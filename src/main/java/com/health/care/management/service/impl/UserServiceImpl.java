package com.health.care.management.service.impl;

import com.health.care.management.dao.UserDAO;
import com.health.care.management.dao.impl.UserDAOImpl;
import com.health.care.management.domain.User;
import com.health.care.management.service.UserService;

import org.springframework.dao.EmptyResultDataAccessException;

public class UserServiceImpl implements UserService {

    private UserDAO userDao;

    public UserServiceImpl() {
        this.userDao = new UserDAOImpl();
    }

    @Override
    public User saveUser(User user) {
        User newUser = new User();
        newUser.setPassword(user.getPassword());
        newUser.setRole(user.getRole());
        newUser.setUserName(user.getUserName());
        int returnedUserId = 0;
        try {
            returnedUserId = userDao.saveUser(newUser);
        } catch (EmptyResultDataAccessException execption) {
            System.out.println("No user data exits in db");
        }
        if (returnedUserId != 0) {
            newUser.setId(returnedUserId);
        } else {
            System.out.println("Id already exists");
        }

        return newUser;
    }

    @Override
    public User validateUser(User user) {
        User returnedDomain = userDao.validateUser(user);
        if (user.getPassword().equals(returnedDomain.getPassword())) {
            user.setStatus("valid");
            user.setRole(returnedDomain.getRole());
            user.setId(returnedDomain.getId());
        } else {
            user.setStatus("invalid");
        }
        return user;

    }

}
