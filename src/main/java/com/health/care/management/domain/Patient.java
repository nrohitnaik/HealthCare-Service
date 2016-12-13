/*
 * Patient.java
 * SRH Hochschule Heidelberg
 * All rights reserverd 2016
*/
package com.health.care.management.domain;

import java.util.Date;

public class Patient {

    private long id;
    private int userId;
    private String firstName;
    private String lastName;
    private String address;
    private long phoneNumber;
    private int sex;
    private Date dob;
    private String alergies;
    private String name;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the sex
     */
    public int getSex() {
        return this.sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(int sex) {
        this.sex = sex;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return this.dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * @return the alergies
     */
    public String getAlergies() {
        return this.alergies;
    }

    /**
     * @param alergies the alergies to set
     */
    public void setAlergies(String alergies) {
        this.alergies = alergies;
    }



    /**
     * @return the userId
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("1. First Name: %s \n" + "2. Last Name: %s \n" + "3. Address: %s \n" + "4. Mobile Number: %s \n" + "5. Sex: %s \n" + "6. Date of birth: %s \n"
                + "7. Alergies are : %s",

                this.firstName, this.lastName, this.address, this.phoneNumber, this.sex, this.dob, this.alergies);
    }

}
