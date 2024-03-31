package com.theta.playlistr.knowledge.service.impl.musicbrainz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theta.playlistr.domain.Artist;
import com.theta.playlistr.domain.ArtistContributionToWork;
import com.theta.playlistr.domain.Work;
import com.theta.playlistr.knowledge.service.ArtistKnowledgeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ArtistKnowledgeServiceMusicbrainzImpl extends AbstractKnowledgeServiceMusicbrainzImpl implements ArtistKnowledgeService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected String getMusicBrainzEntityName() {
        return "artist";
    }

    @Override
    public Iterable<Artist> findByName(String name, int limit) throws JsonProcessingException {

        String matchingArtistsString = new RestTemplate().getForObject(this.getQueryString(name), String.class);

        JsonNode matchingArtistsJson = new ObjectMapper().readTree(matchingArtistsString);

        List<Artist> result = new ArrayList<Artist>();

        int index = 0;
        for(JsonNode artistNode: matchingArtistsJson.get("artists")) {

            if(index++ < limit) {

                String foundName = artistNode
                        .get("name")
                        .asText();

                String mbid = artistNode
                        .get("id")
                        .asText();

                result.add(new Artist()
                        .name(foundName)
                        .artistContributionToWorks(this.findArtistContributionToWorkByArtistMbid(mbid)));
            }
        }

        return result;
    }

    private Set<ArtistContributionToWork> findArtistContributionToWorkByArtistMbid(String artistMbid) throws JsonProcessingException {

        String matchingArtistsString = new RestTemplate().getForObject(this.getRelationStringWith("work", artistMbid), String.class);

        JsonNode matchingArtistsJson = new ObjectMapper().readTree(matchingArtistsString);

        Set<ArtistContributionToWork> result = new HashSet<ArtistContributionToWork>();

        for(JsonNode artistNode: matchingArtistsJson.get("works")) {

            String foundName = artistNode
                    .get("title")
                    .asText();

            result.add(new ArtistContributionToWork().work(new Work().name(foundName)));
        }

        return result;
    }
}
