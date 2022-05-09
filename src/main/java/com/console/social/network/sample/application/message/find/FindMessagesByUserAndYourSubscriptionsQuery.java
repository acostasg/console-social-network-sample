package com.console.social.network.sample.application.message.find;

public class FindMessagesByUserAndYourSubscriptionsQuery {
    private final String userName;

    public FindMessagesByUserAndYourSubscriptionsQuery(String userName) {
        this.userName = userName;
    }

    public String getUser() {
        return userName;
    }
}
