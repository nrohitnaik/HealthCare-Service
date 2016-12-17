/*
 * UserService.java
 * SRH Hochschule Heidelberg
 * All rights reserverd 2016
*/
package com.health.care.management.service;

import com.health.care.management.domain.User;



public interface UserService {

    /*
     * @param user
     */
    User saveUser(User user);

    User validateUser(User user);


}
