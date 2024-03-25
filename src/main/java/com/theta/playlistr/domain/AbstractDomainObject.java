package com.theta.playlistr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

@MappedSuperclass
abstract public class AbstractDomainObject<T> {

    @Id
    @GeneratedValue
    private long id;

    @JsonIgnore
    abstract public T getThis();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public T id(long id) {
        this.setId(id);
        return getThis();
    }
}
