package com.go.weatherex.sidebar;

import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.view.View;

class j
  extends ViewDragHelper.Callback
{
  private final int b;
  private ViewDragHelper c;
  private final Runnable d = new k(this);
  
  public j(SidebarDrawerLayout paramSidebarDrawerLayout, int paramInt)
  {
    this.b = paramInt;
  }
  
  private void b()
  {
    int i = 3;
    if (this.b == 3) {
      i = 5;
    }
    View localView = this.a.d(i);
    if (localView != null) {
      this.a.i(localView);
    }
  }
  
  private void c()
  {
    int j = 0;
    int k = this.c.getEdgeSize();
    int i;
    View localView;
    if (this.b == 3)
    {
      i = 1;
      if (i == 0) {
        break label149;
      }
      localView = this.a.d(3);
      if (localView != null) {
        j = -localView.getWidth();
      }
      j += k;
    }
    for (;;)
    {
      if ((localView != null) && (((i != 0) && (localView.getLeft() < j)) || ((i == 0) && (localView.getLeft() > j) && (this.a.a(localView) == 0))))
      {
        SidebarDrawerLayout.LayoutParams localLayoutParams = (SidebarDrawerLayout.LayoutParams)localView.getLayoutParams();
        this.c.smoothSlideViewTo(localView, j, localView.getTop());
        localLayoutParams.c = true;
        this.a.invalidate();
        b();
        this.a.c();
      }
      return;
      i = 0;
      break;
      label149:
      localView = this.a.d(5);
      j = this.a.getWidth();
      j -= k;
    }
  }
  
  public void a()
  {
    this.a.removeCallbacks(this.d);
  }
  
  public void a(ViewDragHelper paramViewDragHelper)
  {
    this.c = paramViewDragHelper;
  }
  
  public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
  {
    if (this.a.a(paramView, 3)) {
      return Math.max(-paramView.getWidth(), Math.min(paramInt1, 0));
    }
    paramInt2 = this.a.getWidth();
    return Math.max(paramInt2 - paramView.getWidth(), Math.min(paramInt1, paramInt2));
  }
  
  public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
  {
    return paramView.getTop();
  }
  
  public int getViewHorizontalDragRange(View paramView)
  {
    return paramView.getWidth();
  }
  
  public void onEdgeDragStarted(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0x1) == 1) {}
    for (View localView = this.a.d(3);; localView = this.a.d(5))
    {
      if ((localView != null) && (this.a.a(localView) == 0)) {
        this.c.captureChildView(localView, paramInt2);
      }
      return;
    }
  }
  
  public boolean onEdgeLock(int paramInt)
  {
    return false;
  }
  
  public void onEdgeTouched(int paramInt1, int paramInt2)
  {
    this.a.postDelayed(this.d, 160L);
  }
  
  public void onViewCaptured(View paramView, int paramInt)
  {
    ((SidebarDrawerLayout.LayoutParams)paramView.getLayoutParams()).c = false;
    b();
  }
  
  public void onViewDragStateChanged(int paramInt)
  {
    this.a.a(this.b, paramInt, this.c.getCapturedView());
  }
  
  public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = paramView.getWidth();
    float f;
    if (this.a.a(paramView, 3))
    {
      f = (paramInt2 + paramInt1) / paramInt2;
      this.a.b(paramView, f);
      if (f != 0.0F) {
        break label76;
      }
    }
    label76:
    for (paramInt1 = 4;; paramInt1 = 0)
    {
      paramView.setVisibility(paramInt1);
      this.a.invalidate();
      return;
      f = (this.a.getWidth() - paramInt1) / paramInt2;
      break;
    }
  }
  
  public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
  {
    paramFloat2 = this.a.d(paramView);
    int k = paramView.getWidth();
    int i;
    if (this.a.a(paramView, 3)) {
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {
        i = 0;
      }
    }
    for (;;)
    {
      this.c.settleCapturedViewAt(i, paramView.getTop());
      this.a.invalidate();
      return;
      i = -k;
      continue;
      int j = this.a.getWidth();
      if (paramFloat1 >= 0.0F)
      {
        i = j;
        if (paramFloat1 == 0.0F)
        {
          i = j;
          if (paramFloat2 <= 0.5F) {}
        }
      }
      else
      {
        i = j - k;
      }
    }
  }
  
  public boolean tryCaptureView(View paramView, int paramInt)
  {
    return (this.a.g(paramView)) && (this.a.a(paramView, this.b)) && (this.a.a(paramView) == 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/sidebar/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */