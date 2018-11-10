package com.infopulse.factory;

import com.infopulse.dao.BankDao;
import com.infopulse.dao.ClientDao;
import com.infopulse.dao.DepositDao;
import org.hibernate.SessionFactory;

import javax.persistence.Persistence;

public class Factory {
    public static final Factory factory = new Factory();

    private SessionFactory sessionFactory;

    private ClientDao clientDao;
    private BankDao bankDao;
    private DepositDao depositDao;
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

    public synchronized DepositDao getDepositDao(){
        if(depositDao!=null) {
            return depositDao;
        }
        depositDao =new DepositDao(sessionFactory);
        return depositDao;
    }

    public synchronized BankDao getBankDao(){
        if(bankDao!=null) {
            return bankDao;
        }
        bankDao =new BankDao(sessionFactory);
        return bankDao;
    }

}
