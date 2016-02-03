package com.go.weatherex.e;

import android.content.ContentValues;
import android.support.v4.app.FragmentActivity;
import com.gau.go.launcherex.gowidget.weather.globalview.c;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

class b
  implements c
{
  b(a parama) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d locald = new d(this.a, this.a.getActivity().getContentResolver());
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("isdeleted", Integer.valueOf(1));
      locald.startUpdate(-1, null, WeatherContentProvider.p, localContentValues, "readed=?", new String[] { "1" });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */