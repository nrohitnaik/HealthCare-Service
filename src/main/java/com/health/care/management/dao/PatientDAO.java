package com.health.care.management.dao;

import com.health.care.management.domain.Patient;

import java.util.List;
import java.util.Map;

public interface PatientDAO {


    Patient findPatientById(int userId);

    int savePatientInfo(Patient patient);

    int updatePatientInfo(Patient patient);

    List<Map<String, Object>> fetchPastAppointmentDetials(int patientId);

}
