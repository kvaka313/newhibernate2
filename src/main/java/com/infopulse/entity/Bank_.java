package com.infopulse.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;

public class Bank_ {
    public static volatile SingularAttribute<Bank, String> bankName;
    public static volatile SingularAttribute<Bank, Long> id;
    public static volatile ListAttribute<Bank, Client> clients;

    public static final String BANK_NAME = "bankName";
    public static final String ID = "id";
    public static final String CLIENTS = "clients";
}
