package com.console.social.network.sample.infrastucture.user.JPARepository;

import com.console.social.network.sample.infrastucture.user.dto.UserDto;
import org.springframework.stereotype.Service;
import com.console.social.network.sample.domain.user.model.User;

@Service
public class UserRepository implements com.console.social.network.sample.domain.user.repository.UserRepository {

    private final CrudUserRepository crudUserRepository;

    public UserRepository(
            CrudUserRepository crudUserRepository
    ) {
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    public User findByName(String name) {
        UserDto userDto = this.crudUserRepository.findByName(name);
        if (null != userDto) {
            return userDto.to();
        }
        return null;
    }

    @Override
    public void persist(User user) {
        UserDto userDto = new UserDto();
        userDto.make(user);
        this.crudUserRepository.saveAndFlush(userDto);
    }
}
