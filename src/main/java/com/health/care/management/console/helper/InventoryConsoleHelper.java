package com.health.care.management.console.helper;

import static com.health.care.management.util.Util.checkStringIsInterger;

import com.health.care.management.domain.Bill;
import com.health.care.management.domain.Doctor;
import com.health.care.management.domain.Inventory;
import com.health.care.management.service.DoctorService;
import com.health.care.management.service.InventoryService;
import com.health.care.management.service.impl.DoctorServiceImpl;
import com.health.care.management.service.impl.InventoryServiceImpl;

import java.util.List;
import java.util.Scanner;

public class InventoryConsoleHelper {

    private Scanner inventoryScanner;
    private DoctorService doctorService;
    private InventoryService inventoryService;

    public InventoryConsoleHelper() {
        this.inventoryScanner = new Scanner(System.in);
        this.doctorService = new DoctorServiceImpl();
        this.inventoryService = new InventoryServiceImpl();

    }

    public void inventoryManagerMenu() {

        System.out.println("Welcome to Managment Menu");
        System.out.println("Select '1' to view doctor list in hospotial \nSelect '2' to generate bill \nSelect '3' to manage inventory");
        int selectedValue = inventoryScanner.nextInt();
        inventoryScanner.nextLine();
        switch (selectedValue) {
        case (1): {
            System.out.println("List of doctors available in the hospital");
            List<Doctor> doctorList = doctorService.getAllDoctorDetails();
            System.out.println("Registration Id \t\t Doctor's Name \t\t Specialization \t\t Department \t\t email\t\t phone number\t\t status");
            doctorList.forEach(a -> {
                String availablity = "No";
                if (a.isAvailability() == 1) {
                    availablity = "Yes";
                }
                System.out.println(a.getRegistrationId() + "\t\t" + a.getFirstName() + " " + a.getLastName() + "\t\t" + a.getSpecialization() + "\t\t" + a.getDepartment() + "\t\t"
                        + a.getEmail() + "\t\t" + a.getMobileNumber() + "\t\t" + availablity);
            });
            System.out.println("Press any key to return to previous menu..");
            inventoryScanner.nextLine(); // swallow the input and call the inventory menu
            inventoryManagerMenu();
        }
        case (2): {
            List<Bill> billsToBePopultated = inventoryService.fetchAllDiagnoisedDetail("treated");

            int count = 1;
            if (0 != billsToBePopultated.size()) {
            for (Bill aBill : billsToBePopultated) {
                System.out.println("Sr.No \t\t Diagnosis Id \t\t Patient Name\t\t  \t\t Doctor Name \t\t admitted date " + "\t\t discharged date \t\t prescription");

                System.out.println(count + "\t\t" + aBill.getDiagnosisId() + "\t\t" + aBill.getPatientName() + "\t\t " + aBill.getDoctorName() + "\t\t" + aBill.getAdmitDate()
                        + "\t\t" + aBill.getDischargeDate()
                        + "\t\t"
                        + aBill.getPrescription());
                count++;
            }
            System.out.println("Select the Sr.No to generate the bill");
            int selectedDiagnosisId = inventoryScanner.nextInt();
            inventoryScanner.nextLine();
            System.out.println("Enter the comments in the bill");
            String comment = inventoryScanner.nextLine();

            selectedDiagnosisId = selectedDiagnosisId - 1;
            // TODO call bill generation service and update the db
            Bill selectedBill = billsToBePopultated.get(selectedDiagnosisId);
            selectedBill.setComment(comment);
            inventoryService.saveBill(selectedBill);
            } else {
                System.out.println("No enties to generate the bill press any key to return to previous menu");
                inventoryScanner.nextLine();// swallow the key pressed
                inventoryManagerMenu();
            }
        }

        case (3): {
            System.out.println("Manage Inventory");
            List<Inventory> inventoryList = inventoryService.getAllInventory();
            System.out.println("Sr.No \t\t Inventory Name \t\t Description \t\t Quantity \t\t Vendor Contact \t\t Typer");
            int count = 1;
            for (Inventory aInventory : inventoryList) {
                System.out.println(count + "\t\t" + aInventory.getName() + "\t\t" + aInventory.getDescription() + "\t\t" + aInventory.getQuantity() + "\t\t"
                        + aInventory.getVendorContact() + "\t\t" + aInventory.getType());
                count++;
            }

            System.out.println("Select the \"Sr.No\" to update the details. \nSelect '0' to add new Inventory. \n Enter 'back' to return to previous menu");
            // inventoryScanner.nextLine();
            String selecteInventoryId = inventoryScanner.nextLine();
            
            
            if (checkStringIsInterger(selecteInventoryId)) {
                int intValueOfInput = Integer.valueOf(selecteInventoryId);
            if (intValueOfInput != 0) {
                intValueOfInput = intValueOfInput - 1;
                Inventory selectedInventory = inventoryList.get(intValueOfInput);
                getFormForUpdatingInventory(selectedInventory);
                // TODO need to handle indexoutofbound if userchoose any other int ..providing relavent message and other option
                } else {
                // call new form to add new inventory
                newInventoryForm();
            }
            }
            else {
                inventoryManagerMenu();
            }
        }
        }

    }

