package twitter4j.api;

import java.util.Map;

import twitter4j.RateLimitStatus;
import twitter4j.ResponseList;
import twitter4j.TwitterAPIConfiguration;

public abstract interface HelpResources {
    public abstract TwitterAPIConfiguration getAPIConfiguration();

    public abstract ResponseList<HelpResources.Language> getLanguages();

    public abstract String getPrivacyPolicy();

    public abstract Map<String, RateLimitStatus> getRateLimitStatus();

    public abstract Map<String, RateLimitStatus> getRateLimitStatus(String... paramVarArgs);

    public abstract String getTermsOfService();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/api/HelpResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */