package com.console.social.network.sample.domain.user.service.create;

import com.console.social.network.sample.domain.user.expcetion.UserByNameAlreadyExists;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.user.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserCreator {

    private final UserRepository userRepository;

    public UserCreator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User __call(String name) throws UserByNameAlreadyExists {
        User existing = this.userRepository.findByName(name);
        if (null == existing) {
            throw new UserByNameAlreadyExists(name);
        }

        User user = new User(name);
        this.userRepository.persist(user);

        return user;
    }

}
