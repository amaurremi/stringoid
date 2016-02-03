package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class ec
{
  private final List<String> qP;
  private final List<String> qQ;
  private final String qR;
  private final String qS;
  private final String qT;
  private final String qU;
  private final String qV;
  private final boolean qW;
  private final int qX;
  
  public ec(Map<String, String> paramMap)
  {
    this.qV = ((String)paramMap.get("url"));
    this.qS = ((String)paramMap.get("base_uri"));
    this.qT = ((String)paramMap.get("post_parameters"));
    this.qW = parseBoolean((String)paramMap.get("drt_include"));
    this.qR = ((String)paramMap.get("activation_overlay_url"));
    this.qQ = t((String)paramMap.get("check_packages"));
    this.qX = parseInt((String)paramMap.get("request_id"));
    this.qU = ((String)paramMap.get("type"));
    this.qP = t((String)paramMap.get("errors"));
  }
  
  private static boolean parseBoolean(String paramString)
  {
    return (paramString != null) && ((paramString.equals("1")) || (paramString.equals("true")));
  }
  
  private int parseInt(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    return Integer.parseInt(paramString);
  }
  
  private List<String> t(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Arrays.asList(paramString.split(","));
  }
  
  public List<String> bt()
  {
    return this.qP;
  }
  
  public String bu()
  {
    return this.qT;
  }
  
  public boolean bv()
  {
    return this.qW;
  }
  
  public String getType()
  {
    return this.qU;
  }
  
  public String getUrl()
  {
    return this.qV;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */