package com.proglabs.nbaprojectrestapi;

import com.proglabs.nbaprojectrestapi.models.*;

import org.springframework.context.annotation.Configuration;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class Config extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Player.class);
        config.exposeIdsFor(Team.class);
        config.exposeIdsFor(Coach.class);
        config.exposeIdsFor(Arena.class);
        config.exposeIdsFor(City.class);
    }
}