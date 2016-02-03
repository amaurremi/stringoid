package twitter4j.internal.http;

import java.util.Map;

public abstract interface HttpClientWrapperConfiguration
        extends HttpClientConfiguration {
    public abstract Map<String, String> getRequestHeaders();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/http/HttpClientWrapperConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */