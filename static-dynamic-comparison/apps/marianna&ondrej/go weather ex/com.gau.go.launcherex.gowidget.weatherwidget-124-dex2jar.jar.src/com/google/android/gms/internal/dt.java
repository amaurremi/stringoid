package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;

public final class dt
{
  public static void a(Context paramContext, WebSettings paramWebSettings)
  {
    ds.a(paramContext, paramWebSettings);
    paramWebSettings.setMediaPlaybackRequiresUserGesture(false);
  }
  
  public static String getDefaultUserAgent(Context paramContext)
  {
    return WebSettings.getDefaultUserAgent(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */