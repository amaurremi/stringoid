package twitter4j;

import java.io.Serializable;

public abstract interface Relationship
        extends TwitterResponse, Serializable {
    public abstract boolean canSourceDm();

    public abstract long getSourceUserId();

    public abstract String getSourceUserScreenName();

    public abstract long getTargetUserId();

    public abstract String getTargetUserScreenName();

    public abstract boolean isSourceBlockingTarget();

    public abstract boolean isSourceFollowedByTarget();

    public abstract boolean isSourceFollowingTarget();

    public abstract boolean isSourceNotificationsEnabled();

    public abstract boolean isSourceWantRetweets();

    public abstract boolean isTargetFollowedBySource();

    public abstract boolean isTargetFollowingSource();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/Relationship.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */