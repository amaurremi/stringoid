package com.jiubang.pla.listview;

import android.view.View;

class b
{
  private int b;
  private int c;
  private int d;
  private int e = 0;
  private int f = 0;
  
  public b(MultiColumnListView paramMultiColumnListView, int paramInt)
  {
    this.b = paramInt;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    int j = this.a.getChildCount();
    int i = 0;
    label15:
    View localView;
    if (i < j)
    {
      localView = this.a.getChildAt(i);
      if ((localView.getLeft() == this.d) || (this.a.d(localView))) {
        break label61;
      }
    }
    for (;;)
    {
      i += 1;
      break label15;
      break;
      label61:
      localView.offsetTopAndBottom(paramInt);
    }
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public int d()
  {
    int m = this.a.getChildCount();
    int j = 0;
    int i = Integer.MIN_VALUE;
    if (j < m)
    {
      View localView = this.a.getChildAt(j);
      int k;
      if ((localView.getLeft() != this.d) && (!this.a.d(localView))) {
        k = i;
      }
      for (;;)
      {
        j += 1;
        i = k;
        break;
        k = i;
        if (i < localView.getBottom()) {
          k = localView.getBottom();
        }
      }
    }
    j = i;
    if (i == Integer.MIN_VALUE) {
      j = this.f;
    }
    return j;
  }
  
  public int e()
  {
    int m = this.a.getChildCount();
    int j = 0;
    int i = Integer.MAX_VALUE;
    if (j < m)
    {
      View localView = this.a.getChildAt(j);
      int k;
      if ((localView.getLeft() != this.d) && (!this.a.d(localView))) {
        k = i;
      }
      for (;;)
      {
        j += 1;
        i = k;
        break;
        k = i;
        if (i > localView.getTop()) {
          k = localView.getTop();
        }
      }
    }
    j = i;
    if (i == Integer.MAX_VALUE) {
      j = this.e;
    }
    return j;
  }
  
  public void f()
  {
    this.e = 0;
    this.f = e();
  }
  
  public void g()
  {
    this.e = 0;
    this.f = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/pla/listview/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */