package com.inmobi.androidsdk.impl;

import java.io.Serializable;

public class IMAdUnit
  implements Serializable
{
  private static final long serialVersionUID = 7987544297386338802L;
  private AdActionNames a = AdActionNames.AdActionName_Web;
  private AdTypes b = AdTypes.NONE;
  private String c;
  private String d;
  private boolean e;
  private String f;
  private String g;
  private int h;
  private int i;
  
  public static AdActionNames adActionNamefromString(String paramString)
  {
    AdActionNames localAdActionNames = AdActionNames.AdActionName_None;
    if (paramString != null)
    {
      if (paramString.equalsIgnoreCase("call")) {
        localAdActionNames = AdActionNames.AdActionName_Call;
      }
    }
    else {
      return localAdActionNames;
    }
    if (paramString.equalsIgnoreCase("sms")) {
      return AdActionNames.AdActionName_SMS;
    }
    if (paramString.equalsIgnoreCase("search")) {
      return AdActionNames.AdActionName_Search;
    }
    if (paramString.equalsIgnoreCase("android")) {
      return AdActionNames.AdActionName_Android;
    }
    if (paramString.equalsIgnoreCase("web")) {
      return AdActionNames.AdActionName_Web;
    }
    if (paramString.equalsIgnoreCase("map")) {
      return AdActionNames.AdActionName_Map;
    }
    if (paramString.equalsIgnoreCase("audio")) {
      return AdActionNames.AdActionName_Audio;
    }
    if (paramString.equalsIgnoreCase("video")) {
      return AdActionNames.AdActionName_Video;
    }
    return AdActionNames.AdActionName_None;
  }
  
  public static AdTypes adTypefromString(String paramString)
  {
    AdTypes localAdTypes2 = AdTypes.NONE;
    AdTypes localAdTypes1 = localAdTypes2;
    if (paramString != null)
    {
      if (!paramString.equalsIgnoreCase("banner")) {
        break label25;
      }
      localAdTypes1 = AdTypes.BANNER;
    }
    label25:
    do
    {
      return localAdTypes1;
      if (paramString.equalsIgnoreCase("text")) {
        return AdTypes.TEXT;
      }
      if (paramString.equalsIgnoreCase("search")) {
        return AdTypes.SEARCH;
      }
      localAdTypes1 = localAdTypes2;
    } while (!paramString.equalsIgnoreCase("rm"));
    return AdTypes.RICH_MEDIA;
  }
  
  public AdActionNames getAdActionName()
  {
    return this.a;
  }
  
  public AdTypes getAdType()
  {
    return this.b;
  }
  
  public String getCDATABlock()
  {
    return this.g;
  }
  
  public String getDefaultTargetUrl()
  {
    return this.d;
  }
  
  public String getDeviceInfoUploadUrl()
  {
    return this.f;
  }
  
  public int getHeight()
  {
    return this.i;
  }
  
  public String getTargetUrl()
  {
    return this.c;
  }
  
  public int getWidth()
  {
    return this.h;
  }
  
  public boolean isSendDeviceInfo()
  {
    return this.e;
  }
  
  public void setAdActionName(AdActionNames paramAdActionNames)
  {
    this.a = paramAdActionNames;
  }
  
  public void setAdType(AdTypes paramAdTypes)
  {
    this.b = paramAdTypes;
  }
  
  public void setCDATABlock(String paramString)
  {
    this.g = paramString;
  }
  
  public void setDefaultTargetUrl(String paramString)
  {
    this.d = paramString;
  }
  
  public void setDeviceInfoUploadUrl(String paramString)
  {
    this.f = paramString;
  }
  
  public void setHeight(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setSendDeviceInfo(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setTargetUrl(String paramString)
  {
    this.c = paramString;
  }
  
  public void setWidth(int paramInt)
  {
    this.h = paramInt;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("AdUnit: ");
    localStringBuffer.append(" adActionName: " + this.a);
    localStringBuffer.append(" adType: " + this.b);
    localStringBuffer.append(" targetUrl: " + this.c);
    localStringBuffer.append(" width: " + this.h);
    localStringBuffer.append(" height: " + this.i);
    return localStringBuffer.toString();
  }
  
  public static enum AdActionNames
  {
    static
    {
      AdActionName_SMS = new AdActionNames("AdActionName_SMS", 2);
      AdActionName_Search = new AdActionNames("AdActionName_Search", 3);
      AdActionName_Call = new AdActionNames("AdActionName_Call", 4);
      AdActionName_Android = new AdActionNames("AdActionName_Android", 5);
      AdActionName_Map = new AdActionNames("AdActionName_Map", 6);
    }
    
    public String toString()
    {
      return super.toString().replaceFirst("AdActionName_", "").toLowerCase();
    }
  }
  
  public static enum AdTypes
  {
    static
    {
      BANNER = new AdTypes("BANNER", 2);
      SEARCH = new AdTypes("SEARCH", 3);
    }
    
    public String toString()
    {
      return super.toString().replaceFirst("AdType_", "").toLowerCase();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/impl/IMAdUnit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */