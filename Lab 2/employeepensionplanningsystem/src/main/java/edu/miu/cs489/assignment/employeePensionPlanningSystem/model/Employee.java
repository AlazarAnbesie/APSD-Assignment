package edu.miu.cs489.assignment.employeePensionPlanningSystem.model;

import java.time.LocalDate;

public class Employee {
    long emplyeeId;
    String firstName;
    String lastName;
    LocalDate employementDate;
    double yearlySalary;

    public Employee(long emplyeeId, String firstName, String lastName, LocalDate employementDate, double yearlySalary) {
        this.emplyeeId = emplyeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employementDate = employementDate;
        this.yearlySalary = yearlySalary;
    }

    public long getEmplyeeId() {
        return emplyeeId;
    }

    public void setEmplyeeId(long emplyeeId) {
        this.emplyeeId = emplyeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getEmployementDate() {
        return employementDate;
    }

    public void setEmployementDate(LocalDate employementDate) {
        this.employementDate = employementDate;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    @Override
    public String toString() {
        return "Employee [emplyeeId=" + emplyeeId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", employementDate=" + employementDate + ", yearlySalary=" + yearlySalary + "]";
    }
}
