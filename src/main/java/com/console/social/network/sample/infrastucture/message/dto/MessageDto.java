package com.console.social.network.sample.infrastucture.message.dto;

import com.console.social.network.sample.domain.message.model.Message;
import com.console.social.network.sample.infrastucture.user.dto.UserDto;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "messages")
@EnableAutoConfiguration
public class MessageDto {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", columnDefinition = "BINARY(16)", referencedColumnName = "id", nullable = false)
    private UserDto owner = new UserDto();

    @Column
    private String message;

    @Column
    private Date createdAt;

    public UUID getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public UserDto getOwner() {
        return owner;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void make(Message message) {
        this.id = message.getId();
        this.owner.make(message.getOwner());
        this.message = message.getMessage();
        this.createdAt = message.getCreatedAt();
    }

    public Message to() {
        return new Message(
                this.getOwner().to(),
                this.getMessage(),
                this.getId(),
                this.getCreatedAt()
        );
    }
}
