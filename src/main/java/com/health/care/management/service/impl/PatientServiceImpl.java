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
import com.health.care.management.service.PatientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService {

    private PatientDAO patientDAO;

    /**
     * Default constructor
     */
    public PatientServiceImpl() {
        this.patientDAO = new PatientDAOImpl();
    }

    /* (non-Javadoc)
     * @see com.health.care.management.service.PatientService#findPatientByUserID(int)
     */
    @Override
    public Patient findPatientByUserID(int userId) {
        return patientDAO.findPatientById(userId);
    }

    /* (non-Javadoc)
     * @see com.health.care.management.service.PatientService#savePatientInfo(com.health.care.management.domain.Patient)
     */
    @Override
    public int savePatientInfo(Patient patient) {
        return patientDAO.savePatientInfo(patient);
    }

    /* (non-Javadoc)
     * @see com.health.care.management.service.PatientService#updatePatient(com.health.care.management.domain.Patient)
     */
    @Override
    public int updatePatient(Patient patient) {
        return patientDAO.updatePatientInfo(patient);

    }

    /* (non-Javadoc)
     * @see com.health.care.management.service.PatientService#bookAppointment()
     */
    @Override
    public void bookAppointment() {
        // TODO Auto-generated method stub

    }
    
	/* (non-Javadoc)
	 * @see com.health.care.management.service.PatientService#updatePatientStatus(int, java.lang.String)
	 */
	@Override
	public int updatePatientStatus(int patientId, String status) {
		return patientDAO.updatePatientStatus(patientId, status);
	}

	/* (non-Javadoc)
	 * @see com.health.care.management.service.PatientService#checkPatientStatus(int)
	 */
	@Override
	public String checkPatientStatus(int patientId) {
		return patientDAO.checkStatusOfPatient(patientId);
	}

    /* (non-Javadoc)
     * @see com.health.care.management.service.PatientService#fetchPastAppointmentDetials(int)
     */
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
            pastAppointmentDetail.setPrescription(a.get("prescription").toString());
            pastAppointmentDetails.add(pastAppointmentDetail);
        });
        return pastAppointmentDetails;
    }



}
