package mobi.beyondpod.ui.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public abstract class ScaleGestureHelper
{
  private static String TAG = ScaleGestureHelper.class.getSimpleName();
  
  public static ScaleGestureHelper getInstance()
  {
    if (CoreHelper.ApiLevel() <= 7) {
      return NoOpScaleGesture.access$0();
    }
    return ScaleGesture.access$0();
  }
  
  public abstract void Initialize(Context paramContext, OnScaleGestureListener paramOnScaleGestureListener);
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  private static class NoOpScaleGesture
    extends ScaleGestureHelper
  {
    private static ScaleGestureHelper createInstance()
    {
      CoreHelper.WriteTraceEntry(ScaleGestureHelper.TAG, "Created NoOp (pre 2.2) Gesture Detector");
      return new NoOpScaleGesture();
    }
    
    public void Initialize(Context paramContext, ScaleGestureHelper.OnScaleGestureListener paramOnScaleGestureListener) {}
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  public static abstract interface OnScaleGestureListener
  {
    public abstract boolean onScale(float paramFloat);
  }
  
  @SuppressLint({"NewApi"})
  private static class ScaleGesture
    extends ScaleGestureHelper
  {
    ScaleGestureDetector _scaleDetector;
    ScaleGestureHelper.OnScaleGestureListener _scaleListener;
    
    private static ScaleGestureHelper createInstance()
    {
      return new ScaleGesture();
    }
    
    @SuppressLint({"NewApi"})
    public void Initialize(Context paramContext, ScaleGestureHelper.OnScaleGestureListener paramOnScaleGestureListener)
    {
      this._scaleListener = paramOnScaleGestureListener;
      this._scaleDetector = new ScaleGestureDetector(paramContext, new ScaleListener(null));
    }
    
    @SuppressLint({"NewApi"})
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      if (this._scaleDetector != null) {
        return this._scaleDetector.onTouchEvent(paramMotionEvent);
      }
      return false;
    }
    
    private class ScaleListener
      extends ScaleGestureDetector.SimpleOnScaleGestureListener
    {
      private ScaleListener() {}
      
      @SuppressLint({"NewApi"})
      public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
      {
        if (ScaleGestureHelper.ScaleGesture.this._scaleListener != null) {
          return ScaleGestureHelper.ScaleGesture.this._scaleListener.onScale(paramScaleGestureDetector.getScaleFactor());
        }
        return false;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/ScaleGestureHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */