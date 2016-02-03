package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.location.Location;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

class IAmillennialInterstitial
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
        try {
            Object localObject = new IAreflectionHandler.a(this.a, "isAdAvailable").a();
            if ((localObject != null) && (((Boolean) localObject).booleanValue() == true)) {
                new IAreflectionHandler.a(this.a, "display").a();
                return;
            }
            InneractiveAdView.Log.i("Inneractive_info", "Millennial interstitial ad is not ready yet and still loading. Please try again.");
            return;
        } catch (Exception localException) {
            InneractiveAdView.Log.v("Inneractive_verbose", "Handled Exception:");
            InneractiveAdView.Log.v("Inneractive_verbose", c.a(localException));
            InneractiveAdView.Log.d("Inneractive_debug", "Could not show Millennial Media ad using reflection!");
            this.d.a(InneractiveAdView.InneractiveErrorCode.SDK_INTERNAL_ERROR);
        }
    }

    protected final void a(Context paramContext, a.a parama, IAresponseData paramIAresponseData) {
        this.d = parama;
        this.f = IAadConfig.a(paramIAresponseData);
        if (this.f != null) {
            if ((this.f.o() != null) && (this.f.o().get("MM") != null)) {
                e = (String) this.f.o().get("MM");
            }
        }
        for (; ; ) {
            try {
                new IAreflectionHandler.a(null, "initialize").a(Class.forName("com.millennialmedia.android.MMSDK")).a(Context.class, paramContext).a();
                new IAreflectionHandler.a(null, "setLogLevel").a(Class.forName("com.millennialmedia.android.MMLog")).a(Integer.TYPE, Integer.valueOf(2)).a();
                this.a = Class.forName("com.millennialmedia.android.MMInterstitial").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{paramContext});
                parama = new IAreflectionHandler.a(this.a, "isAdAvailable").a();
                if ((parama != null) && (((Boolean) parama).booleanValue() == true)) {
                    InneractiveAdView.Log.d("Inneractive_debug", "** Millennial interstitial ad already loaded **");
                    this.d.a(null);
                    new IAreflectionHandler.a(this.a, "fetch").a();
                    return;
                    this.d.a(InneractiveAdView.InneractiveErrorCode.SDK_INTERNAL_ERROR);
                    return;
                }
                new IAreflectionHandler.a(this.a, "setApid").a(String.class, e).a();
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
                    continue;
                }
                paramContext = parama.getDeclaredField("GENDER_FEMALE");
            } catch (Exception paramContext) {
                InneractiveAdView.Log.v("Inneractive_verbose", "Handled Exception:");
                InneractiveAdView.Log.v("Inneractive_verbose", c.a(paramContext));
                InneractiveAdView.Log.d("Inneractive_debug", "Could not request an ad from Millennial Media using reflection!");
                this.d.a(InneractiveAdView.InneractiveErrorCode.SDK_INTERNAL_ERROR);
                return;
            }
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
            InneractiveAdView.Log.d("Inneractive_debug", "** Millennial interstitial ad dismissed **");
            this.d.e();
        }
        do {
            do {
                return null;
                if (paramMethod.getName().equals("MMAdOverlayLaunched")) {
                    InneractiveAdView.Log.d("Inneractive_debug", "** Showing Millennial interstitial ad **");
                    if (this.f != null) {
                        this.f.l("MM");
                    }
                    this.d.a();
                    return null;
                }
                if (paramMethod.getName().equals("MMAdRequestIsCaching")) {
                    InneractiveAdView.Log.d("Inneractive_debug", "** Millennial interstitial ad is caching **");
                    return null;
                }
                if (!paramMethod.getName().equals("onSingleTap")) {
                    break;
                }
            } while (this.g);
            this.g = true;
            InneractiveAdView.Log.d("Inneractive_debug", "** Millennial interstitial ad clicked **");
            if (this.f != null) {
                this.f.m("MM");
            }
            this.d.b();
            return null;
            if (paramMethod.getName().equals("requestCompleted")) {
                paramObject = InneractiveAdView.InneractiveErrorCode.CONNECTION_ERROR;
                try {
                    paramMethod = new IAreflectionHandler.a(this.a, "isAdAvailable").a();
                    if ((paramMethod != null) && (((Boolean) paramMethod).booleanValue() == true)) {
                        InneractiveAdView.Log.d("Inneractive_debug", "** Millennial interstitial ad loaded successfully **");
                        if (this.f != null) {
                            this.f.l("MM");
                        }
                        this.d.a(null);
                        return null;
                    }
                } catch (Exception paramObject) {
                    InneractiveAdView.Log.v("Inneractive_verbose", "Handled Exception:");
                    InneractiveAdView.Log.v("Inneractive_verbose", c.a((Exception) paramObject));
                    InneractiveAdView.Log.d("Inneractive_debug", "Could not check if Millennial Media ad is available using reflection!");
                    this.d.a(InneractiveAdView.InneractiveErrorCode.SDK_INTERNAL_ERROR);
                    return null;
                }
                InneractiveAdView.Log.d("Inneractive_debug", "** Millennial interstitial ad failed to load **");
                if (this.f != null) {
                    this.f.l("IA");
                    this.f.j("MM");
                }
                this.d.a((InneractiveAdView.InneractiveErrorCode) paramObject);
                return null;
            }
        } while (!paramMethod.getName().equals("requestFailed"));
        InneractiveAdView.Log.d("Inneractive_debug", "** Millennial interstitial ad failed to load **");
        if (this.f != null) {
            this.f.l("IA");
            this.f.j("MM");
        }
        this.d.a(InneractiveAdView.InneractiveErrorCode.NO_FILL);
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAmillennialInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */