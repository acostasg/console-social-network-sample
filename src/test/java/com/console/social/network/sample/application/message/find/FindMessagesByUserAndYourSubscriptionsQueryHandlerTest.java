package com.console.social.network.sample.application.message.find;

import com.console.social.network.sample.domain.message.model.Message;
import com.console.social.network.sample.domain.message.services.find.MessagesByUserAndYourSubscriptionsFinder;
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
class FindMessagesByUserAndYourSubscriptionsQueryHandlerTest {

    private FindMessagesByUserAndYourSubscriptionsQueryHandler findMessagesByUserAndYourSubscriptionsQueryHandler;

    @Mock
    private UserByNameGetter userByNameGetter;

    @Mock
    private MessagesByUserAndYourSubscriptionsFinder messagesByUserAndYourSubscriptionsFinder;

    @BeforeEach
    protected void setUp() {
        this.findMessagesByUserAndYourSubscriptionsQueryHandler = new FindMessagesByUserAndYourSubscriptionsQueryHandler(
                this.messagesByUserAndYourSubscriptionsFinder,
                this.userByNameGetter
        );
    }

    @Test
    void __call() throws UserByNameNotFound {
        User user = new User("user");
        List<Message> messages = List.of(new Message(user, "message"));

        when(this.userByNameGetter.__call("user")).thenReturn(user);
        when(this.messagesByUserAndYourSubscriptionsFinder.__call(user)).thenReturn(messages);

        FindMessagesByUserAndYourSubscriptionsQuery command = new FindMessagesByUserAndYourSubscriptionsQuery("user");
        List<Message> result = this.findMessagesByUserAndYourSubscriptionsQueryHandler.__call(command);

        assertEquals(messages, result);
    }
}