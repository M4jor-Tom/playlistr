package com.theta.playlistr.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class ArtistContributionToWork extends AbstractDomainObject<ArtistContributionToWork> {

    @ManyToOne
    private Artist author;

    @ManyToOne
    private Work work;

    @Override
    protected ArtistContributionToWork getThis() {
        return this;
    }

    public Artist getAuthor() {
        return author;
    }

    public void setAuthor(Artist author) {
        this.author = author;
    }

    public ArtistContributionToWork author(Artist author) {
        this.setAuthor(author);
        return this;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public ArtistContributionToWork work(Work work) {
        this.setWork(work);
        return this;
    }
}
