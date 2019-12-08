package io.mbab.sda.sdajpa17.repository;

import java.util.List;

public interface CustomCrudRepository<T, ID> {

    List<T> findAll();

    T findById(ID id);

    T create(T obj);

    T update(T obj);

    void deleteById(ID id);
}
