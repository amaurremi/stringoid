package com.pocket.q.a;

import android.util.SparseArray;
import com.ideashower.readitlater.util.e;

public class r
  extends q
{
  private final com.ideashower.readitlater.h.b f;
  private h g;
  
  private r(com.ideashower.readitlater.activity.h paramh, String paramString, com.ideashower.readitlater.h.b paramb)
  {
    super(paramh, paramString, null);
    this.f = paramb;
  }
  
  public final q a(b paramb)
  {
    e.a("setOnClickListener not allowed for checkboxes, use on changed listeners instead.");
    return super.a(paramb);
  }
  
  public r a(h paramh)
  {
    this.g = paramh;
    return this;
  }
  
  public g b()
  {
    com.ideashower.readitlater.activity.h localh = this.b;
    com.ideashower.readitlater.h.b localb = this.f;
    String str = this.c;
    if (this.d.size() > 0) {}
    for (SparseArray localSparseArray = this.d;; localSparseArray = null) {
      return new g(localh, localb, str, localSparseArray, this.g, this.e);
    }
  }
  
  public r c(com.ideashower.readitlater.h.b paramb, boolean paramBoolean)
  {
    return (r)super.a(paramb, paramBoolean);
  }
  
  public r c(String paramString)
  {
    return (r)super.a(paramString);
  }
  
  public r d(String paramString)
  {
    this.d.put(a.c, paramString);
    return this;
  }
  
  public r e(int paramInt)
  {
    return (r)super.a(paramInt);
  }
  
  public r f(int paramInt)
  {
    return (r)super.b(paramInt);
  }
  
  public r g(int paramInt)
  {
    return d(p.a(paramInt));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/q/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */