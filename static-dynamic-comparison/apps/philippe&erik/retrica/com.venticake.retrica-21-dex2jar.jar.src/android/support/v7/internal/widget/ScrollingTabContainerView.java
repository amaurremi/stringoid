package android.support.v7.internal.widget;

import android.content.res.Configuration;
import android.support.v7.a.e;
import android.support.v7.b.c;
import android.support.v7.b.h;
import android.support.v7.internal.view.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ScrollingTabContainerView
  extends HorizontalScrollView
  implements n
{
  Runnable a;
  int b;
  int c;
  private ab d;
  private LinearLayout e;
  private ac f;
  private boolean g;
  private final LayoutInflater h;
  private int i;
  private int j;
  
  private ScrollingTabContainerView.TabView a(e parame, boolean paramBoolean)
  {
    ScrollingTabContainerView.TabView localTabView = (ScrollingTabContainerView.TabView)this.h.inflate(h.abc_action_bar_tab, this.e, false);
    localTabView.a(this, parame, paramBoolean);
    if (paramBoolean)
    {
      localTabView.setBackgroundDrawable(null);
      localTabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.i));
      return localTabView;
    }
    localTabView.setFocusable(true);
    if (this.d == null) {
      this.d = new ab(this, null);
    }
    localTabView.setOnClickListener(this.d);
    return localTabView;
  }
  
  private boolean a()
  {
    return (this.f != null) && (this.f.getParent() == this);
  }
  
  private void b()
  {
    if (a()) {
      return;
    }
    if (this.f == null) {
      this.f = d();
    }
    removeView(this.e);
    addView(this.f, new ViewGroup.LayoutParams(-2, -1));
    if (this.f.d() == null) {
      this.f.a(new aa(this, null));
    }
    if (this.a != null)
    {
      removeCallbacks(this.a);
      this.a = null;
    }
    this.f.a(this.j);
  }
  
  private boolean c()
  {
    if (!a()) {
      return false;
    }
    removeView(this.f);
    addView(this.e, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.f.f());
    return false;
  }
  
  private ac d()
  {
    ac localac = new ac(getContext(), null, c.actionDropDownStyle);
    localac.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    localac.b(this);
    return localac;
  }
  
  public void a(int paramInt)
  {
    final View localView = this.e.getChildAt(paramInt);
    if (this.a != null) {
      removeCallbacks(this.a);
    }
    this.a = new Runnable()
    {
      public void run()
      {
        int i = localView.getLeft();
        int j = (ScrollingTabContainerView.this.getWidth() - localView.getWidth()) / 2;
        ScrollingTabContainerView.this.smoothScrollTo(i - j, 0);
        ScrollingTabContainerView.this.a = null;
      }
    };
    post(this.a);
  }
  
  public void a(l<?> paraml, View paramView, int paramInt, long paramLong)
  {
    ((ScrollingTabContainerView.TabView)paramView).getTab().d();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.a != null) {
      post(this.a);
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    paramConfiguration = a.a(getContext());
    setContentHeight(paramConfiguration.e());
    this.c = paramConfiguration.g();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.a != null) {
      removeCallbacks(this.a);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    int k = View.MeasureSpec.getMode(paramInt1);
    boolean bool;
    if (k == 1073741824)
    {
      bool = true;
      setFillViewport(bool);
      int m = this.e.getChildCount();
      if ((m <= 1) || ((k != 1073741824) && (k != Integer.MIN_VALUE))) {
        break label190;
      }
      if (m <= 2) {
        break label177;
      }
      this.b = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      label68:
      this.b = Math.min(this.b, this.c);
      label83:
      k = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
      if ((bool) || (!this.g)) {
        break label198;
      }
      label105:
      if (paramInt2 == 0) {
        break label211;
      }
      this.e.measure(0, k);
      if (this.e.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label203;
      }
      b();
    }
    for (;;)
    {
      paramInt2 = getMeasuredWidth();
      super.onMeasure(paramInt1, k);
      paramInt1 = getMeasuredWidth();
      if ((bool) && (paramInt2 != paramInt1)) {
        setTabSelected(this.j);
      }
      return;
      bool = false;
      break;
      label177:
      this.b = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label68;
      label190:
      this.b = -1;
      break label83;
      label198:
      paramInt2 = 0;
      break label105;
      label203:
      c();
      continue;
      label211:
      c();
    }
  }
  
  public void setAllowCollapse(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.i = paramInt;
    requestLayout();
  }
  
  public void setTabSelected(int paramInt)
  {
    this.j = paramInt;
    int m = this.e.getChildCount();
    int k = 0;
    if (k < m)
    {
      View localView = this.e.getChildAt(k);
      if (k == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool) {
          a(paramInt);
        }
        k += 1;
        break;
      }
    }
    if ((this.f != null) && (paramInt >= 0)) {
      this.f.a(paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/ScrollingTabContainerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */