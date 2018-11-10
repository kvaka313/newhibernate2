package com.infopulse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="clients")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="Typeclient", discriminatorType=DiscriminatorType.STRING, length=10)
//@DiscriminatorValue("CLIENT")
public class Client {
    @Id
    @GenericGenerator(name="increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    private Long id;

    @Column(name = "name",nullable = false, unique = false, length = 20)
    @Basic
    private String name;

    @Lob
    @Basic
    @Column(name = "surename",nullable = false, unique = false, length = 20)
    private String surename;

    @Type(type = "com.infopulse.entity.type.AddressType")
    private Address address;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    List<Order> orders;

    @OneToOne(mappedBy = "client", orphanRemoval = true, cascade = CascadeType.ALL)
    private Passport passport;

    @ManyToMany(fetch = FetchType.LAZY)
    List<Bank> banks;
}
