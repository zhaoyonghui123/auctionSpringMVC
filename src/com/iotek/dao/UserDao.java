package com.iotek.dao;

import com.iotek.entity.User;
import org.springframework.stereotype.Repository;
public interface UserDao extends Update<User>,Query<User>{
    User queryByuserName(String userName);
    User queryUserByNamePassword(User user);
}