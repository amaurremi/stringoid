package com.google.android.gms.location;

import java.util.Comparator;

final class d
        implements Comparator<DetectedActivity> {
    public int a(DetectedActivity paramDetectedActivity1, DetectedActivity paramDetectedActivity2) {
        int j = Integer.valueOf(paramDetectedActivity2.b()).compareTo(Integer.valueOf(paramDetectedActivity1.b()));
        int i = j;
        if (j == 0) {
            i = Integer.valueOf(paramDetectedActivity1.a()).compareTo(Integer.valueOf(paramDetectedActivity2.a()));
        }
        return i;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/location/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */