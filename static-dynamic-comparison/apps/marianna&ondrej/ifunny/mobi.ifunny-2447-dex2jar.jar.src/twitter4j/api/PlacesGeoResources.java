package twitter4j.api;

import twitter4j.GeoLocation;
import twitter4j.GeoQuery;
import twitter4j.Place;
import twitter4j.ResponseList;

public abstract interface PlacesGeoResources {
    public abstract Place getGeoDetails(String paramString);

    public abstract ResponseList<Place> getSimilarPlaces(GeoLocation paramGeoLocation, String paramString1, String paramString2, String paramString3);

    public abstract ResponseList<Place> reverseGeoCode(GeoQuery paramGeoQuery);

    public abstract ResponseList<Place> searchPlaces(GeoQuery paramGeoQuery);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/api/PlacesGeoResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */