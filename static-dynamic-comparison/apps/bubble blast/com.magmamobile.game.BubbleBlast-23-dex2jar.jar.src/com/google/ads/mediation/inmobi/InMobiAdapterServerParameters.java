package com.google.ads.mediation.inmobi;

import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.MediationServerParameters.Parameter;

public class InMobiAdapterServerParameters
  extends MediationServerParameters
{
  @MediationServerParameters.Parameter(name="pubid")
  public String appId;
  @MediationServerParameters.Parameter(name="isUDIDHashAllowed", required=false)
  public String isUDIDHashAllowed = "true";
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/mediation/inmobi/InMobiAdapterServerParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */