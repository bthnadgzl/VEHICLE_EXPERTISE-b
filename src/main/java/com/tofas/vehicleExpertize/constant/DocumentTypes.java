package com.tofas.vehicleExpertize.constant;

public enum DocumentTypes {
    DESCRIPTION_PDF_TYPE("DETAY BILGILER PDF"),
    DESCRIPTION_XML_TYPE("DETAY BILGILER XML"),
    TOFAS_PRE_INSPECTION_PDF("TOFAŞ ÖN İNCELEME DÖKÜMANI PDF"),
    TOFAS_PRE_INSPECTION_XML("TOFAŞ ÖN İNCELEME DÖKÜMANI XML"),
    SERVIS_GECMISI_PDF("SERVIS GEÇMIŞ DÖKÜMANI XML"),
    SERVIS_GECMISI_CSV("SERVIS GEÇMIŞ DÖKÜMANI CSV");

    private String description;

    DocumentTypes(String description) {
        this.description = description;
    }
}
