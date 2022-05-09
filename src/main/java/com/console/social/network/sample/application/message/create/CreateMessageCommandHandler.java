package com.console.social.network.sample.application.message.create;

import org.springframework.stereotype.Component;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.message.services.create.MessageCreator;
import com.console.social.network.sample.domain.user.expcetion.UserByNameAlreadyExists;
import com.console.social.network.sample.application.shared.service.create.UserByNameIfNoExistsCreator;

@Component
public class CreateMessageCommandHandler {

    private final UserByNameIfNoExistsCreator userByNameIfNoExistsCreator;
    private final MessageCreator messageCreator;

    public CreateMessageCommandHandler(
            UserByNameIfNoExistsCreator userByNameIfNoExistsCreator,
            MessageCreator messageCreator
    ) {
        this.userByNameIfNoExistsCreator = userByNameIfNoExistsCreator;
        this.messageCreator = messageCreator;
    }

    public void __call(CreateMessageCommand command) throws UserByNameAlreadyExists {
        User owner = userByNameIfNoExistsCreator.__call(command.getOwnerName());
        this.messageCreator.__call(
                owner,
                command.getMessage()
        );
    }
}
