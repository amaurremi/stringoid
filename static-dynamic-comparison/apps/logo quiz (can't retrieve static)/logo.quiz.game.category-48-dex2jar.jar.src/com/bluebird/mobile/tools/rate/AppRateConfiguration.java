package com.bluebird.mobile.tools.rate;

import com.bluebird.mobile.tools.R.layout;

public class AppRateConfiguration
{
  private String appTitle = "YOUR-APP-NAME";
  private int daysUntilPrompt = 0;
  private int dialogLayout = R.layout.app_rate;
  private String headerText;
  private int launchesUntilPrompt = 0;
  private int nextShowDelayInHours;
  private String rateURI;
  private boolean showOnlineOnly = false;
  
  public AppRateConfiguration() {}
  
  public AppRateConfiguration(String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, String paramString2)
  {
    this(paramString1, paramInt1, paramInt2, paramBoolean, paramString2, 0);
  }
  
  public AppRateConfiguration(String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, String paramString2, int paramInt3)
  {
    this.appTitle = paramString1;
    this.daysUntilPrompt = paramInt1;
    this.launchesUntilPrompt = paramInt2;
    this.showOnlineOnly = paramBoolean;
    this.headerText = paramString2;
    this.nextShowDelayInHours = paramInt3;
  }
  
  public String getAppTitle()
  {
    return this.appTitle;
  }
  
  public int getDaysUntilPrompt()
  {
    return this.daysUntilPrompt;
  }
  
  public int getDialogLayout()
  {
    return this.dialogLayout;
  }
  
  public String getHeaderText()
  {
    if (this.headerText == null) {
      if (this.appTitle != null) {
        break label25;
      }
    }
    label25:
    for (this.headerText = "If you enjoy playing, please rate us.<br/>Thanks for your support!";; this.headerText = ("If you enjoy playing '" + getAppTitle() + "', please rate it.<br/>Thanks for your support!")) {
      return this.headerText;
    }
  }
  
  public int getLaunchesUntilPrompt()
  {
    return this.launchesUntilPrompt;
  }
  
  public int getNextShowDelayInHours()
  {
    return this.nextShowDelayInHours;
  }
  
  public String getRateURI()
  {
    return this.rateURI;
  }
  
  public boolean isShowOnlineOnly()
  {
    return this.showOnlineOnly;
  }
  
  public void setAppTitle(String paramString)
  {
    this.appTitle = paramString;
  }
  
  public void setDaysUntilPrompt(int paramInt)
  {
    this.daysUntilPrompt = paramInt;
  }
  
  public void setDialogLayout(int paramInt)
  {
    this.dialogLayout = paramInt;
  }
  
  public void setHeaderText(String paramString)
  {
    this.headerText = paramString;
  }
  
  public void setLaunchesUntilPrompt(int paramInt)
  {
    this.launchesUntilPrompt = paramInt;
  }
  
  public void setNextShowDelayInHours(int paramInt)
  {
    this.nextShowDelayInHours = paramInt;
  }
  
  public void setRateURI(String paramString)
  {
    this.rateURI = paramString;
  }
  
  public void setShowOnlineOnly(boolean paramBoolean)
  {
    this.showOnlineOnly = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/rate/AppRateConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */