package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.j;
import android.support.v4.view.p;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout
  extends ViewGroup
{
  static final f eg = new g();
  private float bg;
  private float bh;
  private boolean ce;
  private boolean cr = true;
  private int dS = -858993460;
  private int dT;
  private Drawable dU;
  private final int dV;
  private boolean dW;
  private View dX;
  private float dY;
  private float dZ;
  private int ea;
  private int eb;
  private e ec;
  private final i ed;
  private boolean ee;
  private final ArrayList<b> ef = new ArrayList();
  private final Rect mTmpRect = new Rect();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 17)
    {
      eg = new i();
      return;
    }
    if (i >= 16)
    {
      eg = new h();
      return;
    }
  }
  
  public SlidingPaneLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.dV = ((int)(32.0F * f + 0.5F));
    ViewConfiguration.get(paramContext);
    setWillNotDraw(false);
    p.a(this, new a());
    p.b(this, 1);
    this.ed = i.a(this, 0.5F, new c(null));
    this.ed.F(1);
    this.ed.f(f * 400.0F);
  }
  
  private void D(int paramInt)
  {
    d locald = (d)this.dX.getLayoutParams();
    this.dY = ((paramInt - (getPaddingLeft() + locald.leftMargin)) / this.ea);
    if (this.eb != 0) {
      e(this.dY);
    }
    if (locald.ek) {
      a(this.dX, this.dY, this.dS);
    }
    z(this.dX);
  }
  
  private static boolean D(View paramView)
  {
    if (p.i(paramView)) {}
    do
    {
      return true;
      if (Build.VERSION.SDK_INT >= 18) {
        return false;
      }
      paramView = paramView.getBackground();
      if (paramView == null) {
        break;
      }
    } while (paramView.getOpacity() == -1);
    return false;
    return false;
  }
  
  private void E(View paramView)
  {
    eg.b(this, paramView);
  }
  
  private void a(View paramView, float paramFloat, int paramInt)
  {
    d locald = (d)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      i = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (locald.el == null) {
        locald.el = new Paint();
      }
      locald.el.setColorFilter(new PorterDuffColorFilter(i << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
      if (p.f(paramView) != 2) {
        p.a(paramView, 2, locald.el);
      }
      E(paramView);
    }
    while (p.f(paramView) == 0)
    {
      int i;
      return;
    }
    if (locald.el != null) {
      locald.el.setColorFilter(null);
    }
    paramView = new b(paramView);
    this.ef.add(paramView);
    p.a(this, paramView);
  }
  
  private void e(float paramFloat)
  {
    int j = 0;
    Object localObject = (d)this.dX.getLayoutParams();
    int i;
    if ((((d)localObject).ek) && (((d)localObject).leftMargin <= 0))
    {
      i = 1;
      int k = getChildCount();
      label38:
      if (j >= k) {
        return;
      }
      localObject = getChildAt(j);
      if (localObject != this.dX) {
        break label72;
      }
    }
    for (;;)
    {
      j += 1;
      break label38;
      i = 0;
      break;
      label72:
      int m = (int)((1.0F - this.dZ) * this.eb);
      this.dZ = paramFloat;
      ((View)localObject).offsetLeftAndRight(m - (int)((1.0F - paramFloat) * this.eb));
      if (i != 0) {
        a((View)localObject, 1.0F - this.dZ, this.dT);
      }
    }
  }
  
  private boolean f(View paramView, int paramInt)
  {
    boolean bool = false;
    if ((this.cr) || (a(0.0F, paramInt)))
    {
      this.ee = false;
      bool = true;
    }
    return bool;
  }
  
  private boolean g(View paramView, int paramInt)
  {
    if ((this.cr) || (a(1.0F, paramInt)))
    {
      this.ee = true;
      return true;
    }
    return false;
  }
  
  void A(View paramView)
  {
    if (this.ec != null) {
      this.ec.G(paramView);
    }
    sendAccessibilityEvent(32);
  }
  
  void B(View paramView)
  {
    if (this.ec != null) {
      this.ec.H(paramView);
    }
    sendAccessibilityEvent(32);
  }
  
  void C(View paramView)
  {
    int i2 = getPaddingLeft();
    int i3 = getWidth();
    int i4 = getPaddingRight();
    int i5 = getPaddingTop();
    int i6 = getHeight();
    int i7 = getPaddingBottom();
    int m;
    int k;
    int j;
    int i;
    if ((paramView != null) && (D(paramView)))
    {
      m = paramView.getLeft();
      k = paramView.getRight();
      j = paramView.getTop();
      i = paramView.getBottom();
    }
    int n;
    View localView;
    for (;;)
    {
      int i8 = getChildCount();
      n = 0;
      if (n < i8)
      {
        localView = getChildAt(n);
        if (localView != paramView) {
          break;
        }
      }
      return;
      i = 0;
      j = 0;
      k = 0;
      m = 0;
    }
    int i1 = Math.max(i2, localView.getLeft());
    int i9 = Math.max(i5, localView.getTop());
    int i10 = Math.min(i3 - i4, localView.getRight());
    int i11 = Math.min(i6 - i7, localView.getBottom());
    if ((i1 >= m) && (i9 >= j) && (i10 <= k) && (i11 <= i)) {}
    for (i1 = 4;; i1 = 0)
    {
      localView.setVisibility(i1);
      n += 1;
      break;
    }
  }
  
  boolean F(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView = (d)paramView.getLayoutParams();
    if ((this.dW) && (paramView.ek) && (this.dY > 0.0F)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean a(float paramFloat, int paramInt)
  {
    if (!this.dW) {
      return false;
    }
    d locald = (d)this.dX.getLayoutParams();
    paramInt = getPaddingLeft();
    paramInt = (int)(locald.leftMargin + paramInt + this.ea * paramFloat);
    if (this.ed.c(this.dX, paramInt, this.dX.getTop()))
    {
      ae();
      p.d(this);
      return true;
    }
    return false;
  }
  
  void ae()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
      i += 1;
    }
  }
  
  public boolean af()
  {
    return g(this.dX, 0);
  }
  
  public boolean ag()
  {
    return f(this.dX, 0);
  }
  
  public boolean ah()
  {
    return this.dW;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof d)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if (this.ed.e(true))
    {
      if (!this.dW) {
        this.ed.abort();
      }
    }
    else {
      return;
    }
    p.d(this);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (getChildCount() > 1) {}
    for (View localView = getChildAt(1); (localView == null) || (this.dU == null); localView = null) {
      return;
    }
    int i = this.dU.getIntrinsicWidth();
    int j = localView.getLeft();
    int k = localView.getTop();
    int m = localView.getBottom();
    this.dU.setBounds(j - i, k, j, m);
    this.dU.draw(paramCanvas);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    d locald = (d)paramView.getLayoutParams();
    int i = paramCanvas.save(2);
    if ((this.dW) && (!locald.ej) && (this.dX != null))
    {
      paramCanvas.getClipBounds(this.mTmpRect);
      this.mTmpRect.right = Math.min(this.mTmpRect.right, this.dX.getLeft());
      paramCanvas.clipRect(this.mTmpRect);
    }
    boolean bool;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = super.drawChild(paramCanvas, paramView, paramLong);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i);
      return bool;
      if ((locald.ek) && (this.dY > 0.0F))
      {
        if (!paramView.isDrawingCacheEnabled()) {
          paramView.setDrawingCacheEnabled(true);
        }
        Bitmap localBitmap = paramView.getDrawingCache();
        if (localBitmap != null)
        {
          paramCanvas.drawBitmap(localBitmap, paramView.getLeft(), paramView.getTop(), locald.el);
          bool = false;
        }
        else
        {
          Log.e("SlidingPaneLayout", "drawChild: child view " + paramView + " returned null drawing cache");
          bool = super.drawChild(paramCanvas, paramView, paramLong);
        }
      }
      else
      {
        if (paramView.isDrawingCacheEnabled()) {
          paramView.setDrawingCacheEnabled(false);
        }
        bool = super.drawChild(paramCanvas, paramView, paramLong);
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new d();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new d(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new d((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new d(paramLayoutParams);
  }
  
  public boolean isOpen()
  {
    return (!this.dW) || (this.dY == 1.0F);
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
    int j = this.ef.size();
    int i = 0;
    while (i < j)
    {
      ((b)this.ef.get(i)).run();
      i += 1;
    }
    this.ef.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i = j.a(paramMotionEvent);
    if ((!this.dW) && (i == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null) {
        if (this.ed.d(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          break label108;
        }
      }
    }
    label108:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.ee = bool1;
      if ((this.dW) && ((!this.ce) || (i == 0))) {
        break;
      }
      this.ed.cancel();
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    if ((i == 3) || (i == 1))
    {
      this.ed.cancel();
      return false;
    }
    switch (i)
    {
    }
    label164:
    float f1;
    float f2;
    do
    {
      for (i = 0;; i = 1)
      {
        if (!this.ed.f(paramMotionEvent))
        {
          bool1 = bool2;
          if (i == 0) {
            break;
          }
        }
        return true;
        this.ce = false;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.bg = f1;
        this.bh = f2;
        if ((!this.ed.d(this.dX, (int)f1, (int)f2)) || (!F(this.dX))) {
          break label164;
        }
      }
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      f2 = Math.abs(f2 - this.bg);
      f1 = Math.abs(f1 - this.bh);
    } while ((f2 <= this.ed.getTouchSlop()) || (f1 <= f2));
    this.ed.cancel();
    this.ce = true;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramInt3 - paramInt1;
    paramInt1 = getPaddingLeft();
    int k = getPaddingRight();
    int m = getPaddingTop();
    int i = getChildCount();
    if (this.cr) {
      if ((!this.dW) || (!this.ee)) {
        break label98;
      }
    }
    View localView;
    label98:
    for (float f = 1.0F;; f = 0.0F)
    {
      this.dY = f;
      paramInt4 = 0;
      paramInt2 = paramInt1;
      for (;;)
      {
        if (paramInt4 >= i) {
          break label315;
        }
        localView = getChildAt(paramInt4);
        if (localView.getVisibility() != 8) {
          break;
        }
        paramInt4 += 1;
      }
    }
    d locald = (d)localView.getLayoutParams();
    int n = localView.getMeasuredWidth();
    if (locald.ej)
    {
      paramInt3 = locald.leftMargin;
      int i1 = locald.rightMargin;
      paramInt3 = Math.min(paramInt1, j - k - this.dV) - paramInt2 - (paramInt3 + i1);
      this.ea = paramInt3;
      if (locald.leftMargin + paramInt2 + paramInt3 + n / 2 > j - k)
      {
        paramBoolean = true;
        label198:
        locald.ek = paramBoolean;
        paramInt3 = (int)(paramInt3 * this.dY);
        paramInt2 = locald.leftMargin + paramInt3 + paramInt2;
        paramInt3 = 0;
      }
    }
    for (;;)
    {
      paramInt3 = paramInt2 - paramInt3;
      localView.layout(paramInt3, m, paramInt3 + n, localView.getMeasuredHeight() + m);
      paramInt1 += localView.getWidth();
      break;
      paramBoolean = false;
      break label198;
      if ((this.dW) && (this.eb != 0))
      {
        paramInt3 = (int)((1.0F - this.dY) * this.eb);
        paramInt2 = paramInt1;
      }
      else
      {
        paramInt3 = 0;
        paramInt2 = paramInt1;
      }
    }
    label315:
    if (this.cr)
    {
      if (!this.dW) {
        break label390;
      }
      if (this.eb != 0) {
        e(this.dY);
      }
      if (((d)this.dX.getLayoutParams()).ek) {
        a(this.dX, this.dY, this.dS);
      }
    }
    for (;;)
    {
      C(this.dX);
      this.cr = false;
      return;
      label390:
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        a(getChildAt(paramInt1), 0.0F, this.dS);
        paramInt1 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (k != 1073741824) {
      if (isInEditMode()) {
        if (k == Integer.MIN_VALUE)
        {
          paramInt2 = i;
          i = j;
        }
      }
    }
    for (;;)
    {
      label85:
      boolean bool1;
      int i2;
      int i1;
      float f1;
      label133:
      View localView;
      d locald;
      switch (i)
      {
      default: 
        paramInt1 = 0;
        k = -1;
        bool1 = false;
        j = paramInt2 - getPaddingLeft() - getPaddingRight();
        i2 = getChildCount();
        if (i2 > 2) {
          Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.dX = null;
        i1 = 0;
        f1 = 0.0F;
        if (i1 >= i2) {
          break label612;
        }
        localView = getChildAt(i1);
        locald = (d)localView.getLayoutParams();
        if (localView.getVisibility() == 8)
        {
          locald.ek = false;
          m = j;
          j = paramInt1;
          paramInt1 = m;
        }
        break;
      }
      float f2;
      for (;;)
      {
        i1 += 1;
        m = j;
        j = paramInt1;
        paramInt1 = m;
        break label133;
        if (k != 0) {
          break label1088;
        }
        i = j;
        paramInt2 = 300;
        break;
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        if (j != 0) {
          break label1088;
        }
        if (isInEditMode())
        {
          if (j != 0) {
            break label1088;
          }
          j = Integer.MIN_VALUE;
          paramInt2 = i;
          paramInt1 = 300;
          i = j;
          break;
        }
        throw new IllegalStateException("Height must not be UNSPECIFIED");
        paramInt1 = paramInt1 - getPaddingTop() - getPaddingBottom();
        k = paramInt1;
        break label85;
        k = getPaddingTop();
        m = getPaddingBottom();
        j = 0;
        k = paramInt1 - k - m;
        paramInt1 = j;
        break label85;
        f2 = f1;
        if (locald.weight <= 0.0F) {
          break label370;
        }
        f1 += locald.weight;
        f2 = f1;
        if (locald.width != 0) {
          break label370;
        }
        m = paramInt1;
        paramInt1 = j;
        j = m;
      }
      label370:
      int m = locald.leftMargin + locald.rightMargin;
      label405:
      int n;
      label425:
      int i3;
      if (locald.width == -2)
      {
        m = View.MeasureSpec.makeMeasureSpec(paramInt2 - m, Integer.MIN_VALUE);
        if (locald.height != -2) {
          break label568;
        }
        n = View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE);
        localView.measure(m, n);
        n = localView.getMeasuredWidth();
        i3 = localView.getMeasuredHeight();
        m = paramInt1;
        if (i == Integer.MIN_VALUE)
        {
          m = paramInt1;
          if (i3 > paramInt1) {
            m = Math.min(i3, k);
          }
        }
        paramInt1 = j - n;
        if (paramInt1 >= 0) {
          break label606;
        }
      }
      label568:
      label606:
      for (boolean bool2 = true;; bool2 = false)
      {
        locald.ej = bool2;
        if (locald.ej) {
          this.dX = localView;
        }
        j = m;
        bool1 = bool2 | bool1;
        f1 = f2;
        break;
        if (locald.width == -1)
        {
          m = View.MeasureSpec.makeMeasureSpec(paramInt2 - m, 1073741824);
          break label405;
        }
        m = View.MeasureSpec.makeMeasureSpec(locald.width, 1073741824);
        break label405;
        if (locald.height == -1)
        {
          n = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
          break label425;
        }
        n = View.MeasureSpec.makeMeasureSpec(locald.height, 1073741824);
        break label425;
      }
      label612:
      if ((bool1) || (f1 > 0.0F))
      {
        i1 = paramInt2 - this.dV;
        m = 0;
        if (m < i2)
        {
          localView = getChildAt(m);
          if (localView.getVisibility() == 8) {}
          for (;;)
          {
            m += 1;
            break;
            locald = (d)localView.getLayoutParams();
            if (localView.getVisibility() != 8)
            {
              if ((locald.width == 0) && (locald.weight > 0.0F))
              {
                i = 1;
                label709:
                if (i == 0) {
                  break label805;
                }
                n = 0;
                label717:
                if ((!bool1) || (localView == this.dX)) {
                  break label869;
                }
                if ((locald.width >= 0) || ((n <= i1) && (locald.weight <= 0.0F))) {
                  continue;
                }
                if (i == 0) {
                  break label853;
                }
                if (locald.height != -2) {
                  break label815;
                }
                i = View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE);
              }
              for (;;)
              {
                localView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), i);
                break;
                i = 0;
                break label709;
                label805:
                n = localView.getMeasuredWidth();
                break label717;
                label815:
                if (locald.height == -1)
                {
                  i = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
                }
                else
                {
                  i = View.MeasureSpec.makeMeasureSpec(locald.height, 1073741824);
                  continue;
                  label853:
                  i = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                }
              }
              label869:
              if (locald.weight > 0.0F)
              {
                if (locald.width == 0) {
                  if (locald.height == -2) {
                    i = View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE);
                  }
                }
                for (;;)
                {
                  if (!bool1) {
                    break label1014;
                  }
                  i3 = locald.leftMargin;
                  i3 = paramInt2 - (locald.rightMargin + i3);
                  int i4 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                  if (n == i3) {
                    break;
                  }
                  localView.measure(i4, i);
                  break;
                  if (locald.height == -1)
                  {
                    i = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
                  }
                  else
                  {
                    i = View.MeasureSpec.makeMeasureSpec(locald.height, 1073741824);
                    continue;
                    i = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                  }
                }
                label1014:
                i3 = Math.max(0, j);
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(locald.weight * i3 / f1) + n, 1073741824), i);
              }
            }
          }
        }
      }
      setMeasuredDimension(paramInt2, paramInt1);
      this.dW = bool1;
      if ((this.ed.ai() != 0) && (!bool1)) {
        this.ed.abort();
      }
      return;
      label1088:
      paramInt2 = i;
      i = j;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.em) {
      af();
    }
    for (;;)
    {
      this.ee = paramParcelable.em;
      return;
      ag();
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (ah()) {}
    for (boolean bool = isOpen();; bool = this.ee)
    {
      localSavedState.em = bool;
      return localSavedState;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      this.cr = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    if (!this.dW) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    float f1;
    float f2;
    do
    {
      int i;
      boolean bool2;
      float f3;
      float f4;
      do
      {
        do
        {
          return bool1;
          this.ed.g(paramMotionEvent);
          i = paramMotionEvent.getAction();
          bool2 = true;
          switch (i & 0xFF)
          {
          default: 
            return true;
          case 0: 
            f1 = paramMotionEvent.getX();
            f2 = paramMotionEvent.getY();
            this.bg = f1;
            this.bh = f2;
            return true;
          }
          bool1 = bool2;
        } while (!F(this.dX));
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        f3 = f1 - this.bg;
        f4 = f2 - this.bh;
        i = this.ed.getTouchSlop();
        bool1 = bool2;
      } while (f3 * f3 + f4 * f4 >= i * i);
      bool1 = bool2;
    } while (!this.ed.d(this.dX, (int)f1, (int)f2));
    f(this.dX, 0);
    return true;
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.dW)) {
      if (paramView1 != this.dX) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.ee = bool;
      return;
    }
  }
  
  void z(View paramView)
  {
    if (this.ec != null) {
      this.ec.d(paramView, this.dY);
    }
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public SlidingPaneLayout.SavedState[] E(int paramAnonymousInt)
      {
        return new SlidingPaneLayout.SavedState[paramAnonymousInt];
      }
      
      public SlidingPaneLayout.SavedState b(Parcel paramAnonymousParcel)
      {
        return new SlidingPaneLayout.SavedState(paramAnonymousParcel, null);
      }
    };
    boolean em;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.em = bool;
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      if (this.em) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
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
      parama1.setMovementGranularities(parama2.getMovementGranularities());
    }
    
    public void a(View paramView, android.support.v4.view.a.a parama)
    {
      android.support.v4.view.a.a locala = android.support.v4.view.a.a.a(parama);
      super.a(paramView, locala);
      a(parama, locala);
      locala.recycle();
      parama.setClassName(SlidingPaneLayout.class.getName());
      parama.setSource(paramView);
      paramView = p.h(paramView);
      if ((paramView instanceof View)) {
        parama.setParent((View)paramView);
      }
      int j = SlidingPaneLayout.this.getChildCount();
      int i = 0;
      while (i < j)
      {
        paramView = SlidingPaneLayout.this.getChildAt(i);
        if ((!x(paramView)) && (paramView.getVisibility() == 0))
        {
          p.b(paramView, 1);
          parama.addChild(paramView);
        }
        i += 1;
      }
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
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
      return SlidingPaneLayout.this.F(paramView);
    }
  }
  
  private class b
    implements Runnable
  {
    final View ei;
    
    b(View paramView)
    {
      this.ei = paramView;
    }
    
    public void run()
    {
      if (this.ei.getParent() == SlidingPaneLayout.this)
      {
        p.a(this.ei, 0, null);
        SlidingPaneLayout.a(SlidingPaneLayout.this, this.ei);
      }
      SlidingPaneLayout.f(SlidingPaneLayout.this).remove(this);
    }
  }
  
  private class c
    extends i.a
  {
    private c() {}
    
    public void B(int paramInt)
    {
      if (SlidingPaneLayout.b(SlidingPaneLayout.this).ai() == 0)
      {
        if (SlidingPaneLayout.c(SlidingPaneLayout.this) == 0.0F)
        {
          SlidingPaneLayout.this.C(SlidingPaneLayout.d(SlidingPaneLayout.this));
          SlidingPaneLayout.this.B(SlidingPaneLayout.d(SlidingPaneLayout.this));
          SlidingPaneLayout.a(SlidingPaneLayout.this, false);
        }
      }
      else {
        return;
      }
      SlidingPaneLayout.this.A(SlidingPaneLayout.d(SlidingPaneLayout.this));
      SlidingPaneLayout.a(SlidingPaneLayout.this, true);
    }
    
    public int a(View paramView, int paramInt1, int paramInt2)
    {
      paramView = (SlidingPaneLayout.d)SlidingPaneLayout.d(SlidingPaneLayout.this).getLayoutParams();
      paramInt2 = SlidingPaneLayout.this.getPaddingLeft();
      paramInt2 = paramView.leftMargin + paramInt2;
      int i = SlidingPaneLayout.e(SlidingPaneLayout.this);
      return Math.min(Math.max(paramInt1, paramInt2), i + paramInt2);
    }
    
    public void a(View paramView, float paramFloat1, float paramFloat2)
    {
      SlidingPaneLayout.d locald = (SlidingPaneLayout.d)paramView.getLayoutParams();
      int i = SlidingPaneLayout.this.getPaddingLeft();
      int j = locald.leftMargin + i;
      if (paramFloat1 <= 0.0F)
      {
        i = j;
        if (paramFloat1 == 0.0F)
        {
          i = j;
          if (SlidingPaneLayout.c(SlidingPaneLayout.this) <= 0.5F) {}
        }
      }
      else
      {
        i = j + SlidingPaneLayout.e(SlidingPaneLayout.this);
      }
      SlidingPaneLayout.b(SlidingPaneLayout.this).g(i, paramView.getTop());
      SlidingPaneLayout.this.invalidate();
    }
    
    public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      SlidingPaneLayout.a(SlidingPaneLayout.this, paramInt1);
      SlidingPaneLayout.this.invalidate();
    }
    
    public boolean d(View paramView, int paramInt)
    {
      if (SlidingPaneLayout.a(SlidingPaneLayout.this)) {
        return false;
      }
      return ((SlidingPaneLayout.d)paramView.getLayoutParams()).ej;
    }
    
    public void e(View paramView, int paramInt)
    {
      SlidingPaneLayout.this.ae();
    }
    
    public void f(int paramInt1, int paramInt2)
    {
      SlidingPaneLayout.b(SlidingPaneLayout.this).h(SlidingPaneLayout.d(SlidingPaneLayout.this), paramInt2);
    }
    
    public int y(View paramView)
    {
      return SlidingPaneLayout.e(SlidingPaneLayout.this);
    }
  }
  
  public static class d
    extends ViewGroup.MarginLayoutParams
  {
    private static final int[] ATTRS = { 16843137 };
    boolean ej;
    boolean ek;
    Paint el;
    public float weight = 0.0F;
    
    public d()
    {
      super(-1);
    }
    
    public d(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
      this.weight = paramContext.getFloat(0, 0.0F);
      paramContext.recycle();
    }
    
    public d(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public d(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  public static abstract interface e
  {
    public abstract void G(View paramView);
    
    public abstract void H(View paramView);
    
    public abstract void d(View paramView, float paramFloat);
  }
  
  static abstract interface f
  {
    public abstract void b(SlidingPaneLayout paramSlidingPaneLayout, View paramView);
  }
  
  static class g
    implements SlidingPaneLayout.f
  {
    public void b(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      p.a(paramSlidingPaneLayout, paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    }
  }
  
  static class h
    extends SlidingPaneLayout.g
  {
    private Method en;
    private Field eo;
    
    h()
    {
      try
      {
        this.en = View.class.getDeclaredMethod("getDisplayList", (Class[])null);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;)
        {
          try
          {
            this.eo = View.class.getDeclaredField("mRecreateDisplayList");
            this.eo.setAccessible(true);
            return;
          }
          catch (NoSuchFieldException localNoSuchFieldException)
          {
            Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", localNoSuchFieldException);
          }
          localNoSuchMethodException = localNoSuchMethodException;
          Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", localNoSuchMethodException);
        }
      }
    }
    
    public void b(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      if ((this.en != null) && (this.eo != null)) {
        try
        {
          this.eo.setBoolean(paramView, true);
          this.en.invoke(paramView, (Object[])null);
          super.b(paramSlidingPaneLayout, paramView);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("SlidingPaneLayout", "Error refreshing display list state", localException);
          }
        }
      }
      paramView.invalidate();
    }
  }
  
  static class i
    extends SlidingPaneLayout.g
  {
    public void b(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      p.a(paramView, ((SlidingPaneLayout.d)paramView.getLayoutParams()).el);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/widget/SlidingPaneLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */