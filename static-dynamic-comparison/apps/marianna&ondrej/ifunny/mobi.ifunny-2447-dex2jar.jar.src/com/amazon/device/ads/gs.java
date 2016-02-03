package com.amazon.device.ads;

class gs {
    private String a;
    private String b = "app";

    public static boolean a(cd paramcd) {
        boolean bool2 = d();
        boolean bool1 = bool2;
        if (paramcd.c()) {
            if (bool2) {
                bool1 = false;
            }
        } else {
            return bool1;
        }
        String str = he.a().a("amzn-ad-id-origin", null);
        return paramcd.b().equals(str);
    }

    protected static void b(cd paramcd) {
        if (paramcd.c()) {
            he.a().c("amzn-ad-id-origin", paramcd.b());
            return;
        }
        he.a().c("amzn-ad-id-origin", "non-advertising-identifier");
    }

    public static boolean d() {
        String str = he.a().a("amzn-ad-id-origin", null);
        return (str == null) || ("non-advertising-identifier".equals(str));
    }

    public String a() {
        return this.b;
    }

    public void a(String paramString) {
        if ((paramString == null) || (paramString.length() == 0)) {
            throw new IllegalArgumentException("Application Key must not be null or empty.");
        }
        this.a = hu.b(paramString);
    }

    public void a(String paramString, cd paramcd) {
        he localhe = he.a();
        localhe.c("amzn-ad-id", paramString);
        b(paramcd);
        localhe.c("newSISDIDRequested", false);
        localhe.c();
    }

    public String b() {
        return cx.a("debug.adid", he.a().a("amzn-ad-id", null));
    }

    public boolean c() {
        return b() != null;
    }

    public String e() {
        return cx.a("debug.appid", this.a);
    }

    public void f() {
        he.a().b("newSISDIDRequested", true);
    }

    public boolean g() {
        return he.a().a("newSISDIDRequested", false);
    }

    public boolean h() {
        return !hu.c(b());
    }

    public boolean i() {
        return !h();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/gs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */