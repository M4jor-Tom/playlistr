package com.theta.playlistr.knowledge.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IKnowledgeService<T> {

    Iterable<T> findByName(String name) throws JsonProcessingException;
}
