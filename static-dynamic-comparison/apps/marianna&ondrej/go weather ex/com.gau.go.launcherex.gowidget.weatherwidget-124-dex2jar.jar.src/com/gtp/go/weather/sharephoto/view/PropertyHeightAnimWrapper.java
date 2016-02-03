package com.gtp.go.weather.sharephoto.view;

import android.view.View;

public class PropertyHeightAnimWrapper
{
  private View mContent;
  
  public PropertyHeightAnimWrapper(View paramView)
  {
    this.mContent = paramView;
  }
  
  public int getHeight()
  {
    return this.mContent.getHeight();
  }
  
  public void setHeight(int paramInt)
  {
    this.mContent.getLayoutParams().height = paramInt;
    this.mContent.requestLayout();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/view/PropertyHeightAnimWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */