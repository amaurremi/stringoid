package com.gau.go.launcherex.gowidget.weather.util;

import android.content.res.Resources;

public class n
{
  private static int a(Resources paramResources, String paramString1, String paramString2)
  {
    return paramResources.getIdentifier(paramString2, "raw", paramString1);
  }
  
  /* Error */
  public static l a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iconst_2
    //   3: invokevirtual 28	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +541 -> 549
    //   11: aload_0
    //   12: invokevirtual 32	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   15: astore_0
    //   16: aload_0
    //   17: aload_1
    //   18: ldc 34
    //   20: invokestatic 36	com/gau/go/launcherex/gowidget/weather/util/n:a	(Landroid/content/res/Resources;Ljava/lang/String;Ljava/lang/String;)I
    //   23: istore_2
    //   24: iload_2
    //   25: ifeq +134 -> 159
    //   28: aload_0
    //   29: iload_2
    //   30: invokevirtual 40	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +514 -> 549
    //   38: aload_0
    //   39: invokestatic 45	com/gau/go/launcherex/gowidget/weather/f/g:a	(Ljava/io/InputStream;)Lorg/xmlpull/v1/XmlPullParser;
    //   42: astore 7
    //   44: aload 7
    //   46: ifnull +503 -> 549
    //   49: aload 7
    //   51: invokeinterface 51 1 0
    //   56: istore_2
    //   57: aconst_null
    //   58: astore_0
    //   59: aload_0
    //   60: astore 4
    //   62: iload_2
    //   63: iconst_1
    //   64: if_icmpeq +380 -> 444
    //   67: iload_2
    //   68: iconst_2
    //   69: if_icmpne +477 -> 546
    //   72: aload 7
    //   74: invokeinterface 55 1 0
    //   79: astore 4
    //   81: aload 4
    //   83: ifnull +463 -> 546
    //   86: ldc 57
    //   88: aload 4
    //   90: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifeq +137 -> 230
    //   96: aload 7
    //   98: invokeinterface 66 1 0
    //   103: istore_3
    //   104: new 68	java/util/ArrayList
    //   107: dup
    //   108: iload_3
    //   109: invokespecial 72	java/util/ArrayList:<init>	(I)V
    //   112: astore 5
    //   114: iconst_0
    //   115: istore_2
    //   116: iload_2
    //   117: iload_3
    //   118: if_icmpge +64 -> 182
    //   121: aload 5
    //   123: astore 6
    //   125: aload 5
    //   127: astore 4
    //   129: aload 5
    //   131: new 74	com/gau/go/launcherex/gowidget/weather/util/m
    //   134: dup
    //   135: invokespecial 77	com/gau/go/launcherex/gowidget/weather/util/m:<init>	()V
    //   138: invokevirtual 80	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   141: pop
    //   142: iload_2
    //   143: iconst_1
    //   144: iadd
    //   145: istore_2
    //   146: goto -30 -> 116
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 83	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   154: aconst_null
    //   155: astore_0
    //   156: goto -149 -> 7
    //   159: aload_0
    //   160: invokevirtual 87	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   163: ldc 89
    //   165: invokevirtual 95	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   168: astore_0
    //   169: goto -135 -> 34
    //   172: astore_0
    //   173: aload_0
    //   174: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   177: aconst_null
    //   178: astore_0
    //   179: goto -145 -> 34
    //   182: iconst_0
    //   183: istore_2
    //   184: aload 5
    //   186: astore_0
    //   187: iload_2
    //   188: iload_3
    //   189: if_icmpge +124 -> 313
    //   192: aload 5
    //   194: astore 6
    //   196: aload 5
    //   198: astore 4
    //   200: aload 5
    //   202: iload_2
    //   203: invokevirtual 100	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   206: checkcast 74	com/gau/go/launcherex/gowidget/weather/util/m
    //   209: aload 7
    //   211: iload_2
    //   212: invokeinterface 104 2 0
    //   217: invokestatic 110	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   220: putfield 113	com/gau/go/launcherex/gowidget/weather/util/m:a	I
    //   223: iload_2
    //   224: iconst_1
    //   225: iadd
    //   226: istore_2
    //   227: goto -43 -> 184
    //   230: ldc 115
    //   232: aload 4
    //   234: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   237: ifeq +93 -> 330
    //   240: aload 7
    //   242: invokeinterface 66 1 0
    //   247: istore_3
    //   248: iconst_0
    //   249: istore_2
    //   250: iload_2
    //   251: iload_3
    //   252: if_icmpge +61 -> 313
    //   255: aload_0
    //   256: iload_2
    //   257: invokevirtual 100	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   260: checkcast 74	com/gau/go/launcherex/gowidget/weather/util/m
    //   263: astore 5
    //   265: aload 5
    //   267: astore 4
    //   269: aload 5
    //   271: ifnonnull +19 -> 290
    //   274: new 74	com/gau/go/launcherex/gowidget/weather/util/m
    //   277: dup
    //   278: invokespecial 77	com/gau/go/launcherex/gowidget/weather/util/m:<init>	()V
    //   281: astore 4
    //   283: aload_0
    //   284: aload 4
    //   286: invokevirtual 80	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   289: pop
    //   290: aload 4
    //   292: aload 7
    //   294: iload_2
    //   295: invokeinterface 104 2 0
    //   300: invokestatic 110	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   303: putfield 118	com/gau/go/launcherex/gowidget/weather/util/m:b	I
    //   306: iload_2
    //   307: iconst_1
    //   308: iadd
    //   309: istore_2
    //   310: goto -60 -> 250
    //   313: aload_0
    //   314: astore 6
    //   316: aload_0
    //   317: astore 4
    //   319: aload 7
    //   321: invokeinterface 121 1 0
    //   326: istore_2
    //   327: goto -268 -> 59
    //   330: ldc 123
    //   332: aload 4
    //   334: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   337: ifeq +44 -> 381
    //   340: aload 7
    //   342: invokeinterface 66 1 0
    //   347: istore_3
    //   348: iconst_0
    //   349: istore_2
    //   350: iload_2
    //   351: iload_3
    //   352: if_icmpge +203 -> 555
    //   355: aload_0
    //   356: iload_2
    //   357: invokevirtual 100	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   360: checkcast 74	com/gau/go/launcherex/gowidget/weather/util/m
    //   363: aload 7
    //   365: iload_2
    //   366: invokeinterface 104 2 0
    //   371: putfield 127	com/gau/go/launcherex/gowidget/weather/util/m:d	Ljava/lang/String;
    //   374: iload_2
    //   375: iconst_1
    //   376: iadd
    //   377: istore_2
    //   378: goto -28 -> 350
    //   381: ldc -127
    //   383: aload 4
    //   385: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   388: ifeq +158 -> 546
    //   391: aload 7
    //   393: invokeinterface 66 1 0
    //   398: istore_3
    //   399: iconst_0
    //   400: istore_2
    //   401: iload_2
    //   402: iload_3
    //   403: if_icmpge +143 -> 546
    //   406: aload_0
    //   407: iload_2
    //   408: invokevirtual 100	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   411: checkcast 74	com/gau/go/launcherex/gowidget/weather/util/m
    //   414: aload 7
    //   416: iload_2
    //   417: invokeinterface 104 2 0
    //   422: putfield 132	com/gau/go/launcherex/gowidget/weather/util/m:c	Ljava/lang/String;
    //   425: iload_2
    //   426: iconst_1
    //   427: iadd
    //   428: istore_2
    //   429: goto -28 -> 401
    //   432: astore 5
    //   434: aconst_null
    //   435: astore_0
    //   436: aload 5
    //   438: invokevirtual 133	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   441: aload_0
    //   442: astore 4
    //   444: aload 4
    //   446: ifnull +98 -> 544
    //   449: aload 4
    //   451: invokevirtual 137	java/util/ArrayList:isEmpty	()Z
    //   454: ifne +90 -> 544
    //   457: new 139	com/gau/go/launcherex/gowidget/weather/util/l
    //   460: dup
    //   461: invokespecial 140	com/gau/go/launcherex/gowidget/weather/util/l:<init>	()V
    //   464: astore_0
    //   465: aload_0
    //   466: aload_1
    //   467: invokevirtual 143	com/gau/go/launcherex/gowidget/weather/util/l:a	(Ljava/lang/String;)V
    //   470: aload 4
    //   472: invokevirtual 147	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   475: astore_1
    //   476: aload_1
    //   477: invokeinterface 152 1 0
    //   482: ifeq +34 -> 516
    //   485: aload_0
    //   486: aload_1
    //   487: invokeinterface 155 1 0
    //   492: checkcast 74	com/gau/go/launcherex/gowidget/weather/util/m
    //   495: invokevirtual 158	com/gau/go/launcherex/gowidget/weather/util/l:a	(Lcom/gau/go/launcherex/gowidget/weather/util/m;)V
    //   498: goto -22 -> 476
    //   501: astore 4
    //   503: aconst_null
    //   504: astore_0
    //   505: aload 4
    //   507: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   510: aload_0
    //   511: astore 4
    //   513: goto -69 -> 444
    //   516: aload_0
    //   517: areturn
    //   518: astore 4
    //   520: aload 6
    //   522: astore_0
    //   523: goto -18 -> 505
    //   526: astore 4
    //   528: goto -23 -> 505
    //   531: astore 5
    //   533: aload 4
    //   535: astore_0
    //   536: goto -100 -> 436
    //   539: astore 5
    //   541: goto -105 -> 436
    //   544: aconst_null
    //   545: areturn
    //   546: goto -233 -> 313
    //   549: aconst_null
    //   550: astore 4
    //   552: goto -108 -> 444
    //   555: goto -242 -> 313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	558	0	paramContext	android.content.Context
    //   0	558	1	paramString	String
    //   23	406	2	i	int
    //   103	301	3	j	int
    //   60	411	4	localObject1	Object
    //   501	5	4	localIOException1	java.io.IOException
    //   511	1	4	localContext	android.content.Context
    //   518	1	4	localIOException2	java.io.IOException
    //   526	8	4	localIOException3	java.io.IOException
    //   550	1	4	localObject2	Object
    //   112	158	5	localObject3	Object
    //   432	5	5	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   531	1	5	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   539	1	5	localXmlPullParserException3	org.xmlpull.v1.XmlPullParserException
    //   123	398	6	localObject4	Object
    //   42	373	7	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    // Exception table:
    //   from	to	target	type
    //   0	7	149	android/content/pm/PackageManager$NameNotFoundException
    //   159	169	172	java/io/IOException
    //   49	57	432	org/xmlpull/v1/XmlPullParserException
    //   49	57	501	java/io/IOException
    //   129	142	518	java/io/IOException
    //   200	223	518	java/io/IOException
    //   319	327	518	java/io/IOException
    //   72	81	526	java/io/IOException
    //   86	114	526	java/io/IOException
    //   230	248	526	java/io/IOException
    //   255	265	526	java/io/IOException
    //   274	290	526	java/io/IOException
    //   290	306	526	java/io/IOException
    //   330	348	526	java/io/IOException
    //   355	374	526	java/io/IOException
    //   381	399	526	java/io/IOException
    //   406	425	526	java/io/IOException
    //   129	142	531	org/xmlpull/v1/XmlPullParserException
    //   200	223	531	org/xmlpull/v1/XmlPullParserException
    //   319	327	531	org/xmlpull/v1/XmlPullParserException
    //   72	81	539	org/xmlpull/v1/XmlPullParserException
    //   86	114	539	org/xmlpull/v1/XmlPullParserException
    //   230	248	539	org/xmlpull/v1/XmlPullParserException
    //   255	265	539	org/xmlpull/v1/XmlPullParserException
    //   274	290	539	org/xmlpull/v1/XmlPullParserException
    //   290	306	539	org/xmlpull/v1/XmlPullParserException
    //   330	348	539	org/xmlpull/v1/XmlPullParserException
    //   355	374	539	org/xmlpull/v1/XmlPullParserException
    //   381	399	539	org/xmlpull/v1/XmlPullParserException
    //   406	425	539	org/xmlpull/v1/XmlPullParserException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/util/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */