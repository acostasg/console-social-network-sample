package com.console.social.network.sample.application.message.find;

import org.springframework.stereotype.Component;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.message.model.Message;
import com.console.social.network.sample.domain.user.expcetion.UserByNameNotFound;
import com.console.social.network.sample.domain.user.service.get.UserByNameGetter;
import com.console.social.network.sample.domain.message.services.find.MessagesByUserFinder;

import java.util.List;

@Component
public class FindMessagesByUserQueryHandler {

    private final MessagesByUserFinder messagesByUserFinder;
    private final UserByNameGetter userByNameGetter;

    public FindMessagesByUserQueryHandler(
            MessagesByUserFinder messagesByUserFinder,
            UserByNameGetter userByNameGetter
    ) {
        this.messagesByUserFinder = messagesByUserFinder;
        this.userByNameGetter = userByNameGetter;
    }

    public List<Message> __call(FindMessagesByUserQuery query) throws UserByNameNotFound {
        User user = this.userByNameGetter.__call(query.getUser());
        return this.messagesByUserFinder.__call(user);
    }

}
