/*
 * PatientServiceImpl.java
 * SRH Hochschule Heidelberg
 * All rights reserverd 2016
*/
package com.health.care.management.service.impl;

import static com.health.care.management.util.Util.getDateFromTimeStamp;

import com.health.care.management.dao.PatientDAO;
import com.health.care.management.dao.impl.PatientDAOImpl;
import com.health.care.management.domain.PastAppointmentDetails;
import com.health.care.management.domain.Patient;
import com.health.care.management.dto.PatientDTO;
import com.health.care.management.service.PatientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
public class PatientServiceImpl implements PatientService {


    // Used for mapping of object
    private ObjectMapper objectMapper;

    private PatientDAO patientDAO;

    public PatientServiceImpl() {
        this.objectMapper = new ObjectMapper();
        this.patientDAO = new PatientDAOImpl();
    }

    @Override
    public Patient findPatientByUserID(int userId) {
        return patientDAO.findPatientById(userId);
    }

    @Override
    // TODO DTO requried or domain will do the job
    // need to handle SQL Exceptions
    public int savePatientInfo(PatientDTO patient) {
        Patient newPatient = objectMapper.convertValue(patient, Patient.class);
        return patientDAO.savePatientInfo(newPatient);
    }

    @Override
    public int updatePatient(Patient patient) {
        return patientDAO.updatePatientInfo(patient);

    }

    @Override
    public void bookAppointment() {
        // TODO Auto-generated method stub

    }

    @Override
    public List<PastAppointmentDetails> fetchPastAppointmentDetials(int patientId) {
        List<Map<String, Object>> returnedValue = patientDAO.fetchPastAppointmentDetials(patientId);
        List<PastAppointmentDetails> pastAppointmentDetails = new ArrayList<>();
        returnedValue.forEach(a -> {
            PastAppointmentDetails pastAppointmentDetail = new PastAppointmentDetails();
            pastAppointmentDetail.setAmount(Double.valueOf(a.get("amount").toString()));
            pastAppointmentDetail.setAppointmentDate(getDateFromTimeStamp(a.get("date").toString()));
            pastAppointmentDetail.setDoctorName(a.get("doctor_name").toString());
            pastAppointmentDetail.setIllness(a.get("illness").toString());
            pastAppointmentDetail.setPatientName(a.get("patient_name").toString());
            pastAppointmentDetail.setPrescription(a.get("patient_name").toString());
            pastAppointmentDetails.add(pastAppointmentDetail);
        });
        return pastAppointmentDetails;
    }

}
