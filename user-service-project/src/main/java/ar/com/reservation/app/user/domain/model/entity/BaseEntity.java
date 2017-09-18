package ar.com.reservation.app.user.domain.model.entity;

import ar.com.reservation.app.user.domain.model.entity.Entity;

public abstract class BaseEntity<T> extends Entity<T> {

    private boolean isModified;

    public BaseEntity(T id, String name) {
        super.id = id;
        super.name = name;
        isModified = false;
    }

    public BaseEntity(boolean isModified) {
        this.isModified = isModified;
    }
}
