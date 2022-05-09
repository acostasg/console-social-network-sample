package com.console.social.network.sample.application.shared.service.create;

import org.springframework.stereotype.Component;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.user.service.create.UserCreator;
import com.console.social.network.sample.domain.user.service.find.UserByNameFinder;
import com.console.social.network.sample.domain.user.expcetion.UserByNameAlreadyExists;

@Component
public class UserByNameIfNoExistsCreator {

    private final UserByNameFinder userByNameFinder;
    private final UserCreator userCreator;

    public UserByNameIfNoExistsCreator(
            UserByNameFinder finder,
            UserCreator creator
    ) {
        this.userByNameFinder = finder;
        this.userCreator = creator;
    }

    public User __call(String name) throws UserByNameAlreadyExists {
        User user = this.userByNameFinder.__call(name);
        if (user == null) {
            user = this.userCreator.__call(name);
        }
        return user;
    }
}
