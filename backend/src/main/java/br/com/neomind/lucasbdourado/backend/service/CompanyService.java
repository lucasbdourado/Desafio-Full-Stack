package br.com.neomind.lucasbdourado.backend.service;

import br.com.neomind.lucasbdourado.backend.dao.CompanyDAO;
import br.com.neomind.lucasbdourado.backend.dao.ICompanyDAO;
import br.com.neomind.lucasbdourado.backend.domain.Company;
import br.com.neomind.lucasbdourado.backend.exception.ValidationException;
import br.com.neomind.lucasbdourado.backend.validation.FieldsValidator;

import javax.persistence.NoResultException;
import java.util.List;

public class CompanyService extends FieldsValidator<Company> implements ICompanyService{

    private final ICompanyDAO companyDAO;

    public CompanyService(){
        this.companyDAO = new CompanyDAO();
    }

    @Override
    public List<Company> getAll() throws Exception {
        try{
            return companyDAO.getAllCompanies();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Company create(Company company) throws ValidationException {
        try{
            Boolean validatedFields = validateFields(company);

            if(!validatedFields) return company;

            return companyDAO.create(company);
        } catch (ValidationException validationException){
            throw validationException;
        }
    }

    @Override
    public Company read(Long id) throws NoResultException {
        try{
            Company company = companyDAO.findById(id);

            if(company == null) throw new NoResultException("Compania não encontrada com o id especificado!");

            return company;
        } catch (NoResultException e){
            throw new NoResultException(e.getMessage());
        }
    }

    @Override
    public Company update(Long id, Company updatedCompany) throws NoResultException, ValidationException {
        try{
            Boolean validatedFields = validateFields(updatedCompany);

            if(!validatedFields) return updatedCompany;

            Company company = companyDAO.findById(id);

            if(company == null) throw new NoResultException("Compania não encontrada com o id especificado!");

            updatedCompany.setId(company.getId());

            return companyDAO.update(updatedCompany);
        } catch (NoResultException noResultException){
            throw new NoResultException(noResultException.getMessage());
        } catch (ValidationException validationException) {
            throw validationException;
        }
    }

    @Override
    public Company delete(Long id) throws NoResultException {
        try{
            Company company = companyDAO.findById(id);

            if(company == null) throw new NoResultException("Compania não encontrada com o id especificado!");

            return companyDAO.delete(company);
        } catch (NoResultException e){
            throw new NoResultException(e.getMessage());
        }
    }
}
