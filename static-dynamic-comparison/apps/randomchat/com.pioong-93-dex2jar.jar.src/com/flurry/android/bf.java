package com.flurry.android;

import android.content.Context;
import android.view.ViewGroup;

abstract class bf
{
  private final String H;
  private final AdUnit M;
  
  public bf(AdUnit paramAdUnit)
  {
    this.M = paramAdUnit;
    if (paramAdUnit != null) {}
    for (paramAdUnit = paramAdUnit.getAdSpace().toString();; paramAdUnit = null)
    {
      this.H = paramAdUnit;
      return;
    }
  }
  
  public final AdUnit E()
  {
    return this.M;
  }
  
  public final String Y()
  {
    return this.H;
  }
  
  public abstract void a(Context paramContext, ViewGroup paramViewGroup);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */