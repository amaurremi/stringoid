package com.mocoplex.adlib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class AdlibViewGroup
  extends ViewGroup
{
  int a = 0;
  int b = 0;
  int c = 1;
  
  public AdlibViewGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdlibViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = getChildCount() - 1;
    if (k < 0) {
      return;
    }
    View localView = getChildAt(k);
    int j = paramInt3 - paramInt1;
    int i = paramInt4 - paramInt2;
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    localView.measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824));
    int m = localView.getMeasuredWidth();
    int n = localView.getMeasuredHeight();
    if (this.c == 2)
    {
      j = j - m / 2 - this.a;
      i = this.b - n / 2;
    }
    for (;;)
    {
      localView.layout(j, i, j + m, i + n);
      k -= 1;
      break;
      if (this.c == 3)
      {
        j = this.a - m / 2;
        i = i - n / 2 - this.b;
      }
      else if (this.c == 4)
      {
        j = j - m / 2 - this.a;
        i = i - n / 2 - this.b;
      }
      else
      {
        j = this.a - m / 2;
        i = this.b - n / 2;
      }
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
  }
  
  public void setPosition(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt2;
    this.b = paramInt3;
    this.c = paramInt1;
    if (paramInt2 < 0) {
      this.a = 0;
    }
    if (paramInt3 < 0) {
      this.b = 0;
    }
    if ((this.c <= 0) || (this.c > 4)) {
      this.c = 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/AdlibViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */