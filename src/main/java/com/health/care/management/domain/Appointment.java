package com.health.care.management.domain;

import java.util.Date;

public class Appointment {

    private int appointmentId;
    private Date timeSlot;
    private String comment;
    private String illness;
    private int doctorUserId;
    private String status;
    private int patientUserId;
    private String doctorName;
    private String patientName;

    // only for retrival time
    private String alergies;

    public Appointment() {

    }

    public Appointment(Date timeSlot, String comment, String illness, int doctorUserId, String status, int patientUserId) {
        super();
        this.timeSlot = timeSlot;
        this.comment = comment;
        this.illness = illness;
        this.doctorUserId = doctorUserId;
        this.status = status;
        this.patientUserId = patientUserId;
    }

    /**
     * @return the appointmentId
     */
    public int getAppointmentId() {
        return this.appointmentId;
    }

    /**
     * @param appointmentId the appointmentId to set
     */
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    /**
     * @return the timeSlot
     */
    public Date getTimeSlot() {
        return this.timeSlot;
    }

    /**
     * @param timeSlot the timeSlot to set
     */
    public void setTimeSlot(Date timeSlot) {
        this.timeSlot = timeSlot;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
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


    /**
     * @return the status
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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
     * @return the doctorUserId
     */
    public int getDoctorUserId() {
        return this.doctorUserId;
    }


    /**
     * @param doctorUserId the doctorUserId to set
     */
    public void setDoctorUserId(int doctorUserId) {
        this.doctorUserId = doctorUserId;
    }


    /**
     * @return the patientUserId
     */
    public int getPatientUserId() {
        return this.patientUserId;
    }


    /**
     * @param patientUserId the patientUserId to set
     */
    public void setPatientUserId(int patientUserId) {
        this.patientUserId = patientUserId;
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

    // for displaying appointment details for patient
    public String toStringForPatient() {
        return "" + this.appointmentId + "\t\t" + this.timeSlot + "\t\t" + this.comment + "\t\t" + this.illness + "\t\t" + this.doctorName;
    }

    // for displaying appointment details for doctor
    public String toStringForDoctor() {
        return "" + this.appointmentId + "\t\t" + this.timeSlot + "\t\t" + this.patientName + "\t\t" + this.comment + "\t\t" + this.illness + "\t\t" + this.alergies;
    }
}
