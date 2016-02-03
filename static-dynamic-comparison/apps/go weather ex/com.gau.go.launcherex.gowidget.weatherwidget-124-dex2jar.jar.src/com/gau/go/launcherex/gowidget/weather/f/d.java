package com.gau.go.launcherex.gowidget.weather.f;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import org.xmlpull.v1.XmlPullParser;

public class d
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
    //   55: ifeq +392 -> 447
    //   58: iload_3
    //   59: iconst_2
    //   60: if_icmpne +387 -> 447
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
    //   87: ifnull +678 -> 765
    //   90: aload 9
    //   92: invokestatic 29	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   95: istore_3
    //   96: aload 8
    //   98: ifnull +673 -> 771
    //   101: aload 8
    //   103: invokestatic 29	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   106: istore 4
    //   108: aload_2
    //   109: ldc 96
    //   111: invokevirtual 101	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore 8
    //   116: aload 8
    //   118: ifnull +660 -> 778
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
    //   142: ifnull +643 -> 785
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
    //   184: putfield 105	com/gau/go/launcherex/gowidget/weather/f/d:a	Z
    //   187: aload_0
    //   188: getfield 105	com/gau/go/launcherex/gowidget/weather/f/d:a	Z
    //   191: ifeq +284 -> 475
    //   194: aload 7
    //   196: ldc 107
    //   198: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifne +173 -> 374
    //   204: aload 7
    //   206: ldc 109
    //   208: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: ifne +163 -> 374
    //   214: aload 7
    //   216: ldc 111
    //   218: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   221: ifne +153 -> 374
    //   224: aload 7
    //   226: ldc 113
    //   228: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifne +143 -> 374
    //   234: aload 7
    //   236: ldc 115
    //   238: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   241: ifne +133 -> 374
    //   244: aload 7
    //   246: ldc 117
    //   248: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   251: ifne +123 -> 374
    //   254: aload 7
    //   256: ldc 119
    //   258: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   261: ifne +113 -> 374
    //   264: aload 7
    //   266: ldc 121
    //   268: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   271: ifne +103 -> 374
    //   274: aload 7
    //   276: ldc 123
    //   278: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   281: ifne +93 -> 374
    //   284: aload 7
    //   286: ldc 125
    //   288: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   291: ifne +83 -> 374
    //   294: aload 7
    //   296: ldc 127
    //   298: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   301: ifne +73 -> 374
    //   304: aload 7
    //   306: ldc -127
    //   308: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   311: ifne +63 -> 374
    //   314: aload 7
    //   316: ldc -125
    //   318: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   321: ifne +53 -> 374
    //   324: aload 7
    //   326: ldc -123
    //   328: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   331: ifne +43 -> 374
    //   334: aload 7
    //   336: ldc -121
    //   338: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   341: ifne +33 -> 374
    //   344: aload 7
    //   346: ldc -119
    //   348: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   351: ifne +23 -> 374
    //   354: aload 7
    //   356: ldc -117
    //   358: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   361: ifne +13 -> 374
    //   364: aload 7
    //   366: ldc -115
    //   368: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   371: ifeq +104 -> 475
    //   374: aload_1
    //   375: aconst_null
    //   376: ldc 59
    //   378: invokeinterface 65 3 0
    //   383: astore 8
    //   385: aload 8
    //   387: ifnull -378 -> 9
    //   390: aload_2
    //   391: aload 7
    //   393: aload 8
    //   395: invokevirtual 144	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: goto -389 -> 9
    //   401: astore_1
    //   402: aload_1
    //   403: invokevirtual 41	java/lang/Exception:printStackTrace	()V
    //   406: return
    //   407: astore 9
    //   409: aload 9
    //   411: invokevirtual 32	java/lang/NumberFormatException:printStackTrace	()V
    //   414: goto +351 -> 765
    //   417: astore 8
    //   419: aload 8
    //   421: invokevirtual 32	java/lang/NumberFormatException:printStackTrace	()V
    //   424: goto +347 -> 771
    //   427: astore 8
    //   429: aload 8
    //   431: invokevirtual 32	java/lang/NumberFormatException:printStackTrace	()V
    //   434: goto +344 -> 778
    //   437: astore 8
    //   439: aload 8
    //   441: invokevirtual 32	java/lang/NumberFormatException:printStackTrace	()V
    //   444: goto +341 -> 785
    //   447: aload 7
    //   449: ldc 86
    //   451: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   454: ifeq -267 -> 187
    //   457: iload_3
    //   458: iconst_3
    //   459: if_icmpne -272 -> 187
    //   462: aload_0
    //   463: getfield 105	com/gau/go/launcherex/gowidget/weather/f/d:a	Z
    //   466: ifeq -279 -> 187
    //   469: aload_0
    //   470: iconst_0
    //   471: putfield 105	com/gau/go/launcherex/gowidget/weather/f/d:a	Z
    //   474: return
    //   475: aload 7
    //   477: ldc -110
    //   479: invokevirtual 150	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   482: ifeq +21 -> 503
    //   485: aload_0
    //   486: aload_1
    //   487: aload_2
    //   488: invokevirtual 154	com/gau/go/launcherex/gowidget/weather/f/a:c	()[Ljava/lang/String;
    //   491: aload_0
    //   492: aload 7
    //   494: invokespecial 156	com/gau/go/launcherex/gowidget/weather/f/d:a	(Ljava/lang/String;)I
    //   497: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/d:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   500: goto -491 -> 9
    //   503: aload 7
    //   505: ldc -96
    //   507: invokevirtual 150	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   510: ifeq +21 -> 531
    //   513: aload_0
    //   514: aload_1
    //   515: aload_2
    //   516: invokevirtual 163	com/gau/go/launcherex/gowidget/weather/f/a:d	()[Ljava/lang/String;
    //   519: aload_0
    //   520: aload 7
    //   522: invokespecial 156	com/gau/go/launcherex/gowidget/weather/f/d:a	(Ljava/lang/String;)I
    //   525: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/d:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   528: goto -519 -> 9
    //   531: aload 7
    //   533: ldc -91
    //   535: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   538: ifeq +16 -> 554
    //   541: aload_0
    //   542: aload_1
    //   543: aload_2
    //   544: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   547: iconst_0
    //   548: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/d:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   551: goto -542 -> 9
    //   554: aload 7
    //   556: ldc -87
    //   558: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   561: ifeq +16 -> 577
    //   564: aload_0
    //   565: aload_1
    //   566: aload_2
    //   567: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   570: iconst_1
    //   571: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/d:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   574: goto -565 -> 9
    //   577: aload 7
    //   579: ldc -85
    //   581: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   584: ifeq +16 -> 600
    //   587: aload_0
    //   588: aload_1
    //   589: aload_2
    //   590: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   593: iconst_2
    //   594: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/d:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   597: goto -588 -> 9
    //   600: aload 7
    //   602: ldc -83
    //   604: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   607: ifeq +16 -> 623
    //   610: aload_0
    //   611: aload_1
    //   612: aload_2
    //   613: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   616: iconst_3
    //   617: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/d:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   620: goto -611 -> 9
    //   623: aload 7
    //   625: ldc -81
    //   627: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   630: ifeq +16 -> 646
    //   633: aload_0
    //   634: aload_1
    //   635: aload_2
    //   636: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   639: iconst_4
    //   640: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/d:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   643: goto -634 -> 9
    //   646: aload 7
    //   648: ldc -79
    //   650: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   653: ifeq +16 -> 669
    //   656: aload_0
    //   657: aload_1
    //   658: aload_2
    //   659: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   662: iconst_5
    //   663: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/d:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   666: goto -657 -> 9
    //   669: aload 7
    //   671: ldc -77
    //   673: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   676: ifeq +17 -> 693
    //   679: aload_0
    //   680: aload_1
    //   681: aload_2
    //   682: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   685: bipush 6
    //   687: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/d:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   690: goto -681 -> 9
    //   693: aload 7
    //   695: ldc -75
    //   697: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   700: ifeq +17 -> 717
    //   703: aload_0
    //   704: aload_1
    //   705: aload_2
    //   706: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   709: bipush 7
    //   711: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/d:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   714: goto -705 -> 9
    //   717: aload 7
    //   719: ldc -73
    //   721: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   724: ifeq +17 -> 741
    //   727: aload_0
    //   728: aload_1
    //   729: aload_2
    //   730: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   733: bipush 8
    //   735: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/d:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   738: goto -729 -> 9
    //   741: aload 7
    //   743: ldc -71
    //   745: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   748: ifeq -739 -> 9
    //   751: aload_0
    //   752: aload_1
    //   753: aload_2
    //   754: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   757: bipush 9
    //   759: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/d:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   762: goto -753 -> 9
    //   765: bipush -100
    //   767: istore_3
    //   768: goto -672 -> 96
    //   771: bipush -100
    //   773: istore 4
    //   775: goto -667 -> 108
    //   778: bipush -100
    //   780: istore 5
    //   782: goto -650 -> 132
    //   785: bipush -100
    //   787: istore 6
    //   789: goto -633 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	792	0	this	d
    //   0	792	1	paramXmlPullParser	XmlPullParser
    //   0	792	2	parama	a
    //   42	726	3	i	int
    //   106	668	4	j	int
    //   130	651	5	k	int
    //   154	634	6	m	int
    //   34	708	7	str1	String
    //   83	311	8	str2	String
    //   417	3	8	localNumberFormatException1	NumberFormatException
    //   427	3	8	localNumberFormatException2	NumberFormatException
    //   437	3	8	localNumberFormatException3	NumberFormatException
    //   72	19	9	str3	String
    //   407	3	9	localNumberFormatException4	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   9	43	401	java/lang/Exception
    //   48	58	401	java/lang/Exception
    //   63	85	401	java/lang/Exception
    //   90	96	401	java/lang/Exception
    //   101	108	401	java/lang/Exception
    //   108	116	401	java/lang/Exception
    //   121	132	401	java/lang/Exception
    //   132	140	401	java/lang/Exception
    //   145	156	401	java/lang/Exception
    //   182	187	401	java/lang/Exception
    //   187	374	401	java/lang/Exception
    //   374	385	401	java/lang/Exception
    //   390	398	401	java/lang/Exception
    //   409	414	401	java/lang/Exception
    //   419	424	401	java/lang/Exception
    //   429	434	401	java/lang/Exception
    //   439	444	401	java/lang/Exception
    //   447	457	401	java/lang/Exception
    //   462	474	401	java/lang/Exception
    //   475	500	401	java/lang/Exception
    //   503	528	401	java/lang/Exception
    //   531	551	401	java/lang/Exception
    //   554	574	401	java/lang/Exception
    //   577	597	401	java/lang/Exception
    //   600	620	401	java/lang/Exception
    //   623	643	401	java/lang/Exception
    //   646	666	401	java/lang/Exception
    //   669	690	401	java/lang/Exception
    //   693	714	401	java/lang/Exception
    //   717	738	401	java/lang/Exception
    //   741	762	401	java/lang/Exception
    //   90	96	407	java/lang/NumberFormatException
    //   101	108	417	java/lang/NumberFormatException
    //   121	132	427	java/lang/NumberFormatException
    //   145	156	437	java/lang/NumberFormatException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */