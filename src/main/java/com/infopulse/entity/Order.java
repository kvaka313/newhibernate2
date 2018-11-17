package com.infopulse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GenericGenerator(name="increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    private Long id;

    @Column(name = "order_name",nullable = false, unique = false, length = 20)
    @Basic
    private String orderName;

    @Column(name = "order_sum",nullable = false, unique = false)
    @Basic
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "myclient_id", referencedColumnName = "id")
    Client client;
}
