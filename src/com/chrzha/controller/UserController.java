package com.chrzha.controller;

import com.chrzha.entity.User;
import com.chrzha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Chris Zhang on 2017/6/24.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{userId}")
    public @ResponseBody User getUserById(@PathVariable long userId) {
        User u = userService.getUserById(userId);
        return u;
    }
}
