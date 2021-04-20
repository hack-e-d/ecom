package com.example.ecommerce.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserServices {
    @Autowired
    UserDao userDao;
    @Override
    public Map<String, Object> getUserDetails() {
        return userDao.getUserDetails();
    }
}
