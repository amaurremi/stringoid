package twitter4j;

import java.io.Serializable;

public abstract interface Location
        extends Serializable {
    public abstract String getCountryCode();

    public abstract String getCountryName();

    public abstract String getName();

    public abstract int getPlaceCode();

    public abstract String getPlaceName();

    public abstract String getURL();

    public abstract int getWoeid();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/Location.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */