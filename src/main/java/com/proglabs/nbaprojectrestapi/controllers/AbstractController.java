package com.proglabs.nbaprojectrestapi.controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractController<T extends AbstractModel> {

    protected JpaRepository repository;

    @GetMapping("")
    public List<T> getAll() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public T get(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Resource of given ID does not exist.")); //todo
    }

    @PostMapping("")
    public Object create(@RequestBody T newEntity) {
        return repository.save(newEntity);
    }

    @PutMapping("{id}")
    public T update(@RequestBody T updatedEntity, @PathVariable Integer id) {
        return repository.findById(id)
                .map(entity -> entity.update(updatedEntity, repository))
                .orElseGet(() -> {
                    updatedEntity.setId(id);
                    return repository.save(updatedEntity);
                })
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
