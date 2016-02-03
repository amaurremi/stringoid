package com.e.a.b.b;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;

class p
  implements c, Runnable
{
  private p(n paramn) {}
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 0) {}
    q localq;
    do
    {
      return;
      localq = n.a(this.a, paramInt1);
    } while (localq == null);
    localq.a(paramInt2);
  }
  
  public void a(int paramInt, a parama)
  {
    q localq = this.a.a(paramInt);
    if (localq != null) {
      localq.c(parama);
    }
  }
  
  public void a(int paramInt, List paramList)
  {
    q localq = n.a(this.a, paramInt);
    if (localq != null) {
      localq.b(paramList);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      i locali = n.c(this.a, paramInt1);
      if (locali != null) {
        locali.b();
      }
      return;
    }
    n.b(this.a, true, paramInt1, paramInt2, null);
  }
  
  public void a(boolean paramBoolean, int paramInt1, InputStream paramInputStream, int paramInt2)
  {
    q localq = n.a(this.a, paramInt1);
    if (localq == null)
    {
      this.a.a(paramInt1, a.c);
      com.e.a.b.q.a(paramInputStream, paramInt2);
    }
    do
    {
      return;
      localq.a(paramInputStream, paramInt2);
    } while (!paramBoolean);
    localq.f();
  }
  
  public void a(boolean paramBoolean, int paramInt, List paramList)
  {
    q localq = n.a(this.a, paramInt);
    if (localq == null) {
      this.a.a(paramInt, a.c);
    }
    do
    {
      return;
      localq.a(paramList);
    } while (!paramBoolean);
    localq.f();
  }
  
  public void a(boolean paramBoolean, j paramj)
  {
    for (;;)
    {
      int i;
      synchronized (this.a)
      {
        if ((this.a.c == null) || (paramBoolean))
        {
          this.a.c = paramj;
          if (n.c(this.a).isEmpty()) {
            break label176;
          }
          paramj = (q[])n.c(this.a).values().toArray(new q[n.c(this.a).size()]);
          if (paramj == null) {
            break label175;
          }
          int j = paramj.length;
          i = 0;
          if (i >= j) {
            break label175;
          }
        }
      }
      synchronized (paramj[i])
      {
        synchronized (this.a)
        {
          ???.a(this.a.c);
          i += 1;
          continue;
          this.a.c.a(paramj);
          continue;
          paramj = finally;
          throw paramj;
        }
      }
      label175:
      return;
      label176:
      paramj = null;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, final List paramList)
  {
    synchronized (this.a)
    {
      paramList = new q(paramInt1, this.a, paramBoolean1, paramBoolean2, paramInt3, paramInt4, paramList, this.a.c);
      if (n.b(this.a)) {
        return;
      }
      n.b(this.a, paramInt1);
      q localq = (q)n.c(this.a).put(Integer.valueOf(paramInt1), paramList);
      if (localq != null)
      {
        localq.b(a.b);
        this.a.a(paramInt1);
        return;
      }
    }
    n.e().submit(new com.e.a.b.i("OkHttp SPDY Callback %s stream %d", new Object[] { n.d(this.a), Integer.valueOf(paramInt1) })
    {
      public void a()
      {
        try
        {
          n.e(p.this.a).a(paramList);
          return;
        }
        catch (IOException localIOException)
        {
          throw new RuntimeException(localIOException);
        }
      }
    });
  }
  
  public void b(int paramInt, a arg2)
  {
    synchronized (this.a)
    {
      n.a(this.a, true);
      Iterator localIterator = n.c(this.a).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((((Integer)localEntry.getKey()).intValue() > paramInt) && (((q)localEntry.getValue()).b()))
        {
          ((q)localEntry.getValue()).c(a.k);
          localIterator.remove();
        }
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: getstatic 206	com/e/a/b/b/a:g	Lcom/e/a/b/b/a;
    //   3: astore_3
    //   4: getstatic 206	com/e/a/b/b/a:g	Lcom/e/a/b/b/a;
    //   7: astore 4
    //   9: aload_3
    //   10: astore_2
    //   11: aload_3
    //   12: astore_1
    //   13: aload_0
    //   14: getfield 16	com/e/a/b/b/p:a	Lcom/e/a/b/b/n;
    //   17: invokestatic 209	com/e/a/b/b/n:a	(Lcom/e/a/b/b/n;)Lcom/e/a/b/b/b;
    //   20: aload_0
    //   21: invokeinterface 214 2 0
    //   26: ifne -17 -> 9
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: astore_1
    //   33: getstatic 216	com/e/a/b/b/a:a	Lcom/e/a/b/b/a;
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: astore_1
    //   41: getstatic 219	com/e/a/b/b/a:l	Lcom/e/a/b/b/a;
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 16	com/e/a/b/b/p:a	Lcom/e/a/b/b/n;
    //   50: aload_3
    //   51: aload 5
    //   53: invokestatic 222	com/e/a/b/b/n:a	(Lcom/e/a/b/b/n;Lcom/e/a/b/b/a;Lcom/e/a/b/b/a;)V
    //   56: return
    //   57: astore_1
    //   58: aload_2
    //   59: astore_1
    //   60: getstatic 138	com/e/a/b/b/a:b	Lcom/e/a/b/b/a;
    //   63: astore_3
    //   64: getstatic 138	com/e/a/b/b/a:b	Lcom/e/a/b/b/a;
    //   67: astore_1
    //   68: aload_0
    //   69: getfield 16	com/e/a/b/b/p:a	Lcom/e/a/b/b/n;
    //   72: aload_3
    //   73: aload_1
    //   74: invokestatic 222	com/e/a/b/b/n:a	(Lcom/e/a/b/b/n;Lcom/e/a/b/b/a;Lcom/e/a/b/b/a;)V
    //   77: return
    //   78: astore_1
    //   79: return
    //   80: astore_2
    //   81: aload_1
    //   82: astore_3
    //   83: aload_2
    //   84: astore_1
    //   85: aload_0
    //   86: getfield 16	com/e/a/b/b/p:a	Lcom/e/a/b/b/n;
    //   89: aload_3
    //   90: aload 4
    //   92: invokestatic 222	com/e/a/b/b/n:a	(Lcom/e/a/b/b/n;Lcom/e/a/b/b/a;Lcom/e/a/b/b/a;)V
    //   95: aload_1
    //   96: athrow
    //   97: astore_2
    //   98: goto -3 -> 95
    //   101: astore_1
    //   102: goto -17 -> 85
    //   105: astore_1
    //   106: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	p
    //   12	29	1	localObject1	Object
    //   57	1	1	localIOException1	IOException
    //   59	15	1	localObject2	Object
    //   78	4	1	localIOException2	IOException
    //   84	12	1	localObject3	Object
    //   101	1	1	localObject4	Object
    //   105	1	1	localIOException3	IOException
    //   10	49	2	localObject5	Object
    //   80	4	2	localObject6	Object
    //   97	1	2	localIOException4	IOException
    //   3	87	3	localObject7	Object
    //   7	84	4	locala1	a
    //   44	8	5	locala2	a
    // Exception table:
    //   from	to	target	type
    //   13	29	57	java/io/IOException
    //   33	37	57	java/io/IOException
    //   41	46	57	java/io/IOException
    //   68	77	78	java/io/IOException
    //   13	29	80	finally
    //   33	37	80	finally
    //   41	46	80	finally
    //   60	64	80	finally
    //   85	95	97	java/io/IOException
    //   64	68	101	finally
    //   46	56	105	java/io/IOException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */