package com.proglabs.nbaprojectrestapi.repositories;

import com.proglabs.nbaprojectrestapi.models.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface CoachRepository extends JpaRepository<Coach, Integer> {

    Coach findCoachByNameEquals(String name);

    @Query("SELECT c FROM Coach c WHERE c.championships = (SELECT MAX(c.championships) FROM Coach c)")
    Coach findBestCoachByChampionships();


}
