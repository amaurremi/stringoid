package com.google.ads;

@Deprecated
public final class AdRequest
{
  public static final String LOGTAG = "Ads";
  public static final String TEST_EMULATOR = com.google.android.gms.ads.AdRequest.DEVICE_ID_EMULATOR;
  public static final String VERSION = "0.0.0";
  
  public static enum ErrorCode
  {
    private final String description;
    
    static
    {
      NETWORK_ERROR = new ErrorCode("NETWORK_ERROR", 2, "A network error occurred.");
    }
    
    private ErrorCode(String paramString)
    {
      this.description = paramString;
    }
    
    public String toString()
    {
      return this.description;
    }
  }
  
  public static enum Gender
  {
    static
    {
      MALE = new Gender("MALE", 1);
    }
    
    private Gender() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/ads/AdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */