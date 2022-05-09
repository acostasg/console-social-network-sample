package com.console.social.network.sample.domain.user.expcetion;

public class UserByNameNotFound extends Exception {
    public UserByNameNotFound(String message) {
        super(String.format("User name %s not found", message));
    }
}
