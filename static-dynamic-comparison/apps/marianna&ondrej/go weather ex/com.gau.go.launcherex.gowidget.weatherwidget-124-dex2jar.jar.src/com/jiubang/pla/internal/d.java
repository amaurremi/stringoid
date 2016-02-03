package com.jiubang.pla.internal;

import android.widget.Scroller;

class d
  implements Runnable
{
  private final Scroller b;
  private int c;
  
  d(PLA_AbsListView paramPLA_AbsListView)
  {
    this.b = new Scroller(paramPLA_AbsListView.getContext());
  }
  
  private void a()
  {
    this.c = 0;
    this.a.t = -1;
    this.a.a(0);
    PLA_AbsListView.c(this.a);
    this.a.removeCallbacks(this);
    if (PLA_AbsListView.d(this.a) != null) {
      this.a.removeCallbacks(PLA_AbsListView.d(this.a));
    }
    this.b.forceFinished(true);
  }
  
  void a(int paramInt)
  {
    int i = this.a.h(paramInt);
    if (i < 0) {}
    for (paramInt = Integer.MAX_VALUE;; paramInt = 0)
    {
      this.c = paramInt;
      this.b.fling(0, paramInt, 0, i, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
      this.a.t = 4;
      this.a.post(this);
      return;
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (int i = Integer.MAX_VALUE;; i = 0)
    {
      this.c = i;
      this.b.startScroll(0, i, 0, paramInt1, paramInt2);
      this.a.t = 4;
      this.a.post(this);
      return;
    }
  }
  
  public void run()
  {
    switch (this.a.t)
    {
    default: 
      return;
    }
    if ((this.a.M == 0) || (this.a.getChildCount() == 0))
    {
      a();
      return;
    }
    Scroller localScroller = this.b;
    boolean bool1 = localScroller.computeScrollOffset();
    int j = localScroller.getCurrY();
    int i = this.c - j;
    if (i > 0)
    {
      this.a.o = this.a.B;
      this.a.p = this.a.o();
    }
    for (i = Math.min(this.a.getHeight() - this.a.getPaddingBottom() - this.a.getPaddingTop() - 1, i);; i = Math.max(-(this.a.getHeight() - this.a.getPaddingBottom() - this.a.getPaddingTop() - 1), i))
    {
      boolean bool2 = this.a.c(i, i);
      if ((!bool1) || (bool2)) {
        break;
      }
      this.a.invalidate();
      this.c = j;
      this.a.post(this);
      return;
      int k = this.a.getChildCount();
      this.a.o = (k - 1 + this.a.B);
      this.a.p = this.a.r();
    }
    a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/pla/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */