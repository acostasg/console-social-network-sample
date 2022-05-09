package com.console.social.network.sample.view.controller;

import com.console.social.network.sample.application.message.create.CreateFollowingCommand;
import com.console.social.network.sample.application.message.create.CreateFollowingCommandHandler;
import com.console.social.network.sample.domain.user.expcetion.UserByNameNotFound;
import com.console.social.network.sample.view.view.SuccessView;
import org.springframework.stereotype.Component;

@Component
public class FollowingController {

    private final CreateFollowingCommandHandler createFollowingCommandHandler;

    public FollowingController(
            CreateFollowingCommandHandler createFollowingCommandHandler
    ) {
        this.createFollowingCommandHandler = createFollowingCommandHandler;
    }

    public void __call(String[] commandWords) throws UserByNameNotFound {
        String userName = commandWords[0];
        String followedUserName = commandWords[2];

        CreateFollowingCommand createFollowingCommand = new CreateFollowingCommand(
                userName,
                followedUserName
        );
        this.createFollowingCommandHandler.__call(createFollowingCommand);

        SuccessView.render(
                "following to",
                followedUserName
        );
    }
}
