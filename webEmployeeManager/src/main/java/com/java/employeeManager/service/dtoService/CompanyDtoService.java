package com.java.employeeManager.service.dtoService;

import com.java.employeeManager.dto.CompanyDto;
import com.java.employeeManager.exceptions.EntityNotFoundException;
import com.java.employeeManager.model.Company;
import com.java.employeeManager.service.manager.CompanyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyDtoService {

    @Autowired
    CompanyManager companyManager;

    public List<CompanyDto> getAllCompanies() {
        List<Company> companyList = companyManager.getAllCompanies();
        return companyList.stream()
                .map(c -> new CompanyDto( c.getId(), c.getName(),
                         c.getEmployees().stream()
                                .map(e -> e.getId())
                                .collect(Collectors.toSet())
                    ))
                .collect(Collectors.toList());
    }

    public void createCompanies(CompanyDto dto) {
        Company company = new Company( dto.getName() );
        companyManager.createCompanies(company);
    }

    public void updateCompany(CompanyDto dto){
        companyManager.updateCompany( new Company(dto.getId(), dto.getName()) );
    }

    public boolean deleteCompany(Integer id) {
        return  companyManager.deleteCompany(id);
    }


}
