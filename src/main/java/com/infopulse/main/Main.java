package com.infopulse.main;

import com.infopulse.dao.ClientDao;
import com.infopulse.entity.Address;
import com.infopulse.entity.Client;
import com.infopulse.factory.Factory;

import java.util.List;

public class Main {
    public static void main(String[] args){
      Client c = new Client();
      c.setName("Vasya");
      c.setSurename("Pupkin");
      Address address =new Address();
      address.setCountry("Ukraine");
      address.setCity("Kiev");
      c.setAddress(address);
      ClientDao clientDao = Factory.getInstance().getClientDao();
      clientDao.insertClient(c);
      List<Client> clients = clientDao.getAll();
      for(Client client:clients){
          System.out.println(client.getName());
          System.out.println(client.getSurename());
          System.out.println(client.getAddress().getCountry());
      }
    }
}
