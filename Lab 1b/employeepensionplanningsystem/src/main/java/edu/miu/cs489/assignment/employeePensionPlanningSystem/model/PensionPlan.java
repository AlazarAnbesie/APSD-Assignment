package edu.miu.cs489.assignment.employeePensionPlanningSystem.model;

import java.time.LocalDate;

public class PensionPlan {
    String planReferenceNumber;
    LocalDate enrollmenDate;
    double monthlyContribution;

    public PensionPlan(String planReferenceNumber, LocalDate enrollmenDate, double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmenDate = enrollmenDate;
        this.monthlyContribution = monthlyContribution;
    }

    public PensionPlan() {
    }

    public String getPlanReferenceNumber() {
        return planReferenceNumber;
    }

    public void setPlanReferenceNumber(String planReferenceNumber) {
        this.planReferenceNumber = planReferenceNumber;
    }

    public LocalDate getEnrollmenDate() {
        return enrollmenDate;
    }

    public void setEnrollmenDate(LocalDate enrollmenDate) {
        this.enrollmenDate = enrollmenDate;
    }

    public double getMonthlyContribution() {
        return monthlyContribution;
    }

    public void setMonthlyContribution(double monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }

    @Override
    public String toString() {
        return "PensionPlan [planReferenceNumber=" + planReferenceNumber + ", enrollmenDate=" + enrollmenDate
                + ", monthlyContribution=" + monthlyContribution + "]";
    }

}
