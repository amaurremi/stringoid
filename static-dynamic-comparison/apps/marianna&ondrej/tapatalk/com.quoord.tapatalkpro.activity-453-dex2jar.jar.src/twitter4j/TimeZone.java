package twitter4j;

import java.io.Serializable;

public abstract interface TimeZone
        extends Serializable {
    public abstract String getName();

    public abstract String tzinfoName();

    public abstract int utcOffset();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/TimeZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */