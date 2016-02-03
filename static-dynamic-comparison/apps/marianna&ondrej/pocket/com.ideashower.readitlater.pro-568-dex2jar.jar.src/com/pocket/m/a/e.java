package com.pocket.m.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Handler;
import com.ideashower.readitlater.a.ag;
import com.pocket.p.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public abstract class e
{
  public static final Object a = new Object();
  public static final long b;
  protected static final long c = c.b(10.0F);
  private static final Object d = new Object();
  private static final j e = new j();
  private static final long f;
  private static final long g;
  private static final ArrayList h = new ArrayList(1);
  private static final HashMap i = new HashMap();
  private static final ArrayList j = new ArrayList();
  private static final Runnable k = new Runnable()
  {
    public void run()
    {
      new com.ideashower.readitlater.db.operation.j()
      {
        protected void c_()
        {
          e.a(this);
        }
      }.f();
    }
  };
  private static SharedPreferences.OnSharedPreferenceChangeListener l;
  
  static
  {
    b = c.b(100.0F);
    f = b + c.b(100.0F);
    g = c.c(2.0F);
  }
  
  /* Error */
  public static com.ideashower.readitlater.f.a a(a parama, boolean paramBoolean, com.ideashower.readitlater.d.b paramb, d paramd)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: getstatic 42	com/pocket/m/a/e:a	Ljava/lang/Object;
    //   6: astore 6
    //   8: aload 6
    //   10: monitorenter
    //   11: aload_0
    //   12: ifnonnull +8 -> 20
    //   15: aload 6
    //   17: monitorexit
    //   18: aconst_null
    //   19: areturn
    //   20: aload 5
    //   22: astore 4
    //   24: getstatic 78	com/pocket/m/a/e:i	Ljava/util/HashMap;
    //   27: aload_0
    //   28: invokevirtual 91	com/pocket/m/a/a:e	()Ljava/lang/String;
    //   31: invokevirtual 95	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   34: ifne +50 -> 84
    //   37: iload_1
    //   38: ifne +14 -> 52
    //   41: aload 5
    //   43: astore 4
    //   45: aload_0
    //   46: invokevirtual 98	com/pocket/m/a/a:j	()Z
    //   49: ifne +35 -> 84
    //   52: getstatic 78	com/pocket/m/a/e:i	Ljava/util/HashMap;
    //   55: aload_0
    //   56: invokevirtual 91	com/pocket/m/a/a:e	()Ljava/lang/String;
    //   59: aload_0
    //   60: invokevirtual 102	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   63: pop
    //   64: new 104	com/ideashower/readitlater/f/a
    //   67: dup
    //   68: new 106	com/ideashower/readitlater/f/d
    //   71: dup
    //   72: aload_0
    //   73: invokespecial 109	com/ideashower/readitlater/f/d:<init>	(Lcom/pocket/m/a/a;)V
    //   76: aload_2
    //   77: iconst_0
    //   78: iconst_0
    //   79: invokespecial 112	com/ideashower/readitlater/f/a:<init>	(Lcom/ideashower/readitlater/f/d;Lcom/ideashower/readitlater/d/b;ZZ)V
    //   82: astore 4
    //   84: aload_0
    //   85: aload_3
    //   86: invokestatic 115	com/pocket/m/a/e:a	(Lcom/pocket/m/a/a;Lcom/pocket/m/a/d;)V
    //   89: aload 6
    //   91: monitorexit
    //   92: aload 4
    //   94: areturn
    //   95: astore_0
    //   96: aload 6
    //   98: monitorexit
    //   99: aload_0
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	parama	a
    //   0	101	1	paramBoolean	boolean
    //   0	101	2	paramb	com.ideashower.readitlater.d.b
    //   0	101	3	paramd	d
    //   22	71	4	localObject1	Object
    //   1	41	5	localObject2	Object
    //   6	91	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	18	95	finally
    //   24	37	95	finally
    //   45	52	95	finally
    //   52	84	95	finally
    //   84	92	95	finally
    //   96	99	95	finally
  }
  
  public static void a() {}
  
  public static void a(long paramLong1, long paramLong2)
  {
    synchronized (d)
    {
      com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.R, paramLong1);
      com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.S, paramLong2);
      e.a();
      Iterator localIterator = h.iterator();
      if (localIterator.hasNext()) {
        ((f)localIterator.next()).a(paramLong1);
      }
    }
  }
  
  public static void a(com.ideashower.readitlater.db.operation.j paramj)
  {
    synchronized (d)
    {
      ArrayList localArrayList = new ArrayList(j);
      j.clear();
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        ((com.ideashower.readitlater.objects.d)((Iterator)???).next()).a(paramj);
      }
    }
  }
  
  public static void a(a parama, d paramd)
  {
    a(parama.c(), paramd, null);
  }
  
  public static void a(a parama, boolean paramBoolean)
  {
    synchronized (a)
    {
      parama = (a)i.remove(parama.e());
      if (parama != null) {
        parama.a(paramBoolean);
      }
      return;
    }
  }
  
  public static void a(d paramd, com.ideashower.readitlater.db.operation.j paramj)
  {
    b(com.ideashower.readitlater.objects.d.a(paramd), paramj);
  }
  
  public static void a(f paramf)
  {
    synchronized (d)
    {
      h.add(paramf);
      return;
    }
  }
  
  public static void a(String paramString, d paramd)
  {
    b(com.ideashower.readitlater.objects.d.a(paramd, paramString), null);
  }
  
  public static void a(String paramString, d paramd, com.ideashower.readitlater.db.operation.j paramj)
  {
    b(com.ideashower.readitlater.objects.d.a(paramd, paramString), paramj);
  }
  
  public static boolean a(a parama, d paramd, boolean paramBoolean, com.ideashower.readitlater.d.d paramd1)
  {
    for (;;)
    {
      synchronized (a)
      {
        a locala = (a)i.get(parama.e());
        if (locala != null)
        {
          bool = true;
          if ((bool) && (paramd1 != null)) {
            locala.a(paramd1);
          }
          if ((bool) && (paramBoolean)) {
            a(parama, paramd);
          }
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public static boolean a(k paramk)
  {
    return (!e.b()) || (paramk == k.a);
  }
  
  public static void b()
  {
    com.pocket.m.d.e local2 = new com.pocket.m.d.e()
    {
      public void a(String paramAnonymousString, long paramAnonymousLong)
      {
        e.a(com.ideashower.readitlater.objects.d.a(paramAnonymousString, paramAnonymousLong), null);
      }
    };
    com.pocket.m.d.d.a(local2);
    com.ideashower.readitlater.f.i.a(local2);
    l = new SharedPreferences.OnSharedPreferenceChangeListener()
    {
      public void onSharedPreferenceChanged(SharedPreferences paramAnonymousSharedPreferences, String paramAnonymousString)
      {
        if ((paramAnonymousString.equals(com.ideashower.readitlater.h.a.P.b())) || (paramAnonymousString.equals(com.ideashower.readitlater.h.a.N.b()))) {
          e.r().e();
        }
      }
    };
    com.ideashower.readitlater.h.i.a(l);
    e.a();
    com.ideashower.readitlater.a.g.a(new com.ideashower.readitlater.a.i()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {
          g.a();
        }
      }
    });
  }
  
  private static void b(com.ideashower.readitlater.objects.d paramd, com.ideashower.readitlater.db.operation.j arg1)
  {
    if (??? != null)
    {
      paramd.a(???);
      return;
    }
    for (;;)
    {
      Handler localHandler;
      synchronized (d)
      {
        localHandler = com.ideashower.readitlater.a.g.o();
        localHandler.removeCallbacks(k);
        j.add(paramd);
        if (j.size() >= 400)
        {
          k.run();
          return;
        }
      }
      localHandler.postDelayed(k, 1000L);
    }
  }
  
  public static void b(f paramf)
  {
    synchronized (d)
    {
      h.remove(paramf);
      return;
    }
  }
  
  public static void c()
  {
    synchronized (a)
    {
      i.clear();
      return;
    }
  }
  
  public static ag d()
  {
    new ag()
    {
      public void a() {}
      
      public void b() {}
      
      public void c()
      {
        
        synchronized (e.s())
        {
          com.ideashower.readitlater.a.g.o().removeCallbacks(e.t());
          e.u().clear();
          return;
        }
      }
    };
  }
  
  public static boolean e()
  {
    return e.c();
  }
  
  public static long f()
  {
    long l1 = l();
    if (l1 <= 0L) {
      return 0L;
    }
    l1 = h() - l1;
    if (l1 > 0L) {}
    for (;;)
    {
      return l1;
      l1 = 0L;
    }
  }
  
  public static long g()
  {
    if (!i()) {
      return -1L;
    }
    if (j()) {
      return 0L;
    }
    return l() - h();
  }
  
  public static long h()
  {
    return com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.R) + com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.S);
  }
  
  public static boolean i()
  {
    return k() > 0L;
  }
  
  public static boolean j()
  {
    return f() > 0L;
  }
  
  public static long k()
  {
    return com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.N);
  }
  
  public static long l()
  {
    long l1 = 0L;
    long l2 = k();
    if (l2 > 0L) {
      l1 = l2 - b;
    }
    return l1;
  }
  
  public static long m()
  {
    return f;
  }
  
  public static long n()
  {
    return g;
  }
  
  public static boolean o()
  {
    for (;;)
    {
      synchronized (d)
      {
        if (!h.isEmpty())
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public static void p()
  {
    e.d();
  }
  
  public static k q()
  {
    if (com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.P) == 0) {
      return k.a;
    }
    return k.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */