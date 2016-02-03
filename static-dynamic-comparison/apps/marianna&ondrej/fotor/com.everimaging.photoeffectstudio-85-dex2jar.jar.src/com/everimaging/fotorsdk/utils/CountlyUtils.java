package com.everimaging.fotorsdk.utils;

import a.a.a.a.b;
import android.content.Context;

import java.util.Map;

public class CountlyUtils {
    private static final String COUNTLY_SERVER_URL = "http://ELB-countly-1348657816.us-west-2.elb.amazonaws.com";
    private static boolean isInitial = false;

    public static void initCountly(Context paramContext, String paramString) {
        if (!isInitial) {
            b.a().a(paramContext, "http://ELB-countly-1348657816.us-west-2.elb.amazonaws.com", paramString);
            isInitial = true;
        }
    }

    public static void logEvent(String paramString) {
        b.a().a(paramString, 1);
    }

    public static void logEvent(String paramString, Map<String, String> paramMap) {
        b.a().a(paramString, paramMap, 1);
    }

    public static void startCountly() {
        b.a().b();
    }

    public static void stopCountly() {
        b.a().c();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/CountlyUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */