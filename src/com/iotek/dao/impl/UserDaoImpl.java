package com.iotek.dao.impl;

import com.iotek.dao.UserDao;
import com.iotek.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public List<User> queryAll() {
        return null;
    }

    @Override
    public User query(Integer id) {
        return null;
    }

    @Override
    public boolean add(User user) {
        String sql ="insert into user(userName,password,phone,cards)values(?,?,?,?)";
        boolean update = update(sql, null, user.getUsername(), user.getPassword(), user.getPhone(), user.getCards());
        return update;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public User queryByuserName(String userName) {
      String sql ="select * from user where userName=? ";
        List<User> query = query(User.class, sql, null, userName);
        if (query.size()>0){
            return query.get(0);
        }
        return null;
    }

    @Override
    public User queryUserByNamePassword(User user) {
        String sql="SELECT * FROM user WHERE username=? AND password=?";
        List<User> ulist = query(User.class, sql, null,user.getUsername(),user.getPassword());
        if (ulist.size()>0){
            return ulist.get(0);
        }
        return null;
    }

}