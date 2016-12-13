/*
 * ServiceException.java
 * SRH Hochschule Heidelberg
 * All rights reserverd 2016
*/
package com.health.care.management.exception;

public class ServiceException extends Exception {

    private static final long serialVersionUID = 1L;

    public ServiceException(String iMessage) {
        super(iMessage);

    }

    public ServiceException(Throwable iThrowable) {
        super(iThrowable);
    }

}
