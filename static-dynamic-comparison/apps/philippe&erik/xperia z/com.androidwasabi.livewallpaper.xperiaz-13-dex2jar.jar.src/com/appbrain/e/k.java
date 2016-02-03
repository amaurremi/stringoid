package com.appbrain.e;

import com.appbrain.b.h;
import com.appbrain.b.t;
import java.util.Collections;
import java.util.List;

public final class k
  extends com.appbrain.b.k
  implements m
{
  public static com.appbrain.b.w a = new w();
  private static final k b;
  private int c;
  private List d;
  private List e;
  private boolean f;
  private boolean g;
  private byte h = -1;
  private int i = -1;
  
  static
  {
    k localk = new k((byte)0);
    b = localk;
    localk.p();
  }
  
  private k()
  {
    super((byte)0);
  }
  
  private k(byte paramByte) {}
  
  /* Error */
  private k(com.appbrain.b.g paramg, com.appbrain.b.j paramj)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_0
    //   4: invokespecial 45	com/appbrain/b/k:<init>	()V
    //   7: aload_0
    //   8: iconst_m1
    //   9: putfield 42	com/appbrain/e/k:h	B
    //   12: aload_0
    //   13: iconst_m1
    //   14: putfield 44	com/appbrain/e/k:i	I
    //   17: aload_0
    //   18: invokespecial 38	com/appbrain/e/k:p	()V
    //   21: iconst_0
    //   22: istore_3
    //   23: iload 8
    //   25: ifne +388 -> 413
    //   28: iload_3
    //   29: istore 6
    //   31: iload_3
    //   32: istore 4
    //   34: iload_3
    //   35: istore 7
    //   37: aload_1
    //   38: invokevirtual 57	com/appbrain/b/g:a	()I
    //   41: istore 5
    //   43: iload 5
    //   45: lookupswitch	default:+405->450, 0:+408->453, 10:+75->120, 18:+198->243, 24:+290->335, 32:+329->374
    //   96: iload_3
    //   97: istore 6
    //   99: iload_3
    //   100: istore 4
    //   102: iload_3
    //   103: istore 7
    //   105: aload_1
    //   106: iload 5
    //   108: invokevirtual 60	com/appbrain/b/g:b	(I)Z
    //   111: ifne -88 -> 23
    //   114: iconst_1
    //   115: istore 8
    //   117: goto -94 -> 23
    //   120: iload_3
    //   121: istore 5
    //   123: iload_3
    //   124: iconst_1
    //   125: iand
    //   126: iconst_1
    //   127: if_icmpeq +28 -> 155
    //   130: iload_3
    //   131: istore 6
    //   133: iload_3
    //   134: istore 4
    //   136: iload_3
    //   137: istore 7
    //   139: aload_0
    //   140: new 62	java/util/ArrayList
    //   143: dup
    //   144: invokespecial 63	java/util/ArrayList:<init>	()V
    //   147: putfield 65	com/appbrain/e/k:d	Ljava/util/List;
    //   150: iload_3
    //   151: iconst_1
    //   152: ior
    //   153: istore 5
    //   155: iload 5
    //   157: istore 6
    //   159: iload 5
    //   161: istore 4
    //   163: iload 5
    //   165: istore 7
    //   167: aload_0
    //   168: getfield 65	com/appbrain/e/k:d	Ljava/util/List;
    //   171: aload_1
    //   172: getstatic 68	com/appbrain/e/n:a	Lcom/appbrain/b/w;
    //   175: aload_2
    //   176: invokevirtual 71	com/appbrain/b/g:a	(Lcom/appbrain/b/w;Lcom/appbrain/b/j;)Lcom/appbrain/b/t;
    //   179: invokeinterface 77 2 0
    //   184: pop
    //   185: iload 5
    //   187: istore_3
    //   188: goto -165 -> 23
    //   191: astore_1
    //   192: iload 6
    //   194: istore 4
    //   196: aload_1
    //   197: aload_0
    //   198: invokevirtual 80	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   201: athrow
    //   202: astore_1
    //   203: iload 4
    //   205: iconst_1
    //   206: iand
    //   207: iconst_1
    //   208: if_icmpne +14 -> 222
    //   211: aload_0
    //   212: aload_0
    //   213: getfield 65	com/appbrain/e/k:d	Ljava/util/List;
    //   216: invokestatic 86	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   219: putfield 65	com/appbrain/e/k:d	Ljava/util/List;
    //   222: iload 4
    //   224: iconst_2
    //   225: iand
    //   226: iconst_2
    //   227: if_icmpne +14 -> 241
    //   230: aload_0
    //   231: aload_0
    //   232: getfield 88	com/appbrain/e/k:e	Ljava/util/List;
    //   235: invokestatic 86	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   238: putfield 88	com/appbrain/e/k:e	Ljava/util/List;
    //   241: aload_1
    //   242: athrow
    //   243: iload_3
    //   244: istore 5
    //   246: iload_3
    //   247: iconst_2
    //   248: iand
    //   249: iconst_2
    //   250: if_icmpeq +28 -> 278
    //   253: iload_3
    //   254: istore 6
    //   256: iload_3
    //   257: istore 4
    //   259: iload_3
    //   260: istore 7
    //   262: aload_0
    //   263: new 62	java/util/ArrayList
    //   266: dup
    //   267: invokespecial 63	java/util/ArrayList:<init>	()V
    //   270: putfield 88	com/appbrain/e/k:e	Ljava/util/List;
    //   273: iload_3
    //   274: iconst_2
    //   275: ior
    //   276: istore 5
    //   278: iload 5
    //   280: istore 6
    //   282: iload 5
    //   284: istore 4
    //   286: iload 5
    //   288: istore 7
    //   290: aload_0
    //   291: getfield 88	com/appbrain/e/k:e	Ljava/util/List;
    //   294: aload_1
    //   295: getstatic 68	com/appbrain/e/n:a	Lcom/appbrain/b/w;
    //   298: aload_2
    //   299: invokevirtual 71	com/appbrain/b/g:a	(Lcom/appbrain/b/w;Lcom/appbrain/b/j;)Lcom/appbrain/b/t;
    //   302: invokeinterface 77 2 0
    //   307: pop
    //   308: iload 5
    //   310: istore_3
    //   311: goto -288 -> 23
    //   314: astore_1
    //   315: iload 7
    //   317: istore 4
    //   319: new 50	com/appbrain/b/o
    //   322: dup
    //   323: aload_1
    //   324: invokevirtual 92	java/io/IOException:getMessage	()Ljava/lang/String;
    //   327: invokespecial 95	com/appbrain/b/o:<init>	(Ljava/lang/String;)V
    //   330: aload_0
    //   331: invokevirtual 80	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   334: athrow
    //   335: iload_3
    //   336: istore 6
    //   338: iload_3
    //   339: istore 4
    //   341: iload_3
    //   342: istore 7
    //   344: aload_0
    //   345: aload_0
    //   346: getfield 97	com/appbrain/e/k:c	I
    //   349: iconst_1
    //   350: ior
    //   351: putfield 97	com/appbrain/e/k:c	I
    //   354: iload_3
    //   355: istore 6
    //   357: iload_3
    //   358: istore 4
    //   360: iload_3
    //   361: istore 7
    //   363: aload_0
    //   364: aload_1
    //   365: invokevirtual 100	com/appbrain/b/g:d	()Z
    //   368: putfield 102	com/appbrain/e/k:f	Z
    //   371: goto -348 -> 23
    //   374: iload_3
    //   375: istore 6
    //   377: iload_3
    //   378: istore 4
    //   380: iload_3
    //   381: istore 7
    //   383: aload_0
    //   384: aload_0
    //   385: getfield 97	com/appbrain/e/k:c	I
    //   388: iconst_2
    //   389: ior
    //   390: putfield 97	com/appbrain/e/k:c	I
    //   393: iload_3
    //   394: istore 6
    //   396: iload_3
    //   397: istore 4
    //   399: iload_3
    //   400: istore 7
    //   402: aload_0
    //   403: aload_1
    //   404: invokevirtual 100	com/appbrain/b/g:d	()Z
    //   407: putfield 104	com/appbrain/e/k:g	Z
    //   410: goto -387 -> 23
    //   413: iload_3
    //   414: iconst_1
    //   415: iand
    //   416: iconst_1
    //   417: if_icmpne +14 -> 431
    //   420: aload_0
    //   421: aload_0
    //   422: getfield 65	com/appbrain/e/k:d	Ljava/util/List;
    //   425: invokestatic 86	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   428: putfield 65	com/appbrain/e/k:d	Ljava/util/List;
    //   431: iload_3
    //   432: iconst_2
    //   433: iand
    //   434: iconst_2
    //   435: if_icmpne +14 -> 449
    //   438: aload_0
    //   439: aload_0
    //   440: getfield 88	com/appbrain/e/k:e	Ljava/util/List;
    //   443: invokestatic 86	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   446: putfield 88	com/appbrain/e/k:e	Ljava/util/List;
    //   449: return
    //   450: goto -354 -> 96
    //   453: iconst_1
    //   454: istore 8
    //   456: goto -433 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	this	k
    //   0	459	1	paramg	com.appbrain.b.g
    //   0	459	2	paramj	com.appbrain.b.j
    //   22	412	3	j	int
    //   32	366	4	k	int
    //   41	268	5	m	int
    //   29	366	6	n	int
    //   35	366	7	i1	int
    //   1	454	8	i2	int
    // Exception table:
    //   from	to	target	type
    //   37	43	191	com/appbrain/b/o
    //   105	114	191	com/appbrain/b/o
    //   139	150	191	com/appbrain/b/o
    //   167	185	191	com/appbrain/b/o
    //   262	273	191	com/appbrain/b/o
    //   290	308	191	com/appbrain/b/o
    //   344	354	191	com/appbrain/b/o
    //   363	371	191	com/appbrain/b/o
    //   383	393	191	com/appbrain/b/o
    //   402	410	191	com/appbrain/b/o
    //   37	43	202	finally
    //   105	114	202	finally
    //   139	150	202	finally
    //   167	185	202	finally
    //   196	202	202	finally
    //   262	273	202	finally
    //   290	308	202	finally
    //   319	335	202	finally
    //   344	354	202	finally
    //   363	371	202	finally
    //   383	393	202	finally
    //   402	410	202	finally
    //   37	43	314	java/io/IOException
    //   105	114	314	java/io/IOException
    //   139	150	314	java/io/IOException
    //   167	185	314	java/io/IOException
    //   262	273	314	java/io/IOException
    //   290	308	314	java/io/IOException
    //   344	354	314	java/io/IOException
    //   363	371	314	java/io/IOException
    //   383	393	314	java/io/IOException
    //   402	410	314	java/io/IOException
  }
  
  public static l a(k paramk)
  {
    return l.f().a(paramk);
  }
  
  public static k f()
  {
    return b;
  }
  
  private void p()
  {
    this.d = Collections.emptyList();
    this.e = Collections.emptyList();
    this.f = false;
    this.g = false;
  }
  
  public final void a(h paramh)
  {
    int m = 0;
    c();
    int j = 0;
    int k;
    for (;;)
    {
      k = m;
      if (j >= this.d.size()) {
        break;
      }
      paramh.a(1, (t)this.d.get(j));
      j += 1;
    }
    while (k < this.e.size())
    {
      paramh.a(2, (t)this.e.get(k));
      k += 1;
    }
    if ((this.c & 0x1) == 1) {
      paramh.a(3, this.f);
    }
    if ((this.c & 0x2) == 2) {
      paramh.a(4, this.g);
    }
  }
  
  public final int c()
  {
    int i1 = 0;
    int j = this.i;
    if (j != -1) {
      return j;
    }
    int m = 0;
    j = 0;
    int n;
    for (;;)
    {
      n = i1;
      k = j;
      if (m >= this.d.size()) {
        break;
      }
      j += h.b(1, (t)this.d.get(m));
      m += 1;
    }
    while (n < this.e.size())
    {
      k += h.b(2, (t)this.e.get(n));
      n += 1;
    }
    j = k;
    boolean bool;
    if ((this.c & 0x1) == 1)
    {
      bool = this.f;
      j = k + h.a(3);
    }
    int k = j;
    if ((this.c & 0x2) == 2)
    {
      bool = this.g;
      k = j + h.a(4);
    }
    this.i = k;
    return k;
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
  
  public final List g()
  {
    return this.d;
  }
  
  public final int h()
  {
    return this.d.size();
  }
  
  public final List i()
  {
    return this.e;
  }
  
  public final int j()
  {
    return this.e.size();
  }
  
  public final boolean k()
  {
    return (this.c & 0x1) == 1;
  }
  
  public final boolean l()
  {
    return this.f;
  }
  
  public final boolean m()
  {
    return (this.c & 0x2) == 2;
  }
  
  public final boolean n()
  {
    return this.g;
  }
  
  public final l o()
  {
    return l.f().a(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */