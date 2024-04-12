package edu.miu.cs489.assignment.employeePensionPlanningSystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import edu.miu.cs489.assignment.employeePensionPlanningSystem.data.EmployeePensionData;
import edu.miu.cs489.assignment.employeePensionPlanningSystem.model.Employee;
import edu.miu.cs489.assignment.employeePensionPlanningSystem.model.PensionPlan;

public class EmployeePensionService {
    private EmployeePensionData employeePensionData;
    private List<Employee> employees;

    public EmployeePensionService() {
        this.employeePensionData = new EmployeePensionData();
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void monthlyUpcomingEnrolees() {
        List<Employee> enrollees = new ArrayList<>();
        LocalDate today = LocalDate.now();
        int lastDay = today.plusMonths(1).lengthOfMonth(); // 29
        for (Employee emp : employees) {
            if (((today.getYear() - emp.getEmployementDate().getYear() >= 5) ||
                    ((emp.getEmployementDate().getDayOfMonth() > 1) &&
                            (emp.getEmployementDate().getDayOfMonth() < lastDay)))
                    &&
                    !(employeePensionData.getEmployeePensionMap().containsKey(emp.getEmplyeeId()))) {
                enrollees.add(emp);
            }
        }
        Comparator<Employee> byDate = Comparator.comparing(Employee::getEmployementDate);
        List<Employee> sortedEmployee = enrollees.stream().sorted(byDate)
                .collect(Collectors.toCollection(ArrayList::new));
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sortedEmployee);
            System.out.println("Upcoming Enrollees in JSON format: ");
            System.out.println(json);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

    }

    public void enrollEmployeeToPension(Employee employee, PensionPlan pensionPlan) {

        employeePensionData.getEmployeePensionMap().put(employee.getEmplyeeId(), pensionPlan);
    }

    public Map<Long, PensionPlan> getEmployeePensionData() {
        return employeePensionData.getEmployeePensionMap();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    //
    public void printJSONFormat(String sortType) throws JsonProcessingException {
        List<Employee> sortedEmployee = new ArrayList<>();
        if (sortType.equals("ByLastName")) {
            Comparator<Employee> byLastName = Comparator.comparing(Employee::getFirstName);
            sortedEmployee = employees.stream().sorted(byLastName).collect(Collectors.toCollection(ArrayList::new));
        } else if (sortType.equals("BySalary")) {
            Comparator<Employee> bySalary = Comparator.comparing(Employee::getYearlySalary).reversed();
            sortedEmployee = employees.stream().sorted(bySalary).collect(Collectors.toCollection(ArrayList::new));
        } else {
            Comparator<Employee> byFirstName = Comparator.comparing(Employee::getFirstName);
            sortedEmployee = employees.stream().sorted(byFirstName).collect(Collectors.toCollection(ArrayList::new));

        }
        List<Map<String, Object>> jsonEmployees = new ArrayList<>();
        for (Employee employee : sortedEmployee) {
            Map<String, Object> jsonEmployee = new LinkedHashMap<>();
            jsonEmployee.put("FirstName", employee.getFirstName());
            jsonEmployee.put("LastName", employee.getLastName());
            jsonEmployee.put("YearlySalary", employee.getYearlySalary());

            // Check if pension plan exists for the employee
            PensionPlan pensionPlan = employeePensionData.getEmployeePensionMap().get(employee.getEmplyeeId());
            if (pensionPlan != null) {
                jsonEmployee.put("PensionPlan", pensionPlan);
            }
            jsonEmployees.add(jsonEmployee);
        }

        // Convert list to JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonEmployees);

        // Print JSON format
        System.out.println("Employees in JSON format:");
        System.out.println(json);
    }

}
