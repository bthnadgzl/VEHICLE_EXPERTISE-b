package com.tofas.vehicleExpertize.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "VEHICLE_DAMAGE_LOCATION")
@Entity(name = "vehicle_damage_location")
@ToString(exclude = {"damages"})
@EqualsAndHashCode(exclude = {"damages"})
public class VehicleDamageLocation {
    @Id
    @Column(name = "damage_location_id", unique = true)
    private long id;
    @Column(name = "key_name")
    private String keyName;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "damageLocation")
    private Set<VehicleDamage> damages = new HashSet<>();


}
