package com.chrzha.solr;

import com.chrzha.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Chris Zhang on 2017/7/8.
 */
@Controller
@RequestMapping("/solr")
public class SearchController {


    @ResponseBody
    @RequestMapping(value = "/users")
    public List<User> getUsers() {
        List<User> users = null;
        return users;
    }

}
