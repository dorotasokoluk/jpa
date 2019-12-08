package io.mbab.sda.sdajpa17.rest;

import io.mbab.sda.sdajpa17.entity.Skill;
import io.mbab.sda.sdajpa17.repository.CustomCrudRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractController<T, ID> {

    private CustomCrudRepository<T, ID> crudRepository;

    public AbstractController(CustomCrudRepository<T, ID> crudRepository) {
        this.crudRepository = crudRepository;
    }

    public AbstractController(EntityManager em, Class<Skill> skillClass) {
    }

    @GetMapping
    List<T> findAll() {
        return crudRepository.findAll();
    }

    @GetMapping("/{id}")
    T findById(@PathVariable ID id) {
        return crudRepository.findById(id);
    }

    @PostMapping
    T create(@RequestBody T obj) {
        return crudRepository.create(obj);
    }

    @PutMapping
    T update(@RequestBody T obj) {
        return crudRepository.update(obj);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable ID id) {
        crudRepository.deleteById(id);
    }
}
