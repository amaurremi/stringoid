package com.google.ads.mediation.jsadapter;

import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.MediationServerParameters.Parameter;

public class JavascriptServerParameters
  extends MediationServerParameters
{
  @MediationServerParameters.Parameter(name="adxtym_height", required=false)
  public Integer height;
  @MediationServerParameters.Parameter(name="adxtym_html", required=true)
  public String htmlScript;
  @MediationServerParameters.Parameter(name="adxtym_passback_url", required=false)
  public String passBackUrl;
  @MediationServerParameters.Parameter(name="adxtym_width", required=false)
  public Integer width;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/ads/mediation/jsadapter/JavascriptServerParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */