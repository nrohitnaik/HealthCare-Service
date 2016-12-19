package com.health.care.management.service;

import com.health.care.management.domain.Diagnosis;

public interface DiagnosisService {

    /**
     * To save diagnosis details
     * @param diagnosis
     * @return
     */
    int saveDiagnosisDetails(Diagnosis diagnosis);
        


}
