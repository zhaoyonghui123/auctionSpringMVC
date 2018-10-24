package com.iotek.service.impl;

import com.iotek.service.RecordService;
import com.iotek.dao.RecordDao;
import com.iotek.dao.impl.RecordDaoImpl;
import com.iotek.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;
    @Autowired
    private Record record;
    @Override
    public List<Record> getRecordListByProId(int productId) {
        List<Record> recordList = recordDao.getRecordListByProId(productId);
        return recordList;
    }

    @Override
    public Record getMaxprice(int productId) {
        Record maxPriceRecord = recordDao.getMaxPrice(productId);
        return maxPriceRecord;
    }

    @Override
    public void addRecord(int productId,int userId,String auctionTime,BigDecimal auctionPrice,String name) {
        record.setProductid(productId);
        record.setUserid(userId);
        record.setAuctiontime(auctionTime);
        record.setAuctionprice(auctionPrice);
        record.setUsername(name);
        recordDao.addRecordByprice(record);
    }
}