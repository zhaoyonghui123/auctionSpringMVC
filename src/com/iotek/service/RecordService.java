package com.iotek.service;

import com.iotek.entity.Record;

import java.math.BigDecimal;
import java.util.List;

public interface RecordService {
    List<Record> getRecordListByProId(int productId);
    Record getMaxprice(int productId);
    void addRecord(int productId, int userId, String auctionTime, BigDecimal auctionPrice,String name);
}