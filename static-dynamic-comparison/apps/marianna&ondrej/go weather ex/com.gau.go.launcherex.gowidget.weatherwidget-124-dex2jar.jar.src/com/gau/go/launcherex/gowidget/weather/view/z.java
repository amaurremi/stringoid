package com.gau.go.launcherex.gowidget.weather.view;

import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b;
import com.gau.go.launcherex.gowidget.weather.model.RecommendedAppsBean;
import com.gau.go.launcherex.gowidget.weather.model.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

class z
  extends AsyncTask
{
  private ArrayList b = new ArrayList();
  private int c;
  
  public z(LanguageSetting paramLanguageSetting, int paramInt)
  {
    this.c = paramInt;
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    int i;
    if ((LanguageSetting.d(this.a)) || (LanguageSetting.e(this.a)))
    {
      i = 0;
      return Integer.valueOf(i);
    }
    LanguageSetting.a(this.a, true);
    ArrayList localArrayList = new ArrayList();
    paramVarArgs = new StringBuilder(b.a(this.a));
    paramVarArgs.append("#");
    localArrayList.add(new BasicNameValuePair("vps", paramVarArgs.toString()));
    localArrayList.add(new BasicNameValuePair("channel", y.f(this.a)));
    localArrayList.add(new BasicNameValuePair("lang", y.j(this.a)));
    localArrayList.add(new BasicNameValuePair("pversion", "23"));
    localArrayList.add(new BasicNameValuePair("ps", "30"));
    localArrayList.add(new BasicNameValuePair("isgmail", "-1"));
    localArrayList.add(new BasicNameValuePair("appuid", "7"));
    if (y.h(this.a)) {}
    for (paramVarArgs = "1";; paramVarArgs = "0")
    {
      localArrayList.add(new BasicNameValuePair("offical", paramVarArgs));
      localArrayList.add(new BasicNameValuePair("funid", "27"));
      localArrayList.add(new BasicNameValuePair("timestamp", "0"));
      localArrayList.add(new BasicNameValuePair("ty", "4"));
      i = LanguageSetting.a(this.a, localArrayList, this.b);
      LanguageSetting.a(this.a, false);
      break;
    }
  }
  
  protected void a(Integer paramInteger)
  {
    if (LanguageSetting.d(this.a)) {
      LanguageSetting.b(this.a, this.c);
    }
    for (;;)
    {
      LanguageSetting.b(this.a, this.c);
      return;
      if (paramInteger.intValue() == 1)
      {
        paramInteger = this.b.iterator();
        while (paramInteger.hasNext())
        {
          RecommendedAppsBean localRecommendedAppsBean = (RecommendedAppsBean)paramInteger.next();
          Iterator localIterator = LanguageSetting.a(this.a).iterator();
          while (localIterator.hasNext())
          {
            h localh = (h)localIterator.next();
            if (localh.d().equals(localRecommendedAppsBean.a()))
            {
              localh.a(localRecommendedAppsBean.g());
              localh.b(localRecommendedAppsBean.c());
              localh.e(localRecommendedAppsBean.f());
              localh.a(localRecommendedAppsBean.b());
              localh.c(localRecommendedAppsBean.d());
              localh.d(localRecommendedAppsBean.e());
            }
          }
        }
        LanguageSetting.b(this.a, true);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */