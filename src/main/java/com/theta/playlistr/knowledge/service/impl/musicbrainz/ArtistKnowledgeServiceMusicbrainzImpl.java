package com.theta.playlistr.knowledge.service.impl.musicbrainz;

import com.theta.playlistr.domain.Artist;
import com.theta.playlistr.knowledge.service.ArtistKnowledgeService;
import org.springframework.stereotype.Service;

@Service
public class ArtistKnowledgeServiceMusicbrainzImpl implements ArtistKnowledgeService {

    @Override
    public Artist findByName(String name) {
        return new Artist().name(name);
    }
}
