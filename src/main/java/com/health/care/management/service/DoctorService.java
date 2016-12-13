package com.health.care.management.service;

import com.health.care.management.domain.Doctor;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DoctorService {

    // add or update doctor
    int saveDoctorInfo(Doctor doctor);

    Doctor fetchDoctorByUserId(int userId);

    void updateDoctorInfo(Doctor doctor);

    List<String> getAllDepartment();

    List<Map<String, Object>> getDoctorDetails(String deptName);

    List<Date> findAvailableAppointmentForDoctor(int userId, String day);

    List<Doctor> getAllDoctorDetails();

}
