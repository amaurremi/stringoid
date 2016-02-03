package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ViewSwitcher;

final class dy
  extends ViewSwitcher
{
  private final bQ a;
  
  public dy(Context paramContext)
  {
    super(paramContext);
    this.a = new bQ(paramContext);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.a(paramMotionEvent);
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */