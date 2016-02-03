package com.gau.go.launcherex.gowidget.weather.scroller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class AnimViewScrollGroup
  extends FrameLayout
  implements i
{
  int a;
  int b;
  private int c = 500;
  private h d = null;
  private int e = 0;
  private a f = null;
  private Point g;
  private boolean h;
  private int i;
  
  public AnimViewScrollGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int j = getPaddingLeft();
    int k = getPaddingTop();
    int m = this.d.k();
    int n = this.d.o();
    int i1 = this.d.p();
    paramCanvas.save();
    if (this.d.l() == 0) {
      paramCanvas.translate(m + paramInt2, 0.0F);
    }
    for (;;)
    {
      paramCanvas.clipRect(j, k, j + n, k + i1);
      paramCanvas.translate(j, k);
      a(paramCanvas, paramInt1);
      paramCanvas.translate(-j, -k);
      paramCanvas.restore();
      return;
      paramCanvas.translate(0.0F, m + paramInt2);
    }
  }
  
  private void b()
  {
    this.h = false;
    this.g = new Point();
    this.i = 15;
    this.d = new h(this);
    this.d.k(0);
    this.d.h(this.c);
    this.d.f(0);
  }
  
  public void a()
  {
    int j = getChildCount();
    this.d.g(j);
  }
  
  public void a(int paramInt)
  {
    this.d.a(paramInt, this.c, null);
  }
  
  public void a(Canvas paramCanvas, int paramInt)
  {
    if (this.d.j() != 0.0F) {
      this.d.a(false);
    }
    View localView = getChildAt(paramInt);
    if ((localView != null) && (!this.d.d())) {
      localView.draw(paramCanvas);
    }
  }
  
  public void a(a parama)
  {
    this.f = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    h.a(this, paramBoolean);
  }
  
  public void computeScroll()
  {
    this.d.g();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!this.d.d())
    {
      int k = this.d.r();
      int m = this.d.b();
      int n = this.d.c();
      int i1 = this.d.q();
      int j = k;
      if (k > 0) {
        j = k - i1;
      }
      if (j == 0)
      {
        a(paramCanvas, m, j);
        return;
      }
      a(paramCanvas, m, j);
      a(paramCanvas, n, j + i1);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public h getScreenScroller()
  {
    return this.d;
  }
  
  public void onFlingIntercepted() {}
  
  public void onFlingStart() {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.h = false;
      this.g.set((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      this.d.a(paramMotionEvent, paramMotionEvent.getAction());
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 2)
    {
      if ((!this.h) && (Math.abs(paramMotionEvent.getY() - this.g.y) > this.i)) {
        this.h = true;
      }
      return this.h;
    }
    if (paramMotionEvent.getAction() == 1)
    {
      this.d.a(paramMotionEvent, paramMotionEvent.getAction());
      return this.h;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getPaddingLeft();
    int k = getPaddingTop();
    paramInt3 = paramInt3 - paramInt1 - (getPaddingLeft() + getPaddingRight());
    this.a = paramInt3;
    paramInt4 = paramInt4 - paramInt2 - (getPaddingTop() + getPaddingBottom());
    this.b = paramInt4;
    int m = getChildCount();
    paramInt1 = 0;
    paramInt2 = j;
    while (paramInt1 < m)
    {
      getChildAt(paramInt1).layout(paramInt2, k, paramInt2 + paramInt3, k + paramInt4);
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
    this.e = paramInt1;
    if (this.f != null) {
      this.f.a(this.e, paramInt2);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2) {}
  
  public void onScrollFinish(int paramInt)
  {
    this.e = paramInt;
    if (this.f != null) {
      this.f.b(this.e);
    }
  }
  
  public void onScrollStart()
  {
    if (this.f != null) {
      this.f.a(this.e);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingRight();
    int j = getPaddingTop();
    int k = getPaddingBottom();
    this.d.c(paramInt1 - (paramInt3 + paramInt4), paramInt2 - (j + k));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.d.a(paramMotionEvent, paramMotionEvent.getAction());
  }
  
  public void setScreenScroller(h paramh)
  {
    this.d = paramh;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/scroller/AnimViewScrollGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */