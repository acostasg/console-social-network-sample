package com.console.social.network.sample.application.user.find;

import com.console.social.network.sample.domain.user.expcetion.UserByNameNotFound;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.user.service.get.UserByNameGetter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindUserByNameQueryHandlerTest {

    private FindUserByNameQueryHandler findUserByNameQueryHandler;

    @Mock
    private UserByNameGetter userByNameGetter;

    @BeforeEach
    protected void setUp() {
        this.findUserByNameQueryHandler = new FindUserByNameQueryHandler(
                this.userByNameGetter
        );
    }

    @Test
    void __call() throws UserByNameNotFound {
        User user = new User("user");

        when(this.userByNameGetter.__call("user")).thenReturn(user);

        FindUserByNameQuery command = new FindUserByNameQuery("user");
        User result = this.findUserByNameQueryHandler.__call(command);

        assertEquals(user, result);
    }
}