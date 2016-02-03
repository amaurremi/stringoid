package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ViewSwitcher;

final class qk
  extends ViewSwitcher
{
  private final ep a;
  
  public qk(Context paramContext)
  {
    super(paramContext);
    this.a = new ep(paramContext);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.c(paramMotionEvent);
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/qk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */