package com.console.social.network.sample.domain.message.services.create;

import org.springframework.stereotype.Component;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.user.repository.UserRepository;

@Component
public class FollowingCreator {

    private final UserRepository userRepository;

    public FollowingCreator(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    public void __call(
            User user,
            User followedUser
    ) {
        user.addFollowing(followedUser);
        this.userRepository.persist(user);
    }
}
