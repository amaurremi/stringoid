package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout.LayoutParams;

public class TabsLinearLayout
  extends IcsLinearLayout
{
  private static final int LinearLayout_measureWithLargestChild = 0;
  private static final int[] R_styleable_LinearLayout = { 16843476 };
  private boolean mUseLargestChild;
  
  public TabsLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R_styleable_LinearLayout);
    this.mUseLargestChild = paramContext.getBoolean(0, false);
    paramContext.recycle();
  }
  
  private void useLargestChildHorizontal()
  {
    int m = getChildCount();
    int i = 0;
    int j = 0;
    while (i < m)
    {
      j = Math.max(getChildAt(i).getMeasuredWidth(), j);
      i += 1;
    }
    int k = 0;
    i = 0;
    View localView;
    if (k < m)
    {
      localView = getChildAt(k);
      if (localView == null) {
        break label172;
      }
      if (localView.getVisibility() != 8) {}
    }
    label172:
    for (;;)
    {
      k += 1;
      break;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.weight > 0.0F)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824));
        i += j;
      }
      for (;;)
      {
        int n = localLayoutParams.leftMargin;
        i = localLayoutParams.rightMargin + n + i;
        break;
        i += localView.getMeasuredWidth();
      }
      setMeasuredDimension(getPaddingLeft() + getPaddingRight() + i, getMeasuredHeight());
      return;
    }
  }
  
  public boolean isMeasureWithLargestChildEnabled()
  {
    return this.mUseLargestChild;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildCount() <= 2) {}
    do
    {
      return;
      paramInt1 = View.MeasureSpec.getMode(paramInt1);
    } while ((!this.mUseLargestChild) || (paramInt1 != 0) || (getOrientation() != 0));
    useLargestChildHorizontal();
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean)
  {
    this.mUseLargestChild = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/widget/TabsLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */