package com.health.care.management.service.impl;

import com.health.care.management.dao.AppointmentDAO;
import com.health.care.management.dao.DoctorDAO;
import com.health.care.management.dao.impl.AppointmentDAOImpl;
import com.health.care.management.dao.impl.DoctorDAOImpl;
import com.health.care.management.domain.Doctor;
import com.health.care.management.service.DoctorService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DoctorServiceImpl implements DoctorService {

    private DoctorDAO doctorDao;
    private AppointmentDAO appointmentDAO;

    public DoctorServiceImpl() {
        this.doctorDao = new DoctorDAOImpl();
        this.appointmentDAO = new AppointmentDAOImpl();
    }

    /* (non-Javadoc)
     * @see com.health.care.management.service.DoctorService#saveDoctorInfo(com.health.care.management.domain.Doctor)
     */
    @Override
    public int saveDoctorInfo(Doctor doctor) {
        return doctorDao.saveDoctorInfo(doctor);
    }

    /* (non-Javadoc)
     * @see com.health.care.management.service.DoctorService#fetchDoctorByUserId(int)
     */
    @Override
    public Doctor fetchDoctorByUserId(int userId) {
        return doctorDao.findDoctorByUserID(userId);
    }

    /* (non-Javadoc)
     * @see com.health.care.management.service.DoctorService#updateDoctorInfo(com.health.care.management.domain.Doctor)
     */
    @Override
    public void updateDoctorInfo(Doctor doctor) {
        doctorDao.updateDoctorInfo(doctor);
    }

    /* (non-Javadoc)
     * @see com.health.care.management.service.DoctorService#getAllDepartment()
     */
    @Override
    public List<String> getAllDepartment() {
        return doctorDao.findAllDepartment();
    }

    /* (non-Javadoc)
     * @see com.health.care.management.service.DoctorService#getDoctorDetails(java.lang.String)
     */
    @Override
    public List<Map<String, Object>> getDoctorDetails(String deptName) {
        return doctorDao.findDoctorDetailsByDepartment(deptName);
    }

    /* (non-Javadoc)
     * @see com.health.care.management.service.DoctorService#findAvailableAppointmentForDoctor(int, java.lang.String)
     */
    @Override
    public List<Date> findAvailableAppointmentForDoctor(int userId, String day) {
        return appointmentDAO.findAvailableAppointmentForDoctor(userId, day);
    }

    /* (non-Javadoc)
     * @see com.health.care.management.service.DoctorService#getAllDoctorDetails()
     */
    @Override
    public List<Doctor> getAllDoctorDetails() {
        List<Map<String, Object>> doctorsMap = doctorDao.fetchAllDoctors();
        List<Doctor> doctorList = new ArrayList<>();

        doctorsMap.forEach(a -> {
            Doctor aDoctor = new Doctor();
            aDoctor.setFirstName(a.get("first_name").toString());
            aDoctor.setLastName(a.get("last_name").toString());
            aDoctor.setDepartment(a.get("department").toString());
            if (a.get("status").toString().equalsIgnoreCase("true")) {
                aDoctor.setAvailability(1);
            } else {
                aDoctor.setAvailability(0);
            }
            aDoctor.setEmail(a.get("email").toString());
            aDoctor.setPhoneNumber(Long.valueOf(a.get("mobile_no").toString()));
            aDoctor.setRegistrationId(Integer.valueOf(a.get("registration_id").toString()));
            aDoctor.setQualification(a.get("qualification").toString());
            aDoctor.setSpecialization(a.get("specialization").toString());
            doctorList.add(aDoctor);
        });
        return doctorList;
    }

}
