package com.health.care.management.dao;

import com.health.care.management.domain.Patient;

import java.util.List;
import java.util.Map;

public interface PatientDAO {


    /**
     * @param userId
     * @return Patient
     * find patient by patient id
     */
    Patient findPatientById(int userId);

    /**
     * @param patient
     * @return
     * saves the patient info and returns the auto generated primary key
     */
    int savePatientInfo(Patient patient);

    /**
     * @param patient
     * @return
     * updates the patient info
     */
    int updatePatientInfo(Patient patient);

    /**
     * @param patientId
     * @return
     * fetch all the past appointments for patient id
     */
    List<Map<String, Object>> fetchPastAppointmentDetials(int patientId);

}
