package com.theta.playlistr.knowledge.service;

import com.theta.playlistr.domain.Artist;

public interface ArtistKnowledgeService {

    Artist findByName(String name);
}
