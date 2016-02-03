package com.google.ads.mediation.jumptap;

import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.MediationServerParameters.Parameter;

public class JumpTapAdapterServerParameters
  extends MediationServerParameters
{
  @MediationServerParameters.Parameter(name="pubid")
  public String publisherId;
  @MediationServerParameters.Parameter(name="siteId", required=false)
  public String siteId;
  @MediationServerParameters.Parameter(name="adSpotId", required=false)
  public String spotId;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/ads/mediation/jumptap/JumpTapAdapterServerParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */