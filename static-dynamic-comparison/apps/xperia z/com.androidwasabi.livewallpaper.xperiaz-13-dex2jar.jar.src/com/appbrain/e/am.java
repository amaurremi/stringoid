package com.appbrain.e;

import com.appbrain.b.d;
import com.appbrain.b.h;
import com.appbrain.b.k;
import com.appbrain.b.w;

public final class am
  extends k
  implements ao
{
  public static w a = new bc();
  private static final am b;
  private int c;
  private aa d;
  private int e;
  private int f;
  private ap g;
  private int h;
  private boolean i;
  private Object j;
  private byte k = -1;
  private int l = -1;
  
  static
  {
    am localam = new am((byte)0);
    b = localam;
    localam.v();
  }
  
  private am()
  {
    super((byte)0);
  }
  
  private am(byte paramByte) {}
  
  /* Error */
  private am(com.appbrain.b.g paramg, com.appbrain.b.j paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 50	com/appbrain/b/k:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 47	com/appbrain/e/am:k	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 49	com/appbrain/e/am:l	I
    //   14: aload_0
    //   15: invokespecial 43	com/appbrain/e/am:v	()V
    //   18: iconst_0
    //   19: istore_3
    //   20: iload_3
    //   21: ifne +341 -> 362
    //   24: aload_1
    //   25: invokevirtual 62	com/appbrain/b/g:a	()I
    //   28: istore 4
    //   30: iload 4
    //   32: lookupswitch	default:+337->369, 0:+340->372, 10:+90->122, 32:+171->203, 40:+209->241, 48:+230->262, 56:+264->296, 64:+286->318, 74:+308->340
    //   108: aload_1
    //   109: iload 4
    //   111: invokevirtual 65	com/appbrain/b/g:b	(I)Z
    //   114: ifne -94 -> 20
    //   117: iconst_1
    //   118: istore_3
    //   119: goto -99 -> 20
    //   122: aload_0
    //   123: getfield 67	com/appbrain/e/am:c	I
    //   126: iconst_1
    //   127: iand
    //   128: iconst_1
    //   129: if_icmpne +234 -> 363
    //   132: aload_0
    //   133: getfield 69	com/appbrain/e/am:d	Lcom/appbrain/e/aa;
    //   136: invokevirtual 75	com/appbrain/e/aa:ao	()Lcom/appbrain/e/ab;
    //   139: astore 5
    //   141: aload_0
    //   142: aload_1
    //   143: getstatic 76	com/appbrain/e/aa:a	Lcom/appbrain/b/w;
    //   146: aload_2
    //   147: invokevirtual 79	com/appbrain/b/g:a	(Lcom/appbrain/b/w;Lcom/appbrain/b/j;)Lcom/appbrain/b/t;
    //   150: checkcast 71	com/appbrain/e/aa
    //   153: putfield 69	com/appbrain/e/am:d	Lcom/appbrain/e/aa;
    //   156: aload 5
    //   158: ifnull +22 -> 180
    //   161: aload 5
    //   163: aload_0
    //   164: getfield 69	com/appbrain/e/am:d	Lcom/appbrain/e/aa;
    //   167: invokevirtual 84	com/appbrain/e/ab:a	(Lcom/appbrain/e/aa;)Lcom/appbrain/e/ab;
    //   170: pop
    //   171: aload_0
    //   172: aload 5
    //   174: invokevirtual 87	com/appbrain/e/ab:f	()Lcom/appbrain/e/aa;
    //   177: putfield 69	com/appbrain/e/am:d	Lcom/appbrain/e/aa;
    //   180: aload_0
    //   181: aload_0
    //   182: getfield 67	com/appbrain/e/am:c	I
    //   185: iconst_1
    //   186: ior
    //   187: putfield 67	com/appbrain/e/am:c	I
    //   190: goto -170 -> 20
    //   193: astore_1
    //   194: aload_1
    //   195: aload_0
    //   196: invokevirtual 90	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   199: athrow
    //   200: astore_1
    //   201: aload_1
    //   202: athrow
    //   203: aload_0
    //   204: aload_0
    //   205: getfield 67	com/appbrain/e/am:c	I
    //   208: iconst_2
    //   209: ior
    //   210: putfield 67	com/appbrain/e/am:c	I
    //   213: aload_0
    //   214: aload_1
    //   215: invokevirtual 92	com/appbrain/b/g:c	()I
    //   218: putfield 94	com/appbrain/e/am:e	I
    //   221: goto -201 -> 20
    //   224: astore_1
    //   225: new 55	com/appbrain/b/o
    //   228: dup
    //   229: aload_1
    //   230: invokevirtual 98	java/io/IOException:getMessage	()Ljava/lang/String;
    //   233: invokespecial 101	com/appbrain/b/o:<init>	(Ljava/lang/String;)V
    //   236: aload_0
    //   237: invokevirtual 90	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   240: athrow
    //   241: aload_0
    //   242: aload_0
    //   243: getfield 67	com/appbrain/e/am:c	I
    //   246: iconst_4
    //   247: ior
    //   248: putfield 67	com/appbrain/e/am:c	I
    //   251: aload_0
    //   252: aload_1
    //   253: invokevirtual 92	com/appbrain/b/g:c	()I
    //   256: putfield 103	com/appbrain/e/am:f	I
    //   259: goto -239 -> 20
    //   262: aload_1
    //   263: invokevirtual 105	com/appbrain/b/g:f	()I
    //   266: invokestatic 110	com/appbrain/e/ap:a	(I)Lcom/appbrain/e/ap;
    //   269: astore 5
    //   271: aload 5
    //   273: ifnull -253 -> 20
    //   276: aload_0
    //   277: aload_0
    //   278: getfield 67	com/appbrain/e/am:c	I
    //   281: bipush 8
    //   283: ior
    //   284: putfield 67	com/appbrain/e/am:c	I
    //   287: aload_0
    //   288: aload 5
    //   290: putfield 112	com/appbrain/e/am:g	Lcom/appbrain/e/ap;
    //   293: goto -273 -> 20
    //   296: aload_0
    //   297: aload_0
    //   298: getfield 67	com/appbrain/e/am:c	I
    //   301: bipush 16
    //   303: ior
    //   304: putfield 67	com/appbrain/e/am:c	I
    //   307: aload_0
    //   308: aload_1
    //   309: invokevirtual 92	com/appbrain/b/g:c	()I
    //   312: putfield 114	com/appbrain/e/am:h	I
    //   315: goto -295 -> 20
    //   318: aload_0
    //   319: aload_0
    //   320: getfield 67	com/appbrain/e/am:c	I
    //   323: bipush 32
    //   325: ior
    //   326: putfield 67	com/appbrain/e/am:c	I
    //   329: aload_0
    //   330: aload_1
    //   331: invokevirtual 117	com/appbrain/b/g:d	()Z
    //   334: putfield 119	com/appbrain/e/am:i	Z
    //   337: goto -317 -> 20
    //   340: aload_0
    //   341: aload_0
    //   342: getfield 67	com/appbrain/e/am:c	I
    //   345: bipush 64
    //   347: ior
    //   348: putfield 67	com/appbrain/e/am:c	I
    //   351: aload_0
    //   352: aload_1
    //   353: invokevirtual 122	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   356: putfield 124	com/appbrain/e/am:j	Ljava/lang/Object;
    //   359: goto -339 -> 20
    //   362: return
    //   363: aconst_null
    //   364: astore 5
    //   366: goto -225 -> 141
    //   369: goto -261 -> 108
    //   372: iconst_1
    //   373: istore_3
    //   374: goto -354 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	this	am
    //   0	377	1	paramg	com.appbrain.b.g
    //   0	377	2	paramj	com.appbrain.b.j
    //   19	355	3	m	int
    //   28	82	4	n	int
    //   139	226	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	30	193	com/appbrain/b/o
    //   108	117	193	com/appbrain/b/o
    //   122	141	193	com/appbrain/b/o
    //   141	156	193	com/appbrain/b/o
    //   161	180	193	com/appbrain/b/o
    //   180	190	193	com/appbrain/b/o
    //   203	221	193	com/appbrain/b/o
    //   241	259	193	com/appbrain/b/o
    //   262	271	193	com/appbrain/b/o
    //   276	293	193	com/appbrain/b/o
    //   296	315	193	com/appbrain/b/o
    //   318	337	193	com/appbrain/b/o
    //   340	359	193	com/appbrain/b/o
    //   24	30	200	finally
    //   108	117	200	finally
    //   122	141	200	finally
    //   141	156	200	finally
    //   161	180	200	finally
    //   180	190	200	finally
    //   194	200	200	finally
    //   203	221	200	finally
    //   225	241	200	finally
    //   241	259	200	finally
    //   262	271	200	finally
    //   276	293	200	finally
    //   296	315	200	finally
    //   318	337	200	finally
    //   340	359	200	finally
    //   24	30	224	java/io/IOException
    //   108	117	224	java/io/IOException
    //   122	141	224	java/io/IOException
    //   141	156	224	java/io/IOException
    //   161	180	224	java/io/IOException
    //   180	190	224	java/io/IOException
    //   203	221	224	java/io/IOException
    //   241	259	224	java/io/IOException
    //   262	271	224	java/io/IOException
    //   276	293	224	java/io/IOException
    //   296	315	224	java/io/IOException
    //   318	337	224	java/io/IOException
    //   340	359	224	java/io/IOException
  }
  
  public static am f()
  {
    return b;
  }
  
  public static an t()
  {
    return an.f();
  }
  
  private d u()
  {
    Object localObject = this.j;
    if ((localObject instanceof String))
    {
      localObject = d.a((String)localObject);
      this.j = localObject;
      return (d)localObject;
    }
    return (d)localObject;
  }
  
  private void v()
  {
    this.d = aa.f();
    this.e = 0;
    this.f = 0;
    this.g = ap.a;
    this.h = 0;
    this.i = false;
    this.j = "";
  }
  
  public final void a(h paramh)
  {
    c();
    if ((this.c & 0x1) == 1) {
      paramh.a(1, this.d);
    }
    if ((this.c & 0x2) == 2) {
      paramh.a(4, this.e);
    }
    if ((this.c & 0x4) == 4) {
      paramh.a(5, this.f);
    }
    if ((this.c & 0x8) == 8) {
      paramh.b(6, this.g.a());
    }
    if ((this.c & 0x10) == 16) {
      paramh.a(7, this.h);
    }
    if ((this.c & 0x20) == 32) {
      paramh.a(8, this.i);
    }
    if ((this.c & 0x40) == 64) {
      paramh.a(9, u());
    }
  }
  
  public final int c()
  {
    int m = this.l;
    if (m != -1) {
      return m;
    }
    int n = 0;
    if ((this.c & 0x1) == 1) {
      n = h.b(1, this.d) + 0;
    }
    m = n;
    if ((this.c & 0x2) == 2) {
      m = n + h.c(4, this.e);
    }
    n = m;
    if ((this.c & 0x4) == 4) {
      n = m + h.c(5, this.f);
    }
    m = n;
    if ((this.c & 0x8) == 8) {
      m = n + h.d(6, this.g.a());
    }
    n = m;
    if ((this.c & 0x10) == 16) {
      n = m + h.c(7, this.h);
    }
    m = n;
    if ((this.c & 0x20) == 32)
    {
      boolean bool = this.i;
      m = n + h.a(8);
    }
    n = m;
    if ((this.c & 0x40) == 64) {
      n = m + h.b(9, u());
    }
    this.l = n;
    return n;
  }
  
  public final boolean e()
  {
    int m = this.k;
    if (m != -1) {
      return m == 1;
    }
    this.k = 1;
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
  
  public final int j()
  {
    return this.e;
  }
  
  public final boolean k()
  {
    return (this.c & 0x4) == 4;
  }
  
  public final int l()
  {
    return this.f;
  }
  
  public final boolean m()
  {
    return (this.c & 0x8) == 8;
  }
  
  public final ap n()
  {
    return this.g;
  }
  
  public final boolean o()
  {
    return (this.c & 0x10) == 16;
  }
  
  public final int p()
  {
    return this.h;
  }
  
  public final boolean q()
  {
    return (this.c & 0x20) == 32;
  }
  
  public final boolean r()
  {
    return this.i;
  }
  
  public final boolean s()
  {
    return (this.c & 0x40) == 64;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */