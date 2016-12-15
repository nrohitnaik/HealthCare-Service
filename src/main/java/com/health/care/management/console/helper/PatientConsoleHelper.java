package com.health.care.management.console.helper;

import com.health.care.management.HealthCareServiceApplication;
import com.health.care.management.domain.Appointment;
import com.health.care.management.domain.PastAppointmentDetails;
import com.health.care.management.domain.Patient;
import com.health.care.management.service.AppointmentService;
import com.health.care.management.service.DoctorService;
import com.health.care.management.service.PatientService;
import com.health.care.management.service.impl.AppointmentServiceImpl;
import com.health.care.management.service.impl.DoctorServiceImpl;
import com.health.care.management.service.impl.PatientServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.dao.EmptyResultDataAccessException;

public class PatientConsoleHelper {

    private Scanner patientScanner;
    private PatientService patientService;
    private DoctorService doctorService;
    private AppointmentService appointmentService;

    public PatientConsoleHelper() {
        this.patientScanner = new Scanner(System.in);
        this.patientService = new PatientServiceImpl();
        this.doctorService = new DoctorServiceImpl();
        this.appointmentService = new AppointmentServiceImpl();
    }

    // provides form to register as patient
    @SuppressWarnings("deprecation")
    public void signUpAspatient(String userName, int userId) {
        patientScanner.nextLine();
        Patient newPatient = new Patient();
        System.out.println("Enter the first name");
        newPatient.setFirstName(patientScanner.nextLine());
        System.out.println("Enter the last name");
        newPatient.setLastName(patientScanner.nextLine());
        System.out.println("Enter the Date of Birth in format YYYY/MM/DD");
        newPatient.setDob(new Date(patientScanner.nextLine()));
        System.out.println("Select '0' for female");
        System.out.println("Select sex '1' for male");
        newPatient.setSex(patientScanner.nextInt());
        patientScanner.nextLine();
        System.out.println("Enter the address in a single line");
        newPatient.setAddress(patientScanner.nextLine());
        System.out.println("Enter the phone number without nation code");
        newPatient.setPhoneNumber(patientScanner.nextLong());
        patientScanner.nextLine();
        System.out.println("Enter the alergies with comma seperated values");
        newPatient.setAlergies(patientScanner.nextLine());
        newPatient.setUserId(userId);

        int patientId = patientService.savePatientInfo(newPatient);
        if (0 != patientId) {
            // Call patient menu
            System.out.println("Hi " + newPatient.getFirstName() + ", details have been saved press any key to return to main menu");
            patientScanner.nextLine();// swallow the key pressed
            validatedPatientMenu(userName, patientId, userId);
        } else {
            System.out.println("Internal error occured. Please update the info again");
            signUpAspatient(userName, userId);
            // if it fails again need to provide option to logout
        }

    }

    // Form to provide patient with option
     void validatedPatientMenu(String userName, int patientId, int userId) {
        System.out.println("Hi " + userName + " ,please choose the following option");
        System.out.println("Select '1' to update personal details.");
        System.out.println("Select '2' for booking apppointment.");
        System.out.println("Select '3' for viewing the appointment history");
        System.out.println("Select '4' for viewing the future appointments");
        System.out.println("Select '0' to logout");
        int selectedValue = patientScanner.nextInt();

        switch (selectedValue) {
        case 0: {
            HealthCareServiceApplication.getnstance().getUserConsoleHelper().kickStartApplication();
        }

        case 1: {
            System.out.println("Welcome to personal info page.");

            String message = getPatientUpdatePage(userName, patientId, userId); // for updating the patient personal details
            System.out.println(message);
            System.out.println("press anykey to return to previous menu");
            patientScanner.nextLine(); // swallow the value, just a pause n forcing user to select back option
            validatedPatientMenu(userName, patientId, userId);// Provide the menu again in order not to break the app
        }
        case 2: {
            System.out.println("Welcome to appointment booking service");

            captureBookingInfo(userName, patientId);// call booking capture menu
            System.out.println("Appointment has been saved successfully. Press any key to go back to previous menu");
            patientScanner.nextLine();// swallow any key and provide the main menu for patient.
            validatedPatientMenu(userName, patientId, userId);// Provide the menu again in order not to break the app

        }
        case 3: {
            System.out.println("Welcome to view appointment history page");
            patientFutureAppointment(patientId);// fetch details of future appointment
            System.out.println("Press any key to go back to previous menu");
            patientScanner.nextLine();// swallow any key and provide the main menu for patient.
            patientScanner.nextLine();
            validatedPatientMenu(userName, patientId, userId);// Provide the menu again in order not to break the app
        }

        case 4: {
            System.out.println("Welcome to view future appointments page");
            patientPastAppointment(patientId);// fetch details of past appointment
            System.out.println("Press any key to go back to previous menu");
            patientScanner.nextLine();// swallow any key and provide the main menu for patient.
            validatedPatientMenu(userName, patientId, userId);// Provide the menu again in order not to break the app
        }

        default: {
            System.out.println("Invalid selection.. please select the proper value");
            validatedPatientMenu(userName, patientId, userId);// Provide the menu again in order not to break the app
        }
        }

    }

    private void populateExistingDetails(Patient patient, String patientUserName) {
        System.out.println("Please choose an option to edit and '0' to complete updating");
        // poviding existing details to console using toString defined in Patient.java
        System.out.println(patient.toString());
        switchOption(patient, patientUserName);
    }

    private void switchOption(Patient patient, String patientUserName) {
        int selectedOption = patientScanner.nextInt();
        patientScanner.nextLine();
        switch (selectedOption) {

        case (1): {
            System.out.println("Enter the new first name. Existing is " + patient.getFirstName());
            String updatedFirstName = patientScanner.nextLine();
            if (!updatedFirstName.isEmpty()) {
                patient.setFirstName(updatedFirstName);
            }
            break;
        }
        case (2): {
            System.out.println("Enter the new last name.. Existing is " + patient.getLastName());
            String updatedLastName = patientScanner.nextLine();
            if (!updatedLastName.isEmpty()) {
                patient.setLastName(updatedLastName);
            }
            break;
        }
        case (3): {
            System.out.println("Enter the new address in single line .. Existing address is " + patient.getAddress());
            String updatedAddress = patientScanner.nextLine();
            if (!updatedAddress.isEmpty()) {
                patient.setAddress(updatedAddress);
            }
            break;
        }
        case (4): {
            System.out.println("Enter the new mobile number.. Existing mobile number is " + patient.getPhoneNumber());
            long updatedMobileNumber = patientScanner.nextLong();
            if (0 != updatedMobileNumber) {
                patient.setPhoneNumber(updatedMobileNumber);
            }
            break;
        }
        case (5): {
            System.out.println("Update the sex.. Enter '1' for  male\n Enter '2' for female \n Existing is " + patient.getSex());
            // no 0 check as 0 is for female
            patient.setSex(patientScanner.nextInt());
            break;
        }
        case (6): {
            System.out.println("Update date of birth in YYYY/MM/DD format \n Existing is " + patient.getDob());
            String updatedDob = patientScanner.nextLine();
            if (!updatedDob.isEmpty()) {
                patient.setDob(new Date(updatedDob));
            }
            break;
        }
        case (7): {
            System.out.println("Update the alergies as comma ',' seperated values .. Existing are" + patient.getAlergies());
            String updatedAlergies = patientScanner.nextLine();
            if (!updatedAlergies.isEmpty()) {
                updatedAlergies = patient.getAlergies() + ", " + updatedAlergies;
                patient.setAlergies(updatedAlergies);
            }
            break;
        }
        case (10): {
            patientService.updatePatient(patient);
            System.out.println(patient.getFirstName() + " details updated sccuessfully. Press any key to return to previous menu");
            patientScanner.nextLine();// gentle pause
            validatedPatientMenu(patientUserName, Math.toIntExact(patient.getId()), patient.getUserId());
        }
        default: {
            System.out.println("Invalid Selection . please select appropriate value");
            switchOption(patient, patientUserName);
        }

        }
        System.out.println("Would you like to update any other details?  \nSelect '1' to edit any other details.\nSelect '0' to save edited details");
        int toEdit = patientScanner.nextInt();
        if (1 == toEdit) {
            System.out.println("Select 1-7 from above list to edit the respective feild");
            switchOption(patient, patientUserName);
        } else {
            updateUser(patientUserName, patient);
        }
    }

    private void updateUser(String patientUserName, Patient patient) {
        patientService.updatePatient(patient);
        System.out.println(patient.getFirstName() + " details updated sccuessfully. Press any key to return to previous menu");
        patientScanner.nextLine();
        patientScanner.nextLine();// gentle pause
        validatedPatientMenu(patientUserName, Math.toIntExact(patient.getId()), patient.getUserId());
    }

    // if user selects '1' this option has to presented
    private String getPatientUpdatePage(String userName, int patientId, int userId) {
        String message = null;
        try {
            populateExistingDetails(patientService.findPatientByUserID(userId), userName);
            message = "Hi " + userName + ", Details have been successfully updated";
        } catch (EmptyResultDataAccessException ex) {
            // Patient has registered but has not made an entry in patient table
            // valid scenario in our case as transaction is not used to roll back from user table.
            // hence considering it as a possible use case calling update page for patient
            signUpAspatient(userName, userId);

        }
        return message;
    }

    // case '2' if patient choose to book appointment
    private int captureBookingInfo(String patientUserName, int patientId) {
        patientScanner.nextLine();
        System.out.println("Illness");
        String illness = patientScanner.nextLine();
        System.out.println("Select the department");
        // select distinct department from db dynamically
        List<String> departmetnList = doctorService.getAllDepartment();

        // to fetch the primary key of patient in order to update the appointment table foreign key
        // to populate the department dynamically
        int count = 1;
        for (String aDepartment : departmetnList) {
            System.out.println(count + ". " + aDepartment);
            count++;
        }

        // value was incremented to show the list .So to get the actual dep , minus 1 from of selected value
        int selectedDepartment = patientScanner.nextInt();
        selectedDepartment = selectedDepartment - 1;

        String selectedDepartmentName = departmetnList.get(selectedDepartment);

        List<Map<String, Object>> returnedValue = doctorService.getDoctorDetails(selectedDepartmentName);

        System.out.println("Select doctor ");
        count = 1;
        for (Map<String, Object> aMap : returnedValue) {
            System.out.println(count + ". Dr." + aMap.get("first_name").toString() + " " + aMap.get("last_name").toString());
            count++;
        }

        int selectedDocNumber = patientScanner.nextInt();
        selectedDocNumber = selectedDocNumber - 1;

        int doctorRegId = (Integer) returnedValue.get(selectedDocNumber).get("registration_id");
        System.out.println("select date \n1. For Today \n2. For Tomorrow \n3. For Day after tomorrow");
        int selectedDate = patientScanner.nextInt();
        String date = null;
        if (selectedDate == 1) {
            date = "today";
        } else if (selectedDate == 2) {
            date = "tomorrow";
        } else {
            date = "dayafter";
        }
        List<Date> timeslots = doctorService.findAvailableAppointmentForDoctor(doctorRegId, date);
        System.out.println("Select time slot");

        count = 1;
        for (Date aDate : timeslots) {
            System.out.println(count + ". " + aDate.toString());
            count++;
        }

        int selectTimeSlotValue = patientScanner.nextInt();
        selectTimeSlotValue = selectTimeSlotValue - 1;
        Date selectDateTimeValue = timeslots.get(selectTimeSlotValue);
        patientScanner.nextLine();
        System.out.println("Enter comment");
        String userComment = patientScanner.nextLine();
        Appointment newAppointment = new Appointment(selectDateTimeValue, userComment, illness, doctorRegId, "booked", patientId);
        return appointmentService.saveAppointment(newAppointment);

    }

    // case '3' if patient wants to view future appointments
    private int patientFutureAppointment(int patientId) {
        System.out.println("Sr.No \t\t illness \t\t Prescription \t\t Doctor Name \t\t Bill Amount \t\t date");
        List<PastAppointmentDetails> pastAppointmentList = patientService.fetchPastAppointmentDetials(patientId);
        int count = 1;
        for (PastAppointmentDetails appointmentDetail : pastAppointmentList) {
            System.out.println(count + "\t\t" + appointmentDetail.getIllness() + "\t\t" + appointmentDetail.getPrescription() + "\t\t " + appointmentDetail.getDoctorName() + "\t\t"
                    + appointmentDetail.getAmount() + "\t\t" + appointmentDetail.getAppointmentDate());
            count++;
        }
        return 0;// need to return back to the user option so need a return value. No meaningful data to return hence returning 0
    }

    // case '4' if patient wants to look at past appointments
    private int patientPastAppointment(int patientId) {

        List<Appointment> appointmentlist = appointmentService.fetchAppointments(patientId, "booked", "patient");
        if (0 != appointmentlist.size()) {
            System.out.println("Appointment Id\t Date&Time\t Comment\t illness\t Doctor Name ");
            appointmentlist.forEach(a -> System.out.println(a.toStringForPatient()));
        } else {
            System.out.println("No appointments has been scheduled. Please use booking service to book an appointment");
        }
        return 0; // need to return back to the user option so need a return value. No meaningful data to return hence returning 0
    }

}
