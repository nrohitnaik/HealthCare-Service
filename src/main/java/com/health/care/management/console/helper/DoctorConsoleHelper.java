package com.health.care.management.console.helper;

import com.health.care.management.HealthCareServiceApplication;
import com.health.care.management.domain.Appointment;
import com.health.care.management.domain.Diagnosis;
import com.health.care.management.domain.Doctor;
import com.health.care.management.service.AppointmentService;
import com.health.care.management.service.DiagnosisService;
import com.health.care.management.service.DoctorService;
import com.health.care.management.service.impl.AppointmentServiceImpl;
import com.health.care.management.service.impl.DiagnosisServiceImpl;
import com.health.care.management.service.impl.DoctorServiceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;


public class DoctorConsoleHelper {
	private static final Logger LOGGER = Logger.getLogger(DoctorConsoleHelper.class);

	private DoctorService doctorService;
	private AppointmentService appointmentService;
	private DiagnosisService diagnosisService;
	private Scanner doctorScanner;
	private String userNameofDoctor;

	public DoctorConsoleHelper() {
		this.doctorService = new DoctorServiceImpl();
		this.doctorScanner = new Scanner(System.in);
		this.appointmentService = new AppointmentServiceImpl();
		this.diagnosisService = new DiagnosisServiceImpl();
		LOGGER.debug("Doctor Console helper object has been created");
	}

	/**
	 * This provides form for doctor to sign up by taking all the input from the console
	 * @param userName
	 * @param userId
	 *            
	 */
	void signupAsDoctor(String userName, int userId) {
		Doctor newDoctor = new Doctor();
		System.out.println("Enter the first name");
		newDoctor.setFirstName(doctorScanner.nextLine());
		System.out.println("Enter the last name");
		newDoctor.setLastName(doctorScanner.nextLine());
		System.out.println("Enter Doctor registration number");
		newDoctor.setRegistrationId(doctorScanner.nextInt());
		doctorScanner.nextLine();
		System.out.println("Provide the qualification");
		newDoctor.setQualification(doctorScanner.nextLine());
		System.out.println("Specify your specialization");
		newDoctor.setSpecialization(doctorScanner.nextLine());
		System.out.println("Select the department");
		newDoctor.setDepartment(doctorScanner.nextLine());
		System.out.println("Brief description about work experience");
		newDoctor.setExperience(doctorScanner.nextLine());
		System.out.println("Enter the mobile number ");
		newDoctor.setPhoneNumber(doctorScanner.nextLong());
		doctorScanner.nextLine();
		System.out.println("Enter the email");
		newDoctor.setEmail(doctorScanner.nextLine());
		System.out.println("Enter the desired working hours");
		newDoctor.setWorkingHours(doctorScanner.nextLine());
		System.out.println("Please provide the availability");
		System.out.println("Enter '1' to mark available");
		System.out.println("Enter '0' to mark unavailable");
		newDoctor.setAvailability(doctorScanner.nextInt());
		doctorScanner.nextLine();
		newDoctor.setUserId(userId);
		LOGGER.info("Signing up doctor " + newDoctor.toString());
		int rowAffected = doctorService.saveDoctorInfo(newDoctor);
		if (0 != rowAffected) {
			LOGGER.info("Doctor "+newDoctor.getFirstName() + " has been successfully registered ");
			validatedDoctorMenu(userName, userId, newDoctor.getRegistrationId());
		} else {
			LOGGER.error("Error occure in signing up doctor. Presenting the signup form again");
			System.out.println("Internal error occured..please try again");
			signupAsDoctor(userName, userId);
		}
	}

	/**
	 * @param userName
	 * @param userId
	 * @param registrationId
	 *            Provides menu for the validated doctor
	 */
	void validatedDoctorMenu(String userName, int userId, int registrationId) {
		LOGGER.debug("Entering doctor validation menu for username " + userName );
		System.out.println("Hi Doc " + userName + ", please choose the following option");
		System.out.println("Select '1' to update personal details.");
		System.out.println("Select '2' to view apppointments.");
		System.out.println("Slect '0' to logout");
		int selectedValue = doctorScanner.nextInt();
		userNameofDoctor = userName;
		LOGGER.info("selected input by doctor " + userName + " is " + selectedValue);
		switch (selectedValue) {
		
		case 0: {
			HealthCareServiceApplication.getnstance().getUserConsoleHelper().kickStartApplication();

		}
		case 1: {
			System.out.println("Welcome to personal info page.");
			populateExistingDetails(doctorService.fetchDoctorByUserId(userId), userId, registrationId);

		}
		case 2: {
			System.out.println("Welcome to view appointment service");
			viewAppointmentlist(userName, registrationId);
			validatedDoctorMenu(userName, userId, registrationId);
		}

		default: {
			System.out.println("Invalid option selected, please selecte the right one");
			LOGGER.warn(userName +" entered invalid input");
			validatedDoctorMenu(userName, userId, registrationId);
		}
		}

	}

	/**
	 * @param doctor
	 * @param userId
	 * @param registrationId
	 *            Used to populate the existing details returned from database
	 *            on the console
	 *            case '1' if doctor choose to update the info
	 */
	private void populateExistingDetails(Doctor doctor, int userId, int registrationId) {
		System.out.println("Please choose an option to edit and '0' to complete updating");
		System.out.println(doctor.toString());
		LOGGER.debug("populating the user info for user id "+ userId + doctor.toString());
		switchOption(doctor, userId, registrationId);

	}

	/**
	 * @param doctor
	 * @param userId
	 * @param registrationId
	 *            Take the input from the console and performes the intended
	 *            opertaion
	 */
	private void switchOption(Doctor doctor, int userId, int registrationId) {
		int selectedOption = doctorScanner.nextInt();
		LOGGER.info(doctor.getFirstName() +" seleced the value " + selectedOption);
		doctorScanner.nextLine();
		switch (selectedOption) {
		case (1): {
			System.out.println("Enter the new first name. Existing is " + doctor.getFirstName());
			String updatedFirstName = doctorScanner.nextLine();
			if (null != updatedFirstName) {
				doctor.setFirstName(updatedFirstName);
			}
			break;
		}
		case (2): {
			System.out.println("Enter the new last name.. Existing is " + doctor.getLastName());
			String updatedLastName = doctorScanner.nextLine();
			if (null != updatedLastName) {
				doctor.setLastName(updatedLastName);
			}
			break;
		}
		case (3): {
			System.out.println("Enter the specialization.. Existing is  " + doctor.getSpecialization());
			String updatedSpecialization = doctorScanner.nextLine();
			if (null != updatedSpecialization) {
				doctor.setSpecialization(updatedSpecialization);
			}
			break;
		}
		case (4): {
			System.out.println("Enter the department.. Existing is " + doctor.getDepartment());
			String updatedDepartment = doctorScanner.nextLine();
			if (null != updatedDepartment) {
				doctor.setDepartment(updatedDepartment);
			}
			break;
		}
		case (5): {
			System.out.println("Enter the mobile number.. Existing is " + doctor.getPhoneNumber());
			long updatedMobileNumber = doctorScanner.nextLong();
			if (0 != updatedMobileNumber) {
				doctor.setPhoneNumber(updatedMobileNumber);
			}
			break;
		}
		case (6): {
			System.out.println("Enter the qualification.. Existing is " + doctor.getQualification());
			String updatedQualification = doctorScanner.nextLine();
			if (null != updatedQualification) {
				doctor.setQualification(updatedQualification);
			}
			break;
		}
		case (7): {
			System.out.println("Enter the working hours.. Existing is " + doctor.getQualification());
			String updatedWorkingHours = doctorScanner.nextLine();
			if (null != updatedWorkingHours) {
				doctor.setWorkingHours(updatedWorkingHours);
			}
			break;
		}
		case (8): {
			System.out.println("Enter the email.. Existing is " + doctor.getEmail());
			String updatedEmail = doctorScanner.nextLine();
			if (null != updatedEmail) {
				doctor.setEmail(updatedEmail);
			}
			break;
		}
		case (9): {
			System.out.println("Enter the experience.. Existing is " + doctor.getExperience());
			String updatedExperience = doctorScanner.nextLine();
			if (null != updatedExperience) {
				doctor.setExperience(updatedExperience);
			}
			break;
		}
		case (10): {
			System.out.println("Enter the availability \n'1' for available \n'0 for unavailable'.. Existing is "
					+ doctor.isAvailability());
			int updatedAvailability = doctorScanner.nextInt();
			doctor.setAvailability(updatedAvailability);
			break;
		}
		default: {
			System.out.println("Invalid Selection . please select appropriate value");
			switchOption(doctor, userId, registrationId);
		}
		}
		System.out.println(
				"Would you like to update any other details?  \nSelect '1' to edit any other details.\nSelect '0' to save edited details");
		int toEdit = doctorScanner.nextInt();
		if (1 == toEdit) {
			System.out.println("Select 1-10 from above list to edit the respective feild");
			switchOption(doctor, userId, registrationId);
		} else {
			updateDoctor(doctor, userId, registrationId);
		}
	}

	/**
	 * @param doctor
	 * @param userId
	 * @param registraionId
	 * This will update the doctor info
	 */
	private void updateDoctor(Doctor doctor, int userId, int registraionId) {
		doctorService.updateDoctorInfo(doctor);
		LOGGER.info(userId + " Details for "+doctor.getFirstName() + " has been saved successfully");
		System.out.println(
				doctor.getFirstName() + " details updated sccuessfully. Press any key to return to previous menu");
		doctorScanner.nextLine();
		doctorScanner.nextLine();// gentle pause
		validatedDoctorMenu(userNameofDoctor, userId, registraionId);
	}
 
	
	/**
	 * @param userName
	 * @param userId
	 * case '2' if doctor choose to view his appointment
	 * This will list all the appointments associated to the doctor
	 */
	private void viewAppointmentlist(String userName, int userId) {
		System.out.println("Appointment Id\t Date&Time\t patient name\t comment\t  illness\t alergies");
		List<Appointment> appointmentlist = appointmentService.fetchAppointments(userId, "booked", "doctor");
		appointmentlist.forEach(a -> {
			LOGGER.debug("Appointment details for doctor id" + userId +" are as follows" + a.toStringForDoctor());
			System.out.println(a.toStringForDoctor());
		});
		System.out.println("Select the appointment id to treat the patient ");
		int selectedAppointmentId = doctorScanner.nextInt();

		treatmeantForm(userName, selectedAppointmentId);

	}

	/**
	 * @param doctorUserName
	 * @param appointmentId
	 * Provides the form for the doctor to add diagnosis info for the 
	 */
	private void treatmeantForm(String doctorUserName, int appointmentId) {
		LOGGER.debug("Entering treatment doctor id=" + doctorUserName + " appointment id is "+ appointmentId);
		doctorScanner.nextLine();
		System.out.println("Welcome to treatment service");
		System.out.println("Enter the prescription details");
		String prescription = doctorScanner.nextLine();
		System.out.println("Should the patient be admitted \nSelect '1' to admit \n Select '2' Not to admit");
		int selectedAdmitedValue = doctorScanner.nextInt();
		LOGGER.debug("Doctor selected value is " + selectedAdmitedValue);
		doctorScanner.hasNextLine();
		int noOfDaysToBeAdmitted = 0;
		Date admitDate = null;
		Date dischargeDate = null;
		String status = "treated";
		if (1 == selectedAdmitedValue) {
			System.out.println("Enter the number of days to be admitted");
			noOfDaysToBeAdmitted = doctorScanner.nextInt();
			admitDate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(admitDate);
			c.add(Calendar.DATE, noOfDaysToBeAdmitted);
			dischargeDate = c.getTime();
			status = "admitted";
		}
		Diagnosis diagnosis = new Diagnosis(prescription, admitDate, dischargeDate, status, appointmentId);

		int rowsAffected = diagnosisService.saveDiagnosisDetails(diagnosis);
		if (0 != rowsAffected) {
			LOGGER.info("Diagnosis details has been successfully saved by doctor "+ doctorUserName +" for appointment id "+ appointmentId);
			appointmentService.updateStatusOfDiagnosiedAppointment(status, appointmentId);
		}
	}
}
