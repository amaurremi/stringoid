package twitter4j;

import java.io.Serializable;
import java.util.List;

public abstract interface QueryResult
        extends Serializable, TwitterResponse {
    public abstract double getCompletedIn();

    public abstract int getCount();

    public abstract long getMaxId();

    public abstract String getQuery();

    public abstract String getRefreshURL();

    public abstract long getSinceId();

    public abstract List<Status> getTweets();

    public abstract boolean hasNext();

    public abstract Query nextQuery();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/QueryResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */