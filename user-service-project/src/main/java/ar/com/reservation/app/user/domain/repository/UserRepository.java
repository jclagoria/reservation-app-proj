package ar.com.reservation.app.user.domain.repository;

import java.util.Collection;

/**
 * @author jclagoria
 * @param <Booking>
 * @param <sstring>
 */
public interface UserRepository<Booking, sstring> extends Repository<Booking, String> {

    /**
     *
     * @param name
     * @return
     */
    boolean containsName(String name);

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Booking> findByName(String name) throws Exception;

}
