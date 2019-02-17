package com.proglabs.nbaprojectrestapi.repositories;

import com.proglabs.nbaprojectrestapi.models.City;
import com.proglabs.nbaprojectrestapi.models.Player;
import com.proglabs.nbaprojectrestapi.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface TeamRepository extends JpaRepository<Team, Integer> {
    
    Team findTeamByNameEquals(String name);
    Long countTeamsByCity(City city);

    @Query("SELECT t FROM Team t WHERE t.championships = (SELECT MAX(t.championships) FROM Team t)")
    Team findBestTeamByChampionships();

    List<Team> findTop5ByChampionshipsGreaterThan(int championships);

}
