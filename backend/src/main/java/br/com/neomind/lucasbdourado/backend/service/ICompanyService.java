package br.com.neomind.lucasbdourado.backend.service;

import br.com.neomind.lucasbdourado.backend.domain.Company;
import br.com.neomind.lucasbdourado.backend.exception.ValidationException;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public interface ICompanyService {

    List<Company> getAll() throws Exception;

    Company create(Company company) throws ValidationException, SQLException;

    Company read(Long id) throws NoResultException;

    Company update(Long id, Company updatedCompany) throws NoResultException, ValidationException;

    Company delete(Long id) throws NoResultException;
}
