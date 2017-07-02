package com.chrzha.controller;

import com.chrzha.exception.NoSuchUserException;
import com.chrzha.entity.User;
import com.chrzha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        } catch (Exception nsu) {
            System.out.println(new NoSuchUserException("No such user with id: " + userId));
        }
        return u;
    }

    @ResponseBody
    @RequestMapping(value = "/users/{pageNo}/{pageSize}")
    public List<User> getUsersPagenation(@PathVariable int pageNo, @PathVariable int pageSize) {
        List<User> users = userService.getUsers(pageNo, pageSize);
        return users;
    }

    @ResponseBody
    @RequestMapping(value = "/users")
    public List<User> getUsers() {
        List<User> users = userService.getUsers(-1, -1);
        return users;
    }

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user) {
        try {
            userService.updateUser(user);
        } catch (NoSuchUserException nsu) {
            System.out.println(nsu);
        }
        return user;
    }
}
