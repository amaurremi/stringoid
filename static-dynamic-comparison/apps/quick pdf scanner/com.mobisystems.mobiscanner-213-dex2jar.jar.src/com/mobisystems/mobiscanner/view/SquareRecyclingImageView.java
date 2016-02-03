package com.mobisystems.mobiscanner.view;

import android.content.Context;
import android.util.AttributeSet;

public class SquareRecyclingImageView
  extends RecyclingImageView
{
  public SquareRecyclingImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SquareRecyclingImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    setMeasuredDimension(paramInt1, paramInt1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/view/SquareRecyclingImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */