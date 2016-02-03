package com.amazon.device.ads;

class cc {
    private static final String a = cc.class.getSimpleName();
    private db b;
    private boolean c = true;

    static String a() {
        he localhe = he.a();
        String str = localhe.a("adIdTransistion", null);
        localhe.b("adIdTransistion");
        return str;
    }

    private static void a(String paramString) {
        dv.a(a, "Transition: %s", new Object[]{paramString});
        he.a().b("adIdTransistion", paramString);
    }

    private static void b(String paramString) {
        he.a().b("gpsAdId", paramString);
    }

    private void e() {
        String str = null;
        if (f()) {
            str = "migrate";
        }
        while (str != null) {
            a(str);
            return;
            if (g()) {
                str = "reset";
            } else if (h()) {
                str = "revert";
            }
        }
        dv.b(a, "No transition detected.");
    }

    private boolean f() {
        return (dn.i().c().c()) && (gs.d()) && (!j()) && (d().d());
    }

    private boolean g() {
        return (j()) && (d().d()) && (!i().equals(d().c()));
    }

    private boolean h() {
        return (j()) && (!d().d());
    }

    private static String i() {
        return he.a().a("gpsAdId", "");
    }

    private boolean j() {
        return !hu.c(i());
    }

    cc a(boolean paramBoolean) {
        this.c = paramBoolean;
        return this;
    }

    cd b() {
        if (ho.a()) {
            dv.c(a, "You must obtain the advertising indentifier information on a background thread.");
            return cd.a(new cd(), false);
        }
        c();
        if (this.c) {
            e();
        }
        cd localcd = new cd();
        if (d().d()) {
            cd.a(localcd, d().c());
            cd.b(localcd, d().e());
            if (this.c) {
                b(d().c());
            }
        }
        gs localgs = dn.i().c();
        if (gs.a(localcd)) {
            cd.b(localcd, localgs.b());
            return localcd;
        }
        localgs.f();
        return localcd;
    }

    protected void c() {
        this.b = new da().a();
    }

    protected db d() {
        return this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */