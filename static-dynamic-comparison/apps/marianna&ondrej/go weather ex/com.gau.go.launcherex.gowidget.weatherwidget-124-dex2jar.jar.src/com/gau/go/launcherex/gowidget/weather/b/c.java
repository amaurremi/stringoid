package com.gau.go.launcherex.gowidget.weather.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Environment;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.model.ThemeDataBean;
import java.io.File;

class c
  extends AsyncTask
{
  private c(a parama) {}
  
  /* Error */
  private Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 12
    //   9: new 24	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 25	java/util/ArrayList:<init>	()V
    //   16: astore 6
    //   18: aload_0
    //   19: getfield 10	com/gau/go/launcherex/gowidget/weather/b/c:a	Lcom/gau/go/launcherex/gowidget/weather/b/a;
    //   22: aload 6
    //   24: aload_1
    //   25: invokestatic 30	com/gau/go/launcherex/gowidget/weather/b/a:a	(Lcom/gau/go/launcherex/gowidget/weather/b/a;Ljava/util/List;Ljava/lang/String;)V
    //   28: new 32	org/apache/http/client/methods/HttpPost
    //   31: dup
    //   32: ldc 34
    //   34: invokespecial 37	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   37: astore 5
    //   39: aload 5
    //   41: new 39	org/apache/http/client/entity/UrlEncodedFormEntity
    //   44: dup
    //   45: aload 6
    //   47: ldc 41
    //   49: invokespecial 44	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   52: invokevirtual 50	org/apache/http/client/methods/HttpEntityEnclosingRequestBase:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   55: new 52	org/apache/http/impl/client/DefaultHttpClient
    //   58: dup
    //   59: invokespecial 53	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   62: astore 7
    //   64: aload 7
    //   66: aload 5
    //   68: invokevirtual 57	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   71: astore 6
    //   73: aload 6
    //   75: invokeinterface 63 1 0
    //   80: invokeinterface 69 1 0
    //   85: sipush 200
    //   88: if_icmpne +698 -> 786
    //   91: new 71	java/io/DataInputStream
    //   94: dup
    //   95: aload 6
    //   97: invokeinterface 75 1 0
    //   102: invokeinterface 81 1 0
    //   107: invokespecial 84	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   110: astore 5
    //   112: aload 5
    //   114: invokevirtual 87	java/io/DataInputStream:readInt	()I
    //   117: pop
    //   118: aload 5
    //   120: invokevirtual 87	java/io/DataInputStream:readInt	()I
    //   123: pop
    //   124: aload 5
    //   126: invokevirtual 87	java/io/DataInputStream:readInt	()I
    //   129: istore_2
    //   130: iload_2
    //   131: ifne +74 -> 205
    //   134: aload 5
    //   136: ifnull +8 -> 144
    //   139: aload 5
    //   141: invokevirtual 90	java/io/DataInputStream:close	()V
    //   144: iconst_0
    //   145: ifeq +11 -> 156
    //   148: new 92	java/lang/NullPointerException
    //   151: dup
    //   152: invokespecial 93	java/lang/NullPointerException:<init>	()V
    //   155: athrow
    //   156: aload 6
    //   158: ifnull +15 -> 173
    //   161: aload 6
    //   163: invokeinterface 75 1 0
    //   168: invokeinterface 96 1 0
    //   173: aload 13
    //   175: astore 4
    //   177: aload 7
    //   179: ifnull +23 -> 202
    //   182: aload 7
    //   184: invokevirtual 100	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   187: astore 4
    //   189: aload 12
    //   191: astore_1
    //   192: aload 4
    //   194: invokeinterface 105 1 0
    //   199: aload_1
    //   200: astore 4
    //   202: aload 4
    //   204: areturn
    //   205: aload 5
    //   207: invokevirtual 109	java/io/DataInputStream:readLong	()J
    //   210: pop2
    //   211: aload 5
    //   213: invokevirtual 87	java/io/DataInputStream:readInt	()I
    //   216: istore_2
    //   217: iload_2
    //   218: ifle +555 -> 773
    //   221: aload 5
    //   223: invokevirtual 113	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   226: aload_1
    //   227: invokevirtual 119	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: ifeq +263 -> 493
    //   233: aload 5
    //   235: invokevirtual 87	java/io/DataInputStream:readInt	()I
    //   238: istore_3
    //   239: new 121	java/io/ByteArrayOutputStream
    //   242: dup
    //   243: invokespecial 122	java/io/ByteArrayOutputStream:<init>	()V
    //   246: astore_1
    //   247: aload 6
    //   249: astore 11
    //   251: aload 7
    //   253: astore 10
    //   255: aload_1
    //   256: astore 9
    //   258: aload 5
    //   260: astore 8
    //   262: sipush 1024
    //   265: newarray <illegal type>
    //   267: astore 4
    //   269: aload 6
    //   271: astore 11
    //   273: aload 7
    //   275: astore 10
    //   277: aload_1
    //   278: astore 9
    //   280: aload 5
    //   282: astore 8
    //   284: aload 5
    //   286: aload 4
    //   288: invokevirtual 126	java/io/DataInputStream:read	([B)I
    //   291: istore_2
    //   292: iload_2
    //   293: iconst_m1
    //   294: if_icmpeq +108 -> 402
    //   297: aload 6
    //   299: astore 11
    //   301: aload 7
    //   303: astore 10
    //   305: aload_1
    //   306: astore 9
    //   308: aload 5
    //   310: astore 8
    //   312: aload_1
    //   313: aload 4
    //   315: iconst_0
    //   316: iload_2
    //   317: invokevirtual 130	java/io/ByteArrayOutputStream:write	([BII)V
    //   320: goto -51 -> 269
    //   323: astore 4
    //   325: aload 6
    //   327: astore 11
    //   329: aload 7
    //   331: astore 10
    //   333: aload_1
    //   334: astore 9
    //   336: aload 5
    //   338: astore 8
    //   340: aload 4
    //   342: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   345: aload 5
    //   347: ifnull +8 -> 355
    //   350: aload 5
    //   352: invokevirtual 90	java/io/DataInputStream:close	()V
    //   355: aload_1
    //   356: ifnull +7 -> 363
    //   359: aload_1
    //   360: invokevirtual 134	java/io/ByteArrayOutputStream:close	()V
    //   363: aload 6
    //   365: ifnull +15 -> 380
    //   368: aload 6
    //   370: invokeinterface 75 1 0
    //   375: invokeinterface 96 1 0
    //   380: aload 13
    //   382: astore 4
    //   384: aload 7
    //   386: ifnull -184 -> 202
    //   389: aload 7
    //   391: invokevirtual 100	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   394: astore 4
    //   396: aload 12
    //   398: astore_1
    //   399: goto -207 -> 192
    //   402: aload 6
    //   404: astore 11
    //   406: aload 7
    //   408: astore 10
    //   410: aload_1
    //   411: astore 9
    //   413: aload 5
    //   415: astore 8
    //   417: aload_1
    //   418: invokevirtual 138	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   421: iconst_0
    //   422: iload_3
    //   423: invokestatic 144	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   426: astore 4
    //   428: aload 4
    //   430: astore 8
    //   432: aload_1
    //   433: astore 4
    //   435: aload 8
    //   437: astore_1
    //   438: aload 5
    //   440: ifnull +8 -> 448
    //   443: aload 5
    //   445: invokevirtual 90	java/io/DataInputStream:close	()V
    //   448: aload 4
    //   450: ifnull +8 -> 458
    //   453: aload 4
    //   455: invokevirtual 134	java/io/ByteArrayOutputStream:close	()V
    //   458: aload 6
    //   460: ifnull +15 -> 475
    //   463: aload 6
    //   465: invokeinterface 75 1 0
    //   470: invokeinterface 96 1 0
    //   475: aload_1
    //   476: astore 4
    //   478: aload 7
    //   480: ifnull -278 -> 202
    //   483: aload 7
    //   485: invokevirtual 100	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   488: astore 4
    //   490: goto -298 -> 192
    //   493: iload_2
    //   494: iconst_1
    //   495: isub
    //   496: istore_2
    //   497: goto -280 -> 217
    //   500: astore 4
    //   502: aload 4
    //   504: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   507: aload 7
    //   509: ifnull +13 -> 522
    //   512: aload 7
    //   514: invokevirtual 100	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   517: invokeinterface 105 1 0
    //   522: aload_1
    //   523: athrow
    //   524: astore_1
    //   525: aconst_null
    //   526: astore 6
    //   528: aconst_null
    //   529: astore 7
    //   531: aconst_null
    //   532: astore 4
    //   534: aconst_null
    //   535: astore 5
    //   537: aload 5
    //   539: ifnull +8 -> 547
    //   542: aload 5
    //   544: invokevirtual 90	java/io/DataInputStream:close	()V
    //   547: aload 4
    //   549: ifnull +8 -> 557
    //   552: aload 4
    //   554: invokevirtual 134	java/io/ByteArrayOutputStream:close	()V
    //   557: aload 6
    //   559: ifnull -52 -> 507
    //   562: aload 6
    //   564: invokeinterface 75 1 0
    //   569: invokeinterface 96 1 0
    //   574: goto -67 -> 507
    //   577: astore 5
    //   579: aload 5
    //   581: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   584: goto -37 -> 547
    //   587: astore 4
    //   589: aload 4
    //   591: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   594: goto -37 -> 557
    //   597: astore 4
    //   599: aload 4
    //   601: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   604: goto -249 -> 355
    //   607: astore_1
    //   608: aload_1
    //   609: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   612: goto -249 -> 363
    //   615: astore_1
    //   616: aload_1
    //   617: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   620: goto -240 -> 380
    //   623: astore_1
    //   624: aload_1
    //   625: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   628: goto -484 -> 144
    //   631: astore_1
    //   632: aload_1
    //   633: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   636: goto -480 -> 156
    //   639: astore_1
    //   640: aload_1
    //   641: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   644: goto -471 -> 173
    //   647: astore 5
    //   649: aload 5
    //   651: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   654: goto -206 -> 448
    //   657: astore 4
    //   659: aload 4
    //   661: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   664: goto -206 -> 458
    //   667: astore 4
    //   669: aload 4
    //   671: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   674: goto -199 -> 475
    //   677: astore_1
    //   678: aconst_null
    //   679: astore 6
    //   681: aconst_null
    //   682: astore 4
    //   684: aconst_null
    //   685: astore 5
    //   687: goto -150 -> 537
    //   690: astore_1
    //   691: aconst_null
    //   692: astore 4
    //   694: aconst_null
    //   695: astore 5
    //   697: goto -160 -> 537
    //   700: astore_1
    //   701: aconst_null
    //   702: astore 4
    //   704: goto -167 -> 537
    //   707: astore_1
    //   708: aload 11
    //   710: astore 6
    //   712: aload 10
    //   714: astore 7
    //   716: aload 9
    //   718: astore 4
    //   720: aload 8
    //   722: astore 5
    //   724: goto -187 -> 537
    //   727: astore 4
    //   729: aconst_null
    //   730: astore 6
    //   732: aconst_null
    //   733: astore 7
    //   735: aconst_null
    //   736: astore_1
    //   737: aconst_null
    //   738: astore 5
    //   740: goto -415 -> 325
    //   743: astore 4
    //   745: aconst_null
    //   746: astore 6
    //   748: aconst_null
    //   749: astore_1
    //   750: aconst_null
    //   751: astore 5
    //   753: goto -428 -> 325
    //   756: astore 4
    //   758: aconst_null
    //   759: astore_1
    //   760: aconst_null
    //   761: astore 5
    //   763: goto -438 -> 325
    //   766: astore 4
    //   768: aconst_null
    //   769: astore_1
    //   770: goto -445 -> 325
    //   773: aconst_null
    //   774: astore 8
    //   776: aload 4
    //   778: astore_1
    //   779: aload 8
    //   781: astore 4
    //   783: goto -345 -> 438
    //   786: aconst_null
    //   787: astore 8
    //   789: aconst_null
    //   790: astore 5
    //   792: aload 4
    //   794: astore_1
    //   795: aload 8
    //   797: astore 4
    //   799: goto -361 -> 438
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	802	0	this	c
    //   0	802	1	paramString	String
    //   129	368	2	i	int
    //   238	185	3	j	int
    //   4	310	4	localObject1	Object
    //   323	18	4	localException1	Exception
    //   382	107	4	localObject2	Object
    //   500	3	4	localIOException1	java.io.IOException
    //   532	21	4	localObject3	Object
    //   587	3	4	localIOException2	java.io.IOException
    //   597	3	4	localIOException3	java.io.IOException
    //   657	3	4	localIOException4	java.io.IOException
    //   667	3	4	localIOException5	java.io.IOException
    //   682	37	4	localObject4	Object
    //   727	1	4	localException2	Exception
    //   743	1	4	localException3	Exception
    //   756	1	4	localException4	Exception
    //   766	11	4	localException5	Exception
    //   781	17	4	localObject5	Object
    //   37	506	5	localObject6	Object
    //   577	3	5	localIOException6	java.io.IOException
    //   647	3	5	localIOException7	java.io.IOException
    //   685	106	5	localObject7	Object
    //   16	731	6	localObject8	Object
    //   62	672	7	localObject9	Object
    //   260	536	8	localObject10	Object
    //   256	461	9	str	String
    //   253	460	10	localObject11	Object
    //   249	460	11	localObject12	Object
    //   7	390	12	localObject13	Object
    //   1	380	13	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   262	269	323	java/lang/Exception
    //   284	292	323	java/lang/Exception
    //   312	320	323	java/lang/Exception
    //   417	428	323	java/lang/Exception
    //   562	574	500	java/io/IOException
    //   28	64	524	finally
    //   542	547	577	java/io/IOException
    //   552	557	587	java/io/IOException
    //   350	355	597	java/io/IOException
    //   359	363	607	java/io/IOException
    //   368	380	615	java/io/IOException
    //   139	144	623	java/io/IOException
    //   148	156	631	java/io/IOException
    //   161	173	639	java/io/IOException
    //   443	448	647	java/io/IOException
    //   453	458	657	java/io/IOException
    //   463	475	667	java/io/IOException
    //   64	73	677	finally
    //   73	112	690	finally
    //   112	130	700	finally
    //   205	217	700	finally
    //   221	247	700	finally
    //   262	269	707	finally
    //   284	292	707	finally
    //   312	320	707	finally
    //   340	345	707	finally
    //   417	428	707	finally
    //   28	64	727	java/lang/Exception
    //   64	73	743	java/lang/Exception
    //   73	112	756	java/lang/Exception
    //   112	130	766	java/lang/Exception
    //   205	217	766	java/lang/Exception
    //   221	247	766	java/lang/Exception
  }
  
  protected Void a(ThemeDataBean... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      ThemeDataBean localThemeDataBean = paramVarArgs[i];
      if (localThemeDataBean == null) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localThemeDataBean.e() != null) && (!localThemeDataBean.e().equals("")))
        {
          Bitmap localBitmap = a(localThemeDataBean.e());
          if (localBitmap != null)
          {
            if (y.a())
            {
              Object localObject = new File(Environment.getExternalStorageDirectory(), "/GOWeatherEX/download/themeimg");
              if (!((File)localObject).exists()) {
                ((File)localObject).mkdirs();
              }
              localObject = com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(localBitmap, localThemeDataBean.e() + ".png", ((File)localObject).getPath());
              if (localObject != null)
              {
                localThemeDataBean.o((String)localObject);
                publishProgress(new ThemeDataBean[] { localThemeDataBean });
              }
            }
            localBitmap.recycle();
          }
        }
      }
    }
    return null;
  }
  
  protected void b(ThemeDataBean... paramVarArgs)
  {
    if (a.k(this.a))
    {
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APP_DOWNLOAD_PREVIEW_DONE");
      localIntent.putExtra("com.gau.go.launcherex.gowidget.weatherwidget.EXTRA_APP_DOWNLOAD_PREVIEW_DONE", paramVarArgs[0]);
      a.e(this.a).sendBroadcast(localIntent);
    }
    a.a(this.a, paramVarArgs[0]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */