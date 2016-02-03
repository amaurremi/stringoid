package com.gtp.go.weather.sharephoto.award;

import android.content.Context;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.service.a.a;
import com.gtp.go.weather.sharephoto.a.g;
import com.gtp.go.weather.sharephoto.b.k;
import com.gtp.go.weather.sharephoto.b.l;
import com.gtp.go.weather.sharephoto.b.o;
import com.jiubang.goweather.b.d;
import com.jiubang.goweather.b.e;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class w
  extends a
{
  private com.jiubang.goweather.b.f a;
  private l b;
  private Context c;
  
  public w(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.a = new com.jiubang.goweather.b.f();
  }
  
  protected void a()
  {
    Object localObject1 = g.b(this.c).a();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      return;
      Object localObject4 = new e("http://gows.goforandroid.com/goweatherexSns/prompt/promptList");
      ((e)localObject4).a("rd", y.c());
      ((e)localObject4).a("POST");
      Object localObject5 = new ArrayList();
      Object localObject6 = com.gtp.go.weather.sharephoto.a.f.a(this.c);
      if (localObject6 == null) {
        continue;
      }
      ((List)localObject5).add(new BasicNameValuePair("phead", ((JSONObject)localObject6).toString()));
      ((List)localObject5).add(new BasicNameValuePair("userId", (String)localObject1));
      ((e)localObject4).a((List)localObject5);
      localObject6 = d.a(true);
      try
      {
        localObject1 = ((e)localObject4).i();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        com.gtp.a.a.b.c.a("GetPromptTask", "completeURL: " + (String)localObject1);
        com.gtp.a.a.b.c.a("GetPromptTask", "postParams: " + localObject5.toString());
        localObject1 = ((com.jiubang.goweather.b.c)localObject6).b((String)localObject1, (e)localObject4, this.a);
        this.a.b((String)localObject1);
        com.gtp.a.a.b.c.a("GetPromptTask", "resultText: " + (String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          this.b = l.a(((JSONObject)localObject1).getJSONObject("head"));
          if (this.b.a == 1)
          {
            localObject1 = k.a(((JSONObject)localObject1).getJSONArray("prompts"));
            if (localObject1 == null) {
              continue;
            }
            localObject4 = k.a(this.c, null, null, null);
            k.a(this.c, null, null);
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject5 = (k)((Iterator)localObject1).next();
              localObject6 = ((List)localObject4).iterator();
              while (((Iterator)localObject6).hasNext())
              {
                k localk = (k)((Iterator)localObject6).next();
                if (localk.b() == ((k)localObject5).b()) {
                  ((k)localObject5).a(localk.a());
                }
              }
              k.a(this.c, (k)localObject5);
            }
            localUnsupportedEncodingException = localUnsupportedEncodingException;
            if (com.gtp.a.a.b.c.a()) {
              localUnsupportedEncodingException.printStackTrace();
            }
            Object localObject2 = null;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            if (com.gtp.a.a.b.c.a()) {
              localJSONException.printStackTrace();
            }
            Object localObject3 = null;
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */