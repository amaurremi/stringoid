package twitter4j.api;

import java.util.Map;

import twitter4j.RateLimitStatus;
import twitter4j.ResponseList;
import twitter4j.TwitterAPIConfiguration;
import twitter4j.TwitterException;

public abstract interface HelpResources {
    public abstract TwitterAPIConfiguration getAPIConfiguration()
            throws TwitterException;

    public abstract ResponseList<Language> getLanguages()
            throws TwitterException;

    public abstract String getPrivacyPolicy()
            throws TwitterException;

    public abstract Map<String, RateLimitStatus> getRateLimitStatus()
            throws TwitterException;

    public abstract Map<String, RateLimitStatus> getRateLimitStatus(String... paramVarArgs)
            throws TwitterException;

    public abstract String getTermsOfService()
            throws TwitterException;

    public static abstract interface Language {
        public abstract String getCode();

        public abstract String getName();

        public abstract String getStatus();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/api/HelpResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */