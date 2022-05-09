package com.console.social.network.sample.infrastucture.user.JPARepository;

import com.console.social.network.sample.infrastucture.user.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CrudUserRepository extends JpaRepository<UserDto, UUID> {
    UserDto findByName(String name);
}
