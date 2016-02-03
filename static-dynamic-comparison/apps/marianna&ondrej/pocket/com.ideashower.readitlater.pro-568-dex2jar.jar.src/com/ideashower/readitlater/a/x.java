package com.ideashower.readitlater.a;

import android.graphics.Bitmap;
import com.ideashower.readitlater.g.f;
import com.ideashower.readitlater.g.k;
import com.ideashower.readitlater.util.a.c;
import com.pocket.m.a.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class x
{
  private static final com.ideashower.readitlater.d.d a = new com.ideashower.readitlater.d.d()
  {
    public void a(com.pocket.m.a.a paramAnonymousa, boolean paramAnonymousBoolean)
    {
      x.a(paramAnonymousa, paramAnonymousBoolean);
    }
  };
  private static final com.ideashower.readitlater.d.b b = new com.ideashower.readitlater.d.b()
  {
    public void a(boolean paramAnonymousBoolean, com.ideashower.readitlater.f.b paramAnonymousb, com.pocket.m.a.a paramAnonymousa)
    {
      x.a(paramAnonymousBoolean, paramAnonymousb, paramAnonymousa);
    }
    
    public void a(boolean paramAnonymousBoolean, com.ideashower.readitlater.f.b paramAnonymousb, String paramAnonymousString, com.pocket.m.a.a paramAnonymousa) {}
    
    public void a(boolean paramAnonymousBoolean1, com.ideashower.readitlater.f.b paramAnonymousb, String paramAnonymousString, boolean paramAnonymousBoolean2) {}
    
    public boolean a_()
    {
      return false;
    }
  };
  private static HashMap c;
  private static com.ideashower.readitlater.util.a.a d;
  private static f e;
  private static com.ideashower.readitlater.g.i f;
  private static com.ideashower.readitlater.g.i g;
  
  public static com.ideashower.readitlater.util.a.b a(com.ideashower.readitlater.f.e parame)
  {
    return a(parame, true);
  }
  
  private static com.ideashower.readitlater.util.a.b a(com.ideashower.readitlater.f.e parame, boolean paramBoolean)
  {
    Object localObject2;
    if (parame.k())
    {
      localObject2 = (com.ideashower.readitlater.util.a.b)d.a(parame.c());
      if ((localObject2 != null) && (((com.ideashower.readitlater.util.a.b)localObject2).c()))
      {
        ((com.ideashower.readitlater.util.a.b)localObject2).b(true);
        return (com.ideashower.readitlater.util.a.b)localObject2;
      }
    }
    if (paramBoolean)
    {
      e(parame);
      return null;
    }
    if (f(parame))
    {
      Object localObject1;
      int i;
      if (com.ideashower.readitlater.f.i.b(parame))
      {
        localObject1 = c.a(parame.c(), null);
        i = 0;
        label79:
        if (localObject1 == null) {
          break label163;
        }
        localObject1 = new com.ideashower.readitlater.util.a.b((Bitmap)localObject1, parame.c());
        d.b(parame.c(), (com.ideashower.readitlater.util.a.b)localObject1);
        ((com.ideashower.readitlater.util.a.b)localObject1).b(true);
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (i == 0) {
          break;
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          break;
        }
        new y(parame, (com.ideashower.readitlater.util.a.b)localObject1, null).h();
        return (com.ideashower.readitlater.util.a.b)localObject1;
        localObject1 = com.ideashower.readitlater.f.i.b(parame.f().c(), parame.i());
        i = 1;
        break label79;
        label163:
        localObject1 = null;
      }
    }
    return null;
  }
  
  public static void a()
  {
    c = new HashMap();
    int j = g.w();
    if (j > 24)
    {
      i = 5;
      d = new com.ideashower.readitlater.util.a.a(1048576 * j / i);
      if (j <= 40) {
        break label92;
      }
    }
    label92:
    for (int i = 2;; i = 1)
    {
      e = new f(i, "img-resize");
      f = new com.ideashower.readitlater.g.i(2, "img-download");
      g = new com.ideashower.readitlater.g.i(1, "img-write");
      return;
      i = 8;
      break;
    }
  }
  
  public static void a(com.ideashower.readitlater.f.i parami)
  {
    com.ideashower.readitlater.f.e locale = parami.f();
    if (locale == null) {
      return;
    }
    if ((locale.a() == null) || (!parami.e()))
    {
      locale.m();
      return;
    }
    g(locale);
  }
  
  protected static void a(com.pocket.m.a.a parama, boolean paramBoolean)
  {
    synchronized (com.pocket.m.a.e.a)
    {
      parama = (ArrayList)c.remove(parama.e());
      if ((paramBoolean) && (parama != null))
      {
        parama = parama.iterator();
        if (parama.hasNext())
        {
          ??? = (com.ideashower.readitlater.f.i)parama.next();
          e.a((k)???);
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean, com.ideashower.readitlater.f.b paramb, com.pocket.m.a.a parama)
  {
    byte[] arrayOfByte = paramb.b();
    if ((paramBoolean) && (arrayOfByte != null))
    {
      paramb = new com.pocket.m.d.d(null, 0, arrayOfByte, parama.c(), parama);
      g.a(paramb);
    }
    while (paramb.i() != 3) {
      return;
    }
    l.a(parama);
  }
  
  public static com.ideashower.readitlater.util.a.b b(com.ideashower.readitlater.f.e parame)
  {
    return a(parame, false);
  }
  
  public static void b() {}
  
  public static ag c()
  {
    new ag()
    {
      public void a()
      {
        x.e().a(false);
        x.f().a(false);
        x.g().a(false);
      }
      
      public void b() {}
      
      public void c()
      {
        synchronized (com.pocket.m.a.e.a)
        {
          x.h().clear();
          return;
        }
      }
    };
  }
  
  public static void d()
  {
    if (d != null) {
      d.b();
    }
  }
  
  private static void e(com.ideashower.readitlater.f.e parame)
  {
    new z(parame, null).h();
  }
  
  private static boolean f(com.ideashower.readitlater.f.e parame)
  {
    int i = 1;
    boolean bool = true;
    com.pocket.m.a.a locala = parame.f();
    if (l.b(locala)) {
      bool = false;
    }
    while (locala.j()) {
      return bool;
    }
    for (;;)
    {
      synchronized (com.pocket.m.a.e.a)
      {
        Object localObject1;
        if (com.pocket.m.a.e.a(locala, parame.e(), true, a))
        {
          if (i != 0)
          {
            com.ideashower.readitlater.f.i locali = com.ideashower.readitlater.f.i.a(parame);
            if (locali != null)
            {
              localObject1 = (ArrayList)c.get(locala.e());
              parame = (com.ideashower.readitlater.f.e)localObject1;
              if (localObject1 == null) {
                parame = new ArrayList();
              }
              parame.add(locali);
              c.put(locala.e(), parame);
            }
          }
          return false;
        }
        if ((parame.g()) && (com.pocket.m.a.e.a(parame.h())))
        {
          localObject1 = com.pocket.m.a.e.a(locala, false, b, parame.e());
          if (localObject1 == null) {
            return false;
          }
          com.pocket.m.a.e.a(parame.f(), parame.e(), false, a);
          f.a((k)localObject1);
        }
      }
      i = 0;
    }
  }
  
  private static void g(final com.ideashower.readitlater.f.e parame)
  {
    Object localObject2 = null;
    com.ideashower.readitlater.f.g localg = parame.a();
    if ((localg != null) && (!localg.a(parame)))
    {
      parame.m();
      return;
    }
    final Object localObject1 = localObject2;
    if (parame.k())
    {
      localObject1 = localObject2;
      if (localg != null)
      {
        Bitmap localBitmap = c.a(parame.c(), null);
        localObject1 = localObject2;
        if (localBitmap != null)
        {
          localObject1 = new com.ideashower.readitlater.util.a.b(localBitmap, parame.c());
          d.b(parame.c(), (com.ideashower.readitlater.util.a.b)localObject1);
        }
      }
    }
    if ((localg != null) && ((!parame.k()) || (localObject1 != null)))
    {
      if (localObject1 != null) {
        ((com.ideashower.readitlater.util.a.b)localObject1).b(true);
      }
      if (parame.l())
      {
        g.a(new Runnable()
        {
          public void run()
          {
            x.this.a(parame, localObject1);
          }
        });
        return;
      }
      localg.a(parame, (com.ideashower.readitlater.util.a.b)localObject1);
      return;
    }
    parame.m();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */