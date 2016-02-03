package com.gau.go.launcherex.gowidget.weather.scroller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.gau.go.launcherex.gowidget.weather.view.dg;
import com.gau.go.launcherex.gowidget.weather.view.dh;
import java.util.ArrayList;

public class WidgetScrollGroup
  extends FrameLayout
  implements i
{
  int a;
  int b;
  private int c = 500;
  private Point d;
  private boolean e;
  private int f;
  private h g = null;
  private int h = 0;
  private m i = null;
  
  public WidgetScrollGroup(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public WidgetScrollGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  public WidgetScrollGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int j = getPaddingLeft();
    int k = getPaddingTop();
    int m = this.g.k();
    int n = this.g.o();
    int i1 = this.g.p();
    paramCanvas.save();
    if (this.g.l() == 0) {
      paramCanvas.translate(m + paramInt2, 0.0F);
    }
    for (;;)
    {
      paramCanvas.clipRect(j, k - paramInt2, n + j, i1 + k - paramInt2);
      paramCanvas.translate(j, k);
      a(paramCanvas, paramInt1);
      paramCanvas.translate(-j, -k);
      paramCanvas.restore();
      return;
      paramCanvas.translate(0.0F, m + paramInt2);
    }
  }
  
  private void d()
  {
    this.e = false;
    this.d = new Point();
    this.f = 15;
    this.g = new h(this);
    this.g.k(0);
    this.g.h(this.c);
    this.g.f(1);
  }
  
  public void a()
  {
    int j = getChildCount();
    this.g.g(j);
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
  
  public void a(m paramm)
  {
    this.i = paramm;
  }
  
  public void a(boolean paramBoolean)
  {
    h.a(this, paramBoolean);
  }
  
  public int b()
  {
    return this.h;
  }
  
  public ArrayList c()
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < getChildCount())
    {
      dg localdg = (dg)getChildAt(j);
      if ((localdg != null) && (localdg.n() == dh.a)) {
        localArrayList.add(localdg);
      }
      j += 1;
    }
    return localArrayList;
  }
  
  public void computeScroll()
  {
    this.g.g();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int k = this.g.r();
    if (!this.g.d())
    {
      m = this.g.b();
      n = this.g.c();
      i1 = this.g.q();
      j = k;
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
    int j = getPaddingLeft();
    k = getPaddingTop();
    int m = this.g.k();
    int n = this.g.o();
    int i1 = this.g.p();
    int i2 = paramCanvas.save();
    paramCanvas.clipRect(j, m + k, n + j, k + m + i1);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restoreToCount(i2);
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
      this.e = false;
      this.d.set((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      this.g.a(paramMotionEvent, paramMotionEvent.getAction());
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 2)
    {
      if ((!this.e) && (Math.abs(paramMotionEvent.getY() - this.d.y) > this.f)) {
        this.e = true;
      }
      return this.e;
    }
    if (paramMotionEvent.getAction() == 1)
    {
      this.g.a(paramMotionEvent, paramMotionEvent.getAction());
      return this.e;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = getPaddingLeft();
    int j = getPaddingTop();
    paramInt3 = paramInt3 - paramInt1 - (getPaddingLeft() + getPaddingRight());
    this.a = paramInt3;
    paramInt4 = paramInt4 - paramInt2 - (getPaddingTop() + getPaddingBottom());
    this.b = paramInt4;
    int m = getChildCount();
    paramInt1 = 0;
    paramInt2 = j;
    while (paramInt1 < m)
    {
      getChildAt(paramInt1).layout(k, paramInt2, k + paramInt3, paramInt2 + paramInt4);
      paramInt2 += paramInt4;
      paramInt1 += 1;
    }
    this.g.c(paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onScreenChanged(int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    if (this.i != null) {
      this.i.onScrollGroupChange(this, this.h);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2) {}
  
  public void onScrollFinish(int paramInt)
  {
    this.h = paramInt;
    if (this.i != null) {
      this.i.onScrollGroupFinishScroll(this, this.h);
    }
  }
  
  public void onScrollStart()
  {
    if (this.i != null) {
      this.i.onScrollGroupStartScroll(this, this.h);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingRight();
    int j = getPaddingTop();
    int k = getPaddingBottom();
    this.g.c(paramInt1 - (paramInt3 + paramInt4), paramInt2 - (j + k));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.g.a(paramMotionEvent, paramMotionEvent.getAction());
  }
  
  public void setScreenScroller(h paramh)
  {
    this.g = paramh;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/scroller/WidgetScrollGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */