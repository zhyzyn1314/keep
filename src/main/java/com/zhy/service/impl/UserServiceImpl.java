package com.zhy.service.impl;

import com.zhy.bean.Users;
import com.zhy.dao.UsersDao;
import com.zhy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UsersDao usersDao;

    @Override
    public Users getUserById(Integer id) {
        return usersDao.selectById(id);
    }
}
