package com.haha.controller;

import com.haha.model.User;
import com.haha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.haha.util.Utils.isNull;

@Controller
@RequestMapping(produces = "text/html;charset=utf-8", method = RequestMethod.POST)

public class UserController {
    @Autowired
    UserService userServiceImpl;

    @ResponseBody
    @RequestMapping(value = "login.do")
    public String Login(String username, String password) {
        return userServiceImpl.selectByUserName(isNull(username), isNull(password));
    }

    @ResponseBody
    @RequestMapping(value = "registry.do")
    public String registry(User record) {
        String username = isNull(record.getUsername());
        String password = isNull(record.getPassword());
        String email = isNull(record.getEmail());
        if (username == null | password == null | email == null) {
            return "不能为空";
        }
        record.setUsername(username);
        record.setEmail(email);
        record.setPassword(password);
        int i = userServiceImpl.insert(record);
        if (i == 1)
            return "注册成功";

        if (i == 0)
            return "用户名或邮箱重复";

        if (i == -1)
            return "系统错误，请稍后再试";

        return null;
    }
}
