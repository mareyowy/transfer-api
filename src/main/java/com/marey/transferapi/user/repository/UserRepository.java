package com.marey.transferapi.user.repository;

import com.marey.transferapi.user.model.User;

public interface UserRepository {

    User getUser(Long userId);
    void addUser(User user);
}
