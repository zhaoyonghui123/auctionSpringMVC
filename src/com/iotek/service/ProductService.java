package com.iotek.service;

import com.iotek.entity.PageBean;
import com.iotek.entity.Product;
import com.iotek.entity.Record;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ProductService {
    PageBean<Product> getPageBean(int pageIndex, int pageSize);
    Product getProductByid(int productId);
    Map<Product,String> getProductListDeal();
    Map<Product,List<Record>> getProductNotListDeal();
    boolean addProduct(String name, String describe, String startTime, String endTime, BigDecimal startPrice, BigDecimal floorPrice, String img);
    boolean deleteProduct(int productId) throws SQLException;
    boolean updateProduct(int id, String name, String describe, String startTime, String endTime, BigDecimal startPrice, BigDecimal floorPrice, String img);
    List<Product> queryLike(String name);
    PageBean<Product> getLikePageBean(int pageIndex, int pageSize,String name);
    Product queryById(int id);
}
