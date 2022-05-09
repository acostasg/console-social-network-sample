package com.console.social.network.sample.domain.user.service.find;

import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.user.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserByNameFinder {

    private final UserRepository userRepository;

    public UserByNameFinder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User __call(String name) {
        return this.userRepository.findByName(name);
    }

}
