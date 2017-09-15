package ar.com.reservation.app.booking.domain.repository;

import java.util.Collection;

public interface BookingRepository<Booking, String> extends Repository<Booking, String> {

    boolean containsName(String name);

    public Collection<Booking> findByName(String name) throws Exception;

}
