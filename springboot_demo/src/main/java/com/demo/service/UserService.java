package com.demo.service;

import com.demo.dao.UserDao;
import com.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: xiebaobiao
 * Date: 2018/3/21
 * Time: 15:25
 * Description:
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findById(Long id) {
        return userDao.findById(id);
    }

    public User findByUserNameAndPasss(String username, String password) {
        return userDao.findByUserNameAndPasss(username,password);
    }
}