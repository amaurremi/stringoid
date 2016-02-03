package com.go.weatherex.b.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.text.format.Time;
import android.widget.FrameLayout;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

@SuppressLint({"ViewConstructor"})
public class c
  extends FrameLayout
{
  private Activity a;
  private AdView b;
  private LocationManager c;
  private long d;
  private e e;
  private d f;
  
  public c(Activity paramActivity)
  {
    super(paramActivity);
    this.a = paramActivity;
    this.c = ((LocationManager)paramActivity.getSystemService("location"));
  }
  
  public void a()
  {
    this.b.pause();
  }
  
  public void a(e parame)
  {
    this.e = parame;
  }
  
  public void a(String paramString)
  {
    Object localObject3 = null;
    if (this.b == null)
    {
      if (this.a.getResources().getInteger(2131296260) != 1) {
        break label292;
      }
      this.b = new AdView(this.a.getApplicationContext());
      this.b.setAdSize(AdSize.FULL_BANNER);
      this.b.setAdUnitId(paramString);
    }
    for (;;)
    {
      addView(this.b, 0);
      AdRequest.Builder localBuilder = new AdRequest.Builder();
      for (;;)
      {
        try
        {
          localObject2 = this.c.getLastKnownLocation("gps");
          localObject1 = localObject2;
          if (localObject2 != null) {
            paramString = (String)localObject2;
          }
        }
        catch (Exception paramString)
        {
          Object localObject2;
          Object localObject1;
          Time localTime;
          long l1;
          long l2;
          long l3;
          paramString = null;
          continue;
        }
        try
        {
          localTime = new Time();
          localObject1 = localObject2;
          paramString = (String)localObject2;
          if (localTime.toMillis(true) - localTime.gmtoff - ((Location)localObject2).getTime() >= 3600000L) {
            localObject1 = null;
          }
          paramString = (String)localObject1;
          if (localObject1 != null) {
            break label342;
          }
          paramString = (String)localObject1;
          localObject1 = this.c.getLastKnownLocation("network");
          paramString = (String)localObject1;
          if (localObject1 == null) {
            break label342;
          }
          paramString = (String)localObject1;
          localObject2 = new Time();
          paramString = (String)localObject1;
          l1 = ((Time)localObject2).toMillis(true);
          paramString = (String)localObject1;
          l2 = ((Time)localObject2).gmtoff;
          paramString = (String)localObject1;
          l3 = ((Location)localObject1).getTime();
          paramString = (String)localObject1;
          if (l1 - l2 - l3 < 3600000L) {
            break label342;
          }
          paramString = (String)localObject3;
        }
        catch (Exception localException)
        {
          continue;
        }
      }
      if (paramString != null) {
        localBuilder.setLocation(paramString);
      }
      this.b.setAdListener(new f(this));
      this.b.loadAd(localBuilder.build());
      this.d = System.currentTimeMillis();
      com.gtp.a.a.b.c.a("admobviewholder", "启动admob请求。");
      return;
      label292:
      this.b = new AdView(this.a.getApplicationContext());
      this.b.setAdSize(AdSize.BANNER);
      this.b.setAdUnitId(paramString);
    }
  }
  
  public void b()
  {
    this.b.resume();
  }
  
  public void c()
  {
    if (this.b != null) {
      this.b.destroy();
    }
  }
  
  public d d()
  {
    return this.f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */