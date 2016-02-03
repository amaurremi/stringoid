package com.appbrain.e;

import com.appbrain.b.h;
import com.appbrain.b.k;
import com.appbrain.b.w;

public final class aw
  extends k
  implements ay
{
  public static w a = new bg();
  private static final aw b;
  private int c;
  private aq d;
  private boolean e;
  private int f;
  private byte g = -1;
  private int h = -1;
  
  static
  {
    aw localaw = new aw((byte)0);
    b = localaw;
    localaw.o();
  }
  
  private aw()
  {
    super((byte)0);
  }
  
  private aw(byte paramByte) {}
  
  /* Error */
  private aw(com.appbrain.b.g paramg, com.appbrain.b.j paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 44	com/appbrain/b/k:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 41	com/appbrain/e/aw:g	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 43	com/appbrain/e/aw:h	I
    //   14: aload_0
    //   15: invokespecial 37	com/appbrain/e/aw:o	()V
    //   18: iconst_0
    //   19: istore_3
    //   20: iload_3
    //   21: ifne +209 -> 230
    //   24: aload_1
    //   25: invokevirtual 56	com/appbrain/b/g:a	()I
    //   28: istore 4
    //   30: iload 4
    //   32: lookupswitch	default:+205->237, 0:+208->240, 10:+58->90, 16:+139->171, 24:+177->209
    //   76: aload_1
    //   77: iload 4
    //   79: invokevirtual 59	com/appbrain/b/g:b	(I)Z
    //   82: ifne -62 -> 20
    //   85: iconst_1
    //   86: istore_3
    //   87: goto -67 -> 20
    //   90: aload_0
    //   91: getfield 61	com/appbrain/e/aw:c	I
    //   94: iconst_1
    //   95: iand
    //   96: iconst_1
    //   97: if_icmpne +134 -> 231
    //   100: aload_0
    //   101: getfield 63	com/appbrain/e/aw:d	Lcom/appbrain/e/aq;
    //   104: invokevirtual 69	com/appbrain/e/aq:y	()Lcom/appbrain/e/ar;
    //   107: astore 5
    //   109: aload_0
    //   110: aload_1
    //   111: getstatic 70	com/appbrain/e/aq:a	Lcom/appbrain/b/w;
    //   114: aload_2
    //   115: invokevirtual 73	com/appbrain/b/g:a	(Lcom/appbrain/b/w;Lcom/appbrain/b/j;)Lcom/appbrain/b/t;
    //   118: checkcast 65	com/appbrain/e/aq
    //   121: putfield 63	com/appbrain/e/aw:d	Lcom/appbrain/e/aq;
    //   124: aload 5
    //   126: ifnull +22 -> 148
    //   129: aload 5
    //   131: aload_0
    //   132: getfield 63	com/appbrain/e/aw:d	Lcom/appbrain/e/aq;
    //   135: invokevirtual 78	com/appbrain/e/ar:a	(Lcom/appbrain/e/aq;)Lcom/appbrain/e/ar;
    //   138: pop
    //   139: aload_0
    //   140: aload 5
    //   142: invokevirtual 81	com/appbrain/e/ar:f	()Lcom/appbrain/e/aq;
    //   145: putfield 63	com/appbrain/e/aw:d	Lcom/appbrain/e/aq;
    //   148: aload_0
    //   149: aload_0
    //   150: getfield 61	com/appbrain/e/aw:c	I
    //   153: iconst_1
    //   154: ior
    //   155: putfield 61	com/appbrain/e/aw:c	I
    //   158: goto -138 -> 20
    //   161: astore_1
    //   162: aload_1
    //   163: aload_0
    //   164: invokevirtual 84	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   167: athrow
    //   168: astore_1
    //   169: aload_1
    //   170: athrow
    //   171: aload_0
    //   172: aload_0
    //   173: getfield 61	com/appbrain/e/aw:c	I
    //   176: iconst_2
    //   177: ior
    //   178: putfield 61	com/appbrain/e/aw:c	I
    //   181: aload_0
    //   182: aload_1
    //   183: invokevirtual 87	com/appbrain/b/g:d	()Z
    //   186: putfield 89	com/appbrain/e/aw:e	Z
    //   189: goto -169 -> 20
    //   192: astore_1
    //   193: new 49	com/appbrain/b/o
    //   196: dup
    //   197: aload_1
    //   198: invokevirtual 93	java/io/IOException:getMessage	()Ljava/lang/String;
    //   201: invokespecial 96	com/appbrain/b/o:<init>	(Ljava/lang/String;)V
    //   204: aload_0
    //   205: invokevirtual 84	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   208: athrow
    //   209: aload_0
    //   210: aload_0
    //   211: getfield 61	com/appbrain/e/aw:c	I
    //   214: iconst_4
    //   215: ior
    //   216: putfield 61	com/appbrain/e/aw:c	I
    //   219: aload_0
    //   220: aload_1
    //   221: invokevirtual 98	com/appbrain/b/g:c	()I
    //   224: putfield 100	com/appbrain/e/aw:f	I
    //   227: goto -207 -> 20
    //   230: return
    //   231: aconst_null
    //   232: astore 5
    //   234: goto -125 -> 109
    //   237: goto -161 -> 76
    //   240: iconst_1
    //   241: istore_3
    //   242: goto -222 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	aw
    //   0	245	1	paramg	com.appbrain.b.g
    //   0	245	2	paramj	com.appbrain.b.j
    //   19	223	3	i	int
    //   28	50	4	j	int
    //   107	126	5	localar	ar
    // Exception table:
    //   from	to	target	type
    //   24	30	161	com/appbrain/b/o
    //   76	85	161	com/appbrain/b/o
    //   90	109	161	com/appbrain/b/o
    //   109	124	161	com/appbrain/b/o
    //   129	148	161	com/appbrain/b/o
    //   148	158	161	com/appbrain/b/o
    //   171	189	161	com/appbrain/b/o
    //   209	227	161	com/appbrain/b/o
    //   24	30	168	finally
    //   76	85	168	finally
    //   90	109	168	finally
    //   109	124	168	finally
    //   129	148	168	finally
    //   148	158	168	finally
    //   162	168	168	finally
    //   171	189	168	finally
    //   193	209	168	finally
    //   209	227	168	finally
    //   24	30	192	java/io/IOException
    //   76	85	192	java/io/IOException
    //   90	109	192	java/io/IOException
    //   109	124	192	java/io/IOException
    //   129	148	192	java/io/IOException
    //   148	158	192	java/io/IOException
    //   171	189	192	java/io/IOException
    //   209	227	192	java/io/IOException
  }
  
  public static aw a(byte[] paramArrayOfByte)
  {
    return (aw)a.a(paramArrayOfByte);
  }
  
  public static aw f()
  {
    return b;
  }
  
  public static ax m()
  {
    return ax.f();
  }
  
  private void o()
  {
    this.d = aq.f();
    this.e = false;
    this.f = 0;
  }
  
  public final void a(h paramh)
  {
    c();
    if ((this.c & 0x1) == 1) {
      paramh.a(1, this.d);
    }
    if ((this.c & 0x2) == 2) {
      paramh.a(2, this.e);
    }
    if ((this.c & 0x4) == 4) {
      paramh.a(3, this.f);
    }
  }
  
  public final int c()
  {
    int i = this.h;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if ((this.c & 0x1) == 1) {
      j = h.b(1, this.d) + 0;
    }
    i = j;
    if ((this.c & 0x2) == 2)
    {
      boolean bool = this.e;
      i = j + h.a(2);
    }
    j = i;
    if ((this.c & 0x4) == 4) {
      j = i + h.c(3, this.f);
    }
    this.h = j;
    return j;
  }
  
  public final boolean e()
  {
    int i = this.g;
    if (i != -1) {
      return i == 1;
    }
    this.g = 1;
    return true;
  }
  
  public final boolean g()
  {
    return (this.c & 0x1) == 1;
  }
  
  public final aq h()
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
  
  public final int l()
  {
    return this.f;
  }
  
  public final ax n()
  {
    return ax.f().a(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */