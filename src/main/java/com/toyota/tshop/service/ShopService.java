package com.toyota.tshop.service;

import com.toyota.tshop.dao.ShopDAO;
import com.toyota.tshop.dto.ShopDTO;
import com.toyota.tshop.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@SuppressWarnings("unused")
public class ShopService {

    @Autowired
    ShopDAO shopDAO;

    public void setShopDAO(ShopDAO shopDAO) {
        this.shopDAO = shopDAO;
    }

    @Transactional
    public void persistShop(ShopDTO shopDTO) {
        Shop shop = new Shop(shopDTO.getCode(), shopDTO.getName());
        shopDAO.save(shop);
    }

    @Transactional
    public void deleteShop(int id) {
        shopDAO.delete(shopDAO.findByID(id));
    }

    @Transactional
    public void updateShop(int id, ShopDTO shopDTO) {
        Shop shop = shopDAO.findByID(id);
        shop.setName(shopDTO.getName());
        shop.setCode(shopDTO.getCode());
        shop.setUpdatedBy(shopDTO.getName());
        shop.setUpdatedDate(new Date());
        shopDAO.save(shop);
    }

    @Transactional
    public void mergeShop(Shop cse) {
        shopDAO.merge(cse);
    }

    @Transactional(readOnly = true)
    public ShopDTO getByID(int id) {
        return new ShopDTO(shopDAO.findByID(id));
    }

    @Transactional(readOnly = true)
    public List<ShopDTO> getAll() {
        List<Shop> shops = shopDAO.findAll();
        List<ShopDTO> shopDTOs = new ArrayList<ShopDTO>();
        for (Shop shop : shops) {
            shopDTOs.add(new ShopDTO(shop));
        }
        return shopDTOs;
    }

    @Transactional(readOnly = true)
    public List<ShopDTO> getOnlines() {
        List<Shop> shops = shopDAO.findShopsOnline();
        List<ShopDTO> shopDTOs = new ArrayList<ShopDTO>();
        for (Shop shop : shops) {
            shopDTOs.add(new ShopDTO(shop));
        }
        return shopDTOs;
    }
}
