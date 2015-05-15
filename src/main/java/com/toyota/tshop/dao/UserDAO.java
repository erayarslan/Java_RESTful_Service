package com.toyota.tshop.dao;

import com.toyota.tshop.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDAO extends BaseDAO<User> {
    public UserDAO() {
        super(User.class);
    }

    public User existUser(String username, String password) {
        return (User)entityManager
                .createQuery("SELECT usr FROM User usr Where usr.username = :username and usr.password = :password")
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();
    }
}
