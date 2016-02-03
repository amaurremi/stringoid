package twitter4j;

import java.io.Serializable;

public abstract interface Friendship
        extends Serializable {
    public abstract long getId();

    public abstract String getName();

    public abstract String getScreenName();

    public abstract boolean isFollowedBy();

    public abstract boolean isFollowing();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/Friendship.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */