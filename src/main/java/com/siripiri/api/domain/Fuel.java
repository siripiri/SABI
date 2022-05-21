package com.siripiri.api.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public Long currentFuelPrice;
    public Long literFilled;
    public String paymentMode;

    @OneToOne(cascade = CascadeType.ALL)
    public Expenses expenses;
}
