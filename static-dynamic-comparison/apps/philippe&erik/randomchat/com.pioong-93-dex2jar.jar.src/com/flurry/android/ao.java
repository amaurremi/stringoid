package com.flurry.android;

import android.content.Context;

abstract class ao
{
  static final String d = ao.class.getSimpleName();
  private final Context J;
  private final FlurryAds K;
  private final cz L;
  private final AdUnit M;
  
  public ao(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit)
  {
    this.J = paramContext;
    this.K = paramFlurryAds;
    this.L = paramcz;
    this.M = paramAdUnit;
  }
  
  public final FlurryAds C()
  {
    return this.K;
  }
  
  public final cz D()
  {
    return this.L;
  }
  
  public final AdUnit E()
  {
    return this.M;
  }
  
  public abstract void f();
  
  public final Context getContext()
  {
    return this.J;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */