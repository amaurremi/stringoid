package com.jiubang.core.c.a;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.gtp.go.weather.sharephoto.d.m;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class b
{
  private Context a;
  private ConcurrentHashMap b;
  private d c;
  private volatile boolean d = false;
  private ExecutorService e;
  private e f;
  private boolean g = true;
  private boolean h = false;
  private boolean i = false;
  private c j;
  
  public b(Context paramContext)
  {
    this.a = paramContext;
    this.b = new ConcurrentHashMap();
    this.c = new d(this);
    this.f = new e(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.a.registerReceiver(this.f, localIntentFilter);
    this.d = false;
    int k = a();
    this.g = com.gtp.a.a.c.d.b(paramContext);
    this.e = Executors.newFixedThreadPool(k);
  }
  
  private int a()
  {
    int k = 4;
    switch (com.gtp.a.a.c.d.a(this.a))
    {
    default: 
      k = 3;
    case 1: 
    case 4: 
      return k;
    case 2: 
      return 2;
    }
    return 3;
  }
  
  public static String a(String paramString)
  {
    String str = m.a(paramString);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return Integer.toString(paramString.hashCode());
  }
  
  /* Error */
  private boolean a(a parama, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iconst_0
    //   4: istore 10
    //   6: iconst_0
    //   7: istore 8
    //   9: iconst_0
    //   10: istore 7
    //   12: iload 7
    //   14: istore 6
    //   16: aload_2
    //   17: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +263 -> 283
    //   23: iload 7
    //   25: istore 6
    //   27: aload_3
    //   28: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne +252 -> 283
    //   34: aload_0
    //   35: getfield 48	com/jiubang/core/c/a/b:c	Lcom/jiubang/core/c/a/d;
    //   38: aload_0
    //   39: getfield 48	com/jiubang/core/c/a/b:c	Lcom/jiubang/core/c/a/d;
    //   42: iconst_0
    //   43: aload_1
    //   44: invokevirtual 121	com/jiubang/core/c/a/d:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   47: invokevirtual 125	com/jiubang/core/c/a/d:sendMessage	(Landroid/os/Message;)Z
    //   50: pop
    //   51: new 127	com/jiubang/goweather/b/e
    //   54: dup
    //   55: aload_2
    //   56: ldc -127
    //   58: invokespecial 132	com/jiubang/goweather/b/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: astore 15
    //   63: new 134	com/jiubang/goweather/b/f
    //   66: dup
    //   67: invokespecial 135	com/jiubang/goweather/b/f:<init>	()V
    //   70: astore 17
    //   72: invokestatic 140	com/jiubang/goweather/b/d:a	()Lcom/jiubang/goweather/b/c;
    //   75: astore 16
    //   77: aload 16
    //   79: aload_2
    //   80: aload 15
    //   82: aload 17
    //   84: invokevirtual 145	com/jiubang/goweather/b/c:a	(Ljava/lang/String;Lcom/jiubang/goweather/b/e;Lcom/jiubang/goweather/b/f;)Ljava/io/InputStream;
    //   87: astore 16
    //   89: iload 7
    //   91: istore 6
    //   93: aload 16
    //   95: ifnull +188 -> 283
    //   98: aconst_null
    //   99: astore 15
    //   101: invokestatic 150	com/gau/go/launcherex/gowidget/statistics/y:a	()Z
    //   104: ifeq +355 -> 459
    //   107: new 152	java/io/FileOutputStream
    //   110: dup
    //   111: aload_3
    //   112: invokespecial 154	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   115: astore 15
    //   117: aload 15
    //   119: astore_2
    //   120: aload 17
    //   122: invokevirtual 158	com/jiubang/goweather/b/f:o	()J
    //   125: lstore 13
    //   127: lconst_0
    //   128: lstore 11
    //   130: aload 15
    //   132: astore_2
    //   133: sipush 8192
    //   136: newarray <illegal type>
    //   138: astore 17
    //   140: aload 15
    //   142: astore_2
    //   143: aload_0
    //   144: getfield 34	com/jiubang/core/c/a/b:i	Z
    //   147: ifne +156 -> 303
    //   150: aload 15
    //   152: astore_2
    //   153: aload 16
    //   155: aload 17
    //   157: iconst_0
    //   158: sipush 8192
    //   161: invokevirtual 164	java/io/InputStream:read	([BII)I
    //   164: istore 4
    //   166: iload 4
    //   168: iconst_m1
    //   169: if_icmpeq +134 -> 303
    //   172: aload 15
    //   174: astore_2
    //   175: aload 15
    //   177: aload 17
    //   179: iconst_0
    //   180: iload 4
    //   182: invokevirtual 168	java/io/FileOutputStream:write	([BII)V
    //   185: lload 11
    //   187: iload 4
    //   189: i2l
    //   190: ladd
    //   191: lstore 11
    //   193: lload 13
    //   195: lconst_0
    //   196: lcmp
    //   197: ifle +100 -> 297
    //   200: aload 15
    //   202: astore_2
    //   203: ldc2_w 169
    //   206: lload 11
    //   208: lmul
    //   209: lload 13
    //   211: ldiv
    //   212: l2i
    //   213: istore 4
    //   215: aload 15
    //   217: astore_2
    //   218: aload_1
    //   219: iload 4
    //   221: putfield 175	com/jiubang/core/c/a/a:e	I
    //   224: aload 15
    //   226: astore_2
    //   227: aload_0
    //   228: getfield 48	com/jiubang/core/c/a/b:c	Lcom/jiubang/core/c/a/d;
    //   231: aload_0
    //   232: getfield 48	com/jiubang/core/c/a/b:c	Lcom/jiubang/core/c/a/d;
    //   235: iconst_1
    //   236: aload_1
    //   237: invokevirtual 121	com/jiubang/core/c/a/d:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   240: invokevirtual 125	com/jiubang/core/c/a/d:sendMessage	(Landroid/os/Message;)Z
    //   243: pop
    //   244: goto -104 -> 140
    //   247: astore_1
    //   248: aload 15
    //   250: astore_2
    //   251: aload_1
    //   252: invokevirtual 178	java/io/FileNotFoundException:printStackTrace	()V
    //   255: aload 15
    //   257: ifnull +8 -> 265
    //   260: aload 15
    //   262: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   265: iload 7
    //   267: istore 6
    //   269: aload 16
    //   271: ifnull +12 -> 283
    //   274: aload 16
    //   276: invokevirtual 182	java/io/InputStream:close	()V
    //   279: iload 7
    //   281: istore 6
    //   283: iload 6
    //   285: ireturn
    //   286: astore_2
    //   287: aload_2
    //   288: invokevirtual 183	java/lang/IllegalArgumentException:printStackTrace	()V
    //   291: aconst_null
    //   292: astore 16
    //   294: goto -205 -> 89
    //   297: iconst_0
    //   298: istore 4
    //   300: goto -85 -> 215
    //   303: aload 15
    //   305: astore_2
    //   306: aload_0
    //   307: getfield 34	com/jiubang/core/c/a/b:i	Z
    //   310: ifeq +19 -> 329
    //   313: aload 15
    //   315: astore_2
    //   316: aload_1
    //   317: getfield 175	com/jiubang/core/c/a/a:e	I
    //   320: istore 4
    //   322: iload 4
    //   324: bipush 100
    //   326: if_icmpne +42 -> 368
    //   329: iconst_1
    //   330: istore 5
    //   332: aload 15
    //   334: astore_2
    //   335: aload_2
    //   336: ifnull +7 -> 343
    //   339: aload_2
    //   340: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   343: iload 5
    //   345: istore 6
    //   347: aload 16
    //   349: ifnull -66 -> 283
    //   352: aload 16
    //   354: invokevirtual 182	java/io/InputStream:close	()V
    //   357: iload 5
    //   359: ireturn
    //   360: astore_1
    //   361: aload_1
    //   362: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   365: iload 5
    //   367: ireturn
    //   368: aload 15
    //   370: astore_2
    //   371: new 186	java/io/File
    //   374: dup
    //   375: aload_3
    //   376: invokespecial 187	java/io/File:<init>	(Ljava/lang/String;)V
    //   379: astore_1
    //   380: iload 9
    //   382: istore 5
    //   384: aload_1
    //   385: ifnull -53 -> 332
    //   388: iload 9
    //   390: istore 5
    //   392: aload 15
    //   394: astore_2
    //   395: aload_1
    //   396: invokevirtual 190	java/io/File:exists	()Z
    //   399: ifeq -67 -> 332
    //   402: aload 15
    //   404: astore_2
    //   405: aload_1
    //   406: invokevirtual 193	java/io/File:delete	()Z
    //   409: pop
    //   410: iload 9
    //   412: istore 5
    //   414: goto -82 -> 332
    //   417: astore_1
    //   418: aload 15
    //   420: astore_2
    //   421: aload_1
    //   422: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   425: aload 15
    //   427: ifnull +8 -> 435
    //   430: aload 15
    //   432: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   435: iload 7
    //   437: istore 6
    //   439: aload 16
    //   441: ifnull -158 -> 283
    //   444: aload 16
    //   446: invokevirtual 182	java/io/InputStream:close	()V
    //   449: iconst_0
    //   450: ireturn
    //   451: astore_1
    //   452: iload 8
    //   454: istore 5
    //   456: goto -95 -> 361
    //   459: iload 10
    //   461: istore 5
    //   463: aload 15
    //   465: astore_2
    //   466: aload_3
    //   467: ldc -61
    //   469: invokevirtual 198	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   472: ifeq -137 -> 335
    //   475: iload 10
    //   477: istore 5
    //   479: aload 15
    //   481: astore_2
    //   482: aload_0
    //   483: getfield 32	com/jiubang/core/c/a/b:h	Z
    //   486: ifeq -151 -> 335
    //   489: aload 16
    //   491: invokestatic 204	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   494: astore_3
    //   495: iload 10
    //   497: istore 5
    //   499: aload 15
    //   501: astore_2
    //   502: aload_3
    //   503: ifnull -168 -> 335
    //   506: aload_1
    //   507: aload_3
    //   508: putfield 207	com/jiubang/core/c/a/a:d	Ljava/lang/Object;
    //   511: iload 10
    //   513: istore 5
    //   515: aload 15
    //   517: astore_2
    //   518: goto -183 -> 335
    //   521: astore_1
    //   522: aconst_null
    //   523: astore 15
    //   525: goto -277 -> 248
    //   528: astore_1
    //   529: aconst_null
    //   530: astore_2
    //   531: aload_2
    //   532: ifnull +7 -> 539
    //   535: aload_2
    //   536: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   539: aload 16
    //   541: ifnull +8 -> 549
    //   544: aload 16
    //   546: invokevirtual 182	java/io/InputStream:close	()V
    //   549: aload_1
    //   550: athrow
    //   551: astore_2
    //   552: aload_2
    //   553: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   556: goto -17 -> 539
    //   559: astore_2
    //   560: aload_2
    //   561: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   564: goto -15 -> 549
    //   567: astore_1
    //   568: aload_1
    //   569: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   572: goto -307 -> 265
    //   575: astore_1
    //   576: iload 8
    //   578: istore 5
    //   580: goto -219 -> 361
    //   583: astore_1
    //   584: aload_1
    //   585: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   588: goto -153 -> 435
    //   591: astore_1
    //   592: aload_1
    //   593: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   596: goto -253 -> 343
    //   599: astore_1
    //   600: goto -69 -> 531
    //   603: astore_1
    //   604: aconst_null
    //   605: astore 15
    //   607: goto -189 -> 418
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	610	0	this	b
    //   0	610	1	parama	a
    //   0	610	2	paramString1	String
    //   0	610	3	paramString2	String
    //   164	163	4	k	int
    //   330	249	5	bool1	boolean
    //   14	424	6	bool2	boolean
    //   10	426	7	bool3	boolean
    //   7	570	8	bool4	boolean
    //   1	410	9	bool5	boolean
    //   4	508	10	bool6	boolean
    //   128	79	11	l1	long
    //   125	85	13	l2	long
    //   61	545	15	localObject1	Object
    //   75	470	16	localObject2	Object
    //   70	108	17	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   120	127	247	java/io/FileNotFoundException
    //   133	140	247	java/io/FileNotFoundException
    //   143	150	247	java/io/FileNotFoundException
    //   153	166	247	java/io/FileNotFoundException
    //   175	185	247	java/io/FileNotFoundException
    //   203	215	247	java/io/FileNotFoundException
    //   218	224	247	java/io/FileNotFoundException
    //   227	244	247	java/io/FileNotFoundException
    //   306	313	247	java/io/FileNotFoundException
    //   316	322	247	java/io/FileNotFoundException
    //   371	380	247	java/io/FileNotFoundException
    //   395	402	247	java/io/FileNotFoundException
    //   405	410	247	java/io/FileNotFoundException
    //   77	89	286	java/lang/IllegalArgumentException
    //   352	357	360	java/lang/Exception
    //   120	127	417	java/lang/Exception
    //   133	140	417	java/lang/Exception
    //   143	150	417	java/lang/Exception
    //   153	166	417	java/lang/Exception
    //   175	185	417	java/lang/Exception
    //   203	215	417	java/lang/Exception
    //   218	224	417	java/lang/Exception
    //   227	244	417	java/lang/Exception
    //   306	313	417	java/lang/Exception
    //   316	322	417	java/lang/Exception
    //   371	380	417	java/lang/Exception
    //   395	402	417	java/lang/Exception
    //   405	410	417	java/lang/Exception
    //   444	449	451	java/lang/Exception
    //   101	117	521	java/io/FileNotFoundException
    //   466	475	521	java/io/FileNotFoundException
    //   482	495	521	java/io/FileNotFoundException
    //   506	511	521	java/io/FileNotFoundException
    //   101	117	528	finally
    //   466	475	528	finally
    //   482	495	528	finally
    //   506	511	528	finally
    //   535	539	551	java/lang/Exception
    //   544	549	559	java/lang/Exception
    //   260	265	567	java/lang/Exception
    //   274	279	575	java/lang/Exception
    //   430	435	583	java/lang/Exception
    //   339	343	591	java/lang/Exception
    //   120	127	599	finally
    //   133	140	599	finally
    //   143	150	599	finally
    //   153	166	599	finally
    //   175	185	599	finally
    //   203	215	599	finally
    //   218	224	599	finally
    //   227	244	599	finally
    //   251	255	599	finally
    //   306	313	599	finally
    //   316	322	599	finally
    //   371	380	599	finally
    //   395	402	599	finally
    //   405	410	599	finally
    //   421	425	599	finally
    //   101	117	603	java/lang/Exception
    //   466	475	603	java/lang/Exception
    //   482	495	603	java/lang/Exception
    //   506	511	603	java/lang/Exception
  }
  
  public void a(a parama)
  {
    if ((parama != null) && (!this.d) && ((!this.b.containsKey(parama.a)) || (((a)this.b.get(parama.a)).f == 3)))
    {
      if (!this.b.containsKey(parama.a)) {
        this.b.put(parama.a, parama);
      }
      if (this.g) {
        this.e.execute(new f(this, parama));
      }
    }
    else
    {
      return;
    }
    this.c.sendMessage(this.c.obtainMessage(3, parama));
  }
  
  public void a(c paramc)
  {
    this.j = paramc;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = true;
    this.i = paramBoolean;
    this.a.unregisterReceiver(this.f);
    if (this.j != null) {
      this.j = null;
    }
    if (paramBoolean) {
      this.e.shutdownNow();
    }
    for (;;)
    {
      this.c.removeCallbacksAndMessages(null);
      return;
      this.e.shutdown();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/c/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */