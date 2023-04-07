package com.tofas.vehicleExpertize.util;

import com.tofas.vehicleExpertize.constant.*;
import com.tofas.vehicleExpertize.model.FYA.ValuationResult;
import com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.AutorolaXMLFileResponse;
import com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.XMLFileData;
import com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.damage.AutorolaDamage;
import com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.damage.AutorolaDamagePicture;
import com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.equipment.AutorolaEquipment;
import com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.picture.AutorolaVehiclePicture;
import com.tofas.vehicleExpertize.model.autorola.vehicle.AutorolaContract;
import com.tofas.vehicleExpertize.model.autorola.vehicle.AutorolaVehicleResponse;
import com.tofas.vehicleExpertize.model.autorola.vehicle.AutorolaVehicleTradeIn;
import com.tofas.vehicleExpertize.model.dto.response.VehicleExpertiseResponse;
import com.tofas.vehicleExpertize.model.entity.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.tofas.vehicleExpertize.util.DateTimeUtils.formatDateByStringFormat;
import static com.tofas.vehicleExpertize.util.StringUtils.replaceDamageLocation;
import static com.tofas.vehicleExpertize.util.StringUtils.replaceDamageType;
import static java.util.Objects.isNull;


@AllArgsConstructor
@Component
public class Mapper {

    private final String VALUATION_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private final ModelMapper modelMapper;

    public Vehicle mapToVehicleEntity(AutorolaVehicleResponse vehicleResponse, AutorolaXMLFileResponse xmlFileResponse) {
        //region VARIABLES
        var vehicleInformation = vehicleResponse.getAutorolaVehicleInformation();
        var vehicleSpecification = vehicleResponse.getAutorolaVehicleSpecification();
        var vehicleTradeIn = vehicleResponse.getAutorolaVehicleTradeIn();
        var vehicleData = xmlFileResponse.getXmlFileData().getVehicleData().getAutorolaVehicleData();
        var standardVehicleEquipment = xmlFileResponse.getXmlFileData().getAutorolaVehicleEquipment().getStandardAutorolaEquipment();
        var vehicleReference = xmlFileResponse.getXmlFileData().getVehicleData().getAutorolaVehicleReference();
        //endregion
        //region MAPPING VEHICLE NONRELATION PROPERTIES
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(vehicleSpecification.getBrand().toUpperCase());
        vehicle.setModel(vehicleSpecification.getModel().toUpperCase());
        vehicle.setVariant(vehicleSpecification.getVariant().toUpperCase());
        vehicle.setVin(vehicleReference.getVin().toUpperCase());
        vehicle.setCreatedAt(vehicleTradeIn.getVehicleCreateDate().toLocalDateTime());
        vehicle.setCategory(VehicleCategory.valueOf(vehicleInformation.getCategory().name()).getDescription());
        vehicle.setModelYear(vehicleData.getModelYear());
        vehicle.setBodyType(BodyType.valueOf(vehicleSpecification.getBodyType()).getDescription());
        vehicle.setFuelType(vehicleData.getFuelType().toUpperCase());
        vehicle.setTransmission(vehicleData.getTransmission().toUpperCase());
        vehicle.setKw(vehicleSpecification.getKw());
        vehicle.setHp(vehicleSpecification.getHp());
        //endregion
        //region MAPPING VEHICLE RELATION PROPERTIES
        mapVehicleEquipment(standardVehicleEquipment, vehicle);
        mapVehicleExpertise(vehicleResponse, xmlFileResponse, vehicle);
        //endregion
        return vehicle;
    }

    public VehicleExpertise mapToVehicleExpertiseEntity(AutorolaVehicleResponse vehicleResponse, AutorolaXMLFileResponse xmlFileResponse) {
        //region DECLARED VARIABLES
        var xmlFileData = xmlFileResponse.getXmlFileData();
        var vehicleTradeIn = vehicleResponse.getAutorolaVehicleTradeIn();
        var vehicleContract = vehicleResponse.getAutorolaContract();
        var vehicleCondition = xmlFileData.getCondition();
        var vehicleReference = xmlFileData.getVehicleData().getAutorolaVehicleReference();
        var vehicleData = xmlFileData.getVehicleData().getAutorolaVehicleData();
        //endregion
        //region MAPPING OF VEHICLE EXPERTISE NONRELATIONAL PROPERTIES
        VehicleExpertise vehicleExpertise = new VehicleExpertise();
        vehicleExpertise.setCondition(vehicleCondition.getCosmetic().toUpperCase());
        vehicleExpertise.setKm(vehicleData.getKm().getValue());
        vehicleExpertise.setExpertiseFileUrl("XML FILE URL ");
        vehicleExpertise.setExpertiseReportUrl(xmlFileData.getAutorolaReports().getExpertiseReportUrl());
        vehicleExpertise.setLicencePlate(vehicleReference.getLicencePlate().toUpperCase());
        //vehicleExpertise.setOtherDamageInfo(VehicleCategory.valueOf(vehicleInformation.getCategory().name()).getDescription());
        if (!isNull(xmlFileData.getVehicleData().getVehicleEquipmentAccessories())) {
            vehicleExpertise.setDealerNote(xmlFileData.getVehicleData().getVehicleEquipmentAccessories().getNotes().toUpperCase());
        }
        //endregion
        //region MAP RELATIONAL ENTITIES OF VEHICLE EXPERTISE
        mapDealerEntityForExpertise(vehicleContract, vehicleExpertise);
        mapExpertiseImageEntitySetForExpertise(xmlFileData, vehicleExpertise);
        mapOfferEntityForExpertise(vehicleTradeIn, vehicleExpertise);
        mapDamageEntityForExpertise(vehicleExpertise, xmlFileData);
        //endregion
        return vehicleExpertise;
    }

    public VehicleExpertiseResponse mapVehicleExpertiseEntityToVehicleExpertiseResponse(Integer vehicleId, Vehicle savedData) {

        VehicleExpertiseResponse response = new VehicleExpertiseResponse();
        response.setSavedVin(savedData.getVin());
        response.setSavedVehicleId(vehicleId);
        response.setDateTime(LocalDateTime.now().toString());
        return response;
    }

    public <S, T> List<T> mapSourceListToTargetList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    public <T> T mapSourceToTarget(Object source, Class<T> resultClass) {
        return modelMapper.map(source, resultClass);
    }

    public void mapSourceToTargetForExistingObject(Object source, Object target) {
        modelMapper.map(source, target);
    }


    private void mapVehicleExpertise(AutorolaVehicleResponse vehicleResponse, AutorolaXMLFileResponse xmlFileResponse, Vehicle vehicle) {
        var expertiseEntity = mapToVehicleExpertiseEntity(vehicleResponse, xmlFileResponse);
        Set<VehicleExpertise> vehicleExpertiseList = new HashSet<>();
        expertiseEntity.setVehicle(vehicle);
        vehicleExpertiseList.add(expertiseEntity);
        vehicle.setVehicleExpertiseSet(vehicleExpertiseList);
    }

    private void mapVehicleEquipment(List<AutorolaEquipment> standardVehicleAutorolaEquipment, Vehicle vehicle) {
        Set<VehicleEquipment> vehicleEquipmentSet = new HashSet<>();
        for (AutorolaEquipment autorolaEquipment : standardVehicleAutorolaEquipment) {
            var equipmentId = VehicleEquipments.valueOf("_" + autorolaEquipment.getId().toUpperCase()).getId();
            VehicleEquipment vehicleEquipment = new VehicleEquipment();
            vehicleEquipment.setId(equipmentId);
            vehicleEquipmentSet.add(vehicleEquipment);
        }
        vehicle.setVehicleEquipmentSet(vehicleEquipmentSet);
    }

    private void mapDamageEntityForExpertise(VehicleExpertise vehicleExpertise, XMLFileData xmlFileData) {
        var vehicleDamages = xmlFileData.getAutorolaDamages().getAutorolaDamage();
        var vehicleDamagePictures = xmlFileData.getAutorolaDamages().getAutorolaDamagePictures().getPicturelist();
        Set<VehicleDamage> damageList = new HashSet<>();
        for (AutorolaDamage autorolaDamage : vehicleDamages) {
            VehicleDamage vehicleDamage = new VehicleDamage();
            vehicleDamage.setVehicleExpertise(vehicleExpertise);
            String replacedLocationKey = replaceDamageLocation(autorolaDamage.getLocation().getName());
            DamageLocations damageLocationEnum = DamageLocations.valueOf("_" + replacedLocationKey);

            mapDamageLocationEntityForVahicleDamage(damageLocationEnum, vehicleDamage);
            var dtype = mapDamageTypeEntityForVehicleDamage(autorolaDamage, vehicleDamage);

            for (AutorolaDamagePicture autorolaDamagePicture : vehicleDamagePictures
            ) {
                String imageName = autorolaDamagePicture.getDamage();
                String replacedImgForDamageLocation = replaceDamageLocation(imageName.toLowerCase());
                String replacedImgForDamageType = replaceDamageType(imageName.toLowerCase());
                if (replacedImgForDamageLocation.equalsIgnoreCase(damageLocationEnum.getKeyName()) && replacedImgForDamageType.equalsIgnoreCase(dtype.getKeyName())) {
                    VehicleDamageImage vehicleDamageImage = new VehicleDamageImage();
                    vehicleDamageImage.setVehicleDamage(vehicleDamage);
                    vehicleDamageImage.setImageUrl(autorolaDamagePicture.getContent());
                    vehicleDamage.getDamageImageList().add(vehicleDamageImage);
                }
            }
            vehicleDamage.setDamageType(dtype);
            damageList.add(vehicleDamage);
        }
        vehicleExpertise.setVehicleDamageSet(damageList);
    }

    private VehicleDamageType mapDamageTypeEntityForVehicleDamage(AutorolaDamage autorolaDamage, VehicleDamage vehicleDamage) {
        VehicleDamageType vehicleDamageType = new VehicleDamageType();
        String replacedTypeKey = autorolaDamage.getType().getName().replace("-", "_");
        DamageTypes damageTypeEnum = DamageTypes.valueOf(replacedTypeKey.toUpperCase());
        vehicleDamageType.setId(damageTypeEnum.getId());
        vehicleDamageType.setKeyName(damageTypeEnum.getKeyName());
        vehicleDamageType.getDamages().add(vehicleDamage);
        vehicleDamage.setDamageType(vehicleDamageType);
        return vehicleDamageType;
    }

    private void mapDamageLocationEntityForVahicleDamage(DamageLocations damageLocations, VehicleDamage vehicleDamage) {
        VehicleDamageLocation damageLocation = new VehicleDamageLocation();
        vehicleDamage.setDamageLocation(damageLocation);
        damageLocation.setId(damageLocations.getId());
        damageLocation.getDamages().add(vehicleDamage);
    }

    private void mapOfferEntityForExpertise(AutorolaVehicleTradeIn autorolaVehicleTradeIn, VehicleExpertise vehicleExpertise) {

        //region EXPERTISE OFFER MAPPING
        ExpertiseOffer expertiseOffer = new ExpertiseOffer();
        //ARAC SATIN ALINDI MI?
        expertiseOffer.setIsSold(autorolaVehicleTradeIn.getAcceptPrice());
        //AUTOROLA SATIN ALMA TEKLIFI
        expertiseOffer.setAutorolaPurchaseOffer(autorolaVehicleTradeIn.getTradeInPrice());
        expertiseOffer.setVehicleExpertise(vehicleExpertise);
        vehicleExpertise.setExpertiseOffer(expertiseOffer);
        //endregi̇on

        //region DONT HAVE INFO ABUT THESE PROPERTIES
        //TOFAS ALIM GARANTILI FIYAT
        //expertiseOffer.setTofasPurchaseGuaranteedPrice(vehicleTradeIn.getTradeInPrice());

        //BAYİ ALIŞ TEKLİFİ
        //expertiseOffer.setDealerPurchaseOffer(23.0);

        //MÜŞTERİ AUTOROLA FARKI
        //expertiseOffer.setCustomerAndAutorolaPriceDifference();

        //FIYATLANDIRMA NOTU
        //expertiseOffer.setPricingNote();

        //MÜŞTERİ TALEBİ
        // expertiseOffer.setCustomerRequest();

        // expertiseOffer.setIndicataB2BPrice();

        //TOFAS ALIM-BAYİ FARK YÜZDE
        // expertiseOffer.setTofasAndPurchasePercentileDifference();

        //TOFAS ALIM-BAYİ FARK
        // expertiseOffer.setTofasAndPurchasePriceDifference();

        //NOTER ALIM FİYATI
        //expertiseOffer.setNotaryPurchasePrice();

        //TAVSİYE EDİLEN SATIŞ FİYATI
        //expertiseOffer.setRecommendedSellingPrice();

        //TAVSİYE EDİLEN BAYİ ALIŞ FİYATI
        //expertiseOffer.setRecommendedDealerPurchasePrice();

        //NOTER ALIM FİYATI
        //expertiseOffer.setPurchaseNotary();

        //SATIN ALMA ÖNGÖRÜSÜ İLE BAYİ FİYATI FARKI
        //expertiseOffer.setPurchaseForecastDealerPriceDifference();

        //GERÇEKLEŞEN ALIŞ TRADE-IN APP BAYİ BEYANI
        //expertiseOffer.setRealizedPurchaseTradeInDealerPrice();
        //endregion
    }

    private Set<ExpertiseImage> mapExpertiseImageEntitySetForExpertise(XMLFileData xmlFileData, VehicleExpertise vehicleExpertise) {
        Set<ExpertiseImage> expertiseImageEntities = new HashSet<>();
        for (AutorolaVehiclePicture picture : xmlFileData.getAutorolaVehiclePictures().getAutorolaVehiclePicture()) {
            ExpertiseImage expertiseImage = new ExpertiseImage();
            expertiseImage.setUrl(picture.getContent());
            expertiseImage.setDescription(picture.getDescription().toUpperCase());
            expertiseImageEntities.add(expertiseImage);
            expertiseImage.setVehicleExpertise(vehicleExpertise);
        }
        vehicleExpertise.setExpertiseImageSet(expertiseImageEntities);
        return expertiseImageEntities;
    }

    private void mapDealerEntityForExpertise(AutorolaContract vehicleAutorolaContract, VehicleExpertise vehicleExpertise) {
        Dealer dealer = new Dealer();
        dealer.setDealerId("1");
        dealer.getVehicleExpertiseEntities().add(vehicleExpertise);
        vehicleExpertise.setDealer(dealer);
    }

    public ValuationResult mapValuationResult(Integer vehicleId, Double price, Long timeStamp) {
        ValuationResult valuationResult = new ValuationResult();
        valuationResult.setCarId(String.valueOf(vehicleId));
        valuationResult.setValuationAmount(String.valueOf(price));
        valuationResult.setValuationStatus(price.intValue());
        String formattedDate = formatDateByStringFormat(VALUATION_DATE_TIME_FORMAT, timeStamp);
        valuationResult.setValuationDate(formattedDate);

        return valuationResult;
    }

}
