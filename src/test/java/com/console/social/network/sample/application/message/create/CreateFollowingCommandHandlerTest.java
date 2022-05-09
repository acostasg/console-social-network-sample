package com.console.social.network.sample.application.message.create;

import com.console.social.network.sample.domain.message.services.create.FollowingCreator;
import com.console.social.network.sample.domain.user.expcetion.UserByNameNotFound;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.user.service.get.UserByNameGetter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateFollowingCommandHandlerTest {

    private CreateFollowingCommandHandler createFollowingCommandHandler;

    @Mock
    private UserByNameGetter userByNameGetter;

    @Mock
    private FollowingCreator followingCreator;

    @BeforeEach
    protected void setUp() {
        this.createFollowingCommandHandler = new CreateFollowingCommandHandler(
                this.userByNameGetter,
                this.followingCreator
        );
    }

    @Test
    void __call() throws UserByNameNotFound {

        User user = new User("user");
        User following = new User("following");

        when(this.userByNameGetter.__call("user")).thenReturn(user);
        when(this.userByNameGetter.__call("following")).thenReturn(following);

        CreateFollowingCommand command = new CreateFollowingCommand("user", "following");
        this.createFollowingCommandHandler.__call(command);

        verify(this.followingCreator).__call(user, following);
    }
}