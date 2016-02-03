package com.appbrain.e;

import com.appbrain.b.g.a;
import com.appbrain.b.m;
import com.appbrain.b.n;
import com.appbrain.b.o;
import com.appbrain.b.q;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a
{
  public static final class a
    extends com.appbrain.b.g
    implements a.b
  {
    public static o a = new b();
    private static final a b;
    private int c;
    private int d;
    private int e;
    private Object f;
    private byte g = -1;
    private int h = -1;
    
    static
    {
      a locala = new a((byte)0);
      b = locala;
      locala.n();
    }
    
    private a()
    {
      super();
    }
    
    private a(byte paramByte) {}
    
    /* Error */
    private a(com.appbrain.b.d paramd)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 47	com/appbrain/b/g:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 44	com/appbrain/e/a$a:g	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 46	com/appbrain/e/a$a:h	I
      //   14: aload_0
      //   15: invokespecial 40	com/appbrain/e/a$a:n	()V
      //   18: iconst_0
      //   19: istore_2
      //   20: iload_2
      //   21: ifne +154 -> 175
      //   24: aload_1
      //   25: invokevirtual 59	com/appbrain/b/d:a	()I
      //   28: istore_3
      //   29: iload_3
      //   30: lookupswitch	default:+146->176, 0:+149->179, 16:+55->85, 24:+86->116, 34:+124->154
      //   72: aload_1
      //   73: iload_3
      //   74: invokevirtual 62	com/appbrain/b/d:b	(I)Z
      //   77: ifne -57 -> 20
      //   80: iconst_1
      //   81: istore_2
      //   82: goto -62 -> 20
      //   85: aload_0
      //   86: aload_0
      //   87: getfield 64	com/appbrain/e/a$a:c	I
      //   90: iconst_1
      //   91: ior
      //   92: putfield 64	com/appbrain/e/a$a:c	I
      //   95: aload_0
      //   96: aload_1
      //   97: invokevirtual 66	com/appbrain/b/d:c	()I
      //   100: putfield 68	com/appbrain/e/a$a:d	I
      //   103: goto -83 -> 20
      //   106: astore_1
      //   107: aload_1
      //   108: aload_0
      //   109: invokevirtual 71	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   112: athrow
      //   113: astore_1
      //   114: aload_1
      //   115: athrow
      //   116: aload_0
      //   117: aload_0
      //   118: getfield 64	com/appbrain/e/a$a:c	I
      //   121: iconst_2
      //   122: ior
      //   123: putfield 64	com/appbrain/e/a$a:c	I
      //   126: aload_0
      //   127: aload_1
      //   128: invokevirtual 66	com/appbrain/b/d:c	()I
      //   131: putfield 73	com/appbrain/e/a$a:e	I
      //   134: goto -114 -> 20
      //   137: astore_1
      //   138: new 52	com/appbrain/b/i
      //   141: dup
      //   142: aload_1
      //   143: invokevirtual 77	java/io/IOException:getMessage	()Ljava/lang/String;
      //   146: invokespecial 80	com/appbrain/b/i:<init>	(Ljava/lang/String;)V
      //   149: aload_0
      //   150: invokevirtual 71	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   153: athrow
      //   154: aload_0
      //   155: aload_0
      //   156: getfield 64	com/appbrain/e/a$a:c	I
      //   159: iconst_4
      //   160: ior
      //   161: putfield 64	com/appbrain/e/a$a:c	I
      //   164: aload_0
      //   165: aload_1
      //   166: invokevirtual 83	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   169: putfield 85	com/appbrain/e/a$a:f	Ljava/lang/Object;
      //   172: goto -152 -> 20
      //   175: return
      //   176: goto -104 -> 72
      //   179: iconst_1
      //   180: istore_2
      //   181: goto -161 -> 20
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	184	0	this	a
      //   0	184	1	paramd	com.appbrain.b.d
      //   19	162	2	i	int
      //   28	46	3	j	int
      // Exception table:
      //   from	to	target	type
      //   24	29	106	com/appbrain/b/i
      //   72	80	106	com/appbrain/b/i
      //   85	103	106	com/appbrain/b/i
      //   116	134	106	com/appbrain/b/i
      //   154	172	106	com/appbrain/b/i
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
    
    public static a f()
    {
      return b;
    }
    
    public static a l()
    {
      return a.f();
    }
    
    private com.appbrain.b.c m()
    {
      Object localObject = this.f;
      if ((localObject instanceof String))
      {
        localObject = com.appbrain.b.c.a((String)localObject);
        this.f = localObject;
        return (com.appbrain.b.c)localObject;
      }
      return (com.appbrain.b.c)localObject;
    }
    
    private void n()
    {
      this.d = 0;
      this.e = 0;
      this.f = "";
    }
    
    public final void a(com.appbrain.b.e parame)
    {
      c();
      if ((this.c & 0x1) == 1) {
        parame.a(2, this.d);
      }
      if ((this.c & 0x2) == 2) {
        parame.a(3, this.e);
      }
      if ((this.c & 0x4) == 4) {
        parame.a(4, m());
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
        j = com.appbrain.b.e.c(2, this.d) + 0;
      }
      i = j;
      if ((this.c & 0x2) == 2) {
        i = j + com.appbrain.b.e.c(3, this.e);
      }
      j = i;
      if ((this.c & 0x4) == 4) {
        j = i + com.appbrain.b.e.b(4, m());
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
    
    @Deprecated
    public final boolean g()
    {
      return (this.c & 0x1) == 1;
    }
    
    @Deprecated
    public final int h()
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
    
    public static final class a
      extends g.a
      implements a.b
    {
      private int a;
      private int b;
      private int c;
      private Object d = "";
      
      private a g()
      {
        return new a().a(h());
      }
      
      private a.a h()
      {
        int j = 1;
        a.a locala = new a.a('\000');
        int k = this.a;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          a.a.a(locala, this.b);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          a.a.b(locala, this.c);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          a.a.a(locala, this.d);
          a.a.c(locala, j);
          return locala;
          j = 0;
        }
      }
      
      public final a a(int paramInt)
      {
        this.a |= 0x2;
        this.c = paramInt;
        return this;
      }
      
      public final a a(a.a parama)
      {
        if (parama == a.a.f()) {}
        do
        {
          return this;
          if (parama.g())
          {
            int i = parama.h();
            this.a |= 0x1;
            this.b = i;
          }
          if (parama.i()) {
            a(parama.j());
          }
        } while (!parama.k());
        this.a |= 0x4;
        this.d = a.a.a(parama);
        return this;
      }
      
      public final a a(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a |= 0x4;
        this.d = paramString;
        return this;
      }
      
      public final a.a d()
      {
        a.a locala = h();
        if (!locala.e()) {
          throw new q();
        }
        return locala;
      }
      
      public final boolean e()
      {
        return true;
      }
    }
  }
  
  public static abstract interface b
    extends n
  {}
  
  public static final class c
    extends com.appbrain.b.g
    implements a.d
  {
    public static o a = new c();
    private static final c b;
    private int c;
    private Object d;
    private int e;
    private long f;
    private byte g = -1;
    private int h = -1;
    
    static
    {
      c localc = new c((byte)0);
      b = localc;
      localc.n();
    }
    
    private c()
    {
      super();
    }
    
    private c(byte paramByte) {}
    
    /* Error */
    private c(com.appbrain.b.d paramd)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 48	com/appbrain/b/g:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 45	com/appbrain/e/a$c:g	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 47	com/appbrain/e/a$c:h	I
      //   14: aload_0
      //   15: invokespecial 41	com/appbrain/e/a$c:n	()V
      //   18: iconst_0
      //   19: istore_2
      //   20: iload_2
      //   21: ifne +154 -> 175
      //   24: aload_1
      //   25: invokevirtual 60	com/appbrain/b/d:a	()I
      //   28: istore_3
      //   29: iload_3
      //   30: lookupswitch	default:+146->176, 0:+149->179, 10:+55->85, 16:+86->116, 24:+124->154
      //   72: aload_1
      //   73: iload_3
      //   74: invokevirtual 63	com/appbrain/b/d:b	(I)Z
      //   77: ifne -57 -> 20
      //   80: iconst_1
      //   81: istore_2
      //   82: goto -62 -> 20
      //   85: aload_0
      //   86: aload_0
      //   87: getfield 65	com/appbrain/e/a$c:c	I
      //   90: iconst_1
      //   91: ior
      //   92: putfield 65	com/appbrain/e/a$c:c	I
      //   95: aload_0
      //   96: aload_1
      //   97: invokevirtual 68	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   100: putfield 70	com/appbrain/e/a$c:d	Ljava/lang/Object;
      //   103: goto -83 -> 20
      //   106: astore_1
      //   107: aload_1
      //   108: aload_0
      //   109: invokevirtual 73	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   112: athrow
      //   113: astore_1
      //   114: aload_1
      //   115: athrow
      //   116: aload_0
      //   117: aload_0
      //   118: getfield 65	com/appbrain/e/a$c:c	I
      //   121: iconst_2
      //   122: ior
      //   123: putfield 65	com/appbrain/e/a$c:c	I
      //   126: aload_0
      //   127: aload_1
      //   128: invokevirtual 75	com/appbrain/b/d:c	()I
      //   131: putfield 77	com/appbrain/e/a$c:e	I
      //   134: goto -114 -> 20
      //   137: astore_1
      //   138: new 53	com/appbrain/b/i
      //   141: dup
      //   142: aload_1
      //   143: invokevirtual 81	java/io/IOException:getMessage	()Ljava/lang/String;
      //   146: invokespecial 84	com/appbrain/b/i:<init>	(Ljava/lang/String;)V
      //   149: aload_0
      //   150: invokevirtual 73	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   153: athrow
      //   154: aload_0
      //   155: aload_0
      //   156: getfield 65	com/appbrain/e/a$c:c	I
      //   159: iconst_4
      //   160: ior
      //   161: putfield 65	com/appbrain/e/a$c:c	I
      //   164: aload_0
      //   165: aload_1
      //   166: invokevirtual 87	com/appbrain/b/d:b	()J
      //   169: putfield 89	com/appbrain/e/a$c:f	J
      //   172: goto -152 -> 20
      //   175: return
      //   176: goto -104 -> 72
      //   179: iconst_1
      //   180: istore_2
      //   181: goto -161 -> 20
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	184	0	this	c
      //   0	184	1	paramd	com.appbrain.b.d
      //   19	162	2	i	int
      //   28	46	3	j	int
      // Exception table:
      //   from	to	target	type
      //   24	29	106	com/appbrain/b/i
      //   72	80	106	com/appbrain/b/i
      //   85	103	106	com/appbrain/b/i
      //   116	134	106	com/appbrain/b/i
      //   154	172	106	com/appbrain/b/i
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
    
    public static c f()
    {
      return b;
    }
    
    public static a l()
    {
      return a.f();
    }
    
    private com.appbrain.b.c m()
    {
      Object localObject = this.d;
      if ((localObject instanceof String))
      {
        localObject = com.appbrain.b.c.a((String)localObject);
        this.d = localObject;
        return (com.appbrain.b.c)localObject;
      }
      return (com.appbrain.b.c)localObject;
    }
    
    private void n()
    {
      this.d = "";
      this.e = 0;
      this.f = 0L;
    }
    
    public final void a(com.appbrain.b.e parame)
    {
      c();
      if ((this.c & 0x1) == 1) {
        parame.a(1, m());
      }
      if ((this.c & 0x2) == 2) {
        parame.a(2, this.e);
      }
      if ((this.c & 0x4) == 4) {
        parame.a(3, this.f);
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
        j = com.appbrain.b.e.b(1, m()) + 0;
      }
      i = j;
      if ((this.c & 0x2) == 2) {
        i = j + com.appbrain.b.e.c(2, this.e);
      }
      j = i;
      if ((this.c & 0x4) == 4) {
        j = i + com.appbrain.b.e.b(3, this.f);
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
    
    public final boolean h()
    {
      return (this.c & 0x2) == 2;
    }
    
    public final int i()
    {
      return this.e;
    }
    
    public final boolean j()
    {
      return (this.c & 0x4) == 4;
    }
    
    public final long k()
    {
      return this.f;
    }
    
    public static final class a
      extends g.a
      implements a.d
    {
      private int a;
      private Object b = "";
      private int c;
      private long d;
      
      private a g()
      {
        return new a().a(h());
      }
      
      private a.c h()
      {
        int j = 1;
        a.c localc = new a.c('\000');
        int k = this.a;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          a.c.a(localc, this.b);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          a.c.a(localc, this.c);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          a.c.a(localc, this.d);
          a.c.b(localc, j);
          return localc;
          j = 0;
        }
      }
      
      public final a a(int paramInt)
      {
        this.a |= 0x2;
        this.c = paramInt;
        return this;
      }
      
      public final a a(long paramLong)
      {
        this.a |= 0x4;
        this.d = paramLong;
        return this;
      }
      
      public final a a(a.c paramc)
      {
        if (paramc == a.c.f()) {}
        do
        {
          return this;
          if (paramc.g())
          {
            this.a |= 0x1;
            this.b = a.c.a(paramc);
          }
          if (paramc.h()) {
            a(paramc.i());
          }
        } while (!paramc.j());
        a(paramc.k());
        return this;
      }
      
      public final a a(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a |= 0x1;
        this.b = paramString;
        return this;
      }
      
      public final a.c d()
      {
        a.c localc = h();
        if (!localc.e()) {
          throw new q();
        }
        return localc;
      }
      
      public final boolean e()
      {
        return true;
      }
    }
  }
  
  public static abstract interface d
    extends n
  {}
  
  public static final class e
    extends com.appbrain.b.g
    implements a.f
  {
    public static o a = new d();
    private static final e b;
    private int c;
    private a.g d;
    private byte e = -1;
    private int f = -1;
    
    static
    {
      e locale = new e((byte)0);
      b = locale;
      locale.d = a.g.f();
    }
    
    private e()
    {
      super();
    }
    
    private e(byte paramByte) {}
    
    /* Error */
    private e(com.appbrain.b.d paramd, com.appbrain.b.f paramf)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 49	com/appbrain/b/g:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 46	com/appbrain/e/a$e:e	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 48	com/appbrain/e/a$e:f	I
      //   14: aload_0
      //   15: invokestatic 40	com/appbrain/e/a$g:f	()Lcom/appbrain/e/a$g;
      //   18: putfield 42	com/appbrain/e/a$e:d	Lcom/appbrain/e/a$g;
      //   21: iconst_0
      //   22: istore_3
      //   23: iload_3
      //   24: ifne +148 -> 172
      //   27: aload_1
      //   28: invokevirtual 61	com/appbrain/b/d:a	()I
      //   31: istore 4
      //   33: iload 4
      //   35: lookupswitch	default:+144->179, 0:+147->182, 10:+39->74
      //   60: aload_1
      //   61: iload 4
      //   63: invokevirtual 64	com/appbrain/b/d:b	(I)Z
      //   66: ifne -43 -> 23
      //   69: iconst_1
      //   70: istore_3
      //   71: goto -48 -> 23
      //   74: aload_0
      //   75: getfield 66	com/appbrain/e/a$e:c	I
      //   78: iconst_1
      //   79: iand
      //   80: iconst_1
      //   81: if_icmpne +92 -> 173
      //   84: aload_0
      //   85: getfield 42	com/appbrain/e/a$e:d	Lcom/appbrain/e/a$g;
      //   88: invokestatic 69	com/appbrain/e/a$g:a	(Lcom/appbrain/e/a$g;)Lcom/appbrain/e/a$g$a;
      //   91: astore 5
      //   93: aload_0
      //   94: aload_1
      //   95: getstatic 70	com/appbrain/e/a$g:a	Lcom/appbrain/b/o;
      //   98: aload_2
      //   99: invokevirtual 73	com/appbrain/b/d:a	(Lcom/appbrain/b/o;Lcom/appbrain/b/f;)Lcom/appbrain/b/m;
      //   102: checkcast 37	com/appbrain/e/a$g
      //   105: putfield 42	com/appbrain/e/a$e:d	Lcom/appbrain/e/a$g;
      //   108: aload 5
      //   110: ifnull +22 -> 132
      //   113: aload 5
      //   115: aload_0
      //   116: getfield 42	com/appbrain/e/a$e:d	Lcom/appbrain/e/a$g;
      //   119: invokevirtual 76	com/appbrain/e/a$g$a:a	(Lcom/appbrain/e/a$g;)Lcom/appbrain/e/a$g$a;
      //   122: pop
      //   123: aload_0
      //   124: aload 5
      //   126: invokevirtual 78	com/appbrain/e/a$g$a:d	()Lcom/appbrain/e/a$g;
      //   129: putfield 42	com/appbrain/e/a$e:d	Lcom/appbrain/e/a$g;
      //   132: aload_0
      //   133: aload_0
      //   134: getfield 66	com/appbrain/e/a$e:c	I
      //   137: iconst_1
      //   138: ior
      //   139: putfield 66	com/appbrain/e/a$e:c	I
      //   142: goto -119 -> 23
      //   145: astore_1
      //   146: aload_1
      //   147: aload_0
      //   148: invokevirtual 81	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   151: athrow
      //   152: astore_1
      //   153: aload_1
      //   154: athrow
      //   155: astore_1
      //   156: new 54	com/appbrain/b/i
      //   159: dup
      //   160: aload_1
      //   161: invokevirtual 85	java/io/IOException:getMessage	()Ljava/lang/String;
      //   164: invokespecial 88	com/appbrain/b/i:<init>	(Ljava/lang/String;)V
      //   167: aload_0
      //   168: invokevirtual 81	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
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
      //   0	187	0	this	e
      //   0	187	1	paramd	com.appbrain.b.d
      //   0	187	2	paramf	com.appbrain.b.f
      //   22	162	3	i	int
      //   31	31	4	j	int
      //   91	84	5	locala	a.g.a
      // Exception table:
      //   from	to	target	type
      //   27	33	145	com/appbrain/b/i
      //   60	69	145	com/appbrain/b/i
      //   74	93	145	com/appbrain/b/i
      //   93	108	145	com/appbrain/b/i
      //   113	132	145	com/appbrain/b/i
      //   132	142	145	com/appbrain/b/i
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
    
    public static e a(byte[] paramArrayOfByte)
    {
      return (e)a.a(paramArrayOfByte);
    }
    
    public static e f()
    {
      return b;
    }
    
    public final void a(com.appbrain.b.e parame)
    {
      c();
      if ((this.c & 0x1) == 1) {
        parame.a(1, this.d);
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
        i = com.appbrain.b.e.b(1, this.d) + 0;
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
    
    public final a.g h()
    {
      return this.d;
    }
    
    public static final class a
      extends g.a
      implements a.f
    {
      private int a;
      private a.g b = a.g.f();
      
      private a f()
      {
        return new a().a(g());
      }
      
      private a.e g()
      {
        int i = 1;
        a.e locale = new a.e('\000');
        if ((this.a & 0x1) == 1) {}
        for (;;)
        {
          a.e.a(locale, this.b);
          a.e.a(locale, i);
          return locale;
          i = 0;
        }
      }
      
      public final a a(a.e parame)
      {
        if (parame == a.e.f()) {}
        while (!parame.g()) {
          return this;
        }
        parame = parame.h();
        if (((this.a & 0x1) == 1) && (this.b != a.g.f())) {}
        for (this.b = a.g.a(this.b).a(parame).d();; this.b = parame)
        {
          this.a |= 0x1;
          return this;
        }
      }
      
      public final boolean e()
      {
        return true;
      }
    }
  }
  
  public static abstract interface f
    extends n
  {}
  
  public static final class g
    extends com.appbrain.b.g
    implements a.h
  {
    public static o a = new e();
    private static final g b;
    private int c;
    private List d;
    private List e;
    private boolean f;
    private boolean g;
    private byte h = -1;
    private int i = -1;
    
    static
    {
      g localg = new g((byte)0);
      b = localg;
      localg.o();
    }
    
    private g()
    {
      super();
    }
    
    private g(byte paramByte) {}
    
    /* Error */
    private g(com.appbrain.b.d paramd, com.appbrain.b.f paramf)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 8
      //   3: aload_0
      //   4: invokespecial 49	com/appbrain/b/g:<init>	()V
      //   7: aload_0
      //   8: iconst_m1
      //   9: putfield 46	com/appbrain/e/a$g:h	B
      //   12: aload_0
      //   13: iconst_m1
      //   14: putfield 48	com/appbrain/e/a$g:i	I
      //   17: aload_0
      //   18: invokespecial 42	com/appbrain/e/a$g:o	()V
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
      //   38: invokevirtual 61	com/appbrain/b/d:a	()I
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
      //   108: invokevirtual 64	com/appbrain/b/d:b	(I)Z
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
      //   140: new 66	java/util/ArrayList
      //   143: dup
      //   144: invokespecial 67	java/util/ArrayList:<init>	()V
      //   147: putfield 69	com/appbrain/e/a$g:d	Ljava/util/List;
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
      //   168: getfield 69	com/appbrain/e/a$g:d	Ljava/util/List;
      //   171: aload_1
      //   172: getstatic 72	com/appbrain/e/a$i:a	Lcom/appbrain/b/o;
      //   175: aload_2
      //   176: invokevirtual 75	com/appbrain/b/d:a	(Lcom/appbrain/b/o;Lcom/appbrain/b/f;)Lcom/appbrain/b/m;
      //   179: invokeinterface 81 2 0
      //   184: pop
      //   185: iload 5
      //   187: istore_3
      //   188: goto -165 -> 23
      //   191: astore_1
      //   192: iload 6
      //   194: istore 4
      //   196: aload_1
      //   197: aload_0
      //   198: invokevirtual 84	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   201: athrow
      //   202: astore_1
      //   203: iload 4
      //   205: iconst_1
      //   206: iand
      //   207: iconst_1
      //   208: if_icmpne +14 -> 222
      //   211: aload_0
      //   212: aload_0
      //   213: getfield 69	com/appbrain/e/a$g:d	Ljava/util/List;
      //   216: invokestatic 90	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   219: putfield 69	com/appbrain/e/a$g:d	Ljava/util/List;
      //   222: iload 4
      //   224: iconst_2
      //   225: iand
      //   226: iconst_2
      //   227: if_icmpne +14 -> 241
      //   230: aload_0
      //   231: aload_0
      //   232: getfield 92	com/appbrain/e/a$g:e	Ljava/util/List;
      //   235: invokestatic 90	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   238: putfield 92	com/appbrain/e/a$g:e	Ljava/util/List;
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
      //   263: new 66	java/util/ArrayList
      //   266: dup
      //   267: invokespecial 67	java/util/ArrayList:<init>	()V
      //   270: putfield 92	com/appbrain/e/a$g:e	Ljava/util/List;
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
      //   291: getfield 92	com/appbrain/e/a$g:e	Ljava/util/List;
      //   294: aload_1
      //   295: getstatic 72	com/appbrain/e/a$i:a	Lcom/appbrain/b/o;
      //   298: aload_2
      //   299: invokevirtual 75	com/appbrain/b/d:a	(Lcom/appbrain/b/o;Lcom/appbrain/b/f;)Lcom/appbrain/b/m;
      //   302: invokeinterface 81 2 0
      //   307: pop
      //   308: iload 5
      //   310: istore_3
      //   311: goto -288 -> 23
      //   314: astore_1
      //   315: iload 7
      //   317: istore 4
      //   319: new 54	com/appbrain/b/i
      //   322: dup
      //   323: aload_1
      //   324: invokevirtual 96	java/io/IOException:getMessage	()Ljava/lang/String;
      //   327: invokespecial 99	com/appbrain/b/i:<init>	(Ljava/lang/String;)V
      //   330: aload_0
      //   331: invokevirtual 84	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   334: athrow
      //   335: iload_3
      //   336: istore 6
      //   338: iload_3
      //   339: istore 4
      //   341: iload_3
      //   342: istore 7
      //   344: aload_0
      //   345: aload_0
      //   346: getfield 101	com/appbrain/e/a$g:c	I
      //   349: iconst_1
      //   350: ior
      //   351: putfield 101	com/appbrain/e/a$g:c	I
      //   354: iload_3
      //   355: istore 6
      //   357: iload_3
      //   358: istore 4
      //   360: iload_3
      //   361: istore 7
      //   363: aload_0
      //   364: aload_1
      //   365: invokevirtual 104	com/appbrain/b/d:d	()Z
      //   368: putfield 106	com/appbrain/e/a$g:f	Z
      //   371: goto -348 -> 23
      //   374: iload_3
      //   375: istore 6
      //   377: iload_3
      //   378: istore 4
      //   380: iload_3
      //   381: istore 7
      //   383: aload_0
      //   384: aload_0
      //   385: getfield 101	com/appbrain/e/a$g:c	I
      //   388: iconst_2
      //   389: ior
      //   390: putfield 101	com/appbrain/e/a$g:c	I
      //   393: iload_3
      //   394: istore 6
      //   396: iload_3
      //   397: istore 4
      //   399: iload_3
      //   400: istore 7
      //   402: aload_0
      //   403: aload_1
      //   404: invokevirtual 104	com/appbrain/b/d:d	()Z
      //   407: putfield 108	com/appbrain/e/a$g:g	Z
      //   410: goto -387 -> 23
      //   413: iload_3
      //   414: iconst_1
      //   415: iand
      //   416: iconst_1
      //   417: if_icmpne +14 -> 431
      //   420: aload_0
      //   421: aload_0
      //   422: getfield 69	com/appbrain/e/a$g:d	Ljava/util/List;
      //   425: invokestatic 90	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   428: putfield 69	com/appbrain/e/a$g:d	Ljava/util/List;
      //   431: iload_3
      //   432: iconst_2
      //   433: iand
      //   434: iconst_2
      //   435: if_icmpne +14 -> 449
      //   438: aload_0
      //   439: aload_0
      //   440: getfield 92	com/appbrain/e/a$g:e	Ljava/util/List;
      //   443: invokestatic 90	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   446: putfield 92	com/appbrain/e/a$g:e	Ljava/util/List;
      //   449: return
      //   450: goto -354 -> 96
      //   453: iconst_1
      //   454: istore 8
      //   456: goto -433 -> 23
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	459	0	this	g
      //   0	459	1	paramd	com.appbrain.b.d
      //   0	459	2	paramf	com.appbrain.b.f
      //   22	412	3	j	int
      //   32	366	4	k	int
      //   41	268	5	m	int
      //   29	366	6	n	int
      //   35	366	7	i1	int
      //   1	454	8	i2	int
      // Exception table:
      //   from	to	target	type
      //   37	43	191	com/appbrain/b/i
      //   105	114	191	com/appbrain/b/i
      //   139	150	191	com/appbrain/b/i
      //   167	185	191	com/appbrain/b/i
      //   262	273	191	com/appbrain/b/i
      //   290	308	191	com/appbrain/b/i
      //   344	354	191	com/appbrain/b/i
      //   363	371	191	com/appbrain/b/i
      //   383	393	191	com/appbrain/b/i
      //   402	410	191	com/appbrain/b/i
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
    
    public static a a(g paramg)
    {
      return a.f().a(paramg);
    }
    
    public static g f()
    {
      return b;
    }
    
    private void o()
    {
      this.d = Collections.emptyList();
      this.e = Collections.emptyList();
      this.f = false;
      this.g = false;
    }
    
    public final void a(com.appbrain.b.e parame)
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
        parame.a(1, (m)this.d.get(j));
        j += 1;
      }
      while (k < this.e.size())
      {
        parame.a(2, (m)this.e.get(k));
        k += 1;
      }
      if ((this.c & 0x1) == 1) {
        parame.a(3, this.f);
      }
      if ((this.c & 0x2) == 2) {
        parame.a(4, this.g);
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
        j += com.appbrain.b.e.b(1, (m)this.d.get(m));
        m += 1;
      }
      while (n < this.e.size())
      {
        k += com.appbrain.b.e.b(2, (m)this.e.get(n));
        n += 1;
      }
      j = k;
      boolean bool;
      if ((this.c & 0x1) == 1)
      {
        bool = this.f;
        j = k + com.appbrain.b.e.a(3);
      }
      int k = j;
      if ((this.c & 0x2) == 2)
      {
        bool = this.g;
        k = j + com.appbrain.b.e.a(4);
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
    
    public static final class a
      extends g.a
      implements a.h
    {
      private int a;
      private List b = Collections.emptyList();
      private List c = Collections.emptyList();
      private boolean d;
      private boolean e;
      
      private a g()
      {
        return new a().a(d());
      }
      
      public final a a(a.g paramg)
      {
        if (paramg == a.g.f()) {
          return this;
        }
        if (!a.g.b(paramg).isEmpty())
        {
          if (this.b.isEmpty())
          {
            this.b = a.g.b(paramg);
            this.a &= 0xFFFFFFFE;
          }
        }
        else {
          label52:
          if (!a.g.c(paramg).isEmpty())
          {
            if (!this.c.isEmpty()) {
              break label204;
            }
            this.c = a.g.c(paramg);
            this.a &= 0xFFFFFFFD;
          }
        }
        for (;;)
        {
          if (paramg.k())
          {
            bool = paramg.l();
            this.a |= 0x4;
            this.d = bool;
          }
          if (!paramg.m()) {
            break;
          }
          boolean bool = paramg.n();
          this.a |= 0x8;
          this.e = bool;
          return this;
          if ((this.a & 0x1) != 1)
          {
            this.b = new ArrayList(this.b);
            this.a |= 0x1;
          }
          this.b.addAll(a.g.b(paramg));
          break label52;
          label204:
          if ((this.a & 0x2) != 2)
          {
            this.c = new ArrayList(this.c);
            this.a |= 0x2;
          }
          this.c.addAll(a.g.c(paramg));
        }
      }
      
      public final a.g d()
      {
        int i = 1;
        a.g localg = new a.g('\000');
        int k = this.a;
        if ((this.a & 0x1) == 1)
        {
          this.b = Collections.unmodifiableList(this.b);
          this.a &= 0xFFFFFFFE;
        }
        a.g.a(localg, this.b);
        if ((this.a & 0x2) == 2)
        {
          this.c = Collections.unmodifiableList(this.c);
          this.a &= 0xFFFFFFFD;
        }
        a.g.b(localg, this.c);
        if ((k & 0x4) == 4) {}
        for (;;)
        {
          a.g.a(localg, this.d);
          int j = i;
          if ((k & 0x8) == 8) {
            j = i | 0x2;
          }
          a.g.b(localg, this.e);
          a.g.a(localg, j);
          return localg;
          i = 0;
        }
      }
      
      public final boolean e()
      {
        return true;
      }
    }
  }
  
  public static abstract interface h
    extends n
  {}
  
  public static final class i
    extends com.appbrain.b.g
    implements a.j
  {
    public static o a = new f();
    private static final i b;
    private int c;
    private Object d;
    private Object e;
    private boolean f;
    private byte g = -1;
    private int h = -1;
    
    static
    {
      i locali = new i((byte)0);
      b = locali;
      locali.o();
    }
    
    private i()
    {
      super();
    }
    
    private i(byte paramByte) {}
    
    /* Error */
    private i(com.appbrain.b.d paramd)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 49	com/appbrain/b/g:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 46	com/appbrain/e/a$i:g	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 48	com/appbrain/e/a$i:h	I
      //   14: aload_0
      //   15: invokespecial 42	com/appbrain/e/a$i:o	()V
      //   18: iconst_0
      //   19: istore_2
      //   20: iload_2
      //   21: ifne +154 -> 175
      //   24: aload_1
      //   25: invokevirtual 61	com/appbrain/b/d:a	()I
      //   28: istore_3
      //   29: iload_3
      //   30: lookupswitch	default:+146->176, 0:+149->179, 10:+55->85, 18:+86->116, 32:+124->154
      //   72: aload_1
      //   73: iload_3
      //   74: invokevirtual 64	com/appbrain/b/d:b	(I)Z
      //   77: ifne -57 -> 20
      //   80: iconst_1
      //   81: istore_2
      //   82: goto -62 -> 20
      //   85: aload_0
      //   86: aload_0
      //   87: getfield 66	com/appbrain/e/a$i:c	I
      //   90: iconst_1
      //   91: ior
      //   92: putfield 66	com/appbrain/e/a$i:c	I
      //   95: aload_0
      //   96: aload_1
      //   97: invokevirtual 69	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   100: putfield 71	com/appbrain/e/a$i:d	Ljava/lang/Object;
      //   103: goto -83 -> 20
      //   106: astore_1
      //   107: aload_1
      //   108: aload_0
      //   109: invokevirtual 74	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   112: athrow
      //   113: astore_1
      //   114: aload_1
      //   115: athrow
      //   116: aload_0
      //   117: aload_0
      //   118: getfield 66	com/appbrain/e/a$i:c	I
      //   121: iconst_2
      //   122: ior
      //   123: putfield 66	com/appbrain/e/a$i:c	I
      //   126: aload_0
      //   127: aload_1
      //   128: invokevirtual 69	com/appbrain/b/d:e	()Lcom/appbrain/b/c;
      //   131: putfield 76	com/appbrain/e/a$i:e	Ljava/lang/Object;
      //   134: goto -114 -> 20
      //   137: astore_1
      //   138: new 54	com/appbrain/b/i
      //   141: dup
      //   142: aload_1
      //   143: invokevirtual 80	java/io/IOException:getMessage	()Ljava/lang/String;
      //   146: invokespecial 83	com/appbrain/b/i:<init>	(Ljava/lang/String;)V
      //   149: aload_0
      //   150: invokevirtual 74	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   153: athrow
      //   154: aload_0
      //   155: aload_0
      //   156: getfield 66	com/appbrain/e/a$i:c	I
      //   159: iconst_4
      //   160: ior
      //   161: putfield 66	com/appbrain/e/a$i:c	I
      //   164: aload_0
      //   165: aload_1
      //   166: invokevirtual 86	com/appbrain/b/d:d	()Z
      //   169: putfield 88	com/appbrain/e/a$i:f	Z
      //   172: goto -152 -> 20
      //   175: return
      //   176: goto -104 -> 72
      //   179: iconst_1
      //   180: istore_2
      //   181: goto -161 -> 20
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	184	0	this	i
      //   0	184	1	paramd	com.appbrain.b.d
      //   19	162	2	i	int
      //   28	46	3	j	int
      // Exception table:
      //   from	to	target	type
      //   24	29	106	com/appbrain/b/i
      //   72	80	106	com/appbrain/b/i
      //   85	103	106	com/appbrain/b/i
      //   116	134	106	com/appbrain/b/i
      //   154	172	106	com/appbrain/b/i
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
    
    public static i f()
    {
      return b;
    }
    
    private com.appbrain.b.c m()
    {
      Object localObject = this.d;
      if ((localObject instanceof String))
      {
        localObject = com.appbrain.b.c.a((String)localObject);
        this.d = localObject;
        return (com.appbrain.b.c)localObject;
      }
      return (com.appbrain.b.c)localObject;
    }
    
    private com.appbrain.b.c n()
    {
      Object localObject = this.e;
      if ((localObject instanceof String))
      {
        localObject = com.appbrain.b.c.a((String)localObject);
        this.e = localObject;
        return (com.appbrain.b.c)localObject;
      }
      return (com.appbrain.b.c)localObject;
    }
    
    private void o()
    {
      this.d = "";
      this.e = "";
      this.f = false;
    }
    
    public final void a(com.appbrain.b.e parame)
    {
      c();
      if ((this.c & 0x1) == 1) {
        parame.a(1, m());
      }
      if ((this.c & 0x2) == 2) {
        parame.a(2, n());
      }
      if ((this.c & 0x4) == 4) {
        parame.a(4, this.f);
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
        j = com.appbrain.b.e.b(1, m()) + 0;
      }
      i = j;
      if ((this.c & 0x2) == 2) {
        i = j + com.appbrain.b.e.b(2, n());
      }
      j = i;
      if ((this.c & 0x4) == 4)
      {
        boolean bool = this.f;
        j = i + com.appbrain.b.e.a(4);
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
      localObject = (com.appbrain.b.c)localObject;
      String str = ((com.appbrain.b.c)localObject).d();
      if (((com.appbrain.b.c)localObject).e()) {
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
      localObject = (com.appbrain.b.c)localObject;
      String str = ((com.appbrain.b.c)localObject).d();
      if (((com.appbrain.b.c)localObject).e()) {
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
    
    public static final class a
      extends g.a
      implements a.j
    {
      private int a;
      private Object b = "";
      private Object c = "";
      private boolean d;
      
      private a f()
      {
        return new a().a(g());
      }
      
      private a.i g()
      {
        int j = 1;
        a.i locali = new a.i('\000');
        int k = this.a;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          a.i.a(locali, this.b);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          a.i.b(locali, this.c);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          a.i.a(locali, this.d);
          a.i.a(locali, j);
          return locali;
          j = 0;
        }
      }
      
      public final a a(a.i parami)
      {
        if (parami == a.i.f()) {}
        do
        {
          return this;
          if (parami.g())
          {
            this.a |= 0x1;
            this.b = a.i.a(parami);
          }
          if (parami.i())
          {
            this.a |= 0x2;
            this.c = a.i.b(parami);
          }
        } while (!parami.k());
        boolean bool = parami.l();
        this.a |= 0x4;
        this.d = bool;
        return this;
      }
      
      public final boolean e()
      {
        return true;
      }
    }
  }
  
  public static abstract interface j
    extends n
  {}
  
  public static final class k
    extends com.appbrain.b.g
    implements a.l
  {
    public static o a = new g();
    private static final k b;
    private int c;
    private h.a d;
    private boolean e;
    private List f;
    private boolean g;
    private List h;
    private byte i = -1;
    private int j = -1;
    
    static
    {
      k localk = new k((byte)0);
      b = localk;
      localk.o();
    }
    
    private k()
    {
      super();
    }
    
    private k(byte paramByte) {}
    
    /* Error */
    private k(com.appbrain.b.d paramd, com.appbrain.b.f paramf)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 52	com/appbrain/b/g:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 49	com/appbrain/e/a$k:i	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 51	com/appbrain/e/a$k:j	I
      //   14: aload_0
      //   15: invokespecial 45	com/appbrain/e/a$k:o	()V
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
      //   38: invokevirtual 64	com/appbrain/b/d:a	()I
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
      //   116: invokevirtual 67	com/appbrain/b/d:b	(I)Z
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
      //   138: getfield 69	com/appbrain/e/a$k:c	I
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
      //   157: getfield 71	com/appbrain/e/a$k:d	Lcom/appbrain/e/h$a;
      //   160: invokestatic 76	com/appbrain/e/h$a:a	(Lcom/appbrain/e/h$a;)Lcom/appbrain/e/h$a$a;
      //   163: astore 9
      //   165: iload_3
      //   166: istore 7
      //   168: iload_3
      //   169: istore 4
      //   171: iload_3
      //   172: istore 8
      //   174: aload_0
      //   175: aload_1
      //   176: getstatic 77	com/appbrain/e/h$a:a	Lcom/appbrain/b/o;
      //   179: aload_2
      //   180: invokevirtual 80	com/appbrain/b/d:a	(Lcom/appbrain/b/o;Lcom/appbrain/b/f;)Lcom/appbrain/b/m;
      //   183: checkcast 73	com/appbrain/e/h$a
      //   186: putfield 71	com/appbrain/e/a$k:d	Lcom/appbrain/e/h$a;
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
      //   206: getfield 71	com/appbrain/e/a$k:d	Lcom/appbrain/e/h$a;
      //   209: invokevirtual 83	com/appbrain/e/h$a$a:a	(Lcom/appbrain/e/h$a;)Lcom/appbrain/e/h$a$a;
      //   212: pop
      //   213: iload_3
      //   214: istore 7
      //   216: iload_3
      //   217: istore 4
      //   219: iload_3
      //   220: istore 8
      //   222: aload_0
      //   223: aload 9
      //   225: invokevirtual 86	com/appbrain/e/h$a$a:f	()Lcom/appbrain/e/h$a;
      //   228: putfield 71	com/appbrain/e/a$k:d	Lcom/appbrain/e/h$a;
      //   231: iload_3
      //   232: istore 7
      //   234: iload_3
      //   235: istore 4
      //   237: iload_3
      //   238: istore 8
      //   240: aload_0
      //   241: aload_0
      //   242: getfield 69	com/appbrain/e/a$k:c	I
      //   245: iconst_1
      //   246: ior
      //   247: putfield 69	com/appbrain/e/a$k:c	I
      //   250: goto -227 -> 23
      //   253: astore_1
      //   254: iload 7
      //   256: istore 4
      //   258: aload_1
      //   259: aload_0
      //   260: invokevirtual 89	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
      //   263: athrow
      //   264: astore_1
      //   265: iload 4
      //   267: iconst_4
      //   268: iand
      //   269: iconst_4
      //   270: if_icmpne +14 -> 284
      //   273: aload_0
      //   274: aload_0
      //   275: getfield 91	com/appbrain/e/a$k:f	Ljava/util/List;
      //   278: invokestatic 97	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   281: putfield 91	com/appbrain/e/a$k:f	Ljava/util/List;
      //   284: iload 4
      //   286: bipush 16
      //   288: iand
      //   289: bipush 16
      //   291: if_icmpne +14 -> 305
      //   294: aload_0
      //   295: aload_0
      //   296: getfield 99	com/appbrain/e/a$k:h	Ljava/util/List;
      //   299: invokestatic 97	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   302: putfield 99	com/appbrain/e/a$k:h	Ljava/util/List;
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
      //   318: getfield 69	com/appbrain/e/a$k:c	I
      //   321: iconst_2
      //   322: ior
      //   323: putfield 69	com/appbrain/e/a$k:c	I
      //   326: iload_3
      //   327: istore 7
      //   329: iload_3
      //   330: istore 4
      //   332: iload_3
      //   333: istore 8
      //   335: aload_0
      //   336: aload_1
      //   337: invokevirtual 102	com/appbrain/b/d:d	()Z
      //   340: putfield 104	com/appbrain/e/a$k:e	Z
      //   343: goto -320 -> 23
      //   346: astore_1
      //   347: iload 8
      //   349: istore 4
      //   351: new 57	com/appbrain/b/i
      //   354: dup
      //   355: aload_1
      //   356: invokevirtual 108	java/io/IOException:getMessage	()Ljava/lang/String;
      //   359: invokespecial 111	com/appbrain/b/i:<init>	(Ljava/lang/String;)V
      //   362: aload_0
      //   363: invokevirtual 89	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
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
      //   387: new 113	java/util/ArrayList
      //   390: dup
      //   391: invokespecial 114	java/util/ArrayList:<init>	()V
      //   394: putfield 91	com/appbrain/e/a$k:f	Ljava/util/List;
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
      //   415: getfield 91	com/appbrain/e/a$k:f	Ljava/util/List;
      //   418: aload_1
      //   419: getstatic 117	com/appbrain/e/a$a:a	Lcom/appbrain/b/o;
      //   422: aload_2
      //   423: invokevirtual 80	com/appbrain/b/d:a	(Lcom/appbrain/b/o;Lcom/appbrain/b/f;)Lcom/appbrain/b/m;
      //   426: invokeinterface 123 2 0
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
      //   449: getfield 69	com/appbrain/e/a$k:c	I
      //   452: iconst_4
      //   453: ior
      //   454: putfield 69	com/appbrain/e/a$k:c	I
      //   457: iload_3
      //   458: istore 7
      //   460: iload_3
      //   461: istore 4
      //   463: iload_3
      //   464: istore 8
      //   466: aload_0
      //   467: aload_1
      //   468: invokevirtual 102	com/appbrain/b/d:d	()Z
      //   471: putfield 125	com/appbrain/e/a$k:g	Z
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
      //   496: new 113	java/util/ArrayList
      //   499: dup
      //   500: invokespecial 114	java/util/ArrayList:<init>	()V
      //   503: putfield 99	com/appbrain/e/a$k:h	Ljava/util/List;
      //   506: iload_3
      //   507: bipush 16
      //   509: ior
      //   510: istore_3
      //   511: aload_0
      //   512: getfield 99	com/appbrain/e/a$k:h	Ljava/util/List;
      //   515: aload_1
      //   516: getstatic 128	com/appbrain/e/a$c:a	Lcom/appbrain/b/o;
      //   519: aload_2
      //   520: invokevirtual 80	com/appbrain/b/d:a	(Lcom/appbrain/b/o;Lcom/appbrain/b/f;)Lcom/appbrain/b/m;
      //   523: invokeinterface 123 2 0
      //   528: pop
      //   529: goto -506 -> 23
      //   532: iload_3
      //   533: iconst_4
      //   534: iand
      //   535: iconst_4
      //   536: if_icmpne +14 -> 550
      //   539: aload_0
      //   540: aload_0
      //   541: getfield 91	com/appbrain/e/a$k:f	Ljava/util/List;
      //   544: invokestatic 97	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   547: putfield 91	com/appbrain/e/a$k:f	Ljava/util/List;
      //   550: iload_3
      //   551: bipush 16
      //   553: iand
      //   554: bipush 16
      //   556: if_icmpne +14 -> 570
      //   559: aload_0
      //   560: aload_0
      //   561: getfield 99	com/appbrain/e/a$k:h	Ljava/util/List;
      //   564: invokestatic 97	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   567: putfield 99	com/appbrain/e/a$k:h	Ljava/util/List;
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
      //   0	613	0	this	k
      //   0	613	1	paramd	com.appbrain.b.d
      //   0	613	2	paramf	com.appbrain.b.f
      //   22	565	3	k	int
      //   32	556	4	m	int
      //   41	392	5	n	int
      //   19	590	6	i1	int
      //   29	459	7	i2	int
      //   35	459	8	i3	int
      //   163	434	9	locala	h.a.a
      // Exception table:
      //   from	to	target	type
      //   37	43	253	com/appbrain/b/i
      //   113	122	253	com/appbrain/b/i
      //   137	147	253	com/appbrain/b/i
      //   156	165	253	com/appbrain/b/i
      //   174	189	253	com/appbrain/b/i
      //   203	213	253	com/appbrain/b/i
      //   222	231	253	com/appbrain/b/i
      //   240	250	253	com/appbrain/b/i
      //   316	326	253	com/appbrain/b/i
      //   335	343	253	com/appbrain/b/i
      //   386	397	253	com/appbrain/b/i
      //   414	432	253	com/appbrain/b/i
      //   447	457	253	com/appbrain/b/i
      //   466	474	253	com/appbrain/b/i
      //   495	506	253	com/appbrain/b/i
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
      //   511	529	585	com/appbrain/b/i
    }
    
    public static k a(InputStream paramInputStream)
    {
      return (k)a.a(paramInputStream);
    }
    
    public static k f()
    {
      return b;
    }
    
    public static a m()
    {
      return a.f();
    }
    
    private void o()
    {
      this.d = h.a.f();
      this.e = false;
      this.f = Collections.emptyList();
      this.g = false;
      this.h = Collections.emptyList();
    }
    
    public final void a(com.appbrain.b.e parame)
    {
      int m = 0;
      c();
      if ((this.c & 0x1) == 1) {
        parame.a(1, this.d);
      }
      if ((this.c & 0x2) == 2) {
        parame.a(2, this.e);
      }
      int k = 0;
      while (k < this.f.size())
      {
        parame.a(3, (m)this.f.get(k));
        k += 1;
      }
      k = m;
      if ((this.c & 0x4) == 4)
      {
        parame.a(4, this.g);
        k = m;
      }
      while (k < this.h.size())
      {
        parame.a(5, (m)this.h.get(k));
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
      for (int m = com.appbrain.b.e.b(1, this.d) + 0;; m = 0)
      {
        k = m;
        boolean bool;
        if ((this.c & 0x2) == 2)
        {
          bool = this.e;
          k = m + com.appbrain.b.e.a(2);
        }
        m = 0;
        while (m < this.f.size())
        {
          k += com.appbrain.b.e.b(3, (m)this.f.get(m));
          m += 1;
        }
        int n = i1;
        m = k;
        if ((this.c & 0x4) == 4)
        {
          bool = this.g;
          m = k + com.appbrain.b.e.a(4);
          n = i1;
        }
        while (n < this.h.size())
        {
          m += com.appbrain.b.e.b(5, (m)this.h.get(n));
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
    
    public final h.a h()
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
    
    public final a n()
    {
      return a.f().a(this);
    }
    
    public static final class a
      extends g.a
      implements a.l
    {
      private int a;
      private h.a b = h.a.f();
      private boolean c;
      private List d = Collections.emptyList();
      private boolean e;
      private List f = Collections.emptyList();
      
      private a g()
      {
        return new a().a(h());
      }
      
      private a.k h()
      {
        int j = 1;
        a.k localk = new a.k('\000');
        int k = this.a;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          a.k.a(localk, this.b);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          a.k.a(localk, this.c);
          if ((this.a & 0x4) == 4)
          {
            this.d = Collections.unmodifiableList(this.d);
            this.a &= 0xFFFFFFFB;
          }
          a.k.a(localk, this.d);
          j = i;
          if ((k & 0x8) == 8) {
            j = i | 0x4;
          }
          a.k.b(localk, this.e);
          if ((this.a & 0x10) == 16)
          {
            this.f = Collections.unmodifiableList(this.f);
            this.a &= 0xFFFFFFEF;
          }
          a.k.b(localk, this.f);
          a.k.a(localk, j);
          return localk;
          j = 0;
        }
      }
      
      private void i()
      {
        if ((this.a & 0x4) != 4)
        {
          this.d = new ArrayList(this.d);
          this.a |= 0x4;
        }
      }
      
      private void j()
      {
        if ((this.a & 0x10) != 16)
        {
          this.f = new ArrayList(this.f);
          this.a |= 0x10;
        }
      }
      
      public final a a(a.a.a parama)
      {
        i();
        this.d.add(parama.d());
        return this;
      }
      
      public final a a(a.c paramc)
      {
        if (paramc == null) {
          throw new NullPointerException();
        }
        j();
        this.f.add(paramc);
        return this;
      }
      
      public final a a(a.k paramk)
      {
        if (paramk == a.k.f()) {
          return this;
        }
        h.a locala;
        if (paramk.g())
        {
          locala = paramk.h();
          if (((this.a & 0x1) == 1) && (this.b != h.a.f()))
          {
            this.b = h.a.a(this.b).a(locala).f();
            label59:
            this.a |= 0x1;
          }
        }
        else
        {
          if (paramk.i())
          {
            boolean bool = paramk.j();
            this.a |= 0x2;
            this.c = bool;
          }
          if (!a.k.a(paramk).isEmpty())
          {
            if (!this.d.isEmpty()) {
              break label208;
            }
            this.d = a.k.a(paramk);
            this.a &= 0xFFFFFFFB;
          }
        }
        for (;;)
        {
          if (paramk.k()) {
            a(paramk.l());
          }
          if (a.k.b(paramk).isEmpty()) {
            break;
          }
          if (!this.f.isEmpty()) {
            break label229;
          }
          this.f = a.k.b(paramk);
          this.a &= 0xFFFFFFEF;
          return this;
          this.b = locala;
          break label59;
          label208:
          i();
          this.d.addAll(a.k.a(paramk));
        }
        label229:
        j();
        this.f.addAll(a.k.b(paramk));
        return this;
      }
      
      public final a a(h.a parama)
      {
        if (parama == null) {
          throw new NullPointerException();
        }
        this.b = parama;
        this.a |= 0x1;
        return this;
      }
      
      public final a a(boolean paramBoolean)
      {
        this.a |= 0x8;
        this.e = paramBoolean;
        return this;
      }
      
      public final a.k d()
      {
        a.k localk = h();
        if (!localk.e()) {
          throw new q();
        }
        return localk;
      }
      
      public final boolean e()
      {
        return true;
      }
    }
  }
  
  public static abstract interface l
    extends n
  {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */