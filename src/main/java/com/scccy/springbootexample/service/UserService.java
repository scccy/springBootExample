package com.scccy.springbootexample.service;


import com.scccy.springbootexample.domain.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void delete(Integer id);

    void update(User user);

    User getUserById(Integer id);

    List<User> getAll(Integer page, Integer pageSize);
}
