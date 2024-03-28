package com.theta.playlistr.knowledge.service.impl.musicbrainz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theta.playlistr.domain.Work;
import com.theta.playlistr.knowledge.service.WorkKnowledgeService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkKnowledgeServiceMusicbrainzImpl extends AbstractKnowledgeServiceMusicbrainzImpl implements WorkKnowledgeService {

    @Override
    protected String getMusicBrainzEntityName() {
        return "work";
    }

    @Override
    public Iterable<Work> findByName(String name) throws JsonProcessingException {

        String matchingArtistsString = new RestTemplate().getForObject(this.getQueryString(name), String.class);

        JsonNode matchingArtistsJson = new ObjectMapper().readTree(matchingArtistsString);

        List<Work> result = new ArrayList<Work>();

        for(JsonNode artistNode: matchingArtistsJson.get("works")) {

            String foundName = artistNode
                    .get("title")
                    .asText();

            result.add(new Work().name(foundName));
        }

        return result;
    }
}
