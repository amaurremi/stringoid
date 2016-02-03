package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.location.Location;
import android.view.View;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

class IAmillennialBanner
        extends a
        implements InvocationHandler {
    private static String e;
    private Object a;
    private Class b;
    private Object c;
    private a.a d;
    private IAadConfig f;
    private boolean g = false;

    protected final void a() {
        InneractiveAdView.Log.d("Inneractive_debug", "** Millennial banner ad shown **");
    }

    protected final void a(Context paramContext, a.a parama, IAresponseData paramIAresponseData) {
        this.d = parama;
        this.f = IAadConfig.a(paramIAresponseData);
        int j;
        int i;
        if (this.f != null) {
            if ((this.f.o() != null) && (this.f.o().get("MM") != null)) {
                e = (String) this.f.o().get("MM");
            }
            if (this.f.b == InneractiveAdView.InternalAdType.a) {
                if (c.c(paramContext, 728)) {
                    InneractiveAdView.Log.i("Inneractive_info", "Asking Millennial Media for LEADERBOARD");
                    j = 728;
                    i = 90;
                }
            }
        }
        for (; ; ) {
            try {
                new IAreflectionHandler.a(null, "initialize").a(Class.forName("com.millennialmedia.android.MMSDK")).a(Context.class, paramContext).a();
                new IAreflectionHandler.a(null, "setLogLevel").a(Class.forName("com.millennialmedia.android.MMLog")).a(Integer.TYPE, Integer.valueOf(2)).a();
                this.a = Class.forName("com.millennialmedia.android.MMAdView").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{paramContext});
                new IAreflectionHandler.a(this.a, "setApid").a(String.class, e).a();
                new IAreflectionHandler.a(this.a, "setWidth").a(Integer.TYPE, Integer.valueOf(j)).a();
                new IAreflectionHandler.a(this.a, "setHeight").a(Integer.TYPE, Integer.valueOf(i)).a();
                this.b = Class.forName("com.millennialmedia.android.RequestListener");
                this.c = Proxy.newProxyInstance(this.b.getClassLoader(), new Class[]{this.b}, this);
                new IAreflectionHandler.a(this.a, "setListener").a(this.b, this.c).a();
                paramContext = c.a(c.e(paramContext), IAadConfig.H());
                if (paramContext != null) {
                    new IAreflectionHandler.a(null, "setUserLocation").a(Location.class, paramContext).a(Class.forName("com.millennialmedia.android.MMRequest")).a();
                }
                parama = Class.forName("com.millennialmedia.android.MMRequest");
                paramIAresponseData = Class.forName("com.millennialmedia.android.MMRequest").newInstance();
                if (this.f.e() != -1) {
                    new IAreflectionHandler.a(paramIAresponseData, "setAge").a(String.class, Integer.toString(this.f.e())).a();
                }
                if (this.f.d() != null) {
                    if ("m".equals(this.f.d())) {
                        paramContext = parama.getDeclaredField("GENDER_MALE");
                        new IAreflectionHandler.a(paramIAresponseData, "setGender").a(String.class, (String) paramContext.get(null)).a();
                    }
                } else {
                    if (this.f.f() != null) {
                        new IAreflectionHandler.a(paramIAresponseData, "setZip").a(String.class, this.f.f()).a();
                    }
                    if (this.f.c() != null) {
                        new IAreflectionHandler.a(paramIAresponseData, "setKeywords").a(String.class, this.f.c()).a();
                    }
                    new IAreflectionHandler.a(this.a, "setMMRequest").a(parama, paramIAresponseData).a();
                    new IAreflectionHandler.a(this.a, "getAd").a();
                    return;
                    if (c.c(paramContext, 480)) {
                        InneractiveAdView.Log.i("Inneractive_info", "Asking Millennial Media for MEDIUM BANNER");
                        j = 480;
                        i = 60;
                        continue;
                    }
                    InneractiveAdView.Log.i("Inneractive_info", "Asking Millennial Media for BANNER");
                    i = 50;
                    j = 320;
                    continue;
                    if (this.f.b != InneractiveAdView.InternalAdType.b) {
                        break label752;
                    }
                    InneractiveAdView.Log.i("Inneractive_info", "Asking Millennial Media for RECTANGLE");
                    j = 300;
                    i = 250;
                    continue;
                    this.d.a(InneractiveAdView.InneractiveErrorCode.SDK_INTERNAL_ERROR);
                    return;
                }
                paramContext = parama.getDeclaredField("GENDER_FEMALE");
                continue;
                i = 50;
            } catch (Exception paramContext) {
                InneractiveAdView.Log.v("Inneractive_debug", "Handled Exception:");
                InneractiveAdView.Log.v("Inneractive_verbose", c.a(paramContext));
                InneractiveAdView.Log.d("Inneractive_debug", "Could not request an ad from Millennial Media using reflection!");
                this.d.a(InneractiveAdView.InneractiveErrorCode.SDK_INTERNAL_ERROR);
                return;
            }
            label752:
            j = 320;
        }
    }

    protected final void b() {
        try {
            this.b = Class.forName("com.millennialmedia.android.RequestListener");
            new IAreflectionHandler.a(this.a, "setListener").a(this.b, null).a();
            return;
        } catch (Exception localException) {
            InneractiveAdView.Log.v("Inneractive_verbose", "Handled Exception:");
            InneractiveAdView.Log.v("Inneractive_verbose", c.a(localException));
            InneractiveAdView.Log.d("Inneractive_debug", "Could not invalidate Millennial Media ad using reflection!");
            this.d.a(InneractiveAdView.InneractiveErrorCode.SDK_INTERNAL_ERROR);
        }
    }

    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) {
        if (paramMethod.getName().equals("MMAdOverlayClosed")) {
            InneractiveAdView.Log.d("Inneractive_debug", "** Millennial banner ad overlay closed **");
        }
        for (; ; ) {
            return null;
            if (paramMethod.getName().equals("MMAdOverlayLaunched")) {
                InneractiveAdView.Log.d("Inneractive_debug", "** Millennial banner ad overlay Launched **");
                this.d.c();
            } else if (paramMethod.getName().equals("MMAdRequestIsCaching")) {
                InneractiveAdView.Log.d("Inneractive_debug", "** Millennial banner ad is caching **");
            } else if (paramMethod.getName().equals("onSingleTap")) {
                if (!this.g) {
                    this.g = true;
                    InneractiveAdView.Log.d("Inneractive_debug", "** Millennial banner ad clicked **");
                    if (this.f != null) {
                        this.f.m("MM");
                    }
                    this.d.b();
                }
            } else if (paramMethod.getName().equals("requestCompleted")) {
                InneractiveAdView.Log.d("Inneractive_debug", "** Millennial banner ad loaded successfully **");
                if (this.f != null) {
                    this.f.l("MM");
                }
                this.d.a((View) paramArrayOfObject[0]);
            } else if (paramMethod.getName().equals("requestFailed")) {
                InneractiveAdView.Log.d("Inneractive_debug", "** Millennial banner ad failed to load **");
                if (this.f != null) {
                    this.f.l("IA");
                    this.f.j("MM");
                }
                this.d.a(InneractiveAdView.InneractiveErrorCode.NO_FILL);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAmillennialBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */