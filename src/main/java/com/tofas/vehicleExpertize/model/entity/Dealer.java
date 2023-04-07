package com.tofas.vehicleExpertize.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity(name = "DEALER")
@Table(name = "dealer")
@ToString(exclude = {"vehicleExpertiseEntities"})
public class Dealer {
    @Id
    @Column(name = "dealer_id", unique = true)
    private String dealerId;

    @Column(name = "dealer_name")
    private String dealerName;

    @OneToMany(mappedBy = "dealer")
    private Set<VehicleExpertise> vehicleExpertiseEntities = new HashSet<>();
}
