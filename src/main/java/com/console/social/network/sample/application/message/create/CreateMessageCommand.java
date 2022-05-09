package com.console.social.network.sample.application.message.create;

public class CreateMessageCommand {

    private final String ownerName;
    private final String message;

    public CreateMessageCommand(
            String ownerName,
            String message
    ) {
        super();
        this.ownerName = ownerName;
        this.message = message;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getMessage() {
        return message;
    }
}
