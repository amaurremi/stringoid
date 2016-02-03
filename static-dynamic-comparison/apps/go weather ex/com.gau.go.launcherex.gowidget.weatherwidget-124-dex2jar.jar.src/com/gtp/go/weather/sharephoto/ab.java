package com.gtp.go.weather.sharephoto;

import android.view.View;
import android.widget.Toast;
import com.gtp.go.weather.sharephoto.photo.a;
import com.gtp.go.weather.sharephoto.photo.ad;
import com.gtp.go.weather.sharephoto.view.UserPhotoItem;
import com.gtp.go.weather.sharephoto.view.g;

class ab
  implements a
{
  ab(UserPhotosActivity paramUserPhotosActivity, long paramLong, View paramView, UserPhotoItem paramUserPhotoItem) {}
  
  public void a(Long paramLong, Boolean paramBoolean)
  {
    UserPhotosActivity.d(this.d);
    if (paramBoolean.booleanValue())
    {
      UserPhotosActivity.e(this.d).a(this.a, this.b, this.c);
      UserPhotosActivity.f(this.d).a(this.d, this.a);
      return;
    }
    Toast.makeText(this.d.getApplicationContext(), 2131166391, 0).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */