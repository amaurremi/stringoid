package com.inmobi.commons.data;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

import java.util.List;

public class LocationInfo {
    public static int LOCATION_SET_BY_PUB = 0;
    public static int LOCATION_SET_BY_SDK = 1;
    private static LocationManager a;
    private static double b;
    private static double c;
    private static double d;
    private static boolean e;
    private static long f;
    private static int g = LOCATION_SET_BY_SDK;

    private static LocationManager a() {
        try {
            LocationManager localLocationManager = a;
            return localLocationManager;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    private static void a(double paramDouble) {
        b = paramDouble;
    }

    private static void a(long paramLong) {
        f = paramLong;
    }

    static void a(Location paramLocation) {
        if (paramLocation != null) {
            a(true);
            a(paramLocation.getLatitude());
            b(paramLocation.getLongitude());
            c(paramLocation.getAccuracy());
            a(paramLocation.getTime());
            return;
        }
        a(false);
    }

    private static void a(LocationManager paramLocationManager) {
        try {
            a = paramLocationManager;
            return;
        } finally {
            paramLocationManager =finally;
            throw paramLocationManager;
        }
    }

    static void a(boolean paramBoolean) {
        e = paramBoolean;
    }

    private static void b(double paramDouble) {
        c = paramDouble;
    }

    private static boolean b() {
        Object localObject2;
        try {
            if (a() == null) {
                a((LocationManager) InternalSDKUtil.getContext().getSystemService("location"));
            }
            if (a() == null) {
                break label197;
            }
            LocationManager localLocationManager = a();
            localObject2 = new Criteria();
            if (InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                ((Criteria) localObject2).setAccuracy(1);
            }
            for (; ; ) {
                ((Criteria) localObject2).setCostAllowed(false);
                localObject2 = localLocationManager.getBestProvider((Criteria) localObject2, true);
                if (localObject2 == null) {
                    break label197;
                }
                boolean bool1 = localLocationManager.isProviderEnabled("network");
                boolean bool2 = localLocationManager.isProviderEnabled("gps");
                if ((bool1) || (bool2)) {
                    break;
                }
                return false;
                if (InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    ((Criteria) localObject2).setAccuracy(2);
                }
            }
            localObject2 = localException.getLastKnownLocation((String) localObject2);
        } catch (Exception localException) {
            Log.debug("[InMobi]-4.5.1", "Error getting the Location Info ", localException);
            return false;
        }
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = c();
            Log.debug("[InMobi]-4.5.1", "lastKnownLocation: " + localObject1);
        }
        label197:
        while (localObject1 != null) {
            Log.debug("[InMobi]-4.5.1", "lastBestKnownLocation: " + localObject1);
            a((Location) localObject1);
            return true;
            return true;
        }
        return false;
    }

    private static Location c() {
        if (a() == null) {
            a((LocationManager) InternalSDKUtil.getContext().getSystemService("location"));
        }
        if (a() != null) {
            LocationManager localLocationManager = a();
            List localList = localLocationManager.getProviders(true);
            int i = localList.size() - 1;
            while (i >= 0) {
                Object localObject = (String) localList.get(i);
                if (localLocationManager.isProviderEnabled((String) localObject)) {
                    localObject = localLocationManager.getLastKnownLocation((String) localObject);
                    if (localObject != null) {
                        return (Location) localObject;
                    }
                }
                i -= 1;
            }
        }
        return null;
    }

    private static void c(double paramDouble) {
        d = paramDouble;
    }

    public static void collectLocationInfo() {
        try {
            if ((!isLocationPermissionsDenied()) && (b())) {
                setSDKLocation(LOCATION_SET_BY_SDK);
            }
            return;
        } catch (Exception localException) {
            for (; ; ) {
                Log.internal("[InMobi]-4.5.1", "Exception updating loc info", localException);
            }
        } finally {
        }
    }

    public static String currentLocationStr() {
        StringBuilder localStringBuilder = new StringBuilder();
        if (!DemogInfo.isLocationInquiryAllowed()) {
            if (DemogInfo.getCurrentLocation() != null) {
                a(DemogInfo.getCurrentLocation());
                setSDKLocation(LOCATION_SET_BY_PUB);
            }
        }
        for (; ; ) {
            if ((localStringBuilder == null) || (!isValidGeoInfo())) {
                break label120;
            }
            localStringBuilder.append(getLat());
            localStringBuilder.append(",");
            localStringBuilder.append(getLon());
            localStringBuilder.append(",");
            localStringBuilder.append((int) getLocAccuracy());
            return localStringBuilder.toString();
            a(null);
            break;
            if ((!isValidGeoInfo()) && (DemogInfo.getCurrentLocation() != null)) {
                a(DemogInfo.getCurrentLocation());
                setSDKLocation(LOCATION_SET_BY_PUB);
            }
        }
        label120:
        return "";
    }

    public static long getGeoTS() {
        return f;
    }

    public static double getLat() {
        return b;
    }

    public static double getLocAccuracy() {
        return d;
    }

    public static double getLon() {
        return c;
    }

    public static boolean isLocationPermissionsDenied() {
        int i = InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
        int j = InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
        return (i != 0) && (j != 0);
    }

    public static int isSDKSetLocation() {
        return g;
    }

    public static boolean isValidGeoInfo() {
        return e;
    }

    public static void setSDKLocation(int paramInt) {
        g = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/data/LocationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */