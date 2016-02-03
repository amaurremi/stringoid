package com.gau.go.launcherex.gowidget.weather.scroller;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.gau.go.launcherex.gowidget.weather.view.dh;
import com.gau.go.launcherex.gowidget.weather.view.gl.GLWidgetChildView;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.view.GLFrameLayout;
import com.go.gl.view.GLView;
import java.util.ArrayList;

public class GLWidgetScrollGroup
  extends GLFrameLayout
  implements i
{
  private int a = 500;
  private Point b;
  private boolean c;
  private int d;
  private h e = null;
  private int f = 0;
  private e g = null;
  int mScreenHeight;
  int mScreenWidth;
  
  public GLWidgetScrollGroup(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public GLWidgetScrollGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public GLWidgetScrollGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.c = false;
    this.b = new Point();
    this.d = 15;
    this.e = new h(this);
    this.e.k(0);
    this.e.h(this.a);
    this.e.f(1);
  }
  
  private void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = this.e.k();
    int m = this.e.o();
    int n = this.e.p();
    paramGLCanvas.save();
    if (this.e.l() == 0) {
      paramGLCanvas.translate(k + paramInt2, 0.0F);
    }
    for (;;)
    {
      paramGLCanvas.clipRect(i, j - paramInt2, m + i, n + j - paramInt2);
      paramGLCanvas.translate(i, j);
      drawScreen(paramGLCanvas, paramInt1);
      paramGLCanvas.translate(-i, -j);
      paramGLCanvas.restore();
      return;
      paramGLCanvas.translate(0.0F, k + paramInt2);
    }
  }
  
  public void computeScroll()
  {
    this.e.g();
  }
  
  protected void dispatchDraw(GLCanvas paramGLCanvas)
  {
    int j = this.e.r();
    if (!this.e.d())
    {
      k = this.e.b();
      m = this.e.c();
      n = this.e.q();
      i = j;
      if (j > 0) {
        i = j - n;
      }
      if (i == 0)
      {
        a(paramGLCanvas, k, i);
        return;
      }
      a(paramGLCanvas, k, i);
      a(paramGLCanvas, m, i + n);
      return;
    }
    int i = getPaddingLeft();
    j = getPaddingTop();
    int k = this.e.k();
    int m = this.e.o();
    int n = this.e.p();
    int i1 = paramGLCanvas.save();
    paramGLCanvas.clipRect(i, k + j, i + m, j + k + n);
    super.dispatchDraw(paramGLCanvas);
    paramGLCanvas.restoreToCount(i1);
  }
  
  public void drawScreen(GLCanvas paramGLCanvas, int paramInt)
  {
    if (this.e.j() != 0.0F) {
      this.e.a(false);
    }
    GLView localGLView = getChildAt(paramInt);
    if ((localGLView != null) && (!this.e.d())) {
      localGLView.draw(paramGLCanvas);
    }
  }
  
  public int getCityCount()
  {
    return getCitys().size();
  }
  
  public ArrayList getCitys()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < getChildCount())
    {
      GLWidgetChildView localGLWidgetChildView = (GLWidgetChildView)getChildAt(i);
      if ((localGLWidgetChildView != null) && (localGLWidgetChildView.getChildViewType() == dh.a)) {
        localArrayList.add(localGLWidgetChildView);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public int getCurScreen()
  {
    return this.f;
  }
  
  public h getScreenScroller()
  {
    return this.e;
  }
  
  public GLWidgetChildView getThemeEnterance()
  {
    int i = 0;
    while (i < getChildCount())
    {
      GLWidgetChildView localGLWidgetChildView = (GLWidgetChildView)getChildAt(i);
      if ((localGLWidgetChildView != null) && (localGLWidgetChildView.getChildViewType() == dh.b)) {
        return localGLWidgetChildView;
      }
      i += 1;
    }
    return null;
  }
  
  public void notifyViewsChanged()
  {
    int i = getChildCount();
    this.e.g(i);
  }
  
  public void onFlingIntercepted() {}
  
  public void onFlingStart() {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.c = false;
      this.b.set((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      this.e.a(paramMotionEvent, paramMotionEvent.getAction());
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 2)
    {
      if ((!this.c) && (Math.abs(paramMotionEvent.getY() - this.b.y) > this.d)) {
        this.c = true;
      }
      return this.c;
    }
    if (paramMotionEvent.getAction() == 1)
    {
      this.e.a(paramMotionEvent, paramMotionEvent.getAction());
      return this.c;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getPaddingLeft();
    int i = getPaddingTop();
    paramInt3 = paramInt3 - paramInt1 - (getPaddingLeft() + getPaddingRight());
    this.mScreenWidth = paramInt3;
    paramInt4 = paramInt4 - paramInt2 - (getPaddingTop() + getPaddingBottom());
    this.mScreenHeight = paramInt4;
    int k = getChildCount();
    paramInt1 = 0;
    paramInt2 = i;
    while (paramInt1 < k)
    {
      getChildAt(paramInt1).layout(j, paramInt2, j + paramInt3, paramInt2 + paramInt4);
      paramInt2 += paramInt4;
      paramInt1 += 1;
    }
    this.e.c(paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onScreenChanged(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    if (this.g != null) {
      this.g.onScrollGroupChange(this, this.f);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2) {}
  
  public void onScrollFinish(int paramInt)
  {
    this.f = paramInt;
    if (this.g != null) {
      this.g.onScrollGroupFinishScroll(this, this.f);
    }
  }
  
  public void onScrollStart()
  {
    if (this.g != null) {
      this.g.onScrollGroupStartScroll(this, this.f);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingRight();
    int i = getPaddingTop();
    int j = getPaddingBottom();
    this.e.c(paramInt1 - (paramInt3 + paramInt4), paramInt2 - (i + j));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.e.a(paramMotionEvent, paramMotionEvent.getAction());
  }
  
  public void setCurScreen(int paramInt)
  {
    this.e.a(paramInt, this.a, null);
  }
  
  public void setCycleMode(boolean paramBoolean)
  {
    h.a(this, paramBoolean);
  }
  
  public void setEventListener(e parame)
  {
    this.g = parame;
  }
  
  public void setScreenScroller(h paramh)
  {
    this.e = paramh;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/scroller/GLWidgetScrollGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */