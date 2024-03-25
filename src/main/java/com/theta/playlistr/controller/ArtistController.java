package com.theta.playlistr.controller;

import com.theta.playlistr.domain.Artist;
import com.theta.playlistr.knowledge.service.ArtistKnowledgeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ArtistKnowledgeService artistKnowledgeService;

    public ArtistController(ArtistKnowledgeService artistKnowledgeService) {
        this.artistKnowledgeService = artistKnowledgeService;
    }

    @GetMapping("artist/{artistName}")
    public Artist getArtistByName(@PathVariable("artistName") String artistName) {

        return this.artistKnowledgeService.findByName(artistName);
    }
}
