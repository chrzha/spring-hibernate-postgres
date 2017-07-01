package com.chrzha.test;

import com.chrzha.entity.User;
import com.chrzha.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import javax.sql.DataSource;

/**
 * Created by Chris Zhang on 2017/6/24.
 */
public class UserDaoImplTest {
    private ApplicationContext context=null;
    private UserService userService = null;

    {
        context= new ClassPathXmlApplicationContext("webapp/WEB-INF/web.xml");
        userService=context.getBean(UserService.class);
    }
    @Test
    public void test()
    {
        DataSource dataSource=(DataSource) context.getBean(DataSource.class);
        System.out.println(dataSource);
    }
    @Test
    public void test2() throws Exception
    {
        User user = userService.getUserById(1);
        System.out.println(user);
    }
}