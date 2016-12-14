package com.health.care.management.constant;

public abstract class Constant {

    // TODO based on the number of the constants let the modularisation be implemented

    // MYSQL config
    public static final String SQL_URL = "sql.datasource.url";
    public static final String SQL_USERNAME = "sql.datasource.username";
    public static final String SQL_PASSWORD = "sql.datasource.password";
    public static final String SQL_DRIVER = "sql.datasource.driver";

    // SQL quires

    // User related queries
    public static final String SAVE_USER = "INSERT INTO user (username, password, role) VALUES(?, ?, ?)";
    public static final String VALIDATE_USER = "select user_id,username,role,password from user where username=?";
    // Patinet related queries
    public static final String FETCH_PATIENT_DETAILS_BY_USERNAME = "SELECT * FROM patient where user_id =?";
    public static final String UPDATE_PATIENT_INFO = "UPDATE patient SET first_name=?, last_name=?,sex=?, date_of_birth=?, address=?, mobile_number=?, alergies=?  WHERE user_id=?";
    public static final String SAVE_PATIENT = "INSERT INTO patient (first_name, last_name, sex, date_of_birth, address, mobile_number, alergies, user_id )  VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    // Doctor related queries
    public static final String SAVE_DOCTOR = "INSERT INTO doctor(registration_id,first_name,last_name,specialization,department,experience,qualification,mobile_no,email,working_hours,status,user_id) VALUES(?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_DOCTOR_INFO = "UPDATE doctor SET first_name=?, last_name=?,specialization=?,department=?,experience=?,qualification=?,mobile_no=?,email=?,working_hours=?,status=?  WHERE user_id=?";
    public static final String FETCH_DOCTOR_DETAILS_BY_USERNAME = "SELECT * FROM doctor where user_id =?";
    public static final String FETCH_DEPT_LIST = "SELECT DISTINCT department FROM doctor";
    public static final String FETCH_ALL_DOCTOR = "SELECT registration_id,first_name,last_name,specialization,department,qualification,mobile_no,email,status  FROM doctor";
    public static final String FETCH_DOCT_LIST_BY_DEPT = "SELECT registration_id,first_name,last_name,user_id FROM doctor WHERE department=?";

    // Apppointment related queries
    public static final String SAVE_APPOINTMENT = "INSERT INTO appointment (date, comment, illness, doctor_registration_id, status, patient_id) VALUES(? ,? ,? ,? ,? ,?)";
    public static final String UPDATE_APPOINTMENT = "Update appointment set status=?  WHERE appointment_id=?";
    public static final String FETCH_TODAYS_TIMESLOT_BY_DOCTOR_REG_ID = "SELECT today FROM timeslot WHERE today NOT IN (SELECT date FROM appointment WHERE doctor_registration_id=?)";
    public static final String FETCH_TOMORROWS_TIMESLOT_BY_DOCTOR_REG_ID = "SELECT tomorrow FROM timeslot WHERE tomorrow NOT IN (SELECT date FROM appointment WHERE doctor_registration_id=?)";
    public static final String FETCH_DAYAFTER_TIMESLOT_BY_DOCTOR_REG_ID = "SELECT dayafter FROM timeslot WHERE dayafter NOT IN (SELECT date FROM appointment WHERE doctor_registration_id=?)";
    public static final String FETCH_APPOINTMENT_BY_PATIENT_ID = "SELECT appointment.appointment_id,appointment.date,appointment.illness,appointment.comment,patient.first_name AS p_first_name,patient.last_name AS p_last_name,patient.alergies,doctor.first_name AS d_first_name,doctor.last_name AS d_last_name FROM appointment INNER JOIN doctor ON appointment.doctor_registration_id=doctor.registration_id INNER JOIN patient on appointment.patient_id=patient.patient_id WHERE (appointment.patient_id=? AND appointment.status=?);";
    public static final String FETCH_APPOINTMENT_BY_DOC_REG_ID = "SELECT appointment.appointment_id,appointment.date,appointment.illness,appointment.comment,patient.first_name AS p_first_name,patient.last_name AS p_last_name,patient.alergies,doctor.first_name AS d_first_name,doctor.last_name AS d_last_name FROM appointment INNER JOIN doctor ON appointment.doctor_registration_id=doctor.registration_id INNER JOIN patient on appointment.patient_id=patient.patient_id WHERE (appointment.doctor_registration_id=? AND appointment.status=?);";

    // Diagnosis related queries
    public static final String SAVE_DIAGNOSIS = "INSERT INTO diagnosis(prescription, admit_date, discharge_date, status,appointment_id) VALUES(?,?,?,?,?)";
    public static final String FETCH_DIAGNOSIED_INFO_BY_STATUS = "SELECT diagnosis.diagnosis_id,diagnosis.prescription,diagnosis.admit_date,diagnosis.discharge_date,diagnosis.status,diagnosis.appointment_id,patient.first_name as p_first_name,patient.last_name as p_last_name,patient.patient_id, patient.sex,doctor.first_name as d_first_name,doctor.last_name as d_last_name,doctor.specialization FROM `hms_db_prod`.`diagnosis` inner join appointment on diagnosis.appointment_id= appointment.appointment_id inner join doctor on appointment.doctor_registration_id=doctor.registration_id inner "
            + "join patient on appointment.patient_id=patient.patient_id where diagnosis.status=?";
    public static final String UPDATE_STATUS_OF_DIAGNOSIS_BY_ID = "UPDATE diagnosis SET status=? where diagnosis_id=?";

    // Inventory related queries
    public static final String FETCH_ALL_INVENTORIES = "SELECT inventory_id, name, description, quantity, price_per_unit, vendor_contact,type FROM inventory";
    public static final String UPDATE_INVENTORY = "UPDATE inventory SET name=?,description=?,quantity=?,price_per_unit=?,vendor_contact=?,type=? WHERE inventory_id=?";
    public static final String SAVE_INVENTORY = "INSERT into inventory (name,description,quantity,price_per_unit,vendor_contact,type) VALUES(?,?,?,?,?,?)";

    // Bill
    public static final String SAVE_BILL = "INSERT into bill(patient_name, doctor_name,amount,status,comment,diagnosis_id,patient_id) values(?,?,?,?,?,?,?)";
    public static final String FETCH_PAST_APPOINTMENTS = "SELECT bill.patient_name,bill.doctor_name,bill.amount,diagnosis."
            + "prescription,appointment.date,appointment.illness from bill inner join diagnosis on bill.diagnosis_id=diagnosis.diagnosis_id inner join appointment on diagnosis.appointment_id=appointment.appointment_id where bill.patient_id=?";

    // Reporting related queries + one is FETCH_ALL_INVENTORTIES
    public static final String LIST_OF_SINGLE_PATIENT_DETAIL = "select patient.patient_id,patient.first_name as p_first_name,patient.last_name as p_last_name,patient.date_of_birth,appointment.illness, doctor.registration_id, doctor.first_name as d_first_name,doctor.last_name as d_last_name,doctor.specialization,doctor.department, doctor.mobile_no,diagnosis.prescription,diagnosis.status from appointment inner join doctor on appointment.doctor_registration_id=doctor.registration_id INNER JOIN patient on appointment.patient_id=patient.patient_id inner join diagnosis on appointment.appointment_id = diagnosis.appointment_id where appointment.patient_id =%s";
    public static final String LIST_OF_ALL_PATIENT = "select patient.patient_id,patient.first_name as p_first_name,patient.last_name as p_last_name,patient.date_of_birth,appointment.illness, doctor.registration_id, doctor.first_name as d_first_name,doctor.last_name as d_last_name,doctor.specialization,doctor.department, doctor.mobile_no,diagnosis.prescription,diagnosis.status from appointment inner join doctor on appointment.doctor_registration_id=doctor.registration_id INNER JOIN patient on appointment.patient_id=patient.patient_id inner join diagnosis on appointment.appointment_id = diagnosis.appointment_id";
    // Application Constants

    // logger Constants
}
