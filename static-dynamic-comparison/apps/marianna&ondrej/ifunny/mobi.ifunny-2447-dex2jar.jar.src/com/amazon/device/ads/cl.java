package com.amazon.device.ads;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class cl {
    protected static cl d = new cl();
    private static final String e = cl.class.getSimpleName();
    protected final Object a = new Object();
    protected final Set<String> b = Collections.synchronizedSet(new HashSet());
    protected final Set<String> c = Collections.synchronizedSet(new HashSet());

    public static cl a() {
        return d;
    }

    /* Error */
    public org.json.JSONArray b() {
        // Byte code:
        //   0: aconst_null
        //   1: astore 7
        //   3: aconst_null
        //   4: astore 8
        //   6: invokestatic 56	com/amazon/device/ads/dn:i	()Lcom/amazon/device/ads/dl;
        //   9: invokeinterface 62 1 0
        //   14: astore_1
        //   15: aload_1
        //   16: ifnonnull +5 -> 21
        //   19: aconst_null
        //   20: areturn
        //   21: aload_0
        //   22: getfield 33	com/amazon/device/ads/cl:a	Ljava/lang/Object;
        //   25: astore 9
        //   27: aload 9
        //   29: monitorenter
        //   30: new 64	java/io/File
        //   33: dup
        //   34: aload_1
        //   35: invokevirtual 70	android/content/Context:getFilesDir	()Ljava/io/File;
        //   38: ldc 72
        //   40: invokespecial 75	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   43: astore_1
        //   44: aload_1
        //   45: invokevirtual 79	java/io/File:exists	()Z
        //   48: ifne +14 -> 62
        //   51: aload 9
        //   53: monitorexit
        //   54: aconst_null
        //   55: areturn
        //   56: astore_1
        //   57: aload 9
        //   59: monitorexit
        //   60: aload_1
        //   61: athrow
        //   62: new 81	java/io/FileInputStream
        //   65: dup
        //   66: aload_1
        //   67: invokespecial 84	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   70: astore_2
        //   71: new 86	java/io/BufferedReader
        //   74: dup
        //   75: new 88	java/io/InputStreamReader
        //   78: dup
        //   79: aload_2
        //   80: invokespecial 91	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   83: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   86: astore 5
        //   88: aconst_null
        //   89: astore_1
        //   90: aload 5
        //   92: astore 4
        //   94: aload_2
        //   95: astore_3
        //   96: aload 5
        //   98: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   101: astore 6
        //   103: aload 6
        //   105: ifnull +296 -> 401
        //   108: aload 5
        //   110: astore 4
        //   112: aload_2
        //   113: astore_3
        //   114: aload 6
        //   116: invokestatic 102	com/amazon/device/ads/du:a	(Ljava/lang/String;)Lorg/json/JSONObject;
        //   119: astore 10
        //   121: aload 10
        //   123: ifnonnull +43 -> 166
        //   126: aload 5
        //   128: astore 4
        //   130: aload_2
        //   131: astore_3
        //   132: aload_0
        //   133: invokevirtual 104	com/amazon/device/ads/cl:c	()V
        //   136: aload 8
        //   138: astore_1
        //   139: aload_2
        //   140: ifnull +7 -> 147
        //   143: aload_2
        //   144: invokevirtual 107	java/io/FileInputStream:close	()V
        //   147: aload_1
        //   148: astore_2
        //   149: aload 5
        //   151: ifnull +10 -> 161
        //   154: aload 5
        //   156: invokevirtual 108	java/io/BufferedReader:close	()V
        //   159: aload_1
        //   160: astore_2
        //   161: aload 9
        //   163: monitorexit
        //   164: aload_2
        //   165: areturn
        //   166: aload_1
        //   167: astore 6
        //   169: aload_1
        //   170: ifnonnull +18 -> 188
        //   173: aload 5
        //   175: astore 4
        //   177: aload_2
        //   178: astore_3
        //   179: new 110	org/json/JSONArray
        //   182: dup
        //   183: invokespecial 111	org/json/JSONArray:<init>	()V
        //   186: astore 6
        //   188: aload 5
        //   190: astore 4
        //   192: aload_2
        //   193: astore_3
        //   194: aload 6
        //   196: aload 10
        //   198: invokevirtual 115	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
        //   201: pop
        //   202: aload 5
        //   204: astore 4
        //   206: aload_2
        //   207: astore_3
        //   208: aload_0
        //   209: getfield 46	com/amazon/device/ads/cl:c	Ljava/util/Set;
        //   212: aload 10
        //   214: invokevirtual 120	org/json/JSONObject:toString	()Ljava/lang/String;
        //   217: invokeinterface 126 2 0
        //   222: pop
        //   223: aload 6
        //   225: astore_1
        //   226: goto -136 -> 90
        //   229: astore_1
        //   230: aload 5
        //   232: astore_1
        //   233: aload_1
        //   234: astore 4
        //   236: aload_2
        //   237: astore_3
        //   238: getstatic 24	com/amazon/device/ads/cl:e	Ljava/lang/String;
        //   241: ldc -128
        //   243: invokestatic 133	com/amazon/device/ads/dv:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   246: aload_2
        //   247: ifnull +7 -> 254
        //   250: aload_2
        //   251: invokevirtual 107	java/io/FileInputStream:close	()V
        //   254: aload 7
        //   256: astore_2
        //   257: aload_1
        //   258: ifnull -97 -> 161
        //   261: aload_1
        //   262: invokevirtual 108	java/io/BufferedReader:close	()V
        //   265: aload 7
        //   267: astore_2
        //   268: goto -107 -> 161
        //   271: astore_1
        //   272: getstatic 24	com/amazon/device/ads/cl:e	Ljava/lang/String;
        //   275: ldc -121
        //   277: invokestatic 133	com/amazon/device/ads/dv:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   280: aload 7
        //   282: astore_2
        //   283: goto -122 -> 161
        //   286: astore_2
        //   287: getstatic 24	com/amazon/device/ads/cl:e	Ljava/lang/String;
        //   290: ldc -121
        //   292: invokestatic 133	com/amazon/device/ads/dv:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   295: goto -148 -> 147
        //   298: astore_2
        //   299: getstatic 24	com/amazon/device/ads/cl:e	Ljava/lang/String;
        //   302: ldc -121
        //   304: invokestatic 133	com/amazon/device/ads/dv:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   307: aload_1
        //   308: astore_2
        //   309: goto -148 -> 161
        //   312: astore_2
        //   313: getstatic 24	com/amazon/device/ads/cl:e	Ljava/lang/String;
        //   316: ldc -121
        //   318: invokestatic 133	com/amazon/device/ads/dv:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   321: goto -67 -> 254
        //   324: astore_1
        //   325: aconst_null
        //   326: astore_2
        //   327: aconst_null
        //   328: astore 4
        //   330: aload_2
        //   331: ifnull +7 -> 338
        //   334: aload_2
        //   335: invokevirtual 107	java/io/FileInputStream:close	()V
        //   338: aload 4
        //   340: ifnull +8 -> 348
        //   343: aload 4
        //   345: invokevirtual 108	java/io/BufferedReader:close	()V
        //   348: aload_1
        //   349: athrow
        //   350: astore_2
        //   351: getstatic 24	com/amazon/device/ads/cl:e	Ljava/lang/String;
        //   354: ldc -121
        //   356: invokestatic 133	com/amazon/device/ads/dv:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   359: goto -21 -> 338
        //   362: astore_2
        //   363: getstatic 24	com/amazon/device/ads/cl:e	Ljava/lang/String;
        //   366: ldc -121
        //   368: invokestatic 133	com/amazon/device/ads/dv:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   371: goto -23 -> 348
        //   374: astore_1
        //   375: aconst_null
        //   376: astore 4
        //   378: goto -48 -> 330
        //   381: astore_1
        //   382: aload_3
        //   383: astore_2
        //   384: goto -54 -> 330
        //   387: astore_1
        //   388: aconst_null
        //   389: astore_1
        //   390: aconst_null
        //   391: astore_2
        //   392: goto -159 -> 233
        //   395: astore_1
        //   396: aconst_null
        //   397: astore_1
        //   398: goto -165 -> 233
        //   401: goto -262 -> 139
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	404	0	this	cl
        //   14	31	1	localObject1	Object
        //   56	11	1	localFile	java.io.File
        //   89	137	1	localObject2	Object
        //   229	1	1	localIOException1	java.io.IOException
        //   232	30	1	localObject3	Object
        //   271	37	1	localIOException2	java.io.IOException
        //   324	25	1	localObject4	Object
        //   374	1	1	localObject5	Object
        //   381	1	1	localObject6	Object
        //   387	1	1	localIOException3	java.io.IOException
        //   389	1	1	localObject7	Object
        //   395	1	1	localIOException4	java.io.IOException
        //   397	1	1	localObject8	Object
        //   70	213	2	localObject9	Object
        //   286	1	2	localIOException5	java.io.IOException
        //   298	1	2	localIOException6	java.io.IOException
        //   308	1	2	localIOException7	java.io.IOException
        //   312	1	2	localIOException8	java.io.IOException
        //   326	9	2	localObject10	Object
        //   350	1	2	localIOException9	java.io.IOException
        //   362	1	2	localIOException10	java.io.IOException
        //   383	9	2	localObject11	Object
        //   95	288	3	localObject12	Object
        //   92	285	4	localObject13	Object
        //   86	145	5	localBufferedReader	java.io.BufferedReader
        //   101	123	6	localObject14	Object
        //   1	280	7	localObject15	Object
        //   4	133	8	localObject16	Object
        //   25	137	9	localObject17	Object
        //   119	94	10	localJSONObject	org.json.JSONObject
        // Exception table:
        //   from	to	target	type
        //   30	54	56	finally
        //   57	60	56	finally
        //   143	147	56	finally
        //   154	159	56	finally
        //   161	164	56	finally
        //   250	254	56	finally
        //   261	265	56	finally
        //   272	280	56	finally
        //   287	295	56	finally
        //   299	307	56	finally
        //   313	321	56	finally
        //   334	338	56	finally
        //   343	348	56	finally
        //   348	350	56	finally
        //   351	359	56	finally
        //   363	371	56	finally
        //   96	103	229	java/io/IOException
        //   114	121	229	java/io/IOException
        //   132	136	229	java/io/IOException
        //   179	188	229	java/io/IOException
        //   194	202	229	java/io/IOException
        //   208	223	229	java/io/IOException
        //   261	265	271	java/io/IOException
        //   143	147	286	java/io/IOException
        //   154	159	298	java/io/IOException
        //   250	254	312	java/io/IOException
        //   62	71	324	finally
        //   334	338	350	java/io/IOException
        //   343	348	362	java/io/IOException
        //   71	88	374	finally
        //   96	103	381	finally
        //   114	121	381	finally
        //   132	136	381	finally
        //   179	188	381	finally
        //   194	202	381	finally
        //   208	223	381	finally
        //   238	246	381	finally
        //   62	71	387	java/io/IOException
        //   71	88	395	java/io/IOException
    }

    /* Error */
    public void c() {
        // Byte code:
        //   0: invokestatic 56	com/amazon/device/ads/dn:i	()Lcom/amazon/device/ads/dl;
        //   3: invokeinterface 62 1 0
        //   8: astore_2
        //   9: aload_2
        //   10: ifnonnull +4 -> 14
        //   13: return
        //   14: aload_0
        //   15: getfield 33	com/amazon/device/ads/cl:a	Ljava/lang/Object;
        //   18: astore 4
        //   20: aload 4
        //   22: monitorenter
        //   23: aload_0
        //   24: getfield 44	com/amazon/device/ads/cl:b	Ljava/util/Set;
        //   27: aload_0
        //   28: getfield 46	com/amazon/device/ads/cl:c	Ljava/util/Set;
        //   31: invokeinterface 139 2 0
        //   36: pop
        //   37: aload_0
        //   38: getfield 44	com/amazon/device/ads/cl:b	Ljava/util/Set;
        //   41: invokeinterface 142 1 0
        //   46: ifne +234 -> 280
        //   49: new 144	java/lang/StringBuilder
        //   52: dup
        //   53: invokespecial 145	java/lang/StringBuilder:<init>	()V
        //   56: astore_3
        //   57: aload_0
        //   58: getfield 44	com/amazon/device/ads/cl:b	Ljava/util/Set;
        //   61: astore_1
        //   62: aload_1
        //   63: monitorenter
        //   64: aload_0
        //   65: getfield 44	com/amazon/device/ads/cl:b	Ljava/util/Set;
        //   68: invokeinterface 149 1 0
        //   73: astore 5
        //   75: aload 5
        //   77: invokeinterface 154 1 0
        //   82: ifeq +37 -> 119
        //   85: aload_3
        //   86: aload 5
        //   88: invokeinterface 158 1 0
        //   93: checkcast 160	java/lang/String
        //   96: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   99: ldc -90
        //   101: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   104: pop
        //   105: goto -30 -> 75
        //   108: astore_2
        //   109: aload_1
        //   110: monitorexit
        //   111: aload_2
        //   112: athrow
        //   113: astore_1
        //   114: aload 4
        //   116: monitorexit
        //   117: aload_1
        //   118: athrow
        //   119: aload_1
        //   120: monitorexit
        //   121: new 64	java/io/File
        //   124: dup
        //   125: aload_2
        //   126: invokevirtual 70	android/content/Context:getFilesDir	()Ljava/io/File;
        //   129: ldc 72
        //   131: invokespecial 75	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   134: astore_2
        //   135: aconst_null
        //   136: astore_1
        //   137: new 168	java/io/BufferedWriter
        //   140: dup
        //   141: new 170	java/io/OutputStreamWriter
        //   144: dup
        //   145: new 172	java/io/FileOutputStream
        //   148: dup
        //   149: aload_2
        //   150: iconst_0
        //   151: invokespecial 175	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
        //   154: invokespecial 178	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
        //   157: invokespecial 181	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
        //   160: astore_2
        //   161: aload_2
        //   162: astore_1
        //   163: aload_2
        //   164: aload_3
        //   165: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   168: invokevirtual 186	java/io/BufferedWriter:write	(Ljava/lang/String;)V
        //   171: aload_2
        //   172: astore_1
        //   173: aload_0
        //   174: getfield 44	com/amazon/device/ads/cl:b	Ljava/util/Set;
        //   177: invokeinterface 189 1 0
        //   182: aload_2
        //   183: astore_1
        //   184: aload_0
        //   185: getfield 46	com/amazon/device/ads/cl:c	Ljava/util/Set;
        //   188: invokeinterface 189 1 0
        //   193: aload_2
        //   194: ifnull +7 -> 201
        //   197: aload_2
        //   198: invokevirtual 190	java/io/BufferedWriter:close	()V
        //   201: aload 4
        //   203: monitorexit
        //   204: return
        //   205: astore_1
        //   206: getstatic 24	com/amazon/device/ads/cl:e	Ljava/lang/String;
        //   209: ldc -64
        //   211: invokestatic 133	com/amazon/device/ads/dv:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   214: goto -13 -> 201
        //   217: astore_1
        //   218: aconst_null
        //   219: astore_2
        //   220: aload_2
        //   221: astore_1
        //   222: getstatic 24	com/amazon/device/ads/cl:e	Ljava/lang/String;
        //   225: ldc -62
        //   227: invokestatic 133	com/amazon/device/ads/dv:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   230: aload_2
        //   231: ifnull -30 -> 201
        //   234: aload_2
        //   235: invokevirtual 190	java/io/BufferedWriter:close	()V
        //   238: goto -37 -> 201
        //   241: astore_1
        //   242: getstatic 24	com/amazon/device/ads/cl:e	Ljava/lang/String;
        //   245: ldc -64
        //   247: invokestatic 133	com/amazon/device/ads/dv:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   250: goto -49 -> 201
        //   253: astore_3
        //   254: aload_1
        //   255: astore_2
        //   256: aload_3
        //   257: astore_1
        //   258: aload_2
        //   259: ifnull +7 -> 266
        //   262: aload_2
        //   263: invokevirtual 190	java/io/BufferedWriter:close	()V
        //   266: aload_1
        //   267: athrow
        //   268: astore_2
        //   269: getstatic 24	com/amazon/device/ads/cl:e	Ljava/lang/String;
        //   272: ldc -64
        //   274: invokestatic 133	com/amazon/device/ads/dv:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   277: goto -11 -> 266
        //   280: aload_2
        //   281: ldc 72
        //   283: invokevirtual 198	android/content/Context:deleteFile	(Ljava/lang/String;)Z
        //   286: pop
        //   287: aload_0
        //   288: getfield 46	com/amazon/device/ads/cl:c	Ljava/util/Set;
        //   291: invokeinterface 189 1 0
        //   296: goto -95 -> 201
        //   299: astore_3
        //   300: aload_1
        //   301: astore_2
        //   302: aload_3
        //   303: astore_1
        //   304: goto -46 -> 258
        //   307: astore_1
        //   308: goto -88 -> 220
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	311	0	this	cl
        //   61	49	1	localSet	Set
        //   113	7	1	localObject1	Object
        //   136	48	1	localObject2	Object
        //   205	1	1	localIOException1	java.io.IOException
        //   217	1	1	localIOException2	java.io.IOException
        //   221	1	1	localObject3	Object
        //   241	14	1	localIOException3	java.io.IOException
        //   257	47	1	localObject4	Object
        //   307	1	1	localIOException4	java.io.IOException
        //   8	2	2	localContext	android.content.Context
        //   108	18	2	localObject5	Object
        //   134	129	2	localObject6	Object
        //   268	13	2	localIOException5	java.io.IOException
        //   301	1	2	localObject7	Object
        //   56	109	3	localStringBuilder	StringBuilder
        //   253	4	3	localObject8	Object
        //   299	4	3	localObject9	Object
        //   18	184	4	localObject10	Object
        //   73	14	5	localIterator	java.util.Iterator
        // Exception table:
        //   from	to	target	type
        //   64	75	108	finally
        //   75	105	108	finally
        //   109	111	108	finally
        //   119	121	108	finally
        //   23	64	113	finally
        //   111	113	113	finally
        //   114	117	113	finally
        //   121	135	113	finally
        //   197	201	113	finally
        //   201	204	113	finally
        //   206	214	113	finally
        //   234	238	113	finally
        //   242	250	113	finally
        //   262	266	113	finally
        //   266	268	113	finally
        //   269	277	113	finally
        //   280	296	113	finally
        //   197	201	205	java/io/IOException
        //   137	161	217	java/io/IOException
        //   234	238	241	java/io/IOException
        //   137	161	253	finally
        //   262	266	268	java/io/IOException
        //   163	171	299	finally
        //   173	182	299	finally
        //   184	193	299	finally
        //   222	230	299	finally
        //   163	171	307	java/io/IOException
        //   173	182	307	java/io/IOException
        //   184	193	307	java/io/IOException
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */