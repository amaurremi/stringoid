package twitter4j.auth;

import twitter4j.TwitterException;

public abstract interface OAuthSupport {
    public abstract AccessToken getOAuthAccessToken()
            throws TwitterException;

    public abstract AccessToken getOAuthAccessToken(String paramString)
            throws TwitterException;

    public abstract AccessToken getOAuthAccessToken(String paramString1, String paramString2)
            throws TwitterException;

    public abstract AccessToken getOAuthAccessToken(RequestToken paramRequestToken)
            throws TwitterException;

    public abstract AccessToken getOAuthAccessToken(RequestToken paramRequestToken, String paramString)
            throws TwitterException;

    public abstract RequestToken getOAuthRequestToken()
            throws TwitterException;

    public abstract RequestToken getOAuthRequestToken(String paramString)
            throws TwitterException;

    public abstract RequestToken getOAuthRequestToken(String paramString1, String paramString2)
            throws TwitterException;

    public abstract void setOAuthAccessToken(AccessToken paramAccessToken);

    public abstract void setOAuthConsumer(String paramString1, String paramString2);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/auth/OAuthSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */