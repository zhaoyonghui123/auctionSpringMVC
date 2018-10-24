package com.iotek.dao.impl;

import com.iotek.dao.AdminDao;
import com.iotek.entity.Admin;
import com.iotek.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class adminDaoImpl extends BaseDao<Admin> implements AdminDao {
    @Override
    public Admin queryByuserName(String userName) {
        String sql ="select * from admin where adminName=? ";
        List<Admin> query = query(Admin.class, sql, null, userName);
        if (query.size()>0){
            return query.get(0);
        }
        return null;
    }

    @Override
    public Admin queryByNamePassword(Admin admin) {
        String sql="SELECT * FROM admin WHERE adminName=? AND password=?";
        List<Admin> ulist = query(Admin.class, sql, null,admin.getAdminname(),admin.getPassword());
        if (ulist.size()>0){
            return ulist.get(0);
        }
        return null;
    }

    @Override
    public List<Admin> queryAll() {
        return null;
    }

    @Override
    public Admin query(Integer id) {
        return null;
    }

    @Override
    public boolean add(Admin admin) {
        return false;
    }

    @Override
    public boolean update(Admin admin) {
        return false;
    }

    @Override
    public boolean delete(Admin admin) {
        return false;
    }
}