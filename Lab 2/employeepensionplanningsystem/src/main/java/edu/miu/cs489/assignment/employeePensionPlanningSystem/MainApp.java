package edu.miu.cs489.assignment.employeePensionPlanningSystem;

import java.time.LocalDate;
import edu.miu.cs489.assignment.employeePensionPlanningSystem.model.Employee;
import edu.miu.cs489.assignment.employeePensionPlanningSystem.model.PensionPlan;
import edu.miu.cs489.assignment.employeePensionPlanningSystem.service.EmployeePensionService;

public class MainApp {

    public static void main(String[] args) {
        EmployeePensionService employeePensionService = new EmployeePensionService();
        // Add Employees
        employeePensionService.addEmployee(new Employee(1001L, "Daniel", "Agar", LocalDate.of(2018, 1, 17), 105945.50));
        employeePensionService
                .addEmployee(new Employee(1002L, "Benard", "Shaw", LocalDate.of(2018, 10, 03), 197750.00));
        employeePensionService.addEmployee(new Employee(1003L, "Carly", "Agar", LocalDate.of(2014, 5, 16), 842000.75));
        employeePensionService
                .addEmployee(new Employee(1004L, "Wesley", "Schneider", LocalDate.of(2018, 11, 2), 74500.00));
        // Enroll Employee to Pension
        employeePensionService.enrollEmployeeToPension(
                new Employee(1001L, "Daniel", "Agar", LocalDate.of(2018, 1, 17), 105945.50),
                new PensionPlan("EX1089", LocalDate.of(2023, 1, 17), 100.00));
        employeePensionService.enrollEmployeeToPension(
                new Employee(1003L, "Carly", "Agar", LocalDate.of(2014, 5, 16), 842000.75),
                new PensionPlan("SM2307", LocalDate.of(2019, 11, 4), 1555.50));
        employeePensionService.enrollEmployeeToPension(
                new Employee(1002L, "Benard", "Shaw", LocalDate.of(2018, 10, 03), 197750.00),
                new PensionPlan());
        employeePensionService.enrollEmployeeToPension(
                new Employee(1004L, "Wesley", "Schneider", LocalDate.of(2018, 11, 2), 74500.00),
                new PensionPlan());
        // Display Employees in JSON format by Last Name
        System.out.println("-------------------------------------");
        System.out.println("---------Employees By LastName---------");
        System.out.println("-------------------------------------");
        try {
            employeePensionService.printJSONFormat("ByLastName");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Display Employees in JSON format by Salary
        System.out.println("-------------------------------------");
        System.out.println("---------Employees By Salary---------");
        System.out.println("-------------------------------------");
        try {
            employeePensionService.printJSONFormat("BySalary");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Monthly Upcoming Enrollees report
        System.out.println("-------------------------------------");
        System.out.println("------Monthly Upcoming Enrollees-------");
        System.out.println("-------------------------------------");
        employeePensionService.monthlyUpcomingEnrolees();

        // // Display Employees in JSON format by Pension Plan
        // System.out.println("-------------------------------------");
        // System.out.println("------Employees By Pension Plan-------");
        // System.out.println("-------------------------------------");

        // try {
        // employeePensionService.printUpcomingEnrolleesJSONFormat();
        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // }

        // // monthlyUpcomingEnrolees
        // System.out.println("-------------------------------------");
        // System.out.println("------Monthly Upcoming Enrolees-------");
        // System.out.println("-------------------------------------");
        // employeePensionService.monthlyUpcomingEnrolees();

    }
}