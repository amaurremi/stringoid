package com.google.ads.util;

import android.annotation.TargetApi;
import android.webkit.WebSettings;
import com.google.ads.n;

@TargetApi(17)
public final class h
{
  public static void a(WebSettings paramWebSettings, n paramn)
  {
    g.a(paramWebSettings, paramn);
    paramWebSettings.setMediaPlaybackRequiresUserGesture(false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */