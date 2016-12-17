package com.health.care.management.dao;

import com.health.care.management.domain.Diagnosis;

import java.util.List;
import java.util.Map;

public interface DiagnosisDAO {

    /**
     * @param diagnosis
     * @return
     * saves the diagnosis info
     */
    int saveDiagnosiedInfoForAppoinntment(Diagnosis diagnosis);

    /**
     * @param status
     * @return
     * fetch all the diagnosis info based on status
     */
    List<Map<String, Object>> fetchTreatmentDetailsByStatus(String status);

    /**
     * @param status
     * @param diagnosisId
     * @return
     * update the status of diagnosis based on diagnosis id
     */
    int updateTheDiagnosisStatus(String status, int diagnosisId);
}
