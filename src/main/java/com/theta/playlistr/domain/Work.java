package com.theta.playlistr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Work extends AbstractNamedDomainObject<Work> {

    @OneToMany
    @JsonIgnoreProperties("work")
    private Set<ArtistContributionToWork> artistContributionToWorks;

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
