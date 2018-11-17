package com.infopulse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class ClientSum {
    private String clientname;
    private BigDecimal totalSum;

}
