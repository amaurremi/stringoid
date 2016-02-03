package com.flurry.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class FlurryAgent
  implements LocationListener
{
  private static volatile String a = null;
  private static final FlurryAgent b = new FlurryAgent();
  private static long c = 10000L;
  private static long d = 20000L;
  private static boolean e = true;
  private static boolean f = false;
  private static boolean g = true;
  private static Criteria h = null;
  private static volatile String kInsecureReportUrl = "http://data.flurry.com/aar.do";
  private static volatile String kSecureReportUrl = "https://data.flurry.com/aar.do";
  private long A;
  private String B;
  private int C;
  private Location D;
  private Map E;
  private List F;
  private boolean G;
  private int H;
  private List I;
  private int J;
  private final Handler i;
  private File j = null;
  private boolean k = false;
  private boolean l = false;
  private long m;
  private Map n = new WeakHashMap();
  private String o;
  private String p;
  private String q;
  private boolean r = true;
  private List s;
  private LocationManager t;
  private String u;
  private boolean v;
  private long w;
  private List x = new ArrayList();
  private long y;
  private long z;
  
  private FlurryAgent()
  {
    HandlerThread localHandlerThread = new HandlerThread("FlurryAgent");
    localHandlerThread.start();
    this.i = new Handler(localHandlerThread.getLooper());
  }
  
  private static String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 255);
    return paramString.substring(0, 255);
  }
  
  /* Error */
  private void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 146	com/flurry/android/FlurryAgent:o	Ljava/lang/String;
    //   6: ifnull +51 -> 57
    //   9: aload_0
    //   10: getfield 146	com/flurry/android/FlurryAgent:o	Ljava/lang/String;
    //   13: aload_2
    //   14: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifne +40 -> 57
    //   20: ldc 111
    //   22: new 152	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   29: ldc -101
    //   31: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: getfield 146	com/flurry/android/FlurryAgent:o	Ljava/lang/String;
    //   38: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc -95
    //   43: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_2
    //   47: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 170	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   56: pop
    //   57: aload_0
    //   58: getfield 100	com/flurry/android/FlurryAgent:n	Ljava/util/Map;
    //   61: aload_1
    //   62: aload_1
    //   63: invokeinterface 176 3 0
    //   68: checkcast 178	android/content/Context
    //   71: ifnull +11 -> 82
    //   74: ldc 111
    //   76: ldc -76
    //   78: invokestatic 182	com/flurry/android/Flog:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   81: pop
    //   82: aload_0
    //   83: getfield 93	com/flurry/android/FlurryAgent:k	Z
    //   86: ifne +462 -> 548
    //   89: aload_0
    //   90: aload_2
    //   91: putfield 146	com/flurry/android/FlurryAgent:o	Ljava/lang/String;
    //   94: aload_0
    //   95: aload_1
    //   96: new 152	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   103: ldc -72
    //   105: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_0
    //   109: getfield 146	com/flurry/android/FlurryAgent:o	Ljava/lang/String;
    //   112: invokevirtual 187	java/lang/String:hashCode	()I
    //   115: bipush 16
    //   117: invokestatic 191	java/lang/Integer:toString	(II)Ljava/lang/String;
    //   120: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokevirtual 195	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   129: putfield 91	com/flurry/android/FlurryAgent:j	Ljava/io/File;
    //   132: getstatic 85	com/flurry/android/FlurryAgent:g	Z
    //   135: ifeq +13 -> 148
    //   138: new 197	com/flurry/android/d
    //   141: dup
    //   142: invokespecial 198	com/flurry/android/d:<init>	()V
    //   145: invokestatic 204	java/lang/Thread:setDefaultUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   148: aload_1
    //   149: invokevirtual 208	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   152: astore 7
    //   154: aload_0
    //   155: iconst_1
    //   156: putfield 93	com/flurry/android/FlurryAgent:k	Z
    //   159: aload_0
    //   160: getfield 210	com/flurry/android/FlurryAgent:q	Ljava/lang/String;
    //   163: ifnonnull +12 -> 175
    //   166: aload_0
    //   167: aload 7
    //   169: invokestatic 213	com/flurry/android/FlurryAgent:b	(Landroid/content/Context;)Ljava/lang/String;
    //   172: putfield 210	com/flurry/android/FlurryAgent:q	Ljava/lang/String;
    //   175: aload 7
    //   177: invokevirtual 216	android/content/Context:getPackageName	()Ljava/lang/String;
    //   180: astore_1
    //   181: aload_0
    //   182: getfield 218	com/flurry/android/FlurryAgent:p	Ljava/lang/String;
    //   185: ifnull +51 -> 236
    //   188: aload_0
    //   189: getfield 218	com/flurry/android/FlurryAgent:p	Ljava/lang/String;
    //   192: aload_1
    //   193: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   196: ifne +40 -> 236
    //   199: ldc 111
    //   201: new 152	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   208: ldc -36
    //   210: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_0
    //   214: getfield 218	com/flurry/android/FlurryAgent:p	Ljava/lang/String;
    //   217: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc -95
    //   222: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_1
    //   226: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 170	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   235: pop
    //   236: aload_0
    //   237: aload_1
    //   238: putfield 218	com/flurry/android/FlurryAgent:p	Ljava/lang/String;
    //   241: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   244: lstore_3
    //   245: lload_3
    //   246: aload_0
    //   247: getfield 228	com/flurry/android/FlurryAgent:m	J
    //   250: lsub
    //   251: getstatic 75	com/flurry/android/FlurryAgent:c	J
    //   254: lcmp
    //   255: ifle +377 -> 632
    //   258: ldc 111
    //   260: ldc -26
    //   262: invokestatic 232	com/flurry/android/Flog:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   265: pop
    //   266: aload_0
    //   267: invokestatic 237	java/lang/System:currentTimeMillis	()J
    //   270: putfield 239	com/flurry/android/FlurryAgent:y	J
    //   273: aload_0
    //   274: lload_3
    //   275: putfield 241	com/flurry/android/FlurryAgent:z	J
    //   278: aload_0
    //   279: ldc2_w 242
    //   282: putfield 245	com/flurry/android/FlurryAgent:A	J
    //   285: aload_0
    //   286: ldc -125
    //   288: putfield 247	com/flurry/android/FlurryAgent:B	Ljava/lang/String;
    //   291: aload_0
    //   292: iconst_0
    //   293: putfield 249	com/flurry/android/FlurryAgent:C	I
    //   296: aload_0
    //   297: aconst_null
    //   298: putfield 251	com/flurry/android/FlurryAgent:D	Landroid/location/Location;
    //   301: aload_0
    //   302: new 253	java/util/HashMap
    //   305: dup
    //   306: invokespecial 254	java/util/HashMap:<init>	()V
    //   309: putfield 256	com/flurry/android/FlurryAgent:E	Ljava/util/Map;
    //   312: aload_0
    //   313: new 104	java/util/ArrayList
    //   316: dup
    //   317: invokespecial 105	java/util/ArrayList:<init>	()V
    //   320: putfield 258	com/flurry/android/FlurryAgent:F	Ljava/util/List;
    //   323: aload_0
    //   324: iconst_1
    //   325: putfield 260	com/flurry/android/FlurryAgent:G	Z
    //   328: aload_0
    //   329: new 104	java/util/ArrayList
    //   332: dup
    //   333: invokespecial 105	java/util/ArrayList:<init>	()V
    //   336: putfield 262	com/flurry/android/FlurryAgent:I	Ljava/util/List;
    //   339: aload_0
    //   340: iconst_0
    //   341: putfield 264	com/flurry/android/FlurryAgent:H	I
    //   344: aload_0
    //   345: iconst_0
    //   346: putfield 266	com/flurry/android/FlurryAgent:J	I
    //   349: aload_0
    //   350: getfield 95	com/flurry/android/FlurryAgent:l	Z
    //   353: ifne +169 -> 522
    //   356: aload_0
    //   357: getfield 91	com/flurry/android/FlurryAgent:j	Ljava/io/File;
    //   360: invokevirtual 272	java/io/File:exists	()Z
    //   363: istore 5
    //   365: iload 5
    //   367: ifeq +71 -> 438
    //   370: new 274	java/io/DataInputStream
    //   373: dup
    //   374: new 276	java/io/FileInputStream
    //   377: dup
    //   378: aload_0
    //   379: getfield 91	com/flurry/android/FlurryAgent:j	Ljava/io/File;
    //   382: invokespecial 279	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   385: invokespecial 282	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   388: astore_2
    //   389: aload_2
    //   390: astore_1
    //   391: aload_2
    //   392: invokevirtual 285	java/io/DataInputStream:readUnsignedShort	()I
    //   395: ldc_w 286
    //   398: if_icmpne +10 -> 408
    //   401: aload_2
    //   402: astore_1
    //   403: aload_0
    //   404: aload_2
    //   405: invokespecial 289	com/flurry/android/FlurryAgent:a	(Ljava/io/DataInputStream;)V
    //   408: aload_2
    //   409: invokestatic 292	com/flurry/android/FlurryAgent:a	(Ljava/io/Closeable;)V
    //   412: aload_0
    //   413: getfield 95	com/flurry/android/FlurryAgent:l	Z
    //   416: ifne +22 -> 438
    //   419: aload_0
    //   420: getfield 91	com/flurry/android/FlurryAgent:j	Ljava/io/File;
    //   423: invokevirtual 295	java/io/File:delete	()Z
    //   426: ifne +12 -> 438
    //   429: ldc 111
    //   431: ldc_w 297
    //   434: invokestatic 170	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   437: pop
    //   438: aload_0
    //   439: getfield 95	com/flurry/android/FlurryAgent:l	Z
    //   442: ifne +80 -> 522
    //   445: aload_0
    //   446: iconst_0
    //   447: putfield 299	com/flurry/android/FlurryAgent:v	Z
    //   450: aload_0
    //   451: aload_0
    //   452: getfield 239	com/flurry/android/FlurryAgent:y	J
    //   455: putfield 301	com/flurry/android/FlurryAgent:w	J
    //   458: aload 7
    //   460: invokevirtual 305	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   463: ldc_w 307
    //   466: invokestatic 313	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   469: astore_1
    //   470: aload_1
    //   471: ifnull +130 -> 601
    //   474: aload_1
    //   475: invokevirtual 137	java/lang/String:length	()I
    //   478: ifle +123 -> 601
    //   481: aload_1
    //   482: ldc_w 315
    //   485: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   488: ifne +113 -> 601
    //   491: new 152	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   498: ldc_w 317
    //   501: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload_1
    //   505: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: astore_1
    //   512: aload_0
    //   513: aload_1
    //   514: putfield 319	com/flurry/android/FlurryAgent:u	Ljava/lang/String;
    //   517: aload_0
    //   518: iconst_1
    //   519: putfield 95	com/flurry/android/FlurryAgent:l	Z
    //   522: aload_0
    //   523: getfield 102	com/flurry/android/FlurryAgent:r	Z
    //   526: istore 5
    //   528: aload_0
    //   529: getfield 128	com/flurry/android/FlurryAgent:i	Landroid/os/Handler;
    //   532: new 321	com/flurry/android/c
    //   535: dup
    //   536: aload_0
    //   537: aload 7
    //   539: iload 5
    //   541: invokespecial 324	com/flurry/android/c:<init>	(Lcom/flurry/android/FlurryAgent;Landroid/content/Context;Z)V
    //   544: invokevirtual 328	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   547: pop
    //   548: aload_0
    //   549: monitorexit
    //   550: return
    //   551: astore 6
    //   553: aconst_null
    //   554: astore_2
    //   555: aload_2
    //   556: astore_1
    //   557: ldc 111
    //   559: ldc -125
    //   561: aload 6
    //   563: invokestatic 331	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   566: pop
    //   567: aload_2
    //   568: invokestatic 292	com/flurry/android/FlurryAgent:a	(Ljava/io/Closeable;)V
    //   571: goto -159 -> 412
    //   574: astore_1
    //   575: aload_0
    //   576: monitorexit
    //   577: aload_1
    //   578: athrow
    //   579: astore_2
    //   580: aconst_null
    //   581: astore_1
    //   582: aload_1
    //   583: invokestatic 292	com/flurry/android/FlurryAgent:a	(Ljava/io/Closeable;)V
    //   586: aload_2
    //   587: athrow
    //   588: astore_1
    //   589: ldc 111
    //   591: ldc -125
    //   593: aload_1
    //   594: invokestatic 331	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   597: pop
    //   598: goto -160 -> 438
    //   601: new 152	java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   608: ldc_w 333
    //   611: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: invokestatic 237	java/lang/System:currentTimeMillis	()J
    //   617: bipush 16
    //   619: invokestatic 338	java/lang/Long:toString	(JI)Ljava/lang/String;
    //   622: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: astore_1
    //   629: goto -117 -> 512
    //   632: ldc 111
    //   634: ldc_w 340
    //   637: invokestatic 232	com/flurry/android/Flog:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   640: pop
    //   641: aload_0
    //   642: getfield 107	com/flurry/android/FlurryAgent:x	Ljava/util/List;
    //   645: aload_0
    //   646: getfield 107	com/flurry/android/FlurryAgent:x	Ljava/util/List;
    //   649: invokeinterface 345 1 0
    //   654: iconst_1
    //   655: isub
    //   656: invokeinterface 349 2 0
    //   661: pop
    //   662: goto -114 -> 548
    //   665: astore_2
    //   666: goto -84 -> 582
    //   669: astore 6
    //   671: goto -116 -> 555
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	674	0	this	FlurryAgent
    //   0	674	1	paramContext	Context
    //   0	674	2	paramString	String
    //   244	31	3	l1	long
    //   363	177	5	bool	boolean
    //   551	11	6	localThrowable1	Throwable
    //   669	1	6	localThrowable2	Throwable
    //   152	386	7	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   370	389	551	java/lang/Throwable
    //   2	57	574	finally
    //   57	82	574	finally
    //   82	148	574	finally
    //   148	175	574	finally
    //   175	236	574	finally
    //   236	365	574	finally
    //   408	412	574	finally
    //   412	438	574	finally
    //   438	470	574	finally
    //   474	512	574	finally
    //   512	522	574	finally
    //   522	548	574	finally
    //   567	571	574	finally
    //   582	588	574	finally
    //   589	598	574	finally
    //   601	629	574	finally
    //   632	662	574	finally
    //   370	389	579	finally
    //   412	438	588	java/lang/Throwable
    //   391	401	665	finally
    //   403	408	665	finally
    //   557	567	665	finally
    //   391	401	669	java/lang/Throwable
    //   403	408	669	java/lang/Throwable
  }
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  private void a(DataInputStream paramDataInputStream)
  {
    int i1;
    try
    {
      i1 = paramDataInputStream.readUnsignedShort();
      if (i1 > 2) {
        throw new IOException("Unknown agent file version: " + i1);
      }
    }
    finally {}
    Object localObject;
    if (i1 >= 2)
    {
      localObject = paramDataInputStream.readUTF();
      if (!((String)localObject).equals(this.o)) {
        break label130;
      }
      this.u = paramDataInputStream.readUTF();
      this.v = paramDataInputStream.readBoolean();
      this.w = paramDataInputStream.readLong();
      for (;;)
      {
        i1 = paramDataInputStream.readUnsignedShort();
        if (i1 == 0) {
          break;
        }
        localObject = new byte[i1];
        paramDataInputStream.readFully((byte[])localObject);
        this.x.add(0, localObject);
      }
      this.l = true;
    }
    for (;;)
    {
      return;
      label130:
      Flog.a("FlurryAgent", "Api keys do not match, old: " + (String)localObject + ", new: " + this.o);
    }
  }
  
  /* Error */
  private void a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 262	com/flurry/android/FlurryAgent:I	Ljava/util/List;
    //   6: ifnonnull +32 -> 38
    //   9: ldc 111
    //   11: new 152	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 386
    //   21: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 170	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   34: pop
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 249	com/flurry/android/FlurryAgent:C	I
    //   43: iconst_1
    //   44: iadd
    //   45: putfield 249	com/flurry/android/FlurryAgent:C	I
    //   48: aload_0
    //   49: getfield 262	com/flurry/android/FlurryAgent:I	Ljava/util/List;
    //   52: invokeinterface 345 1 0
    //   57: bipush 10
    //   59: if_icmpge -24 -> 35
    //   62: new 388	com/flurry/android/f
    //   65: dup
    //   66: invokespecial 389	com/flurry/android/f:<init>	()V
    //   69: astore 4
    //   71: aload 4
    //   73: invokestatic 237	java/lang/System:currentTimeMillis	()J
    //   76: putfield 391	com/flurry/android/f:a	J
    //   79: aload 4
    //   81: aload_1
    //   82: invokestatic 393	com/flurry/android/FlurryAgent:a	(Ljava/lang/String;)Ljava/lang/String;
    //   85: putfield 395	com/flurry/android/f:b	Ljava/lang/String;
    //   88: aload 4
    //   90: aload_2
    //   91: invokestatic 393	com/flurry/android/FlurryAgent:a	(Ljava/lang/String;)Ljava/lang/String;
    //   94: putfield 397	com/flurry/android/f:c	Ljava/lang/String;
    //   97: aload 4
    //   99: aload_3
    //   100: invokestatic 393	com/flurry/android/FlurryAgent:a	(Ljava/lang/String;)Ljava/lang/String;
    //   103: putfield 399	com/flurry/android/f:d	Ljava/lang/String;
    //   106: aload_0
    //   107: getfield 262	com/flurry/android/FlurryAgent:I	Ljava/util/List;
    //   110: aload 4
    //   112: invokeinterface 401 2 0
    //   117: pop
    //   118: goto -83 -> 35
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	FlurryAgent
    //   0	126	1	paramString1	String
    //   0	126	2	paramString2	String
    //   0	126	3	paramString3	String
    //   69	42	4	localf	f
    // Exception table:
    //   from	to	target	type
    //   2	35	121	finally
    //   38	118	121	finally
  }
  
  private void a(String paramString, Map paramMap)
  {
    for (;;)
    {
      String str;
      try
      {
        if (this.F == null)
        {
          Flog.b("FlurryAgent", "onEvent called before onStartSession.  Event: " + paramString);
          return;
        }
        str = a(paramString);
        if (str.length() == 0) {
          continue;
        }
        paramString = (e)this.E.get(str);
        if (paramString != null) {
          break label247;
        }
        if (this.E.size() < 100)
        {
          paramString = new e();
          paramString.a = 1;
          this.E.put(str, paramString);
          if ((!e) || (this.F.size() >= 100) || (this.H >= 8000)) {
            break label322;
          }
          paramString = paramMap;
          if (paramMap == null) {
            paramString = Collections.emptyMap();
          }
          if (paramString.size() <= 10) {
            break label260;
          }
          if (!Flog.a("FlurryAgent")) {
            continue;
          }
          Flog.a("FlurryAgent", "MaxEventParams exceeded: " + paramString.size());
          continue;
        }
        if (!Flog.a("FlurryAgent")) {
          continue;
        }
      }
      finally {}
      Flog.a("FlurryAgent", "MaxEventIds exceeded: " + str);
      continue;
      label247:
      paramString.a += 1;
      continue;
      label260:
      paramString = b(str, paramString);
      if (paramString.length + this.H <= 8000)
      {
        this.F.add(paramString);
        int i1 = this.H;
        this.H = (paramString.length + i1);
      }
      else
      {
        this.H = 8000;
        this.G = false;
        continue;
        label322:
        this.G = false;
      }
    }
  }
  
  private boolean a(byte[] paramArrayOfByte)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    String str;
    if (a != null)
    {
      str = a;
      if (str != null) {
        break label30;
      }
    }
    label30:
    do
    {
      do
      {
        return bool2;
        str = kInsecureReportUrl;
        break;
        try
        {
          bool2 = a(paramArrayOfByte, str);
          bool1 = bool2;
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;) {}
        }
        bool2 = bool1;
      } while (bool1);
      bool2 = bool1;
    } while (a == null);
    return bool1;
  }
  
  private boolean a(byte[] paramArrayOfByte, String paramString)
  {
    boolean bool = true;
    Flog.a("FlurryAgent", "Sending report to: " + paramString);
    paramArrayOfByte = new ByteArrayEntity(paramArrayOfByte);
    paramArrayOfByte.setContentType("application/octet-stream");
    paramString = new HttpPost(paramString);
    paramString.setEntity(paramArrayOfByte);
    int i1 = new DefaultHttpClient().execute(paramString).getStatusLine().getStatusCode();
    if (i1 == 200) {}
    for (;;)
    {
      try
      {
        Flog.a("FlurryAgent", "Report successful");
        this.v = true;
        this.x.removeAll(this.s);
        this.s = null;
        return bool;
      }
      finally {}
      Flog.a("FlurryAgent", "Report failed");
      bool = false;
    }
  }
  
  private static String b(Context paramContext)
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
      Flog.b("FlurryAgent", "", paramContext);
    }
    return "Unknown";
  }
  
  /* Error */
  private void b(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +28 -> 31
    //   6: aload_0
    //   7: getfield 100	com/flurry/android/FlurryAgent:n	Ljava/util/Map;
    //   10: aload_1
    //   11: invokeinterface 511 2 0
    //   16: checkcast 178	android/content/Context
    //   19: ifnonnull +12 -> 31
    //   22: ldc 111
    //   24: ldc_w 513
    //   27: invokestatic 182	com/flurry/android/Flog:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   30: pop
    //   31: aload_0
    //   32: getfield 93	com/flurry/android/FlurryAgent:k	Z
    //   35: ifeq +152 -> 187
    //   38: aload_0
    //   39: getfield 100	com/flurry/android/FlurryAgent:n	Ljava/util/Map;
    //   42: invokeinterface 516 1 0
    //   47: ifeq +140 -> 187
    //   50: ldc 111
    //   52: ldc_w 518
    //   55: invokestatic 232	com/flurry/android/Flog:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   58: pop
    //   59: aload_0
    //   60: invokevirtual 520	com/flurry/android/FlurryAgent:a	()V
    //   63: aload_1
    //   64: ifnonnull +126 -> 190
    //   67: aconst_null
    //   68: astore 5
    //   70: aload_1
    //   71: ifnull +59 -> 130
    //   74: aload 5
    //   76: invokevirtual 216	android/content/Context:getPackageName	()Ljava/lang/String;
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 218	com/flurry/android/FlurryAgent:p	Ljava/lang/String;
    //   84: aload_1
    //   85: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifne +42 -> 130
    //   91: ldc 111
    //   93: new 152	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 522
    //   103: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: getfield 218	com/flurry/android/FlurryAgent:p	Ljava/lang/String;
    //   110: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 524
    //   116: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 170	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   129: pop
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 93	com/flurry/android/FlurryAgent:k	Z
    //   135: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   138: lstore_3
    //   139: aload_0
    //   140: lload_3
    //   141: putfield 228	com/flurry/android/FlurryAgent:m	J
    //   144: aload_0
    //   145: lload_3
    //   146: aload_0
    //   147: getfield 241	com/flurry/android/FlurryAgent:z	J
    //   150: lsub
    //   151: putfield 245	com/flurry/android/FlurryAgent:A	J
    //   154: aload_0
    //   155: invokespecial 526	com/flurry/android/FlurryAgent:c	()V
    //   158: aload_0
    //   159: invokespecial 528	com/flurry/android/FlurryAgent:g	()V
    //   162: iload_2
    //   163: ifne +24 -> 187
    //   166: aload_0
    //   167: getfield 128	com/flurry/android/FlurryAgent:i	Landroid/os/Handler;
    //   170: new 530	com/flurry/android/a
    //   173: dup
    //   174: aload_0
    //   175: aload 5
    //   177: invokespecial 533	com/flurry/android/a:<init>	(Lcom/flurry/android/FlurryAgent;Landroid/content/Context;)V
    //   180: getstatic 75	com/flurry/android/FlurryAgent:c	J
    //   183: invokevirtual 537	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   186: pop
    //   187: aload_0
    //   188: monitorexit
    //   189: return
    //   190: aload_1
    //   191: invokevirtual 208	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   194: astore 5
    //   196: goto -126 -> 70
    //   199: astore_1
    //   200: aload_0
    //   201: monitorexit
    //   202: aload_1
    //   203: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	FlurryAgent
    //   0	204	1	paramContext	Context
    //   0	204	2	paramBoolean	boolean
    //   138	8	3	l1	long
    //   68	127	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   6	31	199	finally
    //   31	63	199	finally
    //   74	130	199	finally
    //   130	162	199	finally
    //   166	187	199	finally
    //   190	196	199	finally
  }
  
  private static byte[] b(String paramString, Map paramMap)
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
      localDataOutputStream.writeUTF(paramString);
      localDataOutputStream.writeShort(paramMap.size());
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        localDataOutputStream.writeUTF(a((String)paramMap.getKey()));
        localDataOutputStream.writeUTF(a((String)paramMap.getValue()));
      }
      localDataOutputStream.close();
    }
    catch (IOException paramString)
    {
      return new byte[0];
    }
    paramString = localByteArrayOutputStream.toByteArray();
    return paramString;
  }
  
  private Location c(Context paramContext)
  {
    if ((paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) || (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0))
    {
      paramContext = (LocationManager)paramContext.getSystemService("location");
      try
      {
        if (this.t == null) {
          this.t = paramContext;
        }
        for (;;)
        {
          Criteria localCriteria = h;
          Object localObject = localCriteria;
          if (localCriteria == null) {
            localObject = new Criteria();
          }
          localObject = paramContext.getBestProvider((Criteria)localObject, true);
          if (localObject != null)
          {
            paramContext.requestLocationUpdates((String)localObject, 0L, 0.0F, this, Looper.getMainLooper());
            this.i.postDelayed(new b(this), d);
          }
          if (localObject == null) {
            break;
          }
          return paramContext.getLastKnownLocation((String)localObject);
          paramContext = this.t;
        }
        return null;
      }
      finally {}
    }
  }
  
  private void c()
  {
    DataOutputStream localDataOutputStream;
    Object localObject;
    for (;;)
    {
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
        localDataOutputStream.writeUTF(this.q);
        localDataOutputStream.writeLong(this.y);
        localDataOutputStream.writeLong(this.A);
        localDataOutputStream.writeUTF(this.B);
        if (this.D == null)
        {
          localDataOutputStream.writeBoolean(false);
          localDataOutputStream.writeInt(this.J);
          localDataOutputStream.writeByte(-1);
          localDataOutputStream.writeShort(this.E.size());
          localIterator = this.E.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (Map.Entry)localIterator.next();
          localDataOutputStream.writeUTF((String)((Map.Entry)localObject).getKey());
          localDataOutputStream.writeInt(((e)((Map.Entry)localObject).getValue()).a);
          continue;
        }
        localDataOutputStream.writeBoolean(true);
      }
      catch (IOException localIOException)
      {
        Flog.b("FlurryAgent", "", localIOException);
        return;
      }
      localDataOutputStream.writeDouble(this.D.getLatitude());
      localDataOutputStream.writeDouble(this.D.getLongitude());
      localDataOutputStream.writeFloat(this.D.getAccuracy());
    }
    localDataOutputStream.writeShort(this.F.size());
    Iterator localIterator = this.F.iterator();
    while (localIterator.hasNext()) {
      localDataOutputStream.write((byte[])localIterator.next());
    }
    localDataOutputStream.writeBoolean(this.G);
    localDataOutputStream.writeInt(this.C);
    localDataOutputStream.writeShort(this.I.size());
    localIterator = this.I.iterator();
    while (localIterator.hasNext())
    {
      localObject = (f)localIterator.next();
      localDataOutputStream.writeLong(((f)localObject).a);
      localDataOutputStream.writeUTF(((f)localObject).b);
      localDataOutputStream.writeUTF(((f)localObject).c);
      localDataOutputStream.writeUTF(((f)localObject).d);
    }
    localDataOutputStream.writeShort(0);
    this.x.add(localIOException.toByteArray());
  }
  
  private void d()
  {
    try
    {
      this.J += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private byte[] e()
  {
    try
    {
      localObject1 = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject1);
      localDataOutputStream.writeShort(8);
      localDataOutputStream.writeShort(0);
      localDataOutputStream.writeShort(3);
      localDataOutputStream.writeShort(30);
      localDataOutputStream.writeLong(System.currentTimeMillis());
      localDataOutputStream.writeUTF(this.o);
      localDataOutputStream.writeUTF(this.q);
      localDataOutputStream.writeUTF(this.u);
      localDataOutputStream.writeLong(this.w);
      localDataOutputStream.writeLong(this.y);
      localDataOutputStream.writeShort(4);
      localDataOutputStream.writeUTF("device.model");
      localDataOutputStream.writeUTF(Build.MODEL);
      localDataOutputStream.writeUTF("build.brand");
      localDataOutputStream.writeUTF(Build.BRAND);
      localDataOutputStream.writeUTF("build.id");
      localDataOutputStream.writeUTF(Build.ID);
      localDataOutputStream.writeUTF("version.release");
      localDataOutputStream.writeUTF(Build.VERSION.RELEASE);
      int i2 = this.x.size();
      localDataOutputStream.writeShort(i2);
      int i1 = 0;
      while (i1 < i2)
      {
        localDataOutputStream.write((byte[])this.x.get(i1));
        i1 += 1;
      }
      this.s = new ArrayList(this.x);
      localDataOutputStream.close();
      localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject1;
        Flog.b("FlurryAgent", "", localIOException);
        Object localObject2 = null;
      }
    }
    finally {}
    return (byte[])localObject1;
  }
  
  private void f()
  {
    try
    {
      byte[] arrayOfByte = e();
      if ((arrayOfByte != null) && (a(arrayOfByte))) {
        g();
      }
      return;
    }
    catch (IOException localIOException)
    {
      Flog.a("FlurryAgent", "", localIOException);
      return;
    }
    catch (Throwable localThrowable)
    {
      Flog.b("FlurryAgent", "", localThrowable);
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: monitorenter
    //   8: aload 4
    //   10: astore_3
    //   11: aload_0
    //   12: getfield 91	com/flurry/android/FlurryAgent:j	Ljava/io/File;
    //   15: invokevirtual 707	java/io/File:getParentFile	()Ljava/io/File;
    //   18: astore 6
    //   20: aload 4
    //   22: astore_3
    //   23: aload 6
    //   25: invokevirtual 710	java/io/File:mkdirs	()Z
    //   28: ifne +51 -> 79
    //   31: aload 4
    //   33: astore_3
    //   34: aload 6
    //   36: invokevirtual 272	java/io/File:exists	()Z
    //   39: ifne +40 -> 79
    //   42: aload 4
    //   44: astore_3
    //   45: ldc 111
    //   47: new 152	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   54: ldc_w 712
    //   57: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload 6
    //   62: invokevirtual 715	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 170	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   71: pop
    //   72: aconst_null
    //   73: invokestatic 292	com/flurry/android/FlurryAgent:a	(Ljava/io/Closeable;)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: aload 4
    //   81: astore_3
    //   82: new 542	java/io/DataOutputStream
    //   85: dup
    //   86: new 717	java/io/FileOutputStream
    //   89: dup
    //   90: aload_0
    //   91: getfield 91	com/flurry/android/FlurryAgent:j	Ljava/io/File;
    //   94: invokespecial 718	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   97: invokespecial 545	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   100: astore 4
    //   102: aload 4
    //   104: ldc_w 286
    //   107: invokevirtual 552	java/io/DataOutputStream:writeShort	(I)V
    //   110: aload 4
    //   112: iconst_2
    //   113: invokevirtual 552	java/io/DataOutputStream:writeShort	(I)V
    //   116: aload 4
    //   118: aload_0
    //   119: getfield 146	com/flurry/android/FlurryAgent:o	Ljava/lang/String;
    //   122: invokevirtual 548	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   125: aload 4
    //   127: aload_0
    //   128: getfield 319	com/flurry/android/FlurryAgent:u	Ljava/lang/String;
    //   131: invokevirtual 548	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   134: aload 4
    //   136: aload_0
    //   137: getfield 299	com/flurry/android/FlurryAgent:v	Z
    //   140: invokevirtual 636	java/io/DataOutputStream:writeBoolean	(Z)V
    //   143: aload 4
    //   145: aload_0
    //   146: getfield 301	com/flurry/android/FlurryAgent:w	J
    //   149: invokevirtual 632	java/io/DataOutputStream:writeLong	(J)V
    //   152: aload_0
    //   153: getfield 107	com/flurry/android/FlurryAgent:x	Ljava/util/List;
    //   156: invokeinterface 345 1 0
    //   161: iconst_1
    //   162: isub
    //   163: istore_1
    //   164: iload_1
    //   165: iflt +54 -> 219
    //   168: aload_0
    //   169: getfield 107	com/flurry/android/FlurryAgent:x	Ljava/util/List;
    //   172: iload_1
    //   173: invokeinterface 694 2 0
    //   178: checkcast 666	[B
    //   181: astore_3
    //   182: aload_3
    //   183: arraylength
    //   184: istore_2
    //   185: iload_2
    //   186: iconst_2
    //   187: iadd
    //   188: aload 4
    //   190: invokevirtual 719	java/io/DataOutputStream:size	()I
    //   193: iadd
    //   194: ldc_w 720
    //   197: if_icmpgt +22 -> 219
    //   200: aload 4
    //   202: iload_2
    //   203: invokevirtual 552	java/io/DataOutputStream:writeShort	(I)V
    //   206: aload 4
    //   208: aload_3
    //   209: invokevirtual 669	java/io/DataOutputStream:write	([B)V
    //   212: iload_1
    //   213: iconst_1
    //   214: isub
    //   215: istore_1
    //   216: goto -52 -> 164
    //   219: aload 4
    //   221: iconst_0
    //   222: invokevirtual 552	java/io/DataOutputStream:writeShort	(I)V
    //   225: aload 4
    //   227: invokestatic 292	com/flurry/android/FlurryAgent:a	(Ljava/io/Closeable;)V
    //   230: goto -154 -> 76
    //   233: astore_3
    //   234: aload_0
    //   235: monitorexit
    //   236: aload_3
    //   237: athrow
    //   238: astore_3
    //   239: aload 5
    //   241: astore 4
    //   243: aload_3
    //   244: astore 5
    //   246: aload 4
    //   248: astore_3
    //   249: ldc 111
    //   251: ldc -125
    //   253: aload 5
    //   255: invokestatic 331	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   258: pop
    //   259: aload 4
    //   261: invokestatic 292	com/flurry/android/FlurryAgent:a	(Ljava/io/Closeable;)V
    //   264: goto -188 -> 76
    //   267: aload_3
    //   268: invokestatic 292	com/flurry/android/FlurryAgent:a	(Ljava/io/Closeable;)V
    //   271: aload 4
    //   273: athrow
    //   274: astore 5
    //   276: aload 4
    //   278: astore_3
    //   279: aload 5
    //   281: astore 4
    //   283: goto -16 -> 267
    //   286: astore 5
    //   288: goto -42 -> 246
    //   291: astore 4
    //   293: goto -26 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	FlurryAgent
    //   163	53	1	i1	int
    //   184	19	2	i2	int
    //   10	199	3	localObject1	Object
    //   233	4	3	localObject2	Object
    //   238	6	3	localThrowable1	Throwable
    //   248	31	3	localObject3	Object
    //   1	281	4	localObject4	Object
    //   291	1	4	localObject5	Object
    //   4	250	5	localObject6	Object
    //   274	6	5	localObject7	Object
    //   286	1	5	localThrowable2	Throwable
    //   18	43	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   72	76	233	finally
    //   225	230	233	finally
    //   259	264	233	finally
    //   267	274	233	finally
    //   11	20	238	java/lang/Throwable
    //   23	31	238	java/lang/Throwable
    //   34	42	238	java/lang/Throwable
    //   45	72	238	java/lang/Throwable
    //   82	102	238	java/lang/Throwable
    //   102	164	274	finally
    //   168	212	274	finally
    //   219	225	274	finally
    //   102	164	286	java/lang/Throwable
    //   168	212	286	java/lang/Throwable
    //   219	225	286	java/lang/Throwable
    //   11	20	291	finally
    //   23	31	291	finally
    //   34	42	291	finally
    //   45	72	291	finally
    //   82	102	291	finally
    //   249	259	291	finally
  }
  
  public static boolean getForbidPlaintextFallback()
  {
    return false;
  }
  
  public static void onEndSession(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("Null context");
    }
    try
    {
      b.b(paramContext, false);
      return;
    }
    catch (Throwable paramContext)
    {
      Flog.b("FlurryAgent", "", paramContext);
    }
  }
  
  public static void onError(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      b.a(paramString1, paramString2, paramString3);
      return;
    }
    catch (Throwable paramString1)
    {
      Flog.b("FlurryAgent", "", paramString1);
    }
  }
  
  public static void onEvent(String paramString)
  {
    try
    {
      b.a(paramString, null);
      return;
    }
    catch (Throwable paramString)
    {
      Flog.b("FlurryAgent", "", paramString);
    }
  }
  
  public static void onEvent(String paramString, Map paramMap)
  {
    try
    {
      b.a(paramString, paramMap);
      return;
    }
    catch (Throwable paramString)
    {
      Flog.b("FlurryAgent", "", paramString);
    }
  }
  
  public static void onPageView()
  {
    try
    {
      b.d();
      return;
    }
    catch (Throwable localThrowable)
    {
      Flog.b("FlurryAgent", "", localThrowable);
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
      b.a(paramContext, paramString);
      return;
    }
    catch (Throwable paramContext)
    {
      Flog.b("FlurryAgent", "", paramContext);
    }
  }
  
  public static void setCaptureUncaughtExceptions(boolean paramBoolean)
  {
    synchronized (b)
    {
      if (b.k)
      {
        Flog.b("FlurryAgent", "Cannot setCaptureUncaughtExceptions after onSessionStart");
        return;
      }
      g = paramBoolean;
      return;
    }
  }
  
  public static void setContinueSessionMillis(long paramLong)
  {
    synchronized (b)
    {
      c = paramLong;
      return;
    }
  }
  
  public static void setLocationCriteria(Criteria paramCriteria)
  {
    synchronized (b)
    {
      h = paramCriteria;
      return;
    }
  }
  
  public static void setLocationFixTimeoutMillis(long paramLong)
  {
    synchronized (b)
    {
      d = paramLong;
      return;
    }
  }
  
  public static void setLogEnabled(boolean paramBoolean)
  {
    localFlurryAgent = b;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        Flog.enableLog();
        return;
      }
      finally {}
      Flog.disableLog();
    }
  }
  
  public static void setLogEvents(boolean paramBoolean)
  {
    synchronized (b)
    {
      e = paramBoolean;
      return;
    }
  }
  
  public static void setReportLocation(boolean paramBoolean)
  {
    synchronized (b)
    {
      b.r = false;
      return;
    }
  }
  
  public static void setReportUrl(String paramString)
  {
    a = paramString;
  }
  
  public static void setUserId(String paramString)
  {
    synchronized (b)
    {
      b.B = a(paramString);
      return;
    }
  }
  
  public static void setVersionName(String paramString)
  {
    synchronized (b)
    {
      b.q = paramString;
      return;
    }
  }
  
  final void a()
  {
    try
    {
      if (this.t != null) {
        this.t.removeUpdates(this);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  final void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 93	com/flurry/android/FlurryAgent:k	Z
    //   6: ifne +43 -> 49
    //   9: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   12: aload_0
    //   13: getfield 228	com/flurry/android/FlurryAgent:m	J
    //   16: lsub
    //   17: getstatic 75	com/flurry/android/FlurryAgent:c	J
    //   20: lcmp
    //   21: ifle +28 -> 49
    //   24: aload_0
    //   25: getfield 107	com/flurry/android/FlurryAgent:x	Ljava/util/List;
    //   28: invokeinterface 345 1 0
    //   33: ifle +16 -> 49
    //   36: iconst_1
    //   37: istore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_2
    //   41: ifeq +7 -> 48
    //   44: aload_0
    //   45: invokespecial 772	com/flurry/android/FlurryAgent:f	()V
    //   48: return
    //   49: iconst_0
    //   50: istore_2
    //   51: goto -13 -> 38
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    //   59: astore_1
    //   60: ldc 111
    //   62: ldc -125
    //   64: aload_1
    //   65: invokestatic 331	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   68: pop
    //   69: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	FlurryAgent
    //   0	70	1	paramContext	Context
    //   37	14	2	i1	int
    // Exception table:
    //   from	to	target	type
    //   2	36	54	finally
    //   38	40	54	finally
    //   55	57	54	finally
    //   0	2	59	java/lang/Throwable
    //   44	48	59	java/lang/Throwable
    //   57	59	59	java/lang/Throwable
  }
  
  /* Error */
  final void a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iload_2
    //   4: ifeq +10 -> 14
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 774	com/flurry/android/FlurryAgent:c	(Landroid/content/Context;)Landroid/location/Location;
    //   12: astore 4
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: aload 4
    //   19: putfield 251	com/flurry/android/FlurryAgent:D	Landroid/location/Location;
    //   22: aload_0
    //   23: getfield 299	com/flurry/android/FlurryAgent:v	Z
    //   26: ifeq +50 -> 76
    //   29: aload_0
    //   30: getfield 107	com/flurry/android/FlurryAgent:x	Ljava/util/List;
    //   33: invokeinterface 345 1 0
    //   38: ifle +17 -> 55
    //   41: goto +35 -> 76
    //   44: aload_0
    //   45: monitorexit
    //   46: iload_3
    //   47: ifeq +7 -> 54
    //   50: aload_0
    //   51: invokespecial 772	com/flurry/android/FlurryAgent:f	()V
    //   54: return
    //   55: iconst_0
    //   56: istore_3
    //   57: goto -13 -> 44
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    //   65: astore_1
    //   66: ldc 111
    //   68: ldc -125
    //   70: aload_1
    //   71: invokestatic 331	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   74: pop
    //   75: return
    //   76: iconst_1
    //   77: istore_3
    //   78: goto -34 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	FlurryAgent
    //   0	81	1	paramContext	Context
    //   0	81	2	paramBoolean	boolean
    //   46	32	3	i1	int
    //   1	17	4	localLocation	Location
    // Exception table:
    //   from	to	target	type
    //   16	41	60	finally
    //   44	46	60	finally
    //   61	63	60	finally
    //   7	14	65	java/lang/Throwable
    //   14	16	65	java/lang/Throwable
    //   50	54	65	java/lang/Throwable
    //   63	65	65	java/lang/Throwable
  }
  
  final void a(Throwable paramThrowable)
  {
    onError("uncaught", paramThrowable.getMessage(), paramThrowable.getClass().toString());
    this.n.clear();
    b(null, true);
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    try
    {
      this.D = paramLocation;
      a();
      return;
    }
    catch (Throwable paramLocation)
    {
      for (;;)
      {
        Flog.b("FlurryAgent", "", paramLocation);
      }
    }
    finally {}
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/flurry/android/FlurryAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */