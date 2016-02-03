package org.a.a.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class a
  extends ViewGroup
{
  private final SparseIntArray a = new SparseIntArray();
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private boolean e = false;
  private int f;
  private boolean g;
  
  public a(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private int a(b paramb)
  {
    if (paramb.b()) {
      return b.b(paramb);
    }
    return this.c;
  }
  
  private Paint a(int paramInt)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt);
    localPaint.setStrokeWidth(2.0F);
    return localPaint;
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, com.ideashower.readitlater.b.FlowLayout);
    try
    {
      a(paramContext);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void a(TypedArray paramTypedArray)
  {
    this.b = paramTypedArray.getDimensionPixelSize(0, 0);
    this.c = paramTypedArray.getDimensionPixelSize(1, 0);
    this.d = paramTypedArray.getInteger(2, 0);
    this.e = paramTypedArray.getBoolean(3, false);
    this.g = paramTypedArray.getBoolean(4, false);
    this.f = paramTypedArray.getInteger(5, 0);
  }
  
  private void a(Canvas paramCanvas, View paramView)
  {
    if (!this.e) {}
    Paint localPaint3;
    label436:
    label543:
    for (;;)
    {
      return;
      Paint localPaint1 = a(65280);
      Paint localPaint2 = a(-16711936);
      localPaint3 = a(-65536);
      b localb = (b)paramView.getLayoutParams();
      if (b.c(localb) > 0)
      {
        f1 = paramView.getRight();
        f2 = paramView.getTop();
        f2 = paramView.getHeight() / 2.0F + f2;
        paramCanvas.drawLine(f1, f2, f1 + b.c(localb), f2, localPaint1);
        paramCanvas.drawLine(b.c(localb) + f1 - 4.0F, f2 - 4.0F, f1 + b.c(localb), f2, localPaint1);
        paramCanvas.drawLine(b.c(localb) + f1 - 4.0F, f2 + 4.0F, f1 + b.c(localb), f2, localPaint1);
        if (b.b(localb) <= 0) {
          break label436;
        }
        f1 = paramView.getLeft();
        f1 = paramView.getWidth() / 2.0F + f1;
        f2 = paramView.getBottom();
        paramCanvas.drawLine(f1, f2, f1, f2 + b.b(localb), localPaint1);
        paramCanvas.drawLine(f1 - 4.0F, b.b(localb) + f2 - 4.0F, f1, f2 + b.b(localb), localPaint1);
        paramCanvas.drawLine(f1 + 4.0F, b.b(localb) + f2 - 4.0F, f1, f2 + b.b(localb), localPaint1);
      }
      for (;;)
      {
        if (!b.a(localb)) {
          break label543;
        }
        if (this.d != 0) {
          break label545;
        }
        f1 = paramView.getLeft();
        f2 = paramView.getTop() + paramView.getHeight() / 2.0F;
        paramCanvas.drawLine(f1, f2 - 6.0F, f1, f2 + 6.0F, localPaint3);
        return;
        if (this.b <= 0) {
          break;
        }
        f1 = paramView.getRight();
        f2 = paramView.getTop() + paramView.getHeight() / 2.0F;
        paramCanvas.drawLine(f1, f2, f1 + this.b, f2, localPaint2);
        paramCanvas.drawLine(this.b + f1 - 4.0F, f2 - 4.0F, f1 + this.b, f2, localPaint2);
        paramCanvas.drawLine(this.b + f1 - 4.0F, f2 + 4.0F, f1 + this.b, f2, localPaint2);
        break;
        if (this.c > 0)
        {
          f1 = paramView.getLeft() + paramView.getWidth() / 2.0F;
          f2 = paramView.getBottom();
          paramCanvas.drawLine(f1, f2, f1, f2 + this.c, localPaint2);
          paramCanvas.drawLine(f1 - 4.0F, this.c + f2 - 4.0F, f1, f2 + this.c, localPaint2);
          paramCanvas.drawLine(f1 + 4.0F, this.c + f2 - 4.0F, f1, f2 + this.c, localPaint2);
        }
      }
    }
    label545:
    float f1 = paramView.getLeft() + paramView.getWidth() / 2.0F;
    float f2 = paramView.getTop();
    paramCanvas.drawLine(f1 - 6.0F, f2, 6.0F + f1, f2, localPaint3);
  }
  
  private int b(b paramb)
  {
    if (paramb.a()) {
      return b.c(paramb);
    }
    return this.b;
  }
  
  public b a(AttributeSet paramAttributeSet)
  {
    return new b(getContext(), paramAttributeSet);
  }
  
  protected b a(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new b(paramLayoutParams);
  }
  
  protected void c(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramInt, com.ideashower.readitlater.b.FlowLayout);
    try
    {
      a(localTypedArray);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof b;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    a(paramCanvas, paramView);
    return bool;
  }
  
  protected b j()
  {
    return new b(-2, -2);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = getChildCount();
    int i = 0;
    View localView;
    int j;
    if (i < m)
    {
      localView = getChildAt(i);
      b localb = (b)localView.getLayoutParams();
      paramInt2 = b.d(localb);
      paramInt1 = b.e(localb);
      paramInt3 = b.d(localb);
      paramInt3 = localView.getMeasuredWidth() + paramInt3;
      paramInt4 = b.e(localb) + localView.getMeasuredHeight();
      if ((!b.f(localb)) && (!this.g)) {
        break label208;
      }
      j = this.a.get(b.g(localb));
      if (this.d == 0)
      {
        j = (int)((j - localView.getMeasuredHeight()) / 2.0F);
        paramInt1 = localView.getMeasuredHeight() + j;
        paramInt4 = paramInt2;
        paramInt2 = paramInt3;
        paramInt3 = j;
      }
    }
    for (;;)
    {
      localView.layout(paramInt4, paramInt3, paramInt2, paramInt1);
      i += 1;
      break;
      paramInt3 = (int)((j - localView.getMeasuredWidth()) / 2.0F);
      j = localView.getMeasuredWidth() + paramInt3;
      paramInt2 = paramInt4;
      paramInt4 = paramInt3;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = j;
      continue;
      return;
      label208:
      j = paramInt1;
      int k = paramInt2;
      paramInt1 = paramInt4;
      paramInt2 = paramInt3;
      paramInt3 = j;
      paramInt4 = k;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.a.clear();
    int i5 = View.MeasureSpec.getSize(paramInt1) - getPaddingRight() - getPaddingLeft();
    int j = View.MeasureSpec.getSize(paramInt2);
    int k = getPaddingTop();
    int m = getPaddingBottom();
    int i = View.MeasureSpec.getMode(paramInt1);
    int i4 = View.MeasureSpec.getMode(paramInt2);
    if (this.d == 0) {
      i4 = i;
    }
    int i3;
    int i9;
    int i1;
    int n;
    View localView;
    for (;;)
    {
      m = 0;
      k = 0;
      i3 = 0;
      i9 = 0;
      i1 = 0;
      j = 0;
      n = 0;
      i = 0;
      int i13 = getChildCount();
      for (int i6 = 0;; i6 = i7)
      {
        if (i6 >= i13) {
          break label555;
        }
        localView = getChildAt(i6);
        if (localView.getVisibility() != 8) {
          break;
        }
        i7 = j;
        j = i;
        i2 = m;
        m = k;
        k = i9;
        i = i7;
        i7 = i6 + 1;
        i6 = i;
        i9 = k;
        k = m;
        m = i2;
        i = j;
        j = i6;
      }
      i5 = j - k - m;
    }
    b localb = (b)localView.getLayoutParams();
    localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localb.width), getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localb.height));
    int i10 = b(localb);
    int i8 = a(localb);
    int i2 = localView.getMeasuredWidth();
    int i7 = localView.getMeasuredHeight();
    label285:
    int i11;
    label323:
    int i12;
    if (this.d == 0)
    {
      n = i2;
      i2 = i7;
      i11 = i9 + n;
      if ((this.f == -1) || ((!b.a(localb)) && ((i4 == 0) || (i11 <= i5)))) {
        break label525;
      }
      i9 = 1;
      if (i9 == 0) {
        break label669;
      }
      i11 = i2 + i8;
      m += 1;
      i12 = i10 + n;
      i9 = i2;
      i1 += k;
      i3 = n;
      i10 = i11;
      k = i12;
    }
    for (;;)
    {
      i10 = Math.max(i10, i8 + i2);
      i8 = Math.max(i9, i2);
      if (this.d == 0)
      {
        i2 = getPaddingLeft() + i3 - n;
        n = getPaddingTop() + i1;
        label420:
        localb.a(i2, n);
        i2 = Math.max(j, i3);
        n = i1 + i8;
        if ((this.f <= 0) || (m != this.f - 1)) {
          break label666;
        }
        i = n;
      }
      label525:
      label555:
      label666:
      for (;;)
      {
        b.a(localb, m);
        this.a.put(m, i8);
        j = i;
        i = i2;
        i2 = m;
        m = i10;
        i3 = i8;
        break;
        n = i7;
        i11 = i8;
        i8 = i10;
        i10 = i11;
        break label285;
        i9 = 0;
        break label323;
        i2 = getPaddingLeft() + i1;
        n = getPaddingTop() + i3 - i7;
        break label420;
        if (i != 0) {}
        for (;;)
        {
          if (this.d == 0) {
            j += getPaddingLeft() + getPaddingRight();
          }
          for (i = getPaddingBottom() + getPaddingTop() + i; this.d == 0; i = getPaddingLeft() + getPaddingRight() + i)
          {
            setMeasuredDimension(resolveSize(j, paramInt1), resolveSize(i, paramInt2));
            return;
            j += getPaddingBottom() + getPaddingTop();
          }
          setMeasuredDimension(resolveSize(i, paramInt1), resolveSize(j, paramInt2));
          return;
          i = n;
        }
      }
      label669:
      i9 = i11;
      i12 = i11 + i10;
      i10 = i3;
      i11 = k;
      i3 = i9;
      k = i12;
      i9 = i10;
      i10 = i11;
    }
  }
  
  public void setMaxLines(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */