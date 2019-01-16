package com.proglabs.nbaprojectrestapi.controllers;

import com.proglabs.nbaprojectrestapi.exceptions.PlayerNotFoundException;
import com.proglabs.nbaprojectrestapi.models.Player;
import com.proglabs.nbaprojectrestapi.repositories.PlayerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private final PlayerRepository repository;

    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/players")
    List<Player> getAll() {
        return repository.findAll();
    }

    @GetMapping("/players/{id}")
    Player get(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @PostMapping("/players")
    Player create(@RequestBody Player newPlayer) {
        return repository.save(newPlayer);
    }


    @PutMapping("/players/{id}")
    Player update(@RequestBody Player newPlayer, @PathVariable Integer id) {

        return repository.findById(id)
                .map(player -> {
                    player.setName(newPlayer.getName());
                    player.setNationality(newPlayer.getNationality());
                    player.setBirthday(newPlayer.getBirthday());
                    player.setTeam(newPlayer.getTeam());
                    player.setPpg(newPlayer.getPpg());
                    player.setApg(newPlayer.getApg());
                    player.setRpg(newPlayer.getRpg());
                    return repository.save(player);
                })
                .orElseGet(() -> {
                    newPlayer.setId(id);
                    return repository.save(newPlayer);
                });
    }

    @DeleteMapping("/players/{id}")
    void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
