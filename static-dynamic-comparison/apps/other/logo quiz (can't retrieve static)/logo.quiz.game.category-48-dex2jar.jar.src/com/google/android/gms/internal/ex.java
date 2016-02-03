package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.doubleclick.c;

@ez
public final class ex
  extends eu.a
{
  private final PublisherInterstitialAd oF;
  private final c oG;
  
  public ex(c paramc, PublisherInterstitialAd paramPublisherInterstitialAd)
  {
    this.oG = paramc;
    this.oF = paramPublisherInterstitialAd;
  }
  
  public void a(es parames)
  {
    this.oG.a(this.oF, new ev(parames));
  }
  
  public boolean e(String paramString1, String paramString2)
  {
    return this.oG.a(this.oF, paramString1, paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */