/*
 * UserService.java
 * SRH Hochschule Heidelberg
 * All rights reserverd 2016
*/
package com.health.care.management.service;

import com.health.care.management.domain.User;
import com.health.care.management.dto.UserDTO;



public interface UserService {

    /*
     * @param user
     */
    User saveUser(UserDTO user);

    UserDTO validateUser(UserDTO user);

    /*
     * @param username
     */
    UserDTO getUserbyUserName(String userName);

}
