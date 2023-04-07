package com.tofas.vehicleExpertize.model.dto.request;

import lombok.Data;

@Data
public class ExpertiseOfferRequest {
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
}
