package com.gau.go.launcherex.gowidget.weather.scroller;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class WeatherDetailScrollGroup
  extends FrameLayout
  implements i
{
  int a;
  int b;
  private int c = 500;
  private PointF d;
  private boolean e;
  private int f;
  private h g = null;
  private int h = 0;
  private l i = null;
  private c j;
  private c k;
  private int l;
  private k m;
  private boolean n = false;
  
  public WeatherDetailScrollGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    float f2 = 1.0F;
    if (this.j == null) {}
    int i1;
    float f4;
    do
    {
      return;
      if (!this.n)
      {
        this.j.a();
        this.k.a();
        return;
      }
      i1 = this.g.r();
      f4 = this.g.q();
      if ((b() == 0) && (i1 > 0))
      {
        float f3 = (paramInt1 - paramInt2) / f4 * 1.5F;
        f1 = f3;
        if (f3 > 1.0F) {
          f1 = 1.0F;
        }
        this.j.a(f1);
      }
    } while ((i1 >= 0) || (b() != getChildCount() - 1));
    float f1 = (paramInt1 - paramInt2) / f4 * 1.5F;
    if (f1 > 1.0F) {
      f1 = f2;
    }
    for (;;)
    {
      this.k.a(f1);
      return;
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.j == null) {
      return;
    }
    int i1 = this.g.r();
    int i2 = getHeight();
    int i3;
    if ((b() == 0) && (i1 > 0))
    {
      i3 = paramCanvas.save();
      paramCanvas.rotate(270.0F);
      paramCanvas.translate(-i2, getScrollX());
      this.j.a(i2, getWidth());
      if (this.j.a(paramCanvas)) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      paramCanvas.restoreToCount(i3);
      if (this.l <= 0) {
        this.j.a((int)this.g.v());
      }
    }
    if ((i1 < 0) && (b() == getChildCount() - 1))
    {
      i3 = paramCanvas.save();
      int i4 = getWidth();
      paramCanvas.rotate(90.0F);
      paramCanvas.translate(0.0F, -i4 - getScrollX());
      this.k.a(i2, i4);
      if (this.k.a(paramCanvas)) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      paramCanvas.restoreToCount(i3);
      if (this.l >= 0) {
        this.k.a((int)this.g.v());
      }
    }
    this.l = i1;
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int i1 = getPaddingLeft();
    int i2 = getPaddingTop();
    int i3 = this.g.k();
    int i4 = this.g.o();
    int i5 = this.g.p();
    paramCanvas.save();
    if (this.g.l() == 0) {
      paramCanvas.translate(i3 + paramInt2, 0.0F);
    }
    for (;;)
    {
      paramCanvas.clipRect(i1, i2, i1 + i4, i2 + i5);
      paramCanvas.translate(i1, i2);
      a(paramCanvas, paramInt1);
      paramCanvas.translate(-i1, -i2);
      paramCanvas.restore();
      return;
      paramCanvas.translate(0.0F, i3 + paramInt2);
    }
  }
  
  private void c()
  {
    this.e = false;
    this.d = new PointF();
    new DisplayMetrics();
    this.f = ((int)(getResources().getDisplayMetrics().density * 10.0F));
    this.g = new h(this);
    this.g.k(0);
    this.g.h(this.c);
    this.g.f(0);
    a(k.a);
  }
  
  private void d()
  {
    if (!e())
    {
      h();
      return;
    }
    if ((getChildCount() == 1) || (!this.g.s()))
    {
      g();
      return;
    }
    h();
  }
  
  private boolean e()
  {
    return (this.m == k.a) || (this.m == k.c);
  }
  
  private boolean f()
  {
    return (this.m == k.b) || (this.m == k.c);
  }
  
  private void g()
  {
    if (this.j == null) {
      this.j = new c(getContext());
    }
    if (this.k == null) {
      this.k = new c(getContext());
    }
  }
  
  private void h()
  {
    this.j = null;
    this.k = null;
  }
  
  public void a()
  {
    int i1 = getChildCount();
    this.g.g(i1);
    d();
  }
  
  public void a(int paramInt)
  {
    this.g.a(paramInt, this.c, null);
  }
  
  public void a(Canvas paramCanvas, int paramInt)
  {
    if (this.g.j() != 0.0F) {
      this.g.a(false);
    }
    View localView = getChildAt(paramInt);
    if ((localView != null) && (!this.g.d())) {
      localView.draw(paramCanvas);
    }
  }
  
  public void a(k paramk)
  {
    if (this.m != paramk)
    {
      this.m = paramk;
      d();
    }
  }
  
  public void a(l paraml)
  {
    this.i = paraml;
  }
  
  public void a(boolean paramBoolean)
  {
    h.a(this, paramBoolean);
    d();
  }
  
  public int b()
  {
    return this.h;
  }
  
  public void computeScroll()
  {
    this.g.g();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i2;
    int i3;
    int i4;
    int i5;
    if (!this.g.d())
    {
      i2 = this.g.r();
      i3 = this.g.b();
      i4 = this.g.c();
      i5 = this.g.q();
      int i1 = i2;
      if (i2 > 0) {
        i1 = i2 - i5;
      }
      if (-1 != i4)
      {
        i2 = i1;
        if (-1 != i3) {}
      }
      else
      {
        i2 = i1;
        if (!f()) {
          i2 = 0;
        }
      }
      if (i2 == 0)
      {
        a(paramCanvas, i3, i2);
        a(paramCanvas, i4, i2);
      }
    }
    for (;;)
    {
      if (e()) {
        a(paramCanvas);
      }
      return;
      a(paramCanvas, i3, i2);
      a(paramCanvas, i4, i2 + i5);
      continue;
      super.dispatchDraw(paramCanvas);
    }
  }
  
  public h getScreenScroller()
  {
    return this.g;
  }
  
  public void onFlingIntercepted() {}
  
  public void onFlingStart() {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.n = false;
      this.e = false;
      this.d.set(paramMotionEvent.getX(), paramMotionEvent.getY());
      this.g.a(paramMotionEvent, paramMotionEvent.getAction());
      return !this.g.d();
    }
    if (paramMotionEvent.getAction() == 2)
    {
      this.n = true;
      if ((!this.e) && (Math.abs(paramMotionEvent.getX() - this.d.x) > this.f) && (Math.abs(paramMotionEvent.getX() - this.d.x) > Math.abs(paramMotionEvent.getY() - this.d.y) * Math.sqrt(2.0D)))
      {
        this.e = true;
        return true;
      }
    }
    else if (paramMotionEvent.getAction() == 1)
    {
      this.n = false;
      this.g.a(paramMotionEvent, paramMotionEvent.getAction());
      return this.e;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getPaddingLeft();
    int i2 = getPaddingTop();
    paramInt3 = paramInt3 - paramInt1 - (getPaddingLeft() + getPaddingRight());
    this.a = paramInt3;
    paramInt4 = paramInt4 - paramInt2 - (getPaddingTop() + getPaddingBottom());
    this.b = paramInt4;
    int i3 = getChildCount();
    paramInt1 = 0;
    paramInt2 = i1;
    while (paramInt1 < i3)
    {
      getChildAt(paramInt1).layout(paramInt2, i2, paramInt2 + paramInt3, i2 + paramInt4);
      paramInt2 += paramInt3;
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onScreenChanged(int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    if (this.i != null) {
      this.i.b(this, this.h);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public void onScrollFinish(int paramInt)
  {
    this.h = paramInt;
    if (this.i != null) {
      this.i.c(this, this.h);
    }
  }
  
  public void onScrollStart()
  {
    if (this.i != null) {
      this.i.a(this, this.h);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingRight();
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    this.g.c(paramInt1 - (paramInt3 + paramInt4), paramInt2 - (i1 + i2));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 2) {}
    for (this.n = true;; this.n = false) {
      return this.g.a(paramMotionEvent, paramMotionEvent.getAction());
    }
  }
  
  public void setScreenScroller(h paramh)
  {
    this.g = paramh;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/scroller/WeatherDetailScrollGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */