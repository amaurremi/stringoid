package com.mopub.nativeads;

import android.location.Location;

public final class RequestParameters
{
  private final String mKeywords;
  private final Location mLocation;
  
  private RequestParameters(Builder paramBuilder)
  {
    this.mKeywords = paramBuilder.keywords;
    this.mLocation = paramBuilder.location;
  }
  
  public final String getKeywords()
  {
    return this.mKeywords;
  }
  
  public final Location getLocation()
  {
    return this.mLocation;
  }
  
  public static final class Builder
  {
    private String keywords;
    private Location location;
    
    public final RequestParameters build()
    {
      return new RequestParameters(this, null);
    }
    
    public final Builder keywords(String paramString)
    {
      this.keywords = paramString;
      return this;
    }
    
    public final Builder location(Location paramLocation)
    {
      this.location = paramLocation;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/RequestParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */