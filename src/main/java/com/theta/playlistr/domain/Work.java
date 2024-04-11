package com.theta.playlistr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Work extends AbstractNamedDomainObject<Work> {

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("work")
    private Set<ArtistContributionToWork> artistContributionToWorks;

    public Work() {
        this.artistContributionToWorks = new HashSet<ArtistContributionToWork>();
    }

    @Override
    protected Work getThis() {
        return this;
    }

    public Set<ArtistContributionToWork> getArtistContributionToWorks() {
        return artistContributionToWorks;
    }

    public void setArtistContributionToWorks(Set<ArtistContributionToWork> artistContributionToWorks) {
        this.artistContributionToWorks = artistContributionToWorks;
    }

    public Work artistContributionToWorks(Set<ArtistContributionToWork> artistContributionToWorks) {
        this.setArtistContributionToWorks(artistContributionToWorks);
        return this;
    }
}
