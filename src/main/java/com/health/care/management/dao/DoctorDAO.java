package com.health.care.management.dao;

import com.health.care.management.domain.Doctor;

import java.util.List;
import java.util.Map;

public interface DoctorDAO {

	/**
	 * To save doctor info
	 * 
	 * @param doctor
	 * @return
	 */
	int saveDoctorInfo(Doctor doctor);

	/**
	 * To fetch the details of doctor using user name
	 * 
	 * @param doctorUserId
	 * @return
	 */
	Doctor findDoctorByUserID(int doctorUserId);

	/**
	 * Updates the doctor info
	 * 
	 * @param doctor
	 * @return
	 */
	int updateDoctorInfo(Doctor doctor);

	/**
	 * to fetch all the departments from doctor table
	 * 
	 * @return List<String>
	 */
	List<String> findAllDepartment();

	/**
	 * to fetch all the departments from doctor table
	 * 
	 * @param deptName
	 * @return List<Map<String, Object>>
	 */
	List<Map<String, Object>> findDoctorDetailsByDepartment(String deptName);

	/**
	 * To fetch all the doctor details from db
	 * 
	 * @return List<Map<String, Object>>
	 */
	List<Map<String, Object>> fetchAllDoctors();

}
