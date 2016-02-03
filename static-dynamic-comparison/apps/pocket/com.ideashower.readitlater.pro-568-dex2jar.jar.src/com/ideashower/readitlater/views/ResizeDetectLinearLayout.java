package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;

public class ResizeDetectLinearLayout
  extends LinearLayout
  implements x
{
  private u a;
  private final com.pocket.i.a.m b = new com.pocket.i.a.m();
  private int c;
  private boolean d;
  
  public ResizeDetectLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ResizeDetectLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, b.PocketLinearLayout);
    paramAttributeSet = paramContext.getColorStateList(0);
    int i = paramContext.getDimensionPixelSize(1, 0);
    int j = paramContext.getDimensionPixelSize(2, 0);
    if (paramAttributeSet != null) {
      a(paramAttributeSet, i, j);
    }
    paramContext.recycle();
  }
  
  public void a(ColorStateList paramColorStateList, int paramInt1, int paramInt2)
  {
    this.d = true;
    this.b.a(paramColorStateList, getDrawableState());
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(paramInt1);
    this.c = paramInt2;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.d)
    {
      this.b.a(getDrawableState());
      int j = getChildCount();
      int i = 1;
      if (i < j)
      {
        View localView1 = getChildAt(i);
        View localView2 = getChildAt(i - 1);
        float f;
        if (getOrientation() == 0) {
          if ((localView2 != null) && (localView2.getVisibility() == 0))
          {
            f = localView1.getLeft();
            paramCanvas.drawLine(f, this.c, f, getHeight() - this.c, this.b);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          f = localView1.getTop();
          paramCanvas.drawLine(this.c, f, getWidth() - this.c, f, this.b);
        }
      }
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    mergeDrawableStates(arrayOfInt, com.ideashower.readitlater.h.m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setOnResizeListener(u paramu)
  {
    this.a = paramu;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ResizeDetectLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */