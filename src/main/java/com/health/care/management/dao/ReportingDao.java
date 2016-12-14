package com.health.care.management.dao;


public interface ReportingDao {

    String generateInventoryReport();

    String generateListOfDoctorReport();

    String generateDetailsOfAllPatient();

    String generateReportOfSinglePatient(int patientId);


}
