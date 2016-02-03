package com.gtp.nextlauncher.widget.weatherwidget;

abstract interface y
{
  public abstract HourlyTypeView getHourlyTypeView();
  
  public abstract boolean getIfHourSwitchReady();
  
  public abstract boolean getIfTrendSwitchReady();
  
  public abstract WeatherTrendView getTrendView();
  
  public abstract void onHourlyViewHide();
  
  public abstract void onTrendViewHide();
  
  public abstract void setHourDisappearStart();
  
  public abstract void setTrendDisappearStart();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */