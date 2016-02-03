package com.go.weatherex.f;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.weather.util.f;
import java.util.Map;

class u
  implements Runnable
{
  u(t paramt, Object paramObject) {}
  
  public void run()
  {
    com.gau.go.launcherex.gowidget.weather.model.b localb = (com.gau.go.launcherex.gowidget.weather.model.b)this.a;
    Toast.makeText(t.c(this.b), t.c(this.b).getString(2131165764, new Object[] { localb.b() }), 0).show();
    Context localContext = t.d(this.b);
    f localf = f.a(localContext);
    localf.a(localb, localf.c().size(), 0);
    com.gau.go.launcherex.gowidget.gcm.b.a(localContext).b(localb.a());
    t.a(this.b, localb);
    t.a(this.b, false);
    t.a(this.b, localb.a());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */