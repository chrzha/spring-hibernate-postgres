package com.chrzha.dao.impl;

import com.chrzha.dao.UserDao;
import com.chrzha.entity.User;
import com.chrzha.exception.NoSuchUserException;
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

        String hql= "FROM User where id = ?";
        Query query = getSession().createQuery(hql).setParameter(0, userId);
        User user = (User)query.getSingleResult();
        return user;
    }

    @Override
    public List<User> getUsers(int pageNo, int pageSize) {
        String hql= "FROM User";
        Query query = getSession().createQuery(hql);
        if (pageNo != -1 && pageSize != -1) {
            query.setFirstResult((pageNo - 1) * pageSize);
            query.setMaxResults(pageSize);
        }
        List<User> users = (List<User>)query.getResultList();
        return users;
    }

    @Override
    public User addUser(User user) {
        getSession().save(user);
        return user;
    }

    @Override
    public User deleteUserById() {
        return null;
    }

    @Override
    public User updateUser(User user) throws NoSuchUserException {
        getSession().update(user);
        return user;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
