package com.infopulse.main;

import com.infopulse.dao.ClientDao;
import com.infopulse.entity.Address;
import com.infopulse.entity.Client;
import com.infopulse.entity.Order;
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
      Order order1 = new Order();
      order1.setOrderName("order1");
      order1.setClient(c);


      Order order2 =new Order();
      order2.setOrderName("order2");
      order2.setClient(c);

      ClientDao clientDao = Factory.getInstance().getClientDao();
      clientDao.insertClient(c, order1, order2);
      List<Client> clients = clientDao.getAll();
      for(Client client:clients){
          System.out.println(client.getName());
          System.out.println(client.getSurename());
          System.out.println(client.getAddress().getCountry());
      }
    }
}
