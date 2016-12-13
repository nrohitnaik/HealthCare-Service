package com.health.care.management.domain;

import java.util.Date;

public class PastAppointmentDetails {

    private String patientName;
    private String doctorName;
    private double amount;
    private String prescription;
    private Date appointmentDate;
    private String illness;

    /**
     * @return the patientName
     */
    public String getPatientName() {
        return this.patientName;
    }

    /**
     * @param patientName the patientName to set
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     * @return the doctorName
     */
    public String getDoctorName() {
        return this.doctorName;
    }

    /**
     * @param doctorName the doctorName to set
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }


    /**
     * @return the prescription
     */
    public String getPrescription() {
        return this.prescription;
    }


    /**
     * @param prescription the prescription to set
     */
    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    /**
     * @return the appointmentDate
     */
    public Date getAppointmentDate() {
        return this.appointmentDate;
    }

    /**
     * @param appointmentDate the appointmentDate to set
     */
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     * @return the illness
     */
    public String getIllness() {
        return this.illness;
    }

    /**
     * @param illness the illness to set
     */
    public void setIllness(String illness) {
        this.illness = illness;
    }

}
