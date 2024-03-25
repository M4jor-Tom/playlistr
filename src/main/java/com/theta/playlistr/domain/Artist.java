package com.theta.playlistr.domain;

import jakarta.persistence.Entity;

@Entity
public class Artist extends AbstractNamedDomainObject<Artist> {

    @Override
    public Artist getThis() {
        return this;
    }
}
