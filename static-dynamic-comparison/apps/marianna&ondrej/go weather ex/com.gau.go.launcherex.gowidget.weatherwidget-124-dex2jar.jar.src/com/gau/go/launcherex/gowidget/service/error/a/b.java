package com.gau.go.launcherex.gowidget.service.error.a;

import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.service.error.model.LocationErrorBean;
import com.jiubang.goweather.b.c;
import com.jiubang.goweather.b.d;
import com.jiubang.goweather.b.e;
import com.jiubang.goweather.b.f;
import com.jiubang.goweather.b.g;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;

class b
  extends AsyncTask
{
  b(a parama) {}
  
  protected Void a(LocationErrorBean... paramVarArgs)
  {
    Object localObject = paramVarArgs[0];
    paramVarArgs = new e("http://goweatherexmg.3g.cn/goweatherexms/feedBack/gps");
    g.a(a.a(this.a), paramVarArgs);
    paramVarArgs.a("POST");
    f localf = new f();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("date", a.b(this.a)));
    localArrayList.add(new BasicNameValuePair("publishCityId", ((LocationErrorBean)localObject).a()));
    localArrayList.add(new BasicNameValuePair("publishCity", ((LocationErrorBean)localObject).b()));
    localArrayList.add(new BasicNameValuePair("publishState", ((LocationErrorBean)localObject).c()));
    localArrayList.add(new BasicNameValuePair("publishCountry", ((LocationErrorBean)localObject).d()));
    localArrayList.add(new BasicNameValuePair("latlng", ((LocationErrorBean)localObject).e() + "," + ((LocationErrorBean)localObject).f()));
    localArrayList.add(new BasicNameValuePair("feedBackCity", ((LocationErrorBean)localObject).g()));
    localArrayList.add(new BasicNameValuePair("url", ((LocationErrorBean)localObject).h()));
    paramVarArgs.a(localArrayList);
    localObject = d.a(true);
    try
    {
      ((c)localObject).b(paramVarArgs.i(), paramVarArgs, localf);
      return null;
    }
    catch (UnsupportedEncodingException paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/service/error/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */