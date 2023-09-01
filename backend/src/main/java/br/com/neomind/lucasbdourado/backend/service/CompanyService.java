package br.com.neomind.lucasbdourado.backend.service;

import br.com.neomind.lucasbdourado.backend.dao.CompanyDAO;
import br.com.neomind.lucasbdourado.backend.dao.ICompanyDAO;
import br.com.neomind.lucasbdourado.backend.domain.Company;
import br.com.neomind.lucasbdourado.backend.validation.FieldsValidator;

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
    public Company create(Company company) throws Exception {
        try{
            Boolean validatedFields = validateFields(company);

            if(!validatedFields) return company;

            return companyDAO.create(company);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Company read(Long id) throws Exception {
        try{
            Company company = companyDAO.findById(id);

            if(company == null) throw new Exception("Compania não encontrada com o id especificado!");

            return company;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Company update(Long id, Company updatedCompany) throws Exception {
        try{
            Boolean validatedFields = validateFields(updatedCompany);

            if(!validatedFields) return updatedCompany;

            Company company = companyDAO.findById(id);

            if(company == null) throw new Exception("Compania não encontrada com o id especificado!");
            
            updatedCompany.setId(company.getId());

            return companyDAO.update(updatedCompany);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Company delete(Long id) throws Exception {
        try{
            Company company = companyDAO.findById(id);

            if(company == null) throw new Exception("Compania não encontrada com o id especificado!");

            return companyDAO.delete(company);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
