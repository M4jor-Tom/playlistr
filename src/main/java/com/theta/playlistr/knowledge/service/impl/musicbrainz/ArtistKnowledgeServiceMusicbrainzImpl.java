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

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistKnowledgeServiceMusicbrainzImpl implements ArtistKnowledgeService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String URI = "https://musicbrainz.org/ws/2/artist/";

    private String getQueryString(String artistName) {

        return URI + "?query=" + artistName + "&fmt=json";
    }

    @Override
    public Iterable<Artist> findByName(String name) throws JsonProcessingException {

        String matchingArtistsString = new RestTemplate().getForObject(this.getQueryString(name), String.class);

        JsonNode matchingArtistsJson = new ObjectMapper().readTree(matchingArtistsString);

        List<Artist> result = new ArrayList<Artist>();

        for(JsonNode artistNode: matchingArtistsJson.get("artists")) {

            String foundName = artistNode
                .get("name")
                .asText();

            result.add(new Artist().name(foundName));
        }

        return result;
    }
}
