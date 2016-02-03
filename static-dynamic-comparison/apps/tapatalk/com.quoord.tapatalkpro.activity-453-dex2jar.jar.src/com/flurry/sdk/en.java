package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.AbstractHttpEntity;

public class en
        extends fg {
    private static final String a = en.class.getSimpleName();
    private static SSLContext b;
    private static HostnameVerifier c;
    private String d;
    private a e;
    private int f = 10000;
    private int i = 15000;
    private boolean j = true;
    private final ds<String, String> k = new ds();
    private c l;
    private HttpURLConnection m;
    private HttpClient n;
    private boolean o;
    private boolean p;
    private Exception q;
    private int r = -1;
    private final ds<String, String> s = new ds();
    private final Object t = new Object();

    private void a(InputStream paramInputStream)
            throws Exception {
        if (this.l == null) {
        }
        while ((b()) || (paramInputStream == null)) {
            return;
        }
        this.l.a(this, paramInputStream);
    }

    private void a(OutputStream paramOutputStream)
            throws Exception {
        if (this.l == null) {
        }
        while ((b()) || (paramOutputStream == null)) {
            return;
        }
        this.l.a(this, paramOutputStream);
    }

    /* Error */
    private static SSLContext m() {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 108	com/flurry/sdk/en:b	Ljavax/net/ssl/SSLContext;
        //   6: ifnull +12 -> 18
        //   9: getstatic 108	com/flurry/sdk/en:b	Ljavax/net/ssl/SSLContext;
        //   12: astore_0
        //   13: ldc 2
        //   15: monitorexit
        //   16: aload_0
        //   17: areturn
        //   18: new 110	com/flurry/sdk/ej
        //   21: dup
        //   22: aconst_null
        //   23: invokespecial 113	com/flurry/sdk/ej:<init>	(Ljava/security/KeyStore;)V
        //   26: astore_0
        //   27: ldc 115
        //   29: invokestatic 121	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
        //   32: putstatic 108	com/flurry/sdk/en:b	Ljavax/net/ssl/SSLContext;
        //   35: getstatic 108	com/flurry/sdk/en:b	Ljavax/net/ssl/SSLContext;
        //   38: astore_1
        //   39: new 123	java/security/SecureRandom
        //   42: dup
        //   43: invokespecial 124	java/security/SecureRandom:<init>	()V
        //   46: astore_2
        //   47: aload_1
        //   48: aconst_null
        //   49: iconst_1
        //   50: anewarray 126	javax/net/ssl/TrustManager
        //   53: dup
        //   54: iconst_0
        //   55: aload_0
        //   56: aastore
        //   57: aload_2
        //   58: invokevirtual 130	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
        //   61: getstatic 108	com/flurry/sdk/en:b	Ljavax/net/ssl/SSLContext;
        //   64: astore_0
        //   65: goto -52 -> 13
        //   68: astore_0
        //   69: iconst_3
        //   70: getstatic 57	com/flurry/sdk/en:a	Ljava/lang/String;
        //   73: ldc -124
        //   75: aload_0
        //   76: invokestatic 137	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   79: goto -18 -> 61
        //   82: astore_0
        //   83: ldc 2
        //   85: monitorexit
        //   86: aload_0
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   12	53	0	localObject1	Object
        //   68	8	0	localException	Exception
        //   82	5	0	localObject2	Object
        //   38	10	1	localSSLContext	SSLContext
        //   46	12	2	localSecureRandom	java.security.SecureRandom
        // Exception table:
        //   from	to	target	type
        //   18	61	68	java/lang/Exception
        //   3	13	82	finally
        //   18	61	82	finally
        //   61	65	82	finally
        //   69	79	82	finally
    }

    /* Error */
    private static HostnameVerifier n() {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 140	com/flurry/sdk/en:c	Ljavax/net/ssl/HostnameVerifier;
        //   6: ifnull +12 -> 18
        //   9: getstatic 140	com/flurry/sdk/en:c	Ljavax/net/ssl/HostnameVerifier;
        //   12: astore_0
        //   13: ldc 2
        //   15: monitorexit
        //   16: aload_0
        //   17: areturn
        //   18: new 142	com/flurry/sdk/eh
        //   21: dup
        //   22: invokespecial 143	com/flurry/sdk/eh:<init>	()V
        //   25: putstatic 140	com/flurry/sdk/en:c	Ljavax/net/ssl/HostnameVerifier;
        //   28: getstatic 140	com/flurry/sdk/en:c	Ljavax/net/ssl/HostnameVerifier;
        //   31: astore_0
        //   32: goto -19 -> 13
        //   35: astore_0
        //   36: ldc 2
        //   38: monitorexit
        //   39: aload_0
        //   40: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   12	20	0	localHostnameVerifier	HostnameVerifier
        //   35	5	0	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   3	13	35	finally
        //   18	32	35	finally
    }

    /* Error */
    private void o()
            throws Exception {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: aconst_null
        //   4: astore 5
        //   6: aload_0
        //   7: getfield 145	com/flurry/sdk/en:p	Z
        //   10: ifeq +4 -> 14
        //   13: return
        //   14: new 147	java/net/URL
        //   17: dup
        //   18: aload_0
        //   19: getfield 149	com/flurry/sdk/en:d	Ljava/lang/String;
        //   22: invokespecial 152	java/net/URL:<init>	(Ljava/lang/String;)V
        //   25: astore_2
        //   26: aload_0
        //   27: aload_2
        //   28: invokevirtual 156	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   31: checkcast 158	java/net/HttpURLConnection
        //   34: putfield 84	com/flurry/sdk/en:m	Ljava/net/HttpURLConnection;
        //   37: aload_0
        //   38: getfield 84	com/flurry/sdk/en:m	Ljava/net/HttpURLConnection;
        //   41: aload_0
        //   42: getfield 63	com/flurry/sdk/en:f	I
        //   45: invokevirtual 162	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   48: aload_0
        //   49: getfield 84	com/flurry/sdk/en:m	Ljava/net/HttpURLConnection;
        //   52: aload_0
        //   53: getfield 65	com/flurry/sdk/en:i	I
        //   56: invokevirtual 165	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   59: aload_0
        //   60: getfield 84	com/flurry/sdk/en:m	Ljava/net/HttpURLConnection;
        //   63: aload_0
        //   64: getfield 167	com/flurry/sdk/en:e	Lcom/flurry/sdk/en$a;
        //   67: invokevirtual 170	com/flurry/sdk/en$a:toString	()Ljava/lang/String;
        //   70: invokevirtual 173	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   73: aload_0
        //   74: getfield 84	com/flurry/sdk/en:m	Ljava/net/HttpURLConnection;
        //   77: aload_0
        //   78: getfield 67	com/flurry/sdk/en:j	Z
        //   81: invokevirtual 177	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
        //   84: aload_0
        //   85: getfield 84	com/flurry/sdk/en:m	Ljava/net/HttpURLConnection;
        //   88: getstatic 179	com/flurry/sdk/en$a:c	Lcom/flurry/sdk/en$a;
        //   91: aload_0
        //   92: getfield 167	com/flurry/sdk/en:e	Lcom/flurry/sdk/en$a;
        //   95: invokevirtual 183	com/flurry/sdk/en$a:equals	(Ljava/lang/Object;)Z
        //   98: invokevirtual 186	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   101: aload_0
        //   102: getfield 84	com/flurry/sdk/en:m	Ljava/net/HttpURLConnection;
        //   105: iconst_1
        //   106: invokevirtual 189	java/net/HttpURLConnection:setDoInput	(Z)V
        //   109: invokestatic 191	com/flurry/sdk/eo:d	()Z
        //   112: ifeq +38 -> 150
        //   115: aload_0
        //   116: getfield 84	com/flurry/sdk/en:m	Ljava/net/HttpURLConnection;
        //   119: instanceof 193
        //   122: ifeq +28 -> 150
        //   125: aload_0
        //   126: getfield 84	com/flurry/sdk/en:m	Ljava/net/HttpURLConnection;
        //   129: checkcast 193	javax/net/ssl/HttpsURLConnection
        //   132: astore_2
        //   133: aload_2
        //   134: invokestatic 195	com/flurry/sdk/en:n	()Ljavax/net/ssl/HostnameVerifier;
        //   137: invokevirtual 199	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
        //   140: aload_2
        //   141: invokestatic 201	com/flurry/sdk/en:m	()Ljavax/net/ssl/SSLContext;
        //   144: invokevirtual 205	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
        //   147: invokevirtual 209	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
        //   150: aload_0
        //   151: getfield 72	com/flurry/sdk/en:k	Lcom/flurry/sdk/ds;
        //   154: invokevirtual 212	com/flurry/sdk/ds:b	()Ljava/util/Collection;
        //   157: invokeinterface 218 1 0
        //   162: astore_2
        //   163: aload_2
        //   164: invokeinterface 223 1 0
        //   169: ifeq +48 -> 217
        //   172: aload_2
        //   173: invokeinterface 227 1 0
        //   178: checkcast 229	java/util/Map$Entry
        //   181: astore_3
        //   182: aload_0
        //   183: getfield 84	com/flurry/sdk/en:m	Ljava/net/HttpURLConnection;
        //   186: aload_3
        //   187: invokeinterface 232 1 0
        //   192: checkcast 234	java/lang/String
        //   195: aload_3
        //   196: invokeinterface 237 1 0
        //   201: checkcast 234	java/lang/String
        //   204: invokevirtual 241	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   207: goto -44 -> 163
        //   210: astore_2
        //   211: aload_0
        //   212: invokespecial 243	com/flurry/sdk/en:r	()V
        //   215: aload_2
        //   216: athrow
        //   217: getstatic 245	com/flurry/sdk/en$a:b	Lcom/flurry/sdk/en$a;
        //   220: aload_0
        //   221: getfield 167	com/flurry/sdk/en:e	Lcom/flurry/sdk/en$a;
        //   224: invokevirtual 183	com/flurry/sdk/en$a:equals	(Ljava/lang/Object;)Z
        //   227: ifne +27 -> 254
        //   230: getstatic 179	com/flurry/sdk/en$a:c	Lcom/flurry/sdk/en$a;
        //   233: aload_0
        //   234: getfield 167	com/flurry/sdk/en:e	Lcom/flurry/sdk/en$a;
        //   237: invokevirtual 183	com/flurry/sdk/en$a:equals	(Ljava/lang/Object;)Z
        //   240: ifne +14 -> 254
        //   243: aload_0
        //   244: getfield 84	com/flurry/sdk/en:m	Ljava/net/HttpURLConnection;
        //   247: ldc -9
        //   249: ldc -7
        //   251: invokevirtual 252	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   254: aload_0
        //   255: getfield 145	com/flurry/sdk/en:p	Z
        //   258: istore_1
        //   259: iload_1
        //   260: ifeq +8 -> 268
        //   263: aload_0
        //   264: invokespecial 243	com/flurry/sdk/en:r	()V
        //   267: return
        //   268: getstatic 179	com/flurry/sdk/en$a:c	Lcom/flurry/sdk/en$a;
        //   271: aload_0
        //   272: getfield 167	com/flurry/sdk/en:e	Lcom/flurry/sdk/en$a;
        //   275: invokevirtual 183	com/flurry/sdk/en$a:equals	(Ljava/lang/Object;)Z
        //   278: istore_1
        //   279: iload_1
        //   280: ifeq +33 -> 313
        //   283: aload_0
        //   284: getfield 84	com/flurry/sdk/en:m	Ljava/net/HttpURLConnection;
        //   287: invokevirtual 256	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   290: astore_2
        //   291: new 258	java/io/BufferedOutputStream
        //   294: dup
        //   295: aload_2
        //   296: invokespecial 260	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   299: astore_3
        //   300: aload_0
        //   301: aload_3
        //   302: invokespecial 90	com/flurry/sdk/en:a	(Ljava/io/OutputStream;)V
        //   305: aload_3
        //   306: invokestatic 265	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   309: aload_2
        //   310: invokestatic 265	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   313: aload_0
        //   314: aload_0
        //   315: getfield 84	com/flurry/sdk/en:m	Ljava/net/HttpURLConnection;
        //   318: invokevirtual 269	java/net/HttpURLConnection:getResponseCode	()I
        //   321: putfield 74	com/flurry/sdk/en:r	I
        //   324: aload_0
        //   325: getfield 84	com/flurry/sdk/en:m	Ljava/net/HttpURLConnection;
        //   328: invokevirtual 273	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
        //   331: invokeinterface 279 1 0
        //   336: invokeinterface 218 1 0
        //   341: astore_2
        //   342: aload_2
        //   343: invokeinterface 223 1 0
        //   348: ifeq +80 -> 428
        //   351: aload_2
        //   352: invokeinterface 227 1 0
        //   357: checkcast 229	java/util/Map$Entry
        //   360: astore_3
        //   361: aload_3
        //   362: invokeinterface 237 1 0
        //   367: checkcast 281	java/util/List
        //   370: invokeinterface 282 1 0
        //   375: astore 5
        //   377: aload 5
        //   379: invokeinterface 223 1 0
        //   384: ifeq -42 -> 342
        //   387: aload 5
        //   389: invokeinterface 227 1 0
        //   394: checkcast 234	java/lang/String
        //   397: astore 6
        //   399: aload_0
        //   400: getfield 76	com/flurry/sdk/en:s	Lcom/flurry/sdk/ds;
        //   403: aload_3
        //   404: invokeinterface 232 1 0
        //   409: aload 6
        //   411: invokevirtual 285	com/flurry/sdk/ds:a	(Ljava/lang/Object;Ljava/lang/Object;)V
        //   414: goto -37 -> 377
        //   417: aload_3
        //   418: invokestatic 265	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   421: aload 4
        //   423: invokestatic 265	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   426: aload_2
        //   427: athrow
        //   428: getstatic 245	com/flurry/sdk/en$a:b	Lcom/flurry/sdk/en$a;
        //   431: aload_0
        //   432: getfield 167	com/flurry/sdk/en:e	Lcom/flurry/sdk/en$a;
        //   435: invokevirtual 183	com/flurry/sdk/en$a:equals	(Ljava/lang/Object;)Z
        //   438: ifne +23 -> 461
        //   441: getstatic 179	com/flurry/sdk/en$a:c	Lcom/flurry/sdk/en$a;
        //   444: aload_0
        //   445: getfield 167	com/flurry/sdk/en:e	Lcom/flurry/sdk/en$a;
        //   448: invokevirtual 183	com/flurry/sdk/en$a:equals	(Ljava/lang/Object;)Z
        //   451: istore_1
        //   452: iload_1
        //   453: ifne +8 -> 461
        //   456: aload_0
        //   457: invokespecial 243	com/flurry/sdk/en:r	()V
        //   460: return
        //   461: aload_0
        //   462: getfield 145	com/flurry/sdk/en:p	Z
        //   465: istore_1
        //   466: iload_1
        //   467: ifeq +8 -> 475
        //   470: aload_0
        //   471: invokespecial 243	com/flurry/sdk/en:r	()V
        //   474: return
        //   475: aload_0
        //   476: getfield 84	com/flurry/sdk/en:m	Ljava/net/HttpURLConnection;
        //   479: invokevirtual 289	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   482: astore_2
        //   483: new 291	java/io/BufferedInputStream
        //   486: dup
        //   487: aload_2
        //   488: invokespecial 293	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   491: astore_3
        //   492: aload_0
        //   493: aload_3
        //   494: invokespecial 295	com/flurry/sdk/en:a	(Ljava/io/InputStream;)V
        //   497: aload_3
        //   498: invokestatic 265	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   501: aload_2
        //   502: invokestatic 265	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   505: aload_0
        //   506: invokespecial 243	com/flurry/sdk/en:r	()V
        //   509: return
        //   510: astore_2
        //   511: aconst_null
        //   512: astore_3
        //   513: aload 4
        //   515: invokestatic 265	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   518: aload_3
        //   519: invokestatic 265	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   522: aload_2
        //   523: athrow
        //   524: astore 5
        //   526: aload_2
        //   527: astore_3
        //   528: aload 5
        //   530: astore_2
        //   531: goto -18 -> 513
        //   534: astore 5
        //   536: aload_3
        //   537: astore 4
        //   539: aload_2
        //   540: astore_3
        //   541: aload 5
        //   543: astore_2
        //   544: goto -31 -> 513
        //   547: astore 5
        //   549: aconst_null
        //   550: astore_3
        //   551: aload_2
        //   552: astore 4
        //   554: aload 5
        //   556: astore_2
        //   557: goto -140 -> 417
        //   560: astore 5
        //   562: aload_2
        //   563: astore 4
        //   565: aload 5
        //   567: astore_2
        //   568: goto -151 -> 417
        //   571: astore_2
        //   572: aconst_null
        //   573: astore_3
        //   574: aload 5
        //   576: astore 4
        //   578: goto -161 -> 417
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	581	0	this	en
        //   258	209	1	bool	boolean
        //   25	148	2	localObject1	Object
        //   210	6	2	localObject2	Object
        //   290	212	2	localObject3	Object
        //   510	17	2	localObject4	Object
        //   530	38	2	localObject5	Object
        //   571	1	2	localObject6	Object
        //   181	393	3	localObject7	Object
        //   1	576	4	localObject8	Object
        //   4	384	5	localIterator	java.util.Iterator
        //   524	5	5	localObject9	Object
        //   534	8	5	localObject10	Object
        //   547	8	5	localObject11	Object
        //   560	15	5	localObject12	Object
        //   397	13	6	str	String
        // Exception table:
        //   from	to	target	type
        //   26	150	210	finally
        //   150	163	210	finally
        //   163	207	210	finally
        //   217	254	210	finally
        //   254	259	210	finally
        //   268	279	210	finally
        //   305	313	210	finally
        //   313	342	210	finally
        //   342	377	210	finally
        //   377	414	210	finally
        //   417	428	210	finally
        //   428	452	210	finally
        //   461	466	210	finally
        //   497	505	210	finally
        //   513	524	210	finally
        //   475	483	510	finally
        //   483	492	524	finally
        //   492	497	534	finally
        //   291	300	547	finally
        //   300	305	560	finally
        //   283	291	571	finally
    }

    /* Error */
    private void p()
            throws Exception {
        // Byte code:
        //   0: aconst_null
        //   1: astore 8
        //   3: aload_0
        //   4: getfield 145	com/flurry/sdk/en:p	Z
        //   7: ifeq +4 -> 11
        //   10: return
        //   11: aload_0
        //   12: getfield 167	com/flurry/sdk/en:e	Lcom/flurry/sdk/en$a;
        //   15: aload_0
        //   16: getfield 149	com/flurry/sdk/en:d	Ljava/lang/String;
        //   19: invokevirtual 298	com/flurry/sdk/en$a:a	(Ljava/lang/String;)Lorg/apache/http/client/methods/HttpRequestBase;
        //   22: astore 6
        //   24: aload_0
        //   25: getfield 72	com/flurry/sdk/en:k	Lcom/flurry/sdk/ds;
        //   28: invokevirtual 212	com/flurry/sdk/ds:b	()Ljava/util/Collection;
        //   31: invokeinterface 218 1 0
        //   36: astore 7
        //   38: aload 7
        //   40: invokeinterface 223 1 0
        //   45: ifeq +43 -> 88
        //   48: aload 7
        //   50: invokeinterface 227 1 0
        //   55: checkcast 229	java/util/Map$Entry
        //   58: astore 9
        //   60: aload 6
        //   62: aload 9
        //   64: invokeinterface 232 1 0
        //   69: checkcast 234	java/lang/String
        //   72: aload 9
        //   74: invokeinterface 237 1 0
        //   79: checkcast 234	java/lang/String
        //   82: invokevirtual 303	org/apache/http/client/methods/HttpRequestBase:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
        //   85: goto -47 -> 38
        //   88: getstatic 245	com/flurry/sdk/en$a:b	Lcom/flurry/sdk/en$a;
        //   91: aload_0
        //   92: getfield 167	com/flurry/sdk/en:e	Lcom/flurry/sdk/en$a;
        //   95: invokevirtual 183	com/flurry/sdk/en$a:equals	(Ljava/lang/Object;)Z
        //   98: ifne +23 -> 121
        //   101: getstatic 179	com/flurry/sdk/en$a:c	Lcom/flurry/sdk/en$a;
        //   104: aload_0
        //   105: getfield 167	com/flurry/sdk/en:e	Lcom/flurry/sdk/en$a;
        //   108: invokevirtual 183	com/flurry/sdk/en$a:equals	(Ljava/lang/Object;)Z
        //   111: ifne +10 -> 121
        //   114: aload 6
        //   116: ldc -9
        //   118: invokevirtual 306	org/apache/http/client/methods/HttpRequestBase:removeHeaders	(Ljava/lang/String;)V
        //   121: getstatic 179	com/flurry/sdk/en$a:c	Lcom/flurry/sdk/en$a;
        //   124: aload_0
        //   125: getfield 167	com/flurry/sdk/en:e	Lcom/flurry/sdk/en$a;
        //   128: invokevirtual 183	com/flurry/sdk/en$a:equals	(Ljava/lang/Object;)Z
        //   131: ifeq +19 -> 150
        //   134: aload 6
        //   136: checkcast 308	org/apache/http/client/methods/HttpPost
        //   139: new 6	com/flurry/sdk/en$1
        //   142: dup
        //   143: aload_0
        //   144: invokespecial 311	com/flurry/sdk/en$1:<init>	(Lcom/flurry/sdk/en;)V
        //   147: invokevirtual 315	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
        //   150: new 317	org/apache/http/params/BasicHttpParams
        //   153: dup
        //   154: invokespecial 318	org/apache/http/params/BasicHttpParams:<init>	()V
        //   157: astore 7
        //   159: aload 7
        //   161: aload_0
        //   162: getfield 63	com/flurry/sdk/en:f	I
        //   165: invokestatic 324	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
        //   168: aload 7
        //   170: aload_0
        //   171: getfield 65	com/flurry/sdk/en:i	I
        //   174: invokestatic 327	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
        //   177: aload 7
        //   179: ldc_w 329
        //   182: aload_0
        //   183: getfield 67	com/flurry/sdk/en:j	Z
        //   186: invokestatic 335	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   189: invokeinterface 341 3 0
        //   194: pop
        //   195: aload_0
        //   196: aload 7
        //   198: invokestatic 346	com/flurry/sdk/ek:a	(Lorg/apache/http/params/HttpParams;)Lorg/apache/http/client/HttpClient;
        //   201: putfield 105	com/flurry/sdk/en:n	Lorg/apache/http/client/HttpClient;
        //   204: aload_0
        //   205: getfield 105	com/flurry/sdk/en:n	Lorg/apache/http/client/HttpClient;
        //   208: aload 6
        //   210: invokeinterface 352 2 0
        //   215: astore 6
        //   217: aload_0
        //   218: getfield 145	com/flurry/sdk/en:p	Z
        //   221: ifeq +23 -> 244
        //   224: new 87	java/lang/Exception
        //   227: dup
        //   228: ldc_w 354
        //   231: invokespecial 355	java/lang/Exception:<init>	(Ljava/lang/String;)V
        //   234: athrow
        //   235: astore 6
        //   237: aload_0
        //   238: invokespecial 243	com/flurry/sdk/en:r	()V
        //   241: aload 6
        //   243: athrow
        //   244: aload 6
        //   246: ifnull +205 -> 451
        //   249: aload_0
        //   250: aload 6
        //   252: invokeinterface 361 1 0
        //   257: invokeinterface 366 1 0
        //   262: putfield 74	com/flurry/sdk/en:r	I
        //   265: aload 6
        //   267: invokeinterface 370 1 0
        //   272: astore 7
        //   274: aload 7
        //   276: ifnull +72 -> 348
        //   279: aload 7
        //   281: arraylength
        //   282: istore_3
        //   283: iconst_0
        //   284: istore_1
        //   285: iload_1
        //   286: iload_3
        //   287: if_icmpge +61 -> 348
        //   290: aload 7
        //   292: iload_1
        //   293: aaload
        //   294: invokeinterface 376 1 0
        //   299: astore 9
        //   301: aload 9
        //   303: arraylength
        //   304: istore 4
        //   306: iconst_0
        //   307: istore_2
        //   308: iload_2
        //   309: iload 4
        //   311: if_icmpge +192 -> 503
        //   314: aload 9
        //   316: iload_2
        //   317: aaload
        //   318: astore 10
        //   320: aload_0
        //   321: getfield 76	com/flurry/sdk/en:s	Lcom/flurry/sdk/ds;
        //   324: aload 10
        //   326: invokeinterface 381 1 0
        //   331: aload 10
        //   333: invokeinterface 383 1 0
        //   338: invokevirtual 285	com/flurry/sdk/ds:a	(Ljava/lang/Object;Ljava/lang/Object;)V
        //   341: iload_2
        //   342: iconst_1
        //   343: iadd
        //   344: istore_2
        //   345: goto -37 -> 308
        //   348: getstatic 245	com/flurry/sdk/en$a:b	Lcom/flurry/sdk/en$a;
        //   351: aload_0
        //   352: getfield 167	com/flurry/sdk/en:e	Lcom/flurry/sdk/en$a;
        //   355: invokevirtual 183	com/flurry/sdk/en$a:equals	(Ljava/lang/Object;)Z
        //   358: ifne +25 -> 383
        //   361: getstatic 179	com/flurry/sdk/en$a:c	Lcom/flurry/sdk/en$a;
        //   364: aload_0
        //   365: getfield 167	com/flurry/sdk/en:e	Lcom/flurry/sdk/en$a;
        //   368: invokevirtual 183	com/flurry/sdk/en$a:equals	(Ljava/lang/Object;)Z
        //   371: istore 5
        //   373: iload 5
        //   375: ifne +8 -> 383
        //   378: aload_0
        //   379: invokespecial 243	com/flurry/sdk/en:r	()V
        //   382: return
        //   383: aload_0
        //   384: getfield 145	com/flurry/sdk/en:p	Z
        //   387: ifeq +14 -> 401
        //   390: new 87	java/lang/Exception
        //   393: dup
        //   394: ldc_w 354
        //   397: invokespecial 355	java/lang/Exception:<init>	(Ljava/lang/String;)V
        //   400: athrow
        //   401: aload 6
        //   403: invokeinterface 387 1 0
        //   408: astore 6
        //   410: aload 6
        //   412: ifnull +39 -> 451
        //   415: aload 6
        //   417: invokeinterface 392 1 0
        //   422: astore 6
        //   424: new 291	java/io/BufferedInputStream
        //   427: dup
        //   428: aload 6
        //   430: invokespecial 293	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   433: astore 7
        //   435: aload_0
        //   436: aload 7
        //   438: invokespecial 295	com/flurry/sdk/en:a	(Ljava/io/InputStream;)V
        //   441: aload 7
        //   443: invokestatic 265	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   446: aload 6
        //   448: invokestatic 265	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   451: aload_0
        //   452: invokespecial 243	com/flurry/sdk/en:r	()V
        //   455: return
        //   456: astore 6
        //   458: aconst_null
        //   459: astore 7
        //   461: aload 7
        //   463: invokestatic 265	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   466: aload 8
        //   468: invokestatic 265	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   471: aload 6
        //   473: athrow
        //   474: astore 9
        //   476: aconst_null
        //   477: astore 7
        //   479: aload 6
        //   481: astore 8
        //   483: aload 9
        //   485: astore 6
        //   487: goto -26 -> 461
        //   490: astore 9
        //   492: aload 6
        //   494: astore 8
        //   496: aload 9
        //   498: astore 6
        //   500: goto -39 -> 461
        //   503: iload_1
        //   504: iconst_1
        //   505: iadd
        //   506: istore_1
        //   507: goto -222 -> 285
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	510	0	this	en
        //   284	223	1	i1	int
        //   307	38	2	i2	int
        //   282	6	3	i3	int
        //   304	8	4	i4	int
        //   371	3	5	bool	boolean
        //   22	194	6	localObject1	Object
        //   235	167	6	localObject2	Object
        //   408	39	6	localObject3	Object
        //   456	24	6	localObject4	Object
        //   485	14	6	localObject5	Object
        //   36	442	7	localObject6	Object
        //   1	494	8	localObject7	Object
        //   58	257	9	localObject8	Object
        //   474	10	9	localObject9	Object
        //   490	7	9	localObject10	Object
        //   318	14	10	localObject11	Object
        // Exception table:
        //   from	to	target	type
        //   150	235	235	finally
        //   249	274	235	finally
        //   279	283	235	finally
        //   290	306	235	finally
        //   320	341	235	finally
        //   348	373	235	finally
        //   383	401	235	finally
        //   401	410	235	finally
        //   441	451	235	finally
        //   461	474	235	finally
        //   415	424	456	finally
        //   424	435	474	finally
        //   435	441	490	finally
    }

    private void q() {
        if (this.l == null) {
        }
        while (b()) {
            return;
        }
        this.l.a(this);
    }

    private void r() {
        if (this.o) {
        }
        do {
            return;
            this.o = true;
            if (this.m != null) {
                this.m.disconnect();
            }
        } while (this.n == null);
        this.n.getConnectionManager().shutdown();
    }

    private void s() {
        if (this.o) {
        }
        do {
            return;
            this.o = true;
        } while ((this.m == null) && (this.n == null));
        new Thread() {
            public void run() {
                if (en.a(en.this) != null) {
                    en.a(en.this).disconnect();
                }
                if (en.b(en.this) != null) {
                    en.b(en.this).getConnectionManager().shutdown();
                }
            }
        }.start();
    }

    /* Error */
    public void a() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 149	com/flurry/sdk/en:d	Ljava/lang/String;
        //   4: astore_1
        //   5: aload_1
        //   6: ifnonnull +8 -> 14
        //   9: aload_0
        //   10: invokespecial 416	com/flurry/sdk/en:q	()V
        //   13: return
        //   14: invokestatic 421	com/flurry/sdk/ev:a	()Lcom/flurry/sdk/ev;
        //   17: invokevirtual 423	com/flurry/sdk/ev:c	()Z
        //   20: ifne +38 -> 58
        //   23: iconst_3
        //   24: getstatic 57	com/flurry/sdk/en:a	Ljava/lang/String;
        //   27: new 425	java/lang/StringBuilder
        //   30: dup
        //   31: invokespecial 426	java/lang/StringBuilder:<init>	()V
        //   34: ldc_w 428
        //   37: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   40: aload_0
        //   41: getfield 149	com/flurry/sdk/en:d	Ljava/lang/String;
        //   44: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   47: invokevirtual 433	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   50: invokestatic 436	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   53: aload_0
        //   54: invokespecial 416	com/flurry/sdk/en:q	()V
        //   57: return
        //   58: aload_0
        //   59: getfield 167	com/flurry/sdk/en:e	Lcom/flurry/sdk/en$a;
        //   62: ifnull +16 -> 78
        //   65: getstatic 438	com/flurry/sdk/en$a:a	Lcom/flurry/sdk/en$a;
        //   68: aload_0
        //   69: getfield 167	com/flurry/sdk/en:e	Lcom/flurry/sdk/en$a;
        //   72: invokevirtual 183	com/flurry/sdk/en$a:equals	(Ljava/lang/Object;)Z
        //   75: ifeq +10 -> 85
        //   78: aload_0
        //   79: getstatic 245	com/flurry/sdk/en$a:b	Lcom/flurry/sdk/en$a;
        //   82: putfield 167	com/flurry/sdk/en:e	Lcom/flurry/sdk/en$a;
        //   85: getstatic 443	android/os/Build$VERSION:SDK_INT	I
        //   88: bipush 9
        //   90: if_icmplt +55 -> 145
        //   93: aload_0
        //   94: invokespecial 445	com/flurry/sdk/en:o	()V
        //   97: iconst_4
        //   98: getstatic 57	com/flurry/sdk/en:a	Ljava/lang/String;
        //   101: new 425	java/lang/StringBuilder
        //   104: dup
        //   105: invokespecial 426	java/lang/StringBuilder:<init>	()V
        //   108: ldc_w 447
        //   111: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   114: aload_0
        //   115: getfield 74	com/flurry/sdk/en:r	I
        //   118: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   121: ldc_w 452
        //   124: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   127: aload_0
        //   128: getfield 149	com/flurry/sdk/en:d	Ljava/lang/String;
        //   131: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   134: invokevirtual 433	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   137: invokestatic 436	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   140: aload_0
        //   141: invokespecial 416	com/flurry/sdk/en:q	()V
        //   144: return
        //   145: aload_0
        //   146: invokespecial 454	com/flurry/sdk/en:p	()V
        //   149: goto -52 -> 97
        //   152: astore_1
        //   153: iconst_4
        //   154: getstatic 57	com/flurry/sdk/en:a	Ljava/lang/String;
        //   157: new 425	java/lang/StringBuilder
        //   160: dup
        //   161: invokespecial 426	java/lang/StringBuilder:<init>	()V
        //   164: ldc_w 447
        //   167: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   170: aload_0
        //   171: getfield 74	com/flurry/sdk/en:r	I
        //   174: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   177: ldc_w 452
        //   180: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   183: aload_0
        //   184: getfield 149	com/flurry/sdk/en:d	Ljava/lang/String;
        //   187: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   190: invokevirtual 433	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   193: invokestatic 436	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   196: iconst_3
        //   197: getstatic 57	com/flurry/sdk/en:a	Ljava/lang/String;
        //   200: new 425	java/lang/StringBuilder
        //   203: dup
        //   204: invokespecial 426	java/lang/StringBuilder:<init>	()V
        //   207: ldc_w 456
        //   210: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   213: aload_0
        //   214: getfield 149	com/flurry/sdk/en:d	Ljava/lang/String;
        //   217: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   220: invokevirtual 433	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   223: aload_1
        //   224: invokestatic 137	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   227: aload_0
        //   228: aload_1
        //   229: putfield 458	com/flurry/sdk/en:q	Ljava/lang/Exception;
        //   232: aload_0
        //   233: invokespecial 416	com/flurry/sdk/en:q	()V
        //   236: return
        //   237: astore_1
        //   238: aload_0
        //   239: invokespecial 416	com/flurry/sdk/en:q	()V
        //   242: aload_1
        //   243: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	244	0	this	en
        //   4	2	1	str	String
        //   152	77	1	localException	Exception
        //   237	6	1	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   0	5	152	java/lang/Exception
        //   14	53	152	java/lang/Exception
        //   58	78	152	java/lang/Exception
        //   78	85	152	java/lang/Exception
        //   85	97	152	java/lang/Exception
        //   97	140	152	java/lang/Exception
        //   145	149	152	java/lang/Exception
        //   0	5	237	finally
        //   14	53	237	finally
        //   58	78	237	finally
        //   78	85	237	finally
        //   85	97	237	finally
        //   97	140	237	finally
        //   145	149	237	finally
        //   153	232	237	finally
    }

    public void a(a parama) {
        this.e = parama;
    }

    public void a(c paramc) {
        this.l = paramc;
    }

    public void a(String paramString) {
        this.d = paramString;
    }

    public void a(String paramString1, String paramString2) {
        this.k.a(paramString1, paramString2);
    }

    public void a(boolean paramBoolean) {
        this.j = paramBoolean;
    }

    public List<String> b(String paramString) {
        if (paramString == null) {
            return null;
        }
        return this.s.a(paramString);
    }

    public boolean b() {
        synchronized (this.t) {
            boolean bool = this.p;
            return bool;
        }
    }

    public boolean c() {
        return (!f()) && (d());
    }

    public boolean d() {
        return (this.r >= 200) && (this.r < 400);
    }

    public int e() {
        return this.r;
    }

    public boolean f() {
        return this.q != null;
    }

    public void g() {
        synchronized (this.t) {
            this.p = true;
            s();
            return;
        }
    }

    public void h() {
        g();
    }

    public static enum a {
        private a() {
        }

        public HttpRequestBase a(String paramString) {
            switch (en .3.a[ordinal()])
            {
                default:
                    return null;
                case 1:
                    return new HttpPost(paramString);
                case 2:
                    return new HttpPut(paramString);
                case 3:
                    return new HttpDelete(paramString);
                case 4:
                    return new HttpHead(paramString);
            }
            return new HttpGet(paramString);
        }

        public String toString() {
            switch (en .3.a[ordinal()])
            {
                default:
                    return null;
                case 1:
                    return "POST";
                case 2:
                    return "PUT";
                case 3:
                    return "DELETE";
                case 4:
                    return "HEAD";
            }
            return "GET";
        }
    }

    public static class b
            implements en.c {
        public void a(en paramen) {
        }

        public void a(en paramen, InputStream paramInputStream)
                throws Exception {
        }

        public void a(en paramen, OutputStream paramOutputStream)
                throws Exception {
        }
    }

    public static abstract interface c {
        public abstract void a(en paramen);

        public abstract void a(en paramen, InputStream paramInputStream)
                throws Exception;

        public abstract void a(en paramen, OutputStream paramOutputStream)
                throws Exception;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/en.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */