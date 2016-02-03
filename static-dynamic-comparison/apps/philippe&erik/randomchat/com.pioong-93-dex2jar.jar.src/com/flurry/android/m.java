package com.flurry.android;

import android.content.Context;
import java.util.Map;

abstract class m
  extends ao
{
  private static final String d = m.class.getSimpleName();
  
  public m(Context paramContext, FlurryAds paramFlurryAds, cz paramcz, AdUnit paramAdUnit)
  {
    super(paramContext, paramFlurryAds, paramcz, paramAdUnit);
  }
  
  private void a(String paramString, Map<String, String> paramMap)
  {
    new StringBuilder().append("onEvent: ").append(paramString).toString();
    C().a(D(), paramString, true, paramMap);
    if (E() != null) {
      C().onEvent(new cw(paramString, paramMap, getContext(), E(), D(), 0), C(), 0);
    }
  }
  
  public final void onAdClicked(Map<String, String> paramMap)
  {
    a("clicked", paramMap);
  }
  
  public final void onAdClosed(Map<String, String> paramMap)
  {
    a("adClosed", paramMap);
  }
  
  public final void onAdFilled(Map<String, String> paramMap)
  {
    a("filled", paramMap);
  }
  
  public final void onAdShown(Map<String, String> paramMap)
  {
    a("rendered", paramMap);
  }
  
  public final void onRenderFailed(Map<String, String> paramMap)
  {
    a("renderFailed", paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */