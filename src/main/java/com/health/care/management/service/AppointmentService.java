package com.health.care.management.service;

import com.health.care.management.domain.Appointment;

import java.util.List;

public interface AppointmentService {


    int saveAppointment(Appointment appointment);

    List<Appointment> fetchAppointments(int userId, String status, String role);

    int updateStatusOfDiagnosiedAppointment(String status, int appointmentId);

}
