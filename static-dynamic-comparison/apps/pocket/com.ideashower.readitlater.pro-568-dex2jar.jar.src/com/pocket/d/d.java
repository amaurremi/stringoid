package com.pocket.d;

import android.content.Context;
import com.pocket.oauth.k;
import com.pocket.oauth.n;

public abstract class d
  extends e
  implements n
{
  protected final k i;
  
  public d(Context paramContext, b paramb, k paramk)
  {
    super(paramContext, paramb);
    this.i = paramk;
    paramk.a(this);
  }
  
  public void a(k paramk, boolean paramBoolean)
  {
    if (paramBoolean) {
      f();
    }
    g();
  }
  
  protected void e()
  {
    if (this.i.a()) {
      return;
    }
    this.i.b();
  }
  
  public void f()
  {
    if (!this.i.a()) {
      return;
    }
    super.f();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */