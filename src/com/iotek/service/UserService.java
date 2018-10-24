package com.iotek.service;

public interface UserService {
    boolean addUser(String userName, String password, String phone, String cards);

    Object queryUserByUserNamePass(String userName, String password);
}