package com.millennialmedia.android;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class MMAdImplController
        implements AdCache.AdCacheTaskListener {
    private static final Map<Long, MMAdImplController> e = new ConcurrentHashMap();
    private static final Map<Long, WeakReference<MMAdImplController>> f = new ConcurrentHashMap();
    volatile long a;
    volatile MMWebView b;
    volatile WeakReference<MMAdImpl> c;
    MMAdImplController.RequestAdRunnable d;

    private MMAdImplController(MMAdImpl paramMMAdImpl) {
        MMLog.b("MMAdImplController", "**************** creating new controller.");
        this.c = new WeakReference(paramMMAdImpl);
        if (paramMMAdImpl.n != 0L) {
            a(paramMMAdImpl);
            this.b = d(paramMMAdImpl);
        }
        while ((paramMMAdImpl instanceof MMInterstitial.MMInterstitialAdImpl)) {
            return;
        }
        if (paramMMAdImpl.isBanner()) {
            this.b = new MMWebView(paramMMAdImpl.j().getApplicationContext(), paramMMAdImpl.h);
            this.b.g = true;
            return;
        }
        this.b = new MMWebView(paramMMAdImpl.j(), paramMMAdImpl.h);
    }

    static MMAdImpl a(long paramLong) {
        Object localObject1;
        if (paramLong == -4L) {
            localObject1 = null;
        }
        for (; ; ) {
            return (MMAdImpl) localObject1;
            try {
                MMAdImplController localMMAdImplController = (MMAdImplController) e.get(Long.valueOf(paramLong));
                localObject1 = localMMAdImplController;
                if (localMMAdImplController == null) {
                    WeakReference localWeakReference = (WeakReference) f.get(Long.valueOf(paramLong));
                    localObject1 = localMMAdImplController;
                    if (localWeakReference != null) {
                        localObject1 = (MMAdImplController) localWeakReference.get();
                    }
                }
                if (localObject1 != null) {
                    localObject1 = (MMAdImpl) ((MMAdImplController) localObject1).c.get();
                    continue;
                }
                localObject1 = null;
            } finally {
            }
        }
    }

    static void a(Context paramContext) {
        paramContext = e.entrySet().iterator();
        while (paramContext.hasNext()) {
            Object localObject = (MMAdImplController) ((Map.Entry) paramContext.next()).getValue();
            if (localObject != null) {
                localObject = (MMAdImpl) ((MMAdImplController) localObject).c.get();
                if (localObject != null) {
                    localObject = ((MMAdImpl) localObject).d();
                    if ((localObject != null) && ((localObject instanceof MMLayout))) {
                        ((MMLayout) localObject).m();
                    }
                }
            }
        }
    }

    static void b(MMAdImpl paramMMAdImpl) {
        try {
            if (paramMMAdImpl.k != null) {
                if (!e.containsValue(paramMMAdImpl.k)) {
                    if (!paramMMAdImpl.q()) {
                        break label114;
                    }
                    e.put(Long.valueOf(paramMMAdImpl.h), paramMMAdImpl.k);
                    if (f.containsKey(Long.valueOf(paramMMAdImpl.h))) {
                        f.remove(Long.valueOf(paramMMAdImpl.h));
                    }
                }
                for (; ; ) {
                    MMLog.b("MMAdImplController", paramMMAdImpl + " - Has a controller");
                    return;
                    label114:
                    if (!f.containsKey(Long.valueOf(paramMMAdImpl.h))) {
                        f.put(Long.valueOf(paramMMAdImpl.h), new WeakReference(paramMMAdImpl.k));
                    }
                }
            }
            MMLog.b("MMAdImplController", "*****************************************assignAdViewController for " + paramMMAdImpl);
        } finally {
        }
        MMAdImplController localMMAdImplController = (MMAdImplController) e.get(Long.valueOf(paramMMAdImpl.h));
        Object localObject = localMMAdImplController;
        if (localMMAdImplController == null) {
            localObject = (WeakReference) f.get(Long.valueOf(paramMMAdImpl.h));
            if (localObject != null) {
                localMMAdImplController = (MMAdImplController) ((WeakReference) localObject).get();
            }
            localObject = localMMAdImplController;
            if (localMMAdImplController == null) {
                localObject = new MMAdImplController(paramMMAdImpl);
                if (!paramMMAdImpl.q()) {
                    break label325;
                }
                e.put(Long.valueOf(paramMMAdImpl.h), localObject);
            }
        }
        for (; ; ) {
            paramMMAdImpl.k = ((MMAdImplController) localObject);
            ((MMAdImplController) localObject).c = new WeakReference(paramMMAdImpl);
            if ((((MMAdImplController) localObject).b == null) || ((paramMMAdImpl instanceof MMInterstitial.MMInterstitialAdImpl))) {
                break;
            }
            h(paramMMAdImpl);
            break;
            label325:
            f.put(Long.valueOf(paramMMAdImpl.h), new WeakReference(localObject));
        }
    }

    static String c() {
        return f.toString() + " SAVED:" + e.toString();
    }

    static boolean c(MMAdImpl paramMMAdImpl) {
        boolean bool2 = false;
        boolean bool1;
        if (paramMMAdImpl == null) {
            bool1 = bool2;
        }
        for (; ; ) {
            return bool1;
            try {
                MMLog.b("MMAdImplController", "attachWebViewFromOverlay with " + paramMMAdImpl);
                if ((paramMMAdImpl.k != null) && (paramMMAdImpl.k.b != null)) {
                    paramMMAdImpl.k.b.d();
                }
                MMAdImpl localMMAdImpl = a(paramMMAdImpl.n);
                bool1 = bool2;
                if (localMMAdImpl == null) {
                    continue;
                }
                bool1 = bool2;
                if (localMMAdImpl.k == null) {
                    continue;
                }
                if (localMMAdImpl.k.b == null) {
                    bool1 = bool2;
                    if (paramMMAdImpl.k == null) {
                        continue;
                    }
                    bool1 = bool2;
                    if (paramMMAdImpl.k.b == null) {
                        continue;
                    }
                    localMMAdImpl.k.b = paramMMAdImpl.k.b;
                    paramMMAdImpl.removeView(paramMMAdImpl.k.b);
                    paramMMAdImpl.k.b = null;
                }
                localMMAdImpl.k.b.n();
                localMMAdImpl.k.b.setWebViewClient(localMMAdImpl.c());
                bool1 = true;
            } finally {
            }
        }
    }

    static MMWebView d(MMAdImpl paramMMAdImpl) {
        Object localObject = null;
        try {
            MMLog.c("MMAdImplController", "getWebViewFromExistingLayout(" + paramMMAdImpl.h + " taking from " + paramMMAdImpl.n + ")");
            MMAdImpl localMMAdImpl = a(paramMMAdImpl.n);
            paramMMAdImpl = (MMAdImpl) localObject;
            if (localMMAdImpl != null) {
                paramMMAdImpl = (MMAdImpl) localObject;
                if (localMMAdImpl.k != null) {
                    paramMMAdImpl = localMMAdImpl.k.b;
                    localMMAdImpl.k.b = null;
                }
            }
            return paramMMAdImpl;
        } finally {
        }
    }

    static void e(MMAdImpl paramMMAdImpl) {
        for (; ; ) {
            try {
                MMAdImplController localMMAdImplController = paramMMAdImpl.k;
                if (localMMAdImplController == null) {
                    return;
                }
                if (paramMMAdImpl.q()) {
                    e.put(Long.valueOf(paramMMAdImpl.h), paramMMAdImpl.k);
                    if (f.get(Long.valueOf(paramMMAdImpl.h)) != null) {
                        f.remove(Long.valueOf(paramMMAdImpl.h));
                    }
                    MMLog.b("MMAdImplController", "****************RemoveAdviewcontroller - " + paramMMAdImpl);
                    if (paramMMAdImpl.i) {
                        e.remove(Long.valueOf(paramMMAdImpl.h));
                        f.remove(Long.valueOf(paramMMAdImpl.h));
                    }
                    localMMAdImplController = paramMMAdImpl.k;
                    paramMMAdImpl.k = null;
                    MMLog.b("MMAdImplController", "****************RemoveAdviewcontroller - controllers " + c());
                    if (localMMAdImplController.b != null) {
                        MMLog.b("MMAdImplController", "****************RemoveAdviewcontroller - controller!=null, expanding=" + localMMAdImplController.b.b);
                        paramMMAdImpl.removeView(localMMAdImplController.b);
                        localMMAdImplController.b.b = false;
                        if ((paramMMAdImpl.i) && (paramMMAdImpl.n == 0L)) {
                            localMMAdImplController.b.loadData("<html></html>", "text/html", "UTF-8");
                            localMMAdImplController.b.d();
                            localMMAdImplController.b = null;
                        }
                    }
                } else {
                    f.put(Long.valueOf(paramMMAdImpl.h), new WeakReference(paramMMAdImpl.k));
                }
            } finally {
            }
        }
    }

    /* Error */
    private static void h(MMAdImpl paramMMAdImpl) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: aload_0
        //   4: getfield 143	com/millennialmedia/android/MMAdImpl:k	Lcom/millennialmedia/android/MMAdImplController;
        //   7: astore_3
        //   8: aload_3
        //   9: getfield 62	com/millennialmedia/android/MMAdImplController:b	Lcom/millennialmedia/android/MMWebView;
        //   12: ifnull +85 -> 97
        //   15: aload_3
        //   16: getfield 62	com/millennialmedia/android/MMAdImplController:b	Lcom/millennialmedia/android/MMWebView;
        //   19: aload_0
        //   20: invokevirtual 201	com/millennialmedia/android/MMAdImpl:c	()Lcom/millennialmedia/android/MMWebViewClient;
        //   23: invokevirtual 205	com/millennialmedia/android/MMWebView:setWebViewClient	(Landroid/webkit/WebViewClient;)V
        //   26: aload_3
        //   27: getfield 62	com/millennialmedia/android/MMAdImplController:b	Lcom/millennialmedia/android/MMWebView;
        //   30: aload_0
        //   31: getfield 82	com/millennialmedia/android/MMAdImpl:h	J
        //   34: invokevirtual 245	com/millennialmedia/android/MMWebView:a	(J)Z
        //   37: ifne +60 -> 97
        //   40: aload_0
        //   41: invokevirtual 68	com/millennialmedia/android/MMAdImpl:isBanner	()Z
        //   44: ifeq +57 -> 101
        //   47: new 247	android/widget/RelativeLayout$LayoutParams
        //   50: dup
        //   51: bipush -2
        //   53: bipush -2
        //   55: invokespecial 250	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
        //   58: astore_2
        //   59: aload_2
        //   60: astore_1
        //   61: aload_3
        //   62: getfield 62	com/millennialmedia/android/MMAdImplController:b	Lcom/millennialmedia/android/MMWebView;
        //   65: invokevirtual 253	com/millennialmedia/android/MMWebView:w	()Z
        //   68: ifeq +13 -> 81
        //   71: aload_3
        //   72: getfield 62	com/millennialmedia/android/MMAdImplController:b	Lcom/millennialmedia/android/MMWebView;
        //   75: aload_0
        //   76: invokevirtual 255	com/millennialmedia/android/MMWebView:b	(Lcom/millennialmedia/android/MMAdImpl;)V
        //   79: aload_2
        //   80: astore_1
        //   81: aload_3
        //   82: getfield 62	com/millennialmedia/android/MMAdImplController:b	Lcom/millennialmedia/android/MMWebView;
        //   85: invokevirtual 258	com/millennialmedia/android/MMWebView:v	()V
        //   88: aload_0
        //   89: aload_3
        //   90: getfield 62	com/millennialmedia/android/MMAdImplController:b	Lcom/millennialmedia/android/MMWebView;
        //   93: aload_1
        //   94: invokevirtual 262	com/millennialmedia/android/MMAdImpl:addView	(Lcom/millennialmedia/android/MMWebView;Landroid/widget/RelativeLayout$LayoutParams;)V
        //   97: ldc 2
        //   99: monitorexit
        //   100: return
        //   101: new 247	android/widget/RelativeLayout$LayoutParams
        //   104: dup
        //   105: bipush -2
        //   107: iconst_m1
        //   108: invokespecial 250	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
        //   111: astore_1
        //   112: goto -31 -> 81
        //   115: astore_0
        //   116: ldc 2
        //   118: monitorexit
        //   119: aload_0
        //   120: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	121	0	paramMMAdImpl	MMAdImpl
        //   60	52	1	localLayoutParams1	android.widget.RelativeLayout.LayoutParams
        //   58	22	2	localLayoutParams2	android.widget.RelativeLayout.LayoutParams
        //   7	83	3	localMMAdImplController	MMAdImplController
        // Exception table:
        //   from	to	target	type
        //   3	59	115	finally
        //   61	79	115	finally
        //   81	97	115	finally
        //   101	112	115	finally
    }

    private void i(MMAdImpl paramMMAdImpl) {
        if (paramMMAdImpl.e == null) {
            localMMException = new MMException("MMAdView found with a null apid. New ad requests on this MMAdView are disabled until an apid has been assigned.", 1);
            MMLog.e("MMAdImplController", localMMException.getMessage());
            MMSDK.Event.a(paramMMAdImpl, localMMException);
        }
        while ((!paramMMAdImpl.isBanner()) && (j(paramMMAdImpl))) {
            MMException localMMException;
            return;
        }
        try {
            if (this.d != null) {
                MMLog.c("MMAdImplController", MMException.a(12));
                MMSDK.Event.a(paramMMAdImpl, new MMException(12));
                return;
            }
        } finally {
        }
        this.d = new MMAdImplController.RequestAdRunnable(this, null);
        Utils.ThreadUtils.a(this.d);
    }

    private boolean j(MMAdImpl paramMMAdImpl) {
        boolean bool = true;
        for (; ; ) {
            try {
                Context localContext = paramMMAdImpl.j();
                if (HandShake.a(localContext).c(paramMMAdImpl.f)) {
                    MMLog.c("MMAdImplController", "There is a download in progress. Defering call for new ad");
                    MMSDK.Event.a(paramMMAdImpl, new MMException(12));
                    return bool;
                }
                MMLog.b("MMAdImplController", "No download in progress.");
                CachedAd localCachedAd = AdCache.f(localContext, paramMMAdImpl.k());
                if (localCachedAd != null) {
                    MMLog.c("MMAdImplController", "Last ad wasn't fully downloaded. Download again.");
                    MMSDK.Event.b(paramMMAdImpl);
                    AdCache.a(localContext, paramMMAdImpl.k(), localCachedAd, this);
                    continue;
                }
                MMLog.c("MMAdImplController", "No incomplete downloads.");
            } finally {
            }
            bool = false;
        }
    }

    int a(MMAdImpl paramMMAdImpl, CachedAd paramCachedAd) {
        if (paramCachedAd.a()) {
            MMLog.b("MMAdImplController", String.format("%s is expired.", new Object[]{paramCachedAd.e()}));
            return 21;
        }
        if (!paramCachedAd.d(paramMMAdImpl.j())) {
            MMLog.b("MMAdImplController", String.format("%s is not on disk.", new Object[]{paramCachedAd.e()}));
            return 22;
        }
        if (!HandShake.a(paramMMAdImpl.j()).a(paramMMAdImpl.f, paramCachedAd.c)) {
            MMLog.b("MMAdImplController", String.format("%s cannot be shown at this time.", new Object[]{paramCachedAd.e()}));
            return 24;
        }
        return 100;
    }

    void a() {
        MMAdImpl localMMAdImpl = (MMAdImpl) this.c.get();
        if (localMMAdImpl == null) {
            MMLog.e("MMAdImplController", MMException.a(25));
            MMSDK.Event.a(localMMAdImpl, new MMException(25));
            return;
        }
        if (!localMMAdImpl.g()) {
            MMSDK.Event.a(localMMAdImpl, new MMException(16));
            return;
        }
        if (!MMSDK.a()) {
            MMLog.e("MMAdImplController", MMException.a(3));
            MMSDK.Event.a(localMMAdImpl, new MMException(3));
            return;
        }
        if (HandShake.a(localMMAdImpl.j()).b) {
            MMLog.c("MMAdImplController", "The server is no longer allowing ads.");
            MMSDK.Event.a(localMMAdImpl, new MMException(16));
            return;
        }
        try {
            MMLog.b("MMAdImplController", "adLayout - requestAd");
            i(localMMAdImpl);
            return;
        } catch (Exception localException) {
            MMLog.a("MMAdImplController", "There was an exception with the ad request. ", localException);
            localException.printStackTrace();
        }
    }

    void a(HttpMMHeaders paramHttpMMHeaders) {
        if (this.b != null) {
            this.b.a(paramHttpMMHeaders);
        }
    }

    void a(MMAdImpl paramMMAdImpl) {
        MMAdImpl localMMAdImpl = a(paramMMAdImpl.n);
        if (localMMAdImpl != null) {
            this.a = paramMMAdImpl.n;
            localMMAdImpl.k.a = paramMMAdImpl.h;
            localMMAdImpl.n = paramMMAdImpl.h;
        }
    }

    void a(String paramString) {
        if ((!TextUtils.isEmpty(paramString)) && (this.b != null)) {
            this.b.loadUrl(paramString);
        }
    }

    void a(String paramString1, String paramString2) {
        if (this.b != null) {
            this.b.a(paramString1, paramString2, (MMAdImpl) this.c.get());
        }
    }

    String b() {
        Object localObject1 = (MMAdImpl) this.c.get();
        if (localObject1 != null) {
            localObject1 = ((MMAdImpl) localObject1).j();
            if (localObject1 == null) {
            }
        }
        for (localObject1 = getDefaultUserAgentString((Context) localObject1); ; localObject1 = null) {
            Object localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence) localObject1)) {
                localObject2 = Build.MODEL;
            }
            return (String) localObject2;
        }
    }

    void b(String paramString1, String paramString2) {
        MMAdImpl localMMAdImpl = (MMAdImpl) this.c.get();
        if ((localMMAdImpl != null) && (this.b != null)) {
            this.b.a(paramString1, paramString2, localMMAdImpl);
        }
    }

    void d() {
        if (this.b != null) {
            this.b.b((MMAdImpl) this.c.get());
        }
    }

    public void downloadCompleted(CachedAd paramCachedAd, boolean paramBoolean) {
        MMAdImpl localMMAdImpl = (MMAdImpl) this.c.get();
        if (localMMAdImpl == null) {
            MMLog.e("MMAdImplController", MMException.a(25));
            return;
        }
        if (paramBoolean) {
            AdCache.a(localMMAdImpl.j(), localMMAdImpl.k(), paramCachedAd.e());
        }
        if (paramBoolean) {
            MMSDK.Event.f(localMMAdImpl);
            return;
        }
        MMSDK.Event.a(localMMAdImpl, new MMException(15));
    }

    public void downloadStart(CachedAd paramCachedAd) {
    }

    int f(MMAdImpl paramMMAdImpl) {
        CachedAd localCachedAd = AdCache.d(paramMMAdImpl.j(), paramMMAdImpl.k());
        if (localCachedAd != null) {
            if (localCachedAd.a(paramMMAdImpl.j(), paramMMAdImpl, true)) {
                return 0;
            }
            return a(paramMMAdImpl, localCachedAd);
        }
        MMLog.c("MMAdImplController", "No next ad.");
        return 20;
    }

    int g(MMAdImpl paramMMAdImpl) {
        CachedAd localCachedAd = AdCache.d(paramMMAdImpl.j(), paramMMAdImpl.k());
        if (localCachedAd != null) {
            if (localCachedAd.a(paramMMAdImpl.j(), paramMMAdImpl, true)) {
                MMSDK.Event.c(paramMMAdImpl);
                AdCache.a(paramMMAdImpl.j(), paramMMAdImpl.k(), null);
                localCachedAd.a(paramMMAdImpl.j(), paramMMAdImpl.h);
                HandShake.a(paramMMAdImpl.j()).b(paramMMAdImpl.j(), paramMMAdImpl.f);
                return 0;
            }
            return a(paramMMAdImpl, localCachedAd);
        }
        return 20;
    }

    public String getDefaultUserAgentString(Context paramContext) {
        return System.getProperty("http.agent");
    }

    public String toString() {
        MMAdImpl localMMAdImpl = (MMAdImpl) this.c.get();
        StringBuilder localStringBuilder = new StringBuilder();
        if (localMMAdImpl != null) {
            localStringBuilder.append(localMMAdImpl + "-LinkInC=" + this.a);
        }
        return localStringBuilder.toString() + " w/" + this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMAdImplController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */