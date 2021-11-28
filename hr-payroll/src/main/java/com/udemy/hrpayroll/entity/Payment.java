package com.udemy.hrpayroll.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Payment {

    private String name;

    private Double dailyIncome;

    private Integer days;

    public Double getTotal(){
        return days * dailyIncome;
    }
}
