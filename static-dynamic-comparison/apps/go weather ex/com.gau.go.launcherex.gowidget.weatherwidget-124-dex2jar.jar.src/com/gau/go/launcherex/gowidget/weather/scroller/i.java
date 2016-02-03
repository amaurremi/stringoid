package com.gau.go.launcherex.gowidget.weather.scroller;

public abstract interface i
{
  public abstract h getScreenScroller();
  
  public abstract int getScrollX();
  
  public abstract int getScrollY();
  
  public abstract void onFlingIntercepted();
  
  public abstract void onFlingStart();
  
  public abstract void onScreenChanged(int paramInt1, int paramInt2);
  
  public abstract void onScrollChanged(int paramInt1, int paramInt2);
  
  public abstract void onScrollFinish(int paramInt);
  
  public abstract void onScrollStart();
  
  public abstract void postInvalidate();
  
  public abstract void scrollBy(int paramInt1, int paramInt2);
  
  public abstract void setScreenScroller(h paramh);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/scroller/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */