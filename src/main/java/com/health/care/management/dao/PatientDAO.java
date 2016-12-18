package com.health.care.management.dao;

import com.health.care.management.domain.Patient;

import java.util.List;
import java.util.Map;

public interface PatientDAO {

	/**
	 * find patient by patient id
	 * 
	 * @param userId
	 * @return Patient
	 *
	 */
	Patient findPatientById(int userId);

	/**
	 * saves the patient info and returns the auto generated primary key
	 * 
	 * @param patient
	 * @return
	 */
	int savePatientInfo(Patient patient);

	/**
	 * updates the patient info
	 * 
	 * @param patient
	 * @return
	 */
	int updatePatientInfo(Patient patient);

	/**
	 * fetch all the past appointments for patient id
	 * 
	 * @param patientId
	 * @return
	 */
	List<Map<String, Object>> fetchPastAppointmentDetials(int patientId);

	/**
	 * to update the status of the patient based on the id provided
	 * 
	 * @param patientId
	 * @param status
	 * @return
	 */
	int updatePatientStatus(int patientId, String status);
	
	/**
	 * Returns the status of the patient if active or not
	 * @param patientId
	 * @return
	 */
	String checkStatusOfPatient(int patientId);

}
