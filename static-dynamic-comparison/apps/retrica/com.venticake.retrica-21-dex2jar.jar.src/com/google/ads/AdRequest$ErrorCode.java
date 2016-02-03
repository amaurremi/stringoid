package com.google.ads;

public enum AdRequest$ErrorCode
{
  private final String description;
  
  static
  {
    NETWORK_ERROR = new ErrorCode("NETWORK_ERROR", 2, "A network error occurred.");
  }
  
  private AdRequest$ErrorCode(String paramString)
  {
    this.description = paramString;
  }
  
  public String toString()
  {
    return this.description;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/ads/AdRequest$ErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */