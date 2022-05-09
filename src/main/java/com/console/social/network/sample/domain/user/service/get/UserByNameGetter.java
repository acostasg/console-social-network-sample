package com.console.social.network.sample.domain.user.service.get;

import com.console.social.network.sample.domain.user.expcetion.UserByNameNotFound;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.user.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserByNameGetter {

    private final UserRepository userRepository;

    public UserByNameGetter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User __call(String name) throws UserByNameNotFound {
        User user = this.userRepository.findByName(name);
        if (null == user) {
            throw new UserByNameNotFound(name);
        }
        return user;
    }

}
