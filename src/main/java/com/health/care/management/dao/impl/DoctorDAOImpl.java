package com.health.care.management.dao.impl;

import static com.health.care.management.constant.Constant.FETCH_DOCTOR_DETAILS_BY_USERNAME;
import static com.health.care.management.constant.Constant.SAVE_DOCTOR;
import static com.health.care.management.constant.Constant.UPDATE_DOCTOR_INFO;

import com.health.care.management.HealthCareServiceConfiguration;
import com.health.care.management.constant.Constant;
import com.health.care.management.dao.DoctorDAO;
import com.health.care.management.domain.Doctor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DoctorDAOImpl implements DoctorDAO {

    private JdbcTemplate jdbcTemplate;

    public DoctorDAOImpl() {
        super();
        this.jdbcTemplate = HealthCareServiceConfiguration.getJdbcConnection();
    }

    @Override
    public int saveDoctorInfo(Doctor doctor) {

        return jdbcTemplate.update(SAVE_DOCTOR,
                new Object[] { doctor.getRegistrationId(), doctor.getFirstName(), doctor.getLastName(), doctor.getSpecialization(), doctor.getDepartment(), doctor.getExperience(),
                        doctor.getQualification(), doctor.getMobileNumber(), doctor.getEmail(), doctor.getWorkingHours(), doctor.isAvailability(), doctor.getUserId() });
    }

    @Override
    public int updateDoctorInfo(Doctor doctor) {
        return jdbcTemplate.update(UPDATE_DOCTOR_INFO,
                new Object[] { doctor.getFirstName(), doctor.getLastName(), doctor.getSpecialization(), doctor.getDepartment(), doctor.getExperience(), doctor.getQualification(),
                        doctor.getMobileNumber(), doctor.getEmail(), doctor.getWorkingHours(), doctor.isAvailability(), doctor.getUserId() });
    }

    @Override
    public Doctor findDoctorByUserID(int doctorUserId) {
        return jdbcTemplate.queryForObject(FETCH_DOCTOR_DETAILS_BY_USERNAME, new Object[] { doctorUserId }, new DoctorRowMapper());
    }

    @Override
    public List<String> findAllDepartment() {
        return jdbcTemplate.queryForList(Constant.FETCH_DEPT_LIST, String.class);
    }



    @Override
    public List<Map<String, Object>> findDoctorDetailsByDepartment(String deptName) {
        return jdbcTemplate.queryForList(Constant.FETCH_DOCT_LIST_BY_DEPT, deptName);
    }


    @Override
    public List<Map<String, Object>> fetchAllDoctors() {
        return jdbcTemplate.queryForList(Constant.FETCH_ALL_DOCTOR);
    }

    // Row mapper for doctor
    private class DoctorRowMapper implements RowMapper<Doctor> {

        @Override
        public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
            Doctor doctor = new Doctor();
            doctor.setRegistrationId(rs.getInt("registration_id"));
            doctor.setFirstName(rs.getString("first_name"));
            doctor.setLastName(rs.getString("last_name"));
            doctor.setSpecialization(rs.getString("specialization"));
            doctor.setDepartment(rs.getString("department"));
            doctor.setExperience(rs.getString("experience"));
            doctor.setQualification(rs.getString("qualification"));
            doctor.setMobileNumber(rs.getLong("mobile_no"));
            doctor.setEmail(rs.getString("email"));
            doctor.setWorkingHours("working_hours");
            doctor.setAvailability(rs.getInt("status"));
            doctor.setUserId(rs.getInt("user_id"));
            return doctor;
        }
    }



}