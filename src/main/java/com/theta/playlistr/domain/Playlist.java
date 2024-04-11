package com.theta.playlistr.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.Set;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Playlist extends AbstractNamedDomainObject<Playlist> {

    @OneToMany
    private Set<Work> works;

    @OneToMany
    private Set<ReleaseGroup> releaseGroups;

    @OneToMany
    private Set<Artist> artists;

    @OneToMany
    private Set<Playlist> playlists;

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
