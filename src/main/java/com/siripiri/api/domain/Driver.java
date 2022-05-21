package com.siripiri.api.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public int age;
    public String address;
    public String childrenDetails;

    @OneToOne(cascade = CascadeType.ALL)
    public PhoneNumber phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
    public Set<Trip> trips = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "driver_lorry",
                joinColumns = @JoinColumn(name = "driver_id"),
                inverseJoinColumns = @JoinColumn(name = "lorry_id"))
    public Set<Lorry> Lorry = new HashSet<>();
}
