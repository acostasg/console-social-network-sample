package com.console.social.network.sample.infrastucture.user.dto;

import com.console.social.network.sample.domain.user.model.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
@EnableAutoConfiguration
public class UserDto {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(unique = true)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "following_rel",
            joinColumns = {@JoinColumn(name = "user_id", columnDefinition = "BINARY(16)")},
            inverseJoinColumns = {@JoinColumn(name = "parent_id", columnDefinition = "BINARY(16)")})
    private Set<UserDto> following = new HashSet<UserDto>();

    @Column
    private Date createdAt;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Iterable<UserDto> getFollowing() {
        return following;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void make(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.createdAt = user.getCreatedAt();

        for (User follow : user.getFollowing()) {
            UserDto followDto = new UserDto();
            followDto.make(follow);
            this.following.add(followDto);
        }
    }

    public User to() {

        List<User> following = new ArrayList<User>();

        for (UserDto followDto : this.getFollowing()) {
            following.add(followDto.to());
        }

        return new User(
                this.getName(),
                following,
                this.getId(),
                this.getCreatedAt()
        );
    }

}
