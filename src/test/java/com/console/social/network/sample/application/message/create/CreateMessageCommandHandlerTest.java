package com.console.social.network.sample.application.message.create;

import com.console.social.network.sample.application.shared.service.create.UserByNameIfNoExistsCreator;
import com.console.social.network.sample.domain.message.services.create.MessageCreator;
import com.console.social.network.sample.domain.user.expcetion.UserByNameAlreadyExists;
import com.console.social.network.sample.domain.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateMessageCommandHandlerTest {

    private CreateMessageCommandHandler createMessageCommandHandler;

    @Mock
    private UserByNameIfNoExistsCreator userByNameIfNoExistsCreator;

    @Mock
    private MessageCreator messageCreator;

    @BeforeEach
    protected void setUp() {
        this.createMessageCommandHandler = new CreateMessageCommandHandler(
                this.userByNameIfNoExistsCreator,
                this.messageCreator
        );
    }

    @Test
    void __call() throws UserByNameAlreadyExists {

        User user = new User("user");
        String message = "Hello test World";

        when(this.userByNameIfNoExistsCreator.__call("user")).thenReturn(user);

        CreateMessageCommand command = new CreateMessageCommand("user", message);
        this.createMessageCommandHandler.__call(command);

        verify(this.messageCreator).__call(user, message);
    }
}