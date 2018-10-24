package com.iotek.service.impl;

import com.iotek.dao.impl.BaseDao;
import com.iotek.service.ProductService;
import com.iotek.dao.ProductDao;
import com.iotek.dao.RecordDao;
import com.iotek.dao.impl.ProductDaoImpl;
import com.iotek.dao.impl.RecordDaoImpl;
import com.iotek.entity.PageBean;
import com.iotek.entity.Product;
import com.iotek.entity.Record;
import com.iotek.util.GetDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductServiceImpl extends BaseDao implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private RecordDao recordDao;
    @Autowired
    private PageBean<Product> pageBean;
    @Autowired
    private Product product;
    @Override
    public PageBean<Product> getPageBean(int pageIndex, int pageSize) {
        List<Product> products = productDao.queryAll();
        pageBean.setRows(products.size());
        pageBean.setPageIndex(pageIndex);
        pageBean.setPageSize(pageSize);
        int beginIndex = pageBean.getBeginIndex();
        pageBean.setData(productDao.queryProductList(beginIndex,pageSize));
        return pageBean;
    }

    @Override
    public Product getProductByid(int productId) {
        Product product = productDao.query(productId);
        return product;
    }

    @Override
    public Map<Product,String> getProductListDeal() {
        String time = GetDateUtil.getTime();
        List<Product> productList = productDao.queryProductDeal(time);
        System.out.println(productList.size());
        for (Product product : productList){
            System.out.println(product.getProductid());
        }
        Map<Product,String> productListMap = new HashMap<>();
        for (Product product : productList){
            System.out.println(product);
            System.out.println(product.getProductid());
            Record record = recordDao.getMaxPrice(product.getProductid());
            System.out.println(record);
            productListMap.put(product,record.getUsername());
        }

        return productListMap;
    }

    @Override
    public Map<Product,List<Record>> getProductNotListDeal() {
        Map<Product,List<Record>> productListMap = new HashMap<>();
        String time = GetDateUtil.getTime();
        List<Product> productList = productDao.queryProductNotDeal(time);
        for (Product product : productList){
            List<Record> recordList = recordDao.getRecordListByProId(product.getProductid());
            productListMap.put(product,recordList);
        }
        return  productListMap;
    }

    @Override
    public boolean addProduct(String name, String describe, String startTime, String endTime, BigDecimal startPrice, BigDecimal floorPrice, String img) {
        product.setProductname(name);
        product.setPdescribe(describe);
        product.setStarttime(startTime);
        product.setEndtime(endTime);
        product.setStartprice(startPrice);
        product.setPfloorprice(floorPrice);
        product.setPimg(img);
        boolean add = productDao.add(product);
       return add;

    }

    @Override
    public boolean deleteProduct(int productId) throws SQLException {
        Connection connection = null;
        try {
            connection=getConn();
            connection.setAutoCommit(false);
            recordDao.deleteById(connection,productId);
            productDao.deleteById(connection,productId);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            if (connection!=null){
                connection.close();
            }
        }
        return true;
    }

    @Override
    public boolean updateProduct(int id,String name, String describe, String startTime, String endTime, BigDecimal startPrice, BigDecimal floorPrice, String img) {
        product.setProductname(name);
        product.setPdescribe(describe);
        product.setStarttime(startTime);
        product.setEndtime(endTime);
        product.setStartprice(startPrice);
        product.setPfloorprice(floorPrice);
        product.setPimg(img);
        product.setProductid(id);
        boolean update = productDao.update(product);

        return update;
    }

    @Override
    public List<Product> queryLike(String name) {
        product.setProductname(name);
        List<Product> productList = productDao.queryProductByname(name);
        return productList;

    }

    @Override
    public PageBean<Product> getLikePageBean(int pageIndex, int pageSize,String name) {
        List<Product> products = productDao.queryProductByname(name);
        pageBean.setRows(products.size());
        pageBean.setPageIndex(pageIndex);
        pageBean.setPageSize(pageSize);
        int beginIndex = pageBean.getBeginIndex();
        pageBean.setData(productDao.queryProductList(beginIndex,pageSize));
        return pageBean;
    }

    @Override
    public Product queryById(int id) {
        Product query = productDao.query(id);
        return query;
    }

}