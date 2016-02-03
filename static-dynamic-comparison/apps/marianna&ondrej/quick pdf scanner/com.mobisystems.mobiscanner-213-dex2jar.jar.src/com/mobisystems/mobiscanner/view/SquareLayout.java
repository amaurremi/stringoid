package com.mobisystems.mobiscanner.view;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.mobisystems.mobiscanner.a.a;
import com.mobisystems.mobiscanner.common.d;

public class SquareLayout
  extends FrameLayout
{
  private int aLY;
  
  public SquareLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public SquareLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.aLY = 0;
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, a.a.SquareImageButton, 0, 0);
    try
    {
      this.aLY = paramContext.getDimensionPixelSize(0, 0);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (View.MeasureSpec.getMode(paramInt1) == 0) {}
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (1 == d.ah(getContext()))
    {
      if (paramInt1 > paramInt2) {
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth() - this.aLY);
      }
      return;
    }
    setMeasuredDimension(getMeasuredHeight(), getMeasuredHeight());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/view/SquareLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */