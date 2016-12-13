package com.health.care.management.dao;

import com.health.care.management.domain.Diagnosis;

import java.util.List;
import java.util.Map;

public interface DiagnosisDAO {

    int saveDiagnosiedInfoForAppoinntment(Diagnosis diagnosis);

    List<Map<String, Object>> fetchTreatmentDetailsByStatus(String status);

    int updateTheDiagnosisStatus(String status, int diagnosisId);
}
