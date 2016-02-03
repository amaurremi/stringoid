package com.pocket.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View.MeasureSpec;
import android.view.WindowManager;

public class ShadowView
  extends ThemedView
{
  private Drawable a;
  
  public ShadowView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ShadowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ShadowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(int paramInt)
  {
    int k = View.MeasureSpec.getMode(paramInt);
    int i = View.MeasureSpec.getSize(paramInt);
    if (k == 1073741824) {
      paramInt = i;
    }
    int j;
    do
    {
      return paramInt;
      j = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
      paramInt = j;
    } while (k != Integer.MIN_VALUE);
    return Math.min(j, i);
  }
  
  private void a()
  {
    if (this.a == null) {
      return;
    }
    this.a.setBounds(0, 0, getWidth(), getHeight());
  }
  
  private int b(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    int j = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {
      return j;
    }
    if (this.a != null) {}
    for (paramInt = this.a.getIntrinsicHeight(); i == Integer.MIN_VALUE; paramInt = 0) {
      return Math.min(paramInt, j);
    }
    return paramInt;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.a != null) {
      this.a.setState(getDrawableState());
    }
    invalidate();
  }
  
  public int getIntrinsicHeight()
  {
    if (this.a != null) {
      return this.a.getIntrinsicHeight();
    }
    return 0;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a != null) {
      this.a.draw(paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      a();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(paramInt1), b(paramInt2));
  }
  
  public void setDrawable(Drawable paramDrawable)
  {
    this.a = paramDrawable;
    a();
    requestLayout();
    invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ShadowView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */