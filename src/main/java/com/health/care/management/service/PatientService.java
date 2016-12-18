/*
 * PatientService.java
 * SRH Hochschule Heidelberg
 * All rights reserverd 2016
*/
package com.health.care.management.service;

import com.health.care.management.domain.PastAppointmentDetails;
import com.health.care.management.domain.Patient;

import java.util.List;

public interface PatientService {

    /**
     * get all the details of patient based on the id provided
     * @param userId
     * @return
     */
    Patient findPatientByUserID(int userId);

    /**
     *  add  patient
     * @param patient
     * @return
     */
    int savePatientInfo(Patient patient);

    /**
     * to update patient
     * @param patient
     * @return
     */
    int updatePatient(Patient patient);

    /**
     * 
     */
    void bookAppointment();

    /**
     * fetch all the past appointments
     * @param patientId
     * @return
     */
    List<PastAppointmentDetails> fetchPastAppointmentDetials(int patientId);
    
    /**
     * update the status of the patient 
     * @param patientId
     * @param status
     * @return
     */
    int updatePatientStatus(int patientId, String status);
    
    /**
     * check the status of the patient based on the id
     * @param patientId
     * @return
     */
    String checkPatientStatus(int patientId);

}
