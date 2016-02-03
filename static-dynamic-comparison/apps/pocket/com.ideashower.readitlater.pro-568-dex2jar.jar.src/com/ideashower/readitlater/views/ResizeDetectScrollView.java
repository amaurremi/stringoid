package com.ideashower.readitlater.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ResizeDetectScrollView
  extends ScrollView
  implements x
{
  private u a;
  
  public ResizeDetectScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ResizeDetectScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ResizeDetectScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ResizeDetectScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */