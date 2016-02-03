package twitter4j;

import twitter4j.auth.Authorization;
import twitter4j.conf.Configuration;

public abstract interface TwitterBase {
    public abstract void addRateLimitStatusListener(RateLimitStatusListener paramRateLimitStatusListener);

    public abstract Authorization getAuthorization();

    public abstract Configuration getConfiguration();

    public abstract long getId()
            throws TwitterException, IllegalStateException;

    public abstract String getScreenName()
            throws TwitterException, IllegalStateException;

    public abstract void shutdown();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/TwitterBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */