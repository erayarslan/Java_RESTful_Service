package com.toyota.tshop.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_TOKEN", uniqueConstraints = {
        @UniqueConstraint(columnNames = "TOKEN")
})
@SuppressWarnings("unused")
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

    @Column(name = "IP_ADDRESS", nullable = false)
    private String ip_address;

    @Column(name = "USER_AGENT", nullable = false)
    private String user_agent;

    @Column(name = "CREATED", nullable = false)
    private Date created;

    @Column(name = "LAST_ACCESS", nullable = false)
    private Date last_access;

    public Token() {
    }

    public Token(String token, User user, String ip_address, String user_agent) {
        Date now = new Date();

        this.token = token;
        this.user = user;
        this.ip_address = ip_address;
        this.user_agent = user_agent;
        this.created = now;
        this.last_access = now;
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

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getUser_agent() {
        return user_agent;
    }

    public void setUser_agent(String user_agent) {
        this.user_agent = user_agent;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLast_access() {
        return last_access;
    }

    public void setLast_access(Date last_access) {
        this.last_access = last_access;
    }
}
