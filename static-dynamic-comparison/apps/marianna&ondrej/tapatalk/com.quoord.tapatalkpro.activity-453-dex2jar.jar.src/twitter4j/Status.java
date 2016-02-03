package twitter4j;

import java.io.Serializable;
import java.util.Date;

public abstract interface Status
        extends Comparable<Status>, TwitterResponse, EntitySupport, Serializable {
    public abstract long[] getContributors();

    public abstract Date getCreatedAt();

    public abstract long getCurrentUserRetweetId();

    public abstract int getFavoriteCount();

    public abstract GeoLocation getGeoLocation();

    public abstract long getId();

    public abstract String getInReplyToScreenName();

    public abstract long getInReplyToStatusId();

    public abstract long getInReplyToUserId();

    public abstract String getIsoLanguageCode();

    public abstract Place getPlace();

    public abstract int getRetweetCount();

    public abstract Status getRetweetedStatus();

    public abstract String getSource();

    public abstract String getText();

    public abstract User getUser();

    public abstract boolean isFavorited();

    public abstract boolean isPossiblySensitive();

    public abstract boolean isRetweet();

    public abstract boolean isRetweeted();

    public abstract boolean isRetweetedByMe();

    public abstract boolean isTruncated();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */