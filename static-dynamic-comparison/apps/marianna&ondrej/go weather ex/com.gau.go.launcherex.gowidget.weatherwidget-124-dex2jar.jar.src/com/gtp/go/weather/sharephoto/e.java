package com.gtp.go.weather.sharephoto;

import android.widget.CheckBox;
import com.gau.go.launcherex.gowidget.statistics.a.a;
import com.gau.go.launcherex.gowidget.statistics.r;

class e
  implements Runnable
{
  e(PhotoDetailActivity paramPhotoDetailActivity) {}
  
  public void run()
  {
    if (PhotoDetailActivity.a(this.a) == 1) {
      PhotoDetailActivity.d(this.a, true);
    }
    while (!PhotoDetailActivity.u(this.a)) {
      return;
    }
    a locala = new a(117);
    locala.a(String.valueOf(PhotoDetailActivity.p(this.a)));
    if (PhotoDetailActivity.v(this.a).isChecked())
    {
      locala.b("preview");
      r.a(this.a.getApplicationContext()).a(locala);
    }
    locala.b("fs_set_background");
    r.a(this.a.getApplicationContext()).a(locala);
    PhotoDetailActivity.w(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */