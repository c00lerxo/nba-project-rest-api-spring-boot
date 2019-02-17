package com.proglabs.nbaprojectrestapi.repositories;

import com.proglabs.nbaprojectrestapi.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query("SELECT p FROM Player p WHERE p.ppg = (SELECT MAX(p.ppg) FROM Player p)")
    Player findBestByPpg();

    List<Player> findTop5ByPpgGreaterThan(float ppg);
    //List<Player> findTop5ByRpg();
   // List<Player> findTop5ByApg();
}