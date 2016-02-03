package com.gtp.go.weather.coupon.a;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.Iterator;

class g
  extends AsyncTask
{
  private int b;
  private ArrayList c;
  
  public g(e parame, int paramInt, ArrayList paramArrayList)
  {
    this.b = paramInt;
    this.c = paramArrayList;
  }
  
  /* Error */
  protected ArrayList a(Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/gtp/go/weather/coupon/a/g:a	Lcom/gtp/go/weather/coupon/a/e;
    //   4: invokestatic 32	com/gtp/go/weather/coupon/a/e:a	(Lcom/gtp/go/weather/coupon/a/e;)Landroid/content/Context;
    //   7: aload_0
    //   8: getfield 14	com/gtp/go/weather/coupon/a/g:a	Lcom/gtp/go/weather/coupon/a/e;
    //   11: invokestatic 32	com/gtp/go/weather/coupon/a/e:a	(Lcom/gtp/go/weather/coupon/a/e;)Landroid/content/Context;
    //   14: invokestatic 38	com/gau/go/launcherex/gowidget/statistics/y:n	(Landroid/content/Context;)Ljava/lang/String;
    //   17: invokestatic 43	com/gtp/go/weather/sharephoto/a/f:a	(Landroid/content/Context;Ljava/lang/String;)Lorg/json/JSONObject;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull +17 -> 39
    //   25: aload_1
    //   26: invokevirtual 49	org/json/JSONObject:toString	()Ljava/lang/String;
    //   29: astore_1
    //   30: aload_1
    //   31: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   34: ifeq +11 -> 45
    //   37: aconst_null
    //   38: areturn
    //   39: ldc 57
    //   41: astore_1
    //   42: goto -12 -> 30
    //   45: aload_0
    //   46: getfield 14	com/gtp/go/weather/coupon/a/g:a	Lcom/gtp/go/weather/coupon/a/e;
    //   49: invokestatic 32	com/gtp/go/weather/coupon/a/e:a	(Lcom/gtp/go/weather/coupon/a/e;)Landroid/content/Context;
    //   52: astore 4
    //   54: aload_0
    //   55: getfield 19	com/gtp/go/weather/coupon/a/g:b	I
    //   58: ifne +73 -> 131
    //   61: iconst_1
    //   62: istore_2
    //   63: aload 4
    //   65: ldc 59
    //   67: aload_1
    //   68: iload_2
    //   69: invokestatic 64	com/gtp/go/weather/coupon/c/a:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   72: astore_1
    //   73: aload_1
    //   74: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   77: ifne +500 -> 577
    //   80: new 45	org/json/JSONObject
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 67	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +49 -> 139
    //   93: aload_1
    //   94: ldc 69
    //   96: invokevirtual 73	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   99: astore 4
    //   101: aload 4
    //   103: ifnull +42 -> 145
    //   106: aload 4
    //   108: ldc 75
    //   110: iconst_m1
    //   111: invokevirtual 79	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   114: istore_2
    //   115: aload_1
    //   116: astore 4
    //   118: iload_2
    //   119: iconst_1
    //   120: if_icmpne +51 -> 171
    //   123: iconst_1
    //   124: istore_2
    //   125: iload_2
    //   126: ifne +53 -> 179
    //   129: aconst_null
    //   130: areturn
    //   131: aload_0
    //   132: getfield 19	com/gtp/go/weather/coupon/a/g:b	I
    //   135: istore_2
    //   136: goto -73 -> 63
    //   139: aconst_null
    //   140: astore 4
    //   142: goto -41 -> 101
    //   145: iconst_m1
    //   146: istore_2
    //   147: goto -32 -> 115
    //   150: astore 5
    //   152: aconst_null
    //   153: astore_1
    //   154: aload_1
    //   155: astore 4
    //   157: invokestatic 84	com/gtp/a/a/b/c:a	()Z
    //   160: ifeq +11 -> 171
    //   163: aload 5
    //   165: invokevirtual 87	org/json/JSONException:printStackTrace	()V
    //   168: aload_1
    //   169: astore 4
    //   171: iconst_0
    //   172: istore_2
    //   173: aload 4
    //   175: astore_1
    //   176: goto -51 -> 125
    //   179: new 89	java/util/ArrayList
    //   182: dup
    //   183: invokespecial 90	java/util/ArrayList:<init>	()V
    //   186: astore 4
    //   188: aload_1
    //   189: ifnull +181 -> 370
    //   192: aload_1
    //   193: ldc 92
    //   195: invokevirtual 96	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   198: astore_1
    //   199: aload_1
    //   200: ifnull +175 -> 375
    //   203: aload_1
    //   204: invokevirtual 102	org/json/JSONArray:length	()I
    //   207: istore_2
    //   208: iconst_0
    //   209: istore_3
    //   210: iload_3
    //   211: iload_2
    //   212: if_icmpge +200 -> 412
    //   215: aload_1
    //   216: iload_3
    //   217: invokevirtual 106	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   220: astore 5
    //   222: aload 5
    //   224: ifnull +139 -> 363
    //   227: new 108	com/gtp/go/weather/coupon/b/b
    //   230: dup
    //   231: invokespecial 109	com/gtp/go/weather/coupon/b/b:<init>	()V
    //   234: astore 6
    //   236: aload 6
    //   238: aload 5
    //   240: ldc 111
    //   242: invokevirtual 115	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   245: invokevirtual 118	com/gtp/go/weather/coupon/b/b:a	(J)V
    //   248: aload 6
    //   250: aload 5
    //   252: ldc 120
    //   254: invokevirtual 115	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   257: invokevirtual 122	com/gtp/go/weather/coupon/b/b:b	(J)V
    //   260: aload 6
    //   262: aload 5
    //   264: ldc 124
    //   266: invokevirtual 128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   269: invokevirtual 130	com/gtp/go/weather/coupon/b/b:a	(Ljava/lang/String;)V
    //   272: aload 6
    //   274: aload 5
    //   276: ldc -124
    //   278: invokevirtual 128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   281: invokevirtual 134	com/gtp/go/weather/coupon/b/b:b	(Ljava/lang/String;)V
    //   284: aload 6
    //   286: aload 5
    //   288: ldc -120
    //   290: invokevirtual 140	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   293: invokevirtual 143	com/gtp/go/weather/coupon/b/b:a	(I)V
    //   296: aload 6
    //   298: aload 5
    //   300: ldc -111
    //   302: invokevirtual 148	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   305: invokevirtual 150	com/gtp/go/weather/coupon/b/b:c	(Ljava/lang/String;)V
    //   308: aload 6
    //   310: aload 5
    //   312: ldc -104
    //   314: invokevirtual 148	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   317: invokevirtual 155	com/gtp/go/weather/coupon/b/b:d	(Ljava/lang/String;)V
    //   320: aload 6
    //   322: aload 5
    //   324: ldc -99
    //   326: invokevirtual 128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   329: invokevirtual 160	com/gtp/go/weather/coupon/b/b:e	(Ljava/lang/String;)V
    //   332: aload 6
    //   334: aload 5
    //   336: ldc -94
    //   338: invokevirtual 148	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   341: invokevirtual 165	com/gtp/go/weather/coupon/b/b:g	(Ljava/lang/String;)V
    //   344: aload 6
    //   346: invokevirtual 167	com/gtp/go/weather/coupon/b/b:g	()Ljava/lang/String;
    //   349: invokestatic 170	com/gtp/go/weather/coupon/c/a:c	(Ljava/lang/String;)Z
    //   352: ifne +11 -> 363
    //   355: aload 4
    //   357: aload 6
    //   359: invokevirtual 174	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   362: pop
    //   363: iload_3
    //   364: iconst_1
    //   365: iadd
    //   366: istore_3
    //   367: goto -157 -> 210
    //   370: aconst_null
    //   371: astore_1
    //   372: goto -173 -> 199
    //   375: iconst_0
    //   376: istore_2
    //   377: goto -169 -> 208
    //   380: astore 5
    //   382: invokestatic 84	com/gtp/a/a/b/c:a	()Z
    //   385: ifeq -22 -> 363
    //   388: aload 5
    //   390: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   393: goto -30 -> 363
    //   396: astore 5
    //   398: invokestatic 84	com/gtp/a/a/b/c:a	()Z
    //   401: ifeq -38 -> 363
    //   404: aload 5
    //   406: invokevirtual 87	org/json/JSONException:printStackTrace	()V
    //   409: goto -46 -> 363
    //   412: aload_0
    //   413: getfield 19	com/gtp/go/weather/coupon/a/g:b	I
    //   416: ifne +142 -> 558
    //   419: aload_0
    //   420: getfield 14	com/gtp/go/weather/coupon/a/g:a	Lcom/gtp/go/weather/coupon/a/e;
    //   423: invokestatic 32	com/gtp/go/weather/coupon/a/e:a	(Lcom/gtp/go/weather/coupon/a/e;)Landroid/content/Context;
    //   426: invokevirtual 181	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   429: getstatic 187	com/gau/go/launcherex/gowidget/weather/provider/WeatherContentProvider:B	Landroid/net/Uri;
    //   432: aconst_null
    //   433: aconst_null
    //   434: invokevirtual 193	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   437: pop
    //   438: aload_0
    //   439: getfield 14	com/gtp/go/weather/coupon/a/g:a	Lcom/gtp/go/weather/coupon/a/e;
    //   442: aload 4
    //   444: aconst_null
    //   445: invokestatic 196	com/gtp/go/weather/coupon/a/e:a	(Lcom/gtp/go/weather/coupon/a/e;Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   448: aload 4
    //   450: invokevirtual 198	java/util/ArrayList:isEmpty	()Z
    //   453: ifne +121 -> 574
    //   456: aload_0
    //   457: getfield 14	com/gtp/go/weather/coupon/a/g:a	Lcom/gtp/go/weather/coupon/a/e;
    //   460: invokestatic 32	com/gtp/go/weather/coupon/a/e:a	(Lcom/gtp/go/weather/coupon/a/e;)Landroid/content/Context;
    //   463: iconst_1
    //   464: anewarray 200	java/lang/String
    //   467: dup
    //   468: iconst_0
    //   469: ldc -54
    //   471: aastore
    //   472: aconst_null
    //   473: aconst_null
    //   474: invokestatic 207	com/gtp/go/weather/coupon/a/a:a	(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/ArrayList;
    //   477: astore_1
    //   478: aload 4
    //   480: invokevirtual 211	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   483: astore 5
    //   485: aload 5
    //   487: invokeinterface 216 1 0
    //   492: ifeq +82 -> 574
    //   495: aload 5
    //   497: invokeinterface 220 1 0
    //   502: checkcast 108	com/gtp/go/weather/coupon/b/b
    //   505: astore 6
    //   507: aload_1
    //   508: invokevirtual 211	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   511: astore 7
    //   513: aload 7
    //   515: invokeinterface 216 1 0
    //   520: ifeq -35 -> 485
    //   523: aload 7
    //   525: invokeinterface 220 1 0
    //   530: checkcast 108	com/gtp/go/weather/coupon/b/b
    //   533: astore 8
    //   535: aload 6
    //   537: invokevirtual 223	com/gtp/go/weather/coupon/b/b:b	()J
    //   540: aload 8
    //   542: invokevirtual 223	com/gtp/go/weather/coupon/b/b:b	()J
    //   545: lcmp
    //   546: ifne -33 -> 513
    //   549: aload 6
    //   551: iconst_1
    //   552: invokevirtual 226	com/gtp/go/weather/coupon/b/b:c	(Z)V
    //   555: goto -70 -> 485
    //   558: aload_0
    //   559: getfield 14	com/gtp/go/weather/coupon/a/g:a	Lcom/gtp/go/weather/coupon/a/e;
    //   562: aload 4
    //   564: aload_0
    //   565: getfield 21	com/gtp/go/weather/coupon/a/g:c	Ljava/util/ArrayList;
    //   568: invokestatic 196	com/gtp/go/weather/coupon/a/e:a	(Lcom/gtp/go/weather/coupon/a/e;Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   571: goto -123 -> 448
    //   574: aload 4
    //   576: areturn
    //   577: aconst_null
    //   578: areturn
    //   579: astore 5
    //   581: goto -427 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	584	0	this	g
    //   0	584	1	paramVarArgs	Object[]
    //   62	315	2	i	int
    //   209	158	3	j	int
    //   52	523	4	localObject	Object
    //   150	14	5	localJSONException1	org.json.JSONException
    //   220	115	5	localJSONObject	org.json.JSONObject
    //   380	9	5	localException	Exception
    //   396	9	5	localJSONException2	org.json.JSONException
    //   483	13	5	localIterator1	Iterator
    //   579	1	5	localJSONException3	org.json.JSONException
    //   234	316	6	localb1	com.gtp.go.weather.coupon.b.b
    //   511	13	7	localIterator2	Iterator
    //   533	8	8	localb2	com.gtp.go.weather.coupon.b.b
    // Exception table:
    //   from	to	target	type
    //   80	89	150	org/json/JSONException
    //   227	363	380	java/lang/Exception
    //   215	222	396	org/json/JSONException
    //   227	363	396	org/json/JSONException
    //   382	393	396	org/json/JSONException
    //   93	101	579	org/json/JSONException
    //   106	115	579	org/json/JSONException
  }
  
  protected void a(ArrayList paramArrayList)
  {
    super.onPostExecute(paramArrayList);
    if (e.b(this.a) != null) {
      e.b(this.a).a(paramArrayList, this.b);
    }
    if ((paramArrayList != null) && (e.c(this.a) != null))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (com.gtp.go.weather.coupon.b.b)paramArrayList.next();
        if (!((com.gtp.go.weather.coupon.b.b)localObject).k())
        {
          localObject = new com.jiubang.core.c.a.a(((com.gtp.go.weather.coupon.b.b)localObject).i(), com.gtp.go.weather.coupon.c.a.a, com.gtp.go.weather.sharephoto.d.h.a(((com.gtp.go.weather.coupon.b.b)localObject).i()) + ".png");
          e.c(this.a).a((com.jiubang.core.c.a.a)localObject);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */