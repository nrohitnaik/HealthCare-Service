package com.health.care.management;

import com.health.care.management.console.helper.DoctorConsoleHelper;
import com.health.care.management.console.helper.InventoryConsoleHelper;
import com.health.care.management.console.helper.PatientConsoleHelper;
import com.health.care.management.console.helper.UserConsoleHelper;
import com.health.care.management.service.DoctorService;
import com.health.care.management.service.PatientService;
import com.health.care.management.service.impl.DoctorServiceImpl;
import com.health.care.management.service.impl.PatientServiceImpl;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class HealthCareServiceApplication {
	private static Logger LOGGER = Logger.getLogger(HealthCareServiceApplication.class);
	private Scanner ioScanner;
	private UserConsoleHelper userConsoleHelper;
	private PatientConsoleHelper patientConsoleHelper;
	private DoctorConsoleHelper doctorConsoleHelper;
	private InventoryConsoleHelper inventoryConsoleHelper;
	private PatientService patientService;
	private DoctorService doctorService;

	private static HealthCareServiceApplication instance = null;

	/**
	 * @return HealthCareServiceApplication returns the singleton object of this
	 *         class
	 */
	public static HealthCareServiceApplication getnstance() {
		if (null == instance) {
			instance = new HealthCareServiceApplication();
		}
		return instance;
	}

	// Constructor for initialization

	/**
	 * Default constructor used to initialize the variables
	 */
	private HealthCareServiceApplication() {
		this.ioScanner = new Scanner(System.in);
		this.userConsoleHelper = new UserConsoleHelper();
		this.patientConsoleHelper = new PatientConsoleHelper();
		this.doctorConsoleHelper = new DoctorConsoleHelper();
		this.inventoryConsoleHelper = new InventoryConsoleHelper();
		this.patientService = new PatientServiceImpl();
		this.doctorService = new DoctorServiceImpl();
	}

	/**
	 * @return the patientConsoleHelper
	 */

	public PatientConsoleHelper getPatientConsoleHelper() {
		return this.patientConsoleHelper;
	}

	/**
	 * @return the ioScanner
	 */
	public Scanner getIoScanner() {
		return this.ioScanner;
	}

	public UserConsoleHelper getUserConsoleHelper() {
		return this.userConsoleHelper;
	}

	/**
	 * @return the doctorConsoleHelper
	 */
	public DoctorConsoleHelper getDoctorConsoleHelper() {
		return this.doctorConsoleHelper;
	}

	public InventoryConsoleHelper getInventoryConsolehelper() {
		return this.inventoryConsoleHelper;
	}

	/**
	 * @return the patientService
	 */
	public PatientService getPatientService() {
		return this.patientService;
	}

	/**
	 * @return the doctorService
	 */
	public DoctorService getDoctorService() {
		return this.doctorService;
	}

	/**
	 * @param doctorService
	 *            the doctorService to set
	 */
	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	/**
	 * @param args
	 * Entry point of the application
	 */
	public static void main(String[] args) {
		LOGGER.info("Application is starting up...");
		HealthCareServiceApplication appInitializer = HealthCareServiceApplication.getnstance();
		System.out.println("Hello, Welcome to Health Care Service");
		appInitializer.getUserConsoleHelper().kickStartApplication();

	}

}