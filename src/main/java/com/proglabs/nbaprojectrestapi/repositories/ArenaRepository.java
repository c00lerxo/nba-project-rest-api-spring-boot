package com.proglabs.nbaprojectrestapi.repositories;

import com.proglabs.nbaprojectrestapi.models.Arena;
import com.proglabs.nbaprojectrestapi.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ArenaRepository extends JpaRepository<Arena, Integer> {

    Arena findArenaByNameEquals(String name);
    Long countArenasByCity(City city);
}
