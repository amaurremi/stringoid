package com.greystripe.sdk;

import android.webkit.JavascriptInterface;

final class bl
{
  @JavascriptInterface
  public final boolean containsKey(String paramString)
  {
    return bj.d(paramString);
  }
  
  @JavascriptInterface
  public final String get(String paramString)
  {
    return bj.c(paramString);
  }
  
  @JavascriptInterface
  public final void put(String paramString1, String paramString2)
  {
    bj.a(paramString1, paramString2);
  }
  
  @JavascriptInterface
  public final void setAdLoadTime(long paramLong)
  {
    bj.a(bk.AD_LOAD_TIME.name(), Long.toString(paramLong));
  }
  
  @JavascriptInterface
  public final void setAdReadyTime(long paramLong)
  {
    bj.a(bk.AD_READY_TIME.name(), Long.toString(paramLong));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */