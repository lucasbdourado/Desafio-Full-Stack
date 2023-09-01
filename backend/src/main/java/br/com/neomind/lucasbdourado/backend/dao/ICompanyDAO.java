package br.com.neomind.lucasbdourado.backend.dao;

import br.com.neomind.lucasbdourado.backend.domain.Company;

import java.sql.SQLException;
import java.util.List;

public interface ICompanyDAO {

    List<Company> getAllCompanies() throws Exception;

    Company create(Company company) throws Exception;

    Company findById(Long id) throws Exception;

    Company update(Company company) throws Exception;

    Company delete(Company company) throws Exception;
}
