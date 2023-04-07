package com.tofas.vehicleExpertize.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTimeUtils {
    public static String formatDateByStringFormat(String format, Long timeStamp) {

        Format formatter = new SimpleDateFormat(format);
        return formatter.format(new Date(timeStamp));
    }

}
