package com.atomic.apps.ringtone.cutter;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class ah
  extends GestureDetector.SimpleOnGestureListener
{
  ah(WaveView paramWaveView) {}
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    WaveView.a(this.a).d(paramFloat1);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */