package com.console.social.network.sample.domain.user.service.find;

import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserByNameFinderTest {

    private UserByNameFinder userByNameFinder;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    protected void setUp() {
        this.userByNameFinder = new UserByNameFinder(
                this.userRepository
        );
    }

    @Test
    void __call() {
        String userName = "user";
        User user = new User(userName);

        when(this.userRepository.findByName(userName)).thenReturn(user);

        User result = this.userByNameFinder.__call(userName);

        assertEquals(user, result);
    }
}