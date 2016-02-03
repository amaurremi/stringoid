package com.gtp.go.weather.sharephoto.award;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gtp.go.weather.sharephoto.b.l;
import com.gtp.go.weather.sharephoto.b.o;
import com.jiubang.goweather.b.e;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class v
  extends com.gau.go.launcherex.gowidget.weather.service.a.a
{
  private String a;
  private com.jiubang.goweather.b.f b;
  private l c;
  private Context d;
  private SharedPreferences e;
  
  public v(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
    this.b = new com.jiubang.goweather.b.f();
    this.e = GoWidgetApplication.c(this.d.getApplicationContext()).a();
  }
  
  private void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put("none");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = ((com.gtp.go.weather.sharephoto.b.d)paramList.next()).i();
      if (localObject != null)
      {
        localObject = ((com.gtp.go.weather.sharephoto.b.b)localObject).d();
        if (localObject != null)
        {
          localObject = ((com.gtp.go.weather.sharephoto.b.a)localObject).d();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localJSONArray.put(localObject);
          }
        }
      }
    }
    paramList = this.e.edit();
    paramList.putString("key_receive_apk_award_packagenames", localJSONArray.toString());
    paramList.commit();
    com.gtp.a.a.b.c.a("GetMyAwardTask", "AwardPackageNames: " + localJSONArray.toString());
  }
  
  private void b(List paramList)
  {
    com.gtp.go.weather.sharephoto.b.a.c.a(this.d, null, null);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (com.gtp.go.weather.sharephoto.b.d)paramList.next();
      com.gtp.go.weather.sharephoto.b.a.c.a(this.d, (com.gtp.go.weather.sharephoto.b.d)localObject);
      localObject = ((com.gtp.go.weather.sharephoto.b.d)localObject).i();
      if (localObject != null)
      {
        u.a(((com.gtp.go.weather.sharephoto.b.b)localObject).d());
        long l = ((com.gtp.go.weather.sharephoto.b.b)localObject).b();
        com.gtp.go.weather.sharephoto.b.a.b.a(this.d, "user_award_id=?", new String[] { String.valueOf(l) });
        com.gtp.go.weather.sharephoto.b.a.b.a(this.d, (com.gtp.go.weather.sharephoto.b.b)localObject);
        localObject = ((com.gtp.go.weather.sharephoto.b.b)localObject).d();
        if (localObject != null) {
          com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(((com.gtp.go.weather.sharephoto.b.a)localObject).c(), true, this.d);
        }
      }
    }
  }
  
  private List c()
  {
    localObject4 = null;
    Object localObject5 = null;
    this.a = com.gtp.go.weather.sharephoto.a.g.b(this.d).a();
    Object localObject3;
    if (TextUtils.isEmpty(this.a)) {
      localObject3 = localObject5;
    }
    for (;;)
    {
      return (List)localObject3;
      e locale = new e("http://gows.goforandroid.com/goweatherexSns/award/userAwardList", 15000, 15000);
      locale.a("rd", y.c());
      locale.a("POST");
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = com.gtp.go.weather.sharephoto.a.f.a(this.d);
      localObject3 = localObject5;
      if (localObject1 == null) {
        continue;
      }
      localArrayList.add(new BasicNameValuePair("phead", ((JSONObject)localObject1).toString()));
      localArrayList.add(new BasicNameValuePair("userId", this.a));
      locale.a(localArrayList);
      com.jiubang.goweather.b.c localc = com.jiubang.goweather.b.d.a(true);
      try
      {
        localObject1 = locale.i();
        localObject3 = localObject5;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        com.gtp.a.a.b.c.a("GetMyAwardTask", "completeURL: " + (String)localObject1);
        com.gtp.a.a.b.c.a("GetMyAwardTask", "postParams: " + localArrayList.toString());
        localObject1 = localc.b((String)localObject1, locale, this.b);
        this.b.b((String)localObject1);
        com.gtp.a.a.b.c.a("GetMyAwardTask", "resultText: " + (String)localObject1);
        localObject3 = localObject5;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        try
        {
          localObject3 = new JSONObject((String)localObject1);
          this.c = l.a(((JSONObject)localObject3).getJSONObject("head"));
          localObject1 = localObject4;
          if (this.c.a == 1) {
            localObject1 = com.gtp.go.weather.sharephoto.b.a.c.a(((JSONObject)localObject3).getJSONArray("userAwardList"));
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Object localObject2 = localObject4;
            if (com.gtp.a.a.b.c.a())
            {
              localJSONException.printStackTrace();
              localObject2 = localObject4;
            }
          }
        }
        localObject3 = localObject1;
        if (localObject1 == null) {
          continue;
        }
        c((List)localObject1);
        b((List)localObject1);
        return (List)localObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          if (com.gtp.a.a.b.c.a()) {
            localUnsupportedEncodingException.printStackTrace();
          }
          localObject2 = null;
        }
      }
    }
  }
  
  private void c(List paramList)
  {
    Iterator localIterator = paramList.iterator();
    label143:
    label191:
    label192:
    for (;;)
    {
      com.gtp.go.weather.sharephoto.b.d locald;
      if (localIterator.hasNext())
      {
        locald = (com.gtp.go.weather.sharephoto.b.d)localIterator.next();
        String str = locald.f();
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        paramList = com.gau.go.launcherex.gowidget.d.g.a(str);
        paramList = new File(b.b + File.separator + paramList + ".png");
        paramList = new File(com.gtp.a.a.c.c.a(), paramList.getPath());
        if (paramList.exists()) {
          break label191;
        }
        int i = 3;
        boolean bool;
        int j;
        do
        {
          bool = com.jiubang.goweather.e.a.a(paramList, str);
          j = i - 1;
          if (bool) {
            break;
          }
          i = j;
        } while (j > 0);
        if (bool) {
          com.gtp.a.a.b.c.a("GetMyAwardTask", "downloadApkAwardImage picUrl..." + str);
        }
      }
      for (;;)
      {
        if (paramList == null) {
          break label192;
        }
        locald.c(paramList.getAbsolutePath());
        break;
        paramList = null;
        break label143;
        return;
      }
    }
  }
  
  protected void a()
  {
    a(c());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */