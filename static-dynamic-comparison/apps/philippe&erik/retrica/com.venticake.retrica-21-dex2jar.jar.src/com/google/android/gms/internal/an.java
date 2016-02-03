package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;

public final class an
  extends as.a
{
  private final AppEventListener mh;
  
  public an(AppEventListener paramAppEventListener)
  {
    this.mh = paramAppEventListener;
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    this.mh.onAppEvent(paramString1, paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */