package twitter4j.api;

import twitter4j.GeoLocation;
import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Trends;

public abstract interface TrendsResources {
    public abstract ResponseList<Location> getAvailableTrends();

    public abstract ResponseList<Location> getClosestTrends(GeoLocation paramGeoLocation);

    public abstract Trends getPlaceTrends(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/api/TrendsResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */