package com.ywj.wj.service;

import com.ywj.wj.dao.UserDao;
import com.ywj.wj.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public boolean isExist(String username) {
        User user = userDao.findByUsername(username);
        return user != null;
    }

    public User getByName(String username) {
        return userDao.findByUsername(username);
    }

    public User get(String username, String password) {
        return userDao.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDao.save(user);
    }
}

