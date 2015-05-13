package com.toyota.tshop.dao;

import com.toyota.tshop.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDAO extends BaseDAO<User> {
    public UserDAO() {
        super(User.class);
    }
}
