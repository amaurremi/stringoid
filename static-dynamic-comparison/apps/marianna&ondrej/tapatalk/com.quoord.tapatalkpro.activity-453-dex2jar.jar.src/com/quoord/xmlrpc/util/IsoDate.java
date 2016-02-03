package com.quoord.xmlrpc.util;

import java.util.Calendar;
import java.util.Date;

public class IsoDate {
    public static String dateToString(Date paramDate) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(paramDate);
        int i = localCalendar.get(1);
        String str = "" + i;
        i = localCalendar.get(2) + 1;
        paramDate = str;
        if (i < 10) {
            paramDate = str + '0';
        }
        str = paramDate + i;
        i = localCalendar.get(5);
        paramDate = str;
        if (i < 10) {
            paramDate = str + '0';
        }
        str = paramDate + i + 'T';
        i = localCalendar.get(11);
        paramDate = str;
        if (i < 10) {
            paramDate = str + '0';
        }
        str = paramDate + i + ':';
        i = localCalendar.get(12);
        paramDate = str;
        if (i < 10) {
            paramDate = str + '0';
        }
        str = paramDate + i + ':';
        i = localCalendar.get(13);
        paramDate = str;
        if (i < 10) {
            paramDate = str + '0';
        }
        return paramDate + i;
    }

    public static Date stringToDate(String paramString) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.set(1, Integer.parseInt(paramString.substring(0, 4)));
        localCalendar.set(2, Integer.parseInt(paramString.substring(4, 6)) - 1);
        localCalendar.set(5, Integer.parseInt(paramString.substring(6, 8)));
        localCalendar.set(11, Integer.parseInt(paramString.substring(9, 11)));
        localCalendar.set(12, Integer.parseInt(paramString.substring(12, 14)));
        localCalendar.set(13, Integer.parseInt(paramString.substring(15)));
        localCalendar.set(14, 0);
        return localCalendar.getTime();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/xmlrpc/util/IsoDate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */