package com.toyota.tshop.dto;

import com.toyota.tshop.entity.Shop;
import com.toyota.tshop.entity.User;

import java.util.Date;

@SuppressWarnings("unused")
public class ShopDTO {

    private int id;
    private String code;
    private String name;
    private boolean isOnline;
    private User updatedBy;
    private Date updatedDate;

    public ShopDTO() {
        this.isOnline = false;
    }

    public ShopDTO(Shop shop) {
        this.id = shop.getId();
        this.code = shop.getCode();
        this.name = shop.getName();
        this.isOnline = shop.isOnline();
        this.updatedBy = shop.getUpdatedBy();
        this.updatedDate = shop.getUpdatedDate();
    }

    public ShopDTO(String code, String name) {
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
