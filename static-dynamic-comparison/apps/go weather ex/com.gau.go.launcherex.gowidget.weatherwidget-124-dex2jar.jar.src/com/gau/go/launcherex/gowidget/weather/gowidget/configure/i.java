package com.gau.go.launcherex.gowidget.weather.gowidget.configure;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gau.go.launcherex.gowidget.weather.globaltheme.view.a.a;

class i
  implements View.OnClickListener
{
  i(h paramh, j paramj, e parame) {}
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.a.a))
    {
      if (!f.b(this.c.a, this.b))
      {
        paramView = String.format(f.d(this.c.a).getString(2131166534), new Object[] { f.d(this.c.a).getString(2131166507) });
        Toast.makeText(f.d(this.c.a), paramView, 0).show();
      }
    }
    else {
      return;
    }
    if (!f.c(this.c.a, this.b))
    {
      paramView = String.format(f.d(this.c.a).getString(2131166534), new Object[] { f.d(this.c.a).getString(2131166479) });
      Toast.makeText(f.d(this.c.a), paramView, 0).show();
      return;
    }
    f.e(this.c.a).a(false);
    f.e(this.c.a).a(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/gowidget/configure/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */