package com.everimaging.fotorsdk;

import com.everimaging.fotorsdk.utils.CountlyUtils;
import com.everimaging.fotorsdk.utils.DeviceUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a {
    private static final List<a> a = new ArrayList();

    public static void a(a parama) {
        synchronized (a) {
            a.add(parama);
            return;
        }
    }

    public static void a(String paramString) {
        CountlyUtils.logEvent(paramString);
        synchronized (a) {
            Iterator localIterator = a.iterator();
            while (localIterator.hasNext()) {
                a locala = (a) localIterator.next();
                if (locala != null) {
                    locala.b(paramString);
                }
            }
        }
    }

    public static void a(String paramString1, String paramString2) {
        HashMap localHashMap = new HashMap();
        localHashMap.put(paramString1, paramString2);
        a(paramString1, localHashMap);
    }

    public static void a(String paramString1, String paramString2, String paramString3) {
        HashMap localHashMap = new HashMap();
        localHashMap.put(paramString2, paramString3);
        a(paramString1, localHashMap);
    }

    public static void a(String paramString, Map<String, String> paramMap) {
        CountlyUtils.logEvent(paramString, paramMap);
        synchronized (a) {
            Iterator localIterator = a.iterator();
            while (localIterator.hasNext()) {
                a locala = (a) localIterator.next();
                if (locala != null) {
                    locala.a(paramString, paramMap);
                }
            }
        }
    }

    public static void b(String paramString1, String paramString2) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("ErroMessage", paramString2);
        localHashMap.put("Model", DeviceUtils.getDevice());
        localHashMap.put("OSVersion", DeviceUtils.getOSVersion());
        localHashMap.put("Resolution", DeviceUtils.getResolution());
        localHashMap.put("SDKVersion", "1.0.6");
        a(paramString1, localHashMap);
    }

    public static abstract interface a {
        public abstract void a(String paramString, Map<String, String> paramMap);

        public abstract void b(String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */