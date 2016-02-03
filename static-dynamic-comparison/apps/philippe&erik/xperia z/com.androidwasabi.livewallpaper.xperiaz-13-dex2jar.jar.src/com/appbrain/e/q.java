package com.appbrain.e;

import com.appbrain.b.h;
import com.appbrain.b.k;
import com.appbrain.b.t;
import com.appbrain.b.w;
import java.util.Collections;
import java.util.List;

public final class q
  extends k
  implements s
{
  public static w a = new y();
  private static final q b;
  private int c;
  private aa d;
  private boolean e;
  private List f;
  private boolean g;
  private List h;
  private byte i = -1;
  private int j = -1;
  
  static
  {
    q localq = new q((byte)0);
    b = localq;
    localq.o();
  }
  
  private q()
  {
    super((byte)0);
  }
  
  private q(byte paramByte) {}
  
  /* Error */
  private q(com.appbrain.b.g paramg, com.appbrain.b.j paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 47	com/appbrain/b/k:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 44	com/appbrain/e/q:i	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 46	com/appbrain/e/q:j	I
    //   14: aload_0
    //   15: invokespecial 40	com/appbrain/e/q:o	()V
    //   18: iconst_0
    //   19: istore 6
    //   21: iconst_0
    //   22: istore_3
    //   23: iload 6
    //   25: ifne +507 -> 532
    //   28: iload_3
    //   29: istore 7
    //   31: iload_3
    //   32: istore 4
    //   34: iload_3
    //   35: istore 8
    //   37: aload_1
    //   38: invokevirtual 59	com/appbrain/b/g:a	()I
    //   41: istore 5
    //   43: iload 5
    //   45: lookupswitch	default:+559->604, 0:+562->607, 10:+83->128, 16:+262->307, 26:+322->367, 32:+393->438, 42:+432->477
    //   104: iload_3
    //   105: istore 7
    //   107: iload_3
    //   108: istore 4
    //   110: iload_3
    //   111: istore 8
    //   113: aload_1
    //   114: iload 5
    //   116: invokevirtual 62	com/appbrain/b/g:b	(I)Z
    //   119: ifne +482 -> 601
    //   122: iconst_1
    //   123: istore 6
    //   125: goto -102 -> 23
    //   128: iload_3
    //   129: istore 7
    //   131: iload_3
    //   132: istore 4
    //   134: iload_3
    //   135: istore 8
    //   137: aload_0
    //   138: getfield 64	com/appbrain/e/q:c	I
    //   141: iconst_1
    //   142: iand
    //   143: iconst_1
    //   144: if_icmpne +451 -> 595
    //   147: iload_3
    //   148: istore 7
    //   150: iload_3
    //   151: istore 4
    //   153: iload_3
    //   154: istore 8
    //   156: aload_0
    //   157: getfield 66	com/appbrain/e/q:d	Lcom/appbrain/e/aa;
    //   160: invokevirtual 72	com/appbrain/e/aa:ao	()Lcom/appbrain/e/ab;
    //   163: astore 9
    //   165: iload_3
    //   166: istore 7
    //   168: iload_3
    //   169: istore 4
    //   171: iload_3
    //   172: istore 8
    //   174: aload_0
    //   175: aload_1
    //   176: getstatic 73	com/appbrain/e/aa:a	Lcom/appbrain/b/w;
    //   179: aload_2
    //   180: invokevirtual 76	com/appbrain/b/g:a	(Lcom/appbrain/b/w;Lcom/appbrain/b/j;)Lcom/appbrain/b/t;
    //   183: checkcast 68	com/appbrain/e/aa
    //   186: putfield 66	com/appbrain/e/q:d	Lcom/appbrain/e/aa;
    //   189: aload 9
    //   191: ifnull +40 -> 231
    //   194: iload_3
    //   195: istore 7
    //   197: iload_3
    //   198: istore 4
    //   200: iload_3
    //   201: istore 8
    //   203: aload 9
    //   205: aload_0
    //   206: getfield 66	com/appbrain/e/q:d	Lcom/appbrain/e/aa;
    //   209: invokevirtual 81	com/appbrain/e/ab:a	(Lcom/appbrain/e/aa;)Lcom/appbrain/e/ab;
    //   212: pop
    //   213: iload_3
    //   214: istore 7
    //   216: iload_3
    //   217: istore 4
    //   219: iload_3
    //   220: istore 8
    //   222: aload_0
    //   223: aload 9
    //   225: invokevirtual 84	com/appbrain/e/ab:f	()Lcom/appbrain/e/aa;
    //   228: putfield 66	com/appbrain/e/q:d	Lcom/appbrain/e/aa;
    //   231: iload_3
    //   232: istore 7
    //   234: iload_3
    //   235: istore 4
    //   237: iload_3
    //   238: istore 8
    //   240: aload_0
    //   241: aload_0
    //   242: getfield 64	com/appbrain/e/q:c	I
    //   245: iconst_1
    //   246: ior
    //   247: putfield 64	com/appbrain/e/q:c	I
    //   250: goto -227 -> 23
    //   253: astore_1
    //   254: iload 7
    //   256: istore 4
    //   258: aload_1
    //   259: aload_0
    //   260: invokevirtual 87	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   263: athrow
    //   264: astore_1
    //   265: iload 4
    //   267: iconst_4
    //   268: iand
    //   269: iconst_4
    //   270: if_icmpne +14 -> 284
    //   273: aload_0
    //   274: aload_0
    //   275: getfield 89	com/appbrain/e/q:f	Ljava/util/List;
    //   278: invokestatic 95	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   281: putfield 89	com/appbrain/e/q:f	Ljava/util/List;
    //   284: iload 4
    //   286: bipush 16
    //   288: iand
    //   289: bipush 16
    //   291: if_icmpne +14 -> 305
    //   294: aload_0
    //   295: aload_0
    //   296: getfield 97	com/appbrain/e/q:h	Ljava/util/List;
    //   299: invokestatic 95	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   302: putfield 97	com/appbrain/e/q:h	Ljava/util/List;
    //   305: aload_1
    //   306: athrow
    //   307: iload_3
    //   308: istore 7
    //   310: iload_3
    //   311: istore 4
    //   313: iload_3
    //   314: istore 8
    //   316: aload_0
    //   317: aload_0
    //   318: getfield 64	com/appbrain/e/q:c	I
    //   321: iconst_2
    //   322: ior
    //   323: putfield 64	com/appbrain/e/q:c	I
    //   326: iload_3
    //   327: istore 7
    //   329: iload_3
    //   330: istore 4
    //   332: iload_3
    //   333: istore 8
    //   335: aload_0
    //   336: aload_1
    //   337: invokevirtual 100	com/appbrain/b/g:d	()Z
    //   340: putfield 102	com/appbrain/e/q:e	Z
    //   343: goto -320 -> 23
    //   346: astore_1
    //   347: iload 8
    //   349: istore 4
    //   351: new 52	com/appbrain/b/o
    //   354: dup
    //   355: aload_1
    //   356: invokevirtual 106	java/io/IOException:getMessage	()Ljava/lang/String;
    //   359: invokespecial 109	com/appbrain/b/o:<init>	(Ljava/lang/String;)V
    //   362: aload_0
    //   363: invokevirtual 87	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   366: athrow
    //   367: iload_3
    //   368: istore 5
    //   370: iload_3
    //   371: iconst_4
    //   372: iand
    //   373: iconst_4
    //   374: if_icmpeq +28 -> 402
    //   377: iload_3
    //   378: istore 7
    //   380: iload_3
    //   381: istore 4
    //   383: iload_3
    //   384: istore 8
    //   386: aload_0
    //   387: new 111	java/util/ArrayList
    //   390: dup
    //   391: invokespecial 112	java/util/ArrayList:<init>	()V
    //   394: putfield 89	com/appbrain/e/q:f	Ljava/util/List;
    //   397: iload_3
    //   398: iconst_4
    //   399: ior
    //   400: istore 5
    //   402: iload 5
    //   404: istore 7
    //   406: iload 5
    //   408: istore 4
    //   410: iload 5
    //   412: istore 8
    //   414: aload_0
    //   415: getfield 89	com/appbrain/e/q:f	Ljava/util/List;
    //   418: aload_1
    //   419: getstatic 115	com/appbrain/e/b:a	Lcom/appbrain/b/w;
    //   422: aload_2
    //   423: invokevirtual 76	com/appbrain/b/g:a	(Lcom/appbrain/b/w;Lcom/appbrain/b/j;)Lcom/appbrain/b/t;
    //   426: invokeinterface 121 2 0
    //   431: pop
    //   432: iload 5
    //   434: istore_3
    //   435: goto -412 -> 23
    //   438: iload_3
    //   439: istore 7
    //   441: iload_3
    //   442: istore 4
    //   444: iload_3
    //   445: istore 8
    //   447: aload_0
    //   448: aload_0
    //   449: getfield 64	com/appbrain/e/q:c	I
    //   452: iconst_4
    //   453: ior
    //   454: putfield 64	com/appbrain/e/q:c	I
    //   457: iload_3
    //   458: istore 7
    //   460: iload_3
    //   461: istore 4
    //   463: iload_3
    //   464: istore 8
    //   466: aload_0
    //   467: aload_1
    //   468: invokevirtual 100	com/appbrain/b/g:d	()Z
    //   471: putfield 123	com/appbrain/e/q:g	Z
    //   474: goto -451 -> 23
    //   477: iload_3
    //   478: bipush 16
    //   480: iand
    //   481: bipush 16
    //   483: if_icmpeq +109 -> 592
    //   486: iload_3
    //   487: istore 7
    //   489: iload_3
    //   490: istore 4
    //   492: iload_3
    //   493: istore 8
    //   495: aload_0
    //   496: new 111	java/util/ArrayList
    //   499: dup
    //   500: invokespecial 112	java/util/ArrayList:<init>	()V
    //   503: putfield 97	com/appbrain/e/q:h	Ljava/util/List;
    //   506: iload_3
    //   507: bipush 16
    //   509: ior
    //   510: istore_3
    //   511: aload_0
    //   512: getfield 97	com/appbrain/e/q:h	Ljava/util/List;
    //   515: aload_1
    //   516: getstatic 126	com/appbrain/e/e:a	Lcom/appbrain/b/w;
    //   519: aload_2
    //   520: invokevirtual 76	com/appbrain/b/g:a	(Lcom/appbrain/b/w;Lcom/appbrain/b/j;)Lcom/appbrain/b/t;
    //   523: invokeinterface 121 2 0
    //   528: pop
    //   529: goto -506 -> 23
    //   532: iload_3
    //   533: iconst_4
    //   534: iand
    //   535: iconst_4
    //   536: if_icmpne +14 -> 550
    //   539: aload_0
    //   540: aload_0
    //   541: getfield 89	com/appbrain/e/q:f	Ljava/util/List;
    //   544: invokestatic 95	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   547: putfield 89	com/appbrain/e/q:f	Ljava/util/List;
    //   550: iload_3
    //   551: bipush 16
    //   553: iand
    //   554: bipush 16
    //   556: if_icmpne +14 -> 570
    //   559: aload_0
    //   560: aload_0
    //   561: getfield 97	com/appbrain/e/q:h	Ljava/util/List;
    //   564: invokestatic 95	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   567: putfield 97	com/appbrain/e/q:h	Ljava/util/List;
    //   570: return
    //   571: astore_1
    //   572: iload_3
    //   573: istore 4
    //   575: goto -310 -> 265
    //   578: astore_1
    //   579: iload_3
    //   580: istore 4
    //   582: goto -231 -> 351
    //   585: astore_1
    //   586: iload_3
    //   587: istore 4
    //   589: goto -331 -> 258
    //   592: goto -81 -> 511
    //   595: aconst_null
    //   596: astore 9
    //   598: goto -433 -> 165
    //   601: goto -72 -> 529
    //   604: goto -500 -> 104
    //   607: iconst_1
    //   608: istore 6
    //   610: goto -587 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	this	q
    //   0	613	1	paramg	com.appbrain.b.g
    //   0	613	2	paramj	com.appbrain.b.j
    //   22	565	3	k	int
    //   32	556	4	m	int
    //   41	392	5	n	int
    //   19	590	6	i1	int
    //   29	459	7	i2	int
    //   35	459	8	i3	int
    //   163	434	9	localab	ab
    // Exception table:
    //   from	to	target	type
    //   37	43	253	com/appbrain/b/o
    //   113	122	253	com/appbrain/b/o
    //   137	147	253	com/appbrain/b/o
    //   156	165	253	com/appbrain/b/o
    //   174	189	253	com/appbrain/b/o
    //   203	213	253	com/appbrain/b/o
    //   222	231	253	com/appbrain/b/o
    //   240	250	253	com/appbrain/b/o
    //   316	326	253	com/appbrain/b/o
    //   335	343	253	com/appbrain/b/o
    //   386	397	253	com/appbrain/b/o
    //   414	432	253	com/appbrain/b/o
    //   447	457	253	com/appbrain/b/o
    //   466	474	253	com/appbrain/b/o
    //   495	506	253	com/appbrain/b/o
    //   37	43	264	finally
    //   113	122	264	finally
    //   137	147	264	finally
    //   156	165	264	finally
    //   174	189	264	finally
    //   203	213	264	finally
    //   222	231	264	finally
    //   240	250	264	finally
    //   258	264	264	finally
    //   316	326	264	finally
    //   335	343	264	finally
    //   351	367	264	finally
    //   386	397	264	finally
    //   414	432	264	finally
    //   447	457	264	finally
    //   466	474	264	finally
    //   495	506	264	finally
    //   37	43	346	java/io/IOException
    //   113	122	346	java/io/IOException
    //   137	147	346	java/io/IOException
    //   156	165	346	java/io/IOException
    //   174	189	346	java/io/IOException
    //   203	213	346	java/io/IOException
    //   222	231	346	java/io/IOException
    //   240	250	346	java/io/IOException
    //   316	326	346	java/io/IOException
    //   335	343	346	java/io/IOException
    //   386	397	346	java/io/IOException
    //   414	432	346	java/io/IOException
    //   447	457	346	java/io/IOException
    //   466	474	346	java/io/IOException
    //   495	506	346	java/io/IOException
    //   511	529	571	finally
    //   511	529	578	java/io/IOException
    //   511	529	585	com/appbrain/b/o
  }
  
  public static q f()
  {
    return b;
  }
  
  public static r n()
  {
    return r.g();
  }
  
  private void o()
  {
    this.d = aa.f();
    this.e = false;
    this.f = Collections.emptyList();
    this.g = false;
    this.h = Collections.emptyList();
  }
  
  public final void a(h paramh)
  {
    int m = 0;
    c();
    if ((this.c & 0x1) == 1) {
      paramh.a(1, this.d);
    }
    if ((this.c & 0x2) == 2) {
      paramh.a(2, this.e);
    }
    int k = 0;
    while (k < this.f.size())
    {
      paramh.a(3, (t)this.f.get(k));
      k += 1;
    }
    k = m;
    if ((this.c & 0x4) == 4)
    {
      paramh.a(4, this.g);
      k = m;
    }
    while (k < this.h.size())
    {
      paramh.a(5, (t)this.h.get(k));
      k += 1;
    }
  }
  
  public final int c()
  {
    int i1 = 0;
    int k = this.j;
    if (k != -1) {
      return k;
    }
    if ((this.c & 0x1) == 1) {}
    for (int m = h.b(1, this.d) + 0;; m = 0)
    {
      k = m;
      boolean bool;
      if ((this.c & 0x2) == 2)
      {
        bool = this.e;
        k = m + h.a(2);
      }
      m = 0;
      while (m < this.f.size())
      {
        k += h.b(3, (t)this.f.get(m));
        m += 1;
      }
      int n = i1;
      m = k;
      if ((this.c & 0x4) == 4)
      {
        bool = this.g;
        m = k + h.a(4);
        n = i1;
      }
      while (n < this.h.size())
      {
        m += h.b(5, (t)this.h.get(n));
        n += 1;
      }
      this.j = m;
      return m;
    }
  }
  
  public final boolean e()
  {
    int k = this.i;
    if (k != -1) {
      return k == 1;
    }
    this.i = 1;
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
  
  public final boolean j()
  {
    return this.e;
  }
  
  public final boolean k()
  {
    return (this.c & 0x4) == 4;
  }
  
  public final boolean l()
  {
    return this.g;
  }
  
  public final List m()
  {
    return this.h;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */