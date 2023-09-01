package br.com.neomind.lucasbdourado.backend.dao;

import br.com.neomind.lucasbdourado.backend.domain.Company;

import javax.persistence.*;
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
    public Company create(Company company) throws Exception {
        try {
            openConnection();

            if(isCnpjExists(company.getCnpj())) throw new Exception("O CNPJ informado já existe.");


            entityManager.persist(company);
            entityManager.getTransaction().commit();

            closeConnection();

            return company;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Company findById(Long id) throws Exception {
        try {
            openConnection();

            Company company = entityManager.find(Company.class, id);
            entityManager.getTransaction().commit();

            closeConnection();

            return company;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Company update(Company company) throws Exception {
        try {
            openConnection();

            Company updatedCompany = entityManager.merge(company);
            entityManager.getTransaction().commit();

            closeConnection();

            return updatedCompany;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Company delete(Company company) throws Exception {
        try {
            openConnection();

            Company deletedCompany = entityManager.merge(company);
            entityManager.remove(deletedCompany);
            entityManager.getTransaction().commit();

            closeConnection();

            return deletedCompany;
        } catch (NoResultException e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean isCnpjExists(String cnpj) {
        try {
            Boolean isCnpjExists = entityManager.createQuery("SELECT COUNT(c) FROM Company c WHERE c.cnpj = :cnpj", Long.class)
                    .setParameter("cnpj", cnpj)
                    .getSingleResult() > 0;

            return isCnpjExists;
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
