package com.flurry.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;

final class r
  extends Dialog
{
  r(cs paramcs, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (bn.k(this.I.dW) != null) {
      bool = bn.k(this.I.dW).dispatchTouchEvent(paramMotionEvent);
    }
    return bool;
  }
  
  public final boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (bn.k(this.I.dW) != null) {
      bool = bn.k(this.I.dW).dispatchTrackballEvent(paramMotionEvent);
    }
    return bool;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */