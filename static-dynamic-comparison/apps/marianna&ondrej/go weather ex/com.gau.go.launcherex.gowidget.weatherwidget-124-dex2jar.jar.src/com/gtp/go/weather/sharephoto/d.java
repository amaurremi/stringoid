package com.gtp.go.weather.sharephoto;

import android.os.AsyncTask;
import com.gtp.go.weather.sharephoto.d.h;

class d
  extends AsyncTask
{
  d(PhotoDetailActivity paramPhotoDetailActivity, String paramString1, String paramString2) {}
  
  protected Void a(Void... paramVarArgs)
  {
    PhotoDetailActivity.a(this.c, h.a(this.c, this.a));
    PhotoDetailActivity.b(this.c, h.a(this.c, this.b));
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    PhotoDetailActivity.r(this.c);
    PhotoDetailActivity.s(this.c);
    PhotoDetailActivity.t(this.c);
  }
  
  protected void onPreExecute()
  {
    PhotoDetailActivity.a(this.c, this.c.getString(2131166357), true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */