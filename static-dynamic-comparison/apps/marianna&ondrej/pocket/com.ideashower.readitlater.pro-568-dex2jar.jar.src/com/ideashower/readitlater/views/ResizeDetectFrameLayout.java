package com.ideashower.readitlater.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ResizeDetectFrameLayout
  extends FrameLayout
  implements x
{
  private u a;
  
  public ResizeDetectFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ResizeDetectFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ResizeDetectFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ResizeDetectFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */