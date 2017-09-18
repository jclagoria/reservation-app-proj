package ar.com.reservation.app.user.domain.repository;

import ar.com.reservation.app.user.domain.model.entity.Entity;

import java.util.Collection;

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
