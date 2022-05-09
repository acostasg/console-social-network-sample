package com.console.social.network.sample.infrastucture.message.JPARepository;

import com.console.social.network.sample.infrastucture.user.dto.UserDto;
import org.springframework.stereotype.Service;
import com.console.social.network.sample.domain.user.model.User;
import com.console.social.network.sample.domain.message.model.Message;
import com.console.social.network.sample.infrastucture.message.dto.MessageDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageRepository implements com.console.social.network.sample.domain.message.repository.MessageRepository {

    private final CrudMessageRepository crudMessageRepository;

    public MessageRepository(
            CrudMessageRepository crudMessageRepository
    ) {
        this.crudMessageRepository = crudMessageRepository;
    }

    @Override
    public List<Message> findByOwner(User owner) {
        UserDto ownerDto = new UserDto();
        ownerDto.make(owner);

        Iterable<MessageDto> messagesDto = this.crudMessageRepository.findAllByOwnerOrderByCreatedAt(ownerDto);

        List<Message> messages = new ArrayList<Message>();
        for (MessageDto messageDto : messagesDto) {
            messages.add(messageDto.to());
        }
        return messages;
    }

    @Override
    public List<Message> findBySubscriptions(User user) {
        UserDto ownerDto = new UserDto();
        ownerDto.make(user);

        List<UserDto> followersDto = new ArrayList<UserDto>();

        for (UserDto following : ownerDto.getFollowing()) {
            followersDto.add(following);
        }

        List<MessageDto> messagesDto = this.crudMessageRepository.findAllByOwnerInAndOwnerOrderByCreatedAt(
                followersDto,
                ownerDto
        );

        List<Message> messages = new ArrayList<Message>();
        for (MessageDto messageDto : messagesDto) {
            messages.add(messageDto.to());
        }
        return messages;
    }

    @Override
    public void persist(Message message) {
        MessageDto messageDto = new MessageDto();
        messageDto.make(message);
        this.crudMessageRepository.saveAndFlush(messageDto);
    }
}
