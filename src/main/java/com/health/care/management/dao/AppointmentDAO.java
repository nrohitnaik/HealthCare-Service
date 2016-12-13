package com.health.care.management.dao;

import com.health.care.management.domain.Appointment;

import java.util.Date;
import java.util.List;

public interface AppointmentDAO {

    List<Date> findAvailableAppointmentForDoctor(int userId, String date);

    int saveAppointment(Appointment appointment);

    List<Appointment> fetchAppointmentsByPatientId(int patientId, String status);

    List<Appointment> fetchAppointmentsByDoctorRegsitartionId(int registartionId, String status);

    int updateStatusOfAppointment(String status, int appointmentId);
}
