package com.iotek.dao;

import java.util.List;

/**
 * Created by xiaohuang on 2018/7/4.
 * ----------------The heart withered--------
 */
public interface Query<T> {
//   ��ѯ��������
    List<T> queryAll();
//   ͨ��id ��ѯ
    T query(Integer id);

}
