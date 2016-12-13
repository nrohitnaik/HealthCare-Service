package com.health.care.management.domain;

import java.util.Date;

public class Bill {

    private int billId;
    private String patientName;
    private String doctorName;
    private double billAmount;
    private String status;
    private String prescription;
    private String comment;
    private Date admitDate;
    private Date dischargeDate;
    private String doctorSpecialization;
    private int diagnosisId;
    private int patientId;

    /**
     * @return the patientId
     */
    public int getPatientId() {
        return this.patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    /**
     * @return the billId
     */
    public int getBillId() {
        return this.billId;
    }

    /**
     * @param billId the billId to set
     */
    public void setBillId(int billId) {
        this.billId = billId;
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
     * @return the billAmount
     */
    public double getBillAmount() {
        return this.billAmount;
    }

    /**
     * @param billAmount the billAmount to set
     */
    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
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
     * @return the doctorSpecialization
     */
    public String getDoctorSpecialization() {
        return this.doctorSpecialization;
    }

    /**
     * @param doctorSpecialization the doctorSpecialization to set
     */
    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
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

}
