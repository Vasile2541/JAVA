package com.java.employeeManager.service.manager;

import com.java.employeeManager.exceptions.EntityNotFoundException;
import com.java.employeeManager.model.Company;
import com.java.employeeManager.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//DAO data access object
@Component
public class CompanyManager {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public void createCompanies(Company company) {
        companyRepository.save(company);
    }

    public void updateCompany(Company company){
        Optional<Company> optionalCompany = companyRepository.findById( company.getId() );
        if(optionalCompany.isPresent()){
            System.out.println("sdv  "+ company.getId());
            companyRepository.save( company );
        }else{
            System.out.println("updateCompany(Company company)");
        }
    }

    public boolean deleteCompany(Integer id) {
        Optional<Company> optionalEmployee = companyRepository.findById(id);
        if(optionalEmployee.isPresent()){
            companyRepository.delete(optionalEmployee.get());
            return true;
        }
        return false;
    }

    public Company getCompanyById(Integer id) throws EntityNotFoundException {
        Optional<Company> optionalCompany = this.companyRepository.findById(id);
        if(optionalCompany.isPresent()){
            return optionalCompany.get();
        }
        throw new EntityNotFoundException( "Can not find Company entity with id=", id );
    }
}
