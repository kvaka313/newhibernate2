package com.infopulse.dao;

import com.infopulse.entity.Bank;
import com.infopulse.entity.Bank_;
import com.infopulse.entity.Client;
import com.infopulse.entity.Client_;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class BankDao {
    private SessionFactory sessionFactory;

    public BankDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public Bank insertBank(Bank bank){
        EntityManager entityManager =sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(bank);
        entityManager.getTransaction().commit();
        entityManager.close();
        return bank;
    }

    public void deletebank(Long id){
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Bank b where b.id = :id")
                .setParameter("id", id).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Bank> getBanksByClientName(String clientName){
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager
                .createQuery("select b from Bank b inner join b.clients as cl where cl.name=:client_name", Bank.class);
        query.setParameter("client_name", clientName);
        List<Bank> banks =  query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return banks;
    }

    public List<Bank> getBanksByClientNameCriteriaApi(String clientName){
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bank> criteriaQuery = criteriaBuilder.createQuery(Bank.class);
        Root<Bank> rootBank = criteriaQuery.from(Bank.class);
        Root<Client> rootClient = criteriaQuery.from(Client.class);
        Join<Bank, Client> join = rootBank.join(Bank_.clients);

        criteriaQuery = criteriaQuery
                .select(rootBank)
                .where(criteriaBuilder.equal(rootClient.get(Client_.name), clientName));

        List<Bank> banks = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return banks;
    }


}
