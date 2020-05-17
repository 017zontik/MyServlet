package com.tms.dao;

import com.tms.model.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
    void  createUser(User user);
    User getByUsername(String username);
}
