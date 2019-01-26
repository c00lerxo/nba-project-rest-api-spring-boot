package com.proglabs.nbaprojectrestapi.controllers;

import com.proglabs.nbaprojectrestapi.models.Team;
import com.proglabs.nbaprojectrestapi.repositories.TeamRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeamController extends AbstractController<Team> {

    public TeamController(TeamRepository repository) {
        this.repository = repository;
    }
}
