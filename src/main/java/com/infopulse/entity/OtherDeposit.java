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
public class OtherDeposit  {

    @EmbeddedId
    private OtherCompositKey compositKey;

    @Column(name = "sum_deposit")
    Double sumDeposit;
}
