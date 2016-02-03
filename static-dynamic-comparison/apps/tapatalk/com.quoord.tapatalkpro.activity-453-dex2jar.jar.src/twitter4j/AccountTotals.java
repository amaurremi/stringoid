package twitter4j;

import java.io.Serializable;

public abstract interface AccountTotals
        extends TwitterResponse, Serializable {
    public abstract int getFavorites();

    public abstract int getFollowers();

    public abstract int getFriends();

    public abstract int getUpdates();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/AccountTotals.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */