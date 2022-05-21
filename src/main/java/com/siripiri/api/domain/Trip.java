package com.siripiri.api.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public LocalDate date;
    public Long plantToDistributor;
    public Long distributorToPlant;

    @OneToOne(cascade = CascadeType.ALL)
    public Expenses capShortage;

    @ManyToOne(cascade = CascadeType.ALL)
    public Location location;

    @OneToOne(cascade = CascadeType.ALL)
    public Expenses salary;

    @ManyToOne
    public Driver driver;
}
