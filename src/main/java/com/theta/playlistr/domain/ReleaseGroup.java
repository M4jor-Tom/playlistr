package com.theta.playlistr.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class ReleaseGroup extends AbstractNamedDomainObject<ReleaseGroup> {

    @Override
    protected ReleaseGroup getThis() {
        return this;
    }
}
