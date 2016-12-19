package com.health.care.management.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

public final class Util {
	private static Logger LOGGER = Logger.getLogger(Util.class);

    
    private Util(){
        // To prevent instantiation
    }

    /**
     * @param date
     * @return
     */
    public static Date getSqlDateFromJavaDate(java.util.Date date) {
        java.util.Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return new java.sql.Date(cal.getTime().getTime());
    }

    /**
     * to check if string is int or not
     * @param intValue
     * @return
     */
    public static boolean checkStringIsInterger(String intValue) {
        boolean isValidInterger = false;
        try {
            Integer.valueOf(intValue);
            isValidInterger = true;
        } catch (NumberFormatException ex) {
            // if exception is caught then "false" must be sent. Default value is flase so swallow the exception

        }
        return isValidInterger;
    }

    /**
     * @param timeStamp
     * @return
     */
    public static java.util.Date getDateFromTimeStamp(String timeStamp) {
        java.util.Date returnValue = null;
        try {

            returnValue = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(timeStamp);

        } catch (ParseException execption) {
        	LOGGER.error("invalid timestamp" + execption.getMessage());
            System.out.println("Internal server error occured.");
        }
        return returnValue;
    }

    // Fomrated date .
    public static java.util.Date getFormatedDateForString(String dateInString) {
        java.util.Date formattedDate = null;
        try {
            formattedDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateInString);
        } catch (ParseException execption) {
        	LOGGER.error("invalid date string" + execption.getMessage());
            System.out.println("Invalid date input, please try again");
        }
        return formattedDate;
    }

}
