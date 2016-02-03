package com.quoord.xmlrpc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class IsoDate {
    public static final int DATE = 1;
    public static final int DATE_TIME = 3;
    public static final int TIME = 2;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HH:mm:ss");

    public static String dateToString(Date paramDate, int paramInt) {
        return dateFormat.format(paramDate);
    }

    static void dd(StringBuffer paramStringBuffer, int paramInt) {
        paramStringBuffer.append((char) (paramInt / 10 + 48));
        paramStringBuffer.append((char) (paramInt % 10 + 48));
    }

    public static Date stringToDate(String paramString, int paramInt) {
        Calendar localCalendar = Calendar.getInstance();
        if (paramInt != 3) {
            localCalendar.setTime(new Date(0L));
        }
        String str = paramString;
        if ((paramInt & 0x1) != 0) {
            localCalendar.set(1, Integer.parseInt(paramString.substring(0, 4)));
            localCalendar.set(2, Integer.parseInt(paramString.substring(4, 6)) - 1 + 0);
            localCalendar.set(5, Integer.parseInt(paramString.substring(6, 8)));
            str = paramString;
            if (paramInt == 3) {
                str = paramString.substring(9);
            }
        }
        if ((paramInt & 0x2) == 0) {
            return localCalendar.getTime();
        }
        localCalendar.set(11, Integer.parseInt(str.substring(0, 2)));
        localCalendar.set(12, Integer.parseInt(str.substring(3, 5)));
        localCalendar.set(13, Integer.parseInt(str.substring(6, 8)));
        paramString = str.substring(8);
        localCalendar.set(14, 0);
        localCalendar.setTimeZone(TimeZone.getTimeZone("GMT" + paramString));
        return localCalendar.getTime();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/xmlrpc/IsoDate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */