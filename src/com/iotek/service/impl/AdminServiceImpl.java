package com.iotek.service.impl;

import com.iotek.service.AdminService;
import com.iotek.dao.AdminDao;
import com.iotek.dao.impl.adminDaoImpl;
import com.iotek.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private Admin admin;
    @Override
    public Object login(String name, String password) {
        admin.setAdminname(name);
        admin.setPassword(password);
        Admin admin1 = adminDao.queryByNamePassword(admin);
        if (admin1!=null){
            return admin1;
        }else{
            Admin admin2 = adminDao.queryByuserName(name);
            if (admin2!=null){
                return "密码错误";
            }else{
                return "用户不存在";
            }
        }
    }
}