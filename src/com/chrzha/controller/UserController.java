package com.chrzha.controller;

import com.chrzha.NoSuchUserException;
import com.chrzha.entity.User;
import com.chrzha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Chris Zhang on 2017/6/24.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/users/{userId}")
    public User getUserById(@PathVariable int userId) {
        User u = null;
        try {
            u = userService.getUserById(userId);
        } catch (NoSuchUserException nsu) {

        }

        return u;
    }

    @ResponseBody
    @RequestMapping(value = "/users/{start}/{end}")
    public List<User> getUses(@PathVariable int start, @PathVariable int end) {
        List<User> users = userService.getUsers(start, end);
        return users;
    }
}
