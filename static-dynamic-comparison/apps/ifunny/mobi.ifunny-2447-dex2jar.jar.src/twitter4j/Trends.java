package twitter4j;

import java.io.Serializable;
import java.util.Date;

public abstract interface Trends
        extends Serializable, Comparable<Trends>, TwitterResponse {
    public abstract Date getAsOf();

    public abstract Location getLocation();

    public abstract Date getTrendAt();

    public abstract Trend[] getTrends();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/Trends.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */