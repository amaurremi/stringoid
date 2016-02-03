package com.gtp.go.weather.sharephoto.award;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.gau.go.launcherex.gowidget.weather.service.a.a;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

class m
  extends a
{
  m(k paramk, List paramList) {}
  
  protected void a()
  {
    JSONArray localJSONArray = new JSONArray();
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext()) {
      localJSONArray.put((Long)((Iterator)localObject).next());
    }
    localObject = k.c(this.b).edit();
    ((SharedPreferences.Editor)localObject).putString("key_has_read_user_award_ids", localJSONArray.toString());
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */