package com.proglabs.nbaprojectrestapi.controllers;

import com.proglabs.nbaprojectrestapi.models.City;
import com.proglabs.nbaprojectrestapi.repositories.CityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController extends AbstractController<City> {

    public CityController(CityRepository repository) {
        this.repository = repository;
    }
}
