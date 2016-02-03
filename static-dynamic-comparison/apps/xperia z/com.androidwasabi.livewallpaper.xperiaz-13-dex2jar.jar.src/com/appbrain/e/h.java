package com.appbrain.e;

import com.appbrain.b.w;

public final class h
  extends com.appbrain.b.k
  implements j
{
  public static w a = new v();
  private static final h b;
  private int c;
  private k d;
  private byte e = -1;
  private int f = -1;
  
  static
  {
    h localh = new h((byte)0);
    b = localh;
    localh.d = k.f();
  }
  
  private h()
  {
    super((byte)0);
  }
  
  private h(byte paramByte) {}
  
  /* Error */
  private h(com.appbrain.b.g paramg, com.appbrain.b.j paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 45	com/appbrain/b/k:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 42	com/appbrain/e/h:e	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 44	com/appbrain/e/h:f	I
    //   14: aload_0
    //   15: invokestatic 36	com/appbrain/e/k:f	()Lcom/appbrain/e/k;
    //   18: putfield 38	com/appbrain/e/h:d	Lcom/appbrain/e/k;
    //   21: iconst_0
    //   22: istore_3
    //   23: iload_3
    //   24: ifne +148 -> 172
    //   27: aload_1
    //   28: invokevirtual 57	com/appbrain/b/g:a	()I
    //   31: istore 4
    //   33: iload 4
    //   35: lookupswitch	default:+144->179, 0:+147->182, 10:+39->74
    //   60: aload_1
    //   61: iload 4
    //   63: invokevirtual 60	com/appbrain/b/g:b	(I)Z
    //   66: ifne -43 -> 23
    //   69: iconst_1
    //   70: istore_3
    //   71: goto -48 -> 23
    //   74: aload_0
    //   75: getfield 62	com/appbrain/e/h:c	I
    //   78: iconst_1
    //   79: iand
    //   80: iconst_1
    //   81: if_icmpne +92 -> 173
    //   84: aload_0
    //   85: getfield 38	com/appbrain/e/h:d	Lcom/appbrain/e/k;
    //   88: invokevirtual 66	com/appbrain/e/k:o	()Lcom/appbrain/e/l;
    //   91: astore 5
    //   93: aload_0
    //   94: aload_1
    //   95: getstatic 67	com/appbrain/e/k:a	Lcom/appbrain/b/w;
    //   98: aload_2
    //   99: invokevirtual 70	com/appbrain/b/g:a	(Lcom/appbrain/b/w;Lcom/appbrain/b/j;)Lcom/appbrain/b/t;
    //   102: checkcast 33	com/appbrain/e/k
    //   105: putfield 38	com/appbrain/e/h:d	Lcom/appbrain/e/k;
    //   108: aload 5
    //   110: ifnull +22 -> 132
    //   113: aload 5
    //   115: aload_0
    //   116: getfield 38	com/appbrain/e/h:d	Lcom/appbrain/e/k;
    //   119: invokevirtual 75	com/appbrain/e/l:a	(Lcom/appbrain/e/k;)Lcom/appbrain/e/l;
    //   122: pop
    //   123: aload_0
    //   124: aload 5
    //   126: invokevirtual 77	com/appbrain/e/l:d	()Lcom/appbrain/e/k;
    //   129: putfield 38	com/appbrain/e/h:d	Lcom/appbrain/e/k;
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 62	com/appbrain/e/h:c	I
    //   137: iconst_1
    //   138: ior
    //   139: putfield 62	com/appbrain/e/h:c	I
    //   142: goto -119 -> 23
    //   145: astore_1
    //   146: aload_1
    //   147: aload_0
    //   148: invokevirtual 80	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   151: athrow
    //   152: astore_1
    //   153: aload_1
    //   154: athrow
    //   155: astore_1
    //   156: new 50	com/appbrain/b/o
    //   159: dup
    //   160: aload_1
    //   161: invokevirtual 84	java/io/IOException:getMessage	()Ljava/lang/String;
    //   164: invokespecial 87	com/appbrain/b/o:<init>	(Ljava/lang/String;)V
    //   167: aload_0
    //   168: invokevirtual 80	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   171: athrow
    //   172: return
    //   173: aconst_null
    //   174: astore 5
    //   176: goto -83 -> 93
    //   179: goto -119 -> 60
    //   182: iconst_1
    //   183: istore_3
    //   184: goto -161 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	h
    //   0	187	1	paramg	com.appbrain.b.g
    //   0	187	2	paramj	com.appbrain.b.j
    //   22	162	3	i	int
    //   31	31	4	j	int
    //   91	84	5	locall	l
    // Exception table:
    //   from	to	target	type
    //   27	33	145	com/appbrain/b/o
    //   60	69	145	com/appbrain/b/o
    //   74	93	145	com/appbrain/b/o
    //   93	108	145	com/appbrain/b/o
    //   113	132	145	com/appbrain/b/o
    //   132	142	145	com/appbrain/b/o
    //   27	33	152	finally
    //   60	69	152	finally
    //   74	93	152	finally
    //   93	108	152	finally
    //   113	132	152	finally
    //   132	142	152	finally
    //   146	152	152	finally
    //   156	172	152	finally
    //   27	33	155	java/io/IOException
    //   60	69	155	java/io/IOException
    //   74	93	155	java/io/IOException
    //   93	108	155	java/io/IOException
    //   113	132	155	java/io/IOException
    //   132	142	155	java/io/IOException
  }
  
  public static h a(byte[] paramArrayOfByte)
  {
    return (h)a.a(paramArrayOfByte);
  }
  
  public static h f()
  {
    return b;
  }
  
  public final void a(com.appbrain.b.h paramh)
  {
    c();
    if ((this.c & 0x1) == 1) {
      paramh.a(1, this.d);
    }
  }
  
  public final int c()
  {
    int i = this.f;
    if (i != -1) {
      return i;
    }
    i = 0;
    if ((this.c & 0x1) == 1) {
      i = com.appbrain.b.h.b(1, this.d) + 0;
    }
    this.f = i;
    return i;
  }
  
  public final boolean e()
  {
    int i = this.e;
    if (i != -1) {
      return i == 1;
    }
    this.e = 1;
    return true;
  }
  
  public final boolean g()
  {
    return (this.c & 0x1) == 1;
  }
  
  public final k h()
  {
    return this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */