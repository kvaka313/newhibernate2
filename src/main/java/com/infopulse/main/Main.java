package com.infopulse.main;

import com.infopulse.dao.BankDao;
import com.infopulse.dao.ClientDao;
import com.infopulse.dao.DepositDao;
import com.infopulse.entity.*;
import com.infopulse.factory.Factory;
import net.sf.ehcache.CacheManager;

import java.math.BigDecimal;
import java.util.Arrays;
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
      order1.setTotal(new BigDecimal("655"));
      order1.setClient(c);


      Order order2 =new Order();
      order2.setOrderName("order2");
      order2.setTotal(new BigDecimal("345"));
      order2.setClient(c);

      Passport passport =new Passport();
      passport.setPassportNumber("HH7797979");
      c.setPassport(passport);
      passport.setClient(c);


      Bank bank1=new Bank();
      bank1.setBankName("bank1");


      Bank bank2 = new Bank();
      bank2.setBankName("bank2");


      c.setBanks(Arrays.asList(bank1,bank2));

      BankDao bankDao = Factory.getInstance().getBankDao();
      bank1=bankDao.insertBank(bank1);
      bank2=bankDao.insertBank(bank2);

      ClientDao clientDao = Factory.getInstance().getClientDao();
      clientDao.insertClient(c, order1, order2);
      //clientDao.updateClient(c);

      bank1.setClients(Arrays.asList(c));
      bank2.setClients(Arrays.asList(c));

      List<Client> clients = clientDao.getAll();
      for(Client client:clients){
          System.out.println(client.getName());
          System.out.println(client.getSurename());
          System.out.println(client.getAddress().getCountry());
          System.out.println(client.getNameSurename());
      }
      Client badClient = new BadClient();
      badClient.setSurename("Ivanov");
      badClient.setName("Ivan");
      clientDao.insertClient(badClient);
     // bankDao.deletebank(bank1.getId());

      Deposit deposit =new Deposit();
      deposit.setBank_id(10L);
      deposit.setClient_id(20L);

      DepositDao depositDao = Factory.getInstance().getDepositDao();
      depositDao.insertDeposit(deposit);

      OtherDeposit otherDeposit =new OtherDeposit();
      OtherCompositKey otherCompositKey =new OtherCompositKey();
      otherCompositKey.setClient_id(100L);
      otherCompositKey.setBank_id(23L);

      otherDeposit.setCompositKey(otherCompositKey);

      depositDao.insertDeposit(otherDeposit);

      bankDao.getBanksByClientName("Vasya")
              .forEach(bank ->System.out.println(bank.getBankName()));

      bankDao.getBanksByClientNameCriteriaApi("Vasya")
              .forEach(bank ->System.out.println(bank.getBankName()));

      List<ClientSum> clientSums = clientDao.getOrderInformation();
      clientSums.forEach(System.out::println);

      int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
                .getCache("com.infopulse.entity.Client").getSize();
      System.out.println(size);
      Factory factory = Factory.getInstance();
      factory.close();
      //clientSums.forEach(item -> System.out.println(item));
    }
}
