package ar.com.reservation.app.booking.domain.model.entity;

public abstract class BaseEntity<T> extends Entity<T> {

    private boolean isModified;

    /**
     *
     * @param id
     * @param name
     */
    public BaseEntity(T id, String name) {
        super.id = id;
        super.name = name;
        isModified = false;
    }

    public boolean isModified() {
        return isModified;
    }
}
