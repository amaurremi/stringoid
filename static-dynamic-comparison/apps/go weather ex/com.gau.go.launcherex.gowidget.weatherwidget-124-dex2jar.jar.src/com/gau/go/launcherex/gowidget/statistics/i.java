package com.gau.go.launcherex.gowidget.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gtp.a.a.b.c;
import com.jiubang.core.b.a;
import org.json.JSONObject;

public class i
{
  public static String a(Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer("http://goupdate.3g.cn/GOClientData/DR");
    localStringBuffer.append("?package_name=").append("com.gau.go.launcherex.gowidget.weatherwidget").append("&channel_name=").append(y.f(paramContext)).append("&version_code=").append(y.e(paramContext)).append("&version_name=").append(y.c(paramContext));
    paramContext = localStringBuffer.toString();
    c.a("CYN", paramContext);
    return paramContext;
  }
  
  public static String a(Context paramContext, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean) {
      i = 1;
    }
    StringBuffer localStringBuffer = new StringBuffer("http://goupdate.3g.cn/GOClientData/DR");
    localStringBuffer.append("?is_response_json=").append(i).append("&package_name=").append("com.gau.go.launcherex.gowidget.weatherwidget").append("&channel_name=").append(y.f(paramContext)).append("&version_code=").append(y.e(paramContext)).append("&version_name=").append(y.c(paramContext));
    paramContext = localStringBuffer.toString();
    c.a("CYN", paramContext);
    return paramContext;
  }
  
  /* Error */
  public static boolean a(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: aload_0
    //   7: ifnull +12 -> 19
    //   10: ldc 71
    //   12: aload_0
    //   13: invokevirtual 77	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16: ifeq +5 -> 21
    //   19: iconst_0
    //   20: ireturn
    //   21: new 79	java/net/URL
    //   24: dup
    //   25: aload_1
    //   26: invokestatic 81	com/gau/go/launcherex/gowidget/statistics/i:a	(Landroid/content/Context;)Ljava/lang/String;
    //   29: invokespecial 82	java/net/URL:<init>	(Ljava/lang/String;)V
    //   32: astore 9
    //   34: iload 6
    //   36: istore 4
    //   38: aload 9
    //   40: ifnull +328 -> 368
    //   43: iconst_0
    //   44: istore_2
    //   45: iload 6
    //   47: istore 4
    //   49: iload_2
    //   50: iconst_3
    //   51: if_icmpge +317 -> 368
    //   54: aload 9
    //   56: invokevirtual 86	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   59: checkcast 88	java/net/HttpURLConnection
    //   62: astore 7
    //   64: aload 7
    //   66: iconst_1
    //   67: invokevirtual 92	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   70: aload 7
    //   72: iconst_1
    //   73: invokevirtual 95	java/net/HttpURLConnection:setDoInput	(Z)V
    //   76: aload 7
    //   78: ldc 97
    //   80: invokevirtual 100	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   83: aload 7
    //   85: iconst_0
    //   86: invokevirtual 103	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   89: aload 7
    //   91: iconst_1
    //   92: invokevirtual 106	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   95: aload 7
    //   97: sipush 30000
    //   100: invokevirtual 110	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   103: aload 7
    //   105: sipush 30000
    //   108: invokevirtual 113	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   111: aload 7
    //   113: ldc 115
    //   115: ldc 117
    //   117: invokevirtual 120	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload 7
    //   122: invokevirtual 124	java/net/HttpURLConnection:connect	()V
    //   125: new 126	java/io/DataOutputStream
    //   128: dup
    //   129: aload 7
    //   131: invokevirtual 130	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   134: invokespecial 133	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   137: astore 8
    //   139: aload 8
    //   141: aload_0
    //   142: invokevirtual 136	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   145: aload 8
    //   147: invokevirtual 139	java/io/DataOutputStream:flush	()V
    //   150: aload 8
    //   152: invokevirtual 142	java/io/DataOutputStream:close	()V
    //   155: aload 7
    //   157: invokevirtual 146	java/net/HttpURLConnection:getResponseCode	()I
    //   160: sipush 200
    //   163: if_icmpne +56 -> 219
    //   166: aload 7
    //   168: invokevirtual 150	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   171: astore 8
    //   173: iload 5
    //   175: istore_3
    //   176: aload 8
    //   178: ifnull +13 -> 191
    //   181: aload 8
    //   183: invokestatic 155	com/jiubang/goweather/e/a:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   186: aload_1
    //   187: invokestatic 158	com/gau/go/launcherex/gowidget/statistics/i:b	(Ljava/lang/String;Landroid/content/Context;)Z
    //   190: istore_3
    //   191: iload_3
    //   192: istore 4
    //   194: aload 7
    //   196: ifnull +172 -> 368
    //   199: aload 7
    //   201: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   204: iload_3
    //   205: ireturn
    //   206: astore 7
    //   208: aload 7
    //   210: invokevirtual 164	java/net/MalformedURLException:printStackTrace	()V
    //   213: aconst_null
    //   214: astore 9
    //   216: goto -182 -> 34
    //   219: aload 7
    //   221: ifnull +8 -> 229
    //   224: aload 7
    //   226: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   229: iload_2
    //   230: iconst_1
    //   231: iadd
    //   232: istore_2
    //   233: goto -188 -> 45
    //   236: astore 10
    //   238: aconst_null
    //   239: astore 8
    //   241: aload 8
    //   243: astore 7
    //   245: aload 10
    //   247: invokevirtual 165	org/json/JSONException:printStackTrace	()V
    //   250: aload 8
    //   252: ifnull -23 -> 229
    //   255: aload 8
    //   257: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   260: goto -31 -> 229
    //   263: astore 10
    //   265: aconst_null
    //   266: astore 8
    //   268: aload 8
    //   270: astore 7
    //   272: aload 10
    //   274: invokevirtual 166	java/net/SocketTimeoutException:printStackTrace	()V
    //   277: aload 8
    //   279: ifnull -50 -> 229
    //   282: aload 8
    //   284: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   287: goto -58 -> 229
    //   290: astore 10
    //   292: aconst_null
    //   293: astore 8
    //   295: aload 8
    //   297: astore 7
    //   299: aload 10
    //   301: invokevirtual 167	java/lang/Exception:printStackTrace	()V
    //   304: aload 8
    //   306: ifnull -77 -> 229
    //   309: aload 8
    //   311: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   314: goto -85 -> 229
    //   317: astore_0
    //   318: aconst_null
    //   319: astore 7
    //   321: aload 7
    //   323: ifnull +8 -> 331
    //   326: aload 7
    //   328: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   331: aload_0
    //   332: athrow
    //   333: astore_0
    //   334: goto -13 -> 321
    //   337: astore_0
    //   338: goto -17 -> 321
    //   341: astore 10
    //   343: aload 7
    //   345: astore 8
    //   347: goto -52 -> 295
    //   350: astore 10
    //   352: aload 7
    //   354: astore 8
    //   356: goto -88 -> 268
    //   359: astore 10
    //   361: aload 7
    //   363: astore 8
    //   365: goto -124 -> 241
    //   368: iload 4
    //   370: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	paramString	String
    //   0	371	1	paramContext	Context
    //   44	189	2	i	int
    //   175	30	3	bool1	boolean
    //   36	333	4	bool2	boolean
    //   4	170	5	bool3	boolean
    //   1	45	6	bool4	boolean
    //   62	138	7	localHttpURLConnection	java.net.HttpURLConnection
    //   206	19	7	localMalformedURLException	java.net.MalformedURLException
    //   243	119	7	localObject1	Object
    //   137	227	8	localObject2	Object
    //   32	183	9	localURL	java.net.URL
    //   236	10	10	localJSONException1	org.json.JSONException
    //   263	10	10	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   290	10	10	localException1	Exception
    //   341	1	10	localException2	Exception
    //   350	1	10	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   359	1	10	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   21	34	206	java/net/MalformedURLException
    //   54	64	236	org/json/JSONException
    //   54	64	263	java/net/SocketTimeoutException
    //   54	64	290	java/lang/Exception
    //   54	64	317	finally
    //   64	173	333	finally
    //   181	191	333	finally
    //   245	250	337	finally
    //   272	277	337	finally
    //   299	304	337	finally
    //   64	173	341	java/lang/Exception
    //   181	191	341	java/lang/Exception
    //   64	173	350	java/net/SocketTimeoutException
    //   181	191	350	java/net/SocketTimeoutException
    //   64	173	359	org/json/JSONException
    //   181	191	359	org/json/JSONException
  }
  
  /* Error */
  public static boolean a(String paramString, Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 4
    //   6: iload 4
    //   8: istore 5
    //   10: aload_0
    //   11: ifnull +16 -> 27
    //   14: ldc 71
    //   16: aload_0
    //   17: invokevirtual 77	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: ifeq +10 -> 30
    //   23: iload 4
    //   25: istore 5
    //   27: iload 5
    //   29: ireturn
    //   30: new 79	java/net/URL
    //   33: dup
    //   34: aload_1
    //   35: iload_2
    //   36: invokestatic 170	com/gau/go/launcherex/gowidget/statistics/i:a	(Landroid/content/Context;Z)Ljava/lang/String;
    //   39: invokespecial 82	java/net/URL:<init>	(Ljava/lang/String;)V
    //   42: astore 9
    //   44: iload 4
    //   46: istore 5
    //   48: aload 9
    //   50: ifnull -23 -> 27
    //   53: iconst_0
    //   54: istore_3
    //   55: iload 6
    //   57: istore 4
    //   59: iload 4
    //   61: istore 5
    //   63: iload_3
    //   64: iconst_3
    //   65: if_icmpge -38 -> 27
    //   68: aload 9
    //   70: invokevirtual 86	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   73: checkcast 88	java/net/HttpURLConnection
    //   76: astore_1
    //   77: aload_1
    //   78: iconst_1
    //   79: invokevirtual 92	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   82: aload_1
    //   83: iconst_1
    //   84: invokevirtual 95	java/net/HttpURLConnection:setDoInput	(Z)V
    //   87: aload_1
    //   88: ldc 97
    //   90: invokevirtual 100	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   93: aload_1
    //   94: iconst_0
    //   95: invokevirtual 103	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   98: aload_1
    //   99: iconst_1
    //   100: invokevirtual 106	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   103: aload_1
    //   104: sipush 30000
    //   107: invokevirtual 110	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   110: aload_1
    //   111: sipush 30000
    //   114: invokevirtual 113	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   117: aload_1
    //   118: ldc 115
    //   120: ldc 117
    //   122: invokevirtual 120	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_1
    //   126: invokevirtual 124	java/net/HttpURLConnection:connect	()V
    //   129: new 126	java/io/DataOutputStream
    //   132: dup
    //   133: aload_1
    //   134: invokevirtual 130	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   137: invokespecial 133	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   140: astore 7
    //   142: aload 7
    //   144: aload_0
    //   145: invokevirtual 136	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   148: aload 7
    //   150: invokevirtual 139	java/io/DataOutputStream:flush	()V
    //   153: aload 7
    //   155: invokevirtual 142	java/io/DataOutputStream:close	()V
    //   158: aload_1
    //   159: invokevirtual 146	java/net/HttpURLConnection:getResponseCode	()I
    //   162: sipush 200
    //   165: if_icmpne +99 -> 264
    //   168: aload_1
    //   169: invokevirtual 150	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   172: astore 7
    //   174: iload 4
    //   176: istore 6
    //   178: aload 7
    //   180: ifnull +58 -> 238
    //   183: aload 7
    //   185: invokestatic 155	com/jiubang/goweather/e/a:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   188: astore 7
    //   190: iload 4
    //   192: istore 6
    //   194: iload_2
    //   195: ifeq +43 -> 238
    //   198: new 172	org/json/JSONObject
    //   201: dup
    //   202: aload 7
    //   204: invokespecial 173	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   207: ldc -81
    //   209: invokevirtual 179	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   212: ldc -75
    //   214: invokevirtual 185	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   217: istore 5
    //   219: iload 4
    //   221: istore 6
    //   223: iload 5
    //   225: ifeq +13 -> 238
    //   228: ldc 49
    //   230: ldc -69
    //   232: invokestatic 54	com/gtp/a/a/b/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: iconst_1
    //   236: istore 6
    //   238: iload 6
    //   240: istore 5
    //   242: aload_1
    //   243: ifnull -216 -> 27
    //   246: aload_1
    //   247: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   250: iload 6
    //   252: ireturn
    //   253: astore_1
    //   254: aload_1
    //   255: invokevirtual 164	java/net/MalformedURLException:printStackTrace	()V
    //   258: aconst_null
    //   259: astore 9
    //   261: goto -217 -> 44
    //   264: aload_1
    //   265: ifnull +218 -> 483
    //   268: aload_1
    //   269: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   272: iload_3
    //   273: iconst_1
    //   274: iadd
    //   275: istore_3
    //   276: goto -217 -> 59
    //   279: astore 8
    //   281: aconst_null
    //   282: astore 7
    //   284: iload 4
    //   286: istore 5
    //   288: aload 7
    //   290: astore_1
    //   291: aload 8
    //   293: invokevirtual 165	org/json/JSONException:printStackTrace	()V
    //   296: iload 5
    //   298: istore 4
    //   300: aload 7
    //   302: ifnull -30 -> 272
    //   305: aload 7
    //   307: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   310: iload 5
    //   312: istore 4
    //   314: goto -42 -> 272
    //   317: astore 8
    //   319: aconst_null
    //   320: astore 7
    //   322: iload 4
    //   324: istore 5
    //   326: aload 7
    //   328: astore_1
    //   329: aload 8
    //   331: invokevirtual 166	java/net/SocketTimeoutException:printStackTrace	()V
    //   334: iload 5
    //   336: istore 4
    //   338: aload 7
    //   340: ifnull -68 -> 272
    //   343: aload 7
    //   345: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   348: iload 5
    //   350: istore 4
    //   352: goto -80 -> 272
    //   355: astore 8
    //   357: aconst_null
    //   358: astore 7
    //   360: iload 4
    //   362: istore 5
    //   364: aload 7
    //   366: astore_1
    //   367: aload 8
    //   369: invokevirtual 167	java/lang/Exception:printStackTrace	()V
    //   372: iload 5
    //   374: istore 4
    //   376: aload 7
    //   378: ifnull -106 -> 272
    //   381: aload 7
    //   383: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   386: iload 5
    //   388: istore 4
    //   390: goto -118 -> 272
    //   393: astore_0
    //   394: aconst_null
    //   395: astore_1
    //   396: aload_1
    //   397: ifnull +7 -> 404
    //   400: aload_1
    //   401: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   404: aload_0
    //   405: athrow
    //   406: astore_0
    //   407: goto -11 -> 396
    //   410: astore_0
    //   411: goto -15 -> 396
    //   414: astore 8
    //   416: iload 4
    //   418: istore 5
    //   420: aload_1
    //   421: astore 7
    //   423: goto -59 -> 364
    //   426: astore 8
    //   428: iconst_1
    //   429: istore 5
    //   431: aload_1
    //   432: astore 7
    //   434: goto -70 -> 364
    //   437: astore 8
    //   439: iload 4
    //   441: istore 5
    //   443: aload_1
    //   444: astore 7
    //   446: goto -120 -> 326
    //   449: astore 8
    //   451: iconst_1
    //   452: istore 5
    //   454: aload_1
    //   455: astore 7
    //   457: goto -131 -> 326
    //   460: astore 8
    //   462: iload 4
    //   464: istore 5
    //   466: aload_1
    //   467: astore 7
    //   469: goto -181 -> 288
    //   472: astore 8
    //   474: iconst_1
    //   475: istore 5
    //   477: aload_1
    //   478: astore 7
    //   480: goto -192 -> 288
    //   483: goto -211 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	486	0	paramString	String
    //   0	486	1	paramContext	Context
    //   0	486	2	paramBoolean	boolean
    //   54	222	3	i	int
    //   4	459	4	bool1	boolean
    //   8	468	5	bool2	boolean
    //   1	250	6	bool3	boolean
    //   140	339	7	localObject	Object
    //   279	13	8	localJSONException1	org.json.JSONException
    //   317	13	8	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   355	13	8	localException1	Exception
    //   414	1	8	localException2	Exception
    //   426	1	8	localException3	Exception
    //   437	1	8	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   449	1	8	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   460	1	8	localJSONException2	org.json.JSONException
    //   472	1	8	localJSONException3	org.json.JSONException
    //   42	218	9	localURL	java.net.URL
    // Exception table:
    //   from	to	target	type
    //   30	44	253	java/net/MalformedURLException
    //   68	77	279	org/json/JSONException
    //   68	77	317	java/net/SocketTimeoutException
    //   68	77	355	java/lang/Exception
    //   68	77	393	finally
    //   77	174	406	finally
    //   183	190	406	finally
    //   198	219	406	finally
    //   228	235	406	finally
    //   291	296	410	finally
    //   329	334	410	finally
    //   367	372	410	finally
    //   77	174	414	java/lang/Exception
    //   183	190	414	java/lang/Exception
    //   198	219	414	java/lang/Exception
    //   228	235	426	java/lang/Exception
    //   77	174	437	java/net/SocketTimeoutException
    //   183	190	437	java/net/SocketTimeoutException
    //   198	219	437	java/net/SocketTimeoutException
    //   228	235	449	java/net/SocketTimeoutException
    //   77	174	460	org/json/JSONException
    //   183	190	460	org/json/JSONException
    //   198	219	460	org/json/JSONException
    //   228	235	472	org/json/JSONException
  }
  
  private static boolean b(String paramString, Context paramContext)
  {
    if (paramString != null)
    {
      c.a("CYN", paramString);
      boolean bool2;
      if (paramString.equalsIgnoreCase("OK"))
      {
        c.a("CYN", "统计上传成功(非JSON)");
        bool2 = true;
        return bool2;
      }
      paramString = new JSONObject(paramString);
      if (paramString.getString("upload_status").equalsIgnoreCase("OK")) {
        c.a("CYN", "统计上传成功(JSON)");
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        int i = paramString.getInt("is_display_market");
        bool2 = bool1;
        if (paramContext == null) {
          break;
        }
        paramString = GoWidgetApplication.c(paramContext.getApplicationContext()).a().edit();
        if (i == 1)
        {
          paramString.putInt("key_go_market_enable", 1);
          c.a("CYN", "标识应用中心打开");
        }
        for (;;)
        {
          paramString.commit();
          return bool1;
          if (i == 2)
          {
            paramString.putInt("key_go_market_enable", 0);
            c.a("CYN", "标识应用中心关闭");
          }
        }
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */