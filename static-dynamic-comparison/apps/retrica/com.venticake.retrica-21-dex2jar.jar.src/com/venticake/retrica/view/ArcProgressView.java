package com.venticake.retrica.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import java.util.Date;

public class ArcProgressView
  extends View
{
  private Handler mMainHandler = null;
  private Paint mPaint;
  private long mPlayProgressDurationMillis = 0L;
  private long mPlayProgressStartAt = 0L;
  private float mProgress = 0.0F;
  private float mStartAngle;
  private float mSweepAngle;
  
  public ArcProgressView(Context paramContext)
  {
    super(paramContext);
    _initialize();
  }
  
  public ArcProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    _initialize();
  }
  
  public ArcProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    _initialize();
  }
  
  private void _initialize()
  {
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.mStartAngle = -90.0F;
    this.mSweepAngle = 0.0F;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(Color.argb(150, 0, 0, 0));
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = getMeasuredWidth();
    int j = getMeasuredHeight();
    int i = (int)(Math.max(k, j) * 1.4F);
    k = (k - i) / 2;
    j = (j - i) / 2;
    RectF localRectF = new RectF(k, j, k + i, i + j);
    paramCanvas.drawColor(0);
    long l;
    if ((this.mPlayProgressStartAt > 0L) && (this.mPlayProgressDurationMillis > 0L))
    {
      l = new Date().getTime() - this.mPlayProgressStartAt;
      if (l <= this.mPlayProgressDurationMillis) {
        break label167;
      }
      finishProgress();
    }
    label167:
    for (this.mProgress = 1.0F;; this.mProgress = ((float)l / (float)this.mPlayProgressDurationMillis))
    {
      this.mSweepAngle = (360.0F * (1.0F - this.mProgress));
      this.mStartAngle = (270.0F - this.mSweepAngle);
      paramCanvas.drawArc(localRectF, this.mStartAngle, this.mSweepAngle, true, this.mPaint);
      invalidate();
      return;
    }
  }
  
  public void finishProgress()
  {
    this.mPlayProgressStartAt = 0L;
    this.mPlayProgressDurationMillis = 0L;
    this.mMainHandler.post(new Runnable()
    {
      public void run()
      {
        ArcProgressView.this.setVisibility(4);
      }
    });
  }
  
  public void playProgress(long paramLong)
  {
    this.mPlayProgressStartAt = new Date().getTime();
    this.mPlayProgressDurationMillis = paramLong;
    this.mProgress = 0.0F;
    this.mMainHandler.post(new Runnable()
    {
      public void run()
      {
        ArcProgressView.this.setVisibility(0);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/ArcProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */