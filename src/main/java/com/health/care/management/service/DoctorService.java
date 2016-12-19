package com.health.care.management.service;

import com.health.care.management.domain.Doctor;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DoctorService {

    /**
     * @param doctor
     * @return
     */
    int saveDoctorInfo(Doctor doctor);

    /**
     * @param userId
     * @return
     */
    Doctor fetchDoctorByUserId(int userId);

    /**
     * @param doctor
     */
    void updateDoctorInfo(Doctor doctor);

    /**
     * @return
     */
    List<String> getAllDepartment();

    /**
     * @param deptName
     * @return
     */
    List<Map<String, Object>> getDoctorDetails(String deptName);

    /**
     * @param userId
     * @param day
     * @return
     */
    List<Date> findAvailableAppointmentForDoctor(int userId, String day);

    /**
     * @return
     */
    List<Doctor> getAllDoctorDetails();

}
