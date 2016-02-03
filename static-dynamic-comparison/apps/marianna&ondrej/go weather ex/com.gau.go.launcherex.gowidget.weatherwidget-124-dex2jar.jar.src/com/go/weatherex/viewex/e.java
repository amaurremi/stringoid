package com.go.weatherex.viewex;

import android.view.View;

public abstract class e
  implements f
{
  private c a;
  
  static
  {
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      return;
    }
  }
  
  public e(c paramc)
  {
    if ((!b) && (!(paramc instanceof View))) {
      throw new AssertionError();
    }
    this.a = paramc;
    this.a.a(this);
  }
  
  public final void b()
  {
    this.a.invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/viewex/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */