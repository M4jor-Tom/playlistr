package com.theta.playlistr.knowledge.service.impl.musicbrainz;

abstract public class AbstractKnowledgeServiceMusicbrainzImpl {

    abstract protected String getMusicBrainzEntityName();

    protected String getUri() {
        return "https://musicbrainz.org/ws/2/" + this.getMusicBrainzEntityName();
    }

    protected String getQueryString(String name) {

        return this.getUri() + "?query=" + name + "&fmt=json";
    }
}
