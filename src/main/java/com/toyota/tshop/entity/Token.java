package com.toyota.tshop.entity;

import javax.persistence.*;

@Entity
@SuppressWarnings("unused")
@Table(name = "T_TOKEN", catalog = "omg", uniqueConstraints = {
        @UniqueConstraint(columnNames = "TOKEN")
})
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TOKEN_ID", unique = true, nullable = false)
    private int id;

    @Column(name = "TOKEN", unique = true, nullable = false, length = 32)
    private String token;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    public Token() {
    }

    public Token(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
