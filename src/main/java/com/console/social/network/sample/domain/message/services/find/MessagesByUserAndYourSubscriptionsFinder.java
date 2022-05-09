package com.console.social.network.sample.domain.message.services.find;

import org.springframework.stereotype.Component;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.message.model.Message;
import com.console.social.network.sample.domain.message.repository.MessageRepository;

import java.util.List;

@Component
public class MessagesByUserAndYourSubscriptionsFinder {

    private final MessageRepository messageRepository;

    public MessagesByUserAndYourSubscriptionsFinder(
            MessageRepository messageRepository
    ) {
        this.messageRepository = messageRepository;
    }

    public List<Message> __call(
            User user
    ) {
        return this.messageRepository.findBySubscriptions(user);
    }
}
