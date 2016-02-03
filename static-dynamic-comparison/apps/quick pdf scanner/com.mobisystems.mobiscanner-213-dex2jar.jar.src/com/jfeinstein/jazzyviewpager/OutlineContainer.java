package com.jfeinstein.jazzyviewpager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

public class OutlineContainer
  extends FrameLayout
  implements Animatable
{
  private Paint amo;
  private boolean amp = false;
  private final Runnable amq = new Runnable()
  {
    public void run()
    {
      long l = AnimationUtils.currentAnimationTimeMillis() - OutlineContainer.a(OutlineContainer.this);
      if (l >= 500L)
      {
        OutlineContainer.a(OutlineContainer.this, 0.0F);
        OutlineContainer.this.invalidate();
        OutlineContainer.this.stop();
        return;
      }
      OutlineContainer.a(OutlineContainer.this, OutlineContainer.b(OutlineContainer.this).getInterpolation(1.0F - (float)l / 500.0F));
      OutlineContainer.this.invalidate();
      OutlineContainer.this.postDelayed(OutlineContainer.c(OutlineContainer.this), 16L);
    }
  };
  private float mAlpha = 1.0F;
  private final Interpolator mInterpolator = new Interpolator()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
    }
  };
  private long mStartTime;
  
  public OutlineContainer(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public OutlineContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public OutlineContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.amo = new Paint();
    this.amo.setAntiAlias(true);
    this.amo.setStrokeWidth(b.a(getResources(), 2));
    this.amo.setColor(getResources().getColor(a.b.holo_blue));
    this.amo.setStyle(Paint.Style.STROKE);
    int i = b.a(getResources(), 10);
    setPadding(i, i, i, i);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int i = b.a(getResources(), 5);
    if (this.amo.getColor() != JazzyViewPager.alF) {
      this.amo.setColor(JazzyViewPager.alF);
    }
    this.amo.setAlpha((int)(this.mAlpha * 255.0F));
    paramCanvas.drawRect(new Rect(i, i, getMeasuredWidth() - i, getMeasuredHeight() - i), this.amo);
  }
  
  public boolean isRunning()
  {
    return this.amp;
  }
  
  public void start()
  {
    if (this.amp) {
      return;
    }
    this.amp = true;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    post(this.amq);
  }
  
  public void stop()
  {
    if (!this.amp) {
      return;
    }
    this.amp = false;
  }
  
  public void w(float paramFloat)
  {
    this.mAlpha = paramFloat;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/jfeinstein/jazzyviewpager/OutlineContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */