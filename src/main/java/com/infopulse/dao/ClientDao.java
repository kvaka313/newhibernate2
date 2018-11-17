package com.infopulse.dao;

import com.infopulse.entity.Client;
import com.infopulse.entity.ClientSum;
import com.infopulse.entity.Order;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

    public void updateClient(Client c, Order... orders){
        EntityManager entityManager =sessionFactory.createEntityManager();
        c.setOrders(Arrays.asList(orders));
        entityManager.getTransaction().begin();
        entityManager.merge(c);
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

    public List<ClientSum> getOrderInformation(){
        EntityManager entityManager =sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager
                .createQuery("select new com.infopulse.entity.ClientSum(cl.name, sum(ord.total)) from Client cl inner join cl.orders as ord group by cl.name having sum(ord.total)>100", ClientSum.class);
        List<ClientSum> clientSums = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return clientSums;
    }

}
