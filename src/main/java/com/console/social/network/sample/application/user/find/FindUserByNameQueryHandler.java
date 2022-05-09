package com.console.social.network.sample.application.user.find;

import org.springframework.stereotype.Component;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.user.expcetion.UserByNameNotFound;
import com.console.social.network.sample.domain.user.service.get.UserByNameGetter;

@Component
public class FindUserByNameQueryHandler {
    private final UserByNameGetter userByNameGetter;

    public FindUserByNameQueryHandler(
            UserByNameGetter userByNameFinder
    ) {
        this.userByNameGetter = userByNameFinder;
    }

    public User __call(FindUserByNameQuery query) throws UserByNameNotFound {
        return this.userByNameGetter.__call(query.getName());
    }
}
