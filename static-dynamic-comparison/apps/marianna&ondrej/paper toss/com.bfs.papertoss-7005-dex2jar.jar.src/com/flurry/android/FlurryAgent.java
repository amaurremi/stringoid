package com.flurry.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class FlurryAgent
  implements LocationListener
{
  static String a;
  private static final String[] b = { "9774d56d682e549c", "dead00beef" };
  private static volatile String c = null;
  private static volatile String d = null;
  private static volatile String e = "http://ad.flurry.com/getCanvas.do";
  private static volatile String f = null;
  private static volatile String g = "http://ad.flurry.com/getAndroidApp.do";
  private static final FlurryAgent h = new FlurryAgent();
  private static long i = 10000L;
  private static boolean j = true;
  private static boolean k = false;
  private static volatile String kInsecureReportUrl = "http://data.flurry.com/aap.do";
  private static volatile String kSecureReportUrl = "https://data.flurry.com/aap.do";
  private static boolean l = false;
  private static boolean m = true;
  private static Criteria n = null;
  private static boolean o = false;
  private static AppCircle p = new AppCircle();
  private boolean A = true;
  private List B;
  private LocationManager C;
  private String D;
  private boolean E;
  private long F;
  private List G = new ArrayList();
  private long H;
  private long I;
  private long J;
  private String K = "";
  private String L = "";
  private byte M = -1;
  private String N = "";
  private byte O = -1;
  private Long P;
  private int Q;
  private Location R;
  private Map S = new HashMap();
  private List T = new ArrayList();
  private boolean U;
  private int V;
  private List W = new ArrayList();
  private int X;
  private u Y = new u();
  private final Handler q;
  private File r;
  private File s = null;
  private volatile boolean t = false;
  private volatile boolean u = false;
  private long v;
  private Map w = new WeakHashMap();
  private String x;
  private String y;
  private String z;
  
  private FlurryAgent()
  {
    HandlerThread localHandlerThread = new HandlerThread("FlurryAgent");
    localHandlerThread.start();
    this.q = new Handler(localHandlerThread.getLooper());
  }
  
  private static double a(double paramDouble)
  {
    return Math.round(paramDouble * 1000.0D) / 1000.0D;
  }
  
  static View a(Context paramContext, String paramString, int paramInt)
  {
    if (!o) {
      return null;
    }
    try
    {
      paramContext = h.Y.a(paramContext, paramString, paramInt);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      ah.b("FlurryAgent", "", paramContext);
    }
    return null;
  }
  
  static Offer a(String paramString)
  {
    if (!o) {
      return null;
    }
    return h.Y.b(paramString);
  }
  
  private HttpClient a(HttpParams paramHttpParams)
  {
    try
    {
      Object localObject = KeyStore.getInstance(KeyStore.getDefaultType());
      ((KeyStore)localObject).load(null, null);
      localObject = new ai(this, (KeyStore)localObject);
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      localSchemeRegistry.register(new Scheme("https", (SocketFactory)localObject, 443));
      localObject = new DefaultHttpClient(new ThreadSafeClientConnManager(paramHttpParams, localSchemeRegistry), paramHttpParams);
      return (HttpClient)localObject;
    }
    catch (Exception localException) {}
    return new DefaultHttpClient(paramHttpParams);
  }
  
  /* Error */
  private void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: aload_1
    //   5: invokespecial 281	com/flurry/android/FlurryAgent:b	(Landroid/content/Context;)Ljava/lang/String;
    //   8: putfield 283	com/flurry/android/FlurryAgent:D	Ljava/lang/String;
    //   11: aload_0
    //   12: getfield 135	com/flurry/android/FlurryAgent:s	Ljava/io/File;
    //   15: invokevirtual 289	java/io/File:exists	()Z
    //   18: ifeq +346 -> 364
    //   21: ldc -75
    //   23: new 291	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 294
    //   33: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 135	com/flurry/android/FlurryAgent:s	Ljava/io/File;
    //   40: invokevirtual 301	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   43: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 307	com/flurry/android/ah:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   52: pop
    //   53: new 309	java/io/DataInputStream
    //   56: dup
    //   57: new 311	java/io/FileInputStream
    //   60: dup
    //   61: aload_0
    //   62: getfield 135	com/flurry/android/FlurryAgent:s	Ljava/io/File;
    //   65: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   68: invokespecial 317	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore 9
    //   73: aload 9
    //   75: astore 8
    //   77: aload 9
    //   79: invokevirtual 321	java/io/DataInputStream:readUnsignedShort	()I
    //   82: ldc_w 322
    //   85: if_icmpne +195 -> 280
    //   88: aload 9
    //   90: astore 8
    //   92: aload_0
    //   93: aload 9
    //   95: invokespecial 325	com/flurry/android/FlurryAgent:b	(Ljava/io/DataInputStream;)V
    //   98: aload 9
    //   100: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   103: aload_0
    //   104: getfield 139	com/flurry/android/FlurryAgent:u	Z
    //   107: ifne +22 -> 129
    //   110: aload_0
    //   111: getfield 135	com/flurry/android/FlurryAgent:s	Ljava/io/File;
    //   114: invokevirtual 333	java/io/File:delete	()Z
    //   117: ifeq +220 -> 337
    //   120: ldc -75
    //   122: ldc_w 335
    //   125: invokestatic 337	com/flurry/android/ah:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   128: pop
    //   129: aload_0
    //   130: getfield 139	com/flurry/android/FlurryAgent:u	Z
    //   133: ifne +21 -> 154
    //   136: aload_0
    //   137: iconst_0
    //   138: putfield 339	com/flurry/android/FlurryAgent:E	Z
    //   141: aload_0
    //   142: aload_0
    //   143: getfield 341	com/flurry/android/FlurryAgent:H	J
    //   146: putfield 343	com/flurry/android/FlurryAgent:F	J
    //   149: aload_0
    //   150: iconst_1
    //   151: putfield 139	com/flurry/android/FlurryAgent:u	Z
    //   154: aload_0
    //   155: getfield 283	com/flurry/android/FlurryAgent:D	Ljava/lang/String;
    //   158: ifnonnull +76 -> 234
    //   161: invokestatic 347	java/lang/Math:random	()D
    //   164: invokestatic 352	java/lang/Double:doubleToLongBits	(D)J
    //   167: lstore_2
    //   168: invokestatic 358	java/lang/System:nanoTime	()J
    //   171: lstore 4
    //   173: aload_0
    //   174: getfield 360	com/flurry/android/FlurryAgent:x	Ljava/lang/String;
    //   177: invokevirtual 363	java/lang/String:hashCode	()I
    //   180: bipush 37
    //   182: imul
    //   183: i2l
    //   184: lstore 6
    //   186: aload_0
    //   187: new 291	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 365
    //   197: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: lload_2
    //   201: ldc2_w 366
    //   204: lload 4
    //   206: lload 6
    //   208: ladd
    //   209: lmul
    //   210: ladd
    //   211: bipush 16
    //   213: invokestatic 372	java/lang/Long:toString	(JI)Ljava/lang/String;
    //   216: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: putfield 283	com/flurry/android/FlurryAgent:D	Ljava/lang/String;
    //   225: ldc -75
    //   227: ldc_w 374
    //   230: invokestatic 307	com/flurry/android/ah:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   233: pop
    //   234: aload_0
    //   235: getfield 177	com/flurry/android/FlurryAgent:Y	Lcom/flurry/android/u;
    //   238: aload_0
    //   239: getfield 283	com/flurry/android/FlurryAgent:D	Ljava/lang/String;
    //   242: invokevirtual 376	com/flurry/android/u:a	(Ljava/lang/String;)V
    //   245: aload_0
    //   246: getfield 283	com/flurry/android/FlurryAgent:D	Ljava/lang/String;
    //   249: ldc_w 378
    //   252: invokevirtual 382	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   255: ifne +22 -> 277
    //   258: aload_0
    //   259: getfield 384	com/flurry/android/FlurryAgent:r	Ljava/io/File;
    //   262: invokevirtual 289	java/io/File:exists	()Z
    //   265: ifne +12 -> 277
    //   268: aload_0
    //   269: aload_1
    //   270: aload_0
    //   271: getfield 283	com/flurry/android/FlurryAgent:D	Ljava/lang/String;
    //   274: invokespecial 387	com/flurry/android/FlurryAgent:c	(Landroid/content/Context;Ljava/lang/String;)V
    //   277: aload_0
    //   278: monitorexit
    //   279: return
    //   280: aload 9
    //   282: astore 8
    //   284: ldc -75
    //   286: ldc_w 389
    //   289: invokestatic 337	com/flurry/android/ah:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   292: pop
    //   293: goto -195 -> 98
    //   296: astore 10
    //   298: aload 9
    //   300: astore 8
    //   302: ldc -75
    //   304: ldc_w 391
    //   307: aload 10
    //   309: invokestatic 217	com/flurry/android/ah:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   312: pop
    //   313: aload 9
    //   315: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   318: goto -215 -> 103
    //   321: astore_1
    //   322: aload_0
    //   323: monitorexit
    //   324: aload_1
    //   325: athrow
    //   326: astore_1
    //   327: aconst_null
    //   328: astore 8
    //   330: aload 8
    //   332: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   335: aload_1
    //   336: athrow
    //   337: ldc -75
    //   339: ldc_w 393
    //   342: invokestatic 395	com/flurry/android/ah:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   345: pop
    //   346: goto -217 -> 129
    //   349: astore 8
    //   351: ldc -75
    //   353: ldc -103
    //   355: aload 8
    //   357: invokestatic 217	com/flurry/android/ah:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   360: pop
    //   361: goto -232 -> 129
    //   364: ldc -75
    //   366: ldc_w 397
    //   369: invokestatic 307	com/flurry/android/ah:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   372: pop
    //   373: goto -244 -> 129
    //   376: astore_1
    //   377: goto -47 -> 330
    //   380: astore 10
    //   382: aconst_null
    //   383: astore 9
    //   385: goto -87 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	FlurryAgent
    //   0	388	1	paramContext	Context
    //   167	34	2	l1	long
    //   171	34	4	l2	long
    //   184	23	6	l3	long
    //   75	256	8	localDataInputStream1	DataInputStream
    //   349	7	8	localThrowable1	Throwable
    //   71	313	9	localDataInputStream2	DataInputStream
    //   296	12	10	localThrowable2	Throwable
    //   380	1	10	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   77	88	296	java/lang/Throwable
    //   92	98	296	java/lang/Throwable
    //   284	293	296	java/lang/Throwable
    //   2	53	321	finally
    //   98	103	321	finally
    //   103	129	321	finally
    //   129	154	321	finally
    //   154	234	321	finally
    //   234	277	321	finally
    //   313	318	321	finally
    //   330	337	321	finally
    //   337	346	321	finally
    //   351	361	321	finally
    //   364	373	321	finally
    //   53	73	326	finally
    //   103	129	349	java/lang/Throwable
    //   337	346	349	java/lang/Throwable
    //   77	88	376	finally
    //   92	98	376	finally
    //   284	293	376	finally
    //   302	313	376	finally
    //   53	73	380	java/lang/Throwable
  }
  
  static void a(Context paramContext, long paramLong)
  {
    if (!o) {
      ah.d("FlurryAgent", "Cannot accept Offer. AppCircle is not enabled");
    }
    h.Y.a(paramContext, paramLong);
  }
  
  static void a(Context paramContext, String paramString)
  {
    if (!o) {
      return;
    }
    h.Y.a(paramContext, paramString);
  }
  
  /* Error */
  private void a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +28 -> 31
    //   6: aload_0
    //   7: getfield 144	com/flurry/android/FlurryAgent:w	Ljava/util/Map;
    //   10: aload_1
    //   11: invokeinterface 413 2 0
    //   16: checkcast 415	android/content/Context
    //   19: ifnonnull +12 -> 31
    //   22: ldc -75
    //   24: ldc_w 417
    //   27: invokestatic 402	com/flurry/android/ah:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   30: pop
    //   31: aload_0
    //   32: getfield 137	com/flurry/android/FlurryAgent:t	Z
    //   35: ifeq +150 -> 185
    //   38: aload_0
    //   39: getfield 144	com/flurry/android/FlurryAgent:w	Ljava/util/Map;
    //   42: invokeinterface 420 1 0
    //   47: ifeq +138 -> 185
    //   50: ldc -75
    //   52: ldc_w 422
    //   55: invokestatic 337	com/flurry/android/ah:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   58: pop
    //   59: aload_0
    //   60: invokespecial 424	com/flurry/android/FlurryAgent:m	()V
    //   63: aload_1
    //   64: ifnonnull +124 -> 188
    //   67: aconst_null
    //   68: astore 5
    //   70: aload_1
    //   71: ifnull +59 -> 130
    //   74: aload 5
    //   76: invokevirtual 427	android/content/Context:getPackageName	()Ljava/lang/String;
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 429	com/flurry/android/FlurryAgent:y	Ljava/lang/String;
    //   84: aload_1
    //   85: invokevirtual 433	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifne +42 -> 130
    //   91: ldc -75
    //   93: new 291	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 435
    //   103: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: getfield 429	com/flurry/android/FlurryAgent:y	Ljava/lang/String;
    //   110: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 437
    //   116: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 395	com/flurry/android/ah:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   129: pop
    //   130: invokestatic 442	android/os/SystemClock:elapsedRealtime	()J
    //   133: lstore_3
    //   134: aload_0
    //   135: lload_3
    //   136: putfield 444	com/flurry/android/FlurryAgent:v	J
    //   139: aload_0
    //   140: lload_3
    //   141: aload_0
    //   142: getfield 446	com/flurry/android/FlurryAgent:I	J
    //   145: lsub
    //   146: putfield 448	com/flurry/android/FlurryAgent:J	J
    //   149: aload_0
    //   150: getfield 283	com/flurry/android/FlurryAgent:D	Ljava/lang/String;
    //   153: ifnonnull +12 -> 165
    //   156: ldc -75
    //   158: ldc_w 450
    //   161: invokestatic 395	com/flurry/android/ah:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   164: pop
    //   165: aload_0
    //   166: new 452	com/flurry/android/b
    //   169: dup
    //   170: aload_0
    //   171: iload_2
    //   172: aload 5
    //   174: invokespecial 455	com/flurry/android/b:<init>	(Lcom/flurry/android/FlurryAgent;ZLandroid/content/Context;)V
    //   177: invokespecial 458	com/flurry/android/FlurryAgent:a	(Ljava/lang/Runnable;)V
    //   180: aload_0
    //   181: iconst_0
    //   182: putfield 137	com/flurry/android/FlurryAgent:t	Z
    //   185: aload_0
    //   186: monitorexit
    //   187: return
    //   188: aload_1
    //   189: invokevirtual 462	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   192: astore 5
    //   194: goto -124 -> 70
    //   197: astore_1
    //   198: aload_0
    //   199: monitorexit
    //   200: aload_1
    //   201: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	FlurryAgent
    //   0	202	1	paramContext	Context
    //   0	202	2	paramBoolean	boolean
    //   133	8	3	l1	long
    //   68	125	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   6	31	197	finally
    //   31	63	197	finally
    //   74	130	197	finally
    //   130	165	197	finally
    //   165	185	197	finally
    //   188	194	197	finally
  }
  
  static void a(AppCircleCallback paramAppCircleCallback)
  {
    h.Y.a(paramAppCircleCallback);
  }
  
  private void a(DataInputStream paramDataInputStream)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    HashMap localHashMap4 = new HashMap();
    HashMap localHashMap5 = new HashMap();
    HashMap localHashMap6 = new HashMap();
    int i2 = paramDataInputStream.readUnsignedShort();
    int i1 = paramDataInputStream.readInt();
    switch (i2)
    {
    case 260: 
    case 261: 
    case 265: 
    case 267: 
    default: 
      ah.a("FlurryAgent", "Unknown chunkType: " + i2);
      paramDataInputStream.skipBytes(i1);
    }
    while (i2 == 264)
    {
      if (o)
      {
        if (localHashMap1.isEmpty()) {
          ah.a("FlurryAgent", "No ads from server");
        }
        this.Y.a(localHashMap1, localHashMap4, localHashMap5, localHashMap2, localHashMap3, localHashMap6);
      }
      return;
      paramDataInputStream.readInt();
      continue;
      byte b1 = paramDataInputStream.readByte();
      int i3 = paramDataInputStream.readUnsignedShort();
      Object localObject = new v[i3];
      i1 = 0;
      while (i1 < i3)
      {
        localObject[i1] = new v(paramDataInputStream);
        i1 += 1;
      }
      localHashMap1.put(Byte.valueOf(b1), localObject);
      continue;
      i3 = paramDataInputStream.readUnsignedShort();
      i1 = 0;
      while (i1 < i3)
      {
        localObject = new AdImage(paramDataInputStream);
        localHashMap2.put(Long.valueOf(((AdImage)localObject).a), localObject);
        i1 += 1;
      }
      i3 = paramDataInputStream.readInt();
      i1 = 0;
      while (i1 < i3)
      {
        localObject = new e(paramDataInputStream);
        localHashMap4.put(((e)localObject).a, localObject);
        ah.a("FlurryAgent", "Parsed hook: " + localObject);
        i1 += 1;
      }
      paramDataInputStream.skipBytes(i1);
      continue;
      i3 = paramDataInputStream.readByte();
      i1 = 0;
      while (i1 < i3)
      {
        localObject = new c(paramDataInputStream);
        localHashMap5.put(Byte.valueOf(((c)localObject).a), localObject);
        i1 += 1;
      }
      i3 = paramDataInputStream.readByte();
      i1 = 0;
      while (i1 < i3)
      {
        localObject = (c)localHashMap5.get(Byte.valueOf(paramDataInputStream.readByte()));
        if (localObject != null) {
          ((c)localObject).a(paramDataInputStream);
        }
        i1 += 1;
      }
      i3 = paramDataInputStream.readInt();
      i1 = 0;
      while (i1 < i3)
      {
        l1 = paramDataInputStream.readLong();
        localHashMap6.put(Short.valueOf(paramDataInputStream.readShort()), Long.valueOf(l1));
        i1 += 1;
      }
      long l1 = paramDataInputStream.readLong();
      al localal = (al)localHashMap3.get(Long.valueOf(l1));
      localObject = localal;
      if (localal == null) {
        localObject = new al();
      }
      ((al)localObject).a = paramDataInputStream.readUTF();
      ((al)localObject).c = paramDataInputStream.readInt();
      localHashMap3.put(Long.valueOf(l1), localObject);
      continue;
      paramDataInputStream.skipBytes(i1);
      continue;
      paramDataInputStream.skipBytes(i1);
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    this.q.post(paramRunnable);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        if (this.W == null)
        {
          ah.b("FlurryAgent", "onError called before onStartSession.  Error: " + paramString1);
          return;
        }
        this.Q += 1;
        if (this.W.size() < 10)
        {
          aa localaa = new aa();
          localaa.a = System.currentTimeMillis();
          localaa.b = r.a(paramString1, 255);
          localaa.c = r.a(paramString2, 512);
          localaa.d = r.a(paramString3, 255);
          this.W.add(localaa);
          ah.a("FlurryAgent", "Error logged: " + localaa.b);
        }
        else
        {
          ah.a("FlurryAgent", "Max errors logged. No more errors logged.");
        }
      }
      finally {}
    }
  }
  
  private void a(String paramString, Map paramMap, boolean paramBoolean)
  {
    for (;;)
    {
      long l1;
      long l2;
      String str;
      try
      {
        if (this.T == null)
        {
          ah.b("FlurryAgent", "onEvent called before onStartSession.  Event: " + paramString);
          return;
        }
        l1 = SystemClock.elapsedRealtime();
        l2 = this.I;
        str = r.a(paramString, 255);
        if (str.length() == 0) {
          continue;
        }
        paramString = (g)this.S.get(str);
        if (paramString != null) {
          break label287;
        }
        if (this.S.size() < 100)
        {
          paramString = new g();
          paramString.a = 1;
          this.S.put(str, paramString);
          ah.a("FlurryAgent", "Event count incremented: " + str);
          if ((!j) || (this.T.size() >= 200) || (this.V >= 16000)) {
            break label443;
          }
          if (paramMap != null) {
            break label451;
          }
          paramString = Collections.emptyMap();
          if (paramString.size() <= 10) {
            break label327;
          }
          if (!ah.a("FlurryAgent")) {
            continue;
          }
          ah.a("FlurryAgent", "MaxEventParams exceeded: " + paramString.size());
          continue;
        }
        if (!ah.a("FlurryAgent")) {
          continue;
        }
      }
      finally {}
      ah.a("FlurryAgent", "Too many different events. Event not counted: " + str);
      continue;
      label287:
      paramString.a += 1;
      ah.a("FlurryAgent", "Event count incremented: " + str);
      continue;
      label327:
      paramString = new i(str, paramString, l1 - l2, paramBoolean);
      if (paramString.a().length + this.V <= 16000)
      {
        this.T.add(paramString);
        int i1 = this.V;
        this.V = (paramString.a().length + i1);
        ah.a("FlurryAgent", "Logged event: " + str);
      }
      else
      {
        this.V = 16000;
        this.U = false;
        ah.a("FlurryAgent", "Event Log size exceeded. No more event details logged.");
        continue;
        label443:
        this.U = false;
        continue;
        label451:
        paramString = paramMap;
      }
    }
  }
  
  static void a(List paramList)
  {
    if (!o) {
      return;
    }
    h.Y.a(paramList);
  }
  
  static void a(boolean paramBoolean)
  {
    if (!o) {
      return;
    }
    h.Y.a(paramBoolean);
  }
  
  static boolean a()
  {
    return h.Y.h();
  }
  
  private static boolean a(File paramFile)
  {
    paramFile = paramFile.getParentFile();
    if ((!paramFile.mkdirs()) && (!paramFile.exists()))
    {
      ah.b("FlurryAgent", "Unable to create persistent dir: " + paramFile);
      return false;
    }
    return true;
  }
  
  private boolean a(byte[] paramArrayOfByte)
  {
    ??? = k();
    boolean bool2;
    if (??? == null) {
      bool2 = false;
    }
    boolean bool1;
    for (;;)
    {
      return bool2;
      try
      {
        bool1 = a(paramArrayOfByte, (String)???);
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (c == null)
          {
            bool2 = bool1;
            if (k)
            {
              bool2 = bool1;
              if (l) {}
            }
          }
        }
      }
      catch (Exception localException)
      {
        String str;
        synchronized (h)
        {
          for (;;)
          {
            l = true;
            str = k();
            if (str != null) {
              break;
            }
            return false;
            localException = localException;
            ah.a("FlurryAgent", "Sending report exception: " + localException.getMessage());
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(byte[] paramArrayOfByte, String paramString)
  {
    boolean bool2 = true;
    if ("local".equals(paramString)) {
      return true;
    }
    ah.a("FlurryAgent", "Sending report to: " + paramString);
    paramArrayOfByte = new ByteArrayEntity(paramArrayOfByte);
    paramArrayOfByte.setContentType("application/octet-stream");
    paramString = new HttpPost(paramString);
    paramString.setEntity(paramArrayOfByte);
    paramArrayOfByte = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(paramArrayOfByte, 10000);
    HttpConnectionParams.setSoTimeout(paramArrayOfByte, 15000);
    paramString.getParams().setBooleanParameter("http.protocol.expect-continue", false);
    paramArrayOfByte = a(paramArrayOfByte).execute(paramString);
    int i1 = paramArrayOfByte.getStatusLine().getStatusCode();
    if (i1 == 200) {}
    for (;;)
    {
      try
      {
        ah.a("FlurryAgent", "Report successful");
        this.E = true;
        this.G.removeAll(this.B);
        paramArrayOfByte = paramArrayOfByte.getEntity();
        ah.a("FlurryAgent", "Processing report response");
        bool1 = bool2;
        if (paramArrayOfByte != null)
        {
          long l1 = paramArrayOfByte.getContentLength();
          bool1 = bool2;
          if (l1 == 0L) {}
        }
        ah.a("FlurryAgent", "Report failed. HTTP response: " + i1);
      }
      finally
      {
        try
        {
          a(new DataInputStream(paramArrayOfByte.getContent()));
          paramArrayOfByte.consumeContent();
          bool1 = bool2;
          this.B = null;
          return bool1;
        }
        finally
        {
          paramArrayOfByte.consumeContent();
        }
        paramArrayOfByte = finally;
      }
      boolean bool1 = false;
    }
  }
  
  public static void addUserCookie(String paramString1, String paramString2)
  {
    if (!o) {
      return;
    }
    h.Y.a(paramString1, paramString2);
  }
  
  static u b()
  {
    return h.Y;
  }
  
  /* Error */
  private String b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_0
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 283	com/flurry/android/FlurryAgent:D	Ljava/lang/String;
    //   10: ifnull +10 -> 20
    //   13: aload_0
    //   14: getfield 283	com/flurry/android/FlurryAgent:D	Ljava/lang/String;
    //   17: astore_1
    //   18: aload_1
    //   19: areturn
    //   20: aload_1
    //   21: invokevirtual 773	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   24: ldc_w 775
    //   27: invokestatic 781	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 7
    //   32: iload 4
    //   34: istore_2
    //   35: aload 7
    //   37: ifnull +28 -> 65
    //   40: iload 4
    //   42: istore_2
    //   43: aload 7
    //   45: invokevirtual 605	java/lang/String:length	()I
    //   48: ifle +17 -> 65
    //   51: aload 7
    //   53: ldc_w 783
    //   56: invokevirtual 433	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifeq +32 -> 91
    //   62: iload 4
    //   64: istore_2
    //   65: iload_2
    //   66: ifeq +70 -> 136
    //   69: new 291	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 378
    //   79: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload 7
    //   84: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: areturn
    //   91: getstatic 83	com/flurry/android/FlurryAgent:b	[Ljava/lang/String;
    //   94: astore 8
    //   96: aload 8
    //   98: arraylength
    //   99: istore 5
    //   101: iconst_0
    //   102: istore_3
    //   103: iload_3
    //   104: iload 5
    //   106: if_icmpge +25 -> 131
    //   109: iload 4
    //   111: istore_2
    //   112: aload 7
    //   114: aload 8
    //   116: iload_3
    //   117: aaload
    //   118: invokevirtual 433	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: ifne -56 -> 65
    //   124: iload_3
    //   125: iconst_1
    //   126: iadd
    //   127: istore_3
    //   128: goto -25 -> 103
    //   131: iconst_1
    //   132: istore_2
    //   133: goto -68 -> 65
    //   136: aload_1
    //   137: ldc_w 785
    //   140: invokevirtual 789	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   143: astore 7
    //   145: aload 6
    //   147: astore_1
    //   148: aload 7
    //   150: invokevirtual 289	java/io/File:exists	()Z
    //   153: ifeq -135 -> 18
    //   156: new 309	java/io/DataInputStream
    //   159: dup
    //   160: new 311	java/io/FileInputStream
    //   163: dup
    //   164: aload 7
    //   166: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   169: invokespecial 317	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   172: astore 6
    //   174: aload 6
    //   176: astore_1
    //   177: aload 6
    //   179: invokevirtual 482	java/io/DataInputStream:readInt	()I
    //   182: pop
    //   183: aload 6
    //   185: astore_1
    //   186: aload 6
    //   188: invokevirtual 561	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   191: astore 7
    //   193: aload 6
    //   195: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   198: aload 7
    //   200: areturn
    //   201: astore 7
    //   203: aconst_null
    //   204: astore 6
    //   206: aload 6
    //   208: astore_1
    //   209: ldc -75
    //   211: ldc_w 791
    //   214: aload 7
    //   216: invokestatic 217	com/flurry/android/ah:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   219: pop
    //   220: aload 6
    //   222: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   225: aconst_null
    //   226: areturn
    //   227: astore_1
    //   228: aconst_null
    //   229: astore 7
    //   231: aload_1
    //   232: astore 6
    //   234: aload 7
    //   236: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   239: aload 6
    //   241: athrow
    //   242: astore 6
    //   244: aload_1
    //   245: astore 7
    //   247: goto -13 -> 234
    //   250: astore 7
    //   252: goto -46 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	FlurryAgent
    //   0	255	1	paramContext	Context
    //   34	99	2	i1	int
    //   102	26	3	i2	int
    //   4	106	4	i3	int
    //   99	8	5	i4	int
    //   1	239	6	localObject1	Object
    //   242	1	6	localObject2	Object
    //   30	169	7	localObject3	Object
    //   201	14	7	localThrowable1	Throwable
    //   229	17	7	localObject4	Object
    //   250	1	7	localThrowable2	Throwable
    //   94	21	8	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   156	174	201	java/lang/Throwable
    //   156	174	227	finally
    //   177	183	242	finally
    //   186	193	242	finally
    //   209	220	242	finally
    //   177	183	250	java/lang/Throwable
    //   186	193	250	java/lang/Throwable
  }
  
  static List b(String paramString)
  {
    if (!o) {
      return null;
    }
    return h.Y.c(paramString);
  }
  
  /* Error */
  private void b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 360	com/flurry/android/FlurryAgent:x	Ljava/lang/String;
    //   6: ifnull +53 -> 59
    //   9: aload_0
    //   10: getfield 360	com/flurry/android/FlurryAgent:x	Ljava/lang/String;
    //   13: aload_2
    //   14: invokevirtual 433	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifne +42 -> 59
    //   20: ldc -75
    //   22: new 291	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 796
    //   32: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: getfield 360	com/flurry/android/FlurryAgent:x	Ljava/lang/String;
    //   39: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 798
    //   45: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_2
    //   49: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 395	com/flurry/android/ah:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   58: pop
    //   59: aload_0
    //   60: getfield 144	com/flurry/android/FlurryAgent:w	Ljava/util/Map;
    //   63: aload_1
    //   64: aload_1
    //   65: invokeinterface 515 3 0
    //   70: checkcast 415	android/content/Context
    //   73: ifnull +12 -> 85
    //   76: ldc -75
    //   78: ldc_w 800
    //   81: invokestatic 402	com/flurry/android/ah:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   84: pop
    //   85: aload_0
    //   86: getfield 137	com/flurry/android/FlurryAgent:t	Z
    //   89: ifne +472 -> 561
    //   92: ldc -75
    //   94: ldc_w 802
    //   97: invokestatic 337	com/flurry/android/ah:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   100: pop
    //   101: aload_0
    //   102: aload_2
    //   103: putfield 360	com/flurry/android/FlurryAgent:x	Ljava/lang/String;
    //   106: aload_0
    //   107: aload_1
    //   108: new 291	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 804
    //   118: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_0
    //   122: getfield 360	com/flurry/android/FlurryAgent:x	Ljava/lang/String;
    //   125: invokevirtual 363	java/lang/String:hashCode	()I
    //   128: bipush 16
    //   130: invokestatic 809	java/lang/Integer:toString	(II)Ljava/lang/String;
    //   133: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokevirtual 789	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   142: putfield 135	com/flurry/android/FlurryAgent:s	Ljava/io/File;
    //   145: aload_0
    //   146: aload_1
    //   147: ldc_w 785
    //   150: invokevirtual 789	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   153: putfield 384	com/flurry/android/FlurryAgent:r	Ljava/io/File;
    //   156: getstatic 122	com/flurry/android/FlurryAgent:m	Z
    //   159: ifeq +13 -> 172
    //   162: new 811	com/flurry/android/FlurryAgent$FlurryDefaultExceptionHandler
    //   165: dup
    //   166: invokespecial 812	com/flurry/android/FlurryAgent$FlurryDefaultExceptionHandler:<init>	()V
    //   169: invokestatic 818	java/lang/Thread:setDefaultUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   172: aload_1
    //   173: invokevirtual 462	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   176: astore 5
    //   178: aload_0
    //   179: getfield 820	com/flurry/android/FlurryAgent:z	Ljava/lang/String;
    //   182: ifnonnull +12 -> 194
    //   185: aload_0
    //   186: aload 5
    //   188: invokestatic 822	com/flurry/android/FlurryAgent:c	(Landroid/content/Context;)Ljava/lang/String;
    //   191: putfield 820	com/flurry/android/FlurryAgent:z	Ljava/lang/String;
    //   194: aload 5
    //   196: invokevirtual 427	android/content/Context:getPackageName	()Ljava/lang/String;
    //   199: astore_2
    //   200: aload_0
    //   201: getfield 429	com/flurry/android/FlurryAgent:y	Ljava/lang/String;
    //   204: ifnull +53 -> 257
    //   207: aload_0
    //   208: getfield 429	com/flurry/android/FlurryAgent:y	Ljava/lang/String;
    //   211: aload_2
    //   212: invokevirtual 433	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifne +42 -> 257
    //   218: ldc -75
    //   220: new 291	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 824
    //   230: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_0
    //   234: getfield 429	com/flurry/android/FlurryAgent:y	Ljava/lang/String;
    //   237: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc_w 798
    //   243: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_2
    //   247: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 395	com/flurry/android/ah:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   256: pop
    //   257: aload_0
    //   258: aload_2
    //   259: putfield 429	com/flurry/android/FlurryAgent:y	Ljava/lang/String;
    //   262: invokestatic 442	android/os/SystemClock:elapsedRealtime	()J
    //   265: lstore_3
    //   266: lload_3
    //   267: aload_0
    //   268: getfield 444	com/flurry/android/FlurryAgent:v	J
    //   271: lsub
    //   272: getstatic 114	com/flurry/android/FlurryAgent:i	J
    //   275: lcmp
    //   276: ifle +295 -> 571
    //   279: ldc -75
    //   281: ldc_w 826
    //   284: invokestatic 337	com/flurry/android/ah:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   287: pop
    //   288: aload_0
    //   289: invokestatic 584	java/lang/System:currentTimeMillis	()J
    //   292: putfield 341	com/flurry/android/FlurryAgent:H	J
    //   295: aload_0
    //   296: lload_3
    //   297: putfield 446	com/flurry/android/FlurryAgent:I	J
    //   300: aload_0
    //   301: ldc2_w 827
    //   304: putfield 448	com/flurry/android/FlurryAgent:J	J
    //   307: aload_0
    //   308: ldc -103
    //   310: putfield 161	com/flurry/android/FlurryAgent:N	Ljava/lang/String;
    //   313: aload_0
    //   314: iconst_0
    //   315: putfield 573	com/flurry/android/FlurryAgent:Q	I
    //   318: aload_0
    //   319: aconst_null
    //   320: putfield 474	com/flurry/android/FlurryAgent:R	Landroid/location/Location;
    //   323: aload_0
    //   324: invokestatic 834	java/util/TimeZone:getDefault	()Ljava/util/TimeZone;
    //   327: invokevirtual 837	java/util/TimeZone:getID	()Ljava/lang/String;
    //   330: putfield 157	com/flurry/android/FlurryAgent:L	Ljava/lang/String;
    //   333: aload_0
    //   334: new 291	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   341: invokestatic 842	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   344: invokevirtual 845	java/util/Locale:getLanguage	()Ljava/lang/String;
    //   347: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc_w 847
    //   353: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokestatic 842	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   359: invokevirtual 850	java/util/Locale:getCountry	()Ljava/lang/String;
    //   362: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: putfield 155	com/flurry/android/FlurryAgent:K	Ljava/lang/String;
    //   371: aload_0
    //   372: new 165	java/util/HashMap
    //   375: dup
    //   376: invokespecial 166	java/util/HashMap:<init>	()V
    //   379: putfield 168	com/flurry/android/FlurryAgent:S	Ljava/util/Map;
    //   382: aload_0
    //   383: new 148	java/util/ArrayList
    //   386: dup
    //   387: invokespecial 149	java/util/ArrayList:<init>	()V
    //   390: putfield 170	com/flurry/android/FlurryAgent:T	Ljava/util/List;
    //   393: aload_0
    //   394: iconst_1
    //   395: putfield 639	com/flurry/android/FlurryAgent:U	Z
    //   398: aload_0
    //   399: new 148	java/util/ArrayList
    //   402: dup
    //   403: invokespecial 149	java/util/ArrayList:<init>	()V
    //   406: putfield 172	com/flurry/android/FlurryAgent:W	Ljava/util/List;
    //   409: aload_0
    //   410: iconst_0
    //   411: putfield 615	com/flurry/android/FlurryAgent:V	I
    //   414: aload_0
    //   415: iconst_0
    //   416: putfield 852	com/flurry/android/FlurryAgent:X	I
    //   419: getstatic 126	com/flurry/android/FlurryAgent:o	Z
    //   422: ifeq +116 -> 538
    //   425: aload_0
    //   426: getfield 177	com/flurry/android/FlurryAgent:Y	Lcom/flurry/android/u;
    //   429: invokevirtual 854	com/flurry/android/u:a	()Z
    //   432: ifne +91 -> 523
    //   435: ldc -75
    //   437: ldc_w 856
    //   440: invokestatic 337	com/flurry/android/ah:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   443: pop
    //   444: new 858	com/flurry/android/a
    //   447: dup
    //   448: invokespecial 859	com/flurry/android/a:<init>	()V
    //   451: astore 6
    //   453: aload 6
    //   455: aload_0
    //   456: getfield 360	com/flurry/android/FlurryAgent:x	Ljava/lang/String;
    //   459: putfield 860	com/flurry/android/a:a	Ljava/lang/String;
    //   462: aload 6
    //   464: aload_0
    //   465: getfield 343	com/flurry/android/FlurryAgent:F	J
    //   468: putfield 862	com/flurry/android/a:b	J
    //   471: getstatic 95	com/flurry/android/FlurryAgent:d	Ljava/lang/String;
    //   474: ifnull +90 -> 564
    //   477: getstatic 95	com/flurry/android/FlurryAgent:d	Ljava/lang/String;
    //   480: astore_2
    //   481: aload 6
    //   483: aload_2
    //   484: putfield 863	com/flurry/android/a:c	Ljava/lang/String;
    //   487: aload 6
    //   489: invokestatic 865	com/flurry/android/FlurryAgent:c	()Ljava/lang/String;
    //   492: putfield 866	com/flurry/android/a:d	Ljava/lang/String;
    //   495: aload 6
    //   497: aload_0
    //   498: getfield 198	com/flurry/android/FlurryAgent:q	Landroid/os/Handler;
    //   501: putfield 868	com/flurry/android/a:e	Landroid/os/Handler;
    //   504: aload_0
    //   505: getfield 177	com/flurry/android/FlurryAgent:Y	Lcom/flurry/android/u;
    //   508: aload_1
    //   509: aload 6
    //   511: invokevirtual 871	com/flurry/android/u:a	(Landroid/content/Context;Lcom/flurry/android/a;)V
    //   514: ldc -75
    //   516: ldc_w 873
    //   519: invokestatic 337	com/flurry/android/ah:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   522: pop
    //   523: aload_0
    //   524: getfield 177	com/flurry/android/FlurryAgent:Y	Lcom/flurry/android/u;
    //   527: aload_0
    //   528: getfield 341	com/flurry/android/FlurryAgent:H	J
    //   531: aload_0
    //   532: getfield 446	com/flurry/android/FlurryAgent:I	J
    //   535: invokevirtual 876	com/flurry/android/u:a	(JJ)V
    //   538: aload_0
    //   539: new 878	com/flurry/android/d
    //   542: dup
    //   543: aload_0
    //   544: aload 5
    //   546: aload_0
    //   547: getfield 146	com/flurry/android/FlurryAgent:A	Z
    //   550: invokespecial 880	com/flurry/android/d:<init>	(Lcom/flurry/android/FlurryAgent;Landroid/content/Context;Z)V
    //   553: invokespecial 458	com/flurry/android/FlurryAgent:a	(Ljava/lang/Runnable;)V
    //   556: aload_0
    //   557: iconst_1
    //   558: putfield 137	com/flurry/android/FlurryAgent:t	Z
    //   561: aload_0
    //   562: monitorexit
    //   563: return
    //   564: getstatic 99	com/flurry/android/FlurryAgent:e	Ljava/lang/String;
    //   567: astore_2
    //   568: goto -87 -> 481
    //   571: ldc -75
    //   573: ldc_w 882
    //   576: invokestatic 337	com/flurry/android/ah:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   579: pop
    //   580: aload_0
    //   581: getfield 151	com/flurry/android/FlurryAgent:G	Ljava/util/List;
    //   584: invokeinterface 883 1 0
    //   589: ifne -33 -> 556
    //   592: aload_0
    //   593: getfield 151	com/flurry/android/FlurryAgent:G	Ljava/util/List;
    //   596: aload_0
    //   597: getfield 151	com/flurry/android/FlurryAgent:G	Ljava/util/List;
    //   600: invokeinterface 578 1 0
    //   605: iconst_1
    //   606: isub
    //   607: invokeinterface 886 2 0
    //   612: pop
    //   613: goto -57 -> 556
    //   616: astore_1
    //   617: aload_0
    //   618: monitorexit
    //   619: aload_1
    //   620: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	this	FlurryAgent
    //   0	621	1	paramContext	Context
    //   0	621	2	paramString	String
    //   265	32	3	l1	long
    //   176	369	5	localContext	Context
    //   451	59	6	locala	a
    // Exception table:
    //   from	to	target	type
    //   2	59	616	finally
    //   59	85	616	finally
    //   85	172	616	finally
    //   172	194	616	finally
    //   194	257	616	finally
    //   257	481	616	finally
    //   481	523	616	finally
    //   523	538	616	finally
    //   538	556	616	finally
    //   556	561	616	finally
    //   564	568	616	finally
    //   571	613	616	finally
  }
  
  private void b(DataInputStream paramDataInputStream)
  {
    int i1 = 0;
    int i2;
    try
    {
      i2 = paramDataInputStream.readUnsignedShort();
      if (i2 > 2)
      {
        ah.b("FlurryAgent", "Unknown agent file version: " + i2);
        throw new IOException("Unknown agent file version: " + i2);
      }
    }
    finally {}
    Object localObject;
    if (i2 >= 2)
    {
      localObject = paramDataInputStream.readUTF();
      ah.a("FlurryAgent", "Loading API key: " + d(this.x));
      if (((String)localObject).equals(this.x))
      {
        localObject = paramDataInputStream.readUTF();
        if (this.D == null) {
          ah.a("FlurryAgent", "Loading phoneId: " + (String)localObject);
        }
        this.D = ((String)localObject);
        this.E = paramDataInputStream.readBoolean();
        this.F = paramDataInputStream.readLong();
        ah.a("FlurryAgent", "Loading session reports");
        for (;;)
        {
          i2 = paramDataInputStream.readUnsignedShort();
          if (i2 == 0) {
            break;
          }
          localObject = new byte[i2];
          paramDataInputStream.readFully((byte[])localObject);
          this.G.add(0, localObject);
          localObject = new StringBuilder().append("Session report added: ");
          i1 += 1;
          ah.a("FlurryAgent", i1);
        }
        ah.a("FlurryAgent", "Persistent file loaded");
        this.u = true;
      }
    }
    for (;;)
    {
      return;
      ah.a("FlurryAgent", "Api keys do not match, old: " + d((String)localObject) + ", new: " + d(this.x));
      continue;
      ah.d("FlurryAgent", "Deleting old file version: " + i2);
    }
  }
  
  /* Error */
  private byte[] b(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: new 925	java/io/ByteArrayOutputStream
    //   7: dup
    //   8: invokespecial 926	java/io/ByteArrayOutputStream:<init>	()V
    //   11: astore 8
    //   13: new 928	java/io/DataOutputStream
    //   16: dup
    //   17: aload 8
    //   19: invokespecial 931	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore 7
    //   24: aload 7
    //   26: astore 6
    //   28: aload 7
    //   30: bipush 15
    //   32: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   35: aload 7
    //   37: astore 6
    //   39: getstatic 126	com/flurry/android/FlurryAgent:o	Z
    //   42: ifeq +172 -> 214
    //   45: iload_1
    //   46: ifeq +168 -> 214
    //   49: aload 7
    //   51: astore 6
    //   53: aload 7
    //   55: iconst_1
    //   56: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   59: aload 7
    //   61: astore 6
    //   63: getstatic 126	com/flurry/android/FlurryAgent:o	Z
    //   66: ifeq +186 -> 252
    //   69: aload 7
    //   71: astore 6
    //   73: aload 7
    //   75: aload_0
    //   76: getfield 177	com/flurry/android/FlurryAgent:Y	Lcom/flurry/android/u;
    //   79: invokevirtual 937	com/flurry/android/u:d	()J
    //   82: invokevirtual 941	java/io/DataOutputStream:writeLong	(J)V
    //   85: aload 7
    //   87: astore 6
    //   89: aload_0
    //   90: getfield 177	com/flurry/android/FlurryAgent:Y	Lcom/flurry/android/u;
    //   93: invokevirtual 944	com/flurry/android/u:e	()Ljava/util/Set;
    //   96: astore 9
    //   98: aload 7
    //   100: astore 6
    //   102: aload 7
    //   104: aload 9
    //   106: invokeinterface 947 1 0
    //   111: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   114: aload 7
    //   116: astore 6
    //   118: aload 9
    //   120: invokeinterface 951 1 0
    //   125: astore 9
    //   127: aload 7
    //   129: astore 6
    //   131: aload 9
    //   133: invokeinterface 956 1 0
    //   138: ifeq +134 -> 272
    //   141: aload 7
    //   143: astore 6
    //   145: aload 9
    //   147: invokeinterface 960 1 0
    //   152: checkcast 369	java/lang/Long
    //   155: invokevirtual 963	java/lang/Long:longValue	()J
    //   158: lstore 4
    //   160: aload 7
    //   162: astore 6
    //   164: aload 7
    //   166: iconst_1
    //   167: invokevirtual 966	java/io/DataOutputStream:writeByte	(I)V
    //   170: aload 7
    //   172: astore 6
    //   174: aload 7
    //   176: lload 4
    //   178: invokevirtual 941	java/io/DataOutputStream:writeLong	(J)V
    //   181: goto -54 -> 127
    //   184: astore 8
    //   186: aload 7
    //   188: astore 6
    //   190: ldc -75
    //   192: ldc_w 968
    //   195: aload 8
    //   197: invokestatic 217	com/flurry/android/ah:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   200: pop
    //   201: aload 7
    //   203: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   206: aconst_null
    //   207: astore 6
    //   209: aload_0
    //   210: monitorexit
    //   211: aload 6
    //   213: areturn
    //   214: aload 7
    //   216: astore 6
    //   218: aload 7
    //   220: iconst_0
    //   221: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   224: goto -165 -> 59
    //   227: astore 8
    //   229: aload 6
    //   231: astore 7
    //   233: aload 8
    //   235: astore 6
    //   237: aload 7
    //   239: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   242: aload 6
    //   244: athrow
    //   245: astore 6
    //   247: aload_0
    //   248: monitorexit
    //   249: aload 6
    //   251: athrow
    //   252: aload 7
    //   254: astore 6
    //   256: aload 7
    //   258: lconst_0
    //   259: invokevirtual 941	java/io/DataOutputStream:writeLong	(J)V
    //   262: aload 7
    //   264: astore 6
    //   266: aload 7
    //   268: iconst_0
    //   269: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   272: aload 7
    //   274: astore 6
    //   276: aload 7
    //   278: iconst_3
    //   279: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   282: aload 7
    //   284: astore 6
    //   286: aload 7
    //   288: bipush 121
    //   290: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   293: aload 7
    //   295: astore 6
    //   297: aload 7
    //   299: invokestatic 584	java/lang/System:currentTimeMillis	()J
    //   302: invokevirtual 941	java/io/DataOutputStream:writeLong	(J)V
    //   305: aload 7
    //   307: astore 6
    //   309: aload 7
    //   311: aload_0
    //   312: getfield 360	com/flurry/android/FlurryAgent:x	Ljava/lang/String;
    //   315: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   318: aload 7
    //   320: astore 6
    //   322: aload 7
    //   324: aload_0
    //   325: getfield 820	com/flurry/android/FlurryAgent:z	Ljava/lang/String;
    //   328: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   331: aload 7
    //   333: astore 6
    //   335: aload 7
    //   337: iconst_0
    //   338: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   341: aload 7
    //   343: astore 6
    //   345: aload 7
    //   347: aload_0
    //   348: getfield 283	com/flurry/android/FlurryAgent:D	Ljava/lang/String;
    //   351: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   354: aload 7
    //   356: astore 6
    //   358: aload 7
    //   360: aload_0
    //   361: getfield 343	com/flurry/android/FlurryAgent:F	J
    //   364: invokevirtual 941	java/io/DataOutputStream:writeLong	(J)V
    //   367: aload 7
    //   369: astore 6
    //   371: aload 7
    //   373: aload_0
    //   374: getfield 341	com/flurry/android/FlurryAgent:H	J
    //   377: invokevirtual 941	java/io/DataOutputStream:writeLong	(J)V
    //   380: aload 7
    //   382: astore 6
    //   384: aload 7
    //   386: bipush 6
    //   388: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   391: aload 7
    //   393: astore 6
    //   395: aload 7
    //   397: ldc_w 973
    //   400: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   403: aload 7
    //   405: astore 6
    //   407: aload 7
    //   409: getstatic 978	android/os/Build:MODEL	Ljava/lang/String;
    //   412: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   415: aload 7
    //   417: astore 6
    //   419: aload 7
    //   421: ldc_w 980
    //   424: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   427: aload 7
    //   429: astore 6
    //   431: aload 7
    //   433: getstatic 983	android/os/Build:BRAND	Ljava/lang/String;
    //   436: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   439: aload 7
    //   441: astore 6
    //   443: aload 7
    //   445: ldc_w 985
    //   448: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   451: aload 7
    //   453: astore 6
    //   455: aload 7
    //   457: getstatic 987	android/os/Build:ID	Ljava/lang/String;
    //   460: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   463: aload 7
    //   465: astore 6
    //   467: aload 7
    //   469: ldc_w 989
    //   472: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   475: aload 7
    //   477: astore 6
    //   479: aload 7
    //   481: getstatic 994	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   484: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   487: aload 7
    //   489: astore 6
    //   491: aload 7
    //   493: ldc_w 996
    //   496: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   499: aload 7
    //   501: astore 6
    //   503: aload 7
    //   505: getstatic 999	android/os/Build:DEVICE	Ljava/lang/String;
    //   508: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   511: aload 7
    //   513: astore 6
    //   515: aload 7
    //   517: ldc_w 1001
    //   520: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   523: aload 7
    //   525: astore 6
    //   527: aload 7
    //   529: getstatic 1004	android/os/Build:PRODUCT	Ljava/lang/String;
    //   532: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   535: aload 7
    //   537: astore 6
    //   539: aload_0
    //   540: getfield 151	com/flurry/android/FlurryAgent:G	Ljava/util/List;
    //   543: invokeinterface 578 1 0
    //   548: istore_3
    //   549: aload 7
    //   551: astore 6
    //   553: aload 7
    //   555: iload_3
    //   556: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   559: iload_2
    //   560: iload_3
    //   561: if_icmpge +32 -> 593
    //   564: aload 7
    //   566: astore 6
    //   568: aload 7
    //   570: aload_0
    //   571: getfield 151	com/flurry/android/FlurryAgent:G	Ljava/util/List;
    //   574: iload_2
    //   575: invokeinterface 1006 2 0
    //   580: checkcast 1008	[B
    //   583: invokevirtual 1011	java/io/DataOutputStream:write	([B)V
    //   586: iload_2
    //   587: iconst_1
    //   588: iadd
    //   589: istore_2
    //   590: goto -31 -> 559
    //   593: aload 7
    //   595: astore 6
    //   597: aload_0
    //   598: new 148	java/util/ArrayList
    //   601: dup
    //   602: aload_0
    //   603: getfield 151	com/flurry/android/FlurryAgent:G	Ljava/util/List;
    //   606: invokespecial 1014	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   609: putfield 738	com/flurry/android/FlurryAgent:B	Ljava/util/List;
    //   612: aload 7
    //   614: astore 6
    //   616: aload 7
    //   618: invokevirtual 1017	java/io/DataOutputStream:close	()V
    //   621: aload 7
    //   623: astore 6
    //   625: aload 8
    //   627: invokevirtual 1020	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   630: astore 8
    //   632: aload 8
    //   634: astore 6
    //   636: aload 7
    //   638: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   641: goto -432 -> 209
    //   644: astore 6
    //   646: aconst_null
    //   647: astore 7
    //   649: goto -412 -> 237
    //   652: astore 8
    //   654: aconst_null
    //   655: astore 7
    //   657: goto -471 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	660	0	this	FlurryAgent
    //   0	660	1	paramBoolean	boolean
    //   1	589	2	i1	int
    //   548	14	3	i2	int
    //   158	19	4	l1	long
    //   26	217	6	localObject1	Object
    //   245	5	6	localObject2	Object
    //   254	381	6	localObject3	Object
    //   644	1	6	localObject4	Object
    //   22	634	7	localObject5	Object
    //   11	7	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   184	12	8	localThrowable1	Throwable
    //   227	399	8	localObject6	Object
    //   630	3	8	arrayOfByte	byte[]
    //   652	1	8	localThrowable2	Throwable
    //   96	50	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   28	35	184	java/lang/Throwable
    //   39	45	184	java/lang/Throwable
    //   53	59	184	java/lang/Throwable
    //   63	69	184	java/lang/Throwable
    //   73	85	184	java/lang/Throwable
    //   89	98	184	java/lang/Throwable
    //   102	114	184	java/lang/Throwable
    //   118	127	184	java/lang/Throwable
    //   131	141	184	java/lang/Throwable
    //   145	160	184	java/lang/Throwable
    //   164	170	184	java/lang/Throwable
    //   174	181	184	java/lang/Throwable
    //   218	224	184	java/lang/Throwable
    //   256	262	184	java/lang/Throwable
    //   266	272	184	java/lang/Throwable
    //   276	282	184	java/lang/Throwable
    //   286	293	184	java/lang/Throwable
    //   297	305	184	java/lang/Throwable
    //   309	318	184	java/lang/Throwable
    //   322	331	184	java/lang/Throwable
    //   335	341	184	java/lang/Throwable
    //   345	354	184	java/lang/Throwable
    //   358	367	184	java/lang/Throwable
    //   371	380	184	java/lang/Throwable
    //   384	391	184	java/lang/Throwable
    //   395	403	184	java/lang/Throwable
    //   407	415	184	java/lang/Throwable
    //   419	427	184	java/lang/Throwable
    //   431	439	184	java/lang/Throwable
    //   443	451	184	java/lang/Throwable
    //   455	463	184	java/lang/Throwable
    //   467	475	184	java/lang/Throwable
    //   479	487	184	java/lang/Throwable
    //   491	499	184	java/lang/Throwable
    //   503	511	184	java/lang/Throwable
    //   515	523	184	java/lang/Throwable
    //   527	535	184	java/lang/Throwable
    //   539	549	184	java/lang/Throwable
    //   553	559	184	java/lang/Throwable
    //   568	586	184	java/lang/Throwable
    //   597	612	184	java/lang/Throwable
    //   616	621	184	java/lang/Throwable
    //   625	632	184	java/lang/Throwable
    //   28	35	227	finally
    //   39	45	227	finally
    //   53	59	227	finally
    //   63	69	227	finally
    //   73	85	227	finally
    //   89	98	227	finally
    //   102	114	227	finally
    //   118	127	227	finally
    //   131	141	227	finally
    //   145	160	227	finally
    //   164	170	227	finally
    //   174	181	227	finally
    //   190	201	227	finally
    //   218	224	227	finally
    //   256	262	227	finally
    //   266	272	227	finally
    //   276	282	227	finally
    //   286	293	227	finally
    //   297	305	227	finally
    //   309	318	227	finally
    //   322	331	227	finally
    //   335	341	227	finally
    //   345	354	227	finally
    //   358	367	227	finally
    //   371	380	227	finally
    //   384	391	227	finally
    //   395	403	227	finally
    //   407	415	227	finally
    //   419	427	227	finally
    //   431	439	227	finally
    //   443	451	227	finally
    //   455	463	227	finally
    //   467	475	227	finally
    //   479	487	227	finally
    //   491	499	227	finally
    //   503	511	227	finally
    //   515	523	227	finally
    //   527	535	227	finally
    //   539	549	227	finally
    //   553	559	227	finally
    //   568	586	227	finally
    //   597	612	227	finally
    //   616	621	227	finally
    //   625	632	227	finally
    //   201	206	245	finally
    //   237	245	245	finally
    //   636	641	245	finally
    //   4	24	644	finally
    //   4	24	652	java/lang/Throwable
  }
  
  static String c()
  {
    if (f != null) {
      return f;
    }
    return g;
  }
  
  private static String c(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext.versionName != null) {
        return paramContext.versionName;
      }
      if (paramContext.versionCode != 0)
      {
        paramContext = Integer.toString(paramContext.versionCode);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      ah.b("FlurryAgent", "", paramContext);
    }
    return "Unknown";
  }
  
  /* Error */
  private void c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: ldc_w 785
    //   7: invokevirtual 789	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   10: putfield 384	com/flurry/android/FlurryAgent:r	Ljava/io/File;
    //   13: aload_0
    //   14: getfield 384	com/flurry/android/FlurryAgent:r	Ljava/io/File;
    //   17: invokestatic 1045	com/flurry/android/FlurryAgent:a	(Ljava/io/File;)Z
    //   20: istore_3
    //   21: iload_3
    //   22: ifne +6 -> 28
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: new 928	java/io/DataOutputStream
    //   31: dup
    //   32: new 1047	java/io/FileOutputStream
    //   35: dup
    //   36: aload_0
    //   37: getfield 384	com/flurry/android/FlurryAgent:r	Ljava/io/File;
    //   40: invokespecial 1048	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   43: invokespecial 931	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   46: astore 4
    //   48: aload 4
    //   50: astore_1
    //   51: aload 4
    //   53: iconst_1
    //   54: invokevirtual 1051	java/io/DataOutputStream:writeInt	(I)V
    //   57: aload 4
    //   59: astore_1
    //   60: aload 4
    //   62: aload_2
    //   63: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   66: aload 4
    //   68: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   71: goto -46 -> 25
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    //   79: astore 5
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_1
    //   85: ldc -75
    //   87: ldc_w 1053
    //   90: aload 5
    //   92: invokestatic 217	com/flurry/android/ah:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   95: pop
    //   96: aload_2
    //   97: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   100: goto -75 -> 25
    //   103: aload_1
    //   104: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   107: aload_2
    //   108: athrow
    //   109: astore_2
    //   110: goto -7 -> 103
    //   113: astore 5
    //   115: aload 4
    //   117: astore_2
    //   118: goto -35 -> 83
    //   121: astore_2
    //   122: aconst_null
    //   123: astore_1
    //   124: goto -21 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	FlurryAgent
    //   0	127	1	paramContext	Context
    //   0	127	2	paramString	String
    //   20	2	3	bool	boolean
    //   46	70	4	localDataOutputStream	java.io.DataOutputStream
    //   79	12	5	localThrowable1	Throwable
    //   113	1	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	21	74	finally
    //   66	71	74	finally
    //   96	100	74	finally
    //   103	109	74	finally
    //   28	48	79	java/lang/Throwable
    //   51	57	109	finally
    //   60	66	109	finally
    //   85	96	109	finally
    //   51	57	113	java/lang/Throwable
    //   60	66	113	java/lang/Throwable
    //   28	48	121	finally
  }
  
  private void c(String paramString)
  {
    try
    {
      Iterator localIterator = this.T.iterator();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if (locali.a(paramString)) {
          locali.a(SystemClock.elapsedRealtime() - this.I);
        }
      }
      return;
    }
    finally {}
  }
  
  private void c(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        ah.a("FlurryAgent", "generating report");
        Object localObject = b(paramBoolean);
        if (localObject != null)
        {
          if (a((byte[])localObject))
          {
            StringBuilder localStringBuilder = new StringBuilder().append("Done sending ");
            if (!this.t) {
              break label109;
            }
            localObject = "initial ";
            ah.a("FlurryAgent", (String)localObject + "agent report");
            l();
          }
        }
        else
        {
          ah.a("FlurryAgent", "Error generating report");
          return;
        }
      }
      catch (IOException localIOException)
      {
        ah.a("FlurryAgent", "", localIOException);
        return;
      }
      catch (Throwable localThrowable)
      {
        ah.b("FlurryAgent", "", localThrowable);
      }
      return;
      label109:
      String str = "";
    }
  }
  
  public static void clearUserCookies()
  {
    if (!o) {
      return;
    }
    h.Y.k();
  }
  
  private Location d(Context paramContext)
  {
    if ((paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) || (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0))
    {
      paramContext = (LocationManager)paramContext.getSystemService("location");
      try
      {
        if (this.C == null) {
          this.C = paramContext;
        }
        for (;;)
        {
          Criteria localCriteria = n;
          Object localObject = localCriteria;
          if (localCriteria == null) {
            localObject = new Criteria();
          }
          localObject = paramContext.getBestProvider((Criteria)localObject, true);
          if (localObject == null) {
            break;
          }
          paramContext.requestLocationUpdates((String)localObject, 0L, 0.0F, this, Looper.getMainLooper());
          return paramContext.getLastKnownLocation((String)localObject);
          paramContext = this.C;
        }
        return null;
      }
      finally {}
    }
  }
  
  private static String d(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() > 4)
      {
        localObject = new StringBuilder();
        int i1 = 0;
        while (i1 < paramString.length() - 4)
        {
          ((StringBuilder)localObject).append('*');
          i1 += 1;
        }
        ((StringBuilder)localObject).append(paramString.substring(paramString.length() - 4));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return (String)localObject;
  }
  
  static boolean d()
  {
    if (!o) {
      return false;
    }
    return h.Y.m();
  }
  
  static String e()
  {
    return h.x;
  }
  
  public static void enableAppCircle()
  {
    o = true;
  }
  
  public static void endTimedEvent(String paramString)
  {
    try
    {
      h.c(paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      ah.b("FlurryAgent", "Failed to signify the end of event: " + paramString, localThrowable);
    }
  }
  
  public static int getAgentVersion()
  {
    return 121;
  }
  
  public static AppCircle getAppCircle()
  {
    return p;
  }
  
  public static boolean getForbidPlaintextFallback()
  {
    return false;
  }
  
  public static String getPhoneId()
  {
    return h.n();
  }
  
  /* Error */
  private void i()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: new 925	java/io/ByteArrayOutputStream
    //   7: dup
    //   8: invokespecial 926	java/io/ByteArrayOutputStream:<init>	()V
    //   11: astore_3
    //   12: new 928	java/io/DataOutputStream
    //   15: dup
    //   16: aload_3
    //   17: invokespecial 931	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore_2
    //   21: aload_2
    //   22: iconst_1
    //   23: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   26: aload_2
    //   27: aload_0
    //   28: getfield 820	com/flurry/android/FlurryAgent:z	Ljava/lang/String;
    //   31: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   34: aload_2
    //   35: aload_0
    //   36: getfield 341	com/flurry/android/FlurryAgent:H	J
    //   39: invokevirtual 941	java/io/DataOutputStream:writeLong	(J)V
    //   42: aload_2
    //   43: aload_0
    //   44: getfield 448	com/flurry/android/FlurryAgent:J	J
    //   47: invokevirtual 941	java/io/DataOutputStream:writeLong	(J)V
    //   50: aload_2
    //   51: lconst_0
    //   52: invokevirtual 941	java/io/DataOutputStream:writeLong	(J)V
    //   55: aload_2
    //   56: aload_0
    //   57: getfield 155	com/flurry/android/FlurryAgent:K	Ljava/lang/String;
    //   60: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   63: aload_2
    //   64: aload_0
    //   65: getfield 157	com/flurry/android/FlurryAgent:L	Ljava/lang/String;
    //   68: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   71: aload_2
    //   72: aload_0
    //   73: getfield 159	com/flurry/android/FlurryAgent:M	B
    //   76: invokevirtual 966	java/io/DataOutputStream:writeByte	(I)V
    //   79: aload_0
    //   80: getfield 161	com/flurry/android/FlurryAgent:N	Ljava/lang/String;
    //   83: ifnonnull +164 -> 247
    //   86: ldc -103
    //   88: astore_1
    //   89: aload_2
    //   90: aload_1
    //   91: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 474	com/flurry/android/FlurryAgent:R	Landroid/location/Location;
    //   98: ifnonnull +157 -> 255
    //   101: aload_2
    //   102: iconst_0
    //   103: invokevirtual 1143	java/io/DataOutputStream:writeBoolean	(Z)V
    //   106: aload_2
    //   107: aload_0
    //   108: getfield 852	com/flurry/android/FlurryAgent:X	I
    //   111: invokevirtual 1051	java/io/DataOutputStream:writeInt	(I)V
    //   114: aload_2
    //   115: iconst_m1
    //   116: invokevirtual 966	java/io/DataOutputStream:writeByte	(I)V
    //   119: aload_2
    //   120: iconst_m1
    //   121: invokevirtual 966	java/io/DataOutputStream:writeByte	(I)V
    //   124: aload_2
    //   125: aload_0
    //   126: getfield 163	com/flurry/android/FlurryAgent:O	B
    //   129: invokevirtual 966	java/io/DataOutputStream:writeByte	(I)V
    //   132: aload_0
    //   133: getfield 1145	com/flurry/android/FlurryAgent:P	Ljava/lang/Long;
    //   136: ifnonnull +178 -> 314
    //   139: aload_2
    //   140: iconst_0
    //   141: invokevirtual 1143	java/io/DataOutputStream:writeBoolean	(Z)V
    //   144: aload_2
    //   145: aload_0
    //   146: getfield 168	com/flurry/android/FlurryAgent:S	Ljava/util/Map;
    //   149: invokeinterface 608 1 0
    //   154: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   157: aload_0
    //   158: getfield 168	com/flurry/android/FlurryAgent:S	Ljava/util/Map;
    //   161: invokeinterface 1148 1 0
    //   166: invokeinterface 951 1 0
    //   171: astore_1
    //   172: aload_1
    //   173: invokeinterface 956 1 0
    //   178: ifeq +155 -> 333
    //   181: aload_1
    //   182: invokeinterface 960 1 0
    //   187: checkcast 1150	java/util/Map$Entry
    //   190: astore 4
    //   192: aload_2
    //   193: aload 4
    //   195: invokeinterface 1153 1 0
    //   200: checkcast 77	java/lang/String
    //   203: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   206: aload_2
    //   207: aload 4
    //   209: invokeinterface 1156 1 0
    //   214: checkcast 607	com/flurry/android/g
    //   217: getfield 611	com/flurry/android/g:a	I
    //   220: invokevirtual 1051	java/io/DataOutputStream:writeInt	(I)V
    //   223: goto -51 -> 172
    //   226: astore_3
    //   227: aload_2
    //   228: astore_1
    //   229: aload_3
    //   230: astore_2
    //   231: ldc -75
    //   233: ldc -103
    //   235: aload_2
    //   236: invokestatic 217	com/flurry/android/ah:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   239: pop
    //   240: aload_1
    //   241: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   244: aload_0
    //   245: monitorexit
    //   246: return
    //   247: aload_0
    //   248: getfield 161	com/flurry/android/FlurryAgent:N	Ljava/lang/String;
    //   251: astore_1
    //   252: goto -163 -> 89
    //   255: aload_2
    //   256: iconst_1
    //   257: invokevirtual 1143	java/io/DataOutputStream:writeBoolean	(Z)V
    //   260: aload_2
    //   261: aload_0
    //   262: getfield 474	com/flurry/android/FlurryAgent:R	Landroid/location/Location;
    //   265: invokevirtual 1161	android/location/Location:getLatitude	()D
    //   268: invokestatic 1163	com/flurry/android/FlurryAgent:a	(D)D
    //   271: invokevirtual 1167	java/io/DataOutputStream:writeDouble	(D)V
    //   274: aload_2
    //   275: aload_0
    //   276: getfield 474	com/flurry/android/FlurryAgent:R	Landroid/location/Location;
    //   279: invokevirtual 1170	android/location/Location:getLongitude	()D
    //   282: invokestatic 1163	com/flurry/android/FlurryAgent:a	(D)D
    //   285: invokevirtual 1167	java/io/DataOutputStream:writeDouble	(D)V
    //   288: aload_2
    //   289: aload_0
    //   290: getfield 474	com/flurry/android/FlurryAgent:R	Landroid/location/Location;
    //   293: invokevirtual 1174	android/location/Location:getAccuracy	()F
    //   296: invokevirtual 1178	java/io/DataOutputStream:writeFloat	(F)V
    //   299: goto -193 -> 106
    //   302: astore_1
    //   303: aload_2
    //   304: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   307: aload_1
    //   308: athrow
    //   309: astore_1
    //   310: aload_0
    //   311: monitorexit
    //   312: aload_1
    //   313: athrow
    //   314: aload_2
    //   315: iconst_1
    //   316: invokevirtual 1143	java/io/DataOutputStream:writeBoolean	(Z)V
    //   319: aload_2
    //   320: aload_0
    //   321: getfield 1145	com/flurry/android/FlurryAgent:P	Ljava/lang/Long;
    //   324: invokevirtual 963	java/lang/Long:longValue	()J
    //   327: invokevirtual 941	java/io/DataOutputStream:writeLong	(J)V
    //   330: goto -186 -> 144
    //   333: aload_2
    //   334: aload_0
    //   335: getfield 170	com/flurry/android/FlurryAgent:T	Ljava/util/List;
    //   338: invokeinterface 578 1 0
    //   343: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   346: aload_0
    //   347: getfield 170	com/flurry/android/FlurryAgent:T	Ljava/util/List;
    //   350: invokeinterface 1056 1 0
    //   355: astore_1
    //   356: aload_1
    //   357: invokeinterface 956 1 0
    //   362: ifeq +22 -> 384
    //   365: aload_2
    //   366: aload_1
    //   367: invokeinterface 960 1 0
    //   372: checkcast 629	com/flurry/android/i
    //   375: invokevirtual 635	com/flurry/android/i:a	()[B
    //   378: invokevirtual 1011	java/io/DataOutputStream:write	([B)V
    //   381: goto -25 -> 356
    //   384: aload_2
    //   385: aload_0
    //   386: getfield 639	com/flurry/android/FlurryAgent:U	Z
    //   389: invokevirtual 1143	java/io/DataOutputStream:writeBoolean	(Z)V
    //   392: aload_2
    //   393: aload_0
    //   394: getfield 573	com/flurry/android/FlurryAgent:Q	I
    //   397: invokevirtual 1051	java/io/DataOutputStream:writeInt	(I)V
    //   400: aload_2
    //   401: aload_0
    //   402: getfield 172	com/flurry/android/FlurryAgent:W	Ljava/util/List;
    //   405: invokeinterface 578 1 0
    //   410: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   413: aload_0
    //   414: getfield 172	com/flurry/android/FlurryAgent:W	Ljava/util/List;
    //   417: invokeinterface 1056 1 0
    //   422: astore_1
    //   423: aload_1
    //   424: invokeinterface 956 1 0
    //   429: ifeq +53 -> 482
    //   432: aload_1
    //   433: invokeinterface 960 1 0
    //   438: checkcast 580	com/flurry/android/aa
    //   441: astore 4
    //   443: aload_2
    //   444: aload 4
    //   446: getfield 585	com/flurry/android/aa:a	J
    //   449: invokevirtual 941	java/io/DataOutputStream:writeLong	(J)V
    //   452: aload_2
    //   453: aload 4
    //   455: getfield 590	com/flurry/android/aa:b	Ljava/lang/String;
    //   458: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   461: aload_2
    //   462: aload 4
    //   464: getfield 591	com/flurry/android/aa:c	Ljava/lang/String;
    //   467: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   470: aload_2
    //   471: aload 4
    //   473: getfield 592	com/flurry/android/aa:d	Ljava/lang/String;
    //   476: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   479: goto -56 -> 423
    //   482: getstatic 126	com/flurry/android/FlurryAgent:o	Z
    //   485: ifeq +53 -> 538
    //   488: aload_0
    //   489: getfield 177	com/flurry/android/FlurryAgent:Y	Lcom/flurry/android/u;
    //   492: invokevirtual 1181	com/flurry/android/u:f	()Ljava/util/List;
    //   495: astore_1
    //   496: aload_2
    //   497: aload_1
    //   498: invokeinterface 578 1 0
    //   503: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   506: aload_1
    //   507: invokeinterface 1056 1 0
    //   512: astore_1
    //   513: aload_1
    //   514: invokeinterface 956 1 0
    //   519: ifeq +24 -> 543
    //   522: aload_1
    //   523: invokeinterface 960 1 0
    //   528: checkcast 1183	com/flurry/android/p
    //   531: aload_2
    //   532: invokevirtual 1186	com/flurry/android/p:a	(Ljava/io/DataOutput;)V
    //   535: goto -22 -> 513
    //   538: aload_2
    //   539: iconst_0
    //   540: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   543: aload_0
    //   544: getfield 151	com/flurry/android/FlurryAgent:G	Ljava/util/List;
    //   547: aload_3
    //   548: invokevirtual 1020	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   551: invokeinterface 595 2 0
    //   556: pop
    //   557: aload_2
    //   558: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   561: goto -317 -> 244
    //   564: astore_1
    //   565: aconst_null
    //   566: astore_2
    //   567: goto -264 -> 303
    //   570: astore_3
    //   571: aload_1
    //   572: astore_2
    //   573: aload_3
    //   574: astore_1
    //   575: goto -272 -> 303
    //   578: astore_2
    //   579: goto -348 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	FlurryAgent
    //   3	249	1	localObject1	Object
    //   302	6	1	localObject2	Object
    //   309	4	1	localObject3	Object
    //   355	168	1	localObject4	Object
    //   564	8	1	localObject5	Object
    //   574	1	1	localObject6	Object
    //   20	553	2	localObject7	Object
    //   578	1	2	localIOException1	IOException
    //   11	6	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   226	322	3	localIOException2	IOException
    //   570	4	3	localObject8	Object
    //   190	282	4	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   21	86	226	java/io/IOException
    //   89	106	226	java/io/IOException
    //   106	144	226	java/io/IOException
    //   144	172	226	java/io/IOException
    //   172	223	226	java/io/IOException
    //   247	252	226	java/io/IOException
    //   255	299	226	java/io/IOException
    //   314	330	226	java/io/IOException
    //   333	356	226	java/io/IOException
    //   356	381	226	java/io/IOException
    //   384	423	226	java/io/IOException
    //   423	479	226	java/io/IOException
    //   482	513	226	java/io/IOException
    //   513	535	226	java/io/IOException
    //   538	543	226	java/io/IOException
    //   543	557	226	java/io/IOException
    //   21	86	302	finally
    //   89	106	302	finally
    //   106	144	302	finally
    //   144	172	302	finally
    //   172	223	302	finally
    //   247	252	302	finally
    //   255	299	302	finally
    //   314	330	302	finally
    //   333	356	302	finally
    //   356	381	302	finally
    //   384	423	302	finally
    //   423	479	302	finally
    //   482	513	302	finally
    //   513	535	302	finally
    //   538	543	302	finally
    //   543	557	302	finally
    //   240	244	309	finally
    //   303	309	309	finally
    //   557	561	309	finally
    //   4	21	564	finally
    //   231	240	570	finally
    //   4	21	578	java/io/IOException
  }
  
  protected static boolean isCaptureUncaughtExceptions()
  {
    return m;
  }
  
  private void j()
  {
    try
    {
      this.X += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static String k()
  {
    if (c != null) {
      return c;
    }
    if (l) {
      return kInsecureReportUrl;
    }
    if (k) {
      return kSecureReportUrl;
    }
    return kInsecureReportUrl;
  }
  
  /* Error */
  private void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 135	com/flurry/android/FlurryAgent:s	Ljava/io/File;
    //   6: invokestatic 1045	com/flurry/android/FlurryAgent:a	(Ljava/io/File;)Z
    //   9: istore_3
    //   10: iload_3
    //   11: ifne +10 -> 21
    //   14: aconst_null
    //   15: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: new 928	java/io/DataOutputStream
    //   24: dup
    //   25: new 1047	java/io/FileOutputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield 135	com/flurry/android/FlurryAgent:s	Ljava/io/File;
    //   33: invokespecial 1048	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   36: invokespecial 931	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   39: astore 5
    //   41: aload 5
    //   43: astore 4
    //   45: aload 5
    //   47: ldc_w 322
    //   50: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   53: aload 5
    //   55: astore 4
    //   57: aload 5
    //   59: iconst_2
    //   60: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   63: aload 5
    //   65: astore 4
    //   67: aload 5
    //   69: aload_0
    //   70: getfield 360	com/flurry/android/FlurryAgent:x	Ljava/lang/String;
    //   73: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   76: aload 5
    //   78: astore 4
    //   80: aload 5
    //   82: aload_0
    //   83: getfield 283	com/flurry/android/FlurryAgent:D	Ljava/lang/String;
    //   86: invokevirtual 971	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   89: aload 5
    //   91: astore 4
    //   93: aload 5
    //   95: aload_0
    //   96: getfield 339	com/flurry/android/FlurryAgent:E	Z
    //   99: invokevirtual 1143	java/io/DataOutputStream:writeBoolean	(Z)V
    //   102: aload 5
    //   104: astore 4
    //   106: aload 5
    //   108: aload_0
    //   109: getfield 343	com/flurry/android/FlurryAgent:F	J
    //   112: invokevirtual 941	java/io/DataOutputStream:writeLong	(J)V
    //   115: aload 5
    //   117: astore 4
    //   119: aload_0
    //   120: getfield 151	com/flurry/android/FlurryAgent:G	Ljava/util/List;
    //   123: invokeinterface 578 1 0
    //   128: iconst_1
    //   129: isub
    //   130: istore_1
    //   131: iload_1
    //   132: iflt +79 -> 211
    //   135: aload 5
    //   137: astore 4
    //   139: aload_0
    //   140: getfield 151	com/flurry/android/FlurryAgent:G	Ljava/util/List;
    //   143: iload_1
    //   144: invokeinterface 1006 2 0
    //   149: checkcast 1008	[B
    //   152: astore 6
    //   154: aload 5
    //   156: astore 4
    //   158: aload 6
    //   160: arraylength
    //   161: istore_2
    //   162: aload 5
    //   164: astore 4
    //   166: iload_2
    //   167: iconst_2
    //   168: iadd
    //   169: aload 5
    //   171: invokevirtual 1188	java/io/DataOutputStream:size	()I
    //   174: iadd
    //   175: ldc_w 1189
    //   178: if_icmple +58 -> 236
    //   181: aload 5
    //   183: astore 4
    //   185: ldc -75
    //   187: new 291	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 1191
    //   197: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: iload_1
    //   201: invokevirtual 487	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 337	com/flurry/android/ah:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   210: pop
    //   211: aload 5
    //   213: astore 4
    //   215: aload 5
    //   217: iconst_0
    //   218: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   221: aload 5
    //   223: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   226: goto -208 -> 18
    //   229: astore 4
    //   231: aload_0
    //   232: monitorexit
    //   233: aload 4
    //   235: athrow
    //   236: aload 5
    //   238: astore 4
    //   240: aload 5
    //   242: iload_2
    //   243: invokevirtual 935	java/io/DataOutputStream:writeShort	(I)V
    //   246: aload 5
    //   248: astore 4
    //   250: aload 5
    //   252: aload 6
    //   254: invokevirtual 1011	java/io/DataOutputStream:write	([B)V
    //   257: iload_1
    //   258: iconst_1
    //   259: isub
    //   260: istore_1
    //   261: goto -130 -> 131
    //   264: astore 6
    //   266: aconst_null
    //   267: astore 5
    //   269: aload 5
    //   271: astore 4
    //   273: ldc -75
    //   275: ldc -103
    //   277: aload 6
    //   279: invokestatic 217	com/flurry/android/ah:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   282: pop
    //   283: aload 5
    //   285: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   288: goto -270 -> 18
    //   291: aload 4
    //   293: invokestatic 330	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   296: aload 5
    //   298: athrow
    //   299: astore 5
    //   301: goto -10 -> 291
    //   304: astore 6
    //   306: goto -37 -> 269
    //   309: astore 5
    //   311: aconst_null
    //   312: astore 4
    //   314: goto -23 -> 291
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	FlurryAgent
    //   130	131	1	i1	int
    //   161	82	2	i2	int
    //   9	2	3	bool	boolean
    //   43	171	4	localDataOutputStream1	java.io.DataOutputStream
    //   229	5	4	localObject1	Object
    //   238	75	4	localDataOutputStream2	java.io.DataOutputStream
    //   39	258	5	localDataOutputStream3	java.io.DataOutputStream
    //   299	1	5	localObject2	Object
    //   309	1	5	localObject3	Object
    //   152	101	6	arrayOfByte	byte[]
    //   264	14	6	localThrowable1	Throwable
    //   304	1	6	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   14	18	229	finally
    //   221	226	229	finally
    //   283	288	229	finally
    //   291	299	229	finally
    //   2	10	264	java/lang/Throwable
    //   21	41	264	java/lang/Throwable
    //   45	53	299	finally
    //   57	63	299	finally
    //   67	76	299	finally
    //   80	89	299	finally
    //   93	102	299	finally
    //   106	115	299	finally
    //   119	131	299	finally
    //   139	154	299	finally
    //   158	162	299	finally
    //   166	181	299	finally
    //   185	211	299	finally
    //   215	221	299	finally
    //   240	246	299	finally
    //   250	257	299	finally
    //   273	283	299	finally
    //   45	53	304	java/lang/Throwable
    //   57	63	304	java/lang/Throwable
    //   67	76	304	java/lang/Throwable
    //   80	89	304	java/lang/Throwable
    //   93	102	304	java/lang/Throwable
    //   106	115	304	java/lang/Throwable
    //   119	131	304	java/lang/Throwable
    //   139	154	304	java/lang/Throwable
    //   158	162	304	java/lang/Throwable
    //   166	181	304	java/lang/Throwable
    //   185	211	304	java/lang/Throwable
    //   215	221	304	java/lang/Throwable
    //   240	246	304	java/lang/Throwable
    //   250	257	304	java/lang/Throwable
    //   2	10	309	finally
    //   21	41	309	finally
  }
  
  public static void logEvent(String paramString)
  {
    try
    {
      h.a(paramString, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      ah.b("FlurryAgent", "Failed to log event: " + paramString, localThrowable);
    }
  }
  
  public static void logEvent(String paramString, Map paramMap)
  {
    try
    {
      h.a(paramString, paramMap, false);
      return;
    }
    catch (Throwable paramMap)
    {
      ah.b("FlurryAgent", "Failed to log event: " + paramString, paramMap);
    }
  }
  
  public static void logEvent(String paramString, Map paramMap, boolean paramBoolean)
  {
    try
    {
      h.a(paramString, paramMap, paramBoolean);
      return;
    }
    catch (Throwable paramMap)
    {
      ah.b("FlurryAgent", "Failed to log event: " + paramString, paramMap);
    }
  }
  
  public static void logEvent(String paramString, boolean paramBoolean)
  {
    try
    {
      h.a(paramString, null, paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      ah.b("FlurryAgent", "Failed to log event: " + paramString, localThrowable);
    }
  }
  
  private void m()
  {
    try
    {
      if (this.C != null) {
        this.C.removeUpdates(this);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private String n()
  {
    try
    {
      String str = this.D;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void onEndSession(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("Null context");
    }
    try
    {
      h.a(paramContext, false);
      return;
    }
    catch (Throwable paramContext)
    {
      ah.b("FlurryAgent", "", paramContext);
    }
  }
  
  public static void onError(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      h.a(paramString1, paramString2, paramString3);
      return;
    }
    catch (Throwable paramString1)
    {
      ah.b("FlurryAgent", "", paramString1);
    }
  }
  
  public static void onEvent(String paramString)
  {
    try
    {
      h.a(paramString, null, false);
      return;
    }
    catch (Throwable paramString)
    {
      ah.b("FlurryAgent", "", paramString);
    }
  }
  
  public static void onEvent(String paramString, Map paramMap)
  {
    try
    {
      h.a(paramString, paramMap, false);
      return;
    }
    catch (Throwable paramString)
    {
      ah.b("FlurryAgent", "", paramString);
    }
  }
  
  public static void onPageView()
  {
    try
    {
      h.j();
      return;
    }
    catch (Throwable localThrowable)
    {
      ah.b("FlurryAgent", "", localThrowable);
    }
  }
  
  public static void onStartSession(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new NullPointerException("Null context");
    }
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException("Api key not specified");
    }
    try
    {
      h.b(paramContext, paramString);
      return;
    }
    catch (Throwable paramContext)
    {
      ah.b("FlurryAgent", "", paramContext);
    }
  }
  
  public static void setAge(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 110))
    {
      Date localDate = new Date(new Date(System.currentTimeMillis() - paramInt * 31449600000L).getYear(), 1, 1);
      h.P = Long.valueOf(localDate.getTime());
    }
  }
  
  public static void setCanvasUrl(String paramString)
  {
    d = paramString;
  }
  
  public static void setCaptureUncaughtExceptions(boolean paramBoolean)
  {
    synchronized (h)
    {
      if (h.t)
      {
        ah.b("FlurryAgent", "Cannot setCaptureUncaughtExceptions after onSessionStart");
        return;
      }
      m = paramBoolean;
      return;
    }
  }
  
  public static void setCatalogIntentName(String paramString)
  {
    a = paramString;
  }
  
  public static void setContinueSessionMillis(long paramLong)
  {
    if (paramLong < 5000L)
    {
      ah.b("FlurryAgent", "Invalid time set for session resumption: " + paramLong);
      return;
    }
    synchronized (h)
    {
      i = paramLong;
      return;
    }
  }
  
  public static void setDefaultNoAdsMessage(String paramString)
  {
    if (!o) {
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    u.b = str;
  }
  
  public static void setGender(byte paramByte)
  {
    switch (paramByte)
    {
    default: 
      h.O = -1;
      return;
    }
    h.O = paramByte;
  }
  
  public static void setGetAppUrl(String paramString)
  {
    f = paramString;
  }
  
  public static void setLocationCriteria(Criteria paramCriteria)
  {
    synchronized (h)
    {
      n = paramCriteria;
      return;
    }
  }
  
  public static void setLogEnabled(boolean paramBoolean)
  {
    localFlurryAgent = h;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        ah.b();
        return;
      }
      finally {}
      ah.a();
    }
  }
  
  public static void setLogEvents(boolean paramBoolean)
  {
    synchronized (h)
    {
      j = paramBoolean;
      return;
    }
  }
  
  public static void setLogLevel(int paramInt)
  {
    synchronized (h)
    {
      ah.a(paramInt);
      return;
    }
  }
  
  public static void setReportLocation(boolean paramBoolean)
  {
    synchronized (h)
    {
      h.A = paramBoolean;
      return;
    }
  }
  
  public static void setReportUrl(String paramString)
  {
    c = paramString;
  }
  
  public static void setUseHttps(boolean paramBoolean)
  {
    k = paramBoolean;
  }
  
  public static void setUserId(String paramString)
  {
    synchronized (h)
    {
      h.N = r.a(paramString, 255);
      return;
    }
  }
  
  public static void setVersionName(String paramString)
  {
    synchronized (h)
    {
      h.z = paramString;
      return;
    }
  }
  
  final void a(Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    String str = "";
    Object localObject = paramThrowable.getStackTrace();
    if ((localObject != null) && (localObject.length > 0))
    {
      str = localObject[0];
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str.getClassName()).append(".").append(str.getMethodName()).append(":").append(str.getLineNumber());
      if (paramThrowable.getMessage() != null) {
        ((StringBuilder)localObject).append(" (" + paramThrowable.getMessage() + ")");
      }
      str = ((StringBuilder)localObject).toString();
    }
    for (;;)
    {
      onError("uncaught", str, paramThrowable.getClass().toString());
      this.w.clear();
      a(null, true);
      return;
      if (paramThrowable.getMessage() != null) {
        str = paramThrowable.getMessage();
      }
    }
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    try
    {
      this.R = paramLocation;
      m();
      return;
    }
    catch (Throwable paramLocation)
    {
      for (;;)
      {
        ah.b("FlurryAgent", "", paramLocation);
      }
    }
    finally {}
  }
  
  public final void onProviderDisabled(String paramString) {}
  
  public final void onProviderEnabled(String paramString) {}
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/FlurryAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */