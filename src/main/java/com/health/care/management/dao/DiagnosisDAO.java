package com.health.care.management.dao;

import com.health.care.management.domain.Diagnosis;

import java.util.List;
import java.util.Map;

public interface DiagnosisDAO {

	/**
	 * saves the diagnosis info
	 * 
	 * @param diagnosis
	 * @return
	 */
	int saveDiagnosiedInfoForAppoinntment(Diagnosis diagnosis);

	/**
	 * fetch all the diagnosis info based on status
	 * 
	 * @param status
	 * @return
	 */
	List<Map<String, Object>> fetchTreatmentDetailsByStatus(String status);

	/**
	 * update the status of diagnosis based on diagnosis id
	 * 
	 * @param status
	 * @param diagnosisId
	 * @return
	 */
	int updateTheDiagnosisStatus(String status, int diagnosisId);
}
