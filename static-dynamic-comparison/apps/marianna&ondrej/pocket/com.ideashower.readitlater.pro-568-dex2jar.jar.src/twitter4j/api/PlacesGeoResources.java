package twitter4j.api;

import twitter4j.GeoLocation;
import twitter4j.GeoQuery;
import twitter4j.Place;
import twitter4j.ResponseList;
import twitter4j.SimilarPlaces;

public abstract interface PlacesGeoResources
{
  public abstract Place createPlace(String paramString1, String paramString2, String paramString3, GeoLocation paramGeoLocation, String paramString4);
  
  public abstract Place getGeoDetails(String paramString);
  
  public abstract SimilarPlaces getSimilarPlaces(GeoLocation paramGeoLocation, String paramString1, String paramString2, String paramString3);
  
  public abstract ResponseList reverseGeoCode(GeoQuery paramGeoQuery);
  
  public abstract ResponseList searchPlaces(GeoQuery paramGeoQuery);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/api/PlacesGeoResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */