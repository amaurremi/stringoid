package com.go.weatherex.weatheralert;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.gau.go.launcherex.gowidget.weather.model.c;
import com.gau.go.launcherex.gowidget.weather.util.f;

class m
  implements View.OnClickListener
{
  m(l paraml, int paramInt, c paramc) {}
  
  public void onClick(View paramView)
  {
    if (l.a(this.c)[this.a] != 0) {
      l.a(this.c)[this.a] = 0;
    }
    for (;;)
    {
      this.c.notifyDataSetChanged();
      return;
      this.c.a(this.a);
      if (!this.b.m())
      {
        this.b.c(true);
        f.a(this.c.a.getActivity().getApplicationContext()).b(i.d(this.c.a), this.b);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/weatheralert/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */