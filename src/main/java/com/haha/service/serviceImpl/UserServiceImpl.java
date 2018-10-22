package com.haha.service.serviceImpl;

import com.haha.dao.UserMapper;
import com.haha.model.User;
import com.haha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public String selectByUserName(String username,String password) {
        User user =  userMapper.selectByUserName(username);
        if (user == null) {
            return "用户名不存在";
        }
        if (user.getPassword().equals(password)) {
            if (user.getStatus())
                return "登陆成功";
            else
                return "用户未验证";
        }
        return "密码错误";
    }

    @Override
    public int insert(User record) {
        try {
            return userMapper.insert(record);
        } catch (DuplicateKeyException e) {
            System.out.println(e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

}
