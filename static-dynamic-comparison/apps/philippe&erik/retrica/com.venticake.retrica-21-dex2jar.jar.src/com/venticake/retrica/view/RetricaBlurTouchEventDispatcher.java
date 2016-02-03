package com.venticake.retrica.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.view.m;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.venticake.retrica.MainActivity;
import com.venticake.retrica.util.UserInterfaceUtil;

public class RetricaBlurTouchEventDispatcher
  implements GestureDetector.OnGestureListener
{
  public static final int BLUR_GUIDE_CIRCLE_BORDER_WIDTH = 2;
  public static final int BLUR_GUIDE_POINT_RADIUS = 2;
  private Paint blurGuidePaint = null;
  private float centerX = 0.5F;
  private float centerY = 0.5F;
  private final float defaultRadius = 0.3F;
  private RetricaBlurTouchEventListener eventListner = null;
  m gd;
  Context mContext;
  private int mHeight;
  private int mImageHeight = 0;
  private int mImageWidth = 0;
  private GestureDetector mMoveDetector;
  private ScaleGestureDetector mScaleDetector;
  private float mScaleFactor = 1.0F;
  private final float mScaleFactorMax = 1.8F;
  private final float mScaleFactorMin = 0.8F;
  private int mWidth;
  private float radius = 0.3F;
  
  public RetricaBlurTouchEventDispatcher(Context paramContext)
  {
    this.mContext = paramContext;
    this.gd = new m(this.mContext, this);
    this.mMoveDetector = new GestureDetector(paramContext, new RetricaBlurTouchEventDispatcher.MoveListner(this));
    this.mScaleDetector = new ScaleGestureDetector(paramContext, new RetricaBlurTouchEventDispatcher.ScaleListener(this, null));
    this.blurGuidePaint = new Paint();
    this.blurGuidePaint.setColor(-16711936);
  }
  
  private float actualCenterX(float paramFloat)
  {
    if ((this.mImageWidth > 0) && (this.mImageHeight > 0)) {
      return (this.mWidth - this.mImageWidth) / 2.0F + this.centerX * this.mImageWidth;
    }
    return this.centerX * this.mWidth;
  }
  
  private float actualCenterY(float paramFloat)
  {
    if ((this.mImageWidth > 0) && (this.mImageHeight > 0)) {
      return (this.mHeight - this.mImageHeight) / 2.0F + this.centerY * this.mImageHeight;
    }
    return this.centerY * this.mHeight;
  }
  
  private float actualRadius(float paramFloat)
  {
    if ((this.mImageWidth > 0) && (this.mImageHeight > 0)) {
      return Math.min(this.mImageWidth, this.mImageHeight) * paramFloat;
    }
    return Math.min(this.mWidth, this.mHeight) * paramFloat;
  }
  
  public boolean blurGestureEventEnabled()
  {
    if (this.eventListner != null) {
      return this.eventListner.blurGestureEventEnabled();
    }
    return false;
  }
  
  public void drawBlurGuide(View paramView, Canvas paramCanvas)
  {
    float f1 = actualCenterX(this.centerX);
    float f2 = actualCenterY(this.centerY);
    this.blurGuidePaint.setStyle(Paint.Style.STROKE);
    this.blurGuidePaint.setStrokeWidth(UserInterfaceUtil.dp2px(2.0F, paramView));
    paramCanvas.drawCircle(f1, f2, actualRadius(this.radius), this.blurGuidePaint);
    this.blurGuidePaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(f1, f2, UserInterfaceUtil.dp2px(2.0F, paramView), this.blurGuidePaint);
  }
  
  public void finishEvent()
  {
    if (this.eventListner == null) {
      return;
    }
    this.eventListner.gestureEventFinished();
  }
  
  public float getCenterX()
  {
    return this.centerX;
  }
  
  public float getCenterY()
  {
    return this.centerY;
  }
  
  public float getRadius()
  {
    return this.radius;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramMotionEvent1.getX() - paramMotionEvent2.getX() > 50.0F)
    {
      Log.d("swipe", "Left");
      this.eventListner.swipedToLeft();
    }
    for (;;)
    {
      return true;
      if (paramMotionEvent2.getX() - paramMotionEvent1.getX() > 50.0F)
      {
        Log.d("swipe", "Right");
        this.eventListner.swipedToRight();
      }
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.eventListner == null) {
      return true;
    }
    label55:
    int j;
    int i;
    if ((this.eventListner.blurGestureEventEnabled()) && (((MainActivity)MainActivity.a).e.getVisibility() == 4))
    {
      this.mMoveDetector.onTouchEvent(paramMotionEvent);
      this.mScaleDetector.onTouchEvent(paramMotionEvent);
      j = 0;
      i = j;
      switch (paramMotionEvent.getAction())
      {
      default: 
        i = j;
      }
    }
    while (i != 0)
    {
      finishEvent();
      return true;
      if (((MainActivity)MainActivity.a).e.getVisibility() != 0) {
        break label55;
      }
      this.gd.a(paramMotionEvent);
      return true;
      this.eventListner.blurTouchViewTouchDown();
      i = j;
      continue;
      this.eventListner.blurTouchViewTouchUp();
      i = 1;
    }
  }
  
  public void setCenter(float paramFloat1, float paramFloat2)
  {
    setCenter(paramFloat1, paramFloat2, false);
  }
  
  public void setCenter(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.centerX = Math.max(0.0F, Math.min(1.0F, paramFloat1));
    this.centerY = Math.max(0.0F, Math.min(1.0F, paramFloat2));
    if (this.eventListner != null)
    {
      this.eventListner.centerChanged(this.centerX, this.centerY);
      if (paramBoolean) {
        this.eventListner.blurTouchViewTouchUp();
      }
    }
  }
  
  public void setEventListner(RetricaBlurTouchEventListener paramRetricaBlurTouchEventListener)
  {
    this.eventListner = paramRetricaBlurTouchEventListener;
  }
  
  public void setImageSize(int paramInt1, int paramInt2)
  {
    this.mImageWidth = paramInt1;
    this.mImageHeight = paramInt2;
  }
  
  public void setRadius(float paramFloat)
  {
    this.radius = paramFloat;
    if (this.eventListner != null) {
      this.eventListner.radiusChanged(this.radius);
    }
  }
  
  public void startEvent()
  {
    if (this.eventListner == null) {
      return;
    }
    this.eventListner.gestureEventStarted();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/RetricaBlurTouchEventDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */