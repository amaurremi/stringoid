package twitter4j.internal.http;

public abstract interface HttpClientConfiguration {
    public abstract int getHttpConnectionTimeout();

    public abstract int getHttpDefaultMaxPerRoute();

    public abstract int getHttpMaxTotalConnections();

    public abstract String getHttpProxyHost();

    public abstract String getHttpProxyPassword();

    public abstract int getHttpProxyPort();

    public abstract String getHttpProxyUser();

    public abstract int getHttpReadTimeout();

    public abstract int getHttpRetryCount();

    public abstract int getHttpRetryIntervalSeconds();

    public abstract boolean isGZIPEnabled();

    public abstract boolean isPrettyDebugEnabled();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/http/HttpClientConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */