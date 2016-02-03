package twitter4j.internal.http;

import twitter4j.TwitterException;

public abstract interface HttpClient {
    public abstract HttpResponse request(HttpRequest paramHttpRequest)
            throws TwitterException;

    public abstract void shutdown();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/http/HttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */