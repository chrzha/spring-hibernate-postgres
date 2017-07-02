package com.chrzha.dao;

import com.chrzha.exception.NoSuchUserException;
import com.chrzha.entity.User;

import java.util.List;

/**
 * Created by Chris Zhang on 2017/6/24.
 */
public interface UserDao {
    public User getUserById(int userId) throws NoSuchUserException;
    public List<User> getUsers(int pageNo, int pageSize);
    public User addUser(User user);
    public User deleteUserById();
    public User updateUser(User user) throws NoSuchUserException;

}
