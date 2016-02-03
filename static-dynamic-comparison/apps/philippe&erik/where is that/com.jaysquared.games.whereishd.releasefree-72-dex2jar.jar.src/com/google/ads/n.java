package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.google.ads.internal.ActivationOverlay;
import com.google.ads.internal.d;
import com.google.ads.internal.h;
import com.google.ads.util.i;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;
import com.google.ads.util.i.d;

public class n
  extends i
{
  public final i.b<Ad> a;
  public final i.b<d> b;
  public final i.d<Activity> c;
  public final i.b<m> d;
  public final i.b<ActivationOverlay> e;
  public final i.b<Context> f;
  public final i.b<h> g;
  public final i.b<String> h;
  public final i.b<ViewGroup> i;
  public final i.b<AdView> j;
  public final i.b<InterstitialAd> k;
  public final i.c<l> l = new i.c(this, "currentAd", null);
  public final i.c<l> m = new i.c(this, "nextAd", null);
  public final i.c<AdSize[]> n;
  public final i.c<AdListener> o = new i.c(this, "adListener");
  public final i.c<AppEventListener> p = new i.c(this, "appEventListener");
  public final i.c<SwipeableAdListener> q = new i.c(this, "swipeableEventListener");
  public final i.c<ak> r = new i.c(this, "spamSignals", null);
  public final i.c<al> s = new i.c(this, "spamSignalsUtil", null);
  public final i.c<Boolean> t = new i.c(this, "usesManualImpressions", Boolean.valueOf(false));
  
  public n(m paramm, Ad paramAd, AdView paramAdView, InterstitialAd paramInterstitialAd, String paramString, Activity paramActivity, Context paramContext, ViewGroup paramViewGroup, h paramh, d paramd)
  {
    this.d = new i.b(this, "appState", paramm);
    this.a = new i.b(this, "ad", paramAd);
    this.j = new i.b(this, "adView", paramAdView);
    this.g = new i.b(this, "adType", paramh);
    this.h = new i.b(this, "adUnitId", paramString);
    this.c = new i.d(this, "activity", paramActivity);
    this.k = new i.b(this, "interstitialAd", paramInterstitialAd);
    this.i = new i.b(this, "bannerContainer", paramViewGroup);
    this.f = new i.b(this, "applicationContext", paramContext);
    this.n = new i.c(this, "adSizes", null);
    this.b = new i.b(this, "adManager", paramd);
    paramm = (m)localObject;
    if (paramh != null)
    {
      paramm = (m)localObject;
      if (paramh.b()) {
        paramm = new ActivationOverlay(this);
      }
    }
    this.e = new i.b(this, "activationOverlay", paramm);
  }
  
  public boolean a()
  {
    return !b();
  }
  
  public boolean b()
  {
    return ((h)this.g.a()).a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/ads/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */