package com.infopulse.factory;

import com.infopulse.dao.ClientDao;
import org.hibernate.SessionFactory;

import javax.persistence.Persistence;

public class Factory {
    public static final Factory factory = new Factory();

    private SessionFactory sessionFactory;

    private ClientDao clientDao;
    private Factory(){
        sessionFactory=(SessionFactory) Persistence
                .createEntityManagerFactory( "org.hibernate.tutorial.jpa" );

    }

    public static Factory getInstance(){
        return factory;
    }

    public synchronized ClientDao getClientDao(){
        if(clientDao!=null) {
            return clientDao;
        }
        clientDao =new ClientDao(sessionFactory);
        return clientDao;
    }

}
