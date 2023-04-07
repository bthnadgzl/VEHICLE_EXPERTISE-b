package com.tofas.vehicleExpertize.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Data
@Table(name = "VEHICLE_EXPERTISE")
@Entity(name = "vehicle_expertise")
@ToString(exclude = {"vehicle", "dealer", "expertiseImageSet", "expertiseOffer", "vehicleDamageSet"})
@EqualsAndHashCode(exclude = {"vehicle", "dealer", "expertiseImageSet", "expertiseOffer", "vehicleDamageSet"})
public class VehicleExpertise {
    @Id
    @SequenceGenerator(name = "expertise", sequenceName = "SEQ_EXPERTISE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expertise")
    @Column(name = "expertise_id", unique = true)
    private Long id;
    @Column(name = "expertise_file_url")
    private String expertiseFileUrl;
    @Column(name = "expertise_report_url")
    private String expertiseReportUrl;
    @Column(name = "dealer_note")
    private String dealerNote;
    private String km;
    @Column(name = "licence_plate")
    private String licencePlate;
    private String condition;
    @Column(name = "expertise_date")
    private LocalDate expertiseDate;
    @Column(name = "other_damage_info")
    private String otherDamageInfo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vin")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleExpertise")
    private Set<ExpertiseImage> expertiseImageSet;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vehicleExpertise")
    private ExpertiseOffer expertiseOffer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleExpertise")
    private Set<VehicleDamage> vehicleDamageSet;
}
