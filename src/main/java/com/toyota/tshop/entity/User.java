package com.toyota.tshop.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@SuppressWarnings("unused")
@Table(name = "T_USER", catalog = "omg", uniqueConstraints = {
        @UniqueConstraint(columnNames = "USERNAME")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", unique = true, nullable = false)
    private int id;

    @Column(name = "USERNAME", unique = true, nullable = false, length = 24)
    private String username;

    @Column(name = "PASSWORD", unique = false, nullable = false, length = 32)
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "updatedBy")
    private Set<Shop> userShops = new HashSet<Shop>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Token> userTokens = new HashSet<Token>(0);

    public Set<Token> getUserTokens() {
        return userTokens;
    }

    public void setUserTokens(Set<Token> userTokens) {
        this.userTokens = userTokens;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Set<Shop> userShops) {
        this.username = username;
        this.password = password;
        this.userShops = userShops;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Shop> getUserShops() {
        return userShops;
    }

    public void setUserShops(Set<Shop> userShops) {
        this.userShops = userShops;
    }
}
