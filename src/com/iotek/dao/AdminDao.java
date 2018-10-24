package com.iotek.dao;

import com.iotek.entity.Admin;
import com.iotek.entity.User;
import org.springframework.stereotype.Repository;
public interface AdminDao extends Query<Admin>,Update<Admin> {
    Admin queryByuserName(String userName);
    Admin queryByNamePassword(Admin admin);
}
