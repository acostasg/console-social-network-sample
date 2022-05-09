package com.console.social.network.sample.application.message.find;

public class FindMessagesByUserQuery {
    private final String userName;

    public FindMessagesByUserQuery(String userName) {
        this.userName = userName;
    }

    public String getUser() {
        return userName;
    }
}
