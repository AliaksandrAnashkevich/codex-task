package com.codex.service;

import com.codex.entity.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    User getByLogin(String login);

    List<User> getAll();

    boolean update(User user);
}
