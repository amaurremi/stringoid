package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;

public final class es
{
  public static void a(Context paramContext, WebSettings paramWebSettings)
  {
    er.a(paramContext, paramWebSettings);
    paramWebSettings.setMediaPlaybackRequiresUserGesture(false);
  }
  
  public static String getDefaultUserAgent(Context paramContext)
  {
    return WebSettings.getDefaultUserAgent(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/es.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */