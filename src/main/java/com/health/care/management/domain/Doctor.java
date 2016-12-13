package com.health.care.management.domain;


public class Doctor {

    private int registrationId;
    private String firstName;
    private String lastName;
    private String specialization;
    private String department;
    private long mobileNumber;
    private String qualification;
    private String workingHours;
    private String email;
    private String experience;
    private int availability;
    private int userId;

    /**
     * @return the id
     */
    public int getRegistrationId() {

        return this.registrationId;
    }

    /**
     * @param id the id to set
     */
    public void setRegistrationId(int id) {
        this.registrationId = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the specialization
     */
    public String getSpecialization() {
        return this.specialization;
    }

    /**
     * @param specialization the specialization to set
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the mobileNumber
     */
    public long getMobileNumber() {
        return this.mobileNumber;
    }

    /**
     * @param mobileNumber the mobileNumber to set
     */
    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @return the qualification
     */
    public String getQualification() {
        return this.qualification;
    }

    /**
     * @param qualification the qualification to set
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * @return the workingHours
     */
    public String getWorkingHours() {
        return this.workingHours;
    }

    /**
     * @param workingHours the workingHours to set
     */
    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the experience
     */
    public String getExperience() {
        return this.experience;
    }

    /**
     * @param experience the experience to set
     */
    public void setExperience(String experience) {
        this.experience = experience;
    }

    /**
     * @return the availability
     */
    public int isAvailability() {
        return this.availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(int availability) {
        this.availability = availability;
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
     * @return the availability
     */
    public int getAvailability() {
        return this.availability;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format(
                "1. First Name: %s \n2. Last Name: %s \n3. Specialization=%s \n4. Department=%s \n5. Mobile Number=%s \n6. Qualification=%s \n7. Working Hours=%s \n8. email=%s \n9. Experience=%s \n10. availability=%s",
                this.firstName, this.lastName, this.specialization, this.department, this.mobileNumber, this.qualification, this.workingHours, this.email, this.experience,
                this.availability);
    }

}
