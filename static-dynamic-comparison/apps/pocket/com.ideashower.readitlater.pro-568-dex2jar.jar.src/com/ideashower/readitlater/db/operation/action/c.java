package com.ideashower.readitlater.db.operation.action;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.a;
import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.db.operation.v;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.util.l;
import java.util.ArrayList;
import java.util.Iterator;
import org.codehaus.jackson.node.ObjectNode;

public abstract class c
{
  protected final ObjectNode a;
  protected boolean b = false;
  protected int c;
  private final boolean d;
  
  protected c(String paramString, boolean paramBoolean, UiContext paramUiContext)
  {
    a locala = g.n();
    this.a = l.b();
    this.a.put("action", paramString);
    this.a.put("cxt_online", k());
    this.a.put("cxt_orient", l());
    int i = a(locala);
    if (i != -1) {
      this.a.put("cxt_theme", i);
    }
    if (paramUiContext != null) {
      this.a.putAll(paramUiContext.a());
    }
    this.d = paramBoolean;
  }
  
  private int a(a parama)
  {
    if (parama != null) {}
    switch (parama.w())
    {
    case 3: 
    default: 
      return -1;
    case 0: 
      return 0;
    case 2: 
      return 1;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  public static void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (c)localIterator.next();
      ((c)localObject).a(null, false, true);
      boolean bool = paramBoolean;
      if (((c)localObject).m()) {
        bool = true;
      }
      paramBoolean = bool;
      if ((localObject instanceof s))
      {
        localObject = ((s)localObject).p();
        if (localObject != null)
        {
          localArrayList.add(localObject);
          paramBoolean = bool;
        }
        else
        {
          paramBoolean = true;
        }
      }
    }
    if (!localArrayList.isEmpty()) {
      com.ideashower.readitlater.i.c.a(localArrayList);
    }
    new v(paramArrayList, paramBoolean).f();
  }
  
  private static int k()
  {
    if (g.k())
    {
      if (g.l()) {
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  private int l()
  {
    return g.c().getResources().getConfiguration().orientation;
  }
  
  private boolean m()
  {
    return (this.c == 3) || (this.c == 4);
  }
  
  protected abstract int a();
  
  protected j a(j paramj, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    this.b = true;
    this.c = a();
    Object localObject = paramj;
    if (!paramBoolean2)
    {
      if (paramj != null) {
        break label74;
      }
      paramBoolean1 = bool;
      if (this.c != 3) {
        if (this.c != 4) {
          break label69;
        }
      }
    }
    label69:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      localObject = new v(this, paramBoolean1);
      ((j)localObject).f();
      return (j)localObject;
    }
    label74:
    paramj.b(this);
    return paramj;
  }
  
  public o a(boolean paramBoolean)
  {
    j localj = a(null, paramBoolean, false);
    localj.d();
    return localj.n();
  }
  
  public void a(long paramLong)
  {
    this.a.put("time", paramLong);
  }
  
  public abstract void a(j paramj);
  
  public long b()
  {
    return l.a(this.a, "sid", 0L);
  }
  
  public long b(long paramLong)
  {
    long l = d();
    if (l == 0L)
    {
      a(paramLong);
      return paramLong;
    }
    return l;
  }
  
  public void b(j paramj)
  {
    a(paramj, false, false);
  }
  
  public long c(long paramLong)
  {
    long l = b();
    if (l == 0L)
    {
      d(paramLong);
      return paramLong;
    }
    return l;
  }
  
  public String c()
  {
    return l.a(this.a, "action", null);
  }
  
  public long d()
  {
    return l.a(this.a, "time", 0L);
  }
  
  public void d(long paramLong)
  {
    this.a.put("sid", paramLong);
  }
  
  public ObjectNode e()
  {
    return this.a;
  }
  
  public String f()
  {
    h();
    return this.a.toString();
  }
  
  public boolean g()
  {
    return this.b;
  }
  
  protected void h() {}
  
  public boolean i()
  {
    return this.d;
  }
  
  public void j()
  {
    a(null, false, false);
  }
  
  public String toString()
  {
    if (this.a != null) {
      return this.a.toString();
    }
    return super.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */