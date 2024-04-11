package com.theta.playlistr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@NamedEntityGraph(name = "Playlist.works",
        attributeNodes = @NamedAttributeNode("works"))
public class Playlist extends AbstractNamedDomainObject<Playlist> {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("artistContributionToWorks")
    private Set<Work> works;

    @OneToMany
    @JsonIgnore
    private Set<ReleaseGroup> releaseGroups;

    @OneToMany
    @JsonIgnore
    private Set<Artist> artists;

    @OneToMany
    @JsonIgnore
    private Set<Playlist> playlists;

    public Playlist() {
        this.works = new HashSet<Work>();
        this.releaseGroups = new HashSet<ReleaseGroup>();
        this.artists = new HashSet<Artist>();
        this.playlists = new HashSet<Playlist>();
    }

    @Override
    protected Playlist getThis() {
        return this;
    }

    public Set<Work> getWorks() {
        return works;
    }

    public void setWorks(Set<Work> works) {
        this.works = works;
    }

    public void addWork(Work work) {

        this.works.add(work);
        this.setWorks(this.works);
    }

    public Set<ReleaseGroup> getReleaseGroups() {
        return releaseGroups;
    }

    public void setReleaseGroups(Set<ReleaseGroup> releaseGroups) {
        this.releaseGroups = releaseGroups;
    }

    public void addReleaseGroup(ReleaseGroup releaseGroup) {

        this.releaseGroups.add(releaseGroup);
        this.setReleaseGroups(this.releaseGroups);
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }

    public void addPlaylist(Playlist playlist) {

        this.playlists.add(playlist);
        this.setPlaylists(this.playlists);
    }
}
