package com.theta.playlistr.knowledge.service.impl.musicbrainz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theta.playlistr.domain.Artist;
import com.theta.playlistr.domain.ReleaseGroup;
import com.theta.playlistr.knowledge.service.ArtistKnowledgeService;
import com.theta.playlistr.knowledge.service.ReleaseGroupKnowledgeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReleaseListKnowledgeServiceMusicbrainzImpl extends AbstractKnowledgeServiceMusicbrainzImpl implements ReleaseGroupKnowledgeService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected String getMusicBrainzEntityName() {
        return "release-group";
    }

    @Override
    public Iterable<ReleaseGroup> findByName(String name) throws JsonProcessingException {

        String matchingArtistsString = new RestTemplate().getForObject(this.getQueryString(name), String.class);

        JsonNode matchingArtistsJson = new ObjectMapper().readTree(matchingArtistsString);

        List<ReleaseGroup> result = new ArrayList<ReleaseGroup>();

        for(JsonNode artistNode: matchingArtistsJson.get("release-groups")) {

            String foundName = artistNode
                .get("name")
                .asText();

            result.add(new ReleaseGroup().name(foundName));
        }

        return result;
    }
}
