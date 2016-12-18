package com.health.care.management.dao;


public interface ReportingDao {

    /**generates inventory report
     * @return
     */
    String generateInventoryReport();

    /**
     * generate list of doctors report
     * @return
     */
    String generateListOfDoctorReport();

    /**
     * generates details of all patient
     * @return
     */
    String generateDetailsOfAllPatient();

    /**
     * generates report for a patient based on id
     * @param patientId
     * @return
     
     */
    String generateReportOfSinglePatient(int patientId);


}
