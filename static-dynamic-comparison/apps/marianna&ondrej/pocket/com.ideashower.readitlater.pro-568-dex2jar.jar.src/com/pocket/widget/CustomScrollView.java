package com.pocket.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class CustomScrollView
  extends ScrollView
{
  e a;
  
  public CustomScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setOnScrollListener(e parame)
  {
    this.a = parame;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/CustomScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */