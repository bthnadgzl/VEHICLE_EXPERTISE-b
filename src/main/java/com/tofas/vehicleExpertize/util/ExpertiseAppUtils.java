package com.tofas.vehicleExpertize.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tofas.vehicleExpertize.constant.DamageLocations;

import java.util.Date;
import java.util.List;

import static com.tofas.vehicleExpertize.constant.DamageLocationReplaceKeys.*;


public class ExpertiseAppUtils {

    public static String replaceDamageLocation(String willBeReplacedString) {

        return willBeReplacedString
                .replace(REPLACE_REPAINTED_PART.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_STANDARD.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_DEFAULT.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_COMPLETELY_REPAINTED_DM.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_COMPLETELY_REPAINTED.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_PARTLY_REPAINTED.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_REPLACED.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_DAMAGED.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_PAINT_FLAKING.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_PAINT_ERROR.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_DISCOLORATION.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_REP_DEFECT.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_DEFECT.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_FLICKER.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_MISSING.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_LOOSE.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_DENT.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_CLEANING.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_ODORS.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_BROKEN.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_DAMP_STAINED.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_MOIST.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_RUST.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_PAINT_REMNANTS.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_COLOR_DIFFERENCE.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_CRACKLED.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_DULL.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_HOLE.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_GLUE_REMNANTS.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_BURN_MARK.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_STONE_CHIPS.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_WEAR_AND_TEAR.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_SEAM.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_CRACKED.trim(), TARGET_REPLACEMENT)
                .replace(REPLACE_SCRATCH.trim(), TARGET_REPLACEMENT).toUpperCase();

    }

    public static boolean checkIsJWTExpired(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt().before(new Date());
    }

    public static String replaceDamageType(String willBeReplacedString) {
        List<DamageLocations> damageLocationsList = List.of(DamageLocations.values());
        for (DamageLocations damageLocation : damageLocationsList) {
            willBeReplacedString = willBeReplacedString.replace("_" + damageLocation.getKeyName().toLowerCase().trim(), TARGET_REPLACEMENT);
        }

        return willBeReplacedString
                .replace(REPLACE_STANDARD.trim(), TARGET_REPLACEMENT)
                .replace("default_".trim(), TARGET_REPLACEMENT)
                .toUpperCase();

    }

}
