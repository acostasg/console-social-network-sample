package com.console.social.network.sample.domain.user.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

public class User {

    private final UUID id;
    private final String name;
    private final List<User> following;
    private final Date createdAt;

    public User(
            String name
    ) {
        this.name = name;
        this.id = UUID.randomUUID();
        this.following = new ArrayList<>();
        this.createdAt = new Date();
    }

    public User(
            String name,
            List<User> following,
            UUID id,
            Date createdAt
    ) {
        this.name = name;
        this.id = id;
        this.following = following;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void addFollowing(User user) {
        this.following.add(user);
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
