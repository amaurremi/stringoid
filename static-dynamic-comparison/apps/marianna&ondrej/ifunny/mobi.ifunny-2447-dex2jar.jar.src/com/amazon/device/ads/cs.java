package com.amazon.device.ads;

public class cs {
    public static final cs a = new cs("config-aaxHostname", String.class, "aaxHostname", "debug.aaxHostname");
    public static final cs b = new cs("config-sisURL", String.class, "sisURL", "debug.sisURL");
    public static final cs c = new cs("config-adPrefURL", String.class, "adPrefURL", "debug.adPrefURL");
    public static final cs d = new cs("config-madsHostname", String.class, "madsHostname", "debug.madsHostname", true);
    public static final cs e = new cs("config-sisDomain", String.class, "sisDomain", "debug.sisDomain");
    public static final cs f = new cs("config-sendGeo", Boolean.class, "sendGeo", "debug.sendGeo");
    public static final cs[] g = {a, b, c, d, e, f};
    private final String h;
    private final String i;
    private final Class<?> j;
    private final String k;
    private final boolean l;

    protected cs(String paramString1, Class<?> paramClass, String paramString2, String paramString3) {
        this(paramString1, paramClass, paramString2, paramString3, false);
    }

    protected cs(String paramString1, Class<?> paramClass, String paramString2, String paramString3, boolean paramBoolean) {
        this.h = paramString1;
        this.i = paramString2;
        this.j = paramClass;
        this.k = paramString3;
        this.l = paramBoolean;
    }

    String a() {
        return this.h;
    }

    String b() {
        return this.i;
    }

    Class<?> c() {
        return this.j;
    }

    String d() {
        return this.k;
    }

    boolean e() {
        return this.l;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */