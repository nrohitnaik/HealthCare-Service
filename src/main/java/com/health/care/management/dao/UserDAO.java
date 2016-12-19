/*
 * UserDAO.java
 * SRH Hochschule Heidelberg
 * All rights reserverd 2016
*/
package com.health.care.management.dao;

import com.health.care.management.domain.User;

public interface UserDAO {

	/**
	 * This method will save new user and return the user id.
	 * 
	 * @param user
	 * @return
	 */
	int saveUser(User user);

	/**
	 * this method is used to validate the user and return the role
	 * 
	 * @param user
	 * @return
	 */
	User validateUser(User user);

}
