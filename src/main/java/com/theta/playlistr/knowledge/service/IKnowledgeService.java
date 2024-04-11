package com.theta.playlistr.knowledge.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IKnowledgeService<T> {

    List<T> findByName(String name, int limit) throws JsonProcessingException;
}
