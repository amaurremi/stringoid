package com.inmobi.commons.data;

import android.location.Location;
import com.inmobi.commons.EducationType;
import com.inmobi.commons.EthnicityType;
import com.inmobi.commons.GenderType;
import com.inmobi.commons.HasChildren;
import com.inmobi.commons.IMIDType;
import com.inmobi.commons.MaritalStatus;
import com.inmobi.commons.SexualOrientation;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.AutomaticCaptureConfig;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public final class DemogInfo {
    private static int a = 1;
    private static Location b;
    private static EducationType c;
    private static EthnicityType d;
    private static GenderType e;
    private static Calendar f;
    private static Integer g = Integer.valueOf(0);
    private static Integer h = Integer.valueOf(0);
    private static String i;
    private static String j;
    private static String k;
    private static String l;
    private static HasChildren m;
    private static MaritalStatus n;
    private static String o;
    private static SexualOrientation p;
    private static Map<IMIDType, String> q = new HashMap();

    public static void addIDType(IMIDType paramIMIDType, String paramString) {
        if (q != null) {
            q.put(paramIMIDType, paramString);
        }
    }

    public static Integer getAge() {
        return h;
    }

    public static String getAreaCode() {
        return l;
    }

    public static Location getCurrentLocation() {
        return b;
    }

    public static Calendar getDateOfBirth() {
        return f;
    }

    public static int getDeviceIDMask() {
        return a;
    }

    public static EducationType getEducation() {
        return c;
    }

    public static EthnicityType getEthnicity() {
        return d;
    }

    public static GenderType getGender() {
        return e;
    }

    public static HasChildren getHasChildren() {
        return m;
    }

    public static String getIDType(IMIDType paramIMIDType) {
        if (q != null) {
            return (String) q.get(paramIMIDType);
        }
        return null;
    }

    public static Integer getIncome() {
        return g;
    }

    public static String getInterests() {
        return i;
    }

    public static String getLanguage() {
        return o;
    }

    public static String getLocationWithCityStateCountry() {
        return j;
    }

    public static MaritalStatus getMaritalStatus() {
        return n;
    }

    public static String getPostalCode() {
        return k;
    }

    public static SexualOrientation getSexualOrientation() {
        return p;
    }

    public static boolean isLocationInquiryAllowed() {
        return AnalyticsInitializer.getConfigParams().getAutomaticCapture().isAutoLocationCaptureEnabled();
    }

    public static void removeIDType(IMIDType paramIMIDType) {
        if (q != null) {
            q.remove(paramIMIDType);
        }
    }

    public static void setAge(Integer paramInteger) {
        h = paramInteger;
    }

    public static void setAreaCode(String paramString) {
        l = paramString;
    }

    public static void setCurrentLocation(Location paramLocation) {
        b = paramLocation;
    }

    public static void setDateOfBirth(Calendar paramCalendar) {
        f = paramCalendar;
    }

    public static void setDeviceIDMask(int paramInt) {
        a = paramInt;
    }

    public static void setEducation(EducationType paramEducationType) {
        c = paramEducationType;
    }

    public static void setEthnicity(EthnicityType paramEthnicityType) {
        d = paramEthnicityType;
    }

    public static void setGender(GenderType paramGenderType) {
        e = paramGenderType;
    }

    public static void setHasChildren(HasChildren paramHasChildren) {
        m = paramHasChildren;
    }

    public static void setIncome(Integer paramInteger) {
        g = paramInteger;
    }

    public static void setInterests(String paramString) {
        i = paramString;
    }

    public static void setLanguage(String paramString) {
        o = paramString;
    }

    public static void setLocationWithCityStateCountry(String paramString1, String paramString2, String paramString3) {
        if ((paramString1 != null) && (!"".equals(paramString1.trim()))) {
            j = paramString1;
        }
        if ((paramString2 != null) && (!"".equals(paramString2.trim()))) {
            j = j + "-" + paramString2;
        }
        if ((paramString3 != null) && (!"".equals(paramString3.trim()))) {
            j = j + "-" + paramString3;
        }
    }

    public static void setMaritalStatus(MaritalStatus paramMaritalStatus) {
        n = paramMaritalStatus;
    }

    public static void setPostalCode(String paramString) {
        k = paramString;
    }

    public static void setSexualOrientation(SexualOrientation paramSexualOrientation) {
        p = paramSexualOrientation;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/data/DemogInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */