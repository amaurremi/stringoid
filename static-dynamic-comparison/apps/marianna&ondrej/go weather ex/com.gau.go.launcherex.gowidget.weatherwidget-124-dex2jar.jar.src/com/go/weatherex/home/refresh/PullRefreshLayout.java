package com.go.weatherex.home.refresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;

public class PullRefreshLayout
  extends LinearLayout
{
  private static final int[] q = { 16842766 };
  private final Runnable A = new j(this);
  private boolean B;
  private boolean C;
  private int D = -1;
  private float E;
  private float F;
  private a a;
  private View b;
  private int c;
  private k d;
  private int e;
  private boolean f = false;
  private int g;
  private float h = -1.0F;
  private int i;
  private int j;
  private float k = 0.0F;
  private float l = 0.0F;
  private volatile int m;
  private boolean n;
  private boolean o;
  private final DecelerateInterpolator p = new DecelerateInterpolator();
  private int r = 0;
  private final Animation s = new b(this);
  private final Animation t = new c(this);
  private Animation u = new d(this);
  private final Animation.AnimationListener v = new e(this);
  private final Animation.AnimationListener w = new f(this);
  private final Animation.AnimationListener x = new g(this);
  private final Runnable y = new h(this);
  private final Runnable z = new i(this);
  
  public PullRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.i = getResources().getInteger(17694721);
    this.j = getResources().getInteger(17694720);
    this.r = getResources().getDimensionPixelSize(2131427555);
    setWillNotDraw(false);
    this.a = new l(this);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, q);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  private void a(float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      this.l = 0.0F;
      return;
    }
    paramFloat = Math.max(0.0F, Math.min(paramFloat, 1.0F));
    this.l = paramFloat;
    this.a.a(paramFloat);
  }
  
  private void a(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    b(i1 - this.m);
  }
  
  private void a(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.e = paramInt;
    this.s.reset();
    this.s.setDuration(this.i);
    this.s.setAnimationListener(paramAnimationListener);
    this.s.setInterpolator(this.p);
    this.b.startAnimation(this.s);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (this.f != paramBoolean)
    {
      c();
      this.l = 0.0F;
      this.f = paramBoolean;
      if (this.f)
      {
        this.a.a();
        removeCallbacks(this.z);
        post(this.z);
      }
    }
    else
    {
      return;
    }
    this.a.a(paramString);
    removeCallbacks(this.A);
    postDelayed(this.A, this.a.b());
  }
  
  private void b(int paramInt)
  {
    this.b.offsetTopAndBottom(paramInt);
    this.m = this.b.getTop();
  }
  
  private void b(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.e = paramInt;
    this.t.reset();
    this.t.setDuration(this.j);
    this.t.setAnimationListener(this.w);
    this.t.setInterpolator(this.p);
    this.b.startAnimation(this.t);
  }
  
  private void c()
  {
    if (this.b == null)
    {
      if ((getChildCount() > 1) && (!isInEditMode())) {
        throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
      }
      this.b = getChildAt(0);
      this.c = (this.b.getTop() + getPaddingTop());
    }
    if ((this.h == -1.0F) && (getParent() != null) && (((View)getParent()).getHeight() > 0)) {
      this.h = ((int)Math.min(((View)getParent()).getHeight() * 0.6F, this.a.c()));
    }
  }
  
  public void a()
  {
    a(true, "");
    this.d.c();
  }
  
  public void a(k paramk)
  {
    this.d = paramk;
  }
  
  public void a(String paramString)
  {
    this.a.b(paramString);
  }
  
  public boolean a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    while ((paramInt1 < paramView.getLeft()) || (paramInt1 >= paramView.getRight()) || (paramInt2 < paramView.getTop()) || (paramInt2 >= paramView.getBottom())) {
      return false;
    }
    return true;
  }
  
  @SuppressLint({"NewApi"})
  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof AbsListView))
    {
      paramView = (AbsListView)paramView;
      return (paramView.getChildCount() > 0) && ((paramView.getFirstVisiblePosition() > 0) || (paramView.getChildAt(0).getTop() < paramView.getPaddingTop()));
    }
    if ((paramView instanceof ViewGroup))
    {
      if (paramView.getScrollY() > 0) {
        return true;
      }
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i2 = localViewGroup.getChildCount();
      int i1 = paramInt2 + paramView.getScrollX();
      paramInt3 += paramView.getScrollY();
      paramInt2 = i2 - 1;
      while (paramInt2 >= 0)
      {
        View localView = localViewGroup.getChildAt(paramInt2);
        if ((localView.getVisibility() == 0) && (a(localView, i1, paramInt3)) && (a(localView, true, paramInt1, i1 - localView.getLeft(), paramInt3 - localView.getTop()))) {
          return true;
        }
        paramInt2 -= 1;
      }
    }
    return (paramBoolean) && (ViewCompat.canScrollVertically(paramView, -paramInt1));
  }
  
  public void b()
  {
    a(false, "");
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      paramCanvas.save();
      paramCanvas.clipRect(0, 0, getWidth(), this.m);
      paramCanvas.drawColor(1610612736);
      this.a.a(paramCanvas);
      paramCanvas.restore();
    }
    paramCanvas.save();
    paramCanvas.clipRect(0, this.m, getWidth(), getHeight());
    super.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    removeCallbacks(this.A);
    removeCallbacks(this.y);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.y);
    removeCallbacks(this.A);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i1 = paramMotionEvent.getAction() & 0xFF;
    c();
    boolean bool1;
    if (this.o) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            if (i1 == 0) {
              break;
            }
            if (this.B) {
              return true;
            }
            bool1 = bool2;
          } while (!isEnabled());
          bool1 = bool2;
        } while (this.n);
        bool1 = bool2;
      } while (this.C);
      bool1 = bool2;
    } while (this.F < this.r);
    switch (i1)
    {
    }
    for (;;)
    {
      return this.B;
      this.E = paramMotionEvent.getX();
      this.F = paramMotionEvent.getY();
      this.D = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      this.l = 0.0F;
      this.B = false;
      this.C = false;
      continue;
      if ((this.D != -1) && (!this.n))
      {
        float f1 = MotionEventCompat.getX(paramMotionEvent, 0);
        float f2 = Math.abs(f1 - this.E);
        float f3 = MotionEventCompat.getY(paramMotionEvent, 0);
        float f4 = f3 - this.F;
        float f5 = Math.abs(f4);
        if ((f4 != 0.0F) && (a(this, false, (int)f4, (int)f1, (int)f3)))
        {
          this.C = true;
          return false;
        }
        if ((f4 > this.g) && (f5 > f2))
        {
          this.B = true;
          requestDisallowInterceptTouchEvent(true);
          if (this.d != null) {
            this.d.d();
          }
        }
        else if (f2 > this.g)
        {
          this.C = true;
          continue;
          this.B = false;
          this.C = false;
          this.D = -1;
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() == 0) {
      return;
    }
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    View localView = getChildAt(0);
    paramInt3 = getPaddingLeft();
    paramInt4 = this.m + getPaddingTop();
    localView.layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getChildCount();
    if ((paramInt1 > 1) && (!isInEditMode())) {
      throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
    }
    if (paramInt1 > 0) {
      getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!isEnabled()) || (this.n)) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if ((!this.o) && (this.B))
      {
        float f1 = (paramMotionEvent.getY() - this.F) / 3.0F;
        a((int)f1);
        a(f1 / this.h);
        continue;
        this.B = false;
        this.C = false;
        clearAnimation();
        removeCallbacks(this.y);
        removeCallbacks(this.z);
        if (this.o)
        {
          this.D = -1;
          post(this.y);
        }
        else if (this.f)
        {
          if (this.o) {
            post(this.A);
          } else {
            post(this.z);
          }
        }
        else if (this.b.getTop() > this.h)
        {
          a();
        }
        else
        {
          post(this.A);
        }
      }
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/refresh/PullRefreshLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */