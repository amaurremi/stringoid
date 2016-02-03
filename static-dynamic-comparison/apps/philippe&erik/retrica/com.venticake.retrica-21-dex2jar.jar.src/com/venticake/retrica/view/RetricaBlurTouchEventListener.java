package com.venticake.retrica.view;

public abstract interface RetricaBlurTouchEventListener
{
  public abstract boolean blurGestureEventEnabled();
  
  public abstract void blurTouchViewTouchDown();
  
  public abstract void blurTouchViewTouchUp();
  
  public abstract void centerChanged(float paramFloat1, float paramFloat2);
  
  public abstract void gestureEventFinished();
  
  public abstract void gestureEventStarted();
  
  public abstract void radiusChanged(float paramFloat);
  
  public abstract void swipedToLeft();
  
  public abstract void swipedToRight();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/RetricaBlurTouchEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */