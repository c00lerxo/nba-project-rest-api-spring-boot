package com.proglabs.nbaprojectrestapi.controllers;

import com.proglabs.nbaprojectrestapi.models.Coach;
import com.proglabs.nbaprojectrestapi.repositories.CoachRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoachController extends AbstractController<Coach> {

    public CoachController(CoachRepository repository) {
        this.repository = repository;
    }
}
