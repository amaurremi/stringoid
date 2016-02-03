package com.appbrain.e;

import com.appbrain.b.d;
import com.appbrain.b.h;
import com.appbrain.b.k;
import com.appbrain.b.w;

public final class aq
  extends k
  implements as
{
  public static w a = new be();
  private static final aq b;
  private int c;
  private aa d;
  private Object e;
  private af f;
  private long g;
  private long h;
  private Object i;
  private Object j;
  private boolean k;
  private int l;
  private byte m = -1;
  private int n = -1;
  
  static
  {
    aq localaq = new aq((byte)0);
    b = localaq;
    localaq.C();
  }
  
  private aq()
  {
    super((byte)0);
  }
  
  private aq(byte paramByte) {}
  
  /* Error */
  private aq(com.appbrain.b.g paramg, com.appbrain.b.j paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 53	com/appbrain/b/k:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 50	com/appbrain/e/aq:m	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 52	com/appbrain/e/aq:n	I
    //   14: aload_0
    //   15: invokespecial 46	com/appbrain/e/aq:C	()V
    //   18: iconst_0
    //   19: istore_3
    //   20: iload_3
    //   21: ifne +403 -> 424
    //   24: aload_1
    //   25: invokevirtual 65	com/appbrain/b/g:a	()I
    //   28: istore 4
    //   30: iload 4
    //   32: lookupswitch	default:+399->431, 0:+402->434, 10:+106->138, 18:+187->219, 32:+225->257, 40:+258->290, 48:+280->312, 58:+302->334, 66:+324->356, 72:+346->378, 80:+369->401
    //   124: aload_1
    //   125: iload 4
    //   127: invokevirtual 68	com/appbrain/b/g:b	(I)Z
    //   130: ifne -110 -> 20
    //   133: iconst_1
    //   134: istore_3
    //   135: goto -115 -> 20
    //   138: aload_0
    //   139: getfield 70	com/appbrain/e/aq:c	I
    //   142: iconst_1
    //   143: iand
    //   144: iconst_1
    //   145: if_icmpne +280 -> 425
    //   148: aload_0
    //   149: getfield 72	com/appbrain/e/aq:d	Lcom/appbrain/e/aa;
    //   152: invokevirtual 78	com/appbrain/e/aa:ao	()Lcom/appbrain/e/ab;
    //   155: astore 5
    //   157: aload_0
    //   158: aload_1
    //   159: getstatic 79	com/appbrain/e/aa:a	Lcom/appbrain/b/w;
    //   162: aload_2
    //   163: invokevirtual 82	com/appbrain/b/g:a	(Lcom/appbrain/b/w;Lcom/appbrain/b/j;)Lcom/appbrain/b/t;
    //   166: checkcast 74	com/appbrain/e/aa
    //   169: putfield 72	com/appbrain/e/aq:d	Lcom/appbrain/e/aa;
    //   172: aload 5
    //   174: ifnull +22 -> 196
    //   177: aload 5
    //   179: aload_0
    //   180: getfield 72	com/appbrain/e/aq:d	Lcom/appbrain/e/aa;
    //   183: invokevirtual 87	com/appbrain/e/ab:a	(Lcom/appbrain/e/aa;)Lcom/appbrain/e/ab;
    //   186: pop
    //   187: aload_0
    //   188: aload 5
    //   190: invokevirtual 90	com/appbrain/e/ab:f	()Lcom/appbrain/e/aa;
    //   193: putfield 72	com/appbrain/e/aq:d	Lcom/appbrain/e/aa;
    //   196: aload_0
    //   197: aload_0
    //   198: getfield 70	com/appbrain/e/aq:c	I
    //   201: iconst_1
    //   202: ior
    //   203: putfield 70	com/appbrain/e/aq:c	I
    //   206: goto -186 -> 20
    //   209: astore_1
    //   210: aload_1
    //   211: aload_0
    //   212: invokevirtual 93	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   215: athrow
    //   216: astore_1
    //   217: aload_1
    //   218: athrow
    //   219: aload_0
    //   220: aload_0
    //   221: getfield 70	com/appbrain/e/aq:c	I
    //   224: iconst_2
    //   225: ior
    //   226: putfield 70	com/appbrain/e/aq:c	I
    //   229: aload_0
    //   230: aload_1
    //   231: invokevirtual 96	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   234: putfield 98	com/appbrain/e/aq:e	Ljava/lang/Object;
    //   237: goto -217 -> 20
    //   240: astore_1
    //   241: new 58	com/appbrain/b/o
    //   244: dup
    //   245: aload_1
    //   246: invokevirtual 102	java/io/IOException:getMessage	()Ljava/lang/String;
    //   249: invokespecial 105	com/appbrain/b/o:<init>	(Ljava/lang/String;)V
    //   252: aload_0
    //   253: invokevirtual 93	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   256: athrow
    //   257: aload_1
    //   258: invokevirtual 107	com/appbrain/b/g:f	()I
    //   261: invokestatic 112	com/appbrain/e/af:a	(I)Lcom/appbrain/e/af;
    //   264: astore 5
    //   266: aload 5
    //   268: ifnull -248 -> 20
    //   271: aload_0
    //   272: aload_0
    //   273: getfield 70	com/appbrain/e/aq:c	I
    //   276: iconst_4
    //   277: ior
    //   278: putfield 70	com/appbrain/e/aq:c	I
    //   281: aload_0
    //   282: aload 5
    //   284: putfield 114	com/appbrain/e/aq:f	Lcom/appbrain/e/af;
    //   287: goto -267 -> 20
    //   290: aload_0
    //   291: aload_0
    //   292: getfield 70	com/appbrain/e/aq:c	I
    //   295: bipush 8
    //   297: ior
    //   298: putfield 70	com/appbrain/e/aq:c	I
    //   301: aload_0
    //   302: aload_1
    //   303: invokevirtual 117	com/appbrain/b/g:b	()J
    //   306: putfield 119	com/appbrain/e/aq:g	J
    //   309: goto -289 -> 20
    //   312: aload_0
    //   313: aload_0
    //   314: getfield 70	com/appbrain/e/aq:c	I
    //   317: bipush 16
    //   319: ior
    //   320: putfield 70	com/appbrain/e/aq:c	I
    //   323: aload_0
    //   324: aload_1
    //   325: invokevirtual 117	com/appbrain/b/g:b	()J
    //   328: putfield 121	com/appbrain/e/aq:h	J
    //   331: goto -311 -> 20
    //   334: aload_0
    //   335: aload_0
    //   336: getfield 70	com/appbrain/e/aq:c	I
    //   339: bipush 32
    //   341: ior
    //   342: putfield 70	com/appbrain/e/aq:c	I
    //   345: aload_0
    //   346: aload_1
    //   347: invokevirtual 96	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   350: putfield 123	com/appbrain/e/aq:i	Ljava/lang/Object;
    //   353: goto -333 -> 20
    //   356: aload_0
    //   357: aload_0
    //   358: getfield 70	com/appbrain/e/aq:c	I
    //   361: bipush 64
    //   363: ior
    //   364: putfield 70	com/appbrain/e/aq:c	I
    //   367: aload_0
    //   368: aload_1
    //   369: invokevirtual 96	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   372: putfield 125	com/appbrain/e/aq:j	Ljava/lang/Object;
    //   375: goto -355 -> 20
    //   378: aload_0
    //   379: aload_0
    //   380: getfield 70	com/appbrain/e/aq:c	I
    //   383: sipush 128
    //   386: ior
    //   387: putfield 70	com/appbrain/e/aq:c	I
    //   390: aload_0
    //   391: aload_1
    //   392: invokevirtual 128	com/appbrain/b/g:d	()Z
    //   395: putfield 130	com/appbrain/e/aq:k	Z
    //   398: goto -378 -> 20
    //   401: aload_0
    //   402: aload_0
    //   403: getfield 70	com/appbrain/e/aq:c	I
    //   406: sipush 256
    //   409: ior
    //   410: putfield 70	com/appbrain/e/aq:c	I
    //   413: aload_0
    //   414: aload_1
    //   415: invokevirtual 132	com/appbrain/b/g:c	()I
    //   418: putfield 134	com/appbrain/e/aq:l	I
    //   421: goto -401 -> 20
    //   424: return
    //   425: aconst_null
    //   426: astore 5
    //   428: goto -271 -> 157
    //   431: goto -307 -> 124
    //   434: iconst_1
    //   435: istore_3
    //   436: goto -416 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	439	0	this	aq
    //   0	439	1	paramg	com.appbrain.b.g
    //   0	439	2	paramj	com.appbrain.b.j
    //   19	417	3	i1	int
    //   28	98	4	i2	int
    //   155	272	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	30	209	com/appbrain/b/o
    //   124	133	209	com/appbrain/b/o
    //   138	157	209	com/appbrain/b/o
    //   157	172	209	com/appbrain/b/o
    //   177	196	209	com/appbrain/b/o
    //   196	206	209	com/appbrain/b/o
    //   219	237	209	com/appbrain/b/o
    //   257	266	209	com/appbrain/b/o
    //   271	287	209	com/appbrain/b/o
    //   290	309	209	com/appbrain/b/o
    //   312	331	209	com/appbrain/b/o
    //   334	353	209	com/appbrain/b/o
    //   356	375	209	com/appbrain/b/o
    //   378	398	209	com/appbrain/b/o
    //   401	421	209	com/appbrain/b/o
    //   24	30	216	finally
    //   124	133	216	finally
    //   138	157	216	finally
    //   157	172	216	finally
    //   177	196	216	finally
    //   196	206	216	finally
    //   210	216	216	finally
    //   219	237	216	finally
    //   241	257	216	finally
    //   257	266	216	finally
    //   271	287	216	finally
    //   290	309	216	finally
    //   312	331	216	finally
    //   334	353	216	finally
    //   356	375	216	finally
    //   378	398	216	finally
    //   401	421	216	finally
    //   24	30	240	java/io/IOException
    //   124	133	240	java/io/IOException
    //   138	157	240	java/io/IOException
    //   157	172	240	java/io/IOException
    //   177	196	240	java/io/IOException
    //   196	206	240	java/io/IOException
    //   219	237	240	java/io/IOException
    //   257	266	240	java/io/IOException
    //   271	287	240	java/io/IOException
    //   290	309	240	java/io/IOException
    //   312	331	240	java/io/IOException
    //   334	353	240	java/io/IOException
    //   356	375	240	java/io/IOException
    //   378	398	240	java/io/IOException
    //   401	421	240	java/io/IOException
  }
  
  private d A()
  {
    Object localObject = this.i;
    if ((localObject instanceof String))
    {
      localObject = d.a((String)localObject);
      this.i = localObject;
      return (d)localObject;
    }
    return (d)localObject;
  }
  
  private d B()
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
  
  private void C()
  {
    this.d = aa.f();
    this.e = "";
    this.f = af.a;
    this.g = 0L;
    this.h = 0L;
    this.i = "";
    this.j = "";
    this.k = false;
    this.l = 0;
  }
  
  public static ar a(aq paramaq)
  {
    return ar.g().a(paramaq);
  }
  
  public static aq f()
  {
    return b;
  }
  
  public static ar x()
  {
    return ar.g();
  }
  
  private d z()
  {
    Object localObject = this.e;
    if ((localObject instanceof String))
    {
      localObject = d.a((String)localObject);
      this.e = localObject;
      return (d)localObject;
    }
    return (d)localObject;
  }
  
  public final void a(h paramh)
  {
    c();
    if ((this.c & 0x1) == 1) {
      paramh.a(1, this.d);
    }
    if ((this.c & 0x2) == 2) {
      paramh.a(2, z());
    }
    if ((this.c & 0x4) == 4) {
      paramh.b(4, this.f.a());
    }
    if ((this.c & 0x8) == 8) {
      paramh.a(5, this.g);
    }
    if ((this.c & 0x10) == 16) {
      paramh.a(6, this.h);
    }
    if ((this.c & 0x20) == 32) {
      paramh.a(7, A());
    }
    if ((this.c & 0x40) == 64) {
      paramh.a(8, B());
    }
    if ((this.c & 0x80) == 128) {
      paramh.a(9, this.k);
    }
    if ((this.c & 0x100) == 256) {
      paramh.a(10, this.l);
    }
  }
  
  public final int c()
  {
    int i1 = this.n;
    if (i1 != -1) {
      return i1;
    }
    int i2 = 0;
    if ((this.c & 0x1) == 1) {
      i2 = h.b(1, this.d) + 0;
    }
    i1 = i2;
    if ((this.c & 0x2) == 2) {
      i1 = i2 + h.b(2, z());
    }
    i2 = i1;
    if ((this.c & 0x4) == 4) {
      i2 = i1 + h.d(4, this.f.a());
    }
    i1 = i2;
    if ((this.c & 0x8) == 8) {
      i1 = i2 + h.b(5, this.g);
    }
    i2 = i1;
    if ((this.c & 0x10) == 16) {
      i2 = i1 + h.b(6, this.h);
    }
    i1 = i2;
    if ((this.c & 0x20) == 32) {
      i1 = i2 + h.b(7, A());
    }
    i2 = i1;
    if ((this.c & 0x40) == 64) {
      i2 = i1 + h.b(8, B());
    }
    i1 = i2;
    if ((this.c & 0x80) == 128)
    {
      boolean bool = this.k;
      i1 = i2 + h.a(9);
    }
    i2 = i1;
    if ((this.c & 0x100) == 256) {
      i2 = i1 + h.c(10, this.l);
    }
    this.n = i2;
    return i2;
  }
  
  public final boolean e()
  {
    int i1 = this.m;
    if (i1 != -1) {
      return i1 == 1;
    }
    this.m = 1;
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
  
  public final String j()
  {
    Object localObject = this.e;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (d)localObject;
    String str = ((d)localObject).e();
    if (((d)localObject).f()) {
      this.e = str;
    }
    return str;
  }
  
  public final boolean k()
  {
    return (this.c & 0x4) == 4;
  }
  
  public final af l()
  {
    return this.f;
  }
  
  public final boolean m()
  {
    return (this.c & 0x8) == 8;
  }
  
  public final long n()
  {
    return this.g;
  }
  
  public final boolean o()
  {
    return (this.c & 0x10) == 16;
  }
  
  public final long p()
  {
    return this.h;
  }
  
  public final boolean q()
  {
    return (this.c & 0x20) == 32;
  }
  
  public final boolean r()
  {
    return (this.c & 0x40) == 64;
  }
  
  public final String s()
  {
    Object localObject = this.j;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (d)localObject;
    String str = ((d)localObject).e();
    if (((d)localObject).f()) {
      this.j = str;
    }
    return str;
  }
  
  public final boolean t()
  {
    return (this.c & 0x80) == 128;
  }
  
  public final boolean u()
  {
    return this.k;
  }
  
  public final boolean v()
  {
    return (this.c & 0x100) == 256;
  }
  
  public final int w()
  {
    return this.l;
  }
  
  public final ar y()
  {
    return ar.g().a(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */