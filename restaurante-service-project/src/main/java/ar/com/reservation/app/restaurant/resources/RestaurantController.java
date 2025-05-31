package ar.com.reservation.app.restaurant.resources;

import ar.com.reservation.app.restaurant.domain.model.entity.Entity;
import ar.com.reservation.app.restaurant.domain.model.entity.Restaurant;
import ar.com.reservation.app.restaurant.domain.service.RestaurantService;
import ar.com.reservation.app.restaurant.domain.vaueobject.RestaurantVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/v1/restaurants")
public class RestaurantController {

    protected Logger LOGGER = Logger.getLogger(RestaurantController.class.getName());

    protected RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Autowired
    DiscoveryClient client;

    @RequestMapping("/")
    public List<String> home() {
        return client.getServices();
    }

    /**
     * Fetch restaurants with the specified name. A partial case-insensitive
     * match is supported. So <code>http://.../restaurants/rest</code> will find
     * any restaurants with upper or lower case 'rest' in their name.
     *
     * @param name
     * @return A non-null, non-empty collection of restaurants.
     */
    @HystrixCommand(fallbackMethod = "defaultRestaurants")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Restaurant>> findByName(@RequestParam("name") String name) {
        LOGGER.info(String.format("restaurant-service findByName() invoked:{} for {} ", restaurantService.getClass().getName(), name));
        name = name.trim().toLowerCase();
        Collection<Restaurant> restaurants;
        try {
            restaurants = restaurantService.findByName(name);
        } catch (NoSuchElementException ex) {
            LOGGER.log(Level.WARNING, "No restaurants found for name: " + name, ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Exception raised findByName REST Call", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return restaurants.size() > 0 ? new ResponseEntity<>(restaurants, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Fetch restaurants with the given id.
     * <code>http://.../v1/restaurants/{restaurant_id}</code> will return
     * restaurant with given id.
     *
     * @param id
     * @return A non-null, non-empty collection of restaurants.
     */
    @HystrixCommand(fallbackMethod = "defaultRestaurant")
    @RequestMapping(value = "/{restaurant_id}", method = RequestMethod.GET)
    public ResponseEntity<Entity> findById(@PathVariable("restaurant_id") String id) {
        LOGGER.info(String.format("restaurant-service findById() invoked:{} for {} ", restaurantService.getClass().getName(), id));
        id = id.trim();
        Entity restaurant;
        try {
            restaurant = restaurantService.findById(id);
        } catch (NoSuchElementException ex) {
            LOGGER.log(Level.WARNING, "No restaurant found for id: " + id, ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            LOGGER.log(Level.WARNING, "Exception raised findById REST Call {0}", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return restaurant != null ? new ResponseEntity<>(restaurant, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Add restaurant with the specified information.
     *
     * @param restaurantVO
     * @return A non-null restaurant.
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Restaurant> add(@RequestBody RestaurantVO restaurantVO) {
        LOGGER.info(String.format("restaurant-service add() invoked: %s for %s", restaurantService.getClass().getName(), restaurantVO.getName()));
        System.out.println(restaurantVO);
        Restaurant restaurant = new Restaurant(null, null, null, null);
        BeanUtils.copyProperties(restaurantVO, restaurant);
        try {
            restaurantService.add(restaurant);
        } catch (DataIntegrityViolationException ex) {
            LOGGER.log(Level.WARNING, "Data integrity violation while adding restaurant", ex);
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception ex) {
            LOGGER.log(Level.WARNING, "Exception raised add Restaurant REST Call {0}", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    /**
     * Fallback method
     *
     * @param input
     * @return
     */
    public ResponseEntity<Map<String, String>> defaultRestaurant(String input) {
        LOGGER.warning("Fallback method for restaurant-service is being used. Input: " + input);
        Map<String, String> response = new HashMap<>();
        response.put("error", "Service unavailable. Please try again later.");
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }

    /**
     * Fallback method
     *
     * @param input
     * @return
     */
    public ResponseEntity<Map<String, String>> defaultRestaurants(String input) {
        LOGGER.warning("Fallback method for restaurant-service (plural) is being used. Input: " + input);
        Map<String, String> response = new HashMap<>();
        response.put("error", "Service unavailable. Please try again later.");
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }

}
