package com.google.api.client.googleapis.json;

import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpResponseException.a;

public class GoogleJsonResponseException
  extends HttpResponseException
{
  private static final long serialVersionUID = 409811126989994864L;
  private final transient a ZL;
  
  GoogleJsonResponseException(HttpResponseException.a parama, a parama1)
  {
    super(parama);
    this.ZL = parama1;
  }
  
  /* Error */
  public static GoogleJsonResponseException a(com.google.api.client.json.d paramd, com.google.api.client.http.t paramt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore 5
    //   7: new 24	com/google/api/client/http/HttpResponseException$a
    //   10: dup
    //   11: aload_1
    //   12: invokevirtual 30	com/google/api/client/http/t:getStatusCode	()I
    //   15: aload_1
    //   16: invokevirtual 34	com/google/api/client/http/t:xM	()Ljava/lang/String;
    //   19: aload_1
    //   20: invokevirtual 38	com/google/api/client/http/t:xC	()Lcom/google/api/client/http/n;
    //   23: invokespecial 41	com/google/api/client/http/HttpResponseException$a:<init>	(ILjava/lang/String;Lcom/google/api/client/http/n;)V
    //   26: astore 6
    //   28: aload_0
    //   29: invokestatic 47	com/google/api/client/util/x:ad	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: pop
    //   33: aload_1
    //   34: invokevirtual 51	com/google/api/client/http/t:xL	()Z
    //   37: ifne +278 -> 315
    //   40: getstatic 57	com/google/api/client/json/c:MEDIA_TYPE	Ljava/lang/String;
    //   43: aload_1
    //   44: invokevirtual 60	com/google/api/client/http/t:getContentType	()Ljava/lang/String;
    //   47: invokestatic 66	com/google/api/client/http/p:k	(Ljava/lang/String;Ljava/lang/String;)Z
    //   50: ifeq +265 -> 315
    //   53: aload_1
    //   54: invokevirtual 70	com/google/api/client/http/t:getContent	()Ljava/io/InputStream;
    //   57: astore 4
    //   59: aload 4
    //   61: ifnull +254 -> 315
    //   64: aload_0
    //   65: aload_1
    //   66: invokevirtual 70	com/google/api/client/http/t:getContent	()Ljava/io/InputStream;
    //   69: invokevirtual 76	com/google/api/client/json/d:b	(Ljava/io/InputStream;)Lcom/google/api/client/json/g;
    //   72: astore_3
    //   73: aload_3
    //   74: invokevirtual 82	com/google/api/client/json/g:yn	()Lcom/google/api/client/json/JsonToken;
    //   77: astore_2
    //   78: aload_2
    //   79: astore_0
    //   80: aload_2
    //   81: ifnonnull +8 -> 89
    //   84: aload_3
    //   85: invokevirtual 85	com/google/api/client/json/g:ym	()Lcom/google/api/client/json/JsonToken;
    //   88: astore_0
    //   89: aload_0
    //   90: ifnull +287 -> 377
    //   93: aload_3
    //   94: ldc 87
    //   96: invokevirtual 91	com/google/api/client/json/g:cq	(Ljava/lang/String;)V
    //   99: aload_3
    //   100: invokevirtual 82	com/google/api/client/json/g:yn	()Lcom/google/api/client/json/JsonToken;
    //   103: getstatic 97	com/google/api/client/json/JsonToken:acx	Lcom/google/api/client/json/JsonToken;
    //   106: if_acmpeq +271 -> 377
    //   109: aload_3
    //   110: ldc 99
    //   112: invokevirtual 103	com/google/api/client/json/g:g	(Ljava/lang/Class;)Ljava/lang/Object;
    //   115: checkcast 99	com/google/api/client/googleapis/json/a
    //   118: astore_0
    //   119: aload_0
    //   120: astore 4
    //   122: aload_3
    //   123: astore_2
    //   124: aload_0
    //   125: invokevirtual 106	com/google/api/client/googleapis/json/a:toPrettyString	()Ljava/lang/String;
    //   128: astore 5
    //   130: aload 5
    //   132: astore 4
    //   134: aload_0
    //   135: astore 5
    //   137: aload_3
    //   138: ifnonnull +65 -> 203
    //   141: aload_1
    //   142: invokevirtual 110	com/google/api/client/http/t:xO	()V
    //   145: aload 5
    //   147: astore_2
    //   148: aload 4
    //   150: astore_0
    //   151: aload_1
    //   152: invokestatic 114	com/google/api/client/http/HttpResponseException:d	(Lcom/google/api/client/http/t;)Ljava/lang/StringBuilder;
    //   155: astore_1
    //   156: aload_0
    //   157: invokestatic 120	com/google/api/client/util/ac:cr	(Ljava/lang/String;)Z
    //   160: ifne +22 -> 182
    //   163: aload_1
    //   164: getstatic 125	com/google/api/client/util/ab:aeg	Ljava/lang/String;
    //   167: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_0
    //   171: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 6
    //   177: aload_0
    //   178: invokevirtual 135	com/google/api/client/http/HttpResponseException$a:ci	(Ljava/lang/String;)Lcom/google/api/client/http/HttpResponseException$a;
    //   181: pop
    //   182: aload 6
    //   184: aload_1
    //   185: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokevirtual 141	com/google/api/client/http/HttpResponseException$a:cg	(Ljava/lang/String;)Lcom/google/api/client/http/HttpResponseException$a;
    //   191: pop
    //   192: new 2	com/google/api/client/googleapis/json/GoogleJsonResponseException
    //   195: dup
    //   196: aload 6
    //   198: aload_2
    //   199: invokespecial 143	com/google/api/client/googleapis/json/GoogleJsonResponseException:<init>	(Lcom/google/api/client/http/HttpResponseException$a;Lcom/google/api/client/googleapis/json/a;)V
    //   202: areturn
    //   203: aload 4
    //   205: astore_0
    //   206: aload 5
    //   208: astore_2
    //   209: aload 5
    //   211: ifnonnull -60 -> 151
    //   214: aload_3
    //   215: invokevirtual 146	com/google/api/client/json/g:close	()V
    //   218: aload 4
    //   220: astore_0
    //   221: aload 5
    //   223: astore_2
    //   224: goto -73 -> 151
    //   227: astore_3
    //   228: aload 5
    //   230: astore_2
    //   231: aload 4
    //   233: astore_0
    //   234: aload_3
    //   235: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   238: goto -87 -> 151
    //   241: astore 5
    //   243: aconst_null
    //   244: astore_3
    //   245: aconst_null
    //   246: astore_0
    //   247: aload_0
    //   248: astore 4
    //   250: aload_3
    //   251: astore_2
    //   252: aload 5
    //   254: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   257: aload_3
    //   258: ifnonnull +14 -> 272
    //   261: aload_1
    //   262: invokevirtual 110	com/google/api/client/http/t:xO	()V
    //   265: aload_0
    //   266: astore_2
    //   267: aconst_null
    //   268: astore_0
    //   269: goto -118 -> 151
    //   272: aload_0
    //   273: ifnonnull +97 -> 370
    //   276: aload_3
    //   277: invokevirtual 146	com/google/api/client/json/g:close	()V
    //   280: aload_0
    //   281: astore_2
    //   282: aconst_null
    //   283: astore_0
    //   284: goto -133 -> 151
    //   287: astore 4
    //   289: aconst_null
    //   290: astore_2
    //   291: aconst_null
    //   292: astore_0
    //   293: aload_2
    //   294: ifnonnull +10 -> 304
    //   297: aload_1
    //   298: invokevirtual 110	com/google/api/client/http/t:xO	()V
    //   301: aload 4
    //   303: athrow
    //   304: aload_0
    //   305: ifnonnull -4 -> 301
    //   308: aload_2
    //   309: invokevirtual 146	com/google/api/client/json/g:close	()V
    //   312: goto -11 -> 301
    //   315: aload_1
    //   316: invokevirtual 152	com/google/api/client/http/t:xQ	()Ljava/lang/String;
    //   319: astore_0
    //   320: aload_3
    //   321: astore_2
    //   322: goto -171 -> 151
    //   325: astore_3
    //   326: aconst_null
    //   327: astore_0
    //   328: goto -94 -> 234
    //   331: astore_3
    //   332: aload_0
    //   333: astore_2
    //   334: aconst_null
    //   335: astore_0
    //   336: goto -102 -> 234
    //   339: astore 4
    //   341: aconst_null
    //   342: astore_0
    //   343: aload_3
    //   344: astore_2
    //   345: goto -52 -> 293
    //   348: astore_3
    //   349: aload 4
    //   351: astore_0
    //   352: aload_3
    //   353: astore 4
    //   355: goto -62 -> 293
    //   358: astore 5
    //   360: aconst_null
    //   361: astore_0
    //   362: goto -115 -> 247
    //   365: astore 5
    //   367: goto -120 -> 247
    //   370: aload_0
    //   371: astore_2
    //   372: aconst_null
    //   373: astore_0
    //   374: goto -223 -> 151
    //   377: aconst_null
    //   378: astore 4
    //   380: goto -243 -> 137
    //   383: astore_3
    //   384: aconst_null
    //   385: astore 4
    //   387: aload_0
    //   388: astore_2
    //   389: aload 4
    //   391: astore_0
    //   392: goto -158 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	paramd	com.google.api.client.json.d
    //   0	395	1	paramt	com.google.api.client.http.t
    //   3	386	2	localObject1	Object
    //   1	214	3	localg	com.google.api.client.json.g
    //   227	8	3	localIOException1	java.io.IOException
    //   244	77	3	localObject2	Object
    //   325	1	3	localIOException2	java.io.IOException
    //   331	13	3	localIOException3	java.io.IOException
    //   348	5	3	localObject3	Object
    //   383	1	3	localIOException4	java.io.IOException
    //   57	192	4	localObject4	Object
    //   287	15	4	localObject5	Object
    //   339	11	4	localObject6	Object
    //   353	37	4	localObject7	Object
    //   5	224	5	localObject8	Object
    //   241	12	5	localIOException5	java.io.IOException
    //   358	1	5	localIOException6	java.io.IOException
    //   365	1	5	localIOException7	java.io.IOException
    //   26	171	6	locala	HttpResponseException.a
    // Exception table:
    //   from	to	target	type
    //   141	145	227	java/io/IOException
    //   214	218	227	java/io/IOException
    //   64	73	241	java/io/IOException
    //   64	73	287	finally
    //   33	59	325	java/io/IOException
    //   315	320	325	java/io/IOException
    //   261	265	331	java/io/IOException
    //   276	280	331	java/io/IOException
    //   73	78	339	finally
    //   84	89	339	finally
    //   93	119	339	finally
    //   124	130	348	finally
    //   252	257	348	finally
    //   73	78	358	java/io/IOException
    //   84	89	358	java/io/IOException
    //   93	119	358	java/io/IOException
    //   124	130	365	java/io/IOException
    //   297	301	383	java/io/IOException
    //   301	304	383	java/io/IOException
    //   308	312	383	java/io/IOException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/googleapis/json/GoogleJsonResponseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */