package com.infopulse.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="deposits")
@IdClass(CompositKey.class)
public class Deposit {

    @Id
    Long client_id;

    @Id
    Long bank_id;

    @Column(name = "sum_deposit")
    Double sumDeposit;
}
