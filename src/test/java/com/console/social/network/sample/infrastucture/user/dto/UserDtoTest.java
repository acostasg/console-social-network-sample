package com.console.social.network.sample.infrastucture.user.dto;

import com.console.social.network.sample.domain.user.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDtoTest {

    @Test
    void make() {
        User originalUser = new User("test");
        User followingUser = new User("test following");
        originalUser.addFollowing(followingUser);

        UserDto userDto = new UserDto();
        userDto.make(originalUser);

        assertEquals(originalUser.getId(), userDto.getId());
        assertEquals(originalUser.getName(), userDto.getName());
        assertEquals(originalUser.getFollowing().get(0).getName(), originalUser.getFollowing().get(0).getName());
        assertEquals(originalUser.getFollowing().get(0).getId(), originalUser.getFollowing().get(0).getId());
        assertEquals(originalUser.getCreatedAt(), userDto.getCreatedAt());
    }

    @Test
    void to() {
        User originalUser = new User("test");
        User followingUser = new User("test following");
        originalUser.addFollowing(followingUser);

        UserDto userDto = new UserDto();
        userDto.make(originalUser);

        User reverseUser = userDto.to();

        assertEquals(originalUser.getId(), reverseUser.getId());
        assertEquals(originalUser.getName(), reverseUser.getName());
        assertEquals(originalUser.getFollowing().get(0).getName(), reverseUser.getFollowing().get(0).getName());
        assertEquals(originalUser.getFollowing().get(0).getId(), reverseUser.getFollowing().get(0).getId());
        assertEquals(originalUser.getCreatedAt(), reverseUser.getCreatedAt());
    }
}