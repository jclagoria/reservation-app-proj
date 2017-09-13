package ar.com.reservation.app.restaurant.domain.repository;

import ar.com.reservation.app.restaurant.domain.model.entity.Entity;

import java.util.Collection;

/**
 * @author jclagoria
 * @param <TE>
 * @param <T>
 */
public interface ReadOnlyRepository<TE, T> {

    /**
     *
     * @param id
     * @return
     */
    boolean contains(T id);

    /**
     *
     * @param id
     * @return
     */
    Entity get(T id);

    /**
     *
     * @return
     */
    Collection<TE> getAll();
}