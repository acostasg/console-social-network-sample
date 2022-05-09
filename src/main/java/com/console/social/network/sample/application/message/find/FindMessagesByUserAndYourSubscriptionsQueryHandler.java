package com.console.social.network.sample.application.message.find;

import org.springframework.stereotype.Component;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.message.model.Message;
import com.console.social.network.sample.domain.user.service.get.UserByNameGetter;
import com.console.social.network.sample.domain.user.expcetion.UserByNameNotFound;
import com.console.social.network.sample.domain.message.services.find.MessagesByUserAndYourSubscriptionsFinder;

import java.util.List;

@Component
public class FindMessagesByUserAndYourSubscriptionsQueryHandler {

    private final MessagesByUserAndYourSubscriptionsFinder messagesByUserAndYourSubscriptionsFinder;
    private final UserByNameGetter userByNameGetter;

    public FindMessagesByUserAndYourSubscriptionsQueryHandler(
            MessagesByUserAndYourSubscriptionsFinder messagesByUserAndYourSubscriptionsFinder,
            UserByNameGetter userByNameGetter
    ) {
        this.messagesByUserAndYourSubscriptionsFinder = messagesByUserAndYourSubscriptionsFinder;
        this.userByNameGetter = userByNameGetter;
    }

    public List<Message> __call(FindMessagesByUserAndYourSubscriptionsQuery query) throws UserByNameNotFound {
        User user = this.userByNameGetter.__call(query.getUser());
        return this.messagesByUserAndYourSubscriptionsFinder.__call(user);
    }

}
