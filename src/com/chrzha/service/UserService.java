package com.chrzha.service;

import com.chrzha.NoSuchUserException;
import com.chrzha.entity.User;

import java.util.List;

/**
 * Created by Chris Zhang on 2017/6/24.
 */
public interface UserService {

    public User getUserById(int userId) throws NoSuchUserException;

    public List<User> getUsers(int start, int end);
}
