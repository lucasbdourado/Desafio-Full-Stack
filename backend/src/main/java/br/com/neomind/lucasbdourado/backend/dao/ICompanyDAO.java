package br.com.neomind.lucasbdourado.backend.dao;

import br.com.neomind.lucasbdourado.backend.domain.Company;
import br.com.neomind.lucasbdourado.backend.exception.ValidationException;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public interface ICompanyDAO {

    List<Company> getAllCompanies() throws Exception;

    Company create(Company company) throws ValidationException;

    Company findById(Long id) throws NoResultException;

    Company update(Company company) throws NoResultException;

    Company delete(Company company) throws NoResultException;
}
