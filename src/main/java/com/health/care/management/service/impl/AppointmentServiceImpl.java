package com.health.care.management.service.impl;

import com.health.care.management.dao.AppointmentDAO;
import com.health.care.management.dao.impl.AppointmentDAOImpl;
import com.health.care.management.domain.Appointment;
import com.health.care.management.service.AppointmentService;

import java.util.List;


public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentDAO appointmentDAO;

    public AppointmentServiceImpl() {
        this.appointmentDAO = new AppointmentDAOImpl();
    }

    @Override
    public List<Appointment> fetchAppointmentbyID(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int saveAppointment(Appointment appointment) {
        return appointmentDAO.saveAppointment(appointment);
    }

    @Override
    public List<Appointment> fetchAppointments(int userId, String status, String role) {
        List<Appointment> appointments = null;
        if (role.equalsIgnoreCase("patient")) {
            appointments = appointmentDAO.fetchAppointmentsByPatientId(userId, status);
        } else if (role.equalsIgnoreCase("doctor")) {
            appointments = appointmentDAO.fetchAppointmentsByDoctorRegsitartionId(userId, status);
        }
        return appointments;
    }

    @Override
    public int updateStatusOfDiagnosiedAppointment(String status, int appointmentId) {
        appointmentDAO.updateStatusOfAppointment(status, appointmentId);
        return 0;
    }

}
