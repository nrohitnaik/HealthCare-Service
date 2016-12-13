package com.health.care.management.dao;

import com.health.care.management.domain.Doctor;

import java.util.List;
import java.util.Map;

public interface DoctorDAO {

    // To register or update doctor info
    int saveDoctorInfo(Doctor doctor);

    // To fetch the details of doctor using user name
    Doctor findDoctorByUserID(int doctorUserId);

    int updateDoctorInfo(Doctor doctor);

    // to fetch all the departments from doctor table
    List<String> findAllDepartment();

    // To get the list of doctor based on department
    List<Map<String, Object>> findDoctorDetailsByDepartment(String deptName);

    // To fetch all the doctor details from db
    List<Map<String, Object>> fetchAllDoctors();

}
