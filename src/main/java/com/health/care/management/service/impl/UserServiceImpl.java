package com.health.care.management.service.impl;

import com.health.care.management.dao.UserDAO;
import com.health.care.management.dao.impl.UserDAOImpl;
import com.health.care.management.domain.User;
import com.health.care.management.dto.UserDTO;
import com.health.care.management.service.UserService;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.dao.EmptyResultDataAccessException;


public class UserServiceImpl implements UserService {

    private UserDAO userDao;
    private ObjectMapper objectMapper;

    public UserServiceImpl() {
        this.userDao = new UserDAOImpl();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public User saveUser(UserDTO user) {
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
        }
        else {
            System.out.println("Id already exists");
        }

        return newUser;
    }

    @Override
    public UserDTO getUserbyUserName(String userName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDTO validateUser(UserDTO user) {
        User userDomain = objectMapper.convertValue(user, User.class);
        User returnedDomain = userDao.validateUser(userDomain);
        if (userDomain.getPassword().equals(returnedDomain.getPassword())) {
            user.setStatus("valid");
            user.setRole(returnedDomain.getRole());
            user.setId(returnedDomain.getId());
        }
        else {
            user.setStatus("invalid");
        }
        return user;

    }

}
