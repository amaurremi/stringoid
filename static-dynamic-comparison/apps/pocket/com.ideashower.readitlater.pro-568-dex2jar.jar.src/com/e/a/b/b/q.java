package com.e.a.b.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.List;

public final class q
{
  private final int b;
  private final n c;
  private final int d;
  private final int e;
  private long f = 0L;
  private int g;
  private final List h;
  private List i;
  private final r j = new r(this, null);
  private final s k = new s(this, null);
  private a l = null;
  
  static
  {
    if (!q.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  q(int paramInt1, n paramn, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, List paramList, j paramj)
  {
    if (paramn == null) {
      throw new NullPointerException("connection == null");
    }
    if (paramList == null) {
      throw new NullPointerException("requestHeaders == null");
    }
    this.b = paramInt1;
    this.c = paramn;
    r.a(this.j, paramBoolean2);
    s.a(this.k, paramBoolean1);
    this.d = paramInt2;
    this.e = paramInt3;
    this.h = paramList;
    b(paramj);
  }
  
  private void b(j paramj)
  {
    int m = 65536;
    if ((!a) && (!Thread.holdsLock(this.c))) {
      throw new AssertionError();
    }
    if (paramj != null) {
      m = paramj.d(65536);
    }
    this.g = m;
  }
  
  private boolean d(a parama)
  {
    if ((!a) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      if (this.l != null) {
        return false;
      }
      if ((r.a(this.j)) && (s.a(this.k))) {
        return false;
      }
    }
    finally {}
    this.l = parama;
    notifyAll();
    this.c.a(this.b);
    return true;
  }
  
  private void g()
  {
    if ((!a) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    for (;;)
    {
      try
      {
        boolean bool;
        if ((!r.a(this.j)) && (r.b(this.j)))
        {
          if (s.a(this.k)) {
            break label112;
          }
          if (s.b(this.k))
          {
            break label112;
            bool = a();
            if (m == 0) {
              break label95;
            }
            a(a.l);
            return;
          }
        }
        m = 0;
        continue;
        if (bool) {
          continue;
        }
      }
      finally {}
      label95:
      this.c.a(this.b);
      return;
      label112:
      int m = 1;
    }
  }
  
  void a(int paramInt)
  {
    try
    {
      s.a(this.k, paramInt);
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void a(a parama)
  {
    if (!d(parama)) {
      return;
    }
    this.c.b(this.b, parama);
  }
  
  void a(j paramj)
  {
    if ((!a) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    b(paramj);
    notifyAll();
  }
  
  void a(InputStream paramInputStream, int paramInt)
  {
    if ((!a) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    this.j.a(paramInputStream, paramInt);
  }
  
  void a(List paramList)
  {
    boolean bool = true;
    if ((!a) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    int m = 0;
    try
    {
      if ((b()) && (this.i == null))
      {
        this.i = paramList;
        bool = a();
        notifyAll();
        if (m == 0) {
          break label79;
        }
        b(a.e);
      }
      while (bool)
      {
        return;
        m = 1;
        break;
      }
    }
    finally {}
    label79:
    this.c.a(this.b);
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 57	com/e/a/b/b/q:l	Lcom/e/a/b/b/a;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 50	com/e/a/b/b/q:j	Lcom/e/a/b/b/r;
    //   21: invokestatic 110	com/e/a/b/b/r:a	(Lcom/e/a/b/b/r;)Z
    //   24: ifne +13 -> 37
    //   27: aload_0
    //   28: getfield 50	com/e/a/b/b/q:j	Lcom/e/a/b/b/r;
    //   31: invokestatic 127	com/e/a/b/b/r:b	(Lcom/e/a/b/b/r;)Z
    //   34: ifeq +32 -> 66
    //   37: aload_0
    //   38: getfield 55	com/e/a/b/b/q:k	Lcom/e/a/b/b/s;
    //   41: invokestatic 113	com/e/a/b/b/s:a	(Lcom/e/a/b/b/s;)Z
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: getfield 55	com/e/a/b/b/q:k	Lcom/e/a/b/b/s;
    //   51: invokestatic 129	com/e/a/b/b/s:b	(Lcom/e/a/b/b/s;)Z
    //   54: ifeq +12 -> 66
    //   57: aload_0
    //   58: getfield 155	com/e/a/b/b/q:i	Ljava/util/List;
    //   61: astore_2
    //   62: aload_2
    //   63: ifnonnull -50 -> 13
    //   66: iconst_1
    //   67: istore_1
    //   68: goto -55 -> 13
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	q
    //   1	67	1	bool	boolean
    //   8	55	2	localObject1	Object
    //   71	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	71	finally
    //   17	37	71	finally
    //   37	57	71	finally
    //   57	62	71	finally
  }
  
  public void b(a parama)
  {
    if (!d(parama)) {
      return;
    }
    this.c.a(this.b, parama);
  }
  
  /* Error */
  void b(List paramList)
  {
    // Byte code:
    //   0: getstatic 36	com/e/a/b/b/q:a	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 94	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 96	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 97	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: iconst_0
    //   22: istore_2
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 155	com/e/a/b/b/q:i	Ljava/util/List;
    //   29: ifnull +49 -> 78
    //   32: new 163	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 164	java/util/ArrayList:<init>	()V
    //   39: astore_3
    //   40: aload_3
    //   41: aload_0
    //   42: getfield 155	com/e/a/b/b/q:i	Ljava/util/List;
    //   45: invokeinterface 170 2 0
    //   50: pop
    //   51: aload_3
    //   52: aload_1
    //   53: invokeinterface 170 2 0
    //   58: pop
    //   59: aload_0
    //   60: aload_3
    //   61: putfield 155	com/e/a/b/b/q:i	Ljava/util/List;
    //   64: aload_0
    //   65: monitorexit
    //   66: iload_2
    //   67: ifeq +10 -> 77
    //   70: aload_0
    //   71: getstatic 172	com/e/a/b/b/a:b	Lcom/e/a/b/b/a;
    //   74: invokevirtual 159	com/e/a/b/b/q:b	(Lcom/e/a/b/b/a;)V
    //   77: return
    //   78: iconst_1
    //   79: istore_2
    //   80: goto -16 -> 64
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	q
    //   0	88	1	paramList	List
    //   22	58	2	m	int
    //   39	22	3	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   25	64	83	finally
    //   64	66	83	finally
    //   84	86	83	finally
  }
  
  public boolean b()
  {
    if (this.b % 2 == 1) {}
    for (int m = 1; this.c.b == m; m = 0) {
      return true;
    }
    return false;
  }
  
  public List c()
  {
    try
    {
      while ((this.i == null) && (this.l == null)) {
        wait();
      }
      InterruptedIOException localInterruptedIOException;
      if (this.i == null) {
        break label61;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedIOException = new InterruptedIOException();
      localInterruptedIOException.initCause(localInterruptedException);
      throw localInterruptedIOException;
    }
    finally {}
    List localList = this.i;
    return localList;
    label61:
    throw new IOException("stream was reset: " + this.l);
  }
  
  void c(a parama)
  {
    try
    {
      if (this.l == null)
      {
        this.l = parama;
        notifyAll();
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public InputStream d()
  {
    return this.j;
  }
  
  public OutputStream e()
  {
    try
    {
      if ((this.i == null) && (!b())) {
        throw new IllegalStateException("reply before requesting the output stream");
      }
    }
    finally {}
    return this.k;
  }
  
  void f()
  {
    if ((!a) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      r.a(this.j, true);
      boolean bool = a();
      notifyAll();
      if (!bool) {
        this.c.a(this.b);
      }
      return;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */