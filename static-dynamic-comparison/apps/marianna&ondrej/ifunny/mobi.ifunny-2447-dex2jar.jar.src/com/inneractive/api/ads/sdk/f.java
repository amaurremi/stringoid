package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

final class f
        extends j {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;

    f(Context paramContext) {
        this.a = paramContext;
    }

    final f a(int paramInt) {
        if (paramInt != -1) {
            this.e = Integer.toString(paramInt);
            return this;
        }
        this.e = "";
        return this;
    }

    final f a(InneractiveAdView.InternalAdType paramInternalAdType) {
        if (InneractiveAdView.InternalAdType.b.equals(paramInternalAdType)) {
            this.i = Integer.toString(300);
            this.j = Integer.toString(250);
        }
        return this;
    }

    final f a(InneractiveAdView.MediationName paramMediationName) {
        if (paramMediationName != null) {
            this.k = paramMediationName.a;
        }
        return this;
    }

    final f a(boolean paramBoolean) {
        if (paramBoolean) {
            this.b = Boolean.toString(paramBoolean);
            return this;
        }
        this.b = "";
        return this;
    }

    final String a(String paramString) {
        int i1 = 0;
        g(paramString);
        a("aid", this.g);
        a("a", this.e);
        a("g", this.d);
        a("zip", this.f);
        a("k", this.c);
        a("po", this.h);
        a("verbose", this.b);
        a("rw", this.i);
        a("rh", this.j);
        a("med", this.k);
        a("asha", this.l);
        a("amd", this.m);
        a("iesha", this.n);
        a("iemd", this.o);
        Object localObject;
        if ((IAadConfig.B()) && (IAdefines.ApiLevel.a().a(IAdefines.ApiLevel.c))) {
            IAadConfig.c(628);
            a("f", Integer.toString(IAadConfig.m()));
            if (!c.b("2.1.0-Android-5.0.1")) {
                a("v", "2.1.0-Android-5.0.1");
            }
            paramString = IAadConfig.h();
            if (!c.b(paramString)) {
                a("aaid", paramString);
            }
            a("dnt", Boolean.toString(IAadConfig.i()));
            paramString = IAadConfig.v();
            if (!c.b(paramString)) {
                a("bid", paramString);
            }
            paramString = IAadConfig.w();
            if (!c.b(paramString)) {
                a("appv", paramString);
            }
            paramString = c.b();
            if (!c.b(paramString)) {
                a("dml", paramString);
            }
            a("isdks", IAadConfig.G());
            paramString = c.a(c.e(this.a), IAadConfig.H());
            if (paramString != null) {
                a("lg", paramString.getLatitude() + "," + paramString.getLongitude());
            }
            paramString = c.h(this.a);
            if (paramString != null) {
                a("ciso", paramString);
            }
            localObject = c.d(this.a);
            if (localObject != null) {
                break label645;
            }
            paramString = "";
            label381:
            a("mcc", paramString);
            if (localObject != null) {
                break label660;
            }
            paramString = "";
            label396:
            a("mnc", paramString);
            a("t", Long.toString(System.currentTimeMillis()));
            paramString = this.a;
            localObject = (ConnectivityManager) paramString.getSystemService("connectivity");
            if (paramString.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                i1 = 1;
            }
            if (i1 == 0) {
                break label680;
            }
            paramString = ((ConnectivityManager) localObject).getActiveNetworkInfo();
            if (paramString == null) {
                break label674;
            }
            i1 = paramString.getType();
            switch (i1) {
                case 6:
                case 7:
                case 8:
                default:
                    label461:
                    a("nt", IAdefines.InneractiveNetworkType.a.e);
                    label529:
                    a("crn", c.i(this.a));
                    i1 = c.p(this.a);
                    int i2 = c.o(this.a);
                    if ((i1 > 0) && (i2 > 0)) {
                        a("w", Integer.toString(c.a(this.a, i1)));
                        a("h", Integer.toString(c.a(this.a, i2)));
                    }
                    i1 = c.n(this.a);
                    paramString = "u";
                    if (i1 == 1) {
                        paramString = "p";
                    }
                    break;
            }
        }
        for (; ; ) {
            a("o", paramString);
            return a();
            IAadConfig.c(116);
            break;
            label645:
            paramString = ((String) localObject).substring(0, c.a((String) localObject));
            break label381;
            label660:
            paramString = ((String) localObject).substring(c.a((String) localObject));
            break label396;
            label674:
            i1 = 8;
            break label461;
            label680:
            i1 = 8;
            break label461;
            a("nt", IAdefines.InneractiveNetworkType.b.e);
            break label529;
            a("nt", IAdefines.InneractiveNetworkType.c.e);
            break label529;
            a("nt", IAdefines.InneractiveNetworkType.d.e);
            break label529;
            if (i1 == 2) {
                paramString = "l";
            }
        }
    }

    final f b(String paramString) {
        this.g = paramString;
        return this;
    }

    final f b(boolean paramBoolean) {
        if (paramBoolean) {
            this.l = IAadConfig.r();
            this.m = IAadConfig.s();
        }
        return this;
    }

    final f c(String paramString) {
        this.d = paramString;
        return this;
    }

    final f c(boolean paramBoolean) {
        if (paramBoolean) {
            this.n = IAadConfig.u();
            this.o = IAadConfig.t();
        }
        return this;
    }

    final f d(String paramString) {
        this.f = paramString;
        return this;
    }

    final f e(String paramString) {
        this.c = paramString;
        return this;
    }

    final f f(String paramString) {
        this.h = paramString;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */