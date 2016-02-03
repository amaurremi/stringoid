package com.gtp.go.weather.sharephoto.photo;

import android.view.View;
import android.view.View.OnClickListener;
import com.gau.go.launcherex.gowidget.statistics.a.a;
import com.gau.go.launcherex.gowidget.statistics.r;
import com.gtp.go.weather.sharephoto.b.g;

class y
  implements View.OnClickListener
{
  y(PhotoActivity paramPhotoActivity, g paramg) {}
  
  public void onClick(View paramView)
  {
    paramView = new a(117, "fs_set_background");
    paramView.a(String.valueOf(this.a.a()));
    PhotoActivity.a(this.b, this.a.a(), 2);
    r.a(this.b.getApplicationContext()).a(paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */