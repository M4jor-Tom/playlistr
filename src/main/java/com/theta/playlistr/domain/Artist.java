package com.theta.playlistr.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Artist extends AbstractNamedDomainObject<Artist> {

    @OneToMany
    private Set<ArtistContributionToWork> artistContributionToWorks;


    @Override
    protected Artist getThis() {
        return this;
    }


    public Set<ArtistContributionToWork> getArtistContributionToWorks() {
        return artistContributionToWorks;
    }

    public void setArtistContributionToWorks(Set<ArtistContributionToWork> artistContributionToWorks) {
        this.artistContributionToWorks = artistContributionToWorks;
    }

    public Artist artistContributionToWorks(Set<ArtistContributionToWork> artistContributionToWorks) {
        this.setArtistContributionToWorks(artistContributionToWorks);
        return this;
    }
}
