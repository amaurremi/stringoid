package com.gtp.go.weather.sharephoto.award;

import com.gau.go.launcherex.gowidget.weather.globalview.g;
import com.gau.go.launcherex.gowidget.weather.globalview.h;
import com.gtp.go.weather.sharephoto.b.a;

class x
  implements h
{
  x(MyAwardsActivity paramMyAwardsActivity, boolean paramBoolean, a parama, long paramLong) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.a) {
        break label36;
      }
      MyAwardsActivity.a(this.d, this.b.c());
    }
    for (;;)
    {
      MyAwardsActivity.c(this.d).dismiss();
      return;
      label36:
      MyAwardsActivity.a(this.d, this.c, this.b);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */