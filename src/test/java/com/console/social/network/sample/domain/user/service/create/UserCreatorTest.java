package com.console.social.network.sample.domain.user.service.create;

import com.console.social.network.sample.domain.user.expcetion.UserByNameAlreadyExists;
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
class UserCreatorTest {

    private UserCreator userCreator;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    protected void setUp() {
        this.userCreator = new UserCreator(
                this.userRepository
        );
    }

    @Test
    void __call() throws UserByNameAlreadyExists {
        String username = "username";
        User user = new User(username);

        when(this.userRepository.findByName(username)).thenReturn(user);

        User result = this.userCreator.__call(username);

        assertEquals(user.getName(), result.getName());
    }

    @Test
    void __callAlreadyExists() {
        String username = "username";

        when(this.userRepository.findByName(username)).thenReturn(null);

        assertThrows(UserByNameAlreadyExists.class, () -> {
            this.userCreator.__call(username);
        });
    }
}