package twitter4j;

import java.util.List;

public abstract interface ResponseList<T>
        extends TwitterResponse, List<T> {
    public abstract RateLimitStatus getRateLimitStatus();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/ResponseList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */