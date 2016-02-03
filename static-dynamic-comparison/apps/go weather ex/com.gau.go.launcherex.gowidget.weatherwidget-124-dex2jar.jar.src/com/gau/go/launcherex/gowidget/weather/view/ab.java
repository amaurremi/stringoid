package com.gau.go.launcherex.gowidget.weather.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.gau.go.launcherex.gowidget.weather.util.r;

class ab
  implements View.OnClickListener
{
  ab(aa paramaa, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (r.c(this.b.a))
    {
      LanguageSetting.a(this.b.a, 2131166213);
      new z(this.b.a, this.a).execute(new Void[0]);
      return;
    }
    LanguageSetting.a(this.b.a, 2131166304);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */