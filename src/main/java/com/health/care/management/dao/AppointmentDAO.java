package com.health.care.management.dao;

import com.health.care.management.domain.Appointment;

import java.util.Date;
import java.util.List;

public interface AppointmentDAO {

	/**
	 * finds the appointment based on user id and doctor
	 * 
	 * @param userId
	 * @param date
	 * @return List<Date>
	 */
	List<Date> findAvailableAppointmentForDoctor(int userId, String date);

	/**
	 * save the appointment
	 * 
	 * @param appointment
	 * @return int
	 */
	int saveAppointment(Appointment appointment);

	/**
	 * fetch the appointments for patient for given patient id based on status
	 * 
	 * @param patientId
	 * @param status
	 * @return List<Appointment>
	 */
	List<Appointment> fetchAppointmentsByPatientId(int patientId, String status);

	/**
	 * fetch the appointments assigned for the doctor based on status
	 * 
	 * @param registartionId
	 * @param status
	 * @return List<Appointment>
	 */
	List<Appointment> fetchAppointmentsByDoctorRegsitartionId(int registartionId, String status);

	/**
	 * updates the status of appointment based on appointment id
	 * 
	 * @param status
	 * @param appointmentId
	 * @return int
	 */
	int updateStatusOfAppointment(String status, int appointmentId);
}
