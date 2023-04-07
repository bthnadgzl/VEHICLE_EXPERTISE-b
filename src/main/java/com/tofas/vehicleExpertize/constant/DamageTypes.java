package com.tofas.vehicleExpertize.constant;

public enum DamageTypes {
    COMPLETELY_REPAINTED(1L, "COMPLETELY_REPAINTED", "BOYANMIŞ"),
    COMPLETELY_REPAINTED_DM(2L, "COMPLETELY_REPAINTED_DM", "BOYANMIŞ(SÖK TAK),"),
    PARTLY_REPAINTED(3L, "PARTLY_REPAINTED", "LOKAL BOYANMIŞ"),
    REPLACED(4L, "REPLACED", "DEĞİŞMİŞ"),
    DAMAGED(5L, "DAMAGED", "HASARLI"),
    PAINT_FLAKING(6L, "PAINT_FLAKING", "BOYA ATMASI"),
    PAINT_ERROR(7L, "PAINT_ERROR", "BOYA HATASI"),
    DISCOLORATION(8L, "DISCOLORATION", "BOYA KALINTISI"),
    DEFECT(9L, "DEFECT", "DOLU HASAR ONARIMI GÖRMÜŞ"),
    FLICKER(10L, "FLICKER", "DOLU HASARI"),
    MISSING(11L, "MISSING", "EKSIK"),
    LOOSE(12L, "LOOSE", "EZIK"),
    DENT(13L, "DENT", "GÖÇÜK"),
    CLEANING(14L, "CLEANING", "GÜNEŞ YANIĞI"),
    ODORS(15L, "ODORS", "KOKU"),
    REP_DEFECT(16L, "REP_DEFECT", "KUSURLU"),
    BROKEN(17L, "BROKEN", "KIRIK"),
    STAINED(18L, "STAINED", "LEKE"),
    MOIST(19L, "MOIST", "NEMLI"),
    RUST(20L, "RUST", "PASLANMIŞ"),
    PAINT_REMNANTS(21L, "PAINT_REMNANTS", "RENGI ATMIŞ"),
    COLOR_DIFFERENCE(22L, "COLOR_DIFFERENCE", "RENK FARKLILIĞI"),
    CRACKLED(23L, "CRACKLED", "SES VAR"),
    DULL(24L, "DULL", "SOLUK"),
    HOLE(25L, "HOLE", "SÜRTME"),
    GLUE_REMNANTS(26L, "GLUE_REMNANTS", "TAMIR KALINTILARI"),
    BURN_MARK(27L, "BURN_MARK", "YANIK"),
    STONE_CHIPS(28L, "STONE_CHIPS", "TAŞ IZLERI"),
    WEAR_AND_TEAR(29L, "WEAR_AND_TEAR", "YIPRANMIŞ VE AŞINMIŞ"),
    SEAM(30L, "SEAM", "YIRTIK"),
    CRACKED(31L, "CRACKED", "ÇATLAK"),
    SCRATCH(32L, "SCRATCH", "ÇIZIK"),
    DAMP_STAINED(33L,"DAMP-STAINED","ÇIZIK");

    private long id;
    private String description;
    private String keyName;

    DamageTypes(Long id, String keyName, String description) {
        this.description = description;
        this.id = id;
        this.keyName = keyName;
    }

    public String getKeyName() {
        return keyName;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }
}
