package com.gau.go.launcherex.gowidget.statistics;

import android.os.AsyncTask;

class g
  extends AsyncTask
{
  private g(d paramd) {}
  
  /* Error */
  protected Void a(com.gau.go.launcherex.gowidget.weather.model.FeedbackBean... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: aaload
    //   3: astore 4
    //   5: aload 4
    //   7: invokevirtual 28	com/gau/go/launcherex/gowidget/weather/model/FeedbackBean:e	()Ljava/lang/String;
    //   10: astore_1
    //   11: aload_1
    //   12: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: aload_0
    //   21: getfield 10	com/gau/go/launcherex/gowidget/statistics/g:a	Lcom/gau/go/launcherex/gowidget/statistics/d;
    //   24: invokestatic 39	com/gau/go/launcherex/gowidget/statistics/d:a	(Lcom/gau/go/launcherex/gowidget/statistics/d;)Landroid/content/Context;
    //   27: invokevirtual 45	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   30: getstatic 50	com/gau/go/launcherex/gowidget/weather/provider/WeatherContentProvider:a	Landroid/net/Uri;
    //   33: iconst_1
    //   34: anewarray 52	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: ldc 54
    //   41: aastore
    //   42: ldc 56
    //   44: iconst_1
    //   45: anewarray 52	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: aload_1
    //   51: aastore
    //   52: ldc 58
    //   54: invokevirtual 64	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   57: astore 5
    //   59: aload 5
    //   61: ifnull +454 -> 515
    //   64: aload 5
    //   66: invokeinterface 70 1 0
    //   71: iconst_1
    //   72: if_icmpne +438 -> 510
    //   75: aload 5
    //   77: invokeinterface 74 1 0
    //   82: ifeq +428 -> 510
    //   85: aload 5
    //   87: aload 5
    //   89: ldc 54
    //   91: invokeinterface 78 2 0
    //   96: invokeinterface 82 2 0
    //   101: astore_1
    //   102: aload 5
    //   104: invokeinterface 85 1 0
    //   109: aload_1
    //   110: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne -95 -> 18
    //   116: aload_0
    //   117: getfield 10	com/gau/go/launcherex/gowidget/statistics/g:a	Lcom/gau/go/launcherex/gowidget/statistics/d;
    //   120: invokestatic 39	com/gau/go/launcherex/gowidget/statistics/d:a	(Lcom/gau/go/launcherex/gowidget/statistics/d;)Landroid/content/Context;
    //   123: ldc 87
    //   125: invokevirtual 91	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   128: astore 7
    //   130: aload 7
    //   132: ifnull -114 -> 18
    //   135: aload 7
    //   137: invokevirtual 96	java/io/File:exists	()Z
    //   140: ifeq -122 -> 18
    //   143: new 98	com/jiubang/goweather/b/e
    //   146: dup
    //   147: ldc 100
    //   149: invokespecial 103	com/jiubang/goweather/b/e:<init>	(Ljava/lang/String;)V
    //   152: astore 5
    //   154: aload_0
    //   155: getfield 10	com/gau/go/launcherex/gowidget/statistics/g:a	Lcom/gau/go/launcherex/gowidget/statistics/d;
    //   158: invokestatic 39	com/gau/go/launcherex/gowidget/statistics/d:a	(Lcom/gau/go/launcherex/gowidget/statistics/d;)Landroid/content/Context;
    //   161: aload 5
    //   163: invokestatic 108	com/jiubang/goweather/b/g:a	(Landroid/content/Context;Lcom/jiubang/goweather/b/e;)Lcom/jiubang/goweather/b/e;
    //   166: pop
    //   167: aload 5
    //   169: ldc 110
    //   171: invokestatic 115	com/gau/go/launcherex/gowidget/statistics/y:c	()Ljava/lang/String;
    //   174: invokevirtual 118	com/jiubang/goweather/b/e:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/jiubang/goweather/b/a;
    //   177: pop
    //   178: aload 5
    //   180: ldc 120
    //   182: invokevirtual 122	com/jiubang/goweather/b/e:a	(Ljava/lang/String;)V
    //   185: new 124	com/jiubang/goweather/b/f
    //   188: dup
    //   189: invokespecial 125	com/jiubang/goweather/b/f:<init>	()V
    //   192: astore 6
    //   194: new 127	a/a/a/a/a/h
    //   197: dup
    //   198: getstatic 133	a/a/a/a/a/e:b	La/a/a/a/a/e;
    //   201: invokespecial 136	a/a/a/a/a/h:<init>	(La/a/a/a/a/e;)V
    //   204: astore 8
    //   206: aload_0
    //   207: getfield 10	com/gau/go/launcherex/gowidget/statistics/g:a	Lcom/gau/go/launcherex/gowidget/statistics/d;
    //   210: invokestatic 39	com/gau/go/launcherex/gowidget/statistics/d:a	(Lcom/gau/go/launcherex/gowidget/statistics/d;)Landroid/content/Context;
    //   213: invokestatic 141	com/gau/go/gostaticsdk/d:b	(Landroid/content/Context;)Ljava/lang/String;
    //   216: astore 9
    //   218: ldc -113
    //   220: new 145	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   227: ldc -108
    //   229: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload 9
    //   234: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 160	com/gtp/a/a/b/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 8
    //   245: ldc -94
    //   247: new 164	a/a/a/a/a/a/e
    //   250: dup
    //   251: aload 9
    //   253: invokespecial 165	a/a/a/a/a/a/e:<init>	(Ljava/lang/String;)V
    //   256: invokevirtual 168	a/a/a/a/a/h:a	(Ljava/lang/String;La/a/a/a/a/a/b;)V
    //   259: aload 8
    //   261: ldc -86
    //   263: new 164	a/a/a/a/a/a/e
    //   266: dup
    //   267: aload 4
    //   269: invokevirtual 171	com/gau/go/launcherex/gowidget/weather/model/FeedbackBean:c	()Ljava/lang/String;
    //   272: ldc -83
    //   274: invokestatic 179	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   277: invokespecial 182	a/a/a/a/a/a/e:<init>	(Ljava/lang/String;Ljava/nio/charset/Charset;)V
    //   280: invokevirtual 168	a/a/a/a/a/h:a	(Ljava/lang/String;La/a/a/a/a/a/b;)V
    //   283: aload 8
    //   285: ldc -72
    //   287: new 164	a/a/a/a/a/a/e
    //   290: dup
    //   291: aload 4
    //   293: invokevirtual 187	com/gau/go/launcherex/gowidget/weather/model/FeedbackBean:d	()I
    //   296: invokestatic 190	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   299: invokespecial 165	a/a/a/a/a/a/e:<init>	(Ljava/lang/String;)V
    //   302: invokevirtual 168	a/a/a/a/a/h:a	(Ljava/lang/String;La/a/a/a/a/a/b;)V
    //   305: aload 8
    //   307: ldc -64
    //   309: new 164	a/a/a/a/a/a/e
    //   312: dup
    //   313: aload_1
    //   314: ldc -83
    //   316: invokestatic 179	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   319: invokespecial 182	a/a/a/a/a/a/e:<init>	(Ljava/lang/String;Ljava/nio/charset/Charset;)V
    //   322: invokevirtual 168	a/a/a/a/a/h:a	(Ljava/lang/String;La/a/a/a/a/a/b;)V
    //   325: aload 8
    //   327: ldc -62
    //   329: new 196	a/a/a/a/a/a/d
    //   332: dup
    //   333: aload 7
    //   335: invokespecial 199	a/a/a/a/a/a/d:<init>	(Ljava/io/File;)V
    //   338: invokevirtual 168	a/a/a/a/a/h:a	(Ljava/lang/String;La/a/a/a/a/a/b;)V
    //   341: aload 5
    //   343: aload 8
    //   345: invokevirtual 202	com/jiubang/goweather/b/e:a	(La/a/a/a/a/h;)V
    //   348: iconst_1
    //   349: invokestatic 207	com/jiubang/goweather/b/d:a	(Z)Lcom/jiubang/goweather/b/c;
    //   352: astore 7
    //   354: aload 5
    //   356: invokevirtual 210	com/jiubang/goweather/b/e:i	()Ljava/lang/String;
    //   359: astore_1
    //   360: aload_1
    //   361: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   364: ifne -346 -> 18
    //   367: iconst_3
    //   368: istore_2
    //   369: aload 7
    //   371: aload_1
    //   372: aload 5
    //   374: aload 6
    //   376: invokevirtual 215	com/jiubang/goweather/b/c:b	(Ljava/lang/String;Lcom/jiubang/goweather/b/e;Lcom/jiubang/goweather/b/f;)Ljava/lang/String;
    //   379: astore 4
    //   381: aload 4
    //   383: ifnonnull +117 -> 500
    //   386: ldc -39
    //   388: astore 4
    //   390: ldc -113
    //   392: new 145	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   399: ldc -37
    //   401: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload 4
    //   406: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 160	com/gtp/a/a/b/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   415: iload_2
    //   416: iconst_1
    //   417: isub
    //   418: istore_3
    //   419: ldc -35
    //   421: aload 4
    //   423: invokevirtual 225	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   426: ifne -408 -> 18
    //   429: iload_3
    //   430: istore_2
    //   431: iload_3
    //   432: ifgt -63 -> 369
    //   435: aconst_null
    //   436: areturn
    //   437: astore_1
    //   438: invokestatic 227	com/gtp/a/a/b/c:a	()Z
    //   441: ifeq +7 -> 448
    //   444: aload_1
    //   445: invokevirtual 230	android/database/SQLException:printStackTrace	()V
    //   448: aload 5
    //   450: invokeinterface 85 1 0
    //   455: aconst_null
    //   456: astore_1
    //   457: goto -348 -> 109
    //   460: astore_1
    //   461: aload 5
    //   463: invokeinterface 85 1 0
    //   468: aload_1
    //   469: athrow
    //   470: astore_1
    //   471: invokestatic 227	com/gtp/a/a/b/c:a	()Z
    //   474: ifeq -149 -> 325
    //   477: aload_1
    //   478: invokevirtual 231	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   481: goto -156 -> 325
    //   484: astore_1
    //   485: invokestatic 227	com/gtp/a/a/b/c:a	()Z
    //   488: ifeq +7 -> 495
    //   491: aload_1
    //   492: invokevirtual 231	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   495: aconst_null
    //   496: astore_1
    //   497: goto -137 -> 360
    //   500: aload 4
    //   502: invokevirtual 234	java/lang/String:trim	()Ljava/lang/String;
    //   505: astore 4
    //   507: goto -117 -> 390
    //   510: aconst_null
    //   511: astore_1
    //   512: goto -410 -> 102
    //   515: aconst_null
    //   516: astore_1
    //   517: goto -408 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	520	0	this	g
    //   0	520	1	paramVarArgs	com.gau.go.launcherex.gowidget.weather.model.FeedbackBean[]
    //   368	63	2	i	int
    //   418	14	3	j	int
    //   3	503	4	localObject1	Object
    //   57	405	5	localObject2	Object
    //   192	183	6	localf	com.jiubang.goweather.b.f
    //   128	242	7	localObject3	Object
    //   204	140	8	localh	a.a.a.a.a.h
    //   216	36	9	str	String
    // Exception table:
    //   from	to	target	type
    //   64	102	437	android/database/SQLException
    //   64	102	460	finally
    //   438	448	460	finally
    //   206	325	470	java/io/UnsupportedEncodingException
    //   354	360	484	java/io/UnsupportedEncodingException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */