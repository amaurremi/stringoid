package twitter4j.api;

import twitter4j.GeoLocation;
import twitter4j.ResponseList;
import twitter4j.Trends;

public abstract interface TrendsResources
{
  public abstract ResponseList getAvailableTrends();
  
  public abstract ResponseList getAvailableTrends(GeoLocation paramGeoLocation);
  
  public abstract ResponseList getClosestTrends(GeoLocation paramGeoLocation);
  
  public abstract Trends getLocationTrends(int paramInt);
  
  public abstract Trends getPlaceTrends(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/api/TrendsResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */