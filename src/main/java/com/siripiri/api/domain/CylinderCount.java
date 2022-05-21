package com.siripiri.api.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CylinderCount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public int count;

    @ManyToOne(cascade = CascadeType.ALL)
    public Trip trip;

    @OneToOne
    public CylinderDetails cylinderType;
}
