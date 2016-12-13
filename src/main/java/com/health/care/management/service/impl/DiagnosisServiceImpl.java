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

    @Override
    public int saveDiagnosisDetails(Diagnosis diagnosis) {
        return diagnosisDao.saveDiagnosiedInfoForAppoinntment(diagnosis);
    }

    // TODO need to write a method to get list of diagnosied patient where status is treated.

}
