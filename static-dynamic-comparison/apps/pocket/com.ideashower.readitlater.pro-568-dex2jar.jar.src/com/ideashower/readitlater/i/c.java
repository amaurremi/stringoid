package com.ideashower.readitlater.i;

import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.e.o;
import com.pocket.m.b.a;
import com.pocket.m.b.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class c
{
  protected static ArrayList a = new ArrayList();
  protected static ArrayList b = new ArrayList();
  protected static ArrayList c = new ArrayList();
  private static final Runnable d = new Runnable()
  {
    public void run() {}
  };
  
  public static void a()
  {
    if (!g.q())
    {
      g.a(d);
      return;
    }
    b();
  }
  
  public static void a(com.ideashower.readitlater.d.c paramc)
  {
    a.add(new WeakReference(paramc));
  }
  
  public static void a(o paramo)
  {
    if (paramo == null) {
      throw new NullPointerException();
    }
    if (!g.q()) {
      g.a(new Runnable()
      {
        public void run()
        {
          c.a(c.this);
        }
      });
    }
    for (;;)
    {
      return;
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        com.ideashower.readitlater.d.c localc = (com.ideashower.readitlater.d.c)((WeakReference)localIterator.next()).get();
        if (localc == null) {
          localIterator.remove();
        } else {
          localc.a(paramo);
        }
      }
    }
  }
  
  public static void a(d paramd)
  {
    b.add(new WeakReference(paramd));
  }
  
  public static void a(e parame)
  {
    c.add(new WeakReference(parame));
  }
  
  public static void a(i parami, final boolean paramBoolean)
  {
    if (!g.q())
    {
      g.a(new Runnable()
      {
        public void run()
        {
          c.a(c.this, paramBoolean);
        }
      });
      return;
    }
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)((WeakReference)localIterator.next()).get();
      if (locald == null) {
        localIterator.remove();
      } else if (locald.a(parami, paramBoolean)) {
        localIterator.remove();
      }
    }
    a.a(parami, paramBoolean);
  }
  
  public static void a(List paramList)
  {
    if (!g.q()) {
      g.a(new Runnable()
      {
        public void run()
        {
          c.a(c.this);
        }
      });
    }
    for (;;)
    {
      return;
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        com.ideashower.readitlater.d.c localc = (com.ideashower.readitlater.d.c)((WeakReference)localIterator.next()).get();
        if (localc == null) {
          localIterator.remove();
        } else {
          localc.a(paramList);
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)((WeakReference)localIterator.next()).get();
      if (locale == null) {
        localIterator.remove();
      } else {
        locale.a(paramBoolean);
      }
    }
  }
  
  private static void b()
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      com.ideashower.readitlater.d.c localc = (com.ideashower.readitlater.d.c)((WeakReference)localIterator.next()).get();
      if (localc == null) {
        localIterator.remove();
      } else {
        localc.aj();
      }
    }
  }
  
  public static void b(com.ideashower.readitlater.d.c paramc)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      com.ideashower.readitlater.d.c localc = (com.ideashower.readitlater.d.c)((WeakReference)localIterator.next()).get();
      if (localc == null) {
        localIterator.remove();
      } else if (localc == paramc) {
        localIterator.remove();
      }
    }
  }
  
  public static void b(e parame)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)((WeakReference)localIterator.next()).get();
      if (locale == null) {
        localIterator.remove();
      } else if (locale == parame) {
        localIterator.remove();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/i/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */