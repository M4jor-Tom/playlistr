package com.theta.playlistr.knowledge.service.impl.musicbrainz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theta.playlistr.domain.Artist;
import com.theta.playlistr.knowledge.service.ArtistKnowledgeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArtistKnowledgeServiceMusicbrainzImpl implements ArtistKnowledgeService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String URI = "https://musicbrainz.org/ws/2/artist/";

    private String getQueryString(String artistName) {

        return URI + "?query=" + artistName + "&fmt=json";
    }

    @Override
    public Artist findByName(String name) throws JsonProcessingException {

        String matchingArtistsString = new RestTemplate().getForObject(this.getQueryString(name), String.class);

        JsonNode matchingArtistsJson = new ObjectMapper().readTree(matchingArtistsString);
        String foundName = matchingArtistsJson
            .get("artists")
            .get(0)
            .get("name")
            .asText();

        return new Artist().name(foundName);
    }
}
