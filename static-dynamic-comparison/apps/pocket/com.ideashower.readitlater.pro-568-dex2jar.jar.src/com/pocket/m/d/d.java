package com.pocket.m.d;

import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.m;
import com.ideashower.readitlater.g.k;
import com.pocket.m.a.a;
import com.pocket.m.b.f;
import java.io.File;
import java.io.IOException;
import org.apache.a.b.b;

public class d
  extends k
{
  private static e a;
  private final String b;
  private final byte[] c;
  private final String d;
  private final String e;
  private final int f;
  private final a g;
  private final f h;
  private boolean p = false;
  private long q;
  
  public d(f paramf, int paramInt, String paramString1, String paramString2, String paramString3, a parama)
  {
    this.b = paramString3;
    this.c = null;
    this.d = paramString2;
    this.e = paramString1;
    this.h = paramf;
    this.f = paramInt;
    this.g = parama;
  }
  
  public d(f paramf, int paramInt, byte[] paramArrayOfByte, String paramString, a parama)
  {
    this.b = null;
    this.c = paramArrayOfByte;
    this.d = paramString;
    this.e = null;
    this.h = paramf;
    this.f = paramInt;
    this.g = parama;
  }
  
  public static File a(String paramString)
  {
    return a(paramString, true);
  }
  
  /* Error */
  public static File a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 57	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: iconst_0
    //   8: aload_0
    //   9: getstatic 60	java/io/File:separator	Ljava/lang/String;
    //   12: invokevirtual 66	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   15: invokevirtual 70	java/lang/String:substring	(II)Ljava/lang/String;
    //   18: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 5
    //   23: iconst_4
    //   24: istore_2
    //   25: aload 5
    //   27: invokevirtual 77	java/io/File:exists	()Z
    //   30: ifne +75 -> 105
    //   33: iload_3
    //   34: ifne +71 -> 105
    //   37: iload_2
    //   38: ifle +67 -> 105
    //   41: aload 5
    //   43: invokevirtual 80	java/io/File:mkdirs	()Z
    //   46: istore 4
    //   48: iload 4
    //   50: istore_3
    //   51: iload 4
    //   53: ifne -20 -> 33
    //   56: iload_2
    //   57: iconst_1
    //   58: isub
    //   59: istore_2
    //   60: ldc2_w 81
    //   63: invokestatic 88	java/lang/Thread:sleep	(J)V
    //   66: iload 4
    //   68: istore_3
    //   69: goto -36 -> 33
    //   72: astore 6
    //   74: aload 6
    //   76: invokestatic 93	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   79: iload 4
    //   81: istore_3
    //   82: goto -49 -> 33
    //   85: astore 5
    //   87: aconst_null
    //   88: astore_0
    //   89: aload 5
    //   91: invokestatic 93	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   94: invokestatic 99	com/ideashower/readitlater/a/g:s	()Lcom/ideashower/readitlater/a/m;
    //   97: aload 5
    //   99: iconst_2
    //   100: invokevirtual 104	com/ideashower/readitlater/a/m:a	(Ljava/lang/Throwable;I)V
    //   103: aload_0
    //   104: areturn
    //   105: iload_1
    //   106: ifeq +40 -> 146
    //   109: new 57	java/io/File
    //   112: dup
    //   113: aload_0
    //   114: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   117: astore_0
    //   118: aload_0
    //   119: invokevirtual 107	java/io/File:createNewFile	()Z
    //   122: pop
    //   123: aload_0
    //   124: areturn
    //   125: astore 5
    //   127: goto -38 -> 89
    //   130: astore 5
    //   132: aconst_null
    //   133: astore_0
    //   134: aload 5
    //   136: invokestatic 93	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   139: aload_0
    //   140: areturn
    //   141: astore 5
    //   143: goto -9 -> 134
    //   146: aconst_null
    //   147: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramString	String
    //   0	148	1	paramBoolean	boolean
    //   24	36	2	i	int
    //   1	81	3	j	int
    //   46	34	4	bool	boolean
    //   21	21	5	localFile	File
    //   85	13	5	localIOException1	IOException
    //   125	1	5	localIOException2	IOException
    //   130	5	5	localThrowable1	Throwable
    //   141	1	5	localThrowable2	Throwable
    //   72	3	6	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   60	66	72	java/lang/InterruptedException
    //   2	23	85	java/io/IOException
    //   25	33	85	java/io/IOException
    //   41	48	85	java/io/IOException
    //   60	66	85	java/io/IOException
    //   74	79	85	java/io/IOException
    //   109	118	85	java/io/IOException
    //   118	123	125	java/io/IOException
    //   2	23	130	java/lang/Throwable
    //   25	33	130	java/lang/Throwable
    //   41	48	130	java/lang/Throwable
    //   60	66	130	java/lang/Throwable
    //   74	79	130	java/lang/Throwable
    //   109	118	130	java/lang/Throwable
    //   118	123	141	java/lang/Throwable
  }
  
  public static void a(e parame)
  {
    a = parame;
  }
  
  /* Error */
  private boolean a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore 7
    //   17: aload_0
    //   18: getfield 31	com/pocket/m/d/d:b	Ljava/lang/String;
    //   21: ifnull +85 -> 106
    //   24: aload_0
    //   25: getfield 31	com/pocket/m/d/d:b	Ljava/lang/String;
    //   28: astore_2
    //   29: aload_2
    //   30: invokevirtual 117	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   33: astore 9
    //   35: aload 9
    //   37: ldc 119
    //   39: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifne +13 -> 55
    //   45: aload 9
    //   47: ldc 125
    //   49: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifeq +60 -> 112
    //   55: aload_0
    //   56: getfield 37	com/pocket/m/d/d:e	Ljava/lang/String;
    //   59: ldc 127
    //   61: invokevirtual 131	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   64: ldc 119
    //   66: invokestatic 136	com/ideashower/readitlater/util/w:a	([BLjava/lang/String;)[B
    //   69: astore_2
    //   70: new 138	java/io/FileOutputStream
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   78: astore_1
    //   79: aload_1
    //   80: aload_2
    //   81: invokevirtual 145	java/io/FileOutputStream:write	([B)V
    //   84: aconst_null
    //   85: astore_3
    //   86: aload_1
    //   87: astore_2
    //   88: aload_3
    //   89: ifnull +7 -> 96
    //   92: aload_3
    //   93: invokevirtual 150	java/io/BufferedWriter:close	()V
    //   96: aload_2
    //   97: ifnull +355 -> 452
    //   100: aload_2
    //   101: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   104: iconst_1
    //   105: ireturn
    //   106: ldc 119
    //   108: astore_2
    //   109: goto -80 -> 29
    //   112: new 147	java/io/BufferedWriter
    //   115: dup
    //   116: new 153	java/io/OutputStreamWriter
    //   119: dup
    //   120: new 138	java/io/FileOutputStream
    //   123: dup
    //   124: aload_1
    //   125: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   128: aload_2
    //   129: invokespecial 156	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   132: invokespecial 159	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   135: astore_1
    //   136: aload 8
    //   138: astore_3
    //   139: aload_1
    //   140: astore_2
    //   141: aload_1
    //   142: aload_0
    //   143: getfield 37	com/pocket/m/d/d:e	Ljava/lang/String;
    //   146: invokevirtual 161	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   149: aload 7
    //   151: astore_2
    //   152: aload_1
    //   153: astore_3
    //   154: goto -66 -> 88
    //   157: astore_2
    //   158: aconst_null
    //   159: astore 4
    //   161: aload_1
    //   162: astore_3
    //   163: aload 4
    //   165: astore_1
    //   166: aload_2
    //   167: invokestatic 93	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   170: aload_3
    //   171: ifnull +7 -> 178
    //   174: aload_3
    //   175: invokevirtual 150	java/io/BufferedWriter:close	()V
    //   178: aload_1
    //   179: ifnull +271 -> 450
    //   182: aload_1
    //   183: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   186: iconst_0
    //   187: ireturn
    //   188: astore_1
    //   189: aload_1
    //   190: invokestatic 93	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   193: goto -97 -> 96
    //   196: astore_1
    //   197: aload_1
    //   198: invokestatic 93	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   201: iconst_1
    //   202: ireturn
    //   203: astore_2
    //   204: aload_2
    //   205: invokestatic 93	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   208: goto -30 -> 178
    //   211: astore_1
    //   212: aload_1
    //   213: invokestatic 93	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   216: iconst_0
    //   217: ireturn
    //   218: astore 4
    //   220: aconst_null
    //   221: astore_1
    //   222: aload 5
    //   224: astore_3
    //   225: aload_1
    //   226: astore_2
    //   227: invokestatic 99	com/ideashower/readitlater/a/g:s	()Lcom/ideashower/readitlater/a/m;
    //   230: aload 4
    //   232: iconst_2
    //   233: invokevirtual 104	com/ideashower/readitlater/a/m:a	(Ljava/lang/Throwable;I)V
    //   236: aload 5
    //   238: astore_3
    //   239: aload_1
    //   240: astore_2
    //   241: aload 4
    //   243: invokestatic 93	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   246: aload_1
    //   247: ifnull +7 -> 254
    //   250: aload_1
    //   251: invokevirtual 150	java/io/BufferedWriter:close	()V
    //   254: aload 5
    //   256: ifnull +194 -> 450
    //   259: aload 5
    //   261: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   264: iconst_0
    //   265: ireturn
    //   266: astore_1
    //   267: aload_1
    //   268: invokestatic 93	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   271: goto -17 -> 254
    //   274: astore_1
    //   275: aload_1
    //   276: invokestatic 93	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   279: iconst_0
    //   280: ireturn
    //   281: astore 4
    //   283: aconst_null
    //   284: astore_1
    //   285: aload 6
    //   287: astore 5
    //   289: aload 5
    //   291: astore_3
    //   292: aload_1
    //   293: astore_2
    //   294: aload 4
    //   296: invokestatic 93	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   299: aload_1
    //   300: ifnull +7 -> 307
    //   303: aload_1
    //   304: invokevirtual 150	java/io/BufferedWriter:close	()V
    //   307: aload 5
    //   309: ifnull +141 -> 450
    //   312: aload 5
    //   314: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   317: iconst_0
    //   318: ireturn
    //   319: astore_1
    //   320: aload_1
    //   321: invokestatic 93	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   324: goto -17 -> 307
    //   327: astore_1
    //   328: aload_1
    //   329: invokestatic 93	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   332: iconst_0
    //   333: ireturn
    //   334: astore_1
    //   335: aconst_null
    //   336: astore_2
    //   337: aload 4
    //   339: astore_3
    //   340: aload_2
    //   341: ifnull +7 -> 348
    //   344: aload_2
    //   345: invokevirtual 150	java/io/BufferedWriter:close	()V
    //   348: aload_3
    //   349: ifnull +7 -> 356
    //   352: aload_3
    //   353: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   356: aload_1
    //   357: athrow
    //   358: astore_2
    //   359: aload_2
    //   360: invokestatic 93	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   363: goto -15 -> 348
    //   366: astore_2
    //   367: aload_2
    //   368: invokestatic 93	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   371: goto -15 -> 356
    //   374: astore 4
    //   376: aconst_null
    //   377: astore_2
    //   378: aload_1
    //   379: astore_3
    //   380: aload 4
    //   382: astore_1
    //   383: goto -43 -> 340
    //   386: astore_1
    //   387: goto -47 -> 340
    //   390: astore 4
    //   392: aload_3
    //   393: astore_2
    //   394: aload_1
    //   395: astore_3
    //   396: aload 4
    //   398: astore_1
    //   399: goto -59 -> 340
    //   402: astore 4
    //   404: aconst_null
    //   405: astore_2
    //   406: aload_1
    //   407: astore 5
    //   409: aload_2
    //   410: astore_1
    //   411: goto -122 -> 289
    //   414: astore 4
    //   416: aload 6
    //   418: astore 5
    //   420: goto -131 -> 289
    //   423: astore 4
    //   425: aconst_null
    //   426: astore_2
    //   427: aload_1
    //   428: astore 5
    //   430: aload_2
    //   431: astore_1
    //   432: goto -210 -> 222
    //   435: astore 4
    //   437: goto -215 -> 222
    //   440: astore_2
    //   441: aconst_null
    //   442: astore_1
    //   443: goto -277 -> 166
    //   446: astore_2
    //   447: goto -281 -> 166
    //   450: iconst_0
    //   451: ireturn
    //   452: iconst_1
    //   453: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	this	d
    //   0	454	1	paramFile	File
    //   28	124	2	localObject1	Object
    //   157	10	2	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   203	2	2	localIOException1	IOException
    //   226	119	2	localFile	File
    //   358	2	2	localIOException2	IOException
    //   366	2	2	localIOException3	IOException
    //   377	54	2	localObject2	Object
    //   440	1	2	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   446	1	2	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
    //   1	395	3	localObject3	Object
    //   9	155	4	localObject4	Object
    //   218	24	4	localIOException4	IOException
    //   281	57	4	localThrowable1	Throwable
    //   374	7	4	localObject5	Object
    //   390	7	4	localObject6	Object
    //   402	1	4	localThrowable2	Throwable
    //   414	1	4	localThrowable3	Throwable
    //   423	1	4	localIOException5	IOException
    //   435	1	4	localIOException6	IOException
    //   3	426	5	localObject7	Object
    //   6	411	6	localObject8	Object
    //   15	135	7	localObject9	Object
    //   12	125	8	localObject10	Object
    //   33	13	9	str	String
    // Exception table:
    //   from	to	target	type
    //   141	149	157	java/io/UnsupportedEncodingException
    //   92	96	188	java/io/IOException
    //   100	104	196	java/io/IOException
    //   174	178	203	java/io/IOException
    //   182	186	211	java/io/IOException
    //   35	55	218	java/io/IOException
    //   55	79	218	java/io/IOException
    //   112	136	218	java/io/IOException
    //   250	254	266	java/io/IOException
    //   259	264	274	java/io/IOException
    //   35	55	281	java/lang/Throwable
    //   55	79	281	java/lang/Throwable
    //   112	136	281	java/lang/Throwable
    //   303	307	319	java/io/IOException
    //   312	317	327	java/io/IOException
    //   35	55	334	finally
    //   55	79	334	finally
    //   112	136	334	finally
    //   344	348	358	java/io/IOException
    //   352	356	366	java/io/IOException
    //   79	84	374	finally
    //   141	149	386	finally
    //   227	236	386	finally
    //   241	246	386	finally
    //   294	299	386	finally
    //   166	170	390	finally
    //   79	84	402	java/lang/Throwable
    //   141	149	414	java/lang/Throwable
    //   79	84	423	java/io/IOException
    //   141	149	435	java/io/IOException
    //   35	55	440	java/io/UnsupportedEncodingException
    //   55	79	440	java/io/UnsupportedEncodingException
    //   112	136	440	java/io/UnsupportedEncodingException
    //   79	84	446	java/io/UnsupportedEncodingException
  }
  
  public void a()
  {
    int k = 0;
    int j = 1;
    File localFile;
    int i;
    if (this.d != null)
    {
      localFile = a(this.d);
      i = k;
      if ((localFile != null) && (this.c == null)) {
        break label122;
      }
    }
    for (;;)
    {
      try
      {
        b.a(localFile, this.c);
        this.p = true;
        i = 1;
      }
      catch (IOException localIOException)
      {
        com.ideashower.readitlater.util.e.a(localIOException);
        g.s().a(localIOException, 2);
        i = 1;
        continue;
      }
      catch (Throwable localThrowable)
      {
        com.ideashower.readitlater.util.e.a(localThrowable);
        i = 1;
        continue;
      }
      switch (this.f)
      {
      default: 
        if (this.p) {
          this.q = b.h(localFile);
        }
        return;
        label122:
        i = k;
        if (this.e != null)
        {
          this.p = a(localFile);
          i = 1;
        }
        break;
      }
    }
    if (i == 0) {
      i = -4;
    }
    for (;;)
    {
      this.h.a(i);
      break;
      i = j;
      if (!this.p) {
        i = -5;
      }
    }
  }
  
  protected void b(boolean paramBoolean, Throwable paramThrowable)
  {
    super.b(paramBoolean, paramThrowable);
    if (this.g != null)
    {
      if (this.p) {
        this.g.a(this.c);
      }
      paramThrowable = this.g;
      if ((!this.p) || (!paramBoolean)) {
        break label84;
      }
    }
    label84:
    for (paramBoolean = true;; paramBoolean = false)
    {
      com.pocket.m.a.e.a(paramThrowable, paramBoolean);
      if ((this.p) && (a != null)) {
        a.a(this.d, this.q);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */