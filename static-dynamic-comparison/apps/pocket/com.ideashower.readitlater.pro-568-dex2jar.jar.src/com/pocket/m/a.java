package com.pocket.m;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.ideashower.readitlater.a.ag;
import com.ideashower.readitlater.db.operation.aa;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
{
  private static com.pocket.m.e.a a;
  private static com.pocket.m.e.a b;
  private static com.pocket.m.e.g c;
  private static final ConcurrentHashMap d = new ConcurrentHashMap();
  private static final ConcurrentHashMap e = new ConcurrentHashMap();
  private static final AtomicInteger f = new AtomicInteger();
  private static final AtomicInteger g = new AtomicInteger();
  private static final AtomicBoolean h = new AtomicBoolean(false);
  private static final AtomicBoolean i = new AtomicBoolean(false);
  private static final Object j = new Object();
  private static com.pocket.m.c.d k;
  private static final ConcurrentHashMap l = new ConcurrentHashMap();
  private static final ConcurrentHashMap m = new ConcurrentHashMap();
  private static final ArrayList n = new ArrayList();
  private static final Runnable o = new Runnable()
  {
    public void run() {}
  };
  private static Thread p;
  private static final Object q = new Object();
  private static ArrayList r;
  private static final com.ideashower.readitlater.objects.l s = new com.ideashower.readitlater.objects.l(com.ideashower.readitlater.a.g.o(), 300L);
  
  private static boolean C()
  {
    for (;;)
    {
      synchronized (j)
      {
        if (k != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private static void D()
  {
    synchronized (j)
    {
      if (k != null)
      {
        k.D();
        k = null;
      }
      return;
    }
  }
  
  public static com.pocket.m.e.c a(int paramInt, com.pocket.m.b.f paramf)
  {
    return c(paramInt).a(paramf);
  }
  
  public static void a() {}
  
  public static void a(int paramInt)
  {
    a.a(paramInt);
    b.a(paramInt);
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    a.a(paramInt, paramBoolean);
    b.a(paramInt, paramBoolean);
  }
  
  public static void a(Handler paramHandler)
  {
    a = new com.pocket.m.e.a(1, com.pocket.m.e.g.b);
    a.a(true);
    b = new com.pocket.m.e.a(2, com.pocket.m.e.g.a);
    c = new com.pocket.m.e.g(paramHandler);
    c.a();
  }
  
  public static void a(o paramo, int paramInt, boolean paramBoolean1, boolean paramBoolean2, com.pocket.m.a.k paramk, boolean paramBoolean3)
  {
    if ((paramInt == 0) || (paramInt == 2)) {
      paramo.h(0);
    }
    if ((paramInt == 0) || (paramInt == 1)) {
      paramo.i(0);
    }
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramo);
    paramo = new com.pocket.m.c.c(localArrayList, 2, 3, paramk, paramBoolean3, paramBoolean1);
    if (paramInt != 0) {
      paramo.a(paramInt);
    }
    paramo.f();
    e();
  }
  
  public static void a(com.pocket.m.b.f paramf)
  {
    int i1 = -1;
    if (paramf == null) {}
    o localo;
    do
    {
      return;
      localo = paramf.v();
    } while (localo == null);
    if ((!h.get()) && (!paramf.a_())) {
      if (paramf.l() == 2)
      {
        e.remove(Integer.valueOf(localo.f()));
        label54:
        if (!paramf.H()) {
          break label234;
        }
      }
    }
    for (;;)
    {
      label88:
      Object localObject1;
      switch (paramf.l())
      {
      default: 
        localObject1 = (com.pocket.m.b.f)e.get(Integer.valueOf(localo.f()));
        Object localObject2 = (com.pocket.m.b.f)d.get(Integer.valueOf(localo.f()));
        if ((localObject1 == null) && (localObject2 == null))
        {
          if (paramf.j())
          {
            f.decrementAndGet();
            if (f.get() == 0) {
              g.set(0);
            }
          }
          localo.f(false);
        }
        new aa(localo, paramf.l(), i1, paramf.x(), paramf.y()).f();
        if (paramf.l() != 1) {
          break;
        }
        com.ideashower.readitlater.i.c.a((com.pocket.m.b.i)paramf, true);
        return;
        if (paramf.l() != 1) {
          break label54;
        }
        d.remove(Integer.valueOf(localo.f()));
        break label54;
        if (paramf.g())
        {
          if ((paramf.l() != 1) && (paramf.l() != 2)) {
            break label368;
          }
          localObject1 = localo.ag();
          if (localObject1 != null)
          {
            localObject2 = ((ArrayList)localObject1).iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
            } while (((y)((Iterator)localObject2).next()).n());
          }
        }
      case 2: 
      case 1: 
        label192:
        label234:
        for (i1 = 1;; i1 = 0)
        {
          if (i1 != 0) {
            a((ArrayList)localObject1, localo.f(), com.ideashower.readitlater.a.g.c(), paramf.k());
          }
          i1 = 1;
          break;
          if (paramf.w() != -2) {
            break;
          }
          i1 = -2;
          break;
          localo.h(i1);
          break label88;
          localo.i(i1);
          break label88;
          localo.f(false);
          break label192;
        }
        label368:
        i1 = 1;
      }
    }
  }
  
  public static void a(com.pocket.m.b.i parami)
  {
    if ((!parami.a_()) && (!parami.f()))
    {
      if ((parami.z() != null) && (parami.z().size() > 0)) {
        l.put(parami.u(), parami.z());
      }
      if ((parami.A() != null) && (parami.A().size() > 0)) {
        m.put(parami.u(), parami.A());
      }
    }
    com.ideashower.readitlater.i.c.a(parami, false);
  }
  
  public static void a(com.pocket.m.e.f paramf)
  {
    a.a(paramf);
  }
  
  public static void a(e parame)
  {
    n.add(new WeakReference(parame));
    parame = n.iterator();
    while (parame.hasNext()) {
      if (((WeakReference)parame.next()).get() == null) {
        parame.remove();
      }
    }
  }
  
  public static void a(String paramString)
  {
    a(false, true, paramString);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    a(new com.pocket.m.b.i(2, 4, paramString, paramBoolean, com.pocket.m.a.k.a));
    e();
  }
  
  public static void a(ArrayList paramArrayList, int paramInt, Context paramContext, com.ideashower.readitlater.g.l paraml)
  {
    paramArrayList = new com.pocket.m.b.k(paramArrayList, paramInt, 4, com.pocket.m.a.k.a, paramContext);
    paramArrayList.a(paraml, true);
    a(paramArrayList);
    e();
  }
  
  public static void a(ArrayList paramArrayList, int paramInt, Context paramContext, com.pocket.m.a.k paramk)
  {
    b(new com.pocket.m.b.k(paramArrayList, paramInt, 3, paramk, paramContext));
    e();
  }
  
  private static void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.H)) && (!com.ideashower.readitlater.a.g.l())) {}
    while (com.ideashower.readitlater.i.a.a(true)) {
      return;
    }
    synchronized (j)
    {
      if ((k != null) && (!k.a_())) {
        return;
      }
    }
    if (paramString != null) {}
    for (k = new com.pocket.m.c.a(paramString, com.pocket.m.a.k.b);; k = new com.pocket.m.c.b(com.pocket.m.a.k.b))
    {
      k.f();
      return;
    }
  }
  
  public static boolean a(com.pocket.m.b.e parame)
  {
    return a(b, parame);
  }
  
  private static boolean a(com.pocket.m.e.a parama, com.pocket.m.b.e parame)
  {
    if (!com.pocket.m.a.e.a(parame.k())) {
      return false;
    }
    try
    {
      parama.a(parame);
      return true;
    }
    catch (RejectedExecutionException parama) {}
    return false;
  }
  
  public static boolean a(boolean paramBoolean)
  {
    return (!h.get()) && ((C()) || (a.a()) || ((paramBoolean) && (b.a())));
  }
  
  public static SparseArray b(String paramString)
  {
    return (SparseArray)l.get(paramString);
  }
  
  public static ConcurrentHashMap b()
  {
    return d;
  }
  
  public static void b(int paramInt)
  {
    synchronized (q)
    {
      if (r == null) {
        r = new ArrayList();
      }
      r.add(Integer.valueOf(paramInt));
      s.a(new c(null));
      return;
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    a(paramBoolean, false, null);
  }
  
  public static boolean b(com.pocket.m.b.e parame)
  {
    return a(a, parame);
  }
  
  public static SparseArray c(String paramString)
  {
    return (SparseArray)m.get(paramString);
  }
  
  private static com.pocket.m.e.a c(int paramInt)
  {
    if (paramInt == 2) {
      return b;
    }
    return a;
  }
  
  public static ConcurrentHashMap c()
  {
    return e;
  }
  
  public static void c(boolean paramBoolean)
  {
    i.set(paramBoolean);
  }
  
  public static com.ideashower.readitlater.g.g d()
  {
    if (h.get()) {
      return null;
    }
    h.set(true);
    e();
    return new b(null).h();
  }
  
  public static void d(boolean paramBoolean)
  {
    if ((a(false)) && (p == null))
    {
      p = new Thread(new d(paramBoolean));
      p.start();
    }
  }
  
  public static void e()
  {
    if (com.ideashower.readitlater.a.g.q())
    {
      Iterator localIterator = n.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((e)localWeakReference.get()).a();
        }
      }
    }
    com.ideashower.readitlater.a.g.a(o);
  }
  
  public static boolean f()
  {
    return (!h.get()) && (a.a());
  }
  
  public static void g()
  {
    synchronized (j)
    {
      k = null;
      return;
    }
  }
  
  public static boolean h()
  {
    return i.get();
  }
  
  public static void i()
  {
    c.b();
  }
  
  public static boolean j()
  {
    return a(true);
  }
  
  public static void k()
  {
    g.incrementAndGet();
    f.incrementAndGet();
  }
  
  public static void l()
  {
    c.a();
  }
  
  public static ag m()
  {
    new ag()
    {
      public void a()
      {
        a.d().d();
        new f(null).h().d();
      }
      
      public void b() {}
      
      public void c()
      {
        a.s().clear();
        a.t().clear();
        a.u().set(0);
        a.v().set(0);
        a.w().set(false);
        a.z().set(true);
        a.A().clear();
        a.B().clear();
        a.a(com.ideashower.readitlater.a.g.o());
      }
    };
  }
  
  public static int n()
  {
    return g.get();
  }
  
  public static int o()
  {
    return g.get() - f.get();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */