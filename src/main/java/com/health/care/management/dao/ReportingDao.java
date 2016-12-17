package com.health.care.management.dao;


public interface ReportingDao {

    /**
     * @return
     * generates inventory report
     */
    String generateInventoryReport();

    /**
     * @return
     * generate list of doctors report
     */
    String generateListOfDoctorReport();

    /**
     * @return
     * generates details of all patient
     */
    String generateDetailsOfAllPatient();

    /**
     * @param patientId
     * @return
     * generates report for a patient based on id
     */
    String generateReportOfSinglePatient(int patientId);


}
