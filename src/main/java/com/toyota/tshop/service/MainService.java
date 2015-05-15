package com.toyota.tshop.service;

import com.toyota.tshop.dao.TokenDAO;
import com.toyota.tshop.dao.UserDAO;
import com.toyota.tshop.entity.Token;
import com.toyota.tshop.entity.User;
import com.toyota.tshop.util.SessionIdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

@Component
@SuppressWarnings("unused")
public class MainService {

    @Autowired
    TokenDAO tokenDAO;

    @Autowired
    UserDAO userDAO;

    @Transactional(rollbackFor = Exception.class)
    public String doAuth(String username, String password, String userAgent, String ipAddress) throws Exception {
        User user = null;

        try {
            user = userDAO.existUser(username, password);
        } catch (NoResultException ex) {
            throw new Exception("USER_NOT_FOUND");
        }

        String tokenStr = new SessionIdentifierGenerator().nextSessionId();

        Token token = new Token(tokenStr, user, ipAddress, userAgent);
        tokenDAO.save(token);

        return tokenStr;
    }

    @Transactional(rollbackFor = Exception.class)
    public void doRegister(String username, String password) throws Exception {
        try {
            userDAO.save(new User(username, password));
        } catch (Exception ex) {
            throw ex;
        }
    }
}
