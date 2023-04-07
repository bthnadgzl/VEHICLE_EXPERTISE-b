package com.tofas.vehicleExpertize.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Table(name = "EXPERTISE_IMAGE")
@Entity(name = "expertise_image")
@ToString(exclude = {"vehicleExpertise"})
public class ExpertiseImage {
    @Id
    @SequenceGenerator(name = "expertise_image", sequenceName = "SEQ_EXPERTISE_IMAGE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expertise_image")
    private Long id;
    private String url;
    private String description;
    @ManyToOne
    @JoinColumn(name = "vehicle_expertise_id")
    private VehicleExpertise vehicleExpertise;
}
