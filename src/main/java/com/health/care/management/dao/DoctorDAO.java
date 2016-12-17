package com.health.care.management.dao;

import com.health.care.management.domain.Doctor;

import java.util.List;
import java.util.Map;

public interface DoctorDAO {

	/**
	 * @param doctor
	 * @return To save doctor info
	 */
	int saveDoctorInfo(Doctor doctor);

	/**
	 * @param doctorUserId
	 * @return 
	 * To fetch the details of doctor using user name
	 */
	Doctor findDoctorByUserID(int doctorUserId);

	/**
	 * @param doctor
	 * @return 
	 * Updates the doctor info
	 */
	int updateDoctorInfo(Doctor doctor);

	/**
	 * @return List<String> 
	 * to fetch all the departments from doctor table
	 */
	List<String> findAllDepartment();

	/**
	 * @param deptName
	 * @return List<Map<String, Object>> 
	 * To get the list of doctor based on department
	 */
	List<Map<String, Object>> findDoctorDetailsByDepartment(String deptName);

	/**
	 * @return List<Map<String, Object>> 
	 * To fetch all the doctor details from db
	 */
	List<Map<String, Object>> fetchAllDoctors();

}
