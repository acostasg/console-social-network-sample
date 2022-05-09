package com.console.social.network.sample.infrastucture.message.dto;

import com.console.social.network.sample.domain.message.model.Message;
import com.console.social.network.sample.domain.user.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageDtoTest {

    @Test
    void make() {
        User user = new User("test");
        Message original = new Message(user, "test text");

        MessageDto messageDto = new MessageDto();
        messageDto.make(original);

        assertEquals(original.getId(), messageDto.getId());
        assertEquals(original.getMessage(), messageDto.getMessage());
        assertEquals(original.getCreatedAt(), messageDto.getCreatedAt());
        assertEquals(original.getOwner().getName(), messageDto.getOwner().getName());
        assertEquals(original.getOwner().getCreatedAt(), messageDto.getOwner().getCreatedAt());
    }

    @Test
    void to() {
        User user = new User("test");
        Message original = new Message(user, "test text");

        MessageDto messageDto = new MessageDto();
        messageDto.make(original);

        Message revertMessage = messageDto.to();

        assertEquals(original.getId(), revertMessage.getId());
        assertEquals(original.getMessage(), revertMessage.getMessage());
        assertEquals(original.getCreatedAt(), revertMessage.getCreatedAt());
        assertEquals(original.getOwner().getName(), revertMessage.getOwner().getName());
        assertEquals(original.getOwner().getCreatedAt(), revertMessage.getOwner().getCreatedAt());
    }
}