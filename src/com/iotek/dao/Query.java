package com.iotek.dao;

import java.util.List;

/**
 * Created by xiaohuang on 2018/7/4.
 * ----------------The heart withered--------
 */
public interface Query<T> {
//   查询所有内容
    List<T> queryAll();
//   通过id 查询
    T query(Integer id);

}
