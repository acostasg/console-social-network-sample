package com.console.social.network.sample.domain.message.services.create;

import org.springframework.stereotype.Component;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.message.model.Message;
import com.console.social.network.sample.domain.message.repository.MessageRepository;

@Component
public class MessageCreator {
    private final MessageRepository messageRepository;

    public MessageCreator(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message __call(
            User owner,
            String messageText
    ) {
        Message message = new Message(
                owner,
                messageText
        );
        this.messageRepository.persist(message);

        return message;
    }
}
