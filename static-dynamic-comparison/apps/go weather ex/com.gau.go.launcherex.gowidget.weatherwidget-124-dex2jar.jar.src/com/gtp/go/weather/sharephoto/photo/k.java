package com.gtp.go.weather.sharephoto.photo;

import android.os.AsyncTask;
import android.view.View;
import com.gtp.go.weather.sharephoto.b.a.d;
import com.gtp.go.weather.sharephoto.b.e;
import com.gtp.go.weather.sharephoto.c.l;
import java.util.Iterator;
import java.util.List;

class k
  extends AsyncTask
{
  private k(i parami) {}
  
  protected List a(Void... paramVarArgs)
  {
    return d.a(i.a(this.a));
  }
  
  protected void a(List paramList)
  {
    paramList = paramList.iterator();
    e locale;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      locale = (e)paramList.next();
    } while ((locale.k()) || (l.a(Long.valueOf(locale.f()))));
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        i.b(this.a).setVisibility(0);
      }
      for (;;)
      {
        i.a(this.a, null);
        return;
        i.b(this.a).setVisibility(4);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */