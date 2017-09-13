package ar.com.reservation.app.restaurant.domain.repository;

import java.util.Collection;

/**
 *
 * @author jclagoria
 * @param <Restaurant>
 * @param <String>
 */
public interface RestaurantRepository<Restaurant, String> extends Repository<Restaurant, String> {

    /**
     *
     * @param name
     * @return
     */
    boolean containsName(String name);

    public Collection<Restaurant> findByName(String name) throws Exception;

}
