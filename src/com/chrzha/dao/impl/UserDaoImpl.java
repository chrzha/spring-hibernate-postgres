package com.chrzha.dao.impl;

import com.chrzha.dao.UserDao;
import com.chrzha.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Chris Zhang on 2017/6/24.
 */

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    public User getUserById(int userId) {

        String hql= "SELECT user FROM User user where id = ?";
        Query query = getSession().createQuery(hql).setParameter(0, userId);
        User user = (User)query.getSingleResult();
        return user;
    }

    @Override
    public List<User> getUsers(int start, int end) {
        String hql= "SELECT user FROM User user";
        Query query = getSession().createQuery(hql);
        List<User> users = (List<User>)query.getResultList();
        return users;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
