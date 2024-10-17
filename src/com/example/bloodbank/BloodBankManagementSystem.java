package com.example.bloodbank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BloodBankManagementSystem {
    private List<Donor> donors;
    private BloodInventory bloodInventory;

    public BloodBankManagementSystem() {
        donors = new ArrayList<>();
        bloodInventory = new BloodInventory();
    }

    public void registerDonor(String name, String bloodGroup, String contact) {
        Donor donor = new Donor(name, bloodGroup, contact);
        donors.add(donor);
        System.out.println("Donor registered successfully.");
    }

    public void addBloodDonation(String bloodGroup, int quantity) {
        bloodInventory.addBlood(bloodGroup, quantity);
        System.out.println("Blood donation added successfully.");
    }

    public void requestBlood(String bloodGroup, int quantity) {
        if (bloodInventory.reduceStock(bloodGroup, quantity)) {
            System.out.println("Blood request fulfilled successfully.");
        } else {
            System.out.println("Insufficient stock for the requested blood group.");
        }
    }

    public void displayDonors() {
        System.out.println("Registered Donors:");
        for (Donor donor : donors) {
            System.out.println("Name: " + donor.getName() + ", Blood Group: " + donor.getBloodGroup() + ", Contact: " + donor.getContact());
        }
    }

    public static void main(String[] args) {
        BloodBankManagementSystem system = new BloodBankManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register Donor");
            System.out.println("2. Add Blood Donation");
            System.out.println("3. Request Blood");
            System.out.println("4. Display Donors");
            System.out.println("5. Display Blood Stock");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Donor Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Blood Group:");
                    String bloodGroup = scanner.nextLine();
                    System.out.println("Enter Contact:");
                    String contact = scanner.nextLine();
                    system.registerDonor(name, bloodGroup, contact);
                    break;
                case 2:
                    System.out.println("Enter Blood Group:");
                    bloodGroup = scanner.nextLine();
                    System.out.println("Enter Quantity:");
                    int quantity = scanner.nextInt();
                    system.addBloodDonation(bloodGroup, quantity);
                    break;
                case 3:
                    System.out.println("Enter Blood Group:");
                    bloodGroup = scanner.nextLine();
                    System.out.println("Enter Quantity:");
                    quantity = scanner.nextInt();
                    system.requestBlood(bloodGroup, quantity);
                    break;
                case 4:
                    system.displayDonors();
                    break;
                case 5:
                    system.bloodInventory.displayStock();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

