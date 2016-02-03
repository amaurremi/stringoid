package com.gtp.go.weather.sharephoto.takephoto;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import com.gau.go.launcherex.gowidget.weather.globalview.n;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;

class y
  implements View.OnClickListener
{
  y(x paramx, WeatherBean paramWeatherBean, z paramz) {}
  
  public void onClick(View paramView)
  {
    this.c.a.a(this.a);
    if (x.a(this.c) != null) {
      x.a(this.c).setChecked(false);
    }
    x.a(this.c, this.b.b);
    this.b.b.setChecked(true);
    PublishPhotoActivity.d(this.c.a).a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */