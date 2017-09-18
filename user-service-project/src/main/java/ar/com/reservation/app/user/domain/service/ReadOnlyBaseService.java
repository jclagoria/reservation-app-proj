package ar.com.reservation.app.user.domain.service;

import ar.com.reservation.app.user.domain.repository.ReadOnlyRepository;
import ar.com.reservation.app.user.domain.repository.Repository;

/**
 *
 * @author jclagoria
 * @param <TE>
 * @param <T>
 */
public abstract class ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> repository;

    public ReadOnlyBaseService(Repository<TE, T> repository) {
        this.repository = repository;
    }

}
