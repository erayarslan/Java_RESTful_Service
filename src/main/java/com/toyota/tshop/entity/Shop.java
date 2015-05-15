package com.toyota.tshop.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_SHOP", catalog = "omg", uniqueConstraints = {
        @UniqueConstraint(columnNames = "SHOP_CODE")
})
@SuppressWarnings("unused")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SHOP_ID", unique = true, nullable = false)
    private int id;

    @Column(name = "SHOP_CODE", unique = true, nullable = false, length = 8)
    private String code;

    @Column(name = "SHOP_NAME", nullable = false, length = 32)
    private String name;

    @Column(name = "IS_SYSTEM_ON", columnDefinition = "INT(1)", nullable = false)
    private boolean isOnline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPDATED_BY")
    private User updatedBy;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    public Shop() {
        this.isOnline = false;
    }

    public Shop(String code, String name) {
        this.code = code;
        this.name = name;
        this.isOnline = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
