package com.health.care.management.dao.impl;

import com.health.care.management.HealthCareServiceConfiguration;
import com.health.care.management.constant.Constant;
import com.health.care.management.dao.DiagnosisDAO;
import com.health.care.management.domain.Diagnosis;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class DiagnosisDAOImpl implements DiagnosisDAO {

    private JdbcTemplate jdbcTemplate;

    public DiagnosisDAOImpl() {
        this.jdbcTemplate = HealthCareServiceConfiguration.getJdbcConnection();
    }

    /* (non-Javadoc)
     * @see com.health.care.management.dao.DiagnosisDAO#saveDiagnosiedInfoForAppoinntment(com.health.care.management.domain.Diagnosis)
     */
    @Override
    public int saveDiagnosiedInfoForAppoinntment(Diagnosis diagnosis) {
        return jdbcTemplate.update(Constant.SAVE_DIAGNOSIS,
                new Object[] { diagnosis.getPrescription(), diagnosis.getAdmitDate(), diagnosis.getDischargeDate(), diagnosis.getStatus(), diagnosis.getAppointmentId() });

    }

    /* (non-Javadoc)
     * @see com.health.care.management.dao.DiagnosisDAO#fetchTreatmentDetailsByStatus(java.lang.String)
     */
    @Override
    public List<Map<String, Object>> fetchTreatmentDetailsByStatus(String status) {
        return jdbcTemplate.queryForList(Constant.FETCH_DIAGNOSIED_INFO_BY_STATUS, new Object[] { status });
    }

    /* (non-Javadoc)
     * @see com.health.care.management.dao.DiagnosisDAO#updateTheDiagnosisStatus(java.lang.String, int)
     */
    @Override
    public int updateTheDiagnosisStatus(String status, int diagnosisId) {
        return jdbcTemplate.update(Constant.UPDATE_STATUS_OF_DIAGNOSIS_BY_ID, new Object[] { status, diagnosisId });
    }

}
