package com.go.weatherex.weatheralert;

import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.model.c;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

class e
  implements Comparator
{
  e(d paramd, SimpleDateFormat paramSimpleDateFormat) {}
  
  public int a(c paramc1, c paramc2)
  {
    paramc1 = paramc1.c();
    paramc2 = paramc2.c();
    if ((!TextUtils.isEmpty(paramc1)) && (!TextUtils.isEmpty(paramc2))) {
      try
      {
        int i = this.a.parse(paramc1).compareTo(this.a.parse(paramc2));
        return -i;
      }
      catch (ParseException paramc1)
      {
        paramc1.printStackTrace();
      }
    }
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/weatheralert/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */