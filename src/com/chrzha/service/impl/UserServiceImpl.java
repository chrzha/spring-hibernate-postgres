package com.chrzha.service.impl;

import com.chrzha.dao.UserDao;
import com.chrzha.entity.User;
import com.chrzha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chris Zhang on 2017/6/24.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(long userId) {

        return userDao.getUserById(userId);
    }
}
