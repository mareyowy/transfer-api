package com.marey.transferapi.user.repository;

import com.marey.transferapi.user.model.User;

import java.util.HashSet;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {

    private Set<User> users = new HashSet<>();

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

