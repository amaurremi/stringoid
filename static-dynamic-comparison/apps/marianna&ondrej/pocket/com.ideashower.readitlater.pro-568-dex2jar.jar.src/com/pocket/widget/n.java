package com.pocket.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ListView;
import com.b.c.c;

public class n
  extends ViewGroup
{
  private static final Interpolator f = new DecelerateInterpolator(4.0F);
  private int A;
  private VelocityTracker B;
  private boolean C;
  private int D;
  private Interpolator E;
  private long F;
  private c G;
  private o H;
  private p I;
  private q J;
  protected int a;
  protected int b;
  protected int c;
  protected boolean d;
  protected float e;
  private final int g;
  private final Rect h = new Rect();
  private final Rect i = new Rect();
  private final int j;
  private final int k;
  private final int l;
  private final int m;
  private final int n;
  private final int o;
  private final int p;
  private final boolean q;
  private final boolean r;
  private View s;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private int y;
  private int z;
  
  public n(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.c = (-paramInt2);
    this.a = paramInt1;
    this.q = true;
    this.r = true;
    this.g = paramView.getId();
    this.s = paramView;
    addView(paramView);
    float f1 = getResources().getDisplayMetrics().density;
    this.j = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.l = ((int)(120.0F * f1 + 0.5F));
    this.m = ((int)(150.0F * f1 + 0.5F));
    this.n = ((int)(200.0F * f1 + 0.5F));
    this.o = ((int)(2000.0F * f1 + 0.5F));
    this.p = ((int)(f1 * 1000.0F + 0.5F));
    this.k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    setAlwaysDrawnWithCacheEnabled(false);
  }
  
  private void a()
  {
    this.w = false;
    if (this.J != null) {
      this.J.b();
    }
    if (this.B != null)
    {
      this.B.recycle();
      this.B = null;
    }
  }
  
  private void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    float f1;
    if (this.x) {
      if ((paramBoolean) || (paramFloat > this.n) || ((paramInt > getDrawerTop() + this.y) && (paramFloat > -this.n)))
      {
        f1 = this.o;
        if (paramFloat < 0.0F) {
          f1 = 0.0F;
        }
        this.t = true;
        a();
        if (f1 >= 0.0F) {
          break label181;
        }
      }
    }
    label181:
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramInt, paramBoolean, paramFloat);
      return;
      f1 = -this.o;
      if (paramFloat <= 0.0F) {
        break;
      }
      f1 = 0.0F;
      break;
      if ((!paramBoolean) && ((paramFloat > this.n) || ((paramInt > getHeight() / 2) && (paramFloat > -this.n))))
      {
        f1 = this.o;
        if (paramFloat >= 0.0F) {
          break;
        }
        f1 = 0.0F;
        break;
      }
      f1 = -this.o;
      if (paramFloat <= 0.0F) {
        break;
      }
      f1 = 0.0F;
      break;
    }
  }
  
  private void a(final int paramInt, final boolean paramBoolean, final float paramFloat)
  {
    boolean bool;
    label20:
    Object localObject;
    if (this.D != 0)
    {
      paramFloat = this.D;
      if (paramBoolean) {
        break label132;
      }
      bool = true;
      this.v = bool;
      this.H = new o(paramInt, paramFloat)
      {
        public void a(com.b.a.a paramAnonymousa)
        {
          if (b()) {
            return;
          }
          n.a(n.this, false);
          n.a(n.this, null);
          n.a(n.this, null);
          if (paramBoolean) {
            n.this.c();
          }
          for (;;)
          {
            n.this.invalidate();
            return;
            n.this.d();
          }
        }
        
        public void b(com.b.a.a paramAnonymousa) {}
        
        public void c(com.b.a.a paramAnonymousa) {}
        
        public void d(com.b.a.a paramAnonymousa)
        {
          a();
        }
      };
      c localc = c.a(this.s);
      if (this.E == null) {
        break label138;
      }
      localObject = this.E;
      label63:
      localObject = localc.a((Interpolator)localObject);
      if (this.F <= 0L) {
        break label146;
      }
    }
    label132:
    label138:
    label146:
    for (long l1 = this.F;; l1 = 520L)
    {
      this.G = ((c)localObject).a(l1).c(paramFloat).a(this.H);
      return;
      if (paramBoolean) {}
      for (paramFloat = getDrawerTop();; paramFloat = getBottomLocation()) {
        break;
      }
      bool = false;
      break label20;
      localObject = f;
      break label63;
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat1 > getWidth())) {}
    while ((paramFloat2 < getDrawerTop()) || (paramFloat2 > getHeight()) || (paramFloat2 <= com.b.c.a.c(this.s))) {
      return false;
    }
    return true;
  }
  
  private boolean a(int paramInt)
  {
    if (this.x) {
      if (paramInt >= this.j + getDrawerTop()) {}
    }
    while (paramInt > getBottomLocation() - this.j)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    d(paramInt);
    a(paramInt, this.o, true);
  }
  
  private void c(int paramInt)
  {
    d(paramInt);
    a(paramInt, -this.o, true);
  }
  
  private void d(int paramInt)
  {
    setContentScrollbarsEnabled(false);
    if (this.t)
    {
      this.t = false;
      if (this.G != null)
      {
        this.G.a();
        this.H.a();
        this.G = null;
        this.H = null;
      }
    }
    this.w = true;
    this.B = VelocityTracker.obtain();
    e(paramInt);
    if (this.I != null) {
      this.I.k();
    }
  }
  
  private void e(int paramInt)
  {
    View localView = this.s;
    int i3 = getDrawerTop();
    int i1;
    int i2;
    if (this.u)
    {
      i1 = getBottom();
      i2 = 0;
      if (paramInt != 55535) {
        break label99;
      }
      i2 = 1;
      paramInt = i3;
    }
    label38:
    label99:
    label128:
    label131:
    for (;;)
    {
      if (paramInt < i3) {
        paramInt = i3;
      }
      for (;;)
      {
        com.b.c.a.g(localView, paramInt);
        if (i2 != 0)
        {
          Rect localRect1 = this.h;
          Rect localRect2 = this.i;
          localView.getHitRect(localRect1);
          localRect2.set(localRect1);
          invalidate(localRect2);
          return;
          i1 = getBottomLocation();
          break;
          if (paramInt != 55534) {
            break label131;
          }
          i2 = 1;
          paramInt = i1;
          break label38;
          if (paramInt <= i1) {
            break label128;
          }
          paramInt = i1;
          continue;
        }
        invalidate();
        return;
      }
    }
  }
  
  private void setContentScrollbarsEnabled(boolean paramBoolean)
  {
    this.s.setVerticalScrollBarEnabled(paramBoolean);
  }
  
  public c a(boolean paramBoolean1, long paramLong, Interpolator paramInterpolator, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      this.u = true;
    }
    setInterpolator(paramInterpolator);
    setAnimationDuration(paramLong);
    if (paramBoolean1)
    {
      this.D = 0;
      if (paramBoolean2) {
        o();
      }
    }
    for (;;)
    {
      if (paramBoolean1) {
        this.u = false;
      }
      setInterpolator(null);
      setAnimationDuration(0L);
      return null;
      n();
      continue;
      this.D = getBottom();
      n();
    }
  }
  
  protected void c()
  {
    e(55535);
    setContentScrollbarsEnabled(true);
    if (this.x) {}
    do
    {
      return;
      this.x = true;
    } while (this.I == null);
    this.I.l();
  }
  
  protected void d()
  {
    e(55534);
    this.s.destroyDrawingCache();
    setContentScrollbarsEnabled(false);
    if (!this.x) {}
    do
    {
      return;
      this.x = false;
    } while (this.I == null);
    this.I.m();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    long l1 = getDrawingTime();
    drawChild(paramCanvas, this.s, l1);
  }
  
  public void e()
  {
    this.d = true;
  }
  
  public void f()
  {
    this.d = false;
  }
  
  public boolean g()
  {
    return this.x;
  }
  
  protected int getBottomLocation()
  {
    return this.c + getBottom() - getTop();
  }
  
  public View getContent()
  {
    return this.s;
  }
  
  protected int getDrawerTop()
  {
    if (this.r) {
      return this.b;
    }
    return this.a;
  }
  
  public boolean h()
  {
    return (this.w) || (this.t);
  }
  
  public boolean i()
  {
    return (this.u) || (!g()) || ((this.G != null) && (this.v));
  }
  
  public boolean j()
  {
    return (this.u) && (!g());
  }
  
  public void k()
  {
    if (!this.x)
    {
      o();
      return;
    }
    n();
  }
  
  public void l()
  {
    d();
    invalidate();
    requestLayout();
  }
  
  public void m()
  {
    this.u = true;
    d();
    invalidate();
    requestLayout();
  }
  
  public void n()
  {
    q localq = this.J;
    if (localq != null) {
      localq.a();
    }
    b((int)com.b.c.a.c(this.s));
    if (localq != null) {
      localq.b();
    }
  }
  
  public void o()
  {
    q localq = this.J;
    if (localq != null) {
      localq.a();
    }
    c((int)com.b.c.a.c(this.s));
    sendAccessibilityEvent(32);
    if (localq != null) {
      localq.b();
    }
  }
  
  protected void onFinishInflate()
  {
    if (getChildCount() != 1) {
      throw new IllegalArgumentException("There may only be one child view. It cannot be empty or contain multiple children.");
    }
    if (this.s != null)
    {
      this.s = findViewById(this.g);
      if (this.s == null) {
        throw new IllegalArgumentException("The content attribute is must refer to an existing child.");
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.d) {}
    int i1;
    float f1;
    float f2;
    do
    {
      do
      {
        return false;
        i1 = paramMotionEvent.getAction();
      } while ((this.C) && (i1 != 0));
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
    } while ((!this.w) && (!a(f1, f2)));
    if (this.w) {
      return true;
    }
    switch (i1)
    {
    }
    for (;;)
    {
      label92:
      i1 = 0;
      while (i1 != 0)
      {
        this.w = true;
        if (this.J != null) {
          this.J.a();
        }
        i1 = (int)com.b.c.a.c(this.s);
        this.A = ((int)this.e - i1);
        d(i1);
        this.B.addMovement(paramMotionEvent);
        return true;
        this.C = false;
        this.e = f2;
        if ((!this.x) || (this.t))
        {
          i1 = 1;
        }
        else
        {
          if (p()) {
            break label92;
          }
          this.C = true;
          i1 = 0;
          continue;
          f1 = f2 - this.e;
          if (Math.abs(f1) < this.k) {
            break label92;
          }
          if (f1 <= 0.0F) {
            break label239;
          }
          i1 = 1;
        }
      }
      label239:
      this.C = true;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() != 1) {
      throw new IllegalArgumentException("There may only be one child view.");
    }
    if (this.w)
    {
      if (paramBoolean) {
        a((int)com.b.c.a.c(this.s), 0.0F, true);
      }
    }
    else
    {
      View localView = this.s;
      paramInt1 = localView.getMeasuredWidth();
      paramInt2 = localView.getMeasuredHeight();
      paramInt3 = getPaddingLeft();
      paramInt4 = getDrawerTop();
      localView.layout(paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
      this.y = localView.getHeight();
      this.z = localView.getWidth();
      if (!this.t) {
        if (!this.x) {
          break label133;
        }
      }
    }
    label133:
    for (paramInt1 = 55535;; paramInt1 = 55534)
    {
      e(paramInt1);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = 1073741824;
    int i3 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if ((i3 == 0) || (paramInt1 == 0)) {
      throw new RuntimeException("SlidingDrawer cannot have UNSPECIFIED dimensions");
    }
    i3 = this.a;
    View localView = this.s;
    int i4 = View.MeasureSpec.makeMeasureSpec(i2 - getPaddingLeft() - getPaddingRight(), 1073741824);
    paramInt1 = i1;
    if (this.r) {
      paramInt1 = Integer.MIN_VALUE;
    }
    localView.measure(i4, View.MeasureSpec.makeMeasureSpec(paramInt2 - i3, paramInt1));
    if (this.r) {}
    for (paramInt1 = paramInt2 - this.s.getMeasuredHeight();; paramInt1 = 0)
    {
      this.b = paramInt1;
      setMeasuredDimension(i2, paramInt2);
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.d) {
      return false;
    }
    if (this.w) {
      this.B.addMovement(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      if ((!this.w) && (!super.onTouchEvent(paramMotionEvent))) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      e((int)paramMotionEvent.getY() - this.A);
      break;
      VelocityTracker localVelocityTracker = this.B;
      localVelocityTracker.computeCurrentVelocity(this.p);
      float f3 = localVelocityTracker.getYVelocity();
      float f2 = localVelocityTracker.getXVelocity();
      if (f3 < 0.0F) {}
      float f1;
      for (int i1 = 1;; i1 = 0)
      {
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = -f2;
        }
        f2 = f1;
        if (f1 > this.m) {
          f2 = this.m;
        }
        f2 = (float)Math.hypot(f2, f3);
        f1 = f2;
        if (i1 != 0) {
          f1 = -f2;
        }
        i1 = (int)com.b.c.a.c(this.s);
        if (Math.abs(f1) >= this.l) {
          break label278;
        }
        if (!a(i1)) {
          break label267;
        }
        if (!this.q) {
          break label256;
        }
        playSoundEffect(0);
        if (!this.x) {
          break label247;
        }
        b(i1);
        break;
      }
      label247:
      c(i1);
      break;
      label256:
      a(i1, f1, false);
      break;
      label267:
      a(i1, f1, false);
      break;
      label278:
      a(i1, f1, false);
      break;
    }
  }
  
  protected boolean p()
  {
    boolean bool = true;
    if ((this.s instanceof ListView))
    {
      ListView localListView = (ListView)this.s;
      if (localListView.getFirstVisiblePosition() == 0) {
        return localListView.getChildAt(0).getTop() - this.s.getPaddingTop() >= 0;
      }
      return false;
    }
    if (this.s.getScrollY() > 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void setAnimationDuration(long paramLong)
  {
    this.F = paramLong;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.E = paramInterpolator;
  }
  
  public void setOnDrawerOpenListener(p paramp)
  {
    this.I = paramp;
  }
  
  public void setOnDrawerScrollListener(q paramq)
  {
    this.J = paramq;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */