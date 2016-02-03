package com.gtp.go.weather.sharephoto.photo;

import android.view.View;
import android.view.View.OnClickListener;
import com.gau.go.launcherex.gowidget.statistics.a.a;
import com.gau.go.launcherex.gowidget.statistics.r;
import com.gtp.go.weather.sharephoto.b.g;
import com.gtp.go.weather.sharephoto.c.d;
import com.gtp.go.weather.sharephoto.view.e;
import com.jiubang.pla.a.b;

class n
  implements View.OnClickListener
{
  n(PhotoActivity paramPhotoActivity, g paramg) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    if (com.gtp.go.weather.sharephoto.d.n.a(this.b.getApplicationContext()))
    {
      paramView = this.a;
      boolean bool;
      int j;
      if (!this.a.h())
      {
        bool = true;
        paramView.a(bool);
        j = this.a.c();
        if (!this.a.h()) {
          break label172;
        }
      }
      for (;;)
      {
        this.a.a(j + i);
        this.b.a.notifyDataSetChanged();
        PhotoActivity.k(this.b).a(this.a);
        paramView = new a(117);
        paramView.a(String.valueOf(this.a.a()));
        paramView.d("1");
        if (!this.a.h()) {
          break label177;
        }
        e.a(this.b, PhotoActivity.l(this.b));
        paramView.b("exellent_add");
        r.a(this.b.getApplicationContext()).a(paramView);
        return;
        bool = false;
        break;
        label172:
        i = -1;
      }
      label177:
      e.b(this.b, PhotoActivity.l(this.b));
      paramView.b("exellent_minus");
      r.a(this.b.getApplicationContext()).a(paramView);
      return;
    }
    PhotoActivity.m(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */