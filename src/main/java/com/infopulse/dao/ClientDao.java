package com.infopulse.dao;

import com.infopulse.entity.Client;
import com.infopulse.entity.Order;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

public class ClientDao {

    private SessionFactory sessionFactory;

    public ClientDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void insertClient(Client c, Order... orders){
        EntityManager entityManager =sessionFactory.createEntityManager();
        c.setOrders(Arrays.asList(orders));
        entityManager.getTransaction().begin();
        entityManager.persist(c);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Client> getAll(){
        EntityManager entityManager =sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Client> clients = entityManager.createQuery("from Client", Client.class).getResultList();
        entityManager.close();
        return clients;
    }

}
