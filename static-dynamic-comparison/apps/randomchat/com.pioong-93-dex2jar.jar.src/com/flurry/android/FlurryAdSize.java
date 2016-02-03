package com.flurry.android;

public enum FlurryAdSize
{
  private int et;
  
  private FlurryAdSize(int paramInt)
  {
    this.et = paramInt;
  }
  
  static FlurryAdSize a(AdSpaceLayout paramAdSpaceLayout)
  {
    String str = paramAdSpaceLayout.getFormat().toString();
    paramAdSpaceLayout = paramAdSpaceLayout.getAlignment().toString().split("-");
    if (str.equals("takeover")) {
      return FULLSCREEN;
    }
    if (paramAdSpaceLayout[0].equals("b")) {
      return BANNER_BOTTOM;
    }
    return BANNER_TOP;
  }
  
  final int getValue()
  {
    return this.et;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/FlurryAdSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */