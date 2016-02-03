package com.amazon.device.ads;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.json.JSONObject;

class cq {
    protected static cq a = new cq();
    private static final String b = cq.class.getSimpleName();
    private String c = null;
    private boolean d = false;
    private List<ct> e = null;
    private AtomicBoolean f = null;
    private Boolean g = null;
    private boolean h = false;
    private gp i = new gq();

    public static final cq a() {
        return a;
    }

    private void a(cs paramcs, JSONObject paramJSONObject) {
        if (paramcs.c().equals(String.class)) {
            paramJSONObject = paramJSONObject.getString(paramcs.b());
            if ((!paramcs.e()) && (hu.d(paramJSONObject))) {
                throw new IllegalArgumentException("The configuration value must not be empty or contain only white spaces.");
            }
            he.a().c(paramcs.a(), paramJSONObject);
            return;
        }
        if (paramcs.c().equals(Boolean.class)) {
            boolean bool = paramJSONObject.getBoolean(paramcs.b());
            he.a().c(paramcs.a(), bool);
            return;
        }
        throw new IllegalArgumentException("Undefined configuration option type.");
    }

    public static int b() {
        return cx.a("debug.noRetryTTLMax", 300000);
    }

    private boolean m() {
        he localhe = he.a();
        String str = localhe.a("config-appDefinedMarketplace", null);
        if (this.d) {
            this.d = false;
            if ((this.c != null) && (!this.c.equals(str))) {
                localhe.c("config-lastFetchTime", 0L);
                localhe.c("config-appDefinedMarketplace", this.c);
                localhe.c();
                dn.i().c().f();
                dv.b(b, "New application-defined marketplace set. A new configuration will be retrieved.");
                return true;
            }
            if ((str != null) && (this.c == null)) {
                localhe.b("config-appDefinedMarketplace");
                dn.i().c().f();
                dv.b(b, "Application-defined marketplace removed. A new configuration will be retrieved.");
                return true;
            }
        }
        return false;
    }

    private String n() {
        return this.i.a();
    }

    protected hy a(cd paramcd) {
        hy localhy = hy.d();
        localhy.h(b);
        localhy.a(true);
        localhy.b(cx.a("debug.aaxConfigHostname", "aax-us-east.amazon-adsystem.com"));
        localhy.c("/e/msdk/cfg");
        localhy.a(dy.a().b());
        localhy.a(eb.Q);
        localhy.e(cx.a("debug.aaxConfigUseSecure", true));
        gs localgs = dn.i().c();
        cz localcz = dn.i().b();
        localhy.a("appId", localgs.e());
        localhy.a("dinfo", localcz.v().toString());
        localhy.a("adId", paramcd.e());
        localhy.a("sdkVer", hv.b());
        localhy.a("fp", Boolean.toString(this.h));
        localhy.a("mkt", he.a().a("config-appDefinedMarketplace", null));
        localhy.a("pfm", n());
        boolean bool = he.a().a("testingEnabled", false);
        b(bool);
        if (bool) {
            localhy.a("testMode", "true");
        }
        localhy.g(cx.a("debug.aaxConfigParams", null));
        return localhy;
    }

    public String a(cs paramcs) {
        String str2 = cx.a(paramcs.d(), null);
        String str1 = str2;
        if (str2 == null) {
            str1 = he.a().a(paramcs.a(), null);
        }
        return str1;
    }

    public void a(ct paramct) {
        try {
            a(paramct, true);
            return;
        } finally {
            paramct =finally;
            throw paramct;
        }
    }

    public void a(ct paramct, boolean paramBoolean) {
        for (; ; ) {
            try {
                if (e()) {
                    this.e.add(paramct);
                    return;
                }
                if (c()) {
                    this.e.add(paramct);
                    if (paramBoolean) {
                        dv.b(b, "Starting configuration fetching...");
                        a(true);
                        f();
                    }
                } else {
                    paramct.c();
                }
            } finally {
            }
        }
    }

    protected void a(boolean paramBoolean) {
        this.f.set(paramBoolean);
    }

    public boolean a(cs paramcs, boolean paramBoolean) {
        if (cx.a(paramcs.d())) {
            return cx.a(paramcs.d(), paramBoolean);
        }
        return he.a().a(paramcs.a(), paramBoolean);
    }

    protected void b(boolean paramBoolean) {
        this.g = Boolean.valueOf(paramBoolean);
    }

    public boolean b(cs paramcs) {
        return a(paramcs, false);
    }

    protected boolean c() {
        he localhe = he.a();
        if (m()) {
        }
        do {
            do {
                return true;
            } while (he.a().a("configVersion", 0) != 1);
            long l1 = d();
            long l2 = localhe.a("config-lastFetchTime", 0L);
            long l3 = localhe.a("config-ttl", 172800);
            if (l2 == 0L) {
                dv.b(b, "No configuration found. A new configuration will be retrieved.");
                return true;
            }
            if (l1 - l2 > hu.b(l3)) {
                dv.b(b, "The configuration has expired. A new configuration will be retrieved.");
                return true;
            }
            if ((this.g != null) && (this.g.booleanValue() != localhe.a("testingEnabled", false))) {
                dv.b(b, "The testing mode has changed. A new configuration will be retrieved.");
                return true;
            }
        } while (cx.a("debug.shouldFetchConfig", false));
        return false;
    }

    protected long d() {
        return System.nanoTime();
    }

    protected boolean e() {
        return this.f.get();
    }

    protected void f() {
        ho.a(new cr(this));
    }

    protected void g() {
        int j = 0;
        try {
            a(false);
            ct[] arrayOfct = i();
            int k = arrayOfct.length;
            while (j < k) {
                arrayOfct[j].c();
                j += 1;
            }
            return;
        } finally {
        }
    }

    protected void h() {
        int j = 0;
        try {
            dy.a().b().a(eb.R);
            a(false);
            ct[] arrayOfct = i();
            int k = arrayOfct.length;
            while (j < k) {
                arrayOfct[j].d();
                j += 1;
            }
            return;
        } finally {
        }
    }

    protected ct[] i() {
        try {
            ct[] arrayOfct = new ct[this.e.size()];
            arrayOfct = (ct[]) this.e.toArray(arrayOfct);
            this.e.clear();
            return arrayOfct;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    protected cs[] j() {
        return cs.g;
    }

    /* Error */
    protected void k() {
        // Byte code:
        //   0: ldc_w 321
        //   3: istore_2
        //   4: getstatic 31	com/amazon/device/ads/cq:b	Ljava/lang/String;
        //   7: ldc_w 390
        //   10: invokestatic 164	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   13: invokestatic 395	com/amazon/device/ads/go:a	()Lcom/amazon/device/ads/go;
        //   16: invokestatic 149	com/amazon/device/ads/dn:i	()Lcom/amazon/device/ads/dl;
        //   19: invokeinterface 398 1 0
        //   24: getstatic 31	com/amazon/device/ads/cq:b	Ljava/lang/String;
        //   27: invokevirtual 401	com/amazon/device/ads/go:a	(Landroid/content/Context;Ljava/lang/String;)Z
        //   30: ifne +8 -> 38
        //   33: aload_0
        //   34: invokevirtual 403	com/amazon/device/ads/cq:h	()V
        //   37: return
        //   38: aload_0
        //   39: invokevirtual 407	com/amazon/device/ads/cq:l	()Lcom/amazon/device/ads/cd;
        //   42: astore 4
        //   44: aload 4
        //   46: invokevirtual 409	com/amazon/device/ads/cd:a	()Z
        //   49: ifne +8 -> 57
        //   52: aload_0
        //   53: invokevirtual 403	com/amazon/device/ads/cq:h	()V
        //   56: return
        //   57: aload_0
        //   58: aload 4
        //   60: invokevirtual 411	com/amazon/device/ads/cq:a	(Lcom/amazon/device/ads/cd;)Lcom/amazon/device/ads/hy;
        //   63: astore 4
        //   65: aload 4
        //   67: invokevirtual 414	com/amazon/device/ads/hy:e	()Lcom/amazon/device/ads/if;
        //   70: astore 4
        //   72: getstatic 31	com/amazon/device/ads/cq:b	Ljava/lang/String;
        //   75: ldc_w 416
        //   78: iconst_1
        //   79: anewarray 4	java/lang/Object
        //   82: dup
        //   83: iconst_0
        //   84: aload 4
        //   86: invokevirtual 419	com/amazon/device/ads/if:a	()Ljava/lang/String;
        //   89: aastore
        //   90: invokestatic 422	com/amazon/device/ads/dv:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   93: aload 4
        //   95: invokevirtual 424	com/amazon/device/ads/if:b	()Lorg/json/JSONObject;
        //   98: astore 4
        //   100: invokestatic 106	com/amazon/device/ads/he:a	()Lcom/amazon/device/ads/he;
        //   103: astore 5
        //   105: aload_0
        //   106: invokevirtual 426	com/amazon/device/ads/cq:j	()[Lcom/amazon/device/ads/cs;
        //   109: astore 6
        //   111: aload 6
        //   113: arraylength
        //   114: istore_3
        //   115: iconst_0
        //   116: istore_1
        //   117: iload_1
        //   118: iload_3
        //   119: if_icmpge +128 -> 247
        //   122: aload 6
        //   124: iload_1
        //   125: aaload
        //   126: astore 7
        //   128: aload 4
        //   130: aload 7
        //   132: invokevirtual 80	com/amazon/device/ads/cs:b	()Ljava/lang/String;
        //   135: invokevirtual 429	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   138: ifeq +70 -> 208
        //   141: aload 7
        //   143: invokevirtual 89	com/amazon/device/ads/cs:e	()Z
        //   146: ifne +49 -> 195
        //   149: new 388	java/lang/Exception
        //   152: dup
        //   153: ldc_w 431
        //   156: invokespecial 432	java/lang/Exception:<init>	(Ljava/lang/String;)V
        //   159: athrow
        //   160: astore 4
        //   162: getstatic 31	com/amazon/device/ads/cq:b	Ljava/lang/String;
        //   165: ldc_w 434
        //   168: iconst_1
        //   169: anewarray 4	java/lang/Object
        //   172: dup
        //   173: iconst_0
        //   174: aload 4
        //   176: invokevirtual 437	org/json/JSONException:getMessage	()Ljava/lang/String;
        //   179: aastore
        //   180: invokestatic 439	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   183: aload_0
        //   184: invokevirtual 403	com/amazon/device/ads/cq:h	()V
        //   187: return
        //   188: astore 4
        //   190: aload_0
        //   191: invokevirtual 403	com/amazon/device/ads/cq:h	()V
        //   194: return
        //   195: aload 5
        //   197: aload 7
        //   199: invokevirtual 108	com/amazon/device/ads/cs:a	()Ljava/lang/String;
        //   202: invokevirtual 440	com/amazon/device/ads/he:c	(Ljava/lang/String;)V
        //   205: goto +133 -> 338
        //   208: aload_0
        //   209: aload 7
        //   211: aload 4
        //   213: invokespecial 442	com/amazon/device/ads/cq:a	(Lcom/amazon/device/ads/cs;Lorg/json/JSONObject;)V
        //   216: goto +122 -> 338
        //   219: astore 4
        //   221: getstatic 31	com/amazon/device/ads/cq:b	Ljava/lang/String;
        //   224: ldc_w 444
        //   227: iconst_1
        //   228: anewarray 4	java/lang/Object
        //   231: dup
        //   232: iconst_0
        //   233: aload 4
        //   235: invokevirtual 445	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   238: aastore
        //   239: invokestatic 439	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   242: aload_0
        //   243: invokevirtual 403	com/amazon/device/ads/cq:h	()V
        //   246: return
        //   247: aload 4
        //   249: ldc_w 447
        //   252: invokevirtual 429	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   255: ifeq +14 -> 269
        //   258: new 388	java/lang/Exception
        //   261: dup
        //   262: ldc_w 431
        //   265: invokespecial 432	java/lang/Exception:<init>	(Ljava/lang/String;)V
        //   268: athrow
        //   269: aload 4
        //   271: ldc_w 447
        //   274: invokevirtual 451	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   277: istore_1
        //   278: iload_1
        //   279: ldc_w 321
        //   282: if_icmple +53 -> 335
        //   285: iload_2
        //   286: istore_1
        //   287: aload 5
        //   289: ldc_w 320
        //   292: iload_1
        //   293: invokevirtual 454	com/amazon/device/ads/he:c	(Ljava/lang/String;I)V
        //   296: aload 5
        //   298: ldc -117
        //   300: aload_0
        //   301: invokevirtual 315	com/amazon/device/ads/cq:d	()J
        //   304: invokevirtual 142	com/amazon/device/ads/he:c	(Ljava/lang/String;J)V
        //   307: aload 5
        //   309: ldc_w 311
        //   312: iconst_1
        //   313: invokevirtual 454	com/amazon/device/ads/he:c	(Ljava/lang/String;I)V
        //   316: aload 5
        //   318: invokevirtual 144	com/amazon/device/ads/he:c	()V
        //   321: getstatic 31	com/amazon/device/ads/cq:b	Ljava/lang/String;
        //   324: ldc_w 456
        //   327: invokestatic 164	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   330: aload_0
        //   331: invokevirtual 458	com/amazon/device/ads/cq:g	()V
        //   334: return
        //   335: goto -48 -> 287
        //   338: iload_1
        //   339: iconst_1
        //   340: iadd
        //   341: istore_1
        //   342: goto -225 -> 117
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	345	0	this	cq
        //   116	226	1	j	int
        //   3	283	2	k	int
        //   114	6	3	m	int
        //   42	87	4	localObject	Object
        //   160	15	4	localJSONException	org.json.JSONException
        //   188	24	4	localic	ic
        //   219	51	4	localException	Exception
        //   103	214	5	localhe	he
        //   109	14	6	arrayOfcs	cs[]
        //   126	84	7	localcs	cs
        // Exception table:
        //   from	to	target	type
        //   105	115	160	org/json/JSONException
        //   128	160	160	org/json/JSONException
        //   195	205	160	org/json/JSONException
        //   208	216	160	org/json/JSONException
        //   247	269	160	org/json/JSONException
        //   269	278	160	org/json/JSONException
        //   65	72	188	com/amazon/device/ads/ic
        //   105	115	219	java/lang/Exception
        //   128	160	219	java/lang/Exception
        //   195	205	219	java/lang/Exception
        //   208	216	219	java/lang/Exception
        //   247	269	219	java/lang/Exception
        //   269	278	219	java/lang/Exception
    }

    cd l() {
        boolean bool = false;
        cc localcc = new cc();
        if (he.a().a("configVersion", 0) != 0) {
            bool = true;
        }
        return localcc.a(bool).b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */