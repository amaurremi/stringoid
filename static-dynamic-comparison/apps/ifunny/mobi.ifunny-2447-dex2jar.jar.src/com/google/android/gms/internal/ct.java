package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

@ii
public class ct
        implements cp {
    static final Map<String, Integer> a = new HashMap();

    static {
        a.put("resize", Integer.valueOf(1));
        a.put("playVideo", Integer.valueOf(2));
        a.put("storePicture", Integer.valueOf(3));
        a.put("createCalendarEvent", Integer.valueOf(4));
    }

    public void a(mz parammz, Map<String, String> paramMap) {
        String str = (String) paramMap.get("a");
        switch (((Integer) a.get(str)).intValue()) {
            case 2:
            default:
                mx.c("Unknown MRAID command called.");
                return;
            case 1:
                new ey(parammz, paramMap).b();
                return;
            case 4:
                new ev(parammz, paramMap).a();
                return;
        }
        new ez(parammz, paramMap).a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */