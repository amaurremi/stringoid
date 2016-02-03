package com.gtp.go.weather.sharephoto.award;

import android.content.Context;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gtp.go.weather.sharephoto.b.l;
import com.gtp.go.weather.sharephoto.b.o;
import com.jiubang.goweather.b.d;
import com.jiubang.goweather.b.e;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.gau.go.launcherex.gowidget.weather.service.a.a
{
  private String a;
  private String b;
  private com.jiubang.goweather.b.f c;
  private l d;
  private boolean e = false;
  private Context f;
  
  public a(Context paramContext, String paramString)
  {
    this.f = paramContext.getApplicationContext();
    this.c = new com.jiubang.goweather.b.f();
    this.b = paramString;
  }
  
  private boolean a(String paramString)
  {
    return com.gau.go.launcherex.gowidget.weather.d.a.a(com.gau.go.launcherex.gowidget.d.g.a(this.a + "sns" + this.b).getBytes(), 0).replace("\n", "").equals(paramString);
  }
  
  protected void a()
  {
    this.a = com.gtp.go.weather.sharephoto.a.g.b(this.f).a();
    if (TextUtils.isEmpty(this.a))
    {
      this.d = new l();
      this.d.a = 1;
      this.e = false;
    }
    for (;;)
    {
      return;
      e locale = new e("http://gows.goforandroid.com/goweatherexSns/award/awardVerify", 6000, 6000);
      locale.a("rd", y.c());
      locale.a("POST");
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = com.gtp.go.weather.sharephoto.a.f.a(this.f);
      if (localObject1 == null) {
        continue;
      }
      localArrayList.add(new BasicNameValuePair("phead", ((JSONObject)localObject1).toString()));
      localArrayList.add(new BasicNameValuePair("userId", this.a));
      localArrayList.add(new BasicNameValuePair("apkName", String.valueOf(this.b)));
      locale.a(localArrayList);
      com.jiubang.goweather.b.c localc = d.a(true);
      Object localObject3 = null;
      try
      {
        localObject1 = locale.i();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        com.gtp.a.a.b.c.a("ApkAwardVerifyTask", "completeURL: " + (String)localObject1);
        com.gtp.a.a.b.c.a("ApkAwardVerifyTask", "postParams: " + localArrayList.toString());
        localObject1 = localc.b((String)localObject1, locale, this.c);
        this.c.b((String)localObject1);
        com.gtp.a.a.b.c.a("ApkAwardVerifyTask", "resultText: " + (String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          this.d = l.a(((JSONObject)localObject1).getJSONObject("head"));
          if (this.d.a != 1) {
            continue;
          }
          if (((JSONObject)localObject1).getInt("canUse") != 1) {
            break label442;
          }
          bool = true;
          this.e = bool;
          localObject1 = ((JSONObject)localObject1).getString("key");
          if ((!this.e) || (!a((String)localObject1))) {
            break label447;
          }
          bool = true;
          this.e = bool;
          com.gtp.a.a.b.c.a("ApkAwardVerifyTask", "mCanUse: " + this.e);
          return;
        }
        catch (JSONException localJSONException) {}
        if (!com.gtp.a.a.b.c.a()) {
          continue;
        }
        localJSONException.printStackTrace();
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          boolean bool;
          Object localObject2 = localObject3;
          if (com.gtp.a.a.b.c.a())
          {
            localUnsupportedEncodingException.printStackTrace();
            localObject2 = localObject3;
            continue;
            label442:
            bool = false;
            continue;
            label447:
            bool = false;
          }
        }
      }
    }
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public String d()
  {
    return this.b;
  }
  
  public int e()
  {
    if (this.d != null) {
      return this.d.a;
    }
    return -1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */