package com.iotek.dao;

/**
 * Created by xiaohuang on 2018/7/4.
 * ----------------The heart withered--------
 */
public interface Update<T> {
   boolean add(T t);
   boolean update(T t);
   boolean delete(T t);
}
