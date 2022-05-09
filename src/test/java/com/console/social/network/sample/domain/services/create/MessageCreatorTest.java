package com.console.social.network.sample.domain.services.create;

import com.console.social.network.sample.domain.message.model.Message;
import com.console.social.network.sample.domain.message.repository.MessageRepository;
import com.console.social.network.sample.domain.message.services.create.MessageCreator;
import com.console.social.network.sample.domain.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MessageCreatorTest {

    private MessageCreator messageCreator;

    @Mock
    private MessageRepository messageRepository;

    @BeforeEach
    protected void setUp() {
        this.messageCreator = new MessageCreator(
                this.messageRepository
        );
    }

    @Test
    void __call() {
        User owner = new User("user");
        String messageText = "message";

        Message message = this.messageCreator.__call(owner, messageText);

        assertEquals(messageText, message.getMessage());
        assertEquals(owner, message.getOwner());
    }
}