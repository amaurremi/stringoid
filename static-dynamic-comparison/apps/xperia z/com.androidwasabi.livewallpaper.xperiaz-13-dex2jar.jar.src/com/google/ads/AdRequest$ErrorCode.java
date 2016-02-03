package com.google.ads;

public enum AdRequest$ErrorCode
{
  private final String a;
  
  static
  {
    NETWORK_ERROR = new ErrorCode("NETWORK_ERROR", 2, "A network error occurred.");
  }
  
  private AdRequest$ErrorCode(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/AdRequest$ErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */