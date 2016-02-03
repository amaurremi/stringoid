package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

public class fb
  implements fj, id
{
  private static final String a = fb.class.getSimpleName();
  private static AtomicInteger b = new AtomicInteger(0);
  private static AtomicInteger c = new AtomicInteger(0);
  private long A;
  private Map<String, eh> B = new HashMap();
  private List<ek> C = new ArrayList();
  private boolean D;
  private int E;
  private List<ej> F = new ArrayList();
  private int G;
  private Map<String, List<String>> H;
  private Map<String, List<String>> I;
  private final Handler J;
  private fh K;
  private ff L;
  private int M;
  private boolean N = false;
  private File d = null;
  private File e = null;
  private volatile boolean f = false;
  private String g;
  private String h;
  private List<ez> i;
  private Map<ie, ByteBuffer> j = new HashMap();
  private boolean k;
  private long l;
  private List<ez> m = new ArrayList();
  private String n;
  private long o;
  private long p;
  private long q;
  private long r;
  private String s = "";
  private String t = "";
  private byte u = -1;
  private int v;
  private boolean w;
  private String x;
  private byte y;
  private long z;
  
  public fb(Context paramContext, String paramString, ff paramff)
  {
    ja.a(4, a, "Initializing new Flurry session");
    HandlerThread localHandlerThread = new HandlerThread("FlurryAgentSession_" + paramString);
    localHandlerThread.start();
    this.J = new Handler(localHandlerThread.getLooper());
    s();
    this.K = new fh(this);
    this.L = paramff;
    this.g = paramString;
    this.d = paramContext.getFileStreamPath(w());
    this.e = paramContext.getFileStreamPath(g());
    this.h = ir.a();
    this.q = -1L;
    this.v = 0;
    this.t = TimeZone.getDefault().getID();
    this.s = (Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry());
    this.B = new HashMap();
    this.C = new ArrayList();
    this.D = true;
    this.F = new ArrayList();
    this.E = 0;
    this.G = 0;
    b.set(0);
    c.set(0);
    o();
  }
  
  private Location A()
  {
    return eg.a().j();
  }
  
  private void a(long paramLong)
  {
    Iterator localIterator = this.C.iterator();
    while (localIterator.hasNext())
    {
      ek localek = (ek)localIterator.next();
      if ((localek.a()) && (!localek.b())) {
        localek.a(paramLong);
      }
    }
  }
  
  private void a(Context paramContext)
  {
    try
    {
      byte[] arrayOfByte = im.a();
      if (arrayOfByte != null)
      {
        ja.a(3, a, "Fetched hashed IMEI");
        this.j.put(ie.b, ByteBuffer.wrap(arrayOfByte));
      }
      c(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      ja.a(6, a, "", paramContext);
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    em localem = eg.a().k();
    String str = "" + eg.a().b();
    localem.a(paramArrayOfByte, this.g, str);
  }
  
  /* Error */
  private void b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 103	com/flurry/android/monolithic/sdk/impl/fb:m	Ljava/util/List;
    //   6: invokeinterface 319 1 0
    //   11: ifle +17 -> 28
    //   14: iconst_1
    //   15: istore_2
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_2
    //   19: ifeq +8 -> 27
    //   22: aload_0
    //   23: aload_1
    //   24: invokespecial 290	com/flurry/android/monolithic/sdk/impl/fb:c	(Landroid/content/Context;)V
    //   27: return
    //   28: iconst_0
    //   29: istore_2
    //   30: goto -14 -> 16
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    //   38: astore_1
    //   39: bipush 6
    //   41: getstatic 73	com/flurry/android/monolithic/sdk/impl/fb:a	Ljava/lang/String;
    //   44: ldc 105
    //   46: aload_1
    //   47: invokestatic 293	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   50: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	fb
    //   0	51	1	paramContext	Context
    //   15	15	2	i1	int
    // Exception table:
    //   from	to	target	type
    //   2	14	33	finally
    //   16	18	33	finally
    //   34	36	33	finally
    //   0	2	38	java/lang/Throwable
    //   22	27	38	java/lang/Throwable
    //   36	38	38	java/lang/Throwable
  }
  
  private void c(Context paramContext)
  {
    try
    {
      ja.a(3, a, "generating agent report");
      paramContext = new el(this.g, this.h, z(), this.k, this.l, this.o, this.m, this.e, this.j, this.H, this.I);
      this.i = new ArrayList(this.m);
      if ((paramContext != null) && (paramContext.a() != null))
      {
        ja.a(3, a, "generated report of size " + paramContext.a().length + " with " + this.m.size() + " reports.");
        a(paramContext.a());
        this.m.removeAll(this.i);
        this.i = null;
        v();
        return;
      }
      ja.a(6, a, "Error generating report");
      return;
    }
    catch (Throwable paramContext)
    {
      ja.a(6, a, "", paramContext);
    }
  }
  
  /* Error */
  private void d(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	com/flurry/android/monolithic/sdk/impl/fb:d	Ljava/io/File;
    //   6: invokevirtual 372	java/io/File:exists	()Z
    //   9: ifeq +271 -> 280
    //   12: iconst_4
    //   13: getstatic 73	com/flurry/android/monolithic/sdk/impl/fb:a	Ljava/lang/String;
    //   16: new 130	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 374
    //   26: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: getfield 89	com/flurry/android/monolithic/sdk/impl/fb:d	Ljava/io/File;
    //   33: invokevirtual 377	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   36: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 126	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   45: new 379	java/io/DataInputStream
    //   48: dup
    //   49: new 381	java/io/FileInputStream
    //   52: dup
    //   53: aload_0
    //   54: getfield 89	com/flurry/android/monolithic/sdk/impl/fb:d	Ljava/io/File;
    //   57: invokespecial 384	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 387	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore_2
    //   64: aload_2
    //   65: astore_1
    //   66: new 389	com/flurry/android/monolithic/sdk/impl/fg
    //   69: dup
    //   70: invokespecial 390	com/flurry/android/monolithic/sdk/impl/fg:<init>	()V
    //   73: astore_3
    //   74: aload_2
    //   75: astore_1
    //   76: aload_0
    //   77: aload_3
    //   78: aload_2
    //   79: aload_0
    //   80: getfield 170	com/flurry/android/monolithic/sdk/impl/fb:g	Ljava/lang/String;
    //   83: invokevirtual 393	com/flurry/android/monolithic/sdk/impl/fg:a	(Ljava/io/DataInputStream;Ljava/lang/String;)Z
    //   86: putfield 93	com/flurry/android/monolithic/sdk/impl/fb:f	Z
    //   89: aload_2
    //   90: astore_1
    //   91: aload_0
    //   92: getfield 93	com/flurry/android/monolithic/sdk/impl/fb:f	Z
    //   95: ifeq +33 -> 128
    //   98: aload_2
    //   99: astore_1
    //   100: aload_0
    //   101: aload_3
    //   102: invokevirtual 394	com/flurry/android/monolithic/sdk/impl/fg:a	()Z
    //   105: putfield 330	com/flurry/android/monolithic/sdk/impl/fb:k	Z
    //   108: aload_2
    //   109: astore_1
    //   110: aload_0
    //   111: aload_3
    //   112: invokevirtual 397	com/flurry/android/monolithic/sdk/impl/fg:c	()J
    //   115: putfield 332	com/flurry/android/monolithic/sdk/impl/fb:l	J
    //   118: aload_2
    //   119: astore_1
    //   120: aload_0
    //   121: aload_3
    //   122: invokevirtual 400	com/flurry/android/monolithic/sdk/impl/fg:b	()Ljava/util/List;
    //   125: putfield 103	com/flurry/android/monolithic/sdk/impl/fb:m	Ljava/util/List;
    //   128: aload_2
    //   129: invokestatic 405	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   132: aload_0
    //   133: getfield 93	com/flurry/android/monolithic/sdk/impl/fb:f	Z
    //   136: ifne +23 -> 159
    //   139: aload_0
    //   140: getfield 89	com/flurry/android/monolithic/sdk/impl/fb:d	Ljava/io/File;
    //   143: invokevirtual 408	java/io/File:delete	()Z
    //   146: ifeq +105 -> 251
    //   149: iconst_3
    //   150: getstatic 73	com/flurry/android/monolithic/sdk/impl/fb:a	Ljava/lang/String;
    //   153: ldc_w 410
    //   156: invokestatic 126	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   159: aload_0
    //   160: getfield 93	com/flurry/android/monolithic/sdk/impl/fb:f	Z
    //   163: ifne +21 -> 184
    //   166: aload_0
    //   167: iconst_0
    //   168: putfield 330	com/flurry/android/monolithic/sdk/impl/fb:k	Z
    //   171: aload_0
    //   172: aload_0
    //   173: getfield 334	com/flurry/android/monolithic/sdk/impl/fb:o	J
    //   176: putfield 332	com/flurry/android/monolithic/sdk/impl/fb:l	J
    //   179: aload_0
    //   180: iconst_1
    //   181: putfield 93	com/flurry/android/monolithic/sdk/impl/fb:f	Z
    //   184: aload_0
    //   185: new 412	com/flurry/android/monolithic/sdk/impl/ei
    //   188: dup
    //   189: aload_0
    //   190: getfield 91	com/flurry/android/monolithic/sdk/impl/fb:e	Ljava/io/File;
    //   193: invokespecial 413	com/flurry/android/monolithic/sdk/impl/ei:<init>	(Ljava/io/File;)V
    //   196: invokevirtual 416	com/flurry/android/monolithic/sdk/impl/ei:a	()Ljava/util/Map;
    //   199: putfield 336	com/flurry/android/monolithic/sdk/impl/fb:H	Ljava/util/Map;
    //   202: aload_0
    //   203: monitorexit
    //   204: return
    //   205: astore_3
    //   206: aload_2
    //   207: astore_1
    //   208: aload_3
    //   209: invokevirtual 419	java/io/IOException:printStackTrace	()V
    //   212: goto -84 -> 128
    //   215: astore_3
    //   216: aload_2
    //   217: astore_1
    //   218: bipush 6
    //   220: getstatic 73	com/flurry/android/monolithic/sdk/impl/fb:a	Ljava/lang/String;
    //   223: ldc_w 421
    //   226: aload_3
    //   227: invokestatic 293	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   230: aload_2
    //   231: invokestatic 405	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   234: goto -102 -> 132
    //   237: astore_1
    //   238: aload_0
    //   239: monitorexit
    //   240: aload_1
    //   241: athrow
    //   242: astore_2
    //   243: aconst_null
    //   244: astore_1
    //   245: aload_1
    //   246: invokestatic 405	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   249: aload_2
    //   250: athrow
    //   251: bipush 6
    //   253: getstatic 73	com/flurry/android/monolithic/sdk/impl/fb:a	Ljava/lang/String;
    //   256: ldc_w 423
    //   259: invokestatic 126	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   262: goto -103 -> 159
    //   265: astore_1
    //   266: bipush 6
    //   268: getstatic 73	com/flurry/android/monolithic/sdk/impl/fb:a	Ljava/lang/String;
    //   271: ldc 105
    //   273: aload_1
    //   274: invokestatic 293	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   277: goto -118 -> 159
    //   280: iconst_4
    //   281: getstatic 73	com/flurry/android/monolithic/sdk/impl/fb:a	Ljava/lang/String;
    //   284: ldc_w 425
    //   287: invokestatic 126	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   290: goto -131 -> 159
    //   293: astore_2
    //   294: goto -49 -> 245
    //   297: astore_3
    //   298: aconst_null
    //   299: astore_2
    //   300: goto -84 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	fb
    //   0	303	1	paramContext	Context
    //   63	168	2	localDataInputStream	java.io.DataInputStream
    //   242	8	2	localObject1	Object
    //   293	1	2	localObject2	Object
    //   299	1	2	localObject3	Object
    //   73	49	3	localfg	fg
    //   205	4	3	localIOException	java.io.IOException
    //   215	12	3	localThrowable1	Throwable
    //   297	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   66	74	205	java/io/IOException
    //   76	89	205	java/io/IOException
    //   91	98	205	java/io/IOException
    //   100	108	205	java/io/IOException
    //   110	118	205	java/io/IOException
    //   120	128	205	java/io/IOException
    //   66	74	215	java/lang/Throwable
    //   76	89	215	java/lang/Throwable
    //   91	98	215	java/lang/Throwable
    //   100	108	215	java/lang/Throwable
    //   110	118	215	java/lang/Throwable
    //   120	128	215	java/lang/Throwable
    //   208	212	215	java/lang/Throwable
    //   2	45	237	finally
    //   128	132	237	finally
    //   132	159	237	finally
    //   159	184	237	finally
    //   184	202	237	finally
    //   230	234	237	finally
    //   245	251	237	finally
    //   251	262	237	finally
    //   266	277	237	finally
    //   280	290	237	finally
    //   45	64	242	finally
    //   132	159	265	java/lang/Throwable
    //   251	262	265	java/lang/Throwable
    //   66	74	293	finally
    //   76	89	293	finally
    //   91	98	293	finally
    //   100	108	293	finally
    //   110	118	293	finally
    //   120	128	293	finally
    //   208	212	293	finally
    //   218	230	293	finally
    //   45	64	297	java/lang/Throwable
  }
  
  private void m()
  {
    if (this.K.b()) {
      this.K.a();
    }
    this.M += 1;
  }
  
  private void n()
  {
    this.M -= 1;
  }
  
  private void o()
  {
    ic localic = ib.a();
    this.y = ((Byte)localic.a("Gender")).byteValue();
    localic.a("Gender", this);
    ja.a(4, a, "initSettings, Gender = " + this.y);
    this.x = ((String)localic.a("UserId"));
    localic.a("UserId", this);
    ja.a(4, a, "initSettings, UserId = " + this.x);
    this.w = ((Boolean)localic.a("LogEvents")).booleanValue();
    localic.a("LogEvents", this);
    ja.a(4, a, "initSettings, LogEvents = " + this.w);
    this.z = ((Long)localic.a("Age")).longValue();
    localic.a("Age", this);
    ja.a(4, a, "initSettings, BirthDate = " + this.z);
    this.A = ((Long)localic.a("ContinueSessionMillis")).longValue();
    localic.a("ContinueSessionMillis", this);
    ja.a(4, a, "initSettings, ContinueSessionMillis = " + this.A);
  }
  
  private void p()
  {
    ja.a(5, a, "Start session");
    long l1 = SystemClock.elapsedRealtime();
    this.o = System.currentTimeMillis();
    this.p = l1;
    a(new fc(this));
  }
  
  private void q()
  {
    ja.a(5, a, "Continuing previous session");
    if (!this.m.isEmpty()) {
      this.m.remove(this.m.size() - 1);
    }
  }
  
  private void r()
  {
    if (a() != 0) {
      ja.a(6, a, "Error! Session with apiKey = " + i() + " was ended while getSessionCount() is not 0");
    }
    e();
  }
  
  private void s()
  {
    if (TextUtils.isEmpty(this.n)) {
      a(new fd(this));
    }
  }
  
  private void t()
  {
    a(new fe(this, ia.a().b()));
  }
  
  /* Error */
  private ez u()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 560	com/flurry/android/monolithic/sdk/impl/fa
    //   5: dup
    //   6: invokespecial 561	com/flurry/android/monolithic/sdk/impl/fa:<init>	()V
    //   9: astore_1
    //   10: aload_1
    //   11: aload_0
    //   12: getfield 186	com/flurry/android/monolithic/sdk/impl/fb:h	Ljava/lang/String;
    //   15: invokevirtual 563	com/flurry/android/monolithic/sdk/impl/fa:a	(Ljava/lang/String;)V
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 334	com/flurry/android/monolithic/sdk/impl/fb:o	J
    //   23: invokevirtual 564	com/flurry/android/monolithic/sdk/impl/fa:a	(J)V
    //   26: aload_1
    //   27: aload_0
    //   28: getfield 190	com/flurry/android/monolithic/sdk/impl/fb:q	J
    //   31: invokevirtual 566	com/flurry/android/monolithic/sdk/impl/fa:b	(J)V
    //   34: aload_1
    //   35: aload_0
    //   36: getfield 568	com/flurry/android/monolithic/sdk/impl/fb:r	J
    //   39: invokevirtual 570	com/flurry/android/monolithic/sdk/impl/fa:c	(J)V
    //   42: aload_1
    //   43: aload_0
    //   44: invokevirtual 572	com/flurry/android/monolithic/sdk/impl/fb:j	()Ljava/lang/String;
    //   47: invokevirtual 574	com/flurry/android/monolithic/sdk/impl/fa:b	(Ljava/lang/String;)V
    //   50: aload_1
    //   51: aload_0
    //   52: invokevirtual 576	com/flurry/android/monolithic/sdk/impl/fb:k	()Ljava/lang/String;
    //   55: invokevirtual 578	com/flurry/android/monolithic/sdk/impl/fa:c	(Ljava/lang/String;)V
    //   58: aload_1
    //   59: aload_0
    //   60: getfield 111	com/flurry/android/monolithic/sdk/impl/fb:u	B
    //   63: invokevirtual 580	com/flurry/android/monolithic/sdk/impl/fa:a	(I)V
    //   66: aload_1
    //   67: aload_0
    //   68: invokevirtual 582	com/flurry/android/monolithic/sdk/impl/fb:h	()Ljava/lang/String;
    //   71: invokevirtual 584	com/flurry/android/monolithic/sdk/impl/fa:d	(Ljava/lang/String;)V
    //   74: aload_1
    //   75: aload_0
    //   76: invokespecial 586	com/flurry/android/monolithic/sdk/impl/fb:A	()Landroid/location/Location;
    //   79: invokevirtual 589	com/flurry/android/monolithic/sdk/impl/fa:a	(Landroid/location/Location;)V
    //   82: aload_1
    //   83: aload_0
    //   84: getfield 220	com/flurry/android/monolithic/sdk/impl/fb:G	I
    //   87: invokevirtual 591	com/flurry/android/monolithic/sdk/impl/fa:b	(I)V
    //   90: aload_1
    //   91: aload_0
    //   92: getfield 451	com/flurry/android/monolithic/sdk/impl/fb:y	B
    //   95: invokevirtual 594	com/flurry/android/monolithic/sdk/impl/fa:a	(B)V
    //   98: aload_1
    //   99: aload_0
    //   100: getfield 487	com/flurry/android/monolithic/sdk/impl/fb:z	J
    //   103: invokestatic 598	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   106: invokevirtual 601	com/flurry/android/monolithic/sdk/impl/fa:a	(Ljava/lang/Long;)V
    //   109: aload_1
    //   110: aload_0
    //   111: getfield 115	com/flurry/android/monolithic/sdk/impl/fb:C	Ljava/util/List;
    //   114: invokevirtual 604	com/flurry/android/monolithic/sdk/impl/fa:a	(Ljava/util/List;)V
    //   117: aload_1
    //   118: aload_0
    //   119: getfield 113	com/flurry/android/monolithic/sdk/impl/fb:B	Ljava/util/Map;
    //   122: invokevirtual 607	com/flurry/android/monolithic/sdk/impl/fa:a	(Ljava/util/Map;)V
    //   125: aload_1
    //   126: aload_0
    //   127: getfield 117	com/flurry/android/monolithic/sdk/impl/fb:F	Ljava/util/List;
    //   130: invokevirtual 609	com/flurry/android/monolithic/sdk/impl/fa:b	(Ljava/util/List;)V
    //   133: aload_1
    //   134: aload_0
    //   135: getfield 192	com/flurry/android/monolithic/sdk/impl/fb:v	I
    //   138: invokevirtual 611	com/flurry/android/monolithic/sdk/impl/fa:c	(I)V
    //   141: aload_1
    //   142: aload_0
    //   143: getfield 216	com/flurry/android/monolithic/sdk/impl/fb:D	Z
    //   146: invokevirtual 614	com/flurry/android/monolithic/sdk/impl/fa:a	(Z)V
    //   149: new 616	com/flurry/android/monolithic/sdk/impl/ez
    //   152: dup
    //   153: aload_1
    //   154: invokespecial 619	com/flurry/android/monolithic/sdk/impl/ez:<init>	(Lcom/flurry/android/monolithic/sdk/impl/fa;)V
    //   157: astore_1
    //   158: aload_1
    //   159: ifnonnull +14 -> 173
    //   162: bipush 6
    //   164: getstatic 73	com/flurry/android/monolithic/sdk/impl/fb:a	Ljava/lang/String;
    //   167: ldc_w 621
    //   170: invokestatic 126	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   173: aload_0
    //   174: monitorexit
    //   175: aload_1
    //   176: areturn
    //   177: astore_1
    //   178: aload_1
    //   179: invokevirtual 419	java/io/IOException:printStackTrace	()V
    //   182: aconst_null
    //   183: astore_1
    //   184: goto -26 -> 158
    //   187: astore_1
    //   188: aload_0
    //   189: monitorexit
    //   190: aload_1
    //   191: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	fb
    //   9	167	1	localObject1	Object
    //   177	2	1	localIOException	java.io.IOException
    //   183	1	1	localObject2	Object
    //   187	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   149	158	177	java/io/IOException
    //   2	149	187	finally
    //   149	158	187	finally
    //   162	173	187	finally
    //   178	182	187	finally
  }
  
  /* Error */
  private void v()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	com/flurry/android/monolithic/sdk/impl/fb:d	Ljava/io/File;
    //   6: invokestatic 628	com/flurry/android/monolithic/sdk/impl/iw:a	(Ljava/io/File;)Z
    //   9: ifne +17 -> 26
    //   12: bipush 6
    //   14: getstatic 73	com/flurry/android/monolithic/sdk/impl/fb:a	Ljava/lang/String;
    //   17: ldc_w 630
    //   20: invokestatic 126	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: new 632	java/io/DataOutputStream
    //   29: dup
    //   30: new 634	java/io/FileOutputStream
    //   33: dup
    //   34: aload_0
    //   35: getfield 89	com/flurry/android/monolithic/sdk/impl/fb:d	Ljava/io/File;
    //   38: invokespecial 635	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   41: invokespecial 638	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   44: astore_1
    //   45: new 389	com/flurry/android/monolithic/sdk/impl/fg
    //   48: dup
    //   49: invokespecial 390	com/flurry/android/monolithic/sdk/impl/fg:<init>	()V
    //   52: astore_2
    //   53: aload_2
    //   54: aload_0
    //   55: getfield 330	com/flurry/android/monolithic/sdk/impl/fb:k	Z
    //   58: invokevirtual 639	com/flurry/android/monolithic/sdk/impl/fg:a	(Z)V
    //   61: aload_2
    //   62: aload_0
    //   63: getfield 332	com/flurry/android/monolithic/sdk/impl/fb:l	J
    //   66: invokevirtual 640	com/flurry/android/monolithic/sdk/impl/fg:a	(J)V
    //   69: aload_2
    //   70: aload_0
    //   71: getfield 103	com/flurry/android/monolithic/sdk/impl/fb:m	Ljava/util/List;
    //   74: invokevirtual 641	com/flurry/android/monolithic/sdk/impl/fg:a	(Ljava/util/List;)V
    //   77: aload_2
    //   78: aload_1
    //   79: aload_0
    //   80: getfield 170	com/flurry/android/monolithic/sdk/impl/fb:g	Ljava/lang/String;
    //   83: aload_0
    //   84: invokespecial 328	com/flurry/android/monolithic/sdk/impl/fb:z	()Ljava/lang/String;
    //   87: invokevirtual 644	com/flurry/android/monolithic/sdk/impl/fg:a	(Ljava/io/DataOutputStream;Ljava/lang/String;Ljava/lang/String;)V
    //   90: goto -67 -> 23
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 645	java/io/FileNotFoundException:printStackTrace	()V
    //   98: goto -75 -> 23
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 419	java/io/IOException:printStackTrace	()V
    //   111: goto -88 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	fb
    //   44	35	1	localDataOutputStream	java.io.DataOutputStream
    //   93	2	1	localFileNotFoundException	java.io.FileNotFoundException
    //   101	4	1	localObject	Object
    //   106	2	1	localIOException	java.io.IOException
    //   52	26	2	localfg	fg
    // Exception table:
    //   from	to	target	type
    //   26	90	93	java/io/FileNotFoundException
    //   2	23	101	finally
    //   26	90	101	finally
    //   94	98	101	finally
    //   107	111	101	finally
    //   26	90	106	java/io/IOException
  }
  
  private String w()
  {
    return ".flurryagent." + Integer.toString(this.g.hashCode(), 16);
  }
  
  private static int x()
  {
    return b.incrementAndGet();
  }
  
  private static int y()
  {
    return c.incrementAndGet();
  }
  
  private String z()
  {
    return this.n;
  }
  
  int a()
  {
    return this.M;
  }
  
  public void a(jf paramjf)
  {
    this.J.post(paramjf);
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString.equals("Gender"))
    {
      this.y = ((Byte)paramObject).byteValue();
      ja.a(4, a, "onSettingUpdate, Gender = " + this.y);
      return;
    }
    if (paramString.equals("UserId"))
    {
      this.x = ((String)paramObject);
      ja.a(4, a, "onSettingUpdate, UserId = " + this.x);
      return;
    }
    if (paramString.equals("LogEvents"))
    {
      this.w = ((Boolean)paramObject).booleanValue();
      ja.a(4, a, "onSettingUpdate, LogEvents = " + this.w);
      return;
    }
    if (paramString.equals("Age"))
    {
      this.z = ((Long)paramObject).longValue();
      ja.a(4, a, "onSettingUpdate, Birthdate = " + this.z);
      return;
    }
    if (paramString.equals("ContinueSessionMillis"))
    {
      this.A = ((Long)paramObject).longValue();
      ja.a(4, a, "onSettingUpdate, ContinueSessionMillis = " + this.A);
      return;
    }
    ja.a(6, a, "onSettingUpdate internal error!");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    label165:
    label290:
    for (;;)
    {
      int i1;
      long l1;
      try
      {
        if (this.F == null)
        {
          ja.a(6, a, "onError called before onStartSession.  Error: " + paramString1);
          return;
        }
        if ((paramString1 != null) && ("uncaught".equals(paramString1)))
        {
          i1 = 1;
          this.v += 1;
          if (this.F.size() >= 50) {
            break label165;
          }
          l1 = System.currentTimeMillis();
          paramString1 = new ej(y(), Long.valueOf(l1).longValue(), paramString1, paramString2, paramString3, paramThrowable);
          this.F.add(paramString1);
          ja.a(3, a, "Error logged: " + paramString1.c());
          continue;
        }
        i1 = 0;
      }
      finally {}
      continue;
      if (i1 != 0) {
        i1 = 0;
      }
      for (;;)
      {
        if (i1 >= this.F.size()) {
          break label290;
        }
        ej localej = (ej)this.F.get(i1);
        if ((localej.c() != null) && (!"uncaught".equals(localej.c())))
        {
          l1 = System.currentTimeMillis();
          paramString1 = new ej(y(), Long.valueOf(l1).longValue(), paramString1, paramString2, paramString3, paramThrowable);
          this.F.set(i1, paramString1);
          break;
          ja.a(3, a, "Max errors logged. No more errors logged.");
          break;
        }
        i1 += 1;
      }
    }
  }
  
  public void a(String paramString, Map<String, String> paramMap)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.C.iterator();
        ek localek;
        int i1;
        if (localIterator.hasNext())
        {
          localek = (ek)localIterator.next();
          if (!localek.a(paramString)) {
            continue;
          }
          long l1 = SystemClock.elapsedRealtime();
          long l2 = this.p;
          if ((paramMap != null) && (paramMap.size() > 0) && (this.E < 160000))
          {
            i1 = this.E - localek.d();
            paramString = new HashMap(localek.c());
            localek.a(paramMap);
            if (localek.d() + i1 > 160000) {
              break label210;
            }
            if (localek.c().size() > 10)
            {
              ja.a(5, a, "MaxEventParams exceeded on endEvent: " + localek.c().size());
              localek.b(paramString);
            }
          }
          else
          {
            localek.a(l1 - l2);
          }
        }
        else
        {
          return;
        }
        this.E = (i1 + localek.d());
        continue;
        localek.b(paramString);
      }
      finally {}
      label210:
      this.D = false;
      this.E = 160000;
      ja.a(5, a, "Event Log size exceeded. No more event details logged.");
    }
  }
  
  public void a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    for (;;)
    {
      long l1;
      long l2;
      String str;
      try
      {
        if (this.C == null)
        {
          ja.a(6, a, "onEvent called before onStartSession.  Event: " + paramString);
          return;
        }
        l1 = SystemClock.elapsedRealtime();
        l2 = this.p;
        str = je.a(paramString);
        if (str.length() == 0) {
          continue;
        }
        paramString = (eh)this.B.get(str);
        if (paramString != null) {
          break label274;
        }
        if (this.B.size() < 100)
        {
          paramString = new eh();
          paramString.a = 1;
          this.B.put(str, paramString);
          ja.a(3, a, "Event count incremented: " + str);
          if ((!this.w) || (this.C.size() >= 1000) || (this.E >= 160000)) {
            break label378;
          }
          if (paramMap != null) {
            break label386;
          }
          paramString = Collections.emptyMap();
          if (paramString.size() <= 10) {
            break label287;
          }
          ja.a(5, a, "MaxEventParams exceeded: " + paramString.size());
          continue;
        }
        ja.a(5, a, "Too many different events. Event not counted: " + str);
      }
      finally {}
      continue;
      label274:
      paramString.a += 1;
      continue;
      label287:
      paramString = new ek(x(), str, paramString, l1 - l2, paramBoolean);
      if (paramString.d() + this.E <= 160000)
      {
        this.C.add(paramString);
        int i1 = this.E;
        this.E = (paramString.d() + i1);
      }
      else
      {
        this.E = 160000;
        this.D = false;
        ja.a(5, a, "Event Log size exceeded. No more event details logged.");
        continue;
        label378:
        this.D = false;
        continue;
        label386:
        paramString = paramMap;
      }
    }
  }
  
  public void a(Map<String, List<String>> paramMap)
  {
    this.I = paramMap;
  }
  
  public void b()
  {
    this.k = true;
  }
  
  public void c()
  {
    m();
    if (!this.N)
    {
      p();
      this.N = true;
      return;
    }
    q();
  }
  
  public void d()
  {
    ja.a(5, a, "Trying to end session");
    if (!this.N) {}
    do
    {
      return;
      if (a() > 0) {
        n();
      }
    } while (a() != 0);
    this.K.a(this.A);
  }
  
  public void e()
  {
    if (!this.N) {
      return;
    }
    ja.a(5, a, "Ending session");
    this.M = 0;
    if (this.K.b()) {
      this.K.a();
    }
    this.q = (SystemClock.elapsedRealtime() - this.p);
    a(this.q);
    t();
    if (this.L != null) {
      this.L.d(i());
    }
    ib.a().b("Gender", this);
    ib.a().b("UserId", this);
    ib.a().b("Age", this);
    ib.a().b("LogEvents", this);
    ib.a().b("ContinueSessionMillis", this);
    this.J.getLooper().quit();
  }
  
  public void f()
  {
    try
    {
      this.G += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  String g()
  {
    return ".flurryinstallreceiver.";
  }
  
  String h()
  {
    if (this.x == null) {
      return "";
    }
    return this.x;
  }
  
  public String i()
  {
    return this.g;
  }
  
  public String j()
  {
    return this.s;
  }
  
  public String k()
  {
    return this.t;
  }
  
  public void l()
  {
    r();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/fb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */