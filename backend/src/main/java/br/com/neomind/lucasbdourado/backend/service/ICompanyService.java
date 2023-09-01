package br.com.neomind.lucasbdourado.backend.service;

import br.com.neomind.lucasbdourado.backend.domain.Company;

import java.util.List;

public interface ICompanyService {

    List<Company> getAll() throws Exception;

    Company create(Company company) throws Exception;

    Company read(Long id) throws Exception;

    Company update(Long id, Company updatedCompany) throws Exception;

    Company delete(Long id) throws Exception;
}
