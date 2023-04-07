package com.tofas.vehicleExpertize.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Table(name = "VEHICLE_DAMAGE_IMAGE")
@Entity(name = "vehicle_damage_image")
@ToString(exclude = {"vehicleDamage"})
@EqualsAndHashCode(exclude = {"vehicleDamage"})
public class VehicleDamageImage {
    @Id
    @SequenceGenerator(name = "damageImage", sequenceName = "SEQ_DAMAGEIMAGE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "damageImage")
    @Column(name = "damage_image_id", unique = true)
    private long id;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name ="damage_id")
    private VehicleDamage vehicleDamage;

}
