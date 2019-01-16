package com.proglabs.nbaprojectrestapi.exceptions;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(Integer id) {
        super("Could not find player with ID " + id);
    }
}
