package com.flurry.android.monolithic.sdk.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;

class x
  extends Dialog
{
  x(w paramw, Context paramContext, int paramInt, Activity paramActivity)
  {
    super(paramContext, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.a.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    return this.a.dispatchTrackballEvent(paramMotionEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */