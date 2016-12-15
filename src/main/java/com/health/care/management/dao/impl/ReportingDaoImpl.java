package com.health.care.management.dao.impl;

import com.health.care.management.HealthCareServiceConfiguration;
import com.health.care.management.constant.Constant;
import com.health.care.management.dao.ReportingDao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.jdbc.datasource.DataSourceUtils;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

public class ReportingDaoImpl implements ReportingDao {


    @Override
    public String generateInventoryReport() {
        JasperReportBuilder report = DynamicReports.report();
        String inventoryFilePath = "f:/inventory_report.pdf";
        report.columns(Columns.column("Inventory Id", "inventory_id", DataTypes.integerType()), 
                Columns.column("Inventory Name", "name", DataTypes.stringType()),
                Columns.column("Description", "description", DataTypes.stringType()),
                Columns.column("quantity", "quantity", DataTypes.integerType()),
                Columns.column("Price per Unit", "price_per_unit", DataTypes.doubleType()), 
                Columns.column("Vendor Contact Info", "vendor_contact", DataTypes.stringType()),
                Columns.column("Type of Inventory", "type", DataTypes.stringType()))
                .title(Components.text("Inventory List").setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())
                .setDataSource(Constant.FETCH_ALL_INVENTORIES, DataSourceUtils.getConnection(HealthCareServiceConfiguration.getJdbcConnection().getDataSource()));

        return generateReport(report, inventoryFilePath);
    }

    @Override
    public String generateListOfDoctorReport() {
        JasperReportBuilder report = DynamicReports.report();
        String listOfAllDoctorFilePath = "f:/listOfAllDoctor_report.pdf";
        report.columns(Columns.column("Registration Id", "registration_id", DataTypes.integerType()), 
                Columns.column("First Name", "first_name", DataTypes.stringType()),
                Columns.column("Last Name", "last_name", DataTypes.stringType()),
                Columns.column("Specialization", "specialization", DataTypes.stringType()),
                Columns.column("Department", "department", DataTypes.stringType()),
                Columns.column("Qualification", "qualification", DataTypes.stringType()),
                Columns.column("Mobile Number", "mobile_no", DataTypes.bigDecimalType()),
                Columns.column("Email", "email", DataTypes.stringType()),
                Columns.column("Status(1= available,0=unavailable)", "status", DataTypes.stringType()))
                .title(Components.text("List of all the doctors").setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())
                .setDataSource(Constant.FETCH_ALL_DOCTOR, DataSourceUtils.getConnection(HealthCareServiceConfiguration.getJdbcConnection().getDataSource()));
        return generateReport(report, listOfAllDoctorFilePath);
    }




    @Override
    public String generateDetailsOfAllPatient() {
        JasperReportBuilder report = DynamicReports.report();
        String listOfAllPatientFilePath = "f:/listOfAllPatient_report.pdf";
        report.columns(Columns.column("Patient Id", "patient_id", DataTypes.integerType()),
                Columns.column("Patient First Name", "p_first_name", DataTypes.stringType()),
                Columns.column("Patient Last Name", "p_last_name", DataTypes.stringType()),
                Columns.column("Patient Date of Birth", "date_of_birth", DataTypes.dateType()),
                Columns.column("Patient mentioned Illness", "illness", DataTypes.stringType()),
                Columns.column(" Doctor Registration Id", "registration_id", DataTypes.integerType()),
                Columns.column("Doctor First Name", "d_first_name", DataTypes.stringType()), 
                Columns.column("Doctor Last Name", "d_last_name", DataTypes.stringType()),
                Columns.column("Doctor Specialization", "specialization", DataTypes.stringType()),
                Columns.column("Department", "department", DataTypes.stringType()),
                Columns.column("Mobile Number", "mobile_no", DataTypes.bigDecimalType()),
                Columns.column("Doctor Treatment prescription", "prescription", DataTypes.stringType()), Columns.column("Diagnosis Status", "status", DataTypes.stringType()))
                .title(Components.text("List of all the Patients treated").setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())
                .setDataSource(Constant.LIST_OF_ALL_PATIENT, DataSourceUtils.getConnection(HealthCareServiceConfiguration.getJdbcConnection().getDataSource()));

        return generateReport(report, listOfAllPatientFilePath);

    }

    @Override
    public String generateReportOfSinglePatient(int patientId) {
        JasperReportBuilder report = DynamicReports.report();
        String detailsOfSinglePatientFilePath = "f:/" + patientId + "patientDetailsById_report.pdf";
        report.columns(Columns.column("Patient Id", "patient_id", DataTypes.integerType()),
                Columns.column("Patient First Name", "p_first_name", DataTypes.stringType()),
                Columns.column("Patient Last Name", "p_last_name", DataTypes.stringType()),
                Columns.column("Patient Date of Birth", "date_of_birth", DataTypes.dateType()),
                Columns.column("Patient mentioned Illness", "illness", DataTypes.stringType()),
                Columns.column(" Doctor Registration Id", "registration_id", DataTypes.integerType()),
                Columns.column("Doctor First Name", "d_first_name", DataTypes.stringType()),
                Columns.column("Doctor Last Name", "d_last_name", DataTypes.stringType()), 
                Columns.column("Doctor Specialization", "specialization", DataTypes.stringType()),
                Columns.column("Department", "department", DataTypes.stringType()),
                Columns.column("Mobile Number", "mobile_no", DataTypes.bigDecimalType()),
                Columns.column("Doctor Treatment prescription", "prescription", DataTypes.stringType()), 
                Columns.column("Diagnosis Status", "status", DataTypes.stringType()))
                .title(// title of the report
                        Components.text("List of all the Patients treated").setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())// show page number on the page footer
                .setDataSource(getQueryForPatient(patientId), DataSourceUtils.getConnection(HealthCareServiceConfiguration.getJdbcConnection().getDataSource()));
        return generateReport(report, detailsOfSinglePatientFilePath);
    }

    private String generateReport(JasperReportBuilder reportObject, String filePath) {
        try {
            // show the report
            reportObject.show();
            // export the report to a pdf file
            reportObject.toPdf(new FileOutputStream(filePath));
        } catch (DRException e) {
            System.out.println("Exception occured due to" + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Exception occured due to" + e.getMessage());
        }
        return filePath;
    }

    private String getQueryForPatient(int PatientId) {
        String getPatientDetailsById = String.format(Constant.LIST_OF_SINGLE_PATIENT_DETAIL, PatientId);
        return getPatientDetailsById;
    }
}
