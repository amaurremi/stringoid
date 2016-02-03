package twitter4j.api;

import twitter4j.GeoLocation;
import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Trends;
import twitter4j.TwitterException;

public abstract interface TrendsResources {
    public abstract ResponseList<Location> getAvailableTrends()
            throws TwitterException;

    public abstract ResponseList<Location> getAvailableTrends(GeoLocation paramGeoLocation)
            throws TwitterException;

    public abstract ResponseList<Location> getClosestTrends(GeoLocation paramGeoLocation)
            throws TwitterException;

    public abstract Trends getLocationTrends(int paramInt)
            throws TwitterException;

    public abstract Trends getPlaceTrends(int paramInt)
            throws TwitterException;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/api/TrendsResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */