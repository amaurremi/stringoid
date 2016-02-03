package com.appbrain.e;

import com.appbrain.b.d;
import com.appbrain.b.h;
import com.appbrain.b.k;
import com.appbrain.b.w;

public final class n
  extends k
  implements p
{
  public static w a = new x();
  private static final n b;
  private int c;
  private Object d;
  private Object e;
  private boolean f;
  private byte g = -1;
  private int h = -1;
  
  static
  {
    n localn = new n((byte)0);
    b = localn;
    localn.o();
  }
  
  private n()
  {
    super((byte)0);
  }
  
  private n(byte paramByte) {}
  
  /* Error */
  private n(com.appbrain.b.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 44	com/appbrain/b/k:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 41	com/appbrain/e/n:g	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 43	com/appbrain/e/n:h	I
    //   14: aload_0
    //   15: invokespecial 37	com/appbrain/e/n:o	()V
    //   18: iconst_0
    //   19: istore_2
    //   20: iload_2
    //   21: ifne +154 -> 175
    //   24: aload_1
    //   25: invokevirtual 56	com/appbrain/b/g:a	()I
    //   28: istore_3
    //   29: iload_3
    //   30: lookupswitch	default:+146->176, 0:+149->179, 10:+55->85, 18:+86->116, 32:+124->154
    //   72: aload_1
    //   73: iload_3
    //   74: invokevirtual 59	com/appbrain/b/g:b	(I)Z
    //   77: ifne -57 -> 20
    //   80: iconst_1
    //   81: istore_2
    //   82: goto -62 -> 20
    //   85: aload_0
    //   86: aload_0
    //   87: getfield 61	com/appbrain/e/n:c	I
    //   90: iconst_1
    //   91: ior
    //   92: putfield 61	com/appbrain/e/n:c	I
    //   95: aload_0
    //   96: aload_1
    //   97: invokevirtual 64	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   100: putfield 66	com/appbrain/e/n:d	Ljava/lang/Object;
    //   103: goto -83 -> 20
    //   106: astore_1
    //   107: aload_1
    //   108: aload_0
    //   109: invokevirtual 69	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   112: athrow
    //   113: astore_1
    //   114: aload_1
    //   115: athrow
    //   116: aload_0
    //   117: aload_0
    //   118: getfield 61	com/appbrain/e/n:c	I
    //   121: iconst_2
    //   122: ior
    //   123: putfield 61	com/appbrain/e/n:c	I
    //   126: aload_0
    //   127: aload_1
    //   128: invokevirtual 64	com/appbrain/b/g:e	()Lcom/appbrain/b/d;
    //   131: putfield 71	com/appbrain/e/n:e	Ljava/lang/Object;
    //   134: goto -114 -> 20
    //   137: astore_1
    //   138: new 49	com/appbrain/b/o
    //   141: dup
    //   142: aload_1
    //   143: invokevirtual 75	java/io/IOException:getMessage	()Ljava/lang/String;
    //   146: invokespecial 78	com/appbrain/b/o:<init>	(Ljava/lang/String;)V
    //   149: aload_0
    //   150: invokevirtual 69	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   153: athrow
    //   154: aload_0
    //   155: aload_0
    //   156: getfield 61	com/appbrain/e/n:c	I
    //   159: iconst_4
    //   160: ior
    //   161: putfield 61	com/appbrain/e/n:c	I
    //   164: aload_0
    //   165: aload_1
    //   166: invokevirtual 81	com/appbrain/b/g:d	()Z
    //   169: putfield 83	com/appbrain/e/n:f	Z
    //   172: goto -152 -> 20
    //   175: return
    //   176: goto -104 -> 72
    //   179: iconst_1
    //   180: istore_2
    //   181: goto -161 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	n
    //   0	184	1	paramg	com.appbrain.b.g
    //   19	162	2	i	int
    //   28	46	3	j	int
    // Exception table:
    //   from	to	target	type
    //   24	29	106	com/appbrain/b/o
    //   72	80	106	com/appbrain/b/o
    //   85	103	106	com/appbrain/b/o
    //   116	134	106	com/appbrain/b/o
    //   154	172	106	com/appbrain/b/o
    //   24	29	113	finally
    //   72	80	113	finally
    //   85	103	113	finally
    //   107	113	113	finally
    //   116	134	113	finally
    //   138	154	113	finally
    //   154	172	113	finally
    //   24	29	137	java/io/IOException
    //   72	80	137	java/io/IOException
    //   85	103	137	java/io/IOException
    //   116	134	137	java/io/IOException
    //   154	172	137	java/io/IOException
  }
  
  public static n f()
  {
    return b;
  }
  
  private d m()
  {
    Object localObject = this.d;
    if ((localObject instanceof String))
    {
      localObject = d.a((String)localObject);
      this.d = localObject;
      return (d)localObject;
    }
    return (d)localObject;
  }
  
  private d n()
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
  
  private void o()
  {
    this.d = "";
    this.e = "";
    this.f = false;
  }
  
  public final void a(h paramh)
  {
    c();
    if ((this.c & 0x1) == 1) {
      paramh.a(1, m());
    }
    if ((this.c & 0x2) == 2) {
      paramh.a(2, n());
    }
    if ((this.c & 0x4) == 4) {
      paramh.a(4, this.f);
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
      j = h.b(1, m()) + 0;
    }
    i = j;
    if ((this.c & 0x2) == 2) {
      i = j + h.b(2, n());
    }
    j = i;
    if ((this.c & 0x4) == 4)
    {
      boolean bool = this.f;
      j = i + h.a(4);
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
  
  public final String h()
  {
    Object localObject = this.d;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (d)localObject;
    String str = ((d)localObject).e();
    if (((d)localObject).f()) {
      this.d = str;
    }
    return str;
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
  
  public final boolean l()
  {
    return this.f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */