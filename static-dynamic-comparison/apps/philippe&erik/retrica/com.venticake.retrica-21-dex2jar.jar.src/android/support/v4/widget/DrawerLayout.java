package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.ak;
import android.support.v4.view.av;
import android.support.v4.view.bq;
import android.support.v4.view.r;
import android.support.v4.view.w;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class DrawerLayout
  extends ViewGroup
{
  private static final int[] a = { 16842931 };
  private int b;
  private int c = -1728053248;
  private float d;
  private Paint e = new Paint();
  private final ae f;
  private final ae g;
  private final i h;
  private final i i;
  private int j;
  private boolean k;
  private boolean l = true;
  private int m;
  private int n;
  private boolean o;
  private boolean p;
  private g q;
  private float r;
  private float s;
  private Drawable t;
  private Drawable u;
  private CharSequence v;
  private CharSequence w;
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f1 = getResources().getDisplayMetrics().density;
    this.b = ((int)(64.0F * f1 + 0.5F));
    f1 *= 400.0F;
    this.h = new i(this, 3);
    this.i = new i(this, 5);
    this.f = ae.a(this, 1.0F, this.h);
    this.f.a(1);
    this.f.a(f1);
    this.h.a(this.f);
    this.g = ae.a(this, 1.0F, this.i);
    this.g.a(2);
    this.g.a(f1);
    this.i.a(this.g);
    setFocusableInTouchMode(true);
    av.a(this, new f(this));
    bq.a(this, false);
  }
  
  static String c(int paramInt)
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
      if (((h)getChildAt(i1).getLayoutParams()).c) {
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
      if ((g(localView)) && (j(localView))) {
        return localView;
      }
      i1 += 1;
    }
    return null;
  }
  
  private static boolean k(View paramView)
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
      if (((h)localView.getLayoutParams()).d) {
        return localView;
      }
      i1 += 1;
    }
    return null;
  }
  
  public CharSequence a(int paramInt)
  {
    paramInt = r.a(paramInt, av.e(this));
    if (paramInt == 3) {
      return this.v;
    }
    if (paramInt == 5) {
      return this.w;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    paramInt2 = r.a(paramInt2, av.e(this));
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
        ((ae)localObject).e();
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
        localObject = b(paramInt2);
      } while (localObject == null);
      h((View)localObject);
      return;
      localObject = b(paramInt2);
    } while (localObject == null);
    i((View)localObject);
  }
  
  void a(int paramInt1, int paramInt2, View paramView)
  {
    int i1 = 1;
    int i2 = this.f.a();
    int i3 = this.g.a();
    paramInt1 = i1;
    h localh;
    if (i2 != 1)
    {
      if (i3 == 1) {
        paramInt1 = i1;
      }
    }
    else if ((paramView != null) && (paramInt2 == 0))
    {
      localh = (h)paramView.getLayoutParams();
      if (localh.b != 0.0F) {
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
      if (localh.b == 1.0F) {
        c(paramView);
      }
    }
  }
  
  void a(View paramView, float paramFloat)
  {
    if (this.q != null) {
      this.q.a(paramView, paramFloat);
    }
  }
  
  void a(boolean paramBoolean)
  {
    int i5 = getChildCount();
    int i2 = 0;
    int i1 = 0;
    while (i2 < i5)
    {
      View localView = getChildAt(i2);
      h localh = (h)localView.getLayoutParams();
      int i3 = i1;
      if (g(localView))
      {
        if ((paramBoolean) && (!localh.c)) {
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
        i1 |= this.f.a(localView, -i4, localView.getTop());
      }
      for (;;)
      {
        localh.c = false;
        i4 = i1;
        break;
        i1 |= this.g.a(localView, getWidth(), localView.getTop());
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
  
  View b(int paramInt)
  {
    int i1 = r.a(paramInt, av.e(this));
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
  
  public void b()
  {
    a(false);
  }
  
  void b(View paramView)
  {
    h localh = (h)paramView.getLayoutParams();
    if (localh.d)
    {
      localh.d = false;
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
    h localh = (h)paramView.getLayoutParams();
    if (paramFloat == localh.b) {
      return;
    }
    localh.b = paramFloat;
    a(paramView, paramFloat);
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
    h localh = (h)paramView.getLayoutParams();
    if (!localh.d)
    {
      localh.d = true;
      if (this.q != null) {
        this.q.a(paramView);
      }
      sendAccessibilityEvent(32);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof h)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    int i2 = getChildCount();
    float f1 = 0.0F;
    int i1 = 0;
    while (i1 < i2)
    {
      f1 = Math.max(f1, ((h)getChildAt(i1).getLayoutParams()).b);
      i1 += 1;
    }
    this.d = f1;
    if ((this.f.a(true) | this.g.a(true))) {
      av.b(this);
    }
  }
  
  float d(View paramView)
  {
    return ((h)paramView.getLayoutParams()).b;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i7 = getHeight();
    boolean bool1 = f(paramView);
    int i3 = 0;
    int i5 = 0;
    int i1 = getWidth();
    int i8 = paramCanvas.save();
    int i2 = i1;
    int i4;
    View localView;
    if (bool1)
    {
      int i9 = getChildCount();
      i4 = 0;
      i3 = i5;
      for (;;)
      {
        if (i4 < i9)
        {
          localView = getChildAt(i4);
          if ((localView != paramView) && (localView.getVisibility() == 0) && (k(localView)) && (g(localView)))
          {
            if (localView.getHeight() < i7)
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
                break label534;
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
      paramCanvas.clipRect(i3, 0, i1, getHeight());
      i2 = i1;
      boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i8);
      if ((this.d > 0.0F) && (bool1))
      {
        i1 = (int)(((this.c & 0xFF000000) >>> 24) * this.d);
        i4 = this.c;
        this.e.setColor(i1 << 24 | i4 & 0xFFFFFF);
        paramCanvas.drawRect(i3, 0.0F, i2, getHeight(), this.e);
      }
      do
      {
        return bool2;
        if ((this.t != null) && (a(paramView, 3)))
        {
          i1 = this.t.getIntrinsicWidth();
          i2 = paramView.getRight();
          i3 = this.f.b();
          f1 = Math.max(0.0F, Math.min(i2 / i3, 1.0F));
          this.t.setBounds(i2, paramView.getTop(), i1 + i2, paramView.getBottom());
          this.t.setAlpha((int)(255.0F * f1));
          this.t.draw(paramCanvas);
          return bool2;
        }
      } while ((this.u == null) || (!a(paramView, 5)));
      i1 = this.u.getIntrinsicWidth();
      i2 = paramView.getLeft();
      i3 = getWidth();
      i4 = this.g.b();
      float f1 = Math.max(0.0F, Math.min((i3 - i2) / i4, 1.0F));
      this.u.setBounds(i2 - i1, paramView.getTop(), i2, paramView.getBottom());
      this.u.setAlpha((int)(255.0F * f1));
      this.u.draw(paramCanvas);
      return bool2;
      label534:
      i2 = i3;
    }
  }
  
  int e(View paramView)
  {
    return r.a(((h)paramView.getLayoutParams()).a, av.e(this));
  }
  
  boolean f(View paramView)
  {
    return ((h)paramView.getLayoutParams()).a == 0;
  }
  
  boolean g(View paramView)
  {
    return (r.a(((h)paramView.getLayoutParams()).a, av.e(paramView)) & 0x7) != 0;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new h(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new h(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof h)) {
      return new h((h)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new h((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new h(paramLayoutParams);
  }
  
  public void h(View paramView)
  {
    if (!g(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    if (this.l)
    {
      paramView = (h)paramView.getLayoutParams();
      paramView.b = 1.0F;
      paramView.d = true;
    }
    for (;;)
    {
      invalidate();
      return;
      if (a(paramView, 3)) {
        this.f.a(paramView, 0, paramView.getTop());
      } else {
        this.g.a(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
      }
    }
  }
  
  public void i(View paramView)
  {
    if (!g(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    if (this.l)
    {
      paramView = (h)paramView.getLayoutParams();
      paramView.b = 0.0F;
      paramView.d = false;
    }
    for (;;)
    {
      invalidate();
      return;
      if (a(paramView, 3)) {
        this.f.a(paramView, -paramView.getWidth(), paramView.getTop());
      } else {
        this.g.a(paramView, getWidth(), paramView.getTop());
      }
    }
  }
  
  public boolean j(View paramView)
  {
    if (!g(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    return ((h)paramView.getLayoutParams()).b > 0.0F;
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
    boolean bool1 = false;
    int i1 = ak.a(paramMotionEvent);
    boolean bool2 = this.f.a(paramMotionEvent);
    boolean bool3 = this.g.a(paramMotionEvent);
    switch (i1)
    {
    default: 
      i1 = 0;
      if (((bool2 | bool3)) || (i1 != 0) || (e()) || (this.p)) {
        bool1 = true;
      }
      return bool1;
    case 0: 
      label63:
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.r = f1;
      this.s = f2;
      if ((this.d <= 0.0F) || (!f(this.f.d((int)f1, (int)f2)))) {
        break;
      }
    }
    for (i1 = 1;; i1 = 0)
    {
      this.o = false;
      this.p = false;
      break label63;
      if (!this.f.d(3)) {
        break;
      }
      this.h.a();
      this.i.a();
      i1 = 0;
      break label63;
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
      w.b(paramKeyEvent);
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
      h localh;
      for (;;)
      {
        paramInt3 += 1;
        break;
        localh = (h)localView.getLayoutParams();
        if (!f(localView)) {
          break label113;
        }
        localView.layout(localh.leftMargin, localh.topMargin, localh.leftMargin + localView.getMeasuredWidth(), localh.topMargin + localView.getMeasuredHeight());
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
        i1 = (int)(i6 * localh.b) + paramInt1;
        f1 = (i6 + i1) / i6;
        if (f1 == localh.b) {
          break label314;
        }
        i2 = 1;
        label181:
        switch (localh.a & 0x70)
        {
        default: 
          localView.layout(i1, localh.topMargin, i6 + i1, i7 + localh.topMargin);
          label241:
          if (i2 != 0) {
            b(localView, f1);
          }
          if (localh.b <= 0.0F) {
            break;
          }
        }
      }
      for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4)
      {
        localView.setVisibility(paramInt1);
        break;
        i1 = i4 - (int)(i6 * localh.b);
        f1 = (i4 - i1) / i6;
        break label167;
        label314:
        i2 = 0;
        break label181;
        paramInt1 = paramInt4 - paramInt2;
        localView.layout(i1, paramInt1 - localh.bottomMargin - localView.getMeasuredHeight(), i6 + i1, paramInt1 - localh.bottomMargin);
        break label241;
        int i8 = paramInt4 - paramInt2;
        int i3 = (i8 - i7) / 2;
        if (i3 < localh.topMargin) {
          paramInt1 = localh.topMargin;
        }
        for (;;)
        {
          localView.layout(i1, paramInt1, i6 + i1, i7 + paramInt1);
          break;
          paramInt1 = i3;
          if (i3 + i7 > i8 - localh.bottomMargin) {
            paramInt1 = i8 - localh.bottomMargin - i7;
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
      h localh = (h)localView.getLayoutParams();
      if (f(localView))
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i3 - localh.leftMargin - localh.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(i2 - localh.topMargin - localh.bottomMargin, 1073741824));
      }
      else
      {
        if (!g(localView)) {
          break label378;
        }
        i5 = e(localView) & 0x7;
        if ((0x0 & i5) != 0) {
          throw new IllegalStateException("Child drawer has absolute gravity " + c(i5) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
        }
        localView.measure(getChildMeasureSpec(paramInt1, this.b + localh.leftMargin + localh.rightMargin, localh.width), getChildMeasureSpec(paramInt2, localh.topMargin + localh.bottomMargin, localh.height));
      }
    }
    label378:
    throw new IllegalStateException("Child " + localView + " at index " + i1 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (DrawerLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.a != 0)
    {
      View localView = b(paramParcelable.a);
      if (localView != null) {
        h(localView);
      }
    }
    a(paramParcelable.b, 3);
    a(paramParcelable.c, 5);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    DrawerLayout.SavedState localSavedState = new DrawerLayout.SavedState(super.onSaveInstanceState());
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
        localObject = (h)((View)localObject).getLayoutParams();
      } while (!((h)localObject).d);
      localSavedState.a = ((h)localObject).a;
    }
    localSavedState.b = this.m;
    localSavedState.c = this.n;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.f.b(paramMotionEvent);
    this.g.b(paramMotionEvent);
    float f1;
    float f2;
    boolean bool;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return true;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.r = f1;
      this.s = f2;
      this.o = false;
      this.p = false;
      return true;
    case 1: 
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      paramMotionEvent = this.f.d((int)f2, (int)f1);
      if ((paramMotionEvent != null) && (f(paramMotionEvent)))
      {
        f2 -= this.r;
        f1 -= this.s;
        int i1 = this.f.d();
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
      break;
    }
    for (;;)
    {
      a(bool);
      this.o = false;
      return true;
      bool = false;
      continue;
      a(true);
      this.o = false;
      this.p = false;
      return true;
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
  
  public void setDrawerListener(g paramg)
  {
    this.q = paramg;
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    a(paramInt, 3);
    a(paramInt, 5);
  }
  
  public void setScrimColor(int paramInt)
  {
    this.c = paramInt;
    invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/widget/DrawerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */