package ar.com.reservation.app.restaurant.domain.service;

import ar.com.reservation.app.restaurant.domain.repository.ReadOnlyRepository;
import ar.com.reservation.app.restaurant.domain.repository.Repository;

public abstract class ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> repository;

    ReadOnlyBaseService(Repository<TE, T> repository) {
        this.repository = repository;
    }

}
