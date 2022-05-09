package com.console.social.network.sample.application.shared.service.create;

import com.console.social.network.sample.domain.user.expcetion.UserByNameAlreadyExists;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.user.service.create.UserCreator;
import com.console.social.network.sample.domain.user.service.find.UserByNameFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserByNameIfNoExistsCreatorTest {

    private UserByNameIfNoExistsCreator userByNameIfNoExistsCreator;

    @Mock
    private UserByNameFinder userByNameFinder;

    @Mock
    private UserCreator userCreator;

    @BeforeEach
    protected void setUp() {
        this.userByNameIfNoExistsCreator = new UserByNameIfNoExistsCreator(
                this.userByNameFinder,
                this.userCreator
        );
    }

    @Test
    void __call() throws UserByNameAlreadyExists {
        User user = new User("user");

        when(this.userByNameFinder.__call("user")).thenReturn(user);

        User result = this.userByNameIfNoExistsCreator.__call("user");

        assertEquals(user, result);
    }

    @Test
    void __callNotExistUser() throws UserByNameAlreadyExists {
        User user = new User("user");

        when(this.userByNameFinder.__call("user")).thenReturn(null);
        when(this.userCreator.__call("user")).thenReturn(user);

        User result = this.userByNameIfNoExistsCreator.__call("user");

        assertEquals(user, result);
    }
}