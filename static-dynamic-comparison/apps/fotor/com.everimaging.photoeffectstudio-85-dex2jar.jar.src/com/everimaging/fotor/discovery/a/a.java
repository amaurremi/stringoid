package com.everimaging.fotor.discovery.a;

import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotorsdk.http.c;
import com.everimaging.fotorsdk.http.k;
import com.everimaging.fotorsdk.http.l;
import com.everimaging.fotorsdk.http.p;

public class a {
    private static final String a = a.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);
    private static com.everimaging.fotorsdk.http.a c = new com.everimaging.fotorsdk.http.a();
    private static p d = new p();

    public static k a(String paramString, l paraml, c paramc) {
        b.c(new Object[]{"Get Url :" + paramString});
        return d.a(paramString, paraml, paramc);
    }

    public static String a(String paramString) {
        return "http://dl.fotor.com/" + paramString;
    }

    public static k b(String paramString, l paraml, c paramc) {
        b.c(new Object[]{"Post Url :" + b(paramString)});
        return c.b(b(paramString), paraml, paramc);
    }

    public static String b(String paramString) {
        return "http://store.fotor.com/PushSurpport/discover" + paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/discovery/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */