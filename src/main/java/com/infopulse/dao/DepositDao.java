package com.infopulse.dao;

import com.infopulse.entity.Client;
import com.infopulse.entity.Deposit;
import com.infopulse.entity.Order;
import com.infopulse.entity.OtherDeposit;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.Arrays;

public class DepositDao {
    private SessionFactory sessionFactory;

    public DepositDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void insertDeposit(Deposit deposit){
        EntityManager entityManager =sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(deposit);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void insertDeposit(OtherDeposit deposit){
        EntityManager entityManager =sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(deposit);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
