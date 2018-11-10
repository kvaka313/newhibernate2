package com.infopulse.dao;

import com.infopulse.entity.Bank;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

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
}
