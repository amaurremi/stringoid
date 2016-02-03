package com.mapbar.android.maps;

import android.os.SystemClock;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.util.Hashtable;
import java.util.Vector;

public final class q
{
  private static q j;
  private static final int[] k = { 4500000, 2000000, 1000000, 500000, 250000, 100000, 50000, 25000, 10000, 5000, 2500, 1000, 500, 250, 100 };
  private static final int[] l = { 3600000, 1600000, 800000, 400000, 200000, 80000, 40000, 20000, 8000, 4000, 2000, 800, 400, 200, 80 };
  private String a = "/";
  private int b = 1;
  private int c = 0;
  private int d = 0;
  private RandomAccessFile e = null;
  private String f = null;
  private String g = ".rsf";
  private Vector<p> h;
  private Hashtable<String, Vector<String>> i;
  
  private q(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
    this.h = new Vector();
    this.i = new Hashtable();
    long l1 = SystemClock.elapsedRealtime();
    a(this.a);
    E.a("MLocalDatas", "Load data cost=" + (SystemClock.elapsedRealtime() - l1));
  }
  
  private int a(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length;
    int n = 0;
    int m = i1 - 1;
    while (m >= 0)
    {
      n |= (paramArrayOfByte[(m + 0)] & 0xFF) << (i1 - 1 - m) * 8;
      m -= 1;
    }
    return n;
  }
  
  public static q a(String paramString, int paramInt)
  {
    if (j == null) {
      j = new q(paramString, paramInt);
    }
    return j;
  }
  
  /* Error */
  private void a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 22
    //   3: new 126	java/io/RandomAccessFile
    //   6: dup
    //   7: aload_1
    //   8: ldc -128
    //   10: invokespecial 131	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   13: astore 21
    //   15: iconst_4
    //   16: newarray <illegal type>
    //   18: astore 22
    //   20: aload 21
    //   22: iconst_5
    //   23: invokevirtual 135	java/io/RandomAccessFile:skipBytes	(I)I
    //   26: pop
    //   27: aload 21
    //   29: aload 22
    //   31: invokevirtual 138	java/io/RandomAccessFile:read	([B)I
    //   34: pop
    //   35: aload_0
    //   36: aload 22
    //   38: invokespecial 140	com/mapbar/android/maps/q:a	([B)I
    //   41: istore 5
    //   43: iload 5
    //   45: newarray <illegal type>
    //   47: astore 23
    //   49: aload 21
    //   51: aload 23
    //   53: invokevirtual 138	java/io/RandomAccessFile:read	([B)I
    //   56: pop
    //   57: aload 23
    //   59: iconst_0
    //   60: baload
    //   61: istore_2
    //   62: iload_2
    //   63: ifeq +9 -> 72
    //   66: aload 21
    //   68: invokevirtual 143	java/io/RandomAccessFile:close	()V
    //   71: return
    //   72: aload 23
    //   74: iconst_2
    //   75: aload 22
    //   77: iconst_0
    //   78: iconst_4
    //   79: invokestatic 149	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   82: aload_0
    //   83: aload 22
    //   85: invokespecial 140	com/mapbar/android/maps/q:a	([B)I
    //   88: istore 6
    //   90: aload 23
    //   92: bipush 6
    //   94: aload 22
    //   96: iconst_0
    //   97: iconst_4
    //   98: invokestatic 149	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   101: aload_0
    //   102: aload 22
    //   104: invokespecial 140	com/mapbar/android/maps/q:a	([B)I
    //   107: istore 7
    //   109: aload 23
    //   111: bipush 10
    //   113: aload 22
    //   115: iconst_0
    //   116: iconst_4
    //   117: invokestatic 149	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   120: aload 23
    //   122: aload_0
    //   123: aload 22
    //   125: invokespecial 140	com/mapbar/android/maps/q:a	([B)I
    //   128: bipush 14
    //   130: iadd
    //   131: baload
    //   132: istore_2
    //   133: aload_0
    //   134: getfield 58	com/mapbar/android/maps/q:b	I
    //   137: istore_3
    //   138: iload_2
    //   139: iload_3
    //   140: if_icmpeq +11 -> 151
    //   143: aload 21
    //   145: invokevirtual 143	java/io/RandomAccessFile:close	()V
    //   148: return
    //   149: astore_1
    //   150: return
    //   151: aload 21
    //   153: aload 22
    //   155: invokevirtual 138	java/io/RandomAccessFile:read	([B)I
    //   158: pop
    //   159: aload_0
    //   160: aload 22
    //   162: invokespecial 140	com/mapbar/android/maps/q:a	([B)I
    //   165: istore 8
    //   167: iload 8
    //   169: newarray <illegal type>
    //   171: astore 23
    //   173: aload 21
    //   175: aload 23
    //   177: invokevirtual 138	java/io/RandomAccessFile:read	([B)I
    //   180: pop
    //   181: aload 23
    //   183: iconst_0
    //   184: baload
    //   185: istore 9
    //   187: iconst_0
    //   188: istore_3
    //   189: iconst_2
    //   190: istore_2
    //   191: iload_3
    //   192: iload 9
    //   194: if_icmpge +460 -> 654
    //   197: aload 23
    //   199: iload_2
    //   200: baload
    //   201: istore 11
    //   203: iconst_2
    //   204: newarray <illegal type>
    //   206: astore 24
    //   208: aload 23
    //   210: iload_2
    //   211: iconst_1
    //   212: iadd
    //   213: aload 24
    //   215: iconst_0
    //   216: iconst_2
    //   217: invokestatic 149	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   220: aload_0
    //   221: aload 24
    //   223: invokespecial 140	com/mapbar/android/maps/q:a	([B)I
    //   226: istore 10
    //   228: iconst_0
    //   229: istore 4
    //   231: iload 4
    //   233: iload 10
    //   235: if_icmpge +402 -> 637
    //   238: iload_2
    //   239: iconst_3
    //   240: iadd
    //   241: iload 4
    //   243: bipush 38
    //   245: imul
    //   246: iadd
    //   247: istore 20
    //   249: aload 23
    //   251: iload 20
    //   253: aload 22
    //   255: iconst_0
    //   256: iconst_4
    //   257: invokestatic 149	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   260: aload_0
    //   261: aload 22
    //   263: invokespecial 140	com/mapbar/android/maps/q:a	([B)I
    //   266: istore 12
    //   268: aload 23
    //   270: iload 20
    //   272: bipush 6
    //   274: iadd
    //   275: aload 22
    //   277: iconst_0
    //   278: iconst_4
    //   279: invokestatic 149	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   282: aload_0
    //   283: aload 22
    //   285: invokespecial 140	com/mapbar/android/maps/q:a	([B)I
    //   288: istore 13
    //   290: aload 23
    //   292: iload 20
    //   294: bipush 10
    //   296: iadd
    //   297: aload 22
    //   299: iconst_0
    //   300: iconst_4
    //   301: invokestatic 149	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   304: aload_0
    //   305: aload 22
    //   307: invokespecial 140	com/mapbar/android/maps/q:a	([B)I
    //   310: istore 14
    //   312: aload 23
    //   314: iload 20
    //   316: bipush 14
    //   318: iadd
    //   319: aload 22
    //   321: iconst_0
    //   322: iconst_4
    //   323: invokestatic 149	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   326: aload_0
    //   327: aload 22
    //   329: invokespecial 140	com/mapbar/android/maps/q:a	([B)I
    //   332: istore 15
    //   334: aload 23
    //   336: iload 20
    //   338: bipush 18
    //   340: iadd
    //   341: aload 22
    //   343: iconst_0
    //   344: iconst_4
    //   345: invokestatic 149	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   348: aload_0
    //   349: aload 22
    //   351: invokespecial 140	com/mapbar/android/maps/q:a	([B)I
    //   354: istore 16
    //   356: aload 23
    //   358: iload 20
    //   360: bipush 22
    //   362: iadd
    //   363: aload 22
    //   365: iconst_0
    //   366: iconst_4
    //   367: invokestatic 149	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   370: aload_0
    //   371: aload 22
    //   373: invokespecial 140	com/mapbar/android/maps/q:a	([B)I
    //   376: istore 17
    //   378: aload 23
    //   380: iload 20
    //   382: bipush 26
    //   384: iadd
    //   385: aload 22
    //   387: iconst_0
    //   388: iconst_4
    //   389: invokestatic 149	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   392: aload_0
    //   393: aload 22
    //   395: invokespecial 140	com/mapbar/android/maps/q:a	([B)I
    //   398: istore 18
    //   400: aload 23
    //   402: iload 20
    //   404: bipush 30
    //   406: iadd
    //   407: aload 22
    //   409: iconst_0
    //   410: iconst_4
    //   411: invokestatic 149	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   414: aload_0
    //   415: aload 22
    //   417: invokespecial 140	com/mapbar/android/maps/q:a	([B)I
    //   420: istore 19
    //   422: aload 23
    //   424: iload 20
    //   426: bipush 34
    //   428: iadd
    //   429: aload 22
    //   431: iconst_0
    //   432: iconst_4
    //   433: invokestatic 149	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   436: aload_0
    //   437: aload 22
    //   439: invokespecial 140	com/mapbar/android/maps/q:a	([B)I
    //   442: istore 20
    //   444: new 151	com/mapbar/android/maps/p
    //   447: dup
    //   448: iload 7
    //   450: aload_1
    //   451: invokevirtual 156	java/io/File:getName	()Ljava/lang/String;
    //   454: iload 5
    //   456: bipush 17
    //   458: iadd
    //   459: iload 8
    //   461: iadd
    //   462: iconst_4
    //   463: newarray <illegal type>
    //   465: dup
    //   466: iconst_0
    //   467: iload 13
    //   469: iastore
    //   470: dup
    //   471: iconst_1
    //   472: iload 14
    //   474: iastore
    //   475: dup
    //   476: iconst_2
    //   477: iload 15
    //   479: iastore
    //   480: dup
    //   481: iconst_3
    //   482: iload 16
    //   484: iastore
    //   485: iconst_4
    //   486: newarray <illegal type>
    //   488: dup
    //   489: iconst_0
    //   490: iload 17
    //   492: iastore
    //   493: dup
    //   494: iconst_1
    //   495: iload 18
    //   497: iastore
    //   498: dup
    //   499: iconst_2
    //   500: iload 19
    //   502: iastore
    //   503: dup
    //   504: iconst_3
    //   505: iload 20
    //   507: iastore
    //   508: iload 12
    //   510: iload 6
    //   512: invokespecial 159	com/mapbar/android/maps/p:<init>	(ILjava/lang/String;I[I[III)V
    //   515: astore 24
    //   517: aload_0
    //   518: getfield 75	com/mapbar/android/maps/q:h	Ljava/util/Vector;
    //   521: invokevirtual 163	java/util/Vector:size	()I
    //   524: istore 12
    //   526: aload_0
    //   527: getfield 75	com/mapbar/android/maps/q:h	Ljava/util/Vector;
    //   530: aload 24
    //   532: invokevirtual 167	java/util/Vector:addElement	(Ljava/lang/Object;)V
    //   535: iload 11
    //   537: invokestatic 173	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   540: astore 24
    //   542: aload_0
    //   543: getfield 80	com/mapbar/android/maps/q:i	Ljava/util/Hashtable;
    //   546: aload 24
    //   548: invokevirtual 177	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   551: ifeq +26 -> 577
    //   554: aload_0
    //   555: getfield 80	com/mapbar/android/maps/q:i	Ljava/util/Hashtable;
    //   558: aload 24
    //   560: invokevirtual 181	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   563: checkcast 72	java/util/Vector
    //   566: iload 12
    //   568: invokestatic 173	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   571: invokevirtual 167	java/util/Vector:addElement	(Ljava/lang/Object;)V
    //   574: goto +142 -> 716
    //   577: new 72	java/util/Vector
    //   580: dup
    //   581: invokespecial 73	java/util/Vector:<init>	()V
    //   584: astore 25
    //   586: aload 25
    //   588: iload 12
    //   590: invokestatic 173	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   593: invokevirtual 167	java/util/Vector:addElement	(Ljava/lang/Object;)V
    //   596: aload_0
    //   597: getfield 80	com/mapbar/android/maps/q:i	Ljava/util/Hashtable;
    //   600: aload 24
    //   602: aload 25
    //   604: invokevirtual 185	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   607: pop
    //   608: goto +108 -> 716
    //   611: astore 22
    //   613: aload 21
    //   615: astore_1
    //   616: aload 22
    //   618: astore 21
    //   620: aload 21
    //   622: invokevirtual 188	java/lang/Exception:printStackTrace	()V
    //   625: aload_1
    //   626: ifnull +7 -> 633
    //   629: aload_1
    //   630: invokevirtual 143	java/io/RandomAccessFile:close	()V
    //   633: invokestatic 191	java/lang/System:gc	()V
    //   636: return
    //   637: iload_3
    //   638: iconst_1
    //   639: iadd
    //   640: istore_3
    //   641: iload_2
    //   642: iload 10
    //   644: bipush 38
    //   646: imul
    //   647: iconst_3
    //   648: iadd
    //   649: iadd
    //   650: istore_2
    //   651: goto -460 -> 191
    //   654: aload 21
    //   656: invokevirtual 143	java/io/RandomAccessFile:close	()V
    //   659: goto -26 -> 633
    //   662: astore_1
    //   663: goto -30 -> 633
    //   666: astore_1
    //   667: aconst_null
    //   668: astore 21
    //   670: aload 21
    //   672: ifnull +8 -> 680
    //   675: aload 21
    //   677: invokevirtual 143	java/io/RandomAccessFile:close	()V
    //   680: aload_1
    //   681: athrow
    //   682: astore_1
    //   683: return
    //   684: astore_1
    //   685: goto -52 -> 633
    //   688: astore 21
    //   690: goto -10 -> 680
    //   693: astore_1
    //   694: goto -24 -> 670
    //   697: astore 22
    //   699: aload_1
    //   700: astore 21
    //   702: aload 22
    //   704: astore_1
    //   705: goto -35 -> 670
    //   708: astore 21
    //   710: aload 22
    //   712: astore_1
    //   713: goto -93 -> 620
    //   716: iload 4
    //   718: iconst_1
    //   719: iadd
    //   720: istore 4
    //   722: goto -491 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	725	0	this	q
    //   0	725	1	paramFile	File
    //   61	590	2	m	int
    //   137	504	3	n	int
    //   229	492	4	i1	int
    //   41	418	5	i2	int
    //   88	423	6	i3	int
    //   107	342	7	i4	int
    //   165	297	8	i5	int
    //   185	10	9	i6	int
    //   226	421	10	i7	int
    //   201	335	11	i8	int
    //   266	323	12	i9	int
    //   288	180	13	i10	int
    //   310	163	14	i11	int
    //   332	146	15	i12	int
    //   354	129	16	i13	int
    //   376	115	17	i14	int
    //   398	98	18	i15	int
    //   420	81	19	i16	int
    //   247	259	20	i17	int
    //   13	663	21	localObject1	Object
    //   688	1	21	localIOException	java.io.IOException
    //   700	1	21	localFile	File
    //   708	1	21	localException1	Exception
    //   1	437	22	arrayOfByte1	byte[]
    //   611	6	22	localException2	Exception
    //   697	14	22	localObject2	Object
    //   47	376	23	arrayOfByte2	byte[]
    //   206	395	24	localObject3	Object
    //   584	19	25	localVector	Vector
    // Exception table:
    //   from	to	target	type
    //   143	148	149	java/io/IOException
    //   15	57	611	java/lang/Exception
    //   72	138	611	java/lang/Exception
    //   151	181	611	java/lang/Exception
    //   203	228	611	java/lang/Exception
    //   249	574	611	java/lang/Exception
    //   577	608	611	java/lang/Exception
    //   654	659	662	java/io/IOException
    //   3	15	666	finally
    //   66	71	682	java/io/IOException
    //   629	633	684	java/io/IOException
    //   675	680	688	java/io/IOException
    //   15	57	693	finally
    //   72	138	693	finally
    //   151	181	693	finally
    //   203	228	693	finally
    //   249	574	693	finally
    //   577	608	693	finally
    //   620	625	697	finally
    //   3	15	708	java/lang/Exception
  }
  
  private void a(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      if (paramString.isDirectory())
      {
        paramString = paramString.listFiles(new FilenameFilter()
        {
          public boolean accept(File paramAnonymousFile, String paramAnonymousString)
          {
            return paramAnonymousString.toLowerCase().endsWith(q.a(q.this));
          }
        });
        int n = paramString.length;
        int m = 0;
        while (m < n)
        {
          a(paramString[m]);
          m += 1;
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      p localp = (p)this.h.elementAt(paramInt3);
      int[] arrayOfInt = localp.c();
      paramInt3 = arrayOfInt[0];
      int m = arrayOfInt[1];
      int n = arrayOfInt[2];
      int i1 = arrayOfInt[3];
      if ((paramInt1 >= paramInt3) && (paramInt1 <= n) && (paramInt2 >= m) && (paramInt2 <= i1))
      {
        i1 = localp.f();
        return i1 + (paramInt1 - paramInt3 + (n - paramInt3 + 1) * (paramInt2 - m));
      }
    }
    catch (Exception localException)
    {
      return -1;
    }
    return -1;
  }
  
  private void b()
  {
    try
    {
      if (this.e != null)
      {
        this.e.close();
        this.e = null;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean b(String paramString)
  {
    if (this.f == null) {
      this.f = paramString;
    }
    for (;;)
    {
      if (this.e == null) {}
      try
      {
        this.e = new RandomAccessFile(new File(this.a, this.f), "r");
        return true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      if (!this.f.equals(paramString))
      {
        this.f = paramString;
        b();
      }
    }
    return false;
  }
  
  public final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = String.valueOf(paramInt3);
    if (!this.i.containsKey(localObject1)) {
      return -1;
    }
    localObject1 = (Vector)this.i.get(localObject1);
    paramInt3 = 0;
    while (paramInt3 < ((Vector)localObject1).size())
    {
      int m = Integer.parseInt((String)((Vector)localObject1).elementAt(paramInt3));
      Object localObject2 = (p)this.h.elementAt(m);
      if (((p)localObject2).a() >= this.c)
      {
        localObject2 = ((p)localObject2).b();
        if ((paramInt1 >= localObject2[0]) && (paramInt2 >= localObject2[1]) && (paramInt1 <= localObject2[2]) && (paramInt2 <= localObject2[3])) {
          return m;
        }
      }
      paramInt3 += 1;
    }
    return -1;
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 224	com/mapbar/android/maps/q:b	()V
    //   4: aload_0
    //   5: getfield 75	com/mapbar/android/maps/q:h	Ljava/util/Vector;
    //   8: ifnull +22 -> 30
    //   11: aload_0
    //   12: getfield 75	com/mapbar/android/maps/q:h	Ljava/util/Vector;
    //   15: invokevirtual 237	java/util/Vector:removeAllElements	()V
    //   18: aload_0
    //   19: getfield 75	com/mapbar/android/maps/q:h	Ljava/util/Vector;
    //   22: invokevirtual 240	java/util/Vector:clear	()V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 75	com/mapbar/android/maps/q:h	Ljava/util/Vector;
    //   30: aload_0
    //   31: getfield 80	com/mapbar/android/maps/q:i	Ljava/util/Hashtable;
    //   34: ifnull +71 -> 105
    //   37: aload_0
    //   38: getfield 80	com/mapbar/android/maps/q:i	Ljava/util/Hashtable;
    //   41: invokevirtual 244	java/util/Hashtable:keys	()Ljava/util/Enumeration;
    //   44: astore_1
    //   45: aload_1
    //   46: invokeinterface 249 1 0
    //   51: ifeq +42 -> 93
    //   54: aload_1
    //   55: invokeinterface 253 1 0
    //   60: checkcast 169	java/lang/String
    //   63: astore_2
    //   64: aload_0
    //   65: getfield 80	com/mapbar/android/maps/q:i	Ljava/util/Hashtable;
    //   68: aload_2
    //   69: invokevirtual 181	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 72	java/util/Vector
    //   75: astore_2
    //   76: aload_2
    //   77: invokevirtual 237	java/util/Vector:removeAllElements	()V
    //   80: aload_2
    //   81: invokevirtual 240	java/util/Vector:clear	()V
    //   84: goto -39 -> 45
    //   87: astore_1
    //   88: aconst_null
    //   89: putstatic 116	com/mapbar/android/maps/q:j	Lcom/mapbar/android/maps/q;
    //   92: return
    //   93: aload_0
    //   94: getfield 80	com/mapbar/android/maps/q:i	Ljava/util/Hashtable;
    //   97: invokevirtual 254	java/util/Hashtable:clear	()V
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 80	com/mapbar/android/maps/q:i	Ljava/util/Hashtable;
    //   105: aconst_null
    //   106: putstatic 116	com/mapbar/android/maps/q:j	Lcom/mapbar/android/maps/q;
    //   109: return
    //   110: astore_1
    //   111: aconst_null
    //   112: putstatic 116	com/mapbar/android/maps/q:j	Lcom/mapbar/android/maps/q;
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	q
    //   44	11	1	localEnumeration	java.util.Enumeration
    //   87	1	1	localException	Exception
    //   110	6	1	localObject1	Object
    //   63	18	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	30	87	java/lang/Exception
    //   30	45	87	java/lang/Exception
    //   45	84	87	java/lang/Exception
    //   93	105	87	java/lang/Exception
    //   0	30	110	finally
    //   30	45	110	finally
    //   45	84	110	finally
    //   93	105	110	finally
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final byte[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      Object localObject1 = (p)this.h.elementAt(paramInt4);
      Object localObject2 = ((p)localObject1).d();
      int m = ((p)localObject1).e();
      if (m <= 0) {
        return null;
      }
      if (!b((String)localObject2)) {
        return null;
      }
      int n = k[paramInt3];
      paramInt3 = l[paramInt3];
      paramInt1 = b(paramInt1 / n, paramInt2 / paramInt3, paramInt4);
      if (paramInt1 < 0) {
        return null;
      }
      localObject1 = new byte[8];
      this.e.seek(m + (paramInt1 << 2));
      this.e.read((byte[])localObject1);
      localObject2 = new byte[4];
      System.arraycopy(localObject1, 0, localObject2, 0, 4);
      paramInt1 = a((byte[])localObject2);
      System.arraycopy(localObject1, 4, localObject2, 0, 4);
      paramInt2 = a((byte[])localObject2) - paramInt1;
      if ((paramInt2 > 0) && (paramInt2 < 102400))
      {
        localObject1 = new byte[paramInt2];
        this.e.seek(paramInt1);
        this.e.read((byte[])localObject1);
        return (byte[])localObject1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      return null;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    catch (Error localError)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */