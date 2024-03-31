package com.theta.playlistr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.theta.playlistr.domain.Work;
import com.theta.playlistr.knowledge.service.ArtistKnowledgeService;
import com.theta.playlistr.knowledge.service.WorkKnowledgeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkController {

    private static final int WORKS_SEARCH_LIMIT = 5;

    private WorkKnowledgeService workKnowledgeService;

    private ArtistKnowledgeService artistKnowledgeService;


    public WorkController(WorkKnowledgeService workKnowledgeService, ArtistKnowledgeService artistKnowledgeService) {

        this.workKnowledgeService = workKnowledgeService;
    }

    @GetMapping("work/{workName}")
    public Iterable<Work> getArtistByName(@PathVariable("workName") String workName) {

        try {
            return this.workKnowledgeService.findByName(workName, WORKS_SEARCH_LIMIT);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
