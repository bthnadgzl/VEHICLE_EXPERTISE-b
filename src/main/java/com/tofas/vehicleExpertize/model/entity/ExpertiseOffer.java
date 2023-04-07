package com.tofas.vehicleExpertize.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "EXPERTISE_OFFER")
@Entity(name = "expertise_offer")
public class ExpertiseOffer {
    @Id
    @SequenceGenerator(name = "offer", sequenceName = "SEQ_OFFER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offer")
    @Column(unique = true)
    private Long id;
    private Double purchaseForecastDealerPriceDifference;
    private Double customerRequest;
    private Double customerAndAutorolaPriceDifference;
    private Double tofasPurchaseGuaranteedPrice;
    private Boolean isSold;
    private Double recommendedDealerPurchasePrice;
    private Double realizedPurchaseTradeInDealerPrice;
    private String purchaseNotary;
    private Double notaryPurchasePrice;
    private Double tofasAndPurchasePriceDifference;
    private Double tofasAndPurchasePercentileDifference;
    private Double recommendedSellingPrice;
    private Double dealerPurchaseOffer;
    private Double autorolaPurchaseOffer;
    private Double indicataB2BPrice;
    private Double tradeInPrice;
    private String pricingNote;
    @OneToOne
    @JoinColumn(name="vehicle_expertise_id")
    private VehicleExpertise vehicleExpertise;
}
