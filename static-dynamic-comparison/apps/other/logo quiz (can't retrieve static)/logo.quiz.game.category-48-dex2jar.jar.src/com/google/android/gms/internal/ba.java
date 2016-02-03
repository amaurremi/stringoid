package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;

@ez
public final class ba
  extends bf.a
{
  private final AppEventListener oi;
  
  public ba(AppEventListener paramAppEventListener)
  {
    this.oi = paramAppEventListener;
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    this.oi.onAppEvent(paramString1, paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */