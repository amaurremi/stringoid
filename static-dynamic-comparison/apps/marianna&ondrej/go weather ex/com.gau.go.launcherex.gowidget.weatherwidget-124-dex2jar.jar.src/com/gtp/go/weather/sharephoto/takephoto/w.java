package com.gtp.go.weather.sharephoto.takephoto;

import android.widget.Toast;
import com.gau.go.launcherex.gowidget.weather.service.a.a;
import com.gau.go.launcherex.gowidget.weather.service.a.g;
import com.gtp.go.weather.sharephoto.b.e;
import com.gtp.go.weather.sharephoto.c.b;
import com.gtp.go.weather.sharephoto.c.n;
import com.jiubang.goweather.b.f;

class w
  extends g
{
  w(PublishPhotoActivity paramPublishPhotoActivity) {}
  
  public void b(a parama)
  {
    PublishPhotoActivity.a(this.a, false);
    PublishPhotoActivity.f(this.a);
    if ((parama instanceof b))
    {
      parama = (b)parama;
      if (-1L == parama.c().f())
      {
        i = parama.e().e();
        if ((i == 6) || (i == 12)) {
          Toast.makeText(this.a, this.a.getString(2131166315), 0).show();
        }
      }
    }
    while (!(parama instanceof n))
    {
      int i;
      return;
      Toast.makeText(this.a, this.a.getString(2131166313), 0).show();
      return;
      Toast.makeText(this.a, this.a.getString(2131166312), 0).show();
      PublishPhotoActivity.g(this.a);
      this.a.finish();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */