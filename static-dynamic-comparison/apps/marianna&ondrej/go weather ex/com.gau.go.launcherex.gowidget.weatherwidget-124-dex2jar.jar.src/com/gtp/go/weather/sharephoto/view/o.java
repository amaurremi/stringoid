package com.gtp.go.weather.sharephoto.view;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.gtp.go.weather.sharephoto.d.a;
import com.gtp.go.weather.sharephoto.d.l;

class o
  extends l
{
  o(UserPhotoItem paramUserPhotoItem, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if (paramBoolean)
    {
      a.a(this.a, paramBitmap);
      UserPhotoItem.a(this.b).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/view/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */