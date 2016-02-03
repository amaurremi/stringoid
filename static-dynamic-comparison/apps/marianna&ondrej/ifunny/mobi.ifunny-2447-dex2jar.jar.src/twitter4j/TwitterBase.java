package twitter4j;

import twitter4j.auth.Authorization;
import twitter4j.conf.Configuration;

public abstract interface TwitterBase {
    public abstract void addRateLimitStatusListener(RateLimitStatusListener paramRateLimitStatusListener);

    public abstract Authorization getAuthorization();

    public abstract Configuration getConfiguration();

    public abstract long getId();

    public abstract String getScreenName();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/TwitterBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */