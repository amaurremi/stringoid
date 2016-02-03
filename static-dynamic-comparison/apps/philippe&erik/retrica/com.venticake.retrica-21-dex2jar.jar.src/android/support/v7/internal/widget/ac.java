package android.support.v7.internal.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.b.k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.SpinnerAdapter;

class ac
  extends AbsSpinnerICS
  implements DialogInterface.OnClickListener
{
  int E;
  private ag F;
  private ae G;
  private int H;
  private Rect I = new Rect();
  
  ac(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  ac(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, k.Spinner, paramInt1, 0);
    int i = paramInt2;
    if (paramInt2 == -1) {
      i = localTypedArray.getInt(7, 0);
    }
    switch (i)
    {
    }
    for (;;)
    {
      this.H = localTypedArray.getInt(0, 17);
      this.F.a(localTypedArray.getString(6));
      localTypedArray.recycle();
      if (this.G != null)
      {
        this.F.a(this.G);
        this.G = null;
      }
      return;
      this.F = new ad(this, null);
      continue;
      paramContext = new af(this, paramContext, paramAttributeSet, paramInt1);
      this.E = localTypedArray.getLayoutDimension(3, -2);
      paramContext.a(localTypedArray.getDrawable(2));
      paramInt1 = localTypedArray.getDimensionPixelOffset(5, 0);
      if (paramInt1 != 0) {
        paramContext.c(paramInt1);
      }
      paramInt1 = localTypedArray.getDimensionPixelOffset(4, 0);
      if (paramInt1 != 0) {
        paramContext.b(paramInt1);
      }
      this.F = paramContext;
    }
  }
  
  private void c(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = generateDefaultLayoutParams();
    }
    addViewInLayout(paramView, 0, localLayoutParams1);
    paramView.setSelected(hasFocus());
    int i = ViewGroup.getChildMeasureSpec(this.b, this.i.top + this.i.bottom, localLayoutParams1.height);
    paramView.measure(ViewGroup.getChildMeasureSpec(this.c, this.i.left + this.i.right, localLayoutParams1.width), i);
    i = this.i.top + (getMeasuredHeight() - this.i.bottom - this.i.top - paramView.getMeasuredHeight()) / 2;
    int j = paramView.getMeasuredHeight();
    paramView.layout(0, i, paramView.getMeasuredWidth() + 0, j + i);
  }
  
  private View e(int paramInt)
  {
    if (!this.u)
    {
      localView = this.j.a(paramInt);
      if (localView != null)
      {
        c(localView);
        return localView;
      }
    }
    View localView = this.a.getView(paramInt, null, this);
    c(localView);
    return localView;
  }
  
  int a(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i = Math.max(0, f());
    int i2 = Math.min(paramSpinnerAdapter.getCount(), i + 15);
    int j = Math.max(0, i - (15 - (i2 - i)));
    View localView = null;
    int k = 0;
    i = 0;
    if (j < i2)
    {
      int m = paramSpinnerAdapter.getItemViewType(j);
      if (m == i) {
        break label198;
      }
      localView = null;
      i = m;
    }
    label198:
    for (;;)
    {
      localView = paramSpinnerAdapter.getView(j, localView, this);
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      if (paramDrawable != null)
      {
        paramDrawable.getPadding(this.I);
        return this.I.left + this.I.right + k;
      }
      return k;
    }
  }
  
  public void a(n paramn)
  {
    throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
  }
  
  public void a(SpinnerAdapter paramSpinnerAdapter)
  {
    super.a(paramSpinnerAdapter);
    if (this.F != null)
    {
      this.F.a(new ae(paramSpinnerAdapter));
      return;
    }
    this.G = new ae(paramSpinnerAdapter);
  }
  
  void b(int paramInt, boolean paramBoolean)
  {
    paramInt = this.i.left;
    int i = getRight() - getLeft() - this.i.left - this.i.right;
    if (this.u) {
      k();
    }
    if (this.z == 0)
    {
      a();
      return;
    }
    if (this.v >= 0) {
      c(this.v);
    }
    b();
    removeAllViewsInLayout();
    this.k = this.x;
    View localView = e(this.x);
    int j = localView.getMeasuredWidth();
    switch (this.H & 0x7)
    {
    }
    for (;;)
    {
      localView.offsetLeftAndRight(paramInt);
      this.j.a();
      invalidate();
      l();
      this.u = false;
      this.p = false;
      d(this.x);
      return;
      paramInt = paramInt + i / 2 - j / 2;
      continue;
      paramInt = paramInt + i - j;
    }
  }
  
  void b(n paramn)
  {
    super.a(paramn);
  }
  
  public int getBaseline()
  {
    int j = -1;
    Object localObject2 = null;
    Object localObject1;
    if (getChildCount() > 0) {
      localObject1 = getChildAt(0);
    }
    for (;;)
    {
      int i = j;
      if (localObject1 != null)
      {
        int k = ((View)localObject1).getBaseline();
        i = j;
        if (k >= 0) {
          i = ((View)localObject1).getTop() + k;
        }
      }
      return i;
      localObject1 = localObject2;
      if (this.a != null)
      {
        localObject1 = localObject2;
        if (this.a.getCount() > 0)
        {
          localObject1 = e(0);
          this.j.a(0, (View)localObject1);
          removeAllViewsInLayout();
        }
      }
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a(paramInt);
    paramDialogInterface.dismiss();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.F != null) && (this.F.f())) {
      this.F.d();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.r = true;
    b(0, false);
    this.r = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.F != null) && (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(d(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public boolean performClick()
  {
    boolean bool2 = super.performClick();
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool2 = true;
      bool1 = bool2;
      if (!this.F.f())
      {
        this.F.c();
        bool1 = bool2;
      }
    }
    return bool1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */