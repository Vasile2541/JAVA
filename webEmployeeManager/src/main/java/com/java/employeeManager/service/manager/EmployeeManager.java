package com.java.employeeManager.service.manager;

import com.java.employeeManager.exceptions.EntityNotFoundException;
import com.java.employeeManager.model.Company;
import com.java.employeeManager.model.Employee;
import com.java.employeeManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeManager {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void createEmployees(Employee employees) {

        employeeRepository.save(employees);
    }


    public boolean deleteEmployee(Integer id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            employeeRepository.delete(optionalEmployee.get());
            return true;
        }
        return false;
    }

    public void updateEmployee(Employee employeeToUpdate) throws EntityNotFoundException{
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeToUpdate.getId());
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();

            if(employee.getAddress() != null && employeeToUpdate.getAddress() != null){
                employee.getAddress().setStreetInfo(employeeToUpdate.getAddress().getStreetInfo());
            }else{
                if(employeeToUpdate.getAddress() != null){
                    employee.setAddress(employeeToUpdate.getAddress());
                }
            }
            employeeRepository.save( employeeToUpdate );
        }else{
            System.out.println("error in updateEmployee");
            throw new EntityNotFoundException("Can not find Employee entity with id=", employeeToUpdate.getId());
        }
    }


}
