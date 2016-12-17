package com.health.care.management.dao;

import com.health.care.management.domain.Appointment;

import java.util.Date;
import java.util.List;

public interface AppointmentDAO {

    /**
     * @param userId
     * @param date
     * @return List<Date>
     * finds the appointment based on user id and doctor
     */
    List<Date> findAvailableAppointmentForDoctor(int userId, String date);

    /**
     * @param appointment
     * @return int
     * save the appointment
     */
    int saveAppointment(Appointment appointment);

    /**
     * @param patientId
     * @param status
     * @return List<Appointment>
     * fetch the appointments for patient for given patient id based on status
     */
    List<Appointment> fetchAppointmentsByPatientId(int patientId, String status);

    /**
     * @param registartionId
     * @param status
     * @return List<Appointment>
     * fetch the appointments assigned for the doctor based on status
     */
    List<Appointment> fetchAppointmentsByDoctorRegsitartionId(int registartionId, String status);

    /**
     * @param status
     * @param appointmentId
     * @return int
     * updates the status of appointment based on appointment id
     */
    int updateStatusOfAppointment(String status, int appointmentId);
}
