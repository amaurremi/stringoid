package twitter4j.auth;

import twitter4j.TwitterException;

public abstract interface OAuth2Support {
    public abstract OAuth2Token getOAuth2Token()
            throws TwitterException;

    public abstract void invalidateOAuth2Token()
            throws TwitterException;

    public abstract void setOAuth2Token(OAuth2Token paramOAuth2Token);

    public abstract void setOAuthConsumer(String paramString1, String paramString2);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/auth/OAuth2Support.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */