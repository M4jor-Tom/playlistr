package com.theta.playlistr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.theta.playlistr.domain.Work;
import com.theta.playlistr.knowledge.service.WorkKnowledgeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkController {

    private WorkKnowledgeService workKnowledgeService;

    public WorkController(WorkKnowledgeService workKnowledgeService) {

        this.workKnowledgeService = workKnowledgeService;
    }

    @GetMapping("work/{workName}")
    public Iterable<Work> getArtistByName(@PathVariable("workName") String workName) {

        try {
            return this.workKnowledgeService.findByName(workName);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
