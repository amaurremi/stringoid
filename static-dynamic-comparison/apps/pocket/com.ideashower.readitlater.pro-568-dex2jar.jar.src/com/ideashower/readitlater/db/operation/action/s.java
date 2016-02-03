package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.db.operation.v;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.l;
import org.codehaus.jackson.node.ObjectNode;

public abstract class s
  extends c
{
  protected o d;
  private final boolean e;
  
  protected s(String paramString, o paramo, boolean paramBoolean1, boolean paramBoolean2, UiContext paramUiContext)
  {
    super(paramString, paramBoolean1, paramUiContext);
    this.d = paramo;
    if (paramo.h()) {
      this.a.put("unique_id", paramo.f());
    }
    this.a.put("item_id", paramo.c());
    this.a.put("url", paramo.k());
    this.e = paramBoolean2;
  }
  
  protected s(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, UiContext paramUiContext)
  {
    super(paramString1, paramBoolean1, paramUiContext);
    this.a.put("url", paramString2);
    this.e = paramBoolean2;
  }
  
  private ObjectNode k()
  {
    ObjectNode localObjectNode = l.b();
    localObjectNode.putAll(this.a);
    localObjectNode.remove("sid");
    localObjectNode.remove("action");
    return localObjectNode;
  }
  
  protected abstract int a();
  
  protected j a(j paramj, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = true;
    int j = a();
    int i = j;
    Object localObject;
    boolean bool;
    if (j < 4)
    {
      if ((this.d != null) && (this.d.c() != 0)) {
        i = 4;
      }
    }
    else
    {
      this.c = i;
      localObject = paramj;
      if (!paramBoolean2)
      {
        if (paramj != null) {
          break label160;
        }
        if ((this.c != 3) && (this.c != 4)) {
          break label154;
        }
        bool = true;
        label77:
        localObject = new v(this, bool);
        if (paramBoolean1) {
          ((j)localObject).c(l());
        }
        ((j)localObject).f();
      }
    }
    for (;;)
    {
      if ((!paramBoolean2) && ((this.c == 2) || (this.c == 4))) {
        com.ideashower.readitlater.i.c.a(this.d);
      }
      return (j)localObject;
      i = j;
      if (j != 2) {
        break;
      }
      i = 4;
      break;
      label154:
      bool = false;
      break label77;
      label160:
      if (paramBoolean1) {
        paramj.c(l());
      }
      paramj.b(this);
      localObject = paramj;
    }
  }
  
  public void a(int paramInt)
  {
    this.a.put("item_id", paramInt);
  }
  
  public void b(String paramString)
  {
    this.a.put("url", paramString);
  }
  
  protected int c(j paramj)
  {
    int j = n();
    int i = j;
    if (j == 0)
    {
      paramj = paramj.e(l());
      i = j;
      if (paramj != null) {
        i = paramj.f();
      }
    }
    return i;
  }
  
  public String l()
  {
    return l.a(this.a, "url", null);
  }
  
  public int m()
  {
    return l.a(this.a, "item_id", 0);
  }
  
  public int n()
  {
    return l.a(this.a, "unique_id", 0);
  }
  
  protected o o()
  {
    if (this.d != null) {
      return this.d;
    }
    try
    {
      o localo = com.ideashower.readitlater.e.s.a(k(), null);
      return localo;
    }
    catch (Throwable localThrowable)
    {
      e.a(localThrowable);
    }
    return null;
  }
  
  public o p()
  {
    return this.d;
  }
  
  public boolean q()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */