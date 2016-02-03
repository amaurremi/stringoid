package com.appbrain.e;

import com.appbrain.b.d;
import com.appbrain.b.h;
import com.appbrain.b.k;
import com.appbrain.b.p;
import com.appbrain.b.q;
import com.appbrain.b.w;
import java.util.List;

public final class at
  extends k
  implements av
{
  public static w a = new bf();
  private static final at b;
  private int c;
  private aa d;
  private q e;
  private q f;
  private Object g;
  private byte h = -1;
  private int i = -1;
  
  static
  {
    at localat = new at((byte)0);
    b = localat;
    localat.l();
  }
  
  private at()
  {
    super((byte)0);
  }
  
  private at(byte paramByte) {}
  
  /* Error */
  private at(com.appbrain.b.g paramg, com.appbrain.b.j paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 46	com/appbrain/b/k:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 43	com/appbrain/e/at:h	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 45	com/appbrain/e/at:i	I
    //   14: aload_0
    //   15: invokespecial 39	com/appbrain/e/at:l	()V
    //   18: iconst_0
    //   19: istore 8
    //   21: iconst_0
    //   22: istore_3
    //   23: iload 8
    //   25: ifne +472 -> 497
    //   28: iload_3
    //   29: istore 6
    //   31: iload_3
    //   32: istore 4
    //   34: iload_3
    //   35: istore 7
    //   37: aload_1
    //   38: invokevirtual 58	com/appbrain/b/g:a	()I
    //   41: istore 5
    //   43: iload 5
    //   45: lookupswitch	default:+503->548, 0:+506->551, 10:+75->120, 18:+260->305, 26:+347->392, 34:+413->458
    //   96: iload_3
    //   97: istore 6
    //   99: iload_3
    //   100: istore 4
    //   102: iload_3
    //   103: istore 7
    //   105: aload_1
    //   106: iload 5
    //   108: invokevirtual 61	com/appbrain/b/g:b	(I)Z
    //   111: ifne -88 -> 23
    //   114: iconst_1
    //   115: istore 8
    //   117: goto -94 -> 23
    //   120: iload_3
    //   121: istore 6
    //   123: iload_3
    //   124: istore 4
    //   126: iload_3
    //   127: istore 7
    //   129: aload_0
    //   130: getfield 63	com/appbrain/e/at:c	I
    //   133: iconst_1
    //   134: iand
    //   135: iconst_1
    //   136: if_icmpne +406 -> 542
    //   139: iload_3
    //   140: istore 6
    //   142: iload_3
    //   143: istore 4
    //   145: iload_3
    //   146: istore 7
    //   148: aload_0
    //   149: getfield 65	com/appbrain/e/at:d	Lcom/appbrain/e/aa;
    //   152: invokevirtual 71	com/appbrain/e/aa:ao	()Lcom/appbrain/e/ab;
    //   155: astore 9
    //   157: iload_3
    //   158: istore 6
    //   160: iload_3
    //   161: istore 4
    //   163: iload_3
    //   164: istore 7
    //   166: aload_0
    //   167: aload_1
    //   168: getstatic 72	com/appbrain/e/aa:a	Lcom/appbrain/b/w;
    //   171: aload_2
    //   172: invokevirtual 75	com/appbrain/b/g:a	(Lcom/appbrain/b/w;Lcom/appbrain/b/j;)Lcom/appbrain/b/t;
    //   175: checkcast 67	com/appbrain/e/aa
    //   178: putfield 65	com/appbrain/e/at:d	Lcom/appbrain/e/aa;
    //   181: aload 9
    //   183: ifnull +40 -> 223
    //   186: iload_3
    //   187: istore 6
    //   189: iload_3
    //   190: istore 4
    //   192: iload_3
    //   193: istore 7
    //   195: aload 9
    //   197: aload_0
    //   198: getfield 65	com/appbrain/e/at:d	Lcom/appbrain/e/aa;
    //   201: invokevirtual 80	com/appbrain/e/ab:a	(Lcom/appbrain/e/aa;)Lcom/appbrain/e/ab;
    //   204: pop
    //   205: iload_3
    //   206: istore 6
    //   208: iload_3
    //   209: istore 4
    //   211: iload_3
    //   212: istore 7
    //   214: aload_0
    //   215: aload 9
    //   217: invokevirtual 83	com/appbrain/e/ab:f	()Lcom/appbrain/e/aa;
    //   220: putfield 65	com/appbrain/e/at:d	Lcom/appbrain/e/aa;
    //   223: iload_3
    //   224: istore 6
    //   226: iload_3
    //   227: istore 4
    //   229: iload_3
    //   230: istore 7
    //   232: aload_0
    //   233: aload_0
    //   234: getfield 63	com/appbrain/e/at:c	I
    //   237: iconst_1
    //   238: ior
    //   239: putfield 63	com/appbrain/e/at:c	I
    //   242: goto -219 -> 23
    //   245: astore_1
    //   246: iload 6
    //   248: istore 4
    //   250: aload_1
    //   251: aload_0
    //   252: invokevirtual 86	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   255: athrow
    //   256: astore_1
    //   257: iload 4
    //   259: iconst_2
    //   260: iand
    //   261: iconst_2
    //   262: if_icmpne +18 -> 280
    //   265: aload_0
    //   266: new 88	com/appbrain/b/ac
    //   269: dup
    //   270: aload_0
    //   271: getfield 90	com/appbrain/e/at:e	Lcom/appbrain/b/q;
    //   274: invokespecial 93	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   277: putfield 90	com/appbrain/e/at:e	Lcom/appbrain/b/q;
    //   280: iload 4
    //   282: iconst_4
    //   283: iand
    //   284: iconst_4
    //   285: if_icmpne +18 -> 303
    //   288: aload_0
    //   289: new 88	com/appbrain/b/ac
    //   292: dup
    //   293: aload_0
    //   294: getfield 95	com/appbrain/e/at:f	Lcom/appbrain/b/q;
    //   297: invokespecial 93	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   300: putfield 95	com/appbrain/e/at:f	Lcom/appbrain/b/q;
    //   303: aload_1
    //   304: athrow
    //   305: iload_3
    //   306: istore 5
    //   308: iload_3
    //   309: iconst_2
    //   310: iand
    //   311: iconst_2
    //   312: if_icmpeq +28 -> 340
    //   315: iload_3
    //   316: istore 6
    //   318: iload_3
    //   319: istore 4
    //   321: iload_3
    //   322: istore 7
    //   324: aload_0
    //   325: new 97	com/appbrain/b/p
    //   328: dup
    //   329: invokespecial 98	com/appbrain/b/p:<init>	()V
    //   332: putfield 90	com/appbrain/e/at:e	Lcom/appbrain/b/q;
    //   335: iload_3
    //   336: iconst_2
    //   337: ior
    //   338: istore 5
    //   340: iload 5
    //   342: istore 6
    //   344: iload 5
    //   346: istore 4
    //   348: iload 5
    //   350: istore 7
    //   352: aload_0
    //   353: getfield 90	com/appbrain/e/at:e	Lcom/appbrain/b/q;
    //   356: aload_1
    //   357: invokevirtual 101	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   360: invokeinterface 106 2 0
    //   365: iload 5
    //   367: istore_3
    //   368: goto -345 -> 23
    //   371: astore_1
    //   372: iload 7
    //   374: istore 4
    //   376: new 51	com/appbrain/b/o
    //   379: dup
    //   380: aload_1
    //   381: invokevirtual 110	java/io/IOException:getMessage	()Ljava/lang/String;
    //   384: invokespecial 113	com/appbrain/b/o:<init>	(Ljava/lang/String;)V
    //   387: aload_0
    //   388: invokevirtual 86	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   391: athrow
    //   392: iload_3
    //   393: istore 5
    //   395: iload_3
    //   396: iconst_4
    //   397: iand
    //   398: iconst_4
    //   399: if_icmpeq +28 -> 427
    //   402: iload_3
    //   403: istore 6
    //   405: iload_3
    //   406: istore 4
    //   408: iload_3
    //   409: istore 7
    //   411: aload_0
    //   412: new 97	com/appbrain/b/p
    //   415: dup
    //   416: invokespecial 98	com/appbrain/b/p:<init>	()V
    //   419: putfield 95	com/appbrain/e/at:f	Lcom/appbrain/b/q;
    //   422: iload_3
    //   423: iconst_4
    //   424: ior
    //   425: istore 5
    //   427: iload 5
    //   429: istore 6
    //   431: iload 5
    //   433: istore 4
    //   435: iload 5
    //   437: istore 7
    //   439: aload_0
    //   440: getfield 95	com/appbrain/e/at:f	Lcom/appbrain/b/q;
    //   443: aload_1
    //   444: invokevirtual 101	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   447: invokeinterface 106 2 0
    //   452: iload 5
    //   454: istore_3
    //   455: goto -432 -> 23
    //   458: iload_3
    //   459: istore 6
    //   461: iload_3
    //   462: istore 4
    //   464: iload_3
    //   465: istore 7
    //   467: aload_0
    //   468: aload_0
    //   469: getfield 63	com/appbrain/e/at:c	I
    //   472: iconst_2
    //   473: ior
    //   474: putfield 63	com/appbrain/e/at:c	I
    //   477: iload_3
    //   478: istore 6
    //   480: iload_3
    //   481: istore 4
    //   483: iload_3
    //   484: istore 7
    //   486: aload_0
    //   487: aload_1
    //   488: invokevirtual 101	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   491: putfield 115	com/appbrain/e/at:g	Ljava/lang/Object;
    //   494: goto -471 -> 23
    //   497: iload_3
    //   498: iconst_2
    //   499: iand
    //   500: iconst_2
    //   501: if_icmpne +18 -> 519
    //   504: aload_0
    //   505: new 88	com/appbrain/b/ac
    //   508: dup
    //   509: aload_0
    //   510: getfield 90	com/appbrain/e/at:e	Lcom/appbrain/b/q;
    //   513: invokespecial 93	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   516: putfield 90	com/appbrain/e/at:e	Lcom/appbrain/b/q;
    //   519: iload_3
    //   520: iconst_4
    //   521: iand
    //   522: iconst_4
    //   523: if_icmpne +18 -> 541
    //   526: aload_0
    //   527: new 88	com/appbrain/b/ac
    //   530: dup
    //   531: aload_0
    //   532: getfield 95	com/appbrain/e/at:f	Lcom/appbrain/b/q;
    //   535: invokespecial 93	com/appbrain/b/ac:<init>	(Lcom/appbrain/b/q;)V
    //   538: putfield 95	com/appbrain/e/at:f	Lcom/appbrain/b/q;
    //   541: return
    //   542: aconst_null
    //   543: astore 9
    //   545: goto -388 -> 157
    //   548: goto -452 -> 96
    //   551: iconst_1
    //   552: istore 8
    //   554: goto -531 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	557	0	this	at
    //   0	557	1	paramg	com.appbrain.b.g
    //   0	557	2	paramj	com.appbrain.b.j
    //   22	500	3	j	int
    //   32	450	4	k	int
    //   41	412	5	m	int
    //   29	450	6	n	int
    //   35	450	7	i1	int
    //   19	534	8	i2	int
    //   155	389	9	localab	ab
    // Exception table:
    //   from	to	target	type
    //   37	43	245	com/appbrain/b/o
    //   105	114	245	com/appbrain/b/o
    //   129	139	245	com/appbrain/b/o
    //   148	157	245	com/appbrain/b/o
    //   166	181	245	com/appbrain/b/o
    //   195	205	245	com/appbrain/b/o
    //   214	223	245	com/appbrain/b/o
    //   232	242	245	com/appbrain/b/o
    //   324	335	245	com/appbrain/b/o
    //   352	365	245	com/appbrain/b/o
    //   411	422	245	com/appbrain/b/o
    //   439	452	245	com/appbrain/b/o
    //   467	477	245	com/appbrain/b/o
    //   486	494	245	com/appbrain/b/o
    //   37	43	256	finally
    //   105	114	256	finally
    //   129	139	256	finally
    //   148	157	256	finally
    //   166	181	256	finally
    //   195	205	256	finally
    //   214	223	256	finally
    //   232	242	256	finally
    //   250	256	256	finally
    //   324	335	256	finally
    //   352	365	256	finally
    //   376	392	256	finally
    //   411	422	256	finally
    //   439	452	256	finally
    //   467	477	256	finally
    //   486	494	256	finally
    //   37	43	371	java/io/IOException
    //   105	114	371	java/io/IOException
    //   129	139	371	java/io/IOException
    //   148	157	371	java/io/IOException
    //   166	181	371	java/io/IOException
    //   195	205	371	java/io/IOException
    //   214	223	371	java/io/IOException
    //   232	242	371	java/io/IOException
    //   324	335	371	java/io/IOException
    //   352	365	371	java/io/IOException
    //   411	422	371	java/io/IOException
    //   439	452	371	java/io/IOException
    //   467	477	371	java/io/IOException
    //   486	494	371	java/io/IOException
  }
  
  public static at f()
  {
    return b;
  }
  
  public static au j()
  {
    return au.f();
  }
  
  private d k()
  {
    Object localObject = this.g;
    if ((localObject instanceof String))
    {
      localObject = d.a((String)localObject);
      this.g = localObject;
      return (d)localObject;
    }
    return (d)localObject;
  }
  
  private void l()
  {
    this.d = aa.f();
    this.e = p.a;
    this.f = p.a;
    this.g = "";
  }
  
  public final void a(h paramh)
  {
    int m = 0;
    c();
    if ((this.c & 0x1) == 1) {
      paramh.a(1, this.d);
    }
    int j = 0;
    int k;
    for (;;)
    {
      k = m;
      if (j >= this.e.size()) {
        break;
      }
      paramh.a(2, this.e.a(j));
      j += 1;
    }
    while (k < this.f.size())
    {
      paramh.a(3, this.f.a(k));
      k += 1;
    }
    if ((this.c & 0x2) == 2) {
      paramh.a(4, k());
    }
  }
  
  public final int c()
  {
    int n = 0;
    int j = this.i;
    if (j != -1) {
      return j;
    }
    if ((this.c & 0x1) == 1) {}
    for (j = h.b(1, this.d) + 0;; j = 0)
    {
      int m = 0;
      int k = 0;
      while (m < this.e.size())
      {
        k += h.a(this.e.a(m));
        m += 1;
      }
      int i2 = this.e.size();
      int i1 = 0;
      m = n;
      n = i1;
      while (m < this.f.size())
      {
        n += h.a(this.f.a(m));
        m += 1;
      }
      k = n + (i2 * 1 + (j + k)) + this.f.size() * 1;
      j = k;
      if ((this.c & 0x2) == 2) {
        j = k + h.b(4, k());
      }
      this.i = j;
      return j;
    }
  }
  
  public final boolean e()
  {
    int j = this.h;
    if (j != -1) {
      return j == 1;
    }
    this.h = 1;
    return true;
  }
  
  public final boolean g()
  {
    return (this.c & 0x1) == 1;
  }
  
  public final aa h()
  {
    return this.d;
  }
  
  public final boolean i()
  {
    return (this.c & 0x2) == 2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */