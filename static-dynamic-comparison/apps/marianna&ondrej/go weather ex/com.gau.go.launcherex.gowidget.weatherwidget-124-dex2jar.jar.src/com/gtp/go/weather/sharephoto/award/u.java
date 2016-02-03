package com.gtp.go.weather.sharephoto.award;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gtp.go.weather.sharephoto.b.l;
import com.gtp.go.weather.sharephoto.b.n;
import com.gtp.go.weather.sharephoto.b.o;
import com.jiubang.goweather.b.e;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class u
  extends com.gau.go.launcherex.gowidget.weather.service.a.a
{
  private String a;
  private com.gtp.go.weather.sharephoto.b.d b;
  private com.jiubang.goweather.b.f c;
  private l d;
  private Context e;
  
  public u(Context paramContext, com.gtp.go.weather.sharephoto.b.d paramd)
  {
    this.e = paramContext.getApplicationContext();
    this.c = new com.jiubang.goweather.b.f();
    this.b = paramd;
  }
  
  public static void a(com.gtp.go.weather.sharephoto.b.a parama)
  {
    String str;
    if (parama != null)
    {
      str = parama.a();
      if (!TextUtils.isEmpty(str)) {
        break label19;
      }
    }
    label19:
    label195:
    for (;;)
    {
      return;
      Object localObject = com.gau.go.launcherex.gowidget.d.g.a(str);
      localObject = new File(b.a + File.separator + (String)localObject + ".png");
      localObject = new File(com.gtp.a.a.c.c.a(), ((File)localObject).getPath());
      if (!((File)localObject).exists())
      {
        int i = 3;
        boolean bool;
        int j;
        do
        {
          bool = com.jiubang.goweather.e.a.a((File)localObject, str);
          j = i - 1;
          if (bool) {
            break;
          }
          i = j;
        } while (j > 0);
        if (bool) {
          com.gtp.a.a.b.c.a("GetAwardTask", "downloadApkAwardImage picUrl..." + str);
        }
      }
      for (;;)
      {
        if (localObject == null) {
          break label195;
        }
        com.gtp.a.a.b.c.a("GetAwardTask", "downloadApkAwardImage picPath..." + ((File)localObject).getAbsolutePath());
        parama.b(((File)localObject).getAbsolutePath());
        return;
        localObject = null;
        break;
      }
    }
  }
  
  private void a(List paramList)
  {
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.gtp.go.weather.sharephoto.b.b localb = (com.gtp.go.weather.sharephoto.b.b)((Iterator)localObject).next();
      localb.b(this.b.a());
      long l = localb.b();
      com.gtp.go.weather.sharephoto.b.a.b.a(this.e, "user_award_id=?", new String[] { String.valueOf(l) });
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (com.gtp.go.weather.sharephoto.b.b)paramList.next();
      ((com.gtp.go.weather.sharephoto.b.b)localObject).b(this.b.a());
      com.gtp.go.weather.sharephoto.b.a.b.a(this.e, (com.gtp.go.weather.sharephoto.b.b)localObject);
    }
  }
  
  private void b(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.gtp.go.weather.sharephoto.b.b localb = (com.gtp.go.weather.sharephoto.b.b)paramList.next();
      if (localb.c() == 1) {
        a(localb.d());
      }
    }
  }
  
  private List d()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.e.getPackageManager();
    Object localObject2 = new Intent("com.gau.go.weatherex.theme.systemwidget");
    ((Intent)localObject2).addCategory("android.intent.category.DEFAULT");
    localObject2 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 0);
    int k = ((List)localObject2).size();
    int i = 0;
    while (i < k)
    {
      localArrayList.add(((ResolveInfo)((List)localObject2).get(i)).activityInfo.packageName);
      i += 1;
    }
    localObject2 = new Intent("com.gau.go.weatherex.theme.livewallpaper");
    ((Intent)localObject2).addCategory("android.intent.category.DEFAULT");
    localObject2 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 0);
    k = ((List)localObject2).size();
    i = 0;
    while (i < k)
    {
      localArrayList.add(((ResolveInfo)((List)localObject2).get(i)).activityInfo.packageName);
      i += 1;
    }
    localObject2 = new Intent("com.gau.go.weatherex.theme.apptheme");
    ((Intent)localObject2).addCategory("android.intent.category.DEFAULT");
    localObject1 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 0);
    k = ((List)localObject1).size();
    i = j;
    while (i < k)
    {
      localArrayList.add(((ResolveInfo)((List)localObject1).get(i)).activityInfo.packageName);
      i += 1;
    }
    return localArrayList;
  }
  
  protected void a()
  {
    localObject3 = null;
    this.a = com.gtp.go.weather.sharephoto.a.g.b(this.e).a();
    if (TextUtils.isEmpty(this.a)) {}
    for (;;)
    {
      return;
      Object localObject4 = new e("http://gows.goforandroid.com/goweatherexSns/award/awardList", 15000, 15000);
      ((e)localObject4).a("rd", y.c());
      ((e)localObject4).a("POST");
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = com.gtp.go.weather.sharephoto.a.f.a(this.e);
      if (localObject1 == null) {
        continue;
      }
      localArrayList.add(new BasicNameValuePair("phead", ((JSONObject)localObject1).toString()));
      localArrayList.add(new BasicNameValuePair("userId", this.a));
      localArrayList.add(new BasicNameValuePair("userAwardId", String.valueOf(this.b.a())));
      localObject1 = new n();
      ((n)localObject1).a(d());
      ((n)localObject1).a(1);
      localArrayList.add(new BasicNameValuePair("usedAward", ((n)localObject1).a().toString()));
      ((e)localObject4).a(localArrayList);
      com.jiubang.goweather.b.c localc = com.jiubang.goweather.b.d.a(true);
      try
      {
        localObject1 = ((e)localObject4).i();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        com.gtp.a.a.b.c.a("GetAwardTask", "completeURL: " + (String)localObject1);
        com.gtp.a.a.b.c.a("GetAwardTask", "postParams: " + localArrayList.toString());
        localObject1 = localc.b((String)localObject1, (e)localObject4, this.c);
        this.c.b((String)localObject1);
        com.gtp.a.a.b.c.a("GetAwardTask", "resultText: " + (String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        try
        {
          localObject4 = new JSONObject((String)localObject1);
          this.d = l.a(((JSONObject)localObject4).getJSONObject("head"));
          localObject1 = localObject3;
          if (this.d.a == 1) {
            localObject1 = com.gtp.go.weather.sharephoto.b.a.b.a(((JSONObject)localObject4).getJSONArray("awardList"));
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Object localObject2 = localObject3;
            if (com.gtp.a.a.b.c.a())
            {
              localJSONException.printStackTrace();
              localObject2 = localObject3;
            }
          }
        }
        if (localObject1 != null)
        {
          b((List)localObject1);
          a((List)localObject1);
        }
        com.gtp.a.a.b.c.a("GetAwardTask", "task end...");
        return;
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
  
  protected boolean a(com.gau.go.launcherex.gowidget.weather.service.a.a parama)
  {
    if ((parama instanceof u))
    {
      u localu = (u)parama;
      if (this.b.a() == localu.c().a()) {
        return true;
      }
    }
    return super.a(parama);
  }
  
  public com.gtp.go.weather.sharephoto.b.d c()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */