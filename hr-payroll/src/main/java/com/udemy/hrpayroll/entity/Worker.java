package com.udemy.hrpayroll.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Worker {

    private Long id;

    private String name;

    private Double dailyIncome;
}
