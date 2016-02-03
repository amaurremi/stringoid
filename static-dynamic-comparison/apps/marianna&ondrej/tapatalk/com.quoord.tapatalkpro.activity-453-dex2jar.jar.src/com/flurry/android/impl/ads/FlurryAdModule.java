package com.flurry.android.impl.ads;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryAgent;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.android.ICustomAdNetworkHandler;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdReportedId;
import com.flurry.android.impl.ads.avro.protocol.v10.AdReportedId.Builder;
import com.flurry.android.impl.ads.avro.protocol.v10.AdSpaceLayout;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.avro.protocol.v10.Callback;
import com.flurry.android.impl.ads.avro.protocol.v10.FrequencyCapInfo;
import com.flurry.android.impl.ads.avro.protocol.v10.FrequencyCapInfo.Builder;
import com.flurry.android.impl.ads.avro.protocol.v10.Location.Builder;
import com.flurry.android.impl.ads.avro.protocol.v10.SdkLogRequest;
import com.flurry.android.impl.ads.avro.protocol.v10.SdkLogRequest.Builder;
import com.flurry.sdk.a;
import com.flurry.sdk.ac;
import com.flurry.sdk.ad;
import com.flurry.sdk.ae;
import com.flurry.sdk.ah;
import com.flurry.sdk.ai;
import com.flurry.sdk.ak;
import com.flurry.sdk.am;
import com.flurry.sdk.ap;
import com.flurry.sdk.c;
import com.flurry.sdk.cd;
import com.flurry.sdk.cg;
import com.flurry.sdk.ci;
import com.flurry.sdk.co;
import com.flurry.sdk.cp;
import com.flurry.sdk.cx;
import com.flurry.sdk.dj;
import com.flurry.sdk.dl;
import com.flurry.sdk.dn;
import com.flurry.sdk.do;
import com.flurry.sdk.dr;
import com.flurry.sdk.du;
import com.flurry.sdk.du.a;
import com.flurry.sdk.dv;
import com.flurry.sdk.dz;
import com.flurry.sdk.e;
import com.flurry.sdk.eo;
import com.flurry.sdk.et;
import com.flurry.sdk.ev;
import com.flurry.sdk.ev.a;
import com.flurry.sdk.fe;
import com.flurry.sdk.ff;
import com.flurry.sdk.g;
import com.flurry.sdk.j;
import com.flurry.sdk.k;
import com.flurry.sdk.l;
import com.flurry.sdk.n.e;
import com.flurry.sdk.o;
import com.flurry.sdk.p;
import com.flurry.sdk.q;
import com.flurry.sdk.r;
import com.flurry.sdk.s;
import com.flurry.sdk.t;
import com.flurry.sdk.u;
import com.flurry.sdk.x;
import com.flurry.sdk.y;

import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class FlurryAdModule
        implements ae, du, et {
    private static FlurryAdModule L;
    private static List<Integer> p;
    private static final String q = FlurryAdModule.class.getSimpleName();
    private AdUnit A;
    private e B;
    private AdUnit C;
    private final k D;
    private final ak E;
    private WeakReference<FlurryAdListener> F = new WeakReference(null);
    private CharSequence G;
    private final List<Activity> H;
    private final List<e> I = new ArrayList();
    private final Map<String, String> J;
    private final Set<String> K;
    private boolean M;
    private ac N;
    private s O;
    private r P;
    private u Q = new u(this);
    private t R = new t(this);
    volatile Map<String, String> a;
    volatile TreeMap<String, Integer> b;
    long c;
    long d;
    long e;
    y f = y.a();
    ap g = ap.a();
    public ICustomAdNetworkHandler h;
    int i;
    volatile Map<String, e> j = new HashMap();
    volatile Map<String, ci> k = new HashMap();
    volatile Map<String, am> l = new HashMap();
    volatile List<String> m = new ArrayList();
    volatile boolean n = false;
    Map<String, String> o;
    private File r = null;
    private File s = null;
    private File t = null;
    private String u;
    private String v;
    private String w;
    private volatile String x = null;
    private volatile String y = null;
    private e z;

    public FlurryAdModule() {
        Object localObject = new HashMap();
        ((Map) localObject).put("playVideo", "directOpen");
        ((Map) localObject).put("open", "directOpen");
        ((Map) localObject).put("expand", "doExpand");
        ((Map) localObject).put("collapse", "doCollapse");
        this.J = Collections.unmodifiableMap((Map) localObject);
        localObject = new HashSet();
        ((Set) localObject).addAll(Arrays.asList(new String[]{"notifyUser", "nextFrame", "closeAd", "expandAd", "collapseAd", "verifyURL"}));
        this.K = Collections.unmodifiableSet((Set) localObject);
        this.P = new r(this);
        p = Arrays.asList(new Integer[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5)});
        this.u = Build.VERSION.RELEASE;
        this.v = Build.DEVICE;
        this.a = new HashMap();
        this.D = new o();
        this.E = new p();
        this.H = new ArrayList();
        this.b = new TreeMap();
    }

    private SdkLogRequest a(List<e> paramList) {
        paramList = cd.a(paramList);
        if (paramList.isEmpty()) {
            eo.a(3, q, "List of adLogs is empty");
            return null;
        }
        String str = j();
        if (TextUtils.isEmpty(str)) {
            eo.a(3, q, "ApiKey is null.");
            return null;
        }
        List localList = E();
        paramList = SdkLogRequest.b().a(str).a(localList).b(paramList).a(false).a(System.currentTimeMillis()).b(Integer.toString(dn.a().b())).a();
        eo.a(3, q, "Got ad log request:" + paramList.toString());
        return paramList;
    }

    private void ad() {
        try {
            SdkLogRequest localSdkLogRequest = a(this.I);
            this.I.clear();
            this.O.a(localSdkLogRequest, D(), j(), "" + dn.a().b());
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    /* Error */
    private void ae() {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: aconst_null
        //   4: astore_2
        //   5: aload_0
        //   6: monitorenter
        //   7: iconst_4
        //   8: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   11: ldc_w 434
        //   14: invokestatic 336	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   17: aload_0
        //   18: getfield 149	com/flurry/android/impl/ads/FlurryAdModule:r	Ljava/io/File;
        //   21: invokestatic 439	com/flurry/sdk/fd:a	(Ljava/io/File;)Z
        //   24: istore_1
        //   25: iload_1
        //   26: ifne +14 -> 40
        //   29: aconst_null
        //   30: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   33: aconst_null
        //   34: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   37: aload_0
        //   38: monitorexit
        //   39: return
        //   40: new 446	java/io/FileOutputStream
        //   43: dup
        //   44: aload_0
        //   45: getfield 149	com/flurry/android/impl/ads/FlurryAdModule:r	Ljava/io/File;
        //   48: invokespecial 449	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   51: astore_3
        //   52: new 451	java/io/DataOutputStream
        //   55: dup
        //   56: aload_3
        //   57: invokespecial 454	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   60: astore_2
        //   61: aload_0
        //   62: getfield 195	com/flurry/android/impl/ads/FlurryAdModule:I	Ljava/util/List;
        //   65: aload_2
        //   66: invokestatic 459	com/flurry/sdk/d:a	(Ljava/util/List;Ljava/io/DataOutput;)V
        //   69: aload_2
        //   70: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   73: aload_3
        //   74: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   77: goto -40 -> 37
        //   80: astore_2
        //   81: aload_0
        //   82: monitorexit
        //   83: aload_2
        //   84: athrow
        //   85: astore 4
        //   87: aconst_null
        //   88: astore 5
        //   90: aload_2
        //   91: astore_3
        //   92: aload 5
        //   94: astore_2
        //   95: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   98: ldc_w 461
        //   101: aload 4
        //   103: invokestatic 464	com/flurry/sdk/eo:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   106: aload_2
        //   107: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   110: aload_3
        //   111: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   114: goto -77 -> 37
        //   117: aload 4
        //   119: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   122: aload_3
        //   123: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   126: aload_2
        //   127: athrow
        //   128: astore_2
        //   129: goto -12 -> 117
        //   132: astore 5
        //   134: aload_2
        //   135: astore 4
        //   137: aload 5
        //   139: astore_2
        //   140: goto -23 -> 117
        //   143: astore 5
        //   145: aload_2
        //   146: astore 4
        //   148: aload 5
        //   150: astore_2
        //   151: goto -34 -> 117
        //   154: astore 4
        //   156: aconst_null
        //   157: astore_2
        //   158: goto -63 -> 95
        //   161: astore 4
        //   163: goto -68 -> 95
        //   166: astore_2
        //   167: aconst_null
        //   168: astore_3
        //   169: goto -52 -> 117
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	172	0	this	FlurryAdModule
        //   24	2	1	bool	boolean
        //   4	66	2	localDataOutputStream	java.io.DataOutputStream
        //   80	11	2	localObject1	Object
        //   94	33	2	localObject2	Object
        //   128	7	2	localObject3	Object
        //   139	19	2	localObject4	Object
        //   166	1	2	localObject5	Object
        //   51	118	3	localObject6	Object
        //   1	1	4	localObject7	Object
        //   85	33	4	localException1	Exception
        //   135	12	4	localObject8	Object
        //   154	1	4	localException2	Exception
        //   161	1	4	localException3	Exception
        //   88	5	5	localObject9	Object
        //   132	6	5	localObject10	Object
        //   143	6	5	localObject11	Object
        // Exception table:
        //   from	to	target	type
        //   7	17	80	finally
        //   29	37	80	finally
        //   69	77	80	finally
        //   106	114	80	finally
        //   117	128	80	finally
        //   17	25	85	java/lang/Exception
        //   40	52	85	java/lang/Exception
        //   52	61	128	finally
        //   61	69	132	finally
        //   95	106	143	finally
        //   52	61	154	java/lang/Exception
        //   61	69	161	java/lang/Exception
        //   17	25	166	finally
        //   40	52	166	finally
    }

    /* Error */
    private void af() {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: aconst_null
        //   4: astore 4
        //   6: aload_0
        //   7: monitorenter
        //   8: iconst_4
        //   9: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   12: ldc_w 466
        //   15: invokestatic 336	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   18: aload_0
        //   19: getfield 149	com/flurry/android/impl/ads/FlurryAdModule:r	Ljava/io/File;
        //   22: invokevirtual 471	java/io/File:exists	()Z
        //   25: istore_2
        //   26: iload_2
        //   27: ifeq +130 -> 157
        //   30: new 473	java/io/FileInputStream
        //   33: dup
        //   34: aload_0
        //   35: getfield 149	com/flurry/android/impl/ads/FlurryAdModule:r	Ljava/io/File;
        //   38: invokespecial 474	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   41: astore_3
        //   42: new 476	java/io/DataInputStream
        //   45: dup
        //   46: aload_3
        //   47: invokespecial 479	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
        //   50: astore 4
        //   52: aload_0
        //   53: getfield 195	com/flurry/android/impl/ads/FlurryAdModule:I	Ljava/util/List;
        //   56: aload 4
        //   58: invokestatic 482	com/flurry/sdk/d:a	(Ljava/io/DataInput;)Ljava/util/List;
        //   61: invokeinterface 483 2 0
        //   66: pop
        //   67: iconst_1
        //   68: istore_1
        //   69: aload 4
        //   71: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   74: aload_3
        //   75: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   78: iload_1
        //   79: ifne +21 -> 100
        //   82: iconst_3
        //   83: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   86: ldc_w 485
        //   89: invokestatic 336	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   92: aload_0
        //   93: getfield 149	com/flurry/android/impl/ads/FlurryAdModule:r	Ljava/io/File;
        //   96: invokevirtual 488	java/io/File:delete	()Z
        //   99: pop
        //   100: aload_0
        //   101: monitorexit
        //   102: return
        //   103: astore_3
        //   104: aconst_null
        //   105: astore 6
        //   107: aload 4
        //   109: astore 5
        //   111: aload 6
        //   113: astore 4
        //   115: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   118: ldc_w 490
        //   121: aload_3
        //   122: invokestatic 464	com/flurry/sdk/eo:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   125: aload 4
        //   127: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   130: aload 5
        //   132: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   135: iconst_0
        //   136: istore_1
        //   137: goto -59 -> 78
        //   140: aload 4
        //   142: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   145: aload 5
        //   147: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   150: aload_3
        //   151: athrow
        //   152: astore_3
        //   153: aload_0
        //   154: monitorexit
        //   155: aload_3
        //   156: athrow
        //   157: iconst_3
        //   158: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   161: ldc_w 492
        //   164: invokestatic 336	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   167: goto -67 -> 100
        //   170: astore 6
        //   172: aconst_null
        //   173: astore 4
        //   175: aload_3
        //   176: astore 5
        //   178: aload 6
        //   180: astore_3
        //   181: goto -41 -> 140
        //   184: astore 6
        //   186: aload_3
        //   187: astore 5
        //   189: aload 6
        //   191: astore_3
        //   192: goto -52 -> 140
        //   195: astore_3
        //   196: goto -56 -> 140
        //   199: astore 6
        //   201: aconst_null
        //   202: astore 4
        //   204: aload_3
        //   205: astore 5
        //   207: aload 6
        //   209: astore_3
        //   210: goto -95 -> 115
        //   213: astore 6
        //   215: aload_3
        //   216: astore 5
        //   218: aload 6
        //   220: astore_3
        //   221: goto -106 -> 115
        //   224: astore_3
        //   225: aconst_null
        //   226: astore 4
        //   228: goto -88 -> 140
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	231	0	this	FlurryAdModule
        //   68	69	1	i1	int
        //   25	2	2	bool	boolean
        //   41	34	3	localFileInputStream	java.io.FileInputStream
        //   103	48	3	localException1	Exception
        //   152	24	3	localObject1	Object
        //   180	12	3	localObject2	Object
        //   195	10	3	localObject3	Object
        //   209	12	3	localObject4	Object
        //   224	1	3	localObject5	Object
        //   4	223	4	localObject6	Object
        //   1	216	5	localObject7	Object
        //   105	7	6	localObject8	Object
        //   170	9	6	localObject9	Object
        //   184	6	6	localObject10	Object
        //   199	9	6	localException2	Exception
        //   213	6	6	localException3	Exception
        // Exception table:
        //   from	to	target	type
        //   30	42	103	java/lang/Exception
        //   8	26	152	finally
        //   69	78	152	finally
        //   82	100	152	finally
        //   125	135	152	finally
        //   140	152	152	finally
        //   157	167	152	finally
        //   42	52	170	finally
        //   52	67	184	finally
        //   115	125	195	finally
        //   42	52	199	java/lang/Exception
        //   52	67	213	java/lang/Exception
        //   30	42	224	finally
    }

    public static FlurryAdModule getInstance() {
        try {
            if (L == null) {
                L = new FlurryAdModule();
            }
            FlurryAdModule localFlurryAdModule = L;
            return localFlurryAdModule;
        } finally {
        }
    }

    public static boolean i() {
        return ((KeyguardManager) do.a().b().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    public void A() {
        this.o = null;
    }

    public Map<String, String> B() {
        Map localMap = z();
        if (this.N != null) {
            String str = this.N.a();
            if (!TextUtils.isEmpty(str)) {
                localMap.put("appCloudUserId", str);
            }
        }
        return localMap;
    }

    public void C() {
        try {
            b(new ff() {
                public void a() {
                    FlurryAdModule.e(FlurryAdModule.this);
                }
            });
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public String D() {
        return x() + "/v2/postAdLog.do";
    }

    public List<AdReportedId> E() {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = dn.a().l().entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            localArrayList.add(AdReportedId.b().a((ByteBuffer) localEntry.getValue()).a(((dr) localEntry.getKey()).d).a());
        }
        return localArrayList;
    }

    public List<FrequencyCapInfo> F() {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.f.c().iterator();
        while (localIterator.hasNext()) {
            x localx = (x) localIterator.next();
            localArrayList.add(FrequencyCapInfo.b().a(localx.b()).b(localx.h()).b(localx.e()).c(localx.f()).d(localx.g()).a(localx.i()).a(localx.c()).a());
        }
        return localArrayList;
    }

    /* Error */
    public void G() {
        // Byte code:
        //   0: aconst_null
        //   1: astore_2
        //   2: aload_0
        //   3: monitorenter
        //   4: iconst_4
        //   5: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   8: ldc_w 649
        //   11: invokestatic 336	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 171	com/flurry/android/impl/ads/FlurryAdModule:f	Lcom/flurry/sdk/y;
        //   18: invokevirtual 651	com/flurry/sdk/y:d	()V
        //   21: aload_0
        //   22: getfield 151	com/flurry/android/impl/ads/FlurryAdModule:s	Ljava/io/File;
        //   25: invokestatic 439	com/flurry/sdk/fd:a	(Ljava/io/File;)Z
        //   28: istore_1
        //   29: iload_1
        //   30: ifne +14 -> 44
        //   33: aconst_null
        //   34: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   37: aconst_null
        //   38: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   41: aload_0
        //   42: monitorexit
        //   43: return
        //   44: new 446	java/io/FileOutputStream
        //   47: dup
        //   48: aload_0
        //   49: getfield 151	com/flurry/android/impl/ads/FlurryAdModule:s	Ljava/io/File;
        //   52: invokespecial 449	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   55: astore 4
        //   57: new 451	java/io/DataOutputStream
        //   60: dup
        //   61: aload 4
        //   63: invokespecial 454	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   66: astore_3
        //   67: aload_0
        //   68: getfield 171	com/flurry/android/impl/ads/FlurryAdModule:f	Lcom/flurry/sdk/y;
        //   71: invokevirtual 602	com/flurry/sdk/y:c	()Ljava/util/List;
        //   74: invokeinterface 603 1 0
        //   79: astore_2
        //   80: aload_2
        //   81: invokeinterface 561 1 0
        //   86: ifeq +64 -> 150
        //   89: aload_2
        //   90: invokeinterface 565 1 0
        //   95: checkcast 605	com/flurry/sdk/x
        //   98: astore 5
        //   100: aload_3
        //   101: iconst_1
        //   102: invokevirtual 655	java/io/DataOutputStream:writeShort	(I)V
        //   105: aload 5
        //   107: aload_3
        //   108: invokevirtual 658	com/flurry/sdk/x:a	(Ljava/io/DataOutput;)V
        //   111: goto -31 -> 80
        //   114: astore 5
        //   116: aload 4
        //   118: astore_2
        //   119: aload 5
        //   121: astore 4
        //   123: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   126: ldc_w 660
        //   129: aload 4
        //   131: invokestatic 464	com/flurry/sdk/eo:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   134: aload_3
        //   135: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   138: aload_2
        //   139: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   142: goto -101 -> 41
        //   145: astore_2
        //   146: aload_0
        //   147: monitorexit
        //   148: aload_2
        //   149: athrow
        //   150: aload_3
        //   151: iconst_0
        //   152: invokevirtual 655	java/io/DataOutputStream:writeShort	(I)V
        //   155: aload_3
        //   156: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   159: aload 4
        //   161: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   164: goto -123 -> 41
        //   167: aload_3
        //   168: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   171: aload 4
        //   173: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   176: aload_2
        //   177: athrow
        //   178: astore_2
        //   179: aconst_null
        //   180: astore_3
        //   181: goto -14 -> 167
        //   184: astore_2
        //   185: goto -18 -> 167
        //   188: astore 5
        //   190: aload_2
        //   191: astore 4
        //   193: aload 5
        //   195: astore_2
        //   196: goto -29 -> 167
        //   199: astore 4
        //   201: aconst_null
        //   202: astore_3
        //   203: goto -80 -> 123
        //   206: astore 5
        //   208: aconst_null
        //   209: astore_3
        //   210: aload 4
        //   212: astore_2
        //   213: aload 5
        //   215: astore 4
        //   217: goto -94 -> 123
        //   220: astore_2
        //   221: aconst_null
        //   222: astore_3
        //   223: aconst_null
        //   224: astore 4
        //   226: goto -59 -> 167
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	229	0	this	FlurryAdModule
        //   28	2	1	bool	boolean
        //   1	138	2	localObject1	Object
        //   145	32	2	localObject2	Object
        //   178	1	2	localObject3	Object
        //   184	7	2	localObject4	Object
        //   195	18	2	localObject5	Object
        //   220	1	2	localObject6	Object
        //   66	157	3	localDataOutputStream	java.io.DataOutputStream
        //   55	137	4	localObject7	Object
        //   199	12	4	localException1	Exception
        //   215	10	4	localObject8	Object
        //   98	8	5	localx	x
        //   114	6	5	localException2	Exception
        //   188	6	5	localObject9	Object
        //   206	8	5	localException3	Exception
        // Exception table:
        //   from	to	target	type
        //   67	80	114	java/lang/Exception
        //   80	111	114	java/lang/Exception
        //   150	155	114	java/lang/Exception
        //   4	21	145	finally
        //   33	41	145	finally
        //   134	142	145	finally
        //   155	164	145	finally
        //   167	178	145	finally
        //   57	67	178	finally
        //   67	80	184	finally
        //   80	111	184	finally
        //   150	155	184	finally
        //   123	134	188	finally
        //   21	29	199	java/lang/Exception
        //   44	57	199	java/lang/Exception
        //   57	67	206	java/lang/Exception
        //   21	29	220	finally
        //   44	57	220	finally
    }

    /* Error */
    void H() {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: aload_0
        //   3: monitorenter
        //   4: iconst_4
        //   5: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   8: ldc_w 662
        //   11: invokestatic 336	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 151	com/flurry/android/impl/ads/FlurryAdModule:s	Ljava/io/File;
        //   18: invokevirtual 471	java/io/File:exists	()Z
        //   21: istore_2
        //   22: iload_2
        //   23: ifeq +144 -> 167
        //   26: new 473	java/io/FileInputStream
        //   29: dup
        //   30: aload_0
        //   31: getfield 151	com/flurry/android/impl/ads/FlurryAdModule:s	Ljava/io/File;
        //   34: invokespecial 474	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   37: astore 5
        //   39: new 476	java/io/DataInputStream
        //   42: dup
        //   43: aload 5
        //   45: invokespecial 479	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
        //   48: astore 4
        //   50: aload 4
        //   52: invokevirtual 666	java/io/DataInputStream:readShort	()S
        //   55: istore_1
        //   56: iload_1
        //   57: ifne +40 -> 97
        //   60: iconst_1
        //   61: istore_1
        //   62: aload 4
        //   64: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   67: aload 5
        //   69: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   72: iload_1
        //   73: ifne +21 -> 94
        //   76: iconst_3
        //   77: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   80: ldc_w 668
        //   83: invokestatic 336	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   86: aload_0
        //   87: getfield 151	com/flurry/android/impl/ads/FlurryAdModule:s	Ljava/io/File;
        //   90: invokevirtual 488	java/io/File:delete	()Z
        //   93: pop
        //   94: aload_0
        //   95: monitorexit
        //   96: return
        //   97: aload_0
        //   98: getfield 171	com/flurry/android/impl/ads/FlurryAdModule:f	Lcom/flurry/sdk/y;
        //   101: new 605	com/flurry/sdk/x
        //   104: dup
        //   105: aload 4
        //   107: invokespecial 671	com/flurry/sdk/x:<init>	(Ljava/io/DataInput;)V
        //   110: invokevirtual 674	com/flurry/sdk/y:a	(Lcom/flurry/sdk/x;)V
        //   113: goto -63 -> 50
        //   116: astore 6
        //   118: aload 5
        //   120: astore_3
        //   121: aload 6
        //   123: astore 5
        //   125: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   128: ldc_w 676
        //   131: aload 5
        //   133: invokestatic 464	com/flurry/sdk/eo:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   136: aload 4
        //   138: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   141: aload_3
        //   142: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   145: iconst_0
        //   146: istore_1
        //   147: goto -75 -> 72
        //   150: aload 4
        //   152: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   155: aload 5
        //   157: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   160: aload_3
        //   161: athrow
        //   162: astore_3
        //   163: aload_0
        //   164: monitorexit
        //   165: aload_3
        //   166: athrow
        //   167: iconst_3
        //   168: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   171: ldc_w 678
        //   174: invokestatic 336	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   177: goto -83 -> 94
        //   180: astore_3
        //   181: aconst_null
        //   182: astore 4
        //   184: goto -34 -> 150
        //   187: astore_3
        //   188: goto -38 -> 150
        //   191: astore 6
        //   193: aload_3
        //   194: astore 5
        //   196: aload 6
        //   198: astore_3
        //   199: goto -49 -> 150
        //   202: astore 5
        //   204: aconst_null
        //   205: astore 4
        //   207: goto -82 -> 125
        //   210: astore 6
        //   212: aconst_null
        //   213: astore 4
        //   215: aload 5
        //   217: astore_3
        //   218: aload 6
        //   220: astore 5
        //   222: goto -97 -> 125
        //   225: astore_3
        //   226: aconst_null
        //   227: astore 4
        //   229: aconst_null
        //   230: astore 5
        //   232: goto -82 -> 150
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	235	0	this	FlurryAdModule
        //   55	92	1	i1	int
        //   21	2	2	bool	boolean
        //   1	160	3	localObject1	Object
        //   162	4	3	localObject2	Object
        //   180	1	3	localObject3	Object
        //   187	7	3	localObject4	Object
        //   198	20	3	localObject5	Object
        //   225	1	3	localObject6	Object
        //   48	180	4	localDataInputStream	java.io.DataInputStream
        //   37	158	5	localObject7	Object
        //   202	14	5	localException1	Exception
        //   220	11	5	localObject8	Object
        //   116	6	6	localException2	Exception
        //   191	6	6	localObject9	Object
        //   210	9	6	localException3	Exception
        // Exception table:
        //   from	to	target	type
        //   50	56	116	java/lang/Exception
        //   97	113	116	java/lang/Exception
        //   4	22	162	finally
        //   62	72	162	finally
        //   76	94	162	finally
        //   136	145	162	finally
        //   150	162	162	finally
        //   167	177	162	finally
        //   39	50	180	finally
        //   50	56	187	finally
        //   97	113	187	finally
        //   125	136	191	finally
        //   26	39	202	java/lang/Exception
        //   39	50	210	java/lang/Exception
        //   26	39	225	finally
    }

    public void I() {
        try {
            this.g.c();
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void J() {
        try {
            this.g.d();
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void K() {
        try {
            this.g.e();
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void L() {
        try {
            this.g.f();
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    /* Error */
    public void M() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: invokestatic 176	com/flurry/sdk/ap:a	()Lcom/flurry/sdk/ap;
        //   5: invokevirtual 687	com/flurry/sdk/ap:b	()Z
        //   8: istore_1
        //   9: iload_1
        //   10: ifne +6 -> 16
        //   13: aload_0
        //   14: monitorexit
        //   15: return
        //   16: iconst_4
        //   17: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   20: ldc_w 689
        //   23: invokestatic 336	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   26: aload_0
        //   27: getfield 153	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/io/File;
        //   30: invokestatic 439	com/flurry/sdk/fd:a	(Ljava/io/File;)Z
        //   33: istore_1
        //   34: iload_1
        //   35: ifne +15 -> 50
        //   38: aconst_null
        //   39: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   42: goto -29 -> 13
        //   45: astore_2
        //   46: aload_0
        //   47: monitorexit
        //   48: aload_2
        //   49: athrow
        //   50: new 446	java/io/FileOutputStream
        //   53: dup
        //   54: aload_0
        //   55: getfield 153	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/io/File;
        //   58: invokespecial 449	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   61: astore_3
        //   62: aload_3
        //   63: astore_2
        //   64: invokestatic 176	com/flurry/sdk/ap:a	()Lcom/flurry/sdk/ap;
        //   67: aload_3
        //   68: invokevirtual 691	com/flurry/sdk/ap:a	(Ljava/io/OutputStream;)V
        //   71: aload_3
        //   72: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   75: goto -62 -> 13
        //   78: astore 4
        //   80: aconst_null
        //   81: astore_3
        //   82: aload_3
        //   83: astore_2
        //   84: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   87: ldc_w 693
        //   90: aload 4
        //   92: invokestatic 464	com/flurry/sdk/eo:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   95: aload_3
        //   96: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   99: goto -86 -> 13
        //   102: aload_2
        //   103: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   106: aload_3
        //   107: athrow
        //   108: astore_3
        //   109: goto -7 -> 102
        //   112: astore 4
        //   114: goto -32 -> 82
        //   117: astore_3
        //   118: aconst_null
        //   119: astore_2
        //   120: goto -18 -> 102
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	123	0	this	FlurryAdModule
        //   8	27	1	bool	boolean
        //   45	4	2	localObject1	Object
        //   63	57	2	localObject2	Object
        //   61	46	3	localFileOutputStream	java.io.FileOutputStream
        //   108	1	3	localObject3	Object
        //   117	1	3	localObject4	Object
        //   78	13	4	localException1	Exception
        //   112	1	4	localException2	Exception
        // Exception table:
        //   from	to	target	type
        //   2	9	45	finally
        //   16	26	45	finally
        //   38	42	45	finally
        //   71	75	45	finally
        //   95	99	45	finally
        //   102	108	45	finally
        //   26	34	78	java/lang/Exception
        //   50	62	78	java/lang/Exception
        //   64	71	108	finally
        //   84	95	108	finally
        //   64	71	112	java/lang/Exception
        //   26	34	117	finally
        //   50	62	117	finally
    }

    /* Error */
    void N() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: invokestatic 176	com/flurry/sdk/ap:a	()Lcom/flurry/sdk/ap;
        //   5: invokevirtual 687	com/flurry/sdk/ap:b	()Z
        //   8: istore_2
        //   9: iload_2
        //   10: ifne +6 -> 16
        //   13: aload_0
        //   14: monitorexit
        //   15: return
        //   16: iconst_4
        //   17: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   20: ldc_w 695
        //   23: invokestatic 336	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   26: aload_0
        //   27: getfield 153	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/io/File;
        //   30: invokevirtual 471	java/io/File:exists	()Z
        //   33: istore_2
        //   34: iload_2
        //   35: ifeq +112 -> 147
        //   38: new 473	java/io/FileInputStream
        //   41: dup
        //   42: aload_0
        //   43: getfield 153	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/io/File;
        //   46: invokespecial 474	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   49: astore 4
        //   51: aload 4
        //   53: astore_3
        //   54: invokestatic 176	com/flurry/sdk/ap:a	()Lcom/flurry/sdk/ap;
        //   57: aload 4
        //   59: invokevirtual 697	com/flurry/sdk/ap:a	(Ljava/io/InputStream;)V
        //   62: iconst_1
        //   63: istore_1
        //   64: aconst_null
        //   65: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   68: aload 4
        //   70: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   73: iload_1
        //   74: ifne -61 -> 13
        //   77: iconst_3
        //   78: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   81: ldc_w 699
        //   84: invokestatic 336	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   87: aload_0
        //   88: getfield 153	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/io/File;
        //   91: invokevirtual 488	java/io/File:delete	()Z
        //   94: pop
        //   95: goto -82 -> 13
        //   98: astore_3
        //   99: aload_0
        //   100: monitorexit
        //   101: aload_3
        //   102: athrow
        //   103: astore 5
        //   105: aconst_null
        //   106: astore 4
        //   108: aload 4
        //   110: astore_3
        //   111: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   114: ldc_w 701
        //   117: aload 5
        //   119: invokestatic 464	com/flurry/sdk/eo:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   122: aconst_null
        //   123: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   126: aload 4
        //   128: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   131: iconst_0
        //   132: istore_1
        //   133: goto -60 -> 73
        //   136: aconst_null
        //   137: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   140: aload_3
        //   141: invokestatic 444	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   144: aload 4
        //   146: athrow
        //   147: iconst_3
        //   148: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   151: ldc_w 703
        //   154: invokestatic 336	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   157: goto -144 -> 13
        //   160: astore 4
        //   162: goto -26 -> 136
        //   165: astore 5
        //   167: goto -59 -> 108
        //   170: astore 4
        //   172: aconst_null
        //   173: astore_3
        //   174: goto -38 -> 136
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	177	0	this	FlurryAdModule
        //   63	70	1	i1	int
        //   8	27	2	bool	boolean
        //   53	1	3	localFileInputStream1	java.io.FileInputStream
        //   98	4	3	localObject1	Object
        //   110	64	3	localFileInputStream2	java.io.FileInputStream
        //   49	96	4	localFileInputStream3	java.io.FileInputStream
        //   160	1	4	localObject2	Object
        //   170	1	4	localObject3	Object
        //   103	15	5	localException1	Exception
        //   165	1	5	localException2	Exception
        // Exception table:
        //   from	to	target	type
        //   2	9	98	finally
        //   16	34	98	finally
        //   64	73	98	finally
        //   77	95	98	finally
        //   122	131	98	finally
        //   136	147	98	finally
        //   147	157	98	finally
        //   38	51	103	java/lang/Exception
        //   54	62	160	finally
        //   111	122	160	finally
        //   54	62	165	java/lang/Exception
        //   38	51	170	finally
    }

    public e O() {
        return a(a(null), "unfilled", true, null);
    }

    public e P() {
        return this.z;
    }

    public AdUnit Q() {
        return this.A;
    }

    public e R() {
        return this.B;
    }

    public AdUnit S() {
        return this.C;
    }

    public ev.a T() {
        return ev.a().e();
    }

    public boolean U() {
        return (this.G != null) && (this.G.length() > 0);
    }

    public CharSequence V() {
        return this.G;
    }

    public y W() {
        return this.f;
    }

    public List<Integer> X() {
        return p;
    }

    public boolean Y() {
        return this.n;
    }

    public String Z() {
        return this.u;
    }

    Intent a(Intent paramIntent) {
        if (paramIntent == null) {
            return null;
        }
        return (Intent) paramIntent.getParcelableExtra("targetIntent");
    }

    public ah a(Context paramContext, AdUnit paramAdUnit, String paramString, ViewGroup paramViewGroup, FlurryAdSize paramFlurryAdSize) {
        if (paramAdUnit == null) {
        }
        do {
            return null;
            paramString = paramAdUnit.d();
        } while ((paramString == null) || (paramString.isEmpty()));
        paramString = (AdFrame) paramString.get(0);
        paramViewGroup = paramString.e().e().toString();
        paramFlurryAdSize = paramString.g().toString();
        paramString = (e) this.j.get(paramFlurryAdSize);
        if (paramString == null) {
            paramString = a(paramFlurryAdSize);
        }
        for (; ; ) {
            a(new q("filled", Collections.emptyMap(), paramContext, paramAdUnit, paramString, 0), this.P, 1);
            if (paramViewGroup.equals("takeover")) {
                eo.a(3, q, "prepareAd: first frame of AdUnit is a takeover");
                return new ai(this, paramAdUnit, paramString);
            }
            eo.a(3, q, "prepareAd: first frame of AdUnit is a banner");
            return new j(this, paramAdUnit, paramString);
        }
    }

    c a(String paramString, boolean paramBoolean, Map<String, String> paramMap) {
        try {
            paramString = new c(paramString, paramBoolean, o(), paramMap);
            return paramString;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    public ci a(String paramString, ci paramci) {
        synchronized (this.k) {
            paramString = (ci) this.k.put(paramString, paramci);
            return paramString;
        }
    }

    /* Error */
    public e a(e parame, String paramString, boolean paramBoolean, Map<String, String> paramMap) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: iconst_3
        //   3: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   6: new 394	java/lang/StringBuilder
        //   9: dup
        //   10: invokespecial 395	java/lang/StringBuilder:<init>	()V
        //   13: ldc_w 824
        //   16: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   19: aload_1
        //   20: invokevirtual 827	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   23: ldc_w 829
        //   26: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   29: aload_2
        //   30: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   33: ldc_w 829
        //   36: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   39: iload_3
        //   40: invokevirtual 832	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
        //   43: ldc_w 829
        //   46: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   49: aload 4
        //   51: invokevirtual 827	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   54: ldc_w 834
        //   57: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   60: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   63: invokestatic 336	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   66: aload_1
        //   67: monitorenter
        //   68: aload_0
        //   69: getfield 195	com/flurry/android/impl/ads/FlurryAdModule:I	Ljava/util/List;
        //   72: aload_1
        //   73: invokeinterface 837 2 0
        //   78: ifne +41 -> 119
        //   81: aload_0
        //   82: getfield 195	com/flurry/android/impl/ads/FlurryAdModule:I	Ljava/util/List;
        //   85: aload_1
        //   86: invokeinterface 599 2 0
        //   91: pop
        //   92: iconst_3
        //   93: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   96: new 394	java/lang/StringBuilder
        //   99: dup
        //   100: invokespecial 395	java/lang/StringBuilder:<init>	()V
        //   103: ldc_w 839
        //   106: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   109: aload_1
        //   110: invokevirtual 827	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   113: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   116: invokestatic 336	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   119: aload_1
        //   120: aload_0
        //   121: aload_2
        //   122: iload_3
        //   123: aload 4
        //   125: invokevirtual 841	com/flurry/android/impl/ads/FlurryAdModule:a	(Ljava/lang/String;ZLjava/util/Map;)Lcom/flurry/sdk/c;
        //   128: invokevirtual 844	com/flurry/sdk/e:a	(Lcom/flurry/sdk/c;)V
        //   131: aload_1
        //   132: monitorexit
        //   133: aload_0
        //   134: monitorexit
        //   135: aload_1
        //   136: areturn
        //   137: astore_2
        //   138: aload_1
        //   139: monitorexit
        //   140: aload_2
        //   141: athrow
        //   142: astore_1
        //   143: aload_0
        //   144: monitorexit
        //   145: aload_1
        //   146: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	147	0	this	FlurryAdModule
        //   0	147	1	parame	e
        //   0	147	2	paramString	String
        //   0	147	3	paramBoolean	boolean
        //   0	147	4	paramMap	Map<String, String>
        // Exception table:
        //   from	to	target	type
        //   68	119	137	finally
        //   119	133	137	finally
        //   138	140	137	finally
        //   2	68	142	finally
        //   140	142	142	finally
    }

    public e a(String paramString) {
        try {
            e locale = (e) this.j.get(paramString);
            Object localObject = locale;
            if (locale == null) {
                paramString = new e(h(), paramString, o());
                localObject = paramString;
                if (this.I.size() < 32767) {
                    this.I.add(paramString);
                    this.j.put(paramString.b(), paramString);
                    localObject = paramString;
                }
            }
            return (e) localObject;
        } finally {
        }
    }

    public l a(Context paramContext, ViewGroup paramViewGroup, String paramString) {
        return this.Q.a(this, paramContext, paramViewGroup, paramString);
    }

    public r a() {
        return this.P;
    }

    public List<a> a(AdFrame paramAdFrame, q paramq) {
        ArrayList localArrayList = new ArrayList();
        paramAdFrame = paramAdFrame.f();
        String str3 = paramq.a;
        Iterator localIterator1 = paramAdFrame.iterator();
        while (localIterator1.hasNext()) {
            paramAdFrame = (Callback) localIterator1.next();
            if (paramAdFrame.b().toString().equals(str3)) {
                Iterator localIterator2 = paramAdFrame.c().iterator();
                while (localIterator2.hasNext()) {
                    paramAdFrame = (CharSequence) localIterator2.next();
                    HashMap localHashMap = new HashMap();
                    String str2 = paramAdFrame.toString();
                    int i1 = str2.indexOf('?');
                    paramAdFrame = str2;
                    if (i1 != -1) {
                        String str1 = str2.substring(0, i1);
                        str2 = str2.substring(i1 + 1);
                        paramAdFrame = str2;
                        if (str2.contains("%{eventParams}")) {
                            paramAdFrame = str2.replace("%{eventParams}", "");
                            localHashMap.putAll(paramq.b);
                        }
                        localHashMap.putAll(fe.f(paramAdFrame));
                        paramAdFrame = str1;
                    }
                    localArrayList.add(new a(paramAdFrame, localHashMap, paramq));
                }
            }
        }
        return localArrayList;
    }

    /* Error */
    public void a(long paramLong1, long paramLong2) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 178	com/flurry/android/impl/ads/FlurryAdModule:g	Lcom/flurry/sdk/ap;
        //   6: invokevirtual 687	com/flurry/sdk/ap:b	()Z
        //   9: istore 5
        //   11: iload 5
        //   13: ifeq +6 -> 19
        //   16: aload_0
        //   17: monitorexit
        //   18: return
        //   19: invokestatic 508	com/flurry/sdk/do:a	()Lcom/flurry/sdk/do;
        //   22: invokevirtual 511	com/flurry/sdk/do:b	()Landroid/content/Context;
        //   25: astore 6
        //   27: iconst_3
        //   28: getstatic 143	com/flurry/android/impl/ads/FlurryAdModule:q	Ljava/lang/String;
        //   31: ldc_w 904
        //   34: invokestatic 336	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   37: aload_0
        //   38: getfield 178	com/flurry/android/impl/ads/FlurryAdModule:g	Lcom/flurry/sdk/ap;
        //   41: lload_1
        //   42: lload_3
        //   43: invokevirtual 906	com/flurry/sdk/ap:a	(JJ)V
        //   46: aload_0
        //   47: getfield 178	com/flurry/android/impl/ads/FlurryAdModule:g	Lcom/flurry/sdk/ap;
        //   50: invokevirtual 680	com/flurry/sdk/ap:c	()V
        //   53: aload_0
        //   54: aload 6
        //   56: aload_0
        //   57: invokevirtual 908	com/flurry/android/impl/ads/FlurryAdModule:v	()Ljava/lang/String;
        //   60: invokevirtual 912	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
        //   63: putfield 153	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/io/File;
        //   66: aload_0
        //   67: new 54	com/flurry/android/impl/ads/FlurryAdModule$8
        //   70: dup
        //   71: aload_0
        //   72: invokespecial 913	com/flurry/android/impl/ads/FlurryAdModule$8:<init>	(Lcom/flurry/android/impl/ads/FlurryAdModule;)V
        //   75: invokevirtual 542	com/flurry/android/impl/ads/FlurryAdModule:b	(Lcom/flurry/sdk/ff;)V
        //   78: goto -62 -> 16
        //   81: astore 6
        //   83: aload_0
        //   84: monitorexit
        //   85: aload 6
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	FlurryAdModule
        //   0	88	1	paramLong1	long
        //   0	88	3	paramLong2	long
        //   9	3	5	bool	boolean
        //   25	30	6	localContext	Context
        //   81	5	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	11	81	finally
        //   19	78	81	finally
    }

    void a(Activity paramActivity) {
        int i2 = 1;
        Activity localActivity;
        AdUnit localAdUnit;
        int i1;
        if (1 == this.H.size()) {
            localActivity = (Activity) this.H.get(0);
            if (!(localActivity instanceof FlurryFullscreenTakeoverActivity)) {
                break label141;
            }
            Object localObject = (FlurryFullscreenTakeoverActivity) localActivity;
            localAdUnit = ((FlurryFullscreenTakeoverActivity) localObject).getAdUnit();
            localObject = ((FlurryFullscreenTakeoverActivity) localObject).getAdUnityView();
            if (localObject == null) {
                break label136;
            }
            i1 = ((g) localObject).getAdFrameIndex();
        }
        for (; ; ) {
            if ((localAdUnit != null) && ((localAdUnit.e().intValue() != 1) || (i1 > 0))) {
                i1 = i2;
                if (paramActivity != null) {
                    i1 = i2;
                    if ((paramActivity instanceof FlurryFullscreenTakeoverActivity)) {
                        if (((FlurryFullscreenTakeoverActivity) paramActivity).getResult() == n.e.b) {
                            break label131;
                        }
                    }
                }
            }
            label131:
            for (i1 = 1; ; i1 = 0) {
                if (i1 != 0) {
                    localActivity.finish();
                }
                return;
            }
            label136:
            i1 = -1;
            continue;
            label141:
            localAdUnit = null;
            i1 = -1;
        }
    }

    public void a(final Activity paramActivity, final Bundle paramBundle) {
        if (paramActivity == null) {
        }
        do {
            Intent localIntent;
            do {
                return;
                this.H.add(paramActivity);
                localIntent = paramActivity.getIntent();
                paramBundle = b(localIntent);
                a(paramActivity, paramBundle);
            } while (a(localIntent) == null);
            paramActivity = ac();
            eo.a(3, q, "Firing onApplicationExit, listener=" + paramActivity);
        } while (paramActivity == null);
        do.a().a(new ff() {
            public void a() {
                paramActivity.onApplicationExit(paramBundle);
            }
        });
    }

    public void a(Activity paramActivity, du.a parama) {
        this.Q.a(paramActivity, parama);
    }

    public void a(Context paramContext, AdUnit paramAdUnit, ah paramah) {
        if ("takeover".equals(((AdFrame) paramAdUnit.d().get(0)).e().e().toString())) {
            K();
        }
        paramAdUnit = (e) this.j.get(((AdFrame) paramAdUnit.d().get(0)).g().toString());
        a(new q("requested", Collections.emptyMap(), paramContext, paramah.c(), paramAdUnit, 0), this.P, 0);
    }

    public void a(final Context paramContext, final String paramString) {
        this.i += 1;
        if (1 == this.i) {
            paramContext = ac();
            eo.a(3, q, "Firing onAdOpened, listener=" + paramContext);
            if (paramContext != null) {
                do.a().a(new ff() {
                    public void a() {
                        paramContext.onAdOpened(paramString);
                    }
                });
            }
        }
    }

    public void a(FlurryAdListener paramFlurryAdListener) {
        this.F = new WeakReference(paramFlurryAdListener);
    }

    public void a(ICustomAdNetworkHandler paramICustomAdNetworkHandler) {
        this.h = paramICustomAdNetworkHandler;
    }

    public void a(AdUnit paramAdUnit) {
        this.A = paramAdUnit;
    }

    public void a(dj paramdj) {
        C();
    }

    public void a(dj paramdj, Context paramContext) {
        this.N = new ac();
        if (this.O == null) {
            this.O = new s();
        }
        this.c = paramdj.m();
        this.d = paramdj.n();
        this.e = 0L;
        this.w = cg.a(paramContext);
    }

    public void a(e parame) {
        this.z = parame;
    }

    public void a(ff paramff) {
        do.a().a(paramff);
    }

    public void a(final q paramq, ad paramad, int paramInt) {
        int i2 = 1;
        eo.a(3, q, "onEvent:event=" + paramq.a + ",params=" + paramq.b);
        a(paramq.a, 1);
        Object localObject1 = a(paramq.b(), paramq);
        final Object localObject2;
        Object localObject3;
        if (((List) localObject1).isEmpty()) {
            localObject2 = this.J.entrySet().iterator();
            while (((Iterator) localObject2).hasNext()) {
                localObject3 = (Map.Entry) ((Iterator) localObject2).next();
                if (((String) ((Map.Entry) localObject3).getKey()).equals(paramq.a)) {
                    ((List) localObject1).add(new a((String) ((Map.Entry) localObject3).getValue(), paramq.b, paramq));
                }
            }
        }
        if (paramq.a.equals("sendUrlStatusResult")) {
            eo.a(3, q, "sendUrlStatusResult event");
            ((List) localObject1).add(new a("logEvent", paramq.b, paramq));
        }
        Object localObject4;
        Object localObject5;
        if (paramq.a.equals("adWillClose")) {
            localObject2 = (ci) this.k.get(paramq.b().g().toString());
            if (localObject2 != null) {
                localObject2 = ((ci) localObject2).a(co.q);
                if (localObject2 != null) {
                    localObject2 = ((List) localObject2).iterator();
                    while (((Iterator) localObject2).hasNext()) {
                        localObject3 = (String) ((Iterator) localObject2).next();
                        if (localObject3 != null) {
                            eo.a(3, q, "Close Tracking URL: " + (String) localObject3);
                            localObject4 = ((List) localObject1).iterator();
                            while (((Iterator) localObject4).hasNext()) {
                                localObject5 = (a) ((Iterator) localObject4).next();
                                if ("logEvent".equals(((a) localObject5).a)) {
                                    this.P.b((a) localObject5, (String) localObject3);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (paramq.a.equals("renderFailed")) {
            if ((String) paramq.b.remove("binding_3rd_party") == null) {
                break label2640;
            }
        }
        label2624:
        label2625:
        label2638:
        label2640:
        for (int i1 = 1; ; i1 = 0) {
            if (((AdFrame) paramq.c.d().get(0)).b().intValue() == 4) {
                i1 = 1;
            }
            if ((paramq.b.remove("preRender") == null) && (i1 != 1)) {
                localObject2 = ac();
                eo.a(3, q, "Firing renderFailed, listener=" + localObject2);
                if (localObject2 != null) {
                    do.a().a(new ff() {
                        public void a() {
                            localObject2.onRenderFailed(paramq.c.b().toString());
                        }
                    });
                }
            }
            for (; ; ) {
                localObject2 = (ci) this.k.get(paramq.b().g().toString());
                if (localObject2 != null) {
                    localObject2 = ((ci) localObject2).g();
                    if (localObject2 != null) {
                        localObject2 = ((List) localObject2).iterator();
                        while (((Iterator) localObject2).hasNext()) {
                            localObject3 = (String) ((Iterator) localObject2).next();
                            if (localObject3 != null) {
                                eo.a(3, q, "Error Tracking URL: " + (String) localObject3);
                                localObject4 = ((List) localObject1).iterator();
                                while (((Iterator) localObject4).hasNext()) {
                                    localObject5 = (a) ((Iterator) localObject4).next();
                                    if ("logEvent".equals(((a) localObject5).a)) {
                                        this.P.b((a) localObject5, (String) localObject3);
                                    }
                                }
                                continue;
                                localObject2 = ((List) localObject1).iterator();
                                do {
                                    if (!((Iterator) localObject2).hasNext()) {
                                        break;
                                    }
                                } while (!"nextAdUnit".equals(((a) ((Iterator) localObject2).next()).a));
                            }
                        }
                    }
                }
                for (i1 = 0; ; i1 = 1) {
                    if (i1 == 0) {
                        break label2638;
                    }
                    localObject2 = ac();
                    eo.a(3, q, "Firing spaceDidFailToReceiveAd, listener=" + localObject2);
                    if (localObject2 == null) {
                        break;
                    }
                    do.a().a(new ff() {
                        public void a() {
                            localObject2.spaceDidFailToReceiveAd(paramq.c.b().toString());
                        }
                    });
                    break;
                    a(null);
                    d(paramq.b().g().toString());
                    ap.a().f(paramq.c);
                    L();
                    b(new ff() {
                        public void a() {
                            String str = paramq.c.b().toString();
                            FlurryAdModule.this.g.b(str, FlurryAdModule.c(FlurryAdModule.this).e(str));
                        }
                    });
                    if (paramq.a.equals("clicked")) {
                        localObject2 = ac();
                        eo.a(3, q, "Firing onAdClicked, listener=" + localObject2);
                        if (localObject2 != null) {
                            do.a().a(new ff() {
                                public void a() {
                                    localObject2.onAdClicked(paramq.c.b().toString());
                                }
                            });
                        }
                        localObject2 = (ci) this.k.get(paramq.b().g().toString());
                        if (localObject2 != null) {
                            localObject3 = c(paramq.b().g().toString());
                            localObject4 = ((ci) localObject2).a(cp.b);
                            if (localObject4 != null) {
                                ((am) localObject3).g(true);
                                this.P.a(paramq.a(), (String) localObject4, true, paramq.c, paramq.b().g().toString());
                            }
                            if (((am) localObject3).f()) {
                                break label2624;
                            }
                            ((am) localObject3).e(true);
                            localObject2 = ((ci) localObject2).a(cp.c);
                            if (localObject2 != null) {
                                eo.a(3, q, "ClickThrough Tracking URL: " + (String) localObject2);
                                localObject3 = ((List) localObject1).iterator();
                                while (((Iterator) localObject3).hasNext()) {
                                    localObject4 = (a) ((Iterator) localObject3).next();
                                    if ("logEvent".equals(((a) localObject4).a)) {
                                        this.P.b((a) localObject4, (String) localObject2);
                                    }
                                }
                            }
                        }
                    }
                    if (paramq.a.equals("videoStart")) {
                        localObject2 = (ci) this.k.get(paramq.b().g().toString());
                        if (localObject2 != null) {
                            localObject2 = ((ci) localObject2).h();
                            if (localObject2 != null) {
                                localObject2 = ((List) localObject2).iterator();
                                while (((Iterator) localObject2).hasNext()) {
                                    localObject3 = (String) ((Iterator) localObject2).next();
                                    if (localObject3 != null) {
                                        eo.a(3, q, "Impression Tracking URL: " + (String) localObject3);
                                        localObject4 = ((List) localObject1).iterator();
                                        while (((Iterator) localObject4).hasNext()) {
                                            localObject5 = (a) ((Iterator) localObject4).next();
                                            if ("logEvent".equals(((a) localObject5).a)) {
                                                this.P.b((a) localObject5, (String) localObject3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        c(paramq.b().g().toString()).a(true);
                    }
                    if (paramq.a.equals("videoFirstQuartile")) {
                        localObject2 = (ci) this.k.get(paramq.b().g().toString());
                        if (localObject2 != null) {
                            localObject2 = ((ci) localObject2).a(co.e);
                            if (localObject2 != null) {
                                localObject2 = ((List) localObject2).iterator();
                                while (((Iterator) localObject2).hasNext()) {
                                    localObject3 = (String) ((Iterator) localObject2).next();
                                    if (localObject3 != null) {
                                        eo.a(3, q, "First Quartile Tracking URL: " + (String) localObject3);
                                        localObject4 = ((List) localObject1).iterator();
                                        while (((Iterator) localObject4).hasNext()) {
                                            localObject5 = (a) ((Iterator) localObject4).next();
                                            if ("logEvent".equals(((a) localObject5).a)) {
                                                this.P.b((a) localObject5, (String) localObject3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        c(paramq.b().g().toString()).b(true);
                    }
                    if (paramq.a.equals("videoMidpoint")) {
                        localObject2 = (ci) this.k.get(paramq.b().g().toString());
                        if (localObject2 != null) {
                            localObject2 = ((ci) localObject2).a(co.d);
                            if (localObject2 != null) {
                                localObject2 = ((List) localObject2).iterator();
                                while (((Iterator) localObject2).hasNext()) {
                                    localObject3 = (String) ((Iterator) localObject2).next();
                                    if (localObject3 != null) {
                                        eo.a(3, q, "Midpoint Tracking URL: " + (String) localObject3);
                                        localObject4 = ((List) localObject1).iterator();
                                        while (((Iterator) localObject4).hasNext()) {
                                            localObject5 = (a) ((Iterator) localObject4).next();
                                            if ("logEvent".equals(((a) localObject5).a)) {
                                                this.P.b((a) localObject5, (String) localObject3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        c(paramq.b().g().toString()).c(true);
                    }
                    if (paramq.a.equals("videoThirdQuartile")) {
                        localObject2 = (ci) this.k.get(paramq.b().g().toString());
                        if (localObject2 != null) {
                            localObject2 = ((ci) localObject2).a(co.f);
                            if (localObject2 != null) {
                                localObject2 = ((List) localObject2).iterator();
                                while (((Iterator) localObject2).hasNext()) {
                                    localObject3 = (String) ((Iterator) localObject2).next();
                                    if (localObject3 != null) {
                                        eo.a(3, q, "Third Quartile Tracking URL: " + (String) localObject3);
                                        localObject4 = ((List) localObject1).iterator();
                                        while (((Iterator) localObject4).hasNext()) {
                                            localObject5 = (a) ((Iterator) localObject4).next();
                                            if ("logEvent".equals(((a) localObject5).a)) {
                                                this.P.b((a) localObject5, (String) localObject3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        c(paramq.b().g().toString()).d(true);
                    }
                    if (paramq.a.equals("videoCompleted")) {
                        if (paramq.c.n().booleanValue()) {
                            eo.a(3, q, "Ad unit is rewardable, onVideoCompleted listener will fire");
                            localObject2 = ac();
                            eo.a(3, q, "Firing onVideoCompleted, listener=" + localObject2);
                            if (localObject2 != null) {
                                do.a().a(new ff() {
                                    public void a() {
                                        localObject2.onVideoCompleted(paramq.c.b().toString());
                                    }
                                });
                            }
                        }
                        for (; ; ) {
                            localObject2 = (ci) this.k.get(paramq.b().g().toString());
                            if (localObject2 == null) {
                                break;
                            }
                            localObject2 = ((ci) localObject2).a(co.g);
                            if (localObject2 == null) {
                                break;
                            }
                            localObject2 = ((List) localObject2).iterator();
                            while (((Iterator) localObject2).hasNext()) {
                                localObject3 = (String) ((Iterator) localObject2).next();
                                if (localObject3 != null) {
                                    eo.a(3, q, "Complete Tracking URL: " + (String) localObject3);
                                    localObject4 = ((List) localObject1).iterator();
                                    while (((Iterator) localObject4).hasNext()) {
                                        localObject5 = (a) ((Iterator) localObject4).next();
                                        if ("logEvent".equals(((a) localObject5).a)) {
                                            this.P.b((a) localObject5, (String) localObject3);
                                        }
                                    }
                                }
                            }
                            eo.a(3, q, "Ad unit is not rewardable, onVideoCompleted listener will not fire");
                        }
                    }
                    if ((paramq.a.equals("adWillClose")) || (paramq.a.equals("videoCompleted")) || (paramq.a.equals("userConfirmed"))) {
                        localObject2 = ((List) localObject1).iterator();
                        do {
                            if (!((Iterator) localObject2).hasNext()) {
                                break;
                            }
                            localObject3 = (a) ((Iterator) localObject2).next();
                        } while (!this.K.contains(((a) localObject3).a));
                    }
                    for (i1 = i2; ; i1 = 0) {
                        if (i1 == 0) {
                            ((List) localObject1).add(0, new a("closeAd", Collections.emptyMap(), paramq));
                        }
                        if ((i1 == 0) || (paramq.a.equals("videoCompleted")) || (paramq.a.equals("userConfirmed"))) {
                            d(paramq.b().g().toString());
                            L();
                            b(new ff() {
                                public void a() {
                                    String str = paramq.c.b().toString();
                                    FlurryAdModule.this.g.b(str, FlurryAdModule.c(FlurryAdModule.this).e(str));
                                }
                            });
                        }
                        localObject3 = ((List) localObject1).iterator();
                        localObject1 = null;
                        if (((Iterator) localObject3).hasNext()) {
                            localObject2 = (a) ((Iterator) localObject3).next();
                            if (!((a) localObject2).a.equals("logEvent")) {
                                break label2625;
                            }
                            ((a) localObject2).b.put("__sendToServer", "true");
                            localObject1 = localObject2;
                        }
                        for (; ; ) {
                            if (((a) localObject2).a.equals("loadAdComponents")) {
                                localObject4 = ((a) localObject2).c.b.entrySet().iterator();
                                while (((Iterator) localObject4).hasNext()) {
                                    localObject5 = (Map.Entry) ((Iterator) localObject4).next();
                                    ((a) localObject2).b.put(((String) ((Map.Entry) localObject5).getKey()).toString(), ((String) ((Map.Entry) localObject5).getValue()).toString());
                                }
                            }
                            eo.c(q, ((a) localObject2).toString());
                            paramad.a((a) localObject2, this, paramInt + 1);
                            break;
                            if (localObject1 == null) {
                                localObject1 = new HashMap();
                                ((Map) localObject1).put("__sendToServer", "false");
                                paramq = new a("logEvent", (Map) localObject1, paramq);
                                paramad.a(paramq, this, paramInt + 1);
                                eo.c(q, paramq.toString());
                            }
                            return;
                        }
                    }
                }
            }
        }
    }

    public void a(String paramString, int paramInt) {
        synchronized (this.b) {
            Integer localInteger = (Integer) this.b.get(paramString);
            TreeMap localTreeMap2 = this.b;
            int i1 = paramInt;
            if (localInteger != null) {
                i1 = paramInt + localInteger.intValue();
            }
            localTreeMap2.put(paramString, Integer.valueOf(i1));
            return;
        }
    }

    public void a(String paramString, CharSequence paramCharSequence) {
        this.G = paramCharSequence;
        this.Q.d(paramString);
    }

    public void a(final String paramString, final List<AdUnit> paramList) {
        try {
            b(new ff() {
                public void a() {
                    FlurryAdModule.c(FlurryAdModule.this).a(paramString, paramList);
                }
            });
            b(new ff() {
                public void a() {
                    FlurryAdModule.this.g.a(paramString, paramList);
                }
            });
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    public void a(String paramString, List<AdUnit> paramList, int paramInt) {
        e().a(paramString, paramList, paramInt);
    }

    public void a(Map<String, String> paramMap) {
        if ((paramMap != null) && (paramMap.size() > 0)) {
            paramMap = paramMap.entrySet().iterator();
            while (paramMap.hasNext()) {
                Map.Entry localEntry = (Map.Entry) paramMap.next();
                if ((localEntry.getKey() != null) && (localEntry.getValue() != null)) {
                    this.a.put(localEntry.getKey(), localEntry.getValue());
                } else {
                    eo.d(q, "User cookie keys and values may not be null.");
                }
            }
        }
    }

    public void a(boolean paramBoolean) {
        this.n = paramBoolean;
    }

    public String aa() {
        return this.v;
    }

    public String ab() {
        return this.w;
    }

    public FlurryAdListener ac() {
        return (FlurryAdListener) this.F.get();
    }

    public ci b(String paramString) {
        synchronized (this.k) {
            paramString = (ci) this.k.get(paramString);
            return paramString;
        }
    }

    public k b() {
        return this.D;
    }

    String b(Intent paramIntent) {
        if (paramIntent == null) {
            return null;
        }
        return paramIntent.getStringExtra("adSpaceName");
    }

    public void b(Activity paramActivity) {
        if (paramActivity == null) {
            return;
        }
        b(paramActivity, b(paramActivity.getIntent()));
        this.H.remove(paramActivity);
        a(paramActivity);
    }

    public void b(final Context paramContext, final String paramString) {
        this.i -= 1;
        if (this.i == 0) {
            paramContext = ac();
            eo.a(3, q, "Firing onAdClosed, listener=" + paramContext);
            if (paramContext != null) {
                do.a().a(new ff() {
                    public void a() {
                        paramContext.onAdClosed(paramString);
                    }
                });
            }
        }
    }

    public void b(AdUnit paramAdUnit) {
        this.C = paramAdUnit;
    }

    public void b(dj paramdj, Context paramContext) {
        f();
        dz.a().c();
        this.f.d();
        b(new ff() {
            public void a() {
                FlurryAdModule.b(FlurryAdModule.this).a();
            }
        });
        b(new ff() {
            public void a() {
                FlurryAdModule.this.I();
            }
        });
    }

    public void b(e parame) {
        this.B = parame;
    }

    public void b(ff paramff) {
        do.a().c(paramff);
    }

    public void b(Map<String, String> paramMap) {
        if ((paramMap == this.o) || ((paramMap != null) && (paramMap.equals(this.o)))) {
        }
        for (int i1 = 1; ; i1 = 0) {
            this.o = paramMap;
            if (i1 != 0) {
                this.Q.b();
            }
            return;
        }
    }

    public ak c() {
        return this.E;
    }

    public am c(String paramString) {
        synchronized (this.l) {
            am localam2 = (am) this.l.get(paramString);
            am localam1 = localam2;
            if (localam2 == null) {
                localam1 = new am();
                this.l.put(paramString, localam1);
            }
            return localam1;
        }
    }

    public void c(dj paramdj, final Context paramContext) {
        dz.a().d();
        if (!dv.a().b()) {
            a(new ff() {
                public void a() {
                    FlurryAdModule.c(FlurryAdModule.this).a(paramContext);
                }
            });
        }
        if (dl.a().b() == 0) {
            this.Q.a();
            this.R.b();
            b(new ff() {
                public void a() {
                    FlurryAdModule.this.J();
                }
            });
        }
        b(new ff() {
            public void a() {
                FlurryAdModule.d(FlurryAdModule.this);
            }
        });
        b(new ff() {
            public void a() {
                FlurryAdModule.this.G();
            }
        });
        b(new ff() {
            public void a() {
                FlurryAdModule.this.M();
            }
        });
    }

    public u d() {
        return this.Q;
    }

    public void d(String paramString) {
        synchronized (this.l) {
            this.l.remove(paramString);
            return;
        }
    }

    public t e() {
        return this.R;
    }

    public void e(String paramString) {
        this.x = paramString;
    }

    public void f() {
        for (; ; ) {
            try {
                boolean bool = this.M;
                if (bool) {
                    return;
                }
                if (dl.a().c() == null) {
                    throw new RuntimeException("Flurry Session wasn't started");
                }
            } finally {
            }
            Context localContext = do.a().b();
            dv.a().a(this);
            this.r = localContext.getFileStreamPath(t());
            this.s = localContext.getFileStreamPath(u());
            this.P.a();
            b(new ff() {
                public void a() {
                    FlurryAdModule.a(FlurryAdModule.this);
                }
            });
            b(new ff() {
                public void a() {
                    FlurryAdModule.this.H();
                }
            });
            this.M = true;
        }
    }

    public void f(String paramString) {
        this.y = paramString;
    }

    public void g(final String paramString) {
        L();
        b(new ff() {
            public void a() {
                FlurryAdModule.this.g.b(paramString, FlurryAdModule.c(FlurryAdModule.this).e(paramString));
            }
        });
    }

    public boolean g() {
        return this.i != 0;
    }

    public long h() {
        return this.c;
    }

    public String j() {
        return dn.a().h();
    }

    public List<CharSequence> k() {
        ArrayList localArrayList = new ArrayList();
        Object localObject = cx.a().b();
        if ((localObject != null) && (!((HashMap) localObject).isEmpty())) {
            localObject = ((HashMap) localObject).keySet().iterator();
            while (((Iterator) localObject).hasNext()) {
                localArrayList.add((String) ((Iterator) localObject).next());
            }
        }
        return localArrayList;
    }

    public String l() {
        return dn.a().i();
    }

    public String m() {
        return dn.a().j();
    }

    public com.flurry.android.impl.ads.avro.protocol.v10.Location n() {
        float f1 = 0.0F;
        android.location.Location localLocation = dz.a().f();
        float f2;
        if (localLocation != null) {
            f2 = (float) localLocation.getLatitude();
            f1 = (float) localLocation.getLongitude();
        }
        for (; ; ) {
            return com.flurry.android.impl.ads.avro.protocol.v10.Location.b().a(f2).b(f1).a();
            f2 = 0.0F;
        }
    }

    /* Error */
    public long o() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: invokestatic 1370	android/os/SystemClock:elapsedRealtime	()J
        //   5: aload_0
        //   6: getfield 1011	com/flurry/android/impl/ads/FlurryAdModule:d	J
        //   9: lsub
        //   10: lstore_1
        //   11: lload_1
        //   12: aload_0
        //   13: getfield 1013	com/flurry/android/impl/ads/FlurryAdModule:e	J
        //   16: lcmp
        //   17: ifle +17 -> 34
        //   20: aload_0
        //   21: lload_1
        //   22: putfield 1013	com/flurry/android/impl/ads/FlurryAdModule:e	J
        //   25: aload_0
        //   26: getfield 1013	com/flurry/android/impl/ads/FlurryAdModule:e	J
        //   29: lstore_1
        //   30: aload_0
        //   31: monitorexit
        //   32: lload_1
        //   33: lreturn
        //   34: aload_0
        //   35: getfield 1013	com/flurry/android/impl/ads/FlurryAdModule:e	J
        //   38: lconst_1
        //   39: ladd
        //   40: lstore_1
        //   41: aload_0
        //   42: lload_1
        //   43: putfield 1013	com/flurry/android/impl/ads/FlurryAdModule:e	J
        //   46: goto -26 -> 20
        //   49: astore_3
        //   50: aload_0
        //   51: monitorexit
        //   52: aload_3
        //   53: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	54	0	this	FlurryAdModule
        //   10	33	1	l1	long
        //   49	4	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	20	49	finally
        //   20	30	49	finally
        //   34	46	49	finally
    }

    public void p() {
        eo.a(3, q, "========== PRINT COUNTERS ==========");
        synchronized (this.b) {
            Iterator localIterator = this.b.entrySet().iterator();
            if (localIterator.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator.next();
                eo.a(3, q, (String) localEntry.getKey() + " " + localEntry.getValue());
            }
        }
        eo.a(3, q, "========== END PRINT COUNTERS ==========");
    }

    public ICustomAdNetworkHandler q() {
        return this.h;
    }

    public boolean r() {
        return this.o != null;
    }

    public Map<CharSequence, CharSequence> s() {
        HashMap localHashMap = new HashMap();
        Iterator localIterator = this.o.entrySet().iterator();
        while (localIterator.hasNext()) {
            Object localObject1 = (Map.Entry) localIterator.next();
            Object localObject2 = (String) ((Map.Entry) localObject1).getKey();
            String str = (String) ((Map.Entry) localObject1).getValue();
            localObject1 = localObject2;
            if (localObject2 == null) {
                localObject1 = "";
            }
            localObject2 = str;
            if (str == null) {
                localObject2 = "";
            }
            localHashMap.put(localObject1, localObject2);
        }
        return localHashMap;
    }

    String t() {
        return ".flurryadlog." + Integer.toString(j().hashCode(), 16);
    }

    String u() {
        return ".flurryfreqcap." + Integer.toString(j().hashCode(), 16);
    }

    String v() {
        return ".flurrycachedasset." + Integer.toString(j().hashCode(), 16);
    }

    public String w() {
        if (this.x != null) {
            return this.x + "/v10/getAds.do";
        }
        if (FlurryAgent.getUseHttps()) {
            return "https://ads.flurry.com/v10/getAds.do";
        }
        return "http://ads.flurry.com/v10/getAds.do";
    }

    String x() {
        if (this.y != null) {
            return this.y;
        }
        if (FlurryAgent.getUseHttps()) {
            return "https://adlog.flurry.com";
        }
        return "http://adlog.flurry.com";
    }

    public void y() {
        this.a.clear();
    }

    public Map<String, String> z() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/impl/ads/FlurryAdModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */