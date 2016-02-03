package com.gtp.go.weather.sharephoto;

import android.widget.ImageView;
import com.gtp.go.weather.sharephoto.award.o;

class ac
  extends o
{
  private ac(UserPhotosActivity paramUserPhotosActivity) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramInt != 0)
    {
      UserPhotosActivity.c(this.a).setVisibility(0);
      if (paramBoolean) {
        UserPhotosActivity.c(this.a).setImageResource(2130838416);
      }
    }
    else
    {
      return;
    }
    UserPhotosActivity.c(this.a).setImageResource(2130838414);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */