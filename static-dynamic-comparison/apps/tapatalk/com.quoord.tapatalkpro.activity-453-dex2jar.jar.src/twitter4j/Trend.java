package twitter4j;

import java.io.Serializable;

public abstract interface Trend
        extends Serializable {
    public abstract String getName();

    public abstract String getQuery();

    public abstract String getURL();

    public abstract String getUrl();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/Trend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */