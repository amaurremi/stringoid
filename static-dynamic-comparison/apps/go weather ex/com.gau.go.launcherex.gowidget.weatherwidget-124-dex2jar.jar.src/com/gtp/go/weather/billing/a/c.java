package com.gtp.go.weather.billing.a;

import com.gau.go.launcherex.gowidget.a.g;
import com.gau.go.launcherex.gowidget.a.i;
import com.getjar.sdk.GetjarConnectionResult;
import com.gtp.go.weather.billing.view.PayActivity;

class c
  implements i
{
  c(a parama) {}
  
  public void a()
  {
    if (!a.a(this.a)) {
      return;
    }
    a.a(this.a, null, a.c(this.a).getString(2131166054));
    a.b(this.a).b();
    a.b(this.a).a();
  }
  
  public void a(GetjarConnectionResult paramGetjarConnectionResult)
  {
    if (!a.a(this.a)) {}
    while ((paramGetjarConnectionResult.getErrorCode() != 6) || (!paramGetjarConnectionResult.hasResolution())) {
      return;
    }
    a.d(this.a);
    a.a(this.a, paramGetjarConnectionResult.getResolutionIntent());
    a.c(this.a).startActivityForResult(a.e(this.a), 909);
    a.a(this.a, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/billing/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */