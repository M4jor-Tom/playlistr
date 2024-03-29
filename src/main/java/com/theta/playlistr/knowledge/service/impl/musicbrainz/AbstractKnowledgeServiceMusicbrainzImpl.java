package com.theta.playlistr.knowledge.service.impl.musicbrainz;

abstract public class AbstractKnowledgeServiceMusicbrainzImpl {

    private static final String MUSIC_BRAINZ_URI = "https://musicbrainz.org/ws/2/";

    abstract protected String getMusicBrainzEntityName();

    protected String getUri() {
        return MUSIC_BRAINZ_URI + this.getMusicBrainzEntityName();
    }

    protected String getQueryString(String name) {

        return this.getUri() + "?query=" + name + "&fmt=json";
    }

    protected String getRelationStringWith(String otherEntityName, String otherEntityMbid) {

        return MUSIC_BRAINZ_URI + otherEntityName + "?" + this.getMusicBrainzEntityName() + "=" + otherEntityMbid + "&fmt=json";
    }
}
