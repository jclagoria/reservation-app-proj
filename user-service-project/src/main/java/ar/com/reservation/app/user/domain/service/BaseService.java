package ar.com.reservation.app.user.domain.service;

import ar.com.reservation.app.user.domain.repository.Repository;

/**
 *
 * @author jclagoria
 * @param <TE>
 * @param <T>
 */
public class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> _repository;

    public BaseService(Repository<TE, T> repository) {
        super(repository);
        _repository = repository;
    }

    public void add(TE entity) throws Exception {
        _repository.add(entity);
    }

}
