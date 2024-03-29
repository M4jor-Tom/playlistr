package com.theta.playlistr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.Set;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Artist extends AbstractNamedDomainObject<Artist> {

    @OneToMany
    @JsonIgnoreProperties("author")
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
