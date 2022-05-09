package com.console.social.network.sample.domain.services.find;

import com.console.social.network.sample.domain.message.model.Message;
import com.console.social.network.sample.domain.message.repository.MessageRepository;
import com.console.social.network.sample.domain.message.services.find.MessagesByUserFinder;
import com.console.social.network.sample.domain.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessagesByUserFinderTest {

    private MessagesByUserFinder messagesByUserFinder;

    @Mock
    private MessageRepository messageRepository;

    @BeforeEach
    protected void setUp() {
        this.messagesByUserFinder = new MessagesByUserFinder(
                this.messageRepository
        );
    }

    @Test
    void __call() {
        User user = new User("user");
        List<Message> messages = List.of(new Message(user, "message"));

        when(this.messageRepository.findByOwner(user)).thenReturn(messages);

        List<Message> result = this.messagesByUserFinder.__call(user);

        assertEquals(messages, result);
    }
}