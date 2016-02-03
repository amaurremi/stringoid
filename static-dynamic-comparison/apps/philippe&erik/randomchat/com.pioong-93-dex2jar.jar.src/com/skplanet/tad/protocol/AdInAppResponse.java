package com.skplanet.tad.protocol;

public class AdInAppResponse
{
  public AdInAppResponseRich c_data;
  public String c_exposure_time;
  public String c_type;
  public String c_url;
  public String ret_code;
  public String x_bypass;
  
  public String toString()
  {
    return "return_code:" + this.ret_code + "ads_exposure_time:" + this.c_exposure_time + "creative_url:" + this.c_url;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/protocol/AdInAppResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */