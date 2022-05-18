package com.java.employeeManager.controllerService;


import com.java.employeeManager.dto.EmployeeDto;
import com.java.employeeManager.exceptions.EntityNotFoundException;
import com.java.employeeManager.service.dtoService.EmployeeDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    EmployeeDtoService dtoService;

    @GetMapping
    public List<EmployeeDto> getAllEmployees(){
        return dtoService.getAllEmployees();
    }

    @PostMapping
    public void createEmployees(@RequestBody EmployeeDto dtoEmployee) throws EntityNotFoundException {
        dtoService.createEmployees(dtoEmployee);
    }

    @PutMapping
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDto dto){
        try {
            dtoService.updateEmployee(dto);
            return ResponseEntity.ok().build();
        }catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteEmployee(@PathVariable("id") Integer id){
        boolean result = dtoService.deleteEmployee(id);
        if(result){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
