package br.com.neomind.lucasbdourado.backend.dao;

import br.com.neomind.lucasbdourado.backend.domain.Company;
import br.com.neomind.lucasbdourado.backend.exception.ValidationException;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;
public class CompanyDAO implements ICompanyDAO{

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public CompanyDAO() {}
    @Override
    public List<Company> getAllCompanies() throws Exception {
        try {
            openConnection();

            List<Company> companies = entityManager.createQuery("SELECT company FROM Company company", Company.class).getResultList();

            closeConnection();

            return companies;
        } catch (Exception e){
            throw new Exception("Erro: Erro no banco de dados");
        }
    }

    @Override
    public Company create(Company company) throws ValidationException {
        try {
            openConnection();

            if(isCnpjExists(company.getCnpj())) throw new ValidationException("O CNPJ informado já existe.");

            entityManager.persist(company);
            entityManager.getTransaction().commit();

            closeConnection();

            return company;
        } catch (ValidationException e){
            throw new ValidationException(e.getMessage());
        }

    }

    @Override
    public Company findById(Long id) throws NoResultException {
        try {
            openConnection();

            Company company = entityManager.find(Company.class, id);
            entityManager.getTransaction().commit();

            closeConnection();

            return company;
        } catch (NoResultException e){
            throw new NoResultException(e.getMessage());
        }
    }

    @Override
    public Company update(Company company) throws NoResultException {
        try {
            openConnection();

            Company updatedCompany = entityManager.merge(company);
            entityManager.getTransaction().commit();

            closeConnection();

            return updatedCompany;
        } catch (NoResultException e){
            throw new NoResultException(e.getMessage());
        }
    }

    @Override
    public Company delete(Company company) throws NoResultException {
        try {
            openConnection();

            Company deletedCompany = entityManager.merge(company);
            entityManager.remove(deletedCompany);
            entityManager.getTransaction().commit();

            closeConnection();

            return deletedCompany;
        } catch (NoResultException e) {
            throw new NoResultException(e.getMessage());
        }
    }

    public boolean isCnpjExists(String cnpj) {
        try {
            return entityManager.createQuery("SELECT COUNT(c) FROM Company c WHERE c.cnpj = :cnpj", Long.class)
                    .setParameter("cnpj", cnpj)
                    .getSingleResult() > 0;
        } catch (NoResultException e) {
            return false;
        }
    }

    private void openConnection() {
        entityManagerFactory = Persistence.createEntityManagerFactory("neomind-jpa");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    private void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
