package com.jiubang.playsdk.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListView
  extends AdapterView
{
  private boolean A = false;
  private boolean B = false;
  private View.OnClickListener C;
  private DataSetObserver D = new i(this);
  private Runnable E = new j(this);
  protected Scroller a = new Scroller(getContext());
  protected ListAdapter b;
  protected int c;
  protected int d;
  private final k e = new k(this, null);
  private GestureDetector f;
  private int g;
  private List h = new ArrayList();
  private boolean i = false;
  private Rect j = new Rect();
  private View k = null;
  private int l = 0;
  private Drawable m = null;
  private Integer n = null;
  private int o = Integer.MAX_VALUE;
  private int p;
  private int q;
  private int r;
  private p s = null;
  private int t = 0;
  private boolean u = false;
  private n v = null;
  private o w = o.a;
  private EdgeEffectCompat x;
  private EdgeEffectCompat y;
  private int z;
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.x = new EdgeEffectCompat(paramContext);
    this.y = new EdgeEffectCompat(paramContext);
    this.f = new GestureDetector(paramContext, this.e);
    b();
    c();
    a(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    if (Build.VERSION.SDK_INT >= 11) {
      l.a(this.a, 0.009F);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 + paramInt2 + this.l < getWidth()) && (this.q + 1 < this.b.getCount()))
    {
      this.q += 1;
      if (this.p < 0) {
        this.p = this.q;
      }
      View localView = this.b.getView(this.q, c(this.q), this);
      a(localView, -1);
      if (this.q == 0) {}
      for (int i1 = 0;; i1 = this.l)
      {
        paramInt1 += i1 + localView.getMeasuredWidth();
        m();
        break;
      }
    }
  }
  
  private void a(int paramInt, View paramView)
  {
    paramInt = this.b.getItemViewType(paramInt);
    if (d(paramInt)) {
      ((Queue)this.h.get(paramInt)).offer(paramView);
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, com.jiubang.playsdk.k.b);
      paramAttributeSet = paramContext.getDrawable(1);
      if (paramAttributeSet != null) {
        a(paramAttributeSet);
      }
      int i1 = paramContext.getDimensionPixelSize(3, 0);
      if (i1 != 0) {
        a(i1);
      }
      paramContext.recycle();
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if ((this.x != null) && (!this.x.isFinished()) && (n()))
    {
      i1 = paramCanvas.save();
      i2 = getHeight();
      paramCanvas.rotate(-90.0F, 0.0F, 0.0F);
      paramCanvas.translate(-i2 + getPaddingBottom(), 0.0F);
      this.x.setSize(i(), j());
      if (this.x.draw(paramCanvas)) {
        invalidate();
      }
      paramCanvas.restoreToCount(i1);
    }
    while ((this.y == null) || (this.y.isFinished()) || (!n())) {
      return;
    }
    int i1 = paramCanvas.save();
    int i2 = getWidth();
    paramCanvas.rotate(90.0F, 0.0F, 0.0F);
    paramCanvas.translate(getPaddingTop(), -i2);
    this.y.setSize(i(), j());
    if (this.y.draw(paramCanvas)) {
      invalidate();
    }
    paramCanvas.restoreToCount(i1);
  }
  
  private void a(Canvas paramCanvas, Rect paramRect)
  {
    if (this.m != null)
    {
      this.m.setBounds(paramRect);
      this.m.draw(paramCanvas);
    }
  }
  
  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = b(paramView);
    int i2 = ViewGroup.getChildMeasureSpec(this.z, getPaddingTop() + getPaddingBottom(), localLayoutParams.height);
    if (localLayoutParams.width > 0) {}
    for (int i1 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);; i1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(i1, i2);
      return;
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    addViewInLayout(paramView, paramInt, b(paramView), true);
    a(paramView);
  }
  
  private void a(o paramo)
  {
    if ((this.w != paramo) && (this.v != null)) {
      this.v.a(paramo);
    }
    this.w = paramo;
  }
  
  private void a(Boolean paramBoolean)
  {
    if (this.B != paramBoolean.booleanValue()) {}
    for (Object localObject = this;; localObject = (View)((View)localObject).getParent()) {
      if ((((View)localObject).getParent() instanceof View))
      {
        if (((((View)localObject).getParent() instanceof ListView)) || ((((View)localObject).getParent() instanceof ScrollView)))
        {
          ((View)localObject).getParent().requestDisallowInterceptTouchEvent(paramBoolean.booleanValue());
          this.B = paramBoolean.booleanValue();
        }
      }
      else {
        return;
      }
    }
  }
  
  private ViewGroup.LayoutParams b(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = localLayoutParams;
    if (localLayoutParams == null) {
      paramView = new ViewGroup.LayoutParams(-2, -1);
    }
    return paramView;
  }
  
  private void b()
  {
    setOnTouchListener(new h(this));
  }
  
  private void b(int paramInt)
  {
    this.h.clear();
    int i1 = 0;
    while (i1 < paramInt)
    {
      this.h.add(new LinkedList());
      i1 += 1;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 + paramInt2 - this.l > 0) && (this.p >= 1))
    {
      this.p -= 1;
      View localView = this.b.getView(this.p, c(this.p), this);
      a(localView, 0);
      int i1;
      label73:
      int i2;
      if (this.p == 0)
      {
        i1 = localView.getMeasuredWidth();
        i1 = paramInt1 - i1;
        i2 = this.g;
        if (i1 + paramInt2 != 0) {
          break label122;
        }
      }
      label122:
      for (paramInt1 = localView.getMeasuredWidth();; paramInt1 = this.l + localView.getMeasuredWidth())
      {
        this.g = (i2 - paramInt1);
        paramInt1 = i1;
        break;
        i1 = this.l + localView.getMeasuredWidth();
        break label73;
      }
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    int i2 = getChildCount();
    Rect localRect = this.j;
    this.j.top = getPaddingTop();
    this.j.bottom = (this.j.top + i());
    int i1 = 0;
    while (i1 < i2)
    {
      if ((i1 != i2 - 1) || (!i(this.q)))
      {
        View localView = getChildAt(i1);
        localRect.left = localView.getRight();
        localRect.right = (localView.getRight() + this.l);
        if (localRect.left < getPaddingLeft()) {
          localRect.left = getPaddingLeft();
        }
        if (localRect.right > getWidth() - getPaddingRight()) {
          localRect.right = (getWidth() - getPaddingRight());
        }
        a(paramCanvas, localRect);
        if ((i1 == 0) && (localView.getLeft() > getPaddingLeft()))
        {
          localRect.left = getPaddingLeft();
          localRect.right = localView.getLeft();
          a(paramCanvas, localRect);
        }
      }
      i1 += 1;
    }
  }
  
  private int c(int paramInt1, int paramInt2)
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      getChildAt(i1).getHitRect(this.j);
      if (this.j.contains(paramInt1, paramInt2)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private View c(int paramInt)
  {
    paramInt = this.b.getItemViewType(paramInt);
    if (d(paramInt)) {
      return (View)((Queue)this.h.get(paramInt)).poll();
    }
    return null;
  }
  
  private void c()
  {
    this.p = -1;
    this.q = -1;
    this.g = 0;
    this.c = 0;
    this.d = 0;
    this.o = Integer.MAX_VALUE;
    a(o.a);
  }
  
  private void d()
  {
    c();
    removeAllViewsInLayout();
    requestLayout();
  }
  
  private boolean d(int paramInt)
  {
    return paramInt < this.h.size();
  }
  
  private float e()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return m.a(this.a);
    }
    return 30.0F;
  }
  
  private void e(int paramInt)
  {
    int i2 = 0;
    View localView = h();
    if (localView != null) {}
    for (int i1 = localView.getRight();; i1 = 0)
    {
      a(i1, paramInt);
      localView = g();
      i1 = i2;
      if (localView != null) {
        i1 = localView.getLeft();
      }
      b(i1, paramInt);
      return;
    }
  }
  
  private void f(int paramInt)
  {
    View localView = g();
    if ((localView != null) && (localView.getRight() + paramInt <= 0))
    {
      int i2 = this.g;
      if (i(this.p)) {}
      for (int i1 = localView.getMeasuredWidth();; i1 = this.l + localView.getMeasuredWidth())
      {
        this.g = (i1 + i2);
        a(this.p, localView);
        removeViewInLayout(localView);
        this.p += 1;
        localView = g();
        break;
      }
    }
    for (localView = h(); (localView != null) && (localView.getLeft() + paramInt >= getWidth()); localView = h())
    {
      a(this.q, localView);
      removeViewInLayout(localView);
      this.q -= 1;
    }
  }
  
  private boolean f()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i(this.q))
    {
      View localView = h();
      bool1 = bool2;
      if (localView != null)
      {
        int i1 = this.o;
        int i2 = this.c;
        this.o = (localView.getRight() - getPaddingLeft() + i2 - j());
        if (this.o < 0) {
          this.o = 0;
        }
        bool1 = bool2;
        if (this.o != i1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private View g()
  {
    return getChildAt(0);
  }
  
  private void g(int paramInt)
  {
    int i2 = getChildCount();
    if (i2 > 0)
    {
      this.g += paramInt;
      int i1 = this.g;
      paramInt = 0;
      while (paramInt < i2)
      {
        View localView = getChildAt(paramInt);
        int i3 = getPaddingLeft() + i1;
        int i4 = getPaddingTop();
        localView.layout(i3, i4, localView.getMeasuredWidth() + i3, localView.getMeasuredHeight() + i4);
        i1 += localView.getMeasuredWidth() + this.l;
        paramInt += 1;
      }
    }
  }
  
  private View h()
  {
    return getChildAt(getChildCount() - 1);
  }
  
  private View h(int paramInt)
  {
    if ((paramInt >= this.p) && (paramInt <= this.q)) {
      getChildAt(paramInt - this.p);
    }
    return null;
  }
  
  private int i()
  {
    return getHeight() - getPaddingTop() - getPaddingBottom();
  }
  
  private boolean i(int paramInt)
  {
    return paramInt == this.b.getCount() - 1;
  }
  
  private int j()
  {
    return getWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private void j(int paramInt)
  {
    if ((this.x == null) || (this.y == null)) {}
    do
    {
      int i1;
      do
      {
        do
        {
          do
          {
            return;
            i1 = this.c + paramInt;
          } while ((this.a != null) && (!this.a.isFinished()));
          if (i1 >= 0) {
            break;
          }
          paramInt = Math.abs(paramInt);
          this.x.onPull(paramInt / j());
        } while (this.y.isFinished());
        this.y.onRelease();
        return;
      } while (i1 <= this.o);
      paramInt = Math.abs(paramInt);
      this.y.onPull(paramInt / j());
    } while (this.x.isFinished());
    this.x.onRelease();
  }
  
  private void k()
  {
    if (this.k != null)
    {
      this.k.setPressed(false);
      refreshDrawableState();
      this.k = null;
    }
  }
  
  private void l()
  {
    if (this.x != null) {
      this.x.onRelease();
    }
    if (this.y != null) {
      this.y.onRelease();
    }
  }
  
  private void m()
  {
    if ((this.s != null) && (this.b != null) && (this.b.getCount() - (this.q + 1) < this.t) && (!this.u))
    {
      this.u = true;
      this.s.a();
    }
  }
  
  private boolean n()
  {
    if ((this.b == null) || (this.b.isEmpty())) {}
    while (this.o <= 0) {
      return false;
    }
    return true;
  }
  
  public ListAdapter a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.l = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void a(Drawable paramDrawable)
  {
    this.m = paramDrawable;
    if (paramDrawable != null)
    {
      a(paramDrawable.getIntrinsicWidth());
      return;
    }
    a(0);
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    if (this.b != null) {
      this.b.unregisterDataSetObserver(this.D);
    }
    if (paramListAdapter != null)
    {
      this.u = false;
      this.b = paramListAdapter;
      this.b.registerDataSetObserver(this.D);
    }
    b(this.b.getViewTypeCount());
    d();
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    if (!this.a.isFinished()) {}
    for (boolean bool = true;; bool = false)
    {
      this.A = bool;
      this.a.forceFinished(true);
      a(o.a);
      k();
      if (!this.A)
      {
        int i1 = c((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if (i1 >= 0)
        {
          this.k = getChildAt(i1);
          if (this.k != null)
          {
            this.k.setPressed(true);
            refreshDrawableState();
          }
        }
      }
      return true;
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.a.fling(this.d, 0, (int)-paramFloat1, 0, 0, this.o, 0, 0);
    a(o.c);
    requestLayout();
    return true;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    a(paramCanvas);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean) {}
  
  protected float getLeftFadingEdgeStrength()
  {
    int i1 = getHorizontalFadingEdgeLength();
    if (this.c == 0) {
      return 0.0F;
    }
    if (this.c < i1) {
      return this.c / i1;
    }
    return 1.0F;
  }
  
  protected float getRightFadingEdgeStrength()
  {
    int i1 = getHorizontalFadingEdgeLength();
    if (this.c == this.o) {
      return 0.0F;
    }
    if (this.o - this.c < i1) {
      return (this.o - this.c) / i1;
    }
    return 1.0F;
  }
  
  public View getSelectedView()
  {
    return h(this.r);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    b(paramCanvas);
  }
  
  @SuppressLint({"WrongCall"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.b == null) {}
    do
    {
      return;
      invalidate();
      int i1;
      if (this.i)
      {
        i1 = this.c;
        c();
        removeAllViewsInLayout();
        this.d = i1;
        this.i = false;
      }
      if (this.n != null)
      {
        this.d = this.n.intValue();
        this.n = null;
      }
      if (this.a.computeScrollOffset()) {
        this.d = this.a.getCurrX();
      }
      if (this.d < 0)
      {
        this.d = 0;
        if (this.x.isFinished()) {
          this.x.onAbsorb((int)e());
        }
        this.a.forceFinished(true);
        a(o.a);
      }
      for (;;)
      {
        i1 = this.c - this.d;
        f(i1);
        e(i1);
        g(i1);
        this.c = this.d;
        if (!f()) {
          break;
        }
        onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
        if (this.d > this.o)
        {
          this.d = this.o;
          if (this.y.isFinished()) {
            this.y.onAbsorb((int)e());
          }
          this.a.forceFinished(true);
          a(o.a);
        }
      }
      if (!this.a.isFinished()) {
        break;
      }
    } while (this.w != o.c);
    a(o.a);
    return;
    ViewCompat.postOnAnimation(this, this.E);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.z = paramInt2;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.n = Integer.valueOf(paramParcelable.getInt("BUNDLE_ID_CURRENT_X"));
      super.onRestoreInstanceState(paramParcelable.getParcelable("BUNDLE_ID_PARENT_STATE"));
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
    localBundle.putInt("BUNDLE_ID_CURRENT_X", this.c);
    return localBundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if ((this.a == null) || (this.a.isFinished())) {
        a(o.a);
      }
      k();
      l();
      a(Boolean.valueOf(false));
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (paramMotionEvent.getAction() == 3)
      {
        k();
        l();
        a(Boolean.valueOf(false));
      }
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.C = paramOnClickListener;
  }
  
  public void setSelection(int paramInt)
  {
    this.r = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/HorizontalListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */