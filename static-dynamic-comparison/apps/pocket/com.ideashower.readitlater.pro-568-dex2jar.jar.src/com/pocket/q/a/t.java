package com.pocket.q.a;

import android.util.SparseArray;
import com.ideashower.readitlater.activity.h;
import com.ideashower.readitlater.h.d;
import com.ideashower.readitlater.util.e;

public class t
  extends q
{
  private final d f;
  private m g;
  
  private t(h paramh, String paramString, d paramd)
  {
    super(paramh, paramString, null);
    this.f = paramd;
  }
  
  public final q a(b paramb)
  {
    e.a("setOnClickListener not allowed for checkboxes, use on changed listeners instead.");
    return super.a(paramb);
  }
  
  public t a(m paramm)
  {
    this.g = paramm;
    return this;
  }
  
  public l b()
  {
    return new l(this.b, this.f, this.c, this.d, this.g, this.e);
  }
  
  public t c(com.ideashower.readitlater.h.b paramb, boolean paramBoolean)
  {
    return (t)super.a(paramb, paramBoolean);
  }
  
  public t c(String paramString)
  {
    e.a("not allowed on this pref type, use addChoice instead");
    return this;
  }
  
  public t d(String paramString)
  {
    this.d.put(this.d.size(), paramString);
    return this;
  }
  
  public t e(int paramInt)
  {
    e.a("not allowed on this pref type, use addChoice instead");
    return this;
  }
  
  public t f(int paramInt)
  {
    e.a("not allowed on this pref type, use addChoice instead");
    return this;
  }
  
  public t g(int paramInt)
  {
    return d(p.a(paramInt));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/q/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */