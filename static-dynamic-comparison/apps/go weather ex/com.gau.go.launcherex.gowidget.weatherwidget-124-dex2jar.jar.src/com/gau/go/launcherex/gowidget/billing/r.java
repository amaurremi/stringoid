package com.gau.go.launcherex.gowidget.billing;

import android.app.Activity;
import android.content.Context;
import com.gau.go.launcherex.gowidget.googleplay.IabHelper;
import com.gau.go.launcherex.gowidget.googleplay.IabHelper.OnIabSetupFinishedListener;
import com.gau.go.launcherex.gowidget.googleplay.IabHelper.QueryInventoryFinishedListener;
import com.gau.go.launcherex.gowidget.googleplay.IabResult;
import com.gau.go.launcherex.gowidget.googleplay.Inventory;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.globalview.b;
import java.util.ArrayList;
import java.util.Iterator;

public class r
  implements IabHelper.OnIabSetupFinishedListener, IabHelper.QueryInventoryFinishedListener
{
  private t a;
  private IabHelper b;
  private ArrayList c;
  private Context d;
  private boolean e;
  
  public r(Context paramContext)
  {
    this.d = paramContext;
    this.c = new ArrayList();
    this.c.add("com.gau.go.launcherex.gowidget.weatherwidge.billingpay1");
    this.c.add("go_weather_ex_premium_pack_promotions");
    this.c.add("go_weather_ex_premium_pack_vip");
    this.c.add("go_weather_ex_premium_pack_vip_promo");
    this.c.add("go_weather_ex_premium_pack_theme_vip");
    this.c.add("go_weather_ex_premium_pack_theme_vip_promo");
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    b localb = new b(paramActivity);
    localb.b(paramString);
    localb.b(2131166041);
    localb.d(2131166042);
    localb.a(new s(paramActivity));
    localb.b();
  }
  
  private void a(ArrayList paramArrayList)
  {
    this.e = false;
    if (this.a != null) {
      this.a.a(paramArrayList);
    }
  }
  
  /* Error */
  public static boolean a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: invokevirtual 91	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   9: invokestatic 96	com/gau/go/launcherex/gowidget/framework/GoWidgetApplication:b	(Landroid/content/Context;)Lcom/gau/go/launcherex/gowidget/weather/d/f;
    //   12: ldc 98
    //   14: invokevirtual 103	com/gau/go/launcherex/gowidget/weather/d/f:a	(Ljava/lang/String;)Lcom/gau/go/launcherex/gowidget/weather/d/g;
    //   17: astore 7
    //   19: aload 7
    //   21: invokevirtual 108	com/gau/go/launcherex/gowidget/weather/d/g:a	()Z
    //   24: ifeq +7 -> 31
    //   27: iconst_1
    //   28: istore_3
    //   29: iload_3
    //   30: ireturn
    //   31: aload_0
    //   32: ldc 110
    //   34: invokevirtual 114	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   37: astore_0
    //   38: aload_0
    //   39: astore 5
    //   41: aload 5
    //   43: astore_0
    //   44: new 116	java/io/ByteArrayOutputStream
    //   47: dup
    //   48: invokespecial 117	java/io/ByteArrayOutputStream:<init>	()V
    //   51: astore 6
    //   53: aload 5
    //   55: astore_0
    //   56: sipush 1024
    //   59: newarray <illegal type>
    //   61: astore 8
    //   63: aload 5
    //   65: astore_0
    //   66: aload 5
    //   68: aload 8
    //   70: invokevirtual 123	java/io/FileInputStream:read	([B)I
    //   73: istore_1
    //   74: iload_1
    //   75: iconst_m1
    //   76: if_icmpeq +194 -> 270
    //   79: aload 5
    //   81: astore_0
    //   82: aload 6
    //   84: aload 8
    //   86: iconst_0
    //   87: iload_1
    //   88: invokevirtual 127	java/io/ByteArrayOutputStream:write	([BII)V
    //   91: goto -28 -> 63
    //   94: astore 6
    //   96: aload 5
    //   98: astore_0
    //   99: aload 6
    //   101: invokevirtual 130	java/io/FileNotFoundException:printStackTrace	()V
    //   104: aload 5
    //   106: astore_0
    //   107: iload_3
    //   108: istore_2
    //   109: aload 5
    //   111: ifnull +13 -> 124
    //   114: aload 5
    //   116: invokevirtual 133	java/io/FileInputStream:close	()V
    //   119: iload_3
    //   120: istore_2
    //   121: aload 5
    //   123: astore_0
    //   124: invokestatic 136	com/gau/go/launcherex/gowidget/statistics/y:a	()Z
    //   127: ifeq +578 -> 705
    //   130: iload_2
    //   131: ifne +574 -> 705
    //   134: new 138	java/io/File
    //   137: dup
    //   138: invokestatic 144	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   141: ldc -110
    //   143: invokespecial 149	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   146: astore 5
    //   148: iload_2
    //   149: istore_3
    //   150: aload 5
    //   152: invokevirtual 152	java/io/File:exists	()Z
    //   155: ifeq -126 -> 29
    //   158: new 119	java/io/FileInputStream
    //   161: dup
    //   162: aload 5
    //   164: invokespecial 155	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   167: astore 5
    //   169: aload 5
    //   171: astore_0
    //   172: iload_2
    //   173: istore_3
    //   174: new 116	java/io/ByteArrayOutputStream
    //   177: dup
    //   178: invokespecial 117	java/io/ByteArrayOutputStream:<init>	()V
    //   181: astore 6
    //   183: aload 5
    //   185: astore_0
    //   186: iload_2
    //   187: istore_3
    //   188: sipush 1024
    //   191: newarray <illegal type>
    //   193: astore 8
    //   195: aload 5
    //   197: astore_0
    //   198: iload_2
    //   199: istore_3
    //   200: aload 5
    //   202: aload 8
    //   204: invokevirtual 123	java/io/FileInputStream:read	([B)I
    //   207: istore_1
    //   208: iload_1
    //   209: iconst_m1
    //   210: if_icmpeq +215 -> 425
    //   213: aload 5
    //   215: astore_0
    //   216: iload_2
    //   217: istore_3
    //   218: aload 6
    //   220: aload 8
    //   222: iconst_0
    //   223: iload_1
    //   224: invokevirtual 127	java/io/ByteArrayOutputStream:write	([BII)V
    //   227: goto -32 -> 195
    //   230: astore 6
    //   232: aload 5
    //   234: astore_0
    //   235: aload 6
    //   237: astore 5
    //   239: aload 5
    //   241: invokevirtual 130	java/io/FileNotFoundException:printStackTrace	()V
    //   244: aload_0
    //   245: ifnull +7 -> 252
    //   248: aload_0
    //   249: invokevirtual 133	java/io/FileInputStream:close	()V
    //   252: iload_2
    //   253: istore_3
    //   254: iload_2
    //   255: ifeq -226 -> 29
    //   258: aload 7
    //   260: iconst_1
    //   261: invokevirtual 158	com/gau/go/launcherex/gowidget/weather/d/g:a	(Z)Z
    //   264: pop
    //   265: iload_2
    //   266: istore_3
    //   267: goto -238 -> 29
    //   270: aload 5
    //   272: astore_0
    //   273: aload 6
    //   275: ldc -96
    //   277: invokevirtual 164	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   280: astore 6
    //   282: aload 5
    //   284: astore_0
    //   285: getstatic 169	com/gau/go/launcherex/gowidget/a/a:a	Ljava/lang/String;
    //   288: ldc -96
    //   290: invokevirtual 175	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   293: invokestatic 180	com/gau/go/launcherex/gowidget/weather/d/d:a	([B)Ljava/lang/String;
    //   296: aload 6
    //   298: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   301: istore_2
    //   302: iload_2
    //   303: istore_3
    //   304: aload 5
    //   306: astore_0
    //   307: iload_3
    //   308: istore_2
    //   309: aload 5
    //   311: ifnull -187 -> 124
    //   314: aload 5
    //   316: invokevirtual 133	java/io/FileInputStream:close	()V
    //   319: aload 5
    //   321: astore_0
    //   322: iload_3
    //   323: istore_2
    //   324: goto -200 -> 124
    //   327: astore_0
    //   328: aload_0
    //   329: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   332: aload 5
    //   334: astore_0
    //   335: iload_3
    //   336: istore_2
    //   337: goto -213 -> 124
    //   340: astore_0
    //   341: aload_0
    //   342: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   345: aload 5
    //   347: astore_0
    //   348: iload_3
    //   349: istore_2
    //   350: goto -226 -> 124
    //   353: astore 6
    //   355: aconst_null
    //   356: astore 5
    //   358: aload 5
    //   360: astore_0
    //   361: aload 6
    //   363: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   366: aload 5
    //   368: astore_0
    //   369: iload_3
    //   370: istore_2
    //   371: aload 5
    //   373: ifnull -249 -> 124
    //   376: aload 5
    //   378: invokevirtual 133	java/io/FileInputStream:close	()V
    //   381: aload 5
    //   383: astore_0
    //   384: iload_3
    //   385: istore_2
    //   386: goto -262 -> 124
    //   389: astore_0
    //   390: aload_0
    //   391: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   394: aload 5
    //   396: astore_0
    //   397: iload_3
    //   398: istore_2
    //   399: goto -275 -> 124
    //   402: astore_0
    //   403: aload 5
    //   405: ifnull +8 -> 413
    //   408: aload 5
    //   410: invokevirtual 133	java/io/FileInputStream:close	()V
    //   413: aload_0
    //   414: athrow
    //   415: astore 5
    //   417: aload 5
    //   419: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   422: goto -9 -> 413
    //   425: aload 5
    //   427: astore_0
    //   428: iload_2
    //   429: istore_3
    //   430: aload 6
    //   432: ldc -96
    //   434: invokevirtual 164	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   437: astore 6
    //   439: aload 5
    //   441: astore_0
    //   442: iload_2
    //   443: istore_3
    //   444: getstatic 169	com/gau/go/launcherex/gowidget/a/a:a	Ljava/lang/String;
    //   447: ldc -96
    //   449: invokevirtual 175	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   452: invokestatic 180	com/gau/go/launcherex/gowidget/weather/d/d:a	([B)Ljava/lang/String;
    //   455: astore 8
    //   457: aload 5
    //   459: astore_0
    //   460: iload_2
    //   461: istore_3
    //   462: ldc -70
    //   464: new 188	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   471: ldc -65
    //   473: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload 6
    //   478: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 203	com/gtp/a/a/b/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: aload 5
    //   489: astore_0
    //   490: iload_2
    //   491: istore_3
    //   492: ldc -70
    //   494: new 188	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   501: ldc -51
    //   503: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: aload 8
    //   508: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 203	com/gtp/a/a/b/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   517: aload 5
    //   519: astore_0
    //   520: iload_2
    //   521: istore_3
    //   522: aload 8
    //   524: aload 6
    //   526: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   529: istore 4
    //   531: iload 4
    //   533: istore_2
    //   534: aload 5
    //   536: astore_0
    //   537: iload_2
    //   538: istore_3
    //   539: ldc -70
    //   541: new 188	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   548: ldc -49
    //   550: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: iload_2
    //   554: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   557: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 203	com/gtp/a/a/b/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   563: aload 5
    //   565: ifnull +8 -> 573
    //   568: aload 5
    //   570: invokevirtual 133	java/io/FileInputStream:close	()V
    //   573: goto -321 -> 252
    //   576: astore_0
    //   577: aload_0
    //   578: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   581: goto -329 -> 252
    //   584: astore_0
    //   585: aload_0
    //   586: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   589: goto -337 -> 252
    //   592: astore 6
    //   594: aload_0
    //   595: astore 5
    //   597: aload 5
    //   599: astore_0
    //   600: aload 6
    //   602: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   605: aload 5
    //   607: ifnull +8 -> 615
    //   610: aload 5
    //   612: invokevirtual 133	java/io/FileInputStream:close	()V
    //   615: goto -363 -> 252
    //   618: astore_0
    //   619: aload_0
    //   620: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   623: goto -371 -> 252
    //   626: astore 5
    //   628: aload_0
    //   629: ifnull +7 -> 636
    //   632: aload_0
    //   633: invokevirtual 133	java/io/FileInputStream:close	()V
    //   636: aload 5
    //   638: athrow
    //   639: astore_0
    //   640: aload_0
    //   641: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   644: goto -8 -> 636
    //   647: astore 5
    //   649: goto -21 -> 628
    //   652: astore 5
    //   654: goto -26 -> 628
    //   657: astore 6
    //   659: iload_3
    //   660: istore_2
    //   661: goto -64 -> 597
    //   664: astore 5
    //   666: goto -427 -> 239
    //   669: astore 6
    //   671: aload 5
    //   673: astore_0
    //   674: aload 6
    //   676: astore 5
    //   678: goto -439 -> 239
    //   681: astore 6
    //   683: aload_0
    //   684: astore 5
    //   686: aload 6
    //   688: astore_0
    //   689: goto -286 -> 403
    //   692: astore 6
    //   694: goto -336 -> 358
    //   697: astore 6
    //   699: aconst_null
    //   700: astore 5
    //   702: goto -606 -> 96
    //   705: goto -453 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	708	0	paramContext	Context
    //   73	151	1	i	int
    //   108	553	2	bool1	boolean
    //   1	659	3	bool2	boolean
    //   529	3	4	bool3	boolean
    //   3	406	5	localObject1	Object
    //   415	154	5	localIOException1	java.io.IOException
    //   595	16	5	localContext	Context
    //   626	11	5	localObject2	Object
    //   647	1	5	localObject3	Object
    //   652	1	5	localObject4	Object
    //   664	8	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   676	25	5	localObject5	Object
    //   51	32	6	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   94	6	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   181	38	6	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   230	44	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   280	17	6	str1	String
    //   353	78	6	localIOException2	java.io.IOException
    //   437	88	6	str2	String
    //   592	9	6	localIOException3	java.io.IOException
    //   657	1	6	localIOException4	java.io.IOException
    //   669	6	6	localFileNotFoundException4	java.io.FileNotFoundException
    //   681	6	6	localObject6	Object
    //   692	1	6	localIOException5	java.io.IOException
    //   697	1	6	localFileNotFoundException5	java.io.FileNotFoundException
    //   17	242	7	localg	com.gau.go.launcherex.gowidget.weather.d.g
    //   61	462	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   44	53	94	java/io/FileNotFoundException
    //   56	63	94	java/io/FileNotFoundException
    //   66	74	94	java/io/FileNotFoundException
    //   82	91	94	java/io/FileNotFoundException
    //   273	282	94	java/io/FileNotFoundException
    //   285	302	94	java/io/FileNotFoundException
    //   174	183	230	java/io/FileNotFoundException
    //   188	195	230	java/io/FileNotFoundException
    //   200	208	230	java/io/FileNotFoundException
    //   218	227	230	java/io/FileNotFoundException
    //   430	439	230	java/io/FileNotFoundException
    //   444	457	230	java/io/FileNotFoundException
    //   462	487	230	java/io/FileNotFoundException
    //   492	517	230	java/io/FileNotFoundException
    //   522	531	230	java/io/FileNotFoundException
    //   314	319	327	java/io/IOException
    //   114	119	340	java/io/IOException
    //   31	38	353	java/io/IOException
    //   376	381	389	java/io/IOException
    //   31	38	402	finally
    //   408	413	415	java/io/IOException
    //   568	573	576	java/io/IOException
    //   248	252	584	java/io/IOException
    //   158	169	592	java/io/IOException
    //   610	615	618	java/io/IOException
    //   158	169	626	finally
    //   632	636	639	java/io/IOException
    //   174	183	647	finally
    //   188	195	647	finally
    //   200	208	647	finally
    //   218	227	647	finally
    //   430	439	647	finally
    //   444	457	647	finally
    //   462	487	647	finally
    //   492	517	647	finally
    //   522	531	647	finally
    //   539	563	647	finally
    //   600	605	647	finally
    //   239	244	652	finally
    //   174	183	657	java/io/IOException
    //   188	195	657	java/io/IOException
    //   200	208	657	java/io/IOException
    //   218	227	657	java/io/IOException
    //   430	439	657	java/io/IOException
    //   444	457	657	java/io/IOException
    //   462	487	657	java/io/IOException
    //   492	517	657	java/io/IOException
    //   522	531	657	java/io/IOException
    //   539	563	657	java/io/IOException
    //   158	169	664	java/io/FileNotFoundException
    //   539	563	669	java/io/FileNotFoundException
    //   44	53	681	finally
    //   56	63	681	finally
    //   66	74	681	finally
    //   82	91	681	finally
    //   99	104	681	finally
    //   273	282	681	finally
    //   285	302	681	finally
    //   361	366	681	finally
    //   44	53	692	java/io/IOException
    //   56	63	692	java/io/IOException
    //   66	74	692	java/io/IOException
    //   82	91	692	java/io/IOException
    //   273	282	692	java/io/IOException
    //   285	302	692	java/io/IOException
    //   31	38	697	java/io/FileNotFoundException
  }
  
  private void c()
  {
    this.e = false;
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public IabHelper a()
  {
    return this.b;
  }
  
  public void a(t paramt)
  {
    if (!this.e)
    {
      this.e = true;
      this.a = paramt;
      if (!y.s(this.d)) {
        c();
      }
    }
    else
    {
      return;
    }
    if (this.b != null) {}
    try
    {
      this.b.dispose();
      this.b = new IabHelper(this.d, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjMLLCo3hpiezV/bPOi83lz3DktmKGQpvsxjE10fF1h+L62vnazigqi+P6m4NFO+jOFT5RX0VPM9SzM6vCGOo9Xjjuk219queZr9SQUKoytfMTsgrtcI1YGDy9maP1owggij0hxWfaBsP4375zP+R89Pzz0R9Ap2tmLLlfIzRZPwqPcnONlQ/8ZqfdxWwCiOOOLHQJ4k1aN6jUPx8ipKWFxo7ORI0TmqgiJvhsFJuBr6QCqoN2BF6QgOfz6fMac1e+EaeJD3/pzUsuzzvvEnh70aoq+6mqZyZmyJb4840OddTGUHX8z3Qeoa/Dti+YQiXtSO3T2ANuF9pzkyBIAQQLwIDAQAB");
      this.b.enableDebugLogging(true);
      this.b.startSetup(this);
      return;
    }
    catch (Exception paramt)
    {
      for (;;) {}
    }
  }
  
  public boolean a(String paramString)
  {
    return this.c.contains(paramString);
  }
  
  public void b()
  {
    if (this.b != null) {}
    try
    {
      this.b.dispose();
      this.b = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void onIabSetupFinished(IabResult paramIabResult)
  {
    if (!paramIabResult.isSuccess())
    {
      this.b.logDebug("Problem setting up In-app Billing: " + paramIabResult);
      c();
      return;
    }
    this.b.logDebug("IAB is fully set up!: " + paramIabResult);
    this.b.queryInventoryAsync(true, this.c, this);
  }
  
  public void onQueryInventoryFinished(IabResult paramIabResult, Inventory paramInventory)
  {
    if (paramIabResult.isFailure())
    {
      this.b.logDebug("onQueryInventoryFinished-->result.isFailure：" + paramIabResult);
      c();
      return;
    }
    paramIabResult = new ArrayList();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramInventory.hasPurchase(str)) {
        paramIabResult.add(str);
      }
    }
    a(paramIabResult);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */