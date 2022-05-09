package com.console.social.network.sample.application.message.create;

import org.springframework.stereotype.Component;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.user.expcetion.UserByNameNotFound;
import com.console.social.network.sample.domain.user.service.get.UserByNameGetter;
import com.console.social.network.sample.domain.message.services.create.FollowingCreator;

@Component
public class CreateFollowingCommandHandler {

    private final UserByNameGetter userByNameGetter;
    private final FollowingCreator followingCreator;

    public CreateFollowingCommandHandler(
            UserByNameGetter userByNameGetter,
            FollowingCreator followingCreator
    ) {
        this.userByNameGetter = userByNameGetter;
        this.followingCreator = followingCreator;
    }

    public void __call(CreateFollowingCommand command) throws UserByNameNotFound {
        User userName = userByNameGetter.__call(command.getUserName());
        User followedUserName = userByNameGetter.__call(command.getFollowedUserName());

        this.followingCreator.__call(
                userName,
                followedUserName
        );
    }
}