    private void getFormForUpdatingInventory(Inventory inventory) {
        System.out.println("Update the Inventory details");
        System.out.println("Enter the name of the inventory. Existing is " + inventory.getName());
        String updatedName = inventoryScanner.nextLine();
        if (null != updatedName) {
            inventory.setName(updatedName);
        }
        System.out.println("Update the description of the inventory.. Existing is\n" + inventory.getDescription());
        String updatedDescription = inventoryScanner.nextLine();
        if (null != updatedDescription) {
            inventory.setDescription(updatedDescription);
        }

        System.out.println("Update the quantity of the inventory Existing quantity is " + inventory.getQuantity());
        int updatedQuantity = inventoryScanner.nextInt();
        if (0 != updatedQuantity) {
            inventory.setQuantity(updatedQuantity);
        }
        inventoryScanner.nextLine();
        System.out.println("Update the vendot info. Existing is " + inventory.getVendorContact());
        String updatedVendorInfo = inventoryScanner.nextLine();
        if (null != updatedVendorInfo) {
            inventory.setVendorContact(updatedVendorInfo);
        }

        System.out.println("Update the price per unit. Existing is " + inventory.getPricePerUnit());
        int updatedPrice = inventoryScanner.nextInt();
        if (0 != updatedPrice) {
            inventory.setPricePerUnit(updatedPrice);
        }
        inventoryScanner.nextLine();
        System.out.println("Enter the type of inventory . Existing is " + inventory.getType());
        String updatedType = inventoryScanner.nextLine();
        if (null != updatedType) {
            inventory.setType(updatedType);
        }

        inventoryService.updateInventory(inventory);
        System.out.println(inventory.getName() + "  details has been updated successfully. Press any key to return to to previous menu");
        inventoryScanner.nextLine(); // swallow the input
        inventoryManagerMenu();

    }

    private void newInventoryForm() {
        // inventoryScanner.nextLine();
        Inventory inventory = new Inventory();
        System.out.println("Update the Inventory details");
        System.out.println("Enter the name of the inventory. ");
        String updatedName = inventoryScanner.nextLine();
        System.out.println("Enter the description of the inventory");
        String updatedDescription = inventoryScanner.nextLine();
        System.out.println("Enter the quantity of the inventory ");
        int updatedQuantity = inventoryScanner.nextInt();
        inventoryScanner.nextLine();
        System.out.println("Enter the price per unit.");
        int updatedPrice = inventoryScanner.nextInt();
        inventoryScanner.nextLine();
        System.out.println("Enter the vendot info");
        String updatedVendorInfo = inventoryScanner.nextLine();
        System.out.println("Enter the type of inventory ");
        String updatedType = inventoryScanner.nextLine();
        inventory.setName(updatedName);
        inventory.setDescription(updatedDescription);
        inventory.setQuantity(updatedQuantity);
        inventory.setVendorContact(updatedVendorInfo);
        inventory.setType(updatedType);
        inventory.setPricePerUnit(updatedPrice);

        inventoryService.saveInventory(inventory);
        System.out.println(inventory.getName() + "  details has been saved successfully. Press any key to return to to previous menu");
        inventoryScanner.nextLine(); // swallow the input
        inventoryManagerMenu();

    }
}
