package com.gau.go.launcherex.gowidget.weather.f;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import org.xmlpull.v1.XmlPullParser;

public class c
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
    catch (OutOfMemoryError paramResources)
    {
      return null;
    }
    catch (Resources.NotFoundException paramResources) {}
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
    //   10: invokeinterface 79 1 0
    //   15: iconst_1
    //   16: if_icmpeq -8 -> 8
    //   19: aload_1
    //   20: invokeinterface 83 1 0
    //   25: ifnull -16 -> 9
    //   28: aload_1
    //   29: invokeinterface 83 1 0
    //   34: astore 7
    //   36: aload_1
    //   37: invokeinterface 86 1 0
    //   42: istore_3
    //   43: aload 7
    //   45: ifnull -36 -> 9
    //   48: aload 7
    //   50: ldc 88
    //   52: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifeq +382 -> 437
    //   58: iload_3
    //   59: iconst_2
    //   60: if_icmpne +377 -> 437
    //   63: aload_1
    //   64: aconst_null
    //   65: ldc 94
    //   67: invokeinterface 67 3 0
    //   72: astore 9
    //   74: aload_1
    //   75: aconst_null
    //   76: ldc 96
    //   78: invokeinterface 67 3 0
    //   83: astore 8
    //   85: aload 9
    //   87: ifnull +668 -> 755
    //   90: aload 9
    //   92: invokestatic 29	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   95: istore_3
    //   96: aload 8
    //   98: ifnull +663 -> 761
    //   101: aload 8
    //   103: invokestatic 29	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   106: istore 4
    //   108: aload_2
    //   109: ldc 98
    //   111: invokevirtual 103	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore 8
    //   116: aload 8
    //   118: ifnull +650 -> 768
    //   121: aload_2
    //   122: ldc 98
    //   124: invokevirtual 103	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   127: invokestatic 29	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   130: istore 5
    //   132: aload_2
    //   133: ldc 105
    //   135: invokevirtual 103	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   138: astore 8
    //   140: aload 8
    //   142: ifnull +633 -> 775
    //   145: aload_2
    //   146: ldc 105
    //   148: invokevirtual 103	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;)Ljava/lang/String;
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
    //   184: putfield 107	com/gau/go/launcherex/gowidget/weather/f/c:a	Z
    //   187: aload_0
    //   188: getfield 107	com/gau/go/launcherex/gowidget/weather/f/c:a	Z
    //   191: ifeq +274 -> 465
    //   194: aload 7
    //   196: ldc 109
    //   198: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifne +163 -> 364
    //   204: aload 7
    //   206: ldc 111
    //   208: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: ifne +153 -> 364
    //   214: aload 7
    //   216: ldc 113
    //   218: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   221: ifne +143 -> 364
    //   224: aload 7
    //   226: ldc 115
    //   228: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifne +133 -> 364
    //   234: aload 7
    //   236: ldc 117
    //   238: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   241: ifne +123 -> 364
    //   244: aload 7
    //   246: ldc 119
    //   248: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   251: ifne +113 -> 364
    //   254: aload 7
    //   256: ldc 121
    //   258: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   261: ifne +103 -> 364
    //   264: aload 7
    //   266: ldc 123
    //   268: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   271: ifne +93 -> 364
    //   274: aload 7
    //   276: ldc 125
    //   278: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   281: ifne +83 -> 364
    //   284: aload 7
    //   286: ldc 127
    //   288: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   291: ifne +73 -> 364
    //   294: aload 7
    //   296: ldc -127
    //   298: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   301: ifne +63 -> 364
    //   304: aload 7
    //   306: ldc -125
    //   308: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   311: ifne +53 -> 364
    //   314: aload 7
    //   316: ldc -123
    //   318: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   321: ifne +43 -> 364
    //   324: aload 7
    //   326: ldc -121
    //   328: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   331: ifne +33 -> 364
    //   334: aload 7
    //   336: ldc -119
    //   338: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   341: ifne +23 -> 364
    //   344: aload 7
    //   346: ldc -117
    //   348: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   351: ifne +13 -> 364
    //   354: aload 7
    //   356: ldc -115
    //   358: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   361: ifeq +104 -> 465
    //   364: aload_1
    //   365: aconst_null
    //   366: ldc 61
    //   368: invokeinterface 67 3 0
    //   373: astore 8
    //   375: aload 8
    //   377: ifnull -368 -> 9
    //   380: aload_2
    //   381: aload 7
    //   383: aload 8
    //   385: invokevirtual 144	com/gau/go/launcherex/gowidget/weather/f/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   388: goto -379 -> 9
    //   391: astore_1
    //   392: aload_1
    //   393: invokevirtual 41	java/lang/Exception:printStackTrace	()V
    //   396: return
    //   397: astore 9
    //   399: aload 9
    //   401: invokevirtual 32	java/lang/NumberFormatException:printStackTrace	()V
    //   404: goto +351 -> 755
    //   407: astore 8
    //   409: aload 8
    //   411: invokevirtual 32	java/lang/NumberFormatException:printStackTrace	()V
    //   414: goto +347 -> 761
    //   417: astore 8
    //   419: aload 8
    //   421: invokevirtual 32	java/lang/NumberFormatException:printStackTrace	()V
    //   424: goto +344 -> 768
    //   427: astore 8
    //   429: aload 8
    //   431: invokevirtual 32	java/lang/NumberFormatException:printStackTrace	()V
    //   434: goto +341 -> 775
    //   437: aload 7
    //   439: ldc 88
    //   441: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   444: ifeq -257 -> 187
    //   447: iload_3
    //   448: iconst_3
    //   449: if_icmpne -262 -> 187
    //   452: aload_0
    //   453: getfield 107	com/gau/go/launcherex/gowidget/weather/f/c:a	Z
    //   456: ifeq -269 -> 187
    //   459: aload_0
    //   460: iconst_0
    //   461: putfield 107	com/gau/go/launcherex/gowidget/weather/f/c:a	Z
    //   464: return
    //   465: aload 7
    //   467: ldc -110
    //   469: invokevirtual 150	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   472: ifeq +21 -> 493
    //   475: aload_0
    //   476: aload_1
    //   477: aload_2
    //   478: invokevirtual 154	com/gau/go/launcherex/gowidget/weather/f/a:c	()[Ljava/lang/String;
    //   481: aload_0
    //   482: aload 7
    //   484: invokespecial 156	com/gau/go/launcherex/gowidget/weather/f/c:a	(Ljava/lang/String;)I
    //   487: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/c:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   490: goto -481 -> 9
    //   493: aload 7
    //   495: ldc -96
    //   497: invokevirtual 150	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   500: ifeq +21 -> 521
    //   503: aload_0
    //   504: aload_1
    //   505: aload_2
    //   506: invokevirtual 163	com/gau/go/launcherex/gowidget/weather/f/a:d	()[Ljava/lang/String;
    //   509: aload_0
    //   510: aload 7
    //   512: invokespecial 156	com/gau/go/launcherex/gowidget/weather/f/c:a	(Ljava/lang/String;)I
    //   515: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/c:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   518: goto -509 -> 9
    //   521: aload 7
    //   523: ldc -91
    //   525: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   528: ifeq +16 -> 544
    //   531: aload_0
    //   532: aload_1
    //   533: aload_2
    //   534: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   537: iconst_0
    //   538: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/c:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   541: goto -532 -> 9
    //   544: aload 7
    //   546: ldc -87
    //   548: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   551: ifeq +16 -> 567
    //   554: aload_0
    //   555: aload_1
    //   556: aload_2
    //   557: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   560: iconst_1
    //   561: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/c:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   564: goto -555 -> 9
    //   567: aload 7
    //   569: ldc -85
    //   571: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   574: ifeq +16 -> 590
    //   577: aload_0
    //   578: aload_1
    //   579: aload_2
    //   580: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   583: iconst_2
    //   584: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/c:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   587: goto -578 -> 9
    //   590: aload 7
    //   592: ldc -83
    //   594: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   597: ifeq +16 -> 613
    //   600: aload_0
    //   601: aload_1
    //   602: aload_2
    //   603: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   606: iconst_3
    //   607: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/c:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   610: goto -601 -> 9
    //   613: aload 7
    //   615: ldc -81
    //   617: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   620: ifeq +16 -> 636
    //   623: aload_0
    //   624: aload_1
    //   625: aload_2
    //   626: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   629: iconst_4
    //   630: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/c:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   633: goto -624 -> 9
    //   636: aload 7
    //   638: ldc -79
    //   640: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   643: ifeq +16 -> 659
    //   646: aload_0
    //   647: aload_1
    //   648: aload_2
    //   649: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   652: iconst_5
    //   653: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/c:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   656: goto -647 -> 9
    //   659: aload 7
    //   661: ldc -77
    //   663: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   666: ifeq +17 -> 683
    //   669: aload_0
    //   670: aload_1
    //   671: aload_2
    //   672: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   675: bipush 6
    //   677: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/c:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   680: goto -671 -> 9
    //   683: aload 7
    //   685: ldc -75
    //   687: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   690: ifeq +17 -> 707
    //   693: aload_0
    //   694: aload_1
    //   695: aload_2
    //   696: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   699: bipush 7
    //   701: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/c:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   704: goto -695 -> 9
    //   707: aload 7
    //   709: ldc -73
    //   711: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   714: ifeq +17 -> 731
    //   717: aload_0
    //   718: aload_1
    //   719: aload_2
    //   720: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   723: bipush 8
    //   725: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/c:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   728: goto -719 -> 9
    //   731: aload 7
    //   733: ldc -71
    //   735: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   738: ifeq -729 -> 9
    //   741: aload_0
    //   742: aload_1
    //   743: aload_2
    //   744: invokevirtual 167	com/gau/go/launcherex/gowidget/weather/f/a:b	()[Ljava/lang/String;
    //   747: bipush 9
    //   749: invokespecial 158	com/gau/go/launcherex/gowidget/weather/f/c:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   752: goto -743 -> 9
    //   755: bipush -100
    //   757: istore_3
    //   758: goto -662 -> 96
    //   761: bipush -100
    //   763: istore 4
    //   765: goto -657 -> 108
    //   768: bipush -100
    //   770: istore 5
    //   772: goto -640 -> 132
    //   775: bipush -100
    //   777: istore 6
    //   779: goto -623 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	782	0	this	c
    //   0	782	1	paramXmlPullParser	XmlPullParser
    //   0	782	2	parama	a
    //   42	716	3	i	int
    //   106	658	4	j	int
    //   130	641	5	k	int
    //   154	624	6	m	int
    //   34	698	7	str1	String
    //   83	301	8	str2	String
    //   407	3	8	localNumberFormatException1	NumberFormatException
    //   417	3	8	localNumberFormatException2	NumberFormatException
    //   427	3	8	localNumberFormatException3	NumberFormatException
    //   72	19	9	str3	String
    //   397	3	9	localNumberFormatException4	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   9	43	391	java/lang/Exception
    //   48	58	391	java/lang/Exception
    //   63	85	391	java/lang/Exception
    //   90	96	391	java/lang/Exception
    //   101	108	391	java/lang/Exception
    //   108	116	391	java/lang/Exception
    //   121	132	391	java/lang/Exception
    //   132	140	391	java/lang/Exception
    //   145	156	391	java/lang/Exception
    //   182	187	391	java/lang/Exception
    //   187	364	391	java/lang/Exception
    //   364	375	391	java/lang/Exception
    //   380	388	391	java/lang/Exception
    //   399	404	391	java/lang/Exception
    //   409	414	391	java/lang/Exception
    //   419	424	391	java/lang/Exception
    //   429	434	391	java/lang/Exception
    //   437	447	391	java/lang/Exception
    //   452	464	391	java/lang/Exception
    //   465	490	391	java/lang/Exception
    //   493	518	391	java/lang/Exception
    //   521	541	391	java/lang/Exception
    //   544	564	391	java/lang/Exception
    //   567	587	391	java/lang/Exception
    //   590	610	391	java/lang/Exception
    //   613	633	391	java/lang/Exception
    //   636	656	391	java/lang/Exception
    //   659	680	391	java/lang/Exception
    //   683	704	391	java/lang/Exception
    //   707	728	391	java/lang/Exception
    //   731	752	391	java/lang/Exception
    //   90	96	397	java/lang/NumberFormatException
    //   101	108	407	java/lang/NumberFormatException
    //   121	132	417	java/lang/NumberFormatException
    //   145	156	427	java/lang/NumberFormatException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */