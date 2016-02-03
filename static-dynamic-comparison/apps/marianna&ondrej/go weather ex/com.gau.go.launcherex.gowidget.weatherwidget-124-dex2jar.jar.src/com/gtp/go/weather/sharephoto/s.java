package com.gtp.go.weather.sharephoto;

import android.graphics.Bitmap;
import com.gtp.go.weather.sharephoto.d.k;

class s
  implements k
{
  s(PhotoDetailActivity paramPhotoDetailActivity) {}
  
  public void a()
  {
    PhotoDetailActivity.a(this.a, this.a.getString(2131166357), true);
  }
  
  public void a(int paramInt)
  {
    PhotoDetailActivity.a(this.a, this.a.getString(2131166358, new Object[] { Integer.valueOf(paramInt) }), false);
  }
  
  public void a(boolean paramBoolean, String paramString1, Bitmap paramBitmap, String paramString2)
  {
    PhotoDetailActivity.a(this.a, paramBitmap);
    PhotoDetailActivity.b(this.a, true);
    PhotoDetailActivity.q(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */