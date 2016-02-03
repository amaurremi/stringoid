package com.gau.go.launcherex.gowidget.weather.util;

import android.content.Context;
import android.content.Intent;
import com.gtp.go.weather.sharephoto.photo.a;
import java.util.ArrayList;

class h
  implements a
{
  h(f paramf, ArrayList paramArrayList, int paramInt, String paramString) {}
  
  public void a(Integer paramInteger, Object paramObject)
  {
    paramInteger = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_CITY");
    paramInteger.putStringArrayListExtra("city_code_list", this.a);
    paramInteger.putExtra("city_index", this.b);
    paramInteger.putExtra("city_code", this.c);
    f.b(this.d).sendBroadcast(paramInteger);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */