package com.gtp.go.weather.sharephoto.award;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.service.a.a;
import com.gtp.go.weather.sharephoto.a.g;
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

public class t
  extends a
{
  private String a;
  private long b;
  private long c;
  private com.jiubang.goweather.b.f d;
  private l e;
  private boolean f = false;
  private Context g;
  
  public t(Context paramContext, long paramLong1, long paramLong2)
  {
    this.g = paramContext.getApplicationContext();
    this.d = new com.jiubang.goweather.b.f();
    this.b = paramLong1;
    this.c = paramLong2;
  }
  
  protected void a()
  {
    this.a = g.b(this.g).a();
    if (TextUtils.isEmpty(this.a)) {}
    for (;;)
    {
      return;
      e locale = new e("http://gows.goforandroid.com/goweatherexSns/award/awardReply", 15000, 15000);
      locale.a("rd", y.c());
      locale.a("POST");
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = com.gtp.go.weather.sharephoto.a.f.a(this.g);
      if (localObject1 == null) {
        continue;
      }
      localArrayList.add(new BasicNameValuePair("phead", ((JSONObject)localObject1).toString()));
      localArrayList.add(new BasicNameValuePair("userId", this.a));
      localArrayList.add(new BasicNameValuePair("userAwardId", String.valueOf(this.b)));
      localArrayList.add(new BasicNameValuePair("awardId", String.valueOf(this.c)));
      locale.a(localArrayList);
      com.jiubang.goweather.b.c localc = d.a(true);
      Object localObject2 = null;
      try
      {
        localObject1 = locale.i();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        com.gtp.a.a.b.c.a("AwardReplyTask", "completeURL: " + (String)localObject1);
        com.gtp.a.a.b.c.a("AwardReplyTask", "postParams: " + localArrayList.toString());
        localObject1 = localc.b((String)localObject1, locale, this.d);
        this.d.b((String)localObject1);
        com.gtp.a.a.b.c.a("AwardReplyTask", "resultText: " + (String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        try
        {
          do
          {
            this.e = l.a(new JSONObject((String)localObject1).getJSONObject("head"));
            if ((this.e == null) || (this.e.a != 1)) {
              break;
            }
            com.gtp.a.a.b.c.a("AwardReplyTask", "领取奖品成功!");
            localObject1 = new ContentValues();
            ((ContentValues)localObject1).put("is_receive", Integer.valueOf(1));
            ((ContentValues)localObject1).put("award_id", Long.valueOf(this.c));
            long l = this.b;
            com.gtp.go.weather.sharephoto.b.a.c.a(this.g, (ContentValues)localObject1, "user_award_id=?", new String[] { String.valueOf(l) });
            this.f = true;
            return;
            localUnsupportedEncodingException = localUnsupportedEncodingException;
            localObject1 = localObject2;
          } while (!com.gtp.a.a.b.c.a());
          localUnsupportedEncodingException.printStackTrace();
          localObject1 = localObject2;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            if (com.gtp.a.a.b.c.a()) {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public long d()
  {
    return this.b;
  }
  
  public long e()
  {
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */