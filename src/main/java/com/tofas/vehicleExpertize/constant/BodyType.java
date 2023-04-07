package com.tofas.vehicleExpertize.constant;

public enum BodyType {
    VA("Van"),
    BT("Frame with cabin"),
    CX("Chassis only"),
    CO("Coupe"),
    TA("Targa"),
    T("Tiptronic"),
    FW("MPV"),
    DP("Ext cab pu"),
    CH("Hatchback van"),
    SH("Executive"),
    WT("Frame without cabin"),
    CP("Pick up"),
    RV("Converted box van"),
    ES("Estate"),
    OC("4x4"),
    TR("Heavy Lorry"),
    HA("Hatchback"),
    WV("Van with windows"),
    CA("Convertible"),
    OD("SUV"),
    TS("Tiptronic S"),
    OM("Perfomance sports car"),
    MC("City car"),
    DH("Dob cash cabin"),
    CC("Combi"),
    PV("Box van"),
    SA("Saloon"),
    WH("Chassis wihtout cabin"),
    PU("Super mini"),
    MM("Mini MPV"),
    BH("Cassis with cabin"),
    BP("Single cab pu"),
    CE("Stationcar van"),
    CV("Minivan"),
    BU("BUS");

    private String description;

    BodyType(String description) {
        this.description = description;
    }

    public String getDescription() {

        return description;
    }
}
