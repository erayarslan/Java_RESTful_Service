package com.toyota.tshop.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@SuppressWarnings("unused")
@Table(name = "T_SHOP")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SHOP_ID")
    private int id;

    @Column(name = "SHOP_CODE", length = 10)
    private String code;

    @Column(name = "SHOP_NAME", length = 50)
    private String name;

    @Column(name = "IS_SYSTEM_ON", columnDefinition = "INT(1)")
    private boolean isOnline;

    @Column(name = "UPDATED_BY", length = 10)
    private String updatedBy;

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

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
