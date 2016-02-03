package com.gtp.go.weather.sharephoto.photo;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.gau.go.launcherex.gowidget.statistics.a.a;
import com.gtp.go.weather.coupon.view.CouponsActivity;
import com.gtp.go.weather.sharephoto.b.g;

class w
  implements View.OnClickListener
{
  w(PhotoActivity paramPhotoActivity, g paramg) {}
  
  public void onClick(View paramView)
  {
    if (!com.gau.go.launcherex.gowidget.weather.util.r.a(paramView)) {
      return;
    }
    if ((PhotoActivity.i(this.b) == 1) && (PhotoActivity.j(this.b)) && (this.a.a() == -10000L))
    {
      paramView = new Intent();
      paramView.setFlags(67108864);
      paramView.setClass(this.b, CouponsActivity.class);
      this.b.startActivity(paramView);
      return;
    }
    PhotoActivity.a(this.b, this.a.a(), 1);
    paramView = new a(117, "click_fs");
    paramView.a(String.valueOf(this.a.a()));
    paramView.d("1");
    com.gau.go.launcherex.gowidget.statistics.r.a(this.b.getApplicationContext()).a(paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */