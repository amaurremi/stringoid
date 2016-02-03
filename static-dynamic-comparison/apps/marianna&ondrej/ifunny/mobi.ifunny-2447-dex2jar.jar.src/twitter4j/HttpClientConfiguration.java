package twitter4j;

public abstract interface HttpClientConfiguration {
    public abstract int getHttpConnectionTimeout();

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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/HttpClientConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */