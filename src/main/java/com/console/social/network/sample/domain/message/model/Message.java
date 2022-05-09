package com.console.social.network.sample.domain.message.model;

import com.console.social.network.sample.domain.user.model.User;

import java.util.Date;
import java.util.UUID;

public class Message {

    private final UUID id;
    private final User owner;
    private final String message;
    private final Date createdAt;

    public Message(
            User owner,
            String message
    ) {
        this.owner = owner;
        this.message = message;
        this.id = UUID.randomUUID();
        this.createdAt = new Date();
    }

    public Message(
            User owner,
            String message,
            UUID id,
            Date createdAt
    ) {
        this.id = id;
        this.owner = owner;
        this.message = message;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public User getOwner() {
        return owner;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
