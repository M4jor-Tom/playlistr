package com.theta.playlistr.domain;

import jakarta.persistence.Entity;

@Entity
public class Playlist extends AbstractNamedDomainObject<Playlist> {

    @Override
    public Playlist getThis() {
        return this;
    }
}
