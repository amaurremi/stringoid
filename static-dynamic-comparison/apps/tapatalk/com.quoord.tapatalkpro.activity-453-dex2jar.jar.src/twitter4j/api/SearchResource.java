package twitter4j.api;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.TwitterException;

public abstract interface SearchResource {
    public abstract QueryResult search(Query paramQuery)
            throws TwitterException;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/api/SearchResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */