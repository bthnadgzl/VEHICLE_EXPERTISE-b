package com.tofas.vehicleExpertize.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Table(name = "VEHICLE")
@Entity(name = "vehicle")
@ToString(exclude = {"vehicleEquipmentSet","vehicleExpertiseSet"})
@EqualsAndHashCode(exclude = {"vehicleEquipmentSet","vehicleExpertiseSet"})
public class Vehicle {
    @Id
    @Column(unique = true)
    private String vin;
    private String brand;
    private String model;
    private String variant;
    @Column(name = "inserted_by")
    private String insertedBy;
    @Column(name = "inserted_date")
    private LocalDate insertedDate = LocalDate.now();
    @Column(name = "created_at")
    private LocalDateTime createdAt;//Autorola created date
    private String category;//car category -Binek, - Ticari, -TANIMSIZ
    @Column(name = "model_year")
    private Integer modelYear;
    private String segment;
    @Column(name = "body_type")
    private String bodyType;
    @Column(name = "fuel_type")
    private String fuelType;
    private String engine;
    private String transmission;
    private Integer hp;
    private Integer kw;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @ManyToMany
    @JoinTable(name = "vehicle__vehicle_quipment",
            joinColumns = @JoinColumn(name = "vin"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private Set<VehicleEquipment> vehicleEquipmentSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
    private Set<VehicleExpertise> vehicleExpertiseSet;
}
