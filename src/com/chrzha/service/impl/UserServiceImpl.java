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

    public List<User> getUsers(int start, int end) {
        return userDao.getUsers(start, end);
    }
}
