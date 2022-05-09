package com.console.social.network.sample.domain.user.service.get;

import com.console.social.network.sample.domain.user.expcetion.UserByNameNotFound;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserByNameGetterTest {

    private UserByNameGetter userByNameGetter;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    protected void setUp() {
        this.userByNameGetter = new UserByNameGetter(
                this.userRepository
        );
    }

    @Test
    void __call() throws UserByNameNotFound {
        String userName = "user";
        User user = new User(userName);

        when(this.userRepository.findByName(userName)).thenReturn(user);

        User result = this.userByNameGetter.__call(userName);

        assertEquals(user, result);
    }

    @Test
    void __callUserNotFound() throws UserByNameNotFound {
        String userName = "user";

        when(this.userRepository.findByName(userName)).thenReturn(null);

        assertThrows(UserByNameNotFound.class, () -> {
            this.userByNameGetter.__call(userName);
        });

    }
}