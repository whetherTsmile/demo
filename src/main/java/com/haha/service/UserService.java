package com.haha.service;

import com.haha.model.User;

public interface UserService {
    String selectByUserName(String username,String password);

    int insert(User record);
}
