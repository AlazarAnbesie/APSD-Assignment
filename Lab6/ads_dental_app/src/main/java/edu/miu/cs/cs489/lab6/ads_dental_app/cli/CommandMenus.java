package edu.miu.cs.cs489.lab6.ads_dental_app.cli;

import java.util.Scanner;

public class CommandMenus {
    Scanner scanner = new Scanner(System.in);

    public  void menu(){
        System.out.println("1.Patient Operations");
        System.out.println("2.Dentist Operations");
        System.out.println("3.Surgery Operations");
        System.out.println("4.Appointment Operations");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                patientMenu();
                break;
            case 2:
                dentistMenu();
                break;
            case 3:
                surgeryMenu();
                break;
            case 4:
                appointmentMenu();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }


    }

    public void patientMenu(){
        System.out.println("1. Add Patient");
        System.out.println("2. Update Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. List Patients");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();

    }

    public void dentistMenu(){
        System.out.println("1. Add Dentist");
        System.out.println("2. Update Dentist");
        System.out.println("3. Delete Dentist");
        System.out.println("4. List Dentists");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
    }

    public void surgeryMenu(){
        System.out.println("1. Add Surgery");
        System.out.println("2. Update Surgery");
        System.out.println("3. Delete Surgery");
        System.out.println("4. List Surgeries");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
    }

    public void appointmentMenu(){
        System.out.println("1. Add Appointment");
        System.out.println("2. Update Appointment");
        System.out.println("3. Delete Appointment");
        System.out.println("4. List Appointments");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
    }





}
