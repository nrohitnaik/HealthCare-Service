package com.health.care.management.domain;

import java.util.Date;

public class Diagnosis {

    private int diagnosisId;
    private String prescription;
    private Date admitDate;
    private Date dischargeDate;
    private String status;
    private int appointmentId;

    // Not taking diagnosis id in consturctor as primary usage is to set the values of diagnosis details. Cam be changed later
    public Diagnosis(String prescription, Date admitDate, Date dischargeDate, String status, int appointmentId) {
        super();
        this.prescription = prescription;
        this.admitDate = admitDate;
        this.dischargeDate = dischargeDate;
        this.status = status;
        this.appointmentId = appointmentId;
    }

    /**
     * @return the diagnosisId
     */
    public int getDiagnosisId() {
        return this.diagnosisId;
    }

    /**
     * @param diagnosisId the diagnosisId to set
     */
    public void setDiagnosisId(int diagnosisId) {
        this.diagnosisId = diagnosisId;
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
     * @return the admitDate
     */
    public Date getAdmitDate() {
        return this.admitDate;
    }

    /**
     * @param admitDate the admitDate to set
     */
    public void setAdmitDate(Date admitDate) {
        this.admitDate = admitDate;
    }

    /**
     * @return the dischargeDate
     */
    public Date getDischargeDate() {
        return this.dischargeDate;
    }

    /**
     * @param dischargeDate the dischargeDate to set
     */
    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
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
}
