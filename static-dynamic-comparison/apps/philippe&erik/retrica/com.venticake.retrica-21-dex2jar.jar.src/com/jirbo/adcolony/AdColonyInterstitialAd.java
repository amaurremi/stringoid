package com.jirbo.adcolony;

import android.graphics.Bitmap;
import java.util.ArrayList;

public class AdColonyInterstitialAd
  extends AdColonyAd
{
  AdColonyAdListener s;
  AdColonyNativeAdListener t;
  AdColonyNativeAdView u;
  
  public AdColonyInterstitialAd()
  {
    a.u = false;
    a.e();
    this.j = "interstitial";
    this.k = "fullscreen";
    this.l = ab.b();
  }
  
  public AdColonyInterstitialAd(String paramString)
  {
    this.j = "interstitial";
    this.k = "fullscreen";
    a.e();
    this.g = paramString;
    this.l = ab.b();
  }
  
  void a()
  {
    this.j = "interstitial";
    this.k = "fullscreen";
    if (this.s != null) {
      this.s.onAdColonyAdAttemptFinished(this);
    }
    for (;;)
    {
      a.h();
      System.gc();
      if ((a.u) || (AdColonyBrowser.B)) {
        break label109;
      }
      int i = 0;
      while (i < a.Z.size())
      {
        ((Bitmap)a.Z.get(i)).recycle();
        i += 1;
      }
      if (this.t != null) {
        this.t.onAdColonyNativeAdFinished(true, this.u);
      }
    }
    a.Z.clear();
    label109:
    a.I = null;
    a.v = true;
  }
  
  boolean a(boolean paramBoolean)
  {
    if (this.g == null)
    {
      this.g = a.l.e();
      if (this.g == null) {
        return false;
      }
    }
    return a.l.f(this.g);
  }
  
  boolean b()
  {
    return false;
  }
  
  public boolean isReady()
  {
    if (this.g == null)
    {
      this.g = a.l.e();
      if (this.g == null) {
        return false;
      }
    }
    if (AdColony.isZoneNative(this.g))
    {
      a.Y = 12;
      return false;
    }
    return a.l.f(this.g);
  }
  
  public void show()
  {
    a.Y = 0;
    this.j = "interstitial";
    this.k = "fullscreen";
    if (!isReady())
    {
      new j(a.l)
      {
        void a()
        {
          if (AdColonyInterstitialAd.this.g != null) {
            this.n.d.a(AdColonyInterstitialAd.this.g, AdColonyInterstitialAd.this);
          }
        }
      };
      this.f = 2;
      if (this.s != null) {
        this.s.onAdColonyAdAttemptFinished(this);
      }
      return;
    }
    if (a.v)
    {
      new j(a.l)
      {
        void a()
        {
          this.n.d.a(AdColonyInterstitialAd.this.g, AdColonyInterstitialAd.this);
        }
      };
      a.v = false;
      c();
      a.H = this;
      if (!a.l.b(this))
      {
        if (this.s != null) {
          this.s.onAdColonyAdAttemptFinished(this);
        }
        a.v = true;
        return;
      }
      if (this.s != null) {
        this.s.onAdColonyAdStarted(this);
      }
    }
    this.f = 4;
  }
  
  public AdColonyInterstitialAd withListener(AdColonyAdListener paramAdColonyAdListener)
  {
    this.s = paramAdColonyAdListener;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/AdColonyInterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */