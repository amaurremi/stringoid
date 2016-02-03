package com.gtp.go.weather.sharephoto;

import com.gtp.a.a.b.c;
import com.gtp.go.weather.sharephoto.b.g;
import com.gtp.go.weather.sharephoto.photo.a;

class r
  implements a
{
  r(PhotoDetailActivity paramPhotoDetailActivity) {}
  
  public void a(Long paramLong, g paramg)
  {
    if (paramg != null)
    {
      paramLong = paramg.p();
      String str1 = paramg.t();
      String str2 = paramg.x();
      PhotoDetailActivity.a(this.a, paramg.h());
      PhotoDetailActivity.a(this.a, paramg.l());
      PhotoDetailActivity.a(this.a, paramLong, str1, str2);
      return;
    }
    c.a("lishen", "找不到id为" + PhotoDetailActivity.p(this.a) + "的图片。");
    this.a.finish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */