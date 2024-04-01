package com.theta.playlistr.data.service.impl.sql;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

abstract public class AbstractDataServiceImpl<T> {

    private final JpaRepository<T, Long> repository;

    public AbstractDataServiceImpl(JpaRepository<T, Long> repository) {

        this.repository = repository;
    }

    public T save(T entity) {

        return this.repository.save(entity);
    }

    public Iterable<T> saveAll(Iterable<T> entities) {

        return this.repository.saveAll(entities);
    }

    public Iterable<T> findAll() {
        return this.repository.findAll();
    }

    public Optional<T> findById(long id) {

        return this.repository.findById(id);
    }

    public void deleteById(long id) {

        this.repository.deleteById(id);
    }

    protected JpaRepository<T, Long> getRepository() {
        return repository;
    }
}
