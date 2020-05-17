package com.tms.service;

import com.tms.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void  createUser(User user);
    User getByUsername(String username);

}
