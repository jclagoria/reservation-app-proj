package ar.com.reservation.app.booking.domain.service;

import ar.com.reservation.app.booking.domain.repository.ReadOnlyRepository;
import ar.com.reservation.app.booking.domain.repository.Repository;

/**
 *
 * @param <TE>
 * @param <T>
 */
public abstract class ReadOnlyBaseService<TE,T> {

    private Repository<TE, T> repository;

    ReadOnlyBaseService(Repository<TE,T> repository) {
        this.repository = repository;
    }

}