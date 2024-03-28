package com.theta.playlistr.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Playlist extends AbstractNamedDomainObject<Playlist> {

    @Override
    protected Playlist getThis() {
        return this;
    }
}
