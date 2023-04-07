package com.tofas.vehicleExpertize.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Table(name="VEHICLE_EQUIPMENT")
@Entity(name = "vehicle_equipment")
public class VehicleEquipment {
    @Id
    @SequenceGenerator(name = "equipment", sequenceName = "SEQ_EQUIPMENT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipment")
    @Column(name="equipment_id",unique = true)
    private Long id;
    @Column(name = "key_name")
    private String keyName;
    @Column(name = "type_name")
    private String typeName;
    @Column(name = "value_name")
    private String valueName;

   private String state;
    @ManyToMany(mappedBy = "vehicleEquipmentSet",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    Set<Vehicle> vehicleSet;
}
