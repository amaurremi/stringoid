package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.e;
import android.support.v4.view.g;
import android.support.v4.view.j;
import android.support.v4.view.p;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public class DrawerLayout
  extends ViewGroup
{
  private static final int[] bG = { 16842931 };
  private float bg;
  private float bh;
  private boolean cr = true;
  private int df;
  private int dg = -1728053248;
  private float dh;
  private Paint di = new Paint();
  private final i dj;
  private final i dk;
  private final d dl;
  private final d dm;
  private int dn;
  private int jdField_do;
  private int dp;
  private boolean dq;
  private boolean dr;
  private b ds;
  private Drawable dt;
  private Drawable du;
  private boolean mInLayout;
  
  public DrawerLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = getResources().getDisplayMetrics().density;
    this.df = ((int)(64.0F * f + 0.5F));
    f *= 400.0F;
    this.dl = new d(3);
    this.dm = new d(5);
    this.dj = i.a(this, 1.0F, this.dl);
    this.dj.F(1);
    this.dj.f(f);
    this.dl.a(this.dj);
    this.dk = i.a(this, 1.0F, this.dm);
    this.dk.F(2);
    this.dk.f(f);
    this.dm.a(this.dk);
    setFocusableInTouchMode(true);
    p.a(this, new a());
    y.a(this, false);
  }
  
  private boolean W()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      if (((c)getChildAt(i).getLayoutParams()).dz) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean X()
  {
    return Y() != null;
  }
  
  private View Y()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((s(localView)) && (w(localView))) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  private static boolean q(View paramView)
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
  
  static String v(int paramInt)
  {
    if ((paramInt & 0x3) == 3) {
      return "LEFT";
    }
    if ((paramInt & 0x5) == 5) {
      return "RIGHT";
    }
    return Integer.toHexString(paramInt);
  }
  
  View U()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (((c)localView.getLayoutParams()).dA) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public void V()
  {
    d(false);
  }
  
  void Z()
  {
    int i = 0;
    if (!this.dr)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      int j = getChildCount();
      while (i < j)
      {
        getChildAt(i).dispatchTouchEvent(localMotionEvent);
        i += 1;
      }
      localMotionEvent.recycle();
      this.dr = true;
    }
  }
  
  void a(int paramInt1, int paramInt2, View paramView)
  {
    int i = 1;
    int j = this.dj.ai();
    int k = this.dk.ai();
    paramInt1 = i;
    c localc;
    if (j != 1)
    {
      if (k == 1) {
        paramInt1 = i;
      }
    }
    else if ((paramView != null) && (paramInt2 == 0))
    {
      localc = (c)paramView.getLayoutParams();
      if (localc.dw != 0.0F) {
        break label124;
      }
      m(paramView);
    }
    for (;;)
    {
      if (paramInt1 != this.dn)
      {
        this.dn = paramInt1;
        if (this.ds != null) {
          this.ds.onDrawerStateChanged(paramInt1);
        }
      }
      return;
      if ((j == 2) || (k == 2))
      {
        paramInt1 = 2;
        break;
      }
      paramInt1 = 0;
      break;
      label124:
      if (localc.dw == 1.0F) {
        n(paramView);
      }
    }
  }
  
  public void a(b paramb)
  {
    this.ds = paramb;
  }
  
  void b(View paramView, float paramFloat)
  {
    if (this.ds != null) {
      this.ds.onDrawerSlide(paramView, paramFloat);
    }
  }
  
  void c(View paramView, float paramFloat)
  {
    c localc = (c)paramView.getLayoutParams();
    if (paramFloat == localc.dw) {
      return;
    }
    localc.dw = paramFloat;
    b(paramView, paramFloat);
  }
  
  boolean c(View paramView, int paramInt)
  {
    return (p(paramView) & paramInt) == paramInt;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof c)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    int j = getChildCount();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f = Math.max(f, ((c)getChildAt(i).getLayoutParams()).dw);
      i += 1;
    }
    this.dh = f;
    if ((this.dj.e(true) | this.dk.e(true))) {
      p.d(this);
    }
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    paramInt2 = e.getAbsoluteGravity(paramInt2, p.g(this));
    Object localObject;
    if (paramInt2 == 3)
    {
      this.jdField_do = paramInt1;
      if (paramInt1 != 0)
      {
        if (paramInt2 != 3) {
          break label74;
        }
        localObject = this.dj;
        label33:
        ((i)localObject).cancel();
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
        this.dp = paramInt1;
        break;
        localObject = this.dk;
        break label33;
        localObject = u(paramInt2);
      } while (localObject == null);
      t((View)localObject);
      return;
      localObject = u(paramInt2);
    } while (localObject == null);
    u((View)localObject);
  }
  
  void d(boolean paramBoolean)
  {
    int n = getChildCount();
    int j = 0;
    int i = 0;
    while (j < n)
    {
      View localView = getChildAt(j);
      c localc = (c)localView.getLayoutParams();
      int k = i;
      if (s(localView))
      {
        if ((paramBoolean) && (!localc.dz)) {
          k = i;
        }
      }
      else
      {
        j += 1;
        i = k;
        continue;
      }
      int m = localView.getWidth();
      if (c(localView, 3)) {
        i |= this.dj.c(localView, -m, localView.getTop());
      }
      for (;;)
      {
        localc.dz = false;
        m = i;
        break;
        i |= this.dk.c(localView, getWidth(), localView.getTop());
      }
    }
    this.dl.T();
    this.dm.T();
    if (i != 0) {
      invalidate();
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i2 = getHeight();
    boolean bool1 = r(paramView);
    int k = 0;
    int n = 0;
    int i = getWidth();
    int i3 = paramCanvas.save();
    int j = i;
    int m;
    View localView;
    if (bool1)
    {
      int i4 = getChildCount();
      m = 0;
      k = n;
      for (;;)
      {
        if (m < i4)
        {
          localView = getChildAt(m);
          if ((localView != paramView) && (localView.getVisibility() == 0) && (q(localView)) && (s(localView)))
          {
            if (localView.getHeight() < i2)
            {
              n = k;
              j = i;
              m += 1;
              i = j;
              k = n;
              continue;
            }
            if (c(localView, 3))
            {
              j = localView.getRight();
              if (j <= k) {
                break label534;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      n = j;
      j = i;
      break;
      int i1 = localView.getLeft();
      j = i1;
      n = k;
      if (i1 < i) {
        break;
      }
      j = i;
      n = k;
      break;
      paramCanvas.clipRect(k, 0, i, getHeight());
      j = i;
      boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i3);
      if ((this.dh > 0.0F) && (bool1))
      {
        i = (int)(((this.dg & 0xFF000000) >>> 24) * this.dh);
        m = this.dg;
        this.di.setColor(i << 24 | m & 0xFFFFFF);
        paramCanvas.drawRect(k, 0.0F, j, getHeight(), this.di);
      }
      do
      {
        return bool2;
        if ((this.dt != null) && (c(paramView, 3)))
        {
          i = this.dt.getIntrinsicWidth();
          j = paramView.getRight();
          k = this.dj.aj();
          f = Math.max(0.0F, Math.min(j / k, 1.0F));
          this.dt.setBounds(j, paramView.getTop(), i + j, paramView.getBottom());
          this.dt.setAlpha((int)(255.0F * f));
          this.dt.draw(paramCanvas);
          return bool2;
        }
      } while ((this.du == null) || (!c(paramView, 5)));
      i = this.du.getIntrinsicWidth();
      j = paramView.getLeft();
      k = getWidth();
      m = this.dk.aj();
      float f = Math.max(0.0F, Math.min((k - j) / m, 1.0F));
      this.du.setBounds(j - i, paramView.getTop(), j, paramView.getBottom());
      this.du.setAlpha((int)(255.0F * f));
      this.du.draw(paramCanvas);
      return bool2;
      label534:
      j = k;
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new c(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new c(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof c)) {
      return new c((c)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new c((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new c(paramLayoutParams);
  }
  
  public int l(View paramView)
  {
    int i = p(paramView);
    if (i == 3) {
      return this.jdField_do;
    }
    if (i == 5) {
      return this.dp;
    }
    return 0;
  }
  
  void m(View paramView)
  {
    c localc = (c)paramView.getLayoutParams();
    if (localc.dA)
    {
      localc.dA = false;
      if (this.ds != null) {
        this.ds.onDrawerClosed(paramView);
      }
      sendAccessibilityEvent(32);
    }
  }
  
  void n(View paramView)
  {
    c localc = (c)paramView.getLayoutParams();
    if (!localc.dA)
    {
      localc.dA = true;
      if (this.ds != null) {
        this.ds.onDrawerOpened(paramView);
      }
      paramView.sendAccessibilityEvent(32);
    }
  }
  
  float o(View paramView)
  {
    return ((c)paramView.getLayoutParams()).dw;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.cr = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.cr = true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    int i = j.a(paramMotionEvent);
    boolean bool2 = this.dj.f(paramMotionEvent);
    boolean bool3 = this.dk.f(paramMotionEvent);
    switch (i)
    {
    default: 
      i = 0;
      if (((bool2 | bool3)) || (i != 0) || (W()) || (this.dr)) {
        bool1 = true;
      }
      return bool1;
    case 0: 
      label63:
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.bg = f1;
      this.bh = f2;
      if ((this.dh <= 0.0F) || (!r(this.dj.j((int)f1, (int)f2)))) {
        break;
      }
    }
    for (i = 1;; i = 0)
    {
      this.dq = false;
      this.dr = false;
      break label63;
      if (!this.dj.K(3)) {
        break;
      }
      this.dl.T();
      this.dm.T();
      i = 0;
      break label63;
      d(true);
      this.dq = false;
      this.dr = false;
      break;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (X()))
    {
      g.b(paramKeyEvent);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = Y();
      if ((paramKeyEvent != null) && (l(paramKeyEvent) == 0)) {
        V();
      }
      return paramKeyEvent != null;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mInLayout = true;
    int m = paramInt3 - paramInt1;
    int n = getChildCount();
    paramInt3 = 0;
    if (paramInt3 < n)
    {
      View localView = getChildAt(paramInt3);
      if (localView.getVisibility() == 8) {}
      c localc;
      for (;;)
      {
        paramInt3 += 1;
        break;
        localc = (c)localView.getLayoutParams();
        if (!r(localView)) {
          break label113;
        }
        localView.layout(localc.leftMargin, localc.topMargin, localc.leftMargin + localView.getMeasuredWidth(), localc.topMargin + localView.getMeasuredHeight());
      }
      label113:
      int i1 = localView.getMeasuredWidth();
      int i2 = localView.getMeasuredHeight();
      int i;
      float f;
      label167:
      int j;
      if (c(localView, 3))
      {
        paramInt1 = -i1;
        i = (int)(i1 * localc.dw) + paramInt1;
        f = (i1 + i) / i1;
        if (f == localc.dw) {
          break label314;
        }
        j = 1;
        label181:
        switch (localc.gravity & 0x70)
        {
        default: 
          localView.layout(i, localc.topMargin, i1 + i, i2 + localc.topMargin);
          label241:
          if (j != 0) {
            c(localView, f);
          }
          if (localc.dw <= 0.0F) {
            break;
          }
        }
      }
      for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4)
      {
        localView.setVisibility(paramInt1);
        break;
        i = m - (int)(i1 * localc.dw);
        f = (m - i) / i1;
        break label167;
        label314:
        j = 0;
        break label181;
        paramInt1 = paramInt4 - paramInt2;
        localView.layout(i, paramInt1 - localc.bottomMargin - localView.getMeasuredHeight(), i1 + i, paramInt1 - localc.bottomMargin);
        break label241;
        int i3 = paramInt4 - paramInt2;
        int k = (i3 - i2) / 2;
        if (k < localc.topMargin) {
          paramInt1 = localc.topMargin;
        }
        for (;;)
        {
          localView.layout(i, paramInt1, i1 + i, i2 + paramInt1);
          break;
          paramInt1 = k;
          if (k + i2 > i3 - localc.bottomMargin) {
            paramInt1 = i3 - localc.bottomMargin - i2;
          }
        }
      }
    }
    this.mInLayout = false;
    this.cr = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 300;
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    int i;
    label81:
    label97:
    View localView;
    if (i1 == 1073741824)
    {
      i = j;
      if (n == 1073741824) {}
    }
    else
    {
      if (!isInEditMode()) {
        break label164;
      }
      if (i1 == Integer.MIN_VALUE)
      {
        i = j;
        if (n != Integer.MIN_VALUE) {
          break label142;
        }
        j = m;
        k = i;
        setMeasuredDimension(k, j);
        m = getChildCount();
        i = 0;
        if (i >= m) {
          return;
        }
        localView = getChildAt(i);
        if (localView.getVisibility() != 8) {
          break label175;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label97;
      i = j;
      if (i1 != 0) {
        break;
      }
      i = 300;
      break;
      label142:
      j = k;
      k = i;
      if (n == 0) {
        break label81;
      }
      j = m;
      k = i;
      break label81;
      label164:
      throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
      label175:
      c localc = (c)localView.getLayoutParams();
      if (r(localView))
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(k - localc.leftMargin - localc.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(j - localc.topMargin - localc.bottomMargin, 1073741824));
      }
      else
      {
        if (!s(localView)) {
          break label378;
        }
        n = p(localView) & 0x7;
        if ((0x0 & n) != 0) {
          throw new IllegalStateException("Child drawer has absolute gravity " + v(n) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
        }
        localView.measure(getChildMeasureSpec(paramInt1, this.df + localc.leftMargin + localc.rightMargin, localc.width), getChildMeasureSpec(paramInt2, localc.topMargin + localc.bottomMargin, localc.height));
      }
    }
    label378:
    throw new IllegalStateException("Child " + localView + " at index " + i + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.dB != 0)
    {
      View localView = u(paramParcelable.dB);
      if (localView != null) {
        t(localView);
      }
    }
    d(paramParcelable.dC, 3);
    d(paramParcelable.dD, 5);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = getChildAt(i);
      if (!s((View)localObject)) {}
      do
      {
        i += 1;
        break;
        localObject = (c)((View)localObject).getLayoutParams();
      } while (!((c)localObject).dA);
      localSavedState.dB = ((c)localObject).gravity;
    }
    localSavedState.dC = this.jdField_do;
    localSavedState.dD = this.dp;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.dj.g(paramMotionEvent);
    this.dk.g(paramMotionEvent);
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
      this.bg = f1;
      this.bh = f2;
      this.dq = false;
      this.dr = false;
      return true;
    case 1: 
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      paramMotionEvent = this.dj.j((int)f2, (int)f1);
      if ((paramMotionEvent != null) && (r(paramMotionEvent)))
      {
        f2 -= this.bg;
        f1 -= this.bh;
        int i = this.dj.getTouchSlop();
        if (f2 * f2 + f1 * f1 < i * i)
        {
          paramMotionEvent = U();
          if (paramMotionEvent != null) {
            if (l(paramMotionEvent) == 2) {
              bool = true;
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      d(bool);
      this.dq = false;
      return true;
      bool = false;
      continue;
      d(true);
      this.dq = false;
      this.dr = false;
      return true;
      bool = true;
    }
  }
  
  int p(View paramView)
  {
    return e.getAbsoluteGravity(((c)paramView.getLayoutParams()).gravity, p.g(this));
  }
  
  boolean r(View paramView)
  {
    return ((c)paramView.getLayoutParams()).gravity == 0;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.dq = paramBoolean;
    if (paramBoolean) {
      d(true);
    }
  }
  
  public void requestLayout()
  {
    if (!this.mInLayout) {
      super.requestLayout();
    }
  }
  
  boolean s(View paramView)
  {
    return (e.getAbsoluteGravity(((c)paramView.getLayoutParams()).gravity, p.g(paramView)) & 0x7) != 0;
  }
  
  public void t(View paramView)
  {
    if (!s(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    if (this.cr)
    {
      paramView = (c)paramView.getLayoutParams();
      paramView.dw = 1.0F;
      paramView.dA = true;
    }
    for (;;)
    {
      invalidate();
      return;
      if (c(paramView, 3)) {
        this.dj.c(paramView, 0, paramView.getTop());
      } else {
        this.dk.c(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
      }
    }
  }
  
  View u(int paramInt)
  {
    int i = e.getAbsoluteGravity(paramInt, p.g(this));
    int j = getChildCount();
    paramInt = 0;
    while (paramInt < j)
    {
      View localView = getChildAt(paramInt);
      if ((p(localView) & 0x7) == (i & 0x7)) {
        return localView;
      }
      paramInt += 1;
    }
    return null;
  }
  
  public void u(View paramView)
  {
    if (!s(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    if (this.cr)
    {
      paramView = (c)paramView.getLayoutParams();
      paramView.dw = 0.0F;
      paramView.dA = false;
    }
    for (;;)
    {
      invalidate();
      return;
      if (c(paramView, 3)) {
        this.dj.c(paramView, -paramView.getWidth(), paramView.getTop());
      } else {
        this.dk.c(paramView, getWidth(), paramView.getTop());
      }
    }
  }
  
  public boolean v(View paramView)
  {
    if (!s(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    return ((c)paramView.getLayoutParams()).dA;
  }
  
  public void w(int paramInt)
  {
    View localView = u(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("No drawer view found with gravity " + v(paramInt));
    }
    t(localView);
  }
  
  public boolean w(View paramView)
  {
    if (!s(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    return ((c)paramView.getLayoutParams()).dw > 0.0F;
  }
  
  public void x(int paramInt)
  {
    View localView = u(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("No drawer view found with gravity " + v(paramInt));
    }
    u(localView);
  }
  
  public boolean y(int paramInt)
  {
    View localView = u(paramInt);
    if (localView != null) {
      return v(localView);
    }
    return false;
  }
  
  public boolean z(int paramInt)
  {
    View localView = u(paramInt);
    if (localView != null) {
      return w(localView);
    }
    return false;
  }
  
  protected static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public DrawerLayout.SavedState[] A(int paramAnonymousInt)
      {
        return new DrawerLayout.SavedState[paramAnonymousInt];
      }
      
      public DrawerLayout.SavedState a(Parcel paramAnonymousParcel)
      {
        return new DrawerLayout.SavedState(paramAnonymousParcel);
      }
    };
    int dB = 0;
    int dC = 0;
    int dD = 0;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.dB = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.dB);
    }
  }
  
  class a
    extends android.support.v4.view.a
  {
    private final Rect mTmpRect = new Rect();
    
    a() {}
    
    private void a(android.support.v4.view.a.a parama1, android.support.v4.view.a.a parama2)
    {
      Rect localRect = this.mTmpRect;
      parama2.getBoundsInParent(localRect);
      parama1.setBoundsInParent(localRect);
      parama2.getBoundsInScreen(localRect);
      parama1.setBoundsInScreen(localRect);
      parama1.setVisibleToUser(parama2.isVisibleToUser());
      parama1.setPackageName(parama2.getPackageName());
      parama1.setClassName(parama2.getClassName());
      parama1.setContentDescription(parama2.getContentDescription());
      parama1.setEnabled(parama2.isEnabled());
      parama1.setClickable(parama2.isClickable());
      parama1.setFocusable(parama2.isFocusable());
      parama1.setFocused(parama2.isFocused());
      parama1.setAccessibilityFocused(parama2.isAccessibilityFocused());
      parama1.setSelected(parama2.isSelected());
      parama1.setLongClickable(parama2.isLongClickable());
      parama1.addAction(parama2.getActions());
    }
    
    private void a(android.support.v4.view.a.a parama, ViewGroup paramViewGroup)
    {
      int j = paramViewGroup.getChildCount();
      int i = 0;
      if (i < j)
      {
        View localView = paramViewGroup.getChildAt(i);
        if (x(localView)) {}
        for (;;)
        {
          i += 1;
          break;
          switch (p.e(localView))
          {
          case 4: 
          case 3: 
          default: 
            break;
          case 0: 
            p.b(localView, 1);
          case 1: 
            parama.addChild(localView);
            break;
          case 2: 
            if ((localView instanceof ViewGroup)) {
              a(parama, (ViewGroup)localView);
            }
            break;
          }
        }
      }
    }
    
    public void a(View paramView, android.support.v4.view.a.a parama)
    {
      android.support.v4.view.a.a locala = android.support.v4.view.a.a.a(parama);
      super.a(paramView, locala);
      parama.setSource(paramView);
      ViewParent localViewParent = p.h(paramView);
      if ((localViewParent instanceof View)) {
        parama.setParent((View)localViewParent);
      }
      a(parama, locala);
      locala.recycle();
      a(parama, (ViewGroup)paramView);
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (!x(paramView)) {
        return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return false;
    }
    
    public boolean x(View paramView)
    {
      View localView = DrawerLayout.this.U();
      return (localView != null) && (localView != paramView);
    }
  }
  
  public static abstract interface b
  {
    public abstract void onDrawerClosed(View paramView);
    
    public abstract void onDrawerOpened(View paramView);
    
    public abstract void onDrawerSlide(View paramView, float paramFloat);
    
    public abstract void onDrawerStateChanged(int paramInt);
  }
  
  public static class c
    extends ViewGroup.MarginLayoutParams
  {
    boolean dA;
    float dw;
    boolean dz;
    public int gravity = 0;
    
    public c(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public c(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.aa());
      this.gravity = paramContext.getInt(0, 0);
      paramContext.recycle();
    }
    
    public c(c paramc)
    {
      super();
      this.gravity = paramc.gravity;
    }
    
    public c(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public c(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  private class d
    extends i.a
  {
    private final int dE;
    private i dF;
    private final Runnable dG = new Runnable()
    {
      public void run()
      {
        DrawerLayout.d.a(DrawerLayout.d.this);
      }
    };
    
    public d(int paramInt)
    {
      this.dE = paramInt;
    }
    
    private void ab()
    {
      int i = 3;
      if (this.dE == 3) {
        i = 5;
      }
      View localView = DrawerLayout.this.u(i);
      if (localView != null) {
        DrawerLayout.this.u(localView);
      }
    }
    
    private void ac()
    {
      int j = 0;
      int k = this.dF.aj();
      int i;
      View localView;
      if (this.dE == 3)
      {
        i = 1;
        if (i == 0) {
          break label149;
        }
        localView = DrawerLayout.this.u(3);
        if (localView != null) {
          j = -localView.getWidth();
        }
        j += k;
      }
      for (;;)
      {
        if ((localView != null) && (((i != 0) && (localView.getLeft() < j)) || ((i == 0) && (localView.getLeft() > j) && (DrawerLayout.this.l(localView) == 0))))
        {
          DrawerLayout.c localc = (DrawerLayout.c)localView.getLayoutParams();
          this.dF.c(localView, j, localView.getTop());
          localc.dz = true;
          DrawerLayout.this.invalidate();
          ab();
          DrawerLayout.this.Z();
        }
        return;
        i = 0;
        break;
        label149:
        localView = DrawerLayout.this.u(5);
        j = DrawerLayout.this.getWidth();
        j -= k;
      }
    }
    
    public void B(int paramInt)
    {
      DrawerLayout.this.a(this.dE, paramInt, this.dF.ak());
    }
    
    public boolean C(int paramInt)
    {
      return false;
    }
    
    public void T()
    {
      DrawerLayout.this.removeCallbacks(this.dG);
    }
    
    public int a(View paramView, int paramInt1, int paramInt2)
    {
      if (DrawerLayout.this.c(paramView, 3)) {
        return Math.max(-paramView.getWidth(), Math.min(paramInt1, 0));
      }
      paramInt2 = DrawerLayout.this.getWidth();
      return Math.max(paramInt2 - paramView.getWidth(), Math.min(paramInt1, paramInt2));
    }
    
    public void a(i parami)
    {
      this.dF = parami;
    }
    
    public void a(View paramView, float paramFloat1, float paramFloat2)
    {
      paramFloat2 = DrawerLayout.this.o(paramView);
      int k = paramView.getWidth();
      int i;
      if (DrawerLayout.this.c(paramView, 3)) {
        if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {
          i = 0;
        }
      }
      for (;;)
      {
        this.dF.g(i, paramView.getTop());
        DrawerLayout.this.invalidate();
        return;
        i = -k;
        continue;
        int j = DrawerLayout.this.getWidth();
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
    
    public int b(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getTop();
    }
    
    public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramInt2 = paramView.getWidth();
      float f;
      if (DrawerLayout.this.c(paramView, 3))
      {
        f = (paramInt2 + paramInt1) / paramInt2;
        DrawerLayout.this.c(paramView, f);
        if (f != 0.0F) {
          break label76;
        }
      }
      label76:
      for (paramInt1 = 4;; paramInt1 = 0)
      {
        paramView.setVisibility(paramInt1);
        DrawerLayout.this.invalidate();
        return;
        f = (DrawerLayout.this.getWidth() - paramInt1) / paramInt2;
        break;
      }
    }
    
    public boolean d(View paramView, int paramInt)
    {
      return (DrawerLayout.this.s(paramView)) && (DrawerLayout.this.c(paramView, this.dE)) && (DrawerLayout.this.l(paramView) == 0);
    }
    
    public void e(int paramInt1, int paramInt2)
    {
      DrawerLayout.this.postDelayed(this.dG, 160L);
    }
    
    public void e(View paramView, int paramInt)
    {
      ((DrawerLayout.c)paramView.getLayoutParams()).dz = false;
      ab();
    }
    
    public void f(int paramInt1, int paramInt2)
    {
      if ((paramInt1 & 0x1) == 1) {}
      for (View localView = DrawerLayout.this.u(3);; localView = DrawerLayout.this.u(5))
      {
        if ((localView != null) && (DrawerLayout.this.l(localView) == 0)) {
          this.dF.h(localView, paramInt2);
        }
        return;
      }
    }
    
    public int y(View paramView)
    {
      return paramView.getWidth();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/widget/DrawerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */