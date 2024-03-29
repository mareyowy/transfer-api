package com.marey.transferapi.user.repository;

import com.marey.transferapi.user.model.User;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {

    private Set<User> users = new HashSet<>();

    @PostConstruct
    public void init() {
        User user = User.builder()
                .id(1L)
                .name("Jan Kowalski")
                .address("ul. Prosta 1")
                .build();

        users.add(user);
    }

    @Override
    public User getUser(Long userId) {
        return users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}

