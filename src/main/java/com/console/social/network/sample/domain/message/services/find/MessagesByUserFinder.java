package com.console.social.network.sample.domain.message.services.find;

import com.console.social.network.sample.domain.message.model.Message;
import com.console.social.network.sample.domain.message.repository.MessageRepository;
import org.springframework.stereotype.Component;
import com.console.social.network.sample.domain.user.model.User;

import java.util.List;

@Component
public class MessagesByUserFinder {

    private final MessageRepository messageRepository;

    public MessagesByUserFinder(
            MessageRepository messageRepository
    ) {
        this.messageRepository = messageRepository;
    }

    public List<Message> __call(
            User user
    ) {
        return this.messageRepository.findByOwner(user);
    }
}
