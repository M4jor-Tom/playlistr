package com.theta.playlistr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.theta.playlistr.domain.Artist;
import com.theta.playlistr.knowledge.service.ArtistKnowledgeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistController {

    private ArtistKnowledgeService artistKnowledgeService;

    public ArtistController(ArtistKnowledgeService artistKnowledgeService) {
        this.artistKnowledgeService = artistKnowledgeService;
    }

    @GetMapping("artist/{artistName}")
    public Iterable<Artist> getArtistByName(@PathVariable("artistName") String artistName) {

        try {
            return this.artistKnowledgeService.findByName(artistName);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
