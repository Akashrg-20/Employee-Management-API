package com.example.employee_management_api.controller;

import com.example.employee_management_api.model.Employee;
import com.example.employee_management_api.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // SAVE EMPLOYEE DATE
    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
        String status = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    //GET ALL EMPLOYEES
    @GetMapping
    public ResponseEntity<?> getAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();

        if (!allEmployees.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(allEmployees);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found");

    }


    //GET EMPLOYEE BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id){
        Employee employee = employeeService.findEmployeeById(id);
        return employee!=null?ResponseEntity.status(HttpStatus.OK).body(employee)
                :ResponseEntity.status(HttpStatus.NOT_FOUND).body("No employee found by id : "+id);


    }

    // UPDATE EMPLOYEE
    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
        String status = employeeService.updateEmployee(employee);
        return status==null? ResponseEntity.status( HttpStatus.ACCEPTED).body("Updated Successfully")
                :ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found"+status);

    }


    //DELETE EMPLOYEE BY ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id){
        String status = employeeService.deleteEmployeeById(id);
        return status!=null?ResponseEntity.status(HttpStatus.NO_CONTENT).body(null)
                                :ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not employee found by id : "+id);
    }


}
