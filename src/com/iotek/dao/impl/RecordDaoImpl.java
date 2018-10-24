package com.iotek.dao.impl;

import com.iotek.dao.RecordDao;
import com.iotek.entity.Record;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
@Repository
public class RecordDaoImpl extends BaseDao<Record> implements RecordDao {
    @Override
    public List<Record> getRecordListByProId(int productId) {
        String sql = "SELECT record.*,`user`.userName FROM record,`user` WHERE productId=? AND record.userId=`user`.userId";
        List<Record> recordList = query(Record.class, sql, null, productId);
        return recordList;
    }

    @Override
    public Record getMaxPrice(int productId) {

        String sql = "SELECT * from record WHERE auctionPrice=(select max(auctionPrice) from record where productId=?)";
        List<Record> record = query(Record.class, sql, null,productId);
        if (record.size()>0){
            return record.get(0);
        }
        return null;
    }

    @Override
    public boolean addRecordByprice(Record record) {
        String sql = "insert into record(productId,userId,auctionTime,auctionPrice,userName)values(?,?,?,?,?)";
        boolean update = update(sql, null, record.getProductid(), record.getUserid(), record.getAuctiontime(), record.getAuctionprice(),record.getUsername());
    return update;
    }

    @Override
    public boolean deleteById(Connection connection, int productId) {
        String sql = "delete from record where productId=?";
        boolean update = update(sql, connection, productId);
        return update;
    }


    @Override
    public List<Record> queryAll() {
        return null;
    }

    @Override
    public Record query(Integer id) {
        return null;
    }

    @Override
    public boolean add(Record record) {
        return false;
    }

    @Override
    public boolean update(Record record) {
        return false;
    }

    @Override
    public boolean delete(Record record) {
        String sql = "delete from record where productId=?";
        boolean update = update(sql, null, record.getProductid());
        return update;
    }
}