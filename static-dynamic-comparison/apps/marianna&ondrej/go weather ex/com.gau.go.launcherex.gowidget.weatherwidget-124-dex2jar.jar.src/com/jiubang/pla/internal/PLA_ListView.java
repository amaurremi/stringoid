package com.jiubang.pla.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ListAdapter;
import com.gau.go.launcherex.gowidget.weatherwidget.R.styleable;
import java.util.ArrayList;

public class PLA_ListView
  extends PLA_AbsListView
{
  Drawable R;
  int S;
  Drawable T;
  Drawable U;
  private ArrayList V = new ArrayList();
  private ArrayList W = new ArrayList();
  private boolean Z;
  private boolean aa;
  private boolean ab;
  private boolean ac;
  private boolean ad;
  private boolean ae = true;
  private boolean af = false;
  private final Rect ag = new Rect();
  private Paint ah;
  
  public PLA_ListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PLA_ListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772000);
  }
  
  public PLA_ListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ListView, paramInt, 0);
    paramAttributeSet = paramContext.getDrawable(3);
    if (paramAttributeSet != null) {
      b(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(4);
    if (paramAttributeSet != null) {
      c(paramAttributeSet);
    }
    paramInt = paramContext.getDimensionPixelSize(0, 0);
    if (paramInt != 0) {
      m(paramInt);
    }
    this.ac = paramContext.getBoolean(1, true);
    this.ad = paramContext.getBoolean(2, true);
    paramContext.recycle();
  }
  
  private void C()
  {
    int k = 0;
    int m = getChildCount();
    int j;
    int i;
    if (m > 0)
    {
      if (this.x) {
        break label68;
      }
      j = o() - this.l.top;
      i = j;
      if (this.B != 0) {
        i = j - this.S;
      }
      j = i;
      if (i >= 0) {
        break label117;
      }
      j = k;
    }
    label68:
    label117:
    for (;;)
    {
      if (j != 0) {
        b(-j);
      }
      return;
      j = r() - (getHeight() - this.l.bottom);
      i = j;
      if (m + this.B < this.M) {
        i = j + this.S;
      }
      j = k;
      if (i <= 0) {
        j = i;
      }
    }
  }
  
  private boolean D()
  {
    boolean bool = false;
    int i = getScrollY();
    int j = this.l.top;
    if ((this.B > 0) || (getChildAt(0).getTop() > i + j)) {
      bool = true;
    }
    return bool;
  }
  
  private boolean E()
  {
    int i = getChildCount();
    int j = getChildAt(i - 1).getBottom();
    int k = this.B;
    int m = getScrollY();
    int n = getHeight();
    int i1 = this.l.bottom;
    return (i + k - 1 < this.M - 1) || (j < m + n - i1);
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.L)
    {
      localView = this.g.c(paramInt1);
      if (localView != null)
      {
        a(localView, paramInt1, paramInt2, paramBoolean1, i(paramInt1), paramBoolean2, true);
        return localView;
      }
    }
    b(paramInt1, paramBoolean1);
    int i = i(paramInt1);
    View localView = a(paramInt1, this.A);
    a(localView, paramInt1, paramInt2, paramBoolean1, i, paramBoolean2, this.A[0]);
    return localView;
  }
  
  private View a(View paramView, int paramInt)
  {
    paramInt -= 1;
    View localView = a(paramInt, this.A);
    a(localView, paramInt, paramView.getTop() - this.S, false, this.l.left, false, this.A[0]);
    return localView;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    PLA_AbsListView.LayoutParams localLayoutParams2 = (PLA_AbsListView.LayoutParams)paramView.getLayoutParams();
    PLA_AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null)
    {
      localLayoutParams1 = new PLA_AbsListView.LayoutParams(-1, -2, 0);
      paramView.setLayoutParams(localLayoutParams1);
    }
    localLayoutParams1.a = this.c.getItemViewType(paramInt1);
    localLayoutParams1.c = true;
    paramInt2 = ViewGroup.getChildMeasureSpec(paramInt2, this.l.left + this.l.right, localLayoutParams1.width);
    paramInt1 = localLayoutParams1.height;
    if (paramInt1 > 0) {}
    for (paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);; paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(paramInt2, paramInt1);
      return;
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j;
    label27:
    int i;
    boolean bool;
    label55:
    int k;
    label67:
    label87:
    PLA_AbsListView.LayoutParams localLayoutParams1;
    int m;
    if ((paramBoolean2) && (i()))
    {
      paramBoolean2 = true;
      if (paramBoolean2 == paramView.isSelected()) {
        break label334;
      }
      j = 1;
      i = this.t;
      if ((i <= 0) || (i >= 3) || (this.o != paramInt1)) {
        break label340;
      }
      bool = true;
      if (bool == paramView.isPressed()) {
        break label346;
      }
      k = 1;
      if ((paramBoolean3) && (j == 0) && (!paramView.isLayoutRequested())) {
        break label352;
      }
      i = 1;
      PLA_AbsListView.LayoutParams localLayoutParams2 = (PLA_AbsListView.LayoutParams)paramView.getLayoutParams();
      localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new PLA_AbsListView.LayoutParams(-1, -2, 0);
      }
      localLayoutParams1.a = this.c.getItemViewType(paramInt1);
      if (((!paramBoolean3) || (localLayoutParams1.c)) && ((!localLayoutParams1.b) || (localLayoutParams1.a != -2))) {
        break label364;
      }
      if (!paramBoolean1) {
        break label358;
      }
      m = -1;
      label172:
      attachViewToParent(paramView, m, localLayoutParams1);
      if (j != 0) {
        paramView.setSelected(paramBoolean2);
      }
      if (k != 0) {
        paramView.setPressed(bool);
      }
      if (i == 0) {
        break label424;
      }
      k = ViewGroup.getChildMeasureSpec(this.m, this.l.left + this.l.right, localLayoutParams1.width);
      j = localLayoutParams1.height;
      if (j <= 0) {
        break label414;
      }
      j = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
      label258:
      b(paramView, paramInt1, k, j);
      label268:
      j = paramView.getMeasuredWidth();
      k = paramView.getMeasuredHeight();
      if (!paramBoolean1) {
        break label432;
      }
      label285:
      if (i == 0) {
        break label440;
      }
      a(paramView, paramInt1, paramInt3, paramInt2, paramInt3 + j, paramInt2 + k);
    }
    for (;;)
    {
      if ((this.n) && (!paramView.isDrawingCacheEnabled())) {
        paramView.setDrawingCacheEnabled(true);
      }
      return;
      paramBoolean2 = false;
      break;
      label334:
      j = 0;
      break label27;
      label340:
      bool = false;
      break label55;
      label346:
      k = 0;
      break label67;
      label352:
      i = 0;
      break label87;
      label358:
      m = 0;
      break label172;
      label364:
      localLayoutParams1.c = false;
      if (localLayoutParams1.a == -2) {
        localLayoutParams1.b = true;
      }
      if (paramBoolean1) {}
      for (m = -1;; m = 0)
      {
        addViewInLayout(paramView, m, localLayoutParams1, true);
        break;
      }
      label414:
      j = View.MeasureSpec.makeMeasureSpec(0, 0);
      break label258;
      label424:
      cleanupLayoutState(paramView);
      break label268;
      label432:
      paramInt2 -= k;
      break label285;
      label440:
      a(paramView, paramInt1, paramInt3 - paramView.getLeft(), paramInt2 - paramView.getTop());
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      int j = paramArrayList.size();
      int i = 0;
      while (i < j)
      {
        PLA_AbsListView.LayoutParams localLayoutParams = (PLA_AbsListView.LayoutParams)((p)paramArrayList.get(i)).a.getLayoutParams();
        if (localLayoutParams != null) {
          localLayoutParams.b = false;
        }
        i += 1;
      }
    }
  }
  
  private View b(View paramView, int paramInt)
  {
    paramInt += 1;
    View localView = a(paramInt, this.A);
    int i = paramView.getBottom();
    a(localView, paramInt, this.S + i, true, this.l.left, false, this.A[0]);
    return localView;
  }
  
  private View d(int paramInt1, int paramInt2)
  {
    int j = getBottom();
    int k = getTop();
    int m = this.l.bottom;
    int i = q() + this.S;
    paramInt2 = paramInt1;
    for (paramInt1 = i; (paramInt1 < j - k - m) && (paramInt2 < this.M); paramInt1 = q() + this.S)
    {
      a(paramInt2, j(paramInt2), true, false);
      paramInt2 += 1;
    }
    return null;
  }
  
  private View e(int paramInt1, int paramInt2)
  {
    int j = this.l.top;
    int i = p();
    paramInt2 = paramInt1;
    for (paramInt1 = i; (paramInt1 > j) && (paramInt2 >= 0); paramInt1 = k(paramInt2))
    {
      a(paramInt2, k(paramInt2), false, false);
      paramInt2 -= 1;
    }
    this.B = (paramInt2 + 1);
    return null;
  }
  
  private View f(int paramInt1, int paramInt2)
  {
    View localView = a(paramInt1, paramInt2, true, false);
    this.B = paramInt1;
    paramInt2 = this.S;
    if (!this.x)
    {
      e(paramInt1 - 1, localView.getTop() - paramInt2);
      C();
      d(paramInt1 + 1, localView.getBottom() + paramInt2);
      paramInt1 = getChildCount();
      if (paramInt1 > 0) {
        o(paramInt1);
      }
    }
    for (;;)
    {
      return null;
      d(paramInt1 + 1, localView.getBottom() + paramInt2);
      C();
      e(paramInt1 - 1, localView.getTop() - paramInt2);
      paramInt1 = getChildCount();
      if (paramInt1 > 0) {
        p(paramInt1);
      }
    }
  }
  
  private boolean f(View paramView)
  {
    ArrayList localArrayList = this.V;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (paramView == ((p)localArrayList.get(i)).a) {
        return true;
      }
      i += 1;
    }
    localArrayList = this.W;
    j = localArrayList.size();
    i = 0;
    while (i < j)
    {
      if (paramView == ((p)localArrayList.get(i)).a) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private View n(int paramInt)
  {
    this.B = Math.min(this.B, -1);
    this.B = Math.min(this.B, this.M - 1);
    if (this.B < 0) {
      this.B = 0;
    }
    return d(this.B, paramInt);
  }
  
  private void o(int paramInt)
  {
    if ((this.B + paramInt - 1 == this.M - 1) && (paramInt > 0))
    {
      paramInt = r();
      int i = getBottom() - getTop() - this.l.bottom - paramInt;
      int j = o();
      if ((i > 0) && ((this.B > 0) || (j < this.l.top)))
      {
        paramInt = i;
        if (this.B == 0) {
          paramInt = Math.min(i, this.l.top - j);
        }
        b(paramInt);
        if (this.B > 0)
        {
          paramInt = o();
          e(this.B - 1, paramInt - this.S);
          C();
        }
      }
    }
  }
  
  private void p(int paramInt)
  {
    int m;
    if ((this.B == 0) && (paramInt > 0))
    {
      int i = o();
      int k = this.l.top;
      int j = getBottom() - getTop() - this.l.bottom;
      i -= k;
      k = r();
      m = this.B + paramInt - 1;
      if (i > 0)
      {
        if ((m >= this.M - 1) && (k <= j)) {
          break label147;
        }
        paramInt = i;
        if (m == this.M - 1) {
          paramInt = Math.min(i, k - j);
        }
        b(-paramInt);
        if (m < this.M - 1)
        {
          d(m + 1, p() + this.S);
          C();
        }
      }
    }
    label147:
    while (m != this.M - 1) {
      return;
    }
    C();
  }
  
  private void q(int paramInt)
  {
    b(paramInt);
    int i = getHeight() - this.l.bottom;
    int j = this.l.top;
    h localh = this.g;
    View localView;
    if (paramInt < 0)
    {
      localView = B();
      paramInt = getChildCount();
      while (localView.getBottom() < i)
      {
        int k = this.B + paramInt - 1;
        if (k >= this.M - 1) {
          break;
        }
        b(localView, k);
        localView = B();
        paramInt += 1;
      }
      if (localView.getBottom() < i) {
        b(i - localView.getBottom());
      }
      localView = getChildAt(0);
      if (localView.getBottom() < j)
      {
        if (localh.b(((PLA_AbsListView.LayoutParams)localView.getLayoutParams()).a))
        {
          detachViewFromParent(localView);
          localh.a(localView);
        }
        for (;;)
        {
          localView = getChildAt(0);
          this.B += 1;
          break;
          removeViewInLayout(localView);
        }
      }
    }
    else
    {
      localView = getChildAt(0);
      while ((localView.getTop() > j) && (this.B > 0))
      {
        localView = a(localView, this.B);
        this.B -= 1;
      }
      if (localView.getTop() > j) {
        b(j - localView.getTop());
      }
      paramInt = getChildCount() - 1;
      localView = getChildAt(paramInt);
      if (localView.getTop() > i)
      {
        if (localh.b(((PLA_AbsListView.LayoutParams)localView.getLayoutParams()).a))
        {
          detachViewFromParent(localView);
          localh.a(localView);
        }
        for (;;)
        {
          paramInt -= 1;
          localView = getChildAt(paramInt);
          break;
          removeViewInLayout(localView);
        }
      }
    }
  }
  
  protected boolean A()
  {
    return true;
  }
  
  protected View B()
  {
    return getChildAt(getChildCount() - 1);
  }
  
  final int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int k = 0;
    Object localObject = this.c;
    if (localObject == null)
    {
      paramInt1 = this.l.top + this.l.bottom;
      return paramInt1;
    }
    int m = this.l.top + this.l.bottom;
    int i;
    label69:
    boolean bool;
    label111:
    View localView;
    if ((this.S > 0) && (this.R != null))
    {
      i = this.S;
      int j = paramInt3;
      if (paramInt3 == -1) {
        j = ((ListAdapter)localObject).getCount() - 1;
      }
      localObject = this.g;
      bool = A();
      boolean[] arrayOfBoolean = this.A;
      paramInt3 = paramInt2;
      paramInt2 = m;
      if (paramInt3 > j) {
        break label264;
      }
      localView = a(paramInt3, arrayOfBoolean);
      a(localView, paramInt3, paramInt1);
      if (paramInt3 <= 0) {
        break label266;
      }
      paramInt2 += i;
    }
    label264:
    label266:
    for (;;)
    {
      if ((bool) && (((h)localObject).b(((PLA_AbsListView.LayoutParams)localView.getLayoutParams()).a))) {
        ((h)localObject).a(localView);
      }
      paramInt2 = localView.getMeasuredHeight() + paramInt2;
      if (paramInt2 >= paramInt4)
      {
        paramInt1 = paramInt4;
        if (paramInt5 < 0) {
          break;
        }
        paramInt1 = paramInt4;
        if (paramInt3 <= paramInt5) {
          break;
        }
        paramInt1 = paramInt4;
        if (k <= 0) {
          break;
        }
        paramInt1 = paramInt4;
        if (paramInt2 == paramInt4) {
          break;
        }
        return k;
        i = 0;
        break label69;
      }
      m = k;
      if (paramInt5 >= 0)
      {
        m = k;
        if (paramInt3 >= paramInt5) {
          m = paramInt2;
        }
      }
      paramInt3 += 1;
      k = m;
      break label111;
      return paramInt2;
    }
  }
  
  int a(int paramInt, boolean paramBoolean)
  {
    ListAdapter localListAdapter = this.c;
    int i;
    if ((localListAdapter == null) || (isInTouchMode())) {
      i = -1;
    }
    int j;
    label125:
    do
    {
      do
      {
        return i;
        j = localListAdapter.getCount();
        if (this.ae) {
          break label125;
        }
        if (paramBoolean)
        {
          i = Math.max(0, paramInt);
          for (;;)
          {
            paramInt = i;
            if (i >= j) {
              break;
            }
            paramInt = i;
            if (localListAdapter.isEnabled(i)) {
              break;
            }
            i += 1;
          }
        }
        i = Math.min(paramInt, j - 1);
        for (;;)
        {
          paramInt = i;
          if (i < 0) {
            break;
          }
          paramInt = i;
          if (localListAdapter.isEnabled(i)) {
            break;
          }
          i -= 1;
        }
        if (paramInt < 0) {
          break;
        }
        i = paramInt;
      } while (paramInt < j);
      return -1;
      if (paramInt < 0) {
        break;
      }
      i = paramInt;
    } while (paramInt < j);
    return -1;
  }
  
  void a(Canvas paramCanvas, Rect paramRect, int paramInt)
  {
    Drawable localDrawable = this.R;
    boolean bool = this.ab;
    if (!bool) {
      localDrawable.setBounds(paramRect);
    }
    for (;;)
    {
      localDrawable.draw(paramCanvas);
      if (bool) {
        paramCanvas.restore();
      }
      return;
      paramCanvas.save();
      paramCanvas.clipRect(paramRect);
    }
  }
  
  void a(Canvas paramCanvas, Drawable paramDrawable, Rect paramRect)
  {
    int i = paramDrawable.getMinimumHeight();
    paramCanvas.save();
    paramCanvas.clipRect(paramRect);
    if (paramRect.bottom - paramRect.top < i) {
      paramRect.top = (paramRect.bottom - i);
    }
    paramDrawable.setBounds(paramRect);
    paramDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramView.offsetLeftAndRight(paramInt2);
    paramView.offsetTopAndBottom(paramInt3);
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramView.layout(paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void a(View paramView, Object paramObject, boolean paramBoolean)
  {
    if (this.c != null) {
      throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
    }
    p localp = new p(this);
    localp.a = paramView;
    localp.b = paramObject;
    localp.c = paramBoolean;
    this.V.add(localp);
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    if (this.c != null) {
      this.c.unregisterDataSetObserver(this.b);
    }
    c();
    this.g.b();
    if ((this.V.size() > 0) || (this.W.size() > 0))
    {
      this.c = new o(this.V, this.W, paramListAdapter);
      this.O = -1;
      this.P = Long.MIN_VALUE;
      if (this.c == null) {
        break label182;
      }
      this.ae = this.c.areAllItemsEnabled();
      this.N = this.M;
      this.M = this.c.getCount();
      x();
      this.b = new l(this);
      this.c.registerDataSetObserver(this.b);
      this.g.a(this.c.getViewTypeCount());
    }
    for (;;)
    {
      requestLayout();
      return;
      this.c = paramListAdapter;
      break;
      label182:
      this.ae = true;
      x();
    }
  }
  
  protected void b(int paramInt, boolean paramBoolean) {}
  
  void b(Canvas paramCanvas, Drawable paramDrawable, Rect paramRect)
  {
    int i = paramDrawable.getMinimumHeight();
    paramCanvas.save();
    paramCanvas.clipRect(paramRect);
    if (paramRect.bottom - paramRect.top < i) {
      paramRect.bottom = (i + paramRect.top);
    }
    paramDrawable.setBounds(paramRect);
    paramDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void b(Drawable paramDrawable)
  {
    this.T = paramDrawable;
    if (getScrollY() < 0) {
      invalidate();
    }
  }
  
  protected void b(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramView.measure(paramInt2, paramInt3);
  }
  
  public void b(View paramView, Object paramObject, boolean paramBoolean)
  {
    p localp = new p(this);
    localp.a = paramView;
    localp.b = paramObject;
    localp.c = paramBoolean;
    this.W.add(localp);
    if (this.b != null) {
      this.b.onChanged();
    }
  }
  
  public boolean b(View paramView, int paramInt, long paramLong)
  {
    return false | super.b(paramView, paramInt, paramLong);
  }
  
  int c(int paramInt)
  {
    int j = getChildCount();
    if (j > 0)
    {
      if (!this.x)
      {
        i = 0;
        while (i < j)
        {
          if (paramInt <= getChildAt(i).getBottom()) {
            return i + this.B;
          }
          i += 1;
        }
      }
      int i = j - 1;
      while (i >= 0)
      {
        if (paramInt >= getChildAt(i).getTop()) {
          return i + this.B;
        }
        i -= 1;
      }
    }
    return -1;
  }
  
  void c()
  {
    a(this.V);
    a(this.W);
    super.c();
    this.a = 0;
  }
  
  public void c(Drawable paramDrawable)
  {
    this.U = paramDrawable;
    invalidate();
  }
  
  public void c(View paramView)
  {
    a(paramView, null, true);
  }
  
  protected boolean canAnimate()
  {
    return (super.canAnimate()) && (this.M > 0);
  }
  
  protected void d()
  {
    Object localObject1 = null;
    View localView2 = null;
    boolean bool1 = this.Q;
    if (!bool1) {
      this.Q = true;
    }
    label55:
    int j;
    int k;
    int m;
    label128:
    View localView1;
    label135:
    boolean bool2;
    try
    {
      super.d();
      invalidate();
      if (this.c == null)
      {
        c();
        a();
      }
      for (;;)
      {
        return;
        j = this.l.top;
        k = getBottom() - getTop() - this.l.bottom;
        m = getChildCount();
        switch (this.a)
        {
        case 2: 
          localView1 = getChildAt(0);
          bool2 = this.L;
          if (bool2) {
            m();
          }
          if (this.M != 0) {
            break label173;
          }
          c();
          a();
          if (bool1) {}
          break;
        }
      }
      label173:
      if (this.M != this.c.getCount()) {
        throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.c.getClass() + ")]");
      }
    }
    finally
    {
      if (!bool1) {
        this.Q = false;
      }
    }
    int i = this.B;
    h localh = this.g;
    if (bool2)
    {
      i = 0;
      while (i < m)
      {
        localh.a(getChildAt(i));
        i += 1;
      }
    }
    localh.a(m, i);
    View localView3 = getFocusedChild();
    Object localObject3;
    if (localView3 != null)
    {
      if (bool2)
      {
        localObject3 = localView2;
        if (!f(localView3)) {}
      }
      else
      {
        localView2 = findFocus();
        localObject3 = localView2;
        if (localView2 != null)
        {
          localView2.onStartTemporaryDetach();
          localObject3 = localView2;
        }
      }
      requestFocus();
    }
    switch (this.a)
    {
    }
    for (;;)
    {
      if (m == 0)
      {
        detachAllViewsFromParent();
        if (!this.x)
        {
          n(j);
          label438:
          localh.c();
          if ((this.t <= 0) || (this.t >= 3)) {
            break label729;
          }
          localView1 = getChildAt(this.o - this.B);
          if (localView1 != null) {
            a(localView1);
          }
        }
      }
      for (;;)
      {
        if ((hasFocus()) && (localObject3 != null)) {
          ((View)localObject3).requestFocus();
        }
        if ((localObject3 != null) && (((View)localObject3).getWindowToken() != null)) {
          ((View)localObject3).onFinishTemporaryDetach();
        }
        this.a = 0;
        this.L = false;
        this.G = false;
        a();
        if (bool1) {
          break label55;
        }
        break;
        d(this.D);
        detachAllViewsFromParent();
        f(this.D, this.C);
        e(this.D);
        break label438;
        detachAllViewsFromParent();
        e(this.M - 1, k);
        C();
        break label438;
        detachAllViewsFromParent();
        this.B = 0;
        n(j);
        C();
        break label438;
        e(this.M - 1, k);
        break label438;
        if (this.B < this.M)
        {
          d(this.B);
          detachAllViewsFromParent();
          k = this.B;
          if (localView1 == null) {}
          for (i = j;; i = localView1.getTop())
          {
            f(k, i);
            e(this.B);
            break;
          }
        }
        d(0);
        detachAllViewsFromParent();
        f(0, j);
        e(0);
        break label438;
        label729:
        this.w = 0;
        this.f.setEmpty();
      }
      break label128;
      localView1 = null;
      break label135;
    }
  }
  
  protected void d(boolean paramBoolean)
  {
    int i = getChildCount();
    if (paramBoolean)
    {
      d(this.B + i, j(i + this.B));
      e(paramBoolean);
      return;
    }
    e(this.B - 1, k(this.B - 1));
    e(paramBoolean);
  }
  
  public boolean d(View paramView)
  {
    ArrayList localArrayList = this.V;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (((p)localArrayList.get(i)).a == paramView) {
        return true;
      }
      i += 1;
    }
    localArrayList = this.W;
    j = localArrayList.size();
    i = 0;
    while (i < j)
    {
      if (((p)localArrayList.get(i)).a == paramView) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i2 = this.S;
    Drawable localDrawable1 = this.T;
    Drawable localDrawable2 = this.U;
    int i;
    int j;
    label32:
    label47:
    Rect localRect;
    int i3;
    int i5;
    int i8;
    int i6;
    boolean bool1;
    boolean bool2;
    int i4;
    boolean bool3;
    ListAdapter localListAdapter;
    int m;
    label181:
    Paint localPaint;
    int i7;
    int n;
    label301:
    label306:
    int i1;
    if (localDrawable1 != null)
    {
      i = 1;
      if (localDrawable2 == null) {
        break label482;
      }
      j = 1;
      if ((i2 <= 0) || (this.R == null)) {
        break label487;
      }
      k = 1;
      if ((k == 0) && (i == 0) && (j == 0)) {
        break label619;
      }
      localRect = this.ag;
      localRect.left = getPaddingLeft();
      localRect.right = (getRight() - getLeft() - getPaddingRight());
      i3 = getChildCount();
      i5 = this.V.size();
      i8 = this.M;
      i6 = i8 - this.W.size() - 1;
      bool1 = this.ac;
      bool2 = this.ad;
      i4 = this.B;
      bool3 = this.ae;
      localListAdapter = this.c;
      if ((k == 0) || (!isOpaque()) || (super.isOpaque())) {
        break label493;
      }
      m = 1;
      if ((m != 0) && (this.ah == null) && (this.Z))
      {
        this.ah = new Paint();
        this.ah.setColor(n());
      }
      localPaint = this.ah;
      i7 = getBottom() - getTop() - this.l.bottom + getScrollY();
      if (this.x) {
        break label625;
      }
      n = getScrollY();
      if ((i3 > 0) && (n < 0))
      {
        if (i == 0) {
          break label499;
        }
        localRect.bottom = 0;
        localRect.top = n;
        a(paramCanvas, localDrawable1, localRect);
      }
      i = 0;
      n = 0;
      if (n >= i3) {
        break label566;
      }
      if (!bool1)
      {
        i1 = i;
        if (i4 + n < i5) {}
      }
      else if (!bool2)
      {
        i1 = i;
        if (i4 + n >= i6) {}
      }
      else
      {
        i = getChildAt(n).getBottom();
        i1 = i;
        if (k != 0)
        {
          i1 = i;
          if (i < i7) {
            if (j != 0)
            {
              i1 = i;
              if (n == i3 - 1) {}
            }
            else
            {
              if ((!bool3) && ((!localListAdapter.isEnabled(i4 + n)) || ((n != i3 - 1) && (!localListAdapter.isEnabled(i4 + n + 1))))) {
                break label529;
              }
              localRect.top = i;
              localRect.bottom = (i + i2);
              a(paramCanvas, localRect, n);
              i1 = i;
            }
          }
        }
      }
    }
    for (;;)
    {
      n += 1;
      i = i1;
      break label306;
      i = 0;
      break;
      label482:
      j = 0;
      break label32;
      label487:
      k = 0;
      break label47;
      label493:
      m = 0;
      break label181;
      label499:
      if (k == 0) {
        break label301;
      }
      localRect.bottom = 0;
      localRect.top = (-i2);
      a(paramCanvas, localRect, -1);
      break label301;
      label529:
      i1 = i;
      if (m != 0)
      {
        localRect.top = i;
        localRect.bottom = (i + i2);
        paramCanvas.drawRect(localRect, localPaint);
        i1 = i;
      }
    }
    label566:
    int k = getBottom() + getScrollY();
    if ((j != 0) && (i4 + i3 == i8) && (k > i))
    {
      localRect.top = i;
      localRect.bottom = k;
      b(paramCanvas, localDrawable2, localRect);
    }
    for (;;)
    {
      label619:
      super.dispatchDraw(paramCanvas);
      return;
      label625:
      i1 = this.l.top;
      n = getScrollY();
      if ((i3 > 0) && (i != 0))
      {
        localRect.top = n;
        localRect.bottom = getChildAt(0).getTop();
        a(paramCanvas, localDrawable1, localRect);
      }
      if (i != 0)
      {
        i = 1;
        if (i >= i3) {
          break label855;
        }
        if (((bool1) || (i4 + i >= i5)) && ((bool2) || (i4 + i < i6)))
        {
          i8 = getChildAt(i).getTop();
          if ((k != 0) && (i8 > i1))
          {
            if ((!bool3) && ((!localListAdapter.isEnabled(i4 + i)) || ((i != i3 - 1) && (!localListAdapter.isEnabled(i4 + i + 1))))) {
              break label822;
            }
            localRect.top = (i8 - i2);
            localRect.bottom = i8;
            a(paramCanvas, localRect, i - 1);
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        i = 0;
        break;
        label822:
        if (m != 0)
        {
          localRect.top = (i8 - i2);
          localRect.bottom = i8;
          paramCanvas.drawRect(localRect, localPaint);
        }
      }
      label855:
      if ((i3 > 0) && (n > 0)) {
        if (j != 0)
        {
          i = getBottom();
          localRect.top = i;
          localRect.bottom = (i + n);
          b(paramCanvas, localDrawable2, localRect);
        }
        else if (k != 0)
        {
          localRect.top = i7;
          localRect.bottom = (i7 + i2);
          a(paramCanvas, localRect, -1);
        }
      }
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    int k = 0;
    int i = 0;
    boolean bool = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (!bool)
    {
      int j = t();
      ListAdapter localListAdapter = z();
      int n = j;
      if (localListAdapter != null)
      {
        int i1 = localListAdapter.getCount();
        if (i1 < 15)
        {
          int m = 0;
          n = j;
          k = i;
          if (m < i1)
          {
            if (localListAdapter.isEnabled(m))
            {
              n = i + 1;
              k = j;
            }
            for (;;)
            {
              m += 1;
              j = k;
              i = n;
              break;
              k = j;
              n = i;
              if (m <= j)
              {
                k = j - 1;
                n = i;
              }
            }
          }
        }
        else
        {
          k = i1;
          n = j;
        }
      }
      paramAccessibilityEvent.setItemCount(k);
      paramAccessibilityEvent.setCurrentItemIndex(n);
    }
    return bool;
  }
  
  public void e(View paramView)
  {
    b(paramView, null, true);
  }
  
  protected void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      o(getChildCount());
      return;
    }
    p(getChildCount());
  }
  
  public void g(int paramInt)
  {
    if (paramInt >>> 24 == 255) {}
    for (boolean bool = true;; bool = false)
    {
      this.Z = bool;
      if (bool)
      {
        if (this.ah == null) {
          this.ah = new Paint();
        }
        this.ah.setColor(paramInt);
      }
      super.g(paramInt);
      return;
    }
  }
  
  protected int i(int paramInt)
  {
    return this.l.left;
  }
  
  public boolean isOpaque()
  {
    return ((this.n) && (this.Z) && (this.aa)) || (super.isOpaque());
  }
  
  protected int j(int paramInt)
  {
    paramInt = getChildCount();
    if (paramInt > 0) {
      return getChildAt(paramInt - 1).getBottom() + this.S;
    }
    return f();
  }
  
  public int k()
  {
    return this.V.size();
  }
  
  protected int k(int paramInt)
  {
    if (getChildCount() > 0) {
      return getChildAt(0).getTop() - this.S;
    }
    return getHeight() - g();
  }
  
  public int l()
  {
    return this.W.size();
  }
  
  public void l(int paramInt) {}
  
  public void m(int paramInt)
  {
    this.S = paramInt;
    b();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int j = getChildCount();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        c(getChildAt(i));
        i += 1;
      }
      removeAllViews();
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    int j = 0;
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    int i = -1;
    int m = i;
    Rect localRect;
    int k;
    if (paramBoolean)
    {
      m = i;
      if (paramRect != null)
      {
        paramRect.offset(getScrollX(), getScrollY());
        ListAdapter localListAdapter = this.c;
        if (localListAdapter.getCount() < getChildCount() + this.B)
        {
          this.a = 0;
          d();
        }
        localRect = this.ag;
        k = Integer.MAX_VALUE;
        int n = getChildCount();
        int i1 = this.B;
        m = i;
        if (j < n) {
          if (localListAdapter.isEnabled(i1 + j)) {}
        }
      }
    }
    for (;;)
    {
      j += 1;
      break;
      View localView = getChildAt(j);
      localView.getDrawingRect(localRect);
      offsetDescendantRectToMyCoords(localView, localRect);
      m = a(paramRect, localRect, paramInt);
      if (m < k)
      {
        k = m;
        i = j;
        continue;
        if (m >= 0)
        {
          l(this.B + m);
          return;
        }
        requestLayout();
        return;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int i;
    if (this.c == null)
    {
      paramInt2 = 0;
      this.M = paramInt2;
      if ((this.M <= 0) || ((n != 0) && (m != 0))) {
        break label240;
      }
      View localView = a(0, this.A);
      a(localView, 0, paramInt1);
      paramInt2 = localView.getMeasuredWidth();
      i = localView.getMeasuredHeight();
      if ((A()) && (this.g.b(((PLA_AbsListView.LayoutParams)localView.getLayoutParams()).a))) {
        this.g.a(localView);
      }
    }
    for (;;)
    {
      if (n == 0) {
        j = paramInt2 + (this.l.left + this.l.right) + getVerticalScrollbarWidth();
      }
      for (;;)
      {
        paramInt2 = k;
        if (m == 0) {
          paramInt2 = this.l.top + this.l.bottom + i + getVerticalFadingEdgeLength() * 2;
        }
        i = paramInt2;
        if (m == Integer.MIN_VALUE) {
          i = a(paramInt1, 0, -1, paramInt2, -1);
        }
        setMeasuredDimension(j, i);
        this.m = paramInt1;
        return;
        paramInt2 = this.c.getCount();
        break;
      }
      label240:
      i = 0;
      paramInt2 = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.af) && (paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    int n = paramRect.top;
    paramRect.offset(paramView.getLeft(), paramView.getTop());
    paramRect.offset(-paramView.getScrollX(), -paramView.getScrollY());
    int m = getHeight();
    int j = getScrollY();
    int k = j + m;
    int i1 = getVerticalFadingEdgeLength();
    int i = j;
    if (D())
    {
      i = j;
      if (n > i1) {
        i = j + i1;
      }
    }
    n = getChildAt(getChildCount() - 1).getBottom();
    j = k;
    if (E())
    {
      j = k;
      if (paramRect.bottom < n - i1) {
        j = k - i1;
      }
    }
    if ((paramRect.bottom > j) && (paramRect.top > i)) {
      if (paramRect.height() > m)
      {
        i = paramRect.top - i + 0;
        i = Math.min(i, n - j);
      }
    }
    for (;;)
    {
      if (i != 0) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        if (paramBoolean)
        {
          q(-i);
          a(paramView);
          this.w = paramView.getTop();
          invalidate();
        }
        return paramBoolean;
        i = paramRect.bottom - j + 0;
        break;
        if ((paramRect.top >= i) || (paramRect.bottom >= j)) {
          break label314;
        }
        if (paramRect.height() > m) {}
        for (j = 0 - (j - paramRect.bottom);; j = 0 - (i - paramRect.top))
        {
          i = Math.max(j, getChildAt(0).getTop() - i);
          break;
        }
      }
      label314:
      i = 0;
    }
  }
  
  public int v()
  {
    return Math.max(0, this.B - k());
  }
  
  public ListAdapter z()
  {
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/pla/internal/PLA_ListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */