package com.console.social.network.sample.application.message.create;

public class CreateFollowingCommand {

    private final String userName;
    private final String followedUserName;

    public CreateFollowingCommand(
            String userName,
            String followedUserName
    ) {
        super();
        this.userName = userName;
        this.followedUserName = followedUserName;
    }

    public String getUserName() {
        return userName;
    }

    public String getFollowedUserName() {
        return followedUserName;
    }
}
