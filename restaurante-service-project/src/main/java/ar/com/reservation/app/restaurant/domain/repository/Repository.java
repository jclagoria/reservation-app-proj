package ar.com.reservation.app.restaurant.domain.repository;

/**
 *
 * @author jclagoria
 * @param <TE>
 * @param <T>
 */
public interface Repository<TE, T> extends ReadOnlyRepository<TE, T>  {

    /**
     *
     * @param entity
     */
    void add(TE entity);

    /**
     *
     * @param id
     */
    void remove(T id);

    /**
     *
     * @param entity
     */
    void update(TE entity);

}