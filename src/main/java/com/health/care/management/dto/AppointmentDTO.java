package com.health.care.management.dto;

import java.util.Date;

public class AppointmentDTO {
        private int appointmentId;
        private Date timeSlot;
        private String comment;
        private String illness;
        private String doctorName;
        private String status;
        private String patientName;
    private double ammount;
    private String prescription;


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
         * @return the doctorUsername
         */
        public String getDoctorName() {
            return this.doctorName;
        }

        /**
         * @param doctorUsername the doctorUsername to set
         */
        public void setDoctorName(String doctorUsername) {
            this.doctorName = doctorUsername;
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
         * @return the patientUsername
         */
        public String getPatientName() {
            return this.patientName;
        }

        /**
         * @param patientUsername the patientUsername to set
         */
        public void setPatientName(String patientUsername) {
            this.patientName = patientUsername;
        }

    /**
     * @return the ammount
     */
    public double getAmmount() {
        return this.ammount;
    }

    /**
     * @param ammount the ammount to set
     */
    public void setAmmount(double ammount) {
        this.ammount = ammount;
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

}
