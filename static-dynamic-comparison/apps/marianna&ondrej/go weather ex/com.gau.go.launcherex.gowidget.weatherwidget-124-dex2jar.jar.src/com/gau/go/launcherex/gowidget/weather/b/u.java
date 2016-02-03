package com.gau.go.launcherex.gowidget.weather.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Time;
import com.gau.go.launcherex.gowidget.a.g;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.getjar.sdk.GetjarClient;
import com.getjar.sdk.OnAdAvailableListener;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;
import com.gtp.a.a.b.c;

public class u
  extends Handler
  implements OnAdAvailableListener
{
  private Activity a;
  private int b;
  private int c;
  private LocationManager d;
  private SharedPreferences e;
  private int f;
  private String g;
  private String h;
  private InterstitialAd i;
  private GetjarClient j;
  private boolean k;
  private ConnectivityManager l;
  private g m;
  
  public u(Activity paramActivity)
  {
    this.a = paramActivity;
    this.e = GoWidgetApplication.c(paramActivity.getApplicationContext()).a();
    this.b = this.e.getInt("key_adid_enter_2", 1);
    this.c = Integer.parseInt(y.f(this.a));
    this.d = ((LocationManager)paramActivity.getApplicationContext().getSystemService("location"));
    this.f = 0;
    this.g = null;
    this.h = null;
  }
  
  private void e()
  {
    Object localObject = com.gau.go.launcherex.gowidget.weather.globaltheme.a.b.a.a(this.e.getString("key_adid_location_2", ""), 1);
    c.a("adid", "InterstitialAdvertisementHandler: loadAd - adSDKList = " + (String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject != null) && (localObject.length > 0))
      {
        if ((this.f <= localObject.length) && (this.f >= 0)) {
          break label98;
        }
        this.g = "none";
      }
    }
    return;
    label98:
    CharSequence localCharSequence;
    do
    {
      do
      {
        this.f += 1;
        if (this.f >= localObject.length) {
          break;
        }
        localCharSequence = localObject[this.f];
      } while ((localCharSequence == null) || (TextUtils.isEmpty(localCharSequence)));
      c.a("adid", "InterstitialAdvertisementHandler: loadAd - adSDK = " + localCharSequence);
      if (localCharSequence.equals("admob"))
      {
        this.g = "admob";
        return;
      }
    } while (!localCharSequence.equals("getjar"));
    this.g = "getjar";
  }
  
  private void f()
  {
    if (this.i != null)
    {
      this.i.setAdListener(null);
      this.i = null;
    }
    if (Build.VERSION.SDK_INT <= 8)
    {
      h();
      return;
    }
    AdRequest.Builder localBuilder = new AdRequest.Builder();
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject4 = this.d.getLastKnownLocation("gps");
        localObject3 = localObject4;
        if (localObject4 != null) {
          localObject1 = localObject4;
        }
      }
      catch (Exception localException1)
      {
        Object localObject4;
        Object localObject3;
        Object localObject1;
        Time localTime;
        localObject2 = null;
        continue;
      }
      try
      {
        localTime = new Time();
        localObject3 = localObject4;
        localObject1 = localObject4;
        if (localTime.toMillis(true) - localTime.gmtoff - ((Location)localObject4).getTime() >= 3600000L) {
          localObject3 = null;
        }
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = localObject3;
          localObject3 = this.d.getLastKnownLocation("network");
          localObject1 = localObject3;
          if (localObject3 != null)
          {
            localObject1 = localObject3;
            localObject4 = new Time();
            localObject1 = localObject3;
            long l1 = ((Time)localObject4).toMillis(true);
            localObject1 = localObject3;
            long l2 = ((Time)localObject4).gmtoff;
            localObject1 = localObject3;
            long l3 = ((Location)localObject3).getTime();
            localObject1 = localObject3;
            if (l1 - l2 - l3 >= 3600000L) {
              localObject1 = null;
            }
          }
        }
      }
      catch (Exception localException2)
      {
        continue;
        localObject2 = null;
      }
    }
    if (localObject1 != null) {
      localBuilder.setLocation((Location)localObject1);
    }
    localObject1 = com.gau.go.launcherex.gowidget.weather.globaltheme.a.b.a.a(this.e.getString("key_adid_location_2", ""), 2);
    c.a("adid", "InterstitialAdvertisementHandler: loadAdmobInterstitialAd - adIDList = " + (String)localObject1);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((String)localObject1).split("\\|");
      if ((localObject1 != null) && (localObject1.length > 0) && (this.f < localObject1.length) && (this.f >= 0))
      {
        localObject1 = localObject1[this.f];
        if (localObject1 != null)
        {
          localObject3 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
        }
        else
        {
          localObject3 = localObject1;
          if (this.c == 200) {
            localObject3 = this.a.getString(2131165246);
          }
        }
        if ((localObject3 != null) && (!TextUtils.isEmpty((CharSequence)localObject3)))
        {
          c.a("adid", "InterstitialAdvertisementHandler: loadAdmobInterstitialAd - adID = " + (String)localObject3);
          this.h = ((String)localObject3);
          this.i = new InterstitialAd(this.a);
          this.i.setAdUnitId(this.h);
          this.i.setAdListener(new w(this));
          this.i.loadAd(localBuilder.build());
          com.gtp.a.a.a.a.a().a("Admob 请求开始：" + System.currentTimeMillis(), "interstitial_log.txt");
          return;
        }
        h();
        return;
      }
    }
  }
  
  private void g()
  {
    Object localObject2 = null;
    Object localObject3 = com.gau.go.launcherex.gowidget.weather.globaltheme.a.b.a.a(this.e.getString("key_adid_location_2", ""), 2);
    c.a("adid", "InterstitialAdvertisementHandler: prepareGetjarInterstitialAd - adIDList = " + (String)localObject3);
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = ((String)localObject3).split("\\|");
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (localObject3.length > 0)
        {
          localObject1 = localObject2;
          if (this.f < localObject3.length)
          {
            localObject1 = localObject2;
            if (this.f >= 0) {
              localObject1 = localObject3[this.f];
            }
          }
        }
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    else
    {
      localObject2 = localObject1;
      if (this.c == 200) {
        localObject2 = this.a.getString(2131165249);
      }
    }
    if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      c.a("adid", "InterstitialAdvertisementHandler: prepareGetjarInterstitialAd - adID = " + (String)localObject2);
      this.h = ((String)localObject2);
      try
      {
        if (!this.j.isAdAvailable("none"))
        {
          this.j.prepareAd("none", this);
          com.gtp.a.a.a.a.a().a("Getjar 请求开始：" + System.currentTimeMillis(), "interstitial_log.txt");
          return;
        }
        c.a("adid", "InterstitialAdvertisementHandler: prepareGetjarInterstitialAd - isAdAvailable");
        return;
      }
      catch (Exception localException)
      {
        c.a("adid", "InterstitialAdvertisementHandler: prepareGetjarInterstitialAd - Exception = " + localException.getMessage());
        return;
      }
    }
    h();
  }
  
  private void h()
  {
    this.f += 1;
    sendEmptyMessage(1);
    c.a("adid", "InterstitialAdvertisementHandler: alterInterstitialAd - adIndex = " + this.f);
  }
  
  private void i()
  {
    c.a("adid", "InterstitialAdvertisementHandler: saveCount - mCount = " + this.b);
    this.e.edit().putInt("key_adid_enter_2", this.b).commit();
  }
  
  public void a()
  {
    int i2 = 3;
    c.a("adid", "InterstitialAdvertisementHandler: loadAd - checkNeedtoShowAd");
    Object localObject = GoWidgetApplication.b(this.a.getApplicationContext());
    int i1;
    if ((((f)localObject).a(2)) || (((f)localObject).a(1)) || (((f)localObject).a(32)) || (((f)localObject).a(128)))
    {
      i1 = 1;
      localObject = this.e.getString("key_adid_location_2", "");
      String str = com.gau.go.launcherex.gowidget.weather.globaltheme.a.b.a.a((String)localObject, 3);
      if ((!TextUtils.isEmpty(str)) && (str.equals("1"))) {
        if (i1 == 0)
        {
          this.m = g.a(this.a);
          this.j = this.m.c();
        }
      }
    }
    for (;;)
    {
      try
      {
        n = Integer.valueOf(com.gau.go.launcherex.gowidget.weather.globaltheme.a.b.a.a((String)localObject, 4)).intValue();
        if (n == 0)
        {
          n = i2;
          if ((this.b % n == 0) && (i1 == 0))
          {
            this.l = ((ConnectivityManager)this.a.getApplicationContext().getSystemService("connectivity"));
            if (this.l.getActiveNetworkInfo() != null) {
              this.k = true;
            }
            return;
            i1 = 0;
          }
        }
      }
      catch (Exception localException)
      {
        int n = 3;
        continue;
        this.b += 1;
        i();
        return;
      }
    }
  }
  
  public void b()
  {
    if (this.k)
    {
      c.a("adid", "InterstitialAdvertisementHandler: tryLoadAd : " + this.k);
      e();
      if ((this.g == null) || (this.g != "getjar")) {
        break label89;
      }
      if ((this.j == null) || (this.j.getCurrentAccount() == null)) {
        break label82;
      }
      g();
    }
    for (;;)
    {
      this.k = false;
      return;
      label82:
      h();
      continue;
      label89:
      if ((this.g != null) && (this.g == "admob"))
      {
        NetworkInfo localNetworkInfo = this.l.getActiveNetworkInfo();
        if (localNetworkInfo != null)
        {
          int n = localNetworkInfo.getType();
          if ((n == 1) || (n == 6) || (n == 4) || (n == 5) || (n == 9)) {
            sendEmptyMessageDelayed(0, 500L);
          } else {
            sendEmptyMessageDelayed(0, 3000L);
          }
        }
      }
    }
  }
  
  public int c()
  {
    int i2 = 0;
    int i3 = 1;
    Object localObject = GoWidgetApplication.b(this.a.getApplicationContext());
    int i1;
    int n;
    if ((((f)localObject).a(2)) || (((f)localObject).a(1)) || (((f)localObject).a(32)) || (((f)localObject).a(128)))
    {
      i1 = 1;
      n = i2;
      if (i1 == 0)
      {
        n = i2;
        if (this.g != null)
        {
          if (!this.g.equals("admob")) {
            break label169;
          }
          n = i2;
          if (this.i != null)
          {
            n = i2;
            if (this.i.isLoaded())
            {
              this.i.show();
              this.b += 1;
              i();
              c.a("adid", "InterstitialAdvertisementHandler: Admob - showAd");
              n = 1;
            }
          }
        }
      }
    }
    label169:
    do
    {
      c.a("adid", "InterstitialAdvertisementHandler: showAd - isShow = " + n);
      return n;
      i1 = 0;
      break;
      n = i2;
    } while (!this.g.equals("getjar"));
    for (;;)
    {
      try
      {
        if ((!this.j.isConnected()) || (!this.j.isAdAvailable("none"))) {
          break label277;
        }
        localObject = this.j.getInterstitialIntent("placement_tag_show_getjar_on_exit", "none");
        this.a.startActivity((Intent)localObject);
        this.a.finish();
      }
      catch (Exception localException1)
      {
        try
        {
          this.b += 1;
          i();
          c.a("adid", "InterstitialAdvertisementHandler: Getjar - showAd");
          n = i3;
        }
        catch (Exception localException2)
        {
          n = 1;
        }
        localException1 = localException1;
        n = i2;
      }
      break;
      break;
      label277:
      n = 0;
    }
  }
  
  public void d()
  {
    if (this.i != null)
    {
      this.i.setAdListener(null);
      this.i = null;
    }
    if (this.m != null) {
      this.m = null;
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 0) {
      f();
    }
    while (paramMessage.what != 1) {
      return;
    }
    this.k = true;
    b();
  }
  
  public void onAdAvailable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c.a("adid", "InterstitialAdvertisementHandler: Getjar - onAdAvailable = true");
      com.gtp.a.a.a.a.a().a("Getjar 请求结束，获取广告成功：" + System.currentTimeMillis(), "interstitial_log.txt");
      this.a.runOnUiThread(new v(this));
      return;
    }
    c.a("adid", "InterstitialAdvertisementHandler: Getjar - onAdAvailable = false");
    h();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */