package com.console.social.network.sample.view.controller;

import com.console.social.network.sample.application.message.find.FindMessagesByUserQuery;
import org.springframework.stereotype.Component;
import com.console.social.network.sample.view.view.SuccessView;
import com.console.social.network.sample.view.view.MessagesView;
import com.console.social.network.sample.domain.user.expcetion.UserByNameNotFound;
import com.console.social.network.sample.application.message.find.FindMessagesByUserQueryHandler;

@Component
public class ReaderController {

    private final FindMessagesByUserQueryHandler findMessagesByUserQueryHandler;

    public ReaderController(
            FindMessagesByUserQueryHandler findMessagesByUserQueryHandler
    ) {
        this.findMessagesByUserQueryHandler = findMessagesByUserQueryHandler;
    }

    public void __call(String[] commandWords) throws UserByNameNotFound {
        String userName = commandWords[0];
        FindMessagesByUserQuery query = new FindMessagesByUserQuery(userName);

        SuccessView.render(userName, "wall");
        SuccessView.render(userName, "messages");
        MessagesView.render(this.findMessagesByUserQueryHandler.__call(query));
    }
}
