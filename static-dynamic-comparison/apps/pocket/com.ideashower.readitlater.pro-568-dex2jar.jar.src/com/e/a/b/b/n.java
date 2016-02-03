package com.e.a.b.b;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class n
  implements Closeable
{
  private static final ExecutorService e;
  final t a;
  final boolean b;
  j c;
  private final h f;
  private final b g;
  private final d h;
  private final Map i = new HashMap();
  private final String j;
  private int k;
  private int l;
  private boolean m;
  private long n = System.nanoTime();
  private Map o;
  private int p;
  
  static
  {
    if (!n.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.e.a.b.q.b("OkHttp SpdyConnection"));
      return;
    }
  }
  
  private n(o paramo)
  {
    this.a = o.a(paramo);
    this.b = o.b(paramo);
    this.f = o.c(paramo);
    this.g = this.a.a(o.d(paramo), this.b);
    this.h = this.a.a(o.e(paramo), this.b);
    if (o.b(paramo))
    {
      i1 = 1;
      this.l = i1;
      if (!o.b(paramo)) {
        break label173;
      }
    }
    label173:
    for (int i1 = i2;; i1 = 2)
    {
      this.p = i1;
      this.j = o.f(paramo);
      new Thread(new p(this, null), "Spdy Reader " + this.j).start();
      return;
      i1 = 2;
      break;
    }
  }
  
  private void a(a parama1, a parama2)
  {
    if ((!d) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      a(parama1);
      parama1 = null;
    }
    catch (IOException parama1)
    {
      for (;;) {}
    }
    for (;;)
    {
      int i2;
      int i1;
      try
      {
        if (this.i.isEmpty()) {
          break label288;
        }
        arrayOfq = (q[])this.i.values().toArray(new q[this.i.size()]);
        this.i.clear();
        a(false);
        if (this.o == null) {
          break label282;
        }
        arrayOfi = (i[])this.o.values().toArray(new i[this.o.size()]);
        this.o = null;
        localObject = parama1;
        if (arrayOfq == null) {
          break label206;
        }
        i2 = arrayOfq.length;
        i1 = 0;
        if (i1 >= i2) {
          break label203;
        }
        localObject = arrayOfq[i1];
      }
      finally {}
      try
      {
        ((q)localObject).a(parama2);
        localObject = parama1;
      }
      catch (IOException localIOException)
      {
        localObject = parama1;
        if (parama1 == null) {
          continue;
        }
        localObject = localIOException;
        continue;
      }
      i1 += 1;
      parama1 = (a)localObject;
      continue;
      label203:
      Object localObject = parama1;
      label206:
      if (arrayOfi != null)
      {
        i2 = arrayOfi.length;
        i1 = 0;
        while (i1 < i2)
        {
          arrayOfi[i1].c();
          i1 += 1;
        }
      }
      try
      {
        this.g.close();
        parama1 = (a)localObject;
      }
      catch (IOException parama1)
      {
        label261:
        for (;;) {}
      }
      try
      {
        this.h.close();
        parama2 = parama1;
      }
      catch (IOException parama2)
      {
        if (parama1 == null) {
          break label261;
        }
        parama2 = parama1;
        break label261;
      }
      if (parama2 != null) {
        throw parama2;
      }
      return;
      label282:
      i[] arrayOfi = null;
      continue;
      label288:
      q[] arrayOfq = null;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        l1 = System.nanoTime();
        this.n = l1;
        return;
      }
      finally {}
      long l1 = 0L;
    }
  }
  
  private void a(final boolean paramBoolean, final int paramInt1, final int paramInt2, final i parami)
  {
    e.submit(new com.e.a.b.i("OkHttp SPDY Writer %s ping %08x%08x", new Object[] { this.j, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) })
    {
      public void a()
      {
        try
        {
          n.a(n.this, paramBoolean, paramInt1, paramInt2, parami);
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  private q b(int paramInt)
  {
    try
    {
      q localq = (q)this.i.get(Integer.valueOf(paramInt));
      return localq;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void b(boolean paramBoolean, int paramInt1, int paramInt2, i parami)
  {
    d locald = this.h;
    if (parami != null) {}
    try
    {
      parami.a();
      this.h.a(paramBoolean, paramInt1, paramInt2);
      return;
    }
    finally {}
  }
  
  /* Error */
  private i c(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 215	com/e/a/b/b/n:o	Ljava/util/Map;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 215	com/e/a/b/b/n:o	Ljava/util/Map;
    //   13: iload_1
    //   14: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokeinterface 276 2 0
    //   22: checkcast 217	com/e/a/b/b/i
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_2
    //   32: goto -6 -> 26
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	n
    //   0	40	1	paramInt	int
    //   25	7	2	locali	i
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  q a(int paramInt)
  {
    try
    {
      q localq = (q)this.i.remove(Integer.valueOf(paramInt));
      if ((localq != null) && (this.i.isEmpty())) {
        a(true);
      }
      return localq;
    }
    finally {}
  }
  
  public q a(List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      paramBoolean1 = true;
      if (paramBoolean2) {
        break label57;
      }
    }
    label57:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      synchronized (this.h)
      {
        try
        {
          if (!this.m) {
            break label62;
          }
          throw new IOException("shutdown");
        }
        finally {}
      }
      paramBoolean1 = false;
      break;
    }
    label62:
    int i1 = this.l;
    this.l += 2;
    q localq = new q(i1, this, paramBoolean1, paramBoolean2, 0, 0, paramList, this.c);
    if (localq.a())
    {
      this.i.put(Integer.valueOf(i1), localq);
      a(false);
    }
    this.h.a(paramBoolean1, paramBoolean2, i1, 0, 0, 0, paramList);
    return localq;
  }
  
  void a(final int paramInt1, final int paramInt2)
  {
    e.submit(new com.e.a.b.i("OkHttp SPDY Writer %s stream %d", new Object[] { this.j, Integer.valueOf(paramInt1) })
    {
      public void a()
      {
        try
        {
          n.this.b(paramInt1, paramInt2);
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  void a(final int paramInt, final a parama)
  {
    e.submit(new com.e.a.b.i("OkHttp SPDY Writer %s stream %d", new Object[] { this.j, Integer.valueOf(paramInt) })
    {
      public void a()
      {
        try
        {
          n.this.b(paramInt, parama);
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  public void a(int paramInt1, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.h.a(paramBoolean, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public void a(a parama)
  {
    int i1;
    synchronized (this.h) {}
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 93	com/e/a/b/b/n:n	J
    //   6: lstore_1
    //   7: lload_1
    //   8: lconst_0
    //   9: lcmp
    //   10: ifeq +9 -> 19
    //   13: iconst_1
    //   14: istore_3
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_3
    //   18: ireturn
    //   19: iconst_0
    //   20: istore_3
    //   21: goto -6 -> 15
    //   24: astore 4
    //   26: aload_0
    //   27: monitorexit
    //   28: aload 4
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	n
    //   6	2	1	l1	long
    //   14	7	3	bool	boolean
    //   24	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	24	finally
  }
  
  public long b()
  {
    try
    {
      long l1 = this.n;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void b(int paramInt1, int paramInt2)
  {
    this.h.a(paramInt1, paramInt2);
  }
  
  void b(int paramInt, a parama)
  {
    this.h.a(paramInt, parama);
  }
  
  public void c()
  {
    this.h.b();
  }
  
  public void close()
  {
    a(a.a, a.l);
  }
  
  public void d()
  {
    this.h.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */