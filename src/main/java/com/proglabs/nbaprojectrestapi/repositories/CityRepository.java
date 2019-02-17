package com.proglabs.nbaprojectrestapi.repositories;

import com.proglabs.nbaprojectrestapi.models.City;
import com.proglabs.nbaprojectrestapi.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface CityRepository extends JpaRepository<City, Integer> {

    City findCityByNameEquals(String name);

}
