package com.gtp.go.weather.sharephoto.photo;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.gtp.go.weather.sharephoto.a.f;
import com.gtp.go.weather.sharephoto.a.g;
import org.json.JSONObject;

class af
  extends AsyncTask
{
  af(ad paramad, long paramLong, a parama) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    bool2 = false;
    paramVarArgs = f.a(ad.b(this.c));
    g localg = g.a(ad.b(this.c));
    paramVarArgs = ac.a(ad.b(this.c), "http://gows.goforandroid.com/goweatherexSns/image/deleteImage", paramVarArgs.toString(), localg.d(), this.a);
    bool1 = bool2;
    if (!TextUtils.isEmpty(paramVarArgs)) {}
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs).optJSONObject("head");
        if (paramVarArgs == null) {
          continue;
        }
        int i = paramVarArgs.optInt("result", 0);
        if (i != 1) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        bool1 = bool2;
        continue;
        bool1 = false;
        continue;
      }
      return Boolean.valueOf(bool1);
      bool1 = false;
    }
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.a(Long.valueOf(this.a), paramBoolean);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */