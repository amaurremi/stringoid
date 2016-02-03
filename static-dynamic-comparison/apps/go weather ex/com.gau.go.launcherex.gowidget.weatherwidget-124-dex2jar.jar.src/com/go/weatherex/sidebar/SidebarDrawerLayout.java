package com.go.weatherex.sidebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.gtp.a.a.b.c;

public class SidebarDrawerLayout
  extends ViewGroup
{
  private static final int[] a = { 16842931 };
  private boolean A = false;
  private final h B = new f(this);
  private int b;
  private int c = -1728053248;
  private float d;
  private Paint e = new Paint();
  private final ViewDragHelper f;
  private final ViewDragHelper g;
  private final j h;
  private final j i;
  private int j;
  private boolean k;
  private boolean l = true;
  private int m;
  private int n;
  private boolean o;
  private boolean p;
  private h q;
  private float r;
  private float s;
  private Drawable t;
  private Drawable u;
  private CharSequence v;
  private CharSequence w;
  private boolean x = false;
  private a y;
  private Rect z = null;
  
  public SidebarDrawerLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SidebarDrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SidebarDrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f1 = getResources().getDisplayMetrics().density;
    this.b = ((int)(64.0F * f1 + 0.5F));
    f1 *= 400.0F;
    this.h = new j(this, 3);
    this.i = new j(this, 5);
    this.f = ViewDragHelper.create(this, 1.0F, this.h);
    this.f.setEdgeTrackingEnabled(1);
    this.f.setMinVelocity(f1);
    this.h.a(this.f);
    this.g = ViewDragHelper.create(this, 1.0F, this.i);
    this.g.setEdgeTrackingEnabled(2);
    this.g.setMinVelocity(f1);
    this.i.a(this.g);
    setFocusableInTouchMode(true);
    ViewCompat.setAccessibilityDelegate(this, new g(this));
    ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    c.a("SidebarDrawerLayout", "shouldIgnoreTouchEvent: " + paramMotionEvent.getX() + "--" + paramMotionEvent.getY());
    if (this.z == null) {
      return false;
    }
    c.a("SidebarDrawerLayout", "shouldIgnoreTouchEvent: " + this.z.toShortString());
    return this.z.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }
  
  static String e(int paramInt)
  {
    if ((paramInt & 0x3) == 3) {
      return "LEFT";
    }
    if ((paramInt & 0x5) == 5) {
      return "RIGHT";
    }
    return Integer.toHexString(paramInt);
  }
  
  private boolean e()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((SidebarDrawerLayout.LayoutParams)getChildAt(i1).getLayoutParams()).c) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private boolean f()
  {
    return g() != null;
  }
  
  private View g()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if ((g(localView)) && (k(localView))) {
        return localView;
      }
      i1 += 1;
    }
    return null;
  }
  
  private static boolean l(View paramView)
  {
    boolean bool2 = false;
    paramView = paramView.getBackground();
    boolean bool1 = bool2;
    if (paramView != null)
    {
      bool1 = bool2;
      if (paramView.getOpacity() == -1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int a(View paramView)
  {
    int i1 = e(paramView);
    if (i1 == 3) {
      return this.m;
    }
    if (i1 == 5) {
      return this.n;
    }
    return 0;
  }
  
  View a()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (((SidebarDrawerLayout.LayoutParams)localView.getLayoutParams()).d) {
        return localView;
      }
      i1 += 1;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
    invalidate();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(getResources().getDrawable(paramInt1), paramInt2);
  }
  
  void a(int paramInt1, int paramInt2, View paramView)
  {
    int i1 = 1;
    int i2 = this.f.getViewDragState();
    int i3 = this.g.getViewDragState();
    paramInt1 = i1;
    SidebarDrawerLayout.LayoutParams localLayoutParams;
    if (i2 != 1)
    {
      if (i3 == 1) {
        paramInt1 = i1;
      }
    }
    else if ((paramView != null) && (paramInt2 == 0))
    {
      localLayoutParams = (SidebarDrawerLayout.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams.b != 0.0F) {
        break label124;
      }
      b(paramView);
    }
    for (;;)
    {
      if (paramInt1 != this.j)
      {
        this.j = paramInt1;
        if (this.q != null) {
          this.q.a(paramInt1);
        }
      }
      return;
      if ((i2 == 2) || (i3 == 2))
      {
        paramInt1 = 2;
        break;
      }
      paramInt1 = 0;
      break;
      label124:
      if (localLayoutParams.b == 1.0F) {
        c(paramView);
      }
    }
  }
  
  public void a(Rect paramRect)
  {
    this.z = paramRect;
  }
  
  public void a(Drawable paramDrawable, int paramInt)
  {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if ((paramInt & 0x3) == 3)
    {
      this.t = paramDrawable;
      invalidate();
    }
    if ((paramInt & 0x5) == 5)
    {
      this.u = paramDrawable;
      invalidate();
    }
  }
  
  void a(View paramView, float paramFloat)
  {
    if (this.q != null) {
      this.q.a(paramView, paramFloat);
    }
  }
  
  public void a(a parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("why null of onSidebarChangeListener?");
    }
    this.y = parama;
    a(this.B);
  }
  
  public void a(h paramh)
  {
    this.q = paramh;
  }
  
  void a(boolean paramBoolean)
  {
    int i5 = getChildCount();
    int i2 = 0;
    int i1 = 0;
    while (i2 < i5)
    {
      View localView = getChildAt(i2);
      SidebarDrawerLayout.LayoutParams localLayoutParams = (SidebarDrawerLayout.LayoutParams)localView.getLayoutParams();
      int i3 = i1;
      if (g(localView))
      {
        if ((paramBoolean) && (!localLayoutParams.c)) {
          i3 = i1;
        }
      }
      else
      {
        i2 += 1;
        i1 = i3;
        continue;
      }
      int i4 = localView.getWidth();
      if (a(localView, 3)) {
        i1 |= this.f.smoothSlideViewTo(localView, -i4, localView.getTop());
      }
      for (;;)
      {
        localLayoutParams.c = false;
        i4 = i1;
        break;
        i1 |= this.g.smoothSlideViewTo(localView, getWidth(), localView.getTop());
      }
    }
    this.h.a();
    this.i.a();
    if (i1 != 0) {
      invalidate();
    }
  }
  
  boolean a(View paramView, int paramInt)
  {
    return (e(paramView) & paramInt) == paramInt;
  }
  
  public int b(int paramInt)
  {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if (paramInt == 3) {
      return this.m;
    }
    if (paramInt == 5) {
      return this.n;
    }
    return 0;
  }
  
  public void b()
  {
    a(false);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    paramInt2 = GravityCompat.getAbsoluteGravity(paramInt2, ViewCompat.getLayoutDirection(this));
    Object localObject;
    if (paramInt2 == 3)
    {
      this.m = paramInt1;
      if (paramInt1 != 0)
      {
        if (paramInt2 != 3) {
          break label74;
        }
        localObject = this.f;
        label33:
        ((ViewDragHelper)localObject).cancel();
      }
      switch (paramInt1)
      {
      }
    }
    label74:
    do
    {
      do
      {
        return;
        if (paramInt2 != 5) {
          break;
        }
        this.n = paramInt1;
        break;
        localObject = this.g;
        break label33;
        localObject = d(paramInt2);
      } while (localObject == null);
      h((View)localObject);
      return;
      localObject = d(paramInt2);
    } while (localObject == null);
    i((View)localObject);
  }
  
  void b(View paramView)
  {
    SidebarDrawerLayout.LayoutParams localLayoutParams = (SidebarDrawerLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.d)
    {
      localLayoutParams.d = false;
      if (this.q != null) {
        this.q.b(paramView);
      }
      if (hasWindowFocus())
      {
        paramView = getRootView();
        if (paramView != null) {
          paramView.sendAccessibilityEvent(32);
        }
      }
    }
  }
  
  void b(View paramView, float paramFloat)
  {
    SidebarDrawerLayout.LayoutParams localLayoutParams = (SidebarDrawerLayout.LayoutParams)paramView.getLayoutParams();
    if (paramFloat == localLayoutParams.b) {
      return;
    }
    localLayoutParams.b = paramFloat;
    a(paramView, paramFloat);
  }
  
  public void b(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public CharSequence c(int paramInt)
  {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if (paramInt == 3) {
      return this.v;
    }
    if (paramInt == 5) {
      return this.w;
    }
    return null;
  }
  
  void c()
  {
    int i1 = 0;
    if (!this.p)
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
      int i2 = getChildCount();
      while (i1 < i2)
      {
        getChildAt(i1).dispatchTouchEvent(localMotionEvent);
        i1 += 1;
      }
      localMotionEvent.recycle();
      this.p = true;
    }
  }
  
  void c(View paramView)
  {
    SidebarDrawerLayout.LayoutParams localLayoutParams = (SidebarDrawerLayout.LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.d)
    {
      localLayoutParams.d = true;
      if (this.q != null) {
        this.q.a(paramView);
      }
      sendAccessibilityEvent(32);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof SidebarDrawerLayout.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    int i2 = getChildCount();
    float f1 = 0.0F;
    int i1 = 0;
    while (i1 < i2)
    {
      f1 = Math.max(f1, ((SidebarDrawerLayout.LayoutParams)getChildAt(i1).getLayoutParams()).b);
      i1 += 1;
    }
    this.d = f1;
    if ((this.f.continueSettling(true) | this.g.continueSettling(true))) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  float d(View paramView)
  {
    return ((SidebarDrawerLayout.LayoutParams)paramView.getLayoutParams()).b;
  }
  
  View d(int paramInt)
  {
    int i1 = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    int i2 = getChildCount();
    paramInt = 0;
    while (paramInt < i2)
    {
      View localView = getChildAt(paramInt);
      if ((e(localView) & 0x7) == (i1 & 0x7)) {
        return localView;
      }
      paramInt += 1;
    }
    return null;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool1 = false;
    int i8 = getHeight();
    boolean bool2 = f(paramView);
    int i2 = 0;
    int i3 = 0;
    int i1 = getWidth();
    int i7 = paramCanvas.save();
    int i4;
    View localView;
    int i5;
    if (bool2)
    {
      int i9 = getChildCount();
      i4 = 0;
      for (;;)
      {
        if (i4 < i9)
        {
          localView = getChildAt(i4);
          if ((localView != paramView) && (localView.getVisibility() == 0) && (l(localView)) && (g(localView)))
          {
            if (localView.getHeight() < i8)
            {
              i5 = i3;
              i2 = i1;
              i4 += 1;
              i1 = i2;
              i3 = i5;
              continue;
            }
            if (a(localView, 3))
            {
              i2 = localView.getRight();
              if (i2 <= i3) {
                break label590;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      i5 = i2;
      i2 = i1;
      break;
      int i6 = localView.getLeft();
      i2 = i6;
      i5 = i3;
      if (i6 < i1) {
        break;
      }
      i2 = i1;
      i5 = i3;
      break;
      if (!this.x) {
        paramCanvas.clipRect(i3, 0, i1, getHeight());
      }
      bool1 = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i7);
      if ((this.d > 0.0F) && (bool2))
      {
        i2 = (int)(((this.c & 0xFF000000) >>> 24) * this.d);
        i4 = this.c;
        this.e.setColor(i2 << 24 | i4 & 0xFFFFFF);
        paramCanvas.drawRect(i3, 0.0F, i1, getHeight(), this.e);
      }
      do
      {
        return bool1;
        if (this.x)
        {
          if (g(paramView))
          {
            paramCanvas.translate(-paramView.getLeft(), 0.0F);
            bool1 = super.drawChild(paramCanvas, paramView, paramLong);
          }
          i3 = i2;
          break;
        }
        bool1 = super.drawChild(paramCanvas, paramView, paramLong);
        i3 = i2;
        break;
        if ((this.t != null) && (a(paramView, 3)))
        {
          i1 = this.t.getIntrinsicWidth();
          i2 = paramView.getRight();
          i3 = this.f.getEdgeSize();
          f1 = Math.max(0.0F, Math.min(i2 / i3, 1.0F));
          this.t.setBounds(i2, paramView.getTop(), i1 + i2, paramView.getBottom());
          this.t.setAlpha((int)(255.0F * f1));
          this.t.draw(paramCanvas);
          return bool1;
        }
      } while ((this.u == null) || (!a(paramView, 5)));
      i1 = this.u.getIntrinsicWidth();
      i2 = paramView.getLeft();
      i3 = getWidth();
      i4 = this.g.getEdgeSize();
      float f1 = Math.max(0.0F, Math.min((i3 - i2) / i4, 1.0F));
      this.u.setBounds(i2 - i1, paramView.getTop(), i2, paramView.getBottom());
      this.u.setAlpha((int)(255.0F * f1));
      this.u.draw(paramCanvas);
      return bool1;
      label590:
      i2 = i3;
    }
  }
  
  int e(View paramView)
  {
    return GravityCompat.getAbsoluteGravity(((SidebarDrawerLayout.LayoutParams)paramView.getLayoutParams()).a, ViewCompat.getLayoutDirection(this));
  }
  
  public void f(int paramInt)
  {
    View localView = d(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("No drawer view found with gravity " + e(paramInt));
    }
    h(localView);
  }
  
  boolean f(View paramView)
  {
    return ((SidebarDrawerLayout.LayoutParams)paramView.getLayoutParams()).a == 0;
  }
  
  public void g(int paramInt)
  {
    View localView = d(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("No drawer view found with gravity " + e(paramInt));
    }
    i(localView);
  }
  
  boolean g(View paramView)
  {
    return (GravityCompat.getAbsoluteGravity(((SidebarDrawerLayout.LayoutParams)paramView.getLayoutParams()).a, ViewCompat.getLayoutDirection(paramView)) & 0x7) != 0;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new SidebarDrawerLayout.LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new SidebarDrawerLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof SidebarDrawerLayout.LayoutParams)) {
      return new SidebarDrawerLayout.LayoutParams((SidebarDrawerLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new SidebarDrawerLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new SidebarDrawerLayout.LayoutParams(paramLayoutParams);
  }
  
  public void h(View paramView)
  {
    if (!g(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    if (this.l)
    {
      paramView = (SidebarDrawerLayout.LayoutParams)paramView.getLayoutParams();
      paramView.b = 1.0F;
      paramView.d = true;
    }
    for (;;)
    {
      invalidate();
      return;
      if (a(paramView, 3)) {
        this.f.smoothSlideViewTo(paramView, 0, paramView.getTop());
      } else {
        this.g.smoothSlideViewTo(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
      }
    }
  }
  
  public boolean h(int paramInt)
  {
    View localView = d(paramInt);
    if (localView != null) {
      return j(localView);
    }
    return false;
  }
  
  public void i(int paramInt)
  {
    this.b = paramInt;
    requestLayout();
  }
  
  public void i(View paramView)
  {
    if (!g(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    if (this.l)
    {
      paramView = (SidebarDrawerLayout.LayoutParams)paramView.getLayoutParams();
      paramView.b = 0.0F;
      paramView.d = false;
    }
    for (;;)
    {
      invalidate();
      return;
      if (a(paramView, 3)) {
        this.f.smoothSlideViewTo(paramView, -paramView.getWidth(), paramView.getTop());
      } else {
        this.g.smoothSlideViewTo(paramView, getWidth(), paramView.getTop());
      }
    }
  }
  
  public boolean j(View paramView)
  {
    if (!g(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    return ((SidebarDrawerLayout.LayoutParams)paramView.getLayoutParams()).d;
  }
  
  public boolean k(View paramView)
  {
    if (!g(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    return ((SidebarDrawerLayout.LayoutParams)paramView.getLayoutParams()).b > 0.0F;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.l = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.l = true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent)) {}
    label79:
    do
    {
      return false;
      i1 = MotionEventCompat.getActionMasked(paramMotionEvent);
      try
      {
        boolean bool1 = this.f.shouldInterceptTouchEvent(paramMotionEvent);
        boolean bool2 = this.g.shouldInterceptTouchEvent(paramMotionEvent);
        i2 = bool1 | bool2;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        for (;;)
        {
          if (c.a()) {
            localIndexOutOfBoundsException.printStackTrace();
          }
          int i2 = 0;
        }
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.r = f1;
        this.s = f2;
        if (this.d <= 0.0F) {
          break label236;
        }
      }
      switch (i1)
      {
      default: 
        i1 = 0;
      }
    } while ((i2 == 0) && (i1 == 0) && (!e()) && (!this.p));
    return true;
    float f1;
    float f2;
    if (f(this.f.findTopChildUnder((int)f1, (int)f2))) {}
    label236:
    for (int i1 = 1;; i1 = 0)
    {
      this.o = false;
      this.p = false;
      break label79;
      if (!this.f.checkTouchSlop(3)) {
        break;
      }
      this.h.a();
      this.i.a();
      i1 = 0;
      break label79;
      a(true);
      this.o = false;
      this.p = false;
      break;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (f()))
    {
      KeyEventCompat.startTracking(paramKeyEvent);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = g();
      if ((paramKeyEvent != null) && (a(paramKeyEvent) == 0)) {
        b();
      }
      return paramKeyEvent != null;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.k = true;
    int i4 = paramInt3 - paramInt1;
    int i5 = getChildCount();
    paramInt3 = 0;
    if (paramInt3 < i5)
    {
      View localView = getChildAt(paramInt3);
      if (localView.getVisibility() == 8) {}
      SidebarDrawerLayout.LayoutParams localLayoutParams;
      for (;;)
      {
        paramInt3 += 1;
        break;
        localLayoutParams = (SidebarDrawerLayout.LayoutParams)localView.getLayoutParams();
        if (!f(localView)) {
          break label113;
        }
        localView.layout(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.leftMargin + localView.getMeasuredWidth(), localLayoutParams.topMargin + localView.getMeasuredHeight());
      }
      label113:
      int i6 = localView.getMeasuredWidth();
      int i7 = localView.getMeasuredHeight();
      int i1;
      float f1;
      label167:
      int i2;
      if (a(localView, 3))
      {
        paramInt1 = -i6;
        i1 = (int)(i6 * localLayoutParams.b) + paramInt1;
        f1 = (i6 + i1) / i6;
        if (f1 == localLayoutParams.b) {
          break label314;
        }
        i2 = 1;
        label181:
        switch (localLayoutParams.a & 0x70)
        {
        default: 
          localView.layout(i1, localLayoutParams.topMargin, i6 + i1, i7 + localLayoutParams.topMargin);
          label241:
          if (i2 != 0) {
            b(localView, f1);
          }
          if (localLayoutParams.b <= 0.0F) {
            break;
          }
        }
      }
      for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4)
      {
        localView.setVisibility(paramInt1);
        break;
        i1 = i4 - (int)(i6 * localLayoutParams.b);
        f1 = (i4 - i1) / i6;
        break label167;
        label314:
        i2 = 0;
        break label181;
        paramInt1 = paramInt4 - paramInt2;
        localView.layout(i1, paramInt1 - localLayoutParams.bottomMargin - localView.getMeasuredHeight(), i6 + i1, paramInt1 - localLayoutParams.bottomMargin);
        break label241;
        int i8 = paramInt4 - paramInt2;
        int i3 = (i8 - i7) / 2;
        if (i3 < localLayoutParams.topMargin) {
          paramInt1 = localLayoutParams.topMargin;
        }
        for (;;)
        {
          localView.layout(i1, paramInt1, i6 + i1, i7 + paramInt1);
          break;
          paramInt1 = i3;
          if (i3 + i7 > i8 - localLayoutParams.bottomMargin) {
            paramInt1 = i8 - localLayoutParams.bottomMargin - i7;
          }
        }
      }
    }
    this.k = false;
    this.l = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = 300;
    int i6 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getMode(paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    int i1;
    label81:
    label97:
    View localView;
    if (i6 == 1073741824)
    {
      i1 = i2;
      if (i5 == 1073741824) {}
    }
    else
    {
      if (!isInEditMode()) {
        break label164;
      }
      if (i6 == Integer.MIN_VALUE)
      {
        i1 = i2;
        if (i5 != Integer.MIN_VALUE) {
          break label142;
        }
        i2 = i4;
        i3 = i1;
        setMeasuredDimension(i3, i2);
        i4 = getChildCount();
        i1 = 0;
        if (i1 >= i4) {
          return;
        }
        localView = getChildAt(i1);
        if (localView.getVisibility() != 8) {
          break label175;
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      break label97;
      i1 = i2;
      if (i6 != 0) {
        break;
      }
      i1 = 300;
      break;
      label142:
      i2 = i3;
      i3 = i1;
      if (i5 == 0) {
        break label81;
      }
      i2 = i4;
      i3 = i1;
      break label81;
      label164:
      throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
      label175:
      SidebarDrawerLayout.LayoutParams localLayoutParams = (SidebarDrawerLayout.LayoutParams)localView.getLayoutParams();
      if (f(localView))
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i3 - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(i2 - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
      }
      else
      {
        if (!g(localView)) {
          break label377;
        }
        i5 = e(localView) & 0x7;
        if ((0x0 & i5) != 0) {
          throw new IllegalStateException("Child drawer has absolute gravity " + e(i5) + " but this " + "SidebarDrawerLayout" + " already has a " + "drawer view along that edge");
        }
        localView.measure(getChildMeasureSpec(paramInt1, this.b + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
      }
    }
    label377:
    throw new IllegalStateException("Child " + localView + " at index " + i1 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SidebarDrawerLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.a != 0)
    {
      View localView = d(paramParcelable.a);
      if (localView != null) {
        h(localView);
      }
    }
    b(paramParcelable.b, 3);
    b(paramParcelable.c, 5);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SidebarDrawerLayout.SavedState localSavedState = new SidebarDrawerLayout.SavedState(super.onSaveInstanceState());
    int i2 = getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      Object localObject = getChildAt(i1);
      if (!g((View)localObject)) {}
      do
      {
        i1 += 1;
        break;
        localObject = (SidebarDrawerLayout.LayoutParams)((View)localObject).getLayoutParams();
      } while (!((SidebarDrawerLayout.LayoutParams)localObject).d);
      localSavedState.a = ((SidebarDrawerLayout.LayoutParams)localObject).a;
    }
    localSavedState.b = this.m;
    localSavedState.c = this.n;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent)) {
      return false;
    }
    float f1;
    float f2;
    try
    {
      this.f.processTouchEvent(paramMotionEvent);
      this.g.processTouchEvent(paramMotionEvent);
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        return true;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (c.a())
        {
          localIllegalArgumentException.printStackTrace();
          continue;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          this.r = f1;
          this.s = f2;
          this.o = false;
          this.p = false;
        }
      }
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      paramMotionEvent = this.f.findTopChildUnder((int)f2, (int)f1);
      if (paramMotionEvent == null) {
        break label248;
      }
    }
    boolean bool;
    if (f(paramMotionEvent))
    {
      f2 -= this.r;
      f1 -= this.s;
      int i1 = this.f.getTouchSlop();
      if (f2 * f2 + f1 * f1 < i1 * i1)
      {
        paramMotionEvent = a();
        if (paramMotionEvent != null) {
          if (a(paramMotionEvent) == 2) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      a(bool);
      this.o = false;
      break;
      bool = false;
      continue;
      a(true);
      this.o = false;
      this.p = false;
      break;
      label248:
      bool = true;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.o = paramBoolean;
    if (paramBoolean) {
      a(true);
    }
  }
  
  public void requestLayout()
  {
    if (!this.k) {
      super.requestLayout();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/sidebar/SidebarDrawerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */