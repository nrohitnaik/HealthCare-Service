package com.health.care.management.service;

import com.health.care.management.domain.Appointment;

import java.util.List;

public interface AppointmentService {


    /**
     * @param appointment
     * @return
     */
    int saveAppointment(Appointment appointment);

    /**
     * @param userId
     * @param status
     * @param role
     * @return
     */
    List<Appointment> fetchAppointments(int userId, String status, String role);

    /**
     * @param status
     * @param appointmentId
     * @return
     */
    int updateStatusOfDiagnosiedAppointment(String status, int appointmentId);

}
