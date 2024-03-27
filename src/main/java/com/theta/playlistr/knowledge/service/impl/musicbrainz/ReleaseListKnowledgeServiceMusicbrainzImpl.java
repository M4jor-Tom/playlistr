package com.theta.playlistr.knowledge.service.impl.musicbrainz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theta.playlistr.domain.Artist;
import com.theta.playlistr.domain.ReleaseList;
import com.theta.playlistr.knowledge.service.ArtistKnowledgeService;
import com.theta.playlistr.knowledge.service.ReleaseListKnowledgeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReleaseListKnowledgeServiceMusicbrainzImpl extends AbstractKnowledgeServiceMusicbrainzImpl implements ReleaseListKnowledgeService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected String getMusicBrainzEntityName() {
        return "release-group";
    }

    @Override
    public Iterable<ReleaseList> findByName(String name) throws JsonProcessingException {

        String matchingArtistsString = new RestTemplate().getForObject(this.getQueryString(name), String.class);

        JsonNode matchingArtistsJson = new ObjectMapper().readTree(matchingArtistsString);

        List<ReleaseList> result = new ArrayList<ReleaseList>();

        for(JsonNode artistNode: matchingArtistsJson.get("release-groups")) {

            String foundName = artistNode
                .get("name")
                .asText();

            result.add(new ReleaseList().name(foundName));
        }

        return result;
    }
}
