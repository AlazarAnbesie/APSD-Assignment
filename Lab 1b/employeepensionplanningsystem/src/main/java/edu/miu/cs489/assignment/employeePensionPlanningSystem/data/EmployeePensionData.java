package edu.miu.cs489.assignment.employeePensionPlanningSystem.data;

import java.util.HashMap;
import java.util.Map;

import edu.miu.cs489.assignment.employeePensionPlanningSystem.model.PensionPlan;

public class EmployeePensionData {
    Map<Long, PensionPlan> employeePensionMap;

    public EmployeePensionData() {
        this.employeePensionMap = new HashMap<>();
    }

    public Map<Long, PensionPlan> getEmployeePensionMap() {
        return employeePensionMap;
    }

    public void setEmployeePensionMap(Map<Long, PensionPlan> employeePensionMap) {
        this.employeePensionMap = employeePensionMap;
    }

}
