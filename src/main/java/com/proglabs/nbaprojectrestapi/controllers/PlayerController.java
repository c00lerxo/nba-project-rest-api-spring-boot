package com.proglabs.nbaprojectrestapi.controllers;

import com.proglabs.nbaprojectrestapi.models.Player;
import com.proglabs.nbaprojectrestapi.repositories.PlayerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController extends AbstractController<Player> {

    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }
}
