package com.iotek.dao;

import com.iotek.entity.Record;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.prism.impl.Disposer;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
public interface RecordDao extends Query<Record>,Update<Record> {
    List<Record> getRecordListByProId(int productId);
    Record getMaxPrice(int productId);
    boolean addRecordByprice(Record record);
    boolean deleteById(Connection connection, int productId);
}
