package com.pocket.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.ideashower.readitlater.b;

public class MaxHeightScrollView
  extends ThemedScrollView
{
  private int a;
  
  public MaxHeightScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.PocketTheme);
    setMaxHeight(paramAttributeSet.getDimensionPixelSize(2, 0));
    paramAttributeSet.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt2), this.a), i));
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.a = paramInt;
    requestLayout();
    invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/MaxHeightScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */