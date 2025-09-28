package com.example.employee_management_api.service;
import com.example.employee_management_api.model.Employee;
import com.example.employee_management_api.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    public String saveEmployee(Employee employee) {
        employeeRepo.save(employee);
        return "success";
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();


    }

    public Employee findEmployeeById(int id) {
        Optional<Employee> byId = employeeRepo.findById(id);

        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    public String updateEmployee(Employee employee) {
        try {
            employeeRepo.save(employee);
            return null;
        }catch (Exception e){
            return e.getMessage();
        }

    }

    public String deleteEmployeeById(int id) {
        Optional<Employee> byId = employeeRepo.findById(id);

        if (byId.isPresent()){
            employeeRepo.delete(byId.get());
            return "Success";
        }
        return null;
    }
}
