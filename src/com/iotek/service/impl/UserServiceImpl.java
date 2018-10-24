package com.iotek.service.impl;

import com.iotek.service.UserService;
import com.iotek.dao.UserDao;
import com.iotek.dao.impl.UserDaoImpl;
import com.iotek.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.management.counter.perf.PerfInstrumentation;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private User user;
    @Override
    public boolean addUser(String userName, String password, String phone, String cards) {
        user.setUsername(userName);
        user.setPassword(password);
        user.setPhone(phone);
        user.setCards(cards);
        User user1 = userDao.queryByuserName(userName);
        if (user1==null){
            boolean add = userDao.add(user);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Object queryUserByUserNamePass(String userName, String password) {
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        User user1 = userDao.queryUserByNamePassword(user);
        if (user1 != null) {
            return user1;
        } else {
            User user2 = userDao.queryByuserName(userName);
            if (user2 == null) {
                return "用户不存在";
            } else
                return "密码错误";

        }
    }

}