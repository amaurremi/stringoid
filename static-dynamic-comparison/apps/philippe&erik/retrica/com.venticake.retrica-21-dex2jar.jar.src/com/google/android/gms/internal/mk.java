package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

final class mk
  extends RelativeLayout
{
  private final ep a;
  
  public mk(Context paramContext, String paramString)
  {
    super(paramContext);
    this.a = new ep(paramContext, paramString);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.c(paramMotionEvent);
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/mk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */