package com.theta.playlistr.knowledge.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.theta.playlistr.domain.Artist;

public interface ArtistKnowledgeService {

    Iterable<Artist> findByName(String name) throws JsonProcessingException;
}
