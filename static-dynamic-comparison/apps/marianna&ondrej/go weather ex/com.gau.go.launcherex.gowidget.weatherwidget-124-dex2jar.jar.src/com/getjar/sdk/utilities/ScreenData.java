package com.getjar.sdk.utilities;

public class ScreenData
{
  private final Integer availableResX;
  private final Integer availableResY;
  private final int resolutionX;
  private final int resolutionY;
  private final double screenSizeX;
  private final double screenSizeY;
  private final double xDpi;
  private final double yDpi;
  
  protected ScreenData(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, double paramDouble3, double paramDouble4)
  {
    this(paramDouble1, paramDouble2, paramInt1, paramInt2, paramDouble3, paramDouble4, null, null);
  }
  
  protected ScreenData(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, double paramDouble3, double paramDouble4, Integer paramInteger1, Integer paramInteger2)
  {
    if (paramDouble1 <= 0.0D) {
      throw new IllegalArgumentException("Invalid value provided for 'xDpi'");
    }
    if (paramDouble2 <= 0.0D) {
      throw new IllegalArgumentException("Invalid value provided for 'yDpi'");
    }
    if (paramInt1 <= 0) {
      throw new IllegalArgumentException("Invalid value provided for 'resolutionX'");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("Invalid value provided for 'resolutionY'");
    }
    if (paramDouble3 <= 0.0D) {
      throw new IllegalArgumentException("Invalid value provided for 'screenSizeX'");
    }
    if (paramDouble4 <= 0.0D) {
      throw new IllegalArgumentException("Invalid value provided for 'screenSizeY'");
    }
    if ((paramInteger1 != null) && (paramInteger1.intValue() <= 0)) {
      throw new IllegalArgumentException("Invalid value provided for 'availableResX'");
    }
    if ((paramInteger2 != null) && (paramInteger2.intValue() <= 0)) {
      throw new IllegalArgumentException("Invalid value provided for 'availableResY'");
    }
    this.xDpi = paramDouble1;
    this.yDpi = paramDouble2;
    this.resolutionX = paramInt1;
    this.resolutionY = paramInt2;
    this.screenSizeX = paramDouble3;
    this.screenSizeY = paramDouble4;
    this.availableResX = paramInteger1;
    this.availableResY = paramInteger2;
  }
  
  protected Integer getAvailableResX()
  {
    return this.availableResX;
  }
  
  protected Integer getAvailableResY()
  {
    return this.availableResY;
  }
  
  protected int getResolutionX()
  {
    return this.resolutionX;
  }
  
  protected int getResolutionY()
  {
    return this.resolutionY;
  }
  
  protected double getScreenHeight()
  {
    return this.screenSizeY;
  }
  
  protected double getScreenWidth()
  {
    return this.screenSizeX;
  }
  
  protected double getXDpi()
  {
    return this.xDpi;
  }
  
  protected double getYDpi()
  {
    return this.yDpi;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/ScreenData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */