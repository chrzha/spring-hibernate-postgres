package com.chrzha.service.impl;

import com.chrzha.exception.NoSuchUserException;
import com.chrzha.dao.UserDao;
import com.chrzha.entity.User;
import com.chrzha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chris Zhang on 2017/6/24.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(int userId) throws NoSuchUserException {

        return userDao.getUserById(userId);
    }

    public List<User> getUsers(int pageNo, int pageSize) {
        return userDao.getUsers(pageNo, pageSize);
    }

    @Override
    public User addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User deleteUserById() {
        return null;
    }

    @Override
    public User updateUser(User user) throws NoSuchUserException {
        return userDao.updateUser(user);
    }
}
