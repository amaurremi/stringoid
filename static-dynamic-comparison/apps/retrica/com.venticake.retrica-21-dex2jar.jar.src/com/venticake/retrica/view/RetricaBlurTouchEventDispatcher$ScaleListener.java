package com.venticake.retrica.view;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;

class RetricaBlurTouchEventDispatcher$ScaleListener
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  private RetricaBlurTouchEventDispatcher$ScaleListener(RetricaBlurTouchEventDispatcher paramRetricaBlurTouchEventDispatcher) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    RetricaBlurTouchEventDispatcher localRetricaBlurTouchEventDispatcher = this.this$0;
    RetricaBlurTouchEventDispatcher.access$7(localRetricaBlurTouchEventDispatcher, RetricaBlurTouchEventDispatcher.access$6(localRetricaBlurTouchEventDispatcher) * paramScaleGestureDetector.getScaleFactor());
    RetricaBlurTouchEventDispatcher.access$7(this.this$0, Math.max(0.8F, Math.min(RetricaBlurTouchEventDispatcher.access$6(this.this$0), 1.8F)));
    this.this$0.setRadius(RetricaBlurTouchEventDispatcher.access$6(this.this$0) * 0.3F);
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.this$0.startEvent();
    return super.onScaleBegin(paramScaleGestureDetector);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/RetricaBlurTouchEventDispatcher$ScaleListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */