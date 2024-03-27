package com.theta.playlistr.domain;

import jakarta.persistence.Entity;

@Entity
public class Playlist extends AbstractNamedDomainObject<Playlist> {

    @Override
    protected Playlist getThis() {
        return this;
    }
}
