package com.gau.go.gostaticsdk.b;

import android.content.Context;

public class b
  extends a
{
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  /* Error */
  public void b(com.gau.go.gostaticsdk.a.a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: putfield 21	com/gau/go/gostaticsdk/a/a:f	I
    //   5: aload_1
    //   6: getfield 25	com/gau/go/gostaticsdk/a/a:h	Ljava/lang/String;
    //   9: ifnull +227 -> 236
    //   12: new 27	java/lang/StringBuffer
    //   15: dup
    //   16: aload_1
    //   17: getfield 25	com/gau/go/gostaticsdk/a/a:h	Ljava/lang/String;
    //   20: invokespecial 30	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   23: astore_3
    //   24: ldc 32
    //   26: aload_3
    //   27: invokevirtual 36	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   30: invokestatic 42	com/gau/go/gostaticsdk/f/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_3
    //   34: ifnull +201 -> 235
    //   37: aload_3
    //   38: invokevirtual 36	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   41: astore 4
    //   43: aload_1
    //   44: getfield 45	com/gau/go/gostaticsdk/a/a:q	I
    //   47: iconst_1
    //   48: iand
    //   49: ifeq +193 -> 242
    //   52: aload_1
    //   53: getfield 45	com/gau/go/gostaticsdk/a/a:q	I
    //   56: iconst_2
    //   57: iand
    //   58: ifeq +184 -> 242
    //   61: aload 4
    //   63: invokevirtual 51	java/lang/String:getBytes	()[B
    //   66: invokestatic 54	com/gau/go/gostaticsdk/f/d:a	([B)Ljava/lang/String;
    //   69: ldc 56
    //   71: invokestatic 62	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   74: ldc 64
    //   76: invokestatic 68	com/gau/go/gostaticsdk/d/b:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   79: astore_3
    //   80: aload_3
    //   81: ifnull +35 -> 116
    //   84: new 70	java/io/DataOutputStream
    //   87: dup
    //   88: aload_0
    //   89: getfield 73	com/gau/go/gostaticsdk/b/b:a	Ljava/net/HttpURLConnection;
    //   92: invokevirtual 79	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   95: invokespecial 82	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   98: astore 4
    //   100: aload 4
    //   102: aload_3
    //   103: invokevirtual 85	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   106: aload 4
    //   108: invokevirtual 89	java/io/DataOutputStream:flush	()V
    //   111: aload 4
    //   113: invokevirtual 92	java/io/DataOutputStream:close	()V
    //   116: aload_0
    //   117: getfield 73	com/gau/go/gostaticsdk/b/b:a	Ljava/net/HttpURLConnection;
    //   120: invokevirtual 96	java/net/HttpURLConnection:getResponseCode	()I
    //   123: sipush 200
    //   126: if_icmpne +179 -> 305
    //   129: aload_1
    //   130: iconst_3
    //   131: putfield 21	com/gau/go/gostaticsdk/a/a:f	I
    //   134: aload_1
    //   135: getfield 98	com/gau/go/gostaticsdk/a/a:a	I
    //   138: istore_2
    //   139: iload_2
    //   140: bipush 19
    //   142: if_icmpne +93 -> 235
    //   145: aconst_null
    //   146: astore 4
    //   148: new 100	java/io/BufferedReader
    //   151: dup
    //   152: new 102	java/io/InputStreamReader
    //   155: dup
    //   156: aload_0
    //   157: getfield 73	com/gau/go/gostaticsdk/b/b:a	Ljava/net/HttpURLConnection;
    //   160: invokevirtual 106	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   163: invokespecial 109	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   166: invokespecial 112	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   169: astore_3
    //   170: aload_3
    //   171: invokevirtual 115	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   174: astore 4
    //   176: aload 4
    //   178: ifnull +49 -> 227
    //   181: new 117	org/json/JSONObject
    //   184: dup
    //   185: aload 4
    //   187: invokespecial 118	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   190: ldc 120
    //   192: invokevirtual 124	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   195: astore 4
    //   197: aload_0
    //   198: getfield 127	com/gau/go/gostaticsdk/b/b:b	Landroid/content/Context;
    //   201: ldc -127
    //   203: iconst_0
    //   204: invokevirtual 135	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   207: invokeinterface 141 1 0
    //   212: ldc 120
    //   214: aload 4
    //   216: invokeinterface 147 3 0
    //   221: invokeinterface 151 1 0
    //   226: pop
    //   227: aload_3
    //   228: ifnull +7 -> 235
    //   231: aload_3
    //   232: invokevirtual 152	java/io/BufferedReader:close	()V
    //   235: return
    //   236: aload_1
    //   237: iconst_3
    //   238: putfield 21	com/gau/go/gostaticsdk/a/a:f	I
    //   241: return
    //   242: aload_1
    //   243: getfield 45	com/gau/go/gostaticsdk/a/a:q	I
    //   246: iconst_1
    //   247: iand
    //   248: ifeq +15 -> 263
    //   251: aload 4
    //   253: invokevirtual 51	java/lang/String:getBytes	()[B
    //   256: invokestatic 54	com/gau/go/gostaticsdk/f/d:a	([B)Ljava/lang/String;
    //   259: astore_3
    //   260: goto -180 -> 80
    //   263: aload 4
    //   265: astore_3
    //   266: aload_1
    //   267: getfield 45	com/gau/go/gostaticsdk/a/a:q	I
    //   270: iconst_2
    //   271: iand
    //   272: ifeq -192 -> 80
    //   275: aload 4
    //   277: ldc 56
    //   279: invokestatic 62	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   282: ldc 64
    //   284: invokestatic 68	com/gau/go/gostaticsdk/d/b:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   287: astore_3
    //   288: goto -208 -> 80
    //   291: aload_3
    //   292: ifnull -57 -> 235
    //   295: aload_3
    //   296: invokevirtual 152	java/io/BufferedReader:close	()V
    //   299: return
    //   300: astore_3
    //   301: aload_3
    //   302: invokevirtual 155	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   305: aload_1
    //   306: iconst_2
    //   307: putfield 21	com/gau/go/gostaticsdk/a/a:f	I
    //   310: return
    //   311: astore 5
    //   313: aload 4
    //   315: astore_3
    //   316: aload 5
    //   318: astore 4
    //   320: aload_3
    //   321: ifnull +7 -> 328
    //   324: aload_3
    //   325: invokevirtual 152	java/io/BufferedReader:close	()V
    //   328: aload 4
    //   330: athrow
    //   331: astore_3
    //   332: aload_3
    //   333: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   336: goto -31 -> 305
    //   339: astore 4
    //   341: goto -21 -> 320
    //   344: astore 4
    //   346: goto -55 -> 291
    //   349: astore_3
    //   350: aconst_null
    //   351: astore_3
    //   352: goto -61 -> 291
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	b
    //   0	355	1	parama	com.gau.go.gostaticsdk.a.a
    //   138	5	2	i	int
    //   23	273	3	localObject1	Object
    //   300	2	3	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   315	10	3	localObject2	Object
    //   331	2	3	localException1	Exception
    //   349	1	3	localException2	Exception
    //   351	1	3	localObject3	Object
    //   41	288	4	localObject4	Object
    //   339	1	4	localObject5	Object
    //   344	1	4	localException3	Exception
    //   311	6	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   43	80	300	java/io/UnsupportedEncodingException
    //   84	116	300	java/io/UnsupportedEncodingException
    //   116	139	300	java/io/UnsupportedEncodingException
    //   231	235	300	java/io/UnsupportedEncodingException
    //   242	260	300	java/io/UnsupportedEncodingException
    //   266	288	300	java/io/UnsupportedEncodingException
    //   295	299	300	java/io/UnsupportedEncodingException
    //   324	328	300	java/io/UnsupportedEncodingException
    //   328	331	300	java/io/UnsupportedEncodingException
    //   148	170	311	finally
    //   43	80	331	java/lang/Exception
    //   84	116	331	java/lang/Exception
    //   116	139	331	java/lang/Exception
    //   231	235	331	java/lang/Exception
    //   242	260	331	java/lang/Exception
    //   266	288	331	java/lang/Exception
    //   295	299	331	java/lang/Exception
    //   324	328	331	java/lang/Exception
    //   328	331	331	java/lang/Exception
    //   170	176	339	finally
    //   181	227	339	finally
    //   170	176	344	java/lang/Exception
    //   181	227	344	java/lang/Exception
    //   148	170	349	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */