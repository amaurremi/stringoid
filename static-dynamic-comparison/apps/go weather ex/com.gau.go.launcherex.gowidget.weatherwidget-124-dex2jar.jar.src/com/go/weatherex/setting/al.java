package com.go.weatherex.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.gau.go.launcherex.gowidget.weather.util.r;

class al
  implements View.OnClickListener
{
  al(ak paramak, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (r.c(this.b.a.getActivity()))
    {
      ag.a(this.b.a, 2131166213);
      new aj(this.b.a, this.a).execute(new Void[0]);
      return;
    }
    ag.a(this.b.a, 2131166304);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */