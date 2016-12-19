/*
 * UserService.java
 * SRH Hochschule Heidelberg
 * All rights reserverd 2016
*/
package com.health.care.management.service;

import com.health.care.management.domain.User;



public interface UserService {


    /**
     * To save the user
     * @param user
     * @return
     */
    User saveUser(User user);

    /**
     * @param user
     * @return
     */
    User validateUser(User user);


}
