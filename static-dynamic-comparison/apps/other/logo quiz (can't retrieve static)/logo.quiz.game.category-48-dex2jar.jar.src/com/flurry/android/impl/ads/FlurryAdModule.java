package com.flurry.android.impl.ads;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryAgent;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.android.ICustomAdNetworkHandler;
import com.flurry.android.impl.ads.avro.protocol.v6.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v6.AdReportedId;
import com.flurry.android.impl.ads.avro.protocol.v6.AdReportedId.Builder;
import com.flurry.android.impl.ads.avro.protocol.v6.AdRequest;
import com.flurry.android.impl.ads.avro.protocol.v6.AdRequest.Builder;
import com.flurry.android.impl.ads.avro.protocol.v6.AdResponse;
import com.flurry.android.impl.ads.avro.protocol.v6.AdSpaceLayout;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import com.flurry.android.impl.ads.avro.protocol.v6.AdViewContainer;
import com.flurry.android.impl.ads.avro.protocol.v6.AdViewContainer.Builder;
import com.flurry.android.impl.ads.avro.protocol.v6.Callback;
import com.flurry.android.impl.ads.avro.protocol.v6.FrequencyCapInfo;
import com.flurry.android.impl.ads.avro.protocol.v6.FrequencyCapInfo.Builder;
import com.flurry.android.impl.ads.avro.protocol.v6.Location.Builder;
import com.flurry.android.impl.ads.avro.protocol.v6.SdkLogRequest;
import com.flurry.android.impl.ads.avro.protocol.v6.SdkLogRequest.Builder;
import com.flurry.android.impl.ads.avro.protocol.v6.SdkLogResponse;
import com.flurry.android.impl.ads.avro.protocol.v6.TestAds;
import com.flurry.android.impl.ads.avro.protocol.v6.TestAds.Builder;
import com.flurry.android.monolithic.sdk.impl.ab;
import com.flurry.android.monolithic.sdk.impl.ac;
import com.flurry.android.monolithic.sdk.impl.ae;
import com.flurry.android.monolithic.sdk.impl.af;
import com.flurry.android.monolithic.sdk.impl.am;
import com.flurry.android.monolithic.sdk.impl.an;
import com.flurry.android.monolithic.sdk.impl.ay;
import com.flurry.android.monolithic.sdk.impl.bb;
import com.flurry.android.monolithic.sdk.impl.be;
import com.flurry.android.monolithic.sdk.impl.bh;
import com.flurry.android.monolithic.sdk.impl.bi;
import com.flurry.android.monolithic.sdk.impl.bn;
import com.flurry.android.monolithic.sdk.impl.bo;
import com.flurry.android.monolithic.sdk.impl.bp;
import com.flurry.android.monolithic.sdk.impl.bt;
import com.flurry.android.monolithic.sdk.impl.bv;
import com.flurry.android.monolithic.sdk.impl.bw;
import com.flurry.android.monolithic.sdk.impl.cd;
import com.flurry.android.monolithic.sdk.impl.ce;
import com.flurry.android.monolithic.sdk.impl.ch;
import com.flurry.android.monolithic.sdk.impl.ci;
import com.flurry.android.monolithic.sdk.impl.cj;
import com.flurry.android.monolithic.sdk.impl.cl;
import com.flurry.android.monolithic.sdk.impl.cm;
import com.flurry.android.monolithic.sdk.impl.co;
import com.flurry.android.monolithic.sdk.impl.eg;
import com.flurry.android.monolithic.sdk.impl.i;
import com.flurry.android.monolithic.sdk.impl.ia;
import com.flurry.android.monolithic.sdk.impl.ie;
import com.flurry.android.monolithic.sdk.impl.ih;
import com.flurry.android.monolithic.sdk.impl.im;
import com.flurry.android.monolithic.sdk.impl.in;
import com.flurry.android.monolithic.sdk.impl.ja;
import com.flurry.android.monolithic.sdk.impl.jb;
import com.flurry.android.monolithic.sdk.impl.jc;
import com.flurry.android.monolithic.sdk.impl.jd;
import com.flurry.android.monolithic.sdk.impl.je;
import com.flurry.android.monolithic.sdk.impl.jf;
import com.flurry.android.monolithic.sdk.impl.k;
import com.flurry.android.monolithic.sdk.impl.m;
import com.flurry.android.monolithic.sdk.impl.o;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FlurryAdModule
  implements cj, ih, jb
{
  private static FlurryAdModule P;
  private static List<Integer> r;
  private static ae s;
  private static final String t = FlurryAdModule.class.getSimpleName();
  private byte[] A = null;
  private boolean B = false;
  private volatile String C = null;
  private volatile String D = null;
  private m E;
  private AdUnit F;
  private final am G;
  private final co H;
  private WeakReference<FlurryAdListener> I = new WeakReference(null);
  private CharSequence J;
  private final List<Activity> K;
  private AdUnit L;
  private cl M;
  private final Map<String, String> N;
  private final Set<String> O;
  private boolean Q;
  private ch R;
  private Map<ie, ByteBuffer> S = new HashMap();
  private bv T;
  private bi U;
  private bw V;
  public volatile com.flurry.android.impl.ads.avro.protocol.v6.Location a;
  volatile Map<String, String> b;
  long c;
  long d;
  long e;
  public String f;
  Handler g;
  ExecutorService h;
  ce i;
  public ICustomAdNetworkHandler j;
  int k;
  volatile List<m> l;
  volatile Map<String, m> m;
  volatile List<m> n;
  volatile List<String> o;
  volatile boolean p;
  Map<String, String> q;
  private boolean u = false;
  private boolean v = false;
  private File w = null;
  private File x = null;
  private String y;
  private String z;
  
  public FlurryAdModule()
  {
    jc.a().a(this);
    this.i = ce.a();
    this.T = new bv();
    this.V = new bw(this);
    this.l = new CopyOnWriteArrayList();
    this.m = new HashMap();
    this.n = new ArrayList();
    this.o = new ArrayList();
    this.p = false;
    Object localObject = new HashMap();
    ((Map)localObject).put("open", "directOpen");
    ((Map)localObject).put("expand", "doExpand");
    ((Map)localObject).put("collapse", "doCollapse");
    this.N = Collections.unmodifiableMap((Map)localObject);
    localObject = new HashSet();
    ((Set)localObject).addAll(Arrays.asList(new String[] { "notifyUser", "nextFrame", "closeAd", "expandAd", "collapseAd", "verifyURL" }));
    this.O = Collections.unmodifiableSet((Set)localObject);
    localObject = new HandlerThread("FlurryAdThread");
    ((HandlerThread)localObject).start();
    this.g = new Handler(((HandlerThread)localObject).getLooper());
    this.h = Executors.newSingleThreadExecutor();
    this.U = new bi(this);
    r = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) });
    s = new ae(this);
    this.y = Build.VERSION.RELEASE;
    this.z = Build.DEVICE;
    this.b = new HashMap();
    this.G = new bb();
    this.H = new be();
    this.K = new ArrayList();
  }
  
  private com.flurry.android.impl.ads.avro.protocol.v6.Location M()
  {
    float f1 = 0.0F;
    Object localObject = this.a;
    if (localObject != null) {
      return (com.flurry.android.impl.ads.avro.protocol.v6.Location)localObject;
    }
    localObject = in.a().e();
    float f2;
    if (localObject != null)
    {
      f2 = (float)((android.location.Location)localObject).getLatitude();
      f1 = (float)((android.location.Location)localObject).getLongitude();
    }
    for (;;)
    {
      return com.flurry.android.impl.ads.avro.protocol.v6.Location.b().a(f2).b(f1).a();
      f2 = 0.0F;
    }
  }
  
  private jd N()
  {
    return jc.a().e();
  }
  
  private void c(String paramString)
  {
    long l1 = Thread.currentThread().getId();
    Thread.currentThread().setName(paramString + " , id = " + l1);
  }
  
  public static boolean e()
  {
    return ((KeyguardManager)ia.a().b().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public static FlurryAdModule getInstance()
  {
    try
    {
      if (P == null) {
        P = new FlurryAdModule();
      }
      FlurryAdModule localFlurryAdModule = P;
      return localFlurryAdModule;
    }
    finally {}
  }
  
  List<FrequencyCapInfo> A()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.i.c().iterator();
    while (localIterator.hasNext())
    {
      cd localcd = (cd)localIterator.next();
      localArrayList.add(FrequencyCapInfo.b().a(localcd.b()).b(localcd.h()).b(localcd.e()).c(localcd.f()).d(localcd.g()).a(localcd.i()).a(localcd.c()).a());
    }
    return localArrayList;
  }
  
  /* Error */
  public void B()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 112	com/flurry/android/impl/ads/FlurryAdModule:w	Ljava/io/File;
    //   9: invokestatic 484	com/flurry/android/monolithic/sdk/impl/iw:a	(Ljava/io/File;)Z
    //   12: istore_1
    //   13: iload_1
    //   14: ifne +10 -> 24
    //   17: aconst_null
    //   18: invokestatic 489	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: new 491	java/io/DataOutputStream
    //   27: dup
    //   28: new 493	java/io/FileOutputStream
    //   31: dup
    //   32: aload_0
    //   33: getfield 112	com/flurry/android/impl/ads/FlurryAdModule:w	Ljava/io/File;
    //   36: invokespecial 496	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: invokespecial 499	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   42: astore_3
    //   43: aload_3
    //   44: astore_2
    //   45: aload_0
    //   46: getfield 166	com/flurry/android/impl/ads/FlurryAdModule:l	Ljava/util/List;
    //   49: astore 4
    //   51: aload_3
    //   52: astore_2
    //   53: aload 4
    //   55: monitorenter
    //   56: aload_0
    //   57: getfield 166	com/flurry/android/impl/ads/FlurryAdModule:l	Ljava/util/List;
    //   60: aload_3
    //   61: invokestatic 504	com/flurry/android/monolithic/sdk/impl/l:a	(Ljava/util/List;Ljava/io/DataOutput;)V
    //   64: aload 4
    //   66: monitorexit
    //   67: aload_3
    //   68: invokestatic 489	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   71: goto -50 -> 21
    //   74: astore_2
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    //   79: astore 5
    //   81: aload 4
    //   83: monitorexit
    //   84: aload_3
    //   85: astore_2
    //   86: aload 5
    //   88: athrow
    //   89: astore 4
    //   91: aload_3
    //   92: astore_2
    //   93: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   96: ldc_w 506
    //   99: aload 4
    //   101: invokestatic 511	com/flurry/android/monolithic/sdk/impl/ja:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   104: aload_3
    //   105: invokestatic 489	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   108: goto -87 -> 21
    //   111: aload_3
    //   112: invokestatic 489	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   115: aload_2
    //   116: athrow
    //   117: astore 4
    //   119: aload_2
    //   120: astore_3
    //   121: aload 4
    //   123: astore_2
    //   124: goto -13 -> 111
    //   127: astore 4
    //   129: aconst_null
    //   130: astore_3
    //   131: goto -40 -> 91
    //   134: astore_2
    //   135: aload 4
    //   137: astore_3
    //   138: goto -27 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	FlurryAdModule
    //   12	2	1	bool	boolean
    //   44	9	2	localObject1	Object
    //   74	4	2	localObject2	Object
    //   85	39	2	localObject3	Object
    //   134	1	2	localObject4	Object
    //   42	96	3	localObject5	Object
    //   3	79	4	localList	List
    //   89	11	4	localThrowable1	Throwable
    //   117	5	4	localObject6	Object
    //   127	9	4	localThrowable2	Throwable
    //   79	8	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   17	21	74	finally
    //   67	71	74	finally
    //   104	108	74	finally
    //   111	117	74	finally
    //   56	67	79	finally
    //   81	84	79	finally
    //   45	51	89	java/lang/Throwable
    //   53	56	89	java/lang/Throwable
    //   86	89	89	java/lang/Throwable
    //   45	51	117	finally
    //   53	56	117	finally
    //   86	89	117	finally
    //   93	104	117	finally
    //   5	13	127	java/lang/Throwable
    //   24	43	127	java/lang/Throwable
    //   5	13	134	finally
    //   24	43	134	finally
  }
  
  /* Error */
  public void C()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 112	com/flurry/android/impl/ads/FlurryAdModule:w	Ljava/io/File;
    //   6: invokevirtual 516	java/io/File:exists	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifeq +189 -> 200
    //   14: new 518	java/io/DataInputStream
    //   17: dup
    //   18: new 520	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: getfield 112	com/flurry/android/impl/ads/FlurryAdModule:w	Ljava/io/File;
    //   26: invokespecial 521	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 524	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_3
    //   33: aload_3
    //   34: astore_2
    //   35: aload_3
    //   36: invokestatic 527	com/flurry/android/monolithic/sdk/impl/l:a	(Ljava/io/DataInput;)Ljava/util/List;
    //   39: astore 5
    //   41: aload_3
    //   42: astore_2
    //   43: aload_0
    //   44: getfield 166	com/flurry/android/impl/ads/FlurryAdModule:l	Ljava/util/List;
    //   47: astore 4
    //   49: aload_3
    //   50: astore_2
    //   51: aload 4
    //   53: monitorenter
    //   54: aload_0
    //   55: getfield 166	com/flurry/android/impl/ads/FlurryAdModule:l	Ljava/util/List;
    //   58: aload 5
    //   60: invokeinterface 528 2 0
    //   65: pop
    //   66: aload 4
    //   68: monitorexit
    //   69: aload_3
    //   70: astore_2
    //   71: aload_0
    //   72: iconst_1
    //   73: putfield 108	com/flurry/android/impl/ads/FlurryAdModule:u	Z
    //   76: aload_3
    //   77: invokestatic 489	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   80: aload_0
    //   81: getfield 108	com/flurry/android/impl/ads/FlurryAdModule:u	Z
    //   84: ifne +23 -> 107
    //   87: aload_0
    //   88: getfield 112	com/flurry/android/impl/ads/FlurryAdModule:w	Ljava/io/File;
    //   91: invokevirtual 531	java/io/File:delete	()Z
    //   94: ifeq +78 -> 172
    //   97: iconst_3
    //   98: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   101: ldc_w 533
    //   104: invokestatic 536	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    //   110: astore 5
    //   112: aload 4
    //   114: monitorexit
    //   115: aload_3
    //   116: astore_2
    //   117: aload 5
    //   119: athrow
    //   120: astore 4
    //   122: aload_3
    //   123: astore_2
    //   124: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   127: ldc_w 538
    //   130: aload 4
    //   132: invokestatic 511	com/flurry/android/monolithic/sdk/impl/ja:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: aload_3
    //   136: invokestatic 489	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   139: goto -59 -> 80
    //   142: astore_2
    //   143: bipush 6
    //   145: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   148: ldc_w 540
    //   151: aload_2
    //   152: invokestatic 543	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   155: goto -48 -> 107
    //   158: astore_2
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_2
    //   162: athrow
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_2
    //   166: aload_2
    //   167: invokestatic 489	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   170: aload_3
    //   171: athrow
    //   172: bipush 6
    //   174: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   177: ldc_w 545
    //   180: invokestatic 536	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   183: goto -76 -> 107
    //   186: astore_2
    //   187: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   190: ldc_w 547
    //   193: aload_2
    //   194: invokestatic 511	com/flurry/android/monolithic/sdk/impl/ja:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   197: goto -90 -> 107
    //   200: iconst_3
    //   201: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   204: ldc_w 549
    //   207: invokestatic 536	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   210: goto -103 -> 107
    //   213: astore_3
    //   214: goto -48 -> 166
    //   217: astore 4
    //   219: aconst_null
    //   220: astore_3
    //   221: goto -99 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	FlurryAdModule
    //   9	2	1	bool	boolean
    //   34	90	2	localDataInputStream1	java.io.DataInputStream
    //   142	10	2	localThrowable1	Throwable
    //   158	4	2	localObject1	Object
    //   165	2	2	localCloseable	java.io.Closeable
    //   186	8	2	localThrowable2	Throwable
    //   32	104	3	localDataInputStream2	java.io.DataInputStream
    //   163	8	3	localObject2	Object
    //   213	1	3	localObject3	Object
    //   220	1	3	localObject4	Object
    //   47	66	4	localList1	List
    //   120	11	4	localThrowable3	Throwable
    //   217	1	4	localThrowable4	Throwable
    //   39	20	5	localList2	List
    //   110	8	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   54	69	110	finally
    //   112	115	110	finally
    //   35	41	120	java/lang/Throwable
    //   43	49	120	java/lang/Throwable
    //   51	54	120	java/lang/Throwable
    //   71	76	120	java/lang/Throwable
    //   117	120	120	java/lang/Throwable
    //   2	10	142	java/lang/Throwable
    //   76	80	142	java/lang/Throwable
    //   135	139	142	java/lang/Throwable
    //   166	172	142	java/lang/Throwable
    //   187	197	142	java/lang/Throwable
    //   200	210	142	java/lang/Throwable
    //   2	10	158	finally
    //   76	80	158	finally
    //   80	107	158	finally
    //   135	139	158	finally
    //   143	155	158	finally
    //   166	172	158	finally
    //   172	183	158	finally
    //   187	197	158	finally
    //   200	210	158	finally
    //   14	33	163	finally
    //   80	107	186	java/lang/Throwable
    //   172	183	186	java/lang/Throwable
    //   35	41	213	finally
    //   43	49	213	finally
    //   51	54	213	finally
    //   71	76	213	finally
    //   117	120	213	finally
    //   124	135	213	finally
    //   14	33	217	java/lang/Throwable
  }
  
  /* Error */
  public void D()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 149	com/flurry/android/impl/ads/FlurryAdModule:i	Lcom/flurry/android/monolithic/sdk/impl/ce;
    //   6: invokevirtual 551	com/flurry/android/monolithic/sdk/impl/ce:d	()V
    //   9: aload_0
    //   10: getfield 114	com/flurry/android/impl/ads/FlurryAdModule:x	Ljava/io/File;
    //   13: invokestatic 484	com/flurry/android/monolithic/sdk/impl/iw:a	(Ljava/io/File;)Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +10 -> 28
    //   21: aconst_null
    //   22: invokestatic 489	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: new 491	java/io/DataOutputStream
    //   31: dup
    //   32: new 493	java/io/FileOutputStream
    //   35: dup
    //   36: aload_0
    //   37: getfield 114	com/flurry/android/impl/ads/FlurryAdModule:x	Ljava/io/File;
    //   40: invokespecial 496	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   43: invokespecial 499	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   46: astore_3
    //   47: aload_3
    //   48: astore_2
    //   49: aload_0
    //   50: getfield 149	com/flurry/android/impl/ads/FlurryAdModule:i	Lcom/flurry/android/monolithic/sdk/impl/ce;
    //   53: astore 4
    //   55: aload_3
    //   56: astore_2
    //   57: aload 4
    //   59: monitorenter
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 149	com/flurry/android/impl/ads/FlurryAdModule:i	Lcom/flurry/android/monolithic/sdk/impl/ce;
    //   65: aload_3
    //   66: invokevirtual 554	com/flurry/android/impl/ads/FlurryAdModule:a	(Lcom/flurry/android/monolithic/sdk/impl/ce;Ljava/io/DataOutputStream;)V
    //   69: aload 4
    //   71: monitorexit
    //   72: aload_3
    //   73: astore_2
    //   74: aload_3
    //   75: iconst_0
    //   76: invokevirtual 558	java/io/DataOutputStream:writeShort	(I)V
    //   79: aload_3
    //   80: invokestatic 489	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   83: goto -58 -> 25
    //   86: astore_2
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    //   91: astore 5
    //   93: aload 4
    //   95: monitorexit
    //   96: aload_3
    //   97: astore_2
    //   98: aload 5
    //   100: athrow
    //   101: astore 4
    //   103: aload_3
    //   104: astore_2
    //   105: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   108: ldc_w 547
    //   111: aload 4
    //   113: invokestatic 511	com/flurry/android/monolithic/sdk/impl/ja:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   116: aload_3
    //   117: invokestatic 489	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   120: goto -95 -> 25
    //   123: aload_2
    //   124: invokestatic 489	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   127: aload_3
    //   128: athrow
    //   129: astore_3
    //   130: goto -7 -> 123
    //   133: astore 4
    //   135: aconst_null
    //   136: astore_3
    //   137: goto -34 -> 103
    //   140: astore_3
    //   141: aconst_null
    //   142: astore_2
    //   143: goto -20 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	FlurryAdModule
    //   16	2	1	bool	boolean
    //   48	26	2	localDataOutputStream1	DataOutputStream
    //   86	4	2	localObject1	Object
    //   97	46	2	localDataOutputStream2	DataOutputStream
    //   46	82	3	localDataOutputStream3	DataOutputStream
    //   129	1	3	localObject2	Object
    //   136	1	3	localObject3	Object
    //   140	1	3	localObject4	Object
    //   53	41	4	localce	ce
    //   101	11	4	localThrowable1	Throwable
    //   133	1	4	localThrowable2	Throwable
    //   91	8	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	86	finally
    //   21	25	86	finally
    //   79	83	86	finally
    //   116	120	86	finally
    //   123	129	86	finally
    //   60	72	91	finally
    //   93	96	91	finally
    //   49	55	101	java/lang/Throwable
    //   57	60	101	java/lang/Throwable
    //   74	79	101	java/lang/Throwable
    //   98	101	101	java/lang/Throwable
    //   49	55	129	finally
    //   57	60	129	finally
    //   74	79	129	finally
    //   98	101	129	finally
    //   105	116	129	finally
    //   9	17	133	java/lang/Throwable
    //   28	47	133	java/lang/Throwable
    //   9	17	140	finally
    //   28	47	140	finally
  }
  
  /* Error */
  public void E()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   5: ldc_w 560
    //   8: invokestatic 563	com/flurry/android/monolithic/sdk/impl/ja:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 114	com/flurry/android/impl/ads/FlurryAdModule:x	Ljava/io/File;
    //   15: invokevirtual 516	java/io/File:exists	()Z
    //   18: istore_1
    //   19: iload_1
    //   20: ifeq +161 -> 181
    //   23: aconst_null
    //   24: astore_2
    //   25: new 518	java/io/DataInputStream
    //   28: dup
    //   29: new 520	java/io/FileInputStream
    //   32: dup
    //   33: aload_0
    //   34: getfield 114	com/flurry/android/impl/ads/FlurryAdModule:x	Ljava/io/File;
    //   37: invokespecial 521	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   40: invokespecial 524	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_3
    //   44: aload_3
    //   45: astore_2
    //   46: aload_0
    //   47: aload_3
    //   48: invokevirtual 566	com/flurry/android/impl/ads/FlurryAdModule:a	(Ljava/io/DataInputStream;)V
    //   51: aload_3
    //   52: invokestatic 489	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   55: aload_0
    //   56: getfield 110	com/flurry/android/impl/ads/FlurryAdModule:v	Z
    //   59: ifne +112 -> 171
    //   62: aload_0
    //   63: getfield 114	com/flurry/android/impl/ads/FlurryAdModule:x	Ljava/io/File;
    //   66: invokevirtual 531	java/io/File:delete	()Z
    //   69: ifeq +74 -> 143
    //   72: iconst_3
    //   73: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   76: ldc_w 568
    //   79: invokestatic 536	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: astore 4
    //   87: aconst_null
    //   88: astore_3
    //   89: aload_3
    //   90: astore_2
    //   91: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   94: ldc_w 570
    //   97: aload 4
    //   99: invokestatic 511	com/flurry/android/monolithic/sdk/impl/ja:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: aload_3
    //   103: invokestatic 489	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   106: goto -51 -> 55
    //   109: astore_2
    //   110: bipush 6
    //   112: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   115: ldc_w 572
    //   118: aload_2
    //   119: invokestatic 543	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   122: goto -40 -> 82
    //   125: astore_2
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_2
    //   129: athrow
    //   130: astore 4
    //   132: aload_2
    //   133: astore_3
    //   134: aload 4
    //   136: astore_2
    //   137: aload_3
    //   138: invokestatic 489	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   141: aload_2
    //   142: athrow
    //   143: bipush 6
    //   145: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   148: ldc_w 574
    //   151: invokestatic 536	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   154: goto -72 -> 82
    //   157: astore_2
    //   158: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   161: ldc_w 547
    //   164: aload_2
    //   165: invokestatic 511	com/flurry/android/monolithic/sdk/impl/ja:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   168: goto -86 -> 82
    //   171: aload_0
    //   172: getfield 149	com/flurry/android/impl/ads/FlurryAdModule:i	Lcom/flurry/android/monolithic/sdk/impl/ce;
    //   175: invokevirtual 551	com/flurry/android/monolithic/sdk/impl/ce:d	()V
    //   178: goto -96 -> 82
    //   181: iconst_3
    //   182: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   185: ldc_w 576
    //   188: invokestatic 536	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   191: goto -109 -> 82
    //   194: astore 4
    //   196: aload_2
    //   197: astore_3
    //   198: aload 4
    //   200: astore_2
    //   201: goto -64 -> 137
    //   204: astore 4
    //   206: goto -117 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	FlurryAdModule
    //   18	2	1	bool	boolean
    //   24	67	2	localObject1	Object
    //   109	10	2	localThrowable1	Throwable
    //   125	8	2	localObject2	Object
    //   136	6	2	localObject3	Object
    //   157	40	2	localThrowable2	Throwable
    //   200	1	2	localObject4	Object
    //   43	155	3	localObject5	Object
    //   85	13	4	localThrowable3	Throwable
    //   130	5	4	localObject6	Object
    //   194	5	4	localObject7	Object
    //   204	1	4	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   25	44	85	java/lang/Throwable
    //   11	19	109	java/lang/Throwable
    //   51	55	109	java/lang/Throwable
    //   102	106	109	java/lang/Throwable
    //   137	143	109	java/lang/Throwable
    //   158	168	109	java/lang/Throwable
    //   181	191	109	java/lang/Throwable
    //   2	11	125	finally
    //   11	19	125	finally
    //   51	55	125	finally
    //   55	82	125	finally
    //   102	106	125	finally
    //   110	122	125	finally
    //   137	143	125	finally
    //   143	154	125	finally
    //   158	168	125	finally
    //   171	178	125	finally
    //   181	191	125	finally
    //   25	44	130	finally
    //   55	82	157	java/lang/Throwable
    //   143	154	157	java/lang/Throwable
    //   171	178	157	java/lang/Throwable
    //   46	51	194	finally
    //   91	102	194	finally
    //   46	51	204	java/lang/Throwable
  }
  
  public m F()
  {
    return a(ab.a(this, null), "unfilled", true, null);
  }
  
  public m G()
  {
    return this.E;
  }
  
  public AdUnit H()
  {
    return this.F;
  }
  
  public boolean I()
  {
    return jc.a().c();
  }
  
  public void J()
  {
    this.M = null;
  }
  
  public FlurryAdListener K()
  {
    return (FlurryAdListener)this.I.get();
  }
  
  Intent a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (Intent)paramIntent.getParcelableExtra("targetIntent");
  }
  
  AdRequest a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, FlurryAdSize paramFlurryAdSize)
  {
    Object localObject = z();
    List localList = A();
    ArrayList localArrayList = new ArrayList();
    if ((this.J != null) && (this.J.length() > 0))
    {
      localArrayList.add("FLURRY_VIEWER");
      localArrayList.add(this.J);
    }
    localObject = AdRequest.b().a(f()).c("").b(r).a((List)localObject).a(M()).a(this.p).b(Integer.toString(FlurryAgent.getAgentVersion())).a(this.c).a(AdViewContainer.b().d(paramInt4).c(paramInt3).b(paramInt2).a(paramInt1).a(je.a()).a()).d(g()).e(h()).f(this.y).g(this.z).b(false).a(N().a()).c(localList).h(Locale.getDefault().getLanguage()).d(localArrayList).a();
    if (paramBoolean) {
      ((AdRequest)localObject).a(Boolean.valueOf(paramBoolean));
    }
    for (;;)
    {
      if (paramFlurryAdSize != null) {
        ((AdRequest)localObject).a(TestAds.b().a(paramFlurryAdSize.getValue()).a());
      }
      if (this.q != null) {
        ((AdRequest)localObject).a(n());
      }
      ja.a(3, t, "Got ad request: " + localObject);
      return (AdRequest)localObject;
      ((AdRequest)localObject).a(paramString);
    }
  }
  
  public an a(Context paramContext, ViewGroup paramViewGroup, String paramString)
  {
    return this.V.a(this, paramContext, paramViewGroup, paramString);
  }
  
  public bi a()
  {
    return this.U;
  }
  
  public cl a(Context paramContext, AdUnit paramAdUnit)
  {
    this.L = paramAdUnit;
    if (paramAdUnit == null) {
      return null;
    }
    Object localObject = paramAdUnit.d();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return null;
    }
    AdFrame localAdFrame = (AdFrame)((List)localObject).get(0);
    int i1 = localAdFrame.b().intValue();
    String str1 = localAdFrame.d().toString();
    String str2 = localAdFrame.e().e().toString();
    String str3 = localAdFrame.g().toString();
    localObject = (m)this.m.get(str3);
    if (localObject == null) {
      localObject = ab.a(this, str3);
    }
    for (;;)
    {
      a(new bh("filled", Collections.emptyMap(), paramContext, paramAdUnit, (m)localObject, 0), this.U, 1);
      return a(paramContext, paramAdUnit, i1, str1, str2, (m)localObject, localAdFrame);
    }
  }
  
  cl a(Context paramContext, AdUnit paramAdUnit, int paramInt, String paramString1, String paramString2, m paramm, AdFrame paramAdFrame)
  {
    paramAdFrame = ab.a(paramAdFrame.e());
    if ((this.L == null) || (this.L != paramAdUnit)) {
      return this.M;
    }
    this.M = null;
    ICustomAdNetworkHandler localICustomAdNetworkHandler = k();
    if ((paramInt == 4) && (localICustomAdNetworkHandler != null))
    {
      paramAdFrame = localICustomAdNetworkHandler.getAdFromNetwork(paramContext, paramAdFrame, paramString1);
      if (paramAdFrame != null)
      {
        paramAdFrame.setPlatformModule(this);
        paramAdFrame.setAdLog(paramm);
        paramAdFrame.setAdFrameIndex(0);
        paramAdFrame.setAdUnit(paramAdUnit);
        this.M = new af(paramAdFrame, paramAdUnit);
      }
    }
    for (;;)
    {
      return this.M;
      if (paramString2.equals("takeover"))
      {
        b(paramm);
        a(paramAdUnit);
        paramContext = this.H.a_(paramContext, this, paramm, paramAdUnit);
        if (paramContext != null)
        {
          ja.a(3, t, "prepareAd:first frame of AdUnit is a takeover");
          this.M = new cm(paramContext, paramAdUnit);
        }
      }
      else
      {
        paramString2 = this.G.a(paramContext, this, paramm, paramAdUnit);
        if (paramString2 != null)
        {
          ja.a(3, t, "prepareAd: first frame of AdUnit is a banner");
          this.M = new af(paramString2, paramAdUnit);
        }
        else
        {
          ja.e(t, "Failed to create view for ad network: " + paramString1 + ", network is unsupported on Android, or no ICustomAdNetworkHandler was registered or it failed to return a view.");
          a(new bh("renderFailed", Collections.emptyMap(), paramContext, paramAdUnit, paramm, 0), this.U, 1);
        }
      }
    }
  }
  
  k a(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    try
    {
      paramString = new k(paramString, paramBoolean, i(), paramMap);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public m a(m paramm, String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_3
    //   3: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   6: new 366	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 921
    //   16: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_1
    //   20: invokevirtual 778	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   23: ldc_w 923
    //   26: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_2
    //   30: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 923
    //   36: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload_3
    //   40: invokevirtual 926	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   43: ldc_w 923
    //   46: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload 4
    //   51: invokevirtual 778	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: ldc_w 928
    //   57: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 379	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 536	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   66: aload_1
    //   67: monitorenter
    //   68: aload_0
    //   69: getfield 166	com/flurry/android/impl/ads/FlurryAdModule:l	Ljava/util/List;
    //   72: aload_1
    //   73: invokeinterface 931 2 0
    //   78: ifne +41 -> 119
    //   81: aload_0
    //   82: getfield 166	com/flurry/android/impl/ads/FlurryAdModule:l	Ljava/util/List;
    //   85: aload_1
    //   86: invokeinterface 475 2 0
    //   91: pop
    //   92: iconst_3
    //   93: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   96: new 366	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   103: ldc_w 933
    //   106: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: invokevirtual 778	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 379	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 536	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   119: aload_1
    //   120: aload_0
    //   121: aload_2
    //   122: iload_3
    //   123: aload 4
    //   125: invokevirtual 935	com/flurry/android/impl/ads/FlurryAdModule:a	(Ljava/lang/String;ZLjava/util/Map;)Lcom/flurry/android/monolithic/sdk/impl/k;
    //   128: invokevirtual 938	com/flurry/android/monolithic/sdk/impl/m:a	(Lcom/flurry/android/monolithic/sdk/impl/k;)V
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
    //   0	147	1	paramm	m
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
  
  public List<i> a(AdFrame paramAdFrame, bh parambh)
  {
    ArrayList localArrayList = new ArrayList();
    paramAdFrame = paramAdFrame.f();
    String str3 = parambh.a;
    Iterator localIterator1 = paramAdFrame.iterator();
    while (localIterator1.hasNext())
    {
      paramAdFrame = (Callback)localIterator1.next();
      if (paramAdFrame.b().toString().equals(str3))
      {
        Iterator localIterator2 = paramAdFrame.c().iterator();
        while (localIterator2.hasNext())
        {
          paramAdFrame = (CharSequence)localIterator2.next();
          HashMap localHashMap = new HashMap();
          String str2 = paramAdFrame.toString();
          int i1 = str2.indexOf('?');
          paramAdFrame = str2;
          if (i1 != -1)
          {
            String str1 = str2.substring(0, i1);
            str2 = str2.substring(i1 + 1);
            paramAdFrame = str2;
            if (str2.contains("%{eventParams}"))
            {
              paramAdFrame = str2.replace("%{eventParams}", "");
              localHashMap.putAll(parambh.b);
            }
            localHashMap.putAll(je.f(paramAdFrame));
            paramAdFrame = str1;
          }
          localArrayList.add(new i(paramAdFrame, localHashMap, parambh));
        }
      }
    }
    return localArrayList;
  }
  
  public List<AdUnit> a(String paramString, ViewGroup paramViewGroup, boolean paramBoolean, FlurryAdSize paramFlurryAdSize)
  {
    this.i.d();
    if (Build.VERSION.SDK_INT >= 9)
    {
      Pair localPair = je.h();
      int i6 = ((Integer)localPair.first).intValue();
      int i7 = ((Integer)localPair.second).intValue();
      localPair = je.g();
      int i5 = ((Integer)localPair.first).intValue();
      int i3 = ((Integer)localPair.second).intValue();
      int i4;
      int i2;
      if (!paramFlurryAdSize.equals(FlurryAdSize.BANNER_BOTTOM))
      {
        i4 = i5;
        i2 = i3;
        if (!paramFlurryAdSize.equals(FlurryAdSize.BANNER_TOP)) {}
      }
      else
      {
        int i1 = i3;
        if (paramViewGroup != null)
        {
          i1 = i3;
          if (paramViewGroup.getHeight() > 0) {
            i1 = je.a(paramViewGroup.getHeight());
          }
        }
        i4 = i5;
        i2 = i1;
        if (paramViewGroup != null)
        {
          i4 = i5;
          i2 = i1;
          if (paramViewGroup.getWidth() > 0)
          {
            i4 = je.a(paramViewGroup.getWidth());
            i2 = i1;
          }
        }
      }
      paramViewGroup = a(paramString, i4, i2, i6, i7, paramBoolean, paramFlurryAdSize);
      paramViewGroup = this.T.a(paramViewGroup, q());
      if (paramViewGroup == null) {
        return Collections.emptyList();
      }
      ja.a(3, t, "Got ad response: " + paramViewGroup);
      if (paramViewGroup.c().size() > 0)
      {
        ja.b(t, "Ad server responded with the following error(s):");
        paramString = paramViewGroup.c().iterator();
        while (paramString.hasNext())
        {
          paramViewGroup = (CharSequence)paramString.next();
          ja.b(t, paramViewGroup.toString());
        }
        return Collections.emptyList();
      }
      if ((!TextUtils.isEmpty(paramString)) && ((paramViewGroup.b() == null) || (paramViewGroup.b().size() == 0)))
      {
        ja.b(t, "Ad server responded but sent no ad units.");
        return Collections.emptyList();
      }
      return paramViewGroup.b();
    }
    return Collections.emptyList();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.a = com.flurry.android.impl.ads.avro.protocol.v6.Location.b().a(paramFloat1).b(paramFloat2).a();
  }
  
  void a(Activity paramActivity)
  {
    int i2 = 1;
    Activity localActivity;
    AdUnit localAdUnit;
    int i1;
    if (1 == this.K.size())
    {
      localActivity = (Activity)this.K.get(0);
      if (!(localActivity instanceof FlurryFullscreenTakeoverActivity)) {
        break label141;
      }
      Object localObject = (FlurryFullscreenTakeoverActivity)localActivity;
      localAdUnit = ((FlurryFullscreenTakeoverActivity)localObject).getAdUnit();
      localObject = ((FlurryFullscreenTakeoverActivity)localObject).getAdUnityView();
      if (localObject == null) {
        break label136;
      }
      i1 = ((o)localObject).getAdFrameIndex();
    }
    for (;;)
    {
      if ((localAdUnit != null) && ((localAdUnit.e().intValue() != 1) || (i1 > 0)))
      {
        i1 = i2;
        if (paramActivity != null)
        {
          i1 = i2;
          if ((paramActivity instanceof FlurryFullscreenTakeoverActivity)) {
            if (((FlurryFullscreenTakeoverActivity)paramActivity).getResult() == ay.b) {
              break label131;
            }
          }
        }
      }
      label131:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          localActivity.finish();
        }
        return;
      }
      label136:
      i1 = 0;
      continue;
      label141:
      localAdUnit = null;
      i1 = 0;
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    if (paramActivity == null) {}
    do
    {
      Intent localIntent;
      do
      {
        return;
        this.K.add(paramActivity);
        localIntent = paramActivity.getIntent();
        paramBundle = b(localIntent);
        a(paramActivity, paramBundle);
      } while (a(localIntent) == null);
      paramActivity = (FlurryAdListener)this.I.get();
    } while (paramActivity == null);
    paramActivity.onApplicationExit(paramBundle);
  }
  
  public void a(Context paramContext)
  {
    try
    {
      if (!this.Q)
      {
        this.w = paramContext.getFileStreamPath(o());
        this.x = paramContext.getFileStreamPath(p());
        this.U.a();
        this.A = im.a();
        b(new bn(this));
        this.Q = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void a(Context paramContext, long paramLong1, long paramLong2)
  {
    this.R = new ch();
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = 0L;
    this.B = false;
  }
  
  public void a(Context paramContext, AdUnit paramAdUnit, cl paramcl)
  {
    paramAdUnit = (m)this.m.get(((AdFrame)paramAdUnit.d().get(0)).g().toString());
    a(new bh("requested", Collections.emptyMap(), paramContext, paramcl.b(), paramAdUnit, 0), this.U, 0);
  }
  
  public void a(Context paramContext, String paramString)
  {
    this.k += 1;
    if (1 == this.k)
    {
      paramContext = (FlurryAdListener)this.I.get();
      if (paramContext != null) {
        paramContext.onAdOpened(paramString);
      }
    }
  }
  
  public void a(FlurryAdListener paramFlurryAdListener)
  {
    this.I = new WeakReference(paramFlurryAdListener);
  }
  
  public void a(ICustomAdNetworkHandler paramICustomAdNetworkHandler)
  {
    this.j = paramICustomAdNetworkHandler;
  }
  
  public void a(AdUnit paramAdUnit)
  {
    this.F = paramAdUnit;
  }
  
  void a(SdkLogResponse paramSdkLogResponse)
  {
    try
    {
      if (paramSdkLogResponse.b().toString().equals("success"))
      {
        this.l.removeAll(this.n);
        ja.a(3, t, "removed reported AdLogs");
      }
      return;
    }
    finally
    {
      paramSdkLogResponse = finally;
      throw paramSdkLogResponse;
    }
  }
  
  public void a(bh parambh, ci paramci, int paramInt)
  {
    ja.a(3, t, "onEvent:event=" + parambh.a + ",params=" + parambh.b);
    Object localObject2 = a(parambh.a(), parambh);
    Object localObject1;
    Object localObject3;
    if (((List)localObject2).isEmpty())
    {
      localObject1 = this.N.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        if (((String)((Map.Entry)localObject3).getKey()).equals(parambh.a)) {
          ((List)localObject2).add(new i((String)((Map.Entry)localObject3).getValue(), parambh.b, parambh));
        }
      }
    }
    if (parambh.a.equals("adWillClose"))
    {
      localObject1 = ((List)localObject2).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject3 = (i)((Iterator)localObject1).next();
      } while (!this.O.contains(((i)localObject3).a));
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        ((List)localObject2).add(0, new i("closeAd", Collections.emptyMap(), parambh));
      }
      if (parambh.a.equals("renderFailed"))
      {
        localObject1 = (FlurryAdListener)this.I.get();
        if (localObject1 != null) {
          ((FlurryAdListener)localObject1).onRenderFailed(parambh.d.b().toString());
        }
      }
      if (parambh.a.equals("clicked"))
      {
        localObject1 = (FlurryAdListener)this.I.get();
        if (localObject1 != null) {
          ((FlurryAdListener)localObject1).onAdClicked(parambh.d.b().toString());
        }
      }
      if (parambh.a.equals("videoCompleted"))
      {
        localObject1 = (FlurryAdListener)this.I.get();
        if (localObject1 != null) {
          ((FlurryAdListener)localObject1).onVideoCompleted(parambh.d.b().toString());
        }
      }
      localObject1 = null;
      localObject3 = ((List)localObject2).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (i)((Iterator)localObject3).next();
        if (!((i)localObject2).a.equals("logEvent")) {
          break label641;
        }
        ((i)localObject2).b.put("__sendToServer", "true");
        localObject1 = localObject2;
      }
      label641:
      for (;;)
      {
        if (((i)localObject2).a.equals("loadAdComponents"))
        {
          Iterator localIterator = ((i)localObject2).c.b.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            ((i)localObject2).b.put(((String)localEntry.getKey()).toString(), ((String)localEntry.getValue()).toString());
          }
        }
        ja.d(t, ((i)localObject2).toString());
        paramci.a((i)localObject2, this, paramInt + 1);
        break;
        if (localObject1 == null)
        {
          localObject1 = new HashMap();
          ((Map)localObject1).put("__sendToServer", "false");
          parambh = new i("logEvent", (Map)localObject1, parambh);
          paramci.a(parambh, this, paramInt + 1);
          ja.d(t, parambh.toString());
        }
        return;
      }
    }
  }
  
  void a(ce paramce, DataOutputStream paramDataOutputStream)
  {
    try
    {
      paramce = paramce.c().iterator();
      while (paramce.hasNext())
      {
        cd localcd = (cd)paramce.next();
        try
        {
          paramDataOutputStream.writeShort(1);
          localcd.a(paramDataOutputStream);
        }
        catch (IOException localIOException)
        {
          ja.a(t, "unable to convert freqCap to byte[]: " + localcd.b());
        }
      }
    }
    finally {}
  }
  
  public void a(jf paramjf)
  {
    this.g.post(paramjf);
  }
  
  public void a(m paramm)
  {
    try
    {
      if (this.l.size() < 32767)
      {
        this.l.add(paramm);
        this.m.put(paramm.b(), paramm);
      }
      return;
    }
    finally
    {
      paramm = finally;
      throw paramm;
    }
  }
  
  /* Error */
  void a(java.io.DataInputStream paramDataInputStream)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 1241	java/io/DataInputStream:readShort	()S
    //   6: ifne +11 -> 17
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 110	com/flurry/android/impl/ads/FlurryAdModule:v	Z
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 149	com/flurry/android/impl/ads/FlurryAdModule:i	Lcom/flurry/android/monolithic/sdk/impl/ce;
    //   21: astore_2
    //   22: aload_2
    //   23: monitorenter
    //   24: aload_0
    //   25: getfield 149	com/flurry/android/impl/ads/FlurryAdModule:i	Lcom/flurry/android/monolithic/sdk/impl/ce;
    //   28: new 429	com/flurry/android/monolithic/sdk/impl/cd
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 1244	com/flurry/android/monolithic/sdk/impl/cd:<init>	(Ljava/io/DataInput;)V
    //   36: invokevirtual 1247	com/flurry/android/monolithic/sdk/impl/ce:a	(Lcom/flurry/android/monolithic/sdk/impl/cd;)V
    //   39: aload_2
    //   40: monitorexit
    //   41: goto -39 -> 2
    //   44: astore_1
    //   45: aload_2
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	FlurryAdModule
    //   0	54	1	paramDataInputStream	java.io.DataInputStream
    // Exception table:
    //   from	to	target	type
    //   24	41	44	finally
    //   45	47	44	finally
    //   2	14	49	finally
    //   17	24	49	finally
    //   47	49	49	finally
  }
  
  public void a(String paramString)
  {
    this.C = paramString;
  }
  
  public void a(String paramString, CharSequence paramCharSequence)
  {
    this.J = paramCharSequence;
    this.V.f(paramString);
  }
  
  public void a(List<m> paramList)
  {
    this.n = paramList;
  }
  
  public void a(Map<ie, ByteBuffer> paramMap)
  {
    this.S = paramMap;
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public bw b()
  {
    return this.V;
  }
  
  String b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return paramIntent.getStringExtra("adSpaceName");
  }
  
  public Future<?> b(jf paramjf)
  {
    return this.h.submit(paramjf);
  }
  
  public void b(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    b(paramActivity, b(paramActivity.getIntent()));
    this.K.remove(paramActivity);
    a(paramActivity);
  }
  
  public void b(Context paramContext)
  {
    this.i.d();
  }
  
  public void b(Context paramContext, String paramString)
  {
    this.k -= 1;
    if (this.k == 0)
    {
      paramContext = (FlurryAdListener)this.I.get();
      if (paramContext != null) {
        paramContext.onAdClosed(paramString);
      }
    }
  }
  
  void b(SdkLogResponse paramSdkLogResponse)
    throws IOException
  {
    ja.a(4, t, "Got ad log response: " + paramSdkLogResponse);
    if (paramSdkLogResponse.b().toString().equals("success")) {
      a(paramSdkLogResponse);
    }
    for (;;)
    {
      return;
      paramSdkLogResponse = paramSdkLogResponse.c().iterator();
      while (paramSdkLogResponse.hasNext())
      {
        CharSequence localCharSequence = (CharSequence)paramSdkLogResponse.next();
        ja.b(t, localCharSequence.toString());
      }
    }
  }
  
  public void b(m paramm)
  {
    this.E = paramm;
  }
  
  public void b(String paramString)
  {
    this.D = paramString;
  }
  
  public void b(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if ((localEntry.getKey() != null) && (localEntry.getValue() != null)) {
          this.b.put(localEntry.getKey(), localEntry.getValue());
        } else {
          ja.e(t, "User cookie keys and values may not be null.");
        }
      }
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(Context paramContext)
  {
    a(new bo(this));
    if (this.Q) {
      w();
    }
  }
  
  public void c(Map<String, String> paramMap)
  {
    this.q = paramMap;
  }
  
  public boolean c()
  {
    return this.k != 0;
  }
  
  public long d()
  {
    return this.c;
  }
  
  public void d(Context paramContext)
  {
    this.V.a(paramContext);
  }
  
  /* Error */
  public void e(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 118	com/flurry/android/impl/ads/FlurryAdModule:B	Z
    //   6: ifne +41 -> 47
    //   9: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   12: ldc_w 1300
    //   15: invokestatic 1302	com/flurry/android/monolithic/sdk/impl/ja:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: new 1304	com/flurry/android/monolithic/sdk/impl/br
    //   21: dup
    //   22: aload_0
    //   23: ldc_w 547
    //   26: aconst_null
    //   27: iconst_1
    //   28: getstatic 1003	com/flurry/android/FlurryAdSize:BANNER_BOTTOM	Lcom/flurry/android/FlurryAdSize;
    //   31: aconst_null
    //   32: invokespecial 1307	com/flurry/android/monolithic/sdk/impl/br:<init>	(Lcom/flurry/android/impl/ads/FlurryAdModule;Ljava/lang/String;Landroid/view/ViewGroup;ZLcom/flurry/android/FlurryAdSize;Lcom/flurry/android/monolithic/sdk/impl/jf;)V
    //   35: invokevirtual 1310	com/flurry/android/monolithic/sdk/impl/br:a	()Lcom/flurry/android/monolithic/sdk/impl/br;
    //   38: pop
    //   39: aload_0
    //   40: iconst_1
    //   41: putfield 118	com/flurry/android/impl/ads/FlurryAdModule:B	Z
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: getstatic 102	com/flurry/android/impl/ads/FlurryAdModule:t	Ljava/lang/String;
    //   50: ldc_w 1312
    //   53: invokestatic 1302	com/flurry/android/monolithic/sdk/impl/ja:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: goto -12 -> 44
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	FlurryAdModule
    //   0	64	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	44	59	finally
    //   47	56	59	finally
  }
  
  public String f()
  {
    return eg.a().f();
  }
  
  public void f(Context paramContext)
  {
    bt.a().f(paramContext);
  }
  
  String g()
  {
    return eg.a().g();
  }
  
  public void g(Context paramContext)
  {
    bt.a().g(paramContext);
  }
  
  String h()
  {
    return eg.a().h();
  }
  
  /* Error */
  public long i()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 1334	android/os/SystemClock:elapsedRealtime	()J
    //   5: aload_0
    //   6: getfield 1128	com/flurry/android/impl/ads/FlurryAdModule:d	J
    //   9: lsub
    //   10: lstore_1
    //   11: lload_1
    //   12: aload_0
    //   13: getfield 1130	com/flurry/android/impl/ads/FlurryAdModule:e	J
    //   16: lcmp
    //   17: ifle +17 -> 34
    //   20: aload_0
    //   21: lload_1
    //   22: putfield 1130	com/flurry/android/impl/ads/FlurryAdModule:e	J
    //   25: aload_0
    //   26: getfield 1130	com/flurry/android/impl/ads/FlurryAdModule:e	J
    //   29: lstore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: lload_1
    //   33: lreturn
    //   34: aload_0
    //   35: getfield 1130	com/flurry/android/impl/ads/FlurryAdModule:e	J
    //   38: lconst_1
    //   39: ladd
    //   40: lstore_1
    //   41: aload_0
    //   42: lload_1
    //   43: putfield 1130	com/flurry/android/impl/ads/FlurryAdModule:e	J
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
  
  public void j()
  {
    this.a = null;
  }
  
  public ICustomAdNetworkHandler k()
  {
    return this.j;
  }
  
  public String l()
  {
    return this.f;
  }
  
  public Map<ie, ByteBuffer> m()
  {
    return this.S;
  }
  
  Map<CharSequence, CharSequence> n()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.q.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      Object localObject2 = (String)((Map.Entry)localObject1).getKey();
      String str = (String)((Map.Entry)localObject1).getValue();
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
  
  String o()
  {
    return ".flurryadlog." + Integer.toString(f().hashCode(), 16);
  }
  
  String p()
  {
    return ".flurryfreqcap." + Integer.toString(f().hashCode(), 16);
  }
  
  String q()
  {
    if (this.C != null) {
      return this.C + "/v6/getAds.do";
    }
    if (FlurryAgent.getUseHttps()) {
      return "https://ads.flurry.com/v6/getAds.do";
    }
    return "http://ads.flurry.com/v6/getAds.do";
  }
  
  String r()
  {
    if (this.D != null) {
      return this.D;
    }
    if (FlurryAgent.getUseHttps()) {
      return "https://adlog.flurry.com";
    }
    return "http://adlog.flurry.com";
  }
  
  public void s()
  {
    this.b.clear();
  }
  
  public Map<String, String> t()
  {
    return this.b;
  }
  
  public void u()
  {
    this.q = null;
  }
  
  public Map<String, String> v()
  {
    Map localMap = t();
    if (this.R != null)
    {
      String str = this.R.a();
      if (!TextUtils.isEmpty(str)) {
        localMap.put("appCloudUserId", str);
      }
    }
    return localMap;
  }
  
  public void w()
  {
    try
    {
      b(new bp(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void x()
  {
    Object localObject = y();
    String str = r() + "/postAdLog.do";
    localObject = this.T.a((SdkLogRequest)localObject, str);
    if (localObject != null) {}
    try
    {
      b((SdkLogResponse)localObject);
      return;
    }
    catch (IOException localIOException)
    {
      ja.a(6, t, "Error in generateAndSendAdLogRequest: ", localIOException);
    }
  }
  
  SdkLogRequest y()
  {
    List localList1 = z();
    synchronized (this.l)
    {
      List localList2 = s.a(this.l);
      if (localList2.size() == 0)
      {
        ja.a(3, t, "List of adLogs is empty");
        return null;
      }
      ??? = SdkLogRequest.b().a(f()).a(localList1).b(localList2).a(false).a(System.currentTimeMillis()).a();
      ja.a(3, t, "Got ad log request:" + ((SdkLogRequest)???).toString());
      return (SdkLogRequest)???;
    }
  }
  
  List<AdReportedId> z()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = ByteBuffer.wrap(l().getBytes());
    localArrayList.add(AdReportedId.b().a((ByteBuffer)localObject).a(eg.i()).a());
    localObject = this.A;
    if (localObject != null)
    {
      ja.a(3, t, "Fetched hashed IMEI");
      localObject = ByteBuffer.wrap((byte[])localObject);
      localArrayList.add(AdReportedId.b().a((ByteBuffer)localObject).a(ie.b.c).a());
    }
    localObject = m().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localArrayList.add(AdReportedId.b().a((ByteBuffer)localEntry.getValue()).a(((ie)localEntry.getKey()).c).a());
    }
    return localArrayList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/impl/ads/FlurryAdModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */