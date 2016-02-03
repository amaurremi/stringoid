package com.e.a;

import com.e.a.b.j;
import com.e.a.b.q;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c
{
  private static final c a;
  private final int b;
  private final long c;
  private final LinkedList d = new LinkedList();
  private final ExecutorService e = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), q.b("OkHttp ConnectionPool"));
  private final Callable f = new Callable()
  {
    public Void a()
    {
      ArrayList localArrayList = new ArrayList(2);
      int i = 0;
      label252:
      label255:
      label258:
      label261:
      for (;;)
      {
        synchronized (c.this)
        {
          ListIterator localListIterator = c.a(c.this).listIterator(c.a(c.this).size());
          b localb;
          if (localListIterator.hasPrevious())
          {
            localb = (b)localListIterator.previous();
            if ((!localb.d()) || (localb.a(c.b(c.this))))
            {
              localListIterator.remove();
              localArrayList.add(localb);
              if (localArrayList.size() != 2) {
                break label255;
              }
            }
          }
          else
          {
            localListIterator = c.a(c.this).listIterator(c.a(c.this).size());
            if ((!localListIterator.hasPrevious()) || (i <= c.c(c.this))) {
              continue;
            }
            localb = (b)localListIterator.previous();
            if (!localb.g()) {
              break label252;
            }
            localArrayList.add(localb);
            localListIterator.remove();
            i -= 1;
            break label258;
          }
          if (!localb.g()) {
            break label255;
          }
          i += 1;
          break label261;
          ??? = localArrayList.iterator();
          if (((Iterator)???).hasNext()) {
            q.a((b)((Iterator)???).next());
          }
        }
        return null;
        break label258;
        break label261;
      }
    }
  };
  
  static
  {
    String str1 = System.getProperty("http.keepAlive");
    String str2 = System.getProperty("http.keepAliveDuration");
    String str3 = System.getProperty("http.maxConnections");
    if (str2 != null) {}
    for (long l = Long.parseLong(str2); (str1 != null) && (!Boolean.parseBoolean(str1)); l = 300000L)
    {
      a = new c(0, l);
      return;
    }
    if (str3 != null)
    {
      a = new c(Integer.parseInt(str3), l);
      return;
    }
    a = new c(5, l);
  }
  
  public c(int paramInt, long paramLong)
  {
    this.b = paramInt;
    this.c = (paramLong * 1000L * 1000L);
  }
  
  public static c a()
  {
    return a;
  }
  
  public b a(a parama)
  {
    for (;;)
    {
      try
      {
        ListIterator localListIterator = this.d.listIterator(this.d.size());
        if (localListIterator.hasPrevious())
        {
          b localb2 = (b)localListIterator.previous();
          if ((localb2.b().a().equals(parama)) && (localb2.d()) && (System.nanoTime() - localb2.h() < this.c))
          {
            localListIterator.remove();
            boolean bool = localb2.i();
            b localb1 = localb2;
            if (!bool) {}
            try
            {
              j.a().a(localb2.c());
              localb1 = localb2;
              if ((localb1 != null) && (localb1.i())) {
                this.d.addFirst(localb1);
              }
              this.e.submit(this.f);
              return localb1;
            }
            catch (SocketException localSocketException)
            {
              q.a(localb2);
              j.a().a("Unable to tagSocket(): " + localSocketException);
            }
          }
        }
        else
        {
          Object localObject = null;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public void a(b paramb)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 158	com/e/a/b:i	()Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: invokevirtual 145	com/e/a/b:d	()Z
    //   12: ifne +8 -> 20
    //   15: aload_1
    //   16: invokestatic 182	com/e/a/b/q:a	(Ljava/io/Closeable;)V
    //   19: return
    //   20: invokestatic 163	com/e/a/b/j:a	()Lcom/e/a/b/j;
    //   23: aload_1
    //   24: invokevirtual 166	com/e/a/b:c	()Ljava/net/Socket;
    //   27: invokevirtual 204	com/e/a/b/j:b	(Ljava/net/Socket;)V
    //   30: aload_0
    //   31: monitorenter
    //   32: aload_0
    //   33: getfield 66	com/e/a/c:d	Ljava/util/LinkedList;
    //   36: aload_1
    //   37: invokevirtual 173	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   40: aload_1
    //   41: invokevirtual 206	com/e/a/b:f	()V
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_0
    //   47: getfield 91	com/e/a/c:e	Ljava/util/concurrent/ExecutorService;
    //   50: aload_0
    //   51: getfield 96	com/e/a/c:f	Ljava/util/concurrent/Callable;
    //   54: invokeinterface 179 2 0
    //   59: pop
    //   60: return
    //   61: astore_2
    //   62: invokestatic 163	com/e/a/b/j:a	()Lcom/e/a/b/j;
    //   65: new 184	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   72: ldc -48
    //   74: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_2
    //   78: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokevirtual 201	com/e/a/b/j:a	(Ljava/lang/String;)V
    //   87: aload_1
    //   88: invokestatic 182	com/e/a/b/q:a	(Ljava/io/Closeable;)V
    //   91: return
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	c
    //   0	97	1	paramb	b
    //   61	17	2	localSocketException	SocketException
    // Exception table:
    //   from	to	target	type
    //   20	30	61	java/net/SocketException
    //   32	46	92	finally
    //   93	95	92	finally
  }
  
  public void b()
  {
    try
    {
      Object localObject1 = new ArrayList(this.d);
      this.d.clear();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        q.a((b)((Iterator)localObject1).next());
      }
      return;
    }
    finally {}
  }
  
  public void b(b paramb)
  {
    this.e.submit(this.f);
    if (!paramb.i()) {}
    while (!paramb.d()) {
      return;
    }
    try
    {
      this.d.addFirst(paramb);
      return;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */