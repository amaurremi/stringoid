package com.mopub.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateAndTime {
    protected static DateAndTime a = new DateAndTime();

    public static String getTimeZoneOffsetString() {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("Z");
        localSimpleDateFormat.setTimeZone(localTimeZone());
        return localSimpleDateFormat.format(now());
    }

    public static TimeZone localTimeZone() {
        return a.internalLocalTimeZone();
    }

    public static Date now() {
        return a.internalNow();
    }

    @Deprecated
    public static void setInstance(DateAndTime paramDateAndTime) {
        a = paramDateAndTime;
    }

    public TimeZone internalLocalTimeZone() {
        return TimeZone.getDefault();
    }

    public Date internalNow() {
        return new Date();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/DateAndTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */