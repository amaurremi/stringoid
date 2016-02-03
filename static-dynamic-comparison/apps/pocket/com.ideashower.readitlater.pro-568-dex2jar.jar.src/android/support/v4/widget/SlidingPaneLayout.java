package android.support.v4.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.ag;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;

public class SlidingPaneLayout
  extends ViewGroup
{
  static final s a = new t();
  private int b;
  private int c;
  private Drawable d;
  private final int e;
  private boolean f;
  private View g;
  private float h;
  private float i;
  private int j;
  private boolean k;
  private int l;
  private float m;
  private float n;
  private r o;
  private final w p;
  private boolean q;
  private boolean r;
  private final Rect s;
  private final ArrayList t;
  
  static
  {
    int i1 = Build.VERSION.SDK_INT;
    if (i1 >= 17)
    {
      a = new v();
      return;
    }
    if (i1 >= 16)
    {
      a = new u();
      return;
    }
  }
  
  private void a(float paramFloat)
  {
    int i2 = 0;
    Object localObject = (q)this.g.getLayoutParams();
    int i1;
    if ((((q)localObject).c) && (((q)localObject).leftMargin <= 0))
    {
      i1 = 1;
      int i3 = getChildCount();
      label38:
      if (i2 >= i3) {
        return;
      }
      localObject = getChildAt(i2);
      if (localObject != this.g) {
        break label72;
      }
    }
    for (;;)
    {
      i2 += 1;
      break label38;
      i1 = 0;
      break;
      label72:
      int i4 = (int)((1.0F - this.i) * this.l);
      this.i = paramFloat;
      ((View)localObject).offsetLeftAndRight(i4 - (int)((1.0F - paramFloat) * this.l));
      if (i1 != 0) {
        a((View)localObject, 1.0F - this.i, this.c);
      }
    }
  }
  
  private void a(View paramView, float paramFloat, int paramInt)
  {
    q localq = (q)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      i1 = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (localq.d == null) {
        localq.d = new Paint();
      }
      localq.d.setColorFilter(new PorterDuffColorFilter(i1 << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
      if (ag.d(paramView) != 2) {
        ag.a(paramView, 2, localq.d);
      }
      d(paramView);
    }
    while (ag.d(paramView) == 0)
    {
      int i1;
      return;
    }
    if (localq.d != null) {
      localq.d.setColorFilter(null);
    }
    paramView = new p(this, paramView);
    this.t.add(paramView);
    ag.a(this, paramView);
  }
  
  private boolean a(View paramView, int paramInt)
  {
    boolean bool = false;
    if ((this.r) || (a(0.0F, paramInt)))
    {
      this.q = false;
      bool = true;
    }
    return bool;
  }
  
  private boolean b(View paramView, int paramInt)
  {
    if ((this.r) || (a(1.0F, paramInt)))
    {
      this.q = true;
      return true;
    }
    return false;
  }
  
  private static boolean c(View paramView)
  {
    if (ag.g(paramView)) {}
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
  
  private void d(View paramView)
  {
    a.a(this, paramView);
  }
  
  void a()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
      i1 += 1;
    }
  }
  
  void a(View paramView)
  {
    int i7 = getPaddingLeft();
    int i8 = getWidth();
    int i9 = getPaddingRight();
    int i10 = getPaddingTop();
    int i11 = getHeight();
    int i12 = getPaddingBottom();
    int i4;
    int i3;
    int i2;
    int i1;
    if ((paramView != null) && (c(paramView)))
    {
      i4 = paramView.getLeft();
      i3 = paramView.getRight();
      i2 = paramView.getTop();
      i1 = paramView.getBottom();
    }
    int i5;
    View localView;
    for (;;)
    {
      int i13 = getChildCount();
      i5 = 0;
      if (i5 < i13)
      {
        localView = getChildAt(i5);
        if (localView != paramView) {
          break;
        }
      }
      return;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      i4 = 0;
    }
    int i6 = Math.max(i7, localView.getLeft());
    int i14 = Math.max(i10, localView.getTop());
    int i15 = Math.min(i8 - i9, localView.getRight());
    int i16 = Math.min(i11 - i12, localView.getBottom());
    if ((i6 >= i4) && (i14 >= i2) && (i15 <= i3) && (i16 <= i1)) {}
    for (i6 = 4;; i6 = 0)
    {
      localView.setVisibility(i6);
      i5 += 1;
      break;
    }
  }
  
  boolean a(float paramFloat, int paramInt)
  {
    if (!this.f) {
      return false;
    }
    q localq = (q)this.g.getLayoutParams();
    paramInt = getPaddingLeft();
    paramInt = (int)(localq.leftMargin + paramInt + this.j * paramFloat);
    if (this.p.a(this.g, paramInt, this.g.getTop()))
    {
      a();
      ag.b(this);
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    return b(this.g, 0);
  }
  
  boolean b(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView = (q)paramView.getLayoutParams();
    if ((this.f) && (paramView.c) && (this.h > 0.0F)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean c()
  {
    return a(this.g, 0);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof q)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if (this.p.a(true))
    {
      if (!this.f) {
        this.p.f();
      }
    }
    else {
      return;
    }
    ag.b(this);
  }
  
  public boolean d()
  {
    return (!this.f) || (this.h == 1.0F);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (getChildCount() > 1) {}
    for (View localView = getChildAt(1); (localView == null) || (this.d == null); localView = null) {
      return;
    }
    int i1 = this.d.getIntrinsicWidth();
    int i2 = localView.getLeft();
    int i3 = localView.getTop();
    int i4 = localView.getBottom();
    this.d.setBounds(i2 - i1, i3, i2, i4);
    this.d.draw(paramCanvas);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    q localq = (q)paramView.getLayoutParams();
    int i1 = paramCanvas.save(2);
    if ((this.f) && (!localq.b) && (this.g != null))
    {
      paramCanvas.getClipBounds(this.s);
      this.s.right = Math.min(this.s.right, this.g.getLeft());
      paramCanvas.clipRect(this.s);
    }
    boolean bool;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = super.drawChild(paramCanvas, paramView, paramLong);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i1);
      return bool;
      if ((localq.c) && (this.h > 0.0F))
      {
        if (!paramView.isDrawingCacheEnabled()) {
          paramView.setDrawingCacheEnabled(true);
        }
        Bitmap localBitmap = paramView.getDrawingCache();
        if (localBitmap != null)
        {
          paramCanvas.drawBitmap(localBitmap, paramView.getLeft(), paramView.getTop(), localq.d);
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
  
  public boolean e()
  {
    return this.f;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new q();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new q(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new q((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new q(paramLayoutParams);
  }
  
  public int getCoveredFadeColor()
  {
    return this.c;
  }
  
  public int getParallaxDistance()
  {
    return this.l;
  }
  
  public int getSliderFadeColor()
  {
    return this.b;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.r = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.r = true;
    int i2 = this.t.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((p)this.t.get(i1)).run();
      i1 += 1;
    }
    this.t.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i1 = android.support.v4.view.v.a(paramMotionEvent);
    if ((!this.f) && (i1 == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null) {
        if (this.p.b(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          break label108;
        }
      }
    }
    label108:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.q = bool1;
      if ((this.f) && ((!this.k) || (i1 == 0))) {
        break;
      }
      this.p.e();
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    if ((i1 == 3) || (i1 == 1))
    {
      this.p.e();
      return false;
    }
    switch (i1)
    {
    }
    label164:
    float f1;
    float f2;
    do
    {
      for (i1 = 0;; i1 = 1)
      {
        if (!this.p.a(paramMotionEvent))
        {
          bool1 = bool2;
          if (i1 == 0) {
            break;
          }
        }
        return true;
        this.k = false;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.m = f1;
        this.n = f2;
        if ((!this.p.b(this.g, (int)f1, (int)f2)) || (!b(this.g))) {
          break label164;
        }
      }
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      f2 = Math.abs(f2 - this.m);
      f1 = Math.abs(f1 - this.n);
    } while ((f2 <= this.p.d()) || (f1 <= f2));
    this.p.e();
    this.k = true;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = paramInt3 - paramInt1;
    paramInt1 = getPaddingLeft();
    int i3 = getPaddingRight();
    int i4 = getPaddingTop();
    int i1 = getChildCount();
    if (this.r) {
      if ((!this.f) || (!this.q)) {
        break label98;
      }
    }
    View localView;
    label98:
    for (float f1 = 1.0F;; f1 = 0.0F)
    {
      this.h = f1;
      paramInt4 = 0;
      paramInt2 = paramInt1;
      for (;;)
      {
        if (paramInt4 >= i1) {
          break label332;
        }
        localView = getChildAt(paramInt4);
        if (localView.getVisibility() != 8) {
          break;
        }
        paramInt4 += 1;
      }
    }
    q localq = (q)localView.getLayoutParams();
    int i5 = localView.getMeasuredWidth();
    if (localq.b)
    {
      paramInt3 = localq.leftMargin;
      int i6 = localq.rightMargin;
      paramInt3 = Math.min(paramInt1, i2 - i3 - this.e) - paramInt2 - (paramInt3 + i6);
      this.j = paramInt3;
      if (localq.leftMargin + paramInt2 + paramInt3 + i5 / 2 > i2 - i3)
      {
        paramBoolean = true;
        label198:
        localq.c = paramBoolean;
        paramInt3 = (int)(paramInt3 * this.h);
        i6 = localq.leftMargin;
        this.h = (paramInt3 / this.j);
        paramInt2 = i6 + paramInt3 + paramInt2;
        paramInt3 = 0;
      }
    }
    for (;;)
    {
      paramInt3 = paramInt2 - paramInt3;
      localView.layout(paramInt3, i4, paramInt3 + i5, localView.getMeasuredHeight() + i4);
      paramInt1 += localView.getWidth();
      break;
      paramBoolean = false;
      break label198;
      if ((this.f) && (this.l != 0))
      {
        paramInt3 = (int)((1.0F - this.h) * this.l);
        paramInt2 = paramInt1;
      }
      else
      {
        paramInt3 = 0;
        paramInt2 = paramInt1;
      }
    }
    label332:
    if (this.r)
    {
      if (!this.f) {
        break label407;
      }
      if (this.l != 0) {
        a(this.h);
      }
      if (((q)this.g.getLayoutParams()).c) {
        a(this.g, this.h, this.b);
      }
    }
    for (;;)
    {
      a(this.g);
      this.r = false;
      return;
      label407:
      paramInt1 = 0;
      while (paramInt1 < i1)
      {
        a(getChildAt(paramInt1), 0.0F, this.b);
        paramInt1 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (i3 != 1073741824) {
      if (isInEditMode()) {
        if (i3 == Integer.MIN_VALUE)
        {
          paramInt2 = i1;
          i1 = i2;
        }
      }
    }
    for (;;)
    {
      label85:
      boolean bool1;
      int i7;
      int i6;
      float f1;
      label133:
      View localView;
      q localq;
      switch (i1)
      {
      default: 
        paramInt1 = 0;
        i3 = -1;
        bool1 = false;
        i2 = paramInt2 - getPaddingLeft() - getPaddingRight();
        i7 = getChildCount();
        if (i7 > 2) {
          Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.g = null;
        i6 = 0;
        f1 = 0.0F;
        if (i6 >= i7) {
          break label612;
        }
        localView = getChildAt(i6);
        localq = (q)localView.getLayoutParams();
        if (localView.getVisibility() == 8)
        {
          localq.c = false;
          i4 = i2;
          i2 = paramInt1;
          paramInt1 = i4;
        }
        break;
      }
      float f2;
      for (;;)
      {
        i6 += 1;
        i4 = i2;
        i2 = paramInt1;
        paramInt1 = i4;
        break label133;
        if (i3 != 0) {
          break label1088;
        }
        i1 = i2;
        paramInt2 = 300;
        break;
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        if (i2 != 0) {
          break label1088;
        }
        if (isInEditMode())
        {
          if (i2 != 0) {
            break label1088;
          }
          i2 = Integer.MIN_VALUE;
          paramInt2 = i1;
          paramInt1 = 300;
          i1 = i2;
          break;
        }
        throw new IllegalStateException("Height must not be UNSPECIFIED");
        paramInt1 = paramInt1 - getPaddingTop() - getPaddingBottom();
        i3 = paramInt1;
        break label85;
        i3 = getPaddingTop();
        i4 = getPaddingBottom();
        i2 = 0;
        i3 = paramInt1 - i3 - i4;
        paramInt1 = i2;
        break label85;
        f2 = f1;
        if (localq.a <= 0.0F) {
          break label370;
        }
        f1 += localq.a;
        f2 = f1;
        if (localq.width != 0) {
          break label370;
        }
        i4 = paramInt1;
        paramInt1 = i2;
        i2 = i4;
      }
      label370:
      int i4 = localq.leftMargin + localq.rightMargin;
      label405:
      int i5;
      label425:
      int i8;
      if (localq.width == -2)
      {
        i4 = View.MeasureSpec.makeMeasureSpec(paramInt2 - i4, Integer.MIN_VALUE);
        if (localq.height != -2) {
          break label568;
        }
        i5 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        localView.measure(i4, i5);
        i5 = localView.getMeasuredWidth();
        i8 = localView.getMeasuredHeight();
        i4 = paramInt1;
        if (i1 == Integer.MIN_VALUE)
        {
          i4 = paramInt1;
          if (i8 > paramInt1) {
            i4 = Math.min(i8, i3);
          }
        }
        paramInt1 = i2 - i5;
        if (paramInt1 >= 0) {
          break label606;
        }
      }
      label568:
      label606:
      for (boolean bool2 = true;; bool2 = false)
      {
        localq.b = bool2;
        if (localq.b) {
          this.g = localView;
        }
        i2 = i4;
        bool1 = bool2 | bool1;
        f1 = f2;
        break;
        if (localq.width == -1)
        {
          i4 = View.MeasureSpec.makeMeasureSpec(paramInt2 - i4, 1073741824);
          break label405;
        }
        i4 = View.MeasureSpec.makeMeasureSpec(localq.width, 1073741824);
        break label405;
        if (localq.height == -1)
        {
          i5 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
          break label425;
        }
        i5 = View.MeasureSpec.makeMeasureSpec(localq.height, 1073741824);
        break label425;
      }
      label612:
      if ((bool1) || (f1 > 0.0F))
      {
        i6 = paramInt2 - this.e;
        i4 = 0;
        if (i4 < i7)
        {
          localView = getChildAt(i4);
          if (localView.getVisibility() == 8) {}
          for (;;)
          {
            i4 += 1;
            break;
            localq = (q)localView.getLayoutParams();
            if (localView.getVisibility() != 8)
            {
              if ((localq.width == 0) && (localq.a > 0.0F))
              {
                i1 = 1;
                label709:
                if (i1 == 0) {
                  break label805;
                }
                i5 = 0;
                label717:
                if ((!bool1) || (localView == this.g)) {
                  break label869;
                }
                if ((localq.width >= 0) || ((i5 <= i6) && (localq.a <= 0.0F))) {
                  continue;
                }
                if (i1 == 0) {
                  break label853;
                }
                if (localq.height != -2) {
                  break label815;
                }
                i1 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
              }
              for (;;)
              {
                localView.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), i1);
                break;
                i1 = 0;
                break label709;
                label805:
                i5 = localView.getMeasuredWidth();
                break label717;
                label815:
                if (localq.height == -1)
                {
                  i1 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                }
                else
                {
                  i1 = View.MeasureSpec.makeMeasureSpec(localq.height, 1073741824);
                  continue;
                  label853:
                  i1 = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                }
              }
              label869:
              if (localq.a > 0.0F)
              {
                if (localq.width == 0) {
                  if (localq.height == -2) {
                    i1 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                  }
                }
                for (;;)
                {
                  if (!bool1) {
                    break label1014;
                  }
                  i8 = localq.leftMargin;
                  i8 = paramInt2 - (localq.rightMargin + i8);
                  int i9 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
                  if (i5 == i8) {
                    break;
                  }
                  localView.measure(i9, i1);
                  break;
                  if (localq.height == -1)
                  {
                    i1 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                  }
                  else
                  {
                    i1 = View.MeasureSpec.makeMeasureSpec(localq.height, 1073741824);
                    continue;
                    i1 = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                  }
                }
                label1014:
                i8 = Math.max(0, i2);
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localq.a * i8 / f1) + i5, 1073741824), i1);
              }
            }
          }
        }
      }
      setMeasuredDimension(paramInt2, paramInt1);
      this.f = bool1;
      if ((this.p.a() != 0) && (!bool1)) {
        this.p.f();
      }
      return;
      label1088:
      paramInt2 = i1;
      i1 = i2;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SlidingPaneLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.a) {
      b();
    }
    for (;;)
    {
      this.q = paramParcelable.a;
      return;
      c();
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SlidingPaneLayout.SavedState localSavedState = new SlidingPaneLayout.SavedState(super.onSaveInstanceState());
    if (e()) {}
    for (boolean bool = d();; bool = this.q)
    {
      localSavedState.a = bool;
      return localSavedState;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      this.r = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    if (!this.f) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    float f1;
    float f2;
    do
    {
      int i1;
      boolean bool2;
      float f3;
      float f4;
      do
      {
        do
        {
          return bool1;
          this.p.b(paramMotionEvent);
          i1 = paramMotionEvent.getAction();
          bool2 = true;
          switch (i1 & 0xFF)
          {
          default: 
            return true;
          case 0: 
            f1 = paramMotionEvent.getX();
            f2 = paramMotionEvent.getY();
            this.m = f1;
            this.n = f2;
            return true;
          }
          bool1 = bool2;
        } while (!b(this.g));
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        f3 = f1 - this.m;
        f4 = f2 - this.n;
        i1 = this.p.d();
        bool1 = bool2;
      } while (f3 * f3 + f4 * f4 >= i1 * i1);
      bool1 = bool2;
    } while (!this.p.b(this.g, (int)f1, (int)f2));
    a(this.g, 0);
    return true;
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.f)) {
      if (paramView1 != this.g) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.q = bool;
      return;
    }
  }
  
  public void setCoveredFadeColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setPanelSlideListener(r paramr)
  {
    this.o = paramr;
  }
  
  public void setParallaxDistance(int paramInt)
  {
    this.l = paramInt;
    requestLayout();
  }
  
  public void setShadowDrawable(Drawable paramDrawable)
  {
    this.d = paramDrawable;
  }
  
  public void setShadowResource(int paramInt)
  {
    setShadowDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setSliderFadeColor(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/widget/SlidingPaneLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */