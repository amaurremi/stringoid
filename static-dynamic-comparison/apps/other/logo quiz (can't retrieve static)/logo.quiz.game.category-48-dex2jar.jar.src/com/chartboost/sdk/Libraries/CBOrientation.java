package com.chartboost.sdk.Libraries;

public enum CBOrientation
{
  public static final CBOrientation LANDSCAPE_LEFT = LANDSCAPE;
  public static final CBOrientation LANDSCAPE_RIGHT = LANDSCAPE_REVERSE;
  public static final CBOrientation PORTRAIT_LEFT;
  public static final CBOrientation PORTRAIT_RIGHT;
  
  static
  {
    PORTRAIT = new CBOrientation("PORTRAIT", 1);
    LANDSCAPE = new CBOrientation("LANDSCAPE", 2);
    PORTRAIT_REVERSE = new CBOrientation("PORTRAIT_REVERSE", 3);
    LANDSCAPE_REVERSE = new CBOrientation("LANDSCAPE_REVERSE", 4);
    a = new CBOrientation[] { UNSPECIFIED, PORTRAIT, LANDSCAPE, PORTRAIT_REVERSE, LANDSCAPE_REVERSE };
    PORTRAIT_LEFT = PORTRAIT_REVERSE;
    PORTRAIT_RIGHT = PORTRAIT;
  }
  
  private CBOrientation() {}
  
  public boolean isLandscape()
  {
    return (this == LANDSCAPE) || (this == LANDSCAPE_REVERSE);
  }
  
  public boolean isPortrait()
  {
    return (this == PORTRAIT) || (this == PORTRAIT_REVERSE);
  }
  
  public CBOrientation rotate180()
  {
    return rotate90().rotate90();
  }
  
  public CBOrientation rotate270()
  {
    return rotate90().rotate90().rotate90();
  }
  
  public CBOrientation rotate90()
  {
    switch (1.a[ordinal()])
    {
    default: 
      return UNSPECIFIED;
    case 1: 
      return PORTRAIT_LEFT;
    case 2: 
      return LANDSCAPE_RIGHT;
    case 3: 
      return PORTRAIT_RIGHT;
    }
    return LANDSCAPE_LEFT;
  }
  
  public static enum Difference
  {
    private Difference() {}
    
    public int getAsInt()
    {
      switch (CBOrientation.1.b[ordinal()])
      {
      default: 
        return 0;
      case 1: 
        return 90;
      case 2: 
        return 180;
      }
      return 270;
    }
    
    public boolean isOdd()
    {
      return (this == ANGLE_90) || (this == ANGLE_270);
    }
    
    public boolean isReverse()
    {
      return (this == ANGLE_180) || (this == ANGLE_270);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/Libraries/CBOrientation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */