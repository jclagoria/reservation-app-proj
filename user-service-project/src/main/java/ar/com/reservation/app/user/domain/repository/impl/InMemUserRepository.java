package ar.com.reservation.app.user.domain.repository.impl;

import ar.com.reservation.app.user.domain.model.entity.Entity;
import ar.com.reservation.app.user.domain.model.entity.User;
import ar.com.reservation.app.user.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository("userRepository")
public class InMemUserRepository implements UserRepository<User, String> {

    private Map<String, User> entities;

    /**
     * Initialize the in-memory Restaurant Repository with empty Map
     */
    public InMemUserRepository() {
        entities = new HashMap<>();
        User user = new User("1", "User Name 1", "Address 1", "City 1", "9999911111");
        entities.put("1", user);
        User user2 = new User("1", "User Name 2", "Address 2", "City 2", "9999922222");
        entities.put("2", user2);
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public boolean containsName(String name) {

        try {
            return this.findByName(name).size() > 0;
        } catch (Exception ex) {

        }

       return false;
    }

    @Override
    public Collection<User> findByName(String name) throws Exception {

        Collection<User> users = new ArrayList<>();
        int noOfChars = name.length();

        entities.forEach((k, v) -> {
            if(v.getName().toLowerCase()
                    .contains(name.toLowerCase().subSequence(0, noOfChars))) {
                users.add(v);
            }
        });

        return users;
    }

    @Override
    public void add(User entity) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public boolean contains(String id) {
        return false;
    }

    @Override
    public Entity get(String id) {
        return null;
    }

    @Override
    public Collection<User> getAll() {
        return null;
    }
}
