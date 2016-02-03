package com.gau.go.launcherex.gowidget.weather.f;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import org.xmlpull.v1.XmlPullParser;

public class b
{
  private boolean a;
  
  private int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString.substring(paramString.length() - 1));
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public static Drawable a(Resources paramResources, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i;
    if (paramString1 != null)
    {
      i = paramResources.getIdentifier(paramString1, "drawable", paramString2);
      localObject1 = localObject2;
      if (i == 0) {}
    }
    try
    {
      localObject1 = paramResources.getDrawable(i);
      return (Drawable)localObject1;
    }
    catch (OutOfMemoryError paramResources) {}
    return null;
  }
  
  private void a(XmlPullParser paramXmlPullParser, String[] paramArrayOfString, int paramInt)
  {
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "src");
    if (paramXmlPullParser != null) {
      paramArrayOfString[paramInt] = paramXmlPullParser;
    }
  }
  
  public static ColorStateList b(Resources paramResources, String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      int i = paramResources.getIdentifier(paramString1, "color", paramString2);
      if (i != 0) {
        return paramResources.getColorStateList(i);
      }
    }
    return null;
  }
  
  /* Error */
  public void a(XmlPullParser paramXmlPullParser, a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_1
    //   10: invokeinterface 77 1 0
    //   15: iconst_1
    //   16: if_icmpeq -8 -> 8
    //   19: aload_1
    //   20: invokeinterface 81 1 0
    //   25: ifnull -16 -> 9
    //   28: aload_1
    //   29: invokeinterface 81 1 0
    //   34: astore 7
    //   36: aload_1
    //   37: invokeinterface 84 1 0
    //   42: istore_3
    //   43: aload 7
    //   45: ifnull -36 -> 9
    //   48: aload 7
    //   50: ldc 86
    //   52: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifeq +332 -> 387
    //   58: iload_3
    //   59: iconst_2
    //   60: if_icmpne +327 -> 387
    //   63: aload_1
    //   64: aconst_null
    //   65: ldc 92
    //   67: invokeinterface 65 3 0
    //   72: astore 9
    //   74: aload_1
    //   75: aconst_null
    //   76: ldc 94
    //   78: invokeinterface 65 3 0
    //   83: astore 8
    //   85: aload 9
    //   87: ifnull +590 -> 677
    //   90: aload 9
    //   92: invokestatic 29	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   95: istore_3
    //   96: aload 8
    //   98: ifnull +585 -> 683
    //   101: aload 8
    //   103: invokestatic 29	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   106: istore 4
    //   108: aload_2
    //   109: ldc 96
    //   111: invokevirtual 101	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore 8
    //   116: aload 8
    //   118: ifnull +572 -> 690
    //   121: aload_2
    //   122: ldc 96
    //   124: invokevirtual 101	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   127: invokestatic 29	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   130: istore 5
    //   132: aload_2
    //   133: ldc 103
    //   135: invokevirtual 101	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   138: astore 8
    //   140: aload 8
    //   142: ifnull +555 -> 697
    //   145: aload_2
    //   146: ldc 103
    //   148: invokevirtual 101	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   151: invokestatic 29	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   154: istore 6
    //   156: iload_3
    //   157: iload 5
    //   159: if_icmpne +28 -> 187
    //   162: iload_3
    //   163: bipush -100
    //   165: if_icmpeq +22 -> 187
    //   168: iload 6
    //   170: iload 4
    //   172: if_icmpne +15 -> 187
    //   175: iload 6
    //   177: bipush -100
    //   179: if_icmpeq +8 -> 187
    //   182: aload_0
    //   183: iconst_1
    //   184: putfield 105	com/gau/go/launcherex/gowidget/weather/f/b:a	Z
    //   187: aload_0
    //   188: getfield 105	com/gau/go/launcherex/gowidget/weather/f/b:a	Z
    //   191: ifeq +224 -> 415
    //   194: aload 7
    //   196: ldc 107
    //   198: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifne +113 -> 314
    //   204: aload 7
    //   206: ldc 109
    //   208: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: ifne +103 -> 314
    //   214: aload 7
    //   216: ldc 111
    //   218: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   221: ifne +93 -> 314
    //   224: aload 7
    //   226: ldc 113
    //   228: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifne +83 -> 314
    //   234: aload 7
    //   236: ldc 115
    //   238: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   241: ifne +73 -> 314
    //   244: aload 7
    //   246: ldc 117
    //   248: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   251: ifne +63 -> 314
    //   254: aload 7
    //   256: ldc 119
    //   258: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   261: ifne +53 -> 314
    //   264: aload 7
    //   266: ldc 121
    //   268: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   271: ifne +43 -> 314
    //   274: aload 7
    //   276: ldc 123
    //   278: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   281: ifne +33 -> 314
    //   284: aload 7
    //   286: ldc 125
    //   288: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   291: ifne +23 -> 314
    //   294: aload 7
    //   296: ldc 127
    //   298: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   301: ifne +13 -> 314
    //   304: aload 7
    //   306: ldc -127
    //   308: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   311: ifeq +104 -> 415
    //   314: aload_1
    //   315: aconst_null
    //   316: ldc 59
    //   318: invokeinterface 65 3 0
    //   323: astore 8
    //   325: aload 8
    //   327: ifnull -318 -> 9
    //   330: aload_2
    //   331: aload 7
    //   333: aload 8
    //   335: invokevirtual 132	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: goto -329 -> 9
    //   341: astore_1
    //   342: aload_1
    //   343: invokevirtual 41	java/lang/Exception:printStackTrace	()V
    //   346: return
    //   347: astore 9
    //   349: aload 9
    //   351: invokevirtual 32	java/lang/NumberFormatException:printStackTrace	()V
    //   354: goto +323 -> 677
    //   357: astore 8
    //   359: aload 8
    //   361: invokevirtual 32	java/lang/NumberFormatException:printStackTrace	()V
    //   364: goto +319 -> 683
    //   367: astore 8
    //   369: aload 8
    //   371: invokevirtual 32	java/lang/NumberFormatException:printStackTrace	()V
    //   374: goto +316 -> 690
    //   377: astore 8
    //   379: aload 8
    //   381: invokevirtual 32	java/lang/NumberFormatException:printStackTrace	()V
    //   384: goto +313 -> 697
    //   387: aload 7
    //   389: ldc 86
    //   391: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   394: ifeq -207 -> 187
    //   397: iload_3
    //   398: iconst_3
    //   399: if_icmpne -212 -> 187
    //   402: aload_0
    //   403: getfield 105	com/gau/go/launcherex/gowidget/weather/f/b:a	Z
    //   406: ifeq -219 -> 187
    //   409: aload_0
    //   410: iconst_0
    //   411: putfield 105	com/gau/go/launcherex/gowidget/weather/f/b:a	Z
    //   414: return
    //   415: aload 7
    //   417: ldc -122
    //   419: invokevirtual 138	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   422: ifeq +21 -> 443
    //   425: aload_0
    //   426: aload_1
    //   427: aload_2
    //   428: invokevirtual 142	com/gau/go/launcherex/gowidget/weather/f/a:d	()[Ljava/lang/String;
    //   431: aload_0
    //   432: aload 7
    //   434: invokespecial 144	com/gau/go/launcherex/gowidget/weather/f/b:a	(Ljava/lang/String;)I
    //   437: invokespecial 146	com/gau/go/launcherex/gowidget/weather/f/b:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   440: goto -431 -> 9
    //   443: aload 7
    //   445: ldc -108
    //   447: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   450: ifeq +16 -> 466
    //   453: aload_0
    //   454: aload_1
    //   455: aload_2
    //   456: invokevirtual 150	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   459: iconst_0
    //   460: invokespecial 146	com/gau/go/launcherex/gowidget/weather/f/b:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   463: goto -454 -> 9
    //   466: aload 7
    //   468: ldc -104
    //   470: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   473: ifeq +16 -> 489
    //   476: aload_0
    //   477: aload_1
    //   478: aload_2
    //   479: invokevirtual 150	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   482: iconst_1
    //   483: invokespecial 146	com/gau/go/launcherex/gowidget/weather/f/b:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   486: goto -477 -> 9
    //   489: aload 7
    //   491: ldc -102
    //   493: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   496: ifeq +16 -> 512
    //   499: aload_0
    //   500: aload_1
    //   501: aload_2
    //   502: invokevirtual 150	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   505: iconst_2
    //   506: invokespecial 146	com/gau/go/launcherex/gowidget/weather/f/b:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   509: goto -500 -> 9
    //   512: aload 7
    //   514: ldc -100
    //   516: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   519: ifeq +16 -> 535
    //   522: aload_0
    //   523: aload_1
    //   524: aload_2
    //   525: invokevirtual 150	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   528: iconst_3
    //   529: invokespecial 146	com/gau/go/launcherex/gowidget/weather/f/b:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   532: goto -523 -> 9
    //   535: aload 7
    //   537: ldc -98
    //   539: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   542: ifeq +16 -> 558
    //   545: aload_0
    //   546: aload_1
    //   547: aload_2
    //   548: invokevirtual 150	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   551: iconst_4
    //   552: invokespecial 146	com/gau/go/launcherex/gowidget/weather/f/b:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   555: goto -546 -> 9
    //   558: aload 7
    //   560: ldc -96
    //   562: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   565: ifeq +16 -> 581
    //   568: aload_0
    //   569: aload_1
    //   570: aload_2
    //   571: invokevirtual 150	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   574: iconst_5
    //   575: invokespecial 146	com/gau/go/launcherex/gowidget/weather/f/b:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   578: goto -569 -> 9
    //   581: aload 7
    //   583: ldc -94
    //   585: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   588: ifeq +17 -> 605
    //   591: aload_0
    //   592: aload_1
    //   593: aload_2
    //   594: invokevirtual 150	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   597: bipush 6
    //   599: invokespecial 146	com/gau/go/launcherex/gowidget/weather/f/b:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   602: goto -593 -> 9
    //   605: aload 7
    //   607: ldc -92
    //   609: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   612: ifeq +17 -> 629
    //   615: aload_0
    //   616: aload_1
    //   617: aload_2
    //   618: invokevirtual 150	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   621: bipush 7
    //   623: invokespecial 146	com/gau/go/launcherex/gowidget/weather/f/b:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   626: goto -617 -> 9
    //   629: aload 7
    //   631: ldc -90
    //   633: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   636: ifeq +17 -> 653
    //   639: aload_0
    //   640: aload_1
    //   641: aload_2
    //   642: invokevirtual 150	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   645: bipush 8
    //   647: invokespecial 146	com/gau/go/launcherex/gowidget/weather/f/b:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   650: goto -641 -> 9
    //   653: aload 7
    //   655: ldc -88
    //   657: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   660: ifeq -651 -> 9
    //   663: aload_0
    //   664: aload_1
    //   665: aload_2
    //   666: invokevirtual 150	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   669: bipush 9
    //   671: invokespecial 146	com/gau/go/launcherex/gowidget/weather/f/b:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   674: goto -665 -> 9
    //   677: bipush -100
    //   679: istore_3
    //   680: goto -584 -> 96
    //   683: bipush -100
    //   685: istore 4
    //   687: goto -579 -> 108
    //   690: bipush -100
    //   692: istore 5
    //   694: goto -562 -> 132
    //   697: bipush -100
    //   699: istore 6
    //   701: goto -545 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	704	0	this	b
    //   0	704	1	paramXmlPullParser	XmlPullParser
    //   0	704	2	parama	a
    //   42	638	3	i	int
    //   106	580	4	j	int
    //   130	563	5	k	int
    //   154	546	6	m	int
    //   34	620	7	str1	String
    //   83	251	8	str2	String
    //   357	3	8	localNumberFormatException1	NumberFormatException
    //   367	3	8	localNumberFormatException2	NumberFormatException
    //   377	3	8	localNumberFormatException3	NumberFormatException
    //   72	19	9	str3	String
    //   347	3	9	localNumberFormatException4	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   9	43	341	java/lang/Exception
    //   48	58	341	java/lang/Exception
    //   63	85	341	java/lang/Exception
    //   90	96	341	java/lang/Exception
    //   101	108	341	java/lang/Exception
    //   108	116	341	java/lang/Exception
    //   121	132	341	java/lang/Exception
    //   132	140	341	java/lang/Exception
    //   145	156	341	java/lang/Exception
    //   182	187	341	java/lang/Exception
    //   187	314	341	java/lang/Exception
    //   314	325	341	java/lang/Exception
    //   330	338	341	java/lang/Exception
    //   349	354	341	java/lang/Exception
    //   359	364	341	java/lang/Exception
    //   369	374	341	java/lang/Exception
    //   379	384	341	java/lang/Exception
    //   387	397	341	java/lang/Exception
    //   402	414	341	java/lang/Exception
    //   415	440	341	java/lang/Exception
    //   443	463	341	java/lang/Exception
    //   466	486	341	java/lang/Exception
    //   489	509	341	java/lang/Exception
    //   512	532	341	java/lang/Exception
    //   535	555	341	java/lang/Exception
    //   558	578	341	java/lang/Exception
    //   581	602	341	java/lang/Exception
    //   605	626	341	java/lang/Exception
    //   629	650	341	java/lang/Exception
    //   653	674	341	java/lang/Exception
    //   90	96	347	java/lang/NumberFormatException
    //   101	108	357	java/lang/NumberFormatException
    //   121	132	367	java/lang/NumberFormatException
    //   145	156	377	java/lang/NumberFormatException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */