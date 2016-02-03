package com.mopub.mobileads;

class MraidScreenSizeProperty
  extends MraidProperty
{
  private final int mScreenHeight;
  private final int mScreenWidth;
  
  MraidScreenSizeProperty(int paramInt1, int paramInt2)
  {
    this.mScreenWidth = paramInt1;
    this.mScreenHeight = paramInt2;
  }
  
  public static MraidScreenSizeProperty createWithSize(int paramInt1, int paramInt2)
  {
    return new MraidScreenSizeProperty(paramInt1, paramInt2);
  }
  
  public String toJsonPair()
  {
    return "screenSize: { width: " + this.mScreenWidth + ", height: " + this.mScreenHeight + " }";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/MraidScreenSizeProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */