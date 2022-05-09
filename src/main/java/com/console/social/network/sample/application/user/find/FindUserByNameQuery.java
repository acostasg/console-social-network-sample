package com.console.social.network.sample.application.user.find;

public class FindUserByNameQuery {

    private final String name;

    public FindUserByNameQuery(
            String name
    ) {

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
