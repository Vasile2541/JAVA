package com.java.employeeManager.controllerService;

import com.java.employeeManager.dto.CompanyDto;
import com.java.employeeManager.dto.EmployeeDto;
import com.java.employeeManager.exceptions.EntityNotFoundException;
import com.java.employeeManager.service.dtoService.CompanyDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/companies")
public class CompanyController {

    @Autowired
    CompanyDtoService dtoService;

    @GetMapping
    public List<CompanyDto> getAllCompanies(){
        return dtoService.getAllCompanies();
    }

    @PostMapping
    public void createCompanies(@RequestBody CompanyDto dto){
        System.out.println("createCompany() controller");
        dtoService.createCompanies(dto);
    }

    @PutMapping
    public void updateCompany(@RequestBody CompanyDto dto){
        dtoService.updateCompany(dto);
    }

    @DeleteMapping("{id}")
    //'ResponseEntity' - daca e necesar ca manual sa specific niste statuturi
    public ResponseEntity deleteCompany(@PathVariable("id") Integer id){
        boolean result = dtoService.deleteCompany(id);
        if(result){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
