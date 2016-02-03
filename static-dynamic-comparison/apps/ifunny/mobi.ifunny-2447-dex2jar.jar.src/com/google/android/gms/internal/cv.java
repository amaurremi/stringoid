package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

import java.util.Map;

@ii
public final class cv
        implements cp {
    private static int a(DisplayMetrics paramDisplayMetrics, Map<String, String> paramMap, String paramString, int paramInt) {
        paramMap = (String) paramMap.get(paramString);
        int i = paramInt;
        if (paramMap != null) {
        }
        try {
            i = mv.a(paramDisplayMetrics, Integer.parseInt(paramMap));
            return i;
        } catch (NumberFormatException paramDisplayMetrics) {
            mx.e("Could not parse " + paramString + " in a video GMSG: " + paramMap);
        }
        return paramInt;
    }

    public void a(mz parammz, Map<String, String> paramMap) {
        String str = (String) paramMap.get("action");
        if (str == null) {
            mx.e("Action missing from video GMSG.");
            return;
        }
        Object localObject = parammz.d();
        if (localObject == null) {
            mx.e("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean bool1 = "new".equalsIgnoreCase(str);
        boolean bool2 = "position".equalsIgnoreCase(str);
        int i;
        int j;
        if ((bool1) || (bool2)) {
            parammz = parammz.getContext().getResources().getDisplayMetrics();
            i = a(parammz, paramMap, "x", 0);
            j = a(parammz, paramMap, "y", 0);
            int k = a(parammz, paramMap, "w", -1);
            int m = a(parammz, paramMap, "h", -1);
            if ((bool1) && (((fj) localObject).b() == null)) {
                ((fj) localObject).b(i, j, k, m);
                return;
            }
            ((fj) localObject).a(i, j, k, m);
            return;
        }
        localObject = ((fj) localObject).b();
        if (localObject == null) {
            fr.a(parammz, "no_video_view", null);
            return;
        }
        if ("click".equalsIgnoreCase(str)) {
            parammz = parammz.getContext().getResources().getDisplayMetrics();
            i = a(parammz, paramMap, "x", 0);
            j = a(parammz, paramMap, "y", 0);
            long l = SystemClock.uptimeMillis();
            parammz = MotionEvent.obtain(l, l, 0, i, j, 0);
            ((fr) localObject).a(parammz);
            parammz.recycle();
            return;
        }
        if ("controls".equalsIgnoreCase(str)) {
            parammz = (String) paramMap.get("enabled");
            if (parammz == null) {
                mx.e("Enabled parameter missing from controls video GMSG.");
                return;
            }
            ((fr) localObject).a(Boolean.parseBoolean(parammz));
            return;
        }
        if ("currentTime".equalsIgnoreCase(str)) {
            parammz = (String) paramMap.get("time");
            if (parammz == null) {
                mx.e("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                ((fr) localObject).a((int) (Float.parseFloat(parammz) * 1000.0F));
                return;
            } catch (NumberFormatException paramMap) {
                mx.e("Could not parse time parameter from currentTime video GMSG: " + parammz);
                return;
            }
        }
        if ("hide".equalsIgnoreCase(str)) {
            ((fr) localObject).setVisibility(4);
            return;
        }
        if ("load".equalsIgnoreCase(str)) {
            ((fr) localObject).b();
            return;
        }
        if ("pause".equalsIgnoreCase(str)) {
            ((fr) localObject).c();
            return;
        }
        if ("play".equalsIgnoreCase(str)) {
            ((fr) localObject).d();
            return;
        }
        if ("show".equalsIgnoreCase(str)) {
            ((fr) localObject).setVisibility(0);
            return;
        }
        if ("src".equalsIgnoreCase(str)) {
            ((fr) localObject).a((String) paramMap.get("src"));
            return;
        }
        mx.e("Unknown video action: " + str);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */