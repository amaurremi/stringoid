package com.pocket.n;

import com.ideashower.readitlater.a.ag;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.ae;
import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.db.operation.m;
import com.ideashower.readitlater.g.k;
import com.ideashower.readitlater.g.l;
import java.util.ArrayList;
import java.util.Iterator;

public class a
{
  private static final ArrayList a = new ArrayList();
  private static final ArrayList b = new ArrayList();
  private static m c;
  private static boolean d = false;
  
  static
  {
    c = new m()
    {
      public void a(final ArrayList paramAnonymousArrayList)
      {
        com.ideashower.readitlater.a.g.a(new Runnable()
        {
          public void run()
          {
            a.a(paramAnonymousArrayList);
          }
        });
      }
    };
    j.a(c);
  }
  
  public static ag a()
  {
    new ag()
    {
      public void a()
      {
        j.b(a.b());
        a.c().clear();
      }
      
      public void b()
      {
        a.d().clear();
      }
      
      public void c()
      {
        j.a(a.b());
      }
    };
  }
  
  public static void a(b paramb)
  {
    a.add(paramb);
  }
  
  public static void a(g paramg, UiContext paramUiContext)
  {
    new ae(paramg, paramUiContext).j();
  }
  
  public static void b(b paramb)
  {
    a.remove(paramb);
  }
  
  private static void b(ArrayList paramArrayList)
  {
    d = true;
    b.clear();
    b.addAll(paramArrayList);
    paramArrayList = a.iterator();
    while (paramArrayList.hasNext()) {
      e((b)paramArrayList.next());
    }
  }
  
  public static void c(final b paramb)
  {
    if (d)
    {
      e(paramb);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    j local2 = new j()
    {
      protected void c_()
      {
        a.this.addAll(v());
      }
    };
    local2.a(new l()
    {
      public void a() {}
      
      public void a(k paramAnonymousk, boolean paramAnonymousBoolean)
      {
        a.a(a.this);
        a.d(paramb);
      }
    }, true);
    local2.f();
  }
  
  private static void e(b paramb)
  {
    paramb.a(new ArrayList(b));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/n/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */