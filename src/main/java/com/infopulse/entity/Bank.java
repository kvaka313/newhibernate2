package com.infopulse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="banks")
public class Bank {

    @Id
    @GenericGenerator(name="increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    private Long id;

    @Column(name = "bank_name",nullable = false, unique = false, length = 20)
    @Basic
    private String bankName;

    @ManyToMany(mappedBy = "banks")
    List<Client> clients;
}
