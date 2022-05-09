package com.console.social.network.sample.domain.message.repository;

import com.console.social.network.sample.domain.message.model.Message;
import com.console.social.network.sample.domain.user.model.User;

import java.util.List;

public interface MessageRepository {
    List<Message> findByOwner(User user);

    List<Message> findBySubscriptions(User user);

    void persist(Message message);
}
