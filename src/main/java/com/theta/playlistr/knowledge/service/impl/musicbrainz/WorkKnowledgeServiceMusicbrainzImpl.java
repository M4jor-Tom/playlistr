package com.theta.playlistr.knowledge.service.impl.musicbrainz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theta.playlistr.domain.Artist;
import com.theta.playlistr.domain.ArtistContributionToWork;
import com.theta.playlistr.domain.Work;
import com.theta.playlistr.knowledge.service.WorkKnowledgeService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class WorkKnowledgeServiceMusicbrainzImpl extends AbstractKnowledgeServiceMusicbrainzImpl implements WorkKnowledgeService {


    @Override
    protected String getMusicBrainzEntityName() {
        return "work";
    }

    @Override
    public List<Work> findByName(String name, int limit) throws JsonProcessingException {

        String matchingArtistsString = new RestTemplate().getForObject(this.getQueryString(name), String.class);

        JsonNode matchingArtistsJson = new ObjectMapper().readTree(matchingArtistsString);

        List<Work> result = new ArrayList<Work>();

        int index = 0;
        for(JsonNode workNode: matchingArtistsJson.get("works")) {

            if(index++ < limit) {

                String foundName = workNode
                        .get("title")
                        .asText();

                String mbid = workNode
                        .get("id")
                        .asText();

                result.add(new Work()
                        .name(foundName)
                        .artistContributionToWorks(this.findArtistContributionToWorkByWorkMbid(mbid)));
            }
        }

        return result;
    }

    private Set<ArtistContributionToWork> findArtistContributionToWorkByWorkMbid(String workMbid) throws JsonProcessingException {

        String matchingArtistsString = new RestTemplate().getForObject(this.getRelationStringWith("artist", workMbid), String.class);

        JsonNode matchingArtistsJson = new ObjectMapper().readTree(matchingArtistsString);

        Set<ArtistContributionToWork> result = new HashSet<ArtistContributionToWork>();

        for(JsonNode artistNode: matchingArtistsJson.get("artists")) {

            String foundName = artistNode
                    .get("name")
                    .asText();

            result.add(new ArtistContributionToWork().author(new Artist().name(foundName)));
        }

        return result;
    }
}
