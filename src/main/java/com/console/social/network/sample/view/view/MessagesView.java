package com.console.social.network.sample.view.view;

import com.console.social.network.sample.domain.message.model.Message;

import java.util.List;

public class MessagesView {
    public static void render(List<Message> messageList) {
        for (Message message : messageList) {
            System.out.printf("> %s \n", message.getOwner().getName());
            System.out.printf("%s %s\n", message.getMessage(), message.getCreatedAt().toString());
        }
    }
}
