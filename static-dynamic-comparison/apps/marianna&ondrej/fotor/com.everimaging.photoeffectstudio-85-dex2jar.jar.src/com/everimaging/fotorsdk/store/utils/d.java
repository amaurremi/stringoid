package com.everimaging.fotorsdk.store.utils;

import com.everimaging.fotorsdk.http.a;
import com.everimaging.fotorsdk.http.c;
import com.everimaging.fotorsdk.http.k;
import com.everimaging.fotorsdk.http.l;
import com.everimaging.fotorsdk.http.p;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

import java.util.HashMap;

public class d {
    private static final String a = d.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private static a c = new a();
    private static p d = new p();
    private static HashMap<String, Boolean> e = new HashMap();

    static {
        c.a(1, 1500);
        d.a(1, 1500);
    }

    public static k a(String paramString, l paraml, c paramc) {
        b.c(new Object[]{"Post Url :" + a(paramString)});
        return c.b(a(paramString), paraml, paramc);
    }

    public static String a(String paramString) {
        return "http://store.fotor.com/FotorShopSurpport/" + paramString;
    }

    public static void a(String paramString, boolean paramBoolean) {
        e.put(paramString, Boolean.valueOf(paramBoolean));
    }

    public static k b(String paramString, l paraml, c paramc) {
        b.c(new Object[]{"Get Download Url :" + b(paramString)});
        return c.a(b(paramString), paraml, paramc);
    }

    public static String b(String paramString) {
        return "http://dl.fotor.com/store/v1/" + paramString;
    }

    public static boolean c(String paramString) {
        if (e.containsKey(paramString)) {
            return ((Boolean) e.get(paramString)).booleanValue();
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */