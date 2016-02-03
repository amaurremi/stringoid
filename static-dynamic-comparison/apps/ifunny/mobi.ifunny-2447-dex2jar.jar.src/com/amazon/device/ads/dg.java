package com.amazon.device.ads;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class dg
        extends hy {
    private static final String m = dg.class.getSimpleName();

    /* Error */
    private void c(HttpURLConnection paramHttpURLConnection) {
        // Byte code:
        //   0: new 26	java/lang/StringBuilder
        //   3: dup
        //   4: invokespecial 27	java/lang/StringBuilder:<init>	()V
        //   7: astore_3
        //   8: aload_0
        //   9: getfield 30	com/amazon/device/ads/dg:a	Ljava/lang/String;
        //   12: ifnull +79 -> 91
        //   15: aload_3
        //   16: aload_0
        //   17: getfield 30	com/amazon/device/ads/dg:a	Ljava/lang/String;
        //   20: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   23: pop
        //   24: aload_0
        //   25: getfield 38	com/amazon/device/ads/dg:h	Z
        //   28: ifeq +30 -> 58
        //   31: aload_0
        //   32: invokevirtual 41	com/amazon/device/ads/dg:l	()Ljava/lang/String;
        //   35: ifnull +23 -> 58
        //   38: aload_0
        //   39: invokevirtual 44	com/amazon/device/ads/dg:n	()Ljava/lang/String;
        //   42: ldc 46
        //   44: iconst_1
        //   45: anewarray 48	java/lang/Object
        //   48: dup
        //   49: iconst_0
        //   50: aload_0
        //   51: invokevirtual 41	com/amazon/device/ads/dg:l	()Ljava/lang/String;
        //   54: aastore
        //   55: invokestatic 53	com/amazon/device/ads/dv:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   58: new 55	java/io/OutputStreamWriter
        //   61: dup
        //   62: aload_1
        //   63: invokevirtual 61	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   66: ldc 63
        //   68: invokespecial 66	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
        //   71: astore_2
        //   72: aload_2
        //   73: astore_1
        //   74: aload_2
        //   75: aload_3
        //   76: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   79: invokevirtual 73	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
        //   82: aload_2
        //   83: ifnull +7 -> 90
        //   86: aload_2
        //   87: invokevirtual 76	java/io/OutputStreamWriter:close	()V
        //   90: return
        //   91: aload_0
        //   92: getfield 80	com/amazon/device/ads/dg:g	Ljava/util/HashMap;
        //   95: ifnull -71 -> 24
        //   98: aload_0
        //   99: getfield 80	com/amazon/device/ads/dg:g	Ljava/util/HashMap;
        //   102: invokevirtual 86	java/util/HashMap:isEmpty	()Z
        //   105: ifne -81 -> 24
        //   108: aload_0
        //   109: getfield 80	com/amazon/device/ads/dg:g	Ljava/util/HashMap;
        //   112: invokevirtual 90	java/util/HashMap:entrySet	()Ljava/util/Set;
        //   115: invokeinterface 96 1 0
        //   120: astore_2
        //   121: aload_2
        //   122: invokeinterface 101 1 0
        //   127: ifeq +58 -> 185
        //   130: aload_2
        //   131: invokeinterface 105 1 0
        //   136: checkcast 107	java/util/Map$Entry
        //   139: astore 4
        //   141: aload_3
        //   142: aload 4
        //   144: invokeinterface 110 1 0
        //   149: checkcast 112	java/lang/String
        //   152: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   155: ldc 114
        //   157: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   160: aload 4
        //   162: invokeinterface 117 1 0
        //   167: checkcast 112	java/lang/String
        //   170: invokestatic 123	com/amazon/device/ads/hu:b	(Ljava/lang/String;)Ljava/lang/String;
        //   173: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   176: ldc 125
        //   178: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   181: pop
        //   182: goto -61 -> 121
        //   185: aload_3
        //   186: aload_3
        //   187: ldc 125
        //   189: invokevirtual 129	java/lang/StringBuilder:lastIndexOf	(Ljava/lang/String;)I
        //   192: invokevirtual 133	java/lang/StringBuilder:deleteCharAt	(I)Ljava/lang/StringBuilder;
        //   195: pop
        //   196: goto -172 -> 24
        //   199: astore_1
        //   200: aload_0
        //   201: invokevirtual 44	com/amazon/device/ads/dg:n	()Ljava/lang/String;
        //   204: ldc -121
        //   206: iconst_1
        //   207: anewarray 48	java/lang/Object
        //   210: dup
        //   211: iconst_0
        //   212: aload_1
        //   213: invokevirtual 138	java/io/IOException:getMessage	()Ljava/lang/String;
        //   216: aastore
        //   217: invokestatic 140	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   220: new 142	com/amazon/device/ads/ic
        //   223: dup
        //   224: aload_0
        //   225: getstatic 147	com/amazon/device/ads/ie:a	Lcom/amazon/device/ads/ie;
        //   228: ldc -107
        //   230: aload_1
        //   231: invokespecial 152	com/amazon/device/ads/ic:<init>	(Lcom/amazon/device/ads/hy;Lcom/amazon/device/ads/ie;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   234: athrow
        //   235: astore_3
        //   236: aconst_null
        //   237: astore_2
        //   238: aload_2
        //   239: astore_1
        //   240: aload_0
        //   241: invokevirtual 44	com/amazon/device/ads/dg:n	()Ljava/lang/String;
        //   244: ldc -102
        //   246: iconst_1
        //   247: anewarray 48	java/lang/Object
        //   250: dup
        //   251: iconst_0
        //   252: aload_3
        //   253: invokevirtual 138	java/io/IOException:getMessage	()Ljava/lang/String;
        //   256: aastore
        //   257: invokestatic 140	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   260: aload_2
        //   261: astore_1
        //   262: new 142	com/amazon/device/ads/ic
        //   265: dup
        //   266: aload_0
        //   267: getstatic 147	com/amazon/device/ads/ie:a	Lcom/amazon/device/ads/ie;
        //   270: ldc -100
        //   272: aload_3
        //   273: invokespecial 152	com/amazon/device/ads/ic:<init>	(Lcom/amazon/device/ads/hy;Lcom/amazon/device/ads/ie;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   276: athrow
        //   277: astore_3
        //   278: aload_1
        //   279: astore_2
        //   280: aload_3
        //   281: astore_1
        //   282: aload_2
        //   283: ifnull +7 -> 290
        //   286: aload_2
        //   287: invokevirtual 76	java/io/OutputStreamWriter:close	()V
        //   290: aload_1
        //   291: athrow
        //   292: astore_1
        //   293: aload_0
        //   294: invokevirtual 44	com/amazon/device/ads/dg:n	()Ljava/lang/String;
        //   297: ldc -121
        //   299: iconst_1
        //   300: anewarray 48	java/lang/Object
        //   303: dup
        //   304: iconst_0
        //   305: aload_1
        //   306: invokevirtual 138	java/io/IOException:getMessage	()Ljava/lang/String;
        //   309: aastore
        //   310: invokestatic 140	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   313: new 142	com/amazon/device/ads/ic
        //   316: dup
        //   317: aload_0
        //   318: getstatic 147	com/amazon/device/ads/ie:a	Lcom/amazon/device/ads/ie;
        //   321: ldc -107
        //   323: aload_1
        //   324: invokespecial 152	com/amazon/device/ads/ic:<init>	(Lcom/amazon/device/ads/hy;Lcom/amazon/device/ads/ie;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   327: athrow
        //   328: astore_1
        //   329: aconst_null
        //   330: astore_2
        //   331: goto -49 -> 282
        //   334: astore_3
        //   335: goto -97 -> 238
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	338	0	this	dg
        //   0	338	1	paramHttpURLConnection	HttpURLConnection
        //   71	260	2	localObject1	Object
        //   7	180	3	localStringBuilder	StringBuilder
        //   235	38	3	localIOException1	java.io.IOException
        //   277	4	3	localObject2	Object
        //   334	1	3	localIOException2	java.io.IOException
        //   139	22	4	localEntry	Map.Entry
        // Exception table:
        //   from	to	target	type
        //   86	90	199	java/io/IOException
        //   58	72	235	java/io/IOException
        //   74	82	277	finally
        //   240	260	277	finally
        //   262	277	277	finally
        //   286	290	292	java/io/IOException
        //   58	72	328	finally
        //   74	82	334	java/io/IOException
    }
  
  /* Error */
    protected if

    a(URL paramURL) {
        // Byte code:
        //   0: aload_0
        //   1: aload_1
        //   2: invokevirtual 162	com/amazon/device/ads/dg:b	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
        //   5: astore_1
        //   6: aload_0
        //   7: aload_1
        //   8: invokevirtual 164	com/amazon/device/ads/dg:a	(Ljava/net/HttpURLConnection;)V
        //   11: aload_1
        //   12: invokevirtual 167	java/net/HttpURLConnection:connect	()V
        //   15: aload_0
        //   16: aload_1
        //   17: invokevirtual 170	com/amazon/device/ads/dg:b	(Ljava/net/HttpURLConnection;)Lcom/amazon/device/ads/if;
        //   20: areturn
        //   21: astore_1
        //   22: aload_0
        //   23: invokevirtual 44	com/amazon/device/ads/dg:n	()Ljava/lang/String;
        //   26: ldc -84
        //   28: iconst_1
        //   29: anewarray 48	java/lang/Object
        //   32: dup
        //   33: iconst_0
        //   34: aload_1
        //   35: invokevirtual 138	java/io/IOException:getMessage	()Ljava/lang/String;
        //   38: aastore
        //   39: invokestatic 140	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   42: new 142	com/amazon/device/ads/ic
        //   45: dup
        //   46: aload_0
        //   47: getstatic 147	com/amazon/device/ads/ie:a	Lcom/amazon/device/ads/ie;
        //   50: ldc -82
        //   52: aload_1
        //   53: invokespecial 152	com/amazon/device/ads/ic:<init>	(Lcom/amazon/device/ads/hy;Lcom/amazon/device/ads/ie;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   56: athrow
        //   57: astore_1
        //   58: aload_0
        //   59: invokevirtual 44	com/amazon/device/ads/dg:n	()Ljava/lang/String;
        //   62: ldc -80
        //   64: iconst_1
        //   65: anewarray 48	java/lang/Object
        //   68: dup
        //   69: iconst_0
        //   70: aload_1
        //   71: invokevirtual 177	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
        //   74: aastore
        //   75: invokestatic 140	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   78: new 142	com/amazon/device/ads/ic
        //   81: dup
        //   82: aload_0
        //   83: getstatic 179	com/amazon/device/ads/ie:b	Lcom/amazon/device/ads/ie;
        //   86: ldc -75
        //   88: aload_1
        //   89: invokespecial 152	com/amazon/device/ads/ic:<init>	(Lcom/amazon/device/ads/hy;Lcom/amazon/device/ads/ie;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   92: athrow
        //   93: astore_1
        //   94: aload_0
        //   95: invokevirtual 44	com/amazon/device/ads/dg:n	()Ljava/lang/String;
        //   98: ldc -73
        //   100: iconst_1
        //   101: anewarray 48	java/lang/Object
        //   104: dup
        //   105: iconst_0
        //   106: aload_1
        //   107: invokevirtual 138	java/io/IOException:getMessage	()Ljava/lang/String;
        //   110: aastore
        //   111: invokestatic 140	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   114: new 142	com/amazon/device/ads/ic
        //   117: dup
        //   118: aload_0
        //   119: getstatic 147	com/amazon/device/ads/ie:a	Lcom/amazon/device/ads/ie;
        //   122: ldc -71
        //   124: aload_1
        //   125: invokespecial 152	com/amazon/device/ads/ic:<init>	(Lcom/amazon/device/ads/hy;Lcom/amazon/device/ads/ie;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   128: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	129	0	this	dg
        //   0	129	1	paramURL	URL
        // Exception table:
        //   from	to	target	type
        //   0	6	21	java/io/IOException
        //   11	15	57	java/net/SocketTimeoutException
        //   11	15	93	java/io/IOException
    }

    protected void a(HttpURLConnection paramHttpURLConnection) {
        try {
            paramHttpURLConnection.setRequestMethod(f().name());
            Iterator localIterator = this.e.entrySet().iterator();
            while (localIterator.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator.next();
                if ((localEntry.getValue() != null) && (!((String) localEntry.getValue()).equals(""))) {
                    paramHttpURLConnection.setRequestProperty((String) localEntry.getKey(), (String) localEntry.getValue());
                }
            }
            paramHttpURLConnection.setConnectTimeout(m());
        } catch (ProtocolException paramHttpURLConnection) {
            dv.b(n(), "Invalid client protocol: %s", new Object[]{paramHttpURLConnection.getMessage()});
            throw new ic(this, ie.d, "Invalid client protocol", paramHttpURLConnection);
        }
        paramHttpURLConnection.setReadTimeout(m());
        a(paramHttpURLConnection.getURL().toString());
        switch (dh.a[f().ordinal()]) {
            default:
                return;
            case 1:
                paramHttpURLConnection.setDoOutput(false);
                return;
        }
        paramHttpURLConnection.setDoOutput(true);
        c(paramHttpURLConnection);
    }
  
  /* Error */
    protected if

    b(HttpURLConnection paramHttpURLConnection) {
        // Byte code:
        //   0: new 255	com/amazon/device/ads/if
        //   3: dup
        //   4: aload_0
        //   5: invokespecial 258	com/amazon/device/ads/if:<init>	(Lcom/amazon/device/ads/hy;)V
        //   8: astore_2
        //   9: aload_2
        //   10: aload_0
        //   11: invokevirtual 44	com/amazon/device/ads/dg:n	()Ljava/lang/String;
        //   14: invokevirtual 260	com/amazon/device/ads/if:b	(Ljava/lang/String;)V
        //   17: aload_2
        //   18: aload_0
        //   19: getfield 263	com/amazon/device/ads/dg:i	Z
        //   22: invokevirtual 265	com/amazon/device/ads/if:a	(Z)V
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 268	java/net/HttpURLConnection:getResponseCode	()I
        //   30: invokevirtual 270	com/amazon/device/ads/if:a	(I)V
        //   33: aload_2
        //   34: aload_1
        //   35: invokevirtual 273	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
        //   38: invokevirtual 275	com/amazon/device/ads/if:c	(Ljava/lang/String;)V
        //   41: aload_2
        //   42: invokevirtual 277	com/amazon/device/ads/if:d	()I
        //   45: sipush 200
        //   48: if_icmpne +11 -> 59
        //   51: aload_2
        //   52: aload_1
        //   53: invokevirtual 281	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   56: invokevirtual 284	com/amazon/device/ads/if:a	(Ljava/io/InputStream;)V
        //   59: aload_2
        //   60: areturn
        //   61: astore_1
        //   62: aload_0
        //   63: invokevirtual 44	com/amazon/device/ads/dg:n	()Ljava/lang/String;
        //   66: ldc_w 286
        //   69: iconst_1
        //   70: anewarray 48	java/lang/Object
        //   73: dup
        //   74: iconst_0
        //   75: aload_1
        //   76: invokevirtual 177	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
        //   79: aastore
        //   80: invokestatic 140	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   83: new 142	com/amazon/device/ads/ic
        //   86: dup
        //   87: aload_0
        //   88: getstatic 179	com/amazon/device/ads/ie:b	Lcom/amazon/device/ads/ie;
        //   91: ldc_w 288
        //   94: aload_1
        //   95: invokespecial 152	com/amazon/device/ads/ic:<init>	(Lcom/amazon/device/ads/hy;Lcom/amazon/device/ads/ie;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   98: athrow
        //   99: astore_1
        //   100: aload_0
        //   101: invokevirtual 44	com/amazon/device/ads/dg:n	()Ljava/lang/String;
        //   104: ldc_w 290
        //   107: iconst_1
        //   108: anewarray 48	java/lang/Object
        //   111: dup
        //   112: iconst_0
        //   113: aload_1
        //   114: invokevirtual 138	java/io/IOException:getMessage	()Ljava/lang/String;
        //   117: aastore
        //   118: invokestatic 140	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   121: new 142	com/amazon/device/ads/ic
        //   124: dup
        //   125: aload_0
        //   126: getstatic 147	com/amazon/device/ads/ie:a	Lcom/amazon/device/ads/ie;
        //   129: ldc_w 292
        //   132: aload_1
        //   133: invokespecial 152	com/amazon/device/ads/ic:<init>	(Lcom/amazon/device/ads/hy;Lcom/amazon/device/ads/ie;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   136: athrow
        //   137: astore_1
        //   138: aload_0
        //   139: invokevirtual 44	com/amazon/device/ads/dg:n	()Ljava/lang/String;
        //   142: ldc_w 294
        //   145: iconst_1
        //   146: anewarray 48	java/lang/Object
        //   149: dup
        //   150: iconst_0
        //   151: aload_1
        //   152: invokevirtual 138	java/io/IOException:getMessage	()Ljava/lang/String;
        //   155: aastore
        //   156: invokestatic 140	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   159: new 142	com/amazon/device/ads/ic
        //   162: dup
        //   163: aload_0
        //   164: getstatic 147	com/amazon/device/ads/ie:a	Lcom/amazon/device/ads/ie;
        //   167: ldc_w 296
        //   170: aload_1
        //   171: invokespecial 152	com/amazon/device/ads/ic:<init>	(Lcom/amazon/device/ads/hy;Lcom/amazon/device/ads/ie;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   174: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	175	0	this	dg
        //   0	175	1	paramHttpURLConnection	HttpURLConnection
        //   8	52	2	localif	if
        // Exception table:
        //   from	to	target	type
        //   25	41	61	java/net/SocketTimeoutException
        //   25	41	99	java/io/IOException
        //   51	59	137	java/io/IOException
    }

    protected String b() {
        return m;
    }

    protected HttpURLConnection b(URL paramURL) {
        return (HttpURLConnection) paramURL.openConnection();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */