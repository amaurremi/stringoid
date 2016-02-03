package com.flurry.android;

public class AdCreative
{
  public static final String kAlignmentBottom = "bottom";
  public static final String kAlignmentCenter = "center";
  public static final String kAlignmentLeft = "left";
  public static final String kAlignmentMiddle = "middle";
  public static final String kAlignmentRight = "right";
  public static final String kAlignmentTop = "top";
  public static final String kFixBoth = "both";
  public static final String kFixHeight = "height";
  public static final String kFixNone = "none";
  public static final String kFixWidth = "width";
  public static final String kFormatBanner = "banner";
  public static final String kFormatCustom = "custom";
  public static final String kFormatTakeover = "takeover";
  private int i;
  private int j;
  private String k;
  private String l;
  private String m;
  
  AdCreative(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.i = paramInt1;
    this.j = paramInt2;
    this.k = paramString1;
    this.l = paramString2;
    this.m = paramString3;
  }
  
  public String getAlignment()
  {
    return this.m;
  }
  
  public String getFix()
  {
    return this.l;
  }
  
  public String getFormat()
  {
    return this.k;
  }
  
  public int getHeight()
  {
    return this.i;
  }
  
  public int getWidth()
  {
    return this.j;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/AdCreative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */