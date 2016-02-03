package com.mobisystems.photoimageview;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

public class f
{
  private int aEI = 0;
  private final android.support.v4.view.d aOK;
  private final d aOL;
  private final a aOM;
  
  public f(Context paramContext, a parama)
  {
    this.aOK = new android.support.v4.view.d(paramContext, parama);
    this.aOK.setOnDoubleTapListener(parama);
    this.aOM = parama;
    if (Build.VERSION.SDK_INT >= 19) {}
    for (this.aOL = new d(paramContext, parama);; this.aOL = new d(paramContext, parama))
    {
      this.aOL.setQuickScaleEnabled(true);
      return;
    }
  }
  
  private MotionEvent q(MotionEvent paramMotionEvent)
  {
    switch (this.aEI)
    {
    default: 
      return paramMotionEvent;
    case 90: 
      paramMotionEvent.setLocation(paramMotionEvent.getY(), paramMotionEvent.getX());
      return paramMotionEvent;
    case 180: 
      paramMotionEvent.setLocation(this.aOM.getWidth() - paramMotionEvent.getX(), this.aOM.getHeight() - paramMotionEvent.getY());
      return paramMotionEvent;
    }
    paramMotionEvent.setLocation(paramMotionEvent.getY(), this.aOM.getWidth() - paramMotionEvent.getX());
    return paramMotionEvent;
  }
  
  public void gJ(int paramInt)
  {
    this.aEI = paramInt;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = this.aOL.onTouchEvent(q(MotionEvent.obtain(paramMotionEvent)));
    boolean bool1 = bool2;
    if (!this.aOL.isInProgress()) {
      bool1 = bool2 | this.aOK.onTouchEvent(paramMotionEvent);
    }
    return bool1;
  }
  
  public static abstract class a
    implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener
  {
    public int getHeight()
    {
      return 0;
    }
    
    public int getWidth()
    {
      return 0;
    }
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent) {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      return false;
    }
    
    public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      return false;
    }
    
    public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public void onShowPress(MotionEvent paramMotionEvent) {}
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/photoimageview/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */