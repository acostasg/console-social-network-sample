package com.console.social.network.sample.view.controller;

import com.console.social.network.sample.application.message.find.FindMessagesByUserAndYourSubscriptionsQuery;
import com.console.social.network.sample.application.message.find.FindMessagesByUserAndYourSubscriptionsQueryHandler;
import org.springframework.stereotype.Component;
import com.console.social.network.sample.view.view.SuccessView;
import com.console.social.network.sample.view.view.MessagesView;
import com.console.social.network.sample.domain.user.expcetion.UserByNameNotFound;

@Component
public class WallController {
    private final FindMessagesByUserAndYourSubscriptionsQueryHandler findMessagesByUserAndYourSubscriptionsQueryHandler;

    public WallController(
            FindMessagesByUserAndYourSubscriptionsQueryHandler findMessagesByUserAndYourSubscriptionsQueryHandler
    ) {
        this.findMessagesByUserAndYourSubscriptionsQueryHandler = findMessagesByUserAndYourSubscriptionsQueryHandler;
    }

    public void __call(String[] commandWords) throws UserByNameNotFound {
        String userName = commandWords[0];
        FindMessagesByUserAndYourSubscriptionsQuery query = new FindMessagesByUserAndYourSubscriptionsQuery(userName);

        SuccessView.render(userName, "wall");
        MessagesView.render(this.findMessagesByUserAndYourSubscriptionsQueryHandler.__call(query));

    }
}
