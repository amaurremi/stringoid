package com.gtp.go.weather.sharephoto.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.TextView;

public class AnimDeleteButton
  extends FrameLayout
  implements Animation.AnimationListener
{
  private Drawable a;
  private Drawable b;
  private TextView c;
  private a d;
  private boolean e;
  private boolean f;
  private float g = 255.0F;
  private float h;
  private float i;
  private Rect j = new Rect();
  private Resources k;
  
  public AnimDeleteButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AnimDeleteButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat3 <= paramFloat1) {
      return 0.0F;
    }
    if (paramFloat3 >= paramFloat2) {
      return 1.0F;
    }
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  private void a(Context paramContext)
  {
    this.k = paramContext.getResources();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setTextColor(-16736023);
      this.b = f();
      return;
    }
    this.c.setTextColor(-1);
    this.b = g();
  }
  
  private void h()
  {
    this.a = e();
    this.b = g();
    this.c = ((TextView)findViewById(2131231832));
    this.c.setVisibility(4);
    this.c.setText(d());
    this.d = new a(this);
    this.d.setAnimationListener(this);
    this.d.setFillAfter(true);
    this.d.setDuration(500L);
  }
  
  public void a()
  {
    if (!this.f)
    {
      this.f = true;
      this.e = true;
      this.c.setVisibility(0);
      startAnimation(this.d);
    }
  }
  
  public void a(float paramFloat)
  {
    int m = this.c.getWidth() - this.a.getIntrinsicWidth();
    if (this.e)
    {
      this.h = (-180.0F * paramFloat);
      this.i = (-m * paramFloat);
    }
    for (this.g = (a(0.5F, 1.0F, paramFloat) * 255.0F);; this.g = (a(0.0F, 0.5F, paramFloat) * 255.0F))
    {
      invalidate();
      return;
      this.h = (180.0F * paramFloat + 180.0F);
      float f1 = -m;
      this.i = (m * paramFloat + f1);
    }
  }
  
  public void b()
  {
    this.f = true;
    this.e = false;
    startAnimation(this.d);
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  protected String d()
  {
    return this.k.getString(2131166408);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int m = (int)(255.0F - this.g);
    Rect localRect = this.a.getBounds();
    int n = (int)(localRect.left + this.i);
    this.b.setBounds(n, localRect.top, localRect.right, localRect.bottom);
    this.b.draw(paramCanvas);
    n = paramCanvas.save();
    int i5;
    if (this.e)
    {
      com.a.c.a.a(this.c, this.g);
      localRect = this.a.getBounds();
      int i1 = localRect.left;
      int i2 = localRect.width() / 2;
      int i3 = localRect.top;
      int i4 = localRect.height() / 2;
      i5 = paramCanvas.save();
      paramCanvas.rotate(this.h, i1 + i2 + this.i, i4 + i3);
      paramCanvas.translate(this.i, 0.0F);
      if (!this.e) {
        break label218;
      }
      this.a.setAlpha(m);
    }
    for (;;)
    {
      this.a.draw(paramCanvas);
      paramCanvas.restoreToCount(i5);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restoreToCount(n);
      return;
      com.a.c.a.a(this.c, m);
      break;
      label218:
      this.a.setAlpha((int)this.g);
    }
  }
  
  protected Drawable e()
  {
    return this.k.getDrawable(2130838421);
  }
  
  protected Drawable f()
  {
    return this.k.getDrawable(2130838422);
  }
  
  protected Drawable g()
  {
    return this.k.getDrawable(2130838422);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.f = false;
    if (!this.e) {
      this.c.setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    h();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getWidth() - this.a.getIntrinsicWidth() - getPaddingRight();
    paramInt2 = this.c.getTop();
    this.j.set(paramInt1, paramInt2, this.a.getIntrinsicWidth() + paramInt1, this.a.getIntrinsicHeight() + paramInt2);
    this.a.setBounds(this.j);
    this.b.setBounds(this.j);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (this.e)
      {
        a(true);
        continue;
        if (this.e) {
          a(false);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/view/AnimDeleteButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */