package com.console.social.network.sample.view.controller;

import com.console.social.network.sample.application.message.create.CreateMessageCommand;
import com.console.social.network.sample.application.message.create.CreateMessageCommandHandler;
import com.console.social.network.sample.domain.user.expcetion.UserByNameAlreadyExists;
import com.console.social.network.sample.view.view.SuccessView;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PostController {

    private final CreateMessageCommandHandler createMessageCommandHandler;

    public PostController(
            CreateMessageCommandHandler createMessageCommandHandler
    ) {
        this.createMessageCommandHandler = createMessageCommandHandler;
    }

    public void __call(String[] commandWords) throws UserByNameAlreadyExists {
        String userName = commandWords[0];
        CreateMessageCommand createMessageCommand = new CreateMessageCommand(
                userName,
                String.join(" ", Arrays.copyOfRange(commandWords, 2, commandWords.length))
        );
        this.createMessageCommandHandler.__call(createMessageCommand);

        SuccessView.render(
                "Message",
                "posted successfully"
        );

    }
}
