package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import com.flurry.android.impl.analytics.FlurryAnalyticsModule;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;

import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

public class dj
        implements dm.b, dq.a {
    static int a = 100;
    static int b = 10;
    static int c = 1000;
    static int d = 160000;
    static int e = 50;
    static int f = 20;
    private static final String g = dj.class.getSimpleName();
    private String A = "";
    private String B = "";
    private byte C = -1;
    private Location D;
    private boolean E;
    private String F;
    private byte G;
    private long H;
    private long I;
    private final Map<String, cx.a> J = new HashMap();
    private final List<db> K = new ArrayList();
    private boolean L;
    private int M;
    private final List<da> N = new ArrayList();
    private int O;
    private int P;
    private final cy Q = new cy();
    private Map<String, List<String>> R;
    private dm S;
    private int T;
    private boolean U = false;
    private final AtomicInteger h = new AtomicInteger(0);
    private final AtomicInteger i = new AtomicInteger(0);
    private final AtomicInteger j = new AtomicInteger(0);
    private final String k;
    private String l;
    private WeakReference<Context> m;
    private File n = null;
    private List<dh> o;
    private final Map<dr, ByteBuffer> p = new HashMap();
    private boolean q;
    private long r;
    private List<dh> s = new ArrayList();
    private AdvertisingIdClient.Info t;
    private byte[] u;
    private String v;
    private long w;
    private long x;
    private long y;
    private long z;

    public dj(String paramString) {
        eo.a(4, g, "Creating new Flurry session");
        this.k = paramString;
        this.m = new WeakReference(null);
    }

    private void A() {
        try {
            eo.a(3, g, "generating agent report");
            dc localdc = new dc(this.k, this.l, this.q, o(), this.r, this.w, this.s, p(), this.Q.a(false), a(), cx.a().b(), System.currentTimeMillis());
            this.o = new ArrayList(this.s);
            if ((localdc != null) && (localdc.a() != null)) {
                eo.a(3, g, "generated report of size " + localdc.a().length + " with " + this.s.size() + " reports.");
                a(localdc.a());
                this.s.removeAll(this.o);
                this.o = null;
                B();
                return;
            }
            eo.d(g, "Error generating report");
            return;
        } catch (Throwable localThrowable) {
            eo.a(6, g, "", localThrowable);
        }
    }

    /* Error */
    private void B() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 133	com/flurry/sdk/dj:n	Ljava/io/File;
        //   6: invokestatic 279	com/flurry/sdk/fd:a	(Ljava/io/File;)Z
        //   9: ifne +15 -> 24
        //   12: getstatic 102	com/flurry/sdk/dj:g	Ljava/lang/String;
        //   15: ldc_w 281
        //   18: invokestatic 269	com/flurry/sdk/eo:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   21: aload_0
        //   22: monitorexit
        //   23: return
        //   24: new 283	java/io/DataOutputStream
        //   27: dup
        //   28: new 285	java/io/FileOutputStream
        //   31: dup
        //   32: aload_0
        //   33: getfield 133	com/flurry/sdk/dj:n	Ljava/io/File;
        //   36: invokespecial 288	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   39: invokespecial 291	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   42: astore_1
        //   43: new 293	com/flurry/sdk/dk
        //   46: dup
        //   47: invokespecial 294	com/flurry/sdk/dk:<init>	()V
        //   50: astore_2
        //   51: aload_2
        //   52: aload_0
        //   53: getfield 190	com/flurry/sdk/dj:q	Z
        //   56: invokevirtual 297	com/flurry/sdk/dk:a	(Z)V
        //   59: aload_2
        //   60: aload_0
        //   61: getfield 195	com/flurry/sdk/dj:r	J
        //   64: invokevirtual 300	com/flurry/sdk/dk:a	(J)V
        //   67: aload_2
        //   68: aload_0
        //   69: getfield 143	com/flurry/sdk/dj:s	Ljava/util/List;
        //   72: invokevirtual 303	com/flurry/sdk/dk:a	(Ljava/util/List;)V
        //   75: aload_2
        //   76: aload_1
        //   77: aload_0
        //   78: getfield 173	com/flurry/sdk/dj:k	Ljava/lang/String;
        //   81: aload_0
        //   82: invokevirtual 305	com/flurry/sdk/dj:i	()Ljava/lang/String;
        //   85: invokevirtual 308	com/flurry/sdk/dk:a	(Ljava/io/DataOutputStream;Ljava/lang/String;Ljava/lang/String;)V
        //   88: goto -67 -> 21
        //   91: astore_1
        //   92: getstatic 102	com/flurry/sdk/dj:g	Ljava/lang/String;
        //   95: ldc_w 310
        //   98: aload_1
        //   99: invokestatic 313	com/flurry/sdk/eo:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   102: goto -81 -> 21
        //   105: astore_1
        //   106: aload_0
        //   107: monitorexit
        //   108: aload_1
        //   109: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	110	0	this	dj
        //   42	35	1	localDataOutputStream	java.io.DataOutputStream
        //   91	8	1	localException	Exception
        //   105	4	1	localObject	Object
        //   50	26	2	localdk	dk
        // Exception table:
        //   from	to	target	type
        //   24	88	91	java/lang/Exception
        //   2	21	105	finally
        //   24	88	105	finally
        //   92	102	105	finally
    }

    /* Error */
    private void C() {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: aload_0
        //   4: monitorenter
        //   5: iconst_4
        //   6: getstatic 102	com/flurry/sdk/dj:g	Ljava/lang/String;
        //   9: new 232	java/lang/StringBuilder
        //   12: dup
        //   13: invokespecial 233	java/lang/StringBuilder:<init>	()V
        //   16: ldc_w 315
        //   19: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   22: aload_0
        //   23: getfield 133	com/flurry/sdk/dj:n	Ljava/io/File;
        //   26: invokevirtual 320	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   29: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   32: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   35: invokestatic 171	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 133	com/flurry/sdk/dj:n	Ljava/io/File;
        //   42: invokevirtual 323	java/io/File:exists	()Z
        //   45: istore_3
        //   46: iload_3
        //   47: ifeq +184 -> 231
        //   50: new 325	java/io/FileInputStream
        //   53: dup
        //   54: aload_0
        //   55: getfield 133	com/flurry/sdk/dj:n	Ljava/io/File;
        //   58: invokespecial 326	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   61: astore 6
        //   63: new 328	java/io/DataInputStream
        //   66: dup
        //   67: aload 6
        //   69: invokespecial 331	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
        //   72: astore 5
        //   74: new 293	com/flurry/sdk/dk
        //   77: dup
        //   78: invokespecial 294	com/flurry/sdk/dk:<init>	()V
        //   81: astore 4
        //   83: aload 4
        //   85: aload 5
        //   87: aload_0
        //   88: getfield 173	com/flurry/sdk/dj:k	Ljava/lang/String;
        //   91: invokevirtual 334	com/flurry/sdk/dk:a	(Ljava/io/DataInputStream;Ljava/lang/String;)Z
        //   94: pop
        //   95: aload_0
        //   96: aload 4
        //   98: invokevirtual 336	com/flurry/sdk/dk:a	()Z
        //   101: putfield 190	com/flurry/sdk/dj:q	Z
        //   104: aload_0
        //   105: aload 4
        //   107: invokevirtual 338	com/flurry/sdk/dk:c	()J
        //   110: putfield 195	com/flurry/sdk/dj:r	J
        //   113: aload_0
        //   114: aload 4
        //   116: invokevirtual 341	com/flurry/sdk/dk:b	()Ljava/util/List;
        //   119: putfield 143	com/flurry/sdk/dj:s	Ljava/util/List;
        //   122: iconst_1
        //   123: istore_1
        //   124: aload 5
        //   126: invokestatic 346	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   129: aload 6
        //   131: invokestatic 346	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   134: iload_1
        //   135: istore_2
        //   136: iload_1
        //   137: ifne +23 -> 160
        //   140: iconst_3
        //   141: getstatic 102	com/flurry/sdk/dj:g	Ljava/lang/String;
        //   144: ldc_w 348
        //   147: invokestatic 171	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   150: aload_0
        //   151: getfield 133	com/flurry/sdk/dj:n	Ljava/io/File;
        //   154: invokevirtual 351	java/io/File:delete	()Z
        //   157: pop
        //   158: iload_1
        //   159: istore_2
        //   160: iload_2
        //   161: ifne +16 -> 177
        //   164: aload_0
        //   165: iconst_0
        //   166: putfield 190	com/flurry/sdk/dj:q	Z
        //   169: aload_0
        //   170: aload_0
        //   171: getfield 197	com/flurry/sdk/dj:w	J
        //   174: putfield 195	com/flurry/sdk/dj:r	J
        //   177: aload_0
        //   178: monitorexit
        //   179: return
        //   180: astore 6
        //   182: aconst_null
        //   183: astore 5
        //   185: getstatic 102	com/flurry/sdk/dj:g	Ljava/lang/String;
        //   188: ldc_w 353
        //   191: aload 6
        //   193: invokestatic 313	com/flurry/sdk/eo:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   196: aload 5
        //   198: invokestatic 346	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   201: aload 4
        //   203: invokestatic 346	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   206: iconst_0
        //   207: istore_1
        //   208: goto -74 -> 134
        //   211: aload 5
        //   213: invokestatic 346	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   216: aload 6
        //   218: invokestatic 346	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   221: aload 4
        //   223: athrow
        //   224: astore 4
        //   226: aload_0
        //   227: monitorexit
        //   228: aload 4
        //   230: athrow
        //   231: iconst_4
        //   232: getstatic 102	com/flurry/sdk/dj:g	Ljava/lang/String;
        //   235: ldc_w 355
        //   238: invokestatic 171	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   241: iconst_0
        //   242: istore_2
        //   243: goto -83 -> 160
        //   246: astore 4
        //   248: aconst_null
        //   249: astore 5
        //   251: goto -40 -> 211
        //   254: astore 4
        //   256: goto -45 -> 211
        //   259: astore 7
        //   261: aload 4
        //   263: astore 6
        //   265: aload 7
        //   267: astore 4
        //   269: goto -58 -> 211
        //   272: astore 7
        //   274: aconst_null
        //   275: astore 5
        //   277: aload 6
        //   279: astore 4
        //   281: aload 7
        //   283: astore 6
        //   285: goto -100 -> 185
        //   288: astore 7
        //   290: aload 6
        //   292: astore 4
        //   294: aload 7
        //   296: astore 6
        //   298: goto -113 -> 185
        //   301: astore 4
        //   303: aconst_null
        //   304: astore 5
        //   306: aconst_null
        //   307: astore 6
        //   309: goto -98 -> 211
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	312	0	this	dj
        //   123	85	1	i1	int
        //   135	108	2	i2	int
        //   45	2	3	bool	boolean
        //   1	221	4	localdk	dk
        //   224	5	4	localObject1	Object
        //   246	1	4	localObject2	Object
        //   254	8	4	localObject3	Object
        //   267	26	4	localObject4	Object
        //   301	1	4	localObject5	Object
        //   72	233	5	localDataInputStream	java.io.DataInputStream
        //   61	69	6	localFileInputStream	java.io.FileInputStream
        //   180	37	6	localException1	Exception
        //   263	45	6	localObject6	Object
        //   259	7	7	localObject7	Object
        //   272	10	7	localException2	Exception
        //   288	7	7	localException3	Exception
        // Exception table:
        //   from	to	target	type
        //   50	63	180	java/lang/Exception
        //   5	46	224	finally
        //   124	134	224	finally
        //   140	158	224	finally
        //   164	177	224	finally
        //   196	206	224	finally
        //   211	224	224	finally
        //   231	241	224	finally
        //   63	74	246	finally
        //   74	122	254	finally
        //   185	196	259	finally
        //   63	74	272	java/lang/Exception
        //   74	122	288	java/lang/Exception
        //   50	63	301	finally
    }

    private void D() {
        this.T += 1;
    }

    private void E() {
        if (this.T > 0) {
            this.T -= 1;
        }
    }

    private String F() {
        return ".flurryagent." + Integer.toString(this.k.hashCode(), 16);
    }

    private int G() {
        return this.h.incrementAndGet();
    }

    private int H() {
        return this.i.incrementAndGet();
    }

    private void a(long paramLong) {
        try {
            Iterator localIterator = this.K.iterator();
            while (localIterator.hasNext()) {
                db localdb = (db) localIterator.next();
                if ((localdb.a()) && (!localdb.b())) {
                    localdb.a(paramLong);
                }
            }
        } finally {
        }
    }

    private void a(dr paramdr, ByteBuffer paramByteBuffer) {
        synchronized (this.p) {
            this.p.put(paramdr, paramByteBuffer);
            return;
        }
    }

    private void a(byte[] paramArrayOfByte) {
        dd localdd = FlurryAnalyticsModule.getInstance().a();
        String str = "" + dn.a().b();
        localdd.b(paramArrayOfByte, this.k, str);
    }

    private Map<String, List<String>> d(Context paramContext) {
        Iterator localIterator = null;
        Object localObject = localIterator;
        if ((paramContext instanceof Activity)) {
            Bundle localBundle = ((Activity) paramContext).getIntent().getExtras();
            localObject = localIterator;
            if (localBundle != null) {
                eo.a(3, g, "Launch Options Bundle is present " + localBundle.toString());
                localObject = new HashMap();
                localIterator = localBundle.keySet().iterator();
                while (localIterator.hasNext()) {
                    String str = (String) localIterator.next();
                    if (str != null) {
                        paramContext = localBundle.get(str);
                        if (paramContext != null) {
                        }
                        for (paramContext = paramContext.toString(); ; paramContext = "null") {
                            ((Map) localObject).put(str, new ArrayList(Arrays.asList(new String[]{paramContext})));
                            eo.a(3, g, "Launch options Key: " + str + ". Its value: " + paramContext);
                            break;
                        }
                    }
                }
            }
        }
        return (Map<String, List<String>>) localObject;
    }

    private void u() {
        dq localdq = dp.a();
        this.G = ((Byte) localdq.a("Gender")).byteValue();
        localdq.a("Gender", this);
        eo.a(4, g, "initSettings, Gender = " + this.G);
        this.F = ((String) localdq.a("UserId"));
        localdq.a("UserId", this);
        eo.a(4, g, "initSettings, UserId = " + this.F);
        this.E = ((Boolean) localdq.a("LogEvents")).booleanValue();
        localdq.a("LogEvents", this);
        eo.a(4, g, "initSettings, LogEvents = " + this.E);
        this.H = ((Long) localdq.a("Age")).longValue();
        localdq.a("Age", this);
        eo.a(4, g, "initSettings, BirthDate = " + this.H);
        this.I = ((Long) localdq.a("ContinueSessionMillis")).longValue();
        localdq.a("ContinueSessionMillis", this);
        eo.a(4, g, "initSettings, ContinueSessionMillis = " + this.I);
    }

    private void v() {
        try {
            if (this.v != null) {
                eo.a(3, g, "Fetched phone id");
                a(dr.a, ByteBuffer.wrap(this.v.getBytes()));
            }
            if (this.u != null) {
                eo.a(3, g, "Fetched hashed IMEI");
                a(dr.b, ByteBuffer.wrap(this.u));
            }
            if (this.t != null) {
                eo.a(3, g, "Fetched advertising id");
                a(dr.c, ByteBuffer.wrap(this.t.getId().getBytes()));
            }
            A();
            return;
        } catch (Throwable localThrowable) {
            eo.a(6, g, "", localThrowable);
        }
    }

    private void w() {
        a(new ff() {
            public void a() {
                dh localdh = dj.this.d();
                dj.c(dj.this).clear();
                dj.c(dj.this).add(localdh);
                dj.d(dj.this);
            }
        });
    }

    private void x() {
        a(new ff() {
            public void a() {
                dj.e(dj.this);
            }
        });
    }

    /* Error */
    private void y() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 143	com/flurry/sdk/dj:s	Ljava/util/List;
        //   6: invokeinterface 250 1 0
        //   11: ifle +16 -> 27
        //   14: iconst_1
        //   15: istore_1
        //   16: aload_0
        //   17: monitorexit
        //   18: iload_1
        //   19: ifeq +7 -> 26
        //   22: aload_0
        //   23: invokespecial 577	com/flurry/sdk/dj:A	()V
        //   26: return
        //   27: iconst_0
        //   28: istore_1
        //   29: goto -13 -> 16
        //   32: astore_2
        //   33: aload_0
        //   34: monitorexit
        //   35: aload_2
        //   36: athrow
        //   37: astore_2
        //   38: bipush 6
        //   40: getstatic 102	com/flurry/sdk/dj:g	Ljava/lang/String;
        //   43: ldc -111
        //   45: aload_2
        //   46: invokestatic 272	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   49: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	50	0	this	dj
        //   15	14	1	i1	int
        //   32	4	2	localObject	Object
        //   37	9	2	localThrowable	Throwable
        // Exception table:
        //   from	to	target	type
        //   2	14	32	finally
        //   16	18	32	finally
        //   33	35	32	finally
        //   0	2	37	java/lang/Throwable
        //   22	26	37	java/lang/Throwable
        //   35	37	37	java/lang/Throwable
    }

    private void z() {
        a(new ff() {
            public void a() {
                dz.a().d();
            }
        });
    }

    Map<String, List<String>> a() {
        return this.R;
    }

    public void a(Context paramContext) {
        try {
            eo.a(4, g, "Initializing new Flurry session with context:" + paramContext);
            this.m = new WeakReference(paramContext);
            this.S = new dm(this);
            this.n = paramContext.getFileStreamPath(F());
            this.l = eb.a();
            this.y = -1L;
            this.O = 0;
            this.B = TimeZone.getDefault().getID();
            this.A = (Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry());
            this.L = true;
            this.M = 0;
            this.P = 0;
            this.R = d(paramContext);
            u();
            long l1 = SystemClock.elapsedRealtime();
            this.w = System.currentTimeMillis();
            this.x = l1;
            a(new ff() {
                public void a() {
                    dj.a(dj.this, dw.a());
                }
            });
            a(new ff() {
                public void a() {
                    dj.a(dj.this, dy.a());
                }
            });
            a(new ff() {
                public void a() {
                    dj.a(dj.this, ea.a());
                }
            });
            a(new ff() {
                public void a() {
                    dj.a(dj.this);
                }
            });
            a(new ff() {
                public void a() {
                    dj.b(dj.this);
                }
            });
            ep.a().a(this, paramContext);
            this.U = true;
            return;
        } finally {
            paramContext =finally;
            throw paramContext;
        }
    }

    public void a(ff paramff) {
        do.a().c(paramff);
    }

    public void a(String paramString, Object paramObject) {
        if (paramString.equals("Gender")) {
            this.G = ((Byte) paramObject).byteValue();
            eo.a(4, g, "onSettingUpdate, Gender = " + this.G);
            return;
        }
        if (paramString.equals("UserId")) {
            this.F = ((String) paramObject);
            eo.a(4, g, "onSettingUpdate, UserId = " + this.F);
            return;
        }
        if (paramString.equals("LogEvents")) {
            this.E = ((Boolean) paramObject).booleanValue();
            eo.a(4, g, "onSettingUpdate, LogEvents = " + this.E);
            return;
        }
        if (paramString.equals("Age")) {
            this.H = ((Long) paramObject).longValue();
            eo.a(4, g, "onSettingUpdate, Birthdate = " + this.H);
            return;
        }
        if (paramString.equals("ContinueSessionMillis")) {
            this.I = ((Long) paramObject).longValue();
            eo.a(4, g, "onSettingUpdate, ContinueSessionMillis = " + this.I);
            return;
        }
        eo.a(6, g, "onSettingUpdate internal error!");
    }

    public void a(String paramString1, String paramString2, String paramString3, Throwable paramThrowable) {
        if (paramString1 != null) {
        }
        for (; ; ) {
            try {
                long l1;
                if ("uncaught".equals(paramString1)) {
                    i1 = 1;
                    this.O += 1;
                    if (this.N.size() < e) {
                        l1 = System.currentTimeMillis();
                        paramString1 = new da(H(), Long.valueOf(l1).longValue(), paramString1, paramString2, paramString3, paramThrowable);
                        this.N.add(paramString1);
                        eo.d(g, "Error logged: " + paramString1.c());
                    }
                } else {
                    i1 = 0;
                    continue;
                }
                if (i1 == 0) {
                    break label243;
                }
                int i1 = 0;
                if (i1 >= this.N.size()) {
                    continue;
                }
                da localda = (da) this.N.get(i1);
                if ((localda.c() != null) && (!"uncaught".equals(localda.c()))) {
                    l1 = System.currentTimeMillis();
                    paramString1 = new da(H(), Long.valueOf(l1).longValue(), paramString1, paramString2, paramString3, paramThrowable);
                    this.N.set(i1, paramString1);
                    continue;
                }
                i1 += 1;
            } finally {
            }
            continue;
            label243:
            eo.d(g, "Max errors logged. No more errors logged.");
        }
    }

    public void a(String paramString, Map<String, String> paramMap) {
        for (; ; ) {
            try {
                Iterator localIterator = this.K.iterator();
                db localdb;
                int i1;
                if (localIterator.hasNext()) {
                    localdb = (db) localIterator.next();
                    if (!localdb.a(paramString)) {
                        continue;
                    }
                    long l1 = SystemClock.elapsedRealtime();
                    long l2 = this.x;
                    if ((paramMap != null) && (paramMap.size() > 0) && (this.M < d)) {
                        i1 = this.M - localdb.d();
                        paramString = new HashMap(localdb.c());
                        localdb.a(paramMap);
                        if (localdb.d() + i1 > d) {
                            break label210;
                        }
                        if (localdb.c().size() > b) {
                            eo.d(g, "MaxEventParams exceeded on endEvent: " + localdb.c().size());
                            localdb.b(paramString);
                        }
                    } else {
                        localdb.a(l1 - l2);
                    }
                } else {
                    return;
                }
                this.M = (i1 + localdb.d());
                continue;
                localdb.b(paramString);
            } finally {
            }
            label210:
            this.L = false;
            this.M = d;
            eo.d(g, "Event Log size exceeded. No more event details logged.");
        }
    }

    public void a(String paramString, Map<String, String> paramMap, boolean paramBoolean) {
        for (; ; ) {
            long l1;
            long l2;
            String str;
            int i1;
            try {
                l1 = SystemClock.elapsedRealtime();
                l2 = this.x;
                str = fe.a(paramString);
                i1 = str.length();
                if (i1 == 0) {
                    return;
                }
                paramString = (cx.a) this.J.get(str);
                if (paramString != null) {
                    break label242;
                }
                if (this.J.size() < a) {
                    paramString = new cx.a();
                    paramString.a = 1;
                    this.J.put(str, paramString);
                    eo.d(g, "Event count started: " + str);
                    if ((!this.E) || (this.K.size() >= c) || (this.M >= d)) {
                        break label373;
                    }
                    if (paramMap != null) {
                        break label381;
                    }
                    paramString = Collections.emptyMap();
                    if (paramString.size() <= b) {
                        break label282;
                    }
                    eo.d(g, "MaxEventParams exceeded: " + paramString.size());
                    continue;
                }
                eo.d(g, "Too many different events. Event not counted: " + str);
            } finally {
            }
            continue;
            label242:
            paramString.a += 1;
            eo.d(g, "Event count incremented: " + str);
            continue;
            label282:
            paramString = new db(G(), str, paramString, l1 - l2, paramBoolean);
            if (paramString.d() + this.M <= d) {
                this.K.add(paramString);
                i1 = this.M;
                this.M = (paramString.d() + i1);
            } else {
                this.M = d;
                this.L = false;
                eo.d(g, "Event Log size exceeded. No more event details logged.");
                continue;
                label373:
                this.L = false;
                continue;
                label381:
                paramString = paramMap;
            }
        }
    }

    public void b() {
        this.q = true;
    }

    /* Error */
    public void b(Context paramContext) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 164	com/flurry/sdk/dj:U	Z
        //   6: istore_2
        //   7: iload_2
        //   8: ifne +6 -> 14
        //   11: aload_0
        //   12: monitorexit
        //   13: return
        //   14: getstatic 102	com/flurry/sdk/dj:g	Ljava/lang/String;
        //   17: new 232	java/lang/StringBuilder
        //   20: dup
        //   21: invokespecial 233	java/lang/StringBuilder:<init>	()V
        //   24: ldc_w 781
        //   27: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   30: aload_1
        //   31: invokevirtual 593	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   34: ldc_w 783
        //   37: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   40: aload_0
        //   41: invokevirtual 785	com/flurry/sdk/dj:g	()I
        //   44: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   47: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   50: invokestatic 269	com/flurry/sdk/eo:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   53: aload_0
        //   54: new 175	java/lang/ref/WeakReference
        //   57: dup
        //   58: aload_1
        //   59: invokespecial 178	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
        //   62: putfield 180	com/flurry/sdk/dj:m	Ljava/lang/ref/WeakReference;
        //   65: aload_0
        //   66: getfield 600	com/flurry/sdk/dj:S	Lcom/flurry/sdk/dm;
        //   69: invokevirtual 786	com/flurry/sdk/dm:b	()Z
        //   72: ifeq +10 -> 82
        //   75: aload_0
        //   76: getfield 600	com/flurry/sdk/dj:S	Lcom/flurry/sdk/dm;
        //   79: invokevirtual 788	com/flurry/sdk/dm:a	()V
        //   82: aload_0
        //   83: invokespecial 790	com/flurry/sdk/dj:D	()V
        //   86: invokestatic 795	com/flurry/sdk/dz:a	()Lcom/flurry/sdk/dz;
        //   89: invokevirtual 797	com/flurry/sdk/dz:c	()V
        //   92: aload_0
        //   93: invokestatic 795	com/flurry/sdk/dz:a	()Lcom/flurry/sdk/dz;
        //   96: invokevirtual 800	com/flurry/sdk/dz:f	()Landroid/location/Location;
        //   99: putfield 802	com/flurry/sdk/dj:D	Landroid/location/Location;
        //   102: invokestatic 667	com/flurry/sdk/ep:a	()Lcom/flurry/sdk/ep;
        //   105: aload_0
        //   106: aload_1
        //   107: invokevirtual 804	com/flurry/sdk/ep:b	(Lcom/flurry/sdk/dj;Landroid/content/Context;)V
        //   110: goto -99 -> 11
        //   113: astore_1
        //   114: aload_0
        //   115: monitorexit
        //   116: aload_1
        //   117: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	118	0	this	dj
        //   0	118	1	paramContext	Context
        //   6	2	2	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   2	7	113	finally
        //   14	82	113	finally
        //   82	110	113	finally
    }

    /* Error */
    public void c() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 164	com/flurry/sdk/dj:U	Z
        //   6: istore_1
        //   7: iload_1
        //   8: ifne +6 -> 14
        //   11: aload_0
        //   12: monitorexit
        //   13: return
        //   14: getstatic 102	com/flurry/sdk/dj:g	Ljava/lang/String;
        //   17: ldc_w 806
        //   20: invokestatic 269	com/flurry/sdk/eo:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   23: aload_0
        //   24: getfield 600	com/flurry/sdk/dj:S	Lcom/flurry/sdk/dm;
        //   27: invokevirtual 786	com/flurry/sdk/dm:b	()Z
        //   30: ifeq +10 -> 40
        //   33: aload_0
        //   34: getfield 600	com/flurry/sdk/dj:S	Lcom/flurry/sdk/dm;
        //   37: invokevirtual 788	com/flurry/sdk/dm:a	()V
        //   40: aload_0
        //   41: invokevirtual 785	com/flurry/sdk/dj:g	()I
        //   44: ifeq +40 -> 84
        //   47: bipush 6
        //   49: getstatic 102	com/flurry/sdk/dj:g	Ljava/lang/String;
        //   52: new 232	java/lang/StringBuilder
        //   55: dup
        //   56: invokespecial 233	java/lang/StringBuilder:<init>	()V
        //   59: ldc_w 808
        //   62: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   65: aload_0
        //   66: invokevirtual 810	com/flurry/sdk/dj:j	()Ljava/lang/String;
        //   69: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   72: ldc_w 812
        //   75: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   78: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   81: invokestatic 171	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   84: aload_0
        //   85: iconst_0
        //   86: putfield 357	com/flurry/sdk/dj:T	I
        //   89: aload_0
        //   90: invokespecial 814	com/flurry/sdk/dj:x	()V
        //   93: invokestatic 667	com/flurry/sdk/ep:a	()Lcom/flurry/sdk/ep;
        //   96: aload_0
        //   97: invokevirtual 816	com/flurry/sdk/ep:a	(Lcom/flurry/sdk/dj;)V
        //   100: aload_0
        //   101: new 20	com/flurry/sdk/dj$6
        //   104: dup
        //   105: aload_0
        //   106: invokespecial 817	com/flurry/sdk/dj$6:<init>	(Lcom/flurry/sdk/dj;)V
        //   109: invokevirtual 582	com/flurry/sdk/dj:a	(Lcom/flurry/sdk/ff;)V
        //   112: invokestatic 485	com/flurry/sdk/dp:a	()Lcom/flurry/sdk/dq;
        //   115: ldc_w 487
        //   118: aload_0
        //   119: invokevirtual 820	com/flurry/sdk/dq:b	(Ljava/lang/String;Lcom/flurry/sdk/dq$a;)Z
        //   122: pop
        //   123: invokestatic 485	com/flurry/sdk/dp:a	()Lcom/flurry/sdk/dq;
        //   126: ldc_w 506
        //   129: aload_0
        //   130: invokevirtual 820	com/flurry/sdk/dq:b	(Ljava/lang/String;Lcom/flurry/sdk/dq$a;)Z
        //   133: pop
        //   134: invokestatic 485	com/flurry/sdk/dp:a	()Lcom/flurry/sdk/dq;
        //   137: ldc_w 526
        //   140: aload_0
        //   141: invokevirtual 820	com/flurry/sdk/dq:b	(Ljava/lang/String;Lcom/flurry/sdk/dq$a;)Z
        //   144: pop
        //   145: invokestatic 485	com/flurry/sdk/dp:a	()Lcom/flurry/sdk/dq;
        //   148: ldc_w 512
        //   151: aload_0
        //   152: invokevirtual 820	com/flurry/sdk/dq:b	(Ljava/lang/String;Lcom/flurry/sdk/dq$a;)Z
        //   155: pop
        //   156: invokestatic 485	com/flurry/sdk/dp:a	()Lcom/flurry/sdk/dq;
        //   159: ldc_w 540
        //   162: aload_0
        //   163: invokevirtual 820	com/flurry/sdk/dq:b	(Ljava/lang/String;Lcom/flurry/sdk/dq$a;)Z
        //   166: pop
        //   167: goto -156 -> 11
        //   170: astore_2
        //   171: aload_0
        //   172: monitorexit
        //   173: aload_2
        //   174: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	175	0	this	dj
        //   6	2	1	bool	boolean
        //   170	4	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	7	170	finally
        //   14	40	170	finally
        //   40	84	170	finally
        //   84	167	170	finally
    }

    /* Error */
    public void c(Context paramContext) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 164	com/flurry/sdk/dj:U	Z
        //   6: istore_2
        //   7: iload_2
        //   8: ifne +6 -> 14
        //   11: aload_0
        //   12: monitorexit
        //   13: return
        //   14: invokestatic 667	com/flurry/sdk/ep:a	()Lcom/flurry/sdk/ep;
        //   17: aload_0
        //   18: aload_1
        //   19: invokevirtual 822	com/flurry/sdk/ep:c	(Lcom/flurry/sdk/dj;Landroid/content/Context;)V
        //   22: aload_0
        //   23: invokestatic 795	com/flurry/sdk/dz:a	()Lcom/flurry/sdk/dz;
        //   26: invokevirtual 800	com/flurry/sdk/dz:f	()Landroid/location/Location;
        //   29: putfield 802	com/flurry/sdk/dj:D	Landroid/location/Location;
        //   32: aload_0
        //   33: invokespecial 824	com/flurry/sdk/dj:z	()V
        //   36: aload_0
        //   37: invokespecial 826	com/flurry/sdk/dj:E	()V
        //   40: getstatic 102	com/flurry/sdk/dj:g	Ljava/lang/String;
        //   43: new 232	java/lang/StringBuilder
        //   46: dup
        //   47: invokespecial 233	java/lang/StringBuilder:<init>	()V
        //   50: ldc_w 828
        //   53: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   56: aload_1
        //   57: invokevirtual 593	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   60: ldc_w 783
        //   63: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   66: aload_0
        //   67: invokevirtual 785	com/flurry/sdk/dj:g	()I
        //   70: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   73: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   76: invokestatic 269	com/flurry/sdk/eo:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   79: aload_0
        //   80: invokestatic 655	android/os/SystemClock:elapsedRealtime	()J
        //   83: aload_0
        //   84: getfield 657	com/flurry/sdk/dj:x	J
        //   87: lsub
        //   88: putfield 616	com/flurry/sdk/dj:y	J
        //   91: aload_0
        //   92: aload_0
        //   93: getfield 616	com/flurry/sdk/dj:y	J
        //   96: invokespecial 829	com/flurry/sdk/dj:a	(J)V
        //   99: aload_0
        //   100: invokespecial 831	com/flurry/sdk/dj:w	()V
        //   103: aload_0
        //   104: invokevirtual 785	com/flurry/sdk/dj:g	()I
        //   107: ifne -96 -> 11
        //   110: aload_0
        //   111: getfield 600	com/flurry/sdk/dj:S	Lcom/flurry/sdk/dm;
        //   114: aload_0
        //   115: getfield 542	com/flurry/sdk/dj:I	J
        //   118: invokevirtual 832	com/flurry/sdk/dm:a	(J)V
        //   121: goto -110 -> 11
        //   124: astore_1
        //   125: aload_0
        //   126: monitorexit
        //   127: aload_1
        //   128: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	129	0	this	dj
        //   0	129	1	paramContext	Context
        //   6	2	2	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   2	7	124	finally
        //   14	121	124	finally
    }

    /* Error */
    dh d() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: new 837	com/flurry/sdk/di
        //   5: dup
        //   6: invokespecial 838	com/flurry/sdk/di:<init>	()V
        //   9: astore_1
        //   10: aload_1
        //   11: aload_0
        //   12: getfield 188	com/flurry/sdk/dj:l	Ljava/lang/String;
        //   15: invokevirtual 840	com/flurry/sdk/di:a	(Ljava/lang/String;)V
        //   18: aload_1
        //   19: aload_0
        //   20: getfield 197	com/flurry/sdk/dj:w	J
        //   23: invokevirtual 841	com/flurry/sdk/di:a	(J)V
        //   26: aload_1
        //   27: aload_0
        //   28: getfield 616	com/flurry/sdk/dj:y	J
        //   31: invokevirtual 843	com/flurry/sdk/di:b	(J)V
        //   34: aload_1
        //   35: aload_0
        //   36: getfield 845	com/flurry/sdk/dj:z	J
        //   39: invokevirtual 847	com/flurry/sdk/di:c	(J)V
        //   42: aload_1
        //   43: aload_0
        //   44: invokevirtual 849	com/flurry/sdk/dj:k	()Ljava/lang/String;
        //   47: invokevirtual 851	com/flurry/sdk/di:b	(Ljava/lang/String;)V
        //   50: aload_1
        //   51: aload_0
        //   52: invokevirtual 853	com/flurry/sdk/dj:l	()Ljava/lang/String;
        //   55: invokevirtual 855	com/flurry/sdk/di:c	(Ljava/lang/String;)V
        //   58: aload_1
        //   59: aload_0
        //   60: getfield 151	com/flurry/sdk/dj:C	B
        //   63: invokevirtual 857	com/flurry/sdk/di:a	(I)V
        //   66: aload_1
        //   67: aload_0
        //   68: invokevirtual 859	com/flurry/sdk/dj:h	()Ljava/lang/String;
        //   71: invokevirtual 861	com/flurry/sdk/di:d	(Ljava/lang/String;)V
        //   74: aload_1
        //   75: aload_0
        //   76: getfield 802	com/flurry/sdk/dj:D	Landroid/location/Location;
        //   79: invokevirtual 864	com/flurry/sdk/di:a	(Landroid/location/Location;)V
        //   82: aload_1
        //   83: aload_0
        //   84: invokevirtual 866	com/flurry/sdk/dj:f	()I
        //   87: invokevirtual 868	com/flurry/sdk/di:b	(I)V
        //   90: aload_1
        //   91: aload_0
        //   92: getfield 499	com/flurry/sdk/dj:G	B
        //   95: invokevirtual 871	com/flurry/sdk/di:a	(B)V
        //   98: aload_1
        //   99: aload_0
        //   100: getfield 533	com/flurry/sdk/dj:H	J
        //   103: invokestatic 706	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   106: invokevirtual 874	com/flurry/sdk/di:a	(Ljava/lang/Long;)V
        //   109: aload_1
        //   110: aload_0
        //   111: invokevirtual 876	com/flurry/sdk/dj:t	()Ljava/util/Map;
        //   114: invokevirtual 877	com/flurry/sdk/di:a	(Ljava/util/Map;)V
        //   117: aload_1
        //   118: aload_0
        //   119: invokevirtual 879	com/flurry/sdk/dj:r	()Ljava/util/List;
        //   122: invokevirtual 880	com/flurry/sdk/di:a	(Ljava/util/List;)V
        //   125: aload_1
        //   126: aload_0
        //   127: getfield 642	com/flurry/sdk/dj:L	Z
        //   130: invokevirtual 881	com/flurry/sdk/di:a	(Z)V
        //   133: aload_1
        //   134: aload_0
        //   135: invokevirtual 883	com/flurry/sdk/dj:s	()Ljava/util/List;
        //   138: invokevirtual 885	com/flurry/sdk/di:b	(Ljava/util/List;)V
        //   141: aload_1
        //   142: aload_0
        //   143: getfield 618	com/flurry/sdk/dj:O	I
        //   146: invokevirtual 887	com/flurry/sdk/di:c	(I)V
        //   149: new 889	com/flurry/sdk/dh
        //   152: dup
        //   153: aload_1
        //   154: invokespecial 892	com/flurry/sdk/dh:<init>	(Lcom/flurry/sdk/di;)V
        //   157: astore_1
        //   158: aload_1
        //   159: ifnonnull +12 -> 171
        //   162: getstatic 102	com/flurry/sdk/dj:g	Ljava/lang/String;
        //   165: ldc_w 894
        //   168: invokestatic 269	com/flurry/sdk/eo:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   171: aload_0
        //   172: monitorexit
        //   173: aload_1
        //   174: areturn
        //   175: astore_1
        //   176: aload_1
        //   177: invokevirtual 897	java/io/IOException:printStackTrace	()V
        //   180: aconst_null
        //   181: astore_1
        //   182: goto -24 -> 158
        //   185: astore_1
        //   186: aload_0
        //   187: monitorexit
        //   188: aload_1
        //   189: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	190	0	this	dj
        //   9	165	1	localObject1	Object
        //   175	2	1	localIOException	java.io.IOException
        //   181	1	1	localObject2	Object
        //   185	4	1	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   149	158	175	java/io/IOException
        //   2	149	185	finally
        //   149	158	185	finally
        //   162	171	185	finally
        //   176	180	185	finally
    }

    public void e() {
        try {
            this.P += 1;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    int f() {
        return this.P;
    }

    int g() {
        return this.T;
    }

    String h() {
        if (this.F == null) {
            return "";
        }
        return this.F;
    }

    public String i() {
        return this.v;
    }

    public String j() {
        return this.k;
    }

    public String k() {
        return this.A;
    }

    public String l() {
        return this.B;
    }

    public long m() {
        return this.w;
    }

    public long n() {
        return this.x;
    }

    public boolean o() {
        return (this.t == null) || (!this.t.isLimitAdTrackingEnabled());
    }

    public Map<dr, ByteBuffer> p() {
        return new HashMap(this.p);
    }

    public void q() {
        c();
    }

    List<db> r() {
        return this.K;
    }

    List<da> s() {
        return this.N;
    }

    Map<String, cx.a> t() {
        return this.J;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */