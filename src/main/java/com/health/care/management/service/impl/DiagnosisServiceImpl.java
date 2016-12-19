package com.health.care.management.service.impl;

import com.health.care.management.dao.DiagnosisDAO;
import com.health.care.management.dao.impl.DiagnosisDAOImpl;
import com.health.care.management.domain.Diagnosis;
import com.health.care.management.service.DiagnosisService;


public class DiagnosisServiceImpl implements DiagnosisService {

    private DiagnosisDAO diagnosisDao;

    public DiagnosisServiceImpl() {
        super();
        this.diagnosisDao = new DiagnosisDAOImpl();
    }

    /* (non-Javadoc)
     * @see com.health.care.management.service.DiagnosisService#saveDiagnosisDetails(com.health.care.management.domain.Diagnosis)
     */
    @Override
    public int saveDiagnosisDetails(Diagnosis diagnosis) {
        return diagnosisDao.saveDiagnosiedInfoForAppoinntment(diagnosis);
    }


}
