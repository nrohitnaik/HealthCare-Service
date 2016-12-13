package com.health.care.management.dto;

import java.util.Date;

public class PatientDTO {

    private long id;
    private int userId;
    private String firstName;
    private String lastName;
    private String address;
    private long phoneNumber;
    private int sex;
    private Date dob;
    private String alergies;

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


}
