package com.iotek.dao.impl;

import com.iotek.dao.ProductDao;
import com.iotek.entity.Product;
import com.iotek.util.GetDateUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Time;
import java.util.List;
@Repository
public class ProductDaoImpl extends BaseDao<Product> implements ProductDao {
    @Override
    public List<Product> queryAll() {
        String sql = "select * from product";
        List<Product> query = query(Product.class, sql, null);
        if (query.size()>0){
            return query;
        }
        return null;
    }

    @Override
    public Product query(Integer id) {
        String sql ="select * from product where productId=?";
        List<Product> query = query(Product.class, sql, null, id);
        if (query.size()>0){
            return query.get(0);
        }
        return null;
    }

    @Override
    public boolean add(Product product) {
        String sql = "insert into product(productname,pdescribe,startTime,endTime,startPrice,pFloorPrice,pImg)values(?,?,?,?,?,?,?)";
        boolean update = update(sql, null, product.getProductname(), product.getPdescribe(), product.getStarttime()
                , product.getEndtime(), product.getStartprice(), product.getPfloorprice(), product.getPimg());
        return update;
    }

    @Override
    public boolean update(Product product) {
        String sql ="UPDATE product SET productname=?,pdescribe=?,startTime=?,endTime=?," +
                "startPrice=?,pFloorPrice=?,pImg=? WHERE productId=?";
        boolean update = update(sql, null, product.getProductname(), product.getPdescribe(), product.getStarttime(), product.getEndtime(), product.getStartprice(), product.getPfloorprice(), product.getPimg(), product.getProductid());
        return update;
    }

    @Override
    public boolean delete(Product product) {
        String sql = "DELETE FROM product WHERE productId=?";
        boolean update = update(sql, null, product.getProductid());
        return update;
    }

    @Override
    public List<Product> queryProductList(int beginIndex, int pageSize) {
        String sql = "select * from product limit ?,?";
        List<Product> query = query(Product.class, sql, null,beginIndex,pageSize);
        return query;
    }

    @Override
    public List<Product> queryProductDeal(String time) {
        String sql = "SELECT * from product WHERE  endTime<?";
        List<Product> productList = query(Product.class, sql, null,time);
        return productList;
    }

    @Override
    public List<Product> queryProductNotDeal(String time) {
        String sql = "SELECT * from product WHERE  startTime<? and ?<endTime";
        List<Product> productList = query(Product.class, sql, null,time,time);
        return productList;
    }

    @Override
    public boolean deleteById(Connection connection, int productId) {
        String sql = "DELETE FROM product WHERE productId=?";
        boolean update = update(sql, connection, productId);
        return update;
    }

    @Override
    public List<Product> queryProductByname(String name) {
        String sql = "SELECT * FROM product WHERE productname LIKE '%'?'%'";
        List<Product> query = query(Product.class, sql, null, name);
        return query;
    }
}