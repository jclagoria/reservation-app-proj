package ar.com.reservation.app.booking.domain.service;

import ar.com.reservation.app.booking.domain.repository.ReadOnlyRepository;
import ar.com.reservation.app.booking.domain.repository.Repository;

import java.util.Collection;

public class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> _repository;

    BaseService(Repository<TE, T> repository) {
        super(repository);
        _repository = repository;
    }

    /**
     *
     * @throws Exception
     */
    public void add(TE entity) throws Exception {
       _repository.add(entity);
    }

    /**
     *
     * @return
     */
    public Collection<TE> getAll() {
        return _repository.getAll();
    }
}
