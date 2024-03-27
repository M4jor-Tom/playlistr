package com.theta.playlistr.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
abstract public class AbstractNamedDomainObject<T> extends AbstractDomainObject<T> {

    @Column(unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T name(String name) {
        this.setName(name);
        return this.getThis();
    }
}
