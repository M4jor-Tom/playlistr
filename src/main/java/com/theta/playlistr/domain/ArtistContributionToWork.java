package com.theta.playlistr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"author_id", "work_id"}))
public class ArtistContributionToWork extends AbstractDomainObject<ArtistContributionToWork> {

    @ManyToOne
    @JsonIgnoreProperties("artistContributionToWorks")
    private Artist author;

    @ManyToOne
    @JsonIgnoreProperties("artistContributionToWorks")
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
