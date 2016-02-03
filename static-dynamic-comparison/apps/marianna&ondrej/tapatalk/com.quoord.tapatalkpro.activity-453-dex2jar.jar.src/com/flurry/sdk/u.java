package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryAdType;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.avro.protocol.v10.Callback;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class u {
    private static final String a = u.class.getSimpleName();
    private final FlurryAdModule b;
    private an c;
    private final m d;
    private final Map<String, a> e;

    public u(FlurryAdModule paramFlurryAdModule) {
        this.b = paramFlurryAdModule;
        this.d = new m();
        this.c = new an();
        this.e = new HashMap();
    }

    private void a(List<AdUnit> paramList) {
        if ((paramList == null) || (paramList.isEmpty())) {
            return;
        }
        this.c.a(paramList);
    }

    private a g(String paramString) {
        try {
            a locala2 = (a) this.e.get(paramString);
            a locala1 = locala2;
            if (locala2 == null) {
                locala1 = new a(paramString);
                this.e.put(paramString, locala1);
            }
            return locala1;
        } finally {
        }
    }

    public l a(FlurryAdModule paramFlurryAdModule, Context paramContext, ViewGroup paramViewGroup, String paramString) {
        return this.d.a(paramFlurryAdModule, paramContext, paramViewGroup, paramString);
    }

    public List<AdUnit> a(String paramString, int paramInt1, int paramInt2) {
        if (TextUtils.isEmpty(paramString)) {
            return Collections.emptyList();
        }
        List localList = this.c.a(paramString, paramInt1, paramInt2);
        this.c.a(paramString, localList);
        return localList;
    }

    public void a() {
        try {
            Iterator localIterator = this.e.values().iterator();
            while (localIterator.hasNext()) {
                ((a) localIterator.next()).a();
            }
            this.e.clear();
        } finally {
        }
    }

    public void a(final Activity paramActivity, du.a parama) {
        if (du.a.c.equals(parama)) {
            paramActivity = this.d.a(paramActivity).iterator();
            while (paramActivity.hasNext()) {
                ((l) paramActivity.next()).c();
            }
        }
        if (du.a.d.equals(parama)) {
            paramActivity = this.d.a(paramActivity).iterator();
            while (paramActivity.hasNext()) {
                ((l) paramActivity.next()).b();
            }
        }
        if (du.a.b.equals(parama)) {
            this.b.a(new ff() {
                public void a() {
                    u.this.a(paramActivity);
                }
            });
        }
    }

    public void a(Context paramContext, String paramString) {
        eo.a(3, a, "removeAd: context = " + paramContext + ", adSpaceName = " + paramString);
        g(paramString).c();
    }

    public void a(Context paramContext, String paramString, ViewGroup paramViewGroup, FlurryAdSize paramFlurryAdSize, boolean paramBoolean) {
        eo.a(3, a, "fetchAd: context = " + paramContext + ", adSpaceName = " + paramString + ", viewGroup = " + paramViewGroup + ", size = " + paramFlurryAdSize + ", autoDisplay = " + paramBoolean);
        g(paramString).a(paramContext, paramViewGroup, paramFlurryAdSize, paramBoolean);
    }

    void a(String paramString, int paramInt) {
        if (TextUtils.isEmpty(paramString)) {
            return;
        }
        this.c.a(paramString, paramInt);
    }

    public void a(String paramString, AdUnit paramAdUnit) {
        if ((TextUtils.isEmpty(paramString)) || (paramAdUnit == null)) {
            return;
        }
        this.c.a(paramString, paramAdUnit);
    }

    void a(String paramString1, String paramString2) {
        if (TextUtils.isEmpty(paramString1)) {
            return;
        }
        this.c.a(paramString1, paramString2);
    }

    public void a(String paramString, List<AdUnit> paramList) {
        if (paramList == null) {
        }
        a locala;
        do {
            return;
            eo.a(3, a, "Handling ad response");
            if (TextUtils.isEmpty(paramString)) {
                a(paramList);
                f(paramString);
                eo.a(3, a, "handleAdResponse: setting cache request limit count");
                return;
            }
            locala = g(paramString);
        } while (locala.a(paramList));
        a(paramList);
        f(paramString);
        eo.a(3, a, "handleAdResponse: setting cache request limit count");
        locala.f();
    }

    public boolean a(Context paramContext) {
        boolean bool = false;
        Iterator localIterator = this.d.a(paramContext).iterator();
        int i = 0;
        while (localIterator.hasNext()) {
            a(paramContext, ((l) localIterator.next()).getAdSpace());
            i += 1;
        }
        eo.a(3, a, "removeAllAds: removed " + i + " banners");
        if (i > 0) {
            bool = true;
        }
        return bool;
    }

    public boolean a(Context paramContext, String paramString, ViewGroup paramViewGroup) {
        eo.a(3, a, "displayAd: context = " + paramContext + ", adSpaceName = " + paramString + ", viewGroup = " + paramViewGroup);
        return g(paramString).a(paramContext, paramViewGroup);
    }

    public boolean a(Context paramContext, String paramString, ViewGroup paramViewGroup, FlurryAdSize paramFlurryAdSize) {
        eo.a(3, a, "getAd: context = " + paramContext + ", adSpaceName = " + paramString + ", viewGroup = " + paramViewGroup + ", size = " + paramFlurryAdSize);
        if (a(paramString)) {
            return a(paramContext, paramString, paramViewGroup);
        }
        a(paramContext, paramString, paramViewGroup, paramFlurryAdSize, true);
        return false;
    }

    public boolean a(Context paramContext, String paramString, FlurryAdSize paramFlurryAdSize) {
        eo.a(3, a, "isAdAvailable: adSpaceName = " + paramString);
        return a(paramString);
    }

    public boolean a(String paramString) {
        eo.a(3, a, "isAdReady: adSpaceName = " + paramString);
        return g(paramString).d();
    }

    public String b(String paramString) {
        return g(paramString).e();
    }

    public void b() {
        this.c.a();
    }

    public an c() {
        return this.c;
    }

    public l c(String paramString) {
        return this.d.a(paramString);
    }

    public void d(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return;
        }
        this.c.a(paramString);
    }

    public List<AdUnit> e(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return Collections.emptyList();
        }
        return this.c.d(paramString);
    }

    public void f(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return;
        }
        this.c.b(paramString);
        eo.a(3, a, "fetchAdTaskExecute: setting cache request limit count");
    }

    class a
            implements ap.b, fb.a {
        private final String b;
        private u.b c;
        private WeakReference<Context> d;
        private WeakReference<ViewGroup> e;
        private FlurryAdSize f;
        private boolean g;
        private List<AdUnit> h;
        private AdUnit i;
        private ah j;
        private int k;
        private long l;
        private long m;
        private long n;
        private long o;
        private long p;
        private String q;

        public a(String paramString) {
            this.b = paramString;
            this.c = u.b.a;
            this.d = new WeakReference(null);
            this.e = new WeakReference(null);
            a();
        }

        private void a(final AdFrame paramAdFrame, final ci paramci) {
            try {
                final String str = paramci.e();
                el localel = new el();
                localel.a(str);
                localel.b(new ey());
                localel.a(new el.a() {
                    public void a(el<Void, String> paramAnonymousel, String paramAnonymousString) {
                        int i = paramAnonymousel.e();
                        eo.a(3, u.d(), "VAST resolver: HTTP status code is:" + i + " for url: " + str);
                        ci localci = null;
                        if (paramAnonymousel.c()) {
                            eo.a(3, u.d(), "VAST resolver response:" + paramAnonymousString + " for url: " + str);
                            localci = ci.a(paramci, ck.a(paramAnonymousString));
                        }
                        if (localci == null) {
                            eo.a(3, u.d(), "VAST resolver failed for frame: " + paramAdFrame);
                            u.a(u.this).a(paramAdFrame.g().toString(), new ci.a().a().b());
                        }
                        for (; ; ) {
                            do.a().c(new ff() {
                                public void a() {
                                    u.a.e(u.a.this);
                                }
                            });
                            return;
                            eo.a(3, u.d(), "VAST resolver successful for frame: " + paramAdFrame);
                            u.a(u.this).a(paramAdFrame.g().toString(), localci);
                        }
                    }
                });
                em.a().a(this, localel);
                return;
            } finally {
                paramAdFrame =finally;
                throw paramAdFrame;
            }
        }

        private void a(AdUnit paramAdUnit) {
            try {
                Object localObject = ((AdFrame) paramAdUnit.d().get(0)).g().toString();
                localObject = u.a(u.this).a((String) localObject);
                HashMap localHashMap = new HashMap();
                a("prepared", (Context) this.d.get(), localHashMap, paramAdUnit, (e) localObject, 0, 0);
                return;
            } finally {
                paramAdUnit =finally;
                throw paramAdUnit;
            }
        }

        private void a(AdUnit paramAdUnit, b paramb) {
            try {
                a();
                Object localObject = ((AdFrame) paramAdUnit.d().get(0)).g().toString();
                e locale = u.a(u.this).a((String) localObject);
                HashMap localHashMap = new HashMap();
                localHashMap.put("preRender", "true");
                localObject = paramb;
                if (paramb == null) {
                    localObject = b.a;
                }
                localHashMap.put("errorCode", Integer.toString(((b) localObject).a()));
                a("renderFailed", (Context) this.d.get(), localHashMap, paramAdUnit, locale, 0, 0);
                return;
            } finally {
            }
        }

        private void a(final AdUnit paramAdUnit, final String paramString) {
            try {
                eo.a(3, u.d(), "Pre-render: HTTP get for url: " + paramString);
                el localel = new el();
                localel.a(paramString);
                localel.b(new ey());
                localel.a(new el.a() {
                    public void a(el<Void, String> arg1, String paramAnonymousString) {
                        int i =???.e();
                        eo.a(3, u.d(), "Prerender: HTTP status code is:" + i + " for url: " + paramString);
                        if (???.c()){
                            synchronized (u.a.this) {
                                u.a.a(u.a.this, paramAnonymousString);
                                do.a().c(new ff() {
                                    public void a() {
                                        u.a.i(u.a.this);
                                        u.a.a(u.a.this, (Context) u.a.j(u.a.this).get(), (ViewGroup) u.a.k(u.a.this).get());
                                    }
                                });
                                return;
                            }
                        }
                        do.a().c(new ff() {
                            public void a() {
                                u.a.a(u.a.this, u.a .4. this.b, b.k);
                            }
                        });
                    }
                });
                em.a().a(this, localel);
                return;
            } finally {
                paramAdUnit =finally;
                throw paramAdUnit;
            }
        }

        /* Error */
        private void a(b paramb) {
            // Byte code:
            //   0: aload_0
            //   1: monitorenter
            //   2: getstatic 240	com/flurry/sdk/u$b:e	Lcom/flurry/sdk/u$b;
            //   5: aload_0
            //   6: getfield 100	com/flurry/sdk/u$a:c	Lcom/flurry/sdk/u$b;
            //   9: invokevirtual 244	com/flurry/sdk/u$b:equals	(Ljava/lang/Object;)Z
            //   12: istore_2
            //   13: iload_2
            //   14: ifne +6 -> 20
            //   17: aload_0
            //   18: monitorexit
            //   19: return
            //   20: aload_0
            //   21: getfield 246	com/flurry/sdk/u$a:h	Ljava/util/List;
            //   24: ifnull -7 -> 17
            //   27: aload_0
            //   28: getfield 246	com/flurry/sdk/u$a:h	Ljava/util/List;
            //   31: invokeinterface 249 1 0
            //   36: ifeq -19 -> 17
            //   39: aload_0
            //   40: aload_0
            //   41: getfield 246	com/flurry/sdk/u$a:h	Ljava/util/List;
            //   44: iconst_0
            //   45: invokeinterface 159 2 0
            //   50: checkcast 150	com/flurry/android/impl/ads/avro/protocol/v10/AdUnit
            //   53: aload_1
            //   54: invokespecial 251	com/flurry/sdk/u$a:a	(Lcom/flurry/android/impl/ads/avro/protocol/v10/AdUnit;Lcom/flurry/sdk/b;)V
            //   57: goto -40 -> 17
            //   60: astore_1
            //   61: aload_0
            //   62: monitorexit
            //   63: aload_1
            //   64: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	65	0	this	a
            //   0	65	1	paramb	b
            //   12	2	2	bool	boolean
            // Exception table:
            //   from	to	target	type
            //   2	13	60	finally
            //   20	57	60	finally
        }

        /* Error */
        private void a(u.b paramb) {
            // Byte code:
            //   0: aload_0
            //   1: monitorenter
            //   2: aload_1
            //   3: astore_2
            //   4: aload_1
            //   5: ifnonnull +7 -> 12
            //   8: getstatic 98	com/flurry/sdk/u$b:a	Lcom/flurry/sdk/u$b;
            //   11: astore_2
            //   12: iconst_3
            //   13: invokestatic 219	com/flurry/sdk/u:d	()Ljava/lang/String;
            //   16: new 221	java/lang/StringBuilder
            //   19: dup
            //   20: invokespecial 222	java/lang/StringBuilder:<init>	()V
            //   23: ldc_w 262
            //   26: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   29: aload_0
            //   30: getfield 100	com/flurry/sdk/u$a:c	Lcom/flurry/sdk/u$b;
            //   33: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   36: ldc_w 267
            //   39: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   42: aload_2
            //   43: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   46: ldc_w 269
            //   49: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   52: aload_0
            //   53: getfield 94	com/flurry/sdk/u$a:b	Ljava/lang/String;
            //   56: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   59: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   62: invokestatic 234	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
            //   65: getstatic 98	com/flurry/sdk/u$b:a	Lcom/flurry/sdk/u$b;
            //   68: aload_0
            //   69: getfield 100	com/flurry/sdk/u$a:c	Lcom/flurry/sdk/u$b;
            //   72: invokevirtual 244	com/flurry/sdk/u$b:equals	(Ljava/lang/Object;)Z
            //   75: ifeq +95 -> 170
            //   78: getstatic 98	com/flurry/sdk/u$b:a	Lcom/flurry/sdk/u$b;
            //   81: aload_2
            //   82: invokevirtual 244	com/flurry/sdk/u$b:equals	(Ljava/lang/Object;)Z
            //   85: ifne +85 -> 170
            //   88: iconst_3
            //   89: invokestatic 219	com/flurry/sdk/u:d	()Ljava/lang/String;
            //   92: new 221	java/lang/StringBuilder
            //   95: dup
            //   96: invokespecial 222	java/lang/StringBuilder:<init>	()V
            //   99: ldc_w 271
            //   102: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   105: aload_0
            //   106: getfield 94	com/flurry/sdk/u$a:b	Ljava/lang/String;
            //   109: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   112: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   115: invokestatic 234	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
            //   118: invokestatic 276	com/flurry/sdk/fa:a	()Lcom/flurry/sdk/fa;
            //   121: aload_0
            //   122: invokevirtual 279	com/flurry/sdk/fa:a	(Lcom/flurry/sdk/fb$a;)V
            //   125: invokestatic 284	com/flurry/sdk/ap:a	()Lcom/flurry/sdk/ap;
            //   128: aload_0
            //   129: invokevirtual 287	com/flurry/sdk/ap:a	(Lcom/flurry/sdk/ap$b;)V
            //   132: iconst_3
            //   133: invokestatic 219	com/flurry/sdk/u:d	()Ljava/lang/String;
            //   136: new 221	java/lang/StringBuilder
            //   139: dup
            //   140: invokespecial 222	java/lang/StringBuilder:<init>	()V
            //   143: ldc_w 289
            //   146: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   149: aload_0
            //   150: getfield 94	com/flurry/sdk/u$a:b	Ljava/lang/String;
            //   153: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   156: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   159: invokestatic 234	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
            //   162: aload_0
            //   163: aload_2
            //   164: putfield 100	com/flurry/sdk/u$a:c	Lcom/flurry/sdk/u$b;
            //   167: aload_0
            //   168: monitorexit
            //   169: return
            //   170: getstatic 98	com/flurry/sdk/u$b:a	Lcom/flurry/sdk/u$b;
            //   173: aload_2
            //   174: invokevirtual 244	com/flurry/sdk/u$b:equals	(Ljava/lang/Object;)Z
            //   177: ifeq -15 -> 162
            //   180: getstatic 98	com/flurry/sdk/u$b:a	Lcom/flurry/sdk/u$b;
            //   183: aload_0
            //   184: getfield 100	com/flurry/sdk/u$a:c	Lcom/flurry/sdk/u$b;
            //   187: invokevirtual 244	com/flurry/sdk/u$b:equals	(Ljava/lang/Object;)Z
            //   190: ifne -28 -> 162
            //   193: iconst_3
            //   194: invokestatic 219	com/flurry/sdk/u:d	()Ljava/lang/String;
            //   197: new 221	java/lang/StringBuilder
            //   200: dup
            //   201: invokespecial 222	java/lang/StringBuilder:<init>	()V
            //   204: ldc_w 291
            //   207: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   210: aload_0
            //   211: getfield 94	com/flurry/sdk/u$a:b	Ljava/lang/String;
            //   214: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   217: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   220: invokestatic 234	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
            //   223: invokestatic 276	com/flurry/sdk/fa:a	()Lcom/flurry/sdk/fa;
            //   226: aload_0
            //   227: invokevirtual 294	com/flurry/sdk/fa:b	(Lcom/flurry/sdk/fb$a;)Z
            //   230: pop
            //   231: invokestatic 284	com/flurry/sdk/ap:a	()Lcom/flurry/sdk/ap;
            //   234: aload_0
            //   235: invokevirtual 297	com/flurry/sdk/ap:b	(Lcom/flurry/sdk/ap$b;)Z
            //   238: pop
            //   239: iconst_3
            //   240: invokestatic 219	com/flurry/sdk/u:d	()Ljava/lang/String;
            //   243: new 221	java/lang/StringBuilder
            //   246: dup
            //   247: invokespecial 222	java/lang/StringBuilder:<init>	()V
            //   250: ldc_w 299
            //   253: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   256: aload_0
            //   257: getfield 94	com/flurry/sdk/u$a:b	Ljava/lang/String;
            //   260: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   263: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   266: invokestatic 234	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
            //   269: goto -107 -> 162
            //   272: astore_1
            //   273: aload_0
            //   274: monitorexit
            //   275: aload_1
            //   276: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	277	0	this	a
            //   0	277	1	paramb	u.b
            //   3	171	2	localb	u.b
            // Exception table:
            //   from	to	target	type
            //   8	12	272	finally
            //   12	162	272	finally
            //   162	167	272	finally
            //   170	269	272	finally
        }

        private void a(final String paramString, final Context paramContext, final Map<String, String> paramMap, final AdUnit paramAdUnit, final e parame, int paramInt1, int paramInt2) {
            try {
                eo.a(3, u.d(), "fireEvent(event=" + paramString + ",params=" + paramMap + ")");
                do.a().c(new ff() {
                    public void a() {
                        u.a(u.this).a(new q(paramString, paramMap, paramContext, paramAdUnit, parame, 0), u.a(u.this).a(), 0);
                    }
                });
                return;
            } finally {
                paramString =finally;
                throw paramString;
            }
        }

        private void b(final Context paramContext, final ViewGroup paramViewGroup) {
            try {
                if (this.g) {
                    do.a().a(new ff() {
                        public void a() {
                            u.a.this.a(paramContext, paramViewGroup);
                        }
                    });
                }
                return;
            } finally {
                paramContext =finally;
                throw paramContext;
            }
        }

        private void b(AdUnit paramAdUnit) {
            try {
                Object localObject = ((AdFrame) paramAdUnit.d().get(0)).g().toString();
                localObject = u.a(u.this).a((String) localObject);
                HashMap localHashMap = new HashMap();
                a("unfilled", (Context) this.d.get(), localHashMap, paramAdUnit, (e) localObject, 0, 0);
                return;
            } finally {
                paramAdUnit =finally;
                throw paramAdUnit;
            }
        }

        private void b(final b paramb) {
            try {
                a();
                paramb = u.a(u.this).ac();
                eo.a(3, u.d(), "Firing onRenderFailed, listener=" + paramb);
                if (paramb != null) {
                    do.a().a(new ff() {
                        public void a() {
                            paramb.onRenderFailed(u.a.m(u.a.this));
                        }
                    });
                }
                return;
            } finally {
            }
        }

        private void h() {
            try {
                if ((this.l > 0L) && (System.currentTimeMillis() > this.l)) {
                    u();
                }
                return;
            } finally {
                localObject =finally;
                throw ((Throwable) localObject);
            }
        }

        private void i() {
            try {
                if ((this.m > 0L) && (System.currentTimeMillis() > this.m)) {
                    n();
                }
                return;
            } finally {
                localObject =finally;
                throw ((Throwable) localObject);
            }
        }

        /* Error */
        private void j() {
            // Byte code:
            //   0: aload_0
            //   1: monitorenter
            //   2: aload_0
            //   3: getfield 370	com/flurry/sdk/u$a:o	J
            //   6: lconst_0
            //   7: lcmp
            //   8: ifle +24 -> 32
            //   11: invokestatic 355	java/lang/System:currentTimeMillis	()J
            //   14: aload_0
            //   15: getfield 370	com/flurry/sdk/u$a:o	J
            //   18: lcmp
            //   19: ifle +13 -> 32
            //   22: aload_0
            //   23: getstatic 372	com/flurry/sdk/b:m	Lcom/flurry/sdk/b;
            //   26: invokespecial 374	com/flurry/sdk/u$a:a	(Lcom/flurry/sdk/b;)V
            //   29: aload_0
            //   30: monitorexit
            //   31: return
            //   32: aload_0
            //   33: getfield 376	com/flurry/sdk/u$a:n	J
            //   36: lconst_0
            //   37: lcmp
            //   38: ifle -9 -> 29
            //   41: invokestatic 355	java/lang/System:currentTimeMillis	()J
            //   44: aload_0
            //   45: getfield 376	com/flurry/sdk/u$a:n	J
            //   48: lcmp
            //   49: ifle -20 -> 29
            //   52: aload_0
            //   53: invokespecial 378	com/flurry/sdk/u$a:m	()V
            //   56: aload_0
            //   57: invokespecial 343	com/flurry/sdk/u$a:l	()V
            //   60: goto -31 -> 29
            //   63: astore_1
            //   64: aload_0
            //   65: monitorexit
            //   66: aload_1
            //   67: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	68	0	this	a
            //   63	4	1	localObject	Object
            // Exception table:
            //   from	to	target	type
            //   2	29	63	finally
            //   32	60	63	finally
        }

        private void k() {
            try {
                if ((this.p > 0L) && (System.currentTimeMillis() > this.p)) {
                    em.a().a(this);
                    a(this.j.c(), b.o);
                }
                return;
            } finally {
                localObject =finally;
                throw ((Throwable) localObject);
            }
        }

        private void l() {
            for (; ; ) {
                try {
                    boolean bool = u.b.e.equals(this.c);
                    if (!bool) {
                        return;
                    }
                    if ((Context) this.d.get() == null) {
                        u();
                        continue;
                    }
                    if (!FlurryAdModule.i()) {
                        break label60;
                    }
                } finally {
                }
                u();
                continue;
                label60:
                ap localap = ap.a();
                label65:
                AdUnit localAdUnit;
                Object localObject2;
                AdFrame localAdFrame;
                ci localci;
                long l1;
                if (this.h.size() > 0) {
                    localAdUnit = (AdUnit) this.h.get(0);
                    localObject2 = localAdUnit.d();
                    if ((localObject2 == null) || (((List) localObject2).isEmpty())) {
                        a(localAdUnit, b.f);
                        continue;
                    }
                    localObject2 = localAdUnit.d().iterator();
                    for (; ; ) {
                        if (((Iterator) localObject2).hasNext()) {
                            localAdFrame = (AdFrame) ((Iterator) localObject2).next();
                            if (localAdFrame.b().intValue() == 6) {
                                localAdUnit.a(Boolean.valueOf(true));
                                a(u.b.c);
                                g();
                                break;
                            }
                            localci = u.a(u.this).b(localAdFrame.g().toString());
                            if ((localci != null) && (!localci.c())) {
                                if (!localci.d()) {
                                    break label434;
                                }
                            }
                        }
                    }
                    this.o = 0L;
                    if (!localap.b(localAdUnit)) {
                        break label720;
                    }
                    localObject2 = localap.c(localAdUnit);
                    l1 = localAdUnit.p().intValue();
                    eo.a(3, u.d(), "Pre-caching required for ad, AdUnitCachedStatus: " + localObject2 + ", skip time limit: " + l1);
                    if ((!ap.a.d.equals(localObject2)) && (l1 > 0L) && (this.n == 0L)) {
                        eo.a(3, u.d(), "Setting skip timer for " + l1 + " ms");
                        this.n = (System.currentTimeMillis() + l1);
                    }
                    if (!ap.a.d.equals(localObject2)) {
                        break label511;
                    }
                    eo.a(3, u.d(), "Pre-caching completed, ad may proceed");
                }
                for (; ; ) {
                    if (this.h.size() <= 0) {
                        break label733;
                    }
                    a(u.b.f);
                    do.a().a(new ff() {
                        public void a() {
                            u.a.g(u.a.this);
                        }
                    });
                    break;
                    label434:
                    l1 = localAdUnit.o().longValue();
                    if ((l1 > 0L) && (this.o == 0L)) {
                        eo.a(3, u.d(), "Setting VAST resolve timeout for " + l1 + " ms");
                        this.o = (l1 + System.currentTimeMillis());
                    }
                    a(localAdFrame, localci);
                    break;
                    label511:
                    if (ap.a.b.equals(localObject2)) {
                        if (l1 == 0L) {
                            eo.a(3, u.d(), "No skip timer");
                            m();
                            break label65;
                        }
                        if (l1 <= 0L) {
                            break label65;
                        }
                        if (System.currentTimeMillis() > this.n) {
                            eo.a(3, u.d(), "Skip timer expired");
                            m();
                            break label65;
                        }
                        eo.a(3, u.d(), "Waiting for skip timer");
                        break;
                    }
                    if (l1 == 0L) {
                        eo.a(3, u.d(), "No skip timer");
                        m();
                        break label65;
                    }
                    int i1 = this.k + 1;
                    this.k = i1;
                    if (i1 > 1) {
                        eo.a(3, u.d(), "Too many precaching attempts, precaching failed");
                        a(b.h);
                        break;
                    }
                    i1 = localap.e(localAdUnit);
                    if (i1 > 0) {
                        eo.a(3, u.d(), "Requesting " + i1 + " asset(s), attempt #" + this.k);
                        break;
                    }
                    eo.a(3, u.d(), "No assets to cache");
                    continue;
                    label720:
                    eo.a(3, u.d(), "Pre-caching not required for ad");
                }
                label733:
                u.a(u.this).O();
                u();
                v();
            }
        }

        private void m() {
            for (; ; ) {
                try {
                    boolean bool = u.b.e.equals(this.c);
                    if (!bool) {
                        return;
                    }
                    if ((this.h == null) || (this.h.size() == 0)) {
                        continue;
                    }
                    String str = ((AdUnit) this.h.remove(0)).f().toString();
                    eo.a(3, u.d(), "Precaching required for incomplete ad unit, skipping ad group -- adspace: " + this.b + " groupId: " + str);
                    if (!TextUtils.isEmpty(str)) {
                        if ((this.h.size() > 0) && (str.equals(((AdUnit) this.h.get(0)).f().toString()))) {
                            this.h.remove(0);
                            continue;
                        }
                    }
                    u.a(u.this).a("precachingAdGroupSkipped", 1);
                } finally {
                }
                this.k = 0;
                this.n = 0L;
            }
        }

        private void n() {
            label287:
            for (; ; ) {
                try {
                    if (!u.b.c.equals(this.c)) {
                        boolean bool = u.b.d.equals(this.c);
                        if (!bool) {
                            return;
                        }
                    }
                    if ((this.h == null) || (this.h.size() == 0)) {
                        continue;
                    }
                    Iterator localIterator1 = ((AdFrame) ((AdUnit) this.h.get(0)).d().get(0)).f().iterator();
                    int i2 = 1;
                    if (localIterator1.hasNext()) {
                        Object localObject1 = (Callback) localIterator1.next();
                        if (!((Callback) localObject1).b().toString().equals("unfilled")) {
                            continue;
                        }
                        Iterator localIterator2 = ((Callback) localObject1).c().iterator();
                        int i1 = i2;
                        i2 = i1;
                        if (!localIterator2.hasNext()) {
                            continue;
                        }
                        String str = ((CharSequence) localIterator2.next()).toString();
                        i2 = str.indexOf('?');
                        localObject1 = str;
                        if (i2 != -1) {
                            localObject1 = str.substring(0, i2);
                        }
                        if (!((String) localObject1).equals("nextAdUnit")) {
                            break label287;
                        }
                        i1 = 0;
                        break label287;
                    }
                    if (i2 == 1) {
                        b((AdUnit) this.h.get(0));
                        a((AdUnit) this.h.get(0), b.n);
                        continue;
                    }
                    b((AdUnit) this.h.get(0));
                } finally {
                }
                b();
            }
        }

        private void o() {
            for (; ; ) {
                ViewGroup localViewGroup;
                AdUnit localAdUnit;
                try {
                    boolean bool = u.b.f.equals(this.c);
                    if (!bool) {
                        return;
                    }
                    eo.a(3, u.d(), "Preparing ad");
                    Context localContext1 = (Context) this.d.get();
                    localViewGroup = (ViewGroup) this.e.get();
                    localAdUnit = (AdUnit) this.h.get(0);
                    if (this.i == null) {
                        u.this.a(this.b, localAdUnit);
                        if (localContext1 != null) {
                            break label126;
                        }
                        a(localAdUnit, b.e);
                        continue;
                    }
                    u.this.a(this.b, this.i);
                } finally {
                }
                continue;
                label126:
                this.j = u.a(u.this).a(localContext2, localAdUnit, this.b, localViewGroup, this.f);
                a(u.b.g);
                do.a().c(new ff() {
                    public void a() {
                        u.a.h(u.a.this);
                    }
                });
            }
        }

        private void p() {
            for (; ; ) {
                try {
                    boolean bool = u.b.g.equals(this.c);
                    if (!bool) {
                        return;
                    }
                    if (this.j == null) {
                        u();
                        continue;
                    }
                    eo.a(3, u.d(), "Pre-rendering ad");
                } finally {
                }
                AdUnit localAdUnit = this.j.c();
                Object localObject2 = localAdUnit.d();
                if ((localObject2 == null) || (((List) localObject2).isEmpty())) {
                    u();
                } else {
                    Object localObject3 = ((List) localObject2).iterator();
                    for (; ; ) {
                        if (((Iterator) localObject3).hasNext()) {
                            Object localObject4 = (AdFrame) ((Iterator) localObject3).next();
                            localObject4 = u.a(u.this).b(((AdFrame) localObject4).g().toString());
                            if ((localObject4 != null) && ((!((ci) localObject4).c()) || (((ci) localObject4).d()))) {
                                a(localAdUnit, b.g);
                                break;
                            }
                        }
                    }
                    localObject3 = ap.a();
                    if (((ap) localObject3).b(localAdUnit)) {
                        eo.a(3, u.d(), "Precaching required for ad, copying assets");
                        localObject3 = ((ap) localObject3).c(localAdUnit);
                        if (ap.a.d.equals(localObject3)) {
                            u.a(u.this).a("precachingAdAssetsAvailable", 1);
                            if (!ap.a().d(localAdUnit)) {
                                eo.a(3, u.d(), "Could not copy required ad assets");
                                u.a(u.this).a("precachingAdAssetCopyFailed", 1);
                                a(localAdUnit, b.i);
                            }
                        } else {
                            eo.a(3, u.d(), "Ad assets incomplete");
                            u.a(u.this).a("precachingAdAssetsIncomplete", 1);
                            a(localAdUnit, b.j);
                        }
                    } else if (((ap) localObject3).a(localAdUnit)) {
                        eo.a(3, u.d(), "Precaching optional for ad, copying assets");
                        ap.a().d(localAdUnit);
                    }
                    a(localAdUnit);
                    localObject2 = (AdFrame) ((List) localObject2).get(0);
                    if (((AdFrame) localObject2).b().intValue() == 1) {
                        eo.a(3, u.d(), "Binding is HTML_URL, pre-render required");
                        long l1 = localAdUnit.o().longValue();
                        if (l1 > 0L) {
                            eo.a(3, u.d(), "Setting pre-render timeout for " + l1 + " ms");
                            this.p = (l1 + System.currentTimeMillis());
                        }
                        a(localAdUnit, ((AdFrame) localObject2).c().toString());
                    } else {
                        t();
                        b((Context) this.d.get(), (ViewGroup) this.e.get());
                    }
                }
            }
        }

        /* Error */
        private void q() {
            // Byte code:
            //   0: aload_0
            //   1: monitorenter
            //   2: getstatic 628	com/flurry/sdk/u$b:i	Lcom/flurry/sdk/u$b;
            //   5: aload_0
            //   6: getfield 100	com/flurry/sdk/u$a:c	Lcom/flurry/sdk/u$b;
            //   9: invokevirtual 244	com/flurry/sdk/u$b:equals	(Ljava/lang/Object;)Z
            //   12: istore_1
            //   13: iload_1
            //   14: ifne +6 -> 20
            //   17: aload_0
            //   18: monitorexit
            //   19: return
            //   20: aload_0
            //   21: getfield 384	com/flurry/sdk/u$a:j	Lcom/flurry/sdk/ah;
            //   24: invokevirtual 389	com/flurry/sdk/ah:c	()Lcom/flurry/android/impl/ads/avro/protocol/v10/AdUnit;
            //   27: astore_2
            //   28: invokestatic 284	com/flurry/sdk/ap:a	()Lcom/flurry/sdk/ap;
            //   31: astore_3
            //   32: aload_3
            //   33: aload_2
            //   34: invokevirtual 441	com/flurry/sdk/ap:b	(Lcom/flurry/android/impl/ads/avro/protocol/v10/AdUnit;)Z
            //   37: ifne +29 -> 66
            //   40: aload_3
            //   41: aload_2
            //   42: invokevirtual 614	com/flurry/sdk/ap:a	(Lcom/flurry/android/impl/ads/avro/protocol/v10/AdUnit;)Z
            //   45: ifeq +21 -> 66
            //   48: iconst_3
            //   49: invokestatic 219	com/flurry/sdk/u:d	()Ljava/lang/String;
            //   52: ldc_w 630
            //   55: invokestatic 234	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
            //   58: invokestatic 284	com/flurry/sdk/ap:a	()Lcom/flurry/sdk/ap;
            //   61: aload_2
            //   62: invokevirtual 600	com/flurry/sdk/ap:d	(Lcom/flurry/android/impl/ads/avro/protocol/v10/AdUnit;)Z
            //   65: pop
            //   66: aload_0
            //   67: getstatic 632	com/flurry/sdk/u$b:j	Lcom/flurry/sdk/u$b;
            //   70: invokespecial 429	com/flurry/sdk/u$a:a	(Lcom/flurry/sdk/u$b;)V
            //   73: invokestatic 310	com/flurry/sdk/do:a	()Lcom/flurry/sdk/do;
            //   76: new 47	com/flurry/sdk/u$a$5
            //   79: dup
            //   80: aload_0
            //   81: invokespecial 633	com/flurry/sdk/u$a$5:<init>	(Lcom/flurry/sdk/u$a;)V
            //   84: invokevirtual 324	com/flurry/sdk/do:a	(Ljava/lang/Runnable;)V
            //   87: goto -70 -> 17
            //   90: astore_2
            //   91: aload_0
            //   92: monitorexit
            //   93: aload_2
            //   94: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	95	0	this	a
            //   12	2	1	bool	boolean
            //   27	35	2	localAdUnit	AdUnit
            //   90	4	2	localObject	Object
            //   31	10	3	localap	ap
            // Exception table:
            //   from	to	target	type
            //   2	13	90	finally
            //   20	66	90	finally
            //   66	87	90	finally
        }

        private void r() {
            for (; ; ) {
                ViewGroup localViewGroup;
                try {
                    boolean bool = u.b.j.equals(this.c);
                    if (!bool) {
                        return;
                    }
                    Context localContext1 = (Context) this.d.get();
                    localViewGroup = (ViewGroup) this.e.get();
                    if (localContext1 == null) {
                        b(b.e);
                        continue;
                    }
                    localAdUnit = this.j.c();
                } finally {
                }
                AdUnit localAdUnit;
                u.a(u.this).a(localContext2, localAdUnit, this.j);
                this.j.a(localContext2, localViewGroup);
                v();
                s();
            }
        }

        private void s() {
            try {
                a();
                final FlurryAdListener localFlurryAdListener = u.a(u.this).ac();
                eo.a(3, u.d(), "Firing onRendered, listener=" + localFlurryAdListener);
                if (localFlurryAdListener != null) {
                    do.a().a(new ff() {
                        public void a() {
                            localFlurryAdListener.onRendered(u.a.m(u.a.this));
                        }
                    });
                }
                return;
            } finally {
            }
        }

        private void t() {
            try {
                a(u.b.h);
                final FlurryAdListener localFlurryAdListener = u.a(u.this).ac();
                eo.a(3, u.d(), "Firing spaceDidReceiveAd, listener=" + localFlurryAdListener);
                if (localFlurryAdListener != null) {
                    do.a().a(new ff() {
                        public void a() {
                            localFlurryAdListener.spaceDidReceiveAd(u.a.m(u.a.this));
                        }
                    });
                }
                return;
            } finally {
            }
        }

        private void u() {
            try {
                a();
                final FlurryAdListener localFlurryAdListener = u.a(u.this).ac();
                eo.a(3, u.d(), "Firing spaceDidFailToReceiveAd, listener=" + localFlurryAdListener);
                if (localFlurryAdListener != null) {
                    do.a().a(new ff() {
                        public void a() {
                            localFlurryAdListener.spaceDidFailToReceiveAd(u.a.m(u.a.this));
                        }
                    });
                }
                return;
            } finally {
            }
        }

        private void v() {
            try {
                List localList = u.this.e(this.b);
                if (localList.isEmpty()) {
                    eo.a(3, u.d(), "Starting ad request from EnsureCacheNotEmpty size: " + localList.size());
                    FlurryAdModule.getInstance().e().a(this.b, (ViewGroup) this.e.get(), this.f, false, null);
                }
                return;
            } finally {
                localObject =finally;
                throw ((Throwable) localObject);
            }
        }

        public void a() {
            try {
                em.a().a(this);
                a(u.b.a);
                this.d.clear();
                this.e.clear();
                this.f = null;
                this.g = false;
                this.h = null;
                this.i = null;
                this.j = null;
                this.k = 0;
                this.l = 0L;
                this.m = 0L;
                this.n = 0L;
                this.o = 0L;
                this.p = 0L;
                this.q = null;
                return;
            } finally {
                localObject =finally;
                throw ((Throwable) localObject);
            }
        }

        public void a(Context paramContext, ViewGroup paramViewGroup, FlurryAdSize paramFlurryAdSize, boolean paramBoolean) {
            for (; ; ) {
                try {
                    if (d()) {
                        t();
                        return;
                    }
                    if (!u.b.a.equals(this.c)) {
                        continue;
                    }
                    if (!ev.a().c()) {
                        eo.a(5, u.d(), "There is no network connectivity (ad will not fetch)");
                        u();
                        continue;
                    }
                    u.a(u.this).L();
                } finally {
                }
                this.d = new WeakReference(paramContext);
                this.e = new WeakReference(paramViewGroup);
                this.f = paramFlurryAdSize;
                this.g = paramBoolean;
                this.h = u.this.e(this.b);
                if (this.h.isEmpty()) {
                    a(u.b.b);
                    if (15000L > 0L) {
                        eo.a(3, u.d(), "Setting ad request timeout for " + 15000L + " ms");
                        this.l = (15000L + System.currentTimeMillis());
                    }
                    u.a(u.this).e().a(this.b, (ViewGroup) this.e.get(), this.f, false, null);
                } else {
                    a(u.b.e);
                    do.a().c(new ff() {
                        public void a() {
                            u.a.e(u.a.this);
                        }
                    });
                }
            }
        }

        public void a(fb paramfb) {
            for (; ; ) {
                try {
                    if (u.b.b.equals(this.c)) {
                        do.a().c(new ff() {
                            public void a() {
                                u.a.a(u.a.this);
                            }
                        });
                        return;
                    }
                    if (u.b.d.equals(this.c)) {
                        do.a().c(new ff() {
                            public void a() {
                                u.a.b(u.a.this);
                            }
                        });
                        continue;
                    }
                    if (!u.b.e.equals(this.c)) {
                        break label97;
                    }
                } finally {
                }
                do.a().c(new ff() {
                    public void a() {
                        u.a.c(u.a.this);
                    }
                });
                continue;
                label97:
                if (u.b.g.equals(this.c)) {
                    do.a().c(new ff() {
                        public void a() {
                            u.a.d(u.a.this);
                        }
                    });
                }
            }
        }

        public void a(String paramString, ar paramar) {
            try {
                eo.a(3, u.d(), "Detected asset status change for asset:" + paramString + " status:" + paramar);
                if ((u.b.e.equals(this.c)) && ((ar.d.equals(paramar)) || (ar.g.equals(paramar)))) {
                    do.a().c(new ff() {
                        public void a() {
                            u.a.e(u.a.this);
                        }
                    });
                }
                return;
            } finally {
            }
        }

        public boolean a(Context paramContext, ViewGroup paramViewGroup) {
            boolean bool2 = false;
            for (; ; ) {
                try {
                    bool1 = u.b.h.equals(this.c);
                    if (!bool1) {
                        return bool2;
                    }
                    if (!ev.a().c()) {
                        eo.a(5, u.d(), "There is no network connectivity (ad will not display)");
                        b(b.c);
                        continue;
                    }
                    if (this.j != null) {
                        break label76;
                    }
                } finally {
                }
                b(b.d);
                continue;
                label76:
                if (paramContext != null) {
                    break;
                }
                b(b.e);
            }
            this.d = new WeakReference(paramContext);
            this.e = new WeakReference(paramViewGroup);
            FlurryAdListener localFlurryAdListener = u.a(u.this).ac();
            eo.a(3, u.d(), "Firing shouldDisplayAd, listener=" + localFlurryAdListener);
            if (localFlurryAdListener != null) {
            }
            for (; ; ) {
                try {
                    String str = this.b;
                    if (!(this.j instanceof j)) {
                        continue;
                    }
                    paramContext = FlurryAdType.WEB_BANNER;
                    bool1 = localFlurryAdListener.shouldDisplayAd(str, paramContext);
                } catch (Throwable paramContext) {
                    eo.a(6, u.d(), "AdListener.shouldDisplayAd", paramContext);
                    bool1 = false;
                    continue;
                }
                if (!bool1) {
                    break;
                }
                if ((paramViewGroup != null) && ((this.j instanceof j))) {
                    paramViewGroup.setBackgroundColor(369098752);
                }
                a(u.b.i);
                do.a().c(new ff() {
                    public void a() {
                        u.a.f(u.a.this);
                    }
                });
                bool2 = true;
                break;
                paramContext = FlurryAdType.WEB_TAKEOVER;
            }
        }

        public boolean a(List<AdUnit> paramList) {
            for (; ; ) {
                try {
                    if (u.b.d.equals(this.c)) {
                        if ((paramList != null) && (!paramList.isEmpty())) {
                            int i1 = paramList.size();
                            if (i1 <= 1) {
                            }
                        } else {
                            bool = false;
                            return bool;
                        }
                        AdUnit localAdUnit = (AdUnit) paramList.get(0);
                        if (!localAdUnit.s().booleanValue()) {
                            bool = false;
                            continue;
                        }
                        paramList = localAdUnit.d();
                        if ((paramList == null) || (paramList.isEmpty()) || (((AdFrame) paramList.get(0)).b().intValue() == 6)) {
                            break label360;
                        }
                        this.h.remove(0);
                        List localList = null;
                        paramList = localList;
                        if (localAdUnit != null) {
                            Map localMap = localAdUnit.t();
                            paramList = localList;
                            if (localMap != null) {
                                paramList = localList;
                                if (localMap.containsKey("GROUP_ID")) {
                                    paramList = ((CharSequence) localMap.get("GROUP_ID")).toString();
                                }
                            }
                        }
                        if (paramList == null) {
                            paramList = (AdFrame) localAdUnit.d().get(0);
                            localList = this.i.d();
                            localList.remove(0);
                            localList.add(0, paramList);
                            localAdUnit.a(localList);
                            localAdUnit.a(this.i.f());
                            if ((localAdUnit.t() != null) && (localAdUnit.t().isEmpty())) {
                                localAdUnit.a(this.i.t());
                            }
                            localAdUnit.b(this.i.g());
                            this.h.add(0, localAdUnit);
                            a(u.b.e);
                            do.a().c(new ff() {
                                public void a() {
                                    u.a.e(u.a.this);
                                }
                            });
                            bool = true;
                            continue;
                        }
                        this.h.add(0, localAdUnit);
                        continue;
                    }
                    bool = false;
                } finally {
                }
                continue;
                label360:
                boolean bool = false;
            }
        }

        public void b() {
            try {
                AdUnit localAdUnit = (AdUnit) this.h.get(0);
                u.b(u.this).a(this.b, localAdUnit);
                this.h.remove(0);
                a();
                return;
            } finally {
                localObject =finally;
                throw ((Throwable) localObject);
            }
        }

        public void c() {
            try {
                l locall = u.c(u.this).a(this.b);
                if (locall != null) {
                    locall.d();
                    locall.removeAllViews();
                    ViewGroup localViewGroup = locall.getViewGroup();
                    if (localViewGroup != null) {
                        localViewGroup.removeView(locall);
                    }
                    u.c(u.this).a(locall);
                }
                u.a(u.this).g(this.b);
                a();
                return;
            } finally {
            }
        }

        public boolean d() {
            try {
                boolean bool = u.b.h.equals(this.c);
                return bool;
            } finally {
                localObject =finally;
                throw ((Throwable) localObject);
            }
        }

        public String e() {
            try {
                String str = this.q;
                return str;
            } finally {
                localObject =finally;
                throw ((Throwable) localObject);
            }
        }

        public void f() {
            try {
                if (u.b.b.equals(this.c)) {
                    a(u.b.e);
                    this.h = u.this.e(this.b);
                    l();
                }
                return;
            } finally {
                localObject =finally;
                throw ((Throwable) localObject);
            }
        }

        public void g() {
            for (; ; ) {
                FlurryAdSize localFlurryAdSize;
                try {
                    boolean bool = u.b.c.equals(this.c);
                    if (!bool) {
                        return;
                    }
                    ViewGroup localViewGroup1 = (ViewGroup) this.e.get();
                    localFlurryAdSize = this.f;
                    this.h = u.this.e(this.b);
                    if (this.h.isEmpty()) {
                        eo.a(6, u.d(), "An auction is required, but there is no ad unit!");
                        u();
                        continue;
                    }
                    a(u.b.d);
                } finally {
                }
                AdUnit localAdUnit = (AdUnit) this.h.get(0);
                long l1 = localAdUnit.o().longValue();
                if (l1 > 0L) {
                    eo.a(3, u.d(), "Setting CSRTB auction timeout for " + l1 + " ms");
                    this.m = (l1 + System.currentTimeMillis());
                }
                this.i = localAdUnit;
                u.a(u.this).e().a(this.b, localViewGroup2, localFlurryAdSize, false, localAdUnit);
            }
        }
    }

    static enum b {
        private b() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */