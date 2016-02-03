package com.bubble.keyboard.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class FlowLayout
  extends ViewGroup
{
  private int line_height;
  
  static
  {
    if (!FlowLayout.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public FlowLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams instanceof LayoutParams);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(1, 1);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = getChildCount();
    paramInt4 = getPaddingLeft();
    paramInt2 = getPaddingTop();
    int j = 0;
    while (j < m)
    {
      View localView = getChildAt(j);
      int k = paramInt4;
      int i = paramInt2;
      if (localView.getVisibility() != 8)
      {
        int n = localView.getMeasuredWidth();
        int i1 = localView.getMeasuredHeight();
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        k = paramInt4;
        i = paramInt2;
        if (paramInt4 + n > paramInt3 - paramInt1)
        {
          k = getPaddingLeft();
          i = paramInt2 + this.line_height;
        }
        localView.layout(k, i, k + n, i + i1);
        k += localLayoutParams.horizontal_spacing + n;
      }
      j += 1;
      paramInt4 = k;
      paramInt2 = i;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    assert (View.MeasureSpec.getMode(paramInt1) != 0);
    int i4 = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int i3 = View.MeasureSpec.getSize(paramInt2) - getPaddingTop() - getPaddingBottom();
    int i5 = getChildCount();
    int j = 0;
    int i = getPaddingLeft();
    paramInt1 = getPaddingTop();
    if (View.MeasureSpec.getMode(paramInt2) == Integer.MIN_VALUE) {}
    for (int k = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);; k = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      int m = 0;
      while (m < i5)
      {
        View localView = getChildAt(m);
        int i2 = j;
        int i1 = i;
        int n = paramInt1;
        if (localView.getVisibility() != 8)
        {
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          localView.measure(View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE), k);
          i1 = localView.getMeasuredWidth();
          i2 = Math.max(j, localView.getMeasuredHeight() + localLayoutParams.vertical_spacing);
          n = i;
          j = paramInt1;
          if (i + i1 > i4)
          {
            n = getPaddingLeft();
            j = paramInt1 + i2;
          }
          i1 = n + (localLayoutParams.horizontal_spacing + i1);
          n = j;
        }
        m += 1;
        j = i2;
        i = i1;
        paramInt1 = n;
      }
    }
    this.line_height = j;
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      i = paramInt1 + j;
    }
    for (;;)
    {
      setMeasuredDimension(i4, i);
      return;
      i = i3;
      if (View.MeasureSpec.getMode(paramInt2) == Integer.MIN_VALUE)
      {
        i = i3;
        if (paramInt1 + j < i3) {
          i = paramInt1 + j;
        }
      }
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    public final int horizontal_spacing;
    public final int vertical_spacing;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(0);
      this.horizontal_spacing = paramInt1;
      this.vertical_spacing = paramInt2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/keyboard/layout/FlowLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */