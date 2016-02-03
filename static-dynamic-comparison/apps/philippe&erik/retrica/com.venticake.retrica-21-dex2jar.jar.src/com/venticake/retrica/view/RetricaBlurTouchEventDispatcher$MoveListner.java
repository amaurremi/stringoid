package com.venticake.retrica.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class RetricaBlurTouchEventDispatcher$MoveListner
  extends GestureDetector.SimpleOnGestureListener
{
  public RetricaBlurTouchEventDispatcher$MoveListner(RetricaBlurTouchEventDispatcher paramRetricaBlurTouchEventDispatcher) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.this$0.startEvent();
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((RetricaBlurTouchEventDispatcher.access$0(this.this$0) > 0) && (RetricaBlurTouchEventDispatcher.access$1(this.this$0) > 0)) {
      this.this$0.setCenter(RetricaBlurTouchEventDispatcher.access$4(this.this$0) - paramFloat1 / RetricaBlurTouchEventDispatcher.access$0(this.this$0), RetricaBlurTouchEventDispatcher.access$5(this.this$0) - paramFloat2 / RetricaBlurTouchEventDispatcher.access$1(this.this$0));
    }
    for (;;)
    {
      return true;
      this.this$0.setCenter(RetricaBlurTouchEventDispatcher.access$4(this.this$0) - paramFloat1 / RetricaBlurTouchEventDispatcher.access$2(this.this$0), RetricaBlurTouchEventDispatcher.access$5(this.this$0) - paramFloat2 / RetricaBlurTouchEventDispatcher.access$3(this.this$0));
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((RetricaBlurTouchEventDispatcher.access$0(this.this$0) > 0) && (RetricaBlurTouchEventDispatcher.access$1(this.this$0) > 0))
    {
      float f1 = (RetricaBlurTouchEventDispatcher.access$2(this.this$0) - RetricaBlurTouchEventDispatcher.access$0(this.this$0)) / 2.0F;
      float f2 = (RetricaBlurTouchEventDispatcher.access$3(this.this$0) - RetricaBlurTouchEventDispatcher.access$1(this.this$0)) / 2.0F;
      float f3 = paramMotionEvent.getX();
      float f4 = paramMotionEvent.getY();
      this.this$0.setCenter((f3 - f1) / RetricaBlurTouchEventDispatcher.access$0(this.this$0), (f4 - f2) / RetricaBlurTouchEventDispatcher.access$1(this.this$0), true);
      return true;
    }
    this.this$0.setCenter(paramMotionEvent.getX() / RetricaBlurTouchEventDispatcher.access$2(this.this$0), paramMotionEvent.getY() / RetricaBlurTouchEventDispatcher.access$3(this.this$0), true);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/RetricaBlurTouchEventDispatcher$MoveListner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */