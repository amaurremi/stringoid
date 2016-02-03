package com.go.weatherex.managegood.a;

import android.app.Activity;
import com.gau.go.launcherex.gowidget.a.i;
import com.getjar.sdk.GetjarConnectionResult;

class c
  implements i
{
  c(a parama) {}
  
  public void a()
  {
    a.a(this.a, "onConnected");
    com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "getjar->onConnected");
    a.a(this.a, (short)0);
    a.a(this.a, false);
    if (a.a(this.a) != null) {
      a.b(this.a, null);
    }
    if (a.b(this.a))
    {
      a.b(this.a, false);
      a.a(this.a, a.c(this.a), a.d(this.a));
    }
  }
  
  public void a(GetjarConnectionResult paramGetjarConnectionResult)
  {
    a.a(this.a, "onConnectionFailed");
    com.gtp.a.a.b.c.a("ManageGoodGetjarHelper", "getjar->onConnectionFailed");
    a.a(this.a, false);
    if (paramGetjarConnectionResult.hasResolution()) {
      a.b(this.a, paramGetjarConnectionResult.getResolutionIntent());
    }
    if (a.e(this.a) < 1)
    {
      a.f(this.a);
      return;
    }
    a.g(this.a).runOnUiThread(new d(this));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/managegood/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */