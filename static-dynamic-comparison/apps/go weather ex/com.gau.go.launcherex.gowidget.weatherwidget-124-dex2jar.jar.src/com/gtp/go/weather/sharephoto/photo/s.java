package com.gtp.go.weather.sharephoto.photo;

import android.widget.Toast;
import com.gau.go.launcherex.gowidget.weather.globalview.c;

class s
  implements c
{
  s(PhotoActivity paramPhotoActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Toast.makeText(this.a.getApplicationContext(), this.a.getString(2131166350), 0).show();
      PhotoActivity.a(this.a, true);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */