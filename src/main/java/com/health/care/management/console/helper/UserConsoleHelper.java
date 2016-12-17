package com.health.care.management.console.helper;

import com.health.care.management.domain.User;
import com.health.care.management.service.DoctorService;
import com.health.care.management.service.PatientService;
import com.health.care.management.service.UserService;
import com.health.care.management.service.impl.DoctorServiceImpl;
import com.health.care.management.service.impl.PatientServiceImpl;
import com.health.care.management.service.impl.UserServiceImpl;

import java.util.Scanner;

public class UserConsoleHelper {

    private PatientConsoleHelper patientConsoleHelper;
    private DoctorConsoleHelper doctorConsoleHelper;
    private InventoryConsoleHelper inventoryConsoleHelper;

    private UserService userService;
    private PatientService patientService;
    private DoctorService doctorService;

    private Scanner userScanner;

    /**
     * Default constructor
     */
    public UserConsoleHelper() {
        this.patientConsoleHelper = new PatientConsoleHelper();
        this.doctorConsoleHelper = new DoctorConsoleHelper();
        this.inventoryConsoleHelper = new InventoryConsoleHelper();
        this.userService = new UserServiceImpl();
        this.doctorService = new DoctorServiceImpl();
        this.patientService = new PatientServiceImpl();
        this.userScanner = new Scanner(System.in);
    }
    
    
    /**
     * Entry form for the application
     */
    public void kickStartApplication() {
        System.out.println("Press '1' to login");
        System.out.println("Press '2' to register");

        int initialSelction = userScanner.nextInt();
        if (initialSelction == 1) {
            // Used to validate the user and respond with appropriate pages
            User returnValue = validateUserLogin();
            if (returnValue.getStatus() == "valid") {
                switch (returnValue.getRole()) {
                case "patient": {
                    System.out.println("Patient menu");
                    // TODO pass the patient pk
                    int patientId = Math.toIntExact(patientService.findPatientByUserID(returnValue.getId()).getId());
                    patientConsoleHelper.validatedPatientMenu(returnValue.getUserName(), patientId, returnValue.getId());
                    break;
                }
                case "doctor": {
                    // TODO fetch by user Id
                    int doctorRegistrationId = Math.toIntExact(doctorService.fetchDoctorByUserId(returnValue.getId()).getRegistrationId());
                    doctorConsoleHelper.validatedDoctorMenu(returnValue.getUserName(), returnValue.getId(), doctorRegistrationId);
                    break;

                }
                // for inventory manager
                default: {
                    System.out.println("Inventory menu");
                    inventoryConsoleHelper.inventoryManagerMenu();
                }
                }
            } else {
                System.out.println("Invalid login please try again or signup");
                kickStartApplication();
            }

        } else if (initialSelction == 2) {
            // provide option to register as doc or as patient
            getInitialForm();
        } else {
            System.out.println("Please choose the correct option");
            kickStartApplication();
        }
    }

    /**
     * Provides form to register as patient / doctor
     * 
     */
    public void getInitialForm() {
        System.out.println("Select '1' to register as patient");
        System.out.println("Select '2' to register as doctor");
        int registrationOption = userScanner.nextInt();
        if (registrationOption == 1) {
            signUpUser("patient");
        } else if (registrationOption == 2) {
            signUpUser("doctor");
        } else {
            System.out.println("Improper selection made.Try again..");
            getInitialForm();
        }
    }



    /**
     * @param role
     * Provides form to sign up 
     */
    public void signUpUser(String role) {
        // need to validate the user
        String roleOfUser = role;

        System.out.println("Enter the user name");
        String userName = userScanner.next();
        
        System.out.println("Enter the desired password");
        String password = userScanner.next();
        User userDTO = new User();
        userDTO.setRole(roleOfUser);
        userDTO.setPassword(password);
        userDTO.setUserName(userName);

        // call userService and returns the userName if valid userName or else return error message
        User savedUser = userService.saveUser(userDTO);

        if (0 != savedUser.getId()) {
            if (roleOfUser.equalsIgnoreCase("patient")) {
                patientConsoleHelper.signUpAspatient(savedUser.getUserName(), savedUser.getId());
            } else {
                doctorConsoleHelper.signupAsDoctor(savedUser.getUserName(), savedUser.getId());
            }
        } else {
            System.out.println("User name already exits . Please select any other user name");
            // presenting the sign-up form to try with different username
            signUpUser(role);

        }

    }

    // login validation and providing respective pages based on the role of the user
    /**
     * @return User
     * validates user has entered valid password or not
     */
    public User validateUserLogin() {
        User userToBeValidated = new User();
        System.out.println("Enter the user name");
        userToBeValidated.setUserName(userScanner.next());
        System.out.println("Enter the password");
        userToBeValidated.setPassword(userScanner.next());
        return userService.validateUser(userToBeValidated);

    }

}
