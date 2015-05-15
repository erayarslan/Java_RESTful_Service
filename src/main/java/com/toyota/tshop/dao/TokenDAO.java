package com.toyota.tshop.dao;

import com.toyota.tshop.entity.Token;
import org.springframework.stereotype.Component;

@Component
public class TokenDAO extends BaseDAO<Token> {
    public TokenDAO() {
        super(Token.class);
    }

    public Token existToken(String token) {
        return (Token)entityManager.createQuery("SELECT tk FROM Token tk Where tk.token = :token").setParameter("token", token).getSingleResult();
    }
}
