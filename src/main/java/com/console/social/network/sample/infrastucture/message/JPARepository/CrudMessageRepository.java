package com.console.social.network.sample.infrastucture.message.JPARepository;

import com.console.social.network.sample.infrastucture.message.dto.MessageDto;
import com.console.social.network.sample.infrastucture.user.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CrudMessageRepository extends JpaRepository<MessageDto, UUID> {
    List<MessageDto> findAllByOwnerOrderByCreatedAt(UserDto owner);

    List<MessageDto> findAllByOwnerInAndOwnerOrderByCreatedAt(List<UserDto> owners, UserDto owner);
}
