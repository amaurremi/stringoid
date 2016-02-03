package com.google.ads.mediation.admob;

import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.MediationServerParameters.Parameter;

public final class AdMobServerParameters
  extends MediationServerParameters
{
  public String adJson;
  @MediationServerParameters.Parameter(name="pubid")
  public String adUnitId;
  @MediationServerParameters.Parameter(name="mad_hac", required=false)
  public String allowHouseAds = null;
  public int tagForChildDirectedTreatment = -1;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/ads/mediation/admob/AdMobServerParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */