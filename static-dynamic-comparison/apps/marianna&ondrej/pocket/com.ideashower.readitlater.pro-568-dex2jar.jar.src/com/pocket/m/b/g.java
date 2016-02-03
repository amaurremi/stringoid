package com.pocket.m.b;

import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.i.d;
import com.pocket.m.a;
import java.io.File;

public class g
  implements com.ideashower.readitlater.g.l, d
{
  private final h a;
  private String b;
  private o c;
  private File d;
  
  private g(h paramh)
  {
    this.a = paramh;
  }
  
  private void a(com.ideashower.readitlater.db.operation.h paramh)
  {
    paramh.a(this, true);
    paramh.f();
  }
  
  private void a(o paramo)
  {
    Object localObject;
    boolean bool;
    if (paramo != null)
    {
      if (paramo.P() == -2)
      {
        this.a.a();
        return;
      }
      localObject = com.pocket.m.a.l.c().d(paramo.f());
      localObject = new File((String)localObject);
      if (paramo == null) {
        break label100;
      }
      bool = paramo.R();
    }
    for (;;)
    {
      if (!bool)
      {
        this.c = paramo;
        this.d = ((File)localObject);
        com.ideashower.readitlater.i.c.a(this);
        if (paramo != null)
        {
          a.a(paramo, 1, true, true, com.pocket.m.a.k.a, false);
          return;
          localObject = com.pocket.m.a.l.c().a(this.b);
          break;
          label100:
          bool = ((File)localObject).exists();
          continue;
        }
        a.a(this.b, false);
        return;
      }
    }
    this.a.a((File)localObject);
  }
  
  private void a(String paramString)
  {
    this.b = paramString;
    a(new com.ideashower.readitlater.db.operation.h(paramString));
  }
  
  public static void a(String paramString, h paramh)
  {
    new g(paramh).a(paramString);
  }
  
  public void a() {}
  
  public void a(com.ideashower.readitlater.g.k paramk, boolean paramBoolean)
  {
    a(((com.ideashower.readitlater.db.operation.h)paramk).e());
  }
  
  public boolean a(i parami, boolean paramBoolean)
  {
    if ((this.c != null) && (parami.v() != null))
    {
      if (this.c.f() == parami.v().f())
      {
        this.a.a(this.d);
        return true;
      }
    }
    else if (this.b.equals(parami.u()))
    {
      this.a.a(this.d);
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */