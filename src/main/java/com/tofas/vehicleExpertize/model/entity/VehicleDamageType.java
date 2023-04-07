package com.tofas.vehicleExpertize.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "VEHICLE_DAMAGE_TYPE")
@Entity(name = "vehicle_damage_type")
@ToString(exclude = {"damages"})
@EqualsAndHashCode(exclude = {"damages"})
public class VehicleDamageType {
    @Id
    @Column(name = "damage_type_id", unique = true)
    private long id;
    @Column(name = "key_name")
    private String keyName;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "damageType")
    private Set<VehicleDamage> damages = new HashSet<>();



}
