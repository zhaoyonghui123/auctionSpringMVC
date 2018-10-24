package com.iotek.dao;

import com.iotek.entity.Product;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;
public interface ProductDao extends Update<Product>,Query<Product> {
    List<Product> queryProductList(int beginIndex, int pageSize);
    List<Product> queryProductDeal(String time);
    List<Product> queryProductNotDeal(String time);
    boolean deleteById(Connection connection, int productId);
    List<Product> queryProductByname(String name);
}