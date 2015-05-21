package com.toyota.tshop.dao;

import com.toyota.tshop.entity.Shop;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@SuppressWarnings("unchecked")
public class ShopDAO extends BaseDAO<Shop> {
    public ShopDAO() {
        super(Shop.class);
    }

    public List<Shop> findShopsOnline() {
        return (List<Shop>) entityManager
                .createQuery("SELECT sh FROM Shop sh Where sh.isOnline = true")
                .getResultList();
    }
}
