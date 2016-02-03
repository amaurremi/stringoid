package com.mopub.mobileads;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class ViewGestureDetector
  extends GestureDetector
{
  private AdAlertGestureListener mAdAlertGestureListener;
  private UserClickListener mUserClickListener;
  private final View mView;
  
  private ViewGestureDetector(Context paramContext, View paramView, AdAlertGestureListener paramAdAlertGestureListener)
  {
    super(paramContext, paramAdAlertGestureListener);
    this.mAdAlertGestureListener = paramAdAlertGestureListener;
    this.mView = paramView;
    setIsLongpressEnabled(false);
  }
  
  public ViewGestureDetector(Context paramContext, View paramView, AdConfiguration paramAdConfiguration)
  {
    this(paramContext, paramView, new AdAlertGestureListener(paramView, paramAdConfiguration));
  }
  
  private boolean isMotionEventInView(MotionEvent paramMotionEvent, View paramView)
  {
    if ((paramMotionEvent == null) || (paramView == null)) {}
    float f1;
    float f2;
    do
    {
      return false;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
    } while ((f1 < 0.0F) || (f1 > paramView.getWidth()) || (f2 < 0.0F) || (f2 > paramView.getHeight()));
    return true;
  }
  
  void resetAdFlaggingGesture()
  {
    this.mAdAlertGestureListener.reset();
  }
  
  void sendTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return;
    case 1: 
      if (this.mUserClickListener != null) {
        this.mUserClickListener.onUserClick();
      }
      for (;;)
      {
        this.mAdAlertGestureListener.finishGestureDetection();
        return;
        Log.d("MoPub", "View's onUserClick() is not registered.");
      }
    case 0: 
      onTouchEvent(paramMotionEvent);
      return;
    }
    if (isMotionEventInView(paramMotionEvent, this.mView))
    {
      onTouchEvent(paramMotionEvent);
      return;
    }
    resetAdFlaggingGesture();
  }
  
  @Deprecated
  void setAdAlertGestureListener(AdAlertGestureListener paramAdAlertGestureListener)
  {
    this.mAdAlertGestureListener = paramAdAlertGestureListener;
  }
  
  void setUserClickListener(UserClickListener paramUserClickListener)
  {
    this.mUserClickListener = paramUserClickListener;
  }
  
  static abstract interface UserClickListener
  {
    public abstract void onResetUserClick();
    
    public abstract void onUserClick();
    
    public abstract boolean wasClicked();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/ViewGestureDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */