/*
 * UserDAO.java
 * SRH Hochschule Heidelberg
 * All rights reserverd 2016
*/
package com.health.care.management.dao;

import com.health.care.management.domain.User;

public interface UserDAO {

    /**
     * @param user
     * @return
     * This method will save new user and return the user id.
     */
    int saveUser(User user);

    /**
     * @param user
     * @return
     * this method is used to validate the user and return the role
     */
    User validateUser(User user);

}
