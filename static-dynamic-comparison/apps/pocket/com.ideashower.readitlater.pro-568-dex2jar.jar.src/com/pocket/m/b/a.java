package com.pocket.m.b;

import com.ideashower.readitlater.db.operation.h;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.g.g;
import java.io.File;
import java.util.ArrayList;

public class a
{
  private static a a;
  private final String b;
  private final int c;
  private final c d;
  private d e;
  private ArrayList f = new ArrayList();
  private boolean g = false;
  
  public a(int paramInt, c paramc)
  {
    this.d = paramc;
    this.c = paramInt;
    this.b = null;
  }
  
  public a(String paramString, c paramc)
  {
    this.d = paramc;
    this.b = paramString;
    this.c = 0;
  }
  
  private void a(o paramo)
  {
    Object localObject;
    if (paramo != null)
    {
      if (paramo.P() == -2)
      {
        this.d.b();
        d();
        return;
      }
      localObject = com.pocket.m.a.l.c().d(paramo.f());
      localObject = new File((String)localObject);
      if (paramo == null) {
        break label105;
      }
    }
    label105:
    for (boolean bool = paramo.R();; bool = ((File)localObject).exists())
    {
      this.e = new d(this, (File)localObject, paramo, null);
      if (bool) {
        break label122;
      }
      if (paramo == null) {
        break label113;
      }
      com.pocket.m.a.a(paramo, 1, true, true, com.pocket.m.a.k.a, false);
      return;
      localObject = com.pocket.m.a.l.c().a(this.b);
      break;
    }
    label113:
    com.pocket.m.a.a(this.b, false);
    return;
    label122:
    c();
  }
  
  public static void a(i parami, boolean paramBoolean)
  {
    if (a != null) {
      a.b(parami, paramBoolean);
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.d.a(paramString, this.f);
    }
    for (;;)
    {
      d();
      return;
      this.d.b();
    }
  }
  
  private void c()
  {
    if (this.e == null)
    {
      this.d.b();
      d();
      return;
    }
    b localb = new b(this, d.a(this.e), d.b(this.e), this.g, null);
    this.e = null;
    localb.h();
  }
  
  private void d()
  {
    a = null;
  }
  
  public void a()
  {
    this.g = true;
  }
  
  public void b()
  {
    a = this;
    if (this.c != 0)
    {
      final h localh = new h(this.c);
      localh.a(new com.ideashower.readitlater.g.l()
      {
        public void a() {}
        
        public void a(com.ideashower.readitlater.g.k paramAnonymousk, boolean paramAnonymousBoolean)
        {
          paramAnonymousk = localh.e();
          a.a(a.this, paramAnonymousk);
        }
      }, true);
      localh.f();
      return;
    }
    a(null);
  }
  
  public void b(i parami, boolean paramBoolean)
  {
    if (this.e == null) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while ((d.b(this.e) == null) || (d.b(this.e).f() != parami.v().f()));
      c();
      return;
    } while ((this.b == null) || (this.b != parami.u()));
    c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */