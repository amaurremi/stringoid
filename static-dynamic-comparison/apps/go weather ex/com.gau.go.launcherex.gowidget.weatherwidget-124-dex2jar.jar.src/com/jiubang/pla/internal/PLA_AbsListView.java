package com.jiubang.pla.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import android.widget.ListAdapter;
import com.gau.go.launcherex.gowidget.weatherwidget.R.styleable;
import java.util.ArrayList;

public abstract class PLA_AbsListView
  extends PLA_AdapterView
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener
{
  final boolean[] A = new boolean[1];
  private VelocityTracker R;
  private d S;
  private g T;
  private e U;
  private boolean V = true;
  private Rect W;
  private ContextMenu.ContextMenuInfo Z = null;
  int a = 0;
  private int aa = -1;
  private boolean ab = false;
  private boolean ac = false;
  private Runnable ad;
  private f ae;
  private int af;
  private int ag;
  private boolean ah;
  private int ai = 0;
  private int aj;
  private Runnable ak;
  private int al;
  private int am;
  private int an = -1;
  l b;
  protected ListAdapter c;
  boolean d = false;
  Drawable e;
  Rect f = new Rect();
  final h g = new h(this);
  int h = 0;
  int i = 0;
  int j = 0;
  int k = 0;
  protected Rect l = new Rect();
  protected int m = 0;
  protected boolean n;
  protected int o;
  int p;
  int q;
  int r;
  int s;
  protected int t = -1;
  int u;
  int v;
  int w = 0;
  boolean x;
  boolean y;
  int z = -1;
  
  public PLA_AbsListView(Context paramContext)
  {
    super(paramContext);
    z();
    setVerticalScrollBarEnabled(true);
    paramContext = paramContext.obtainStyledAttributes(R.styleable.View);
    initializeScrollbars(paramContext);
    paramContext.recycle();
  }
  
  public PLA_AbsListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130771999);
  }
  
  public PLA_AbsListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    z();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AbsListView, paramInt, 0);
    paramAttributeSet = paramContext.getDrawable(0);
    if (paramAttributeSet != null) {
      a(paramAttributeSet);
    }
    this.d = paramContext.getBoolean(1, false);
    c(paramContext.getBoolean(2, false));
    b(paramContext.getBoolean(3, true));
    f(paramContext.getInt(5, 0));
    g(paramContext.getColor(6, 0));
    a(paramContext.getBoolean(8, true));
    paramContext.recycle();
  }
  
  private void A()
  {
    a(getResources().getDrawable(17301602));
  }
  
  private void B()
  {
    if ((this.y) && (!this.n))
    {
      setChildrenDrawnWithCacheEnabled(true);
      setChildrenDrawingCacheEnabled(true);
      this.n = true;
    }
  }
  
  private void C()
  {
    if (this.ak == null) {
      this.ak = new b(this);
    }
    post(this.ak);
  }
  
  static int a(Rect paramRect1, Rect paramRect2, int paramInt)
  {
    int i3;
    int i2;
    int i1;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 66: 
      i3 = paramRect1.right;
      i2 = paramRect1.top + paramRect1.height() / 2;
      i1 = paramRect2.left;
      paramInt = paramRect2.top + paramRect2.height() / 2;
    }
    for (;;)
    {
      i1 -= i3;
      paramInt -= i2;
      return paramInt * paramInt + i1 * i1;
      i3 = paramRect1.left + paramRect1.width() / 2;
      i2 = paramRect1.bottom;
      paramInt = paramRect2.left;
      i1 = paramRect2.width() / 2 + paramInt;
      paramInt = paramRect2.top;
      continue;
      i3 = paramRect1.left;
      i2 = paramRect1.top + paramRect1.height() / 2;
      i1 = paramRect2.right;
      paramInt = paramRect2.top + paramRect2.height() / 2;
      continue;
      i3 = paramRect1.left + paramRect1.width() / 2;
      i2 = paramRect1.top;
      paramInt = paramRect2.left;
      i1 = paramRect2.width() / 2 + paramInt;
      paramInt = paramRect2.bottom;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f.set(paramInt1 - this.h, paramInt2 - this.i, this.j + paramInt3, this.k + paramInt4);
  }
  
  private void a(Canvas paramCanvas)
  {
    if ((i()) && (this.f != null) && (!this.f.isEmpty()))
    {
      Drawable localDrawable = this.e;
      localDrawable.setBounds(this.f);
      localDrawable.draw(paramCanvas);
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    if (paramMotionEvent.getPointerId(i1) == this.an) {
      if (i1 != 0) {
        break label74;
      }
    }
    label74:
    for (i1 = 1;; i1 = 0)
    {
      this.r = ((int)paramMotionEvent.getX(i1));
      this.s = ((int)paramMotionEvent.getY(i1));
      this.an = paramMotionEvent.getPointerId(i1);
      if (this.R != null) {
        this.R.clear();
      }
      return;
    }
  }
  
  private void c(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      paramView.onFinishTemporaryDetach();
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i2 = paramView.getChildCount();
        int i1 = 0;
        while (i1 < i2)
        {
          c(paramView.getChildAt(i1));
          i1 += 1;
        }
      }
    }
  }
  
  private boolean i(int paramInt)
  {
    if (Math.abs(paramInt) > this.aj)
    {
      B();
      this.t = 3;
      this.v = paramInt;
      setPressed(false);
      View localView = getChildAt(this.o - this.B);
      if (localView != null) {
        localView.setPressed(false);
      }
      a(1);
      requestDisallowInterceptTouchEvent(true);
      return true;
    }
    return false;
  }
  
  private void z()
  {
    setClickable(true);
    setFocusableInTouchMode(true);
    setWillNotDraw(false);
    setAlwaysDrawnWithCacheEnabled(false);
    b(true);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.aj = localViewConfiguration.getScaledTouchSlop();
    this.al = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.am = localViewConfiguration.getScaledMaximumFlingVelocity();
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.W;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.W = new Rect();
      localObject1 = this.W;
    }
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      localObject2 = getChildAt(i1);
      if (((View)localObject2).getVisibility() == 0)
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return this.B + i1;
        }
      }
      i1 -= 1;
    }
    return -1;
  }
  
  ContextMenu.ContextMenuInfo a(View paramView, int paramInt, long paramLong)
  {
    return new k(paramView, paramInt, paramLong);
  }
  
  View a(int paramInt, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = false;
    View localView2 = this.g.d(paramInt);
    View localView1;
    if (localView2 != null)
    {
      localView1 = this.c.getView(paramInt, localView2, this);
      if (localView1 != localView2)
      {
        this.g.a(localView2);
        paramArrayOfBoolean = localView1;
        if (this.ag != 0)
        {
          localView1.setDrawingCacheBackgroundColor(this.ag);
          paramArrayOfBoolean = localView1;
        }
      }
    }
    do
    {
      return paramArrayOfBoolean;
      paramArrayOfBoolean[0] = true;
      c(localView1);
      return localView1;
      localView1 = this.c.getView(paramInt, null, this);
      paramArrayOfBoolean = localView1;
    } while (this.ag == 0);
    localView1.setDrawingCacheBackgroundColor(this.ag);
    return localView1;
  }
  
  public PLA_AbsListView.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new PLA_AbsListView.LayoutParams(getContext(), paramAttributeSet);
  }
  
  void a()
  {
    if (this.U != null) {
      this.U.a(this, this.B, getChildCount(), this.M);
    }
  }
  
  void a(int paramInt)
  {
    if ((paramInt != this.ai) && (this.U != null))
    {
      this.U.a(this, paramInt);
      this.ai = paramInt;
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.e != null)
    {
      this.e.setCallback(null);
      unscheduleDrawable(this.e);
    }
    this.e = paramDrawable;
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    this.h = localRect.left;
    this.i = localRect.top;
    this.j = localRect.right;
    this.k = localRect.bottom;
    paramDrawable.setCallback(this);
    paramDrawable.setState(getDrawableState());
  }
  
  void a(View paramView)
  {
    Rect localRect = this.f;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    a(localRect.left, localRect.top, localRect.right, localRect.bottom);
    boolean bool = this.ah;
    if (paramView.isEnabled() != bool) {
      if (bool) {
        break label74;
      }
    }
    label74:
    for (bool = true;; bool = false)
    {
      this.ah = bool;
      refreshDrawableState();
      return;
    }
  }
  
  public void a(e parame)
  {
    this.U = parame;
    a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.V = paramBoolean;
  }
  
  public void addTouchables(ArrayList paramArrayList)
  {
    int i2 = getChildCount();
    int i3 = this.B;
    ListAdapter localListAdapter = this.c;
    if (localListAdapter == null) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = getChildAt(i1);
        if (localListAdapter.isEnabled(i3 + i1)) {
          paramArrayList.add(localView);
        }
        localView.addTouchables(paramArrayList);
        i1 += 1;
      }
    }
  }
  
  void b()
  {
    if (getChildCount() > 0)
    {
      c();
      requestLayout();
      invalidate();
    }
  }
  
  protected void b(int paramInt)
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      getChildAt(i1).offsetTopAndBottom(paramInt);
      i1 += 1;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.S == null) {
      this.S = new d(this);
    }
    for (;;)
    {
      this.S.a(paramInt1, paramInt2);
      return;
      d.a(this.S);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.y) && (!paramBoolean)) {
      C();
    }
    this.y = paramBoolean;
  }
  
  abstract int c(int paramInt);
  
  void c()
  {
    removeAllViewsInLayout();
    this.B = 0;
    this.L = false;
    this.G = false;
    this.O = -1;
    this.P = Long.MIN_VALUE;
    this.w = 0;
    this.f.setEmpty();
    invalidate();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.x != paramBoolean)
    {
      this.x = paramBoolean;
      b();
    }
  }
  
  boolean c(int paramInt1, int paramInt2)
  {
    int i11 = getChildCount();
    if (i11 == 0) {
      return true;
    }
    int i1 = o();
    int i4 = r();
    Object localObject = this.l;
    int i6 = getHeight() - ((Rect)localObject).bottom;
    int i7 = ((Rect)localObject).top;
    int i8 = p();
    int i9 = q();
    int i3 = getHeight() - getPaddingBottom() - getPaddingTop();
    int i2;
    if (paramInt1 < 0)
    {
      i2 = Math.max(-(i3 - 1), paramInt1);
      if (paramInt2 >= 0) {
        break label147;
      }
    }
    int i10;
    label147:
    for (i3 = Math.max(-(i3 - 1), paramInt2);; i3 = Math.min(i3 - 1, paramInt2))
    {
      i10 = this.B;
      if ((i10 != 0) || (i1 < ((Rect)localObject).top) || (i2 < 0)) {
        break label160;
      }
      return true;
      i2 = Math.min(i3 - 1, paramInt1);
      break;
    }
    label160:
    if ((i10 + i11 == this.M) && (i4 <= i6) && (i2 <= 0)) {
      return true;
    }
    boolean bool;
    int i12;
    int i13;
    int i5;
    if (i3 < 0)
    {
      bool = true;
      i12 = k();
      i13 = this.M - l();
      i4 = 0;
      i1 = 0;
      if (bool)
      {
        i14 = ((Rect)localObject).top;
        paramInt1 = 0;
        paramInt2 = 0;
      }
    }
    else
    {
      for (;;)
      {
        i4 = paramInt1;
        i5 = i1;
        if (paramInt2 < i11)
        {
          localObject = getChildAt(paramInt2);
          if (((View)localObject).getBottom() >= i14 - i3)
          {
            i5 = i1;
            i4 = paramInt1;
          }
        }
        else
        {
          this.q = (this.p + i2);
          this.Q = true;
          if (i4 > 0) {
            detachViewsFromParent(i5, i4);
          }
          b(i3);
          if (bool) {
            this.B = (i4 + this.B);
          }
          invalidate();
          paramInt1 = Math.abs(i3);
          if ((i7 - i8 < paramInt1) || (i9 - i6 < paramInt1)) {
            d(bool);
          }
          this.Q = false;
          a();
          awakenScrollBars();
          return false;
          bool = false;
          break;
        }
        i4 = i10 + paramInt2;
        if ((i4 >= i12) && (i4 < i13)) {
          this.g.a((View)localObject);
        }
        paramInt2 += 1;
        paramInt1 += 1;
      }
    }
    int i14 = getHeight();
    int i15 = ((Rect)localObject).bottom;
    paramInt2 = 0;
    paramInt1 = i11 - 1;
    i1 = i4;
    for (;;)
    {
      i4 = paramInt2;
      i5 = i1;
      if (paramInt1 < 0) {
        break;
      }
      localObject = getChildAt(paramInt1);
      i4 = paramInt2;
      i5 = i1;
      if (((View)localObject).getTop() <= i14 - i15 - i3) {
        break;
      }
      i1 = i10 + paramInt1;
      if ((i1 >= i12) && (i1 < i13)) {
        this.g.a((View)localObject);
      }
      paramInt2 += 1;
      i1 = paramInt1;
      paramInt1 -= 1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof PLA_AbsListView.LayoutParams;
  }
  
  protected int computeVerticalScrollExtent()
  {
    int i3 = getChildCount();
    if (i3 > 0)
    {
      if (this.V)
      {
        int i2 = i3 * 100;
        View localView = getChildAt(0);
        int i4 = p();
        int i5 = localView.getHeight();
        int i1 = i2;
        if (i5 > 0) {
          i1 = i2 + i4 * 100 / i5;
        }
        localView = getChildAt(i3 - 1);
        i3 = r();
        i4 = localView.getHeight();
        i2 = i1;
        if (i4 > 0) {
          i2 = i1 - (i3 - getHeight()) * 100 / i4;
        }
        return i2;
      }
      return 1;
    }
    return 0;
  }
  
  protected int computeVerticalScrollOffset()
  {
    int i3 = 0;
    int i2 = 0;
    int i4 = this.B;
    int i5 = getChildCount();
    int i1 = i2;
    if (i4 >= 0)
    {
      i1 = i2;
      if (i5 > 0)
      {
        if (!this.V) {
          break label113;
        }
        View localView = getChildAt(0);
        i3 = p();
        i5 = localView.getHeight();
        i1 = i2;
        if (i5 > 0) {
          i1 = Math.max(i4 * 100 - i3 * 100 / i5 + (int)(getScrollY() / getHeight() * this.M * 100.0F), 0);
        }
      }
    }
    return i1;
    label113:
    i2 = this.M;
    if (i4 == 0) {
      i1 = i3;
    }
    for (;;)
    {
      float f1 = i4;
      float f2 = i5;
      return (int)(i1 / i2 * f2 + f1);
      if (i4 + i5 == i2) {
        i1 = i2;
      } else {
        i1 = i5 / 2 + i4;
      }
    }
  }
  
  protected int computeVerticalScrollRange()
  {
    if (this.V) {
      return Math.max(this.M * 100, 0);
    }
    return this.M;
  }
  
  protected void d() {}
  
  protected void d(int paramInt) {}
  
  abstract void d(boolean paramBoolean);
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    boolean bool = this.d;
    if (!bool) {
      a(paramCanvas);
    }
    super.dispatchDraw(paramCanvas);
    if (bool) {
      a(paramCanvas);
    }
  }
  
  protected void dispatchSetPressed(boolean paramBoolean) {}
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.e != null) {
      this.e.setState(getDrawableState());
    }
  }
  
  @ViewDebug.ExportedProperty
  public View e()
  {
    return null;
  }
  
  protected void e(int paramInt) {}
  
  public int f()
  {
    return this.l.top;
  }
  
  public void f(int paramInt)
  {
    this.af = paramInt;
  }
  
  public int g()
  {
    return this.l.bottom;
  }
  
  public void g(int paramInt)
  {
    if (paramInt != this.ag)
    {
      this.ag = paramInt;
      int i2 = getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        getChildAt(i1).setDrawingCacheBackgroundColor(paramInt);
        i1 += 1;
      }
      this.g.e(paramInt);
    }
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new PLA_AbsListView.LayoutParams(paramLayoutParams);
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    int i1 = getChildCount();
    float f1 = super.getBottomFadingEdgeStrength();
    if (i1 == 0) {}
    int i2;
    float f2;
    do
    {
      return f1;
      if (this.B + i1 - 1 < this.M - 1) {
        return 1.0F;
      }
      i1 = getChildAt(i1 - 1).getBottom();
      i2 = getHeight();
      f2 = getVerticalFadingEdgeLength();
    } while (i1 <= i2 - getPaddingBottom());
    return (i1 - i2 + getPaddingBottom()) / f2;
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.Z;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    View localView = e();
    if ((localView != null) && (localView.getParent() == this))
    {
      localView.getFocusedRect(paramRect);
      offsetDescendantRectToMyCoords(localView, paramRect);
      return;
    }
    super.getFocusedRect(paramRect);
  }
  
  public int getSolidColor()
  {
    return this.ag;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    int i1 = getChildCount();
    float f1 = super.getTopFadingEdgeStrength();
    if (i1 == 0) {}
    float f2;
    do
    {
      return f1;
      if (this.B > 0) {
        return 1.0F;
      }
      i1 = getChildAt(0).getTop();
      f2 = getVerticalFadingEdgeLength();
    } while (i1 >= getPaddingTop());
    return -(i1 - getPaddingTop()) / f2;
  }
  
  protected int h(int paramInt)
  {
    return paramInt;
  }
  
  boolean h()
  {
    switch (this.t)
    {
    default: 
      return false;
    }
    return true;
  }
  
  protected boolean i()
  {
    return ((hasFocus()) && (!isInTouchMode())) || (h());
  }
  
  public boolean j()
  {
    if (getChildCount() == 0) {}
    int i1;
    Rect localRect;
    int i2;
    do
    {
      return true;
      i1 = o();
      localRect = this.l;
      i2 = Math.min(getHeight() - getPaddingBottom() - getPaddingTop() - 1, 0);
    } while ((this.B == 0) && (i1 >= localRect.top) && (i2 >= 0));
    return false;
  }
  
  int k()
  {
    return 0;
  }
  
  int l()
  {
    return 0;
  }
  
  protected void m()
  {
    int i3 = this.M;
    if (i3 > 0)
    {
      if (this.G)
      {
        this.G = false;
        if ((this.af == 2) || ((this.af == 1) && (this.B + getChildCount() >= this.N))) {
          this.a = 3;
        }
      }
      int i2;
      do
      {
        return;
        switch (this.H)
        {
        default: 
          if (isInTouchMode()) {
            break label171;
          }
          i2 = t();
          i1 = i2;
          if (i2 >= i3) {
            i1 = i3 - 1;
          }
          i2 = i1;
          if (i1 < 0) {
            i2 = 0;
          }
          a(i2, true);
        }
      } while (a(i2, false) >= 0);
    }
    if (this.x) {}
    for (int i1 = 3;; i1 = 1)
    {
      this.a = i1;
      this.G = false;
      return;
      this.a = 5;
      this.D = Math.min(Math.max(0, this.D), i3 - 1);
      return;
      label171:
      if (this.z < 0) {
        break;
      }
      return;
    }
  }
  
  public int n()
  {
    return this.ag;
  }
  
  protected int o()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return getChildAt(0).getTop();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.addOnTouchModeChangeListener(this);
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    Object localObject;
    if (this.ah)
    {
      localObject = super.onCreateDrawableState(paramInt);
      return (int[])localObject;
    }
    int i1 = ENABLED_STATE_SET[0];
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    paramInt = arrayOfInt.length - 1;
    label36:
    if (paramInt >= 0) {
      if (arrayOfInt[paramInt] != i1) {}
    }
    for (;;)
    {
      localObject = arrayOfInt;
      if (paramInt < 0) {
        break;
      }
      System.arraycopy(arrayOfInt, paramInt + 1, arrayOfInt, paramInt, arrayOfInt.length - paramInt - 1);
      return arrayOfInt;
      paramInt -= 1;
      break label36;
      paramInt = -1;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.g.b();
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.removeOnTouchModeChangeListener(this);
    }
  }
  
  public void onGlobalLayout() {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return false;
      int i1 = this.t;
      int i2 = (int)paramMotionEvent.getX();
      int i3 = (int)paramMotionEvent.getY();
      this.an = paramMotionEvent.getPointerId(0);
      int i4 = c(i3);
      if ((i1 != 4) && (i4 >= 0))
      {
        this.p = getChildAt(i4 - this.B).getTop();
        this.r = i2;
        this.s = i3;
        this.o = i4;
        this.t = 0;
        C();
      }
      this.u = Integer.MIN_VALUE;
      if (i1 == 4)
      {
        return true;
        switch (this.t)
        {
        default: 
          break;
        case 0: 
          if (i((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.an)) - this.s))
          {
            return true;
            this.t = -1;
            this.an = -1;
            a(0);
            continue;
            a(paramMotionEvent);
          }
          break;
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.I = true;
    if (paramBoolean)
    {
      paramInt2 = getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        getChildAt(paramInt1).forceLayout();
        paramInt1 += 1;
      }
      this.g.a();
    }
    d();
    this.I = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.e == null) {
      A();
    }
    Rect localRect = this.l;
    localRect.left = (this.h + getPaddingLeft());
    localRect.top = (this.i + getPaddingTop());
    localRect.right = (this.j + getPaddingRight());
    localRect.bottom = (this.k + getPaddingBottom());
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(paramParcelable);
    this.L = true;
    requestLayout();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() > 0)
    {
      this.L = true;
      y();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (!isEnabled())
    {
      if ((isClickable()) || (isLongClickable())) {}
      for (bool1 = true;; bool1 = false) {
        return bool1;
      }
    }
    int i1 = paramMotionEvent.getAction();
    if (this.R == null) {
      this.R = VelocityTracker.obtain();
    }
    this.R.addMovement(paramMotionEvent);
    int i2;
    int i3;
    switch (i1 & 0xFF)
    {
    case 4: 
    case 5: 
    default: 
      return true;
    case 0: 
      this.an = paramMotionEvent.getPointerId(0);
      i2 = (int)paramMotionEvent.getX();
      i3 = (int)paramMotionEvent.getY();
      i1 = a(i2, i3);
      if (!this.L) {
        if ((this.t != 4) && (i1 >= 0) && (((ListAdapter)s()).isEnabled(i1)))
        {
          this.t = 0;
          if (this.ad == null) {
            this.ad = new c(this);
          }
          postDelayed(this.ad, ViewConfiguration.getTapTimeout());
        }
      }
      break;
    }
    for (;;)
    {
      if (i1 >= 0) {
        this.p = getChildAt(i1 - this.B).getTop();
      }
      this.r = i2;
      this.s = i3;
      this.o = i1;
      this.u = Integer.MIN_VALUE;
      return true;
      if ((paramMotionEvent.getEdgeFlags() != 0) && (i1 < 0)) {
        return false;
      }
      if (this.t == 4)
      {
        B();
        this.t = 3;
        this.v = 0;
        i1 = c(i3);
        a(1);
        continue;
        i3 = (int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.an));
        i1 = i3 - this.s;
        switch (this.t)
        {
        default: 
          return true;
        case 0: 
        case 1: 
        case 2: 
          i(i1);
          return true;
        }
        if (i3 == this.u) {
          break;
        }
        i2 = i1 - this.v;
        if (this.u != Integer.MIN_VALUE) {}
        for (i1 = i3 - this.u;; i1 = i2)
        {
          bool1 = bool2;
          if (i1 != 0) {
            bool1 = c(i2, i1);
          }
          if ((bool1) && (getChildCount() > 0))
          {
            i1 = c(i3);
            if (i1 >= 0) {
              this.p = getChildAt(i1 - this.B).getTop();
            }
            this.s = i3;
            this.o = i1;
            invalidate();
          }
          this.u = i3;
          return true;
        }
        switch (this.t)
        {
        }
        for (;;)
        {
          setPressed(false);
          invalidate();
          if (this.R != null)
          {
            this.R.recycle();
            this.R = null;
          }
          this.an = -1;
          return true;
          i1 = this.o;
          paramMotionEvent = getChildAt(i1 - this.B);
          if ((paramMotionEvent != null) && (!paramMotionEvent.hasFocusable()))
          {
            if (this.t != 0) {
              paramMotionEvent.setPressed(false);
            }
            if (this.ae == null) {
              this.ae = new f(this, null);
            }
            f localf = this.ae;
            localf.a = paramMotionEvent;
            localf.b = i1;
            localf.a();
            this.z = i1;
            if ((this.t == 0) || (this.t == 1))
            {
              this.a = 0;
              if ((!this.L) && (this.c.isEnabled(i1)))
              {
                this.t = 1;
                d();
                paramMotionEvent.setPressed(true);
                a(paramMotionEvent);
                setPressed(true);
                if (this.e != null)
                {
                  Drawable localDrawable = this.e.getCurrent();
                  if ((localDrawable != null) && ((localDrawable instanceof TransitionDrawable))) {
                    ((TransitionDrawable)localDrawable).resetTransition();
                  }
                }
                postDelayed(new a(this, paramMotionEvent, localf), ViewConfiguration.getPressedStateDuration());
                return true;
              }
              this.t = -1;
              return true;
            }
            if ((!this.L) && (this.c.isEnabled(i1))) {
              post(localf);
            }
          }
          this.t = -1;
          continue;
          i1 = getChildCount();
          if (i1 > 0)
          {
            i2 = p();
            i3 = q();
            if ((this.B == 0) && (i2 >= this.l.top) && (i1 + this.B < this.M) && (i3 <= getHeight() - this.l.bottom))
            {
              this.t = -1;
              a(0);
            }
            else
            {
              paramMotionEvent = this.R;
              paramMotionEvent.computeCurrentVelocity(1600, this.am);
              i1 = (int)paramMotionEvent.getYVelocity(this.an);
              if (Math.abs(i1) > this.al)
              {
                if (this.S == null) {
                  this.S = new d(this);
                }
                a(2);
                this.S.a(-i1);
              }
              else
              {
                this.t = -1;
                a(0);
              }
            }
          }
          else
          {
            this.t = -1;
            a(0);
          }
        }
        this.t = -1;
        setPressed(false);
        paramMotionEvent = getChildAt(this.o - this.B);
        if (paramMotionEvent != null) {
          paramMotionEvent.setPressed(false);
        }
        C();
        if (this.R != null)
        {
          this.R.recycle();
          this.R = null;
        }
        this.an = -1;
        return true;
        a(paramMotionEvent);
        i2 = this.r;
        i1 = this.s;
        i2 = a(i2, i1);
        if (i2 >= 0)
        {
          this.p = getChildAt(i2 - this.B).getTop();
          this.o = i2;
        }
        this.u = i1;
        return true;
      }
    }
  }
  
  public void onTouchModeChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (getHeight() > 0) && (getChildCount() > 0)) {
      d();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    int i1;
    if (isInTouchMode())
    {
      i1 = 0;
      if (paramBoolean) {
        break label77;
      }
      setChildrenDrawingCacheEnabled(false);
      if (this.S != null)
      {
        removeCallbacks(this.S);
        d.a(this.S);
        if (getScrollY() != 0)
        {
          scrollTo(getScrollX(), 0);
          invalidate();
        }
      }
    }
    for (;;)
    {
      this.aa = i1;
      return;
      i1 = 1;
      break;
      label77:
      if ((i1 != this.aa) && (this.aa != -1))
      {
        this.a = 0;
        d();
      }
    }
  }
  
  protected int p()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return getChildAt(0).getTop();
  }
  
  protected int q()
  {
    int i1 = getChildCount();
    if (i1 == 0) {
      return 0;
    }
    return getChildAt(i1 - 1).getBottom();
  }
  
  protected int r()
  {
    int i1 = getChildCount();
    if (i1 == 0) {
      return 0;
    }
    return getChildAt(i1 - 1).getBottom();
  }
  
  public void requestLayout()
  {
    if ((!this.Q) && (!this.I)) {
      super.requestLayout();
    }
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    int i1 = b(paramView);
    if (i1 >= 0)
    {
      long l1 = this.c.getItemId(i1);
      if (this.K != null) {
        bool2 = this.K.a(this, paramView, i1, l1);
      }
      bool1 = bool2;
      if (!bool2)
      {
        this.Z = a(getChildAt(i1 - this.B), i1, l1);
        bool1 = super.showContextMenuForChild(paramView);
      }
    }
    return bool1;
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    return (this.e == paramDrawable) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/pla/internal/PLA_AbsListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */