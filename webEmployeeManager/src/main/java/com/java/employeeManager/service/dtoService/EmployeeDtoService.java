package com.java.employeeManager.service.dtoService;

import com.java.employeeManager.dto.EmployeeDto;
import com.java.employeeManager.exceptions.EntityNotFoundException;
import com.java.employeeManager.model.Address;
import com.java.employeeManager.model.Employee;
import com.java.employeeManager.service.manager.CompanyManager;
import com.java.employeeManager.service.manager.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDtoService {

    @Autowired
    EmployeeManager employeeManager;
    @Autowired
    CompanyManager companyManager;

    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeManager.getAllEmployees();
        return employees.stream()
                .map( e -> new EmployeeDto(
                        e.getId(), e.getFirstName(), e.getLastName(), e.getSalary(),
                        e.getCompany() != null ? e.getCompany().getId() : null,
                        e.getAddress() != null ? e.getAddress().getStreetInfo() : null
                        )
                )
                .collect(Collectors.toList());
    }

    public void createEmployees(EmployeeDto dtoE) throws EntityNotFoundException {
        this.employeeManager.createEmployees(
                new Employee(dtoE.getFirstName(), dtoE.getLastName(), dtoE.getSalary(),
                    this.companyManager.getCompanyById( dtoE.getCompanyId() ),
                    new Address( dtoE.getAddress() )//datorita la CascadeType.ALL atunci cidn creem un angajam nou si ii dam un obiect nou de tip Address el are grija sa creeze obiectul asta  (o sa creeze in Adress o inregistrare si id-ul inrregistrarii astea o sa o puna aici ca legatura)
                )
        );
    }


    public boolean deleteEmployee(Integer id) {
        return employeeManager.deleteEmployee(id);
    }

    public void updateEmployee(EmployeeDto dto) throws EntityNotFoundException {
        employeeManager.updateEmployee(
                new Employee( dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getSalary(),
                        this.companyManager.getCompanyById( dto.getCompanyId() ) ,
                        dto.getAddress() != null ? new Address( dto.getAddress() ) : null
                )
        );
    }
}
