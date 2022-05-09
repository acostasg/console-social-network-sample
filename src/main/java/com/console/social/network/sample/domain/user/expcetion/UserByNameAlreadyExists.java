package com.console.social.network.sample.domain.user.expcetion;

public class UserByNameAlreadyExists extends Exception {
    public UserByNameAlreadyExists(String message) {
        super(String.format("User name %s already exists", message));
    }
}
