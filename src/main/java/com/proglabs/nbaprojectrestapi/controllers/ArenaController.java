package com.proglabs.nbaprojectrestapi.controllers;

import com.proglabs.nbaprojectrestapi.models.Arena;
import com.proglabs.nbaprojectrestapi.repositories.ArenaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArenaController extends AbstractController<Arena> {

    public ArenaController(ArenaRepository repository) {
        this.repository = repository;
    }
}
