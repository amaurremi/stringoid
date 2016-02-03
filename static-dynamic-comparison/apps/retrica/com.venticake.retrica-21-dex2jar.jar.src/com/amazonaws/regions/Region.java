package com.amazonaws.regions;

import java.util.HashMap;
import java.util.Map;

public final class Region
{
  private final String domain;
  private final Map<String, Boolean> httpSupport = new HashMap();
  private final Map<String, Boolean> httpsSupport = new HashMap();
  private final String name;
  private final Map<String, String> serviceEndpoints = new HashMap();
  
  Region(String paramString1, String paramString2)
  {
    this.name = paramString1;
    if (paramString2 == null)
    {
      this.domain = "amazonaws.com";
      return;
    }
    this.domain = paramString2;
  }
  
  public static Region getRegion(Regions paramRegions)
  {
    return RegionUtils.getRegion(paramRegions.getName());
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Region)) {
      return false;
    }
    paramObject = (Region)paramObject;
    return getName().equals(((Region)paramObject).getName());
  }
  
  public String getDomain()
  {
    return this.domain;
  }
  
  Map<String, Boolean> getHttpSupport()
  {
    return this.httpSupport;
  }
  
  Map<String, Boolean> getHttpsSupport()
  {
    return this.httpsSupport;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getServiceEndpoint(String paramString)
  {
    return (String)this.serviceEndpoints.get(paramString);
  }
  
  Map<String, String> getServiceEndpoints()
  {
    return this.serviceEndpoints;
  }
  
  public int hashCode()
  {
    return getName().hashCode();
  }
  
  public boolean isServiceSupported(String paramString)
  {
    return this.serviceEndpoints.containsKey(paramString);
  }
  
  public String toString()
  {
    return getName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/regions/Region.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */