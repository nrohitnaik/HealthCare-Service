package com.health.care.management.dao.impl;

import com.health.care.management.HealthCareServiceConfiguration;
import com.health.care.management.constant.Constant;
import com.health.care.management.dao.AppointmentDAO;
import com.health.care.management.domain.Appointment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class AppointmentDAOImpl implements AppointmentDAO {

    private JdbcTemplate jdbcTemplate;

    public AppointmentDAOImpl() {
        super();
        this.jdbcTemplate = HealthCareServiceConfiguration.getJdbcConnection();
    }

    @Override
    public List<Date> findAvailableAppointmentForDoctor(int userId, String date) {
        List<Date> returnValue = null;
        switch (date) {

        case ("today"): {
            returnValue = jdbcTemplate.queryForList(Constant.FETCH_TODAYS_TIMESLOT_BY_DOCTOR_REG_ID, new Object[] { userId }, Date.class);
            break;
        }
        case ("tomorrow"): {
            returnValue = jdbcTemplate.queryForList(Constant.FETCH_TOMORROWS_TIMESLOT_BY_DOCTOR_REG_ID, new Object[] { userId }, Date.class);
            break;
        }
        case ("dayafter"): {
            returnValue = jdbcTemplate.queryForList(Constant.FETCH_DAYAFTER_TIMESLOT_BY_DOCTOR_REG_ID, new Object[] { userId }, Date.class);
            break;
        }
        }
        return returnValue;
    }

    @Override
    public int saveAppointment(Appointment appointment) {
        return jdbcTemplate.update(Constant.SAVE_APPOINTMENT, appointment.getTimeSlot(), appointment.getComment(), appointment.getIllness(), appointment.getDoctorUserId(),
                appointment.getStatus(), appointment.getPatientUserId());
    }

    @Override
    public List<Appointment> fetchAppointmentsByPatientId(int patientId, String status) {
        return jdbcTemplate.query(Constant.FETCH_APPOINTMENT_BY_PATIENT_ID, new Object[] { patientId, status }, new AppointmentRowMapper());

    }

    @Override
    public List<Appointment> fetchAppointmentsByDoctorRegsitartionId(int registartionId, String status) {
        return jdbcTemplate.query(Constant.FETCH_APPOINTMENT_BY_DOC_REG_ID, new Object[] { registartionId, status }, new AppointmentRowMapper());

    }

    @Override
    public int updateStatusOfAppointment(String status, int appointmentId) {
        return jdbcTemplate.update(Constant.UPDATE_APPOINTMENT, new Object[] { status, appointmentId });
    }

    private class AppointmentRowMapper implements RowMapper<Appointment> {

        @Override
        public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
            Appointment appointment = new Appointment();
            appointment.setAppointmentId(rs.getInt("appointment_id"));
            appointment.setComment(rs.getString("comment"));
            appointment.setDoctorName(rs.getString("d_first_name") + " " + rs.getString("d_last_name"));
            appointment.setIllness(rs.getString("illness"));
            appointment.setPatientName(rs.getString("p_first_name") + " " + rs.getString("p_last_name"));
            appointment.setTimeSlot(rs.getTimestamp("date"));
            appointment.setAlergies(rs.getString("alergies"));
            return appointment;
        }

    }

}
