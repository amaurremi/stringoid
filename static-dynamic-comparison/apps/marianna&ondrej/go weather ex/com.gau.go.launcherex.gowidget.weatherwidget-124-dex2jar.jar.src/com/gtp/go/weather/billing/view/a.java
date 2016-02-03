package com.gtp.go.weather.billing.view;

import android.widget.Toast;
import com.gtp.go.weather.sharephoto.award.k;
import com.gtp.go.weather.sharephoto.award.o;

class a
  extends o
{
  a(PayActivity paramPayActivity, k paramk) {}
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    if (PayActivity.a(this.b).equals(paramString))
    {
      if (paramInt != 1) {
        break label74;
      }
      if (!paramBoolean) {
        break label57;
      }
      com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(PayActivity.a(this.b), true, this.b.getApplicationContext());
      this.b.b();
    }
    for (;;)
    {
      this.a.a();
      return;
      label57:
      PayActivity.b(this.b);
      PayActivity.c(this.b);
      continue;
      label74:
      Toast.makeText(this.b.getApplicationContext(), this.b.getString(2131166398), 0).show();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/billing/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */