package com.tms.service;

import com.tms.dao.IUserDao;
import com.tms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> findAll(){
    return userDao.findAll();
}

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }


}
