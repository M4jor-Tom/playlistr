package com.theta.playlistr.data.service;

import java.util.Optional;

public interface IDataService<T> {

    public T save(T entity);

    public Iterable<T> saveAll(Iterable<T> entities);

    public Iterable<T> findAll();
    public Optional<T> findById(long id);

    public void deleteById(long id);
}
