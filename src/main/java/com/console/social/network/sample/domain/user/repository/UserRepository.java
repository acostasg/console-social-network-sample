package com.console.social.network.sample.domain.user.repository;

import com.console.social.network.sample.domain.user.model.User;

public interface UserRepository {
    User findByName(String name);

    void persist(User user);
}
