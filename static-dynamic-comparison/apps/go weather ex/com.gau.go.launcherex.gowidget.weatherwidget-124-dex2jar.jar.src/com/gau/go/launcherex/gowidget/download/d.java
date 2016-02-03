package com.gau.go.launcherex.gowidget.download;

import android.os.AsyncTask;
import java.io.File;

class d
  extends AsyncTask
{
  private e b;
  
  public d(DownloadService paramDownloadService, e parame)
  {
    this.b = parame;
  }
  
  private int a()
  {
    if (this.b != null)
    {
      if (this.b.h() == 7) {}
      for (;;)
      {
        return 2;
        try
        {
          File localFile1 = new File(this.b.g());
          File localFile2 = localFile1.getParentFile();
          if (!localFile2.exists()) {
            localFile2.mkdirs();
          }
          localFile1.createNewFile();
          if (this.b.e() > 0L)
          {
            this.b.a();
            this.b.c(6);
          }
          boolean bool = a(this.b.c(), localFile1);
          if (bool) {
            return 1;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return 0;
        }
      }
    }
    return -1;
  }
  
  /* Error */
  private java.net.HttpURLConnection a(String paramString)
  {
    // Byte code:
    //   0: new 74	java/net/URL
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 75	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_0
    //   10: getfield 12	com/gau/go/launcherex/gowidget/download/d:a	Lcom/gau/go/launcherex/gowidget/download/DownloadService;
    //   13: invokevirtual 81	com/gau/go/launcherex/gowidget/download/DownloadService:getApplicationContext	()Landroid/content/Context;
    //   16: invokestatic 86	com/gau/go/launcherex/gowidget/download/g:c	(Landroid/content/Context;)Z
    //   19: ifeq +180 -> 199
    //   22: aload_0
    //   23: getfield 12	com/gau/go/launcherex/gowidget/download/d:a	Lcom/gau/go/launcherex/gowidget/download/DownloadService;
    //   26: invokevirtual 81	com/gau/go/launcherex/gowidget/download/DownloadService:getApplicationContext	()Landroid/content/Context;
    //   29: invokestatic 91	com/gau/go/launcherex/gowidget/d/g:b	(Landroid/content/Context;)I
    //   32: iconst_1
    //   33: if_icmpeq +166 -> 199
    //   36: aload_0
    //   37: getfield 12	com/gau/go/launcherex/gowidget/download/d:a	Lcom/gau/go/launcherex/gowidget/download/DownloadService;
    //   40: invokevirtual 81	com/gau/go/launcherex/gowidget/download/DownloadService:getApplicationContext	()Landroid/content/Context;
    //   43: invokestatic 94	com/gau/go/launcherex/gowidget/download/g:a	(Landroid/content/Context;)Ljava/lang/String;
    //   46: astore_3
    //   47: aload_0
    //   48: getfield 12	com/gau/go/launcherex/gowidget/download/d:a	Lcom/gau/go/launcherex/gowidget/download/DownloadService;
    //   51: invokevirtual 81	com/gau/go/launcherex/gowidget/download/DownloadService:getApplicationContext	()Landroid/content/Context;
    //   54: invokestatic 95	com/gau/go/launcherex/gowidget/download/g:b	(Landroid/content/Context;)I
    //   57: istore_2
    //   58: aload_1
    //   59: new 97	java/net/Proxy
    //   62: dup
    //   63: getstatic 103	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   66: new 105	java/net/InetSocketAddress
    //   69: dup
    //   70: aload_3
    //   71: iload_2
    //   72: invokespecial 108	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   75: invokespecial 111	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   78: invokevirtual 115	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   81: checkcast 117	java/net/HttpURLConnection
    //   84: astore 4
    //   86: aload 4
    //   88: astore_1
    //   89: aload 4
    //   91: astore_3
    //   92: aload 4
    //   94: ldc 118
    //   96: invokevirtual 121	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   99: aload 4
    //   101: astore_1
    //   102: aload 4
    //   104: astore_3
    //   105: aload 4
    //   107: ldc 118
    //   109: invokevirtual 124	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   112: aload 4
    //   114: astore_1
    //   115: aload 4
    //   117: astore_3
    //   118: aload 4
    //   120: sipush 4096
    //   123: invokevirtual 127	java/net/HttpURLConnection:setChunkedStreamingMode	(I)V
    //   126: aload 4
    //   128: astore_1
    //   129: aload 4
    //   131: astore_3
    //   132: aload 4
    //   134: ldc -127
    //   136: ldc -125
    //   138: invokevirtual 135	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload 4
    //   143: astore_1
    //   144: aload 4
    //   146: astore_3
    //   147: aload 4
    //   149: ldc -119
    //   151: new 139	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   158: ldc -114
    //   160: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: getfield 17	com/gau/go/launcherex/gowidget/download/d:b	Lcom/gau/go/launcherex/gowidget/download/e;
    //   167: invokevirtual 53	com/gau/go/launcherex/gowidget/download/e:e	()J
    //   170: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   173: ldc -105
    //   175: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokevirtual 135	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload 4
    //   186: astore_1
    //   187: aload 4
    //   189: astore_3
    //   190: aload 4
    //   192: iconst_1
    //   193: invokevirtual 158	java/net/HttpURLConnection:setDoInput	(Z)V
    //   196: aload 4
    //   198: areturn
    //   199: aload_1
    //   200: invokevirtual 161	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   203: checkcast 117	java/net/HttpURLConnection
    //   206: astore 4
    //   208: aload 4
    //   210: astore_1
    //   211: aload 4
    //   213: astore_3
    //   214: aload 4
    //   216: ldc -94
    //   218: invokevirtual 121	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   221: aload 4
    //   223: astore_1
    //   224: aload 4
    //   226: astore_3
    //   227: aload 4
    //   229: ldc -94
    //   231: invokevirtual 124	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   234: goto -108 -> 126
    //   237: astore_3
    //   238: aload_3
    //   239: invokevirtual 163	java/net/MalformedURLException:printStackTrace	()V
    //   242: aload_1
    //   243: areturn
    //   244: astore_1
    //   245: aconst_null
    //   246: astore_3
    //   247: aload_1
    //   248: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   251: aload_3
    //   252: areturn
    //   253: astore_1
    //   254: goto -7 -> 247
    //   257: astore_3
    //   258: aconst_null
    //   259: astore_1
    //   260: goto -22 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	d
    //   0	263	1	paramString	String
    //   57	15	2	i	int
    //   46	181	3	localObject	Object
    //   237	2	3	localMalformedURLException1	java.net.MalformedURLException
    //   246	6	3	localHttpURLConnection1	java.net.HttpURLConnection
    //   257	1	3	localMalformedURLException2	java.net.MalformedURLException
    //   84	144	4	localHttpURLConnection2	java.net.HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   92	99	237	java/net/MalformedURLException
    //   105	112	237	java/net/MalformedURLException
    //   118	126	237	java/net/MalformedURLException
    //   132	141	237	java/net/MalformedURLException
    //   147	184	237	java/net/MalformedURLException
    //   190	196	237	java/net/MalformedURLException
    //   214	221	237	java/net/MalformedURLException
    //   227	234	237	java/net/MalformedURLException
    //   0	86	244	java/io/IOException
    //   199	208	244	java/io/IOException
    //   92	99	253	java/io/IOException
    //   105	112	253	java/io/IOException
    //   118	126	253	java/io/IOException
    //   132	141	253	java/io/IOException
    //   147	184	253	java/io/IOException
    //   190	196	253	java/io/IOException
    //   214	221	253	java/io/IOException
    //   227	234	253	java/io/IOException
    //   0	86	257	java/net/MalformedURLException
    //   199	208	257	java/net/MalformedURLException
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.b != null)
    {
      this.b.b(paramInt1);
      c.a(this.a.getApplicationContext()).a(Long.valueOf(this.b.b()));
      this.b.c(paramInt2);
    }
  }
  
  /* Error */
  private boolean a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 10
    //   12: aload_0
    //   13: getfield 17	com/gau/go/launcherex/gowidget/download/d:b	Lcom/gau/go/launcherex/gowidget/download/e;
    //   16: invokevirtual 53	com/gau/go/launcherex/gowidget/download/e:e	()J
    //   19: lstore 7
    //   21: aload_0
    //   22: aload_1
    //   23: invokespecial 185	com/gau/go/launcherex/gowidget/download/d:a	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnonnull +42 -> 70
    //   31: aload_1
    //   32: ifnull +7 -> 39
    //   35: aload_1
    //   36: invokevirtual 188	java/net/HttpURLConnection:disconnect	()V
    //   39: iconst_0
    //   40: ifeq +11 -> 51
    //   43: new 190	java/lang/NullPointerException
    //   46: dup
    //   47: invokespecial 191	java/lang/NullPointerException:<init>	()V
    //   50: athrow
    //   51: iload 5
    //   53: istore 6
    //   55: iconst_0
    //   56: ifeq +11 -> 67
    //   59: new 190	java/lang/NullPointerException
    //   62: dup
    //   63: invokespecial 191	java/lang/NullPointerException:<init>	()V
    //   66: athrow
    //   67: iload 6
    //   69: ireturn
    //   70: aload_1
    //   71: invokevirtual 194	java/net/HttpURLConnection:getResponseCode	()I
    //   74: invokestatic 199	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   77: ldc -55
    //   79: invokevirtual 205	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   82: ifne +71 -> 153
    //   85: new 21	java/lang/Exception
    //   88: dup
    //   89: ldc -49
    //   91: invokespecial 208	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   94: athrow
    //   95: astore 9
    //   97: aconst_null
    //   98: astore 11
    //   100: aload_1
    //   101: astore_2
    //   102: aload 11
    //   104: astore_1
    //   105: aload 9
    //   107: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   110: aload 9
    //   112: athrow
    //   113: astore 11
    //   115: aload_1
    //   116: astore 9
    //   118: aload_2
    //   119: astore_1
    //   120: aload 11
    //   122: astore_2
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 188	java/net/HttpURLConnection:disconnect	()V
    //   131: aload 9
    //   133: ifnull +8 -> 141
    //   136: aload 9
    //   138: invokevirtual 213	java/io/InputStream:close	()V
    //   141: aload 10
    //   143: ifnull +8 -> 151
    //   146: aload 10
    //   148: invokevirtual 216	java/io/RandomAccessFile:close	()V
    //   151: aload_2
    //   152: athrow
    //   153: aload_1
    //   154: invokevirtual 220	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   157: astore 9
    //   159: aload_1
    //   160: ldc -34
    //   162: invokevirtual 226	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   165: astore 12
    //   167: aload_0
    //   168: getfield 17	com/gau/go/launcherex/gowidget/download/d:b	Lcom/gau/go/launcherex/gowidget/download/e;
    //   171: invokevirtual 229	com/gau/go/launcherex/gowidget/download/e:i	()Ljava/lang/String;
    //   174: astore 13
    //   176: aload 13
    //   178: ifnull +23 -> 201
    //   181: aload 13
    //   183: aload 12
    //   185: invokevirtual 233	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   188: ifne +13 -> 201
    //   191: new 21	java/lang/Exception
    //   194: dup
    //   195: ldc -49
    //   197: invokespecial 208	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   200: athrow
    //   201: aload_0
    //   202: getfield 17	com/gau/go/launcherex/gowidget/download/d:b	Lcom/gau/go/launcherex/gowidget/download/e;
    //   205: aload 12
    //   207: invokevirtual 235	com/gau/go/launcherex/gowidget/download/e:c	(Ljava/lang/String;)V
    //   210: aload_1
    //   211: ldc -19
    //   213: invokevirtual 226	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   216: ifnonnull +13 -> 229
    //   219: new 21	java/lang/Exception
    //   222: dup
    //   223: ldc -49
    //   225: invokespecial 208	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   228: athrow
    //   229: aload_1
    //   230: invokevirtual 240	java/net/HttpURLConnection:getContentLength	()I
    //   233: i2l
    //   234: lload 7
    //   236: ladd
    //   237: l2i
    //   238: istore_3
    //   239: aload_0
    //   240: getfield 17	com/gau/go/launcherex/gowidget/download/d:b	Lcom/gau/go/launcherex/gowidget/download/e;
    //   243: invokevirtual 243	com/gau/go/launcherex/gowidget/download/e:f	()I
    //   246: pop
    //   247: sipush 4096
    //   250: newarray <illegal type>
    //   252: astore 12
    //   254: new 215	java/io/RandomAccessFile
    //   257: dup
    //   258: aload_2
    //   259: ldc -11
    //   261: invokespecial 248	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   264: astore_2
    //   265: aload_2
    //   266: lload 7
    //   268: invokevirtual 252	java/io/RandomAccessFile:seek	(J)V
    //   271: aload_0
    //   272: getfield 17	com/gau/go/launcherex/gowidget/download/d:b	Lcom/gau/go/launcherex/gowidget/download/e;
    //   275: iconst_3
    //   276: invokevirtual 167	com/gau/go/launcherex/gowidget/download/e:b	(I)V
    //   279: aload_0
    //   280: getfield 17	com/gau/go/launcherex/gowidget/download/d:b	Lcom/gau/go/launcherex/gowidget/download/e;
    //   283: invokevirtual 26	com/gau/go/launcherex/gowidget/download/e:h	()I
    //   286: bipush 7
    //   288: if_icmpeq +108 -> 396
    //   291: aload_0
    //   292: getfield 17	com/gau/go/launcherex/gowidget/download/d:b	Lcom/gau/go/launcherex/gowidget/download/e;
    //   295: invokevirtual 26	com/gau/go/launcherex/gowidget/download/e:h	()I
    //   298: bipush 6
    //   300: if_icmpeq +96 -> 396
    //   303: aload 9
    //   305: aload 12
    //   307: invokevirtual 256	java/io/InputStream:read	([B)I
    //   310: istore 4
    //   312: iload 4
    //   314: ifle +82 -> 396
    //   317: aload_2
    //   318: aload 12
    //   320: iconst_0
    //   321: iload 4
    //   323: invokevirtual 260	java/io/RandomAccessFile:write	([BII)V
    //   326: lload 7
    //   328: iload 4
    //   330: i2l
    //   331: ladd
    //   332: lstore 7
    //   334: aload_0
    //   335: getfield 17	com/gau/go/launcherex/gowidget/download/d:b	Lcom/gau/go/launcherex/gowidget/download/e;
    //   338: lload 7
    //   340: invokevirtual 262	com/gau/go/launcherex/gowidget/download/e:a	(J)V
    //   343: lload 7
    //   345: l2i
    //   346: bipush 100
    //   348: imul
    //   349: iload_3
    //   350: idiv
    //   351: istore 4
    //   353: aload_0
    //   354: getfield 17	com/gau/go/launcherex/gowidget/download/d:b	Lcom/gau/go/launcherex/gowidget/download/e;
    //   357: iload 4
    //   359: invokevirtual 264	com/gau/go/launcherex/gowidget/download/e:a	(I)V
    //   362: aload_0
    //   363: getfield 17	com/gau/go/launcherex/gowidget/download/d:b	Lcom/gau/go/launcherex/gowidget/download/e;
    //   366: iconst_2
    //   367: invokevirtual 59	com/gau/go/launcherex/gowidget/download/e:c	(I)V
    //   370: goto -91 -> 279
    //   373: astore 12
    //   375: aload_2
    //   376: astore 10
    //   378: aload 9
    //   380: astore_2
    //   381: aload_1
    //   382: astore 11
    //   384: aload 12
    //   386: astore 9
    //   388: aload_2
    //   389: astore_1
    //   390: aload 11
    //   392: astore_2
    //   393: goto -288 -> 105
    //   396: iload 6
    //   398: istore 5
    //   400: lload 7
    //   402: lconst_0
    //   403: lcmp
    //   404: ifle +26 -> 430
    //   407: iload 6
    //   409: istore 5
    //   411: iload_3
    //   412: ifle +18 -> 430
    //   415: iload 6
    //   417: istore 5
    //   419: lload 7
    //   421: iload_3
    //   422: i2l
    //   423: lcmp
    //   424: ifne +6 -> 430
    //   427: iconst_1
    //   428: istore 5
    //   430: aload_1
    //   431: ifnull +7 -> 438
    //   434: aload_1
    //   435: invokevirtual 188	java/net/HttpURLConnection:disconnect	()V
    //   438: aload 9
    //   440: ifnull +8 -> 448
    //   443: aload 9
    //   445: invokevirtual 213	java/io/InputStream:close	()V
    //   448: iload 5
    //   450: istore 6
    //   452: aload_2
    //   453: ifnull -386 -> 67
    //   456: aload_2
    //   457: invokevirtual 216	java/io/RandomAccessFile:close	()V
    //   460: iload 5
    //   462: ireturn
    //   463: astore_2
    //   464: aconst_null
    //   465: astore 9
    //   467: aconst_null
    //   468: astore_1
    //   469: aload 11
    //   471: astore 10
    //   473: goto -350 -> 123
    //   476: astore_2
    //   477: aconst_null
    //   478: astore 9
    //   480: aload 11
    //   482: astore 10
    //   484: goto -361 -> 123
    //   487: astore 11
    //   489: aload_2
    //   490: astore 10
    //   492: aload 11
    //   494: astore_2
    //   495: goto -372 -> 123
    //   498: astore 9
    //   500: aconst_null
    //   501: astore_1
    //   502: aconst_null
    //   503: astore_2
    //   504: goto -399 -> 105
    //   507: astore 12
    //   509: aload 9
    //   511: astore 11
    //   513: aload_1
    //   514: astore_2
    //   515: aload 12
    //   517: astore 9
    //   519: aload 11
    //   521: astore_1
    //   522: goto -417 -> 105
    //   525: astore_2
    //   526: aload 11
    //   528: astore 10
    //   530: goto -407 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	this	d
    //   0	533	1	paramString	String
    //   0	533	2	paramFile	File
    //   238	184	3	i	int
    //   310	48	4	j	int
    //   4	457	5	bool1	boolean
    //   1	450	6	bool2	boolean
    //   19	401	7	l	long
    //   95	16	9	localException1	Exception
    //   116	363	9	localObject1	Object
    //   498	12	9	localException2	Exception
    //   517	1	9	localObject2	Object
    //   10	519	10	localObject3	Object
    //   7	96	11	localObject4	Object
    //   113	8	11	localObject5	Object
    //   382	99	11	str1	String
    //   487	6	11	localObject6	Object
    //   511	16	11	localObject7	Object
    //   165	154	12	localObject8	Object
    //   373	12	12	localException3	Exception
    //   507	9	12	localException4	Exception
    //   174	8	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   70	95	95	java/lang/Exception
    //   153	159	95	java/lang/Exception
    //   105	113	113	finally
    //   265	279	373	java/lang/Exception
    //   279	312	373	java/lang/Exception
    //   317	326	373	java/lang/Exception
    //   334	370	373	java/lang/Exception
    //   21	27	463	finally
    //   70	95	476	finally
    //   153	159	476	finally
    //   265	279	487	finally
    //   279	312	487	finally
    //   317	326	487	finally
    //   334	370	487	finally
    //   21	27	498	java/lang/Exception
    //   159	176	507	java/lang/Exception
    //   181	201	507	java/lang/Exception
    //   201	229	507	java/lang/Exception
    //   229	265	507	java/lang/Exception
    //   159	176	525	finally
    //   181	201	525	finally
    //   201	229	525	finally
    //   229	265	525	finally
  }
  
  protected Integer a(Object... paramVarArgs)
  {
    int i = -1;
    if (this.b != null)
    {
      this.b.b(2);
      this.b.c(1);
      i = a();
      switch (i)
      {
      }
    }
    for (;;)
    {
      return Integer.valueOf(i);
      a(5, 3);
      continue;
      a(4, 4);
      continue;
      a(7, 5);
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    switch (paramInteger.intValue())
    {
    }
    for (;;)
    {
      DownloadService.a(this.a);
      if (DownloadService.b(this.a) <= 0) {
        this.a.stopSelf();
      }
      return;
      c.a(this.a.getApplicationContext()).c(this.b);
    }
  }
  
  protected void a(e... paramVarArgs)
  {
    super.onProgressUpdate(paramVarArgs);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/download/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */