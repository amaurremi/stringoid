package com.gau.go.launcherex.gowidget.weather.systemwidget;

import org.xmlpull.v1.XmlPullParser;

public class am
{
  public static final String[] a = { "go_weatherex_widget_unknow", "go_weatherex_widget_sun", "go_weatherex_widget_sun_night", "go_weatherex_widget_cloud", "go_weatherex_widget_cloud_night", "go_weatherex_widget_dark_cloud", "go_weatherex_widget_snow", "go_weatherex_widget_fog", "go_weatherex_widget_rain", "go_weatherex_widget_thunderstorm" };
  public static final String[] b = { "go_weatherex_widget_unknow_forecast", "go_weatherex_widget_sun_forecast", "go_weatherex_widget_sun_night_forecast", "go_weatherex_widget_cloud_forecast", "go_weatherex_widget_cloud_night_forecast", "go_weatherex_widget_dark_cloud_forecast", "go_weatherex_widget_snow_forecast", "go_weatherex_widget_fog_forecast", "go_weatherex_widget_rain_forecast", "go_weatherex_widget_thunderstorm_forecast" };
  private boolean c;
  
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
  
  private void a(XmlPullParser paramXmlPullParser, String[] paramArrayOfString, int paramInt)
  {
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "src");
    if (paramXmlPullParser != null) {
      paramArrayOfString[paramInt] = paramXmlPullParser;
    }
  }
  
  /* Error */
  public void a(XmlPullParser paramXmlPullParser, an paraman)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_1
    //   10: invokeinterface 95 1 0
    //   15: iconst_1
    //   16: if_icmpeq -8 -> 8
    //   19: aload_1
    //   20: invokeinterface 99 1 0
    //   25: ifnull -16 -> 9
    //   28: aload_1
    //   29: invokeinterface 99 1 0
    //   34: astore 5
    //   36: aload_1
    //   37: invokeinterface 102 1 0
    //   42: istore_3
    //   43: aload 5
    //   45: ifnull -36 -> 9
    //   48: aload 5
    //   50: ldc 104
    //   52: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifeq +221 -> 276
    //   58: iload_3
    //   59: iconst_2
    //   60: if_icmpne +216 -> 276
    //   63: aload_1
    //   64: aconst_null
    //   65: ldc 110
    //   67: invokeinterface 89 3 0
    //   72: astore 6
    //   74: aload 6
    //   76: ifnull +479 -> 555
    //   79: aload 6
    //   81: invokestatic 77	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   84: istore_3
    //   85: aload_2
    //   86: ldc 112
    //   88: invokevirtual 117	com/gau/go/launcherex/gowidget/weather/systemwidget/an:a	(Ljava/lang/String;)Ljava/lang/String;
    //   91: astore 6
    //   93: aload 6
    //   95: ifnull +466 -> 561
    //   98: aload_2
    //   99: ldc 112
    //   101: invokevirtual 117	com/gau/go/launcherex/gowidget/weather/systemwidget/an:a	(Ljava/lang/String;)Ljava/lang/String;
    //   104: invokestatic 77	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   107: istore 4
    //   109: iload_3
    //   110: iload 4
    //   112: if_icmpne +14 -> 126
    //   115: iload_3
    //   116: bipush -100
    //   118: if_icmpeq +8 -> 126
    //   121: aload_0
    //   122: iconst_1
    //   123: putfield 119	com/gau/go/launcherex/gowidget/weather/systemwidget/am:c	Z
    //   126: aload_0
    //   127: getfield 119	com/gau/go/launcherex/gowidget/weather/systemwidget/am:c	Z
    //   130: ifeq +174 -> 304
    //   133: aload 5
    //   135: ldc 121
    //   137: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   140: ifne +83 -> 223
    //   143: aload 5
    //   145: ldc 123
    //   147: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   150: ifne +73 -> 223
    //   153: aload 5
    //   155: ldc 125
    //   157: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifne +63 -> 223
    //   163: aload 5
    //   165: ldc 127
    //   167: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   170: ifne +53 -> 223
    //   173: aload 5
    //   175: ldc -127
    //   177: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   180: ifne +43 -> 223
    //   183: aload 5
    //   185: ldc -125
    //   187: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: ifne +33 -> 223
    //   193: aload 5
    //   195: ldc -123
    //   197: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   200: ifne +23 -> 223
    //   203: aload 5
    //   205: ldc -121
    //   207: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   210: ifne +13 -> 223
    //   213: aload 5
    //   215: ldc -119
    //   217: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   220: ifeq +84 -> 304
    //   223: aload_1
    //   224: aconst_null
    //   225: ldc 83
    //   227: invokeinterface 89 3 0
    //   232: astore 6
    //   234: aload 6
    //   236: ifnull -227 -> 9
    //   239: aload_2
    //   240: aload 5
    //   242: aload 6
    //   244: invokevirtual 140	com/gau/go/launcherex/gowidget/weather/systemwidget/an:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: goto -238 -> 9
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   255: return
    //   256: astore 6
    //   258: aload 6
    //   260: invokevirtual 80	java/lang/NumberFormatException:printStackTrace	()V
    //   263: goto +292 -> 555
    //   266: astore 6
    //   268: aload 6
    //   270: invokevirtual 80	java/lang/NumberFormatException:printStackTrace	()V
    //   273: goto +288 -> 561
    //   276: aload 5
    //   278: ldc 104
    //   280: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   283: ifeq -157 -> 126
    //   286: iload_3
    //   287: iconst_3
    //   288: if_icmpne -162 -> 126
    //   291: aload_0
    //   292: getfield 119	com/gau/go/launcherex/gowidget/weather/systemwidget/am:c	Z
    //   295: ifeq -169 -> 126
    //   298: aload_0
    //   299: iconst_0
    //   300: putfield 119	com/gau/go/launcherex/gowidget/weather/systemwidget/am:c	Z
    //   303: return
    //   304: aload 5
    //   306: ldc -113
    //   308: invokevirtual 147	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   311: ifeq +20 -> 331
    //   314: aload_0
    //   315: aload_1
    //   316: invokestatic 150	com/gau/go/launcherex/gowidget/weather/systemwidget/an:b	()[Ljava/lang/String;
    //   319: aload_0
    //   320: aload 5
    //   322: invokespecial 152	com/gau/go/launcherex/gowidget/weather/systemwidget/am:a	(Ljava/lang/String;)I
    //   325: invokespecial 154	com/gau/go/launcherex/gowidget/weather/systemwidget/am:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   328: goto -319 -> 9
    //   331: aload 5
    //   333: ldc 15
    //   335: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   338: ifeq +15 -> 353
    //   341: aload_0
    //   342: aload_1
    //   343: invokestatic 156	com/gau/go/launcherex/gowidget/weather/systemwidget/an:a	()[Ljava/lang/String;
    //   346: iconst_0
    //   347: invokespecial 154	com/gau/go/launcherex/gowidget/weather/systemwidget/am:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   350: goto -341 -> 9
    //   353: aload 5
    //   355: ldc 17
    //   357: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   360: ifeq +15 -> 375
    //   363: aload_0
    //   364: aload_1
    //   365: invokestatic 156	com/gau/go/launcherex/gowidget/weather/systemwidget/an:a	()[Ljava/lang/String;
    //   368: iconst_1
    //   369: invokespecial 154	com/gau/go/launcherex/gowidget/weather/systemwidget/am:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   372: goto -363 -> 9
    //   375: aload 5
    //   377: ldc 19
    //   379: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   382: ifeq +15 -> 397
    //   385: aload_0
    //   386: aload_1
    //   387: invokestatic 156	com/gau/go/launcherex/gowidget/weather/systemwidget/an:a	()[Ljava/lang/String;
    //   390: iconst_2
    //   391: invokespecial 154	com/gau/go/launcherex/gowidget/weather/systemwidget/am:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   394: goto -385 -> 9
    //   397: aload 5
    //   399: ldc 21
    //   401: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   404: ifeq +15 -> 419
    //   407: aload_0
    //   408: aload_1
    //   409: invokestatic 156	com/gau/go/launcherex/gowidget/weather/systemwidget/an:a	()[Ljava/lang/String;
    //   412: iconst_3
    //   413: invokespecial 154	com/gau/go/launcherex/gowidget/weather/systemwidget/am:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   416: goto -407 -> 9
    //   419: aload 5
    //   421: ldc 23
    //   423: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   426: ifeq +15 -> 441
    //   429: aload_0
    //   430: aload_1
    //   431: invokestatic 156	com/gau/go/launcherex/gowidget/weather/systemwidget/an:a	()[Ljava/lang/String;
    //   434: iconst_4
    //   435: invokespecial 154	com/gau/go/launcherex/gowidget/weather/systemwidget/am:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   438: goto -429 -> 9
    //   441: aload 5
    //   443: ldc 25
    //   445: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   448: ifeq +15 -> 463
    //   451: aload_0
    //   452: aload_1
    //   453: invokestatic 156	com/gau/go/launcherex/gowidget/weather/systemwidget/an:a	()[Ljava/lang/String;
    //   456: iconst_5
    //   457: invokespecial 154	com/gau/go/launcherex/gowidget/weather/systemwidget/am:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   460: goto -451 -> 9
    //   463: aload 5
    //   465: ldc 27
    //   467: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   470: ifeq +16 -> 486
    //   473: aload_0
    //   474: aload_1
    //   475: invokestatic 156	com/gau/go/launcherex/gowidget/weather/systemwidget/an:a	()[Ljava/lang/String;
    //   478: bipush 6
    //   480: invokespecial 154	com/gau/go/launcherex/gowidget/weather/systemwidget/am:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   483: goto -474 -> 9
    //   486: aload 5
    //   488: ldc 29
    //   490: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   493: ifeq +16 -> 509
    //   496: aload_0
    //   497: aload_1
    //   498: invokestatic 156	com/gau/go/launcherex/gowidget/weather/systemwidget/an:a	()[Ljava/lang/String;
    //   501: bipush 7
    //   503: invokespecial 154	com/gau/go/launcherex/gowidget/weather/systemwidget/am:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   506: goto -497 -> 9
    //   509: aload 5
    //   511: ldc 31
    //   513: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   516: ifeq +16 -> 532
    //   519: aload_0
    //   520: aload_1
    //   521: invokestatic 156	com/gau/go/launcherex/gowidget/weather/systemwidget/an:a	()[Ljava/lang/String;
    //   524: bipush 8
    //   526: invokespecial 154	com/gau/go/launcherex/gowidget/weather/systemwidget/am:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   529: goto -520 -> 9
    //   532: aload 5
    //   534: ldc 33
    //   536: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   539: ifeq -530 -> 9
    //   542: aload_0
    //   543: aload_1
    //   544: invokestatic 156	com/gau/go/launcherex/gowidget/weather/systemwidget/an:a	()[Ljava/lang/String;
    //   547: bipush 9
    //   549: invokespecial 154	com/gau/go/launcherex/gowidget/weather/systemwidget/am:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;I)V
    //   552: goto -543 -> 9
    //   555: bipush -100
    //   557: istore_3
    //   558: goto -473 -> 85
    //   561: bipush -100
    //   563: istore 4
    //   565: goto -456 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	568	0	this	am
    //   0	568	1	paramXmlPullParser	XmlPullParser
    //   0	568	2	paraman	an
    //   42	516	3	i	int
    //   107	457	4	j	int
    //   34	499	5	str1	String
    //   72	171	6	str2	String
    //   256	3	6	localNumberFormatException1	NumberFormatException
    //   266	3	6	localNumberFormatException2	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   9	43	250	java/lang/Exception
    //   48	58	250	java/lang/Exception
    //   63	74	250	java/lang/Exception
    //   79	85	250	java/lang/Exception
    //   85	93	250	java/lang/Exception
    //   98	109	250	java/lang/Exception
    //   121	126	250	java/lang/Exception
    //   126	223	250	java/lang/Exception
    //   223	234	250	java/lang/Exception
    //   239	247	250	java/lang/Exception
    //   258	263	250	java/lang/Exception
    //   268	273	250	java/lang/Exception
    //   276	286	250	java/lang/Exception
    //   291	303	250	java/lang/Exception
    //   304	328	250	java/lang/Exception
    //   331	350	250	java/lang/Exception
    //   353	372	250	java/lang/Exception
    //   375	394	250	java/lang/Exception
    //   397	416	250	java/lang/Exception
    //   419	438	250	java/lang/Exception
    //   441	460	250	java/lang/Exception
    //   463	483	250	java/lang/Exception
    //   486	506	250	java/lang/Exception
    //   509	529	250	java/lang/Exception
    //   532	552	250	java/lang/Exception
    //   79	85	256	java/lang/NumberFormatException
    //   98	109	266	java/lang/NumberFormatException
  }
  
  public void a(XmlPullParser paramXmlPullParser, ao paramao)
  {
    if ((paramXmlPullParser == null) || (paramao == null)) {
      return;
    }
    for (;;)
    {
      String str1;
      int i;
      int j;
      try
      {
        if (paramXmlPullParser.next() == 1) {
          break;
        }
        if (paramXmlPullParser.getName() == null) {
          continue;
        }
        str1 = paramXmlPullParser.getName();
        i = paramXmlPullParser.getEventType();
        if (str1 == null) {
          continue;
        }
        if ((str1.equals("systemwidget")) && (i == 2))
        {
          str2 = paramXmlPullParser.getAttributeValue(null, "style_id");
          if (str2 == null) {
            break label679;
          }
        }
      }
      catch (Exception paramXmlPullParser)
      {
        try
        {
          i = Integer.parseInt(str2);
          str2 = paramao.a("systemwidget_style");
          if (str2 == null) {
            break label685;
          }
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          String str2;
          localNumberFormatException1.printStackTrace();
        }
        try
        {
          j = Integer.parseInt(paramao.a("systemwidget_style"));
          if ((i == j) && (i != -100)) {
            this.c = true;
          }
          if (((!this.c) || ((!str1.equals("go_weatherex_widget_temp_minus")) && (!str1.equals("go_weatherex_widget_temp_unit_centigrade")) && (!str1.equals("go_weatherex_widget_temp_unit_fahrenheit")) && (!str1.equals("go_weatherex_widget_temp_unit")) && (!str1.equals("go_weatherex_widget_time_bg")) && (!str1.equals("go_weatherex_widget_time_divider")) && (!str1.equals("go_weatherex_widget_time_bg")) && (!str1.equals("go_weatherex_widget_change_city")) && (!str1.equals("go_weatherex_widget_time_am")) && (!str1.equals("go_weatherex_widget_time_pm")) && (!str1.equals("go_weatherex_widget_time_ampm_empty")) && (!str1.equals("go_weatherex_widget_bg")) && (!str1.equals("go_weatherex_widget_bg_day")) && (!str1.equals("go_weatherex_widget_extreme_icon")) && (!str1.equals("go_weatherex_widget_bg_night")))) && (!str1.equals("go_weatherex_widget_date_style_color"))) {
            break label374;
          }
          str2 = paramXmlPullParser.getAttributeValue(null, "src");
          if (str2 == null) {
            continue;
          }
          paramao.a(str1, str2);
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          localNumberFormatException2.printStackTrace();
          break label685;
        }
        paramXmlPullParser = paramXmlPullParser;
        paramXmlPullParser.printStackTrace();
        return;
      }
      if ((str1.equals("systemwidget")) && (i == 3) && (this.c))
      {
        this.c = false;
        return;
        label374:
        if (str1.startsWith("go_weatherex_widget_time_num"))
        {
          a(paramXmlPullParser, ao.b(), a(str1));
        }
        else if (str1.startsWith("go_weatherex_widget_time_min_num"))
        {
          a(paramXmlPullParser, ao.c(), a(str1));
        }
        else if (str1.startsWith("go_weatherex_widget_temp_num"))
        {
          a(paramXmlPullParser, ao.d(), a(str1));
        }
        else if (str1.equals("go_weatherex_widget_unknow"))
        {
          a(paramXmlPullParser, ao.a(), 0);
        }
        else if (str1.equals("go_weatherex_widget_sun"))
        {
          a(paramXmlPullParser, ao.a(), 1);
        }
        else if (str1.equals("go_weatherex_widget_sun_night"))
        {
          a(paramXmlPullParser, ao.a(), 2);
        }
        else if (str1.equals("go_weatherex_widget_cloud"))
        {
          a(paramXmlPullParser, ao.a(), 3);
        }
        else if (str1.equals("go_weatherex_widget_cloud_night"))
        {
          a(paramXmlPullParser, ao.a(), 4);
        }
        else if (str1.equals("go_weatherex_widget_dark_cloud"))
        {
          a(paramXmlPullParser, ao.a(), 5);
        }
        else if (str1.equals("go_weatherex_widget_snow"))
        {
          a(paramXmlPullParser, ao.a(), 6);
        }
        else if (str1.equals("go_weatherex_widget_fog"))
        {
          a(paramXmlPullParser, ao.a(), 7);
        }
        else if (str1.equals("go_weatherex_widget_rain"))
        {
          a(paramXmlPullParser, ao.a(), 8);
        }
        else if (str1.equals("go_weatherex_widget_thunderstorm"))
        {
          a(paramXmlPullParser, ao.a(), 9);
          continue;
          label679:
          i = -100;
          continue;
          label685:
          j = -100;
        }
      }
    }
  }
  
  public void a(XmlPullParser paramXmlPullParser, ap paramap)
  {
    if ((paramXmlPullParser == null) || (paramap == null)) {
      return;
    }
    for (;;)
    {
      String str1;
      int i;
      int j;
      try
      {
        if (paramXmlPullParser.next() == 1) {
          break;
        }
        if (paramXmlPullParser.getName() == null) {
          continue;
        }
        str1 = paramXmlPullParser.getName();
        i = paramXmlPullParser.getEventType();
        if (str1 == null) {
          continue;
        }
        if ((str1.equals("systemwidget")) && (i == 2))
        {
          str2 = paramXmlPullParser.getAttributeValue(null, "style_id");
          if (str2 == null) {
            break label679;
          }
        }
      }
      catch (Exception paramXmlPullParser)
      {
        try
        {
          i = Integer.parseInt(str2);
          str2 = paramap.a("systemwidget_style");
          if (str2 == null) {
            break label685;
          }
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          String str2;
          localNumberFormatException1.printStackTrace();
        }
        try
        {
          j = Integer.parseInt(paramap.a("systemwidget_style"));
          if ((i == j) && (i != -100)) {
            this.c = true;
          }
          if (((!this.c) || ((!str1.equals("go_weatherex_widget_temp_minus")) && (!str1.equals("go_weatherex_widget_temp_unit_centigrade")) && (!str1.equals("go_weatherex_widget_temp_unit_fahrenheit")) && (!str1.equals("go_weatherex_widget_temp_unit")) && (!str1.equals("go_weatherex_widget_time_bg")) && (!str1.equals("go_weatherex_widget_time_divider")) && (!str1.equals("go_weatherex_widget_time_am")) && (!str1.equals("go_weatherex_widget_time_pm")) && (!str1.equals("go_weatherex_widget_time_ampm_empty")) && (!str1.equals("go_weatherex_widget_time_bg")) && (!str1.equals("go_weatherex_widget_change_city")) && (!str1.equals("go_weatherex_widget_bg")) && (!str1.equals("go_weatherex_widget_bg_day")) && (!str1.equals("go_weatherex_widget_extreme_icon")) && (!str1.equals("go_weatherex_widget_bg_night")))) && (!str1.equals("go_weatherex_widget_date_style_color"))) {
            break label374;
          }
          str2 = paramXmlPullParser.getAttributeValue(null, "src");
          if (str2 == null) {
            continue;
          }
          paramap.a(str1, str2);
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          localNumberFormatException2.printStackTrace();
          break label685;
        }
        paramXmlPullParser = paramXmlPullParser;
        paramXmlPullParser.printStackTrace();
        return;
      }
      if ((str1.equals("systemwidget")) && (i == 3) && (this.c))
      {
        this.c = false;
        return;
        label374:
        if (str1.startsWith("go_weatherex_widget_time_num"))
        {
          a(paramXmlPullParser, ap.b(), a(str1));
        }
        else if (str1.startsWith("go_weatherex_widget_time_min_num"))
        {
          a(paramXmlPullParser, ap.c(), a(str1));
        }
        else if (str1.startsWith("go_weatherex_widget_temp_num"))
        {
          a(paramXmlPullParser, ap.d(), a(str1));
        }
        else if (str1.equals("go_weatherex_widget_unknow"))
        {
          a(paramXmlPullParser, ap.a(), 0);
        }
        else if (str1.equals("go_weatherex_widget_sun"))
        {
          a(paramXmlPullParser, ap.a(), 1);
        }
        else if (str1.equals("go_weatherex_widget_sun_night"))
        {
          a(paramXmlPullParser, ap.a(), 2);
        }
        else if (str1.equals("go_weatherex_widget_cloud"))
        {
          a(paramXmlPullParser, ap.a(), 3);
        }
        else if (str1.equals("go_weatherex_widget_cloud_night"))
        {
          a(paramXmlPullParser, ap.a(), 4);
        }
        else if (str1.equals("go_weatherex_widget_dark_cloud"))
        {
          a(paramXmlPullParser, ap.a(), 5);
        }
        else if (str1.equals("go_weatherex_widget_snow"))
        {
          a(paramXmlPullParser, ap.a(), 6);
        }
        else if (str1.equals("go_weatherex_widget_fog"))
        {
          a(paramXmlPullParser, ap.a(), 7);
        }
        else if (str1.equals("go_weatherex_widget_rain"))
        {
          a(paramXmlPullParser, ap.a(), 8);
        }
        else if (str1.equals("go_weatherex_widget_thunderstorm"))
        {
          a(paramXmlPullParser, ap.a(), 9);
          continue;
          label679:
          i = -100;
          continue;
          label685:
          j = -100;
        }
      }
    }
  }
  
  public void a(XmlPullParser paramXmlPullParser, aq paramaq)
  {
    if ((paramXmlPullParser == null) || (paramaq == null)) {
      return;
    }
    for (;;)
    {
      String str1;
      int i;
      int j;
      try
      {
        if (paramXmlPullParser.next() == 1) {
          break;
        }
        if (paramXmlPullParser.getName() == null) {
          continue;
        }
        str1 = paramXmlPullParser.getName();
        i = paramXmlPullParser.getEventType();
        if (str1 == null) {
          continue;
        }
        if ((str1.equals("systemwidget")) && (i == 2))
        {
          str2 = paramXmlPullParser.getAttributeValue(null, "style_id");
          if (str2 == null) {
            break label923;
          }
        }
      }
      catch (Exception paramXmlPullParser)
      {
        try
        {
          i = Integer.parseInt(str2);
          str2 = paramaq.a("systemwidget_style");
          if (str2 == null) {
            break label929;
          }
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          String str2;
          localNumberFormatException1.printStackTrace();
        }
        try
        {
          j = Integer.parseInt(paramaq.a("systemwidget_style"));
          if ((i == j) && (i != -100)) {
            this.c = true;
          }
          if (((!this.c) || ((!str1.equals("go_weatherex_widget_temp_minus")) && (!str1.equals("go_weatherex_widget_temp_unit_centigrade")) && (!str1.equals("go_weatherex_widget_temp_unit_fahrenheit")) && (!str1.equals("go_weatherex_widget_temp_unit")) && (!str1.equals("go_weatherex_widget_time_bg")) && (!str1.equals("go_weatherex_widget_time_divider")) && (!str1.equals("go_weatherex_widget_time_am")) && (!str1.equals("go_weatherex_widget_time_pm")) && (!str1.equals("go_weatherex_widget_time_ampm_empty")) && (!str1.equals("go_weatherex_widget_time_bg")) && (!str1.equals("go_weatherex_widget_change_city")) && (!str1.equals("go_weatherex_widget_bg")) && (!str1.equals("go_weatherex_widget_bg_day")) && (!str1.equals("go_weatherex_widget_extreme_icon")) && (!str1.equals("go_weatherex_widget_bg_night")) && (!str1.equals("go_weatherex_widget_next_page")) && (!str1.equals("go_weatherex_widget_previous_page")))) && (!str1.equals("go_weatherex_widget_date_style_color"))) {
            break label394;
          }
          str2 = paramXmlPullParser.getAttributeValue(null, "src");
          if (str2 == null) {
            continue;
          }
          paramaq.a(str1, str2);
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          localNumberFormatException2.printStackTrace();
          break label929;
        }
        paramXmlPullParser = paramXmlPullParser;
        paramXmlPullParser.printStackTrace();
        return;
      }
      if ((str1.equals("systemwidget")) && (i == 3) && (this.c))
      {
        this.c = false;
        return;
        label394:
        if (str1.startsWith("go_weatherex_widget_time_num"))
        {
          a(paramXmlPullParser, aq.c(), a(str1));
        }
        else if (str1.startsWith("go_weatherex_widget_time_min_num"))
        {
          a(paramXmlPullParser, aq.d(), a(str1));
        }
        else if (str1.startsWith("go_weatherex_widget_temp_num"))
        {
          a(paramXmlPullParser, aq.e(), a(str1));
        }
        else if (str1.equals("go_weatherex_widget_unknow"))
        {
          a(paramXmlPullParser, aq.b(), 0);
        }
        else if (str1.equals("go_weatherex_widget_sun"))
        {
          a(paramXmlPullParser, aq.b(), 1);
        }
        else if (str1.equals("go_weatherex_widget_sun_night"))
        {
          a(paramXmlPullParser, aq.b(), 2);
        }
        else if (str1.equals("go_weatherex_widget_cloud"))
        {
          a(paramXmlPullParser, aq.b(), 3);
        }
        else if (str1.equals("go_weatherex_widget_cloud_night"))
        {
          a(paramXmlPullParser, aq.b(), 4);
        }
        else if (str1.equals("go_weatherex_widget_dark_cloud"))
        {
          a(paramXmlPullParser, aq.b(), 5);
        }
        else if (str1.equals("go_weatherex_widget_snow"))
        {
          a(paramXmlPullParser, aq.b(), 6);
        }
        else if (str1.equals("go_weatherex_widget_fog"))
        {
          a(paramXmlPullParser, aq.b(), 7);
        }
        else if (str1.equals("go_weatherex_widget_rain"))
        {
          a(paramXmlPullParser, aq.b(), 8);
        }
        else if (str1.equals("go_weatherex_widget_thunderstorm"))
        {
          a(paramXmlPullParser, aq.b(), 9);
        }
        else if (str1.equals("go_weatherex_widget_unknow_forecast"))
        {
          a(paramXmlPullParser, aq.a(), 0);
        }
        else if (str1.equals("go_weatherex_widget_sun_forecast"))
        {
          a(paramXmlPullParser, aq.a(), 1);
        }
        else if (str1.equals("go_weatherex_widget_sun_night_forecast"))
        {
          a(paramXmlPullParser, aq.a(), 2);
        }
        else if (str1.equals("go_weatherex_widget_cloud_forecast"))
        {
          a(paramXmlPullParser, aq.a(), 3);
        }
        else if (str1.equals("go_weatherex_widget_cloud_night_forecast"))
        {
          a(paramXmlPullParser, aq.a(), 4);
        }
        else if (str1.equals("go_weatherex_widget_dark_cloud_forecast"))
        {
          a(paramXmlPullParser, aq.a(), 5);
        }
        else if (str1.equals("go_weatherex_widget_snow_forecast"))
        {
          a(paramXmlPullParser, aq.a(), 6);
        }
        else if (str1.equals("go_weatherex_widget_fog_forecast"))
        {
          a(paramXmlPullParser, aq.a(), 7);
        }
        else if (str1.equals("go_weatherex_widget_rain_forecast"))
        {
          a(paramXmlPullParser, aq.a(), 8);
        }
        else if (str1.equals("go_weatherex_widget_thunderstorm_forecast"))
        {
          a(paramXmlPullParser, aq.a(), 9);
          continue;
          label923:
          i = -100;
          continue;
          label929:
          j = -100;
        }
      }
    }
  }
  
  public void a(XmlPullParser paramXmlPullParser, ar paramar)
  {
    if ((paramXmlPullParser == null) || (paramar == null)) {
      return;
    }
    for (;;)
    {
      String str1;
      int i;
      int j;
      try
      {
        if (paramXmlPullParser.next() == 1) {
          break;
        }
        if (paramXmlPullParser.getName() == null) {
          continue;
        }
        str1 = paramXmlPullParser.getName();
        i = paramXmlPullParser.getEventType();
        if (str1 == null) {
          continue;
        }
        if ((str1.equals("systemwidget")) && (i == 2))
        {
          str2 = paramXmlPullParser.getAttributeValue(null, "style_id");
          if (str2 == null) {
            break label923;
          }
        }
      }
      catch (Exception paramXmlPullParser)
      {
        try
        {
          i = Integer.parseInt(str2);
          str2 = paramar.a("systemwidget_style");
          if (str2 == null) {
            break label929;
          }
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          String str2;
          localNumberFormatException1.printStackTrace();
        }
        try
        {
          j = Integer.parseInt(paramar.a("systemwidget_style"));
          if ((i == j) && (i != -100)) {
            this.c = true;
          }
          if (((!this.c) || ((!str1.equals("go_weatherex_widget_temp_minus")) && (!str1.equals("go_weatherex_widget_temp_unit_centigrade")) && (!str1.equals("go_weatherex_widget_temp_unit_fahrenheit")) && (!str1.equals("go_weatherex_widget_temp_unit")) && (!str1.equals("go_weatherex_widget_time_bg")) && (!str1.equals("go_weatherex_widget_time_divider")) && (!str1.equals("go_weatherex_widget_time_am")) && (!str1.equals("go_weatherex_widget_time_pm")) && (!str1.equals("go_weatherex_widget_time_ampm_empty")) && (!str1.equals("go_weatherex_widget_time_bg")) && (!str1.equals("go_weatherex_widget_change_city")) && (!str1.equals("go_weatherex_widget_bg")) && (!str1.equals("go_weatherex_widget_bg_day")) && (!str1.equals("go_weatherex_widget_extreme_icon")) && (!str1.equals("go_weatherex_widget_bg_night")) && (!str1.equals("go_weatherex_widget_next_page")) && (!str1.equals("go_weatherex_widget_previous_page")))) && (!str1.equals("go_weatherex_widget_date_style_color"))) {
            break label394;
          }
          str2 = paramXmlPullParser.getAttributeValue(null, "src");
          if (str2 == null) {
            continue;
          }
          paramar.a(str1, str2);
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          localNumberFormatException2.printStackTrace();
          break label929;
        }
        paramXmlPullParser = paramXmlPullParser;
        paramXmlPullParser.printStackTrace();
        return;
      }
      if ((str1.equals("systemwidget")) && (i == 3) && (this.c))
      {
        this.c = false;
        return;
        label394:
        if (str1.startsWith("go_weatherex_widget_time_num"))
        {
          a(paramXmlPullParser, ar.c(), a(str1));
        }
        else if (str1.startsWith("go_weatherex_widget_time_min_num"))
        {
          a(paramXmlPullParser, ar.d(), a(str1));
        }
        else if (str1.startsWith("go_weatherex_widget_temp_num"))
        {
          a(paramXmlPullParser, ar.e(), a(str1));
        }
        else if (str1.equals("go_weatherex_widget_unknow"))
        {
          a(paramXmlPullParser, ar.b(), 0);
        }
        else if (str1.equals("go_weatherex_widget_sun"))
        {
          a(paramXmlPullParser, ar.b(), 1);
        }
        else if (str1.equals("go_weatherex_widget_sun_night"))
        {
          a(paramXmlPullParser, ar.b(), 2);
        }
        else if (str1.equals("go_weatherex_widget_cloud"))
        {
          a(paramXmlPullParser, ar.b(), 3);
        }
        else if (str1.equals("go_weatherex_widget_cloud_night"))
        {
          a(paramXmlPullParser, ar.b(), 4);
        }
        else if (str1.equals("go_weatherex_widget_dark_cloud"))
        {
          a(paramXmlPullParser, ar.b(), 5);
        }
        else if (str1.equals("go_weatherex_widget_snow"))
        {
          a(paramXmlPullParser, ar.b(), 6);
        }
        else if (str1.equals("go_weatherex_widget_fog"))
        {
          a(paramXmlPullParser, ar.b(), 7);
        }
        else if (str1.equals("go_weatherex_widget_rain"))
        {
          a(paramXmlPullParser, ar.b(), 8);
        }
        else if (str1.equals("go_weatherex_widget_thunderstorm"))
        {
          a(paramXmlPullParser, ar.b(), 9);
        }
        else if (str1.equals("go_weatherex_widget_unknow_forecast"))
        {
          a(paramXmlPullParser, ar.a(), 0);
        }
        else if (str1.equals("go_weatherex_widget_sun_forecast"))
        {
          a(paramXmlPullParser, ar.a(), 1);
        }
        else if (str1.equals("go_weatherex_widget_sun_night_forecast"))
        {
          a(paramXmlPullParser, ar.a(), 2);
        }
        else if (str1.equals("go_weatherex_widget_cloud_forecast"))
        {
          a(paramXmlPullParser, ar.a(), 3);
        }
        else if (str1.equals("go_weatherex_widget_cloud_night_forecast"))
        {
          a(paramXmlPullParser, ar.a(), 4);
        }
        else if (str1.equals("go_weatherex_widget_dark_cloud_forecast"))
        {
          a(paramXmlPullParser, ar.a(), 5);
        }
        else if (str1.equals("go_weatherex_widget_snow_forecast"))
        {
          a(paramXmlPullParser, ar.a(), 6);
        }
        else if (str1.equals("go_weatherex_widget_fog_forecast"))
        {
          a(paramXmlPullParser, ar.a(), 7);
        }
        else if (str1.equals("go_weatherex_widget_rain_forecast"))
        {
          a(paramXmlPullParser, ar.a(), 8);
        }
        else if (str1.equals("go_weatherex_widget_thunderstorm_forecast"))
        {
          a(paramXmlPullParser, ar.a(), 9);
          continue;
          label923:
          i = -100;
          continue;
          label929:
          j = -100;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */