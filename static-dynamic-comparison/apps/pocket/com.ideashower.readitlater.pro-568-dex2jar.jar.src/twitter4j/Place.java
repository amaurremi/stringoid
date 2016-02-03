package twitter4j;

import java.io.Serializable;

public abstract interface Place
  extends Serializable, Comparable, TwitterResponse
{
  public abstract GeoLocation[][] getBoundingBoxCoordinates();
  
  public abstract String getBoundingBoxType();
  
  public abstract Place[] getContainedWithIn();
  
  public abstract String getCountry();
  
  public abstract String getCountryCode();
  
  public abstract String getFullName();
  
  public abstract GeoLocation[][] getGeometryCoordinates();
  
  public abstract String getGeometryType();
  
  public abstract String getId();
  
  public abstract String getName();
  
  public abstract String getPlaceType();
  
  public abstract String getStreetAddress();
  
  public abstract String getURL();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/Place.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */