package com.infopulse.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;

public class Client_ {
    public static volatile SingularAttribute<Client, String> name;
    public static volatile SingularAttribute<Client, String> clientId;
    public static volatile SingularAttribute<Client, String> surename;
    public static volatile SingularAttribute<Client, Address> address;
    public static volatile SingularAttribute<Client, Long> id;
    public static volatile ListAttribute<Bank, Order> orders;
    public static volatile SingularAttribute<Client, Passport> passport;
    public static volatile ListAttribute<Client, Bank> banks;

    public static final String NAME = "name";
    public static final String ID = "id";
    public static final String ADDRESS = "address";
    public static final String CLIENT_ID = "clientId";
    public static final String SURENAME = "surename";
    public static final String ORDERS = "orders";
    public static final String PASSPORT = "passport";
    public static final String BANKS = "banks";

}
