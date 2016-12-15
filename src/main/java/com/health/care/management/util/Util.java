package com.health.care.management.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Util {
    
    private Util(){
        // To prevent instantiation
    }

    public static Date getSqlDateFromJavaDate(java.util.Date date) {
        java.util.Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return new java.sql.Date(cal.getTime().getTime());
    }

    // to check if string is int or not
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

    public static java.util.Date getDateFromTimeStamp(String timeStamp) {
        java.util.Date returnValue = null;
        try {

            returnValue = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(timeStamp);

        } catch (ParseException ex) {
            System.out.println("Internal server error occured.");
        }
        return returnValue;
    }

    // Fomrated date .
    public static java.util.Date getFormatedDateForString(String dateInString) {
        java.util.Date formattedDate = null;
        try {
            formattedDate = new SimpleDateFormat("YYYY/MM/DD").parse(dateInString);
        } catch (ParseException execption) {

            // TODO calling the relevant portion of the caller
            System.out.println("Invalid date input, please try again");
        }
        return formattedDate;
    }

}
