package com.tofas.vehicleExpertize.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "VEHICLE_DAMAGE")
@Entity(name = "vehicle_damage")
@ToString(exclude = {"damageLocation", "vehicleExpertise"})
@EqualsAndHashCode(exclude = {"damageLocation", "vehicleExpertise"})

public class VehicleDamage {
    @Id
    @SequenceGenerator(name = "damage", sequenceName = "SEQ_DAMAGE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "damage")
    @Column(name = "damage_id", unique = true)
    private long id;
    @ManyToOne
    @JoinColumn(name = "expertise_id")
    private VehicleExpertise vehicleExpertise;

    @ManyToOne
    @JoinColumn(name = "damage_location_id")
    private VehicleDamageLocation damageLocation;

    @ManyToOne
    @JoinColumn(name = "damage_type_id")
    private VehicleDamageType damageType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleDamage")
    private Set<VehicleDamageImage> damageImageList = new HashSet<>();
}
