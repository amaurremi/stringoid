package com.google.ads.mediation.admob;

import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.MediationServerParameters.Parameter;

public final class AdMobAdapterServerParameters
  extends MediationServerParameters
{
  @MediationServerParameters.Parameter(name="pubid")
  public String adUnitId;
  @MediationServerParameters.Parameter(name="mad_hac", required=false)
  public String allowHouseAds = null;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/google/ads/mediation/admob/AdMobAdapterServerParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */