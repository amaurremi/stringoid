package com.gau.go.launcherex.gowidget.weather.b;

import android.app.Activity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import com.gtp.a.a.a.a;
import com.gtp.a.a.b.c;

class w
  extends AdListener
{
  w(u paramu) {}
  
  public void onAdClosed()
  {
    super.onAdClosed();
    this.a.d();
    u.b(this.a).finish();
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    super.onAdFailedToLoad(paramInt);
    c.a("adid", "InterstitialAdvertisementHandler: Admob - onFailedToReceiveAd");
    u.c(this.a);
  }
  
  public void onAdLoaded()
  {
    super.onAdLoaded();
    c.a("adid", "InterstitialAdvertisementHandler: Admob - onReceiveAd");
    if (u.a(this.a).isLoaded()) {
      a.a().a("Admob 请求结束，获取广告成功：" + System.currentTimeMillis(), "interstitial_log.txt");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */