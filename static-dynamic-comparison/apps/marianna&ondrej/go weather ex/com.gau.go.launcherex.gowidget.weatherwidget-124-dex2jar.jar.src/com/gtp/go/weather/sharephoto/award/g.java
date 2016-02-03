package com.gtp.go.weather.sharephoto.award;

import android.widget.Toast;
import com.gtp.go.weather.sharephoto.b.b;
import com.gtp.go.weather.sharephoto.b.d;

class g
  extends o
{
  g(c paramc) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (c.j(this.a) == null) {
      return;
    }
    c.k(this.a);
    if (paramBoolean)
    {
      Toast.makeText(c.l(this.a), c.a(this.a, 2131166395), 0).show();
      if ((c.e(this.a).a() == paramLong1) && (c.j(this.a).b.a() == paramLong2))
      {
        c.e(this.a).d(1);
        c.e(this.a).c(paramLong2);
        c.e(this.a).a(c.j(this.a).b);
        c.a(this.a, paramLong2);
      }
      this.a.dismiss();
      return;
    }
    Toast.makeText(c.m(this.a), c.a(this.a, 2131166396), 0).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */