package com.ideashower.readitlater.db.operation;

import com.ideashower.readitlater.e.e;
import com.ideashower.readitlater.e.r;
import com.ideashower.readitlater.g.k;
import com.ideashower.readitlater.g.l;

public class h
  extends j
{
  private final String e;
  private final int p;
  private e q;
  
  public h(int paramInt)
  {
    this.p = paramInt;
    this.e = null;
  }
  
  public h(String paramString)
  {
    this.e = paramString;
    this.p = 0;
  }
  
  private static void a(final h paramh, i parami)
  {
    paramh.a(new l()
    {
      public void a() {}
      
      public void a(k paramAnonymousk, boolean paramAnonymousBoolean)
      {
        h.this.a(paramh.e());
      }
    }, true);
    paramh.f();
  }
  
  public static void a(String paramString, i parami)
  {
    a(new h(paramString), parami);
  }
  
  protected void c_()
  {
    if (this.e != null)
    {
      this.q = r.a(this.e, this.h);
      return;
    }
    this.q = r.a(this.p, this.h);
  }
  
  public e e()
  {
    return this.q;
  }
  
  public String g()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */