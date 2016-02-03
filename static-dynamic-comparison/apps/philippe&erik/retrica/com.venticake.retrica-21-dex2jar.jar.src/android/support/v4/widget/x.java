package android.support.v4.widget;

import android.view.View;

class x
  extends af
{
  private x(SlidingPaneLayout paramSlidingPaneLayout) {}
  
  public int a(View paramView)
  {
    return SlidingPaneLayout.e(this.a);
  }
  
  public int a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = (y)SlidingPaneLayout.d(this.a).getLayoutParams();
    paramInt2 = this.a.getPaddingLeft();
    paramInt2 = paramView.leftMargin + paramInt2;
    int i = SlidingPaneLayout.e(this.a);
    return Math.min(Math.max(paramInt1, paramInt2), i + paramInt2);
  }
  
  public void a(int paramInt)
  {
    if (SlidingPaneLayout.b(this.a).a() == 0)
    {
      if (SlidingPaneLayout.c(this.a) == 0.0F)
      {
        this.a.d(SlidingPaneLayout.d(this.a));
        this.a.c(SlidingPaneLayout.d(this.a));
        SlidingPaneLayout.a(this.a, false);
      }
    }
    else {
      return;
    }
    this.a.b(SlidingPaneLayout.d(this.a));
    SlidingPaneLayout.a(this.a, true);
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    y localy = (y)paramView.getLayoutParams();
    int i = this.a.getPaddingLeft();
    int j = localy.leftMargin + i;
    if (paramFloat1 <= 0.0F)
    {
      i = j;
      if (paramFloat1 == 0.0F)
      {
        i = j;
        if (SlidingPaneLayout.c(this.a) <= 0.5F) {}
      }
    }
    else
    {
      i = j + SlidingPaneLayout.e(this.a);
    }
    SlidingPaneLayout.b(this.a).a(i, paramView.getTop());
    this.a.invalidate();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SlidingPaneLayout.a(this.a, paramInt1);
    this.a.invalidate();
  }
  
  public boolean a(View paramView, int paramInt)
  {
    if (SlidingPaneLayout.a(this.a)) {
      return false;
    }
    return ((y)paramView.getLayoutParams()).b;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    SlidingPaneLayout.b(this.a).a(SlidingPaneLayout.d(this.a), paramInt2);
  }
  
  public void b(View paramView, int paramInt)
  {
    this.a.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/widget/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */