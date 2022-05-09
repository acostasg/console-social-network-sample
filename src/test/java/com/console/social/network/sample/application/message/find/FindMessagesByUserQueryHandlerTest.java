package com.console.social.network.sample.application.message.find;

import com.console.social.network.sample.domain.message.model.Message;
import com.console.social.network.sample.domain.message.services.find.MessagesByUserFinder;
import com.console.social.network.sample.domain.user.expcetion.UserByNameNotFound;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.user.service.get.UserByNameGetter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindMessagesByUserQueryHandlerTest {

    private FindMessagesByUserQueryHandler findMessagesByUserQueryHandler;

    @Mock
    private UserByNameGetter userByNameGetter;

    @Mock
    private MessagesByUserFinder messagesByUserFinder;

    @BeforeEach
    protected void setUp() {
        this.findMessagesByUserQueryHandler = new FindMessagesByUserQueryHandler(
                this.messagesByUserFinder,
                this.userByNameGetter
        );
    }

    @Test
    void __call() throws UserByNameNotFound {
        User user = new User("user");
        List<Message> messages = List.of(new Message(user, "message"));

        when(this.userByNameGetter.__call("user")).thenReturn(user);
        when(this.messagesByUserFinder.__call(user)).thenReturn(messages);

        FindMessagesByUserQuery command = new FindMessagesByUserQuery("user");
        List<Message> result = this.findMessagesByUserQueryHandler.__call(command);

        assertEquals(messages, result);
    }
}