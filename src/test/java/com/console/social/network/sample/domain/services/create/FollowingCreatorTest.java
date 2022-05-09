package com.console.social.network.sample.domain.services.create;

import com.console.social.network.sample.domain.message.services.create.FollowingCreator;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FollowingCreatorTest {

    private FollowingCreator followingCreator;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    protected void setUp() {
        this.followingCreator = new FollowingCreator(
                this.userRepository
        );
    }

    @Test
    void __call() {
        User user = new User("user");
        User followedUser = new User("user");

        this.followingCreator.__call(user, followedUser);

        verify(this.userRepository).persist(user);
    }
}